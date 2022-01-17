package edu.mgmt.entities;

import java.time.LocalDate;


public class Assignment{
    private Integer assignmentId;
    private String assignmentName;
    private String assignmentDetails;
    private String assignmentSubject;
    private String assignmentFilePath;
    private LocalDate publishedDate;
    private LocalDate submitDate;

    public Assignment( String assignmentName, String assignmentDetails, String assignmentSubject, String assignmentFilePath, LocalDate publishedDate, LocalDate submitDate) {
        this.assignmentName = assignmentName;
        this.assignmentDetails = assignmentDetails;
        this.assignmentSubject = assignmentSubject;
        this.assignmentFilePath = assignmentFilePath;
        this.publishedDate = publishedDate;
        this.submitDate = submitDate;
    }

    public Assignment(Integer assignmentId, String assignmentName, String assignmentDetails, String assignmentSubject, String assignmentFilePath, LocalDate publishedDate, LocalDate submitDate) {
        this.assignmentId = assignmentId;
        this.assignmentName = assignmentName;
        this.assignmentDetails = assignmentDetails;
        this.assignmentSubject = assignmentSubject;
        this.assignmentFilePath = assignmentFilePath;
        this.publishedDate = publishedDate;
        this.submitDate = submitDate;
    }

    public Integer getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Integer assignmentId) {
        this.assignmentId = assignmentId;
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

    public String getAssignmentSubject() {
        return assignmentSubject;
    }

    public void setAssignmentSubject(String assignmentSubject) {
        this.assignmentSubject = assignmentSubject;
    }

    public String getAssignmentFilePath() {
        return assignmentFilePath;
    }

    public void setAssignmentFilePath(String assignmentFilePath) {
        this.assignmentFilePath = assignmentFilePath;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public LocalDate getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(LocalDate submitDate) {
        this.submitDate = submitDate;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId=" + assignmentId +
                ", assignmentName='" + assignmentName + '\'' +
                ", assignmentSubject='" + assignmentSubject + '\'' +
                ", assignmentFilePath='" + assignmentFilePath + '\'' +
                ", publishedDate=" + publishedDate +
                ", SubmitDate=" + submitDate +
                '}';
    }
}

