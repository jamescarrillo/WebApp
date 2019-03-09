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
        <script type="text/javascript" src="resources/js/AlMultiFade.js"></script> 
        <script type="text/javascript" src="resources/js/JpSlider.js"></script>
        <script type="text/javascript" src="resources/js/JpCalendar.js"></script>
        <script type="text/javascript" src="resources/js/JpAgenda.js"></script>
       
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
                
               /* new JpSlider($("s-content"), {
                    url: './Publicaciones?action=NotaPrensaForNotice',
                    type: 'notice'
                });

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
                });*/

                $$('.panel').multiFade();
                $('st1').setFocus();
                $('buscarPag').buscarDato("norte");
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
                });
*/


                $("st1").addEvent('click', function(event) {
                    event.stop();
                    sp1.toggle();
                    sp2.hide();
                    sp3.hide();
                });

                $("st2").addEvent('click', function(event) {
                    event.stop();
                    sp1.hide();
                    sp2.toggle();
                    sp3.hide();
                });

                $("st3").addEvent('click', function(event) {
                    event.stop();
                    sp1.hide();
                    sp2.hide();
                    sp3.toggle();
                });
                
                var sp1 = $("sp1");//new Fx.Slide('sp1', {mode: 'vertical'});
                var sp2 = $("sp2");//new Fx.Slide('sp2', {mode: 'vertical'});
                var sp3 = $("sp3");
                
                sp1.hide();
                sp2.hide();
                sp3.hide();

                var tab = get()["tab"];

                switch (tab) {
                    case "1" :
                        sp1.toggle();
                        break;
                    case "2" :
                        sp2.toggle();
                        break;
                    case "3" :
                        sp3.toggle();
                        break;
                }




            });
        </script>
        <title>Quienes Somos</title>
    </head>
    <body>
        <div class="wrapper2">
            <%@include file="../jspf/cabecera.jspf"%>
            <div class="cuerpo">
                <div class="navegacion">
                    <h2>
                        <a href="./Inicio">Inicio</a> / <a href="./LaInstitucion">La Instituci&oacute;n</a> / Quienes Somos
                    </h2>
                </div>
                <div class="services text-center">
                    <div class="gadget">
                        <div class="panel active">
                            <div class="quienes-somos"></div>
                            <div class="descripcion" style="font-size:11px"><a>Quienes Somos</a></div>
                        </div>
                        <div class="panel">
                            <a href="./LaInstitucion?action=Vision">
                                <div class="vision"></div>
                                <div class="descripcion" style="font-size:11px">Visi&oacute;n / Misi&oacute;n</div>
                            </a>
                        </div>                 
                        <div class="panel">
                            <a href="./LaInstitucion?action=Objetivo">
                                <div class="objetivo"></div>
                                <div class="descripcion" style="font-size:11px">Objetivo / Funciones</div>
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
                        <div class="panel">
                            <a href="./LaInstitucion?action=Ubicacion">
                                <div class="ubicacion"></div>
                                <div class="descripcion" style="font-size:11px">Ubicaci&oacute;n</div>
                            </a>
                        </div>
                        <div class="panel">
                            <a href="./LaInstitucion?action=Estructura">
                                <div class="estructura"></div>
                                <div class="descripcion" style="font-size:11px">Estructura Org&aacute;nica</div>
                            </a>
                        </div>                  
                        <div class="panel">
                            <a href="./LaInstitucion?action=Directorio">
                                <div class="directorio"></div>
                                <div class="descripcion" style="font-size:11px">Directorio de Contactos</div>
                            </a>
                        </div>
                       
                    </div>
                </div>
                <div class="cdesk">
                    <div class="sliderPanel" >
                        <h2 id="st1">Base Legal</h2>
                        <div id="sp1" style="list-style: square; margin-left: 105px; margin-right: 105px; margin-top: 35px; margin-bottom: 35px;">
                            <p>El Proyecto Especial Alto Mayo (PEAM) fue creado mediante Decreto Supremo Nº. 031-81-PCM como una institución pública descentralizada. En 1990 adquirió la categoría de Programa Presupuestario, con personería jurídica y autonomía económica, financiera, técnica y administrativa, D.L. Nº. 556 Art. 419. <a style="font-family: verdana, arial" href="http://www.peam.gob.pe/GestionTransparente?action=verNormaDirectiva&id=31249" target="_blank">Ver Documento</a></p>
                            <p>El PEAM es transferido al Gobierno Regional de San Martín, el 09 de setiembre del 2003 mediante D.S. Nº. 024-2003-VIVIENDA, en concordancia con la Ley Nº. 27902 en el que establece el inicio del proceso de transferencia a los Gobiernos Regionales y en el marco del proceso establecido por el Consejo Nacional de Descentralización. <a  style="font-family: verdana, arial" href="http://www.peam.gob.pe/GestionTransparente?action=verNormaDirectiva&id=31248" target="_blank">Ver Documento</a> </p>
                        </div>
                    </div>
                    <div class="sliderPanel">
                        <h2 id="st2">Rese&ntilde;a Hist&oacute;rica</h2>
                        <div id="sp2" style="list-style: square; margin-left: 105px; margin-right: 105px; margin-top: 35px; margin-bottom: 35px;">
                            <p>En la década del 80, con la elaboración del Plan Nacional de Desarrollo, y la definición de objetivos y determinación de medidas para la estabilización de la economía, el gobierno decide impulsar los Proyectos de Desarrollo Rural, adquiriendo importancia los proyectos ubicados en la Zona de Selva, considerada como una importante frontera agrícola y despensa nacional.</p>
                            <p>Dentro de éste marco se crea el Proyecto Especial Alto Mayo como un Subprograma Presupuestario del Proyecto Especial Huallaga Central y Bajo Mayo, D.S. Nº. 031-81-PCM, adquiriendo en 1990 la categoría de Programa Presupuestario con personería jurídica, autonomía económica, financiera, técnica y administrativa, D.L. Nº. 556- Artículo 419. </p>
                            <p>Desde su concepción, el Proyecto Especial Alto Mayo estima su ejecución en dos etapas, la primera etapa con 120,000 Ha. ubicadas en la Margen Derecha del Río Mayo con un presupuesto aproximado de US$ 83’700,000 a precios de 1,983 con Financiamiento Externo, mediante Convenio de Préstamo con el Banco Mundial (BIRF) con US$ 21’882,291 y Convenio de Préstamo con el Fondo Internacional de Desarrollo Agrícola (FIDA) por US$ 22’857,058 DEG, y la segunda etapa con 37,000 Ha. ubicadas en la Margen Izquierda del Río Mayo con una inversión aproximada de 18’000,000 DM mediante el financiamiento de Cooperación Económica de la KfW de Alemania y la contraparte con Recursos Nacionales.</p>
                            <p>El Proyecto Desarrollo Integral Alto Mayo (DIAM) establece el Componente de Protección Ambiental mediante Canje de Deuda por Naturaleza por DM 10 millones, a través de un aporte financiero del Estado Peruano de DM 4 millones, administrados por PROFONANPE. </p>
                        </div>
                    </div>
                    <div class="sliderPanel">
                        <h2 id="st3">Actualidad</h2>
                        <div id="sp3">
                            <div class="spoon" style="margin:35px;">
                                <img src="resources/images/fachada_peam.png" />
                                <p>En este contexto el Proyecto Especial Alto Mayo ha venido ejecutando sus acciones con el uso combinado de recursos del Tesoro Público, Donaciones y Crédito Externo, en base a políticas y
                                    lineamientos del Instituto Nacional de Desarrollo (INADE) hasta el 09 de setiembre del 2,003, fecha en que mediante D.S. Nº. 024-2003-VIVIENDA se dispone la transferencia definitiva al
                                    Gobierno Regional San Martín, continuando como Unidad Ejecutora dependiente de este.</p>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
            <%@include file="../jspf/pie.jspf"%>
        </div>
    </body>
</html>
