package com.example.javafxhelloworld;

import java.util.ArrayList;

public class Student {
    private int ID;
    private String firstName;
    private String lastName;
    private String major;
    private double gpa;
    private ArrayList<Enrollment> enrollments;


    public Student(int ID, String firstName, String lastName, String major, double gpa) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.gpa = gpa;
        this.enrollments = new ArrayList<>();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public ArrayList<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(ArrayList<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    @Override
    public String toString() {
        return "Student{" + "\n" +
                "ID=" + ID + "\n" +
                ", firstName='" + firstName + '\'' + "\n" +
                ", lastName='" + lastName + '\'' + "\n" +
                ", major='" + major + '\'' + "\n" +
                ", gpa=" + gpa + "\n" +
                '}';
    }
}
