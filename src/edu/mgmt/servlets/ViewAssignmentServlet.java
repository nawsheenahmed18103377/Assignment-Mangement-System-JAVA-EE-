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

public class ViewAssignmentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int assignmentId = Integer.parseInt(req.getParameter("assignmentId"));
        AssignmentDao asDao = new AssignmentDao(ConnectionProvider.getConnection());
        Assignment assignmentById = asDao.getAssignmentById(assignmentId);

        if (assignmentById !=null){
            req.setAttribute("assignment", assignmentById);
            RequestDispatcher dispatcher = req.getRequestDispatcher("view_assignment.jsp");
            dispatcher.forward(req, resp);
        }

    }


}
