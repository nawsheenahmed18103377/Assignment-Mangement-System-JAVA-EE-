<%@ page import="edu.mgmt.entities.Message" %>

<%--<%@page import="com.tech.blog.entities.Message"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"> 
        <link href="css/mystyle.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    </head>
    <body class="primary-background" style="height: 100%">
        <!--navbar--> 
        <%@include file="primary_navbar.jsp" %>
        <main class="d-flex p-5 mt-3">
            <div class="container">
                <div class="row">
                    <div class="" style="margin: auto">
                        <div class="card" style="width: 400px;">
                            <div class="card-header primary-background text-white text-center">
                                <span class="fa fa-user-circle fa-3x"></span>
                                <br>
                                <p>User Login</p> 
                            </div>
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
                            <div class="card-body">
                                <form action="LoginServlet" method="POST">
                                    <div class="form-group">
                                        <label for="exampleUserName">Email address</label>
                                        <input name="name" required type="text" class="form-control" id="exampleUserName" placeholder=" username">
                                        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputPassword1">Password</label>
                                        <input name="password" required type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                                    </div>
                                    <div class="container text-center">
                                        <button type="submit" class="btn btn-primary primary-background">Submit</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div> 
            </div>
        </main>



        <!--javaScripts--> 
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script> 
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/myjs.js" type="text/javascript"></script>


    </body>
</html>

