
package com.webpersonalization;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;


/**
 *
 * @author Lavanya
 */
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String uname = request.getParameter("uname");
        String upass = request.getParameter("pwd");
        
        try{
     
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
            String url="jdbc:sqlserver://localhost:1433;databaseName=MovieDatabasev;user=sa;password=sa";
        
            Connection con = DriverManager.getConnection(url);
        
            String sql = "select * from userdetails where Username=? and userpass=?";
        
            PreparedStatement result = con.prepareStatement(sql);
        
            result.setString(1, uname);
            result.setString(2, upass);
        
            ResultSet rs = result.executeQuery();
        
            if(rs.next()){
                HttpSession session = request.getSession();
                session.setAttribute("username", uname);
                session.setAttribute("userid", rs.getString(1));
                System.out.println("Success");      
                response.sendRedirect("Welcome.jsp");    
                
            } else {
                System.out.println("Un-Success");      
                JOptionPane.showMessageDialog(null, "Invalid username or password... Please try again !!!");
                response.sendRedirect("Login.jsp");  
                
            }
        }
        catch(SQLException sqle) {
            System.out.println("Sql Exception :"+sqle.getMessage());
        }
        catch(ClassNotFoundException e) {
            System.out.println("Class Not Found Exception :" + e.getMessage());
        }
    }
}
