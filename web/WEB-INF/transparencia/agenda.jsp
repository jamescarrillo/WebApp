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
                
                $('st1').setFocus();
                $('buscarPag').buscarDato("norte");
                /*new JpSlider($("s-content"), {
                    url: './Publicaciones?action=NotaPrensaForNotice',
                    type: 'notice'
                });
                new JpSlider($("enlaces"), {
                    url: './Enlace',
                    type: 'links'
                });*/
                $("st1").addEvent('click', function(event) {
                    event.stop();
                    sp1.toggle();
                    
                    sp2.hide();
                    sp3.hide();
                    sp4.hide();
                });
                $("st2").addEvent('click', function(event) {
                    event.stop();
                    sp1.hide();
                    sp2.toggle();
                    sp3.hide();
                    sp4.hide();
                });
                $("st3").addEvent('click', function(event) {
                    event.stop();
                    sp1.hide();
                    sp2.hide();
                    sp3.toggle();
                    sp4.hide();
                });
                $("st4").addEvent('click', function(event) {
                    event.stop();
                    sp1.hide();
                    sp2.hide();
                    sp3.hide();
                    sp4.toggle();
                });
                
                var sp1 = $("sp1"); 
                var sp2 = $("sp2");
                var sp3 = $("sp3");
                var sp4 = $("sp4");
                
                sp1.hide();
                sp2.hide();
                sp3.hide();
                sp4.hide();
                //buscamos primero los datos del Gerente
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
                    case "4" :
                        sp4.toggle();
                        break;
                   
                }
                
                var ajaxGerente = new Request.JSON({
                    url: './GestionTransparente?action=getFuncionarioForFlowChart',
                    data: "organigrama=GERENCIA%20GENERAL",
                    onSuccess: function(response) {
                        $("photoGerencia").set("src", "./archivos/" + response.funcionario.foto);
                        $("descripcionGerencia").set("html", " " + response.funcionario.nombresApellidos + " </br>" + response.funcionario.cargo);
                        var calGerencia = new JpAgenda($("fechaGerencia"), $("actividadGerencia"), {
                            navigation: true,
                            url: './GestionTransparente?action=ListarAgendaInstitucional&tipo=1'
                        });
                    }
                });
                ajaxGerente.send();

                var ajaxInfraestructura = new Request.JSON({
                    url: './GestionTransparente?action=getFuncionarioForFlowChart',
                    data: "organigrama=DIRECCION%20DE%20INFRAESTRUCTURA",
                    onSuccess: function(response) {
                        $("photoInfraestructura").set("src", "./archivos/" + response.funcionario.foto);
                        $("descripcionInfraestructura").set("html", " " + response.funcionario.nombresApellidos + " </br>" + response.funcionario.cargo);
                        var calInfraestructura = new JpAgenda($("fechaInfraestructura"), $("actividadInfraestructura"), {
                            navigation: true,
                            url: './GestionTransparente?action=ListarAgendaInstitucional&tipo=2'
                        });
                    }
                });
                ajaxInfraestructura.send();
                var ajaxAgropecuario = new Request.JSON({
                    url: './GestionTransparente?action=getFuncionarioForFlowChart',
                    data: "organigrama=DIRECCION%20DE%20DESARROLLO%20AGROPECUARIO",
                    onSuccess: function(response) {
                        $("photoAgropecuario").set("src", "./archivos/" + response.funcionario.foto);
                        $("descripcionAgropecuario").set("html", " " + response.funcionario.nombresApellidos + " </br>" + response.funcionario.cargo);
                        var calAgropecuario = new JpAgenda($("fechaAgropecuario"), $("actividadAgropecuario"), {
                            navigation: true,
                            url: './GestionTransparente?action=ListarAgendaInstitucional&tipo=3'
                        });
                    }
                });
                ajaxAgropecuario.send();
                var ajaxAmbiental = new Request.JSON({
                    url: './GestionTransparente?action=getFuncionarioForFlowChart',
                    data: "organigrama=DIRECCION%20DE%20MANEJO%20AMBIENTAL",
                    onSuccess: function(response) {
                        $("photoAmbiental").set("src", "./archivos/" + response.funcionario.foto);
                        $("descripcionAmbiental").set("html", " " + response.funcionario.nombresApellidos + " </br>" + response.funcionario.cargo);
                        var calAmbiental = new JpAgenda($("fechaAmbiental"), $("actividadAmbiental"), {
                            navigation: true,
                            url: './GestionTransparente?action=ListarAgendaInstitucional&tipo=4'
                        });
                    }
                });
                ajaxAmbiental.send();

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
               /* $("cab1").addEvent("click", function() {
                    $("hidenoti").setStyle('display', 'block');
                    $("s-content").setStyle('display', 'block');
                });
                $("hidenoti").setStyle('display', 'none').addEvent("click", function() {
                    $("hidenoti").setStyle('display', 'none');
                    $("s-content").setStyle('display', 'none');
                });*/
                var gerente = new Request.HTML({
                    url: './GestionTransparente?action=ObtenerGerente',
                    onComplete: function(data) {
                        $("nombreGerente").empty().adopt(data);
                    }
                }).send();
            });
        </script>
        <title>Agenda Institucional</title>
    </head>
    <body>
        <%@include file="../jspf/cabecera.jspf"%>
        <div class="wrapper2">
            
            <div class="cuerpo">
                <div class="navegacion">
                    <h2>
                        <a href="./Inicio">Inicio</a> / <a href="./GestionTransparente">Gesti&oacute;n Transparente</a> / Agenda Institucional
                    </h2>
                </div>
                <div class="services text-center" id="serv">
                    <div class="gadget">
                         <div class="panel efecto">
                            <a href="./GestionTransparente?action=NormasDirectivas">
                                <div class="normas"></div>
                                <div class="descripcion" style="font-size:11px">Documentos Normativos y de Gestión</div>
                            </a>
                        </div>
                        <div class="panel efecto">
                            <a href="./GestionTransparente?action=PresupuestoFinanzas">
                                <div class="presupuesto"></div>
                                <div class="descripcion" style="font-size:11px">Presupuesto y Finanzas</div>
                            </a>
                        </div>
                        <div class="panel efecto">
                            <a href="./GestionTransparente?action=ProyectoInversion">
                                <div class="viaticos"></div>
                                <div class="descripcion" style="font-size:11px">Proyectos de Inversi&oacute;n</div>
                            </a>
                        </div>
                        <div class="panel efecto">
                            <a href="./GestionTransparente?action=RecursosHumanos">
                                <div class="rrhh"></div>
                                <div class="descripcion" style="font-size:11px">Recursos Humanos</div>
                            </a>
                        </div>
                        <div class="panel efecto">
                            <a href="./GestionTransparente?action=AdquisicionesContrataciones">
                                <div class="adquisiciones"></div>
                                <div class="descripcion" style="font-size:11px">Adquisiciones y Contrataciones </div>
                            </a>
                        </div>
                        
                        <div class="panel efecto active">
                                <div class="agenda"></div>
                                <div class="descripcion" style="font-size:11px">Agenda Institucional</div>
                        </div>
                        <div class="panel efecto">
                            <a href="./GestionTransparente?action=infoAdicional">
                                <div class="resoluciones"></div>
                                <div class="descripcion" style="font-size:11px">Informaci&oacute;n Adicional</div>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="cdesk" >
                    <div class="sliderPanel">
                        <h2 id="st1">Agenda Institucional - Gerencia General</h2>
                        <div id="sp1">
                            <div class="jp-agenda">
                                <div id="fechaGerencia" class="agenda"></div>
                                <div id="actividadGerencia" class="activity"></div>
                                <div id="imagenGerencia" class="imagen">
                                    <img id="photoGerencia" src="" class="foto" />
                                    <div id="descripcionGerencia" class="descripcion"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="sliderPanel">
                        <h2 id="st2">Agenda Institucional - Direcci&oacute;n de Infraestructura</h2>
                        <div id="sp2">
                            <div class="jp-agenda">
                                <div id="fechaInfraestructura" class="agenda"></div>
                                <div id="actividadInfraestructura" class="activity"></div>
                                <div id="imagenInfraestructura" class="imagen">
                                    <img id="photoInfraestructura" src="" class="foto" />
                                    <div id="descripcionInfraestructura" class="descripcion"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="sliderPanel">
                        <h2 id="st3">Agenda Institucional - Direcci&oacute;n de Desarrollo Agropecuario</h2>
                        <div id="sp3">
                            <div class="jp-agenda">
                                <div id="fechaAgropecuario" class="agenda"></div>
                                <div id="actividadAgropecuario" class="activity"></div>
                                <div id="imagenAgropecuario" class="imagen">
                                    <img id="photoAgropecuario" src="" class="foto" />
                                    <div id="descripcionAgropecuario" class="descripcion"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="sliderPanel">
                        <h2 id="st4">Agenda Institucional - Direcci&oacute;n de Manejo Ambiental</h2>
                        <div id="sp4">
                            <div class="jp-agenda">
                                <div id="fechaAmbiental" class="agenda"></div>
                                <div id="actividadAmbiental" class="activity"></div>
                                <div id="imagenAmbiental" class="imagen">
                                    <img id="photoAmbiental" src="" class="foto" />
                                    <div id="descripcionAmbiental" class="descripcion"></div>
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
