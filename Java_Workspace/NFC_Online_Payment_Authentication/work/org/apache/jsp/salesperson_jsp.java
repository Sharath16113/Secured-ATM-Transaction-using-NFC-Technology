package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class salesperson_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 
public int convert(String str) 
{ 
	int conv=0; 
	if(str==null) 
	{ 
		str="0"; 
	} 
	else if((str.trim()).equals("null")) 
	{ 
		str="0"; 
	} 
	else if(str.equals("")) 
	{ 
		str="0"; 
	} 
	try
	{ 
		conv=Integer.parseInt(str); 
	} 
	catch(Exception e) 
	{ 
	} 
	return conv; 
	
} 

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
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("  <title>NFC_Online_Payement</title>\r\n");
      out.write("  <meta name=\"description\" content=\"website description\" />\r\n");
      out.write("  <meta name=\"keywords\" content=\"website keywords, website keywords\" />\r\n");
      out.write("  <meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />\r\n");
      out.write("  <!-- modernizr enables HTML5 elements and feature detects -->\r\n");
      out.write("  <script type=\"text/javascript\" src=\"js/modernizr-1.5.min.js\"></script>\r\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style1.css\" />\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("  \r\n");
      out.write("  <div id=\"main\">\r\n");
      out.write("    <div id=\"top_container\" style=\"height:340px\">\r\n");
      out.write("\t  <header>\r\n");
      out.write("       <center><img src=\"images/title.png\"/></center> \r\n");
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
      out.write("      \r\n");
      out.write("      <div id=\"content\">\r\n");
      out.write("       <div class=\"wrapper\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<div class=\"content\" >\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div id=\"form_wrapper\" class=\"form_wrapper\" >\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<!-------------------------------Login Form -------------------------------------->\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<form class=\"login active\" action=\"");
      out.print(request.getContextPath());
      out.write("/LoginServlet\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t<h3 style=\"height: 30px;\">Sales Person Login</h3>\r\n");
      out.write("\t\t\t\t\t\t<div style=\"height: 60px\">\r\n");
      out.write("\t\t\t\t\t\t\t<label >Sales Person ID:</label>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"salesid\" id=\"userid\" placeholder=\"Sales Person ID\" required=\"yes\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div style=\"height: 60px\">\r\n");
      out.write("\t\t\t\t\t\t\t<label >Password: </label>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"password\" name=\"salespass\" id=\"password\" placeholder=\"Password\" required=\"yes\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<div class=\"bottom\" style=\"height: 100px\">\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"submit\" value=\"Login\" onclick=\"return \"></input>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"index.jsp\" rel=\"login\" class=\"linkform\">Admin Login</a>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("      </div>\r\n");
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
      out.write("\r\n");

	int no=convert(request.getParameter("no"));
	if(no==1)
	{
		    

      out.write("       \r\n");
      out.write("    \t\t\r\n");
      out.write("    \t <script type=\"text/javascript\">\r\n");
      out.write("    \t\t\talert('Enter Username and Password !');\r\n");
      out.write("    \t\t\t</script>\r\n");

	}
	if(no==2)
	{

      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("    \t\t\r\n");
      out.write("    \t<script type=\"text/javascript\">\r\n");
      out.write("    \t\t\talert(' Please,Enter Your Username.!!');\r\n");
      out.write("    \t\t\t</script>\r\n");

	}
	if(no==3)
	{

      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("    \t\r\n");
      out.write("    \t\r\n");
      out.write("    \t<script type=\"text/javascript\">\r\n");
      out.write("    \t\t\talert(' Please,Enter Your Password.!');\r\n");
      out.write("    \t\t\t</script>\r\n");

	}

      out.write('\r');
      out.write('\n');

	if(no==4)
	{

      out.write("\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("    \t\t\talert('Sorry invalid username and password');\r\n");
      out.write("    \t\t\t</script>\r\n");

	}

      out.write('\r');
      out.write('\n');

	if(no==5)
	{

      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("    \t\t\talert('You have Logged out successfully...!');\r\n");
      out.write("    \t\t\t</script>\t\r\n");

	}

      out.write("\r\n");
      out.write("\r\n");
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
