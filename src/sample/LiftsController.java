package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.FloatStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LiftsController implements Initializable {

    @FXML private TableView<Lifter> liftTableView;
    @FXML private TableColumn<Lifter, Float> benchColumn;
    @FXML private TableColumn<Lifter, Float> squatColumn;
    @FXML private TableColumn<Lifter, Float> deadLiftColumn;
    @FXML private TableColumn<Lifter, String> passFailColumn;
    @FXML private TableColumn<Lifter, String> passFailColumn2;
    @FXML private TableColumn<Lifter, String> passFailColumn3;

    @FXML private TextField benchTextField;
    @FXML private TextField squatTextField;
    @FXML private TextField deadLiftTextField;

    private Lifter selectedLifter;
    @FXML private Label firstNameLabel;
    @FXML private Label lastNameLabel;


    @FXML private HBox plates;

    private weightManager wm = new weightManager();
    private int typeOfExcercise = 0; //3 types Bench, squat, and dead. 0,1,2 respectively.
    @FXML
    private TextField weightEnter;
    @FXML
    private Text currentWeightText;




    public void initialize(URL url, ResourceBundle rb){
        benchColumn.setCellValueFactory(new PropertyValueFactory<Lifter, Float>("benchWeight"));
        squatColumn.setCellValueFactory(new PropertyValueFactory<Lifter, Float>("squatWeight"));
        deadLiftColumn.setCellValueFactory(new PropertyValueFactory<Lifter, Float>("deadLiftWeight"));

        // allows user to directly type into the table for Pass/Fail columns
        liftTableView.setEditable(true);

        passFailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        passFailColumn2.setCellFactory(TextFieldTableCell.forTableColumn());
        passFailColumn3.setCellFactory(TextFieldTableCell.forTableColumn());

    }

    public void recordNewLift(){
        Lifter newLift = new Lifter(Float.parseFloat(benchTextField.getText()), Float.parseFloat(squatTextField.getText()), Float.parseFloat(deadLiftTextField.getText()));
        liftTableView.getItems().add(newLift);
    }




    public void goBackToParticipantScreen(ActionEvent event) throws IOException {
        Parent mainWindowParent = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene mainWindowScene = new Scene(mainWindowParent);

        Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        window.setScene(mainWindowScene);
        window.show();
    }


    public void initData(Lifter lifter){
        selectedLifter = lifter;
        firstNameLabel.setText(selectedLifter.getParticipantFirstName());
        lastNameLabel.setText(selectedLifter.getParticipantLastName());
    }

    public void set()
    {
        wm.clear();
        wm.setWeight(Float.parseFloat(weightEnter.getText()));
        weightEnter.setText(Float.toString(wm.getCurrentWeight()));//sets input box text to a working number if weight cannot be balanced evenly

        if(typeOfExcercise == 0)
            currentWeightText.setText("Currently benching " + wm.getCurrentWeight() + "Kg or " + String.format("%.2f",wm.getCurrentWeight()*2.20462) + "lbs");
        else if(typeOfExcercise == 1)
            currentWeightText.setText("Currently squatting " + wm.getCurrentWeight() + "Kg or " + String.format("%.2f",wm.getCurrentWeight()*2.20462) + "lbs");
        else if(typeOfExcercise == 2)
            currentWeightText.setText("Currently dead lifting " + wm.getCurrentWeight() + "Kg or " + String.format("%.2f",wm.getCurrentWeight()*2.20462) + "lbs");



        //plate image generation
        Color[] colors = new Color[10];
        colors[0] = Color.RED;//50
        colors[1] = Color.GREEN;//25
        colors[2] = Color.GRAY;//20
        colors[3] = Color.YELLOW;//15
        colors[4] = Color.LIGHTBLUE;//10
        colors[5] = Color.PINK;//5
        colors[6] = Color.DARKGOLDENROD;//2.5
        colors[7] = Color.SEASHELL;//1.25
        colors[8] = Color.WHEAT;//.5
        colors[9] = Color.MOCCASIN;//.25

        plates.getChildren().clear();

        for(int x =0; x <wm.getFifty(); x++)
        {
            Text text = new Text(50 + "kg");
            Rectangle plate = new Rectangle();
            plate.setWidth(30);
            plate.setHeight(200);
            plate.setFill(colors[0]);

            Rectangle invisiblePlate = new Rectangle();
            invisiblePlate.setWidth(10);

            StackPane stack = new StackPane();
            stack.getChildren().addAll(plate,text);
            plates.getChildren().add(stack);
            plates.getChildren().add(invisiblePlate);

        }
        for(int x =0; x <wm.getTwentyFive(); x++)
        {
            Text text = new Text(25 + "kg");
            Rectangle plate = new Rectangle();
            plate.setWidth(30);
            plate.setHeight(175);
            plate.setFill(colors[1]);

            Rectangle invisiblePlate = new Rectangle();
            invisiblePlate.setWidth(10);

            StackPane stack = new StackPane();
            stack.getChildren().addAll(plate,text);
            plates.getChildren().add(stack);
            plates.getChildren().add(invisiblePlate);


        }
        for(int x =0; x <wm.getTwenty(); x++)
        {
            Text text = new Text(20 + "kg");
            Rectangle plate = new Rectangle();
            plate.setWidth(30);
            plate.setHeight(150);
            plate.setFill(colors[2]);

            Rectangle invisiblePlate = new Rectangle();
            invisiblePlate.setWidth(10);

            StackPane stack = new StackPane();
            stack.getChildren().addAll(plate,text);
            plates.getChildren().add(stack);
            plates.getChildren().add(invisiblePlate);


        }
        for(int x =0; x <wm.getFifteen(); x++)
        {
            Text text = new Text(15 + "kg");
            Rectangle plate = new Rectangle();
            plate.setWidth(30);
            plate.setHeight(125);
            plate.setFill(colors[3]);

            Rectangle invisiblePlate = new Rectangle();
            invisiblePlate.setWidth(10);

            StackPane stack = new StackPane();
            stack.getChildren().addAll(plate,text);
            plates.getChildren().add(stack);
            plates.getChildren().add(invisiblePlate);


        }
        for(int x =0; x <wm.getTen(); x++)
        {
            Text text = new Text(10 + "kg");
            Rectangle plate = new Rectangle();
            plate.setWidth(30);
            plate.setHeight(100);
            plate.setFill(colors[4]);

            Rectangle invisiblePlate = new Rectangle();
            invisiblePlate.setWidth(10);

            StackPane stack = new StackPane();
            stack.getChildren().addAll(plate,text);
            plates.getChildren().add(stack);
            plates.getChildren().add(invisiblePlate);


        }
        for(int x =0; x <wm.getFive(); x++)
        {
            Text text = new Text(5 + "kg");
            Rectangle plate = new Rectangle();
            plate.setWidth(30);
            plate.setHeight(75);
            plate.setFill(colors[5]);

            Rectangle invisiblePlate = new Rectangle();
            invisiblePlate.setWidth(10);

            StackPane stack = new StackPane();
            stack.getChildren().addAll(plate,text);
            plates.getChildren().add(stack);
            plates.getChildren().add(invisiblePlate);


        }
        for(int x =0; x <wm.getTwoFive(); x++)
        {
            Text text = new Text(2.5 + "kg");
            Rectangle plate = new Rectangle();
            plate.setWidth(30);
            plate.setHeight(50);
            plate.setFill(colors[6]);

            Rectangle invisiblePlate = new Rectangle();
            invisiblePlate.setWidth(10);

            StackPane stack = new StackPane();
            stack.getChildren().addAll(plate,text);
            plates.getChildren().add(stack);
            plates.getChildren().add(invisiblePlate);


        }
        for(int x =0; x <wm.getOneTwentyFive(); x++)
        {
            Text text = new Text(1.25 + "kg");
            Rectangle plate = new Rectangle();
            plate.setWidth(30);
            plate.setHeight(40);
            plate.setFill(colors[7]);

            Rectangle invisiblePlate = new Rectangle();
            invisiblePlate.setWidth(10);

            StackPane stack = new StackPane();
            stack.getChildren().addAll(plate,text);
            plates.getChildren().add(stack);
            plates.getChildren().add(invisiblePlate);


        }
        for(int x =0; x <wm.getZeroFive(); x++)
        {
            Text text = new Text(0.5 + "kg");
            Rectangle plate = new Rectangle();
            plate.setWidth(30);
            plate.setHeight(30);
            plate.setFill(colors[8]);

            Rectangle invisiblePlate = new Rectangle();
            invisiblePlate.setWidth(10);

            StackPane stack = new StackPane();
            stack.getChildren().addAll(plate,text);
            plates.getChildren().add(stack);
            plates.getChildren().add(invisiblePlate);



        }
        for(int x =0; x <wm.getZeroTwentyFive(); x++)
        {
            Text text = new Text(.25 + "kg");
            Rectangle plate = new Rectangle();
            plate.setWidth(30);
            plate.setHeight(20);
            plate.setFill(colors[9]);

            Rectangle invisiblePlate = new Rectangle();
            invisiblePlate.setWidth(10);

            StackPane stack = new StackPane();
            stack.getChildren().addAll(plate,text);
            plates.getChildren().add(stack);
            plates.getChildren().add(invisiblePlate);


        }
        //plate image generation

    }

    public void changeToBench(ActionEvent Event)
    {
        typeOfExcercise =0;
        weightEnter.setText("0");

    }

    public void changeToSquat(ActionEvent Event)
    {
        typeOfExcercise = 1;
        weightEnter.setText("0");
    }

    public void changeToDeadlift(ActionEvent Event)
    {
        typeOfExcercise =2;
        weightEnter.setText("0");


    }




}
