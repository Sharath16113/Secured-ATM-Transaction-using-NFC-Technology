package org.apache.jsp.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.drw.serviceLocation.*;
import java.sql.*;

public final class ProductDetails_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


Connection connection=null;
Statement statement=null;
ResultSet resultset=null;
int pro_code;
String pro_name="";
int cat_code;
int sub_cat_code;
String pro_description=""; 
String pro_photo="";
int pro_pur_price;
int pro_mrp;
int pro_price;
int pro_tax;

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

      out.write(" \r\n");
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


System.out.println("came to prodetai");

      out.write("\r\n");
      out.write("<body background=\"");
      out.print(request.getContextPath());
      out.write("/bg1.jpg\">\r\n");
      out.write('\r');
      out.write('\n');

connection=serverConnector.serverConnector();
statement=connection.createStatement();
String query="select * from d_product";
resultset=statement.executeQuery(query);

      out.write("\r\n");
      out.write("<form action=\"");
      out.print(request.getContextPath());
      out.write("/JSP/Admin/AddProduct.jsp\" method=\"post\">\r\n");
      out.write("<center><h2>ProductDetails</h2></center>\r\n");
      out.write("<table align=\"center\" border=\"1\" width=\"75%\">\r\n");
      out.write("<tr bgcolor=\"#145B8D\">\r\n");
      out.write("<td width=\"6%\">\r\n");
      out.write("<p align=\"center\"><font size=\"4\"><b>pro_code</b></font></p>\r\n");
      out.write("</td>\r\n");
      out.write("<td width=\"35%\">\r\n");
      out.write("<p align=\"center\"><font size=\"4\">&nbsp;<b>pro_name</b></font></p>\r\n");
      out.write("</td>\r\n");
      out.write("<td width=\"35%\">\r\n");
      out.write("<p align=\"center\"><font size=\"4\">&nbsp;<b>pro_description</b></font></p>\r\n");
      out.write("</td>\r\n");
      out.write("<td width=\"35%\">\r\n");
      out.write("<p align=\"center\"><font size=\"4\">&nbsp;<b>cat_code</b></font></p>\r\n");
      out.write("</td>\r\n");
      out.write("<td width=\"35%\">\r\n");
      out.write("<p align=\"center\"><font size=\"4\">&nbsp;<b>sub_cat_code</b></font></p>\r\n");
      out.write("</td>\r\n");
      out.write("<td width=\"35%\">\r\n");
      out.write("<p align=\"center\"><font size=\"4\">&nbsp;<b>pro_photo</b></font></p>\r\n");
      out.write("</td>\r\n");
      out.write("<td width=\"35%\">\r\n");
      out.write("<p align=\"center\"><font size=\"4\">&nbsp;<b>pro_pur_price</b></font></p>\r\n");
      out.write("</td>\r\n");
      out.write("<td width=\"35%\">\r\n");
      out.write("<p align=\"center\"><font size=\"4\">&nbsp;<b>pro_mrp</b></font></p>\r\n");
      out.write("</td>\r\n");
      out.write("<td width=\"35%\">\r\n");
      out.write("<p align=\"center\"><font size=\"4\">&nbsp;<b>pro_price</b></font></p>\r\n");
      out.write("</td>\r\n");
      out.write("<td width=\"35%\">\r\n");
      out.write("<p align=\"center\"><font size=\"4\">&nbsp;<b>pro_tax</b></font></p>\r\n");
      out.write("</td>\r\n");
      out.write("<td width=\"26%\">\r\n");
      out.write("<p align=\"center\"><font size=\"4\">&nbsp;<b>Delete</b></font></p>\r\n");
      out.write("</td>\r\n");
      out.write("\r\n");
      out.write("</tr>\r\n");

int count=0;
while(resultset.next())
{
	++count;
	pro_code=resultset.getInt(1);
	pro_name=resultset.getString(2);
	pro_description=resultset.getString(3);
	cat_code=resultset.getInt(4);
	sub_cat_code=resultset.getInt(5);
	pro_photo=resultset.getString(6);
	pro_pur_price=resultset.getInt(7);
	pro_mrp=resultset.getInt(8);
	pro_price=resultset.getInt(9);
	pro_tax=resultset.getInt(10);
	System.out.println("photo image,........."+pro_photo);

      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<td width=\"35%\">");
      out.print(pro_code);
      out.write("</td>\r\n");
      out.write("<td width=\"27%\">");
      out.print(pro_name);
      out.write("</td>\r\n");
      out.write("<td width=\"27%\">");
      out.print(pro_description);
      out.write("</td>\r\n");
      out.write("<td width=\"27%\">");
      out.print(cat_code);
      out.write("</td>\r\n");
      out.write("<td width=\"27%\">");
      out.print(sub_cat_code);
      out.write("</td>\r\n");
      out.write("<td width=\"27%\"><img src=\"");
      out.print(request.getContextPath());
      out.write("//images//");
      out.print(pro_photo);
      out.write("\" height=\"25\" width=\"25\"></img></td>\r\n");
      out.write("<td width=\"27%\">");
      out.print(pro_pur_price);
      out.write("</td>\r\n");
      out.write("<td width=\"27%\">");
      out.print(pro_mrp);
      out.write("</td>\r\n");
      out.write("<td width=\"27%\">");
      out.print(pro_price);
      out.write("</td>\r\n");
      out.write("<td width=\"27%\">");
      out.print(pro_tax);
      out.write("</td>\r\n");
      out.write("<td width=\"26%\">\r\n");
      out.write("<a href=\"");
      out.print(request.getContextPath());
      out.write("/JSP/Admin/DeleteProduct.jsp?pro_code=");
      out.print(pro_code);
      out.write("\" Onclick=\"return confirm('Do you want to delete : ");
      out.print(pro_code);
      out.write("?')\">Delete</a>\r\n");
      out.write("</td>\r\n");
      out.write("\r\n");
      out.write("</tr>\r\n");

}

      out.write('\r');
      out.write('\n');

String deletestatus="";
deletestatus=request.getParameter("deletestatus");
if(deletestatus==null)
{}
else if(deletestatus.equals("success"))
{

      out.write("\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("alert(\"Delete Successfully\");\r\n");
      out.write("</script>\r\n");

}

      out.write("\r\n");
      out.write("\r\n");

String Updatestatus="";
Updatestatus=(String)request.getParameter("Updatestatus");
if(Updatestatus==null)
{
}
else
{

      out.write('\r');
      out.write('\n');

}

      out.write("\r\n");
      out.write("</table><br></br>\r\n");
      out.write("<center><input type=\"submit\" name=\"add\" value=\"Add\" class=\"button button2\"></input></center>\r\n");
      out.write("</form>\r\n");
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
