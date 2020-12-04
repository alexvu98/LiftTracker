package sample;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Lifter {

    private SimpleStringProperty participantFirstName;
    private SimpleStringProperty participantLastName;
    private SimpleStringProperty participantSex;
    private SimpleIntegerProperty participantWeight;

    private SimpleFloatProperty benchWeight;
    private SimpleFloatProperty squatWeight;
    private SimpleFloatProperty deadLiftWeight;

    public Lifter(String participantFirstName, String participantLastName, String participantSex, Integer participantWeight) {
        this.participantFirstName = new SimpleStringProperty(participantFirstName);
        this.participantLastName = new SimpleStringProperty(participantLastName);
        this.participantSex = new SimpleStringProperty(participantSex);
        this.participantWeight = new SimpleIntegerProperty(participantWeight);
    }

    public Lifter(Float benchWeight, Float squatWeight, Float deadLiftWeight){
        this.benchWeight = new SimpleFloatProperty(benchWeight);
        this.squatWeight = new SimpleFloatProperty(squatWeight);
        this.deadLiftWeight = new SimpleFloatProperty(deadLiftWeight);
    }

    public String getParticipantFirstName() {
        return participantFirstName.get();
    }

    public SimpleStringProperty participantFirstNameProperty() {
        return participantFirstName;
    }

    public void setParticipantFirstName(String participantFirstName) {
        this.participantFirstName = new SimpleStringProperty(participantFirstName);
    }

    public String getParticipantLastName() {
        return participantLastName.get();
    }

    public SimpleStringProperty participantLastNameProperty() {
        return participantLastName;
    }

    public void setParticipantLastName(String participantLastName) {
        this.participantLastName = new SimpleStringProperty(participantLastName);
    }

    public String getParticipantSex() {
        return participantSex.get();
    }

    public SimpleStringProperty participantSexProperty() {
        return participantSex;
    }

    public void setParticipantSex(String participantSex) {
        this.participantSex = new SimpleStringProperty(participantSex);
    }

    public int getParticipantWeight() {
        return participantWeight.get();
    }

    public SimpleIntegerProperty participantWeightProperty() {
        return participantWeight;
    }

    public void setParticipantWeight(int participantWeight) {
        this.participantWeight.set(participantWeight);
    }

    public float getBenchWeight() {
        return benchWeight.get();
    }

    public SimpleFloatProperty benchWeightProperty() {
        return benchWeight;
    }

    public void setBenchWeight(float benchWeight) {
        this.benchWeight.set(benchWeight);
    }

    public float getSquatWeight() {
        return squatWeight.get();
    }

    public SimpleFloatProperty squatWeightProperty() {
        return squatWeight;
    }

    public void setSquatWeight(float squatWeight) {
        this.squatWeight.set(squatWeight);
    }

    public float getDeadLiftWeight() {
        return deadLiftWeight.get();
    }

    public SimpleFloatProperty deadLiftWeightProperty() {
        return deadLiftWeight;
    }

    public void setDeadLiftWeight(float deadLiftWeight) {
        this.deadLiftWeight.set(deadLiftWeight);
    }

}
