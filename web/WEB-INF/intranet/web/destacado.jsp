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
        <script type="text/javascript" src="resources/js/jquery.corner.js"></script>
        <script type="text/javascript" src="resources/js/CJRoles.js"></script>
        <script type="text/javascript" src="resources/js/jHtmlArea.js"></script>
        <script type="text/javascript" src="resources/js/admin/controller/destacadoController.js"></script>
        <link rel="shortcut icon" type="image/x-icon" href="resources/images/16x16/favicon.ico" />
        <title>Destacados</title>       
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
            <div class="paper" id="paper"  >
                <div class="cerrarPaper" style="display:block; margin: -40px; float:right; cursor: pointer">(X) Cerrar</div>
                <div class ="titulo">
                </div><div class="imagen" >  </div>
                <div class="contenido">
                </div>
                <!--<botton class="button green" id="imprimir" style="float:left"> Imprimir </botton>-->
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
                    <h2 class="ui-widget-header">Administrar Destacados</h2>
                    <div id="message" class="message ui-widget ui-state-highlight">Destaque el contenido mas relevante y promocional en la seccion superior de la p&aacute;gina inicial.</div>
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
                        <form id="frmRegistroNoticia" style="display: none;">
                            <div>
                                <label>Fecha de publicaci&oacute;n:</label>
                                <input id="fechaPublicacion" class="casilla" readonly="true" type="text" style="width: 100px;"  />
                            </div>
                            <div>
                                <label>Titulo de destacado:</label>
                                <textarea id="tituloDestacado" class="casilla" style="text-transform: uppercase;width: 649px; height: 50px; float: left; font-size: 12px" name="tituloDestacado" ></textarea>
                            </div>
                            <div>
                                <label>Contenido de destacado:</label>
                                <textarea id="contenidoDestacado" class="casilla" style="width: 649px; height: 200px; float: left; font-size: 12px" name="contenidoDestacado" ></textarea>
                            </div>
                            <div>
                                <label>Enlace del destacado:</label>
                                <input id="urlDestacado" class="casilla" type="text" />
                            </div>
                            <div>
                                <label>Foto del destacado (Flickr):</label>
                                <input id="fotoDestacado" class="casilla" type="text" />
                            </div>

                        </form>
                    </div>   
                    <div id="noticias">
                    </div>
                    <div id="busqueda-more" class="busqueda-more">
                        <div class="b-izq">
                            <input type="hidden" id="txtLimit" value="7" />
                            <input type="hidden" id="txtStart" value="0" />
                            <input type="hidden" id="txtCurrent" value="0" />
                            <button id="btnSeguir" class="button">M&aacute;s Destacados</button>
                        </div>
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

    </body>
</html>
