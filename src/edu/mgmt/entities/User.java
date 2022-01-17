package edu.mgmt.entities;

import javax.jws.soap.SOAPBinding;
import java.io.Serializable;

public class User implements Serializable {
    private Integer id;
    private String fullName;
    private String gender;
    private String address;
    private String department;
    private String details;
    private String userName;
    private String password;
    private Integer type;

    public User(String fullName, String gender, String address, String department, String details, String userName, String password, Integer type) {
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.details = details;
        this.userName = userName;
        this.password = password;
        this.type = type;
    }

    public User(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", department='" + department + '\'' +
                ", details='" + details + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                '}';
    }
}
