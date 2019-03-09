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
        <script type="text/javascript" src="resources/js/CjGrid2.js"></script>
        <script type="text/javascript" src="resources/js/admin/controller/documentosgestionController.js"></script>
        <link rel="shortcut icon" type="image/x-icon" href="resources/images/16x16/favicon.ico" />
        <title>Documentos de Gestion</title>       
        <style>
            /* force a height so the tabs don't jump as content height changes */
            #tabs .tabs-spacer { float: left; height: 200px; }
            .tabs-bottom .ui-tabs-nav { clear: left; padding: 0 .2em .2em .2em; }
            .tabs-bottom .ui-tabs-nav li { top: auto; bottom: 0; margin: 0 .2em 1px 0; border-bottom: auto; border-top: 0; }
            .tabs-bottom .ui-tabs-nav li.ui-tabs-active { margin-top: -1px; padding-top: 1px; }
            .tabla{width: 100%}
            .ui-icon { cursor:pointer}

            /* the norm */
            #gritter-notice-wrapper {
                position:fixed;
                top:20px;
                right:20px;
                width:301px;
                z-index:9999;
            }
            #gritter-notice-wrapper.top-left {
                left: 20px;
                right: auto;
            }
            #gritter-notice-wrapper.bottom-right {
                top: auto;
                left: auto;
                bottom: 20px;
                right: 20px;
            }
            #gritter-notice-wrapper.bottom-left {
                top: auto;
                right: auto;
                bottom: 20px;
                left: 20px;
            }
            .gritter-item-wrapper {
                position:relative;
                margin:0 0 10px 0;
                background:url('./resources/images/ie-spacer.gif'); /* ie7/8 fix */ 
            }
            .gritter-top {
                background:url(./resources/images/gritter.png) no-repeat left -30px;
                height:10px;
            }
            .hover .gritter-top {
                background-position:right -30px;
            }
            .gritter-bottom {
                background:url(./resources/images/gritter.png) no-repeat left bottom;
                height:8px;
                margin:0;
            }
            .hover .gritter-bottom {
                background-position: bottom right;
            }
            .gritter-item {
                display:block;
                background:url(./resources/images/gritter.png) no-repeat left -40px;
                color:#eee;
                padding:2px 11px 8px 11px;
                font-size: 11px;
                font-family:verdana;
            }
            .hover .gritter-item {
                background-position:right -40px;
            }
            .gritter-item p {
                padding:0;
                margin:0;
                word-wrap:break-word;
            }
            .gritter-close {
                display:none;
                position:absolute;
                top:5px;
                left:3px;
                background:url(./resources/images/gritter.png) no-repeat left top;
                cursor:pointer;
                width:30px;
                height:30px;
            }
            .gritter-title {
                font-size:14px;
                font-weight:bold;
                padding:0 0 7px 0;
                display:block;
                text-shadow:1px 1px 0 #000; /* Not supported by IE :( */
            }
            .gritter-image {
                width:48px;
                height:48px;
                float:left;
            }
            .gritter-with-image,
            .gritter-without-image {
                padding:0;
            }
            .gritter-with-image {
                width:220px;
                float:right;
            }
            /* for the light (white) version of the gritter notice */
            .gritter-light .gritter-item,
            .gritter-light .gritter-bottom,
            .gritter-light .gritter-top,
            .gritter-light .gritter-close {
                background-image: url(./resources/images/gritter-light.png);
                color: #222;
            }
            .gritter-light .gritter-title {
                text-shadow: none;
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
            <div id="c-izquierdo">
                <div class="marco ui-widget-content">
                    <h2 class="ui-widget-header ">Gesti&oacute;n  de Documentos</h2>
                    <div id="message" class="message ui-widget ui-state-highlight">Getione los Documentos del ArcDig,  para su publicacion en el portal Web</div>
                    <div class="content-marco">
                        <div id="tabs" class="tabs-bottom">
                            <ul >
                                <li>
                                    <a href="#ui-tabs-0"><span> Documentos de Gestion  </span> </a>
                                </li>
                                <li>
                                    <a href="#ui-tabs-1"><span> Normas Directivas </span> </a>
                                </li>
                                <li>
                                    <a href="#ui-tabs-2"><span> Resoluciones Gerenciales </span> </a>
                                </li>

                            </ul>
                            <div class="tabs-spacer"></div>
                            <div id="ui-tabs-0">
                                <fieldset class="ui-widget-content ui-corner-all" >
                                    <legend>Filtro: </legend>
                                    <table class="tabla" >
                                        <tr>
                                            <td align="left" >
                                                <input size='65' class="ui-corner-all ui-widget-content" dir="true" id='buscar-gestion' />
                                            </td>
                                            <!--<td align="right">
                                                <label style="cursor:pointer"><input type="radio" rev='' name="group1" class="radio" checked="checked" value="Todos" />Todos</label>
                                                <label style="cursor:pointer"><input type="radio" rev='true' name="group1" class="radio"  value="Registros Activos" />Publicados</label>
                                            </td>-->
                                            <td align="right">
                                                <button id="btnDocGestion">Actualizar</button>
                                            </td>
                                        </tr>
                                    </table>
                                    <div id="docgestion"></div>
                                </fieldset>
                            </div>
                            <div id="ui-tabs-1">
                                <fieldset class="ui-widget-content ui-corner-all" >
                                    <legend>Filtro: </legend>
                                    <table class="tabla" >
                                        <tr>
                                            <td align="left" >
                                                <input size='65' class="ui-corner-all ui-widget-content" dir="true" id='buscar-normas' />
                                            </td>
                                            <!--<td align="right">
                                                <label style="cursor:pointer"><input type="radio" rev='' name="group2" class="radio1" checked="checked" value="Todos" />Todos</label>
                                                <label style="cursor:pointer"><input type="radio" rev='true' name="group2" class="radio1"  value="Registros Activos" />Publicados</label>
                                            </td>-->
                                            <td align="right">
                                                <button id="btnNormasDirectivas">Actualizar</button>
                                            </td>
                                        </tr>
                                    </table>
                                    <div id="docsnormas"></div>
                                </fieldset>

                            </div>
                            <div id="ui-tabs-2">
                                <fieldset class="ui-widget-content ui-corner-all" >
                                    <legend>Filtro: </legend>
                                    <table class="tabla" >
                                        <tr>
                                            <td align="left" >
                                                <input size='55' class="ui-corner-all ui-widget-content" dir="true" id='buscar-resol' />
                                            </td>
                                            <td>
                                                <label>A&ntilde;o:</label><select id="anhosResolucionGerencial"></select>
                                            <td>
                                                <!--<td align="right">
                                                    <label style="cursor:pointer"><input type="radio" rev='' name="group3" class="radio2" checked="checked" value="Todos" />Todos</label>
                                                    <label style="cursor:pointer"><input type="radio" rev='true' name="group3" class="radio2"  value="Registros Activos" />Publicados</label>
                                                </td>-->
                                            <td align="right">
                                                <button id="btnResoluciones">Actualizar</button>
                                            </td>
                                        </tr>
                                    </table>
                                    <div id="docsresol"></div>
                                </fieldset>
                            </div>
                            <div class="eliminarQuestionMod ui-widget ui-dialog" style="display: none; font-size: 12px;">
                                <div class="ui-widget ui-state-highlight ui-corner-all" style="padding:5px;">
                                    <p style="font-size: 13px;padding:5px;">
                                        <span id="msg-icon" style="float: left; margin-right: .3em;"></span><span class="msg-html"></span>
                                    </p>
                                </div>
                                <div style="margin-top: 5px; overflow: hidden;font-size: 12px;">
                                    <input class="noMessage ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover" style="padding:3px;float: right; margin-left: 5px;" type="button" value="No" />
                                    <input class="siMessage ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover" style="padding:3px;float: right;" type="button" value="S&iacute;" />        
                                </div>
                            </div>

                        </div>
                        <input id="array" type="hidden" val=""   />
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>