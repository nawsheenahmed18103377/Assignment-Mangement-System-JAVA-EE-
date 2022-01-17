
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="f" %>--%>
<%@ page import="edu.mgmt.dao.AssignmentDao" %>
<%@ page import="edu.mgmt.helper.ConnectionProvider" %>
<%@ page import="edu.mgmt.entities.Assignment" %>
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


    <title>Student Dashboard</title>
</head>

<body>
<!-- top navigation bar -->
<%@include file="topnav.jsp"%>
<!-- top navigation bar -->


<!-- offcanvas -->
<%@include file="student_sidenav.jsp"%>
<!-- offcanvas -->


<main class="mt-5 pt-3 p-5 bg-light">
    <div class="row">
        <div class="col-md-12 mb-3">
            <div class="card">
                <div class="card-header">
                    <span><i class="bi bi-table me-2"></i></span> Assignment List
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <%
                            ArrayList<Assignment> assignments = (ArrayList<Assignment>) request.getAttribute("assignments");
                        %>
                        <table id="table" class="table table-striped data-table" style="width: 100%">
                            <thead>
                            <tr>
                                <th>As. ID</th>
                                <th>As. Name</th>
                                <th>As. Details</th>
                                <th>As. Sub</th>
                                <th>Pub. Date</th>
                                <th>Sub. Date</th>
                                <th>Download</th>
                                <th>View</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%
                                for (Assignment as: assignments){
                            %>
                                <tr>
                                        <td><%=as.getAssignmentId() %></td>
                                        <td><%=as.getAssignmentName() %></td>
                                        <td><%=as.getAssignmentDetails() %></td>
                                        <td><%=as.getAssignmentSubject() %></td>
                                        <td><%=as.getPublishedDate() %></td>
                                        <td><%=as.getSubmitDate() %></td>
                                        <%
                                            request.setAttribute("assignmentId", as.getAssignmentId());
                                        %>
                                    <td style="text-align: center"><a class="btn btn-primary" href="DownloadAssignmentServlet?assignmentId=<%=as.getAssignmentId() %>">Download</a></td>
                                    <td style="text-align: center">
                                        <form action="ViewAssignmentServlet" method="post">
                                            <input type="hidden" name="assignmentId" value="<%=as.getAssignmentId() %>" readonly>
                                            <input class="btn btn-primary" type="submit" value="View">
                                        </form>
                                    </td>
                                    <%--<td style="text-align: center"><a class="btn btn-primary" href="ViewAssignmentServlet?assignmentId=<%=as.getAssignmentId() %>">View</a></td>--%>
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
        $("#assignments").addClass("active");
    });


</script>

</body>

</html>


