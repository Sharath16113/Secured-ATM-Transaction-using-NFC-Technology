<!DOCTYPE HTML>
<html>

<head>
  <title>NFC Online Payement</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <link rel="stylesheet" type="text/css" href="css/style.css" />
  <!-- modernizr enables HTML5 elements and feature detects -->
  <script type="text/javascript" src="js/modernizr-1.5.min.js"></script>
</head>

<body>
  
  <div id="main">
    <div id="top_container" style="height:340px">
	  <header>
        <center><img  src="images/title.png"/></center> 
        <nav>
          <ul class="lavaLampWithImage" id="lava_menu">
            
            <li><a href="<%=request.getContextPath()%>/JSP/Admin/SalesDetails.jsp" target="myframe">SalesPerson</a></li>
            <li><a href="<%=request.getContextPath()%>/JSP/Admin/CategoryDetails.jsp" target="myframe">CategoryDetails</a></li>
           <li><a href="<%=request.getContextPath()%>/JSP/Admin/SubcatDetails.jsp" target="myframe">SubcategoryDetails</a></li>
           <li><a href="<%=request.getContextPath()%>/JSP/Admin/ProductDetails.jsp" target="myframe">ProductDetails</a></li>
           <li><a href="<%=request.getContextPath()%>/JSP/Admin/AChangePassword.jsp" target="myframe">ChangePassword</a></li>
          
           <li><a href="<%=request.getContextPath()%>/index.jsp" >Logout</a></li>
          </ul>
        </nav>
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
      <div id="sidebar_container">
       <iframe src="<%=request.getContextPath()%>/JSP/Admin/SalesDetails.jsp" style="position: absolute;top:500px;width: 960px;height:400px;left: 195px;border-color: #556B2F;" name="myframe" >
                
               
                </iframe>
		
        
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
</html>
