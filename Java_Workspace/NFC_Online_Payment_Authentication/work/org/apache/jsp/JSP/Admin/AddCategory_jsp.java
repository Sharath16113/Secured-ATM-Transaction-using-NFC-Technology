package org.apache.jsp.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AddCategory_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("* {\r\n");
      out.write("  box-sizing: border-box;\r\n");
      out.write("}\r\n");
      out.write("body {\r\n");
      out.write("  background: white;\r\n");
      out.write("  font-family: \"Open Sans\", arial;\r\n");
      out.write("}\r\n");
      out.write("table {\r\n");
      out.write("  width: 100%;\r\n");
      out.write("  max-width: 600px;\r\n");
      out.write("  height: 320px;\r\n");
      out.write("  border-collapse: collapse;\r\n");
      out.write("  border: 1px solid #38678f;\r\n");
      out.write("  margin: 50px auto;\r\n");
      out.write("  background: white;\r\n");
      out.write("}\r\n");
      out.write("th {\r\n");
      out.write("  background: #04166f;\r\n");
      out.write("  height: 54px;\r\n");
      out.write("  width: 25%;\r\n");
      out.write("  font-weight: lighter;\r\n");
      out.write("  text-shadow: 0 1px 0 #38678f;\r\n");
      out.write("  color: white;\r\n");
      out.write("  border: 1px solid #38678f;\r\n");
      out.write("  box-shadow: inset 0px 1px 2px #568ebd;\r\n");
      out.write("  transition: all 0.2s;\r\n");
      out.write("}\r\n");
      out.write("tr {\r\n");
      out.write("  border-bottom: 1px solid #cccccc;\r\n");
      out.write("}\r\n");
      out.write("tr:last-child {\r\n");
      out.write("  border-bottom: 0px;\r\n");
      out.write("}\r\n");
      out.write("td {\r\n");
      out.write("  border-right: 1px solid #cccccc;\r\n");
      out.write("  padding: 15px;\r\n");
      out.write("  transition: all 0.2s;\r\n");
      out.write("}\r\n");
      out.write("td:last-child {\r\n");
      out.write("  border-right: 0px;\r\n");
      out.write("}\r\n");
      out.write("td.selected {\r\n");
      out.write("  background: #d7e4ef;\r\n");
      out.write("  z-index: ;\r\n");
      out.write("}\r\n");
      out.write("td input {\r\n");
      out.write("  font-size: 12px;\r\n");
      out.write("  background: none;\r\n");
      out.write("  outline: none;\r\n");
      out.write("  border: 0;\r\n");
      out.write("  display: table-cell;\r\n");
      out.write("  height: 100%;\r\n");
      out.write("  width: 100%;\r\n");
      out.write("}\r\n");
      out.write("td input:focus {\r\n");
      out.write("  box-shadow: 0 1px 0 steelblue;\r\n");
      out.write("  color: steelblue;\r\n");
      out.write("}\r\n");
      out.write("::-moz-selection {\r\n");
      out.write("  background: steelblue;\r\n");
      out.write("  color: white;\r\n");
      out.write("}\r\n");
      out.write("::selection {\r\n");
      out.write("  background: steelblue;\r\n");
      out.write("  color: white;\r\n");
      out.write("}\r\n");
      out.write(".heavyTable {\r\n");
      out.write("  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.2);\r\n");
      out.write("  animation: float 5s infinite;\r\n");
      out.write("}\r\n");
      out.write(".main {\r\n");
      out.write("  max-width: 600px;\r\n");
      out.write("  padding: 10px;\r\n");
      out.write("  margin: auto;\r\n");
      out.write("}\r\n");
      out.write(".content {\r\n");
      out.write("  color: white;\r\n");
      out.write("  text-align: center;\r\n");
      out.write("}\r\n");
      out.write(".content p,\r\n");
      out.write(".content pre,\r\n");
      out.write(".content h2 {\r\n");
      out.write("  text-align: left;\r\n");
      out.write("}\r\n");
      out.write(".content pre {\r\n");
      out.write("  padding: 1.2em 0 0.5em;\r\n");
      out.write("  background: white;\r\n");
      out.write("  background: rgba(255, 255, 255, 0.7);\r\n");
      out.write("  border: 1px solid rgba(255, 255, 255, 0.9);\r\n");
      out.write("  color: #38678f;\r\n");
      out.write("}\r\n");
      out.write(".content .download {\r\n");
      out.write("  margin: auto;\r\n");
      out.write("  background: rgba(255, 255, 255, 0.1);\r\n");
      out.write("  display: inline-block;\r\n");
      out.write("  padding: 1em 1em;\r\n");
      out.write("  border-radius: 12em;\r\n");
      out.write("  margin-bottom: 2em;\r\n");
      out.write("}\r\n");
      out.write(".content .button {\r\n");
      out.write("  display: inline-block;\r\n");
      out.write("  text-decoration: none;\r\n");
      out.write("  color: white;\r\n");
      out.write("  height: 48px;\r\n");
      out.write("  line-height: 48px;\r\n");
      out.write("  padding: 0 20px;\r\n");
      out.write("  border-radius: 24px;\r\n");
      out.write("  border: 1px solid #38678f;\r\n");
      out.write("  background: steelblue;\r\n");
      out.write("  box-shadow: 0 1px 0 rgba(255, 255, 255, 0.1), inset 0 1px 3px rgba(255, 255, 255, 0.2);\r\n");
      out.write("  transition: all 0.1s;\r\n");
      out.write("}\r\n");
      out.write(".content .button:hover {\r\n");
      out.write("  background: #4f8aba;\r\n");
      out.write("  box-shadow: 0 1px 0 rgba(255, 255, 255, 0.1), inset 0 0 10px rgba(255, 255, 255, 0.1);\r\n");
      out.write("}\r\n");
      out.write(".content .button:active {\r\n");
      out.write("  color: #294d6b;\r\n");
      out.write("  background: #427aa9;\r\n");
      out.write("  box-shadow: 0 1px 0 rgba(255, 255, 255, 0.1), inset 0 0 5px rgba(0, 0, 0, 0.2);\r\n");
      out.write("}\r\n");
      out.write(".content .button:focus {\r\n");
      out.write("  outline: none;\r\n");
      out.write("}\r\n");
      out.write("h1 {\r\n");
      out.write("  text-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);\r\n");
      out.write("  text-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("function window_onload()\r\n");
      out.write("{\r\n");
      out.write("    document.categoryform.ccode.focus();\r\n");
      out.write("\tdocument.getElementById(\"ccode\").focus();\r\n");
      out.write("\tdocument.getElementById(\"ccode\").values=\"\";\r\n");
      out.write("}\r\n");
      out.write("function checkFormValidator()\r\n");
      out.write("{\r\n");
      out.write("\tif(document.categoryform.ccode.value==\"\" && document.categoryform.cname.value==\"\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\talert(\"Please Enter All Fields\");\r\n");
      out.write("\t\tdocument.categoryform.ccode.focus();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\telse if(document.categoryform.ccode.value==\"\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\talert(\"Please Enter categorycode\");\r\n");
      out.write("\t\tdocument.categoryform.ccode.focus();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\telse if(document.categoryform.cname.value==\"\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\talert(\"Please Enter categoryname\");\r\n");
      out.write("\t\tdocument.categoryform.cname.focus();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function CheckNo()\r\n");
      out.write("{\r\n");
      out.write("\tvar ctrl=document.categoryform.ccode.value;\r\n");
      out.write("\tvar ctrl1=ctrl.length;\r\n");
      out.write("\tvar count=0;\r\n");
      out.write("\tfor(var i=0;i<ctrl1;i++)\r\n");
      out.write("\t{\r\n");
      out.write("\t\tvar c=ctrl.charAt(i);\r\n");
      out.write("\t\tif((c<\"0\")||(c>\"9\"))\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tcount=count+1;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tif(count>=1)\r\n");
      out.write("\t{\r\n");
      out.write("\t\talert(\"enter numbers only\");\r\n");
      out.write("\t\tdocument.categoryform.ccode.value=\"\";\r\n");
      out.write("\t\tdocument.categoryform.ccode.focus();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\telse if(ctrl.length>12)\r\n");
      out.write("\t{\r\n");
      out.write("\t\talert(\"enter correct code\");\r\n");
      out.write("\t\tdocument.categoryform.ccode.value=\"\";\r\n");
      out.write("\t\tdocument.categoryform.ccode.focus();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\tif(ctrl.value==\"\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\talert(\"enter correct code\");\r\n");
      out.write("\t\treturn false; \r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function CheckName()\r\n");
      out.write("{\r\n");
      out.write("\tvar name=document.categoryform.cname.value;\r\n");
      out.write("\tvar len=name.length;\r\n");
      out.write("\tfor(var i=0;i<len;i++)\r\n");
      out.write("\t{\r\n");
      out.write("\t\tvar ctrl=name.charAt(i);\r\n");
      out.write("\t\tvar a=parseInt(ctrl);\r\n");
      out.write("\t\tif((a>\"65\") || (a<\"122\"))\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\talert(\"enter characters only\");\r\n");
      out.write("\t\t\tdocument.categoryform.cname.value=\"\";\r\n");
      out.write("\t\t\tdocument.categoryform.cname.focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"window_onload()\" background=\"");
      out.print(request.getContextPath());
      out.write("/bg1.jpg\">\r\n");
      out.write("<center>\r\n");
      out.write("<form action=\"");
      out.print(request.getContextPath());
      out.write("/AddCategoryServlet\" name=\"categoryform\" method=\"post\" onsubmit=\"return checkFormValidator()\">\r\n");
      out.write("<table rows=\"2\" width=\"25\"><br></br>\r\n");
      out.write("<tr><td><b>CatCode:</b></td><td>&nbsp;&nbsp;<input type=\"text\" name=\"ccode\" name=\"categoryform\" onBlur=\"return CheckNo()\"></input></td></tr>\r\n");
      out.write("<tr><td><b>CatName:</b></td><td>&nbsp;&nbsp;<input type=\"text\" name=\"cname\" name=\"categoryform\" onBlur=\"return CheckName()\"></input></td></tr>\r\n");
      out.write("</table><br></br>\r\n");
      out.write("<input type=\"submit\" name=\"submit\" value=\"Add\" class=\"button button2\"></input>\r\n");
      out.write("<input type=\"reset\" name=\"reset\" value=\"Reset\" class=\"button button2\"></input>\r\n");

String status=null;
status=(String)request.getAttribute("insertstatus");
if(status==null)
{}
else
{

      out.write("\r\n");
      out.write("<font color=\"blue\"><b>");
      out.print(status);
      out.write("</b></font>\r\n");

}

      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("</center>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
