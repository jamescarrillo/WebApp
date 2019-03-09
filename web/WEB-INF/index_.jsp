
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link  type="text/css" rel="stylesheet" href="resources/css/estilo.css">
        <script type="text/javascript" src="resources/js/mootools-core.js"></script>
        <script type="text/javascript" src="resources/js/mootools-more.js"></script>
        <script type="text/javascript" src="resources/js/JpSlider.js"></script>
        <script type="text/javascript" src="resources/js/JpCalendar.js"></script>
        <script type="text/javascript" src="resources/js/JpWindow.js"></script>
        <script type="text/javascript" src="resources/js/AlMultiFade.js"></script>

        <script type="text/javascript">
            window.addEvent("domready", function() {
                var myAccordion = new Fx.Accordion(document.id('accordion'), 'h3.toggler', 'div.element', {
                    opacity: false,
                    onActive: function(toggler, element) {
                        toggler.addClass('active');
                        $$(".linknoti[data=1]").set("html", "");
                    },
                    onBackground: function(toggler, element) {
                        toggler.removeClass('active');
                    }
                });
                $("s-content").setStyle('display', 'block');
                $('buscarPag').buscarDato("norte");
                $$('.ciudad').multiFade();
                $$('.instituto').multiFade();
                $$('.public').multiFade();
                $$('.tranparent').multiFade();
                $$('.convo').multiFade();
                new JpSlider($("s-content"), {
                    url: './Publicaciones?action=NotaPrensaForNotice',
                    type: 'notice',
                    hide: true
                });
                new JpSlider($("enlaces"), {url: './Enlace', type: 'links'});
                var cal = new JpCalendar($("calendario"), {navigation: true, ruteable: true});
                $("txtStartM").set("value", "0");
                $("txtLimitM").set("value", "1");
                $("txtCurrentM").set("value", "0");
                var divIzquierda = new Element('div');
                divIzquierda.setStyles({
                    "id": "divIzquierda",
                    "width": "96px",
                    "height": "96px",
                    "padding": "0",
                    "position": "absolute",
                    "float": "left",
                    "margin-top": "100px",
                    "margin-left": "0px",
                    "z-index": "9999",
                    "background": "url('./resources/images/back.png') 0 0 no-repeat",
                    "cursor": "pointer",
                    "display": "none"
                });
                divIzquierda.inject("Multimedia", 'before');
                divIzquierda.tween('opacity', 0.3);
                divIzquierda.addEvents({
                    'mouseenter': function() {
                        divIzquierda.tween('opacity', 1);
                    },
                    'mouseleave': function() {
                        divIzquierda.tween('opacity', 0.3);
                    }
                });
                var divDerecha = new Element('div');
                divDerecha.setStyles({
                    "id": "divDerecha",
                    "width": "96px",
                    "height": "96px",
                    "padding": "0",
                    "position": "absolute",
                    "margin-top": "100px",
                    "margin-left": "375px",
                    "z-index": "9999",
                    "background": "url('./resources/images/run.png') 0 0 no-repeat",
                    "cursor": "pointer",
                    "display": "none"
                });
                divDerecha.inject("Multimedia", 'before');
                divDerecha.tween('opacity', 0.3);
                divDerecha.addEvents({
                    'mouseenter': function() {
                        divDerecha.tween('opacity', 1);
                    },
                    'mouseleave': function() {
                        divDerecha.tween('opacity', 0.3);
                    }
                });
                //cargamos las noticias
                var jsonMultimedia = function() {
                    var ajaxNotice = new Request.JSON({
                        url: './Publicaciones?action=MultimediaForNotice',
                        data: Object.toQueryString({
                            "start": $("txtStartM").get("value"),
                            "limit": $("txtLimitM").get("value"),
                            "current": $("txtCurrentM").get("value")
                        }),
                        onSuccess: function(response) {
                            var iFrame = new Element('iframe', {
                                "width": "100%",
                                "height": "290px",
                                "frameborder": "0",
                                "allowfullscreen": "",
                                "src": response.multimedia.fuente + "&showinfo=0&wmode=transparent"
                            });
                            var titulo = new Element('h1', {
                                "html": response.multimedia.titulo
                            }).tween('opacity', 0.5);
                            titulo.setStyles({
                                "z-index": "9010",
                                "position": "absolute",
                                "width": "100%",
                                "height": "8%",
                                "top": "0px"
                            });
                            var divMa = new Element('div');
                            divMa.setStyles({
                                "border": "0.1em #ccc solid",
                                "display": "block",
                                "width": "100%",
                                "height": "290px",
                                "padding": "0",
                                "position": "relative"
                            });
                            divMa.adopt(iFrame, titulo);
                            $("Multimedia").adopt(divMa);
                            if ((parseInt($("txtCurrentM").get("value"))) < Math.ceil(parseInt(response.total) / parseInt($("txtLimitM").get("value")))) {
                                divDerecha.setStyle("display", "block");
                            }
                            else {
                                divDerecha.setStyle("display", "none");
                            }
                            if ((parseInt($("txtCurrentM").get("value")) + 1) == Math.ceil(parseInt(response.total) / parseInt($("txtLimitM").get("value")))) {
                                divDerecha.setStyle("display", "none");
                            }

                            if ((parseInt($("txtCurrentM").get("value"))) > 0) {
                                divIzquierda.setStyle("display", "block");
                            }
                            else {
                                divIzquierda.setStyle("display", "none");
                            }
                        }
                    });
                    ajaxNotice.send();
                }
                jsonMultimedia();
                divDerecha.addEvent("click", function() {
                    $("txtCurrentM").set("value", (parseInt($("txtCurrentM").get("value")) + 1));
                    $("txtStartM").set("value", ((parseInt($("txtCurrentM").get("value"))) * parseInt($("txtLimitM").get("value"))));
                    $("Multimedia").empty();
                    jsonMultimedia();
                    return false;
                });
                divIzquierda.addEvent("click", function() {
                    $("txtCurrentM").set("value", (parseInt($("txtCurrentM").get("value")) - 1));
                    $("txtStartM").set("value", ((parseInt($("txtCurrentM").get("value"))) * parseInt($("txtLimitM").get("value"))));
                    $("Multimedia").empty();
                    jsonMultimedia();
                    return false;
                });
                var gerente = new Request.HTML({
                    url: './GestionTransparente?action=ObtenerGerente',
                    onComplete: function(data) {
                        $("nombreGerente").empty().adopt(data);
                    }
                }).send();
            });</script>
        <script src="./resources/galleria/jquery.js"></script>
        <!-- load Galleria -->
        <script src="./resources/galleria/galleria-1.3.6.min.js"></script>
        <!-- load flickr plugin -->
        <script src="./resources/galleria/plugins/flickr/galleria.flickr.min.js"></script>
        
        <script>
            jQuery.noConflict();
            // Load the classic theme
            Galleria.loadTheme('./resources/galleria/themes/classic/galleria.classic.min.js');
            // Initialize Galleria
            Galleria.run('#galleria', {
                // search flickr for "galleria"
                flickr: 'set:72157650280814132',
                flickrOptions: {
                    // sort by interestingness
                    sort: 'interestingness-desc'
                },
                imageCrop: 'landscape',
                transition: 'fade',
                autoplay: 6000,
                height: 310,
                width: 445,
                lightbox: true
            });
        </script>
        <title>Proyecto Especial Alto Mayo (PEAM)</title>

        <style>
            a#resoluciones{
                background:url('./resources/images/res.png') no-repeat 2% 70%;
            }
            a#tupa{
                background:url('./resources/images/tupa.png') no-repeat 2% 70%;
            }
            a#comunicado{
                background:url('./resources/images/comunicado.png') no-repeat 2% 70%;
            }
            a#memoria{
                background:url('./resources/images/memoria.png') no-repeat 2% 70%;
            }
            a#directorio{
                background:url('./resources/images/directorio.png') no-repeat 2% 70%;
            }
            .galleria-info{ height: 30px}
        </style>
    </head>
    <body>
        <div class="wrapper">
            <%@include file="jspf/cabecera.jspf" %>
            <%@include file="jspf/cuerpo.jspf" %>
            <%@include file="jspf/pie.jspf" %>
        </div>        
    </body>
</html>
