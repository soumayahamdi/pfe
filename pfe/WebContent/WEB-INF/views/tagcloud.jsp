<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>Tag cloud</title>

<style type="text/css" media="screen">
    body{
        font-family: Arial, "MS Trebuchet", sans-serif; 
        background-color: #FFFFFF;
    }
    #list{
        margin:0 auto;
        height:380px;
        width:600px;
        overflow:hidden;
        position:relative;
        background-color: #FFFFFF;
/*         gris */
    }
    #list ul,
    #list li{
        list-style:none;
        margin:0;
        padding:0;
          
    }
    #list a{
        position:absolute;
        text-decoration: none;
        color:black;
          }
    #list a:hover{
        color:gris;
       
    }
</style>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<div id="list">
    
 <c:forEach items="${topicForm.topics}" var="topic" varStatus="status"> 
  
        <ul>
             <li><a href="#">${topic.name}</a></li>

         </ul>
        
    </c:forEach> 

</div>  

<script type="text/javascript">


$(document).ready(function(){
    
var element = $('#list a');
var offset = 0; 
var stepping = 0.03;
var list = $('#list');
var $list = $(list)

$list.mousemove(function(e){
    var topOfList = $list.eq(0).offset().top
    var listHeight = $list.height()
    stepping = (e.clientY - topOfList) /  listHeight * 0.2 - 0.1;
    
});


for (var i = element.length - 1; i >= 0; i--)
{
    element[i].elemAngle = i * Math.PI * 2 / element.length;
}


setInterval(render, 20);


function render(){
    for (var i = element.length - 1; i >= 0; i--){
        
        var angle = element[i].elemAngle + offset;
        
        x = 120 + Math.sin(angle) * 30;
        y = 45 + Math.cos(angle) * 40;
        size = Math.round(10 - Math.sin(angle) * 20);
        
        var elementCenter = $(element[i]).width() / 2;

        var leftValue = (($list.width()/2) * x / 100 - elementCenter) + "px"

        $(element[i]).css("fontSize", size + "pt");
        $(element[i]).css("opacity",size/100);
        $(element[i]).css("zIndex" ,size);
        $(element[i]).css("left" ,leftValue);
        $(element[i]).css("top", y + "%");
    }
    
    offset += stepping;
}

    
});

</script>

</body>
</html>