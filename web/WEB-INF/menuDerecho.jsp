<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div>    
    <c:forEach var="etiqueta" items="${gadgets}">
        <input id="uri" value="${uri}" type="hidden" /> 
        <div class="menu-lateral ui-widget ui-widget-content">
            <c:if test="${etiqueta.idEtiqueta==0}">
                <h2 class="ui-widget-header">GENERAL</h2>
            </c:if>
            <c:if test="${etiqueta.idEtiqueta>0}">
                <h2 class="ui-widget-header">${etiqueta.descripcion}</h2>
            </c:if>
            <ul>
                <c:forEach var="subMo" items="${etiqueta.subModulos}" >
                    <li id="${subMo.idSubModulo}" class="menu-lateral"><a  href="${subMo.url}&id=${subMo.idSubModulo}">${subMo.nombre}</a></li>
                </c:forEach>
            </ul>
        </div>
    </c:forEach>
</div>