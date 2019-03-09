<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link type="text/css" rel="stylesheet" href="resources/css/default.css">
        <link type="text/css" rel="stylesheet" href="resources/css/${estilo}/jquery-ui.css">
        <script type="text/javascript" src="resources/js/jquery.js"></script>
        <script type="text/javascript" src="resources/js/jquery-ui.js"></script>
        <script type="text/javascript" src="resources/js/CJRoles.js"></script>
        <script type="text/javascript" src="resources/js/admin/controller/temaController.js"></script>
        <title>Temas</title>   
        <style>
            .thumbnail {
                display: block;
                float: left;
                margin-right: 0.8em;
                margin-left: 0.8em;
                margin-bottom: 2.3em;
                width: 150px;
                text-align: center;
                float:left;
                text-align: center;
            }
            .thumbnail table {
                width: 100%;
            }
            #contenedor {
                position: relative;
                float: left;
                width: 100%;
                
                padding-right: 2em;
            }
            .marco {
                position: relative;
                float: left;
                width: 100%;
            }
        </style>
    </head>
    <body>
        <div id="cabecera" class="ui-widget ui-widget-header">
            <%@include file="../../jspf/cnorte.jspf" %>            
        </div>
        <div id="menu">
            <%@include file="../../jspf/menu.jspf" %>
        </div>
        <div id="cuerpo">
            <div id="c-derecho">
                <c:import url="../../menuDerecho.jsp" />
            </div>

            <div id="c-izquierdo" >
                <div class="marco ui-widget-content">
                    <h2 class="ui-widget-header">Administrar Temas</h2>
                    <div id="message" class="message ui-widget ui-state-highlight">Administre sus temas de manera fácil y sencilla</div>
                    <div class="content-marco" ></div>
                    <div id="contenedor" ></div>
                </div>
            </div>

        </div>
    </body>
</html>