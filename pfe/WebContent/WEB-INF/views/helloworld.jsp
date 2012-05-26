
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

pageEncoding="ISO-8859-1"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<head>
  <link rel="SHORTCUT ICON" href="https://encrypted-tbn3.google.com/images?q=tbn:ANd9GcRqHF1nnFEKxU8muYPH8UOwyAp_V6aIWvHI5_oTqu35eeY_fgGN8B733l7i"/>
     <title>Data Mining </title>  
	 
</head>
<head>
<style>
body {
    background-position: left 30px;
    background-attachment: fixed;
    background-repeat: repeat;
    background-repeat: no-repeat;
    background-color: #ACDED6;
	background-image:url("2.gif");
	-webkit-transform-style: preserve-3d; 
	-webkit-perspective: 600px;
 }
.card { position: absolute; left:186px; top:156px; padding: 400px;
height: 150px; width: 150px; border-radius: 20 px; border: 0px solid tan;
}
.front {background-color: #FFFFFF; filter:alpha(opacity=75);-moz-opacity:0.5;opacity: 0.75;}
</style>
<style>
#menuDeroulant
{
	width: 1348px;
	height: 55px;
	list-style-type: none;
	margin:-8;
	padding:0;
	border: 0;
	position: absolute;
	top: 0;
	left: 0;
}
#menuDeroulant li
{
	float: left;
	width: 337.9px;
	margin: 0;
	padding: 0;
	border: 0;
}
#menuDeroulant li a:link, #menuDeroulant li a:visited
{
	display: block;
	height: 50%;
	width: 320px; // nzid fiha ki n7eb les block ywalliw lés9in
	margin: 0;
	padding: 4px 8px;
	border-right: 0px solid #fff;
	text-decoration: none;
	color:#FFFFFF;
	background-color:#404040;
	text-align:center;
	text-decoration:none;
	//covertir en majus.
	text-transform:uppercase;
}
#menuDeroulant li a:hover { background-color:#202020; }
#menuDeroulant li a:active { background-color: #5F879D; }
#menuDeroulant .sousMenu
{
	display: none;
	list-style-type: none;
	margin: 0;
	padding: 0;
	border: 0;
}
#menuDeroulant .sousMenu li
{
	float: none;
	margin: 0;
	padding: 0;
	border: 0;
	width: 270px;
	border-top: 1px solid transparent;
	border-right: 1px solid transparent;
}
#menuDeroulant .sousMenu li a:link, #menuDeroulant .sousMenu li a:visited
{
	display: block;
	color: #FFF;
	margin: 0;
	border: 0;
	text-decoration: none;
	background: transparent repeat;
}
#menuDeroulant .sousMenu li a:hover
{
background-image: none;
font-size:150%;
color:black;
font-family:monospace;

}
#menuDeroulant li:hover > .sousMenu { display: block; }
</style>
<style>
.scrollbox { overflow: scroll; padding:3px; width: 650px; height:400px; border-style: solid; border-width: 1px; top: 10 px; left: 20 px;
border-color:black; background-color:transparent; text-align: left; letter-spacing: 1px; word-spacing: 2px; font-size: 12px;
color:black; font-family: arial; }
</style>
<style>
#outerdiv {
width: 250px; position: relative;
}
#innerdiv {
position: absolute; left: -380px; top: 130px; width:1680px; height:50px;
}

</style>
<script type="text/javascript">
function startTime()
{
var today=new Date();
var h=today.getHours();
var m=today.getMinutes();
var s=today.getSeconds();
// add a zero in front of numbers<10
m=checkTime(m);
s=checkTime(s);
document.getElementById('txt').innerHTML=h+":"+m+":"+s;
t=setTimeout('startTime()',500);
}
function checkTime(i)
{
if (i<10)
  {
  i="0" + i;
  }
return i;
}
</script>

</head>
<HEAD>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>

	
		  <script>
		  <c:if test="${not empty location }">
		  function ajout(){
			  
			  $.ajax({
		            type:       "post",
		            url:        "cc.html",
		           
		            success:    function(msg) {

		                $('#tweets').hide();

		                $("#tweets").html( msg )
		                .fadeIn("slow");
		            }
		        });
			  //setInterval (ajout(), 5000);
			 
		  }
		  function ajout1(){ajout();
		  timeOut = setTimeout('ajout1()', 2000);
		  }
		  $(document).ready(ajout1() 

       
    
		   );
		  </c:if>
</script>

</HEAD>
<body onload="startTime()" > 
<!--Recherche-->
<form  action="helloworld.html" name="frmMain"  id="frmMain"  method="post"> 
	<div>
	<input TYPE="text" NAME="text" id=search maxlength=255 value="" placeholder=Search autocomplete=off style="position: absolute; top: 110 px; left: 500 px;"/>  
	<input type="submit" value="Submit"  class="affichimag" id=submit  style="position: absolute; top: 100 px; left: 680 px; width: 35 px; height: 35 px; " /><br><br>
	</div>
</form>
<ul id="menuDeroulant">
		<li>
			<a href="#">Home</a>
			</li>
		<li>
			<a href="#">Facebook</a>
				</li>
		<li>
			<a href="#">LinkedIn</a>
			</li>
		<li>
			<a href="#">Twitter</a>
			<ul class="sousMenu">			      
				<li><a href="home.jsp" >search using Key word</a></li>
				<li><a href="Search_by_area.jsp">Search by area</a></li>
				<li><a href="Trending_Topics.jsp">Trending Topics</a></li>
				<li><a href="Track_profiles.jsp">Track profiles</a></li>
				<li><a href="compare.jsp">Comparing keywords</a></li>
				<li><a href="NewFile.html">Analysis</a></li>				
			</ul>
		</li>
</ul>
<br /> <br /><br /> <br /> <br /><br /> <br /> <br /><br /> <br /> <br /><br /> <br /> <br /><br /> <br /> <br /><br /> <br /> <br /><br /> <br /> <br /><br /> <br /> <br /><br /> 
<dd><dd><dd><dd><h3 id="txt"></h3> 
<div class="card front" id="front"> 
<table>
	<tr>
		<td>
			<fieldset style="position: absolute; width: 470px; top: 50 px; left: 20 px; height: 430px;">
				<legend> <h3>Tweets </h3></legend>
				<div class="scrollbox" id="tweets"style="width:460px; height: 400px;" />  
			</fieldset>

		</td>
	<td>
	<c:if test="${not empty location }">
	
	<img src="fff.png" style="position: absolute; top: 80 px; left: 550 px; width: 350px; height: 420px; font-size:250%;"></c:if> </td>
	</tr>
<tr>
<td>
	<div id="outerdiv">
		<div id="innerdiv">  
	
		<c:if test="${not empty location }">
		<iframe width="890" height="400" src="formoutput.html" > </iframe> </c:if> 
		</div>
	</div>
	</td>
</tr>
</table>
</div>
</body>
</html>