package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML private TableView<Lifter> tableView;
    @FXML private TableColumn<Lifter, String> firstNameColumn;
    @FXML private TableColumn<Lifter, String> lastNameColumn;
    @FXML private TableColumn<Lifter, String> sexColumn;
    @FXML private TableColumn<Lifter, Integer> weightColumn;

    @FXML private TextField firstNameTextField;
    @FXML private TextField lastNameTextField;
    @FXML private TextField sexTextField;
    @FXML private TextField weightTextField;






    public void initialize(URL url, ResourceBundle rb){
      firstNameColumn.setCellValueFactory(new PropertyValueFactory<Lifter, String>("participantFirstName"));
      lastNameColumn.setCellValueFactory(new PropertyValueFactory<Lifter, String>("participantLastName"));
      sexColumn.setCellValueFactory(new PropertyValueFactory<Lifter, String>("participantSex"));
      weightColumn.setCellValueFactory(new PropertyValueFactory<Lifter, Integer>("participantWeight"));


      tableView.setItems(getParticipants());

      // allows for fields to be updated
      tableView.setEditable(true);

      firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
      lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
      sexColumn.setCellFactory(TextFieldTableCell.forTableColumn());
      weightColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

      // allows user to select multiple participants
      tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
  }

  // method to add participant to table

  public void addNewParticipant(){
      Lifter newLifter = new Lifter(firstNameTextField.getText(), lastNameTextField.getText(), sexTextField.getText(), Integer.parseInt(weightTextField.getText()));

      tableView.getItems().add(newLifter);
  }

  // removing participants from table

  public void removeParticipant(){
      ObservableList<Lifter> selectedRows, allLifters;
      allLifters = tableView.getItems();

      selectedRows = tableView.getSelectionModel().getSelectedItems();

      for(Lifter participant: selectedRows){
          allLifters.remove(participant);
      }
  }

  // allows table to be edited

  public void editFirstName(TableColumn.CellEditEvent editedFirstName){
      Lifter lifterSelected = tableView.getSelectionModel().getSelectedItem();
      lifterSelected.setParticipantFirstName(editedFirstName.getNewValue().toString());
  }

  public void editLastName(TableColumn.CellEditEvent editedLastName){
    Lifter lifterSelected = tableView.getSelectionModel().getSelectedItem();
    lifterSelected.setParticipantLastName(editedLastName.getNewValue().toString());
  }

  public void editSex(TableColumn.CellEditEvent editedSex){
    Lifter lifterSelected = tableView.getSelectionModel().getSelectedItem();
    lifterSelected.setParticipantSex(editedSex.getNewValue().toString());
  }


  public ObservableList<Lifter> getParticipants(){
    ObservableList<Lifter> participant = FXCollections.observableArrayList();

    participant.add(new Lifter("Alexander", "Vu", "Male", 130));
    participant.add(new Lifter("Christopher", "Ung", "Male", 130));

    return participant;
  }

  public void changeSceneToLifts(ActionEvent event) throws IOException{
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("Lifts.fxml"));
      Parent liftsTableViewParent = loader.load();

      Scene liftsTableViewScene = new Scene(liftsTableViewParent);

      LiftsController controller = loader.getController();
      controller.initData(tableView.getSelectionModel().getSelectedItem());

      Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
      window.setScene(liftsTableViewScene);
      window.show();
  }



}
