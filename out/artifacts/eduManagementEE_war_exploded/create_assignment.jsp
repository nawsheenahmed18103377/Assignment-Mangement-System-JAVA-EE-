<%@ page import="edu.mgmt.entities.Message" %>


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
    <div class="container-fluid"  style="border: 1px solid #062c33; border-radius:5px;">
        <div class="row">
            <div class="col-md-12 pt-3">
                <h4 style="color: #157347">Create Assignment</h4>
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
        <div class="row">
            <div class="col-md-12">
                <form id="assignment_form" class="px-5" method="post" action="SaveAssignmentServlet" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="assignmentName" style="font-size: 18px; font-weight: 400;">Assignment Name</label>
                        <input type="text" class="form-control" name="assignmentName" id="assignmentName" placeholder="Assignment Name" required>
                    </div>
                    <div class="form-group">
                        <label for="assignmentDetails" style="font-size: 18px; font-weight:400;">Assignment Details</label>
                        <textarea class="form-control" name="assignmentDetails" id="assignmentDetails" rows="3" placeholder="Details..." required></textarea>
                    </div>
                    <div class="form-group">
                        <label for="assignmentSubject" style="font-size: 18px; font-weight: 400;">Assignment Subject</label>
                        <input type="text" class="form-control" name="assignmentSubject" id="assignmentSubject" placeholder="Assignment Subject" required>
                    </div>
                    <div class="form-group">
                        <label for="publishedDate" style="font-size: 18px; font-weight: 400;">Published Date</label>
                        <input type="text" class="form-control" name="publishedDate" id="publishedDate" placeholder="YYYY/MM/DD" required>
                    </div>
                    <div class="form-group">
                        <label for="submitDate" style="font-size: 18px; font-weight: 400;">Submit Date</label>
                        <input type="text" class="form-control" name="submitDate" id="submitDate" placeholder="YYYY/MM/DD" required>
                    </div>
                    <div class="form-group">
                        <label for="fileChooser" style="font-size: 18px; font-weight: 400;">Choose file for assignment</label>
                        <input type="file" name="fileChooser" class="form-control-file" id="fileChooser" required>
                    </div>
                    <hr>
                    <div class="form-group text-center">
                        <button type="submit" class="btn btn-primary" style="font-size: 18px;">Create Assignment</button>
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
        $("#createassignment").addClass("active");
    });
</script>

<script>
    $( "#publishedDate" ).datepicker({ dateFormat: 'yy-mm-dd' });
    $( "#submitDate" ).datepicker({ dateFormat: 'yy-mm-dd' });
</script>

</body>

</html>