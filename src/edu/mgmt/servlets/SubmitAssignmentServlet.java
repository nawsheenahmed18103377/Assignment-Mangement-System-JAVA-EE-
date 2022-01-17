package edu.mgmt.servlets;

import edu.mgmt.dao.SubmitedAssignmentDao;
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

@MultipartConfig
public class SubmitAssignmentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer userId = Integer.valueOf(req.getParameter("userId"));
        Integer assignmentId = Integer.valueOf(req.getParameter("assignmentId"));
        Part file = req.getPart("fileChoosers");
        String fileName = file.getSubmittedFileName();
        String assignmentFilePath = FileConfig.submitedAssignmentDirectory + fileName;

        boolean nullCheck = userId==null || assignmentId==null || assignmentFilePath==null;
        if (nullCheck){
            Message msg = new Message("Please fill all the fields in the form.", "warning", "alert-danger");
            req.setAttribute("msg", msg);
            RequestDispatcher dispatcher= req.getRequestDispatcher("/ViewAssignmentServlet");
            dispatcher.forward(req, resp);
        }

        SubmitedAssignmentDao subAsDao = new SubmitedAssignmentDao(ConnectionProvider.getConnection());
        boolean isAsAlrdSubmited = subAsDao.isAssignmentAlreadySubmited(userId, assignmentId);
        if(isAsAlrdSubmited){
            Message msg = new Message("Assignment Already Submited.", "error", "alert-warning");
            req.setAttribute("msg", msg);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/ViewAssignmentServlet");
            dispatcher.forward(req, resp);
        }else {
            boolean isSubAsSaved = subAsDao.saveSubmitedAssignment(userId, assignmentId, assignmentFilePath);
            FileUtil fileUtil = new FileUtil(FileConfig.submitedAssignmentDirectory);
            boolean isFileSave = fileUtil.saveFile(assignmentFilePath, file);

            if (isSubAsSaved && isFileSave) {
                Message msg = new Message("Assignment submited successfully.", "success", "alert-success");
                req.setAttribute("msg", msg);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/ViewAssignmentServlet");
                dispatcher.forward(req, resp);
            } else {
                Message msg = new Message("Assignment submition unsuccessfull.", "error", "alert-warning");
                req.setAttribute("msg", msg);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/ViewAssignmentServlet");
                dispatcher.forward(req, resp);
            }
        }



    }
}
