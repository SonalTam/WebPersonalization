<%-- 
    Document   : Usersignup
    Created on : Mar 6, 2017, 5:49:03 AM
    Author     : Sonal
--%>

<%@page import="org.apache.catalina.User"%>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@page import="java.sql.*" %>
        <%@page import ="java.util.*"%>
        <%@page import ="javax.sql.*"%>
        <%@page import="java.util.Map.Entry"%>
        <% 
            try {
            Connection conn = null;
         Statement stmt = null;
         ResultSet rs = null;
         String UserName1 = request.getParameter("UName");      
         System.out.print(UserName1);
       String url= "jdbc:sqlserver://localhost:1433;databaseName=Capstone-Movie";
            String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String username ="sa";
            Class.forName(driver);
            conn=java.sql.DriverManager.getConnection(url,username,"sa");
            Statement st=conn.createStatement();
			
          //  String UserName1 = request.getParameter("UName");      
            System.out.print(UserName1);
            String PASSword = request.getParameter("password");
           /* String FirNam  = request.getParameter("Fname");
            String LasNam  = request.getParameter("Lname");
            String EMAIL   = request.getParameter("Email");*/
            String query = "Insert into userinfo(UserName1,PASSword)";
            st.execute(query);
            response.sendRedirect("UserProfile.jsp");
            }
            catch(Exception e)
                {System.out.println(e);} %>
        </body> 
        
</html> 