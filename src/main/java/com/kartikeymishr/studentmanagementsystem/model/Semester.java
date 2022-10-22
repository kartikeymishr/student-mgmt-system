package com.kartikeymishr.studentmanagementsystem.model;

import com.kartikeymishr.studentmanagementsystem.firestore.DocumentId;

import java.util.List;
import java.util.Objects;

public class Semester {

    @DocumentId
    private String semesterId;
    private String semesterNumber;
    private double gradePointAverage;
    private List<Course> courses;

    public Semester() {
    }

    public Semester(String semesterId, String semesterNumber, double gradePointAverage, List<Course> courses) {
        this.semesterId = semesterId;
        this.semesterNumber = semesterNumber;
        this.gradePointAverage = gradePointAverage;
        this.courses = courses;
    }

    public String getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(String semesterId) {
        this.semesterId = semesterId;
    }

    public String getSemesterNumber() {
        return semesterNumber;
    }

    public void setSemesterNumber(String semesterNumber) {
        this.semesterNumber = semesterNumber;
    }

    public double getGradePointAverage() {
        return gradePointAverage;
    }

    public void setGradePointAverage(double gradePointAverage) {
        this.gradePointAverage = gradePointAverage;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Semester semester = (Semester) o;
        return Double.compare(semester.gradePointAverage, gradePointAverage) == 0
                && Objects.equals(semesterId, semester.semesterId)
                && Objects.equals(semesterNumber, semester.semesterNumber)
                && Objects.equals(courses, semester.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(semesterId, semesterNumber, gradePointAverage, courses);
    }

    @Override
    public String toString() {
        return "Semester{" +
                "semesterId='" + semesterId + '\'' +
                ", semesterNumber='" + semesterNumber + '\'' +
                ", gradePointAverage=" + gradePointAverage +
                ", courses=" + courses +
                '}';
    }
}
