package org.apache.jsp.JSP.salesperson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.drw.serviceLocation.serverConnector;
import java.sql.*;
import com.drw.dao.*;
import com.drw.action.*;

public final class nextss_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>Payment Mode</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<center>\r\n");
      out.write("\t<h1>Payment Mode</h1>\r\n");
      out.write("\t<form action=\"");
      out.print(request.getContextPath());
      out.write("/JSP/salesperson/cashpay.jsp\">\r\n");
      out.write("\t\t<input type=\"submit\" value=\"Pay By Cash\">\r\n");
      out.write("\t</form>\r\n");
      out.write("\t\r\n");
      out.write("\t<form action=\"");
      out.print(request.getContextPath());
      out.write("/JSP/salesperson/cardpay1.jsp\">\r\n");
      out.write("\t\t<input type=\"submit\" value=\"Pay By Card\">\r\n");
      out.write("\t</form>\r\n");
      out.write("\r\n");
      out.write("</center>\r\n");
      out.write("\r\n");

	String status=null;

    status=(String)request.getAttribute("InsertSuccess");
    if(status==null)
    {
    }
    else
    {

      out.write("\r\n");
      out.write("\t<br>\r\n");
      out.write("    <center>\r\n");
      out.write("    \t\t<font color=\"green\"><b>");
      out.print(status);
      out.write("</b></font>\r\n");
      out.write("    </center>\r\n");

    }

      out.write("\r\n");
      out.write("    \r\n");
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
