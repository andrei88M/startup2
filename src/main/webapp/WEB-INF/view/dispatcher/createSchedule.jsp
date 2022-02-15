<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

 <form method="post" action="/startup/">

                           <input type="hidden" name="command" value="CREATE_SCHEDULE"/>
                           <input type="text" required placeholder="day" name="day"/></br>
                           <input type="text" required placeholder="month" name="month"/></br>
                           <input type="text" required placeholder="year" name="year"/></br>
                           <input type="text" required placeholder="personnelNumber" name="personnelNumber"/></br>
                           <input type="text" required placeholder="route" name="route"/></br>
                           <input type="text" required placeholder="type" name="type"/></br>
                           <input type="text" required placeholder="replacement" name="replacement"/></br>


              <input type="submit" value="submit"/>
 </form>
<a href="/startup/dispatcher">dispatcher</a>
</body>
</html>