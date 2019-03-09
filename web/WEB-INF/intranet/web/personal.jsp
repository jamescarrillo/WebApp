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
        <script type="text/javascript" src="resources/js/admin/controller/personalController.js"></script>
        <link rel="shortcut icon" type="image/x-icon" href="resources/images/16x16/favicon.ico" />
        <title>Personal</title>
        <script>
            function mostrarArchivo() {
                var frame = document.getElementById('archivo-subido');
                var img =  frame.contentWindow.document.getElementById('mensaje');
                if (img != undefined) {
                    if($(img).attr("data")=="yes"){
                        $("#btnSubir").button({
                            disabled:false,
                            icons:{
                                primary:'ui-icon-disk'
                            }
                        });
                        $("#message2").removeClass("ui-state-error").addClass("ui-state-highlight").html($(img).html());
                    }
                    else{
                        $("#btnSubir").button({
                            disabled:true,
                            icons:{
                                primary:'ui-icon-disk'
                            }
                        });
                        $("#message2").removeClass("ui-state-highlight").addClass("ui-state-error").html($(img).html());
                    }
                    //var imgRe = document.getElementById("photo");
                    //imgRe.src = img.src;
                }
            }
            function mostrarArchivoS() {
                var frame = document.getElementById('archivo-subidoS');
                var img = frame.contentWindow.document.getElementById('mensajeS');
                
                if (img != null) {
                    if($(img).attr("data")=="yes"){
                        
                        $("#btnSubirS").button({
                            disabled:false,
                            icons:{
                                primary:'ui-icon-disk'
                            }
                        });
                        $("#message3").removeClass("ui-state-error").addClass("ui-state-highlight").html($(img).html());
                    }
                    else{
                        $("#btnSubirS").button({
                            disabled:true,
                            icons:{
                                primary:'ui-icon-disk'
                            }
                        });
                        $("#message3").removeClass("ui-state-highlight").addClass("ui-state-error").html($(img).html());
                    }
                    //var imgRe = document.getElementById("photo");
                    //imgRe.src = img.src;
                }
            }
            function mostrarArchivoP() {
                var frame = document.getElementById('archivo-subidoP');
                var img = frame.contentWindow.document.getElementById('mensajeP');
                
                if (img != null) {
                    if($(img).attr("data")=="yes"){
                        
                        $("#btnSubirP").button({
                            disabled:false,
                            icons:{
                                primary:'ui-icon-disk'
                            }
                        });
                        $("#message4").removeClass("ui-state-error").addClass("ui-state-highlight").html($(img).html());
                    }
                    else{
                        $("#btnSubirP").button({
                            disabled:true,
                            icons:{
                                primary:'ui-icon-disk'
                            }
                        });
                        $("#message4").removeClass("ui-state-highlight").addClass("ui-state-error").html($(img).html());
                    }
                    //var imgRe = document.getElementById("photo");
                    //imgRe.src = img.src;
                }
            }
            function mostrarArchivoT() {
                var frame = document.getElementById('archivo-subidoT');
                var img = frame.contentWindow.document.getElementById('mensajeT');
                if (img != null) {
                    if($(img).attr("data")=="yes"){
                        
                        $("#btnSubirT").button({
                            disabled:false,
                            icons:{
                                primary:'ui-icon-disk'
                            }
                        });
                        $("#message5").removeClass("ui-state-error").addClass("ui-state-highlight").html($(img).html());
                    }
                    else{
                        $("#btnSubirT").button({
                            disabled:true,
                            icons:{
                                primary:'ui-icon-disk'
                            }
                        });
                        $("#message5").removeClass("ui-state-highlight").addClass("ui-state-error").html($(img).html());
                    }
                    //var imgRe = document.getElementById("photo");
                    //imgRe.src = img.src;
                }
            }
            
        </script>
        <style>
            .body ul li {
                font-size: 11px;
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
                    <h2 class="ui-widget ui-widget-header ui-corner-top">Adquisiciones y Contrataciones</h2>
                    <div id="message" class="message ui-widget ui-state-highlight">Aqui puedes Administrar Adquicisiones y Contrataciones de la instituci&oacute;n </div>
                    <div class="content-marco">
                        <div id="tabs">
                            <ul >
                                <li>
                                    <a href="#ui-tabs-0"><span> Personal de Planilla  </span> </a>
                                </li>
                                <li>
                                    <a href="#ui-tabs-1"><span> Locador de  Servicios </span> </a>
                                </li>
                                <li>
                                    <a href="#ui-tabs-2"><span> Contratos Administrativos de Servicios </span> </a>
                                </li>
                                <li>
                                    <a href="#ui-tabs-3"><span> Personal por Categorías </span> </a>
                                </li>
                            </ul>
                            <div id="ui-tabs-0">
                                <div class="content-marco">
                                    <!-- para registrar o editar una PersonalPlanilla -->
                                    <div id="frmRegistroPersonalPlanilla"  style="margin: 5px; display: none; padding:2px;">
                                        <div id="message2" class="message ui-widget ui-state-highlight" style="padding: 5px;">Selecciona el Archivo para importar</div>
                                        <form target="archivo-subido" id="frmPersonalPlanillaFile" class="ui-widget ui-widget-content" style="margin-top: 5px;" action="./GestionTransparente?action=CargarArchivo&t=mensaje" enctype="multipart/form-data" method="post">
                                            <div>
                                                <label style="padding:5px 0px;">Buscar Archivo</label>
                                                <input id="archivo" name="archivo" type="file" style="width: 62%;border: none;" value="" readonly="true" accept="application/vnd.ms-excel"   />                            
                                                <iframe name="archivo-subido" id="archivo-subido" onload="mostrarArchivo()" style="display: none;"></iframe>
                                            </div>                        
                                        </form>
                                        <form class="ui-widget ui-widget-content" style="margin-top: 5px; ">
                                            <div style="float:left; color: red;" id="msnError_1">

                                            </div>
                                            <div style="margin-top: 5px;">

                                                <button dir="nuevo" id="btnSubir" type="button">Ver Filas</button>
                                                <button type="button" id="guardarFilasPersonalPlanilla">Guardar</button>
                                                <button type="button" id="btnCancelarPersonalPlanilla" style="margin-left: 5px;">Cancelar</button>
                                            </div>
                                        </form>
                                        <div id="frmVerPersonalPlanilla">
                                            <div class="jgrid ui-widget ui-widget-content ui-corner-all" style=" margin: 4px auto;padding:0px;">
                                                <div class="header ui-state-default ui-corner-top" style="padding: 0;">
                                                    <div id="idx" data="0" class="sortable" style="width: 2%;" type="string">Id</div>
                                                    <div id="nombrePersonalPlanillax" data="1" class="sortable" style="width: 19%;" type="string">Apellidos y Nombres</div>
                                                    <div id="nombrePersonalPlanillax" data="1" class="sortable" style="width: 10%;" type="string">DNI</div>
                                                    <div id="trimestrePersonalPlanillax" data="2" class="sortable" style="width: 8%;" type="string">Mes</div>
                                                    <div id="categoriaPersonalPlanillax" data="3" class="sortable" style="width: 8%;" type="string">Categoria</div>
                                                    <div id="cargoPersonalPlanillax" data="4" class="sortable" style="width: 20%;" type="string">Cargo</div>
                                                    <div id="regimen" data="5" class="sortable" style="width: 10%;" type="string">Reg. Lab.</div>
                                                    <div id="total" data="5" class="sortable" style="width: 8%;" type="string">Ingre. Total</div>
                                                </div>
                                                <div class="body" style="padding:0;"></div>
                                            </div>
                                            <input type="hidden" value="10" id="limitx" />
                                            <input type="hidden" value="0" id="startx" />
                                            <input type="hidden" value="0" id="currentx" />
                                        </div>
                                    </div>
                                    <!-- fin -->
                                    <div id="widget" class="ui-widget ui-widget-content" style="margin:5px;">
                                        <div>
                                            <button type="button"  dir="nuevo" id="btnNuevoPersonalPlanilla">Nueva Personal en Planilla</button>
                                            <button type="button"  dir="eliminar" id="btnEliminarPersonalPlanilla" style="margin-left: 5px;">Eliminar Personal en Planilla</button>
                                        </div>
                                    </div>
                                    <div id="frmPersonalPlanilla">
                                        <div style="display: block;overflow: hidden;border:0.1em #c9c9c9 solid;padding:4px;width: 99%;">
                                            <label style="float: left;width: 15%;padding:10px;vertical-align: middle">Buscar Personal:</label>
                                            <input type="text" style="float: left;width: 50%;padding: 5px;" id="txtBuscarPersonalPlanilla" name="txtBuscarPersonalPlanilla" />
                                            <label style="float: left;width: 5%;padding:10px;vertical-align: middle">Año:</label>
                                            <select id="anhosPersonalPlanilla" style="float: left;width: 20%;padding: 5px;"></select>
                                        </div>
                                        <div class="jgrid ui-widget ui-widget-content ui-corner-all" style=" margin: 4px auto;padding:0px;">
                                            <div class="header ui-state-default ui-corner-top" style="padding: 0;">
                                                <div id="nombrePersonalPlanilla" data="1" class="sortable" style="width: 20%; padding-left: 0px" type="string">Apellidos y Nombres</div>
                                                <div id="dni" data="1" class="sortable" style="width: 10%;" type="string">DNI</div>
                                                <div id="trimestrePersonalPlanilla" data="2" class="sortable" style="width: 8%;" type="string">Mes</div>
                                                <div id="categoriaPersonalPlanilla" data="3" class="sortable" style="width: 8%;" type="string">Categoria</div>
                                                <div id="cargoPersonalPlanilla" data="4" class="sortable" style="width: 20%;" type="string">Cargo</div>
                                                <div id="regimen" data="5" class="sortable" style="width: 10%;" type="string">Reg. Lab.</div>
                                                <div id="total" data="5" class="sortable" style="width: 10%;" type="string">Ingre. Total.</div>
                                                <div  data="3" style="width: 2%;" type="string">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
                                            </div>
                                            <div class="body" style="padding:0;"></div>
                                        </div>
                                        <input type="hidden" value="10" id="limit1" />
                                        <input type="hidden" value="0" id="start1" />
                                        <input type="hidden" value="0" id="current1" />
                                    </div>
                                </div>
                            </div>

                            <!-- Orden Locador -->
                            <div id="ui-tabs-1">
                                <div class="content-marco">

                                    <div id="frmRegistroLocador"  style="margin: 5px; display: none; padding:2px;">
                                        <div id="message3" class="message ui-widget ui-state-highlight" style="padding: 5px;">Selecciona el Archivo para importar</div>
                                        <form target="archivo-subidoS" id="frmLocadors" class="ui-widget ui-widget-content" style="margin-top: 5px;" action="./GestionTransparente?action=CargarArchivo&t=mensajeS" enctype="multipart/form-data" method="post">
                                            <div>
                                                <label style="padding:5px 0px;">Buscar Archivo</label>
                                                <input id="archivoS" name="archivo" type="file" style="width: 62%;border: none;" value="" readonly="true" accept="application/vnd.ms-excel"   />                            
                                                <iframe name="archivo-subidoS" id="archivo-subidoS" onload="mostrarArchivoS()" style="display: none;"></iframe>
                                            </div>                        
                                        </form>
                                        <form class="ui-widget ui-widget-content" style="margin-top: 5px; ">
                                            <div style="float:left; color: red;" id="msnError_2"></div>
                                            <div style="margin-top: 5px;">

                                                <button id="btnSubirS" type="button">Ver Filas</button>
                                                <button type="button" id="guardarFilasLocador">Guardar</button>
                                                <button type="button" id="btnCancelarLocador" style="margin-left: 5px;">Cancelar</button>
                                            </div>
                                        </form>
                                        <div id="frmVerLocador">
                                            <div class="jgrid ui-widget ui-widget-content ui-corner-all" style=" margin: 4px auto;padding:0px;">
                                                <div class="header ui-state-default ui-corner-top" style="padding: 0;">
                                                    <div id="idxx" data="0" class="sortable" style="width: 2%;" type="string">Id</div>
                                                    <div id="nombrePersonalLocador" data="1" class="sortable" style="width: 19%;" type="string">Apellidos y Nombres</div>
                                                    <div style="width:9%"  type="string">DNI</div>
                                                    <div style="width:10%"  type="string">Fecha Ingre.</div>
                                                    <div id="trimestrePersonalLocador" data="2" class="sortable" style="width: 8%;" type="string">Trimestre</div>
                                                    <div id="dependenciaPersonalLocador" data="3" class="sortable" style="width: 18%;" type="string">Dependencia.</div>
                                                    <div id="regimenLocador" data="5" class="sortable" style="width: 10%;" type="string">Codigo Civil</div>
                                                    <div class="sortable" style="width: 10%;" type="string">Ingr. Total</div>
                                                </div>
                                                <div class="body" style="padding:0;"></div>
                                            </div>
                                            <input type="hidden" value="10" id="limitx" />
                                            <input type="hidden" value="0" id="startx" />
                                            <input type="hidden" value="0" id="currentx" />
                                        </div>
                                    </div>

                                    <div id="widgetS" class="ui-widget ui-widget-content" style="margin:5px;">
                                        <div>
                                            <button dir="nuevo" type="button"  id="btnNuevoLocador">Nueva Locador</button>
                                            <button dir="eliminar" type="button"  id="btnEliminarLocador" style="margin-left: 5px;">Eliminar Locador</button>
                                        </div>
                                    </div>
                                    <div id="frmLocador">
                                        <div style="display: block;overflow: hidden;border:0.1em #c9c9c9 solid;padding:4px;width: 99%;">
                                            <label style="float: left;width: 15%;padding:10px;vertical-align: middle">Buscar Locador:</label>
                                            <input type="text" style="float: left;width: 50%;padding: 5px;" id="txtBuscarLocador" name="txtBuscarLocador" />
                                            <label style="float: left;width: 5%;padding:10px;vertical-align: middle">Año:</label>
                                            <select id="anhosLocador" style="float: left;width: 20%;padding: 5px;"></select>
                                        </div>
                                        <div class="jgrid ui-widget ui-widget-content ui-corner-all" style=" margin: 4px auto;padding:0px;">
                                            <div class="header ui-state-default ui-corner-top" style="padding: 0;">
                                                <div id="nombrePersonalLocador" data="1" class="sortable" style="width: 20%;" type="string">Apellidos y Nombres</div>
                                                <div style="width:9%"  type="string">DNI</div>
                                                <div style="width:10%"  type="string">Fecha Ingre.</div>
                                                <div id="trimestrePersonalLocador" data="2" class="sortable" style="width: 8%;" type="string">Trimestre</div>
                                                <div id="dependenciaPersonalLocador" data="3" class="sortable" style="width: 19%;" type="string">Dependencia.</div>
                                                <div id="regimenLocador" data="5" class="sortable" style="width: 10%;" type="string">Codigo Civil</div>
                                                <div class="sortable" style="width: 10%;" type="string">Ingr. Total</div>
                                            </div>
                                            <div class="body" style="padding:0;"></div>
                                        </div>
                                        <input type="hidden" value="10" id="limit2" />
                                        <input type="hidden" value="0" id="start2" />
                                        <input type="hidden" value="0" id="current2" />
                                    </div>
                                </div>
                            </div>

                            <!-- Orden CASes -->
                            <div id="ui-tabs-2">
                                <div class="content-marco">
                                    <div id="frmRegistroCAS"  style="margin: 5px; display: none; padding:2px;">
                                        <div id="message4" class="message ui-widget ui-state-highlight" style="padding: 5px;">Selecciona el Archivo para importar</div>
                                        <form target="archivo-subidoP" id="frmCASs" class="ui-widget ui-widget-content" style="margin-top: 5px;" action="./GestionTransparente?action=CargarArchivo&t=mensajeP" enctype="multipart/form-data" method="post">
                                            <div>
                                                <label style="padding:5px 0px;">Buscar Archivo</label>
                                                <input id="archivoP" name="archivo" type="file" style="width: 62%;border: none;" value="" readonly="true" accept="application/vnd.ms-excel" />                            
                                                <iframe name="archivo-subidoP" id="archivo-subidoP" onload="mostrarArchivoP()" style="display: none;"></iframe>
                                            </div>                        
                                        </form>
                                        <form class="ui-widget ui-widget-content" style="margin-top: 5px; ">
                                            <div style="float:left; color: red;" id="msnError_3"></div>
                                            <div style="margin-top: 5px;">
                                                <button id="btnSubirP" type="button">Ver Filas</button>
                                                <button type="button" id="guardarFilasCAS">Guardar</button>
                                                <button type="button" id="btnCancelarCAS" style="margin-left: 5px;">Cancelar</button>
                                            </div>
                                        </form>
                                        <div id="frmVerCAS">
                                            <div class="jgrid ui-widget ui-widget-content ui-corner-all" style=" margin: 4px auto;padding:0px;">
                                                <div class="header ui-state-default ui-corner-top" style="padding: 0;">
                                                    <div id="idxx" data="0" class="sortable" style="width: 2%;" type="string">Id</div>
                                                    <div id="nombrePersonalLocador" data="1" class="sortable" style="width: 19%;" type="string">Apellidos y Nombres</div>
                                                    <div style="width:9%"  type="string">DNI</div>
                                                    <div style="width:10%"  type="string">Fecha Ingre.</div>
                                                    <div id="trimestrePersonalLocador" data="2" class="sortable" style="width: 8%;" type="string">Trimestre</div>
                                                    <div id="dependenciaPersonalLocador" data="3" class="sortable" style="width: 18%;" type="string">Dependencia.</div>
                                                    <div id="regimenLocador" data="5" class="sortable" style="width: 10%;" type="string">Codigo Civil</div>
                                                    <div class="sortable" style="width: 10%;" type="string">Ingr. Total</div>
                                                </div>
                                                <div class="body" style="padding:0;"></div>
                                            </div>
                                            <input type="hidden" value="10" id="limitx" />
                                            <input type="hidden" value="0" id="startx" />
                                            <input type="hidden" value="0" id="currentx" />
                                        </div>
                                    </div>

                                    <div id="widgetP" class="ui-widget ui-widget-content" style="margin:5px;">
                                        <div>
                                            <button dir="nuevo" id="btnNuevoCAS">Nueva CAS</button>
                                            <button dir="eliminar" id="btnEliminarCAS" style="margin-left: 5px;">Eliminar CAS</button>
                                        </div>
                                    </div>
                                    <div id="frmCAS">

                                        <div style="display: block;overflow: hidden;border:0.1em #c9c9c9 solid;padding:4px;width: 99%;">
                                            <label style="float: left;width: 15%;padding:10px;vertical-align: middle">Buscar CAS:</label>
                                            <input type="text" style="float: left;width: 50%;padding: 5px;" id="txtBuscarCAS" name="txtBuscarCAS" />
                                            <label style="float: left;width: 5%;padding:10px;vertical-align: middle">Año:</label>
                                            <select id="anhosCAS" style="float: left;width: 20%;padding: 5px;"></select>
                                        </div>

                                        <div class="jgrid ui-widget ui-widget-content ui-corner-all" style=" margin: 4px auto;padding:0px;">
                                            <div class="header ui-state-default ui-corner-top" style="padding: 0;">

                                                <div id="nombrePersonalLocador" data="1" class="sortable" style="width: 19%;" type="string">Apellidos y Nombres</div>
                                                <div style="width:9%"  type="string">DNI</div>
                                                <div style="width:10%"  type="string">Fecha Ingre.</div>
                                                <div id="trimestrePersonalLocador" data="2" class="sortable" style="width: 8%;" type="string">Trimestre</div>
                                                <div id="dependenciaPersonalLocador" data="3" class="sortable" style="width: 18%;" type="string">Dependencia.</div>
                                                <div id="regimenLocador" data="5" class="sortable" style="width: 10%;" type="string">Codigo Civil</div>
                                                <div class="sortable" style="width: 10%;" type="string">Ingr. Total</div>
                                            </div>
                                            <div class="body" style="padding:0;"></div>
                                        </div>
                                        <input type="hidden" value="10" id="limit3" />
                                        <input type="hidden" value="0" id="start3" />
                                        <input type="hidden" value="0" id="current3" />
                                    </div>
                                </div>
                            </div>
                            <!-- Compras CAS -->
                            <div id="ui-tabs-3">
                                <div class="content-marco">
                                    <div id="frmRegistroCategoria"  style="margin: 5px; display: none; padding:2px;">
                                        <div id="message5" class="message ui-widget ui-state-highlight" style="padding: 5px;">Selecciona el Archivo para importar</div>
                                        <form target="archivo-subidoT" id="frmCategorias" class="ui-widget ui-widget-content" style="margin-top: 5px;" action="./GestionTransparente?action=CargarArchivo&t=mensajeT" enctype="multipart/form-data" method="post">
                                            <div>
                                                <label style="padding:5px 0px;">Buscar Archivo</label>
                                                <input id="archivoT" name="archivo" type="file" style="width: 62%;border: none;" value=""  accept="application/vnd.ms-excel" />                            
                                                <iframe name="archivo-subidoT" id="archivo-subidoT" onload="mostrarArchivoT()" style="display: none;"></iframe>
                                            </div>
                                        </form>
                                        <form class="ui-widget ui-widget-content" style="margin-top: 5px; ">
                                            <div style="float:left; color: red;" id="msnError_4"></div>
                                            <div style="margin-top: 5px;">
                                                <button id="btnSubirT" type="button">Ver Filas</button>
                                                <button type="button" id="guardarFilasCategoria">Guardar</button>
                                                <button type="button" id="btnCancelarCategoria" style="margin-left: 5px;">Cancelar</button>
                                            </div>
                                        </form>
                                        <div id="frmVerCategoria">
                                            <div class="jgrid ui-widget ui-widget-content ui-corner-all" style=" margin: 4px auto;padding:0px;">
                                                <div class="header ui-state-default ui-corner-top" style="padding: 0;">
                                                    <div id="idxx" data="0" class="sortable" style="width: 2%;" type="string">Id</div>
                                                    <div id="codigoCategoriax" data="0" style="width: 10%;" type="integer">Codigo</div>
                                                    <div id="trimestreCategoriax" data="1" class="sortable" style="width: 10%;" type="string">Trim.</div>
                                                    <div id="cateCategoriax" data="2" class="sortable" style="width: 17%;" type="string">Cargo</div>
                                                    <div id="renumeracionMinCategoria" data="3" class="sortable" style="width: 15%;" type="string">Remune. Min</div>
                                                    <div id="renumeracionMaxCategoria" data="3" class="sortable" style="width: 15%;" type="string">Remune. Max</div>
                                                    <div id="nroTrabajadoresx" data="3" class="sortable" style="width: 15%;" type="string">Nro. Trabajadores</div>
                                                    <div  data="4" style="width: 2%;" type="string">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
                                                </div>
                                                <div class="body" style="padding:0;"></div>
                                            </div>
                                            <input type="hidden" value="10" id="limitx" />
                                            <input type="hidden" value="0" id="startx" />
                                            <input type="hidden" value="0" id="currentx" />
                                        </div>
                                    </div>
                                    <div id="widgetT" class="ui-widget ui-widget-content" style="margin:5px;">
                                        <div>
                                            <button dir="nuevo" type="button"  id="btnNuevoCategoria">Nueva Categoria</button>
                                            <button dir="eliminar" type="button"  id="btnEliminarCategoria" style="margin-left: 5px;">Eliminar Categoria</button>
                                        </div>
                                    </div>
                                    <div id="frmCategoria">
                                        <div style="display: block;overflow: hidden;border:0.1em #c9c9c9 solid;padding:4px;width: 99%;">
                                            <label style="float: left;width: 15%;padding:10px;vertical-align: middle">Buscar Categoria:</label>
                                            <input type="text" style="float: left;width: 50%;padding: 5px;" id="txtBuscarCategoria" name="txtBuscarCategoria" />
                                            <label style="float: left;width: 5%;padding:10px;vertical-align: middle">Año:</label>
                                            <select id="anhosCategoria" style="float: left;width: 20%;padding: 5px;"></select>
                                        </div>
                                        <div class="jgrid ui-widget ui-widget-content ui-corner-all" style=" margin: 4px auto;padding:0px;">
                                            <div class="header ui-state-default ui-corner-top" style="padding: 0;">
                                                <div id="codigoCategoria" data="0" style="width: 10%;" type="integer">Codigo</div>
                                                <div id="trimestreCategoria" data="1" class="sortable" style="width: 10%;" type="string">Trim.</div>
                                                <div id="cateCategoria" data="2" class="sortable" style="width: 20%;" type="string">Cargo</div>
                                                <div id="renumeracionMinCategoria" data="3" class="sortable" style="width: 15%;" type="string">Remune. Min</div>
                                                <div id="renumeracionMaxCategoria" data="3" class="sortable" style="width: 15%;" type="string">Remune. Max</div>
                                                <div id="nroTrabajadores" data="3" class="sortable" style="width: 15%;" type="string">Nro. Trabajadores</div>
                                                <div  data="3" style="width: 2%;" type="string">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
                                            </div>
                                            <div class="body" style="padding:0;"></div>
                                        </div>
                                        <input type="hidden" value="10" id="limit4" />
                                        <input type="hidden" value="0" id="start4" />
                                        <input type="hidden" value="0" id="current4" />
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </body>
</html>
