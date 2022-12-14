package com.kartikeymishr.studentmanagementsystem.model;

import com.kartikeymishr.studentmanagementsystem.firestore.DocumentId;
import com.kartikeymishr.studentmanagementsystem.model.entity.Professor;
import com.kartikeymishr.studentmanagementsystem.model.entity.Student;

import java.util.List;
import java.util.Objects;

public class Batch {
    @DocumentId
    private String batchId;
    private String name;
    private String startYear;
    private String endYear;
    private String properName;
    private Professor courseCoordinator;
    private Student classRepresentative;
    private List<Student> students;

    public Batch() {
    }

    public Batch(String batchId, String name, String startYear, String endYear, Professor courseCoordinator,
                 Student classRepresentative, List<Student> students) {
        this.batchId = batchId;
        this.name = name;
        this.startYear = startYear;
        this.endYear = endYear;
        this.courseCoordinator = courseCoordinator;
        this.classRepresentative = classRepresentative;
        this.students = students;

        this.properName = name + " " + startYear + "-" + endYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public Professor getCourseCoordinator() {
        return courseCoordinator;
    }

    public void setCourseCoordinator(Professor courseCoordinator) {
        this.courseCoordinator = courseCoordinator;
    }

    public Student getClassRepresentative() {
        return classRepresentative;
    }

    public void setClassRepresentative(Student classRepresentative) {
        this.classRepresentative = classRepresentative;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    public String getProperName() {
        return properName;
    }

    public void setProperName(String properName) {
        this.properName = properName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Batch batch = (Batch) o;
        return Objects.equals(batchId, batch.batchId) && Objects.equals(name, batch.name)
                && Objects.equals(startYear, batch.startYear) && Objects.equals(endYear, batch.endYear)
                && Objects.equals(properName, batch.properName)
                && Objects.equals(courseCoordinator, batch.courseCoordinator)
                && Objects.equals(classRepresentative, batch.classRepresentative)
                && Objects.equals(students, batch.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(batchId, name, startYear, endYear, properName, courseCoordinator,
                classRepresentative, students);
    }
}
