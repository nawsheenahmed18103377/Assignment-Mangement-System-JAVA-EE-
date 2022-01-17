package edu.mgmt.dao;

import edu.mgmt.entities.Assignment;
import edu.mgmt.entities.SubmitedAssignment;
import edu.mgmt.entities.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class SubmitedAssignmentDao {

    private Connection con;

    public SubmitedAssignmentDao(Connection con){
        this.con = con;
    }

    public boolean saveSubmitedAssignment(Integer studentId, Integer assignmentNo, String asFilePath){
        boolean f = false;
        try {

            AssignmentDao asDao = new AssignmentDao(con);
            Assignment assignment = asDao.getAssignmentById(assignmentNo);

            UserDao userDao = new UserDao(con);
            User userById = userDao.getUserById(studentId);

            String query = "INSERT INTO `submited_assignments` (`userId`, `fullName`, `asId`, `asName`, `asDetails`, `pubDate`, `subDate`, `asFilePath`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, studentId);
            pstmt.setString(2, userById.getFullName());
            pstmt.setInt(3, assignmentNo);
            pstmt.setString(4, assignment.getAssignmentName());
            pstmt.setString(5, assignment.getAssignmentDetails());
            pstmt.setDate(6, Date.valueOf(assignment.getPublishedDate()));
            pstmt.setDate(7, Date.valueOf(assignment.getSubmitDate()));
            pstmt.setString(8, asFilePath);

            pstmt.setString(8, asFilePath);
            pstmt.executeUpdate();

            f = true;

        }catch (Exception e){
            e.printStackTrace();
        }

        return f;
    }

    public ArrayList<SubmitedAssignment> getSubmitedAssignmentByUserId(Integer uID){
         ArrayList<SubmitedAssignment> subAssignments = new ArrayList<>();

        try {
            String query = "SELECT * FROM submited_assignments WHERE `userId`=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, uID);
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()){
                int subAsId = resultSet.getInt("subAsId");
                int userId = resultSet.getInt("userId");
                String fullName = resultSet.getString("fullName");
                int asId = resultSet.getInt("asId");
                String asName = resultSet.getString("asName");
                String asDetails = resultSet.getString("asDetails");
                LocalDate pubDate = resultSet.getDate("pubDate").toLocalDate();
                LocalDate subDate = resultSet.getDate("subDate").toLocalDate();
                String asFilePath = resultSet.getString("asFilePath");

                SubmitedAssignment subAss = new SubmitedAssignment(subAsId, userId, fullName, asId, asName, asDetails, pubDate, subDate, asFilePath);
                subAssignments.add(subAss);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return subAssignments;
    }


    public String getAssignmentFilePathById(int subAsId){
        String assignmentFilePath = null;

        try{
            String query = "SELECT `asFilePath` FROM `submited_assignments` WHERE `subAsId`=?";

            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, subAsId);
            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()){
                assignmentFilePath = resultSet.getString("asFilePath");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return assignmentFilePath;
    }

    public boolean isAssignmentAlreadySubmited(Integer studentId, Integer assignmentNo){
        boolean f = false;
        try {

            String query = "SELECT * FROM submited_assignments WHERE `userId`=? AND `asId`=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, studentId);
            pstmt.setInt(2, assignmentNo);
            ResultSet resultSet = pstmt.executeQuery();
            boolean data = resultSet.next();
            f = data;

        }catch (Exception e){
            e.printStackTrace();
        }

        return f;
    }


    public ArrayList<SubmitedAssignment> getAllSubmitedAssignment(){
        ArrayList<SubmitedAssignment> subAssignments = new ArrayList<>();

        try {
            String query = "SELECT * FROM submited_assignments";
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()){
                int subAsId = resultSet.getInt("subAsId");
                int userId = resultSet.getInt("userId");
                String fullName = resultSet.getString("fullName");
                int asId = resultSet.getInt("asId");
                String asName = resultSet.getString("asName");
                String asDetails = resultSet.getString("asDetails");
                LocalDate pubDate = resultSet.getDate("pubDate").toLocalDate();
                LocalDate subDate = resultSet.getDate("subDate").toLocalDate();
                String asFilePath = resultSet.getString("asFilePath");

                SubmitedAssignment subAss = new SubmitedAssignment(subAsId, userId, fullName, asId, asName, asDetails, pubDate, subDate, asFilePath);
                subAssignments.add(subAss);

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return subAssignments;
    }



    public SubmitedAssignment getSbuAsById(int subAsId){
        SubmitedAssignment subAs = null;

        try{
            String query = "SELECT * FROM submited_assignments WHERE `subAsId`=?";

            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, subAsId);
            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()){
//                int subAsId = resultSet.getInt("subAsId");
                int userId = resultSet.getInt("userId");
                String fullName = resultSet.getString("fullName");
                int asId = resultSet.getInt("asId");
                String asName = resultSet.getString("asName");
                String asDetails = resultSet.getString("asDetails");
                LocalDate pubDate = resultSet.getDate("pubDate").toLocalDate();
                LocalDate subDate = resultSet.getDate("subDate").toLocalDate();
                String asFilePath = resultSet.getString("asFilePath");

                subAs = new SubmitedAssignment(subAsId, userId, fullName, asId, asName, asDetails, pubDate, subDate, asFilePath);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return subAs;
    }

    public int getNumberOfSubmitedAssignment(){
        int total = 0;
        try {
            String query = "SELECT COUNT(subAsId) AS total FROM submited_assignments";
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
