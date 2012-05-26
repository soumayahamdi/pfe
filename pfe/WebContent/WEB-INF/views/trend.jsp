<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<body>
<table>
 
   <c:forEach items="${topicForm.topics}" var="topic" varStatus="status"> 
        <tr> 
            <td>${topic.name}</td> 

         </tr> 
    </c:forEach> 

</table>
<br/>

</body>
</html>