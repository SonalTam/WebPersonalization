package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import javax.sql.*;
import java.util.Map.Entry;
import java.sql.*;

public final class Welcome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("                <link rel=\"stylesheet\" href=\"menu.css\">  \n");
      out.write("        <title>Welcome Page</title>\n");
      out.write("       <style>\n");
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
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");
 
            if(session.getAttribute("username")==null)
            {
                response.sendRedirect("Login.jsp");
            }
        
      out.write("\n");
      out.write("        <div>\n");
      out.write("            <h1>Movie Recommendation(s) </h1>\n");
      out.write("        \n");
      out.write("        <ul style=\"font-size:20px\">\n");
      out.write("            <li><a-text>Welcome ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a-text></li>\n");
      out.write("            <li><a href=\"Welcome.jsp\">Home</a></li>\n");
      out.write("        <li style=\"float:right\"><form action=\"Logout\"><a>Sign-out</a></form></li>\n");
      out.write("            <li style=\"float:right\"><a href=\"Ratings.jsp\">MyRatings</a></li>\n");
      out.write("            <li style=\"float:right\"><a href=\"UserProfile.jsp\">MyProfile</a></li>\n");
      out.write("        </ul>\n");
      out.write("        </div>\n");
      out.write("            \n");
      out.write("        ");
 String Uid = session.getAttribute("userid").toString(); 
      out.write("\n");
      out.write("        <form method=\"get\" action=\"Login.jsp\">\n");
      out.write("        \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            ");

                String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                String url = "jdbc:sqlserver://localhost:1433;databaseName=MovieDatabasev";
                String user = "sa";
                String pass = "sa";

                Class.forName(driver);
                java.sql.Connection con = DriverManager.getConnection(url, user, pass);
                Statement st1 = con.createStatement();
                ResultSet rs1 = st1.executeQuery("select top 8 rating, imdbPictureURL from Movies join User_Ratedmovies on Movies.id = User_Ratedmovies.movieID where userID in ("+Uid+") order by rating desc" );
                
      out.write("\n");
      out.write("               <br>\n");
      out.write("               <h1> Top 8 movies </h1><br>\n");
      out.write("                <table border=\"1\"><tr>\n");
      out.write("                ");

                rs1 = st1.executeQuery("select top 8 movieID, rating, imdbPictureURL from Movies join User_Ratedmovies on Movies.id = User_Ratedmovies.movieID where userID in ("+Uid+") order by rating desc" );
                while(rs1.next())    
                {
                
      out.write("\n");
      out.write("                \n");
      out.write("                <td><a href=\"MovieDetails.jsp?movieid=");
 out.println(rs1.getString(1)); 
      out.write("\"><img src = \"");
 out.println(rs1.getString(3)); 
      out.write("\" alt=\"Movie Link not working\" style=\"width:162px;height:200px;\"> <br>\n");
      out.write("                        Your Rating: ");
out.println(rs1.getString(2)); 
      out.write(" /5.0  </a></td>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("                </tr></table>\n");
      out.write("        </form>\n");
      out.write("        \n");
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
