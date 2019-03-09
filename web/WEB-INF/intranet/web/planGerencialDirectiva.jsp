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
        <script type="text/javascript" src="resources/js/admin/controller/plangerencialController.js"></script>
        <link rel="shortcut icon" type="image/x-icon" href="resources/images/16x16/favicon.ico" />
        <title>PLAN GERENCIAL Y DIRECTIVA</title>
        <style>
            #listFuncionarios {
                font-size: 11px;
            }
            #listDirectivos {
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
                    <h2 class="ui-widget ui-widget-header ui-corner-top">Organizar la Plana Gerencial, Directiva y Funcionaria</h2>
                    <div id="message" class="message ui-widget ui-state-highlight">Aqui puedes Agregar / Editar y Eliminar Funcionarios de la institución</div>
                    <!-- para registrar o editar un agenda -->
                    <div id="tabs">
                        <ul >
                            <li>
                                <a href="#ui-tabs-0">Funcionarios</a>
                            </li>
                            <li>
                                <a href="#ui-tabs-1">Directivo</a>
                            </li>
                        </ul>
                        <div id="ui-tabs-0">
                            <div id="frmRegistroFuncionario" class="ui-widget ui-widget-content" style="display: none;margin: 5px; font-size: 12px;">
                                <form id="frmRegistroFuncionarioSend">
                                    <div>
                                        <label>Nombres y Apellidos</label><input type="text" class="casilla ui-corner-all ui-widget"  id="txtNombre" name="txtNombre" style="width: 62%; " />
                                    </div>
                                    <div>
                                        <label>Numero de D.N.I.</label><input type="text" class="casilla ui-corner-all ui-widget" maxlength="8"  id="txtDNI" name="txtDNI" style="width: 12%; " />
                                    </div>  
                                    <div>
                                        <label>Cargo</label>
                                        <input type="text" class="casilla ui-corner-all ui-widget"  id="txtCargo" name="txtCargo" style="width: 62%; " />
                                    </div>
                                    <div>
                                        <label>Oficina</label><select name="txtOrganigrama" id ="txtOrganigrama" >
                                            <option value="GERENCIA GENERAL" >GERENCIA GENERAL</option>
                                            <option value="DIRECCION DE INFRAESTRUCTURA">DIRECCION DE INFRAESTRUCTURA</option>
                                            <option value="DIRECCION DE MANEJO AMBIENTAL">DIRECCION DE MANEJO AMBIENTAL</option>
                                            <option value="DIRECCION DE DESARROLLO AGROPECUARIO">DIRECCION DE DESARROLLO AGROPECUARIO</option>
                                            <option value="ORGANO DE CONTROL INSTITUCIONAL">ORGANO DE CONTROL INSTITUCIONAL</option>
                                            <option value="OFICINA DE ASESORIA JURIDICA">OFICINA DE ASESORIA JURIDICA</option>
                                            <option value="OFICINA DE PRESUPUESTO Y PLANIFICACION">OFICINA DE PRESUPUESTO Y PLANIFICACION</option>
                                            <option value="OFICINA DE ADMINISTRACION">OFICINA DE ADMINISTRACION</option>
                                            <option value="OTRA OFICINA">OTRA OFICINA</option>
                                        </select>
                                    </div>                            
                                    <div>
                                        <label>Nivel</label><input type="text" class="casilla ui-corner-all ui-widget"  id="txtNivel" name="txtNivel" style="width: 12%; " />
                                    </div>
                                    <div>
                                        <label>Regimen Laboral</label><input type="text" class="casilla ui-corner-all ui-widget"  id="txtRegimen" name="txtRegimen" style="width: 12%; " />
                                    </div>     
                                    <div>
                                        <label>Retribución Mensual</label><input type="text" class="casilla ui-corner-all ui-widget"  id="txtRetribucion" value='0' name="txtRetribucion" style="width: 12%; " />
                                    </div>                             
                                    <div>
                                        <label>Designado Por</label><input type="text" class="casilla ui-corner-all ui-widget"  id="txtResolucion" name="txtResolucion" style="width: 62%; " />
                                    </div>
                                    <div>
                                        <label>Fecha Desiganción</label><input id="txtFecha" class="casilla" name="txtFecha" style="width: 12%;" type="text" />
                                    </div>
                                    <div>
                                        <label>Profesión</label><input id="txtProfesion" class="casilla" name="txtProfesion" type="text"  style="width: 62%; "/>
                                    </div>
                                    <div>
                                        <label>Telefono</label><input id="txtTelefono" class="casilla" name="txtTelefono" type="text"  style="width: 62%; "/>
                                    </div>
                                    <div>
                                        <label>Fax</label><input id="txtFax" name="txtFax" class="casilla" type="text"  style="width: 62%; "/>
                                    </div>                            
                                    <div>
                                        <label>Correo Electrónico</label><input id="txtEmail" class="casilla" name="txtEmail" type="text"  style="width: 62%; "/>
                                    </div>
                                    <div >
                                        <label>Destacado </label><input type="checkbox" name="txtDestacado" id="txtDestacado"  style="float:left; text-align:left; width:auto" />
                                    </div>
                                    <div dir="publicar" role="div">
                                        <label>Estado del Registro </label><input type="checkbox" checked="checked" name="txtEstado" id="txtEstado" style="float: left; text-align: left; width: auto" />
                                    </div>

                                    <input name="codigo" class="casilla" type="hidden" id="codigo"  value="" />
                                    <input name="txtCurriculum" type="hidden" id="txtCurriculum"  value="nocurriculum.pdf" />
                                    <input name="txtFoto" type="hidden" id="txtFoto"  value="no-photo.gif" />
                                </form>
                                <form id='file_upload' action='./Upload' method='POST' enctype='multipart/form-data' >
                                    <div id='drop_zone_1'>
                                        <label>Hoja de Vida (PDF)</label>
                                        <input  id='file_1' class=" casilla ui-widget ui-widget-content ui-corner-all" style="width: 62%; " type='file' name='file_1' >
                                    </div>
                                    <table id='files_1' class='tablafile' style='background:yellow;'></table>
                                </form>

                                <form id='file_upload_2' action='./Upload' method='POST' enctype='multipart/form-data' >
                                    <div id='drop_zone_2'>
                                        <label>Foto de Perfil (100x130px)</label>
                                        <div id="fotoPerfil" style=" padding: 3px;">  
                                            <div id ="fotito" class="ui-widget-content" style=" width: 100px; height: 130px;"></div>
                                            <table id='files_2' class='tablafile'></table>
                                            <input  id='file_2' class=" casilla ui-widget ui-widget-content ui-corner-all" style="width: 62%; " type='file' name='file_2' >
                                        </div>
                                    </div>

                                </form>

                                <form>
                                    <div style="margin-top: 5px;"><button  id="btnCancelarFuncionario" type="button" style="margin-left: 5px;">Cancelar</button><button type="button" id="btnGuardarFuncionario">Guardar</button></div>
                                </form>

                            </div>
                            <!-- fin -->
                            <div id="widget" class="ui-widget ui-widget-content" style="margin:5px;">
                                <div>
                                    <button type="button" dir="nuevo" id="btnNuevoFuncionario">Nuevo Funcionario</button>
                                    <button type="button" dir="editar" id="btnEditarFuncionario" style="margin-left: 5px;">Editar Funcionario</button>
                                    <button type="button" dir="eliminar" id="btnEliminarFuncionario" style="margin-left: 5px;">Eliminar Funcionario</button>
                                </div>
                            </div>
                            <div id="frmFuncionario">
                                <div style="display: block; overflow: hidden; border:0.1em #c9c9c9 solid; padding:4px; width: 99%;">
                                    <label style="float: left; width: 15%; padding:10px; vertical-align: middle">Buscar Funcionario:</label>
                                    <input type="text" style="float: left; width: 75%; padding: 5px;" id="txtBuscarFuncionario" name="txtBuscarFuncionario" />
                                </div>
                                <div class="jgrid ui-widget ui-widget-content ui-corner-all" style=" margin: 4px auto;padding:0px;">
                                    <div class="header ui-state-default ui-corner-top" style="padding: 0;">
                                        <div id="idFuncionario" data="0" style="width: 5%; display:none" type="integer">Id</div>
                                        <div id="nombre" data="1" style="width: 22%;" type="integer">Nombre</div>
                                        <div id="cargo" data="2" style="width: 20%;" type="integer">Cargo</div>
                                        <div id="dni" data="3" class="sortable" style="width: 8%;" type="string">DNI</div>
                                        <div id="telefono" data="4" class="sortable" style="width: 24%;" type="string">Telefono</div>
                                        <div id="curriculum" data="5" class="sortable" style="width: 10%;" type="string">Curriculum</div>
                                    </div>
                                    <div class="body" style="padding:0;"></div>
                                </div>
                                <input type="hidden" value="10" id="limit1" />
                                <input type="hidden" value="0" id="start1" />
                                <input type="hidden" value="0" id="current1" />
                            </div>

                            <!-- fin -->

                        </div>
                        <div id="ui-tabs-1"> <!-- Directivo Directivo -->
                            <div id="frmRegistroDirectivo" class="ui-widget ui-widget-content" style="display: none;margin: 5px; font-size: 12px;">
                                <form id="frmRegistroDirectivoSend">
                                    <div>
                                        <label>Nombres y Apellidos</label><input type="text" class="casilla_1 ui-corner-all ui-widget"  id="txtNombre_1" name="txtNombre" style="width: 62%; " />
                                    </div>
                                    <div>
                                        <label>Numero de D.N.I.</label><input type="text" class="casilla_1 ui-corner-all ui-widget" maxlength="8"  id="txtDNI_1" name="txtDNI" style="width: 12%; " />
                                    </div>
                                    <div>
                                        <label>Cargo</label><input type="text" class="casilla_1 ui-corner-all ui-widget"  id="txtCargo_1" name="txtCargo" style="width: 62%; " />
                                    </div>                                    
                                    <div>
                                        <label>Institucion</label><input type="text" class="casilla_1 ui-corner-all ui-widget"  id="txtInstitucion_1" name="txtInstitucion" style="width: 62%; " />
                                    </div>
                                    <div>
                                        <label>Nivel</label><input type="text" class="casilla_1 ui-corner-all ui-widget"  id="txtNivel_1" name="txtNivel" style="width: 12%; " />
                                    </div>
                                    <div>
                                        <label>Regimen Laboral</label><input type="text" class="casilla_1 ui-corner-all ui-widget"  id="txtRegimen_1" name="txtRegimen" style="width: 12%; " />
                                    </div>     
                                    <div>
                                        <label>Retribución Mensual</label><input type="text" class="casilla_1 ui-corner-all ui-widget"  id="txtRetribucion_1" name="txtRetribucion" value="0" style="width: 12%; " />
                                    </div>                             
                                    <div>
                                        <label>Designado Por</label><input type="text" class="casilla_1 ui-corner-all ui-widget"  id="txtResolucion_1" name="txtResolucion" style="width: 62%; " />
                                    </div>
                                    <div>
                                        <label>Fecha Desiganción</label><input id="txtFecha_1" class="casilla_1" name="txtFecha" style="width: 12%;" type="text" />
                                    </div>
                                    <div>
                                        <label>Profesión</label><input id="txtProfesion_1" class="casilla_1" name="txtProfesion" type="text"  style="width: 62%; "/>
                                    </div>
                                    <div>
                                        <label>Telefono</label><input id="txtTelefono_1" class="casilla_1" name="txtTelefono" type="text"  style="width: 62%; "/>
                                    </div>
                                    <div>
                                        <label>Fax</label><input id="txtFax_1" name="txtFax" class="casilla_1" type="text"  style="width: 62%; "/>
                                    </div>                            
                                    <div>
                                        <label>Correo Electrónico</label><input id="txtEmail_1" class="casilla_1" name="txtEmail" type="text"  style="width: 62%; "/>
                                    </div>
                                    <div dir="publicar" role="div">
                                        <label>Estado del Registro </label><input type="checkbox" checked="checked" name="txtEstado" id="txtEstado_1" style="float: left; text-align: left; width: auto" />
                                    </div>
                                    <input name="codigo" class="casilla_1" type="hidden" id="codigo_1"  value="" />
                                    <input name="txtCurriculum" type="hidden" id="txtCurriculum_1"  value="nocurriculum.pdf" />
                                    <input name="txtFoto" type="hidden" id="txtFoto_1"  value="no-photo.gif" />
                                </form>
                                <form id='file_upload_3' action='./Upload' method='POST' enctype='multipart/form-data' >
                                    <div id='drop_zone_3'>
                                        <label>Hoja de Vida (PDF)</label>
                                        <input  id='file_3' class="casilla_1 ui-widget ui-widget-content ui-corner-all" style="width: 62%; " type='file' name='file_3' >
                                    </div>
                                    <table id='files_3' class='tablafile_1' style='background:yellow;'></table>
                                </form>

                                <form id='file_upload_4' action='./Upload' method='POST' enctype='multipart/form-data' >
                                    <div id='drop_zone_4'>
                                        <label>Foto de Perfil (100x130px)</label>
                                        <div id="fotoPerfil_1" style=" padding: 3px;">  
                                            <div id ="fotito_1" class="ui-widget-content" style=" width: 100px; height: 130px;"></div>
                                            <table id='files_4' class='tablafile_1'></table>
                                            <input  id='file_4' class="casilla_1 ui-widget ui-widget-content ui-corner-all" style="width: 62%; " type='file' name='file_4' >
                                        </div>
                                    </div>

                                </form>

                                <form>
                                    <div style="margin-top: 5px;"><button  id="btnCancelarDirectivo" type="button" style="margin-left: 5px;">Cancelar</button><button type="button" id="btnGuardarDirectivo">Guardar</button></div>
                                </form>

                            </div>
                            <!-- fin -->
                            <div id="widget_1" class="ui-widget ui-widget-content" style="margin:5px;">
                                <div>
                                    <button type="button" dir="nuevo" id="btnNuevoDirectivo">Nuevo Directivo</button>
                                    <button type="button" dir="editar" id="btnEditarDirectivo" style="margin-left: 5px;">Editar Directivo</button>
                                    <button type="button" dir="eliminar" id="btnEliminarDirectivo" style="margin-left: 5px;">Eliminar Directivo</button>
                                </div>
                            </div>
                            <div id="frmDirectivo">
                                <div style="display: block; overflow: hidden; border:0.1em #c9c9c9 solid; padding:4px; width: 99%;">
                                    <label style="float: left; width: 15%; padding:10px; vertical-align: middle">Buscar Directivo:</label>
                                    <input type="text" style="float: left; width: 75%; padding: 5px;" id="txtBuscarDirectivo" name="txtBuscarDirectivo" />
                                </div>
                                <div class="jgrid ui-widget ui-widget-content ui-corner-all" style=" margin: 4px auto;padding:0px;">
                                    <div class="header ui-state-default ui-corner-top" style="padding: 0;">
                                        <div id="idDirectivo" data="0" style="width: 5%; display:none" type="integer">Id</div>
                                        <div id="nombre" data="1" style="width: 22%;" type="integer">Nombre</div>
                                        <div id="cargo" data="2" style="width: 20%;" type="integer">Cargo</div>
                                        <div id="dni" data="3" class="sortable" style="width: 8%;" type="string">DNI</div>
                                        <div id="telefono" data="4" class="sortable" style="width: 24%;" type="string">Telefono</div>
                                        <div id="curriculum" data="5" class="sortable" style="width: 10%;" type="string">Curriculum</div>
                                    </div>
                                    <div class="body" style="padding:0;"></div>
                                </div>
                                <input type="hidden" value="10" id="limit2" />
                                <input type="hidden" value="0" id="start2" />
                                <input type="hidden" value="0" id="current2" />
                            </div>
                        </div>
                    </div>
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