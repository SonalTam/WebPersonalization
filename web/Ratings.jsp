<%-- 
    Document   : Ratings
    Created on : Mar 9, 2017, 6:41:38 AM
    Author     : Kruthi Mohan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">  
         <% String Uid = session.getAttribute("userid").toString(); %>
        <title>Ratings</title>
    </head>
    <body>
        
        <div-1 background="#000000">
            <h1>My Rating(s) </h1>
        
        <ul style="font-size:20px">
            <li><a-text>Welcome ${username}</a-text></li>
            <li><a href="Welcome.jsp">Home</a></li>
            <li style="float:right" action="Logout"><a href="#" >Sign-out</a></li>
            <li style="float:right"><a href="Ratings.jsp">MyRatings</a></li>
            <li style="float:right"><a href="UserProfile.jsp">MyProfile</a></li>
        </ul>
        </div-1>
        
        
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
           
            String q2 = "select title, rating, imdbPictureURL from Movies join User_Ratedmovies on Movies.id = User_Ratedmovies.movieID where userID in ("+Uid+") order by rating desc";
           st2 = con.createStatement();
            ResultSet rs2 = st2.executeQuery(q2);
                      
          %>  
          <div class="profile-page" align="Left">
              <div class="profile-form">
              <table border="1" cellpadding="5">
              <caption> <h1> My Ratings </h1></caption>
              <tr bgcolor="#A52A2A">
               <td><b>Movie</b></td>
               <td><b>Rating</b></td>
               <td><b>Poster</b></td>
              </tr>
                  <%
while( rs2.next() ){
%> 
                  
                      <tr>
                         <td><%= rs2.getString("title") %></td>                          
                         <td><%= rs2.getString("rating") %></td>
                         <td><img src = "<% out.println(rs2.getString(3)); %>" alt="Movie Link not working" style="width:200px;height:200px;"></td>
                         
                      </tr>                     
                  
                  <%
                      }
%>
          </div>
          </div>
    </body>
</html>
