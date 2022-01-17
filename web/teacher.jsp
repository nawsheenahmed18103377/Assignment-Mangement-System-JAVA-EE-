<%@ page import="edu.mgmt.entities.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    User user = (User) session.getAttribute("currentUser");
    if (user == null){
        response.sendRedirect("/LoginServlet");
    }
%>

<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/bootstrap02.min.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/dataTables.bootstrap5.min.css" />
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/mystyle.css"/>
    <link rel="stylesheet" href="css/jquery-ui.css"/>
    <script src="./js/jquery-3.5.1.js"></script>
    <script src="./js/jquery-ui.js"></script>


    <title>Teacher Dashboard</title>
</head>

<body>
<!-- top navigation bar -->
<%@include file="topnav.jsp"%>
<!-- top navigation bar -->


<!-- offcanvas -->
<%@include file="teacher_sidenav.jsp"%>
<!-- offcanvas -->






<main class="mt-5 pt-3">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <h4>Dashboard</h4>
            </div>
            <hr>
        </div>
        <%
            int noOfStudent = (int) session.getAttribute("noOfStudent");
            int noOfAssaignment = (int) session.getAttribute("noOfAssaignment");
            int noOfSubAs = (int) session.getAttribute("noOfSubAs");
        %>
        <div class="row">
            <div class="col-md-4 mb-3">
                <div class="card text-white bg-info "style="text-align: center">
                    <div class="card-header" >Total</div>
                    <div class="card-body">
                        <h5 class="card-title"><%=noOfStudent%></h5>
                        <p class="card-text">Students</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4 mb-3">
                <div class="card text-white bg-danger " style="text-align: center">
                    <div class="card-header">Total</div>
                    <div class="card-body">
                        <h5 class="card-title"><%= noOfAssaignment %></h5>
                        <p class="card-text"> Assignments </p>
                    </div>
                </div>
            </div>
            <div class="col-md-4 mb-3">
                <div class="card text-white bg-warning" style="text-align: center">
                    <div class="card-header">Total</div>
                    <div class="card-body">
                        <h5 class="card-title"><%= noOfSubAs %></h5>
                        <p class="card-text"> Submited Assignments</p>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <div class="card h-100">
                    Area Chart Example
                </div>
            </div>
            <div class="col-md-6 mb-3">
                <div class="card h-100">
                    Area Chart Example
                </div>
            </div>
        </div>
    </div>
</main>





<script src="./js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@3.0.2/dist/chart.min.js"></script>
<script src="./js/jquery.dataTables.min.js"></script>
<script src="./js/dataTables.bootstrap5.min.js"></script>
<script src="./js/script.js"></script>

<script>

</script>

</body>

</html>
