package org.apache.jsp.JSP.salesperson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.drw.serviceLocation.serverConnector;
import java.sql.*;
import com.drw.dao.*;
import com.drw.action.*;
import java.math.*;

public final class ss_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


   Connection con=null;
   Statement st=null;
   ResultSet res=null;
   String photo="";
   String name="";
     String proname="";
     float q=0.0f;
     int qno;
     float p=0.0f;
     float t=0.0f;
     float am=0.0f;
     float amt=0.0f;
     float amtp=0.0f;
     float amtptt=0.0f;
     float tmp; 
     
   int code;
   String qp="";
   String pp="";
   String amp="";
   String tp="";
   int qun;
   
 
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
      out.write("<body background=\"");
      out.print(request.getContextPath());
      out.write("/bg1.jpg\">\r\n");
      out.write('\r');
      out.write('\n');
      out.write(' ');

 
int qno=UserDAO.getqno();
 
 System.out.println("Quotatio nin jsp"+qno);
 
   con=serverConnector.serverConnector();
   st=con.createStatement();
   String query="select qty,price,tax,amount,pro_code from t_quotation where q_no='"+qno+"'";
   res=st.executeQuery(query);
   
 
      out.write("\r\n");
      out.write(" <form  action=\"");
      out.print(request.getContextPath());
      out.write("/confirm\"   method=\"post\">\r\n");
      out.write(" <center >ONLINE BILLING FOR COMPUTER SUPERMARKET </center>\r\n");
      out.write("<center>BILL NUMBER:<input type=\"text\" name=\"qno\" value=\"");
      out.print(qno);
      out.write("\"></input></center>\r\n");
      out.write(" \r\n");
      out.write(" <table align=\"center\" border=\"1\" width=\"75%\" >\r\n");
      out.write(" \r\n");
      out.write(" <tr>\r\n");
      out.write(" \r\n");
      out.write("  <td width=\"35%\">\r\n");
      out.write(" <p align=\"center\"><font size=\"4\">&nbsp;<b>Name</b></font></p>\r\n");
      out.write(" </td>\r\n");
      out.write("  <td width=\"35%\">\r\n");
      out.write(" <p align=\"center\"><font size=\"4\">&nbsp;<b>Quantity</b></font></p>\r\n");
      out.write(" </td>\r\n");
      out.write(" <td width=\"35%\">\r\n");
      out.write(" <p align=\"center\"><font size=\"4\">&nbsp;<b>Price</b></font></p>\r\n");
      out.write(" </td>\r\n");
      out.write(" <td width=\"35%\">\r\n");
      out.write(" <p align=\"center\"><font size=\"4\">&nbsp;<b>Tax</b></font></p>\r\n");
      out.write(" </td>\r\n");
      out.write(" <td width=\"35%\">\r\n");
      out.write(" <p align=\"center\"><font size=\"4\">&nbsp;<b>Amount</b></font></p>\r\n");
      out.write(" </td>\r\n");
      out.write(" </tr>\r\n");
      out.write(" ");

 float tt=0.0f;
 while(res.next())
   {  qun=res.getInt(1);
   p=res.getFloat(2);
   t=res.getFloat(3);
   am=res.getFloat(4);
   System.out.println("amount"+am);
     int code=res.getInt(5);
     System.out.println("code in jsp"+code);
     String name=UserDAO.getname(code);
     System.out.println("the mnemr"+name);
     amt=UserDAO.gettotal(qno);
     System.out.println("the mnemr"+amt);
     System.out.println("thre initial amount is "+tt);
     tt=tt+am;
     System.out.println("thre after addition amount is "+tt);
     tmp = Math.round(tt);
  
      
      out.write("\r\n");
      out.write("   <tr>\r\n");
      out.write("        <td width=\"35%\">");
      out.print(name);
      out.write("</td>\r\n");
      out.write("        <td width=\"35%\">");
      out.print(qun);
      out.write("</td>\r\n");
      out.write("        <td width=\"35%\">");
      out.print(p);
      out.write("</td>\r\n");
      out.write("        <td width=\"35%\">");
      out.print(t);
      out.write("</td>\r\n");
      out.write("        <td width=\"35%\">");
      out.print(am);
      out.write("</td>\r\n");
      out.write("        \r\n");
      out.write("        <td width=\"26%\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/JSP/salesperson/quodelete.jsp?pro_code=");
      out.print(code);
      out.write("\" onClick=\"return confirm('Do u want to delete");
      out.print(name);
      out.write("?')\">Delete</a>\r\n");
      out.write("    </td>\r\n");
      out.write("    <td width=\"26%\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/JSP/salesperson/quoupdate1.jsp?pro_code=");
      out.print(code);
      out.write("\">Edit</a>\r\n");
      out.write("    </td>\r\n");
      out.write("      \r\n");
      out.write("    ");

    }

	
    
      out.write("\r\n");
      out.write("     \r\n");
      out.write("     </table>\r\n");
      out.write(" <center> NET AMOUNT:<input type=\"text\" name=\"tot\" value=\"");
      out.print(tmp);
      out.write("\"></center>\r\n");
      out.write("    <br>\r\n");
      out.write("    <center><a href=\"");
      out.print(request.getContextPath());
      out.write("/JSP/salesperson/category1.jsp\">Add More Items To Cart</a></center><br></br>\r\n");
      out.write(" <center><input type=\"submit\" value=\"Pay...The...Amount\"></input></center> \r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("   ");
String status=null;
    status=(String)request.getAttribute("InsertSuccess");
    if(status==null)
    {
    }
    else
    {
    
      out.write("\r\n");
      out.write("    <center><font color=\"green\"><b>");
      out.print(status);
      out.write("</b></font></center>\r\n");
      out.write("    ");

    }
    
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
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
