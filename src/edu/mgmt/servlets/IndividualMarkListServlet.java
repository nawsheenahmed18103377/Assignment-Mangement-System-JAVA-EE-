package edu.mgmt.servlets;

import edu.mgmt.dao.MarkDao;
import edu.mgmt.entities.Mark;
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

public class IndividualMarkListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("currentUser");


        MarkDao mDao = new MarkDao(ConnectionProvider.getConnection());
        ArrayList<Mark> marks = mDao.showAllMarkByUserId(user.getId());

        req.setAttribute("marks", marks);

        RequestDispatcher dispatcher = req.getRequestDispatcher("individual_mark_list.jsp");
        dispatcher.forward(req, resp);


    }
}
