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
        <script type="text/javascript" src="resources/js/JpCalendar.js"></script>
        <script type="text/javascript" src="resources/js/JpAgenda.js"></script>
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

                /*new JpSlider($("s-content"), {
                 url : './Publicaciones?action=NotaPrensaForNotice',
                 type : 'notice'
                 });*/
                $('st1').setFocus();
                var myAccordion = new Fx.Accordion(document.id('accordion'), 'h3.toggler', 'div.element', {
                    opacity: false,
                    display: 1,
                    currentIndex: 1,
                    index: 1,
                    onActive: function (toggler, element) {
                        toggler.addClass('active');
                    },
                    onBackground: function (toggler, element) {
                        toggler.removeClass('active');
                    }
                });
                $$('.panel').multiFade();
                $('st1').setFocus();
                $('buscarPag').buscarDato("norte");
                /*$("cab1").addEvent("click",function(){
                 $("hidenoti").setStyle('display', 'block');
                 $("s-content").setStyle('display', 'block');
                 });
                 $("hidenoti").setStyle('display', 'none').addEvent("click",function(){
                 $("hidenoti").setStyle('display', 'none');
                 $("s-content").setStyle('display', 'none');
                 });
                 new JpSlider($("enlaces"), {
                 url : './Enlace',
                 type : 'links'
                 });*/

            });
        </script>
        <title>Etica</title>
    </head>
    <body>
        <%@include file="../jspf/cabecera.jspf"%>
        <div class="wrapper2">

            <div class="cuerpo">
                <div class="navegacion">
                    <h2>
                        <a href="./Inicio">Inicio</a> / <a href="./LaInstitucion">La Instituci&oacute;n</a> / Etica
                    </h2>
                </div>
                <div class="services text-center">
                    <div class="gadget">
                        <div class="panel">
                            <a href="./LaInstitucion?action=QuienesSomos">
                                <div class="quienes-somos"></div>
                                <div class="descripcion" style="font-size:11px">
                                    Quienes Somos
                                </div>
                            </a>
                        </div>
                        <div class="panel">
                            <a href="./LaInstitucion?action=Vision">
                                <div class="vision"></div>
                                <div class="descripcion" style="font-size:11px">
                                    Visi&oacute;n / Misi&oacute;n
                                </div>
                            </a>
                        </div>
                        <div class="panel">
                            <a href="./LaInstitucion?action=Objetivo">
                                <div class="objetivo"></div>
                                <div class="descripcion" style="font-size:11px">
                                    Objetivo / Funciones
                                </div>
                            </a>
                        </div>
                        <div class="panel active">
                            <div class="etica"></div>
                            <div class="descripcion" style="font-size:11px">
                                <a>Código de Etica</a>
                            </div>
                        </div>
                        <div class="panel">
                            <a href="./LaInstitucion?action=Ubicacion">
                                <div class="ubicacion"></div>
                                <div class="descripcion" style="font-size:11px">
                                    Ubicaci&oacute;n
                                </div>
                            </a>
                        </div>

                        <div class="panel">
                            <a href="./LaInstitucion?action=Estructura">
                                <div class="estructura"></div>
                                <div class="descripcion" style="font-size:11px">
                                    Estructura Org&aacute;nica
                                </div>
                            </a>
                        </div>
                        <div class="panel">
                            <a href="./LaInstitucion?action=Directorio">
                                <div class="directorio"></div>
                                <div class="descripcion" style="font-size:11px">
                                    Directorio de Contactos
                                </div>
                            </a>
                        </div>

                    </div>
                </div>

                <div class="cdesk">
                    <div class="sliderPanel">
                        <h2 id="st1">Etica</h2>
                        <div id="sp1">
                            <div class="row" style="list-style: square; margin:35px;">
                                <div class="col-sm-2"></div>
                                <img src="resources/images/codigoetica.png" class="col-sm-1" />
                                <p class="col-sm-7">
                                    El presente Código de Ética tiene por objetivo direccionar dentro de la función pública el actuar de
                                    los empleados del Proyecto Especial Alto Mayo, en cualquiera de sus niveles, el cumplimiento y
                                    observancia estricta de las bases éticas establecidas en la Ley y Reglamento del Código de Ética, que
                                    servirá para generar la confianza y credibilidad de la ciudadanía. <a  style="font-family: verdana, arial" href="http://lib.peam.gob.pe:8081/ArcDig/OriArc.pdf?id=60633" target="_blank">Ver Documento</a> </p>

                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <%@include file="../jspf/pie.jspf"%>
    </body>
</html>
