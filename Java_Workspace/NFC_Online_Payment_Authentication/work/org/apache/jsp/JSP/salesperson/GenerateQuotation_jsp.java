package org.apache.jsp.JSP.salesperson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.drw.serviceLocation.serverConnector;
import java.sql.*;
import com.drw.dao.*;
import com.drw.action.*;
import java.util.*;

public final class GenerateQuotation_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


   Connection con=null;
   Statement st=null;
   ResultSet res=null;
   String photo="";
   String name="";
   String price="";
   String purchase="";
   String mrp="";
   String tax="";
  String code="";
  

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
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function f()\r\n");
      out.write("{\r\n");
      out.write("\tvar q=document.f.qty.value;\r\n");
      out.write("\treturn q;\r\n");
      out.write("}\r\n");
      out.write("function f1()\r\n");
      out.write("{\r\n");
      out.write("\tvar q=document.f.qty.value;\r\n");
      out.write("\tvar m=document.f.mrp.value;\r\n");
      out.write("\tvar m1=document.f.tax.value;\r\n");
      out.write("\tvar t,e;\r\n");
      out.write("\tvar t1=m1/100;\r\n");
      out.write("\tt=q*m;\r\n");
      out.write("\te=t+t1;\r\n");
      out.write("\tdocument.f.tot.value=t;\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body background=\"");
      out.print(request.getContextPath());
      out.write("/bg1.jpg\">\r\n");
      out.write("\r\n");
String s=request.getParameter("pro_code");


      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");

   con=serverConnector.serverConnector();
   st=con.createStatement();
   String query="select pro_name,pro_photo_path,pro_pur_price,pro_price,pro_tax,pro_mrp,pro_code from d_product where pro_code='"+s+"'";
   res=st.executeQuery(query);

      out.write("\r\n");
      out.write("\r\n");

   int count=0;
   while(res.next())
   {
	 ++count;
   	 name=res.getString(1);
   	 photo=res.getString(2);
     purchase=res.getString(3);
     price =res.getString(4);
     tax=res.getString(5);
     mrp=res.getString(6);
     code=res.getString(7);
    
   }

      out.write("\r\n");
      out.write("\r\n");
      out.write("<form name=\"f\" action=\"");
      out.print(request.getContextPath());
      out.write("/qutoation\" method=\"post\">\r\n");
      out.write("   \r\n");
      out.write("   <table align=\"center\" width=\"700\">\r\n");
      out.write("   \t\t<tr align=\"center\">\r\n");
      out.write("   \t\t\t\t<td colspan=\"3\" align=\"center\">\r\n");
      out.write("   \t\t\t\t\t<h2>Product Details</h2>\r\n");
      out.write("   \t\t\t\t</td>\r\n");
      out.write("   \t\t</tr>\r\n");
      out.write("   \t\t\r\n");
      out.write("   \t\t<tr>\r\n");
      out.write("   \t\t\t\t<td colspan=\"3\" align=\"center\">\r\n");
      out.write("   \t\t\t\t\t\t<hr>\r\n");
      out.write("   \t\t\t\t</td>\r\n");
      out.write("   \t\t</tr>\r\n");
      out.write("   \t\t\r\n");
      out.write("   \t\t<tr>\r\n");
      out.write("   \t\t\t\t<td colspan=\"3\" align=\"center\">\r\n");
      out.write("   \t\t\t\t\t\t<img src=\"");
      out.print(request.getContextPath());
      out.write("//uploadedimages//");
      out.print(photo);
      out.write("\"  height=\"150\" width=\"150\"></img>\r\n");
      out.write("   \t\t\t\t</td>\r\n");
      out.write("   \t\t</tr>\r\n");
      out.write("   \t\t\r\n");
      out.write("   \t\t<tr align=\"center\" height=\"10\"></tr>\r\n");
      out.write("   \t\t\r\n");
      out.write("   \t\t<tr align=\"center\">\r\n");
      out.write("   \t\t\t\t<td align=\"center\">\r\n");
      out.write("   \t\t\t\t\t\tProduct Code \r\n");
      out.write("   \t\t\t\t</td>\r\n");
      out.write("   \t\t\t\t\r\n");
      out.write("   \t\t\t\t<td width=\"30\" align=\"center\">\r\n");
      out.write("   \t\t\t\t\t\t:\r\n");
      out.write("   \t\t\t\t</td>\r\n");
      out.write("   \t\t\t\t\r\n");
      out.write("   \t\t\t\t<td align=\"center\">\r\n");
      out.write("   \t\t\t\t\t\t<input type=\"text\" name=\"code\" value=\"");
      out.print(code);
      out.write("\"></input>\r\n");
      out.write("   \t\t\t\t</td>\r\n");
      out.write("   \t\t</tr>\r\n");
      out.write("   \t\t\r\n");
      out.write("   \t\t<tr align=\"center\" height=\"10\"></tr>\r\n");
      out.write("   \t\t\r\n");
      out.write("   \t\t<tr align=\"center\">\r\n");
      out.write("   \t\t\t\t<td align=\"center\">\r\n");
      out.write("   \t\t\t\t\t\tProduct Name \r\n");
      out.write("   \t\t\t\t</td>\r\n");
      out.write("   \t\t\t\t\r\n");
      out.write("   \t\t\t\t<td width=\"30\" align=\"center\">\r\n");
      out.write("   \t\t\t\t\t\t:\r\n");
      out.write("   \t\t\t\t</td>\r\n");
      out.write("   \t\t\t\t\r\n");
      out.write("   \t\t\t\t<td align=\"center\">\r\n");
      out.write("   \t\t\t\t\t\t<input type=\"text\" name=\"name\" value=\"");
      out.print(name );
      out.write("\"></input> \r\n");
      out.write("   \t\t\t\t</td>\r\n");
      out.write("   \t\t</tr>\r\n");
      out.write("   \t\t\r\n");
      out.write("   \t\t<tr align=\"center\" height=\"10\"></tr>\r\n");
      out.write("   \t\t\r\n");
      out.write("   \t\t<tr align=\"center\">\r\n");
      out.write("   \t\t\t\t<td align=\"center\">\r\n");
      out.write("   \t\t\t\t\t\tMRP Rate \r\n");
      out.write("   \t\t\t\t</td>\r\n");
      out.write("   \t\t\t\t\r\n");
      out.write("   \t\t\t\t<td width=\"30\" align=\"center\">\r\n");
      out.write("   \t\t\t\t\t\t:\r\n");
      out.write("   \t\t\t\t</td>\r\n");
      out.write("   \t\t\t\t\r\n");
      out.write("   \t\t\t\t<td align=\"center\">\r\n");
      out.write("   \t\t\t\t\t\t<input type=\"text\" name=\"mrp\" value=\"");
      out.print(mrp);
      out.write("\"></input>\r\n");
      out.write("   \t\t\t\t</td>\r\n");
      out.write("   \t\t</tr>\r\n");
      out.write("   \t\t\r\n");
      out.write("   \t\t<tr align=\"center\" height=\"10\"></tr>\r\n");
      out.write("   \t\t\r\n");
      out.write("   \t\t<tr align=\"center\">\r\n");
      out.write("   \t\t\t\t<td align=\"center\">\r\n");
      out.write("   \t\t\t\t\t\tPrice\r\n");
      out.write("   \t\t\t\t</td>\r\n");
      out.write("   \t\t\t\t\r\n");
      out.write("   \t\t\t\t<td width=\"30\" align=\"center\">\r\n");
      out.write("   \t\t\t\t\t\t:\r\n");
      out.write("   \t\t\t\t</td>\r\n");
      out.write("   \t\t\t\t\r\n");
      out.write("   \t\t\t\t<td align=\"center\">\r\n");
      out.write("   \t\t\t\t\t\t<input type=\"text\" name=\"price\" value=\"");
      out.print(price);
      out.write("\"></input>\r\n");
      out.write("   \t\t\t\t</td>\r\n");
      out.write("   \t\t</tr>\r\n");
      out.write("   \t\t\r\n");
      out.write("   \t\t<tr align=\"center\" height=\"10\"></tr>\r\n");
      out.write("   \t\t\r\n");
      out.write("   \t\t<tr align=\"center\">\r\n");
      out.write("   \t\t\t\t<td align=\"center\">\r\n");
      out.write("   \t\t\t\t\t\tTax\r\n");
      out.write("   \t\t\t\t</td>\r\n");
      out.write("   \t\t\t\t\r\n");
      out.write("   \t\t\t\t<td width=\"30\" align=\"center\">\r\n");
      out.write("   \t\t\t\t\t\t:\r\n");
      out.write("   \t\t\t\t</td>\r\n");
      out.write("   \t\t\t\t\r\n");
      out.write("   \t\t\t\t<td align=\"center\">\r\n");
      out.write("   \t\t\t\t\t\t<input type=\"text\" name=\"tax\" value=\"");
      out.print(tax);
      out.write("\"></input>\r\n");
      out.write("   \t\t\t\t</td>\r\n");
      out.write("   \t\t</tr>\r\n");
      out.write("   \t\t\r\n");
      out.write("   \t\t<tr align=\"center\" height=\"10\"></tr>\r\n");
      out.write("   \t\t\r\n");
      out.write("   \t\t<tr align=\"center\">\r\n");
      out.write("   \t\t\t\t<td align=\"center\">\r\n");
      out.write("   \t\t\t\t\t\tQuantity\r\n");
      out.write("   \t\t\t\t</td>\r\n");
      out.write("   \t\t\t\t\r\n");
      out.write("   \t\t\t\t<td width=\"30\" align=\"center\">\r\n");
      out.write("   \t\t\t\t\t\t:\r\n");
      out.write("   \t\t\t\t</td>\r\n");
      out.write("   \t\t\t\t\r\n");
      out.write("   \t\t\t\t<td align=\"center\">\r\n");
      out.write("   \t\t\t\t\t\t<input type=\"text\" name=\"qty\" onchange=\"f1()\" />\r\n");
      out.write("   \t\t\t\t</td>\r\n");
      out.write("   \t\t</tr>\r\n");
      out.write("   \t\t\r\n");
      out.write("   \t\t<tr align=\"center\" height=\"10\"></tr>\r\n");
      out.write("   \t\t\r\n");
      out.write("   \t\t<tr align=\"center\">\r\n");
      out.write("   \t\t\t\t\r\n");
      out.write("   \t\t\t\t<td colspan=\"3\" align=\"center\">\r\n");
      out.write("   \t\t\t\t\t\t<input type=\"submit\" name=\"submit\" value=\"Add To Cart\"/>\r\n");
      out.write("   \t\t\t\t</td>\r\n");
      out.write("   \t\t</tr>\r\n");
      out.write("   \t\t\r\n");
      out.write("   </table> \r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("   \r\n");
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
