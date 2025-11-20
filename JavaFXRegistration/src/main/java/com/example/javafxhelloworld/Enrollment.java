package com.example.javafxhelloworld;

public class Enrollment {
    private int ID;
    private Student student;
    private Section section;
    private String grade;

    public Enrollment(int ID, Student student, Section section, String grade) {
        this.ID = ID;
        this.student = student;
        this.section = section;
        this.grade = grade;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Enrollment{" +"\n" +
                "ID=" + ID +"\n" +
                ", student=" + student.toString() +"\n" +
                ", section=" + section.toString() +"\n" +
                ", grade='" + grade + '\'' +"\n" +
                '}';
    }
}
