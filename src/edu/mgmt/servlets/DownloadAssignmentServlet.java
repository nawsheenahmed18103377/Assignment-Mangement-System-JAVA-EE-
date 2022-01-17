package edu.mgmt.servlets;

import edu.mgmt.dao.AssignmentDao;
import edu.mgmt.helper.ConnectionProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class DownloadAssignmentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int assignmentId = Integer.parseInt(req.getParameter("assignmentId"));
        AssignmentDao asDao = new AssignmentDao(ConnectionProvider.getConnection());
        String assignmentFilePath = asDao.getAssignmentFilePathById(assignmentId);
        resp.setContentType("APPLICATION/OCTET-STREAM");
        String filename = assignmentFilePath.substring(assignmentFilePath.lastIndexOf("/")+1);
        resp.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");

        FileInputStream fileInputStream = new FileInputStream(assignmentFilePath);
        PrintWriter out = resp.getWriter();

        int i;
        while ((i=fileInputStream.read()) != -1) {
            out.write(i);
        }
        fileInputStream.close();
        out.close();
    }

}
