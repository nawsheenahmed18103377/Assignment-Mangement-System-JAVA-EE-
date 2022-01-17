<%@ page import="edu.mgmt.entities.Message" %>
<%@ page import="edu.mgmt.entities.Assignment" %>
<%@ page import="edu.mgmt.entities.User" %>

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
    <div class="container-fluid"  style="border: 1px solid #062c33; border-radius:5px;">
        <div class="row">
            <div class="col-md-12 pt-3">
                <h4 style="color: #157347">View Assignment</h4>
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
            Assignment assignment = (Assignment) request.getAttribute("assignment");
            User user = (User) session.getAttribute("currentUser");
            Integer userId = user.getId();
        %>

        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <label for="assignmentName" style="font-size: 18px; font-weight:500;">Assignment Details: </label>
                    <input type="text" class="form-control" name="assignmentName" id="assignmentName" value="<%= assignment.getAssignmentName()%>" readonly>
                </div>
                <div class="form-group">
                    <label for="assignmentDetails" style="font-size: 18px; font-weight:500;">Assignment Details: </label>
                    <textarea class="form-control" name="assignmentDetails" id="assignmentDetails" rows="5" readonly><%= assignment.getAssignmentDetails()%></textarea>
                </div>
                <div class="form-group">
                    <label for="assignmentSubject" style="font-size: 18px; font-weight: 500;">Assignment Subject</label>
                    <input type="text" class="form-control" name="assignmentSubject" id="assignmentSubject" value="<%= assignment.getAssignmentSubject()%>" readonly>
                </div>
                <div class="form-group">
                    <label for="publishedDate" style="font-size: 18px; font-weight: 500;">Published Date</label>
                    <input type="text" class="form-control" name="publishedDate" id="publishedDate" value="<%= assignment.getPublishedDate()%>" readonly >
                </div>
                <div class="form-group">
                    <label for="submitDate" style="font-size: 18px; font-weight: 500;">Submit Date</label>
                    <input type="text" class="form-control" name="submitDate" id="submitDate" value="<%= assignment.getSubmitDate()%>" readonly >
                </div>
                <div class="form-group" style="text-align: center; font-size: 16px;">
                    <a class="btn btn-primary" href="DownloadAssignmentServlet?assignmentId=<%= assignment.getAssignmentId()%>">Download Assignment</a>
                </div>
                <hr>
                <form  method="post" action="SubmitAssignmentServlet" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="fileChooser" style="font-size: 20px; font-weight: 400;">Choose file (Assignment Submit)</label>
                        <input type="file" name="fileChoosers" class="form-control-file" id="fileChooser" required>
                        <input style="display: none" type="text" name="userId" value="<%=userId%>" readonly>
                        <input style="display: none" type="text" name="assignmentId" value="<%=assignment.getAssignmentId()%>" readonly>
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

    // function processAjaxData(response, urlPath){
    //     document.getElementById("content").innerHTML = response.html;
    //     document.title = response.pageTitle;
    //     window.history.pushState({"html":response.html,"pageTitle":response.pageTitle},"", urlPath);
    // }

    $(document).ready(function () {
        $("#assignments").addClass("active");
    });


</script>

</body>

</html>


