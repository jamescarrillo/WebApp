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

        <script src="resources/js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>

        <!-- /container -->
        <script src="resources/js/vendor/jquery-1.11.1.min.js"></script>
        <script src="resources/js/vendor/bootstrap.min.js"></script>

        <script src="resources/js/plugins.js"></script>
        <!-- SLIDER REVOLUTION 4.x SCRIPTS  -->

        <script type="text/javascript" src="resources/rs-plugin/js/jquery.themepunch.plugins.min.js"></script>
        <script type="text/javascript" src="resources/rs-plugin/js/jquery.themepunch.revolution.min.js"></script>

        <script src="resources/js/wow.min.js"></script>
        <script src="resources/js/waypoints.min.js"></script>
        <script src="resources/js/jquery.counterup.min.js"></script>
        <script type="text/javascript" src="resources/js/jquery.nicescroll.min.js"></script>
        <script src="resources/js/bootstrap-progressbar.min.js"></script>
        <script src="resources/js/bxslider/jquery.bxslider.js"></script>
        <script src="resources/js/chocolat/js/jquery.chocolat.js"></script>






        <script>
            /*jQuery(window).load(function(){
             jQuery('.preload').remove();
             wow = new WOW(
             {
             animateClass: 'animated',
             offset:       70,
             }
             );
             wow.init();
             });*/
            jQuery.noConflict();
            jQuery(document).ready(function () {
                jQuery('.preload').remove();
                wow = new WOW(
                        {
                            animateClass: 'animated',
                            offset: 70,
                        }
                );
                wow.init();
                jQuery("body,html").niceScroll({
                    cursorwidth: "8px",
                    cursorminheight: 75
                });

                jQuery('.bx-carrusel3').bxSlider({
                    auto: true,
                    slideWidth: 262,
                    minSlides: 2,
                    maxSlides: 4,
                    slideMargin: 0,
                    pager: false,
                    autoHover: true,
                    moveSlides: 1,
                });
                //barra de progreso cv
                jQuery('.progress .progress-bar').progressbar({
                    transition_delay: 1000,
                    refresh_speed: 10,
                });
                //contador cv
                jQuery('.counter-p').counterUp({
                    delay: 10,
                    time: 1000
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
                //Enlaces
                jQuery.ajax({
                    url: './Enlace',
                    dataType: 'json',
                    success: function (response) {
                        jQuery(response.items).each(function (index, data) {
                            jQuery(".pnlEnlaces").append('<div class="slide"><a href="' + data.url + '" target="_blank" title="' + data.descripcion + '"><img src="resources/images/logo/' + data.logo + '" alt=""></a></div>');
                        });
                        jQuery('.bx-carrusel2').bxSlider({
                            auto: true,
                            slideWidth: 156,
                            minSlides: 1,
                            maxSlides: 7,
                            slideMargin: 5,
                            pager: false,
                            autoHover: true,
                            moveSlides: 1,
                            speed: 500
                        });
                    }
                });

            });


        </script>

        <title>Mapa de Sitio</title>
        <style>
            #sp1 ul {
                margin-left: 20px;
                margin-bottom: 20px;
                font-weight: bold;
            }
            #sp1 ul ul {
                font-weight: normal;
                margin-bottom: 0px;
            }
            #sp1 ul li {
                line-height: 1.8em; 
                border-bottom: 1px dotted rgb(27, 29, 26);
            }

            #sp1 ul li a{
                text-decoration: none;
                display: inline-block;

            }
            .link-text{
                color: #212121;
                width: 80%;
            }            
        </style>
    </head>
    <body>

        <%@include file="../jspf/cabecera.jspf" %>

        <div class="wrapper2">
            <div class="cdesk" id="cdesk">
                <div class="sliderPanel">
                    <div id="sp1" style="max-width: 930px;margin: 40px auto;  text-align: left;">
                        <h1 style="font-weight: 700; font-size: 18px; line-height: 1.2em; border-bottom: 1px dotted rgb(27, 29, 26); color:#0071bc; margin-bottom: 10px;">LA INSTITUCIÓN</h1> 
                        <ul>
                            <li><a class="link-text" href="./LaInstitucion?action=QuienesSomos">Quienes Somos</a> <a href="./LaInstitucion?action=QuienesSomos" class="green button" > ir allá </a></li>
                            <ul>
                                <li><a class="link-text" href="./LaInstitucion?action=QuienesSomos&tab=1" style="margin-right: -12px;">Base Legal</a> <a href="./LaInstitucion?action=QuienesSomos&tab=1" class="green button"  > ir allá </a></li>
                                <li><a class="link-text" href="./LaInstitucion?action=QuienesSomos&tab=2"style="margin-right: -12px;">Reseña Histórica</a> <a href="./LaInstitucion?action=QuienesSomos&tab=2" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./LaInstitucion?action=QuienesSomos&tab=3"style="margin-right: -12px;">Actualidad</a> <a href="./LaInstitucion?action=QuienesSomos&tab=3" class="green button" > ir allá </a></li>
                            </ul>
                            <li><a class="link-text" href="./LaInstitucion?action=Vision">Misión/Visión</a> <a href="./LaInstitucion?action=Vision" class="green button" > ir allá </a></li>
                            <ul>
                                <li><a class="link-text" href="./LaInstitucion?action=Vision&tab=1"style="margin-right: -12px;">Visión</a> <a href="./LaInstitucion?action=Vision&tab=1" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./LaInstitucion?action=Vision&tab=2"style="margin-right: -12px;">Misión</a> <a href="./LaInstitucion?action=Vision&tab=2" class="green button" > ir allá </a></li>
                            </ul>
                            <li><a class="link-text" href="./LaInstitucion?action=Objetivo">Objetivos/Funciones</a> <a href="./LaInstitucion?action=Objetivo" class="green button" > ir allá </a></li>
                            <ul>
                                <li><a class="link-text" href="./LaInstitucion?action=Objetivo&tab=1"style="margin-right: -12px;">Objetivos</a> <a href="./LaInstitucion?action=Objetivo&tab=1" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./LaInstitucion?action=Objetivo&tab=2"style="margin-right: -12px;">Funciones</a> <a href="./LaInstitucion?action=Objetivo&tab=2" class="green button" > ir allá </a></li>
                            </ul>
                            <li><a class="link-text" href="./LaInstitucion?action=Ubicacion">Ubicación</a> <a href="./LaInstitucion?action=Ubicacion" class="green button" > ir allá </a></li>
                            <li><a class="link-text" href="./LaInstitucion?action=Estructura">Estructura Orgánica</a> <a href="./LaInstitucion?action=Estructura" class="green button" > ir allá </a></li>
                            <li><a class="link-text" href="./LaInstitucion?action=Directorio">Directorio Telefónico</a> <a href="./LaInstitucion?action=Directorio" class="green button" > ir allá </a></li>
                            <ul>
                                <li><a class="link-text" href="./LaInstitucion?action=Directorio&tab=1" style="margin-right: -12px;">Directorio de Contactos </a> <a href="./LaInstitucion?action=Directorio&tab=1" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./LaInstitucion?action=Directorio&tab=2" style="margin-right: -12px;">Directorio Telefónico Interno</a> <a href="./LaInstitucion?action=Directorio&tab=2" class="green button" > ir allá </a></li>
                            </ul>
                        </ul>
                        <h1 style="font-weight: 700; font-size: 18px; line-height: 1.2em; border-bottom: 1px dotted rgb(27, 29, 26); color:#0071bc; margin-bottom: 10px;">GESTIÓN TRANSPARENTE</h1> 
                        <ul>
                            <li><a class="link-text" href="./GestionTransparente?action=NormasDirectivas">Documentos Normativos y de Gestión</a> <a href="./GestionTransparente?action=NormasDirectivas" class="green button" > ir allá </a></li>
                            <ul>
                                <li><a class="link-text" href="./GestionTransparente?action=NormasDirectivas&tab=1" style="margin-right: -12px;">Resoluciones Gerenciales</a> <a href="./GestionTransparente?action=NormasDirectivas&tab=1" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./GestionTransparente?action=NormasDirectivas&tab=5" style="margin-right: -12px;">Actas de Sesión de Consejo Directivo</a> <a href="./GestionTransparente?action=NormasDirectivas&tab=5" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./GestionTransparente?action=NormasDirectivas&tab=2" style="margin-right: -12px;">Documentos de Gestión</a> <a href="./GestionTransparente?action=NormasDirectivas&tab=2" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./GestionTransparente?action=NormasDirectivas&tab=3" style="margin-right: -12px;">Normas y Directivas</a> <a href="./GestionTransparente?action=NormasDirectivas&tab=3" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./GestionTransparente?action=NormasDirectivas&tab=4" style="margin-right: -12px;">Indicadores de Desempeño</a> <a href="./GestionTransparente?action=NormasDirectivas&tab=4" class="green button" > ir allá </a></li>

                            </ul>
                            <li><a class="link-text" href="./GestionTransparente?action=PresupuestoFinanzas">Presupuestos y Finanzas</a> <a href="./GestionTransparente?action=PresupuestoFinanzas" class="green button" > ir allá </a></li>
                            <ul>
                                <li><a class="link-text" href="./GestionTransparente?action=PresupuestoFinanzas&tab=1" style="margin-right: -12px;">Presupuesto Institucional de Apertura (PIA) y Presupuesto Institucional Modificado (PIM)</a> <a href="./GestionTransparente?action=PresupuestoFinanzas&tab=1" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./GestionTransparente?action=PresupuestoFinanzas&tab=2" style="margin-right: -12px;">Información Financiera</a> <a href="./GestionTransparente?action=PresupuestoFinanzas&tab=2" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./GestionTransparente?action=PresupuestoFinanzas&tab=3" style="margin-right: -12px;">Información Presupuestal</a> <a href="./GestionTransparente?action=PresupuestoFinanzas&tab=3" class="green button" > ir allá </a></li>
                            </ul>
                            <li><a class="link-text" href="./GestionTransparente?action=ProyectoInversion">Proyectos de Inversión</a> <a href="./GestionTransparente?action=ProyectoInvtoFinanzas"  class="green button" > ir allá </a></li>
                            <li><a class="link-text" href="./GestionTransparente?action=RecursosHumanos">Recursos Humanos</a> <a href="./GestionTransparente?action=RecursosHumanos" class="green button" > ir allá </a></li>
                            <ul>
                                <li><a class="link-text" href="./GestionTransparente?action=RecursosHumanos&tab=4" style="margin-right: -12px;">Plan Gerencial y Directivos</a> <a href="./GestionTransparente?action=RecursosHumanos&tab=4" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./GestionTransparente?action=RecursosHumanos&tab=5" style="margin-right: -12px;">Consejo Directivo</a> <a href="./GestionTransparente?action=RecursosHumanos&tab=5" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./GestionTransparente?action=RecursosHumanos&tab=6" style="margin-right: -12px;">Remuneración por Categorías</a> <a href="./GestionTransparente?action=RecursosHumanos&tab=6" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./GestionTransparente?action=RecursosHumanos&tab=1" style="margin-right: -12px;">Personal y Remuneraciones - Régimen Lab. D.L. 728</a> <a href="./GestionTransparente?action=RecursosHumanos&tab=1" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./GestionTransparente?action=RecursosHumanos&tab=2" style="margin-right: -12px;">Personal y Remuneraciones - Contrato por Locación de Servicios</a> <a href="./GestionTransparente?action=RecursosHumanos&tab=2" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./GestionTransparente?action=RecursosHumanos&tab=3" style="margin-right: -12px;">Personal y Remuneraciones - Contrato Administrativo de Servicios</a> <a href="./GestionTransparente?action=RecursosHumanos&tab=3" class="green button" > ir allá </a></li>
                            </ul>
                            <li><a class="link-text" href="./GestionTransparente?action=AdquisicionesContrataciones">Adquisiciones y Contratos</a> <a href="./GestionTransparente?action=AdquisicionesContrataciones" class="green button" > ir allá </a></li>
                            <ul>
                                <li><a class="link-text" href="./GestionTransparente?action=AdquisicionesContrataciones&tab=12" style="margin-right: -12px;">PAC y Modificatorias</a> <a href="./GestionTransparente?action=AdquisicionesContrataciones&tab=12" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./GestionTransparente?action=AdquisicionesContrataciones&tab=1" style="margin-right: -12px;">Ordenes de Compra de Bienes</a> <a href="./GestionTransparente?action=AdquisicionesContrataciones&tab=1" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./GestionTransparente?action=AdquisicionesContrataciones&tab=2" style="margin-right: -12px;">Ordenes de Servicios</a> <a href="./GestionTransparente?action=AdquisicionesContrataciones&tab=2" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./GestionTransparente?action=AdquisicionesContrataciones&tab=3" style="margin-right: -12px;">Gastos en Publicidad</a> <a href="./GestionTransparente?action=AdquisicionesContrataciones&tab=3" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./GestionTransparente?action=AdquisicionesContrataciones&tab=4" style="margin-right: -12px;">Gastos en Telefonía</a> <a href="./GestionTransparente?action=AdquisicionesContrataciones&tab=4" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./GestionTransparente?action=AdquisicionesContrataciones&tab=5" style="margin-right: -12px;">Uso de Vehículos</a> <a href="./GestionTransparente?action=AdquisicionesContrataciones&tab=5" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./GestionTransparente?action=AdquisicionesContrataciones&tab=6" style="margin-right: -12px;">Principales Proveedores</a> <a href="./GestionTransparente?action=AdquisicionesContrataciones&tab=6" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./GestionTransparente?action=AdquisicionesContrataciones&tab=7" style="margin-right: -12px;">Viáticos y Pasajes</a> <a href="./GestionTransparente?action=AdquisicionesContrataciones&tab=7" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./GestionTransparente?action=AdquisicionesContrataciones&tab=8" style="margin-right: -12px;">Penalidades Aplicadas </a> <a href="./GestionTransparente?action=AdquisicionesContrataciones&tab=8" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./GestionTransparente?action=AdquisicionesContrataciones&tab=9" style="margin-right: -12px;">Monto de liquidación final de Obra</a> <a href="./GestionTransparente?action=AdquisicionesContrataciones&tab=9" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./GestionTransparente?action=AdquisicionesContrataciones&tab=10" style="margin-right: -12px;">Monto Adicionales de las Obras</a> <a href="./GestionTransparente?action=AdquisicionesContrataciones&tab=10" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./GestionTransparente?action=AdquisicionesContrataciones&tab=11" style="margin-right: -12px;">Informes de Supervisión de Contratos</a> <a href="./GestionTransparente?action=AdquisicionesContrataciones&tab=11" class="green button" > ir allá </a></li>
                            </ul>
                            <li><a class="link-text" href="./GestionTransparente?action=AgendaInstitucional">Agenda Institucional</a> <a href="./GestionTransparente?action=AgendaInstitucional" class="green button" > ir allá </a></li>
                            <ul>
                                <li><a class="link-text" href="./GestionTransparente?action=AgendaInstitucional&tab=1" style="margin-right: -12px;">Agenda Institucional - Gerencia General</a> <a href="./GestionTransparente?action=AgendaInstitucional&tab=1" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./GestionTransparente?action=AgendaInstitucional&tab=2" style="margin-right: -12px;">Agenda Institucional - Dirección de Infraestructura</a> <a href="./GestionTransparente?action=AgendaInstitucional&tab=2" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./GestionTransparente?action=AgendaInstitucional&tab=3" style="margin-right: -12px;">Agenda Institucional - Dirección de Desarrollo Agropecuario</a> <a href="./GestionTransparente?action=AgendaInstitucional&tab=3" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./GestionTransparente?action=AgendaInstitucional&tab=4" style="margin-right: -12px;">Agenda Institucional - Dirección de Manejo Ambiental</a> <a href="./GestionTransparente?action=AgendaInstitucional&tab=4" class="green button" > ir allá </a></li>
                            </ul>

                            <li><a class="link-text" href="./GestionTransparente?action=infoAdicional">Información Adicional</a> <a href="./GestionTransparente?action=infoAdicional" class="green button" > ir allá </a></li>
                            <ul>
                                <li><a class="link-text" href="./GestionTransparente?action=infoAdicional&tab=1" style="margin-right: -12px;">Recomendaciones de los informes de auditoría orientadas al mejoramiento de la gestión</a> <a href="./GestionTransparente?action=infoAdicional&tab=1" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./GestionTransparente?action=infoAdicional&tab=2" style="margin-right: -12px;">Evaluación del cumplimiento de actualización del Portal</a> <a href="./GestionTransparente?action=infoAdicional&tab=2" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./GestionTransparente?action=infoAdicional&tab=3" style="margin-right: -12px;">Laudos </a> <a href="./GestionTransparente?action=infoAdicional&tab=3" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./GestionTransparente?action=infoAdicional&tab=4" style="margin-right: -12px;">Actas de conciliación </a> <a href="./GestionTransparente?action=infoAdicional&tab=4" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./GestionTransparente?action=infoAdicional&tab=5" style="margin-right: -12px;">Declaraciones juradas de ingresos, bienes y rentas  </a> <a href="./GestionTransparente?action=infoAdicional&tab=5" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./GestionTransparente?action=infoAdicional&tab=6" style="margin-right: -12px;">Informes Técnicos Previos de Evaluación de Software  </a> <a href="./GestionTransparente?action=infoAdicional&tab=6" class="green button" > ir allá </a></li>
                            </ul>
                        </ul>
                        <h1 style="font-weight: 700; font-size: 18px; line-height: 1.2em; border-bottom: 1px dotted rgb(27, 29, 26); color:#0071bc; margin-bottom: 10px;">CONVOCATORIAS</h1> 
                        <ul>
                            <li><a class="link-text" href="./ConvocatoriaPers?action=ConvocatoriaPers">Convocatoria de Personal</a> <a href="./ConvocatoriaPers?action=ConvocatoriaPers" class="green button" > ir allá </a></li>
                            <li><a class="link-text" href="./Convocatorias?action=convocatoria">Convocatoria Bienes/Servicios/Obras</a> <a href="./Convocatorias?action=convocatoria" class="green button" > ir allá </a></li>
                            <ul>
                                <li><a class="link-text" href="./Convocatorias?action=Comites" style="margin-right: -12px;">Comités de Contrataciones</a> <a href="./Convocatorias?action=Comites" class="green button" > ir allá </a></li>
                                <li><a class="link-text" href="./Convocatorias?action=Exonerado" style="margin-right: -12px;">Procesos Exonerados</a> <a href="./Convocatorias?action=Exonerado" class="green button" > ir allá </a></li>
                            </ul>
                        </ul>
                        <h1 style="font-weight: 700; font-size: 18px; line-height: 1.2em; border-bottom: 1px dotted rgb(27, 29, 26); color:#0071bc; margin-bottom: 10px;"> PUBLICACIONES</h1> 
                        <ul>
                            <li><a class="link-text" href="./Publicaciones?action=NotaPrensa">Noticia/Nota Prensa</a> <a href="./Publicaciones?action=NotaPrensa" class="green button" > ir allá </a></li>
                            <li><a class="link-text" href="./Publicaciones?action=NoticiasMultimedia">Noticias Multimedia</a> <a href="./Publicaciones?action=NoticiasMultimedia" class="green button" > ir allá </a></li>
                            <li><a class="link-text" href="./Publicaciones?action=MemoriasAnuales">Memorias Anuales</a> <a href="./Publicaciones?action=MemoriasAnuales" class="green button" > ir allá </a></li>
                            <li><a class="link-text" href="./Publicaciones?action=Comunicados">Comunicados</a> <a href="./Publicaciones?action=Comunicados" class="green button" > ir allá </a></li>

                            <li><a class="link-text" href="./Publicaciones?action=OtrasPublicaciones">Otras Publicaciones</a> <a href="./Publicaciones?action=OtrasPublicaciones" class="green button" > ir allá </a></li>
                        </ul>
                        <h1 style="font-weight: 700; font-size: 18px; line-height: 1.2em; border-bottom: 1px dotted rgb(27, 29, 26); color:#0071bc; margin-bottom: 10px;">PARTICIPACIÓN CIUDADANA</h1> 
                        <ul>
                            <li><a class="link-text" href="./Servicios">Mis Servicios</a> <a href="./Servicios" class="green button" > ir allá </a></li>
                            <li><a class="link-text" href="./ParticipacionCiudadana?action=AccesoInformacion">Acceso a la Información</a> <a href="./ParticipacionCiudadana?action=AccesoInformacion" class="green button" > ir allá </a></li>
                            <li><a class="link-text" href="./ParticipacionCiudadana?action=LibroReclamaciones">Libro de Reclamaciones</a> <a href="./ParticipacionCiudadana?action=LibroReclamaciones" class="green button" > ir allá </a></li>
                            <li><a class="link-text" href="./ParticipacionCiudadana?action=Consultas">Consultas y Sugerencias</a> <a href="./ParticipacionCiudadana?action=Consultas" class="green button" > ir allá </a></li>
                            <li><a class="link-text" href="./ParticipacionCiudadana?action=PortalTransparencia">Portal de Transparencia</a> <a href="./ParticipacionCiudadana?action=PortalTransparencia" class="green button" > ir allá </a></li>
                        </ul>

                    </div>
                </div>
            </div>

        </div>
        <%@include file="../jspf/pie.jspf" %>
    </body>
</html>
