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

public class ReviewAssignmentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer subAsId = Integer.valueOf(req.getParameter("subAsId"));
        SubmitedAssignmentDao subAsDao = new SubmitedAssignmentDao(ConnectionProvider.getConnection());
        SubmitedAssignment subAs = subAsDao.getSbuAsById(subAsId);

        if (subAs !=null){
            req.setAttribute("subAs", subAs);
            RequestDispatcher dispatcher = req.getRequestDispatcher("review_assignment.jsp");
            dispatcher.forward(req, resp);
        }




    }
}
