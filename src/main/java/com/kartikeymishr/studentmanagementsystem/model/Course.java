package com.kartikeymishr.studentmanagementsystem.model;

import com.kartikeymishr.studentmanagementsystem.firestore.DocumentId;
import com.kartikeymishr.studentmanagementsystem.model.entity.Professor;

import java.util.Objects;

public class Course {

    @DocumentId
    private String courseId;
    private String courseName;
    private Professor professor;

    public Course() {
    }

    public Course(String courseId, String courseName, Professor professor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.professor = professor;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseId, course.courseId) && Objects.equals(courseName, course.courseName)
                && Objects.equals(professor, course.professor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, courseName, professor);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", professor=" + professor +
                '}';
    }
}
