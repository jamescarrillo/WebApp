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
        <script type="text/javascript" src="resources/js/JpView.js"></script>
        <script type="text/javascript" src="resources/js/JpGrid.js"></script>
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
                    onActive: function(toggler, element) {
                        toggler.addClass('active');
                    },
                    onBackground: function(toggler, element) {
                        toggler.removeClass('active');
                    }
                });
                //new JpView($("tbl-funcionario"),{url:'./GestionTransparente?action=FuncionarioDirectorio',select:true});
                $$('.panel').multiFade();
                $('buscarPag').buscarDato("norte");
                /*$("cab1").addEvent("click", function() {
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
                var tblDirectorioTelefonico = new JpGrid($("tbl-directorio"), {
                    id: "gridDirectorioTelefonico",
                    url: './LaInstitucion?action=ListarDirectorioTelefonico',
                    altura: '240px',
                    params: {
                        limit: 12},
                    dataQuery: [
                        {name: 'query', value: $("txtBuscarDirectorio").get("value").replace("&", "$$")}
                    ],
                    model: [
                        {name: "oficina", field: 'Oficina', width: "35%", sort: true, type: 'string'},
                        {name: "seccion", field: 'Secci&oacute;n', width: "35%", type: 'string', sort: true},
                        {name: "anexo", field: 'Anexo', width: "30%", type: 'string'}
                    ]
                });
                $("btnBuscarFuncionario").addEvent("click", function(evt) {
                    evt.preventDefault();
                    tblFuncionarioDirectorio.loadData([
                        {name: 'query', value: $("txtBuscarFuncionario").get("value").replace("&", "$$")}
                    ]);
                });

                $("txtBuscarFuncionario").addEvent("keypress", function(evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblFuncionarioDirectorio.loadData([
                            {name: 'query', value: $("txtBuscarFuncionario").get("value").replace("&", "$$")}
                        ]);
                    }
                });

                var tblFuncionarioDirectorio = new JpGrid($("tbl-funcionario-grid"), {
                    id: "gridFuncionarioDirectorio",
                    url: './GestionTransparente?action=FuncionarioDirectorio',
                    altura: 'auto',
                    params: {
                        limit: 10},
                    dataQuery: [
                        {name: 'query', value: $("txtBuscarFuncionario").get("value").replace("&", "$$")}
                    ],
                    model: [
                        {name: "cargo", field: 'Cargo', width: "30%", sort: true, type: 'string'},
                        {name: "nombresApellidos", field: 'Nombres y Apellidos', width: "25%", type: 'string', sort: true},
                        {name: "telefono", field: 'Telefono', width: "25%", type: 'string', sort: true},
                        {name: "eMail", field: 'E-Mail', width: "20%", type: 'string', sort: true},
                    ]
                });

                $("btnBuscarDirectorio").addEvent("click", function(evt) {
                    evt.preventDefault();
                    tblDirectorioTelefonico.loadData([
                        {name: 'query', value: $("txtBuscarDirectorio").get("value").replace("&", "$$")}
                    ]);
                });
                $("txtBuscarDirectorio").addEvent("keypress", function(evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblDirectorioTelefonico.loadData([
                            {name: 'query', value: $("txtBuscarDirectorio").get("value").replace("&", "$$")}
                        ]);
                    }
                });
                $("st1").addEvent('click', function(event) {
                    event.stop();
                    sp1.toggle();
                    sp2.hide();
                });

                $('st1').setFocus();

                $("st2").addEvent('click', function(event) {
                    event.stop();
                    sp1.hide();
                    sp2.toggle();
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
        <title>Directorio Telef&oacute;nico</title>
    </head>
    <body>
        <%@include file="../jspf/cabecera.jspf"%>
        <div class="wrapper2">
            
            <div class="cuerpo" style="border-bottom: 1px ">
                <div class="navegacion">
                    <h2>
                        <a href="./Inicio">Inicio</a> / <a href="./LaInstitucion">La Instituci&oacute;n</a> / Directorio Telef&oacute;nico
                    </h2>
                </div>
                <div class="services text-center">
                    <div class="gadget">
                        <div class="panel" style=''>
                            <a href="./LaInstitucion?action=QuienesSomos">
                                <div class="quienes-somos"></div>
                                <div class="descripcion" style="font-size:11px">Quienes Somos</div>
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

                        <div class="panel active">
                            <div class="directorio"></div>
                            <div class="descripcion" style="font-size:11px">
                                <a>Directorio de Contactos</a>
                            </div>
                        </div>
                        
                    </div>
                </div>
                <div class="cdesk">
                    <div class="sliderPanel">
                        <h2 id="st1">Directorio de Contactos </h2>
                        <div id="sp1">
                            <div class="search">
                                <div class="content-i">
                                    <label style="margin-right:15px;margin-left:-50px; font-weight: bold; color: #6A6C71;">Buscar Por Cargo/Nombre:</label><input type="text" id="txtBuscarFuncionario" style="margin-right:3px" /><button id="btnBuscarFuncionario">Buscar</button>
                                </div>
                            </div>
                            <div id="tbl-funcionario-grid" class="grid"></div>  
                        </div>
                    </div>
                    <div class="sliderPanel">
                        <h2 id="st2">Directorio Telef&oacute;nico Interno</h2>
                        <div id="sp2">
                            <div class="search">
                                <label style="margin: 10px auto auto 10px; float: left">Número Principal: <b style="font-weight: bold">042-562522</b></label>
                                <div class="content-i">
                                    <label style="margin-right:15px;margin-left:-50px; font-weight: bold; color: #6A6C71;">Buscar Por Oficina/secci&oacute;n:</label><input type="text" id="txtBuscarDirectorio" style="margin-right:3px" /><button id="btnBuscarDirectorio">Buscar</button>
                                </div>
                            </div>
                            <div id="tbl-directorio" class="grid"></div>  
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
        <%@include file="../jspf/pie.jspf"%>
    </body>
</html>
