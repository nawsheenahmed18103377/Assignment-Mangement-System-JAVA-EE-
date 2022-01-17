package edu.mgmt.servlets;

import edu.mgmt.dao.UserDao;
import edu.mgmt.entities.User;
import edu.mgmt.helper.ConnectionProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AllStudentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDao userDao = new UserDao(ConnectionProvider.getConnection());
        ArrayList<User> allStudents = userDao.getAllStudents();

        req.setAttribute("allStudents", allStudents);

        RequestDispatcher dispatcher = req.getRequestDispatcher("all_student.jsp");
        dispatcher.forward(req, resp);

    }
}
