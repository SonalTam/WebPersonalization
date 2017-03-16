<%-- 
    Document   : MovieDetails
    Created on : Mar 13, 2017, 2:01:17 PM
    Author     : Lavanya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1> Movie Details</h1>
        
         <%@page import="java.sql.*" %>
        <%@page import ="java.util.*"%>
        <%@page import ="javax.sql.*"%>
        <%@page import="java.util.Map.Entry"%>
        
        <%       
            String movieid = request.getParameter("movieid");
            String mid = movieid;
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                String url = "jdbc:sqlserver://localhost:1433;databaseName=MovieDatabasev";
                String user = "sa";
                String pass = "sa";

                Class.forName(driver);
                java.sql.Connection con = DriverManager.getConnection(url, user, pass);
                Statement st1 = con.createStatement();
                Statement std = con.createStatement();
                Statement sta = con.createStatement();
                ResultSet rs1 = st1.executeQuery("select ID, title, imdbPictureURL, year, rtAllCriticsRating  from Movies where id in ("+mid+")" );
                ResultSet rsd = std.executeQuery("select directorName from Movie_Directors where movieID in ("+mid+")" );
                ResultSet rsa = sta.executeQuery("select top 8 actorName from Movie_Actors where movieID in ("+mid+") order by ranking asc");
                %>
                <table border="1"><tr>
                <%
               if (rsd.next())
               {
                   System.out.println("Have Director"); 
               }
               if (rsa.next())
               {
                   System.out.println("Have Actors"); 
               }
                if(rs1.next())    
                {
                %>
                
                <td><a href="MovieDetails.jsp?movieid=<% out.println(rs1.getString(1)); %>"><img src = "<% out.println(rs1.getString(3)); %>" alt="Movie Link not working" style="width:200px;height:300px;"> <br>
                    </a></td>
                    <td> 
                        <table>
                            <tr>
                                <td>
                                    <h1><font color="darkyellow"><%out.println(rs1.getString(2)); %> (<%out.println(rs1.getString(4));%>) </font></h1>
                                </td>

                            </tr>
                            <tr>
                                <td>
                                Rotten Tomatoes Rating : <%out.println(rs1.getString(5)); %> / 10.0  
                                </td>
                            </tr>
                            <tr>
                                <td>
                  
                                Director : <%out.println(rsd.getString(1)); %> 
                                </td>
                            </tr>
                            <tr>
                                <td>
                                Actors : <%while (rsa.next())
                                {out.println(rsa.getString(1)); %>,<% }%>
                                </td>
                            </tr>
                            
                        </table> 
                    </td>
                <%}%>
                </tr></table>

        
    </body>
</html>
