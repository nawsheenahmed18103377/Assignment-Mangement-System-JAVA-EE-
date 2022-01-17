package edu.mgmt.servlets;

import edu.mgmt.dao.AssignmentDao;
import edu.mgmt.entities.Assignment;
import edu.mgmt.entities.Message;
import edu.mgmt.helper.ConnectionProvider;
import edu.mgmt.util.FileConfig;
import edu.mgmt.util.FileUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.time.LocalDate;

@MultipartConfig
public class SaveAssignmentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String assignmentName = req.getParameter("assignmentName");
        String assignmentDetails = req.getParameter("assignmentDetails");
        String assignmentSubject = req.getParameter("assignmentSubject");
        LocalDate publishedDate = LocalDate.parse(req.getParameter("publishedDate"));
        LocalDate submitDate = LocalDate.parse(req.getParameter("submitDate"));
        Part file = req.getPart("fileChooser");
        String fileName = file.getSubmittedFileName();
        String assignmentFilePath = FileConfig.assignmentDirectory +fileName;

        boolean nullCheck = assignmentName==null || assignmentDetails==null || assignmentSubject==null || assignmentFilePath==null || publishedDate==null || submitDate==null;

        if (nullCheck){
            Message msg = new Message("Please fill all the fields in the form.", "warning", "alert-danger");
            req.setAttribute("msg", msg);
            RequestDispatcher dispatcher= req.getRequestDispatcher("CreateAssignmentServlet");
            dispatcher.forward(req, resp);
        }

        Assignment assignment = new Assignment(assignmentName, assignmentDetails, assignmentSubject, assignmentFilePath, publishedDate, submitDate);
        Connection con = ConnectionProvider.getConnection();
        AssignmentDao assignmentDao = new AssignmentDao(con);
        boolean isAssignmentSaved = assignmentDao.saveAssignment(assignment);
        FileUtil fileUtil= new FileUtil(FileConfig.assignmentDirectory);
        boolean isFileSaved = fileUtil.saveFile(assignment.getAssignmentFilePath(), file);

        if (isAssignmentSaved && isFileSaved){
                Message msg = new Message("Assignment created successfully.", "success", "alert-success");
                req.setAttribute("msg", msg);
                RequestDispatcher dispatcher = req.getRequestDispatcher("CreateAssignmentServlet");
                dispatcher.forward(req, resp);
        }else {
            Message msg = new Message("Assignment creation unsuccessfull.", "error", "alert-warning");
            req.setAttribute("msg", msg);
            RequestDispatcher dispatcher = req.getRequestDispatcher("CreateAssignmentServlet");
            dispatcher.forward(req, resp);
        }

    }
}
