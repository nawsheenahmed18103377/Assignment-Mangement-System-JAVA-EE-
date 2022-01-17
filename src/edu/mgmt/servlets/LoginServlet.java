package edu.mgmt.servlets;

import edu.mgmt.dao.AssignmentDao;
import edu.mgmt.dao.SubmitedAssignmentDao;
import edu.mgmt.dao.UserDao;
import edu.mgmt.entities.User;
import edu.mgmt.helper.ConnectionProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;


public class LoginServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User)request.getAttribute("user");

        if (user.getType()==0){
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", user);
            response.sendRedirect("StudentServlet");
        }
        if (user.getType()==1){
            Connection con = ConnectionProvider.getConnection();
            UserDao userDao = new UserDao(con);
            AssignmentDao asDao = new AssignmentDao(con);
            SubmitedAssignmentDao subAs = new SubmitedAssignmentDao(con);


            HttpSession session = request.getSession();
            session.setAttribute("noOfStudent", userDao.getNumberOfStudents());
            session.setAttribute("noOfAssaignment", asDao.getNumberOfAssignments());
            session.setAttribute("noOfSubAs", subAs.getNumberOfSubmitedAssignment());
            session.setAttribute("currentUser", user);
            response.sendRedirect("TeacherServlet");
        }

    }


}
