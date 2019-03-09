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
        <title>Proyecto Especial Alto Mayo</title>
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
            jQuery(document).ready(function() {
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
                jQuery("#scrollTop").click(function() {
                    jQuery("body,html").animate({
                        scrollTop: '0px'
                    }, 800);
                });
                jQuery(window).scroll(function() {
                    if (jQuery(this).scrollTop() > 0) {
                        jQuery("#scrollTop").slideDown(300);
                    }
                    else {
                        jQuery("#scrollTop").slideUp(300);
                    }
                });
                //Banner
                jQuery.get("./Destacado?action=DestacadoForWeb", function(response) {
                    jQuery(response.items).each(function(index, data) {
                        jQuery(".tp-banner ul").append('<li data-transition="fade" data-slotamount="7" data-masterspeed="500"  data-saveperformance="on"  data-title="Intro Slide">'
                                + '<img src="resources/images/dummy.png"  alt="slidebg1" data-lazyload="' + data.foto + '" data-bgposition="right top" data-kenburns="on" data-duration="16000" data-ease="Power0.easeInOut" data-bgfit="115" data-bgfitend="100" data-bgpositionend="center bottom">'
                                + '<div class="tp-caption light_heavy_40 customin fadeout tp-resizeme rs-parallaxlevel-10"'
                                + 'data-x="120" data-y="50" data-customin="x:0;y:0;z:0;rotationX:0;rotationY:0;rotationZ:0;scaleX:0;scaleY:0;skewX:0;skewY:0;opacity:0;transformPerspective:600;transformOrigin:50% 50%;"'
                                + 'data-speed="300" data-start="1000" data-easing="Power3.easeInOut" data-splitin="none" data-splitout="none" data-elementdelay="0.1" data-endelementdelay="0.1" data-endspeed="300"'
                                + 'style="z-index: 3; max-width: auto; max-height: auto; white-space: nowrap;">'
                                + '<h2 class="hidden-sm hidden-xs">' + wordWrap(data.titulo, 56) + '</h2>' + '<h2 class="visible-sm visible-xs">' + wordWrap(data.titulo, 23) + '</h2></div>'
                                + '<div class="tp-caption light_heavy_40 customin fadeout tp-resizeme rs-parallaxlevel-10"'
                                + 'data-x="120" data-y="180" data-customin="x:0;y:0;z:0;rotationX:0;rotationY:0;rotationZ:0;scaleX:0;scaleY:0;skewX:0;skewY:0;opacity:0;transformPerspective:600;transformOrigin:50% 50%;"'
                                + 'data-speed="300" data-start="2000" data-easing="Power3.easeInOut" data-splitin="none" data-splitout="none" data-elementdelay="0.1" data-endelementdelay="0.1" data-endspeed="300"'
                                + 'style="z-index: 3; max-width: auto; max-height: auto; white-space: nowrap;">'
                                + '<p>' + data.contenido + '</p></div>'
                                + '<div class="tp-caption light_heavy_40 customin fadeout tp-resizeme rs-parallaxlevel-10"'
                                + 'data-x="120" data-y="280" data-customin="x:0;y:0;z:0;rotationX:0;rotationY:0;rotationZ:0;scaleX:0;scaleY:0;skewX:0;skewY:0;opacity:0;transformPerspective:600;transformOrigin:50% 50%;"'
                                + 'data-speed="300" data-start="2500" data-easing="Power3.easeInOut" data-splitin="none" data-splitout="none" data-elementdelay="0.1" data-endelementdelay="0.1" data-endspeed="300"'
                                + 'style="z-index: 3; max-width: auto; max-height: auto; white-space: nowrap;">'
                                + '<a href="' + data.url + '" class="btn btn-naranja" style="color:#fff;"> Leer más </a></div>'
                                + '</li>');
                    });


                    function wordWrap(str, maxWidth) {
                        var newLineStr = "<br/>";
                        done = false;
                        res = '';
                        if (str.length > maxWidth) {
                            do {
                                found = false;
                                // Inserts new line at first whitespace of the line
                                for (i = maxWidth - 1; i >= 0; i--) {
                                    if (testWhite(str.charAt(i))) {
                                        res = res + [str.slice(0, i), newLineStr].join('');
                                        str = str.slice(i + 1);
                                        found = true;
                                        break;
                                    }
                                }
                                // Inserts new line at maxWidth position, the word is too long to wrap
                                if (!found) {
                                    res += [str.slice(0, maxWidth), newLineStr].join('');
                                    str = str.slice(maxWidth);
                                }

                                if (str.length < maxWidth) {
                                    done = true;
                                    res = res + str;
                                }
                            } while (!done);
                        }else{
                            res = str;
                        }
                        return res;
                    }

                    function testWhite(x) {
                        var white = new RegExp(/^\s$/);
                        return white.test(x.charAt(0));
                    }
                    ;

                    jQuery('.tp-banner').show().revolution(
                            {
                                dottedOverlay: "twoxtwo",
                                delay: 16000,
                                startwidth: 1170,
                                startheight: 350,
                                hideThumbs: 200,
                                thumbWidth: 100,
                                thumbHeight: 50,
                                thumbAmount: 5,
                                navigationType: "none",
                                navigationArrows: "solo",
                                navigationStyle: "preview",
                                touchenabled: "on",
                                onHoverStop: "on",
                                swipe_velocity: 0.7,
                                swipe_min_touches: 1,
                                swipe_max_touches: 1,
                                drag_block_vertical: false,
                                parallax: "mouse",
                                parallaxBgFreeze: "on",
                                parallaxLevels: [7, 4, 3, 2, 5, 4, 3, 2, 1, 0],
                                keyboardNavigation: "off",
                                navigationHAlign: "center",
                                navigationVAlign: "bottom",
                                navigationHOffset: 0,
                                navigationVOffset: 20,
                                soloArrowLeftHalign: "left",
                                soloArrowLeftValign: "center",
                                soloArrowLeftHOffset: 20,
                                soloArrowLeftVOffset: 0,
                                soloArrowRightHalign: "right",
                                soloArrowRightValign: "center",
                                soloArrowRightHOffset: 20,
                                soloArrowRightVOffset: 0,
                                shadow: 0,
                                fullWidth: "off",
                                fullScreen: "off",
                                spinner: "spinner4",
                                stopLoop: "off",
                                stopAfterLoops: -1,
                                stopAtSlide: -1,
                                shuffle: "off",
                                autoHeight: "off",
                                forceFullWidth: "off",
                                hideThumbsOnMobile: "off",
                                hideNavDelayOnMobile: 1500,
                                hideBulletsOnMobile: "off",
                                hideArrowsOnMobile: "off",
                                hideThumbsUnderResolution: 0,
                                hideSliderAtLimit: 0,
                                hideCaptionAtLimit: 0,
                                hideAllCaptionAtLilmit: 0,
                                startWithSlide: 0,
                                fullScreenOffsetContainer: ".header"
                            });
                });
                //Notas de Prensa
                jQuery.get("./Publicaciones?action=NotaPrensaForNotice", function(response) {
                    jQuery(response.items).each(function(index, data) {
                        jQuery(".pnlNoticias").append('       '
                                + '<div class="item">'
                                + '  <div class="row">'
                                + '      <div class="col-xs-6 sp-p">'
                                + '          <div class="img-noti-carusel">'
                                + '              <a href="./Publicaciones?action=PaginaNotaPrensaPrint&id=' + data.id + '"><img src="' + data.foto + '" alt="" class="full-width"></a>'
                                + '          </div>'
                                + '      </div>'
                                + '      <div class="col-xs-6">'
                                + '          <div class="mensaje-noti">'
                                + '            <h3>' + data.titulo.toUpperCase() + '</h3>'
                                + '            <p>' + data.contenido.substring(0, 300) + '...' + '</p>'
                                + '            <a href="./Publicaciones?action=PaginaNotaPrensaPrint&id=' + data.id + '" class="btn btn-naranja" style="color:#fff" target="_blank"> Ver Noticia </a>'
                                + '          </div>'
                                + '      </div>'
                                + '  </div>'
                                + '</div>');
                    });
                    jQuery(".pnlNoticias .item").eq(0).addClass("active");
                    jQuery(".pnlNoticias .item p").css({"text-decoration": "none", "font-weight": "normal", "font-size": "1em", "text-align": "justify"});
                    jQuery('#carousel-noticias').carousel();
                });
                //Agenda
                jQuery.get("./GestionTransparente?action=ObtenerGerente", function(response) {
                    jQuery("#gerente").html(response);
                });
                jQuery.ajax({
                    url: './GestionTransparente?action=LastAgendaInstitucional&tipo=1',
                    dataType: 'json',
                    success: function(response) {
                        if (response.agenda != null) {
                            jQuery(".agenda-mes").html(response.agenda.lugar)
                            jQuery(".agenda-dia").html(response.agenda.ciudad)
                            jQuery(".agenda-actividad").html(response.agenda.actividad)
                        }
                    }

                });
                //Galeria Final
                
                //Galeria
                
                var apiKey = '43635b83205357579f0b3da4d79feb48';
                var idUsuario = '83313636@N07';
                var idAlbum = '72157691821802514';

                jQuery.get("https://api.flickr.com/services/rest/?method=flickr.photosets.getPhotos&api_key=" + apiKey + "&photoset_id=" + idAlbum + "&user_id=" + idUsuario + "&format=rest&per_page=20&page=1&extras=url_c,url_m",
                        function(data) {
                            
                            var idx = 1;
                            var imgs = '';
                            
                            jQuery.each(jQuery(data).find('photo'), function(i, item) {
                                    
                                    var urlFoto = "https://www.flickr.com/photos/" + idUsuario + "/" + jQuery(item).attr('id') + "/in/album-" + idAlbum + "/";
                                    imgs = imgs + '<div class="box-img">'
                                            + '<img style="width:215px;height:125px;" src="' + jQuery(item).attr('url_m') + '" alt="">'
                                            + '<div class="box-text-img">'
                                            + '<a href="' + jQuery(item).attr('url_c') + '" class="chocolat-image ver-m">ver</a>'
                                            + '<a href="' + urlFoto + '" target="_blank" class="ver-mas-i" title="Imagen">'
                                            + '<i class="fa fa-plus"></i>  Ver Flickr'
                                            + '</a>'
                                            + '</div>'
                                            + '</div>';
                                    idx++;
                                    if (idx == 3) {
                                        imgs = '<div class="slide">' + imgs + '</div>';
                                        jQuery("#galeria").append(imgs);
                                        imgs = '';
                                        idx = 1;
                                    }

                            });
                            jQuery('.bx-carrusel').bxSlider({
                                slideWidth: 215,
                                minSlides: 2,
                                maxSlides: 5,
                                slideMargin: 10,
                                pager: false
                            });
                            jQuery(function() {
                                jQuery('.box-text-img').Chocolat({
                                    imageSize: 'contain'
                                });
                            });
                        }, "xml");
                        
                        
                //Videos
                jQuery.get("./Publicaciones?action=MultimediasForNotice&start=0&limit=2&current=0", function(response) {
                    jQuery(response.multimedia).each(function(index, data) {
                        jQuery(".pnlVideos").append('<div class="col-md-6">'
                                + '<div class="videoWrapper wow fadeInUp" data-duration=".5s">'
                                + '<a target="_blank" href="http://www.peam.gob.pe/Publicaciones?action=NoticiasMultimedia" class="ver-mas-v">'
                                + '<i class="fa fa-plus"></i>  Ver todos'
                                + '</a>'
                                + '<iframe width="560" height="349" src="' + data.fuente + '" frameborder="0" allowfullscreen></iframe>'
                                + '</div>'
                                + '<div class="spaci-2"></div> '
                                + '</div>');
                    });
                });
                jQuery(function() {
                    jQuery('.box-text-img').Chocolat({
                        imageSize: 'contain'
                    });
                });

                //Enlaces
                jQuery.ajax({
                    url: './Enlace',
                    dataType: 'json',
                    success: function(response) {
                        jQuery(response.items).each(function(index, data) {
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
    </head>
    <body>

        <%@include file="jspf/cabecera.jspf" %>

        <!-- slider -->
        <div class="tp-banner-container">
            <div class="tp-banner">
                <ul></ul>
                <div class="tp-bannertimer"></div>  
            </div>
        </div>  
        <!-- SLIDE  -->
        <section>
            <div class="container">
                <!-- Example row of columns -->
		<div class="centrar">
                    <div class="col-md-12 text-center">
                        <!-- <h2 class="h2-title">Destacados</h2> -->
                        <div class="centrar">
                            <div class="centrar">
                                <!-- 
				<a  href="./archivos/marcasm.rar" title="">
                                    <div class="col-md-12 text-center">
					<img src="resources/images/marcasm.png" alt="">
                                    </div>
                                </a>
				-->
                            </div>

                        </div>
                    </div>
                </div>
	
                <div class="row">
                    <div class="col-md-12 text-center">
                        <h2 class="h2-title">Nuestras L&iacute;neas de Acción</h2>
                        <div class="row">
                            <div class="col-md-3 col-xs-6 box-areas a-casa bounceInUp" data-wow-duration=".8s" data-wow-delay=".3s">
                                <a  href="./LineaAccion?action=DireccionInfraestructura" title="">
                                    <div class="box-areas-img">

                                    </div>
                                    <div class="box-areas-texto">
                                        DIRECCION DE <br>INFRAESTRUCTURA
                                    </div>
                                </a>
                            </div>

                            <div class="col-md-3 col-xs-6 box-areas a-planta bounceInUp" data-wow-duration="1s" data-wow-delay=".3s">
                                <a  href="./LineaAccion?action=DireccionManejoAmbiental" title="">
                                    <div class="box-areas-img">

                                    </div>
                                    <div class="box-areas-texto">
                                        DIRECCION DE <br>MANEJO AMBIENTAL
                                    </div>
                                </a>
                            </div>

                            <div class="col-md-3 col-xs-6 box-areas a-agro bounceInUp" data-wow-duration="1.2s" data-wow-delay=".3s">
                                <a  href="./LineaAccion?action=DireccionDesarrolloAgropecuario" title="">
                                    <div class="box-areas-img">

                                    </div>
                                    <div class="box-areas-texto">
                                        DIRECCION DE <br>DESARROLLO AGROPECUARIO
                                    </div>
                                </a>
                            </div>

                            <div class="col-md-3 col-xs-6 box-areas a-estu bounceInUp" data-wow-duration="1.4s" data-wow-delay=".3s">
                                <a href="./LineaAccion?action=AreaEstudios" title="">
                                    <div class="box-areas-img">

                                    </div>
                                    <div class="box-areas-texto">
                                        AREA DE <br>ESTUDIOS
                                    </div>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="bg1">
            <div class="container">                
                <div class="row">
                    <div class="col-md-9">
                        <h2 class="h2-title">Noticias</h2>
                        <div id="carruselnoticia" class="carousel slide photo_carousel2 wow fadeInUp" data-wow-duration=".8s" data-wow-delay=".3s" data-ride="carousel">
                            <div class="carousel-inner pnlNoticias">
                            </div>
                            <ol class="carousel-indicators">
                                <li data-target="#carruselnoticia" data-slide-to="0" class="active"></li>
                                <li data-target="#carruselnoticia" data-slide-to="1"></li>
                                <li data-target="#carruselnoticia" data-slide-to="2"></li>
                                <li data-target="#carruselnoticia" data-slide-to="3"></li>
                                <li data-target="#carruselnoticia" data-slide-to="4"></li>
                                <li data-target="#carruselnoticia" data-slide-to="5"></li>
                                <li data-target="#carruselnoticia" data-slide-to="6"></li>
                            </ol>
                        </div>
                    </div>
                    <div class="col-md-3 wow slideInRight agenda" data-wow-duration="1s" data-wow-delay=".7s">
                        <div class="box-p-l">
                            <h2 class="h2-title">Agenda</h2>
                            <div class="box-service text-center">
                                <div class="agenda-figure">
                                    <img src="resources/images/gerente2.jpg" alt="">
                                    <div class="agenda-text">
                                        <p id="gerente"></p>
                                        <h3>GERENTE GENERAL</h3>
                                    </div>
                                </div>
                                <div class="spaci-2"></div>
                                <div class="ag-calendario">
                                    <h3 class="agenda-mes"></h3>
                                    <span class="agenda-dia"></span>
                                </div>
                                <div class="text-left link-a">
                                    <p class="agenda-actividad"></p>
                                    <a href="./GestionTransparente?action=AgendaInstitucional" title="">Ver agenda</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section>
            <div class="container">
                <!-- Example row of columns -->
                <div class="row">
                    <div class="col-md-12 text-center">
                        <h2 class="h2-title">Favoritos</h2>
                        <p class="sub-title">Trabajamos más para servirte mejor.</p>
                    </div>
                    <div class="col-md-12">
                        <div class="row">
                            <div class="col-md-6">
                                <img src="resources/images/institucional.png" alt="" class="full-width b-bb">
                            </div>
                            <div class="col-md-6 row-table text-center">
                                <div class="col-md-4 col-xs-4 box-favoritos s-b-l i-tupac wow bounceIn" data-wow-duration=".5s" data-wow-delay=".3s">
                                    <div class="box-favorito-img"></div>
                                    <a href="./GestionTransparente?action=NormasDirectivas&tab=2&opcion=11" title="" class="btn btn-b-naranja clients">TUPA</a>
                                </div>
                                <div class="col-md-4 col-xs-4 box-favoritos i-etica wow bounceIn" data-wow-duration="1s" data-wow-delay=".3s">
                                    <div class="box-favorito-img"></div>
                                    <a href="./LaInstitucion?action=Etica" title="" class="btn btn-b-naranja clients">CÓDIGO DE ÉTICA</a>
                                </div>
                                <div class="col-md-4 col-xs-4 box-favoritos i-sisg wow bounceIn" data-wow-duration="1.4s" data-wow-delay=".3s">
                                    <div class="box-favorito-img"></div>
                                    <a href="http://doc.peam.gob.pe/sisgedo/app/main.php" target="_blank" title="" class="btn btn-b-naranja clients">SISGEDO</a>
                                </div>
                                <div class="col-md-4 col-xs-4 box-favoritos s-b-l b-t i-libro wow bounceIn" data-wow-duration="1.8s" data-wow-delay=".3s">
                                    <div class="box-favorito-img"></div>
                                    <a href="./ParticipacionCiudadana?action=LibroReclamaciones" title="" class="btn btn-b-naranja clients">LIBRO DE RECLAMACIONES</a>
                                </div>
                                <div class="col-md-4 col-xs-4 box-favoritos b-t i-solicitud wow bounceIn" data-wow-duration="2s" data-wow-delay=".3s">
                                    <div class="box-favorito-img"></div>
                                    <a href="./ParticipacionCiudadana?action=AccesoInformacion" title="" class="btn btn-b-naranja clients">SOLICITUD DE ACCESO A INFORMACIÓN</a>
                                </div>
                                <div class="col-md-4 col-xs-4 box-favoritos b-t i-resu wow bounceIn" data-wow-duration="2.2s" data-wow-delay=".3s">
                                    <div class="box-favorito-img"></div>
                                    <a href="./GestionTransparente?action=NormasDirectivas&tab=1" title="" class="btn btn-b-naranja clients">RESOLUCIONES</a>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="bg2">
            <div class="container">
                <!-- Example row of columns -->
                <div class="row">
                    <div class="col-md-12 text-center">
                        <h2 class="h2-title bl-d">Convocatorias</h2>
                    </div>
                    <div class="spaci-2"></div>
                    <div class="col-md-4 col-xs-4 c-ww wow bounceIn" data-wow-duration="1s" data-wow-delay=".5s">
                        <div class="box-team text-center text-curs c-selec">
                            <a href="./Convocatorias" title="">
                                <div class="team-figure">
                                </div>
                                <div class="text-conv">
                                    <span>SELECCIÓN DE <br>PERSONAL</span>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-4 col-xs-4 c-ww wow bounceIn" data-wow-duration="1s" data-wow-delay=".5s">
                        <div class="box-team text-center text-curs c-bienes">
                            <a href="./Convocatorias?action=convocatoria" title="">
                                <div class="team-figure">
                                </div>
                                <div class="text-conv">
                                    <span>BIENES, SERVICIOS, OBRAS <br>Y CONCESIONES</span>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-4 col-xs-4 c-ww wow bounceIn" data-wow-duration="1s" data-wow-delay=".5s">
                        <div class="box-team text-center text-curs c-comu">
                            <a href="./Publicaciones?action=Comunicados" title="">
                                <div class="team-figure">
                                </div>
                                <div class="text-conv">
                                    <span>COMUNICADOS</span>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        
        
        <section>
            <div class="container">
                <!-- Example row of columns -->
                <div class="row">
                    <div class="col-md-12 text-center">
                        <h2 class="h2-title bl-d">Galería</h2>
                    </div>
                    <div class="col-md-12 wow fadeIn" data-wow-offset="5" data-wow-duration="1s" data-wow-delay=".5s">
                        <div class="box-galeria">
                            <ul class="bx-carrusel" id="galeria"></ul>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section>
            <div class="container">
                <!-- Example row of columns -->
                <div class="row pnlVideos">
                    <div class="col-md-12 text-center">
                        <h2 class="h2-title bl-d">Multimedia</h2>
                    </div>                    
                </div>
            </div>
        </section>

        <section class="bg1">
            <div class="container">
                <!-- Example row of columns -->
                <div class="row">
                    <div class="col-md-12 text-center">
                        <h2 class="h2-title bl-d">Gestión Transparente</h2>
                    </div>
                    <div class="col-md-12">
                        <div class="col-md5 text-center g-doc wow bounceInUp" data-wow-duration=".8s" data-wow-delay=".3s">
                            <a href="./GestionTransparente?action=NormasDirectivas&tab=2" title="">
                                <div class="box-gestion-img"></div>
                                <h5>DOCUMENTOS DE GESTIÓN</h5>
                            </a>
                        </div>
                        <div class="col-md5 text-center g-presu wow bounceInUp" data-wow-duration="1s" data-wow-delay=".3s">
                            <a href="./GestionTransparente?action=PresupuestoFinanzas" title="">
                                <div class="box-gestion-img"></div>
                                <h5>PRESUPUESTOS Y FINANZAS</h5>
                            </a>
                        </div>
                        <div class="col-md5 text-center g-recu wow bounceInUp" data-wow-duration="1.2s" data-wow-delay=".3s">
                            <a href="./GestionTransparente?action=RecursosHumanos" title="">
                                <div class="box-gestion-img"></div>
                                <h5>RECURSOS <br>HUMANOS</h5>
                            </a>
                        </div>
                        <div class="col-md5 text-center g-adq wow bounceInUp" data-wow-duration="1.4s" data-wow-delay=".3s">
                            <a href="./GestionTransparente?action=AdquisicionesContrataciones" title="">
                                <div class="box-gestion-img"></div>
                                <h5>ADQUISICIONES Y CONTRATACIONES</h5>
                            </a>
                        </div>
                        <div class="col-md5 text-center g-modi wow bounceInUp" data-wow-duration="1.6s" data-wow-delay=".3s">
                            <a href="./GestionTransparente?action=AdquisicionesContrataciones&tab=12" title="">
                                <div class="box-gestion-img"></div>
                                <h5>MODIFICACIONES DEL PAC</h5>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <%@include file="jspf/pie.jspf" %>        
    </body>
</html>