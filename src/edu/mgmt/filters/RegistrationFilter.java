package edu.mgmt.filters;


import edu.mgmt.entities.Message;
import edu.mgmt.entities.User;

import javax.servlet.*;
import java.io.IOException;

public class RegistrationFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        String fullName = request.getParameter("fullName");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
//        Integer userType = Integer.parseInt(request.getParameter("userType"));
        String depertment = request.getParameter("depertment");
        String details = request.getParameter("details");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        boolean nullCheck =  fullName==null || gender == null || address==null || depertment==null || details== null || userName==null || password==null;

        if (nullCheck){
            Message msg = new Message("Please fill all the fields in the form.", "warning", "alert-danger");
            request.setAttribute("msg", msg);
            RequestDispatcher dispatcher= request.getRequestDispatcher("registration.jsp");
            dispatcher.forward(request, response);
        }
        else
            {

            Integer userType = Integer.parseInt(request.getParameter("userType"));
            User user = new User(fullName, gender, address, depertment, details, userName, password, userType);
            request.setAttribute("user", user);
            filterChain.doFilter(request, response);

        }

    }

    @Override
    public void destroy() {

    }
}
