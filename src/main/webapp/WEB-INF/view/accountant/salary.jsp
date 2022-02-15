<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <form method="" action="/startup/">
                 <h1>Show spent time</h1>
                 <input type="hidden" name="command" value="WORK_TIME"/>

                 personnel number</br>
                 <input type="text" required placeholder="" name="personalNumber"/></br>

                 <input type="submit" value="submit"/>
    </form>

    <h1>Accrually salary</h1>

    <form method="post" action="/startup/">
                     <input type="hidden" name="command" value="WORK_MONEY"/>

                     personnel number</br>
                     <input type="text" required placeholder="" name="personalNumber"/></br>
                     hour</br>
                     <input type="text" required placeholder="" name="hour"/></br>
                     money</br>
                     <input type="text" required placeholder="" name="money"/></br>

                     <input type="submit" value="submit"/>
    </form>

<c:if test="${requestScope.times != null}">
    <c:forEach var="workTime" items="${requestScope.times}">

            <p><c:out value="${workTime}" /></p>

    </c:forEach>
</c:if>


</body>
</html>