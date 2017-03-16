<%-- 
    Document   : Login
    Created on : Feb 19, 2017, 12:14:19 PM
    Author     : Lavanya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">  
        <title>Login</title>
    </head>
    <body>
        <div class="login-page">
            <div class="form">
                <form name="Login" method="get" action="Login">
                    <h1><i>Login</i></h1>  
                    <input type="text" name="uname" placeholder="Username"> <br>
                    <input type="password" name="pwd" placeholder="Password"> <br>
                    <button>Login</button><br>
                    <error> Its an error </error>
                </form>
                          <p>Forgot Password?<a href="#"> Click here</a></p>
                          <p>Not registered? <a href="#">Create an account</a></p>
          </div>  
        </div>
    </body>
</html>
