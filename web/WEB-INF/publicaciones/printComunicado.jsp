<%-- 
    Document   : institucion
    Created on : 30/05/2012, 02:53:26 PM
    Author     : jprada
--%>

<%@page import="gob.peam.beans.Anuncio"%>
<%@page import="gob.peam.dao.AnuncioDao"%>
<%
    Integer id = Integer.parseInt(request.getParameter("id").toString());
    AnuncioDao dao = new AnuncioDao();
    Anuncio anuncio = dao.getAnuncioAdmin(id);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- any content can be specified here e.g.: --%>
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
                $('imprimir').addEvent('click', function() {
                    window.print();
                });
                $('buscarPag').buscarDato("norte");
                
                $$('.panel').multiFade();
               // $("accordion").hide();
                //var links= new JpSlider($("enlaces"),{url:'./Enlace',type:'links'});
            });
        </script>
        <title>Comunicados</title>
    </head>
    <body>
        <%@include file="../jspf/cabecera.jspf" %>
        <div class="wrapper2">
            <div class="cuerpo">

                <div class="services text-center">
                    <div class="gadget">
                        <div class="panel active">                            
                            <div class="icon-html"></div>
                            <div class="descripcion"><a>En Formato HTML</a></div>
                        </div>
                        <div class="panel">
                            <a target="_blank" href="./AnuncioPrint?format=pdf&id=<% out.println(id);%>">
                                <div class="icon-pdf"></div>
                                <div class="descripcion">En Formato PDF</div>
                            </a>
                        </div>
                        <div class="panel">
                            <a href="./AnuncioPrint?format=word&id=<% out.println(id);%>">
                                <div class="icon-word"></div>
                                <div class="descripcion">En Formato WORD</div>
                            </a>
                        </div>
                        <div class="panel">
                            <a href="./AnuncioPrint?format=odt&id=<% out.println(id);%>">
                                <div class="icon-odt"></div>
                                <div class="descripcion">En Formato ODT</div>
                            </a>
                        </div>

                    </div>
                </div>
                <div class="paper" id="paper">
                    <div class ="titulo">
                        <% out.println(anuncio.getTitulo());%>
                    </div>

                    <div class="contenido">
                        <% out.println(anuncio.getContenido());%>
                    </div>

                    <botton class="button green" id="imprimir" style="float:right"> Imprimir </botton>
                </div>
            </div>
            
        </div>
                    <%@include file="../jspf/pie.jspf" %>
    </body>
</html>
