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
                    onActive: function (toggler, element) {
                        toggler.addClass('active');
                    },
                    onBackground: function (toggler, element) {
                        toggler.removeClass('active');
                    }
                });
                $$('.panel').multiFade();
                /* $("cab1").addEvent("click", function () {
                 $("hidenoti").setStyle('display', 'block');
                 $("s-content").setStyle('display', 'block');
                 });
                 $("hidenoti").setStyle('display', 'none').addEvent("click", function () {
                 $("hidenoti").setStyle('display', 'none');
                 $("s-content").setStyle('display', 'none');
                 });
                 new JpSlider($("s-content"), {
                 url: './Publicaciones?action=NotaPrensaForNotice',
                 type: 'notice'});
                 new JpSlider($("enlaces"), {url: './Enlace', type: 'links'});*/
                 
                $("st1").addEvent('click', function (event) {
                    event.stop();
                    sp1.toggle();
                    sp2.hide();
                    sp3.hide();
                    sp4.hide();
                    sp5.hide();

                });
                $("st2").addEvent('click', function (event) {
                    event.stop();
                    sp1.hide();
                    sp2.toggle();
                    sp3.hide();
                    sp4.hide();
                    sp5.hide();
                });
                $("st3").addEvent('click', function (event) {
                    event.stop();
                    sp1.hide();
                    sp2.hide();
                    sp3.toggle();
                    sp4.hide();
                    sp5.hide();
                });
                $("st4").addEvent('click', function (event) {
                    event.stop();
                    sp1.hide();
                    sp2.hide();
                    sp3.hide();
                    sp4.toggle();
                    sp5.hide();
                });

                $("st5").addEvent('click', function (event) {
                    event.stop();
                    sp1.hide();
                    sp2.hide();
                    sp3.hide();
                    sp4.hide();
                    sp5.toggle();
                });

                var sp1 = $("sp1");//new Fx.Slide('sp1', {mode: 'vertical'});
                var sp2 = $("sp2");//new Fx.Slide('sp2', {mode: 'vertical'});
                var sp3 = $("sp3");//new Fx.Slide('sp3', {mode: 'vertical'});
                var sp4 = $("sp4");
                var sp5 = $("sp5");

                sp1.hide();
                sp2.hide();
                sp3.hide();
                sp4.hide();
                sp5.hide();

                var tab = get()["tab"];
                var opcion = get()["opcion"];
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

                }

                var tblResolucionGerencial;

                var anhoResolucionGerencial = new Request.HTML({
                    url: './GestionTransparente?action=ListarAnhosResolucionGerencial',
                    onSuccess: function (responseTree, responseElements, responseHTML, responseJavaScript) {
                        $("anhosResolucionGerencial").set('html', responseHTML);
                        tblResolucionGerencial = new JpGrid($("tbl-resolucion-gerencial"), {
                            id: "gridResolucionGerencial",
                            url: './GestionTransparente?action=ResolucionGerencial',
                            dataQuery: [
                                {name: 'anho', value: $("anhosResolucionGerencial").get("value")},
                                {name: 'query', value: $("txtBuscarResolucionGerencial").get("value").replace("&", "$$")}
                            ],
                            success: function (e) {
                                $$(".tips").addEvent('click', function () {

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
                                {name: "titulo", field: 'N° Resoluci&oacute;n', width: "10%", sort: true, type: 'string'},
                                {name: "resumen", style: {"text-align": "justify"}, field: 'Resumen', width: "70%", type: 'string'},
                                {name: "id", field: 'Descargar', style: {"text-align": "center"}, width: "5%", clase: 'tips', title: 'Explicación', filtro: 'descripcion', activo: 'activo', type: 'string', renderer: function (val) {
                                        return '<a class="pdf"  target="_blank" href="./GestionTransparente?action=verResolucion&id=' + val + '&anho=' + $("anhosResolucionGerencial").get("value") + '"></a>'
                                    }}
                            ]
                        });
                    }
                });
                anhoResolucionGerencial.send();

                $("anhosResolucionGerencial").addEvent("change", function (evt) {
                    evt.stopPropagation();
                    tblResolucionGerencial.loadData([
                        {name: 'anho', value: $("anhosResolucionGerencial").get("value")},
                        {name: 'query', value: $("txtBuscarResolucionGerencial").get("value").replace("&", "$$")}
                    ]);
                });
                $("btnBuscarResolucionGerencial").addEvent("click", function (evt) {
                    evt.stopPropagation();
                    tblResolucionGerencial.loadData([
                        {name: 'anho', value: $("anhosResolucionGerencial").get("value")},
                        {name: 'query', value: $("txtBuscarResolucionGerencial").get("value").replace("&", "$$")}
                    ]);
                });
                $("txtBuscarResolucionGerencial").addEvent("keypress", function (evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblResolucionGerencial.loadData([
                            {name: 'anho', value: $("anhosResolucionGerencial").get("value")},
                            {name: 'query', value: $("txtBuscarResolucionGerencial").get("value").replace("&", "$$")}
                        ]);
                    }
                });

                //////////////documentos de gestion
                var $cargarCategoriaDoc = function (divCont, tipo) {
                    $(divCont).empty();
                    $(divCont).addEvent("change", function (evt) {
                        evt.stopPropagation();
                        tblDocumentoGestion.loadData([
                            {name: 'cateId', value: this.get("value")},
                            {name: 'query', value: $("txtBuscarDocumentoGestion").get("value").replace("&", "$$")}
                        ]);
                    });
                    var cate = new Request.JSON({
                        url: "./GestionTransparente?action=listarCategoriaDocumento&tipo=" + tipo,
                        onSuccess: function (data) {
                            var varHTML = "";
                            varHTML += "<option value=''>TODOS</option>";
                            data.items.each(function (node) {
                                if (opcion == node.cateId) {
                                    varHTML += "<option selected='selected' class='opcion1' value=" + node.cateId + ">" + node.nombre + "</option>";
                                } else
                                    varHTML += "<option  class='opcion1' value=" + node.cateId + ">" + node.nombre + "</option>";
                            });
                            $(divCont).set("html", varHTML);
                        }
                    });
                    cate.send();
                }
                $cargarCategoriaDoc("categoriaDocumento", 11);
                var array = {};
                if (opcion != "undefined" && opcion != undefined) {
                    array = {name: 'cateId', value: opcion}
                } else {
                    array = {name: 'tipo', value: 11}
                }

                var tblDocumentoGestion = new JpGrid($("tbl-documento-gestion"), {
                    id: "gridDocumentoGestion",
                    url: './GestionTransparente?action=DocumentoGestion',
                    dataQuery: [
                        {name: 'query', value: $("txtBuscarDocumentoGestion").get("value").replace("&", "$$")},
                        array
                    ],
                    params: {
                        limit: 15
                    },
                    success: function (e) {
                        $$(".tips").addEvent('click', function () {

                            ToolTip.instance(this, {
                                autohide: false,
                                position: {position: 'bottom', edge: 'top'}
                            },
                            this.get('dir')
                                    ).show();

                        });
                    },
                    model: [
                        {name: "titulo", field: 'Nombre', width: "25", sort: true, type: 'string'},
                        {name: "resumen", style: {"text-align": "justify"}, field: 'Descripci&oacute;n', width: "70%", type: 'string'},
                        {name: "id", field: ' Descargar', style: {"text-align": "center"}, width: "7%", clase: 'tips', title: 'Explicación', filtro: 'descripcion', activo: 'activo', type: 'string', renderer: function (val) {
                                return '<a class="pdf" target="_blank" href="./GestionTransparente?action=verDocumentosGestion&id=' + val + '"> </a>'
                            }}
                    ]
                });
                $("btnBuscarDocumentoGestion").addEvent("click", function (evt) {
                    evt.stopPropagation();
                    tblDocumentoGestion.loadData([
                        {name: 'query', value: $("txtBuscarDocumentoGestion").get("value").replace("&", "$$")}
                    ]);
                });
                $("txtBuscarDocumentoGestion").addEvent("keypress", function (evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblDocumentoGestion.loadData([
                            {name: 'query', value: $("txtBuscarDocumentoGestion").get("value").replace("&", "$$")}
                        ]);
                    }
                });
                /////Normativas 

                var tblNormaDirectiva = new JpGrid($("tbl-norma-directiva"), {
                    id: "gridNormaDirectiva",
                    url: './GestionTransparente?action=NormaDirectiva',
                    dataQuery: [
                        {name: 'query', value: $("txtBuscarNormaDirectiva").get("value").replace("&", "$$")}
                    ],
                    params: {
                        limit: 15
                    },
                    success: function (e) {
                        $$(".tips").addEvent('click', function () {
                            ToolTip.instance(this, {
                                autohide: false,
                                position: {position: 'bottom', edge: 'top'}
                            },
                            this.get('dir')
                                    ).show();

                        });
                    },
                    model: [
                        {name: "titulo", field: 'T&iacute;tulo', width: "17%", sort: true, type: 'string'},
                        {name: "resumen", style: {"text-align": "justify"}, field: 'Resumen', width: "72%", type: 'string'},
                        {name: "id", field: 'Descargar', style: {"text-align": "center"}, width: "7%", clase: 'tips', title: 'Explicación', filtro: 'descripcion', activo: 'activo', type: 'string', renderer: function (val) {
                                return '<a class="pdf" target="_blank" href="./GestionTransparente?action=verNormaDirectiva&id=' + val + '"> </a>'
                            }}
                    ]
                });
                $("btnBuscarNormaDirectiva").addEvent("click", function (evt) {
                    evt.stopPropagation();
                    tblNormaDirectiva.loadData([
                        {name: 'query', value: $("txtBuscarNormaDirectiva").get("value").replace("&", "$$")}
                    ]);
                });
                $("txtBuscarNormaDirectiva").addEvent("keypress", function (evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblNormaDirectiva.loadData([
                            {name: 'query', value: $("txtBuscarNormaDirectiva").get("value").replace("&", "$$")}
                        ]);
                    }
                });

                // Indicadores de Desempeño
                var tblIndicador;

                var anhoIndicador = new Request.HTML({
                    url: './Convocatoria?action=ListarAnhosDocumentos&cate_id=900',
                    onSuccess: function (responseTree, responseElements, responseHTML, responseJavaScript) {
                        $("anhosIndicador").set('html', responseHTML);
                        tblIndicador = new JpGrid($("tbl-indicador"), {
                            id: "gridIndicador",
                            url: './Convocatoria?action=Documentos',
                            dataQuery: [
                                {name: 'anho', value: $("anhosIndicador").get("value")},
                                {name: 'cate_id', value: 900},
                                {name: 'query', value: $("txtBuscarIndicador").get("value").replace("&", "$$")}
                            ],
                            success: function (e) {
                                $$(".tips").addEvent('click', function () {
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
                                {name: "titulo", field: 'Título', width: "25%", sort: true, type: 'string'},
                                {name: "resumen", style: {"text-align": "justify"}, field: 'Descripción', width: "60%", type: 'string'},
                                {name: "id", field: 'Descargar', style: {"text-align": "center"}, width: "7%", clase: 'tips', title: 'Explicación', filtro: 'descripcion', activo: 'activo', type: 'string', renderer: function (val) {
                                        return '<a class="pdf" target="_blank" href="./GestionTransparente?action=verResolucion&id=' + val + '&anho=' + $("anhosIndicador").get("value") + '"> </a>'
                                    }}
                            ]
                        });
                    }
                });
                anhoIndicador.send();

                $("anhosIndicador").addEvent("change", function (evt) {
                    evt.stopPropagation();
                    tblIndicador.loadData([
                        {name: 'anho', value: $("anhosIndicador").get("value")},
                        {name: 'cate_id', value: 900},
                        {name: 'query', value: $("txtBuscarIndicador").get("value").replace("&", "$$")}
                    ]);
                });
                $("btnBuscarIndicador").addEvent("click", function (evt) {
                    evt.stopPropagation();
                    tblIndicador.loadData([
                        {name: 'anho', value: $("anhosIndicador").get("value")},
                        {name: 'cate_id', value: 900},
                        {name: 'query', value: $("txtBuscarIndicador").get("value").replace("&", "$$")}
                    ]);
                });
                $("txtBuscarIndicador").addEvent("keypress", function (evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblIndicador.loadData([
                            {name: 'anho', value: $("anhosIndicador").get("value")},
                            {name: 'cate_id', value: 900},
                            {name: 'query', value: $("txtBuscarIndicador").get("value").replace("&", "$$")}
                        ]);
                    }
                });


                //DNG
                //// 
                var tblDNG;
                var anhoDNG = new Request.HTML({
                    url: './Convocatoria?action=ListarAnhosDocumentos&cate_id=2800',
                    onSuccess: function (responseTree, responseElements, responseHTML, responseJavaScript) {
                        $("anhosDNG").set('html', responseHTML);
                        tblDNG = new JpGrid($("tbl-dng"), {
                            id: "gridDNG",
                            url: './Convocatoria?action=Documentos',
                            dataQuery: [
                                {name: 'anho', value: $("anhosDNG").get("value")},
                                {name: 'cate_id', value: 2800},
                                {name: 'query', value: $("txtBuscarDNG").get("value").replace("&", "$$")}
                            ],
                            success: function (e) {
                                $$(".tips").addEvent('click', function () {
                                    ToolTip.instance(this, {
                                        autohide: false,
                                        position: {position: 'bottom', edge: 'top'}
                                    },
                                    this.get('dir')
                                            ).show();

                                });
                            },
                            model: [
                                {name: "titulo", field: 'T&iacute;tulo', width: "75%", sort: true, type: 'string'},
                                {name: "fecha", style: {"text-align": "center"}, field: 'Fecha', width: "15%", type: 'string'},
                                {name: "id", field: 'Descargar', style: {"text-align": "center"}, width: "7%", clase: 'tips', title: 'Explicación', filtro: 'descripcion', activo: 'activo', type: 'string', renderer: function (val) {
                                        return '<a class="pdf" target="_blank" href="./GestionTransparente?action=verNormaDirectiva&id=' + val + '"> </a>'
                                    }}
                            ]
                        });
                    }
                });

                anhoDNG.send();

                $("anhosDNG").addEvent("change", function (evt) {
                    evt.stopPropagation();
                    tblDNG.loadData([
                        {name: 'anho', value: $("anhosDNG").get("value")},
                        {name: 'cate_id', value: 2800},
                        {name: 'query', value: $("txtBuscarDNG").get("value").replace("&", "$$")}
                    ]);
                });

                $("btnBuscarDNG").addEvent("click", function (evt) {
                    evt.stopPropagation();
                    tblDNG.loadData([
                        {name: 'anho', value: $("anhosDNG").get("value")},
                        {name: 'cate_id', value: 2800},
                        {name: 'query', value: $("txtBuscarDNG").get("value").replace("&", "$$")}
                    ]);
                });
                $("txtBuscarDNG").addEvent("keypress", function (evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblDNG.loadData([
                            {name: 'anho', value: $("anhosDNG").get("value")},
                            {name: 'cate_id', value: 2800},
                            {name: 'query', value: $("txtBuscarDNG").get("value").replace("&", "$$")}
                        ]);
                    }
                });

                $$(".print").addEvent("click", function (evt) {
                    var url = this.get("rev");
                    var anho = this.getParent("label").getParent("div").getNext("div").getChildren(".anho").get("value");
                    //var mes = this.getParent("label").getParent("div").getNext("div").getChildren(".mes").get("value");
                    this.set("href", url + "?format=" + this.get("rel") + "&anho=" + anho);
                });

            });
        </script>
        <title>Documentos Normativos y de Gesti&oacute;n</title>
    </head>
    <body>
        <%@include file="../jspf/cabecera.jspf" %>  
        <div class="wrapper2">

            <div class="cuerpo">
                <div class="navegacion">
                    <h2>
                        <a href="./Inicio">Inicio</a> / <a href="./GestionTransparente">Gesti&oacute;n Transparente</a> / Documentos Normativos y de Gesti&oacute;n
                    </h2> 
                </div>
                <div class="services text-center">
                    <div class="gadget">
                        <div class="panel efecto active">

                            <div class="normas"></div>
                            <div class="descripcion" style="font-size:11px">Documentos Normativos y de Gestión</div>

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
                        <div class="panel efecto">
                            <a href="./GestionTransparente?action=infoAdicional">
                                <div class="resoluciones"></div>
                                <div class="descripcion" style="font-size:11px">Informaci&oacute;n Adicional</div>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="cdesk">              
                    <div class="sliderPanel">
                        <h2 id="st1">Resoluciones Gerenciales</h2>
                        <div id="sp1">
                            <div class="search">
                                <div class="content-l">

                                    <label style="margin: 10px auto auto 10px; float: left; font-weight: bold; color: #6A6C71;">Obtener Reporte completo en: </label>
                                    <label style="margin-left: 15px;">
                                        <a style="margin: auto 20px auto 0px;" target="_blank" rel="pdf" title="Seleccione el a&ntilde;o que desea para reportear" rev="./ResolucionPrint" class="print"><img src="./resources/images/16x16/pdf.png" /></a>
                                        <a style="margin: auto 10px auto 10px;" target="_blank" rel="excel" title="Seleccione el a&ntilde;o que desea para reportear" rev="./ResolucionPrint" class=" print"><img src="./resources/images/16x16/excel.png" /></a>
                                        <a style="margin: auto 10px auto 10px;" target="_blank" rel="odt" title="Seleccione el a&ntilde;o que desea para reportear"  rev="./ResolucionPrint" class="print"><img src="./resources/images/16x16/word.png" /></a>
                                    </label>
                                </div>
                                <div class="content-i"  style="width: 52%">
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Buscar Resolución:</label><input  id="txtBuscarResolucionGerencial" style="margin-right:3px" /><button id="btnBuscarResolucionGerencial">Buscar</button>             
                                    <label style="margin-right:13px; margin-left:5px; font-weight: bold; color: #6A6C71;">Filtrar por A&ntilde;o:</label><select class="anho" id="anhosResolucionGerencial"></select>
                                </div>
                            </div>
                            <div id="tbl-resolucion-gerencial" class="grid"></div>  
                        </div>
                    </div>
                    <div class="sliderPanel">
                        <h2 id="st5">Actas de Sesión de Consejo Directivo</h2>
                        <div id="sp5">
                            <div class="search">
                                <div class="content-l">
                                    <label style="margin-right:13px; margin-left:5px; font-weight: bold; color: #6A6C71;">Filtrar por A&ntilde;o:</label><select class="anho" id="anhosDNG"></select>
                                </div>
                                <div class="content-i">
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Buscar: </label><input  id="txtBuscarDNG" style="margin-right:3px" /><button id="btnBuscarDNG">Buscar</button>             
                                </div>
                            </div>
                            <div id="tbl-dng" class="grid"></div>  
                        </div>
                    </div>
                    <div class="sliderPanel">
                        <h2 id="st2">Documentos de Gesti&oacute;n</h2>
                        <div id="sp2">
                            <div class="search">
                                <div class="content-l">
                                    <label style="margin-right:13px; margin-left:5px; font-weight: bold; color: #6A6C71;">Filtrar por Categor&iacute;a:</label><select id="categoriaDocumento"></select>
                                </div>
                                <div class="content-i">
                                    <label style="margin-right:15px;margin-left:-50px; font-weight: bold; color: #6A6C71;">Buscar por Nombre o Descripci&oacute;n:</label><input  id="txtBuscarDocumentoGestion" style="margin-right:3px"/><button id="btnBuscarDocumentoGestion">Buscar</button>             
                                </div>
                            </div>
                            <div id="tbl-documento-gestion" class="grid"></div>  
                        </div>
                    </div>

                    <div class="sliderPanel">
                        <h2 id="st3">Normas y Directivas</h2>
                        <div id="sp3">
                            <div class="search">
                                <div class="content-i">
                                    <label style="margin-right:15px;margin-left:-50px; font-weight: bold; color: #6A6C71;">Buscar por T&iacute;tulo o Resumen:</label><input  id="txtBuscarNormaDirectiva" style="margin-right:3px" /><button id="btnBuscarNormaDirectiva">Buscar</button>             
                                </div>
                            </div>
                            <div id="tbl-norma-directiva" class="grid"></div>
                        </div>
                    </div>

                    <div class="sliderPanel">
                        <h2 id="st4">Indicadores de Desempeño</h2>
                        <div id="sp4">
                            <div class="search">
                                <div class="content-l">
                                    <label style="margin-right:13px; margin-left:5px; font-weight: bold; color: #6A6C71;">Filtrar por A&ntilde;o:</label><select id="anhosIndicador"></select>
                                </div>
                                <div class="content-i">
                                    <label style="margin-right:15px;margin-left:-50px; font-weight: bold; color: #6A6C71;">Buscar: </label><input  id="txtBuscarIndicador" style="margin-right:3px" /><button id="btnBuscarIndicador">Buscar</button>             
                                </div>
                            </div>
                            <div id="tbl-indicador" class="grid"></div>  
                        </div>
                    </div>


                </div>
            </div>
        </div>

        <%@include file="../jspf/pie.jspf" %>
    </body>
</html>
