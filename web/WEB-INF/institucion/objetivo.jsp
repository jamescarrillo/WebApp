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
                    url: './Publicaciones?action=NotaPrensaForNotice',
                    type: 'notice'
                });*/

                var myAccordion = new Fx.Accordion(document.id('accordion'), 'h3.toggler', 'div.element', {
                    opacity: false,
                    display: 1,
                    currentIndex: 1,
                    index: 1,
                    onActive: function(toggler, element) {
                        toggler.addClass('active');
                    },
                    onBackground: function(toggler, element) {
                        toggler.removeClass('active');
                    }
                });
                $$('.panel').multiFade();
                $('buscarPag').buscarDato("norte");
                $('st1').setFocus();
               /* $("cab1").addEvent("click", function() {
                    $("hidenoti").setStyle('display', 'block');
                    $("s-content").setStyle('display', 'block');
                });
                $("hidenoti").setStyle('display', 'none').addEvent("click", function() {
                    $("hidenoti").setStyle('display', 'none');
                    $("s-content").setStyle('display', 'none');
                });
                new JpSlider($("enlaces"), {
                    url: './Enlace',
                    type: 'links'
                });*/
                $("st1").addEvent('click', function(event) {
                    event.stop();
                    sp1.toggle();
                    sp2.hide();
                });
                
                $("st2").addEvent('click', function(event) {
                    event.stop();
                    sp2.toggle();
                    sp1.hide();
                });

                var sp1 = $("sp1");//new Fx.Slide('sp1', {mode: 'vertical'});
                var sp2 = $("sp2");//new Fx.Slide('sp2', {mode: 'vertical'});

                sp1.hide();
                sp2.hide();

                var tab = get()["tab"];

                switch (tab) {
                    case "1" :
                        sp1.toggle();
                        break;
                    case "2" :
                        sp2.toggle();
                        break;

                }

            });
        </script>
        <title>Objetivos</title>
    </head>
    <body>
        <%@include file="../jspf/cabecera.jspf"%>
        <div class="wrapper2">
            
            <div class="cuerpo">
                <div class="navegacion">
                    <h2>
                        <a href="./Inicio">Inicio</a> / <a href="./LaInstitucion">La Instituci&oacute;n</a> / Objetivos
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
                        <div class="panel active">
                            <div class="objetivo"></div>
                            <div class="descripcion" style="font-size:11px">
                                <a>Objetivo / Funciones</a>
                            </div>
                        </div>
                         <div class="panel">
                            <a href="./LaInstitucion?action=Etica">
                                <div class="etica"></div>
                                <div class="descripcion" style="font-size:11px">
                                    Código de Etica
                                </div>
                            </a>
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
                        <h2 id="st1">Objetivos Estratégicos</h2>
                        <div id="sp1">
                            <div class="row">
                                <div class="col-sm-2"></div>
                                <img src="resources/images/NuestrosObjetivos.png" class="col-sm-2" style="margin:15px;"/>
                                <div class="col-sm-6">
                                    <ul style="list-style: square; margin:35px; font-size: 14px; color: #666666; text-align: justify;" >
                                        <li>
                                            Fortalecer la especializaci&oacute;n de las personas por desempe&ntilde;o.</li>
                                        <li>
                                            Implementar metodolog&iacute;as con evidencia comprobada sectoriales.</li>
                                        <li>
                                            Desarrollar mecanismos simplificados de acceso a la informaci&oacute;n y &eacute;tica p&uacute;blica.</li>
                                        <li>
                                            Producir bienes y servicios especializados estandarizados de acuerdo a las expectativas de la ciudadan&iacute;a.</li>
                                        <li>
                                            Implementar la gesti&oacute;n por procesos mediante el fortalecimiento organizacional.</li>
					<li>
                                            Desarrollar intervenciones operativas mediante la inversi&oacute;n p&uacute;blica y privada.</li>

                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="sliderPanel">
                        <h2 id="st2">Funciones</h2>
                        <div id="sp2">
                            <div class="row" style="line-height: 1.5em; font-size: 14px; " >
                                <div class="col-sm-2"></div>
                                <ul style="list-style: square; margin-left: 105px; margin-right: 135px; margin-top: 35px; margin-bottom: 35px; color: #666666; text-align: justify;">
                                  <!--  <ul class="col-sm-8" style="list-style: square; margin-left: 75px; margin-right: 105px; margin-top: 35px; margin-bottom: 35px;">-->
                                    <li>
                                        Formular el Plan Estratégico de Desarrollo del PEAM, en armonía con los Planes Estratégicos Regional y Nacional, y los objetivos del Proyecto, y de acuerdo a lo establecido en los Convenios de Cooperación Técnica Internacional que le corresponda ejecutar.
                                    </li>
                                    <li>
                                        Formular los Poyectos Anuales de Presupuesto de la Institución y gestiona su aprobación en los diferentes niveles: GRSM, Dirección Nacional del Presuspuesto Público-MEF y Comisión de Presupuesto del Congreso de la República.
                                    </li>
                                    <li>
                                        Programa, dirige, ejecuta, controla y supervisa las diferentes obras y actividades para el cumplimiento de las metas físicas y financieras en función de los recursos económicos asignados.
                                    </li>
                                    <li>
                                        Contratación de empresas y personas naturales o jurídicas para la ejecución de estudios y obras de los Proyectos a su cargo, de acuerdo con las exigencias de la Ley y Reglamento de Adquisiciones y Contrataciones del Estado.
                                    </li>
                                    <li>
                                        Evalúa la gestión y el nivel de ejecución de las diferentes obras o proyectos productivos, en función de la programación anual, teniendo en cuenta el diseño total del Proyecto sujeto a evaluación.
                                    </li>
                                    <li>
                                        Realizar el seguimiento y evaluación de los efectos e impactos de la ejecución del PEAM, sobre el incremento de la producción y productividad agropecuaria en el area de influencia y aréas adyacentes, sobre el nivel de vida de la población y sobre la economía en conjunto, estableciendo compraciones con las metas obtenidas en períodos anteriores.
                                    </li>
                                    <li>
                                        Coordina con el GRSM, los aspectos técnicos, jurídicos, normativos, laborales, económicos y financieros relacionados con la ejecución del PEAM.
                                    </li>
                                    <li>
                                        Investiga y realiza acciones de difusión en aspectos relevantes para el desarrollo de los proyectos a su cargo, tales tales como la conservación, mejoramiento y uso adecuado de los recursos agua, suelo y bosques, manejo integral de cuencas, ecosistemas y aprovechamiento adecuado de los recursos naturales.
                                    </li>    
                                    <li>
                                        Promueve la participación de los beneficios de las obras o proyectos ejecutados, ademas de propiciar la inversión privado en proyectos agropecuarios y agroindustriales, principalmente de aquellos orientados a la exportación.
                                    </li>
                                    <li>
                                        Ejecuta los estudios de factibilidad que sean necesarios en apoyo al desarrollo de proyectos específicos de inversión.
                                    <li>
                                        Otras que le asigne el GRSM.
                                    </li>
                                </ul>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
        <%@include file="../jspf/pie.jspf"%>
    </body>
</html>
