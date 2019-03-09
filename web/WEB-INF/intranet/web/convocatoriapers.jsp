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
        <script type="text/javascript" src="resources/js/jquery.fileupload-ui.js"></script>
        <script type="text/javascript" src= "resources/js/jquery.fileupload.js"></script>
        <script type="text/javascript" src="resources/js/admin/controller/convocatoriapersController.js"></script>
        <link rel="shortcut icon" type="image/x-icon" href="resources/images/16x16/favicon.ico" />
        <title>Contratacion de Personal</title>       
        <style>
            .tabla tbody th{
                border: 1px solid #000;
                width: 7%;
                text-align: center;
            }
            .tabla thead tr td{
                text-align: center;
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
                background: url(./resources/images/pbar-ani.gif);
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
                    <h2 class="ui-widget ui-widget-header ui-corner-top">Propiedades de la Convocatoria de Personal</h2>
                    <div id="message" class="message ui-widget ui-state-highlight">Aqui puedes programar tus Convocatoria de Personal</div>
                    <!-- para registrar o editar un convocatoriaPers -->
                    <div id="frmRegistroConvocatoriaPers" class="ui-widget ui-widget-content" style="display: none;margin: 5px; font-size: 12px;">        
                        <form>
                            <div>
                                <label>Convocatoria</label><input style="width: 62%;" class="import" id="txtConvocatoriaPers" name="txtConvocatoriaPers" type="text" />
                            </div>
                            <div>
                                <label>Sintesis de la Convocatoria</label><textarea class="import"  id="txtSintesisConvocatoriaPers" name="txtSintesisConvocatoriaPers" style="width: 62%; height: 40px;resize: none;"></textarea>
                            </div>
                            <div dir="publicar" role="div">
                                <label>Estado de la Convocatoria</label><input type="checkbox" id="txtEstadoConvocatoriaPers" style="float: left; text-align: left; width: auto" />
                            </div>

                            <div style="margin-top: 5px;"><button id="btnCancelarConvocatoriaPers" type="button" style="margin-left: 5px;">Cancelar</button><button type="button" id="btnGuardarConvocatoriaPers">Guardar</button></div>
                        </form>

                    </div>
                    <!-- fin -->
                    <div id="widget" class="ui-widget ui-widget-content" style="margin:5px;">
                        <div>
                            <button type="button" dir ="nuevo" id="btnNuevoConvocatoriaPers">Nuevo Convocatoria</button>
                            <button  type="button" dir="editar" id="btnEditarConvocatoriaPers" style="margin-left: 5px;">Editar Convocatoria</button>
                            <button type="button" dir="eliminar" id="btnEliminarConvocatoriaPers" style="margin-left: 5px;">Eliminar Convocatoria</button>
                        </div>
                    </div>
                    <div id="frmConvocatoriaPers">
                        <div style="display: block;overflow: hidden;border:0.1em #c9c9c9 solid;padding:4px;width: 99%;">
                            <label style="float: left;width: 15%;padding:10px;vertical-align: middle">Buscar Convocatoria:</label>
                            <input type="text" style="float: left;width: 80%;padding: 5px;" id="txtBuscarConvocatoriaPers" name="txtBuscarConvocatoriaPers" />
                        </div>
                        <div class="jgrid ui-widget ui-widget-content ui-corner-all" style=" margin: 4px auto;padding:0px;">
                            <div class="header ui-state-default ui-corner-top" style="padding: 0;">
                               <!-- <div id="idConvocatoriaPers" data="0" style="width: 10%;" type="integer">Id</div>-->
                                <div id="fecha" data="1" style="width: 10%;" type="integer">Fecha</div>
                                <div id="nombre" data="2" class="sortable" style="width: 30%;" type="string">Convocatoria</div>
                                <div id="tipo" data="3" class="sortable" style="width: 45%;" type="string">Descripcion</div>
                                <div  data="4" style="width: 2%;" type="string">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
                                <div  data="5" style="width: 2%;" type="string">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
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
                            <button type="button" dir="nuevo" id="btnNuevoActividad">Seleccionar Actividad</button>                                
                            <button type="button" dir="editar" id="btnEditarActividad" style="margin-left: 5px;">Editar Actividad</button>
                            <button type="button" dir="eliminar" id="btnEliminarActividad" style="margin-left: 5px;">Eliminar Actividad</button>
                        </div>
                        <div id="frmActividadPorConvocatoriaPers">
                            <div style="display: block;overflow: hidden;border:0.1em #c9c9c9 solid;padding:4px;width: 99%;">
                                <label style="float: left;width: 15%;margin-top: 1px;padding:8px 5px;vertical-align: middle">Buscar Actividad</label>
                                <input type="text" style="float: left;width: 82%;padding: 5px;" id="txtBuscarActividad" name="txtBuscarActividad" />
                            </div>
                            <div class="jgrid ui-widget ui-widget-content" style=" margin: 5px auto;padding:0px;">
                                <div class="header ui-state-default" style="padding: 0;">
                                    <!--<div id="idActividad" data="0" style="width: 5%;" type="integer">Id</div>-->
                                    <div id="nombreActividad" data="1" class="sortable" style="width: 49%;" type="string">Nombre del Actividad</div>
                                    <div id="fechaIniActividad" data="2" style="width: 20%;" type="string">Fecha Inicio</div>
                                    <div id="fechaFinActividad" data="3" style="width: 20%;" type="string">Fecha Fin</div>
                                </div>
                                <div class="body" style="padding:0;"></div>
                            </div>
                            <input type="hidden" value="10" id="limitActividad" />
                            <input type="hidden" value="0" id="startActividad" />
                            <input type="hidden" value="0" id="currentActividad" />
                        </div>
                    </div>
                    <!-- fin -->
                    <!--aqui es para visualizar los Plazas a convocar-->
                    <div id="panelPlaza" class="ui-widget ui-widget-content ui-corner-all" style="display: none;margin: 0 5px 5px 5px;padding: 0;">
                        <h2 class="ui-widget ui-widget-header ui-corner-top" style="margin: 0;">Lista de Plazas a convocar</h2>
                        <div id="message7" class="message ui-widget ui-state-highlight" style="padding: 10px; width: 97%; margin: 5px auto;">Aqui puede gestionar las plazas a convocar</div>
                        <div id="widget" class="ui-widget ui-widget-content" style="padding: 10px;width: 97%;margin: 5px auto;">                     
                            <button type="button" dir="nuevo" id="btnNuevoPlaza">Nueva Plaza</button>                                
                            <button type="button" dir="editar" id="btnEditarPlaza">Editar Plaza</button>
                            <button type="button" dir="eliminar" id="btnEliminarPlaza" style="margin-left: 5px;">Eliminar Plaza</button>
                        </div>
                        <div id="frmPlazaPorConvocatoriaPers">
                            <div style="display: block;overflow: hidden;border:0.1em #c9c9c9 solid;padding:4px;width: 99%;">
                                <label style="float: left;width: 15%;margin-top: 1px;padding:8px 5px;vertical-align: middle">Buscar Plaza</label>
                                <input type="text" style="float: left;width: 82%;padding: 5px;" id="txtBuscarPlaza" name="txtBuscarActividad" />
                            </div>
                            <div class="jgrid ui-widget ui-widget-content" style=" margin: 5px auto;padding:0px;">
                                <div class="header ui-state-default" style="padding: 0;">
                                    <!--<div id="idPlazah" data="0" style="width: 5%;" type="integer">Id</div>-->
                                    <div id="cargoPlazah" data="1" class="sortable" style="width: 45%;" type="string">Cargo</div>
                                    <div id="ingresoPlazah" data="2" style="width: 15%;" type="string">Ingreso Mensual</div>
                                    <div id="modalidadPlazah" data="3" style="width: 20%;" type="string">Modalidad</div>
                                    <div id="vacantesPlazah" data="4" style="width: 10%;" type="string">Nr. Vacantes</div>
                                </div>
                                <div class="body" style="padding:0;"></div>
                            </div>
                            <input type="hidden" value="10" id="limitPlaza" />
                            <input type="hidden" value="0" id="startPlaza" />
                            <input type="hidden" value="0" id="currentPlaza" />
                        </div>
                    </div>
                    <!-- fin -->
                    <!-- para registrar o editar un actividades convocatoria calendario  -->
                    <div id="frmRegistroActividad" class="ui-widget ui-widget-content" style="display: none;margin: 5px; padding: 0; font-size: 12px;">        
                        <div id="message3" class="message ui-widget ui-state-highlight" style="padding: 10px; margin: 5px auto;">Aqui puedes Registrar las actividad</div>
                        <form class="ui-widget ui-widget-content" style="padding: 5px;">
                            <div>
                                <label>Fecha Inicio:</label><input class="importActi" id="txtFechaInicio" style="width: 12%;" type="text" />
                            </div>
                            <div>
                                <label>Fecha Fin:</label><input  class="importActi" id="txtFechaFin" style="width: 12%;" type="text" />
                            </div>
                            <div>
                                <label>Actividad:</label>
                                <select id="cmbnombreActividad" style="width: 52%;"></select>
                                <button type="button" dir="eliminar"  id="btnEliminarnombreActividad" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only" aria-disabled="false">
                                    <span class="ui-button-icon-primary ui-icon ui-icon-trash"></span>
                                    <span class="ui-button-text">Eliminar</span>
                                </button>
                                <button type="button" dir="editar" id="btnEditarnombreActividad" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only" role="button" aria-disabled="false">
                                    <span class="ui-button-icon-primary ui-icon ui-icon-pencil"></span>
                                    <span class="ui-button-text">Nuevo</span>
                                </button>
                                <button type="button" dir="nuevo" id="btnNuevonombreActividad" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only" role="button" aria-disabled="false">
                                    <span class="ui-button-icon-primary ui-icon ui-icon-plus"></span>
                                    <span class="ui-button-text">Nuevo</span>
                                </button>                                    
                            </div>
                            <div dir="publicar" role="div">
                                <label>Estado de la Actividad</label><input type="checkbox" id="txtEstadoActividad" style="float: left;text-align: left;width: auto" />
                            </div>
                        </form>
                        <form>
                            <div style="margin-top: 5px;"><button type="button" id="btnCancelarActividad" style="margin-left: 5px;">Cancelar</button><button type="button" id="btnGuardarActividad">Guardar</button></div>
                        </form>
                    </div>

                    <!-- fin -->
                    <!-- para registrar o editar un Plazas Convocatoria  -->
                    <div id="frmRegistroPlaza" class="ui-widget ui-widget-content" style="display: none;margin: 5px; padding: 0; font-size: 12px;">        
                        <div id="message4" class="message ui-widget ui-state-highlight" style="padding: 10px; margin: 5px auto;">Aqui puedes Registrar las Plazas a Convocar</div>
                        <form class="ui-widget ui-widget-content" style="padding: 5px;">
                            <div>
                                <label>Cargo:</label><input class="importPlaza" id="txtCargo" style="width: 60%;" type="text" />
                            </div>
                            <div>
                                <label>Ingreso Mensual:</label><input class="importPlaza" id="txtCostoMensual" style="width: 12%;" type="text" />
                            </div>
                            <div>
                                <label>Modalidad</label><input class="importPlaza" id="txtModalidad" style="width: 60%;" type="text" />
                            </div>
                            <div>
                                <label>Nro Plazas</label><input id="txtPlazas" style="width: 12%;" value="1" type="text" />
                            </div>
                            <input id="opcion"  type='hidden' value="1" />
                            <input id="txtIdPlaza"  type='hidden' value="" />
                        </form>
                        <form>
                            <div style="margin-top: 5px;"><button id="btnCancelarPlaza" style="margin-left: 5px;" type="button">Cancelar</button><button  type="button" id="btnGuardarPlaza">Guardar</button></div>
                        </form>
                    </div>
                    <!-- fin -->
                    <!--inicio para Atividad-->
                    <div id="frmRegistroActiNeto" style="display: none; font-size: 12px;">
                        <div id="message4" class="message ui-widget ui-state-highlight" style="padding: 5px;">Agregue un Nuevo Item</div>
                        <form  class="ui-widget ui-widget-content" style="padding: 0 3px;">
                            <div style="width: 100%; margin:5px 0px;">
                                <label style="width: 30%; ">Nombre </label><input style="width: 68%" type="text" id="txtDescripcionActiNeto" />
                            </div>
                        </form>
                        <form>
                            <div style="margin-top: 5px;"><button  type="button" id="btnCancelarActiNeto" style="margin-left: 5px;">Cancelar</button><button  type="button" id="btnGuardarActiNeto">Guardar</button></div>    
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
                        <input class="noMessage ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover" style="padding:3px;float: right; margin-left: 5px;" type="button" value="No" />
                        <input class="siMessage ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover" style="padding:3px;float: right;" type="button" value="S&iacute;" />        
                    </div>
                </div>

                <div id="dialog-pers" title="Administrar Sus Archivos">
                    <div id="message6" class="message ui-widget ui-state-highlight" style="padding: 5px;">Administre los Documentos a Publicar por cada Actividad Seleccionada</div>
                    <div id="archivos"></div>
                    <div>
                        <button  type="button" role="button" id="nuevo" dir="nuevo" rel="true" class="ui-button "><span> Nuevo </span></button>
                        <button type="button" id="eliminar" dir="eliminar" rel="false" style="clear: both" class="ui-button"><span> Eliminar </span></button>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>                