package edu.mgmt.filters;


import edu.mgmt.entities.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class AuthorizationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);

        User user = (User)session.getAttribute("currentUser");


        ArrayList<String> studentURL = new ArrayList<>();
        studentURL.add("http://localhost:8080/StudentServlet");
        studentURL.add("http://localhost:8080/StudentAssignmentListServlet");
        studentURL.add("http://localhost:8080/DownloadAssignmentServlet");
        studentURL.add("http://localhost:8080/ViewAssignmentServlet");
        studentURL.add("http://localhost:8080/SubmitAssignmentServlet");
        studentURL.add("http://localhost:8080/SubmitedAssignmentsStudentServlet");
        studentURL.add("http://localhost:8080/DownloadSubmitedAssignmentServlet");
        studentURL.add("http://localhost:8080/IndividualMarkListServlet");

        ArrayList<String> teacherURL = new ArrayList<>();
        teacherURL.add("http://localhost:8080/TeacherServlet");
        teacherURL.add("http://localhost:8080/AllStudentsServlet");
        teacherURL.add("http://localhost:8080/CreateAssignmentServlet");
        teacherURL.add("http://localhost:8080/SaveAssignmentServlet");
        teacherURL.add("http://localhost:8080/AssignmentListServlet");
        teacherURL.add("http://localhost:8080/DownloadAssignmentServlet");
        teacherURL.add("http://localhost:8080/SubmitedAssignmentListServlet");
        teacherURL.add("http://localhost:8080/DownloadSubmitedAssignmentServlet");
        teacherURL.add("http://localhost:8080/ReviewAssignmentServlet");
        teacherURL.add("http://localhost:8080/SubmitMarkServlet");
        teacherURL.add("http://localhost:8080/AllStudentsMarkListServlet");


        String url = request.getRequestURL().toString();
        System.out.println("Req: "+url);
//            String queryString = ((HttpServletRequest)servletRequest).getQueryString();

        int temp=0;

        if (user.getType() == 0){
            for(String s: studentURL){
                System.out.println(s);
                if (s.equals(url)){
                    temp = 1;
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            }
        }else if (user.getType() == 1){
            for(String s: teacherURL){
                System.out.println(s);
                if (s.equals(url)){
                    temp = 1;
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            }
        }

        if(temp == 0){
            session.removeAttribute("currentUser");
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("404-page.jsp");
            dispatcher.forward(servletRequest, servletResponse);
        }





    }

    @Override
    public void destroy() {

    }
}
