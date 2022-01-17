package edu.mgmt.servlets;

import edu.mgmt.dao.SubmitedAssignmentDao;
import edu.mgmt.entities.SubmitedAssignment;
import edu.mgmt.helper.ConnectionProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class SubmitedAssignmentListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SubmitedAssignmentDao subAsDao = new SubmitedAssignmentDao(ConnectionProvider.getConnection());
        ArrayList<SubmitedAssignment> subAssignments = subAsDao.getAllSubmitedAssignment();
        req.setAttribute("subAssignments", subAssignments);

        RequestDispatcher dispatcher = req.getRequestDispatcher("submited_assignment.jsp");
        dispatcher.forward(req, resp);

    }
}
