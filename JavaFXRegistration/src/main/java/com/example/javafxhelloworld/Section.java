package com.example.javafxhelloworld;

public class Section {
    private int ID;
    private Course course;
    private Faculty faculty;
    private String semester;
    private String day;
    private String startTime;
    private String endTime;
    private String modality;

    public Section(int ID, Course course, Faculty faculty, String semester, String day, String startTime, String endTime, String modality) {
        this.ID = ID;
        this.course = course;
        this.faculty = faculty;
        this.semester = semester;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.modality = modality;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    @Override
    public String toString() {
        return "Section{" + "\n" +
                "ID=" + ID + "\n" +
                ", course=" + course.toString() + "\n" +
                ", faculty=" + faculty.toString() + "\n" +
                ", semester='" + semester + '\'' + "\n" +
                ", day='" + day + '\'' +"\n" +
                ", startTime='" + startTime + '\'' + "\n" +
                ", endTime='" + endTime + '\'' + "\n" +
                ", modality='" + modality + '\'' +"\n" +
                '}';
    }
}
