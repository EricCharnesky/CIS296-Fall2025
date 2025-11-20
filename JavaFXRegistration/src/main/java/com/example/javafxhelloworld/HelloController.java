package com.example.javafxhelloworld;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.event.*;

import java.util.ArrayList;
import java.util.Collections;

public class HelloController {

    @FXML
    private TextField studentIDTextBox;
    @FXML
    private Button lookupStudentButton;
    @FXML
    private Label enrollmentsLabel;
    @FXML
    private TextArea textArea;
    @FXML
    private ListView studentsListView;
    @FXML
    private Button getStudentListButton;

    @FXML
    public void lookupStudent(ActionEvent actionEvent) {
        ArrayList<Student> students = CollegeDB.getStudent(Integer.parseInt(studentIDTextBox.getText()));
        textArea.clear();
        if (students.isEmpty()){
            textArea.appendText("No students found");
        } else{
            Student student = students.get(0);
            CollegeDB.addEnrollmentInfo(student);

            for ( Enrollment enrollment : student.getEnrollments()){
                textArea.appendText( enrollment.toString() + "\n");
            }
        }


    }

    @FXML
    public void getStudentList(ActionEvent actionEvent) {
        ArrayList<Student> students = CollegeDB.getStudents();

        studentsListView.setItems(FXCollections.observableList(students));

    }

    @FXML
    public void studentClicked(Event event) {
        Student selectedStudent = (Student)studentsListView.getSelectionModel().getSelectedItem();
        studentIDTextBox.setText(Integer.toString(selectedStudent.getID()));
    }
}