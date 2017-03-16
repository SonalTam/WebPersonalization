package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;
import javax.sql.*;
import java.util.Map.Entry;

public final class MovieDetails_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <h1> Movie Details</h1>\n");
      out.write("        \n");
      out.write("         \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        ");
       
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
                
      out.write("\n");
      out.write("                <table border=\"1\"><tr>\n");
      out.write("                ");

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
                
      out.write("\n");
      out.write("                \n");
      out.write("                <td><a href=\"MovieDetails.jsp?movieid=");
 out.println(rs1.getString(1)); 
      out.write("\"><img src = \"");
 out.println(rs1.getString(3)); 
      out.write("\" alt=\"Movie Link not working\" style=\"width:200px;height:300px;\"> <br>\n");
      out.write("                    </a></td>\n");
      out.write("                    <td> \n");
      out.write("                        <table>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>\n");
      out.write("                                    <h1><font color=\"darkyellow\">");
out.println(rs1.getString(2)); 
      out.write(' ');
      out.write('(');
out.println(rs1.getString(4));
      out.write(") </font></h1>\n");
      out.write("                                </td>\n");
      out.write("\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>\n");
      out.write("                                Rotten Tomatoes Rating : ");
out.println(rs1.getString(5)); 
      out.write(" / 10.0  \n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>\n");
      out.write("                  \n");
      out.write("                                Director : ");
out.println(rsd.getString(1)); 
      out.write(" \n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>\n");
      out.write("                                Actors : ");
while (rsa.next())
                                {out.println(rsa.getString(1)); 
      out.write(',');
 }
      out.write("\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            \n");
      out.write("                        </table> \n");
      out.write("                    </td>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("                </tr></table>\n");
      out.write("\n");
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
