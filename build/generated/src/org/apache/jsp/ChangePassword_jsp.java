package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ChangePassword_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <body background=\"background.jpg\"></body>\n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\">  \n");
      out.write("         ");
String username = session.getAttribute("username").toString(); 
      out.write("\n");
      out.write("         ");
 String Uid = session.getAttribute("userid").toString(); 
      out.write("\n");
      out.write("        <title>Change Password</title>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("<script language=\"javascript\">\n");
      out.write("function fncSubmit()\n");
      out.write("{\n");
      out.write("\n");
      out.write("if(document.ChangePasswordForm.OldPassword.value === \"\")\n");
      out.write("{\n");
      out.write("alert('Please input old password');\n");
      out.write("document.ChangePasswordForm.OldPassword.focus();\n");
      out.write("return false;\n");
      out.write("} \n");
      out.write("\n");
      out.write("if(document.ChangePasswordForm.newpassword.value === \"\")\n");
      out.write("{\n");
      out.write("alert('Please input Password');\n");
      out.write("document.ChangePasswordForm.newpassword.focus(); \n");
      out.write("return false;\n");
      out.write("} \n");
      out.write("\n");
      out.write("if(document.ChangePasswordForm.conpassword.value === \"\")\n");
      out.write("{\n");
      out.write("alert('Please input Confirm Password');\n");
      out.write("document.ChangePasswordForm.conpassword.focus(); \n");
      out.write("return false;\n");
      out.write("} \n");
      out.write("\n");
      out.write("if(document.ChangePasswordForm.newpassword.value !== document.ChangePasswordForm.conpassword.value)\n");
      out.write("{\n");
      out.write("alert('Confirm Password Not Match');\n");
      out.write("document.ChangePasswordForm.conpassword.focus(); \n");
      out.write("return false;\n");
      out.write("} \n");
      out.write("\n");
      out.write("document.ChangePasswordForm.submit();\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("<form name=\"ChangePasswordForm\" method=\"post\" action=\"processChangePWD.jsp\" OnSubmit=\"return fncSubmit();\">\n");
      out.write("\n");
      out.write("<table border=\"1\" align=\"center\" bgcolor=\"#2B60DE\">\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("<td>OLD PASSWORD</td>\n");
      out.write("<TD><input name=\"OldPassword\" type=\"password\" id=\"OLDpwd\" size=\"20\"></td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td>New Password</td>\n");
      out.write("<td><input name=\"newpassword\" type=\"password\" id=\"newpassword\">\n");
      out.write("</td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td>Confirm Password</td>\n");
      out.write("<td><input name=\"conpassword\" type=\"password\" id=\"conpassword\">\n");
      out.write("</td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td>&nbsp;</td>\n");
      out.write("<td><input type=\"submit\" name=\"Submit\" value=\"Save\"></td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("</table>\n");
      out.write("</form>\n");
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
