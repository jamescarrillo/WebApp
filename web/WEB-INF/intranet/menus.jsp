<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <c:forEach var="modul" items="${modulos}">
        <div class="menu-lateral  ui-widget-content">
            <h2 class="ui-widget-header">${modul.nombre}</h2>            
            <ul>
                <c:forEach var="subMo" items="${modul.subModulos}">
                    <li><a href="${subMo.url}">${subMo.nombre}</a></li>
                </c:forEach>
            </ul>
        </div>
    </c:forEach>
</div>