package edu.mgmt.dao;

import edu.mgmt.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {

    private Connection con;

    public UserDao(Connection con){
        this.con = con;
    }

    public boolean saveUser(User user){
        boolean f = false;
        try{
            String query = " INSERT INTO users (`fullName`,`gender`,`address`, `depertment`,`details`,`userName`,`pass`,`userType`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, user.getFullName());
            pstmt.setString(2, user.getGender());
            pstmt.setString(3, user.getAddress());
            pstmt.setString(4, user.getDepartment());
            pstmt.setString(5, user.getDetails());
            pstmt.setString(6, user.getUserName());
            pstmt.setString(7, user.getPassword());
            pstmt.setInt(8, user.getType());

            pstmt.executeUpdate();
            f= true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

    public User getUserByEmailAndPassword(String userName, String userPassword) {
        User user = null;
        try {

            String query = " SELECT * FROM users WHERE userName=? AND pass=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, userName);
            pstmt.setString(2, userPassword);

            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()){
                user = new User();
                int userId = resultSet.getInt("userId");

//                `userId``fullName``depertment``details``userName``pass``userType`
                user.setId(userId);
                user.setFullName(resultSet.getString("fullName"));
                user.setGender(resultSet.getString("gender"));
                user.setAddress(resultSet.getString("address"));
                user.setDepartment(resultSet.getString("depertment"));
                user.setDetails(resultSet.getString("details"));
                user.setUserName(resultSet.getString("userName"));
                user.setPassword(resultSet.getString("pass"));
                user.setType(resultSet.getInt("userType"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return user;
    }


    public User getUserById(Integer userId) {
        User user = null;
        try {
            String query = " SELECT * FROM users WHERE userId=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, userId);

            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()){
                user = new User();

//                `userId``fullName``depertment``details``userName``pass``userType`
                user.setId(resultSet.getInt("userId"));
                user.setFullName(resultSet.getString("fullName"));
                user.setGender(resultSet.getString("gender"));
                user.setAddress(resultSet.getString("address"));
                user.setDepartment(resultSet.getString("depertment"));
                user.setDetails(resultSet.getString("details"));
                user.setUserName(resultSet.getString("userName"));
                user.setPassword(resultSet.getString("pass"));
                user.setType(resultSet.getInt("userType"));

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return user;
    }


    public ArrayList<User> getAllStudents() {
        ArrayList<User> students = new ArrayList<>();

        try {
            String query = " SELECT * FROM users WHERE userType=0";
                PreparedStatement pstmt = con.prepareStatement(query);
                ResultSet resultSet = pstmt.executeQuery();

                while (resultSet.next()){
                    User user = new User();
                    user.setId(resultSet.getInt("userId"));
                    user.setFullName(resultSet.getString("fullName"));
                    user.setGender(resultSet.getString("gender"));
                    user.setAddress(resultSet.getString("address"));
                    user.setDepartment(resultSet.getString("depertment"));
                    user.setDetails(resultSet.getString("details"));
                    user.setUserName(resultSet.getString("userName"));
                    user.setPassword(resultSet.getString("pass"));
                    user.setType(resultSet.getInt("userType"));

                    students.add(user);
        }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return students;
    }


    public int getNumberOfStudents(){
        int total = 0;
        try {
            String query = "SELECT COUNT(userId) AS total FROM users WHERE userType=0";
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
