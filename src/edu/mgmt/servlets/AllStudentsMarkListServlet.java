package edu.mgmt.servlets;

import edu.mgmt.dao.MarkDao;
import edu.mgmt.entities.Mark;
import edu.mgmt.helper.ConnectionProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AllStudentsMarkListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        MarkDao mDao = new MarkDao(ConnectionProvider.getConnection());
        ArrayList<Mark> marks = mDao.showAllMark();
        req.setAttribute("marks", marks);

        RequestDispatcher dispatcher = req.getRequestDispatcher("all_student_mark_list.jsp");
        dispatcher.forward(req, resp);


    }
}
