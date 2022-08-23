package org.apache.jsp.JSP.salesperson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.drw.action.*;
import com.drw.dao.*;
import com.drw.serviceLocation.*;
import java.sql.*;

public final class CatTest_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


   Connection con=null;
   Statement st=null;
   ResultSet res=null;
   String code="";
   String clevel="";
   String cname="";

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
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function Window_onload()\r\n");
      out.write("{\r\n");
      out.write("\tdocument.changeform.oldpassword.focus();\r\n");
      out.write("}\r\n");
      out.write("function window_onload()\r\n");
      out.write("{\r\n");
      out.write("    document.changeform.oldpass.focus();\r\n");
      out.write("\tdocument.getElementById(\"oldpassword\").focus();\r\n");
      out.write("\tdocument.getElementById(\"oldpassword\").value=\"\";\r\n");
      out.write("}\r\n");
      out.write("function checkFormValidator()\r\n");
      out.write("{\r\n");
      out.write("\tif(document.changeform.oldpassword.value==\"\" && document.changeform.newpassword.value==\"\" && document.changeform.confirmpassword.value==\"\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\talert(\"Please Enter oldpwd\");\r\n");
      out.write("\t\tdocument.changeform.oldpassword.focus();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\telse if(document.changeform.newpassword.value==\"\")\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\talert(\"Please Enter newpwd\");\r\n");
      out.write("\t\t\tdocument.changeform.newpassword.focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\telse if(document.changeform.confirmpassword.value==\"\")\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\talert(\"Please Enter confirmpwd\");\r\n");
      out.write("\t\t\tdocument.changeform.confirmpassword.focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
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
      out.write(".tb8 {\r\n");
      out.write("\twidth: 230px;\r\n");
      out.write("\tborder: 1px solid #3366FF;\r\n");
      out.write("\tborder-left: 4px solid #3366FF;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".button {\r\n");
      out.write("    background-color: #427aa9; /* Green */\r\n");
      out.write("    border: none;\r\n");
      out.write("    color: white;\r\n");
      out.write("    padding: 15px 32px;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    text-decoration: none;\r\n");
      out.write("    display: inline-block;\r\n");
      out.write("    font-size: 16px;\r\n");
      out.write("    margin: 4px 2px;\r\n");
      out.write("    cursor: pointer;\r\n");
      out.write("}\r\n");
      out.write(".button3 {background-color: #f44336;}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<form name=\"f\" action=\"");
      out.print(request.getContextPath());
      out.write("/JSP/salesperson/productde.jsp\" method=\"post\">\r\n");
      out.write("\r\n");
      out.write("<table border=\"0\" align=\"center\">\r\n");
      out.write("<tr><td><b><font size=\"4\">Category:</font></b></td>\r\n");
      out.write("\r\n");
      out.write("<td><select name=\"cat\" class=\"tb8\" >\r\n");


String name=request.getParameter("cat");
System.out.println(name);
serverConnector obj=new serverConnector();
Connection con=obj.serverConnector();

Statement smt=con.createStatement();
ResultSet rs=smt.executeQuery("select * from d_cat");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 
while(rs.next())
	{
	 
      out.write("\r\n");
      out.write("<option value=");
      out.print(rs.getString(1));
      out.write('>');
      out.print(rs.getString(2));
      out.write("</option>\r\n");
 
}

      out.write("\r\n");
      out.write("</select> </td></tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<tr><td><b><font size=\"4\">Sub Category:</font></b></td>\r\n");
      out.write("\r\n");
      out.write("<td><select name=\"sub\"  class=\"tb8\" >\r\n");
      out.write("\r\n");

String cat=request.getParameter("cat");
System.out.println(cat);
try
{
	Statement smt1=con.createStatement();
	ResultSet rs1=smt1.executeQuery("select sub_cat_name ,sub_cat_code from d_sub_cat ");
	while(rs1.next())
	{
	String	sub_name=rs1.getString(1);
	String	subcode=rs1.getString(2);
		
	

      out.write("\r\n");
      out.write("<option value=\"");
      out.print(subcode);
      out.write('"');
      out.write('>');
      out.print(rs1.getString(1));
      out.write("</option>\r\n");

	}
}

catch(Exception e)
{
	out.println(e);
}

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</select> \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</td>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr><td><input type=\"submit\" style=\"background: green;\" value=\"VIEW\"></input></td>\r\n");
      out.write(" </table>\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
