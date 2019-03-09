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
        <script type="text/javascript" src="resources/js/admin/controller/viaticoController.js"></script>
        <link rel="shortcut icon" type="image/x-icon" href="resources/images/16x16/favicon.ico" />
        <title>Viatico</title>
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
                    <h2 class="ui-widget ui-widget-header ui-corner-top">Viacticos</h2>
                    <div id="message" class="message ui-widget ui-state-highlight">Aqui puedes Administrar los Viaticos de la instituci&oacute;n </div>
                    <div class="content-marco">

                        <div class="content-marco">
                            <!-- para registrar o editar una Viatico -->
                            <div id="frmRegistroViatico"  style="margin: 5px; display: none; padding:2px;">
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
                                        <button type="button" id="guardarFilasViatico">Guardar</button>
                                        <button type="button" id="btnCancelarViatico" style="margin-left: 5px;">Cancelar</button>
                                    </div>
                                </form>
                                <div id="frmVerViatico">
                                    <div class="jgrid ui-widget ui-widget-content ui-corner-all" style=" margin: 4px auto;padding:0px;">
                                        <div class="header ui-state-default ui-corner-top" style="padding: 0;">
                                            <div id="idx" data="0" class="sortable" style="width: 2%;" type="string">Id</div>
                                            <div id="areaViaticox" data="1" class="sortable" style="width: 14%;" type="string">Area</div>
                                            <div id="usuarioViaticox" data="2" class="sortable" style="width: 18%;" type="string">Usuario</div>
                                            <div id="salidaViaticox" data="3" class="sortable" style="width: 7%;" type="string">Salida</div>
                                            <div id="retornoViaticox" data="4" class="sortable" style="width: 7%;" type="string">Retorno</div>
                                            <div id="rutaViaticox" data="5" class="sortable" style="width: 21%;" type="string">Ruta</div>
                                            <div id="pasajeViaticox" data="6" class="sortable" style="width: 7%;" type="string">Pasaje</div>
                                            <div id="Viaticox" data="7" class="sortable" style="width: 7%;" type="string">Viatico</div>
                                            <div  data="8" style="width: 2%;" type="string">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
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
                                    <button type="button"  dir="nuevo" id="btnNuevoViatico">Nuevo Viáticos</button>
                                    <button type="button"  dir="eliminar" id="btnEliminarViatico" style="margin-left: 5px;">Eliminar Viáticos</button>
                                </div>
                            </div>
                            <div id="frmViatico">
                                <div style="display: block;overflow: hidden;border:0.1em #c9c9c9 solid;padding:4px;width: 99%;">
                                    <label style="float: left;width: 15%;padding:10px;vertical-align: middle">Buscar Compra Bien:</label>
                                    <input type="text" style="float: left;width: 50%;padding: 5px;" id="txtBuscarViatico" name="txtBuscarViatico" />
                                    <label style="float: left;width: 5%;padding:10px;vertical-align: middle">Año:</label>
                                    <select id="anhosComprasBienes" style="float: left;width: 20%;padding: 5px;"></select>
                                </div>
                                <div class="jgrid ui-widget ui-widget-content ui-corner-all" style=" margin: 0px auto; padding:0px;">
                                    <div class="header ui-state-default ui-corner-top" style="padding: 0; margin-left:0px">
                                        <div id="areaViatico" data="1" class="sortable" style="width: 14%; padding-right: 5px" type="string">Area</div>
                                        <div id="usuarioViatico" data="2" class="sortable" style="width: 18%;" type="string">Usuario</div>
                                        <div id="salidaViatico" data="3" class="sortable" style="width: 7%;" type="string">Salida</div>
                                        <div id="retornoViatico" data="4" class="sortable" style="width: 7%;" type="string">Retorno</div>
                                        <div id="rutaViatico" data="5" class="sortable" style="width: 24%;" type="string">Ruta</div>
                                        <div id="pasajeViatico" data="6" class="sortable" style="width: 7%;" type="string">Pasaje</div>
                                        <div id="Viatico" data="7" class="sortable" style="width: 7%;" type="string">Viatico</div>
                                        <div  data="8" style="width: 2%;" type="string">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
                                    </div>
                                    <div class="body" style="padding:0;"></div>
                                </div>
                                <input type="hidden" value="10" id="limit1" />
                                <input type="hidden" value="0" id="start1" />
                                <input type="hidden" value="0" id="current1" />
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </body>
</html>
