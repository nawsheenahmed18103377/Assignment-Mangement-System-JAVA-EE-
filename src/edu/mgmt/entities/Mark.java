package edu.mgmt.entities;

public class Mark {

    private Integer markId;
    private Integer studentId;
    private String studentName;
    private Integer assignmentId;
    private String assignmentName;
    private Integer mark;

    public Mark(Integer studentId, String studentName, Integer assignmentId, String assignmentName, Integer mark) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.assignmentId = assignmentId;
        this.assignmentName = assignmentName;
        this.mark = mark;
    }

    public Mark(Integer markId, Integer studentId, String studentName, Integer assignmentId, String assignmentName, Integer mark) {
        this.markId = markId;
        this.studentId = studentId;
        this.studentName = studentName;
        this.assignmentId = assignmentId;
        this.assignmentName = assignmentName;
        this.mark = mark;
    }

    public Integer getMarkId() {
        return markId;
    }

    public void setMarkId(Integer markId) {
        this.markId = markId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "markId=" + markId +
                ", studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", assignmentId=" + assignmentId +
                ", assignmentName='" + assignmentName + '\'' +
                ", mark=" + mark +
                '}';
    }
}
