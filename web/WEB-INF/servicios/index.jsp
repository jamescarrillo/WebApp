<%-- any content can be specified here e.g.: --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> 
<html class="no-js"> <!--<![endif]-->
    <head>
        <link rel="shortcut icon" href="resources/img/logo-peam.png"/>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="resources/css/bootstrap.css">
        <link rel="stylesheet" href="resources/css/animate.css">
        <link rel="stylesheet" href="resources/css/font-awesome.css" type="text/css" />
        <!-- SLIDER REVOLUTION 4.x CSS SETTINGS -->
        <link rel="stylesheet" type="text/css" href="resources/css/extralayers.css" media="screen" /> 
        <link rel="stylesheet" type="text/css" href="resources/rs-plugin/css/settings.css" media="screen" />
        <link rel="stylesheet" href="resources/js/bxslider/jquery.bxslider.css">
        <link rel="stylesheet" href="resources/js/chocolat/css/chocolat.css" />
        <link rel="stylesheet" href="resources/css/main.css">       

        <link type="text/css" rel="stylesheet" href="resources/css/estilo.css" />
        <script type="text/javascript" src="resources/js/mootools-core.js"></script>
        <script type="text/javascript" src="resources/js/mootools-more.js"></script>
        <script type="text/javascript" src="resources/js/JpSlider.js"></script>
        <script type="text/javascript" src="resources/js/AlMultiFade.js"></script>

        <script src="resources/js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
        <script src="resources/js/vendor/jquery-1.11.1.min.js"></script>        
        <script type="text/javascript" src="resources/js/jquery.nicescroll.min.js"></script>

        <script type="text/javascript">
            jQuery.noConflict();

            window.addEvent("domready", function () {

                jQuery("body,html").niceScroll({
                    cursorwidth: "8px",
                    cursorminheight: 75
                });
                jQuery("#scrollTop").click(function () {
                    jQuery("body,html").animate({
                        scrollTop: '0px'
                    }, 800);
                });
                jQuery(window).scroll(function () {
                    if (jQuery(this).scrollTop() > 0) {
                        jQuery("#scrollTop").slideDown(300);
                    }
                    else {
                        jQuery("#scrollTop").slideUp(300);
                    }
                });


                $('buscarPag').buscarDato("norte");
                //$("accordion").hide();
                //var links = new JpSlider($("enlaces"), {url: './Enlace', type: 'links'});

                var el = $$('#posts li'),
                        color = el.getStyle('backgroundColor');

                //We retrieve the link location (href) and assign it to LI to make the whole region clickable
                var link = $$('#posts li');

                $$(".panel").each(function (element) {

                    element.addEvent('click', function () {
                        window.location = element.get('dir');
                        this.morph({
                            'border': '1px solid #eee',
                            'background-color': '#fff'
                        });
                    });
                });

                var data_10 = '<li data-id="10">\n\
                            <div class="banner clean_slider_image_shown" style="display: block;">\n\
                                <img src="./resources/images/logos/msn.png" height="100" width="100">\n\
                                <div style="display: block;" class="clean_slider_image_shown">\n\
                                    <h1 class="titulo">Nuestros Servicios Institucionales</h1>\n\
                                    <p style="text-shadow: none">\n\
                                        Seleccione Su sistema de Preferencia\n\
                                        para Continuar, Haciendo click sobre ellos\n\
                                </div>\n\
                            </div>\n\
                        </li>';

                var data_0 = '<li data-id="0" dir="http://doc.peam.gob.pe/sisgedo/app/main.php">\n\
                            <div class="banner clean_slider_image_shown" style="display: block;">\n\
                                <img src="./resources/images/logos/sisgedo128.png" height="100" width="100">\n\
                                <div style="display: block;" class="clean_slider_image_shown">\n\
                                    <h1 class="titulo">Sistema de Tramite Documentario</h1>\n\
                                    <p style="text-shadow: none">El Sistema de Gestión Documentaria - SisGeDo 1.5.0 es una aplicación WEB\n\
                                        que permite efectuar el registro,\n\
                                        control y seguimiento detallado y estricto de todos los expedientes que\n\
                                        se procesan en la Institución, tanto externos como internos.</p>\n\
                                </div>\n\
                            </div>\n\
                        </li>';
                var data_1 = '<li data-id="1" dir="http://siga.peam.gob.pe:8080/SIGAWEB/">\n\
                            <div class="banner clean_slider_image_shown" style="display: block;">\n\
                                <img src="./resources/images/logos/siga128.png" height="100" width="100">\n\
                                <div class="clean_slider_image_shown" style="display: block;">\n\
                                    <h1 class="titulo">Sistema Integrado de Gestión Administrativa</h1>\n\
                                    <p style="text-shadow: none">Es un sistema informático que contribuye al ordenamiento y simplificación de los procesos administrativos en el marco de las normas establecidas por los Órganos Rectores de los Sistemas Administrativos del Estado</p>\n\
                                </div>\n\
                            </div>\n\
                        </li>';
                var data_2 = '<li data-id="2" dir="http://lib.peam.gob.pe/ArcDig/">\n\
                            <div class="banner clean_slider_image_shown" style="display: block;">\n\
                                <img src="./resources/images/logos/archivo128.png" height="100" width="100">\n\
                                <div class="clean_slider_image_shown" style="display: block;">\n\
                                    <h1 class="titulo">Sistema de Archivos Digitales</h1>\n\
                                    <p style="text-shadow: none">La Biblioteca de archivos virtuales(conocido por sus siglas ArcDig),es el repositorio\n\
                                        institucional del Proyecto Especial Alto Mayo que recoge los documentos que se produce\n\
                                        de las diferentes oficinas de la institución.</p>\n\
                                </div>\n\
                            </div></li>';
                var data_3 = '<li data-id="3" dir="http://lib.peam.gob.pe/Visitas/controlVisitas/index.php?r=consultas/visitaConsulta">\n\
                            <div class="banner clean_slider_image_shown" style="display: block;">\n\
                                <img src="./resources/images/logos/registro128.png" height="100" width="100">\n\
                                <div class="clean_slider_image_shown" style="display: block;">\n\
                                    <h1 class="titulo">Registro de Visitas en L&iacute;nea</h1>\n\
                                    <p style="text-shadow: none">El Sistema de Registro de Visitas es una aplicación web que permite hacer el registro de las visitas de los ciudadanos que visitan a un empleado público.</p>\n\
                                </div>\n\
                            </div>\n\
                        </li>';
                var data_4 = '<li data-id="4" dir="https://correo.peam.gob.pe/">\n\
                            <div class="banner clean_slider_image_shown" style="display: block;">\n\
                                <img src="./resources/images/logos/correo128.png" height="100" width="100">\n\
                                <div class="clean_slider_image_shown" style="display: block;">\n\
                                    <h1 class="titulo">Correo Institucional</h1>\n\
                                    <p style="text-shadow: none">Contamos con el cliente web Zimbra que es una interfaz que brinda servicio de correo electrónico y trabajo colaborativo.</p>\n\
                                </div>\n\
                            </div>\n\
                        </li>';
                var data_5 = '<li data-id="5" dir="http://lib.peam.gob.pe:8080/Gps">\n\
                            <div class="banner clean_slider_image_shown" style="display: block;">\n\
                                <img src="./resources/images/logos/gps128.png" height="100" width="100">\n\
                                <div class="clean_slider_image_shown" style="display: block;">\n\
                                    <h1 class="titulo">Rastreo Satelital</h1>\n\
                                    <p style="text-shadow: none">Herramienta web que facilita la consulta de coordenadas referente a la ubicación de los vehículos motorizados del Proyecto Especial Alto Mayo. </p>\n\
                                </div>\n\
                            </div>\n\
                        </li>';

                var array = {0: data_0, 1: data_1, 2: data_2, 3: data_3, 4: data_4, 5: data_5, 10: data_10};
                var a = 0.3;
                $$('.panel').multiSelect(a, array);

                function mostrarDialogVerNotice() {
                    capa = $$(".papel")
                    back = $$(".back")
                    capa.toggle();
                    back.toggle();
                    capa.focus();
                }

                $$('.cerrarPapel').addEvent("click", function () {
                    capa = $$(".papel");
                    back = $$(".back");
                    capa.hide();
                    back.hide();
                });

                $$('.back').addEvent("click", function () {
                    this.hide();
                    $$(".papel").hide();
                });

                $("siga-class").addEvent("click", function () {
                    mostrarDialogVerNotice();
                });
            });
        </script>

        <style type="text/css">
            /*<![CDATA[*/

            #posts {
                padding: 0;
                margin: 0;
            }
            #posts li {
                width: 98%;
                border: 1px solid #eee;
                background-color: #F9F9F9;
                background-image: none;
                float: left;
                clear: both;
                list-style: none;
                margin: 0 0 5px 0;
                padding: 5px;
                cursor: pointer;
            }
            #posts a {
                text-decoration: none;
                color: #000;

            }
            #posts img {
                display: block;
                float: left;
                border: 1px #ccc solid;
                background: white;
                padding: 3px;
                margin: 0 10px 0 0;
            }
            #posts h1 {
                padding: 5px 0 0 0;
                margin: 0;
                color: #CC0033;
                font-family: "Times New Roman", Times, serif;
                font-size: 1.2em;
            }
            #posts p {
                margin: 0;
                padding: 0 0 10px 0;
            }
            .titulo {
                font: arial;
                font-size: 2.0em;
                color: #CC0033;
                line-height: 150%;                
            }
            #detailSistema  li div img {
                float: left;
                margin-right: 20px;
            }
            /*]]>*/

        </style>
        <title>Mis Servicios</title>
    </head>
    <body>
        <%@include file="../jspf/cabecera.jspf" %>
        <div class="wrapper2" >            
            <div class="cuerpo">
                <div class="back" id="back" style="display:none;    z-index:10000; background-color:#fff; position: absolute;  height:515px; -moz-border-radius: 6px 6px 6px 6px; -webkit-border-radius: 6px 6px 6px 6px; border-radius: 6px 6px 6px 6px; -moz-box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.2); -webkit-box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.2);	box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.2); margin: 0px 0 0px 0;	" ></div>
                <div class="papel" id="papel" style="display:none;   border:1px solid #898C95; z-index:10000; background-color:#fff; position: absolute; min-height:auto; -moz-border-radius: 6px 6px 6px 6px; -webkit-border-radius: 6px 6px 6px 6px; border-radius: 6px 6px 6px 6px; -moz-box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.2); -webkit-box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.2);	box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.2); margin: 120px 5px 4px 5px;	padding: 8px 10px 8px 10px; " >
                   <!-- <div class="" style=" width: 100%; font-size: 14pt; font-weight: bold; text-align: center; cursor: pointer">Seleccione el aplicativo que necesita</div>-->
                   <!-- <div class="cerrarPapel" style=" width: 100%; font-weight: bold; text-align: right; cursor: pointer">(X) Cerrar</div>-->
                    <div class ="titulo"></div>
                    <!--<div class="contenido row">
                        <div  class="col-sm-6">
                            <ul id="posts">
                                <li style="text-shadow: none" class="panel" dir="http://siga.peam.gob.pe:8080/SIGAWEB/" data-id="6">
                                    <img src="./resources/images/logos/siga.png" alt="" />
                                    <h1>SIGA</h1>
                                    <p >Para efectuar la Programación de los Bienes, Servicios y Cuadro de Necesidades; para el cumplimiento de sus metas durante el periodo anual. Asimismo, contiene los procedimientos para la ejecución de sus adquisiciones y el control presupuestal de los mismos.</p>
                                </li>
                            </ul>
                        </div>
                       <!-- <div class="col-sm-6">
                            <ul id="posts"  >
                                <li style="text-shadow: none" class="panel" dir="http://siga.peam.gob.pe:8080/SIGAWEB_VIATICOS/" data-id="7">
                                    <img  src="./resources/images/logos/viatico.png" alt="" />
                                    <h1>SIGA VIATICOS</h1>
                                    <p > Sistema de Viáticos de las Unidades Ejecutoras para efectuar la Solicitud, Generación, Otorgamiento y Rendición de las Planillas de Viáticos dentro y fuera del territorio nacional así como la generación de Órdenes de Pasaje.</p>
                                </li>
                        </div>-->
                    </div>
                    <!--<botton class="button green" id="imprimir" style="float:left"> Imprimir </botton>-->
                </div>
                <div  class="services row hidden-xs" style="width: 95%; margin: 10px auto;"  >
                    <ul style="width: auto; height: 100px;" id="detailSistema">
                    </ul>
                </div>
                <div class="services row" style="width: 95%; margin: 10px auto; "  > 
                    <div style="" class="col-sm-6">
                        <ul id="posts">
                            <li style="text-shadow: none" class="panel" dir="http://doc.peam.gob.pe/sisgedo/app/main.php" data-id="0">
                                <img src="./resources/images/logos/sisgedo.png" alt="" />
                                <h1>SISGEDO</h1>
                                <p >El Sistema de Gestión Documentaria - SisGeDo 1.5.0 es una aplicación WEB que permite efectuar la administracion de expedientes... </p>
                            </li>

                            <li id="siga-class" style="text-shadow: none" class="panel" dir="http://siga.peam.gob.pe:8080/SIGAWEB/" data-id="1">
                                <img src="./resources/images/logos/siga.png" alt="" />
                                <h1>SIGA WEB</h1>
                                <p >Es un sistema informático que contribuye al ordenamiento y
                                    simplificación de los procesos administrativos...</p>
                            </li>

                            <li style="text-shadow: none" class="panel" dir="http://lib.peam.gob.pe/ArcDig/"   data-id="2">
                                <img src="./resources/images/logos/archivo.png" alt="" />
                                <h1>ARCDIG</h1>
                                <p >La Biblioteca de archivos virtuales (conocido por sus siglas ArcDig), es el repositorio institucional del Proyecto Especial Alto Mayo... </p>
                            </li>
                        </ul>
                    </div>
                    <div style=" " class="col-sm-6">
                        <ul id="posts"  >
                            <li style="text-shadow: none" class="panel" dir="http://lib.peam.gob.pe/Visitas/controlVisitas/index.php?r=consultas/visitaConsulta" data-id="3">
                                <img  src="./resources/images/logos/registro.png" alt="" />
                                <h1>REGISTRO DE VISITAS EN LINEA</h1>
                                <p >El Sistema de Registro de Visitas es una aplicación web que permite hacer el registro de las visitas de los ciudadanos que visitan a un empleado público... </p>
                            </li>
                            <li style="text-shadow: none" class="panel" data-id="4" dir="https://correo.peam.gob.pe/">
                                <img src="./resources/images/logos/correo.png"  alt="" />
                                <h1>CORREO INSTITUCIONAL</h1>
                                <p >Contamos con el cliente web Zimbra que es una interfaz que brinda servicio de correo electrónico y trabajo colaborativo... </p>
                            </li>
                            <li style="text-shadow: none" class="panel" data-id="5" dir="http://lib.peam.gob.pe:8081/Gps">
                                <img src="./resources/images/logos/gps.png" alt="" />
                                <h1>RASTREO SATELITAL</h1>
                                <p >Herramienta web que facilita la consulta de coordenadas referente a la ubicación de los vehículos motorizados... </p>
                            </li>
                        </ul>
                    </div>
                </div>

            </div>

        </div>

        <%@include file="../jspf/pie.jspf" %>

    </body>
</html>