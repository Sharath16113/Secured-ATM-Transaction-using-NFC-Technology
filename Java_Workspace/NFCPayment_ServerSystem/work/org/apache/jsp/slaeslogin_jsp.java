package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.sql.*;
import com.data.*;

public final class slaeslogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


String oldpass = "";
	String sid = "";
	String pass = "";
	String confirmusr = "";
     StringBuffer sb = null;
	String info = "Opps,Something Went Wrong Try Again..";
	
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	sb = new StringBuffer();
boolean flag = false;
sid = request.getParameter("sid");
System.out.print("sid>>>>>>>>>>>"+sid);
pass = request.getParameter("passs");
System.out.print("pass"+pass);
Class.forName("com.mysql.jdbc.Driver");
String status="no";
Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_nfc_payment", "root", "admin");

Statement stmt=(Statement) con.createStatement();


ResultSet rs=	stmt.executeQuery("select * from d_salesperson where sp_id='"+sid+"' and sp_password='"+pass+"' ");

	
	String alphaNumerics = "123456789";
	String t = "";
	

	for (int i = 0; i < 6; i++) 
	{
	    t += alphaNumerics.charAt((int) (Math.random() * alphaNumerics.length()));
	}
	
	
String email=CommonDAO.getphonenum(sid);

	
	//SendSmscode.SendSMS(phone,"Your OTP is "+" "+t );
	//String email=CommonDAO.getEmail(sid);
    String msg="Hi ,You're One Time Password : "+t;
    SendMailAttachment.sendPersonalizedMail(email, "Regarding the OTP ", msg, "no");
   //result=adminDAO.addRating(type,desc,rating);
	
	flag=CommonDAO.updateotp(sid,pass, t);
	
	
	
		flag=true;
		    sb.append(flag);

		

	
	
	

System.out.println(sb.toString());

	out.println(sb.toString()); 
	
	
	

      out.write("\r\n");
      out.write("\r\n");
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
