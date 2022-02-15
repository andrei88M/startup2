<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<head>
    <title>schedule</title>
    <link href="resources/style.css" rel="stylesheet" type="text/css">
</head>

<form method="" action="/startup/">
              <input type="hidden" name="command" value="SEE_SCHEDULE"/>
              <input type="text" required placeholder="month" name="month"/></br>
              <input type="text" required placeholder="year" name="year"/></br>

              <input type="submit" value="submit"/>
 </form>

 <c:forEach items="${requestScope.schedule}" var="m">

    ${m.day }  ${m.month } ${m.route} ${m.replacement }
 </br>
 </c:forEach>


</body>
</html>