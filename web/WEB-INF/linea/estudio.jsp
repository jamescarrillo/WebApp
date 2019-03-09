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
            jQuery.noConflict();
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


                //Estudios
                jQuery.ajax({
                    url: './Estudio?action=EstudioForWeb',
                    dataType: 'json',
                    success: function (response) {
                        jQuery(response.items).each(function (index, data) {
                            var f = data.fecha.split("-");
                            var bene = "";
                            if (data.cantidadBeneficiarios != undefined) {
                                bene = data.cantidadBeneficiarios;
                            }
                            jQuery(".pnlEstudios").append('<div class="col-md-12 pa-b-t bg1 b-t-f wow fadeInUp" data-wow-duration=".8s" data-wow-delay=".5s">'
                                    + '<div class="container">'
                                    + '<div class="row">'
                                    + '<div class="col-xs-6">'
                                    + '<h5 class="text-obra">' + data.titulo + '</h5>'
                                    + '<div><span class="col-sm-6" style="padding-left:0px;color:#f34a04;">' + f[2] + "/" + f[1] + "/" + f[0] + '</span><span class="col-sm-6 text-right">' + data.seguimiento + '</span></div>'
                                    + '<div>N° Beneficiarios: ' + bene + '</div>'
                                    + '<div style="font-family:segoeui;">' + data.objetivo + '</div>'
                                    + '<div class="col-sm-10" style="padding-left:0px;">' + data.lugar + '</div>'
                                    + '<div class="col-sm-2 pull-right"><a id="' + data.id + '" class="btnVer btn btn-tranps btn-celeste2" style="color:#fff;">Ver detalle </a></div>'
                                    + '</div>'
                                    + '<div class="col-xs-3"><img src="' + data.foto + '" alt="" class="full-width obra-img" style="max-height:150px;"></div>'
                                    + '<div class="col-xs-3">' + data.mapa + '</div>'
                                    + '</div>'
                                    + '</div>'
                                    + '</div>');

                        });

                        jQuery(".col-xs-3 iframe").attr({"width": "100%", "height": "150px"});

                        jQuery(".pnlEstudios .btnVer").on("click", function () {
                            var ik = jQuery(this).attr("id");
                            jQuery.ajax({
                                url: './Estudio?action=GetNoticeAlways',
                                dataType: 'json',
                                data: {
                                    id: ik
                                },
                                success: function (response) {
                                    var f = response.estudio.fecha.split("-");
                                    jQuery("#titulo").html(response.estudio.titulo);
                                    jQuery("#fecha").html(f[2] + "/" + f[1] + "/" + f[0]);
                                    jQuery("#seguimiento").html(response.estudio.seguimiento);
                                    jQuery("#snip").html(response.estudio.snip);
                                    jQuery("#objetivo").html(response.estudio.objetivo);
                                    jQuery("#cantidadBeneficiarios").html(response.estudio.cantidadBeneficiarios);
                                    jQuery("#caracteristicasBeneficiarios").html(response.estudio.caracteristicasBeneficiarios);
                                    jQuery("#lugar").html(response.estudio.lugar);
                                    jQuery("#foto").attr("src", response.estudio.foto);
                                    jQuery("#mapa").html(response.estudio.mapa).find("iframe").css("width", "100%");

                                    jQuery("#modalVer").modal("show");
                                }
                            });
                        });

                    }
                });


                //Eventos
                jQuery.ajax({
                    url: './Evento?action=EventoForWeb&area=4',
                    dataType: 'json',
                    success: function (response) {
                        jQuery(response.items).each(function (index, data) {
                            jQuery(".pnlEventos").append('<div class="slide box-img"><a  title=""><img style="height:200px" src="' + data.foto + '" alt="">'
                                    + '<div class="box-text-img">'
                                    + '<a href="' + data.foto + '" class="chocolat-image ver-m">ver</a>'
                                    + '</div>'
                                    + '<p>' + data.titulo + '</p>'
                                    + '</a></div>');
                        });
                        jQuery('.bx-carrusel3').bxSlider({
                            auto: true,
                            slideWidth: 262,
                            minSlides: 2,
                            maxSlides: 4,
                            slideMargin: 0,
                            pager: false,
                            autoHover: true,
                            moveSlides: 1
                        });
                        jQuery('.pnlEventos').siblings('.bx-loading').hide(),
                                jQuery(function () {
                                    jQuery('.box-text-img').Chocolat({
                                        imageSize: 'contain'
                                    });
                                });
                    }
                });

            });



        </script>
    </head>
    <body>

        <%@include file="../jspf/cabecera.jspf" %>

        <!-- slider -->
        <div class="page-slider bg-slider-main" style="background-image: url('resources/img/estudio.jpg')" >
            <div class="bg-n">
                <div class="container">
                    <div class="col-md-4 col-md-offset-8 text-center">
                        <img src="resources/img/estudio_i.png" alt="">
                        <h2>ÁREA DE ESTUDIOS</h2>
                    </div>
                </div>
            </div>
        </div>  
        <!-- SLIDE  -->
        <section class="main-menu-bar">
            <div class="container">
                <ol class="breadcrumb">
                    <li><a href="./">Inicio</a></li>
                    <li class="active">Área de Estudios</li>
                </ol>
            </div>
        </section>

        <section class="bg1">
            <div class="container">
                <div class="row">
                    <div class="col-md-9 text-center">
                        <h2 class="h2-title">Nuestras funciones</h2>
                        <ul class="box-funciones wow bounceIn" data-wow-duration="1s" data-wow-delay=".5s">
                            <li>Dirigir los estudios a nivel de perfil, pre factibilidad y factibilidad, según los lineamientos establecidos en las Directivas Generales del Sistema Nacional de Inversión Pública y sus modificatorias</li>
                            <li>Dirigir y supervisar la formulación, el seguimiento y la evaluación de los sistemas de planificación e inversión pública</li>
                            <li>Dirigir y supervisar el proceso de aplicación del sistema de inversión pública</li>
                            <li>Observar obligatoriamente los procedimientos establecidos en la normatividad vigente, para la declaración de viabilidad de los perfiles como requisito previo a su programación y ejecución</li>
                            <li>Supervisa la elaboración de los Planes de Desarrollo del ámbito de acción del proyecto: agroindustriales, de riego, de electrificación, viales, saneamiento, etc., concordantes con los Planes de Desarrollo Regional, Local, y Estratégico Institucional, con criterios de rentabilidad económica</li>
                            <li>Desarrollar las demás funciones de su competencia que le asigne la Oficina de Presupuesto, Planificación, Estudios y O.T.</li>
                        </ul>
                    </div>
                    <div class="col-md-3 wow slideInRight" data-wow-duration="1s" data-wow-delay=".6s">
                        <div class="box-service text-center b-sp">
                            <div class="agenda-figure">
                                <img src="resources/img/responsable_estudios.jpg" alt="">
                                <div class="agenda-text">
                                    <p>Adan Fabian Vergara</p>
                                    <h3>Responsable Área de Estudios</h3>
                                </div>
                            </div>
                            <div class="spaci-2"></div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section>
            <div>
                <div class="col-md-12 text-center" style="margin-top: 10px;">
                    <h2 class="h2-title">Últimos Estudios</h2>
                </div>                
                <div class="pnlEstudios row"></div> 
                <div class="col-md-12 text-center" style="margin-top: 10px;">
                    <h2 class="h2-title">Consultas</h2>
                </div>                
                <div class="pnlMef text-center row" style="padding-top: 30px;">
                    <div class="col-sm-6">
                        <a class="btn btn-tranps btn-verde" style="font-size: 1.5em;color: #fff;" href="http://ofi5.mef.gob.pe/sosem2/" target="_blank">Proyectos por código SNIP</a>
                    </div>
                    <div class="col-sm-6">
                        <a class="btn btn-tranps btn-verde" style="font-size: 1.5em;color: #fff;" href="http://ofi5.mef.gob.pe/wp/BusquedaAvanzada.aspx" target="_blank">Proyectos por unidad formuladora</a>
                    </div>
                </div>
            </div>
        </section>


        <section class="bg1">
            <div class="container">
                <!-- Example row of columns -->
                <div class="row">
                    <div class="col-md-12 text-center box-eventos wow fadeIn" data-wow-duration=".8s" data-wow-delay=".5s">
                        <h2 class="h2-title">Eventos</h2>
                        <ul class="bx-carrusel3 pnlEventos"></ul>
                    </div>
                </div>
            </div>
        </section>

    </div>      
    <%@include file="../jspf/pie.jspf" %>   
    <div id="modalVer" class="modal fade" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-lg">
            <div class="modal-content"> 
                <div class="modal-header"> 
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button> 
                    <h4 class="modal-title text-obra" id="titulo"></h4> 
                </div> 
                <div class="modal-body"> 
                    <div class="row linea-obra">
                        <label class="col-sm-2 fecha-obra" id="fecha"></label>
                        <label class="col-sm-1">SNIP:</label>
                        <label class="col-sm-1" id="snip"></label>
                        <label class="col-sm-5"></label>
                        <div class="col-sm-3 text-center"><label class=" seguimiento-obra" id="seguimiento"></label></div>
                    </div>
                    <div class="row linea-obra">
                        <label class="col-sm-2 text-bold">Lugar:</label><label class="col-sm-10" id="lugar"></label>
                    </div>
                    <div class="row linea-obra">
                        <label class="col-sm-2 text-bold">Objetivo:</label><label class="col-sm-10" id="objetivo"></label>
                    </div>
                    <div class="row linea-obra">
                        <label class="col-sm-2 text-bold">N° Beneficiarios:</label><label class="col-sm-10" id="cantidadBeneficiarios"></label>
                    </div>
                    <div class="row linea-obra">
                        <label class="col-sm-2 text-bold">Catacterísticas:</label>
                        <label class="col-sm-10 text-clean" id="caracteristicasBeneficiarios"></label>
                    </div>
                    <div class="row linea-obra">
                        <img class="col-sm-6" id="foto"  />
                        <div class="col-sm-6" id="mapa"></div>
                    </div>
                </div>
            </div>  </div>
    </div>
</body>
</html>