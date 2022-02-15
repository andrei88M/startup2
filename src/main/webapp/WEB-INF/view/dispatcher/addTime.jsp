<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

 <form method="" action="/startup/">

              <input type="hidden" name="command" value="ADD_TIME"/>
              <input type="text" required placeholder="number worker" name="number"/></br>
              <input type="text" required placeholder="quantity time" name="time"/></br>
              <input type="text" required placeholder="month" name="month"/></br>
              <input type="text" required placeholder="day" name="day"/></br>

              <input type="submit" value="submit"/>
 </form>
<a href="/startup/dispatcher">dispatcher</a>
</body>
</html>