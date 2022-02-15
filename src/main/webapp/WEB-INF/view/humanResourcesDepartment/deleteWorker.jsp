<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="resources/style.css" rel="stylesheet" type="text/css">
</head>
<body>
         <form method="" action="/startup/" class="center-children">

                  <input type="hidden" name="command" value="DELETE_WORKER"/>
                  <input type="text" required placeholder="personnelNumber" name="personnelNumber"/></br>

                  <input type="submit" value="submit"/>
         </form>

        <a href="/startup/hrd">hrd</a>

</body>
</html>