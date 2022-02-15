<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
 ${requestScope.message}
 <form method="" action="/startup/">

              <input type="hidden" name="command" value="CREATE_ROUTE"/>
              <input type="text" required placeholder="number" name="number"/></br>
              <input type="text" required placeholder="typeNumber" name="typeNumber"/></br>
              <input type="text" required placeholder="startTime" name="startTime"/></br>
              <input type="text" required placeholder="finishTime" name="finishTime"/></br>
              <input type="text" required placeholder="replacementTime" name="replacementTime"/></br>

              <input type="submit" value="submit"/>

 </form>

 <a href="/startup/dispatcher">dispatcher</a>

</body>
</html>