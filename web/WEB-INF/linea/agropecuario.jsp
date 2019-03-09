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

        <link rel="stylesheet" href="http://ofi5.mef.gob.pe/wp/css/cupertino/jquery-ui-1.10.4.custom.min.css">
        <link rel="stylesheet" href="http://ofi5.mef.gob.pe/wp/css/ui.jqgrid.css">

        <script src="resources/js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>

        <!-- /container -->
        <script src="resources/js/vendor/jquery-1.11.1.min.js"></script>
        <script src="http://code.jquery.com/jquery-migrate-1.2.1.js"></script>
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

        <script src="http://ofi5.mef.gob.pe/wp/js/jquery-ui-1.10.4.custom.min.js"></script>
        <script src="http://ofi5.mef.gob.pe/wp/js/ui/i18n/jquery1.10.4-ui-i18n.min.js"></script>
        <script src="http://ofi5.mef.gob.pe/wp/js/grid.locale-es.js"></script>
        <script src="http://ofi5.mef.gob.pe/wp/js/jquery.jqGrid.min.js"></script>

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
                jQuery.ajax({
                    url: './Obra?action=ListarAnhos&area=1',
                    dataType: 'html',
                    success: function (response) {
                        jQuery("#obraAnho").html(response);
                        cargarObras();
                    }
                });
                //Eventos
                jQuery.ajax({
                    url: './Evento?action=EventoForWeb&area=3',
                    dataType: 'json',
                    success: function (response) {
                        jQuery(response.items).each(function (index, data) {
                            jQuery(".pnlEventos").append('<div class="slide box-img"><a  title=""><img style="height:200px" src="' + data.foto + '" alt="">'
                                    + '<div class="box-text-img">'
                                    + '<a target="_blank" href="' + data.link + '" style="padding-top:120px;" >Ver documento</a>'
                                    //+ '<a href="' + data.foto + '" class="chocolat-image ver-m">ver</a>'
                                    + '</div>'
                                    + '<p>' + data.titulo + '</p>'
                                    + '</a></div>');
                        });
                        jQuery('.bx-carrusel3').bxSlider({auto: true,
                            slideWidth: 262,
                            minSlides: 2,
                            maxSlides: 4,
                            slideMargin: 0,
                            pager: false,
                            autoHover: true,
                            moveSlides: 1,
                        });
                        jQuery('.pnlEventos').siblings('.bx-loading').hide(),
                                jQuery(function () {
                                    jQuery('.box-text-img').Chocolat({
                                        imageSize: 'contain'
                                    });
                                });
                    }});

                jQuery(document).on('click', '.btnPagina', function (e) {
                    e.preventDefault();
                    var pagina = jQuery(this).attr('pagina');
                    var start = pagina * parseInt(jQuery("#txtLimit").val());

                    jQuery("#txtCurrent").val(pagina);
                    jQuery("#txtStart").val(start);
                    cargarObras();
                });
                jQuery(".cambiar").on("change", function () {
                    cargarObras();
                });
                jQuery("#txtBuscador").on("keypress", function (e) {
                    if (e.keyCode == 13) {
                        cargarObras();
                    }
                });

                function cargarObras() {
                    //Obras
                    jQuery.ajax({
                        url: './Obra?action=ObraForWeb',
                        method: "get",
                        dataType: 'json',
                        data: {
                            start: jQuery("#txtStart").val(),
                            filtro: jQuery("#txtBuscador").val(),
                            limit: jQuery("#txtLimit").val(),
                            current: jQuery("#txtCurrent").val(),
                            anho: jQuery("#obraAnho").val(),
                            seguimiento: jQuery("#obraEstado").val(),
                            area: 3
                        },
                        success: function (response) {
                            jQuery('.pnlPaginacion').find('.pagination').html("");
                            jQuery(".pnlObras").html("");
                            if (response.total == 0) {
                                jQuery(".pnlObras").html('<div class="text-center alert alert-warning">No se encontraron resultados</div>');
                                return;
                            }


                            var paginaActual = parseInt(jQuery("#txtCurrent").val());
                            var totalItems = parseInt(response.total);
                            var ItemsPagina = parseInt(jQuery("#txtLimit").val());

                            var numeroPaginas = parseInt(totalItems / ItemsPagina);
                            if (numeroPaginas * ItemsPagina < totalItems) {
                                numeroPaginas++;
                            }

                            var anterior = paginaActual - 1;
                            var siguiente = paginaActual + 1;

                            if (anterior < 0) {
                                anterior = 0;
                            }
                            if (siguiente > (numeroPaginas - 1)) {
                                siguiente = numeroPaginas - 1;
                            }

                            var paginaInicio = paginaActual - 3;
                            var paginaFin = paginaActual + 4;

                            if (paginaInicio < 0) {
                                paginaInicio = 0;
                            }
                            if (paginaFin > numeroPaginas) {
                                paginaFin = numeroPaginas;
                            }

                            var htmlPaginacion = '<li><a href="#" pagina="' + parseInt(anterior) + '" class="btnPagina"><i class="fa fa-caret-left"></i></a></li>';

                            for (var i = paginaInicio; i < paginaFin; i++) {
                                var actual = ' class="btnPagina"';
                                if (paginaActual == i) {
                                    actual = ' class="active btnPagina"';
                                }
                                htmlPaginacion = htmlPaginacion + '<li><a href="#" pagina="' + parseInt(i) + '" ' + actual + ' >' + (i + 1) + '</a></li>';
                            }

                            htmlPaginacion = htmlPaginacion + '<li><a href="#" pagina="' + parseInt(siguiente) + '" class="btnPagina"><i class="fa fa-caret-right"></i></a></li>';


                            jQuery('.pnlPaginacion').find('.pagination').html(htmlPaginacion);

                            jQuery(response.items).each(function (index, data) {
                                var avanceFinanciero = parseInt((data.montoGastado * 100) / data.montoInversion);
                                jQuery(".pnlObras").append('<div class="col-md-12 pa-b-t bg1 b-t-f wow fadeInUp" data-wow-duration=".8s" data-wow-delay=".5s">'
                                        + '<div class="container">'
                                        + '<div class="row">'
                                        + '<div class="col-xs-4"><img src="' + data.foto + '" alt="" class="full-width obra-img" style="max-height:200px;"><p style="text-align:center;">'+data.leyenda+'</p></div>'
                                        + '<div class="col-xs-6 text-obra">'
                                        + '<h4 style="text-align:justify;">' + data.descripcion + ' </h4>'
                                        + '<table class="table">'
                                        + '<tr>'
                                        + '<td class="text-b-m">Monto de la Inversion</td>'
                                        + '<td class="num-text">S/. ' + data.montoInversion + '</td>'
                                        + '</tr>'
                                        + '<tr>'
                                        + '<td class="text-b-m">Avance Físico</td>'
                                        + ' <td>'
                                        + '<span class="min-progre"><span class="counter- p">' + data.avanceFisico + '</span>%</span>'
                                        + '<div class="progress prog">'
                                        + '<div class="progress-bar" role="progressbar" data-transitiongoal="' + data.avanceFisico + '" aria-valuemin="0" aria-valuemax="100" style="width: ' + data.avanceFisico + '%;">'
                                        + '</div>'
                                        + '</div>'
                                        + '</td>'
                                        + '</tr>'
                                        + '<tr>'
                                        + '<td class="text-b-m">Avance Financiero</td>'
                                        + '<td>'
                                        + '<span class="min-progre"><span class="counter-p">' + avanceFinanciero + '</span>%</span>'
                                        + '<div class="progress prog">'
                                        + '<div  class="progress-bar" role="progressbar" data-transitiongoal="' + avanceFinanciero + '" aria-valuemin="0" aria-valuemax = "100" style="width: ' + avanceFinanciero + '%;">'
                                        + '</div>'
                                        + '</div>'
                                        + '</td>'
                                        + '</tr>'
                                        + '</table >'
                                        + '</div>'
                                        + '<div class="col-xs-2 fecha-m p">'
                                        + '<div class="text-fecha ">'
                                        + data.mesActualizacion +'-' + data.anhoActualizacion
                                        + '</div>'
                                        + '<a id="' + data.id + '" class="btnVer btn btn-block btn-tranps btn-celeste2">Ver detalle </a>'
                                        + '<a titulo="' + data.descripcion + '" id="' + data.galeria + '" class="btnGaleria btn btn-block btn-tranps btn-verde">Galería </a><div><a style="margin-top:5px;color:#fff;" target="_blank" href="' + data.infobras + '" class=" btn btn-block btn-tranps btn-verde">Link Infobras </a></div><div class="text-center" style="margin-top:10px;"><span class="fecha-obra" >' + data.seguimiento + '</span></div>'
                                        + '</div>'
                                        + '</div>'
                                        + '</div>'
                                        + '</div>'
                                        );
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

                            jQuery(".pnlObras .btnVer").unbind("click").on("click", function () {
                                var ik = jQuery(this).attr("id");
                                jQuery.ajax({
                                    url: './Obra?action=GetNoticeAlways',
                                    dataType: 'json',
                                    data: {
                                        id: ik
                                    },
                                    success: function (response) {
                                        var f1 = response.obra.fechaInicio.split("-");
                                        var f2 = response.obra.fechaFin.split("-");
                                        var avanceFinanciero = parseInt((response.obra.montoGastado * 100) / response.obra.montoInversion);
                                        jQuery("#descripcion").html(response.obra.descripcion);
                                        jQuery("#montoInversion").html("S/. " + response.obra.montoInversion);
                                        jQuery("#fechaInicio").html(f1[2] + "/" + f1[1] + "/" + f1[0]);
                                        jQuery("#fechaFin").html(f2[2] + "/" + f2[1] + "/" + f2[0]);
                                        jQuery("#seguimiento").html(response.obra.seguimiento);
                                        jQuery("#tiempoEjecucion").html(response.obra.tiempoEjecucion);
                                        jQuery("#modalidadEjecucion").html(response.obra.modalidadEjecucion);

                                        jQuery("#avanceFisico").html(response.obra.avanceFisico);
                                        jQuery("#avanceFisico").parent().parent().find(".progress-bar").attr("data-transitiongoal", response.obra.avanceFisico).css("width", response.obra.avanceFisico + "%");

                                        jQuery("#avanceFinanciero").html(avanceFinanciero);
                                        jQuery("#avanceFinanciero").parent().parent().find(".progress-bar").css("width", avanceFinanciero + "%");
                                        
                                        jQuery("#periodoActualizacion").html(response.obra.mesActualizacion +'-'+response.obra.anhoActualizacion);
                                        
                                        if (response.obra.snip != null && response.obra.snip.trim() != "") {
                                            jQuery("#snip").parent().show();
                                            jQuery("#snip").html(response.obra.snip);
                                        } else {
                                            jQuery("#snip").parent().hide();
                                        }
                                        if (response.obra.observacion != null && response.obra.observacion.trim() != "") {
                                            jQuery("#observacion").parent().show();
                                            jQuery("#observacion").html(response.obra.observacion);
                                        } else {
                                            jQuery("#observacion").parent().hide();
                                        }
                                        jQuery("#leyenda").html(response.obra.leyenda);


                                        jQuery("#ubicacion").html(response.obra.ubicacion);
                                        if (response.obra.contratista != null && response.obra.contratista.trim() != "") {
                                            jQuery("#contratista").parent().show();
                                            jQuery("#contratista").html(response.obra.contratista);
                                        } else {
                                            jQuery("#contratista").parent().hide();
                                        }
                                        if (response.obra.supervisor != null && response.obra.supervisor.trim() != "") {
                                            jQuery("#supervisor").parent().show();
                                            jQuery("#supervisor").html(response.obra.supervisor);
                                        } else {
                                            jQuery("#supervisor").parent().hide();
                                        }
                                        if (response.obra.residente != null && response.obra.residente.trim() != "") {
                                            jQuery("#residente").parent().show();
                                            jQuery("#residente").html(response.obra.residente);
                                        } else {
                                            jQuery("#residente").parent().hide();
                                        }

                                        jQuery("#fechaEditado").html(response.obra.fechaEditado);
                                        jQuery("#foto").attr("src", response.obra.foto);

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

                                        jQuery("#modalVer").modal("show");
                                    }
                                });
                            });

                            jQuery(".pnlObras .btnGaleria").unbind("click").on("click", function () {
                                var ik = jQuery(this).attr("id");

                                jQuery("#modalGaleria").find("#descripcion").html(jQuery(this).attr("titulo"));
                                jQuery("#modalGaleria").modal("show");

                                var link = ik.substring(ik.lastIndexOf("/")+1, ik.length);
                               
                                var objeto= "<div style='position: relative; padding-bottom: 51%; height: 0; overflow: hidden;'><iframe id='iframe' src='//flickrit.com/slideshowholder.php?height=50&size=big&setId="+link+"&credit=2&thumbnails=1&transition=0&layoutType=responsive&sort=0' scrolling='no' frameborder='0'style='width:100%; height:100%; position: absolute; top:0; left:0;' ></iframe></div>"

                                jQuery('#galeriaFlickr').html(objeto);
                                
                                

                            });

                        }
                    });
                }
            });

        </script>
    </head>
    <body>

        <%@include file="../jspf/cabecera.jspf" %>

        <!-- slider -->
        <div class="page-slider bg-slider-main" style="background-image: url('resources/img/agropecuario.jpg')" >
            <div class="bg-n">
                <div class="container">
                    <div class="col-md-4 col-md-offset-8 text-center">
                        <img src="resources/img/agropecuario_i.png" alt="">
                        <h2>DIRECCI&Oacute;N DE DESARROLLO AGROPECUARIO</h2>
                    </div>
                </div>
            </div>
        </div>  
        <!-- SLIDE  -->
        <section class="main-menu-bar">
            <div class="container">
                <ol class="breadcrumb">
                    <li><a href="./">Inicio</a></li>
                    <li class="active">Dirección de Desarrollo Agropecuario</li>
                </ol>
            </div>
        </section>

        <section class="bg1">
            <div class="container">
                <div class="row">
                    <div class="col-md-9 text-center">
                        <h2 class="h2-title">Nuestras funciones</h2>
                        <ul class="box-funciones wow bounceIn" data-wow-duration="1s" data-wow-delay=".5s">
                            <li>Formular el Plan de Desarrollo Agropecuario en armon&iacute;a, con el plan integral de desarrollo del PEAM.</li>
                            <li>Programar, dirigir, ejecutar, supervisar y evaluar las acctividades y acciones para el cumplimiento de los planes anuales de desarrollo agropecuario del PEAM en funci&oacute;n a los recursos presupuestales que se designen.</li>
		            <li>Brindar asistencia t&eacute;cnica integral promoviendo la agro exportaci&oacute;n y agroindustria.</li>
                            <li>Coordinar con los dem&aacute;s &Oacute;rganos de L&iacute;nea de programaci&oacute;n y ejecuci&oacute;n de actividades tendentes al manejo y conservaci&oacute;n de los recursos naturales.</li>
                            <li>Coordinar con los Proyectos y Unidades Operativas del sector Agricultura y otras instituciones para planificar, programar y ejecutar acciones de desarrollo agropecuario.</li>
                            <li>Promover la formaci&oacute;n de organizaciones de base, fomentando la participaci&oacute;n de Genero y fortaleciendo su capacidad de autoayuda y gesti&oacute;n.</li>
			    <li>Formular y elaborar estudios de desarrollo agropecuario, as&iacute; como emitir opini&oacute;n cuando sea necesario o lo requieran las dem&aacute;s Direcciones de L&iacute;neas en coordinaci&oacute;n con la Gerencia General..</li>
                            <li>Evaluar el avance de las actividades y acciones a su cargo e informar a la Gerencia General.</li>
                        </ul>
                    </div>
                    <div class="col-md-3 wow slideInRight" data-wow-duration="1s" data-wow-delay=".6s">
                        <div class="box-service text-center b-sp">
                            <div class="agenda-figure">
                                <img src="resources/img/director_agropecuario.jpg" alt="">
                                <div class="agenda-text">
                                    <p>Ing. Luis Alberto Villavicencio Zuasnabar</p>
                                    <h3>Director de Desarrollo Agropecuario</h3>
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
                    <h2 class="h2-title">Últimas Obras y Proyectos</h2>
                </div>             
                <div class="col-md-12 bg3 form-page">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-3 form-horizontal text-right">
                                <div class="form-group">
                                    <label for="obraAnho" class="control-label">Año</label>
                                    <select id="obraAnho" class="form-control frm-2 cambiar"></select>
                                </div>
                            </div>
                            <div class="col-sm-1"></div>
                            <div class="col-xs-3 form-horizontal text-left">
                                <div class="form-group">
                                    <label for="obraEstado" class="control-label">Estado</label>
                                    <select id="obraEstado" class="form-control frm-2 cambiar">
                                        <option value="Todos">Todos</option>
                                        <option value="En Ejecucion">En Ejecucion</option>
                                        <option value="Finalizado">Finalizado</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-sm-1"></div>
                            <div class="col-xs-4 form-horizontal text-left">
                                <div class="form-group">
                                    <input type="text" class="form-control i-search" id="txtBuscador" placeholder="Buscar..." />
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="pnlObras row"></div>   
                <div class="container pnlPaginacion">
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
    <input type="hidden" id="txtLimit" value="3" />
    <input type="hidden" id="txtStart" value="0" />
    <input type="hidden" id="txtCurrent" value="0" />
    <div id="modalVer" class="modal fade" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-lg">
            <div class="modal-content"> 
                <div class="modal-header"> 
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button> 
                    <h4 class="modal-title text-obra" id="descripcion"></h4> 
                </div> 
                <div class="modal-body"> 
                    <div class="row linea-obra">
                        <div class="col-sm-6">
                            <label class="col-sm-5 linea-obra">Monto de Inversión:</label>
                            <label class="col-sm-5 linea-obra text-bold" style="font-size: 1.3em;" id="montoInversion"></label>
                            <label class="col-sm-5 linea-obra">Fecha de Inicio:</label>
                            <label class="col-sm-5 linea-obra fecha-obra" id="fechaInicio"></label>
                            <label class="col-sm-5 linea-obra">Fecha de Finalización:</label>
                            <label class="col-sm-5 linea-obra fecha-obra" id="fechaFin"></label>
                            <label class="col-sm-5 linea-obra">Tiempo Ejecución:</label>
                            <label class="col-sm-5 linea-obra" ><span id="tiempoEjecucion"></span> días</label>
                            <label class="col-sm-5 linea-obra">Modalidad de Ejecución:</label>
                            <label class="col-sm-5 linea-obra" id="modalidadEjecucion"></label>
                        </div>
                        <div class="col-sm-6">
                            <div class="text-center"><label class="seguimiento-obra" id="seguimiento"></label></div>
                            <table class="table">
                                <tbody>                            
                                    <tr>
                                        <td class="text-b-m">Avance Físico</td>
                                        <td>
                                            <span class="min-progre"><span class="counter-p" id="avanceFisico"></span>%</span>
                                            <div class="progress prog">
                                                <div class="progress-bar" role="progressbar" data-transitiongoal="" aria-valuemin="0" aria-valuemax="100" >
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="text-b-m">Avance Financiero</td>
                                        <td>
                                            <span class="min-progre"><span class="counter-p" id="avanceFinanciero"></span>%</span>
                                            <div class="progress prog">
                                                <div class="progress-bar" role="progressbar" data-transitiongoal="" aria-valuemin="0" aria-valuemax="100" >
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>  
                        </div>                       
                    </div>
                     <div class="row linea-obra">
                        <label class="col-sm-2">SNIP</label>
                        <label class="col-sm-10" id="snip"></label>
                    </div>
                    <div class="row linea-obra">
                        <label class="col-sm-2">Ubicación:</label>
                        <label class="col-sm-10" id="ubicacion"></label>
                    </div>
                    <div class="row linea-obra">
                        <label class="col-sm-2">Contratista:</label>
                        <label class="col-sm-10" id="contratista"></label>
                    </div>
                    <div class="row linea-obra">
                        <label class="col-sm-2">Supervisor:</label>
                        <label class="col-sm-10" id="supervisor"></label>
                    </div>
                    <div class="row linea-obra">
                        <label class="col-sm-2">Residente:</label>
                        <label class="col-sm-10" id="residente"></label>
                    </div>
                    <div class="row linea-obra">
                        <label class="col-sm-2">Observación:</label>
                        <label class="col-sm-10" id="observacion"></label>
                    </div>
                    <div class="row text-bold ">
                        <div class="col-sm-12" style="text-align: right;padding-right: 30px;color: #29a9e0;"><span>Actualización: <span id="periodoActualizacion"></span> - <span id="fechaEditado"></span></div>
                    </div>
                    <div class="row">
                        <div class="col-sm-3"></div>
                        <div><img id="foto" class="col-sm-6"/></div>
                        <div class="col-sm-12" style="text-align: center;" id="leyenda"></div>
                    </div>
                </div> 
            </div>
        </div>
    </div>
    <div id="modalGaleria" class="modal fade" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-lg">
            <div class="modal-content"> 
                <div class="modal-header"> 
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button> 
                    <h5 class="modal-title text-obra" id="descripcion"></h5> 
                </div> 
                <div class="modal-body"> 
                    <div style="width:100%;height:500px;text-align:center;margin:auto;" id="galeriaFlickr" >
                    </div>
                </div> 
            </div>
        </div>
    </div>
</body>
</html>