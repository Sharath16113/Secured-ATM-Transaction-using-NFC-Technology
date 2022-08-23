/**
 @Author : Munna Kumar Singh
 Date : Apr 18, 2013
 File : AuthunticateUserAgent.java
 Package : com.gmail.action
*/
package com.drw.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.drw.HttpClient.CustomUrlResponse;
import com.util.Utility;


@SuppressWarnings("serial")
public class PaymentVerification extends HttpServlet
{
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		
		String reqUrl="",resp="",queryString="";
		String serverIpAddress="",serverPortNumber="",serverAppName="";
		double amountToPay=0,curLatitude=0,curLongitude=0;
		int cvv2Number=0,cardExpiryMonth=0,cardExpiryYear=0;
		String cardType="",cardNumber="",nameOnCard="";
			   
		
		
		try
		{
			
			amountToPay = Utility.parseDouble(request.getParameter("amount_to_pay"));
			cardType = request.getParameter("card_type");
			cardNumber = request.getParameter("card_no");
			nameOnCard = request.getParameter("name_on_card");
			cvv2Number = Utility.parse(request.getParameter("cvv2_no"));
			cardExpiryMonth = Utility.parse(request.getParameter("month"));
			cardExpiryYear = Utility.parse(request.getParameter("year"));
			curLatitude = Utility.parseDouble(request.getParameter("cur_lat"));
			curLongitude = Utility.parseDouble(request.getParameter("cur_long"));
			
			System.out.println("*********** Payment Verification Information ***********");
			
/*			System.out.println("Amout To Pay : "+amountToPay);
			System.out.println("Card Type : " + cardType);
			System.out.println("Card Number : " + cardNumber);
			System.out.println("Name On Card : " + nameOnCard);
			System.out.println("CVV2 Number : " + cvv2Number);
			System.out.println("Card Exp. Date : " + cardExpiryMonth+"/"+cardExpiryYear);
			System.out.println("Cur Loc(Lat,Long) : (" + curLatitude+","+curLongitude+")");
*/			
			
			//Credit Card Authentication Process(Starts)
			serverIpAddress = Utility.getPro("IPaddress").trim();
			serverPortNumber = Utility.getPro("PortNumber").trim();
			serverAppName = Utility.getPro("AppName").trim();
			
			//reqUrl="http://localhost:8080/CreditCardAuthServer/AuthenticateCard?card_no="+cardNumber+"&card_type="+cardType+"";
			//reqUrl="http://"+serverIpAddress+":"+serverPortNumber+"/"+serverAppName+"/AuthenticateCard?card_no="+cardNumber+"&card_type="+cardType+"";
			reqUrl="http://"+serverIpAddress+":"+serverPortNumber+"/"+serverAppName+"/AuthenticateCard?";
			
			queryString="amount_to_pay="+amountToPay+"&card_type="+cardType+"&card_no="+cardNumber+"&name_on_card="+nameOnCard+
			"&cvv2_no="+cvv2Number+"&month="+cardExpiryMonth+"&year="+cardExpiryYear+"&cur_lat="+curLatitude+"&cur_long="+curLongitude;
			
			reqUrl = reqUrl+queryString;
			System.out.println("Credit Card Authentication Server Url :\n" + reqUrl);
			
			resp = CustomUrlResponse.getRespose(reqUrl);
			resp = resp.trim();
			
			System.out.println("\n*********** Payment Verification Result ***********");
			
			if(resp.equals("InvalidCard"))
			{
				System.out.println("Opps,Invalid Card!!!!!");
				System.out.println("Check Your Card Type and Card Number!!!!");
				
				rd = request.getRequestDispatcher("/JSP/cardpay.jsp?no=1");
				rd.forward(request,response);
			}
			else if(resp.equals("InvalidCVV2"))
			{
				System.out.println("Opps,Invalid CVV2 Number!!!!!");
				rd = request.getRequestDispatcher("/JSP/cardpay.jsp?no=2");
				rd.forward(request,response);
			}
			else if(resp.equals("CardIsExpired"))
			{
				System.out.println("Opps,The Card Has Been Expired!!!!!");
				rd = request.getRequestDispatcher("/JSP/cardpay.jsp?no=3");
				rd.forward(request,response);
			}
			else if(resp.equals("CardIsBlocked"))
			{
				System.out.println("Opps,The Card Has Been Blocked!!!!!");
				System.out.println("Please,Contact To The Card Issuing Bank.");
				rd = request.getRequestDispatcher("/JSP/cardpay.jsp?no=9");
				rd.forward(request,response);
			}
			else if(resp.equals("InSufficientBalance"))
			{
				System.out.println("The Card is not having Sufficient Balance To Pay.");
				rd = request.getRequestDispatcher("/JSP/cardpay.jsp?no=4");
				rd.forward(request,response);
			}
			else if(resp.equals("CardMisUsed"))
			{
				System.out.println("Opps,Cardholder is not nearby the Shopping Merchant.");
				System.out.println("Opps,The Card Has been Misused!!!!!");
				rd = request.getRequestDispatcher("/JSP/cardpay.jsp?no=5");
				rd.forward(request,response);
			}
			else if(resp.equals("success"))
			{
				//Removing The Items From Cart
				session.removeAttribute("qd");
				
				System.out.println("Payment Verification Done Successfully.......");
				System.out.println("Payment Done Successfully........");
				//rd = request.getRequestDispatcher("/JSP/cardpay.jsp?no=7");//
				rd = request.getRequestDispatcher("/JSP/payment_confirmation.jsp");//
				rd.forward(request,response);
			}
			else if(resp.equals("failed"))
			{
				System.out.println("Opps,Something Went Wong While Making The Payment!!!!!");
				rd = request.getRequestDispatcher("/JSP/cardpay.jsp?no=6");
				rd.forward(request,response);
			}
			else
			{
				System.out.println("Opps,Something Went Wrong,Try Latter!!!!!");
				rd = request.getRequestDispatcher("/JSP/cardpay.jsp?no=8");
				rd.forward(request,response);
			}
			
		}
		catch (Exception e) 
		{
			System.out.println("Opps,Exception In CreditCardAuthentication=>Verification Servlet : ");
			e.printStackTrace();
		}
	}
}
