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

                /*new JpSlider($("s-content"), {
                    url: './Publicaciones?action=NotaPrensaForNotice',
                    type: 'notice'
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
                $('buscarPag').buscarDato("norte");
                /*$("cab1").addEvent("click", function () {
                    $("hidenoti").setStyle('display', 'block');
                    $("s-content").setStyle('display', 'block');
                });
                $("hidenoti").setStyle('display', 'none').addEvent("click", function () {
                    $("hidenoti").setStyle('display', 'none');
                    $("s-content").setStyle('display', 'none');
                });
                new JpSlider($("enlaces"), {
                    url: './Enlace',
                    type: 'links'
                });*/

                $("st1").addEvent('click', function (event) {
                    event.stop();
                    sp1.toggle();
                });

                var sp1 = new Fx.Slide('sp1', {
                    mode: 'vertical'
                });
                $("map-grsm").addEvent("click", function () {
                    cargarGrsm();
                    return false;
                });
                $("map-consejo").addEvent("click", function () {
                    cargarConsejo();
                    return false;
                });
                $("map-gerencia").addEvent("click", function () {
                    cargarFuncionario("organigrama=GERENCIA%20GENERAL");
                    return false;
                });
                $("map-osi").addEvent("click", function () {
                    cargarFuncionario("organigrama=ORGANO%20DE%20CONTROL%20INSTITUCIONAL");
                    return false;
                });
                $("map-administracion").addEvent("click", function () {
                    cargarFuncionario("organigrama=OFICINA%20DE%20ADMINISTRACION");
                    return false;
                });
                $("map-opp").addEvent("click", function () {
                    cargarFuncionario("organigrama=OFICINA%20DE%20PRESUPUESTO%20Y%20PLANIFICACION");
                    return false;
                });
                $("map-asesoria").addEvent("click", function () {
                    cargarFuncionario("organigrama=OFICINA%20DE%20ASESORIA%20JURIDICA");
                    return false;
                });
                $("map-dma").addEvent("click", function () {
                    cargarFuncionario("organigrama=DIRECCION%20DE%20MANEJO%20AMBIENTAL");
                    return false;
                });
                $("map-infraestructura").addEvent("click", function () {
                    cargarFuncionario("organigrama=DIRECCION%20DE%20INFRAESTRUCTURA");
                    return false;
                });
                $("map-agropecuaria").addEvent("click", function () {
                    cargarFuncionario("organigrama=DIRECCION%20DE%20DESARROLLO%20AGROPECUARIO");
                    return false;
                });
                function cargarGrsm() {
                    $("marco").getChildren().each(function (node, index) {
                        $$(node)[0].getParent().removeChild(node);
                    });
                    var titulo = new Element('h1', {
                        "html": "Gobierno Regional de San Mart&iacute;n"
                    });
                    var divM = new Element('div', {
                        "class": "mark"
                    });
                    divM.setStyles({"width": "100%", "margin-top": "10px"});
                    var img = new Element('img', {
                        "src": "resources/images/san_martin.png"

                    });
                    var span = new Element('span', {
                        "html": "El Proyecto Especial Alto Mayo (PEAM) es una unidad ejecutora del Gobierno Regional de San Martín desde el 09 de setiembre del año 2003, fecha en que mediante D.S. Nº. 024-2003-VIVIENDA se dispone su transferencia definitiva desde el Instituto Nacional de Desarrollo (INADE).\n\
                        <a href='http://lib.peam.gob.pe:8081/ArcDig/OriArc.pdf?id=26794' target='_blank' > Ver documento de aprobación </a>"
                    });
                    var divAl = new Element('div', {
                        "class": "mensaje-aviso",
                        html: "Para obtener más detalles haz click en cualquier nodo del organigrama."
                    });
                    var divLink = new Element('div', {
                        "style": "margin-top:20px",
                      //  html: "<a href='http://lib.peam.gob.pe:8081/ArcDig/OriArc.pdf?id=26794' target='_blank' > Ver documento de aprobación </a>"
                    });
                    divAl.setStyles({"width": "100%", "margin-top": "10px"});
                    img.inject(divM);
                    span.inject(divM);
                    $("marco").adopt(titulo, divM, divAl, divLink);
                }

                function cargarConsejo() {
                    var ajax = new Request.JSON({
                        url: './GestionTransparente?action=Directivo',
                        onSuccess: function (response) {
                            $("marco").getChildren().each(function (node, index) {
                                $$(node)[0].getParent().removeChild(node);
                            });

                            var tituloH = new Element('h1', {
                                "html": "Consejo Directivo"
                            });
                            tituloH.inject($("marco"));

                            $("marco").adopt(tituloH);
                            var accord = new Element('div', {
                                "id": 'accord',
                                'style': 'width:100%',
                                
                            });

                            accord.inject($("marco"));
                            var Ahtml = "";
                            response.items.each(function (node, index) {
                                var titulo = "<h3 class='toogle'> " + node.nombresApellidos + "</h3>"
                                var img = "<img style='float:left; margin:0px; ' src= './archivos/" + node.foto + "' />";
                                var descriptionInfor = "<table  style='width:80%; margin-top:40px; font-size: 12px; float:left'><tr><td width='40%' style='font-weight:bold';>Cargo:</td><td width='60%'>" + node.cargo + "</td></tr>";
                                descriptionInfor += "<tr><td style='font-weight:bold';>Designado por:</td><td>" + node.resolucion + "</td></tr>";
                                descriptionInfor += "<tr><td style='font-weight:bold';>Representante de:</td><td>" + node.institucion + "</td></tr>";
                                descriptionInfor += "<tr><td style='font-weight:bold';>Correo Electr&oacute;nico:</td><td>" + node.eMail + "</td></tr></table>";
                                var divMark = "<div class='elem' style='float:none; width:100%'  >" + img + descriptionInfor + "</div>";
                                
                                Ahtml += titulo + divMark;
                            });
                            $("accord").set("html", Ahtml);

                            var acc = new Fx.Accordion(document.id('accord'), 'h3.toogle', 'div.elem', {
                                opacity: false,
                                onActive: function (toogle, element) {
                                    toogle.addClass('active');
                                },
                                onBackground: function (toogle, element) {
                                    toogle.removeClass('active');
                                }
                            });
                        }
                    });
                    ajax.send();
                }
                function cargarFuncionario(organigrama) {

                    $("marco").getChildren().each(function (node, index) {
                        $$(node)[0].getParent().removeChild(node);
                    });

                    var tituloH = new Element('h1', {
                        "html": organigrama.split("=")[1].replace(/%20/g, ' ')
                    });
                    tituloH.inject($("marco"));
                    var ajax = new Request.JSON({
                        url: './GestionTransparente?action=getFuncionarioForFlowChart',
                        data: organigrama,
                        onSuccess: function (response) {
                            var divMark = new Element('div', {"class": "mark"});
                            divMark.setStyles({"padding": "5px", "width": "97%"});
                            var img = new Element('img', {
                                "src": "./archivos/" + response.funcionario.foto
                            });
                            img.setStyles({"margin-top": "20px", "margin-left": "30px",'border': '1px solid #000'});
                            var descriptionInfor = "<div><label>Nombres y Apellidos:</label><span >" + response.funcionario.nombresApellidos + "</span></div>";
                            descriptionInfor += "<div><label>N&uacute;mero de D.N.I:</label><span>" + response.funcionario.numeroDni + "</span></div>";
                            descriptionInfor += "<div><label>Cargo:</label><span>" + response.funcionario.cargo + "</span></div>";
                            descriptionInfor += "<div><label>Nivel Remunerativo:</label><span>" + response.funcionario.nivelRemunerativo + "</span></div>";
                            descriptionInfor += "<div><label>Designado Por:</label><span>" + response.funcionario.resolucion + "</span></div>";
                            descriptionInfor += "<div><label>Tel&eacute;fono:</label><span>" + response.funcionario.telefono + "</span></div>";
                            //descriptionInfor += "<div><label>Fax:</label><span>" + response.funcionario.fax + "</span></div>";
                            descriptionInfor += "<div><label>Correo Electr&oacute;nico:</label><span>" + response.funcionario.eMail + "</span></div>";
                            descriptionInfor += "<div><label>R&eacute;gimen Laboral:</label><span>" + response.funcionario.regimenLaboral + "</span></div>";
                            var divIn = new Element('div', {
                                "class": "information",
                                "html": descriptionInfor
                            });
                            divIn.setStyles({"width": "70%", "margin-top": "10px", "padding": "1px", "padding-bottom":"15px"});
                            divMark.setStyles({"border": "0.2em #ccc solid", "margin-top": "10px", "background-color": "#efefef"});
                            divMark.adopt(img, divIn);
                            $("marco").adopt(divMark);
                        }
                    });
                    ajax.send();
                    return false;
                }
                cargarGrsm();
            });
        </script>
        <title>Estructura Org&aacute;nica</title>
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
                        <div class="panel" style=" ">
                            <a href="./LaInstitucion?action=Vision">
                                <div class="vision"></div>
                                <div class="descripcion">
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
                        <div class="panel">
                            <a href="./LaInstitucion?action=Ubicacion">
                                <div class="ubicacion"></div>
                                <div class="descripcion" style="font-size:11px">
                                    Ubicaci&oacute;n
                                </div>
                            </a>
                        </div>
                        <div class="panel active">
                            <div class="estructura"></div>
                            <div class="descripcion" style="font-size:11px">
                                <a>Estructura Org&aacute;nica</a>
                            </div>
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
                        <h2 id="st1">Estructura Org&aacute;nica (Organigrama)</h2>
                        <div id="sp1">
                            <div class="row">
                                <div class="col-sm-1"></div>
                                <img src="resources/images/Organigrama.png" usemap="#organigrama" />
                                <map name="organigrama" id="organigrama" style="display: none;">
                                    <area shape="rect" coords="141,7,232,29" id="map-grsm" href="#">
                                    <area shape="rect" coords="141,56,232,83" id="map-consejo" href="#">
                                    <area shape="rect" coords="141,107,232,134" id="map-gerencia" href="#">
                                    <area shape="rect" coords="10,105,115,134" id="map-osi" href="#">
                                    <area shape="rect" coords="31,197,116,226" id="map-administracion" href="#">
                                    <area shape="rect" coords="232,166,352,195" id="map-opp" href="#">
                                    <area shape="rect" coords="243,231,345,264" id="map-asesoria" href="#">
                                    <area shape="rect" coords="18,307,126,337" id="map-dma" href="#">
                                    <area shape="rect" coords="140,307,234,337" id="map-infraestructura" href="#">
                                    <area shape="rect" coords="247,307,386,337" id="map-agropecuaria" href="#">
                                </map>
                                <p class="col-sm-6" id="marco"></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <%@include file="../jspf/pie.jspf"%>
    </body>
</html>
