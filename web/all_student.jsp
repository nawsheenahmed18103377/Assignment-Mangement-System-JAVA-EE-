<%@ page import="edu.mgmt.entities.User" %>
<%@ page import="java.util.ArrayList" %>
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




<main class="mt-5 pt-3 p-5 bg-light">
    <div class="row">
        <div class="col-md-12 mb-3">
            <div class="card">
                <div class="card-header">
                    <span><i class="bi bi-table me-2"></i></span>  All Student
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <%
                            ArrayList<User> students = (ArrayList<User>) request.getAttribute("allStudents");
                        %>
                        <table id="table" class="table table-striped data-table" style="width: 100%">
                            <thead>
                            <tr>
                                <th>Student Name</th>
                                <th>Student ID</th>
                                <th>Gender</th>
                                <th>Depertment</th>
                                <th>Details</th>
                                <th>Address</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%
                                for (User s: students){
                            %>
                            <tr>
                                <td><%= s.getFullName()  %></td>
                                <td><%= s.getId() %></td>
                                <td><%= s.getGender() %></td>
                                <td><%= s.getDepartment() %></td>
                                <td><%= s.getDetails() %></td>
                                <td><%= s.getAddress() %></td>
                            </tr>
                            <%
                                }
                            %>
                            </tbody>
                        </table>
                    </div>
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
    $(document).ready(function () {
        $("#allstudent").addClass("active");
    });
</script>

</body>

</html>
