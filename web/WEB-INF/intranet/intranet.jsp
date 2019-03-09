<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=8">
        <c:if test="${sessionScope.user==null}">
        <meta http-equiv="Refresh" content="60;URL=nuevapagina.html" />    
        </c:if>        
        <link type="text/css" href="resources/css/default.css" rel="stylesheet">
        <link type="text/css" href="resources/css/black-tie/jquery-ui.css" rel="stylesheet">
        <link type="text/css" href="resources/css/escritorio.css" rel="stylesheet">
        <script type="text/javascript" src="resources/js/jquery.js"></script> 
        <link rel="shortcut icon" type="image/x-icon" href="resources/images/16x16/favicon.ico" />
        
        <script type="text/javascript">
            $("document").ready(function() {
                if ($(".gadget").length == 0) {
                    var divi = $("<div/>", {
                        html: "USTED NO TIENE PERMISOS A NINGUN MODULO COMUNIQUESE CON SU ADMINISTRADOR"
                    }).addClass("ui-state-error").css({"padding": "10px", "margin": "0 auto"});
                    $("#modulos").append($(divi));
                }
                $(".gadget").on("click", function() {
                    var item = $(this);
                    $("#contenido-text").html("<img src='./resources/images/16x16/loader.gif' /> Cargando...")
                    $.ajax({
                        dataType: 'json',
                        cache: true,
                        type: 'post',
                        url: "./Intranet?action=Redirect",
                        data: {"idModulo": $(this).attr("id"), "url": $(this).attr("contextmenu")},
                        success: function() {
                            window.location = item.attr("contextmenu");
                        }
                    });
                });
            });
        </script>
        <title>Control Panel Gestor de Contenido</title>
    </head>
    <body>
       
        <div id="cabecera" class="ui-widget ui-widget-header">
            <c:import url="../jspf/cnorte.jspf" />
        </div>
        <div id="menu">
            <%@include file="../jspf/menu.jspf"%>
        </div>
        <div id="contenido"> 
            <div id="contenido-text"  class="ui-widget ui-state-highlight" style="padding:10px;margin: 5px;">
                Bienvenidos a Nuestro Control Panel Gestor de Contenido Web
            </div>
        </div>
        <div id="cuerpo">
            <div id="centro" class="ui-corner-all">
                <div id="modulos">
                    <div id="gadget">
                        <c:forEach var="gadget" items="${gadgets}">
                            <div id="${gadget.idModulo}" class="gadget ui-widget ui-widget-content ui-corner-all" contextmenu="${gadget.url}">
                                <c:if test="${fn:length(gadget.url)>0}">
                                    <img src="resources/images/modulos/${fn:toLowerCase(fn:substring(gadget.url,2,fn:length(gadget.url)))}.png" />
                                </c:if>
                                <span>${gadget.nombre}</span>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div id="profile">
                    <h2>MIS DATOS</h2>
                    <form>
                        <div>
                            <label>ID Sesi&oacute;n</label><span><c:out value="${pageContext.session.id}" /></span>
                        </div>
                        <div>
                            <label>Usuario</label><span><c:out value="${sessionScope.user}" /></span>
                        </div>
                        <div>
                            <label>Documento de Identidad</label><span><c:out value="${sessionScope.dniusuario}" /></span>
                        </div>
                        <div>
                            <label>Nombre(s)</label><span><c:out value="${sessionScope.nombreUsuario}" /></span>
                        </div>
                        <div>
                            <label>Apellido Paterno</label><span><c:out value="${sessionScope.apellidoPaterno}" /></span>
                        </div>
                        <div>
                            <label>Apellido Materno</label><span><c:out value="${sessionScope.apellidoMaterno}" /></span>
                        </div>
                    </form>
                </div>
            </div>
        </div>   
    
    </body>
</html>