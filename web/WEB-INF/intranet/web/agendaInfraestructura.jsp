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
        <!--<link type="text/less" rel="stylesheet" href="resources/less/ui.tab.less">-->
        <script type="text/javascript" src="resources/js/jquery.js"></script>
        <script type="text/javascript" src="resources/js/jquery-ui.js"></script>
        <script type="text/javascript" src="resources/js/CJRoles.js"></script>
        <script type="text/javascript" src="resources/js/jquery.timeentry.min.js"></script>
        <script type="text/javascript" src="resources/js/jquery.timeentry-es.js"></script>
        <link rel="shortcut icon" type="image/x-icon" href="resources/images/16x16/favicon.ico" />
        <script type="text/javascript">
            $(function () {
                $('#txtHora').timeEntry({
                    show24Hours:false
                });
                $('#txtHoraFinal').timeEntry({
                    show24Hours:false
                });
            });
        </script>
        <script type="text/javascript" src="resources/js/admin/controller/agendaController.js"></script>
        <title>Agenda Gerencial</title>
        <style>
            #listActividads {
                font-size: 11px;
            }
            /* TimeEntry styles */
            .timeEntry_control {
                vertical-align: middle;
                margin-left: 2px;
            }
            * html .timeEntry_control { /* IE only */
                margin-top: -4px;
            }
            .jgrid .body ul li div { /* IE only */
                *display: inline;
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
                <div class="marco ui-widget ui-widget-content">
                    <h2 class="ui-widget ui-widget-header ui-corner-top">Organización de Sus Actividades</h2>
                    <div id="message" class="message ui-widget ui-state-highlight">Aqui puedes Agregar/Editar y Eliminar Actividades programadas en su agenda</div>
                    <!-- para registrar o editar un agenda -->
                    <div id="frmRegistroActividad" class="ui-widget ui-widget-content" style="display: none;margin: 5px; font-size: 12px;">
                        <form id="frmRegistroActividadSend">
                            <div>
                                <label>Actividad</label><textarea class="import ui-corner-all ui-widget"  id="txtActividad" name="txtActividad" style="width: 62%; height: 40px;resize: none;"></textarea>
                            </div>
                            <div>
                                <label>Fecha</label><input id="txtFecha" readonly="readonly" name="txtFecha" style="width: 12%;" type="text" />
                            </div>
                            <div>
                                <label>Hora de Inicio</label><input id="txtHora" name="txtHora" style="width: 12%;" type="text" />
                            </div>
                            <div>
                                <label>Hora de Termino</label><input id="txtHoraFinal" name="txtHoraFinal" style="width: 12%;" type="text" />
                            </div>
                            <div>
                                <label>Ciudad</label><input id="txtCiudad" name="txtCiudad" type="text" size="80"  style="width: 61%; "/>
                            </div>
                            <div>
                                <label>Lugar</label><textarea class="import ui-corner-all ui-widget"  id="txtLugar" name="txtLugar" style="width: 62%; height: 40px;resize: none;"></textarea>
                            </div>
                            <div dir="publicar" role="div">
                                <label>Estado de la Actividad</label><input type="checkbox" checked="checked" id="txtEstado" style="float: left; text-align: left; width: auto" />
                            </div>
                            <input name="txtTipo" type="hidden" id="txtTipo" value="2" />
                            <div style="margin-top: 5px;"><button  id="btnCancelarActividad" type="button" style="margin-left: 5px;">Cancelar</button><button type="button" id="btnGuardarActividad">Guardar</button></div>
                        </form>
                    </div>
                    <!-- fin -->
                    <div id="widget" class="ui-widget ui-widget-content" style="margin:5px;">
                        <div>
                            <button type="button" dir="nuevo" id="btnNuevoActividad">Nueva Actividad</button>
                            <button type="button" dir="editar" id="btnEditarActividad" style="margin-left: 5px;">Editar Actividad</button>
                            <button type="button" dir="eliminar" id="btnEliminarActividad" style="margin-left: 5px;">Eliminar Actividad</button>
                        </div> 
                    </div>
                    <div id="frmActividad">
                        <div style="display: block; overflow: hidden; border:0.1em #c9c9c9 solid; padding:4px; width: 99%;">
                            <label style="float: left; width: 12%; padding:10px; vertical-align: middle">Buscar Actividad:</label>
                            <input type="text" style="float: left; width: 35%; padding: 5px;" id="txtBuscarActividad" name="txtBuscarActividad" />
                            <label style="float: left;width: 6%; padding:10px;vertical-align: middle">Filtar Por:</label>
                            <select id="filtro" style="float: left; width: 14%; padding:5px; ">
                                <option value="1" selected="selected">Día</option>
                                <option value="2">Mes</option>
                                <option value="3">Año</option>
                                <option value="4">Todo</option>
                            </select>
                            <label style="float: left;width: 5%; padding:10px;vertical-align: middle">Fecha:</label>
                            <input type="text" style="float: left; width: 10%; padding: 5px;" readonly="readonly" id="txtFechaFiltro" name="txtFecha" />
                        </div>
                        <div class="jgrid ui-widget ui-widget-content ui-corner-all" style=" margin: 4px auto;padding:0px;">
                            <div class="header ui-state-default ui-corner-top" style="padding: 0;">
                                <div id="idActividad" data="0" style="width: 5%; display:none" type="integer">Id</div>
                                <div id="fecha" data="1" style="width: 10%;" type="integer">Hora</div>
                                <div id="hora" data="2" style="width: 10%;" type="integer">Fecha</div>
                                <div id="actividad" data="3" class="sortable" style="width: 26%;" type="string">Actividad</div>
                                <div id="ciudad" data="4" class="sortable" style="width: 14%;" type="string">Ciudad</div>
                                <div id="lugar" data="5" class="sortable" style="width: 25%;" type="string">Lugar</div>
                            </div>
                            <div class="body" style="padding:0;"></div>
                        </div>
                        <input type="hidden" value="10" id="limit" />
                        <input type="hidden" value="0" id="start" />
                        <input type="hidden" value="0" id="current" />
                    </div>

                    <!-- fin -->

                </div>

                <div class="eliminarQuestionMod ui-widget ui-dialog" style="display: none; font-size: 12px;">
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
            </div>
        </div>
    </body>
</html>