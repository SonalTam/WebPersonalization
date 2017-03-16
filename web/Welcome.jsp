<%-- 
    Document   : Welcome
    Created on : Feb 19, 2017, 12:33:22 PM
    Author     : Lavanya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" href="menu.css">  
        <title>Welcome Page</title>
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
    </head>
    <body>
        
        <% 
            if(session.getAttribute("username")==null)
            {
                response.sendRedirect("Login.jsp");
            }
        %>
        <div>
            <h1>Movie Recommendation(s) </h1>
        
        <ul style="font-size:20px">
            <li><a-text>Welcome ${username}</a-text></li>
            <li><a href="Welcome.jsp">Home</a></li>
        <li style="float:right"><form action="Logout"><a>Sign-out</a></form></li>
            <li style="float:right"><a href="Ratings.jsp">MyRatings</a></li>
            <li style="float:right"><a href="UserProfile.jsp">MyProfile</a></li>
        </ul>
        </div>
            
        <% String Uid = session.getAttribute("userid").toString(); %>
        <form method="get" action="Login.jsp">
        
            <%@page import ="java.util.*"%>
            <%@page import ="javax.sql.*"%>
            <%@page import="java.util.Map.Entry"%>
            <%@page import="java.sql.*"%>
            <%
                String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                String url = "jdbc:sqlserver://localhost:1433;databaseName=MovieDatabasev";
                String user = "sa";
                String pass = "sa";

                Class.forName(driver);
                java.sql.Connection con = DriverManager.getConnection(url, user, pass);
                Statement st1 = con.createStatement();
                ResultSet rs1 = st1.executeQuery("select top 8 rating, imdbPictureURL from Movies join User_Ratedmovies on Movies.id = User_Ratedmovies.movieID where userID in ("+Uid+") order by rating desc" );
                %>
               <br>
               <h1> Top 8 movies </h1><br>
                <table border="1"><tr>
                <%
                rs1 = st1.executeQuery("select top 8 movieID, rating, imdbPictureURL from Movies join User_Ratedmovies on Movies.id = User_Ratedmovies.movieID where userID in ("+Uid+") order by rating desc" );
                while(rs1.next())    
                {
                %>
                
                <td><a href="MovieDetails.jsp?movieid=<% out.println(rs1.getString(1)); %>"><img src = "<% out.println(rs1.getString(3)); %>" alt="Movie Link not working" style="width:162px;height:200px;"> <br>
                        Your Rating: <%out.println(rs1.getString(2)); %> /5.0  </a></td>
                <%}%>
                </tr></table>
        </form>
        
    </body>
</html>
