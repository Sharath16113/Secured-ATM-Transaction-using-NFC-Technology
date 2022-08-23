package org.apache.jsp.JSP.salesperson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.drw.serviceLocation.serverConnector;
import java.sql.*;
import com.drw.dao.*;
import com.drw.action.*;

public final class productde_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


   Connection con=null;
   Statement st=null;
   ResultSet res=null;
   String photo="";
   String name="";
   String pro_code="";

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
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body background=\"");
      out.print(request.getContextPath());
      out.write("/bg1.jpg\">\r\n");

	String s=request.getParameter("sub");
String cat=request.getParameter("cat");

      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');

   con=serverConnector.serverConnector();
   st=con.createStatement();
   String query="select pro_photo_path,pro_name,pro_code from d_product where sub_cat_code='"+s+"' and cat_code='"+cat+"'";
   res=st.executeQuery(query);

      out.write("\r\n");
      out.write(" <center><h2>Product Details</h2></center>\r\n");
      out.write(" \r\n");
      out.write(" <table align=\"center\" border=\"1\" width=\"75%\">\r\n");
      out.write(" <tr align=\"center\">\r\n");
      out.write(" <td width=\"20%\" align=\"center\">\r\n");
      out.write(" \t<p align=\"center\">\r\n");
      out.write("\t \t<font size=\"4\">\r\n");
      out.write("\t \t\t<b>Product Photo</b>\r\n");
      out.write("\t \t</font>\r\n");
      out.write(" \t</p>\r\n");
      out.write(" </td>\r\n");
      out.write(" \r\n");
      out.write(" <td width=\"65%\" align=\"center\">\r\n");
      out.write(" \t<p align=\"center\"><font size=\"4\">&nbsp;<b>Product Name</b></font></p>\r\n");
      out.write(" </td>\r\n");
      out.write(" \r\n");
      out.write(" <td width=\"10%\" align=\"center\">\r\n");
      out.write(" \t<p align=\"center\"><font size=\"4\">&nbsp;<b>Action</b></font></p>\r\n");
      out.write(" </td>\r\n");
      out.write("    \r\n");
      out.write(" </tr>\r\n");
      out.write(" ");

   int count=0;
   while(res.next())
   {++count;
    photo=res.getString(1);
    name=res.getString(2);
    pro_code=res.getString(3);

      out.write("\r\n");
      out.write("   <tr align=\"center\">\r\n");
      out.write("    <td width=\"20%\" align=\"center\">\r\n");
      out.write("    \t<img src=\"");
      out.print(request.getContextPath());
      out.write("//uploadedimages//");
      out.print(photo);
      out.write("\"  height=\"40\" width=\"50\"></img>\r\n");
      out.write("    </td>\r\n");
      out.write("    <td width=\"65%\">\r\n");
      out.write("    \t");
      out.print(name );
      out.write("\r\n");
      out.write("    </td>\r\n");
      out.write("    \r\n");
      out.write("     <td width=\"10%\">\r\n");
      out.write("      <a href=\"");
      out.print(request.getContextPath());
      out.write("/JSP/salesperson/GenerateQuotation.jsp?pro_code=");
      out.print(pro_code);
      out.write("\">View</a>\r\n");
      out.write("    </td>\r\n");
      out.write("    \r\n");
      out.write("    </tr>\r\n");

    }

      out.write("\r\n");
      out.write("    </table>\r\n");
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
