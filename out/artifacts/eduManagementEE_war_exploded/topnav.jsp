<%@ page import="edu.mgmt.entities.User" %>
<%
    User u = (User) session.getAttribute("currentUser");
%>

<nav class="navbar navbar-expand-lg navbar-light fixed-top" style="background-color: #c2e4f3;">
    <div class="container-fluid">
        <a class="navbar-brand me-auto ms-lg-0 ms-3 fw-bold" href="#">Assignment Management System</a>
        <div class="nav navbar-nav navbar-right" id="navbar-menu">
            <div class="navbar-nav">
                <a href="#!" class="nav-item nav-link" data-toggle="modal" data-target="#profileModal"> <span class="fa fa-user-circle"></span> <%= u.getFullName() %> </a>
            </div>
            <div class="navbar-nav">
                <a href="LogoutServlet" class="nav-item nav-link"> <span class="bi bi-person-x-fill"></span> Log Out</a>
            </div>
        </div>
    </div>
</nav>