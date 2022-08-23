<!DOCTYPE HTML>
<html>
<%! 
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
%>

<head>
  <title>NFC_Online_Payement</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <link rel="stylesheet" type="text/css" href="css/style.css" />
  <!-- modernizr enables HTML5 elements and feature detects -->
  <script type="text/javascript" src="js/modernizr-1.5.min.js"></script>
  <link rel="stylesheet" type="text/css" href="css/style1.css" />
</head>

<body>
  
  <div id="main">
    <div id="top_container" style="height:340px">
	  <header>
       <center><img src="images/title.png"/></center> 
      </header>
      <div class="slideshow">
        <ul class="slideshow">
          <li class="show"><img width="950" height="250" src="images/1.jpg" /></li>
          <li ><img width="950" height="250" src="images/1.jpg" /></li>
          <li ><img width="950" height="250" src="images/1.jpg" /></li>
        </ul>
	  </div>		
    </div>	  

    <div id="site_content">
      
      <div id="content">
       <div class="wrapper">
		
			<div class="content" >

				<div id="form_wrapper" class="form_wrapper" >
				
				
					
					<!-------------------------------Login Form -------------------------------------->
					
					
					
					<form class="login active" action="<%=request.getContextPath()%>/LoginServlet" method="post">
						<h3 style="height: 30px;">Sales Person Login</h3>
						<div style="height: 60px">
							<label >Sales Person ID:</label>
							<input type="text" name="salesid" id="userid" placeholder="Sales Person ID" required="yes"/>
							
						</div>
						<div style="height: 60px">
							<label >Password: </label>
							<input type="password" name="salespass" id="password" placeholder="Password" required="yes"/>
							
						</div>
					
						
						<div class="bottom" style="height: 100px">
							
							<input type="submit" value="Login" onclick="return "></input>
							<a href="index.jsp" rel="login" class="linkform">Admin Login</a>
							<div class="clear"></div>
						</div>
					</form>
				
				</div>
			</div>
							

		</div>
		
      </div>
    </div>
   
  </div>
  <!-- javascript at the bottom for fast page loading -->
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/jquery.easing.min.js"></script>
  <script type="text/javascript" src="js/jquery.lavalamp.min.js"></script>
  <script type="text/javascript" src="js/image_fade.js"></script>
  <script type="text/javascript">
    $(function() {
      $("#lava_menu").lavaLamp({
        fx: "backout",
        speed: 700
      });
    });
  </script>
</body>

<%
	int no=convert(request.getParameter("no"));
	if(no==1)
	{
		    
%>       
    		
    	 <script type="text/javascript">
    			alert('Enter Username and Password !');
    			</script>
<%
	}
	if(no==2)
	{
%>
		
    		
    	<script type="text/javascript">
    			alert(' Please,Enter Your Username.!!');
    			</script>
<%
	}
	if(no==3)
	{
%>
		
    	
    	
    	<script type="text/javascript">
    			alert(' Please,Enter Your Password.!');
    			</script>
<%
	}
%>
<%
	if(no==4)
	{
%>
		<script type="text/javascript">
    			alert('Sorry invalid username and password');
    			</script>
<%
	}
%>
<%
	if(no==5)
	{
%>
		
		
	<script type="text/javascript">
    			alert('You have Logged out successfully...!');
    			</script>	
<%
	}
%>

</html>
