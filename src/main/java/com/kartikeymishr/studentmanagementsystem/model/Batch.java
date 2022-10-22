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
    private Professor courseCoordinator;
    private Student classRepresentative;
    private List<Student> students;

    public Batch() {
    }

    public Batch(String name, String batchId, Professor courseCoordinator, Student classRepresentative,
                 List<Student> students) {
        this.name = name;
        this.batchId = batchId;
        this.courseCoordinator = courseCoordinator;
        this.classRepresentative = classRepresentative;
        this.students = students;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Batch batch = (Batch) o;
        return Objects.equals(name, batch.name) && Objects.equals(batchId, batch.batchId)
                && Objects.equals(courseCoordinator, batch.courseCoordinator)
                && Objects.equals(classRepresentative, batch.classRepresentative)
                && Objects.equals(students, batch.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, batchId, courseCoordinator, classRepresentative, students);
    }

    @Override
    public String toString() {
        return "Batch{" +
                "name='" + name + '\'' +
                ", batchId='" + batchId + '\'' +
                ", courseCoordinator=" + courseCoordinator +
                ", classRepresentative=" + classRepresentative +
                ", students=" + students +
                '}';
    }
}
