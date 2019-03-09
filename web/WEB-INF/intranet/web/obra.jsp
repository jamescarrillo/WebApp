<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link type="text/css" rel="stylesheet" href="resources/css/default.css">
        <link type="text/css" rel="stylesheet" href="resources/css/jHtmlArea/jHtmlArea.css">
        <link type="text/css" rel="stylesheet" href="resources/css/${estilo}/jquery-ui.css">
        <script type="text/javascript" src="resources/js/jquery.js"></script>
        <script type="text/javascript" src="resources/js/jquery-ui.js"></script>
        <script type="text/javascript" src="resources/js/jquery.corner.js"></script>
        <script type="text/javascript" src="resources/js/CJRoles.js"></script>
        <script type="text/javascript" src="resources/js/jHtmlArea.js"></script>
        <script type="text/javascript" src="resources/js/admin/controller/obraController.js"></script>
        <link rel="shortcut icon" type="image/x-icon" href="resources/images/16x16/favicon.ico" />
        <title>Obras</title>       
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
            <div class="paper" id="paper"  >
                <div class="cerrarPaper" style="display:block; margin: -40px; float:right; cursor: pointer">(X) Cerrar</div>
                <div class ="titulo" style="font-size: 14px;">
                </div>
                <div class="imagen" style="float: left">  </div>                
                <!--<botton class="button green" id="imprimir" style="float:left"> Imprimir </botton>-->
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
                    <h2 class="ui-widget-header">Administrar Obras</h2>
                    <div id="message" class="message ui-widget ui-state-highlight">Administre los Obras correspondientes a las diferentes Lineas de Acción.</div>
                    <div class="content-marco">
                        <form id="frmBuscador" action="#">    
                            <div style="overflow: hidden;padding:5px;font-size:12px;">
                                <input id="txtBuscador" style="float: left;padding:5px;width: 75%;" type="text"/>
                                <button id="btnNuevo" type="button" dir="nuevo" style="float: right;margin-left:5px;">Nuevo</button>
                                <button id="btnBuscar" type="button">Buscar</button>
                                <button id="btnCancelar" type="button" style="display: none;float: right;margin-left:5px; ">Cancelar</button>  
                                <button id="btnGuardar" type="button"  style="display: none;">Guardar</button>

                            </div>
                        </form>
                        <form id="frmRegistroNoticia" style="display: none;">
                            <div id="pnlArea">
                                <label>Dirección/Area:</label>                                
                            </div> 
                            <div>
                                <label>Nombre de la obra:</label>
                                <textarea id="descripcionObra" class="casilla" rows="3" style="width: 648px" ></textarea>                                
                            </div> 
                            <div>
                                <label>Monto de inversión:</label>
                                <input id="montoInversionObra" class="casilla" type="text" style="width: 200px;"  />
                                <label style="width: 248px;text-align: right">Monto Gastado:</label>
                                <input id="montoGastadoObra" class="casilla" type="text" style="width: 200px;"  />
                            </div> 
                            <div>
                                <label>Fecha de Inicio:</label>
                                <input id="fechaInicioObra" class="casilla" readonly="true" type="text" style="width: 185px;"  />
                                <label style="width: 248px;text-align: right">Fecha de Fin:</label>
                                <input id="fechaFinObra" class="casilla" readonly="true" type="text" style="width: 185px;"  />
                            </div>  
                            <div>
                                <label>Mes actualizacion:</label>
                               <select id="mesActualizacion" class="casilla"  type="text" style="width: 200px;"  >
                                    <option class="Enero">Enero</option>
                                    <option class="Febrero">Febrero</option>
                                    <option class="Marzo">Marzo</option>
                                    <option class="Abril">Abril</option>
                                    <option class="Mayo">Mayo</option>
                                    <option class="Junio">Junio</option>
                                    <option class="Julio">Julio</option>
                                    <option class="Agosto">Agosto</option>
                                    <option class="Septiembre">Septiembre</option>
                                    <option class="Octubre">Octubre</option>
                                    <option class="Noviembre">Noviembre</option>
                                    <option class="Diciembre">Diciembre</option>
                                </select>
                                <label style="width: 248px;text-align: right">Año Actualizacion:</label>
                                 <select id="anhoActualizacion" class="casilla"  type="text" style="width: 200px;"  >
                                    <option class="2016">2016</option>
                                    <option class="2017">2017</option>
                                    <option class="2018">2018</option>
                                    <option class="2019">2019</option>
                                    <option class="2020">2020</option>
                                    <option class="2021">2021</option>
                                </select>
                            </div>  
                            <div>
                                <label>Tiempo de ejecución (días):</label>
                                <input id="tiempoEjecucionObra" class="casilla" type="text" style="width: 200px;"  />
                                <label style="width: 248px;text-align: right">Modalidad Ejecución:</label>
                                <input id="modalidadEjecucionObra" class="casilla" type="text" style="width: 200px;"  />
                            </div> 
                            <div>
                                <label>Estado de la Obra:</label>
                                <select id="seguimientoObra" class="casilla" style="width: 200px;"  >
                                    <option value="En Ejecucion">En Ejecucion</option>
                                    <option value="Finalizado">Finalizado</option>
                                </select>
                                <label style="width: 248px;text-align: right">Avance Físico (%):</label>
                                <input id="avanceFisicoObra" class="casilla" type="text" style="width: 200px;"  />
                            </div> 
                             <div>
                                <label>SNIP de la Obra:</label>
                                <input id="snip" class="casilla" type="text" style="width: 200px;"  />
                            </div>
                            <div>
                                <label>Ubicación de la Obra:</label>
                                <input id="ubicacionObra" class="casilla" type="text" style="width: 649px;"  />
                            </div>
                            <div>
                                <label>Contratista de la Obra:</label>
                                <input id="contratistaObra" class="casilla" type="text" />
                            </div>
                            <div>
                                <label>Supervisor de la Obra:</label>
                                <input id="supervisorObra" class="casilla" type="text" />
                            </div>
                            <div>
                                <label>Residente de la Obra:</label>
                                <input id="residenteObra" class="casilla" type="text" />
                            </div>
                            <div>
                                <label>Link Infobras:</label>
                                <input id="infobras" class="casilla" style="width: 648px;" type="text" />
                            </div>
                            <div>
                                <label>Url Galeria (Flickr):</label>
                                <input id="galeriaObra" class="casilla" style="width: 648px;" type="text" />
                            </div>
                            <div>
                                <label>Foto Muestra (Flickr) :</label>
                                <input id="fotoObra" class="casilla" style="width: 648px;" type="text" />
                            </div>
                            <div>
                                <label>Leyenda de Foto :</label>
                                <input id="leyenda" class="casilla" style="width: 648px;" type="text" />
                            </div>
                            <div>
                                <label>Observacion:</label>
                                <textarea id="observacion" class="casilla" rows="3" style="width: 648px" ></textarea>                                
                            </div> 
                        </form>
                    </div>   
                    <div id="noticias">
                    </div>
                    <div id="busqueda-more" class="busqueda-more">
                        <div class="b-izq">
                            <input type="hidden" id="txtLimit" value="7" />
                            <input type="hidden" id="txtStart" value="0" />
                            <input type="hidden" id="txtCurrent" value="0" />
                            <button id="btnSeguir" class="button">M&aacute;s Obras</button>
                        </div>
                    </div>   
                </div>
            </div>
        </div>
        <div class="eliminarQuestionPublic ui-widget ui-dialog" style="display: none; font-size: 12px;">
            <div class="ui-widget ui-state-highlight ui-corner-all" style="padding:5px;">
                <p style="font-size: 13px;padding:5px;">
                    <span id="msg-icon-public" style="float: left; margin-right: .3em;"></span><span class="msg-html-public"></span>
                </p>
            </div>
            <div style="margin-top: 5px; overflow: hidden;font-size: 12px;">
                <input class="noMessagePublic ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover" style="padding:3px;float: right;margin-left: 5px;" type="button" value="No" />
                <input class="siMessagePublic ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover" style="padding:3px;float: right;" type="button" value="S&iacute;" />        
            </div>
        </div>

    </body>
</html>
