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
                /* $("cab1").addEvent("click",function(){
                 $("hidenoti").setStyle('display', 'block');
                 $("s-content").setStyle('display', 'block');
                 });
                 $("hidenoti").setStyle('display', 'none').addEvent("click",function(){
                 $("hidenoti").setStyle('display', 'none');
                 $("s-content").setStyle('display', 'none');
                 });
                 var notice= new JpSlider($("s-content"),{
                 url : './Publicaciones?action=NotaPrensaForNotice',
                 type:'notice'});
                 var links= new JpSlider($("enlaces"),{url:'./Enlace',type:'links'});
                 */
                var tblGlosario = new JpGrid($("tbl-glosario"), {
                    id: "gridGlosario",
                    url: './Glosario?action=Glosario',
                    dataQuery: [
                        {name: 'query', value: $("txtBuscarTermino").get("value").replace("&", "$$")}
                    ],
                    params: {
                        limit: 40
                    },
                    model: [
                        {name: "titulo", field: 'Término', width: "20%",style: {"font-weight": "bold"}, sort: true, type: 'string'},
                        {name: "descripcion", field: 'Signficado', width: "70%",style: {"text-align": "justify"}, type: 'string'}
                    ]
                });

                $("btnBuscarTermino").addEvent("click", function (evt) {
                    evt.stopPropagation();
                    tblGlosario.loadData([
                        {name: 'query', value: $("txtBuscarTermino").get("value").replace("&", "$$")}
                    ]);
                });
                $("txtBuscarTermino").addEvent("keypress", function (evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblGlosario.loadData([
                            {name: 'query', value: $("txtBuscarTermino").get("value").replace("&", "$$")}
                        ]);
                    }
                });

            });
        </script>
        <title>Glosario de T&eacute;rminos</title>
        <style>
            #tbl-glosario table tbody tr td {
                line-height: 1.8em;
                height: 50px;
                font-family: sans-serif, monospace;
            }
        </style>
    </head>
    <body>
        <%@include file="../jspf/cabecera.jspf" %>         
        <div class="wrapper2" style="padding: 30px;">

            <div class="cuerpo">
                <div class="navegacion">
                    <h2>
                        <a href="./Inicio">Inicio</a> / Glosario
                    </h2> 
                </div>
                <div class="cdesk" id="cdesk">
                    <div class="sliderPanel">
                        <h2 id="st3">Glosario de T&eacute;rminos</h2>
                        <div id="sp3">
                            <div class="search">
                                <div class="content-i">
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Buscar por T&eacute;rminos </label><input  id="txtBuscarTermino" style="margin-right:3px" /><button id="btnBuscarTermino">Buscar</button>             
                                </div>
                            </div>
                            <div id="tbl-glosario" class="grid"></div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <%@include file="../jspf/pie.jspf" %>
    </body>
</html>
