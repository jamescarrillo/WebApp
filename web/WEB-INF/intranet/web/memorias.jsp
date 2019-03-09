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
        <script type="text/javascript" src="resources/js/admin/controller/memoriasController.js"></script>
        <link rel="shortcut icon" type="image/x-icon" href="resources/images/16x16/favicon.ico" />
        <title>Memorias Anuales</title>
        <style>
            div.file_upload_small {
                width: 200px;
                height: 30px;
                line-height: 30px;
                font-size: auto;

            }

            div.file_upload_large {
                width: 100%;
                height: 150px;
                line-height: 150px;
                font-size: 20px;

            }

            div.file_upload_highlight {

            }



            .file_upload iframe, .file_upload button {
                display: block;
            }

            .file_upload_preview img {
                width: 80px;
            }

            .file_upload_progress div {
                width: 150px;
                height: 15px;
            }

            .file_upload_cancel button {
                cursor: pointer;
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
                    <h2 class="ui-widget ui-widget-header ui-corner-top">Memorias Anuales</h2>
                    <div id="message" class="message ui-widget ui-state-highlight">Aqui puedes Publicar Las memorias anuales</div>


                    <div class="content-marco">
                        <!-- para registrar o editar una MEMO -->
                        <div id="frmRegistroMEMO"  style="margin: 5px; display: none; padding:2px;">
                            <div id="message2" class="message ui-widget ui-state-highlight" style="padding: 5px;">Complete el Formulario</div>
                            <form  method="POST" enctype="multipart/form-data" id="" class="ui-widget ui-widget-content" style="margin-top: 5px;"  >
                                <div>
                                    <label style="padding:5px 0px;">Asignar Registro desde ArcDig</label>
                                    <button dir="nuevo" id="asignarArcDig_2" type="button"  style="float:left">Asignar</button>
                                </div>
                                <div>
                                    <label style="padding:5px 0px;">Fecha</label>
                                    <input type="text"  id="txtFechaMEMO" class="casilla" name="txtFechaMEMO" style="width: 10%;" />
                                </div>
                                <div>
                                    <label style="padding:5px 0px;">Titulo</label>
                                    <input type="text"  id="txtTituloMEMO" class="casilla" name="txtTituloMEMO" style="width: 62%;" />
                                </div>                                
                                <div>
                                    <label style="padding:5px 0px;">Descripcion</label>
                                    <textarea  id="txtDescripcionMEMO" class="casilla" name="txtDescripcionMEMO" style="width: 62%; height: 40px; resize: none;"></textarea>
                                </div>
                                <div>
                                    <label>Estado de la MEMO</label><input type="checkbox" checked="checked" id="txtEstadoMEMO" style="float: left; text-align: left; width: auto" />
                                </div>
                                <input type="hidden" id="txtIdMEMO" class="casilla" value="" />
                                <input type="hidden" id="txtArcDigId_2" class="casilla" value="" />
                            </form>
                            <form class="ui-widget ui-widget-content" style="margin-top: 5px; ">
                                <div style="margin-top: 5px;">
                                    <button type="button" id="guardarMEMO">Guardar</button>
                                    <button type="button" id="btnCancelarMEMO" style="margin-left: 5px;">Cancelar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                    <!-- fin -->
                    <div id="dialog-MEMO" title="Seleccionar Registro desde ArcDig" style="display: none">
                        <div style="display: block;overflow: hidden;border:0.1em #c9c9c9 solid;padding:4px;width: 99%;">
                            <label style="float: left;width: 15%;padding:10px;vertical-align: middle">Buscar MEMO</label>
                            <input type="text" style="float: left;width: 50%;padding: 5px;" id="buscar-arcDig-MEMO" />
                        </div>
                        <div id="arcDigMEMO"></div>
                        <input id="arrayMEMO" type="hidden" value="" />
                        <fieldset class='ui-widget-content ui-corner-bottom' style='text-align:center; padding: 5px 0px'><button type='button' id='seleccionar_2'>Seleccionar</button><button type='button' id='close_2'>Cerrar</button></fieldset>
                    </div>
                    <div id="widgetMEMO" class="ui-widget ui-widget-content" style="margin:5px;">
                        <div>
                            <button dir="nuevo" id="btnActualizarMEMO">Actualizar de ArcDig</button>
                            <button dir="nuevo" id="btnNuevoMEMO">Nueva MEMO</button>
                            <button dir="editar" id="btnEditarMEMO" style="margin-left: 5px;">Editar MEMO</button>
                            <button dir="eliminar" id="btnEliminarMEMO" style="margin-left: 5px;">Eliminar MEMO</button>

                        </div>
                    </div>
                    <div id="divMEMO">
                        <div style="display: block;overflow: hidden;border:0.1em #c9c9c9 solid;padding:4px;width: 99%;">
                            <label style="float: left;width: 15%;padding:10px;vertical-align: middle">Buscar MEMO:</label>
                            <input type="text" style="float: left;width: 50%;padding: 5px;" id="buscar-MEMO" />
                        </div>
                        <div id="frmMEMO"></div>
                        <input type="hidden" value="" id="arrayE" />
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
    </body>
</html>
