
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.zkoss.org/jsp/zul" prefix="z" %>
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
        <script  type="text/javascript" src="resources/js/admin/controller/penalidadController.js"></script>
        <link rel="shortcut icon" type="image/x-icon" href="resources/images/16x16/favicon.ico" />
        <title>Penalidades</title>

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
                    <h2 class="ui-widget ui-widget-header ui-corner-top">Penalidades</h2>
                    <div id="message" class="message ui-widget ui-state-highlight">Registre en nuestro formulario Las penalidades de algunos procesos</div>
                    <div id="frmRegistro" class="ui-widget ui-widget-content" style="display: none;margin: 5px; font-size: 12px;">
                        <z:page>
                            <form id="formRegistro" action="./Convocatoria?action=ActualizarPenalidad">
                                <z:grid>
                                    <z:rows>
                                        <z:row>
                                            <z:label value="Año" width="150px" />
                                            <z:hlayout> 
                                                <z:textbox  width="100px" maxlength="4" name="anho" hflex="1" />
                                            </z:hlayout>
                                            <div>
                                                <label  style="width:100%"></label>
                                            </div>
                                        </z:row>
                                        <z:row>
                                            <z:label value="Monto Contrato" width="150px" />
                                            <z:hlayout>
                                                <z:textbox  width="250px" maxlength="30"  name="monto_contrato" hflex="1" />
                                            </z:hlayout>
                                            <div>
                                                <label  style="width:100%"></label>
                                            </div>
                                        </z:row>
                                        <z:row>
                                            <z:label value="Nombre del Contratista" width="150px" />
                                            <z:hlayout>
                                                <z:textbox  width="250px" name="contratista" hflex="1" />
                                            </z:hlayout>
                                            <div>
                                                <label  style="width:100%"></label>
                                            </div>
                                        </z:row>
                                        <z:row>
                                            <z:label value="R.U.C" width="150px" />
                                            <z:hlayout>
                                                <z:textbox  maxlength="11"  width="250px" name="ruc" hflex="1" />
                                            </z:hlayout>
                                            <div>
                                                <label  style="width:100%"></label>
                                            </div>
                                        </z:row>                                        
                                        <z:row>
                                            <z:label value="Objeto del proceso (Bienes, Servicios u Obras)" width="150px" />
                                            <z:hlayout>
                                                <z:textbox rows="3" width="250px" name="objeto" hflex="1" />
                                            </z:hlayout>
                                            <div>
                                                <label  style="width:100%"></label>
                                            </div>
                                        </z:row>
                                        <z:row>
                                            <z:label value="Nro. Proceso de selección convocado" width="150px" />
                                            <z:hlayout> 
                                                <z:textbox  maxlength="100"  width="100px" name="nro_proceso" hflex="1" />
                                            </z:hlayout>
                                            <div>
                                                <label  style="width:100%"></label>
                                            </div>
                                        </z:row>
                                        
                                        <z:row>
                                            <z:label value="Nro. de Contrato" width="150px" />
                                            <z:hlayout> 
                                                <z:textbox maxlength="50"  width="100px" name="nro_contrato" hflex="1" />
                                            </z:hlayout>
                                            <div>
                                                <label  style="width:100%"></label>
                                            </div>
                                        </z:row>

                                        <z:row>
                                            <z:label value="Tipo Penalidad (Mora u otra)" width="150px" />
                                            <z:hlayout>
                                                <z:textbox  width="250px" name="tipo" />
                                            </z:hlayout>
                                            <div>
                                                <label  style="width:100%"></label>
                                            </div>
                                        </z:row>
                                        <z:row>
                                            <z:label value="Monto de la penalidad (S/.)" width="150px" />
                                            <z:hlayout>
                                                <z:textbox maxlength="30"   width="250px" name="monto_penalidad" />
                                            </z:hlayout>
                                            <div>
                                                <label  style="width:100%"></label>
                                            </div>
                                        </z:row>
                                    </z:rows>
                                </z:grid>
                                <input type="hidden" id="op" name="op" value="0"/>
                                <input type="hidden" id="id" name="id" value="0"/>
                                <div style="margin-top: 5px;"><button  id="btnCancelar" type="button" style="margin-left: 5px;">Cancelar</button><button type="submit" id="btnGuardar">Guardar</button></div>
                            </form>
                        </z:page>
                    </div>
                    <div id="frm" style="margin:5px;">
                        <div id="grid" >
                            <jsp:include page="./zul/gridPenalidad.zul" />
                        </div>
                    </div>

                    <!-- fin -->

                </div>

                <div id="dialog-confirm" title="Aviso!" style="display:none">
                    <p>
                        <span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>
                    <div id="dialog-msg"></div>
                    </p>
                </div>
            </div>
        </div>
    </body>
</html>