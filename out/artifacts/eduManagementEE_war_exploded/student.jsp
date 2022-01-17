<%@ page import="edu.mgmt.entities.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    User user = (User) session.getAttribute("currentUser");
    if (user == null){
        response.sendRedirect("login_page.jsp");
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


    <title>Student Dashboard</title>
</head>

<body>
<!-- top navigation bar -->
<%@include file="topnav.jsp"%>
<!-- top navigation bar -->


<!-- offcanvas -->
<%@include file="student_sidenav.jsp"%>
<!-- offcanvas -->


<div id="container_body">

</div>


<script src="./js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@3.0.2/dist/chart.min.js"></script>
<script src="./js/jquery.dataTables.min.js"></script>
<script src="./js/dataTables.bootstrap5.min.js"></script>
<script src="./js/script.js"></script>

<script>

    // function processAjaxData(response, urlPath){
    //     document.getElementById("content").innerHTML = response.html;
    //     document.title = response.pageTitle;
    //     window.history.pushState({"html":response.html,"pageTitle":response.pageTitle},"", urlPath);
    // }

    $(document).ready(function () {
        $("#container_body").hide();
        $("#assignments").click(function(){

            $("#container_body").show();
            $("#container_body").load("student_assignment_list.jsp");
            // window.history.pushState('page2', 'Title', '/create_assignment');
        });
        $("#viewassignments").click(function(){
            $("#container_body").show();
            $("#container_body").load("");
        });

    });


</script>

</body>

</html>
