<%@ page import="edu.mgmt.entities.Message" %>
<%@ page import="edu.mgmt.entities.User" %>
<%@ page import="edu.mgmt.entities.SubmitedAssignment" %>

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


    <title>Teacher Dashboard || Review Assignment</title>
</head>

<body>
<!-- top navigation bar -->
<%@include file="topnav.jsp"%>
<!-- top navigation bar -->


<!-- offcanvas -->
<%@include file="teacher_sidenav.jsp"%>
<!-- offcanvas -->



<main class="mt-5 pt-3 p-5 bg-light">
    <div class="container-fluid"  style="border: 1px solid #062c33; border-radius:5px;">
        <div class="row">
            <div class="col-md-12 pt-3">
                <h4 style="color: #157347">Review Assignment</h4>
            </div>
        </div>
        <hr>
        <%
            Message m = (Message) request.getAttribute("msg");
            if (m != null) {
        %>
        <div class="alert <%= m.getCssClass() %>  " role="alert">
            <%= m.getContent() %>
        </div>
        <%
                request.removeAttribute("msg");
            }
        %>

        <%
            SubmitedAssignment subAs = (SubmitedAssignment) request.getAttribute("subAs");
//            User user = (User) session.getAttribute("currentUser");
//            Integer userId = user.getId();
        %>

        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <label for="userName" style="font-size: 18px; font-weight:500;">Student Name: </label>
                    <input type="text" class="form-control" name="userName" id="userName" value="<%= subAs.getStudentName()%>" readonly>
                </div>
                <div class="form-group">
                    <label for="userId" style="font-size: 18px; font-weight:500;">Student Name: </label>
                    <input type="text" class="form-control" name="userId" id="userId" value="<%= subAs.getStudentID()%>" readonly>
                </div>
                <div class="form-group">
                    <label for="assignmentName" style="font-size: 18px; font-weight:500;">Assignment Name: </label>
                    <input type="text" class="form-control" name="assignmentName" id="assignmentName" value="<%= subAs.getAssignmentName()%>" readonly>
                </div>
                <div class="form-group">
                    <label for="assignmentDetails" style="font-size: 18px; font-weight:500;">Assignment Details: </label>
                    <textarea class="form-control" name="assignmentDetails" id="assignmentDetails" rows="5" readonly><%= subAs.getAssignmentDetails() %></textarea>
                </div>
                <div class="form-group">
                    <label for="publishedDate" style="font-size: 18px; font-weight: 500;">Published Date</label>
                    <input type="text" class="form-control" name="publishedDate" id="publishedDate" value="<%= subAs.getPublishDate()%>" readonly >
                </div>
                <div class="form-group">
                    <label for="submitDate" style="font-size: 18px; font-weight: 500;">Submit Date</label>
                    <input type="text" class="form-control" name="submitDate" id="submitDate" value="<%= subAs.getSubmitDate()%>" readonly >
                </div>
                <div class="form-group" style="text-align: center; font-size: 16px;">
                    <a class="btn btn-primary" href="DownloadSubmitedAssignmentServlet?subAsId=<%=subAs.getSubmitedAssignmentId() %>">Download Assignment</a>
                </div>
                <hr>
                <form  method="post" action="SubmitMarkServlet">
                    <div class="form-group">
                        <label for="mark" style="font-size: 20px; font-weight: 400;">Give Marks</label>
                        <input type="number" placeholder="Mark" name="mark" class="form-control-file" id="mark" required>
                        <input style="display: none" type="text" name="subAsId" value="<%=subAs.getSubmitedAssignmentId()%>" readonly>
                    </div>
                    <div class="form-group text-center">
                        <button type="submit" class="btn btn-primary" style="font-size: 16px;">Submit Assignment</button>
                    </div>
                </form>
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
        $("#subas").addClass("active");
    });
</script>

</body>

</html>

