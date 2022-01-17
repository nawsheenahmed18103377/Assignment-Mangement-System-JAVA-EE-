package edu.mgmt.servlets;

import edu.mgmt.entities.Message;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession session = req.getSession();
        session.removeAttribute("currentUser");

        Message msg=new Message("Successfully Logout.", "success", "alert-success");
        session.setAttribute("msg", msg);
        RequestDispatcher dispatcher = req.getRequestDispatcher("login_page.jsp");
        dispatcher.forward(req, resp);


    }
}
