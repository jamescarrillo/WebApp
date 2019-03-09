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
        <script type="text/javascript" src="resources/js/CJRoles.js"></script>
        <script type="text/javascript" src="resources/js/admin/controller/correoController.js"></script>
        <link rel="shortcut icon" type="image/x-icon" href="resources/images/16x16/favicon.ico" />
        <title>Correo Configuracion</title>       
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
                    <h2 class="ui-widget-header">Administrar Envio de Correo </h2>
                    <div id="message" class="message ui-widget ui-state-highlight">Configure a donde quiere que llegue información solicitada por los usuarios, usando su correo(s)</div>
                    <div class="content-marco">
                        <form id="frmRegistroCorreo" style="" >
                            <div>
                                <label>Modulo:</label>
                                <select name="modulo" id="moduloCorreo" style="width: 25%">
                                    <option value="1">Solicitud</option>
                                    <option value="2">Comentario/Sugerencia</option>
                                    <option value="3">Reclamo</option>
                                </select>
                            </div>
                            <div>
                                <label>Para:</label>
                                <input id="paraCorreo" name="para" class="import" type="text" style="width: 25%"  />
                            </div>
                            <div>
                                <label>CC:</label>
                                <input id="ccCorreo" class="noimport" name="cc" type="text" style="width: 62%"  />
                            </div>
                            <div>
                                <label>De parte:</label>
                                <input id="deCorreo" name="de" class="import" type="text" style="width: 25%"  />
                            </div>
                            <div >
                                <label>Envío de Mensaje Automático</label><input class="noimport" type="checkbox" name="estado" checked="checked" id="txtEstado" style="float: left; border:0px; text-align: left; width: auto" />
                            </div>
                            <div>
                                <label>Mensaje de envio Automático:</label>
                                <textarea id="mensajeCorreo" name="contenido" class="noimport" style="width: 62%; resize: false; height: 200px;font-size: 12px"  ></textarea>
                            </div>
                            
                            <div style="margin-top: 5px;"><button type="submit" id="btnGuardar">Guardar</button></div>
                        </form>
                    </div>   

                </div>
            </div>
        </div>
    </body>
</html>