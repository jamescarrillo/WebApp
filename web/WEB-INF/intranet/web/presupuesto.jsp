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
        <script type="text/javascript" src="resources/js/admin/controller/presupuestoController.js"></script>
        <link rel="shortcut icon" type="image/x-icon" href="resources/images/16x16/favicon.ico" />
        <title>Presupuesto y Finanza</title>

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
                    <h2 class="ui-widget ui-widget-header ui-corner-top">Presupuesto y Finanzas</h2>
                    <div id="message" class="message ui-widget ui-state-highlight">Aqui puedes Administrar Las Publicaciones de Presupuestos y finanzas de la Institución</div>
                    <div class="content-marco">
                        <div id="tabs">
                            <ul>
                                <li>
                                    <a href="#ui-tabs-0">De Apertura (PIA)</a>
                                </li>
                                <li>
                                    <a href="#ui-tabs-1">Modificado (PIM)</a>
                                </li>
                                <li>
                                    <a href="#ui-tabs-2">Ejecución Presupuestal</a>
                                </li>
                                <li>
                                    <a href="#ui-tabs-3">Estados de Situación Financiera</a>
                                </li>
                                <li>
                                    <a href="#ui-tabs-4">Evaluación de Ingreso</a>
                                </li>
                                <li>
                                    <a href="#ui-tabs-5">Resumen de Gastos</a>
                                </li>                                  
                            </ul>
                            <div id="ui-tabs-0">
                                <div class="content-marco">
                                    <!-- para registrar o editar una PIA -->
                                    <div id="frmRegistroPIA"  style="margin: 5px; display: none; padding:2px;">
                                        <div id="message" class="message ui-widget ui-state-highlight" style="padding: 5px;">Complete el Formulario</div>
                                        <form  method="POST" enctype="multipart/form-data" id="" class="ui-widget ui-widget-content" style="margin-top: 5px;" action="./Upload?tmp=data-presupuesto" >
                                            <div>
                                                <label style="padding:5px 0px;">Asignar Registro desde ArcDig</label>
                                                <button dir="nuevo" id="asignarArcDig" type="button"  style="float:left">Asignar</button>
                                            </div>
                                            <div>
                                                <label style="padding:5px 0px;">Fecha</label>
                                                <input type="text"  id="txtFechaPIA" class="casilla" name="txtFechaPIA" style="width: 10%;" />
                                            </div>
                                            <div>
                                                <label style="padding:5px 0px;">Descripcion</label>
                                                <textarea  id="txtDescripcionPIA" class="casilla" name="txtDescripcionPIA" style="width: 62%; height: 40px; resize: none;"></textarea>
                                            </div>
                                            <div>
                                                <label style="padding:5px 0px;">Aprobado Por</label>
                                                <input type="text"  id="txtAprobadoPor" class="casilla" name="txtAprobadoPor" style="width: 62%;" />
                                            </div>

                                            <div>
                                                <label>Estado de la PIA</label><input type="checkbox" checked="checked" id="txtEstadoPIA" style="float: left; text-align: left; width: auto" />
                                            </div>
                                            <input type="hidden" id="archivo_1" class="casilla" value="" />
                                            <input type="hidden" id="txtIdPIA" class="casilla" value="" />
                                            <input type="hidden" id="txtArcDigId" class="casilla" value="" />
                                        </form>
                                        <form class="ui-widget ui-widget-content" style="margin-top: 5px; ">
                                            <div style="margin-top: 5px;">
                                                <button type="button" id="guardarPIA">Guardar</button>
                                                <button type="button" id="btnCancelarPIA" style="margin-left: 5px;">Cancelar</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                                <div id="dialog-PIA" title="Seleccionar Registro desde ArcDig" style="display: none">
                                    <div style="display: block;overflow: hidden;border:0.1em #c9c9c9 solid;padding:4px;width: 99%;">
                                        <label style="float: left;width: 15%;padding:10px;vertical-align: middle">Buscar PIA:</label>
                                        <input type="text" style="float: left;width: 50%;padding: 5px;" id="buscar-arcDig-PIA" />
                                    </div>
                                    <div id="arcDigPIA"></div>
                                    <input id="arrayPIA" type="hidden" value="" />
                                    <fieldset class='ui-widget-content ui-corner-bottom' style='text-align:center; padding: 5px 0px'><button type='button' id='seleccionar'>Seleccionar</button><button type='button' id='close'>Cerrar</button></fieldset>
                                </div>
                                <!-- fin -->
                                <div id="widget" class="ui-widget ui-widget-content" style="margin:5px;">
                                    <div>
                                        <button dir="nuevo" id="btnNuevoPIA">Nueva PIA</button>
                                        <button dir="editar" id="btnEditarPIA" style="margin-left: 5px;">Editar PIA</button>
                                        <button dir="eliminar" id="btnEliminarPIA" style="margin-left: 5px;">Eliminar PIA</button>
                                    </div>
                                </div>
                                <div id="divPIA">
                                    <div style="display: block;overflow: hidden;border:0.1em #c9c9c9 solid;padding:4px;width: 99%;">
                                        <label style="float: left;width: 15%;padding:10px;vertical-align: middle">Buscar </label>
                                        <input type="text" style="float: left;width: 50%;padding: 5px;" id="buscar-PIA" />
                                    </div>
                                    <div id="frmPIA"></div>
                                    <input type="hidden" value="" id="arrayO" />
                                </div>
                            </div>

                            <!-- PIM -->
                            <div id="ui-tabs-1">
                                <div class="content-marco">
                                    <!-- para registrar o editar una PIM -->
                                    <div id="frmRegistroPIM"  style="margin: 5px; display: none; padding:2px;">
                                        <div id="message1" class="message ui-widget ui-state-highlight" style="padding: 5px;">Complete el Formulario</div>
                                        <form  method="POST" enctype="multipart/form-data" id="" class="ui-widget ui-widget-content" style="margin-top: 5px;"  >
                                            <div>
                                                <label style="padding:5px 0px;">Asignar Registro desde ArcDig</label>
                                                <button dir="nuevo" id="asignarArcDig_1" type="button"  style="float:left">Asignar</button>
                                            </div>
                                            <div>
                                                <label style="padding:5px 0px;">Fecha</label>
                                                <input type="text"  id="txtFechaPIM" class="casilla" name="txtFechaPIM" style="width: 10%;" />
                                            </div>
                                            <div>
                                                <label style="padding:5px 0px;">Descripcion</label>
                                                <textarea  id="txtDescripcionPIM" class="casilla" name="txtDescripcionPIM" style="width: 62%; height: 40px; resize: none;"></textarea>
                                            </div>
                                            <div>
                                                <label style="padding:5px 0px;">Aprobado Por</label>
                                                <input type="text"  id="txtAprobadoPorPIM" class="casilla" name="txtAprobadoPor" style="width: 62%;" />
                                            </div>
                                            <div>
                                                <label>Estado de la PIM</label><input type="checkbox" checked="checked" id="txtEstadoPIM" style="float: left; text-align: left; width: auto" />
                                            </div>
                                            <input type="hidden" id="txtIdPIM" class="casilla" value="" />
                                            <input type="hidden" id="txtArcDigId_1" class="casilla" value="" />
                                        </form>
                                        <form class="ui-widget ui-widget-content" style="margin-top: 5px; ">
                                            <div style="margin-top: 5px;">
                                                <button  type="button" id="guardarPIM">Guardar</button>
                                                <button type="button" id="btnCancelarPIM" style="margin-left: 5px;">Cancelar</button>

                                            </div>
                                        </form>
                                    </div>
                                </div>
                                <!-- fin -->
                                <div id="dialog-PIM" title="Seleccionar Registro desde ArcDig" style="display: none">
                                    <div style="display: block;overflow: hidden;border:0.1em #c9c9c9 solid;padding:4px;width: 99%;">
                                        <label style="float: left;width: 15%;padding:10px;vertical-align: middle">Buscar PIM</label>
                                        <input type="text" style="float: left;width: 50%;padding: 5px;" id="buscar-arcDig-PIM" />
                                    </div>
                                    <div id="arcDigPIM"></div>
                                    <input id="arrayPIM" type="hidden" value="" />
                                    <fieldset class='ui-widget-content ui-corner-bottom' style='text-align:center; padding: 5px 0px'><button type='button' id='seleccionar_1'>Seleccionar</button><button type='button' id='close_1'>Cerrar</button></fieldset>
                                </div>
                                <div id="widgetPIM" class="ui-widget ui-widget-content" style="margin:5px;">
                                    <div>
                                        <button dir="nuevo" id="btnNuevoPIM">Nueva PIM</button>
                                        <button dir="editar" id="btnEditarPIM" style="margin-left: 5px;">Editar PIM</button>
                                        <button dir="eliminar" id="btnEliminarPIM" style="margin-left: 5px;">Eliminar PIM</button>
                                    </div>
                                </div>
                                <div id="divPIM">
                                    <div style="display: block;overflow: hidden;border:0.1em #c9c9c9 solid;padding:4px;width: 99%;">
                                        <label style="float: left;width: 15%;padding:10px;vertical-align: middle">Buscar PIM:</label>
                                        <input type="text" style="float: left;width: 50%;padding: 5px;" id="buscar-PIM" />
                                    </div>
                                    <div id="frmPIM"></div>
                                    <input type="hidden" value="" id="arrayM" />
                                </div>
                            </div>

                            <!-- Orden EFF -->
                            <div id="ui-tabs-2">
                                <div class="content-marco">
                                    <!-- para registrar o editar una EFF -->
                                    <div id="frmRegistroEFF"  style="margin: 5px; display: none; padding:2px;">
                                        <div id="message2" class="message ui-widget ui-state-highlight" style="padding: 5px;">Complete el Formulario</div>
                                        <form  method="POST" enctype="multipart/form-data" id="" class="ui-widget ui-widget-content" style="margin-top: 5px;"  >
                                            <div>
                                                <label style="padding:5px 0px;">Asignar Registro desde ArcDig</label>
                                                <button dir="nuevo" id="asignarArcDig_2" type="button"  style="float:left">Asignar</button>
                                            </div>
                                            <div>
                                                <label style="padding:5px 0px;">Fecha</label>
                                                <input type="text"  id="txtFechaEFF" class="casilla" name="txtFechaEFF" style="width: 10%;" />
                                            </div>
                                            <div>
                                                <label style="padding:5px 0px;">Descripcion</label>
                                                <textarea  id="txtDescripcionEFF" class="casilla" name="txtDescripcionEFF" style="width: 62%; height: 40px; resize: none;"></textarea>
                                            </div>

                                            <div>
                                                <label>Estado de la EFF</label><input type="checkbox" checked="checked" id="txtEstadoEFF" style="float: left; text-align: left; width: auto" />
                                            </div>
                                            <input type="hidden" id="txtIdEFF" class="casilla" value="" />
                                            <input type="hidden" id="txtArcDigId_2" class="casilla" value="" />
                                        </form>
                                        <form class="ui-widget ui-widget-content" style="margin-top: 5px; ">
                                            <div style="margin-top: 5px;">
                                                <button type="button" id="guardarEFF">Guardar</button>
                                                <button type="button" id="btnCancelarEFF" style="margin-left: 5px;">Cancelar</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                                <!-- fin -->
                                <div id="dialog-EFF" title="Seleccionar Registro desde ArcDig" style="display: none">
                                    <div style="display: block;overflow: hidden;border:0.1em #c9c9c9 solid;padding:4px;width: 99%;">
                                        <label style="float: left;width: 15%;padding:10px;vertical-align: middle">Buscar EP</label>
                                        <input type="text" style="float: left;width: 50%;padding: 5px;" id="buscar-arcDig-EFF" />
                                    </div>
                                    <div id="arcDigEFF"></div>
                                    <input id="arrayEFF" type="hidden" value="" />
                                    <fieldset class='ui-widget-content ui-corner-bottom' style='text-align:center; padding: 5px 0px'><button type='button' id='seleccionar_2'>Seleccionar</button><button type='button' id='close_2'>Cerrar</button></fieldset>
                                </div>
                                <div id="widgetEFF" class="ui-widget ui-widget-content" style="margin:5px;">
                                    <div>
                                        <button dir="nuevo" id="btnActualizarEFF">Actualizar de ArcDig</button>
                                        <button dir="nuevo" id="btnNuevoEFF">Nueva EFF</button>
                                        <button dir="editar" id="btnEditarEFF" style="margin-left: 5px;">Editar EP</button>
                                        <button dir="eliminar" id="btnEliminarEFF" style="margin-left: 5px;">Eliminar EP</button>
                                    </div>
                                </div>
                                <div id="divEFF">
                                    <div style="display: block;overflow: hidden;border:0.1em #c9c9c9 solid;padding:4px;width: 99%;">
                                        <label style="float: left;width: 15%;padding:10px;vertical-align: middle">Buscar EP:</label>
                                        <input type="text" style="float: left;width: 50%;padding: 5px;" id="buscar-EFF" />
                                    </div>
                                    <div id="frmEFF"></div>
                                    <input type="hidden" value="" id="arrayE" />
                                </div>
                            </div>
                            <!-- Compras BG -->
                            <div id="ui-tabs-3">
                                <div class="content-marco">
                                    <!-- para registrar o editar una BG -->
                                    <div id="frmRegistroBG"  style="margin: 5px; display: none; padding:2px;">
                                        <div id="message3" class="message ui-widget ui-state-highlight" style="padding: 5px;">Complete el Formulario</div>
                                        <form  method="POST" enctype="multipart/form-data" id="" class="ui-widget ui-widget-content" style="margin-top: 5px;"  >
                                            <div>
                                                <label style="padding:5px 0px;">Asignar Registro desde ArcDig</label>
                                                <button dir="nuevo" id="asignarArcDig_3" type="button"  style="float:left">Asignar</button>
                                            </div>
                                            <div>
                                                <label style="padding:5px 0px;">Fecha</label>
                                                <input type="text"  id="txtFechaBG" class="casilla" name="txtFechaBG" style="width: 10%;" />
                                            </div>
                                            <div>
                                                <label style="padding:5px 0px;">Descripcion</label>
                                                <textarea  id="txtDescripcionBG" class="casilla" name="txtDescripcionBG" style="width: 62%; height: 40px; resize: none;"></textarea>
                                            </div>
                                            <div>
                                                <label>Estado de la ESF</label><input type="checkbox" checked="checked" id="txtEstadoBG" style="float: left; text-align: left; width: auto" />
                                            </div>
                                            <input type="hidden" id="txtIdBG" class="casilla" value="" />
                                            <input type="hidden" id="txtArcDigId_3" class="casilla" value="" />
                                        </form>
                                        <form class="ui-widget ui-widget-content" style="margin-top: 5px; ">
                                            <div style="margin-top: 5px;">
                                                <button type="button" id="guardarBG">Guardar</button>
                                                <button type="button" id="btnCancelarBG" style="margin-left: 5px;">Cancelar</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                                <!-- fin -->
                                <div id="dialog-BG" title="Seleccionar Registro desde ArcDig" style="display: none">
                                    <div style="display: block;overflow: hidden;border:0.1em #c9c9c9 solid;padding:4px;width: 99%;">
                                        <label style="float: left;width: 15%;padding:10px;vertical-align: middle">Buscar BG</label>
                                        <input type="text" style="float: left;width: 50%;padding: 5px;" value="" id="buscar-arcDig-BG" />
                                    </div>
                                    <div id="arcDigBG"></div>
                                    <input id="arrayBG" type="hidden" value="" />
                                    <fieldset class='ui-widget-content ui-corner-bottom' style='text-align:center; padding: 5px 0px'><button type='button' id='seleccionar_3'>Seleccionar</button><button type='button' id='close_3'>Cerrar</button></fieldset>
                                </div>
                                <div id="widgetBG" class="ui-widget ui-widget-content" style="margin:5px;">
                                    <div>
                                        <button dir="nuevo" id="btnActualizarBG">Actualizar de ArcDig</button>
                                        <button dir="nuevo" id="btnNuevoBG">Nueva ESF</button>
                                        <button dir="editar" id="btnEditarBG" style="margin-left: 5px;">Editar ESF</button>
                                        <button dir="eliminar" id="btnEliminarBG" style="margin-left: 5px;">Eliminar ESF</button>

                                    </div>
                                </div>
                                <div id="divBG">
                                    <div style="display: block;overflow: hidden;border:0.1em #c9c9c9 solid;padding:4px;width: 99%;">
                                        <label style="float: left;width: 15%;padding:10px;vertical-align: middle">Buscar BG:</label>
                                        <input type="text" style="float: left;width: 50%;padding: 5px;" id="buscar-BG" />
                                    </div>
                                    <div id="frmBG"></div>
                                    <input type="hidden" value="" id="arrayB" />
                                </div>
                            </div>


                            <!-- Compras EI -->
                            <div id="ui-tabs-4">
                                <div class="content-marco">
                                    <!-- para registrar o editar una EI -->
                                    <div id="frmRegistroEI"  style="margin: 5px; display: none; padding:2px;">
                                        <div id="message4" class="message ui-widget ui-state-highlight" style="padding: 5px;">Complete el Formulario</div>
                                        <form  method="POST" enctype="multipart/form-data" id="" class="ui-widget ui-widget-content" style="margin-top: 5px;"  >
                                            <div>
                                                <label style="padding:5px 0px;">Asignar Registro desde ArcDig</label>
                                                <button dir="nuevo" id="asignarArcDig_4" type="button"  style="float:left">Asignar</button>
                                            </div>
                                            <div>
                                                <label style="padding:5px 0px;">Fecha</label>
                                                <input type="text"  id="txtFechaEI" class="casilla" name="txtFechaEI" style="width: 10%;" />
                                            </div>
                                            <div>
                                                <label style="padding:5px 0px;">Descripcion</label>
                                                <textarea  id="txtDescripcionEI" class="casilla" name="txtDescripcionEI" style="width: 62%; height: 40px; resize: none;"></textarea>
                                            </div>
                                            <div>
                                                <label>Estado de la EI</label><input type="checkbox" checked="checked" id="txtEstadoEI" style="float: left; text-align: left; width: auto" />
                                            </div>
                                            <input type="hidden" id="txtIdEI" class="casilla" value="" />
                                            <input type="hidden" id="txtArcDigId_4" class="casilla" value="" />
                                        </form>
                                        <form class="ui-widget ui-widget-content" style="margin-top: 5px; ">
                                            <div style="margin-top: 5px;">
                                                <button type="button" id="guardarEI">Guardar</button>
                                                <button type="button" id="btnCancelarEI" style="margin-left: 5px;">Cancelar</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                                <!-- fin -->
                                <div id="dialog-EI" title="Seleccionar Registro desde ArcDig" style="display: none">
                                    <div style="display: block;overflow: hidden;border:0.1em #c9c9c9 solid;padding:4px;width: 99%;">
                                        <label style="float: left;width: 15%;padding:10px;vertical-align: middle">Buscar EI</label>
                                        <input type="text" style="float: left;width: 50%;padding: 5px;" id="buscar-arcDig-EI" />
                                    </div>
                                    <div id="arcDigEI"></div>
                                    <input id="arrayEI" type="hidden" value="" />
                                    <fieldset class='ui-widget-content ui-corner-bottom' style='text-align:center; padding: 5px 0px'><button type='button' id='seleccionar_4'>Seleccionar</button><button type='button' id='close_4'>Cerrar</button></fieldset>
                                </div>
                                <div id="widgetEI" class="ui-widget ui-widget-content" style="margin:5px;">
                                    <div>
                                        <button dir="nuevo" id="btnActualizarEI">Actualizar de ArcDig</button>
                                        <button dir="nuevo" id="btnNuevoEI">Nueva EI</button>
                                        <button dir="editar" id="btnEditarEI" style="margin-left: 5px;">Editar EI</button>
                                        <button dir="eliminar" id="btnEliminarEI" style="margin-left: 5px;">Eliminar EI</button>
                                    </div>
                                </div>
                                <div id="divEI">
                                    <div style="display: block;overflow: hidden;border:0.1em #c9c9c9 solid;padding:4px;width: 99%;">
                                        <label style="float: left;width: 15%;padding:10px;vertical-align: middle">Buscar EI:</label>
                                        <input type="text" style="float: left;width: 50%;padding: 5px;" id="buscar-EI" />
                                    </div>
                                    <div id="frmEI"></div>
                                    <input type="hidden" value="" id="arrayI" />
                                </div>
                            </div>
                            <!--RGE--->
                            <div id="ui-tabs-5">
                                <div class="content-marco">
                                    <!-- para registrar o editar una RGE -->
                                    <div id="frmRegistroRGE"  style="margin: 5px; display: none; padding:2px;">
                                        <div id="message5" class="message ui-widget ui-state-highlight" style="padding: 5px;">Complete el Formulario</div>
                                        <form  method="POST" enctype="multipart/form-data" id="" class="ui-widget ui-widget-content" style="margin-top: 5px;"  >
                                            <div>
                                                <label style="padding:5px 0px;">Asignar Registro desde ArcDig</label>
                                                <button dir="nuevo" id="asignarArcDig_5" type="button"  style="float:left">Asignar</button>
                                            </div>
                                            <div>
                                                <label style="padding:5px 0px;">Fecha</label>
                                                <input type="text"  id="txtFechaRGE" class="casilla" name="txtFechaRGE" style="width: 10%;" />
                                            </div>
                                            <div>
                                                <label style="padding:5px 0px;">Descripcion</label>
                                                <textarea  id="txtDescripcionRGE" class="casilla" name="txtDescripcionRGE" style="width: 62%; hRGEght: 40px; resize: none;"></textarea>
                                            </div>
                                            <div>
                                                <label>Estado de la RGE</label><input type="checkbox" checked="checked" id="txtEstadoRGE" style="float: left; text-align: left; width: auto" />
                                            </div>
                                            <input type="hidden" id="txtIdRGE" class="casilla" value="" />
                                            <input type="hidden" id="txtArcDigId_5" class="casilla" value="" />
                                        </form>
                                        <form class="ui-widget ui-widget-content" style="margin-top: 5px; ">
                                            <div style="margin-top: 5px;">
                                                <button type="button" id="guardarRGE">Guardar</button>
                                                <button type="button" id="btnCancelarRGE" style="margin-left: 5px;">Cancelar</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                                <!-- fin -->
                                <div id="dialog-RGE" title="Seleccionar Registro desde ArcDig" style="display: none">
                                    <div style="display: block;overflow: hidden;border:0.1em #c9c9c9 solid;padding:4px;width: 99%;">
                                        <label style="float: left;width: 15%;padding:10px;vertical-align: middle">Buscar RGE</label>
                                        <input type="text" style="float: left;width: 50%;padding: 5px;" id="buscar-arcDig-RGE" />
                                    </div>
                                    <div id="arcDigRGE"></div>
                                    <input id="arrayRGE" type="hidden" value="" />
                                    <fieldset class='ui-widget-content ui-corner-bottom' style='text-align:center; padding: 5px 0px'><button type='button' id='seleccionar_5'>Seleccionar</button><button type='button' id='close_5'>Cerrar</button></fieldset>
                                </div>
                                <div id="widgetRGE" class="ui-widget ui-widget-content" style="margin:5px;">
                                    <div>
                                        <button dir="nuevo" id="btnActualizarRGE">Actualizar de ArcDig</button>
                                        <button dir="nuevo" id="btnNuevoRGE">Nueva RGE</button>
                                        <button dir="editar" id="btnEditarRGE" style="margin-left: 5px;">Editar RGE</button>
                                        <button dir="eliminar" id="btnEliminarRGE" style="margin-left: 5px;">Eliminar RGE</button>
                                    </div>
                                </div>
                                <div id="divRGE">
                                    <div style="display: block;overflow: hidden;border:0.1em #c9c9c9 solid;padding:4px;width: 99%;">
                                        <label style="float: left;width: 15%;padding:10px;vertical-align: middle">Buscar RGE:</label>
                                        <input type="text" style="float: left;width: 50%;padding: 5px;" id="buscar-RGE" />
                                    </div>
                                    <div id="frmRGE"></div>
                                    <input type="hidden" value="" id="arrayR" />
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="eliminarQuestionADCO ui-widget ui-dialog" style="display: none; font-size: 12px;">
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
        </div>
    </body>
</html>
