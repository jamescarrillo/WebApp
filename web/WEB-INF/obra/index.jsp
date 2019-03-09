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
                            jQuery(".pnlEstudios").append('<div class="col-md-12 pa-b-t bg1 b-t-f wow fadeInUp" data-wow-duration=".8s" data-wow-delay=".5s">'
                            +'<div class="container">'
                                +'<div class="row">'
                                    +'<div class="col-xs-4"><img src="'+data.foto+'" alt="" class="full-width obra-img"></div>'
                                    +'<div class="col-xs-6 text-obra">'
                                        +'<h4>'+data.descripcion+'</h4>'
                                        +'<table class="table">'
                                            +'<tr>'
                                                +'<td class="text-b-m">Monto de la Inversion</td>'
                                                +'<td class="num-text">S/. 10 500 000</td>'
                                            +'</tr>'
                                            +'<tr>'
                                                +'<td class="text-b-m">Avance Físico</td>'
                                               +' <td>'
                                                    +'<span class="min-progre"><span class="counter-p">70</span>%</span>'
                                                    +'<div class="progress prog">'
                                                        +'<div class="progress-bar" role="progressbar" data-transitiongoal="75" aria-valuemin="0" aria-valuemax="100">'
                                                        +'</div>'
                                                    +'</div>'
                                                +'</td>'
                                            +'</tr>'
                                            +'<tr>'
                                                +'<td class="text-b-m">Avance Financiero</td>'
                                                +'<td>'
                                                    +'<span class="min-progre"><span class="counter-p">90</span>%</span>'
                                                    +'<div class="progress prog">'
                                                        +'<div class="progress-bar" role="progressbar" data-transitiongoal="90" aria-valuemin="0" aria-valuemax="100">'
                                                        +'</div>'
                                                    +'</div>'
                                                +'</td>'
                                            +'</tr>'
                                        +'</table>'
                                    +'</div>'
                                    +'<div class="col-xs-2 fecha-mp">'
                                        +'<div class="text-fecha">'
                                            +'15/02/2015'
                                        +'</div>'
                                        +'<a href="#" class="btn btn-block btn-tranps btn-celeste2">Ver detalle </a>'
                                        +'<a href="#" class="btn btn-block btn-tranps btn-verde">Galería </a>'
                                    +'</div>'
                                +'</div>'
                            +'</div>'
                        +'</div>');
                        });
                        
                         //barra de progreso cv
                        jQuery('.progress .progress-bar').progressbar({
                            transition_delay: 1000,
                            refresh_speed: 10,
                        });

                    }
                });


                //Eventos
                jQuery.ajax({
                    url: './Evento?action=EventoForWeb&area=4',
                    dataType: 'json',
                    success: function (response) {
                        jQuery(response.items).each(function (index, data) {
                            jQuery(".pnlEventos").append('<div class="slide"><a  title=""><img src="' + data.foto + '" alt="">'
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
                            moveSlides: 1,
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
                        <img src="/resources/img/a.jpg" alt="">
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
                        <div class="spaci3"></div>
                        <ul class="box-funciones wow bounceIn" data-wow-duration="1s" data-wow-delay=".5s">
                            <li>El Gobierno Regional de San Martín a través su unidad ejecutora Proyecto Especial Alto Mayo, viene formulando el proyecto de inversión denominado</li>
                            <li>El Gobierno Regional de San Martín a través su unidad ejecutora Proyecto Especial Alto Mayo, viene formulando el proyecto de inversión denominado</li>
                        </ul>
                    </div>
                    <div class="col-md-3 wow slideInRight" data-wow-duration="1s" data-wow-delay=".6s">
                        <div class="box-service text-center b-sp">
                            <div class="agenda-figure">
                                <img src="resources/img/director_estudio.jpg" alt="">
                                <div class="agenda-text">
                                    <p>Nombre Apellidos del Director</p>
                                    <h3>Director Área de Estudios</h3>
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
                <div class="col-md-12 text-center">
                    <h2 class="h2-title">Estudios</h2>
                </div>
                <div class="col-md-12 bg3 form-page">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-4 form-horizontal text-right">
                                <div class="form-group">
                                    <label for="inputEmail3" class="control-label">Año</label>
                                    <select class="form-control frm-2">
                                        <option></option>
                                        <option>2015</option>
                                        <option>2016</option>
                                        <option>2017</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-xs-4 form-horizontal text-center">
                                <div class="form-group">
                                    <label for="inputEmail3" class="control-label">Mes</label>
                                    <select class="form-control frm-2">
                                        <option>Enero</option>
                                        <option>Febrero</option>
                                        <option>Marzo</option>
                                        <option>Abril</option>
                                        <option>Mayo</option>
                                        <option>Junio</option>
                                        <option>Julio</option>
                                        <option>Agosto</option>
                                        <option>Septiembre</option>
                                        <option>Octubre</option>
                                        <option>Noviembre</option>
                                        <option>Diembre</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-xs-4 form-horizontal text-left">
                                <div class="form-group">
                                    <label for="inputEmail3" class="control-label">Estado</label>
                                    <select class="form-control frm-2">
                                        <option></option>
                                        <option>Ejecución</option>
                                        <option>Activo</option>
                                        <option>Desactivado</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="pnlEstudios"></div>                
                <div class="container">
                    <div class="text-center pagi-bt">
                        <ul class="pagination pagination-sm">
                            <li><a href="#"><i class="fa fa-caret-left"></i></a></li>
                            <li><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#" class="active">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#"><i class="fa fa-caret-right"></i></a></li>
                        </ul>
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
</body>
</html>