<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>message</title>
    <link href="resources/style.css" rel="stylesheet" type="text/css">
</head>
<body>
    <h1>write message</h1>
   <form method="post" action="/startup/">
                 <input type="hidden" name="command" value="MESSAGE_WRITE"/>
                 message</br>
                 <input type="text" required placeholder="" name="text"/></br>
                 to</br>
                 <input type="text" required placeholder="" name="to"/></br>

                 <input type="submit" value="submit"/>
    </form>

    <h1>read message</h1>
    <form method="" action="/startup/">
                     <input type="hidden" name="command" value="MESSAGE_READ"/>
                     from</br>
                     <input type="text" required placeholder="" name="from"/></br>

                     <input type="submit" value="submit"/>
        </form>

     <c:forEach items="${requestScope.messages}" var="message">
         ${message}
     </br>
      </c:forEach>

</body>
</html>