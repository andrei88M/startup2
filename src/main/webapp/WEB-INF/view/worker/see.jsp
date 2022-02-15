<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<head>
    <title>see</title>
    <link href="resources/style.css" rel="stylesheet" type="text/css">
</head>

<form method="" action="/startup/">
              <input type="hidden" name="command" value="SEE_WORK_TIME"/>
              <input type="text" required placeholder="day" name="day"/></br>
              <input type="text" required placeholder="month" name="month"/></br>

              <input type="submit" value="submit"/>
 </form>

 <c:forEach items="${requestScope.list}" var="m">

    day${m.day }  month${m.month }  time${m.time}
</br>
 </c:forEach>

 <form method="" action="/startup/">
               <input type="hidden" name="command" value="SEE_MONEY"/>
               <input type="text" required placeholder="month" name="month"/></br>

               <input type="submit" value="submit"/>
  </form>
  <c:forEach items="${requestScope.money}" var="n">
      ${n}
  </br>
   </c:forEach>


</body>
</html>