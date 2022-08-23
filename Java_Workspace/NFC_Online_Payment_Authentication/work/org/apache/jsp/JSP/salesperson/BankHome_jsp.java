package org.apache.jsp.JSP.salesperson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class BankHome_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE HTML>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("  <title>NFC Online Payement</title>\r\n");
      out.write("  <meta name=\"description\" content=\"website description\" />\r\n");
      out.write("  <meta name=\"keywords\" content=\"website keywords, website keywords\" />\r\n");
      out.write("  <meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />\r\n");
      out.write("  <!-- modernizr enables HTML5 elements and feature detects -->\r\n");
      out.write("  <script type=\"text/javascript\" src=\"js/modernizr-1.5.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("  \r\n");
      out.write("  <div id=\"main\">\r\n");
      out.write("    <div id=\"top_container\" style=\"height:340px\">\r\n");
      out.write("\t  <header>\r\n");
      out.write("        <center><img  src=\"images/title.png\"/></center> \r\n");
      out.write("        <nav>\r\n");
      out.write("          <ul class=\"lavaLampWithImage\" id=\"lava_menu\">\r\n");
      out.write("            \r\n");
      out.write("            <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/JSP/salesperson/User.jsp\" target=\"myframe\">User</a></li>\r\n");
      out.write("          \r\n");
      out.write("          \r\n");
      out.write("           <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/salesperson.jsp\" >Logout</a></li>\r\n");
      out.write("          </ul>\r\n");
      out.write("        </nav>\r\n");
      out.write("      </header>\r\n");
      out.write("      <div class=\"slideshow\">\r\n");
      out.write("        <ul class=\"slideshow\">\r\n");
      out.write("          <li class=\"show\"><img width=\"950\" height=\"250\" src=\"images/1.jpg\" /></li>\r\n");
      out.write("          <li ><img width=\"950\" height=\"250\" src=\"images/1.jpg\" /></li>\r\n");
      out.write("          <li ><img width=\"950\" height=\"250\" src=\"images/1.jpg\" /></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("\t  </div>\t\t\r\n");
      out.write("    </div>\t  \r\n");
      out.write("\r\n");
      out.write("    <div id=\"site_content\">\r\n");
      out.write("      <div id=\"sidebar_container\">\r\n");
      out.write("       <iframe  style=\"position: absolute; background: #FFFFFF;         top:500px;width: 960px;height:400px;left: 195px;border-color: #556B2F;\"  name=\"myframe\" >\r\n");
      out.write("                \r\n");
      out.write("               \r\n");
      out.write("                </iframe>\r\n");
      out.write("\t\t\r\n");
      out.write("        \r\n");
      out.write("      </div>\r\n");
      out.write("      \r\n");
      out.write("    </div>\r\n");
      out.write("   \r\n");
      out.write("  </div>\r\n");
      out.write("  <!-- javascript at the bottom for fast page loading -->\r\n");
      out.write("  <script type=\"text/javascript\" src=\"js/jquery.min.js\"></script>\r\n");
      out.write("  <script type=\"text/javascript\" src=\"js/jquery.easing.min.js\"></script>\r\n");
      out.write("  <script type=\"text/javascript\" src=\"js/jquery.lavalamp.min.js\"></script>\r\n");
      out.write("  <script type=\"text/javascript\" src=\"js/image_fade.js\"></script>\r\n");
      out.write("  <script type=\"text/javascript\">\r\n");
      out.write("    $(function() {\r\n");
      out.write("      $(\"#lava_menu\").lavaLamp({\r\n");
      out.write("        fx: \"backout\",\r\n");
      out.write("        speed: 700\r\n");
      out.write("      });\r\n");
      out.write("    });\r\n");
      out.write("  </script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
