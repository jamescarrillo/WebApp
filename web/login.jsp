<%-- any content can be specified here e.g.: --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=8">          
        <link type="text/css" rel="stylesheet" href="resources/css/login.css" >
        <script type="text/javascript" src="resources/js/jquery.js"></script>
        <link rel="shortcut icon" type="image/x-icon" href="resources/images/16x16/favicon.ico" />
        <script type="text/javascript">
            $("document").ready(function() {
                var save = true;
                $("#formLogin").submit(function() {
                    if (save) {
                        save = false;
                        $.ajax({
                            dataType: 'json',
                            type: 'post',
                            url: $(this).attr("action"),
                            data: $(this).serialize(),
                            success: function(response) {
                                save = true;
                                if (response.success) {
                                    window.location = response.msg;
                                } else {
                                    $("div.mensaje").addClass("error").html(response.msg);
                                }
                            }
                        });
                    }
                    return false;
                });
            });

        </script>
        <title>Bienvenido a nuestro Gestor de Contenidos Web<</title>
    </head>
    <body>        
        <div id="cabecera" class="ui-widget ui-widget-content">
            <%@include file="WEB-INF/jspf/cnorte.jspf" %>
            <div id="c-centro"><h2></h2> </div>
        </div>
        <div class="content">
            <div id="cuerpo"></div>
            <div id="c-cuerpo">
                <div id="cl-der" style="float:right">
                    <h2>Iniciar Sesi&oacute;n</h2>                        
                    <form id="formLogin" action="./Usuario?action=connect">
                            <div>
                                <label for="usua_login">Usuario:</label>
                                <input id="usua_login"  name="login" maxlength="60" /> 
                            </div>
                            <div>
                                <label for="usua_password">Contrase&ntilde;a:</label>
                                <input id="usua_password"   type="password"   name="password" maxlength="60" /> 
                            </div>
                            <div>
                                <label>C&oacute;digo captcha:</label>
                                <img id='captcha' src="./captcha.jpg" />
                            </div>
                            <div>
                                <label for="usua_captcha">Ingrese C&oacute;digo captcha:</label>
                                <input id="usua_captcha"  name="captcha" maxlength="6" /> 
                            </div>
                            <div>
                                <button type="submit"  id='btnConectar'>Conectar</button>
                            </div>
                            <div class="mensaje">
                                <span class="mensaje-aviso">Bienvenidos</span>
                            </div>
                        </form>
                </div>
                <div id="cl-izq"  style="float:left">
                    <div id="video">
                        <img src="resources/images/logos/content.png"  />
                    </div>
                    <div id="soportado">
                        <img src="resources/images/32x32/Chrome.png" />
                        <img src="resources/images/32x32/Firefox.png" />
                        <img src="resources/images/32x32/IE.png" />
                        <img src="resources/images/32x32/Opera.png" />
                        <img src="resources/images/32x32/Safari.png" />
                    </div>

                </div>
            </div>
        </div>
        <div id="pie">
            <div id="p-centro" style="text-align: right; font-weight: bold; margin:10px">
                Gestor de Contenidos Web Version 2.0 *Todos Los Derechos Reservados. Proyecto Especial Alto Mayo (PEAM) 2013 / SAN MARTIN - PERU
            </div>              
        </div>     
    </body>
</html>
