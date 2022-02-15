<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="resources/style2.css" rel="stylesheet" type="text/css">
</head>
<body>
         <form method="post" action="/startup/" class="center-children">

                  <input type="hidden" name="command" value="CREATE_WORKER"/>
                  name</br>
                  <input type="text" required placeholder="" name="name"/></br>
                  surname</br>
                  <input type="text" required placeholder="" name="surname"/></br>
                  personnel number</br>
                  <input type="text" required placeholder="" name="personnelNumber"/></br>
                  telephone</br>
                  <input type="text" required placeholder="" name="telephone"/></br>
                  role</br>
                  <input type="text" required placeholder="" name="role"/></br>

                  <input type="submit" value="submit"/>
         </form>

        <a href="/startup/hrd">hrd</a>

</body>
</html>