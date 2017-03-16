<%-- 
    Document   : processChangePWD
    Created on : Mar 9, 2017, 7:57:43 AM
    Author     : Kruthi Mohan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%String username = session.getAttribute("username").toString(); %>
        <title>ChangePWD</title>
    </head>
    <body>
        <%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%
String OldPassword = request.getParameter("OldPassword");
String Newpass = request.getParameter("newpassword");
String conpass = request.getParameter("conpassword");


Connection con = null;
Statement st = null;
String pass = "";
int id = 0;
try {

String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
String url = "jdbc:sqlserver://localhost:1433;databaseName=MovieDatabasev;user=sa;password=sa";
Class.forName(driver);
con = DriverManager.getConnection(url);
st = con.createStatement();
ResultSet rs = st.executeQuery("select * from userdetails where userpass= '"+ OldPassword + "'and username='"+username+"'");
if (rs.next()) { 
pass = rs.getString("userpass");
} 
if(Newpass.equals(conpass))
{

    if (pass.equals(OldPassword)) {

        st = con.createStatement();

        int i = st.executeUpdate("update userdetails set userpass='"+ Newpass + "' where userpass= '"+ OldPassword + "'and username='"+username+"'" );

        out.println("Password changed successfully");

        st.close();

        con.close();

    } else {

        out.println("Old Password doesn't match");

    }
/*}else{
out.println("new password and confirm new password is not matching");
}*/
}
} catch (Exception e) {
out.println(e);
}
%>
    </body>
</html>
