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
        <script type="text/javascript" src="resources/js/jquery.fileupload-ui.js"></script>
        <script type="text/javascript" src= "resources/js/jquery.fileupload.js"></script>
        <script type="text/javascript" src="resources/js/admin/controller/convocatoriaController.js"></script>
        <link rel="shortcut icon" type="image/x-icon" href="resources/images/16x16/favicon.ico" />
        <title>Contratacion de Bienes/Servicios y Obras</title>       
        <style>
            .tabla tbody th{
                border: 1px solid #000;
                width: 7%;
                text-align: center;
            }
            .tabla thead tr td{
                text-align: center;
            }
            .icono{
                cursor:pointer;
            }
            
            div.file_upload {
                position: relative;
                overflow: hidden;
                direction: ltr;
                cursor: pointer;
                text-align: center;
                color: #333;
                font-weight: bold;
                -moz-border-radius: 10px;
                -webkit-border-radius: 10px;
                border-radius: 10px;
                width: 200px;
                height: 30px;
                line-height: 30px;
                background: palegreen;
                border: 1px solid limegreen;
            }

            div.file_upload_small {
                width: 200px;
                height: 30px;
                line-height: 30px;
                font-size: auto;
                background: palegreen;
                border: 1px solid limegreen;
            }

            div.file_upload_large {
                width: 100%;
                height: 150px;
                line-height: 150px;
                font-size: 20px;
                background: palegreen;
                border: 1px solid limegreen;
            }

            div.file_upload_highlight {
                background: lawngreen;
            }

            div.file_upload input {
                position: absolute;
                top: 0;
                right: 0;
                margin: 0;
                border: 300px solid transparent;
                opacity: 0;
                -ms-filter: 'alpha(opacity=0)';
                filter: alpha(opacity=0);
                -o-transform: translate(-300px, -300px) scale(10);
                -moz-transform: translate(-800px, 0) scale(10);
                cursor: pointer;
            }

            .file_upload iframe, .file_upload button {
                display: none;
            }

            .file_upload_preview img {
                width: 80px;
            }

            .file_upload_progress .ui-progressbar-value {
                background: url(../resources/images/pbar-ani.gif);
            }

            .file_upload_progress div {
                width: 150px;
                height: 15px;
            }

            .file_upload_cancel button {
                cursor: pointer;
            }
            .body ul li {
                font-size: 10px;
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
                    <h2 class="ui-widget ui-widget-header ui-corner-top">Propiedades de la Convocatoria</h2>
                    <div id="message" class="message ui-widget ui-state-highlight">Aqui puedes editar los datos de la Convocatoria</div>
                    <!-- para registrar o editar un convocatoria -->
                    <div id="frmRegistroConvocatoria" class="ui-widget ui-widget-content" style="display: none;margin: 5px; font-size: 12px;">        
                        <form>
                            <div>
                                <label>Titulo de la Convocatoria</label><input size="200" class="import" type="text"  id="txtTituloConvocatoria" name="txtTituloConvocatoria" style="width: 62%;"/>
                            </div>
                            <div>
                                <label>Sintesis de la Convocatoria</label><textarea class="import "  id="txtSintesisConvocatoria" name="txtSintesisConvocatoria" style="width: 62%; height: 40px;resize: none;"></textarea>
                            </div>
                            <div>
                                <label>Fecha de la Convocatoria</label>
                                <input id="txtFecha" readonly="readonly" name="txtFecha" style="width: 12%;" type="text" />
                            </div>
                            <div>
                                <label>Objeto</label>
                                <select id="cmbObjeto" name="cmbObjeto">
                                    <option value="1">Bienes</option>
                                    <option value="2">Servicios</option>
                                    <option value="3">Obras</option>
                                    <option value="4">Concesión</option>
                                </select>
                            </div>
                            <div>
                                <label>Valor Referencial:</label><input size ="20" id="txtValorReferencial" name="txtValorReferencial" type="text" />
                            </div>
                            <div>
                                <label>Costo de Participacion:</label><input size ="20"  id="txtCostoParticipacion" name="txtCostoParticipacion" type="text" />
                            </div>
                            <div>
                                <label>Lugar de registro de participantes:</label><input size="200" id="txtLugarRegParticipantes" name="txtLugarRegParticipantes" type="text" />
                            </div>
                            <div>
                                <label>Estado Del Proceso: </label>
                                <select  id="txtProceso" name="txtProceso">
                                    <option value="1" >Vigente</option>
                                    <option value="2">Anulado</option>
                                    <option value="3">Finalizado</option>
                                    <option value="4">Desierto</option>
                                </select>
                            </div>
                            <div dir="publicar" role="div">
                                <label>Estado de Publicación:</label><input type="checkbox" checked="checked" name="txtEstado" id="txtEstado" style="float: left; text-align: left; width: auto" />
                            </div>
                            <input type="hidden" value="" id="file_1" class="file" />
                            <input type="hidden" value="" id="file_2" class="file" />
                            <input type="hidden" value="" id="file_3" class="file" />
                            <input type="hidden" value="" id="file_4" class="file"/>
                            <input type="hidden" value="" id="file_5" class="file"/>
                            <input type="hidden" value="" id="file_6" class="file"/>
                            <input type="hidden" value="" id="file_7" class="file"/>
                            <input type="hidden" value="" id="file_8" class="file"/>
                            <input type="hidden" value="" id="file_9" class="file"/>
                            <input type="hidden" value="" id="file_10" class="file"/>
                            <input type="hidden" value="" id="file_11" class="file"/>
                            <input type="hidden" value="" id="file_12" class="file"/>
                            <input type="hidden" value="" id="file_13" class="file"/>
                            <input type="hidden" value="" id="file_14" class="file"/>
                            <div style="margin-top: 5px;"><button  id="btnCancelarConvocatoria" type="button" style="margin-left: 5px;">Cancelar</button><button type="button" id="btnGuardarConvocatoria">Guardar</button></div>
                        </form>
                        <form id="file_upload" action="./Upload" method="POST" enctype="multipart/form-data">
                            <table class="tabla" border="1" cellpadding="3" cellspacing="0" width="100%" style="border-collapse: collapse; border: 1px solid #000" >
                                <tbody>
                                    <tr style="height:100px; font-size:9px;">
                                        <th>Bases <br /> <div class="icono" ></div>
                                        </th><th>Resumen Ejecutivo <br /> <div class="icono" ></div>
                                        </th><th>Absolución de Consultas y Observaciones <br /> <div class="icono" ></div>
                                        </th><th>Absolución Consultas <br /> <div class="icono" ></div>
                                        </th><th>Absolución Observaciones <br /> <div class="icono" ></div>
                                        </th><th>Pronuncia. Entidad <br /> <div class="icono" ></div>
                                        </th><th>Pronuncia. OSCE <br /> <div class="icono" ></div>
                                        </th><th>Bases Integradas <br /> <div class="icono" ></div>
                                        </th><th>Acta de Evaluación Técnica <br /> <div class="icono" ></div></th>
                                        <th>Cuadro Comparativo y/o Actas <br /> <div class="icono" ></div>
                                        </th><th>Acta Buena Pro <br /> <div class="icono" ></div>
                                        </th><th>Notificación Suscripción de Acuerdo <br /> <div class="icono" ></div>
                                        </th><th>Resolución de Recurso de Apelación de la Entidad <br /> <div class="icono" ></div>
                                        </th><th>Resolución de Recurso de Apelación del Tribunal <br /> <div class="icono" ></div>
                                        </th>
                                    </tr>
                                    <tr>
                                        <td valign="top" align="center">
                                            <div id="drop_zone_1" style="width: 37px;  height: 25px; " >
                                                <input style="width: 35px; float: left;" id="file_1" type="file" class="archivo" name="file_1" >
                                                <div style="width: 25px; float: left;"> <img src="./resources/images/16x16/add-hover.png" ></div>
                                            </div>
                                        </td>
                                        <td valign="top" align="center">
                                            <div id="drop_zone_2" style="width: 37px;  height: 25px; " >
                                                <input style="width: 35px; float: left;" id="file_2" type="file" class="archivo" name="file_2" >
                                                <div style="width: 25px; float: left;"> <img src="./resources/images/16x16/add-hover.png" ></div>
                                            </div>
                                        </td>
                                        <td valign="top" align="center">
                                            <div id="drop_zone_3" style="width: 37px;  height: 25px; " >
                                                <input style="width: 35px; float: left;" id="file_3" type="file" class="archivo" name="file_3" >
                                                <div style="width: 25px; float: left;"> <img src="./resources/images/16x16/add-hover.png" ></div>
                                            </div>
                                        </td>
                                        <td valign="top" align="center">
                                            <div id="drop_zone_4" style="width: 37px;  height: 25px; " >
                                                <input style="width: 35px; float: left;" id="file_4" type="file" class="archivo" name="file_4" >
                                                <div style="width: 25px; float: left;"> <img src="./resources/images/16x16/add-hover.png" ></div>
                                            </div>
                                        </td>
                                        <td valign="top" align="center">
                                            <div id="drop_zone_5" style="width: 37px;  height: 25px; " >
                                                <input style="width: 35px; float: left;" id="file_5" type="file" class="archivo" name="file_5" >
                                                <div style="width: 25px; float: left;"> <img src="./resources/images/16x16/add-hover.png" ></div>
                                            </div>
                                        </td>
                                        <td valign="top" align="center">
                                            <div id="drop_zone_6" style="width: 37px;  height: 25px; " >
                                                <input style="width: 35px; float: left;" id="file_6" type="file" class="archivo" name="file_6" >
                                                <div style="width: 25px; float: left;"> <img src="./resources/images/16x16/add-hover.png" ></div>
                                            </div>
                                        </td>
                                        <td valign="top" align="center">
                                            <div id="drop_zone_7" style="width: 37px;  height: 25px; " >
                                                <input style="width: 35px; float: left;" id="file_7" type="file" class="archivo" name="file_7" >
                                                <div style="width: 25px; float: left;"> <img src="./resources/images/16x16/add-hover.png" ></div>
                                            </div>
                                        </td>
                                        <td valign="top" align="center">
                                            <div id="drop_zone_8" style="width: 37px;  height: 25px; " >
                                                <input style="width: 35px; float: left;" id="file_8" type="file" class="archivo" name="file_8" >
                                                <div style="width: 25px; float: left;"> <img src="./resources/images/16x16/add-hover.png" ></div>
                                            </div>
                                        </td>
                                        <td valign="top" align="center">
                                            <div id="drop_zone_9" style="width: 37px;  height: 25px; " >
                                                <input style="width: 35px; float: left;" id="file_9" type="file" class="archivo" name="file_9" >
                                                <div style="width: 25px; float: left;"> <img src="./resources/images/16x16/add-hover.png" ></div>
                                            </div>
                                        </td>
                                        <td valign="top" align="center">
                                            <div id="drop_zone_10" style="width: 37px;  height: 25px; " >
                                                <input style="width: 35px; float: left;" id="file_10" type="file" class="archivo" name="file_10" >
                                                <div style="width: 25px; float: left;"> <img src="./resources/images/16x16/add-hover.png" ></div>
                                            </div>
                                        </td>
                                        <td valign="top" align="center">
                                            <div id="drop_zone_11" style="width: 37px;  height: 25px; " >
                                                <input style="width: 35px; float: left;" id="file_11" type="file" class="archivo" name="file_11" >
                                                <div style="width: 25px; float: left;"> <img src="./resources/images/16x16/add-hover.png" ></div>
                                            </div>
                                        </td>
                                        <td valign="top" align="center">
                                            <div id="drop_zone_12" style="width: 37px;  height: 25px; " >
                                                <input style="width: 35px; float: left;" id="file_12" type="file" class="archivo" name="file_12" >
                                                <div style="width: 25px; float: left;"> <img src="./resources/images/16x16/add-hover.png" ></div>
                                            </div>
                                        </td>
                                        <td valign="top" align="center">
                                            <div id="drop_zone_13" style="width: 37px;  height: 25px; " >
                                                <input style="width: 35px; float: left;" id="file_13" type="file" class="archivo" name="file_13" >
                                                <div style="width: 25px; float: left;"> <img src="./resources/images/16x16/add-hover.png" ></div>
                                            </div>
                                        </td>
                                        <td valign="top" align="center">
                                            <div id="drop_zone_14" style="width: 37px;  height: 25px; " >
                                                <input style="width: 35px; float: left;" id="file_14" type="file" class="archivo" name="file_14" >
                                                <div style="width: 25px; float: left;"> <img src="./resources/images/16x16/add-hover.png" ></div>
                                            </div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>

                            <table id="files_1" class="tablafile" style="background:yellow;"></table>
                            <table id="files_2" class="tablafile" style="background:gold;"></table>
                            <table id="files_3" class="tablafile" style="background:orange;"></table>
                            <table id="files_4" class="tablafile" style="background:blue;"></table>
                            <table id="files_5" class="tablafile" style="background:cyan;"></table>
                            <table id="files_6" class="tablafile" style="background:orange;"></table>
                            <table id="files_7" class="tablafile"  style="background:yellow;"></table>
                            <table id="files_8" class="tablafile" style="background:gold;"></table>
                            <table id="files_9" class="tablafile" style="background:orange;"></table>
                            <table id="files_10" class="tablafile" style="background:yellow;"></table>
                            <table id="files_11" class="tablafile" style="background:gold;"></table>
                            <table id="files_12" class="tablafile" style="background:orange;"></table>
                            <table id="files_13" class="tablafile" style="background:yellow;"></table>
                            <table id="files_14" class="tablafile" style="background:gold;"></table>
                            <button >Upload</button>
                        </form>
                    </div>
                    <!-- fin -->
                    <div id="widget" class="ui-widget ui-widget-content" style="margin:5px;">
                        <div>
                            <button type="button" dir="nuevo" id="btnNuevoConvocatoria">Nuevo Convocatoria</button>
                            <button type="button" dir="editar" id="btnEditarConvocatoria" style="margin-left: 5px;">Editar Convocatoria</button>
                            <button type="button" dir="eliminar" id="btnEliminarConvocatoria" style="margin-left: 5px;">Eliminar Convocatoria</button>
                        </div> 
                    </div>
                    <div id="frmConvocatoria">
                        <div style="display: block;overflow: hidden;border:0.1em #c9c9c9 solid;padding:4px;width: 99%;">
                            <label style="float: left;width: 14%;padding:10px;vertical-align: middle">Buscar Convocatoria:</label>
                            <input type="text" style="float: left;width: 55%;padding: 5px;" id="txtBuscarConvocatoria" name="txtBuscarConvocatoria" />
                            <label style="float: left;width: 6%; padding:10px;vertical-align: middle">Filtar Por:</label>
                            <select id="filtro" style="float: left; width: 14%; padding:5px; ">
                                <option value="0" selected="selected">TODOS</option>
                                <option value="1">Bienes</option>
                                <option value="2">Servicios</option>
                                <option value="3">Obras</option>
                                <option value="4">Concesión</option>
                            </select>
                        </div>
                        <div class="jgrid ui-widget ui-widget-content ui-corner-all" style=" margin: 4px auto;padding:0px;">
                            <div class="header ui-state-default ui-corner-top" style="padding: 0;">
                                <div id="fecha" data="1" style="width: 10%;" type="integer">Fecha</div>
                                <div id="nombre" data="2" class="sortable" style="width: 54%;" type="string">Sintesis</div>
                                <div id="tipo" data="3" class="sortable" style="width: 10%;" type="string">Tipo</div>
                                <div id="proceso" data="4" class="sortable" style="width: 9%;" type="string">Proceso</div>
                            </div>
                            <div class="body" style="padding:0;"></div>
                        </div>
                        <input type="hidden" value="10" id="limit" />
                        <input type="hidden" value="0" id="start" />
                        <input type="hidden" value="0" id="current" />
                    </div>
                    <!--aqui es para visualizar los Actividads-->
                    <div id="panelActividads" class="ui-widget ui-widget-content ui-corner-all" style="display: none;margin: 0 5px 5px 5px;padding: 0;">
                        <h2 class="ui-widget ui-widget-header ui-corner-top" style="margin: 0;">Lista de Actividads</h2>
                        <div id="message2" class="message ui-widget ui-state-highlight" style="padding: 10px; width: 97%; margin: 5px auto;">Aqui puede gestionar las Actividades del Cronograma de la Convocatoria</div>
                        <div id="widget" class="ui-widget ui-widget-content" style="padding: 10px;width: 97%;margin: 5px auto;">                     
                            <button  type="button" dir="nuevo" id="btnNuevoActividad">Nuevo Actividad</button>                                
                            <button type="button" dir="editar" id="btnEditarActividad" style="margin-left: 5px;">Editar Actividad</button>
                            <button type="button" dir="eliminar" id="btnEliminarActividad" style="margin-left: 5px;">Eliminar Actividad</button>
                        </div>
                        <div id="frmActividadPorConvocatoria">
                            <div style="display: block;overflow: hidden;border:0.1em #c9c9c9 solid;padding:4px;width: 99%;">
                                <label style="float: left;width: 15%;margin-top: 1px;padding:8px 5px;vertical-align: middle">Buscar Actividad</label>
                                <input type="text" style="float: left;width: 82%;padding: 5px;" id="txtBuscarActividad" name="txtBuscarActividad" />
                            </div>
                            <div class="jgrid ui-widget ui-widget-content" style=" margin: 5px auto;padding:0px;">
                                <div class="header ui-state-default" style="padding: 0;">
                                    <div id="idActividad" data="0" style="width: 5%;" type="integer">Id</div>
                                    <div id="nombreActividad" data="1" class="sortable" style="width: 40%;" type="string">Nombre del Actividad</div>
                                    <div id="urlActividad" data="2" style="width: 20%;" type="string">Fecha Inicio</div>
                                    <div id="urlActividad" data="2" style="width: 20%;" type="string">Fecha Fin</div>
                                </div>
                                <div class="body" style="padding:0;"></div>
                            </div>
                            <input type="hidden" value="10" id="limitActividad" />
                            <input type="hidden" value="0" id="startActividad" />
                            <input type="hidden" value="0" id="currentActividad" />
                        </div>
                    </div>
                    <!-- fin -->
                    <!-- para registrar o editar un subconvocatoria -->
                    <div id="frmRegistroActividad" class="ui-widget ui-widget-content" style="display: none;margin: 5px; padding: 0; font-size: 12px;">        
                        <div id="message3" class="message ui-widget ui-state-highlight" style="padding: 10px; margin: 5px auto;">Aqui puedes Registrar las actividad</div>
                        <form class="ui-widget ui-widget-content" style="padding: 5px;">
                            <div>
                                <label>Fecha Inicio:</label><input id="txtFechaInicio" readonly="readonly" style="width: 12%;" type="text" />
                            </div>
                            <div>
                                <label>Fecha Fin:</label><input id="txtFechaFin" readonly="readonly"  style="width: 12%;" type="text" />
                            </div>
                            <div>
                                <label>Actividad:</label>
                                <select id="cmbnombreActividad" style="width: 52%;"></select>
                                <button dir="eliminar" type="button" id="btnEliminarnombreActividad" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only" aria-disabled="false">
                                    <span class="ui-button-icon-primary ui-icon ui-icon-trash"></span>
                                    <span class="ui-button-text">Eliminar</span>
                                </button>
                                <button dir="editar" type="button" id="btnEditarnombreActividad" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only" role="button" aria-disabled="false">
                                    <span class="ui-button-icon-primary ui-icon ui-icon-pencil"></span>
                                    <span class="ui-button-text">Editar</span>
                                </button>
                                <button dir="nuevo" type="button" id="btnNuevonombreActividad" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only" role="button" aria-disabled="false">
                                    <span class="ui-button-icon-primary ui-icon ui-icon-plus"></span>
                                    <span class="ui-button-text">Nuevo</span>
                                </button>
                            </div>

                        </form>
                        <form>
                            <div style="margin-top: 5px;"><button id="btnCancelarActividad" style="margin-left: 5px;">Cancelar</button><button id="btnGuardarActividad">Guardar</button></div>
                        </form>
                    </div>
                    <!-- fin -->
                    <!--inicio para registrar una etiqueta o grupo de subconvocatorias-->
                    <div id="frmRegistroActiNeto" style="display: none; font-size: 12px;">
                        <div id="message4" class="message ui-widget ui-state-highlight" style="padding: 5px;">Agregue un Nuevo Nombre de Actividad</div>
                        <form  class="ui-widget ui-widget-content" style="padding: 0 3px;">
                            <div style="width: 100%;margin:5px 0px;">
                                <label style="width: 30%">Nombre del ActiNeto</label><input style="width: 68%" type="text" id="txtDescripcionActiNeto" />
                            </div>
                        </form>
                        <form>
                            <div style="margin-top: 5px;"><button id="btnCancelarActiNeto" style="margin-left: 5px;">Cancelar</button><button id="btnGuardarActiNeto">Guardar</button></div>
                        </form>
                    </div>
                    <!--fin -->
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