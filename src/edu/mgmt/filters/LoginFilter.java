package edu.mgmt.filters;

import edu.mgmt.dao.UserDao;
import edu.mgmt.entities.Message;
import edu.mgmt.entities.User;
import edu.mgmt.helper.ConnectionProvider;

import javax.servlet.*;
import java.io.IOException;
import java.sql.Connection;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        String userName = servletRequest.getParameter("name");
        String userPassword = servletRequest.getParameter("password");

        Connection con = ConnectionProvider.getConnection();
        UserDao userDao = new UserDao(con);
        User user = userDao.getUserByEmailAndPassword(userName, userPassword);

        if (user == null){

            Message msg=new Message("Invalid user email or password, please try again", "error", "alert-danger");
            servletRequest.setAttribute("msg",msg);
            RequestDispatcher reqDisp = servletRequest.getRequestDispatcher("login_page.jsp");
            reqDisp.include(servletRequest, servletResponse);

        }else{

        servletRequest.setAttribute("user", user);
        filterChain.doFilter(servletRequest, servletResponse);

        }


    }

    @Override
    public void destroy() {

    }
}
