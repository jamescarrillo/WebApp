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
        <script type="text/javascript" src="resources/js/JpView.js"></script>
        <script type="text/javascript" src="resources/js/AlMultiFade.js"></script>
         <script src="resources/js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
        <script src="resources/js/vendor/jquery-1.11.1.min.js"></script>        
        <script type="text/javascript" src="resources/js/jquery.nicescroll.min.js"></script>

        
        <style>
            .tooltip {
                background: #000;
                border-radius: 5px;
                box-shadow: 2px 2px 10px rgba(0,0,0,.3);
                color: #fff;
                max-width: 500px;
                padding: 5px 8px;
                -moz-border-radius: 5px;
                -webkit-border-radius: 5px;
                -moz-box-shadow: 2px 2px 10px rgba(0,0,0,.3);
                -webkit-box-shadow: 2px 2px 10px rgba(0,0,0,.3);
            }
            .tooltip a {
                color: #fff;
            }
            .tooltip div.close {
                background: url(./resources/images/tool-close.png) no-repeat;
                border: 1px solid #000;
                float: right;
                height: 6px;
                margin-left: 5px;
                width: 7px;
            }
            .tooltip div.close:hover {
                border-style: outset;
            }
        </style>
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
                $('sp1').setFocus();
                $('buscarPag').buscarDato("norte");
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
                /*$("cab1").addEvent("click", function() {
                    $("hidenoti").setStyle('display', 'block');
                    $("s-content").setStyle('display', 'block');
                });
                $("hidenoti").setStyle('display', 'none').addEvent("click", function() {
                    $("hidenoti").setStyle('display', 'none');
                    $("s-content").setStyle('display', 'none');
                });
                new JpSlider($("s-content"), {
                    url: './Publicaciones?action=NotaPrensaForNotice',
                    type: 'notice'});
                new JpSlider($("enlaces"), {url: './Enlace', type: 'links'});*/

                // Recomendacioens

                var tblRecomendacion;
                $("st1").addEvent('click', function(event) {
                    event.stop();
                    sp1.toggle();
                    sp2.hide();
                    sp3.hide();
                    sp4.hide();
                    sp5.hide();
                    sp6.hide();

                });
                $("st2").addEvent('click', function(event) {
                    event.stop();
                    sp1.hide();
                    sp2.toggle();
                    sp3.hide();
                    sp4.hide();
                    sp5.hide();
                    sp6.hide();
                });
                $("st3").addEvent('click', function(event) {
                    event.stop();
                    sp1.hide();
                    sp2.hide();
                    sp3.toggle();
                    sp4.hide();
                    sp5.hide();
                    sp6.hide();
                });
                $("st4").addEvent('click', function(event) {
                    event.stop();
                    sp1.hide();
                    sp2.hide();
                    sp3.hide();
                    sp4.toggle();
                    sp5.hide();
                    sp6.hide();
                });

                $("st5").addEvent('click', function(event) {
                    event.stop();
                    sp1.hide();
                    sp2.hide();
                    sp3.hide();
                    sp4.hide();
                    sp5.toggle();
                    sp6.hide();
                });

                $("st6").addEvent('click', function(event) {
                    event.stop();
                    sp1.hide();
                    sp2.hide();
                    sp3.hide();
                    sp4.hide();
                    sp5.hide();
                    sp6.toggle();
                });

                var sp1 = $("sp1");//new Fx.Slide('sp1', {mode: 'vertical'});
                var sp2 = $("sp2");//new Fx.Slide('sp2', {mode: 'vertical'});
                var sp3 = $("sp3");
                var sp4 = $("sp4");
                var sp5 = $("sp5");
                var sp6 = $("sp6");

                sp1.hide();
                sp2.hide();
                sp3.hide();
                sp4.hide();
                sp5.hide();
                sp6.hide();

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
                    case "5" :
                        sp5.toggle();
                        break;
                    case "6" :
                        sp6.toggle();
                        break;


                }

                var anhoRecomendacion = new Request.HTML({
                    url: './Convocatoria?action=ListarAnhosDocumentos&cate_id=700',
                    onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                        $("anhosRecomendacion").set('html', responseHTML);
                        tblRecomendacion = new JpGrid($("tbl-recomendacion"), {
                            id: "gridRecomendacion",
                            url: './Convocatoria?action=Documentos',
                            dataQuery: [
                                {name: 'anho', value: $("anhosRecomendacion").get("value")},
                                {name: 'cate_id', value: 700},
                                {name: 'query', value: $("txtBuscarRecomendacion").get("value").replace("&", "$$")}
                            ],
                            success: function(e) {
                                $$(".tips").addEvent('click', function() {
                                    ToolTip.instance(this, {
                                        autohide: false,
                                        position: {position: 'bottom', edge: 'top'}
                                    },
                                    this.get('dir')
                                            ).show();

                                });
                            },
                            model: [
                                {name: "fecha", field: 'Fecha', width: "5%", type: 'string'},
                                {name: "titulo", field: 'Título', width: "20%", sort: true, type: 'string'},
                                {name: "resumen", style: {"text-align": "justify"}, field: 'Descripción', width: "60%", type: 'string'},
                                {name: "id", field: 'Descargar', style: {"text-align": "center"}, width: "7%", clase: 'tips', title: 'Explicación', filtro: 'descripcion', activo: 'activo', type: 'string', renderer: function(val) {
                                        return '<a class="pdf" target="_blank" href="./GestionTransparente?action=verResolucion&id=' + val + '&anho=' + $("anhosRecomendacion").get("value") + '"></a>'
                                    }}
                            ]
                        });
                    }
                });
                anhoRecomendacion.send();

                $("anhosRecomendacion").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    tblRecomendacion.loadData([
                        {name: 'anho', value: $("anhosRecomendacion").get("value")},
                        {name: 'cate_id', value: 700},
                        {name: 'query', value: $("txtBuscarRecomendacion").get("value").replace("&", "$$")}
                    ]);
                });
                $("btnBuscarRecomendacion").addEvent("click", function(evt) {
                    evt.stopPropagation();
                    tblRecomendacion.loadData([
                        {name: 'anho', value: $("anhosRecomendacion").get("value")},
                        {name: 'cate_id', value: 700},
                        {name: 'query', value: $("txtBuscarRecomendacion").get("value").replace("&", "$$")}
                    ]);
                });
                $("txtBuscarRecomendacion").addEvent("keypress", function(evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblRecomendacion.loadData([
                            {name: 'anho', value: $("anhosRecomendacion").get("value")},
                            {name: 'cate_id', value: 700},
                            {name: 'query', value: $("txtBuscarRecomendacion").get("value").replace("&", "$$")}
                        ]);
                    }
                });

                // Evaluacion
                var tblEvaluacion;

                var anhoEvaluacion = new Request.HTML({
                    url: './Convocatoria?action=ListarAnhosDocumentos&cate_id=800',
                    onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                        $("anhosEvaluacion").set('html', responseHTML);
                        tblEvaluacion = new JpGrid($("tbl-evaluacion"), {
                            id: "gridEvaluacion",
                            url: './Convocatoria?action=Documentos',
                            dataQuery: [
                                {name: 'anho', value: $("anhosEvaluacion").get("value")},
                                {name: 'cate_id', value: 800},
                                {name: 'query', value: $("txtBuscarEvaluacion").get("value").replace("&", "$$")}
                            ],
                            success: function(e) {
                                $$(".tips").addEvent('click', function() {
                                    ToolTip.instance(this, {
                                        autohide: false,
                                        position: {position: 'bottom', edge: 'top'}
                                    },
                                    this.get('dir')
                                            ).show();

                                });
                            },
                            model: [
                                {name: "fecha", field: 'Fecha', width: "5%", type: 'string'},
                                {name: "titulo", field: 'Título', width: "20%", sort: true, type: 'string'},
                                {name: "resumen", style: {"text-align": "justify"}, field: 'Descripción', width: "60%", type: 'string'},
                                {name: "id", field: 'Descargar', style: {"text-align": "center"}, width: "7%", clase: 'tips', title: 'Explicación', filtro: 'descripcion', activo: 'activo', type: 'string', renderer: function(val) {
                                        return '<a class="pdf" target="_blank" href="./GestionTransparente?action=verResolucion&id=' + val + '&anho=' + $("anhosEvaluacion").get("value") + '"></a>'
                                    }}
                            ]
                        });
                    }
                });
                anhoEvaluacion.send();

                $("anhosEvaluacion").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    tblEvaluacion.loadData([
                        {name: 'anho', value: $("anhosEvaluacion").get("value")},
                        {name: 'cate_id', value: 800},
                        {name: 'query', value: $("txtBuscarEvaluacion").get("value").replace("&", "$$")}
                    ]);
                });
                $("btnBuscarEvaluacion").addEvent("click", function(evt) {
                    evt.stopPropagation();
                    tblEvaluacion.loadData([
                        {name: 'anho', value: $("anhosEvaluacion").get("value")},
                        {name: 'cate_id', value: 800},
                        {name: 'query', value: $("txtBuscarEvaluacion").get("value").replace("&", "$$")}
                    ]);
                });
                $("txtBuscarEvaluacion").addEvent("keypress", function(evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblEvaluacion.loadData([
                            {name: 'anho', value: $("anhosEvaluacion").get("value")},
                            {name: 'cate_id', value: 800},
                            {name: 'query', value: $("txtBuscarEvaluacion").get("value").replace("&", "$$")}
                        ]);
                    }
                });

                //Laudos
                var tblLaudo;

                var anhoLaudo = new Request.HTML({
                    url: './Convocatoria?action=ListarAnhosDocumentos&cate_id=500',
                    onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                        $("anhosLaudo").set('html', responseHTML);
                        tblLaudo = new JpGrid($("tbl-laudo"), {
                            id: "gridLaudo",
                            url: './Convocatoria?action=Documentos',
                            dataQuery: [
                                {name: 'anho', value: $("anhosLaudo").get("value")},
                                {name: 'cate_id', value: 500},
                                {name: 'query', value: $("txtBuscarLaudo").get("value").replace("&", "$$")}
                            ],
                            success: function(e) {
                                $$(".tips").addEvent('click', function() {
                                    ToolTip.instance(this, {
                                        autohide: false,
                                        position: {position: 'bottom', edge: 'top'}
                                    },
                                    this.get('dir')
                                            ).show();

                                });
                            },
                            model: [
                                {name: "fecha", field: 'Fecha', width: "5%", type: 'string'},
                                {name: "titulo", field: 'Título', width: "20%", sort: true, type: 'string'},
                                {name: "resumen", style: {"text-align": "justify"}, field: 'Descripción', width: "60%", type: 'string'},
                                {name: "id", field: 'Descargar', style: {"text-align": "center"}, width: "7%", clase: 'tips', title: 'Explicación', filtro: 'descripcion', activo: 'activo', type: 'string', renderer: function(val) {
                                        return '<a class="pdf" target="_blank" href="./GestionTransparente?action=verResolucion&id=' + val + '&anho=' + $("anhosLaudo").get("value") + '"></a>'
                                    }}
                            ]
                        });
                    }
                });
                anhoLaudo.send();

                $("anhosLaudo").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    tblLaudo.loadData([
                        {name: 'anho', value: $("anhosLaudo").get("value")},
                        {name: 'cate_id', value: 500},
                        {name: 'query', value: $("txtBuscarLaudo").get("value").replace("&", "$$")}
                    ]);
                });
                $("btnBuscarLaudo").addEvent("click", function(evt) {
                    evt.stopPropagation();
                    tblLaudo.loadData([
                        {name: 'anho', value: $("anhosLaudo").get("value")},
                        {name: 'cate_id', value: 500},
                        {name: 'query', value: $("txtBuscarLaudo").get("value").replace("&", "$$")}
                    ]);
                });
                $("txtBuscarLaudo").addEvent("keypress", function(evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblLaudo.loadData([
                            {name: 'anho', value: $("anhosLaudo").get("value")},
                            {name: 'cate_id', value: 500},
                            {name: 'query', value: $("txtBuscarLaudo").get("value").replace("&", "$$")}
                        ]);
                    }
                });

                //Actas de conciliacion
                var tblActa;

                var anhoActa = new Request.HTML({
                    url: './Convocatoria?action=ListarAnhosDocumentos&cate_id=600',
                    onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                        $("anhosActa").set('html', responseHTML);
                        tblActa = new JpGrid($("tbl-acta"), {
                            id: "gridActa",
                            url: './Convocatoria?action=Documentos',
                            dataQuery: [
                                {name: 'anho', value: $("anhosActa").get("value")},
                                {name: 'cate_id', value: 600},
                                {name: 'query', value: $("txtBuscarActa").get("value").replace("&", "$$")}
                            ],
                            success: function(e) {
                                $$(".tips").addEvent('click', function() {
                                    ToolTip.instance(this, {
                                        autohide: false,
                                        position: {position: 'bottom', edge: 'top'}
                                    },
                                    this.get('dir')
                                            ).show();

                                });
                            },
                            model: [
                                {name: "fecha", field: 'Fecha', width: "5%", type: 'string'},
                                {name: "titulo", field: 'Título', width: "20%", sort: true, type: 'string'},
                                {name: "resumen", style: {"text-align": "justify"}, field: 'Descripción', width: "60%", type: 'string'},
                                {name: "id", field: 'Descargar', style: {"text-align": "center"}, width: "7%", clase: 'tips', title: 'Explicación', filtro: 'descripcion', activo: 'activo', type: 'string', renderer: function(val) {
                                        return '<a class="pdf" target="_blank" href="./GestionTransparente?action=verResolucion&id=' + val + '&anho=' + $("anhosActa").get("value") + '"></a>'
                                    }}
                            ]
                        });
                    }
                });
                anhoActa.send();

                $("anhosActa").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    tblActa.loadData([
                        {name: 'anho', value: $("anhosActa").get("value")},
                        {name: 'cate_id', value: 600},
                        {name: 'query', value: $("txtBuscarActa").get("value").replace("&", "$$")}
                    ]);
                });
                $("btnBuscarActa").addEvent("click", function(evt) {
                    evt.stopPropagation();
                    tblActa.loadData([
                        {name: 'anho', value: $("anhosActa").get("value")},
                        {name: 'cate_id', value: 600},
                        {name: 'query', value: $("txtBuscarActa").get("value").replace("&", "$$")}
                    ]);
                });
                $("txtBuscarActa").addEvent("keypress", function(evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblActa.loadData([
                            {name: 'anho', value: $("anhosActa").get("value")},
                            {name: 'cate_id', value: 600},
                            {name: 'query', value: $("txtBuscarActa").get("value").replace("&", "$$")}
                        ]);
                    }
                });

                //Declaraciones Juradas
                var tblDeclaracion;

                var anhoDeclaracion = new Request.HTML({
                    url: './Convocatoria?action=ListarAnhosDocumentos&cate_id=1200',
                    onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                        $("anhosDeclaracion").set('html', responseHTML);
                        tblDeclaracion = new JpGrid($("tbl-declaracion"), {
                            id: "gridDeclaracion",
                            url: './Convocatoria?action=Declaracion',
                            dataQuery: [
                                {name: 'anho', value: $("anhosDeclaracion").get("value")},
                                {name: 'cate_id', value: 1200},
                                {name: 'query', value: $("txtBuscarDeclaracion").get("value").replace("&", "$$")}
                            ],
                            success: function(e) {
                                $$(".tips").addEvent('click', function() {
                                    ToolTip.instance(this, {
                                        autohide: false,
                                        position: {position: 'bottom', edge: 'top'}
                                    },
                                    this.get('dir')
                                            ).show();
                                });
                            },
                            model: [
                                {name: "titulo", field: 'D.N.I', width: "8%", sort: true, type: 'string'},
                                {name: "resumen", style: {"text-align": "justify"}, field: 'Declarante', width: "25%", type: 'string'},
                                {name: "cargo", field: 'Cargo', width: "40%", type: 'string'},
                                {name: "presentacion", field: 'Presentación', width: "20%", type: 'string'},
                                {name: "id", field: 'Descargar', style: {"text-align": "center"}, width: "7%", clase: 'tips', title: 'Explicación', filtro: 'descripcion', activo: 'activo', type: 'string', renderer: function(val) {
                                        return '<a class="pdf" target="_blank" href="./GestionTransparente?action=verResolucion&id=' + val + '&anho=' + $("anhosDeclaracion").get("value") + '"></a>'
                                    }}
                            ]
                        });
                    }
                });
                anhoDeclaracion.send();

                $("anhosDeclaracion").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    tblDeclaracion.loadData([
                        {name: 'anho', value: $("anhosDeclaracion").get("value")},
                        {name: 'cate_id', value: 1200},
                        {name: 'query', value: $("txtBuscarDeclaracion").get("value").replace("&", "$$")}
                    ]);
                });
                $("btnBuscarDeclaracion").addEvent("click", function(evt) {
                    evt.stopPropagation();
                    tblDeclaracion.loadData([
                        {name: 'anho', value: $("anhosDeclaracion").get("value")},
                        {name: 'cate_id', value: 1200},
                        {name: 'query', value: $("txtBuscarDeclaracion").get("value").replace("&", "$$")}
                    ]);
                });
                $("txtBuscarDeclaracion").addEvent("keypress", function(evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblDeclaracion.loadData([
                            {name: 'anho', value: $("anhosDeclaracion").get("value")},
                            {name: 'cate_id', value: 1200},
                            {name: 'query', value: $("txtBuscarDeclaracion").get("value").replace("&", "$$")}
                        ]);
                    }
                });

                //Portal
                var tblPortal;

                var anhoPortal = new Request.HTML({
                    url: './Convocatoria?action=ListarAnhosDocumentos&cate_id=1300',
                    onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                        $("anhosPortal").set('html', responseHTML);
                        tblPortal = new JpGrid($("tbl-portal"), {
                            id: "gridPortal",
                            url: './Convocatoria?action=Documentos',
                            dataQuery: [
                                {name: 'anho', value: $("anhosPortal").get("value")},
                                {name: 'cate_id', value: 1300},
                                {name: 'query', value: $("txtBuscarPortal").get("value").replace("&", "$$")}
                            ],
                            success: function(e) {
                                $$(".tips").addEvent('click', function() {
                                    ToolTip.instance(this, {
                                        autohide: false,
                                        position: {position: 'bottom', edge: 'top'}
                                    },
                                    this.get('dir')
                                            ).show();
                                });
                            },
                            model: [
                                {name: "titulo", field: 'Nro. Doc.', width: "15%", sort: true, type: 'string'},
                                {name: "resumen", style: {"text-align": "justify"}, field: 'Titulo', width: "71%", type: 'string'},
                                {name: "id", field: 'Descargar', style: {"text-align": "center"}, width: "7%", clase: 'tips', title: 'Explicación', filtro: 'descripcion', activo: 'activo', type: 'string', renderer: function(val) {
                                        return '<a class="pdf" target="_blank" href="./GestionTransparente?action=verResolucion&id=' + val + '&anho=' + $("anhosPortal").get("value") + '"></a>'
                                    }}
                            ]
                        });
                    }
                });
                anhoPortal.send();

                $("anhosPortal").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    tblPortal.loadData([
                        {name: 'anho', value: $("anhosPortal").get("value")},
                        {name: 'cate_id', value: 1300},
                        {name: 'query', value: $("txtBuscarPortal").get("value").replace("&", "$$")}
                    ]);
                });
                $("btnBuscarPortal").addEvent("click", function(evt) {
                    evt.stopPropagation();
                    tblPortal.loadData([
                        {name: 'anho', value: $("anhosPortal").get("value")},
                        {name: 'cate_id', value: 1300},
                        {name: 'query', value: $("txtBuscarPortal").get("value").replace("&", "$$")}
                    ]);
                });
                $("txtBuscarPortal").addEvent("keypress", function(evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblPortal.loadData([
                            {name: 'anho', value: $("anhosPortal").get("value")},
                            {name: 'cate_id', value: 1300},
                            {name: 'query', value: $("txtBuscarPortal").get("value").replace("&", "$$")}
                        ]);
                    }
                });
            });
        </script>
        <title>Información Adicional</title>
    </head>
    <body>
        <%@include file="../jspf/cabecera.jspf" %>
        <div class="wrapper2">
            
            <div class="cuerpo">
                <div class="navegacion">
                    <h2>
                        <a href="./Inicio">Inicio</a> / <a href="./GestionTransparente">Gesti&oacute;n Transparente</a> / Informaci&oacute;n Adicional
                    </h2> 
                </div>
                <div class="services text-center">
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

                        <div class="panel efecto">
                            <a href="./GestionTransparente?action=AgendaInstitucional">
                                <div class="agenda"></div>
                                <div class="descripcion" style="font-size:11px">Agenda Institucional</div>
                            </a>
                        </div>
                        <div class="panel efecto active">
                            <div class="resoluciones"></div>
                            <div class="descripcion" style="font-size:11px">Informaci&oacute;n Adicional</div>
                        </div>
                    </div>

                </div>
                <div class="cdesk">              
                    <div class="sliderPanel">
                        <h2 id="st1">Recomendaciones de los informes de auditor&iacute;a orientadas al mejoramiento de la gesti&oacute;n</h2>
                        <div id="sp1">
                            <div class="search">
                                <div class="content-l">
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Filtrar por A&ntilde;o:</label><select id="anhosRecomendacion"></select>
                                </div>
                                <div class="content-i">
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Buscar Recomendación: </label><input  id="txtBuscarRecomendacion" style="margin-right:3px" /><button id="btnBuscarRecomendacion">Buscar</button>             
                                </div>
                            </div>
                            <div id="tbl-recomendacion" class="grid"></div>
                        </div>
                    </div>

                    <div class="sliderPanel">
                        <h2 id="st2">Evaluaci&oacute;n del cumplimiento de actualizaci&oacute;n del Portal</h2>
                        <div id="sp2">
                            <div class="search">
                                <div class="content-l">
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Filtrar por A&ntilde;o:</label><select id="anhosEvaluacion"></select>
                                </div>
                                <div class="content-i">
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Buscar Evaluación: </label><input  id="txtBuscarEvaluacion" style="margin-right:3px" /><button id="btnBuscarEvaluacion">Buscar</button>             
                                </div>
                            </div>
                            <div id="tbl-evaluacion" class="grid"></div>
                        </div>
                    </div>

                    <div class="sliderPanel">
                        <h2 id="st3" >Laudos </h2>
                        <div id="sp3" >
                            <div class="search">
                                <div class="content-l">
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Filtrar por A&ntilde;o:</label><select id="anhosLaudo"></select>
                                </div>
                                <div class="content-i">
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Buscar Laudo: </label><input  id="txtBuscarLaudo" style="margin-right:3px"/><button id="btnBuscarLaudo">Buscar</button>             
                                </div>
                            </div>
                            <div id="tbl-laudo" class="grid"></div>  
                        </div>
                    </div>
                    <div class="sliderPanel">
                        <h2 id="st4" >Actas de conciliaci&oacute;n </h2>
                        <div id="sp4" >
                            <div class="search">
                                <div class="content-l">
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Filtrar por A&ntilde;o:</label><select id="anhosActa"></select>
                                </div>
                                <div class="content-i">
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Buscar Conciliacion: </label><input  id="txtBuscarActa" style="margin-right:3px"/><button id="btnBuscarActa">Buscar</button>             
                                </div>
                            </div>
                            <div id="tbl-acta" class="grid"></div>  
                        </div>
                    </div>

                    <div class="sliderPanel">
                        <h2 id="st5" >Declaraciones juradas de ingresos, bienes y rentas </h2>
                        <div id="sp5" >
                            <div class="search">
                                <div class="content-l">
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Filtrar por A&ntilde;o:</label><select id="anhosDeclaracion"></select>
                                </div>
                                <div class="content-i">
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Buscar Declaración: </label><input  id="txtBuscarDeclaracion" style="margin-right:3px" /><button id="btnBuscarDeclaracion">Buscar</button>             
                                </div>
                            </div>
                            <div id="tbl-declaracion" class="grid"></div>  

                        </div>
                    </div>
                    <div class="sliderPanel">
                        <h2 id="st6" >Informes Técnicos Previos de Evaluación de Software  </h2>
                        <div id="sp6" >
                            <div class="search">
                                <div class="content-l">
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Filtrar por A&ntilde;o:</label><select id="anhosPortal"></select>
                                </div>
                                <div class="content-i">
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Buscar: </label><input  id="txtBuscarPortal" style="margin-right:3px"/><button id="btnBuscarPortal">Buscar</button>             
                                </div>
                            </div>
                            <div id="tbl-portal" class="grid"></div>  

                        </div>
                    </div>
                </div>
            </div>
            
        </div>
        <%@include file="../jspf/pie.jspf" %>
    </body>
</html>
