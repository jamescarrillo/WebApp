<%-- 
    Document   : institucion
    Created on : 30/05/2012, 02:53:26 PM
    Author     : jprada
--%>
<%@page import="gob.peam.beans.NotaPrensa"%>
<%@page import="gob.peam.dao.NotaPrensaDao"%>

<%
    Integer id = Integer.parseInt(request.getParameter("id").toString());
    NotaPrensaDao dao = new NotaPrensaDao();
    NotaPrensa notaPrensa = dao.getNotaPrensaForAdmin(id);
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
        <script src="resources/js/JSLoader.js" type="text/javascript"></script>


        <link href=<% out.println(notaPrensa.getFoto().trim());%> rel="image_src" />
        <title> <% out.println(notaPrensa.getTitulo());%></title>

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
                var tab

                $('buscarPag').buscarDato("norte");
                $$('.panel').multiFade();
                // $("accordion").hide();
                //var links = new JpSlider($("enlaces"), {url: './Enlace', type: 'links'});
                tab = get()["id"];
                JSLoader.onLoad(start);
                JSLoader.loadfile([{"fileName": "resources/js/urlShortener.js", "fileType": "js"}]);
                function start() {
                    urlShortener.settings.apiKey = "AIzaSyBGj7tLpciEO2IVPAP12p_L3lRlfXhKkgE";
                    document.getElementById("facebook_").setAttribute("href", "http://www.facebook.com/sharer.php?u=" + urlShortener.getLink({"longUrl": "http://www.peam.gob.pe/Publicaciones?action=PaginaNotaPrensaPrint&id=" + tab}));
                    document.getElementById("twitter_").setAttribute("href", "https://twitter.com/intent/tweet?original_referer=" + urlShortener.getLink({"longUrl": "http://www.peam.gob.pe/Publicaciones?action=PaginaNotaPrensaPrint&id=" + tab}));
                    //document.getElementById("relong").innerHTML = urlShortener.getLink({"shortUrl": document.getElementById("shortUrl").innerHTML});
                    //document.getElementById("relong").setAttribute("href", document.getElementById("relong").innerHTML);

                    //document.getElementById("analytics").innerHTML = JSON.stringify(urlShortener.getLink({"shortUrl": document.getElementById("shortUrl").innerHTML, "projection": "FULL"}));
                }
            });
        </script>
    </head>
    <body >
        <%@include file="../jspf/cabecera.jspf" %>
        <div class="wrapper2">

            <div class="cuerpo2" style="margin: 10px;">

                <div class="paperd" id="paperd" style="padding: 70px 20px;" >
                    <div style='width:100%; margin-bottom:30px;  margin-top: -45px'>
                        <table width='100%; '>
                            <tr>    
                                <td><a title='Formato PDF' target='_blank' href="./NotaPrensaPrint?format=pdf&AMP;id=<% out.println(id);%>"><img alt='formato PDF' src='./resources/images/16x16/pdf.png'></a></td>
                                <td width='1%'></td>
                                <td><a title='Formato WORD' target='_blank' href="./NotaPrensaPrint?format=word&AMP;id=<% out.println(id);%>"><img alt='formato word' src='./resources/images/16x16/word.png'></a></td>
                                <td width='1%'></td>
                                <td><a title='Formato ODT' target='_blank' href="./NotaPrensaPrint?format=odt&AMP;id=<% out.println(id);%>"><img alt='formato odt' src='./resources/images/16x16/doc.png'></a></td>
                                <td width='90%'></td>

                                <td> Compartir: </td>
                                <td width='2%'></td>
                                <td><a id="facebook_" target="_blank" href="#"><img alt='Compartir Facebook' src='./resources/images/16x16/facebook.png'></a></td>

                                <td width='2%'></td>
                                <td><a id="twitter_" target="_blank" href="#"><img alt='Compartir Twitter' src='./resources/images/16x16/twitter.png'></a></td>
                            </tr>
                        </table>
                    </div>
                    <div class="row">
                        <div class ="titulo col-sm-12" style="font-size: 1.7em;margin-bottom: 20px;">
                            <% out.println(notaPrensa.getTitulo());%>
                        </div>
                        <img style="float: right;" alt="Foto" class="col-sm-5"  src="<% out.println(notaPrensa.getFoto());%>"  > 
                        <div class="contenido" style="margin: 10px; text-align: justify;">
                            <% out.println(notaPrensa.getContenido());%>
                            <p style="float:right;margin-right: 10px;">Fecha Publicación:  <% out.println(notaPrensa.getFecha().toString().split("-")[2] + "/" + notaPrensa.getFecha().toString().split("-")[1] + "/" + notaPrensa.getFecha().toString().split("-")[0]);%></p>
                        </div>
                    </div>


                </div>
            </div>

        </div>
        <%@include file="../jspf/pie.jspf" %>
    </body>
</html>
