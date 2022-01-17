package edu.mgmt.servlets;

import edu.mgmt.dao.AssignmentDao;
import edu.mgmt.entities.Assignment;
import edu.mgmt.helper.ConnectionProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AssignmentListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        AssignmentDao asDao = new AssignmentDao(ConnectionProvider.getConnection());
        ArrayList<Assignment> assignments = asDao.showAllAssignment();
        req.setAttribute("assignments", assignments);

        RequestDispatcher dispatcher = req.getRequestDispatcher("assignment_list.jsp");
        dispatcher.forward(req, resp);

    }
}
