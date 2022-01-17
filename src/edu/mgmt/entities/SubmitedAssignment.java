package edu.mgmt.entities;

import java.io.Serializable;
import java.time.LocalDate;

public class SubmitedAssignment implements Serializable {
    private Integer submitedAssignmentId;
    private Integer studentID;
    private String studentName;
    private Integer assignmentNo;
    private String assignmentName;
    private String assignmentDetails;
    private LocalDate publishDate;
    private LocalDate submitDate;
    private String assignmentFilePath;


    public SubmitedAssignment(Integer submitedAssignmentId ,Integer studentID, String studentName, Integer assignmentNo, String assignmentName,String assignmentDetails, LocalDate publishDate, LocalDate submitDate, String assignmentFilePath) {
        this.submitedAssignmentId = submitedAssignmentId;
        this.studentName = studentName;
        this.studentID = studentID;
        this.assignmentNo = assignmentNo;
        this.assignmentName = assignmentName;
        this.assignmentDetails = assignmentDetails;
        this.publishDate = publishDate;
        this.submitDate = submitDate;
        this.assignmentFilePath = assignmentFilePath;
    }

    public Integer getSubmitedAssignmentId() {
        return submitedAssignmentId;
    }

    public void setSubmitedAssignmentId(Integer submitedAssignmentId) {
        this.submitedAssignmentId = submitedAssignmentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public Integer getAssignmentNo() {
        return assignmentNo;
    }

    public void setAssignmentNo(Integer assignmentNo) {
        this.assignmentNo = assignmentNo;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public String getAssignmentDetails() {
        return assignmentDetails;
    }

    public void setAssignmentDetails(String assignmentDetails) {
        this.assignmentDetails = assignmentDetails;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public LocalDate getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(LocalDate submitDate) {
        this.submitDate = submitDate;
    }

    public String getAssignmentFilePath() {
        return assignmentFilePath;
    }

    public void setAssignmentFilePath(String assignmentFilePath) {
        this.assignmentFilePath = assignmentFilePath;
    }

    @Override
    public String toString() {
        return "SubmitedAssignment{" +
                "submitedAssignmentId=" + submitedAssignmentId +
                ", studentID=" + studentID +
                ", studentName='" + studentName + '\'' +
                ", assignmentNo=" + assignmentNo +
                ", assignmentName='" + assignmentName + '\'' +
                ", assignmentDetails='" + assignmentDetails + '\'' +
                ", publishDate=" + publishDate +
                ", submitDate=" + submitDate +
                ", assignmentFilePath='" + assignmentFilePath + '\'' +
                '}';
    }
}


