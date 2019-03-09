<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link type="text/css" rel="stylesheet" href="resources/css/default.css">
        <link type="text/css" rel="stylesheet" href="resources/css/jHtmlArea/jHtmlArea.css">
        <link type="text/css" rel="stylesheet" href="resources/css/${estilo}/jquery-ui.css">
        <script type="text/javascript" src="resources/js/jquery.js"></script>
        <script type="text/javascript" src="resources/js/jquery-ui.js"></script>
        <script type="text/javascript" src="resources/js/CJRoles.js"></script>
        <script type="text/javascript" src="resources/js/jHtmlArea.js"></script>
        <script type="text/javascript" src="resources/js/admin/controller/multimediaController.js"></script>
        <link rel="shortcut icon" type="image/x-icon" href="resources/images/16x16/favicon.ico" />
        <title>Noticias Multimedia</title>       
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
            <div class="eliminarQuestion ui-widget ui-dialog" style="display: none; font-size: 12px;">
                <div class="ui-widget ui-state-highlight ui-corner-all" style="padding:5px;">
                    <p style="font-size: 13px;padding:5px;">
                        <span id="msg-icon" style="float: left; margin-right: .3em;"></span><span class="msg-html"></span>
                    </p>
                </div>
                <div style="margin-top: 5px; overflow: hidden;font-size: 12px;">
                    <input class="noMessage ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover" style="padding:3px;float: right;margin-left: 5px;" type="button" value="No" />
                    <input class="siMessage ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover" style="padding:3px;float: right;" type="button" value="S&iacute;" />        
                </div>
            </div>
            <div id="c-izquierdo">

                <div class="marco ui-widget-content">
                    <h2 class="ui-widget-header">Administrar Noticias Multimedias</h2>
                    <div id="message" class="message ui-widget ui-state-highlight">Administre las noticias  multimedia de una manera m&aacute;s f&aacute;cil, con integraci&oacute;n a Youtube</div>
                    <div class="content-marco">
                        <form id="frmBuscador" action="#">
                            <div style="overflow: hidden;padding:5px;font-size:12px;">
                                <input id="txtBuscador" style="float: left;padding:5px;width: 75%;" type="text"/>
                                <button id="btnNuevo" type="button" dir="nuevo" style="float: right;margin-left:5px;">Nuevo</button>
                                <button id="btnBuscar" type="button">Buscar</button>
                                <button id="btnCancelar" type="button" style="display: none;float: right;margin-left:5px; ">Cancelar</button>  
                                <button id="btnGuardar" type="button"  style="display: none;">Guardar</button>
                            </div>
                        </form>
                        <form id="frmRegistroMultimedia" style="display: none;">
                            <div>
                                <label>Fecha de publicaci&oacute;n:</label>
                                <input class="casilla" id="fechaPublicacion" readonly="true" type="text" style="width: 100px;"  />
                            </div>
                            <div>
                                <label>Titulo del video Multimedia:</label>
                                <input class="casilla" id="tituloMultimedia" type="text" />
                            </div>
                            <div>
                                <label>Dirección URL del video (youtube)</label>
                                <input class="casilla" id="fuenteMultimedia" type="text" />
                            </div>

                            <div id="ivideo" style="text-align: center"></div>
                        </form>
                    </div>   
                    <div id="noticias"></div>
                    <div id="busqueda-more" class="busqueda-more">
                        <div class="b-izq">
                            <input type="hidden" id="txtLimit" value="7" />
                            <input type="hidden" id="txtStart" value="0" />
                            <input type="hidden" id="txtCurrent" value="0" />
                            <button id="btnSeguir" class="button">M&aacute;s Videos </button>
                        </div>
                    </div>   
                </div>
            </div>
            <div class="eliminarQuestionPublic ui-widget ui-dialog" style="display: none; font-size: 12px;">
                <div class="ui-widget ui-state-highlight ui-corner-all" style="padding:5px;">
                    <p style="font-size: 13px;padding:5px;">
                        <span id="msg-icon-public" style="float: left; margin-right: .3em;"></span><span class="msg-html-public"></span>
                    </p>
                </div>
                <div style="margin-top: 5px; overflow: hidden;font-size: 12px;">
                    <input class="noMessagePublic ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover" style="padding:3px;float: right;margin-left: 5px;" type="button" value="No" />
                    <input class="siMessagePublic ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover" style="padding:3px;float: right;" type="button" value="S&iacute;" />        
                </div>
            </div>
        </div>

    </body>
</html>