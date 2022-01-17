package edu.mgmt.servlets;

import edu.mgmt.dao.UserDao;
import edu.mgmt.entities.Message;
import edu.mgmt.entities.User;
import edu.mgmt.helper.ConnectionProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getAttribute("user");

        Connection con = ConnectionProvider.getConnection();
        UserDao userDao = new UserDao(con);
        boolean isUserSaved = userDao.saveUser(user);
        if (isUserSaved){
            Message msg = new Message("Registration successfull.", "success", "alert-success");
            req.setAttribute("msg", msg);
            RequestDispatcher dispatcher = req.getRequestDispatcher("registration.jsp");
            dispatcher.forward(req, resp);
        }
        else {
            Message msg = new Message("Username already exists.", "error", "alert-warning");
            req.setAttribute("msg", msg);
            RequestDispatcher dispatcher = req.getRequestDispatcher("registration.jsp");
            dispatcher.forward(req, resp);



        }

    }
}
