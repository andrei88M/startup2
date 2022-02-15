<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="resources/style.css" rel="stylesheet" type="text/css">
</head>
<body>

    <form method="post" action="/startup/" class="center-children" >
             <input type="hidden" name="command" value="REGISTRATION"/>

             name</br>
             <input type="text" required placeholder="" name="name"/></br>

             surname</br>
             <input type="text" required placeholder="" name="surname"/></br>

             personnelNumber</br>
             <input type="text" required placeholder="" name="personnelNumber"/></br>

             login</br>
             <input type="text" required placeholder="" name="login"/></br>

             password</br>
             <input type="password" required placeholder="" name="password1"/></br>

             password</br>
             <input type="password" required placeholder="" name="password2"/></br></br>

             <input type="submit" value="submit"/>     <a href="/startup/authentication" >authorization</a>
    </form>

</body>
</html>