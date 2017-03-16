<%-- 
    Document   : UserProfile
    Created on : Mar 8, 2017, 8:10:52 PM
    Author     : Kruthi Mohan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">  
        <% String Uid = session.getAttribute("userid").toString(); %>
        
               <style>
           ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
                overflow: hidden;
                background-color: #333;
            }

            li {
                float: left;
            }

            li a {
                display: block;
                color: white;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }
            
            li a-text {
                display: block;
                color: white;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }

            li a:hover:not(.active) {
                background-color: #111;
            }

            .active {
                background-color: #4CAF50;
            } 
       </style>

        <title>User Profile</title>
    </head>
    <body>
        <h1> My Profile </h1>
        <ul style="font-size:20px">
            <li><a-text>Welcome ${username}</a-text></li>
            <li><a href="Welcome.jsp">Home</a></li>
            <li style="float:right" action="Logout"><a href="#" >Sign-out</a></li>
            <li style="float:right"><a href="Ratings.jsp">MyRatings</a></li>
            <li style="float:right"><a href="UserProfile.jsp">MyProfile</a></li>
        </ul>
        <%@page import="java.sql.*" %>
        <%@page import ="java.util.*"%>
        <%@page import ="javax.sql.*"%>
        <%@page import="java.util.Map.Entry"%>
         
        <%       
             
            java.sql.Connection con;
            java.sql.Statement st2;
            con=null;
            
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=MovieDatabasev;user=sa;password=sa";
           try
           {Class.forName(driver);
            con = java.sql.DriverManager.getConnection(url);
           }
           catch(ClassNotFoundException cnfex){
                cnfex.printStackTrace();}
           String q2 = "select username,userpass,secret_question1,answer1,secret_question2,answer2 from Userdetails where userid in ("+Uid+")";
           st2 = con.createStatement();
            ResultSet rs2 = st2.executeQuery(q2);
                      
          %>  
       
          <div class="profile-page" align="Left">
              <div class="profile-form">
              <table border="1" cellpadding="5">
              <caption> <h1> My Details </h1></caption>
                <%
                while( rs2.next() ){
                %> 
                  
                      <tr>
                          <td>Username</td>
                          <td><%= rs2.getString("username") %></td>
                          
                      </tr>
                      <tr>
                          <td>Password</td>
                          <td><%= rs2.getString("userpass") %></td>
                          <td><a href="ChangePassword.jsp">Change Password</a></td>
                      </tr>
                      <tr>
                          <td>Secret Question #1 </td>
                          <td><%= rs2.getString("secret_question1") %></td>
                      </tr>
                      
                      <tr>
                          <td>Answer</td>
                        <td><%= rs2.getString("answer1") %></td>  
                      </tr>
                      <tr>
                          <td>Secret Question #2 </td>
                          <td><%= rs2.getString("secret_question2") %></td>
                      </tr>
                      
                      <tr>
                          <td>Answer</td>
                          <td><%= rs2.getString("answer2") %></td>
                      </tr>                      
                  
                  <%
                      }
%>
          </div>
          
          </div>
          <div> <a href= "Ratings.jsp">Ratings</a> </div>
          
    </body>
</html>
