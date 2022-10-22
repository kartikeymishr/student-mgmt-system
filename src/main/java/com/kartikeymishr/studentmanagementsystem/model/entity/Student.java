package com.kartikeymishr.studentmanagementsystem.model.entity;

import com.kartikeymishr.studentmanagementsystem.model.Batch;
import com.kartikeymishr.studentmanagementsystem.model.Semester;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Student extends BaseEntity {

    private Date enrollmentDate;
    private String enrollmentYear;
    private String projectedGraduationYear;
    private String programName;
    private String specializationName;
    private int currentYear;
    private int currentSemester;
    private Batch batch;
    private List<Semester> semesters;

    public Student() {
    }

    public Student(String firstName, String lastName, String email, String registrationNumber, String mobile,
                   Date dateOfBirth, Date enrollmentDate, String enrollmentYear, String projectedGraduationYear,
                   String programName, String specializationName, int currentYear, int currentSemester, Batch batch,
                   List<Semester> semesters) {
        super(firstName, lastName, email, registrationNumber, mobile, dateOfBirth);
        this.enrollmentDate = enrollmentDate;
        this.enrollmentYear = enrollmentYear;
        this.projectedGraduationYear = projectedGraduationYear;
        this.programName = programName;
        this.specializationName = specializationName;
        this.currentYear = currentYear;
        this.currentSemester = currentSemester;
        this.batch = batch;
        this.semesters = semesters;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(String enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public String getProjectedGraduationYear() {
        return projectedGraduationYear;
    }

    public void setProjectedGraduationYear(String projectedGraduationYear) {
        this.projectedGraduationYear = projectedGraduationYear;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getSpecializationName() {
        return specializationName;
    }

    public void setSpecializationName(String specializationName) {
        this.specializationName = specializationName;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public int getCurrentSemester() {
        return currentSemester;
    }

    public void setCurrentSemester(int currentSemester) {
        this.currentSemester = currentSemester;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public List<Semester> getSemesters() {
        return semesters;
    }

    public void setSemesters(List<Semester> semesters) {
        this.semesters = semesters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return currentYear == student.currentYear && currentSemester == student.currentSemester &&
                Objects.equals(enrollmentDate, student.enrollmentDate)
                && Objects.equals(enrollmentYear, student.enrollmentYear)
                && Objects.equals(projectedGraduationYear, student.projectedGraduationYear)
                && Objects.equals(programName, student.programName)
                && Objects.equals(specializationName, student.specializationName)
                && Objects.equals(batch, student.batch) && Objects.equals(semesters, student.semesters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), enrollmentDate, enrollmentYear, projectedGraduationYear, programName,
                specializationName, currentYear, currentSemester, batch, semesters);
    }
}
