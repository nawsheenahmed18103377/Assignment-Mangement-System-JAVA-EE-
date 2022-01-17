package edu.mgmt.dao;

import edu.mgmt.entities.Assignment;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class AssignmentDao {
    private Connection con;

    public AssignmentDao(Connection con){
        this.con = con;
    }

    public boolean saveAssignment(Assignment assignment){
        boolean f = false;
        try {
            String query = "INSERT INTO `assignments` (`asName`, `asDetails`, `asSubject`, `asFilePath`, `pubDate`, `subDate`) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, assignment.getAssignmentName());
            pstmt.setString(2, assignment.getAssignmentDetails());
            pstmt.setString(3, assignment.getAssignmentSubject());
            pstmt.setString(4, assignment.getAssignmentFilePath());
            pstmt.setDate(5, Date.valueOf(assignment.getPublishedDate()));
            pstmt.setDate(6, Date.valueOf(assignment.getSubmitDate()));

            pstmt.executeUpdate();
            f = true;

        }catch (Exception e){
            e.printStackTrace();
        }

        return f;
    }

    public ArrayList<Assignment> showAllAssignment(){
        ArrayList<Assignment> assignments = new ArrayList<>();

        try {
            String query = "SELECT * FROM assignments";
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()){
                Integer asId = resultSet.getInt("asId");
                String asName = resultSet.getString("asName");
                String asDetails = resultSet.getString("asDetails");
                String asSubject = resultSet.getString("asSubject");
                String asFilePath = resultSet.getString("asFilePath");
                LocalDate pubDate = resultSet.getDate("pubDate").toLocalDate();
                LocalDate subDate = resultSet.getDate("subDate").toLocalDate();

                Assignment assignment = new Assignment(asId, asName, asDetails, asSubject, asFilePath, pubDate, subDate);
                assignments.add(assignment);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return assignments;
    }

    public String getAssignmentFilePathById(int asId){
        String assignmentFilePath = null;

        try{
            String query = "SELECT `asFilePath` FROM `assignments` WHERE `asId`=?";

            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, asId);
            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()){
                assignmentFilePath = resultSet.getString("asFilePath");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return assignmentFilePath;
    }


    public Assignment getAssignmentById(int assignmentId){
        Assignment assignment = null;

        try{
            String query = "SELECT * FROM `assignments` WHERE `asId`=?";

            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, assignmentId);
            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()){

                Integer asId = resultSet.getInt("asId");
                String asName = resultSet.getString("asName");
                String asDetails = resultSet.getString("asDetails");
                String asSubject = resultSet.getString("asSubject");
                String asFilePath = resultSet.getString("asFilePath");
                LocalDate pubDate = resultSet.getDate("pubDate").toLocalDate();
                LocalDate subDate = resultSet.getDate("subDate").toLocalDate();
                assignment = new Assignment(asId, asName, asDetails, asSubject, asFilePath, pubDate, subDate);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return assignment;
    }


    public int getNumberOfAssignments(){
        int total = 0;
        try {
            String query = "SELECT COUNT(asId) AS total FROM assignments";
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                int t = resultSet.getInt("total");
                total = t;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return total;
    }


}
