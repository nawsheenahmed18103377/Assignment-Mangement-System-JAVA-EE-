package edu.mgmt.servlets;

import edu.mgmt.dao.AssignmentDao;
import edu.mgmt.dao.SubmitedAssignmentDao;
import edu.mgmt.helper.ConnectionProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class DownloadSubmitedAssignmentServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int subAsId = Integer.parseInt(req.getParameter("subAsId"));
        SubmitedAssignmentDao asDao = new SubmitedAssignmentDao(ConnectionProvider.getConnection());
        String assignmentFilePathById = asDao.getAssignmentFilePathById(subAsId);
        resp.setContentType("APPLICATION/OCTET-STREAM");
        String filename = assignmentFilePathById.substring(assignmentFilePathById.lastIndexOf("/")+1);
        resp.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");

        FileInputStream fileInputStream = new FileInputStream(assignmentFilePathById);
        PrintWriter out = resp.getWriter();

        int i;
        while ((i=fileInputStream.read()) != -1) {
            out.write(i);
        }
        fileInputStream.close();
        out.close();
    }
    
}
