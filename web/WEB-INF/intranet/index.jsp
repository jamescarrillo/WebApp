<%-- 
    Document   : index
    Created on : Jun 20, 2012, 10:16:35 PM
    Author     : jpgprog84
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=8">
        <link type="text/css" rel="stylesheet" href="./resources/css/default.css">
        <link type="text/css" rel="stylesheet" href="./resources/css/black-tie/jquery-ui.css">
        
        <link rel="shortcut icon" type="image/x-icon" href="resources/images/16x16/favicon.ico" />
        <title>Gestor de Contenido Web</title>
    </head>
    <body>
        <div id="cabecera" class="ui-widget ui-widget-header">
            <%@include file="../jspf/cnorte.jspf" %>            
        </div>
        
        <div id="menu">           
            <%@include file="../jspf/menu.jspf" %>
        </div>
        <div id="cuerpo">
            <div id="c-derecho">
                <c:import url="../menuDerecho.jsp" />     
            </div>
        </div>
            
    </body>
</html>
