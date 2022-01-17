package edu.mgmt.servlets;

import edu.mgmt.dao.SubmitedAssignmentDao;
import edu.mgmt.entities.SubmitedAssignment;
import edu.mgmt.entities.User;
import edu.mgmt.helper.ConnectionProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class SubmitedAssignmentsStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("currentUser");

        SubmitedAssignmentDao subAsDao = new SubmitedAssignmentDao(ConnectionProvider.getConnection());
        ArrayList<SubmitedAssignment> subAsByUserId = subAsDao.getSubmitedAssignmentByUserId(user.getId());
        req.setAttribute("subAsByUserId", subAsByUserId);

        RequestDispatcher dispatcher = req.getRequestDispatcher("submited_assignments_student.jsp");
        dispatcher.forward(req, resp);
//        resp.sendRedirect("submited_assignments_student.jsp");

    }
}
