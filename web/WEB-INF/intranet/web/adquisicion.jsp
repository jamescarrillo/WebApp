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
        <script type="text/javascript" src="resources/js/admin/controller/adquicontraController.js"></script>
        <link rel="shortcut icon" type="image/x-icon" href="resources/images/16x16/favicon.ico" />
        <title>Adquisiciones y Contrataciones</title>
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
            function mostrarArchivoV() {
                var frame = document.getElementById('archivo-subidoV');
                var img = frame.contentWindow.document.getElementById('mensajeV');
                if (img != null) {
                    if($(img).attr("data")=="yes"){
                        $("#btnSubirV").button({
                            disabled:false,
                            icons:{
                                primary:'ui-icon-disk'
                            }
                        });
                        $("#message6").removeClass("ui-state-error").addClass("ui-state-highlight").html($(img).html());
                    }
                    else{
                        $("#btnSubirV").button({
                            disabled:true,
                            icons:{
                                primary:'ui-icon-disk'
                            }
                        });
                        $("#message6").removeClass("ui-state-highlight").addClass("ui-state-error").html($(img).html());
                    }
                }
            }
            
            function mostrarArchivoPr() {
                var frame = document.getElementById('archivo-subidoPr');
                var img = frame.contentWindow.document.getElementById('mensajePr');
                if (img != null) {
                    if($(img).attr("data")=="yes"){
                        $("#btnSubirPr").button({
                            disabled:false,
                            icons:{
                                primary:'ui-icon-disk'
                            }
                        });
                        $("#message7").removeClass("ui-state-error").addClass("ui-state-highlight").html($(img).html());
                    }
                    else{
                        $("#btnSubirPr").button({
                            disabled:true,
                            icons:{
                                primary:'ui-icon-disk'
                            }
                        });
                        $("#message7").removeClass("ui-state-highlight").addClass("ui-state-error").html($(img).html());
                    }
                }
            }
        </script>
        <style>
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
                                    <a href="#ui-tabs-0"><span> Compra de Bienes  </span> </a>
                                </li>
                                <li>
                                    <a href="#ui-tabs-1"><span> Compra de Servicios </span> </a>
                                </li>
                                <li>
                                    <a href="#ui-tabs-2"><span> Gastos en Publicidad </span> </a>
                                </li>
                                <li>
                                    <a href="#ui-tabs-3"><span> Compras en Telefonías </span> </a>
                                </li>
                                <li>
                                    <a href="#ui-tabs-4"><span> Uso de Vehiculos </span> </a>
                                </li>   
                                <li>
                                    <a href="#ui-tabs-5"><span> Principales Proveedores </span> </a>
                                </li>  
                            </ul>
                            <div id="ui-tabs-0">
                                <div class="content-marco">
                                    <!-- para registrar o editar una CompraBien -->
                                    <div id="frmRegistroCompraBien"  style="margin: 5px; display: none; padding:2px;">
                                        <div id="message2" class="message ui-widget ui-state-highlight" style="padding: 5px;">Selecciona el Archivo para importar</div>
                                        <form target="archivo-subido" id="frmComprasBienes" class="ui-widget ui-widget-content" style="margin-top: 5px;" action="./GestionTransparente?action=CargarArchivo&t=mensaje" enctype="multipart/form-data" method="post">
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
                                                <button type="button" id="guardarFilasCompraBien">Guardar</button>
                                                <button type="button" id="btnCancelarCompraBien" style="margin-left: 5px;">Cancelar</button>
                                            </div>
                                        </form>
                                        <div id="frmVerCompraBien">
                                            <div class="jgrid ui-widget ui-widget-content ui-corner-all" style=" margin: 4px auto;padding:0px;">
                                                <div class="header ui-state-default ui-corner-top" style="padding: 0;">
                                                    <div id="itemCompraBienx" data="0" style="width: 2%;" type="integer">Id</div>
                                                    <div id="idCompraBien" data="0" style="width: 7%; padding-right: 2px" type="integer">Nr°</div>
                                                    <div id="fechaCompraBien" data="1" class="sortable" style="width: 9%; padding-right: 2px" type="string">Fecha</div>
                                                    <div id="fuenteCompraBien" data="2" class="sortable" style="width: 20%; padding-right: 2px" type="string">Fuente Financiamiento</div>
                                                    <div id="proveedorCompraBien" data="2" class="sortable" style="width: 20%; padding-right: 2px" type="string">Proveedor</div>
                                                    <div id="FinanzamientoCompraBien" data="3" class="sortable" style="width: 10%; padding-right: 2px" type="string">Finan.</div>
                                                    <div id="montoCompraBien" data="4" class="sortable" style="width: 7%; padding-right: 2px" type="string">Monto</div>
                                                    <div id="NroSiaf" data="5" class="sortable" style="width: 10%; padding-right: 2px" type="string">Nro. Siaf</div>
                                                    <div  data="3" style="width: 2%;" type="string">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>

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
                                            <button type="button"  dir="nuevo" id="btnNuevoCompraBien">Nueva Compra de Bienes</button>
                                            <button type="button"  dir="eliminar" id="btnEliminarCompraBien" style="margin-left: 5px;">Eliminar Compra de Bienes</button>
                                        </div>
                                    </div>
                                    <div id="frmCompraBien">
                                        <div style="display: block;overflow: hidden;border:0.1em #c9c9c9 solid;padding:4px;width: 99%;">
                                            <label style="float: left;width: 15%;padding:10px;vertical-align: middle">Buscar Compra Bien:</label>
                                            <input type="text" style="float: left;width: 50%;padding: 5px;" id="txtBuscarCompraBien" name="txtBuscarCompraBien" />
                                            <label style="float: left;width: 5%;padding:10px;vertical-align: middle">Año:</label>
                                            <select id="anhosComprasBienes" style="float: left;width: 20%;padding: 5px;"></select>
                                        </div>
                                        <div class="jgrid ui-widget ui-widget-content ui-corner-all" style=" margin: 4px auto;padding:0px;">
                                            <div class="header ui-state-default ui-corner-top" style="padding: 0;">
                                                <div id="idCompraBien" data="0" style="width: 7%; padding-right: 2px" type="integer">Nr°</div>
                                                <div id="fechaCompraBien" data="1" class="sortable" style="width: 9%; padding-right: 2px" type="string">Fecha</div>
                                                <div id="fuenteCompraBien" data="2" class="sortable" style="width: 20%; padding-right: 2px" type="string">Fuente Financiamiento</div>
                                                <div id="proveedorCompraBien" data="2" class="sortable" style="width: 23%; padding-right: 2px" type="string">Proveedor</div>
                                                <div id="FinanzamientoCompraBien" data="3" class="sortable" style="width: 10%; padding-right: 2px" type="string">Finan.</div>
                                                <div id="montoCompraBien" data="4" class="sortable" style="width: 7%; padding-right: 2px" type="string">Monto</div>
                                                <div id="NroSiaf" data="5" class="sortable" style="width: 10%; padding-right: 2px" type="string">Nro. Siaf</div>
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

                            <!-- Orden Servicio -->
                            <div id="ui-tabs-1">
                                <div class="content-marco">

                                    <div id="frmRegistroServicio"  style="margin: 5px; display: none; padding:2px;">
                                        <div id="message3" class="message ui-widget ui-state-highlight" style="padding: 5px;">Selecciona el Archivo para importar</div>
                                        <form target="archivo-subidoS" id="frmServicios" class="ui-widget ui-widget-content" style="margin-top: 5px;" action="./GestionTransparente?action=CargarArchivo&t=mensajeS" enctype="multipart/form-data" method="post">
                                            <div>
                                                <label style="padding:5px 0px;">Buscar Archivo</label>
                                                <input id="archivoS" name="archivo" type="file" style="width: 62%;border: none;" value="" readonly="true" accept="application/vnd.ms-excel"   />                            
                                                <iframe name="archivo-subidoS" id="archivo-subidoS" onload="mostrarArchivoS()" style="display: none;"></iframe>
                                            </div>                        
                                        </form>
                                        <form class="ui-widget ui-widget-content" style="margin-top: 5px; ">
                                            <div style="float:left; color: red;" id="msnError_2">

                                            </div>

                                            <div style="margin-top: 5px;">
                                                <button id="btnSubirS" type="button">Ver Filas</button>
                                                <button type="button" id="guardarFilasServicio">Guardar</button>
                                                <button type="button" id="btnCancelarServicio" style="margin-left: 5px;">Cancelar</button>
                                            </div>
                                        </form>
                                        <div id="frmVerServicio">
                                            <div class="jgrid ui-widget ui-widget-content ui-corner-all" style=" margin: 4px auto;padding:0px;">
                                                <div class="header ui-state-default ui-corner-top" style="padding: 0;">
                                                    <div id="itemServiciox" data="0" style="width: 2%; " type="integer">Id</div>
                                                    <div id="idServicioBien" data="0" style="width: 7%; padding-right: 3px" type="integer">Nr°</div>
                                                    <div id="fechaServicioBien" data="1" class="sortable" style="width: 9%; padding-right: 5px" type="string">Fecha</div>
                                                    <div id="fuenteServicioBien" data="2" class="sortable" style="width: 20%; padding-right: 5px" type="string">Fuente Financiamiento</div>
                                                    <div id="proveedorServicioBien" data="2" class="sortable" style="width: 20%; padding-right: 5px" type="string">Proveedor</div>
                                                    <div id="FinanzamientoServicioBien" data="3" class="sortable" style="width: 10%; padding-right: 5px" type="string">Finan.</div>
                                                    <div id="montoServicioBien" data="4" class="sortable" style="width: 7%; padding-right: 5px" type="string">Monto</div>
                                                    <div id="NroSiaf" data="5" class="sortable" style="width: 10%; padding-right: 2px" type="string">Nro. Siaf</div>
                                                    <div data="3" style="width: 2%;" type="string">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>

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
                                            <button dir="nuevo" type="button"  id="btnNuevoServicio">Nueva Servicio</button>
                                            <button dir="eliminar" type="button"  id="btnEliminarServicio" style="margin-left: 5px;">Eliminar Servicio</button>
                                        </div>
                                    </div>
                                    <div id="frmServicio">
                                        <div style="display: block;overflow: hidden;border:0.1em #c9c9c9 solid;padding:4px;width: 99%;">
                                            <label style="float: left;width: 15%;padding:10px;vertical-align: middle">Buscar Servicio:</label>
                                            <input type="text" style="float: left;width: 50%;padding: 5px;" id="txtBuscarServicio" name="txtBuscarServicio" />
                                            <label style="float: left;width: 5%;padding:10px;vertical-align: middle">Año:</label>
                                            <select id="anhosServicio" style="float: left;width: 20%;padding: 5px;"></select>
                                        </div>
                                        <div class="jgrid ui-widget ui-widget-content ui-corner-all" style=" margin: 4px auto;padding:0px;">
                                            <div class="header ui-state-default ui-corner-top" style="padding: 0;">

                                                <div id="idServicioBien" data="0" style="width: 7%; padding-right: 2px" type="integer">Nr°</div>
                                                <div id="fechaServicioBien" data="1" class="sortable" style="width: 9%; padding-right: 2px" type="string">Fecha</div>
                                                <div id="fuenteServicioBien" data="2" class="sortable" style="width: 20%; padding-right: 2px" type="string">Fuente Financiamiento</div>
                                                <div id="proveedorServicioBien" data="2" class="sortable" style="width: 23%; padding-right: 2px" type="string">Proveedor</div>
                                                <div id="FinanzamientoServicioBien" data="3" class="sortable" style="width: 10%; padding-right: 2px" type="string">Finan.</div>
                                                <div id="montoServicioBien" data="4" class="sortable" style="width: 7%; padding-right: 2px" type="string">Monto</div>
                                                <div id="NroSiaf" data="5" class="sortable" style="width: 10%; padding-right: 2px" type="string">Nro. Siaf</div>
                                                <div  data="3" style="width: 2%;" type="string">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>

                                            </div>
                                            <div class="body" style="padding:0;"></div>
                                        </div>
                                        <input type="hidden" value="10" id="limit2" />
                                        <input type="hidden" value="0" id="start2" />
                                        <input type="hidden" value="0" id="current2" />
                                    </div>
                                </div>
                            </div>

                            <!-- Orden Publicidades -->
                            <div id="ui-tabs-2">
                                <div class="content-marco">
                                    <div id="frmRegistroPublicidad"  style="margin: 5px; display: none; padding:2px;">
                                        <div id="message4" class="message ui-widget ui-state-highlight" style="padding: 5px;">Selecciona el Archivo para importar</div>
                                        <form target="archivo-subidoP" id="frmPublicidads" class="ui-widget ui-widget-content" style="margin-top: 5px;" action="./GestionTransparente?action=CargarArchivo&t=mensajeP" enctype="multipart/form-data" method="post">
                                            <div>
                                                <label style="padding:5px 0px;">Buscar Archivo</label>
                                                <input id="archivoP" name="archivo" type="file" style="width: 62%;border: none;" value="" readonly="true" accept="application/vnd.ms-excel" />                            
                                                <iframe name="archivo-subidoP" id="archivo-subidoP" onload="mostrarArchivoP()" style="display: none;"></iframe>
                                            </div>                        
                                        </form>
                                        <form class="ui-widget ui-widget-content" style="margin-top: 5px; ">
                                            <div style="float:left; color: red;" id="msnError_3">

                                            </div>
                                            <div style="margin-top: 5px;">
                                                <button id="btnSubirP" type="button">Ver Filas</button>
                                                <button type="button" id="guardarFilasPublicidad">Guardar</button>
                                                <button type="button" id="btnCancelarPublicidad" style="margin-left: 5px;">Cancelar</button>
                                            </div>
                                        </form>
                                        <div id="frmVerPublicidad">
                                            <div class="jgrid ui-widget ui-widget-content ui-corner-all" style=" margin: 4px auto;padding:0px;">
                                                <div class="header ui-state-default ui-corner-top" style="padding: 0;">
                                                    <div id="idPublicidadx" data="" style="width: 2%; " type="integer">Id</div>
                                                    <div id="fuentePublicidadx" data="" style="width: 12%; padding-right: 2px; " type="integer">Fuente F.</div>
                                                    <div id="contratoPublicidadx" data="0" style="width: 12%; padding-right: 5px; " type="integer">Contrato</div>
                                                    <div id="objetoPublicidadx" data="1" class="sortable" style="width: 15%;  padding-right: 5px;" type="string">Objeto</div>
                                                    <div id="rucPublicidadx" data="2" class="sortable" style="width: 10%;  padding-right: 5px;" type="string">RUC</div>
                                                    <div id="proveedorPublicidadx" data="3" class="sortable" style="width: 23%;  padding-right: 5px;" type="string">Proveedor.</div>
                                                    <div id="penalidadPublicidadx" data="3" class="sortable" style="width: 5%;  padding-right: 5px;" type="string">Pena.</div>
                                                    <div id="montoPublicidadx" data="4" class="sortable" style="width: 5%;  padding-right: 5px;" type="string">Monto</div>
                                                    <div  data="3" style="width: 2%;" type="string">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
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
                                            <button dir="nuevo" id="btnNuevoPublicidad">Nueva Publicidad</button>
                                            <button dir="eliminar" id="btnEliminarPublicidad" style="margin-left: 5px;">Eliminar Publicidad</button>
                                        </div>
                                    </div>
                                    <div id="frmPublicidad">

                                        <div style="display: block;overflow: hidden;border:0.1em #c9c9c9 solid;padding:4px;width: 99%;">
                                            <label style="float: left;width: 15%;padding:10px;vertical-align: middle">Buscar Publicidad:</label>
                                            <input type="text" style="float: left;width: 50%;padding: 5px;" id="txtBuscarPublicidad" name="txtBuscarPublicidad" />
                                            <label style="float: left;width: 5%;padding:10px;vertical-align: middle">Año:</label>
                                            <select id="anhosPublicidad" style="float: left;width: 20%;padding: 5px;"></select>
                                        </div>

                                        <div class="jgrid ui-widget ui-widget-content ui-corner-all" style=" margin: 4px auto;padding:0px;">
                                            <div class="header ui-state-default ui-corner-top" style="padding:0px">
                                                <div id="fuentePublicidad" data="" style="width: 12%; padding-right: 0px;" type="integer">Fuente F.</div>
                                                <div id="contratoPublicidad" data="0" style="width: 12%; padding-right: 5px; " type="integer">Contrato</div>
                                                <div id="objetoPublicidad" data="1" class="sortable" style="width: 15%;  padding-right: 5px;" type="string">Objeto</div>
                                                <div id="rucPublicidad" data="2" class="sortable" style="width: 10%;  padding-right: 5px;" type="string">RUC</div>
                                                <div id="proveedorPublicidad" data="3" class="sortable" style="width: 25%;  padding-right: 5px;" type="string">Proveedor.</div>
                                                <div id="penalidadPublicidad" data="3" class="sortable" style="width: 5%;  padding-right: 5px;" type="string">Pena.</div>
                                                <div id="montoPublicidad" data="4" class="sortable" style="width: 5%;  padding-right: 5px;" type="string">Monto</div>
                                                <div  data="3" style="width: 2%;" type="string">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
                                            </div>
                                            <div class="body" style="padding:0;"></div>
                                        </div>
                                        <input type="hidden" value="10" id="limit3" />
                                        <input type="hidden" value="0" id="start3" />
                                        <input type="hidden" value="0" id="current3" />
                                    </div>
                                </div>
                            </div>
                            <!-- Compras Telefonicas -->
                            <div id="ui-tabs-3">
                                <div class="content-marco">
                                    <div id="frmRegistroTelefonia"  style="margin: 5px; display: none; padding:2px;">
                                        <div id="message5" class="message ui-widget ui-state-highlight" style="padding: 5px;">Selecciona el Archivo para importar</div>
                                        <form target="archivo-subidoT" id="frmTelefonias" class="ui-widget ui-widget-content" style="margin-top: 5px;" action="./GestionTransparente?action=CargarArchivo&t=mensajeT" enctype="multipart/form-data" method="post">
                                            <div>
                                                <label style="padding:5px 0px;">Buscar Archivo</label>
                                                <input id="archivoT" name="archivo" type="file" style="width: 62%;border: none;" value=""  accept="application/vnd.ms-excel" />                            
                                                <iframe name="archivo-subidoT" id="archivo-subidoT" onload="mostrarArchivoT()" style="display: none;"></iframe>
                                            </div>
                                        </form>
                                        <form class="ui-widget ui-widget-content" style="margin-top: 5px; ">
                                            <div style="float:left; color: red;" id="msnError_4">

                                            </div>
                                            <div style="margin-top: 5px;">

                                                <button id="btnSubirT" type="button">Ver Filas</button>
                                                <button type="button" id="guardarFilasTelefonia">Guardar</button>
                                                <button type="button" id="btnCancelarTelefonia" style="margin-left: 5px;">Cancelar</button>
                                            </div>
                                        </form>
                                        <div id="frmVerTelefonia">
                                            <div class="jgrid ui-widget ui-widget-content ui-corner-all" style=" margin: 4px auto;padding:0px;">
                                                <div class="header ui-state-default ui-corner-top" style="padding: 0;">
                                                    <div id="itemTelefoniax" data="0" style="width: 2%;" type="integer">Id</div>
                                                    <div style="width: 10%;" type="integer">Tipo</div>
                                                    <div  style="width: 10%;" type="integer">Numero</div>
                                                    <div id="areaTelefoniax" data="0" style="width: 18%;" type="integer">Area/Oficina</div>
                                                    <div id="asinacionTelefoniax" data="1" class="sortable" style="width: 17%;" type="string">Asignado a</div>
                                                    <div id="cargoTelefoniax" data="2" class="sortable" style="width: 17%;" type="string">Cargo</div>
                                                    <div id="importeTelefoniax" data="3" class="sortable" style="width: 10%;" type="string">Importe</div>
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
                                            <button dir="nuevo" type="button"  id="btnNuevoTelefonia">Nueva Telefonia</button>
                                            <button dir="eliminar" type="button"  id="btnEliminarTelefonia" style="margin-left: 5px;">Eliminar Telefonia</button>
                                        </div>
                                    </div>
                                    <div id="frmTelefonia">
                                        <div style="display: block;overflow: hidden;border:0.1em #c9c9c9 solid;padding:4px;width: 99%;">
                                            <label style="float: left;width: 15%;padding:10px;vertical-align: middle">Buscar Telefonia:</label>
                                            <input type="text" style="float: left;width: 50%;padding: 5px;" id="txtBuscarTelefonia" name="txtBuscarTelefonia" />
                                            <label style="float: left;width: 5%;padding:10px;vertical-align: middle">Año:</label>
                                            <select id="anhosTelefonia" style="float: left;width: 20%;padding: 5px;"></select>
                                        </div>
                                        <div class="jgrid ui-widget ui-widget-content ui-corner-all" style=" margin: 4px auto;padding:0px;">
                                            <div class="header ui-state-default ui-corner-top" style="padding: 0;">
                                                <div style="width: 10%;" type="integer">Tipo</div>
                                                <div  style="width: 10%;" type="integer">Numero</div>
                                                <div id="areaTelefonia" data="0" style="width: 18%;" type="integer">Area/Oficina</div>
                                                <div id="asinacionTelefonia" data="1" class="sortable" style="width: 17%;" type="string">Asignado a</div>
                                                <div id="cargoTelefonia" data="2" class="sortable" style="width: 17%;" type="string">Cargo</div>
                                                <div id="importeTelefonia" data="3" class="sortable" style="width: 10%;" type="string">Importe</div>
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

                            <!-- Uso Vehiculos -->
                            <div id="ui-tabs-4">
                                <div class="content-marco">
                                    <div id="frmRegistroVehiculo"  style="margin: 5px; display: none; padding:2px;">
                                        <div id="message6" class="message ui-widget ui-state-highlight" style="padding: 5px;">Selecciona el Archivo para importar</div>
                                        <form target="archivo-subidoV" id="frmVehiculos" class="ui-widget ui-widget-content" style="margin-top: 5px;" action="./GestionTransparente?action=CargarArchivo&t=mensajeV" enctype="multipart/form-data" method="post">
                                            <div>
                                                <label style="padding:5px 0px;">Buscar Archivo</label>
                                                <input id="archivoV" name="archivo" type="file" style="width: 62%;border: none;" value=""  accept="application/vnd.ms-excel" />                            
                                                <iframe name="archivo-subidoV" id="archivo-subidoV" onload="mostrarArchivoV()" style="display: none;"></iframe>
                                            </div>
                                        </form>
                                        <form class="ui-widget ui-widget-content" style="margin-top: 5px; ">
                                            <div style="float:left; color: red;" id="msnError_5">

                                            </div>
                                            <div style="margin-top: 5px;">
                                                <button id="btnSubirV" type="button">Ver Filas</button>
                                                <button type="button" id="guardarFilasVehiculo">Guardar</button>
                                                <button type="button" id="btnCancelarVehiculo" style="margin-left: 5px;">Cancelar</button>
                                            </div>
                                        </form>
                                        <div id="frmVerVehiculo">
                                            <div class="jgrid ui-widget ui-widget-content ui-corner-all" style=" margin: 4px auto;padding:0px;">
                                                <div class="header ui-state-default ui-corner-top" style="padding: 0;">
                                                    <div id="itemVehiculox" data="0" style="width: 2%;" type="integer">Id</div>
                                                    <div id="claseVehiculox" data="0" style="width: 7%;" type="integer">Clase</div>
                                                    <div id="vehiculox" data="1" class="sortable" style="width: 10%;" type="string">Vehiculo</div>
                                                    <div id="placaVehiculox" data="2" class="sortable" style="width: 7%;" type="string">Placa</div>
                                                    <div id="SOATVehiculox" data="3" class="sortable" style="width: 10%;" type="string">SOAT</div>
                                                    <div id="asignadoVehiculox" data="4" class="sortable" style="width: 19%;" type="string">Asignado a</div>
                                                    <div id="recorridoVehiculox" data="5" class="sortable" style="width: 8%;" type="string">Recorrido Km</div>
                                                    <div id="tipoVehiculox" data="6" class="sortable" style="width: 10%;" type="string">Tipo Comb.</div>
                                                    <div id="costoVehiculox" data="7" class="sortable" style="width: 10%;" type="string">Costo Comb.</div>
                                                </div>
                                                <div class="body" style="padding:0;"></div>
                                            </div>
                                            <input type="hidden" value="10" id="limitx" />
                                            <input type="hidden" value="0" id="startx" />
                                            <input type="hidden" value="0" id="currentx" />
                                        </div>
                                    </div>

                                    <div id="widgetV" class="ui-widget ui-widget-content" style="margin:5px;">
                                        <div>
                                            <button dir="nuevo" type="button"  id="btnNuevoVehiculo">Nueva Vehiculo</button>
                                            <button dir="eliminar" type="button" id="btnEliminarVehiculo" style="margin-left: 5px;">Eliminar Vehiculo</button>
                                        </div>
                                    </div>
                                    <div id="frmVehiculo">
                                        <div style="display: block;overflow: hidden;border:0.1em #c9c9c9 solid;padding:4px;width: 99%;">
                                            <label style="float: left;width: 15%;padding:10px;vertical-align: middle">Buscar Vehiculo:</label>
                                            <input type="text" style="float: left;width: 50%;padding: 5px;" id="txtBuscarVehiculo" name="txtBuscarVehiculo" />
                                            <label style="float: left;width: 5%;padding:10px;vertical-align: middle">Año:</label>
                                            <select id="anhosVehiculo" style="float: left;width: 20%;padding: 5px;"></select>
                                        </div>
                                        <div class="jgrid ui-widget ui-widget-content ui-corner-all" style=" margin: 4px auto;padding:0px;">
                                            <div class="header ui-state-default ui-corner-top" style="padding: 0;">
                                                <div id="claseVehiculo" data="0" style="width: 7%;" type="integer">Clase</div>
                                                <div id="vehiculo" data="1" class="sortable" style="width: 10%;" type="string">Vehiculo</div>
                                                <div id="placaVehiculo" data="2" class="sortable" style="width: 7%;" type="string">Placa</div>
                                                <div id="SOATVehiculo" data="3" class="sortable" style="width: 10%;" type="string">SOAT</div>
                                                <div id="asignadoVehiculo" data="4" class="sortable" style="width: 19%;" type="string">Asignado a</div>
                                                <div id="recorridoVehiculo" data="5" class="sortable" style="width: 8%;" type="string">Recorrido Km</div>
                                                <div id="tipoVehiculo" data="6" class="sortable" style="width: 12%;" type="string">Tipo Comb.</div>
                                                <div id="costoVehiculo" data="7" class="sortable" style="width: 10%;" type="string">Costo Comb.</div>
                                                
                                            </div>
                                            <div class="body" style="padding:0;"></div>
                                        </div>
                                        <input type="hidden" value="10" id="limit5" />
                                        <input type="hidden" value="0" id="start5" />
                                        <input type="hidden" value="0" id="current5" />
                                    </div>
                                </div>
                            </div>

                            <!-- Proveedores -->
                            <div id="ui-tabs-5">
                                <div class="content-marco">
                                    <div id="frmRegistroProveedor"  style="margin: 5px; display: none; padding:2px;">
                                        <div id="message7" class="message ui-widget ui-state-highlight" style="padding: 5px;">Selecciona el Archivo para importar</div>
                                        <form target="archivo-subidoPr" id="frmProveedors" class="ui-widget ui-widget-content" style="margin-top: 5px;" action="./GestionTransparente?action=CargarArchivo&t=mensajePr" enctype="multipart/form-data" method="post">
                                            <div>
                                                <label style="padding:5px 0px;">Buscar Archivo</label>
                                                <input id="archivoPr" name="archivo" type="file" style="width: 62%;border: none;" value=""  accept="application/vnd.ms-excel" />                            
                                                <iframe name="archivo-subidoPr" id="archivo-subidoPr" onload="mostrarArchivoPr()" style="display: none;"></iframe>
                                            </div>
                                        </form>
                                        <form class="ui-widget ui-widget-content" style="margin-top: 5px;">
                                            <div style="float:left; color: red;" id="msnError_6">
                                            </div>
                                            <div style="margin-top: 5px;">
                                                <button id="btnSubirPr" type="button">Ver Filas</button>
                                                <button type="button" id="guardarFilasProveedor">Guardar</button>
                                                <button type="button" id="btnCancelarProveedor" style="margin-left: 5px;">Cancelar</button>
                                            </div>
                                        </form>
                                        <div id="frmVerProveedor">
                                            <div class="jgrid ui-widget ui-widget-content ui-corner-all" style=" margin: 4px auto;padding:0px;">
                                                <div class="header ui-state-default ui-corner-top" style="padding: 0;">
                                                    <div id="itemProveedorx" data="0" style="width: 2%;" type="integer">Id</div>
                                                    <div id="rucProveedorx" data="0" style="width: 25%;" type="integer">R.U.C</div>
                                                    <div id="proveedorx" data="1" class="sortable" style="width: 45%;" type="string">Proveedor</div>
                                                    <div id="importeProveedorx" data="2" class="sortable" style="width: 15%;" type="string">Importe</div>
                                                    <div  data="4" style="width: 2%;" type="string">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
                                                </div>
                                                <div class="body" style="padding:0;"></div>
                                            </div>
                                            <input type="hidden" value="10" id="limitx" />
                                            <input type="hidden" value="0" id="startx" />
                                            <input type="hidden" value="0" id="currentx" />
                                        </div>
                                    </div>

                                    <div id="widgetPr" class="ui-widget ui-widget-content" style="margin:5px;">
                                        <div>
                                            <button type="button" dir="nuevo" id="btnNuevoProveedor">Nueva Proveedor</button>
                                            <button type="button" dir="eliminar" id="btnEliminarProveedor" style="margin-left: 5px;">Eliminar Proveedor</button>
                                        </div>
                                    </div>
                                    <div id="frmProveedor">
                                        <div style="display: block;overflow: hidden;border:0.1em #c9c9c9 solid;padding:4px;width: 99%;">
                                            <label style="float: left;width: 15%;padding:10px;vertical-align: middle">Buscar Proveedor:</label>
                                            <input type="text" style="float: left;width: 50%;padding: 5px;" id="txtBuscarProveedor" name="txtBuscarProveedor" />
                                            <label style="float: left;width: 5%;padding:10px;vertical-align: middle">Año:</label>
                                            <select id="anhosProveedor" style="float: left;width: 20%;padding: 5px;"></select>
                                        </div>
                                        <div class="jgrid ui-widget ui-widget-content ui-corner-all" style=" margin: 4px auto;padding:0px;">
                                            <div class="header ui-state-default ui-corner-top" style="padding: 0;">

                                                <div id="rucProveedor" data="0" style="width: 25%;" type="integer">R.U.C</div>
                                                <div id="proveedor" data="1" class="sortable" style="width: 50%;" type="string">Proveedor</div>
                                                <div id="importeProveedor" data="2" class="sortable" style="width: 15%;" type="string">Importe</div>
                                                <div  data="3" style="width: 2%;" type="string">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
                                            </div>
                                            <div class="body" style="padding:0;"></div>
                                        </div>
                                        <input type="hidden" value="10" id="limit6" />
                                        <input type="hidden" value="0" id="start6" />
                                        <input type="hidden" value="0" id="current6" />
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
