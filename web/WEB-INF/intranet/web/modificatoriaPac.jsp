
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.zkoss.org/jsp/zul" prefix="z" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link type="text/css" rel="stylesheet" href="resources/css/default.css" >
        <link type="text/css" rel="stylesheet" href="resources/css/${estilo}/jquery-ui.css" >
        <script type="text/javascript" src="resources/js/jquery.js"></script>
        <script type="text/javascript" src="resources/js/jquery-ui.js"></script>
        <script type="text/javascript" src="resources/js/CJRoles.js"></script>
        <script  type="text/javascript" src="resources/js/admin/controller/modificatoriaController.js"></script>
        <link rel="shortcut icon" type="image/x-icon" href="resources/images/16x16/favicon.ico" />
        <title>Modificatorias del PAC</title>
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
                    <h2 class="ui-widget ui-widget-header ui-corner-top">Modificatorias del PAC</h2>
                    <div id="message" class="message ui-widget ui-state-highlight">Agrege, Quite o edite los Documentos de Modificatorias del PAC</div>
                    <div id="frmRegistro" class="ui-widget ui-widget-content" style="display: none;margin: 5px; font-size: 12px;">
                        <z:page>
                            <form id="formRegistro" action="./Convocatoria?action=ActualizarFinalObra">
                                <z:grid>
                                    <z:rows>
                                        <z:row>
                                            <z:label value="Nombre/Titulo" width="150px" />
                                            <z:hlayout> 
                                                <z:textbox value="" constraint="no empty" maxlength="50" name="titulo" width="250px" tabindex="1" />
                                            </z:hlayout>
                                            <div>
                                                <label style="width:100%"></label>
                                            </div>
                                        </z:row>
                                        <z:row>
                                            <z:label value="Resumen" width="150px" />
                                            <z:hlayout>
                                                <z:textbox rows="3" width="250px" name="descripcion" hflex="1" />
                                            </z:hlayout>
                                            <div>
                                                <label style="width:100%"></label>
                                            </div>
                                        </z:row>

                                    </z:rows>
                                </z:grid>
                                <input type="hidden" id="op" name="op" value="0"/>
                                <input type="hidden" id="id" name="id" value="0"/>
                                <input type="hidden" id="cate_id" name="cate_id" value="1100"/>

                                <div style="margin-top: 5px;"><button  id="btnCancelar" type="button" style="margin-left: 5px;">Cancelar</button><button type="submit" id="btnGuardar">Guardar</button></div>
                            </form>
                        </z:page>
                    </div>
                    <div id="frm" style="margin:5px;">
                        <div id="grid" >
                            <jsp:include page="./zul/gridModificatoria.zul" />
                        </div>
                    </div>
                    <!-- fin -->
                </div>

                <div id="dialog-confirm" title="Aviso!" style="display:none">
                    <div>
                        <span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>
                    <div id="dialog-msg"></div>
                    </div>
                </div>


                <div id="dialog-arcdig" title="Gestion de Documentos" style="display:none">
                    <div style="padding:10px;" class="message ui-widget ui-state-highlight ui-widget-content ui-corner-all">Seleccionar un Archivo de nuestro Repositorio de ArcDig </div>
                    <div id="grid-01" > 
                        <jsp:include page="./zul/gridArcDig.zul" />
                    </div>
                </div>
            </div>
        </div>
    
</body>
</html>