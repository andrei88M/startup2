<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="resources/style.css" rel="stylesheet" type="text/css">
</head>
<body>

    <form method="post" action="/startup/" class="center-children">
     <input type="hidden" name="command" value="AUTHENTICATION"/>
       login
               </br>
       <input type="text" name="login"/>
               </br>
       password
               </br>
       <input type="password" name="password"/>
               </br></br>
       <input type="submit" value="submit"/>
       <a href="/startup/registration">registration</a>
    </form>
</body>
</html>