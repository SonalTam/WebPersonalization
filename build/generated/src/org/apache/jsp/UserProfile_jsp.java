package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;
import javax.sql.*;
import java.util.Map.Entry;

public final class UserProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\">  \n");
      out.write("        ");
 String Uid = session.getAttribute("userid").toString(); 
      out.write("\n");
      out.write("        \n");
      out.write("               <style>\n");
      out.write("           ul {\n");
      out.write("                list-style-type: none;\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 0;\n");
      out.write("                overflow: hidden;\n");
      out.write("                background-color: #333;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            li {\n");
      out.write("                float: left;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            li a {\n");
      out.write("                display: block;\n");
      out.write("                color: white;\n");
      out.write("                text-align: center;\n");
      out.write("                padding: 14px 16px;\n");
      out.write("                text-decoration: none;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            li a-text {\n");
      out.write("                display: block;\n");
      out.write("                color: white;\n");
      out.write("                text-align: center;\n");
      out.write("                padding: 14px 16px;\n");
      out.write("                text-decoration: none;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            li a:hover:not(.active) {\n");
      out.write("                background-color: #111;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .active {\n");
      out.write("                background-color: #4CAF50;\n");
      out.write("            } \n");
      out.write("       </style>\n");
      out.write("\n");
      out.write("        <title>User Profile</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1> My Profile </h1>\n");
      out.write("        <ul style=\"font-size:20px\">\n");
      out.write("            <li><a-text>Welcome ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a-text></li>\n");
      out.write("            <li><a href=\"Welcome.jsp\">Home</a></li>\n");
      out.write("            <li style=\"float:right\" action=\"Logout\"><a href=\"#\" >Sign-out</a></li>\n");
      out.write("            <li style=\"float:right\"><a href=\"Ratings.jsp\">MyRatings</a></li>\n");
      out.write("            <li style=\"float:right\"><a href=\"UserProfile.jsp\">MyProfile</a></li>\n");
      out.write("        </ul>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("         \n");
      out.write("        ");
       
             
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
                      
          
      out.write("  \n");
      out.write("       \n");
      out.write("          <div class=\"profile-page\" align=\"Left\">\n");
      out.write("              <div class=\"profile-form\">\n");
      out.write("              <table border=\"1\" cellpadding=\"5\">\n");
      out.write("              <caption> <h1> My Details </h1></caption>\n");
      out.write("                ");

                while( rs2.next() ){
                
      out.write(" \n");
      out.write("                  \n");
      out.write("                      <tr>\n");
      out.write("                          <td>Username</td>\n");
      out.write("                          <td>");
      out.print( rs2.getString("username") );
      out.write("</td>\n");
      out.write("                          \n");
      out.write("                      </tr>\n");
      out.write("                      <tr>\n");
      out.write("                          <td>Password</td>\n");
      out.write("                          <td>");
      out.print( rs2.getString("userpass") );
      out.write("</td>\n");
      out.write("                          <td><a href=\"ChangePassword.jsp\">Change Password</a></td>\n");
      out.write("                      </tr>\n");
      out.write("                      <tr>\n");
      out.write("                          <td>Secret Question #1 </td>\n");
      out.write("                          <td>");
      out.print( rs2.getString("secret_question1") );
      out.write("</td>\n");
      out.write("                      </tr>\n");
      out.write("                      \n");
      out.write("                      <tr>\n");
      out.write("                          <td>Answer</td>\n");
      out.write("                        <td>");
      out.print( rs2.getString("answer1") );
      out.write("</td>  \n");
      out.write("                      </tr>\n");
      out.write("                      <tr>\n");
      out.write("                          <td>Secret Question #2 </td>\n");
      out.write("                          <td>");
      out.print( rs2.getString("secret_question2") );
      out.write("</td>\n");
      out.write("                      </tr>\n");
      out.write("                      \n");
      out.write("                      <tr>\n");
      out.write("                          <td>Answer</td>\n");
      out.write("                          <td>");
      out.print( rs2.getString("answer2") );
      out.write("</td>\n");
      out.write("                      </tr>                      \n");
      out.write("                  \n");
      out.write("                  ");

                      }

      out.write("\n");
      out.write("          </div>\n");
      out.write("          \n");
      out.write("          </div>\n");
      out.write("          <div> <a href= \"Ratings.jsp\">Ratings</a> </div>\n");
      out.write("          \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
