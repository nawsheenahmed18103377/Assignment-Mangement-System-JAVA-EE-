<%@ page import="edu.mgmt.entities.Message" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/bootstrap02.min.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" />
    <link rel="stylesheet" href="css/dataTables.bootstrap5.min.css" />
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/mystyle.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body class="primary-background" style="height: 100%">
<!--navbar-->
<%@include file="primary_navbar.jsp" %>


<section class="h-100 primary-background">
    <form method="post" action="RegistrationServlet">
        <div class="container pt-5 h-100" style="padding-left: 250px; padding-right: 250px;">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col" style="min-width:400px;">
                    <div class="card card-registration my-4">
                        <div class="row g-0" >
                            <div class="col-md-12" >
                                <div class="card-body p-md-5 text-black">
                                    <h4 class="mb-2">Registration </h4>
                                    <hr class="mb-4">
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
                                        <div class="col-md-12 mb-4">
                                            <div class="form-outline">
                                                <input type="text" name="fullName" id="fullName" class="form-control form-control-lg " required />
                                                <label class="form-label" for="fullName">Full Name</label>
                                            </div>
                                        </div>
                                    </div>.

                                    <div class="d-md-flex justify-content-start align-items-center mb-4 py-2">

                                        <h6 class="mb-0 me-4">Gender: </h6>

                                        <div class="form-check form-check-inline mb-0 me-4">
                                            <input
                                                    class="form-check-input"
                                                    type="radio"
                                                    name="gender"
                                                    id="maleGender"
                                                    value="MALE"
                                                    required
                                            />
                                            <label class="form-check-label" for="maleGender">Female</label>
                                        </div>

                                        <div class="form-check form-check-inline mb-0 me-4">
                                            <input
                                                    class="form-check-input"
                                                    type="radio"
                                                    name="gender"
                                                    id="femaleGender"
                                                    value="FEMALE"
                                            />
                                            <label class="form-check-label" for="femaleGender">Male</label>
                                        </div>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input type="text" id="address" name="address" class="form-control form-control-lg " required />
                                        <label class="form-label" for="address">Address</label>
                                    </div>


                                    <div class="row">
                                        <div class="col-md-12 mb-4">

                                            <select class="select" name="userType" style="padding: 10px ; border: 1px solid #DCDCDC; border-radius: 5px;" required>
                                                <option value="0">Student</option>
                                                <option value="1">Teacher</option>
                                            </select>

                                        </div>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input type="text" name="depertment" id="depertment" class="form-control form-control-lg " required />
                                        <label class="form-label" for="depertment">Depertment</label>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input type="text" name="details" id="details" class="form-control form-control-lg " required />
                                        <label class="form-label" for="details">Details</label>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input type="text" name="userName" id="userName" class="form-control form-control-lg " required />
                                        <label class="form-label" for="userName">Username</label>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input type="text" name="password" id="password" class="form-control form-control-lg " required />
                                        <label class="form-label" for="password">Password</label>
                                    </div>

                                    <div class="d-flex justify-content-end pt-3">
                                        <button type="reset" class="btn btn-light btn-lg" style="border: 1px solid #c69500">Clear</button>
                                        <button type="submit" class="btn btn-warning btn-lg ms-2">Submit</button>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</section>



<!--javaScripts-->

<script>
    // function clr() {
    //     var elements = [] ;
    //     elements = document.getElementsByClassName("clr");
    //     for(var i=0; i<elements.length ; i++){
    //         elements[i].value = "" ;
    //     }
    // }
</script>

<script src="./js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@3.0.2/dist/chart.min.js"></script>
<script src="./js/jquery-3.5.1.js"></script>
<script src="./js/jquery.dataTables.min.js"></script>
<script src="./js/dataTables.bootstrap5.min.js"></script>
<script src="./js/script.js"></script>


</body>
</html>

