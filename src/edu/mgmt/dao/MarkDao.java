package edu.mgmt.dao;

import edu.mgmt.entities.Mark;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MarkDao {

    Connection con;

    public MarkDao(Connection con){
        this.con = con;
    }

    public boolean saveMark(Mark mark){
        boolean f= false;
        try{
            String query = "INSERT INTO marks (`userId`, `fullName`, `asId`, `asName`, `mark`) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, mark.getStudentId());
            pstmt.setString(2, mark.getStudentName());
            pstmt.setInt(3, mark.getAssignmentId());
            pstmt.setString(4, mark.getAssignmentName());
            pstmt.setInt(5, mark.getMark());
            pstmt.executeUpdate();
            f= true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }


    public boolean isMarkAlreadyGiven(Integer studentId, Integer assignmentNo){
        boolean f = false;
        try {

            String query = "SELECT * FROM marks WHERE `userId`=? AND `asId`=?";
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


    public ArrayList<Mark> showAllMark(){
        ArrayList<Mark> marks = new ArrayList<>();

        try {
            String query = "SELECT * FROM marks";
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()){
                int markId = resultSet.getInt("markId");
                int userId = resultSet.getInt("userId");
                String fullName = resultSet.getString("fullName");
                int asId = resultSet.getInt("asId");
                String asName = resultSet.getString("asName");
                int mark = resultSet.getInt("mark");

                Mark markOb = new Mark(markId, userId, fullName, asId, asName, mark);
                marks.add(markOb);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return marks;
    }



    public ArrayList<Mark> showAllMarkByUserId(Integer userId){
        ArrayList<Mark> marks = new ArrayList<>();

        try {
            String query = "SELECT * FROM marks WHERE `userId`=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, userId);
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()){
                int markId = resultSet.getInt("markId");
                int uId = resultSet.getInt("userId");
                String fullName = resultSet.getString("fullName");
                int asId = resultSet.getInt("asId");
                String asName = resultSet.getString("asName");
                int mark = resultSet.getInt("mark");

                Mark markO = new Mark(markId, uId, fullName, asId, asName, mark);
                marks.add(markO);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return marks;
    }


}
