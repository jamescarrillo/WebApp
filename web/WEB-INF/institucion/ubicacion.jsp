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
                /* $("cab1").addEvent("click",function(){
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
        <title>Ubicaci&oacute;n</title>
    </head>
    <body>
        <%@include file="../jspf/cabecera.jspf"%>
        <div class="wrapper2">

            <div class="cuerpo">
                <div class="navegacion">
                    <h2>
                        <a href="./Inicio">Inicio</a> / <a href="./LaInstitucion">La Instituci&oacute;n</a> / Ubicaci&oacute;n
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
                        <div class="panel">
                            <a href="./LaInstitucion?action=Etica">
                                <div class="etica"></div>
                                <div class="descripcion" style="font-size:11px">
                                    Código de Etica
                                </div>
                            </a>
                        </div>
                        <div class="panel active">
                            <div class="ubicacion"></div>
                            <div class="descripcion" style="font-size:11px">
                                <a>Ubicaci&oacute;n</a>
                            </div>
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
                        <h2 id="st1">Ubicaci&oacute;n Geogr&aacute;fica</h2>
                        <div id="sp1">
                            <div class="row" style="list-style: square; margin:35px;">          
                                <div class="col-sm-1"></div>
                                <iframe class="col-sm-5" style="float: left; padding: 20px;" height="400px" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.com.pe/maps?ie=UTF8&amp;cid=3653831969751690139&amp;q=Proyecto+Especial+Alto+Mayo&amp;gl=PE&amp;hl=es&amp;t=m&amp;ll=-6.043346,-76.971502&amp;spn=0.012803,0.012875&amp;z=15&amp;output=embed"></iframe> 
                                <div class="col-sm-5">
                                    <p>El Valle del Alto Mayo está situado en la parte nor - oeste de la Región San Martín, en el Perú, comprende dentro de su ámbito a las provincias de Moyobamba y Rioja.</p>
                                    <p>El ámbito geográfico de acción principal del Proyecto Especial Alto Mayo se ubica en la zona del Alto Mayo, comprendidas en las provincias de Moyobamba y Rioja, además de las zonas
                                        priorizadas en los distritos de Pinto Recodo y Alonso de Alvarado de la Provincia de Lamas, comprendida dentro de la Región San Martín.</p>
                                    <p>El área de acción actual lo constituyen 157,000 Ha. de tierras agrícolas y pecuarias de un total de 755,519 Ha. en el Alto Mayo, distribuidos: 486,448 Ha. y 269,071 Ha., en las márgenes
                                        derecha e izquierda del Río Mayo, respectivamente.</p>
                                    <p>La sede central del proyecto se encuentra ubicada en el distrito y provincia de Moyobamba.</p>
                                    <p>Además cuenta con Oficinas de Coordinación en la jurisdicción de la Provincia de Rioja, distritos de Rioja y Nueva Cajamarca y en la jurisdicción de la Provincia de Moyobamba, los
                                        Centros Poblados de Pueblo Libre y Pacayzapa.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <%@include file="../jspf/pie.jspf"%>
    </body>
</html>
