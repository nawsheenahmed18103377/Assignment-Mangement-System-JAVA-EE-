package edu.mgmt.servlets;

import edu.mgmt.dao.MarkDao;
import edu.mgmt.dao.SubmitedAssignmentDao;
import edu.mgmt.entities.Mark;
import edu.mgmt.entities.Message;
import edu.mgmt.entities.SubmitedAssignment;
import edu.mgmt.helper.ConnectionProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class SubmitMarkServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection con = ConnectionProvider.getConnection();

        int mark = Integer.valueOf(req.getParameter("mark"));
        Integer subAsId = Integer.valueOf(req.getParameter("subAsId"));

        SubmitedAssignmentDao subAsDao = new SubmitedAssignmentDao(con);
        SubmitedAssignment subAs = subAsDao.getSbuAsById(subAsId);

        Integer studentID = subAs.getStudentID();
        String studentName = subAs.getStudentName();
        Integer assignmentId = subAs.getAssignmentNo();
        String assignmentName = subAs.getAssignmentName();

        Mark markOb= new Mark(studentID, studentName, assignmentId, assignmentName,mark);
        MarkDao markDao = new MarkDao(con);
        boolean isMarkGiven = markDao.isMarkAlreadyGiven(studentID, assignmentId);
        if (isMarkGiven){
            Message msg = new Message("Mark is already given.", "error", "alert-warning");
            req.setAttribute("msg", msg);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/ReviewAssignmentServlet");
            dispatcher.forward(req, resp);
        }else {

            boolean isMarkSave = markDao.saveMark(markOb);
            if (isMarkSave){
                Message msg = new Message("Mark assigned successfully.", "success", "alert-success");
                req.setAttribute("msg", msg);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/ReviewAssignmentServlet");
                dispatcher.forward(req, resp);
            }else {
                Message msg = new Message("Mark assigned unsuccessfull.", "error", "alert-warning");
                req.setAttribute("msg", msg);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/ReviewAssignmentServlet");
                dispatcher.forward(req, resp);
            }

        }

    }
}
