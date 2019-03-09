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

                $("st1").addEvent('click', function(event) {
                    event.stop();
                    sp1.toggle();
                    sp2.hide();
                    sp3.hide();
                });

                $("st2").addEvent('click', function(event) {
                    event.stop();
                    sp1.hide();
                    sp2.toggle();
                    sp3.hide();
                });

                $("st3").addEvent('click', function(event) {
                    event.stop();
                    sp1.hide();
                    sp2.hide();
                    sp3.toggle();
                });

                var sp1 = $("sp1");
                var sp2 = $("sp2");
                var sp3 = $("sp3");

                sp1.hide();
                sp2.hide();
                sp3.hide();
                
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
                }
                var tblPresupuesto = new JpGrid($("tbl-presupuesto"), {
                    id: "gridPresupuesto",
                    url: './GestionTransparente?action=listarPresupuesto',
                    altura: '240px',
                    dataQuery: [
                        {name: 'tipo', value: $("presupuestoCmb").get("value")},
                        {name: 'query', value: $("txtBuscarPresupuesto").get("value").replace("&", "$$")}
                    ],
                    model: [
                        //{name: "anho", field: 'Año', width: "10%", sort: true, type: 'string'},
                        {name: "fechaAprobacion", field: 'Fecha', width: "7%"},
                        {name: "descripcion", field: 'Descripci&oacute;n', width: "30%", sort: true},
                        {name: "resolucionAprobacion", field: 'Documento de Aprobaci&oacute;n', width: "40%", type: 'string'},
                        {name: "docuId", field: 'Descargar', style: {"text-align": "center"}, width: "7%", clase: 'tips', title: 'Explicación', filtro: 'descripcion', activo: 'activo', type: 'string', renderer: function(val) {
                                return '<a class="pdf" target="_blank" href="./GestionTransparente?action=verDocumentosGestion&id=' + val + '"></a>'
                            }}
                    ]
                });

                var loadControlPresupuesto = function() {
                    $("divAnhoPresupuesto").hide();
                    $("divMesPresupuesto").hide();
                    if ($("presupuestoCmb").get("value") == "2") {
                        $("divAnhoPresupuesto").toggle();
                        $("divMesPresupuesto").toggle();
                        var anhoPresupuesto = new Request.HTML({
                            url: './GestionTransparente?action=ListarAnhosPresupuesto',
                            onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                                $("anhosPresupuesto").set('html', responseHTML);
                                $("anhosPresupuesto").addEvent("change", function(evt) {
                                    evt.stopPropagation();
                                    loadDataPresupuesto();
                                });
                                loadDataPresupuesto();
                            }}).send();
                    } else
                        tblPresupuesto.loadData([
                            {name: 'tipo', value: $("presupuestoCmb").get("value")},
                            {name: 'query', value: $("txtBuscarPresupuesto").get("value").replace("&", "$$")}
                        ]);
                }
                $("presupuestoCmb").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    loadControlPresupuesto();
                });
                loadControlPresupuesto();
                var loadDataPresupuesto = function() {
                    var loadSubDataPre = function() {
                        tblPresupuesto.loadData([
                            {name: 'mes', value: $("mesPresupuesto").get("value")},
                            {name: 'anho', value: $("anhosPresupuesto").get("value")},
                            {name: 'tipo', value: $("presupuestoCmb").get("value")},
                            {name: 'query', value: $("txtBuscarPresupuesto").get("value").replace("&", "$$")}
                        ]);
                    }
                    var mesPresupuesto = new Request.HTML({
                        url: './GestionTransparente?action=ListarMesPresupuesto&anho=' + $("anhosPresupuesto").get("value"),
                        onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                            $("mesPresupuesto").set('html', responseHTML);
                            $("mesPresupuesto").addEvent("change", function(evt) {
                                evt.stopPropagation();
                                loadSubDataPre();
                            });
                            loadSubDataPre();
                        }
                    }).send();
                }
                $("btnBuscarPresupuesto").addEvent("click", function(evt) {
                    evt.stopPropagation();
                    tblPresupuesto.loadData([
                        {name: 'mes', value: $("mesPresupuesto").get("value")},
                        {name: 'anho', value: $("anhosPresupuesto").get("value")},
                        {name: 'tipo', value: $("presupuestoCmb").get("value")},
                        {name: 'query', value: $("txtBuscarPresupuesto").get("value").replace("&", "$$")}
                    ]);
                });

                $("txtBuscarPresupuesto").addEvent("keypress", function(evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblPresupuesto.loadData([
                            {name: 'mes', value: $("mesPresupuesto").get("value")},
                            {name: 'anho', value: $("anhosPresupuesto").get("value")},
                            {name: 'tipo', value: $("presupuestoCmb").get("value")},
                            {name: 'query', value: $("txtBuscarPresupuesto").get("value").replace("&", "$$")}
                        ]);
                    }
                });

                var loadDataFinanza = function() {
                    var anhoFinanza = new Request.HTML({
                        url: './GestionTransparente?action=ListarAnhosFinanza&tipo=' + $("finanzaCmb").get("value"),
                        onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                            $("anhosFinanza").set('html', responseHTML);
                            $("anhosFinanza").addEvent("change", function(evt) {
                                evt.stopPropagation();
                                loadControlFinanza();
                            });
                            loadControlFinanza();
                        }}).send();
                }

                var tblFinanza;
                tblFinanza = new JpGrid($("tbl-finanza"), {
                    id: "gridFinanza",
                    url: './GestionTransparente?action=listarFinanza',
                    altura: '240px',
                    dataQuery: [
                        {name: 'tipo', value: $("finanzaCmb").get("value")},
                        {name: 'query', value: $("txtBuscarFinanza").get("value").replace("&", "$$")}
                    ],
                    model: [
                        {name: "mes", field: 'Fecha', width: "15%",
                            items: [{id: "01", valor: "Enero"},
                                {id: "02", valor: "Febrero"},
                                {id: "03", valor: "Marzo"},
                                {id: "04", valor: "Abril"},
                                {id: "05", valor: "Mayo"},
                                {id: "06", valor: "Junio"},
                                {id: "07", valor: "Julio"},
                                {id: "08", valor: "Agosto"},
                                {id: "09", valor: "Setiembre"},
                                {id: "10", valor: "Octubre"},
                                {id: "11", valor: "Noviembre"},
                                {id: "12", valor: "Diciembre"}]
                        },
                        {name: "descripcion", field: 'Descripci&oacute;n', width: "60%", sort: true},
                        {name: "docuId", field: 'Descargar', style: {"text-align": "center"}, width: "7%", clase: 'tips', title: 'Explicación', filtro: 'descripcion', activo: 'activo', type: 'string', renderer: function(val) {
                                return '<a class="pdf" target="_blank" href="./GestionTransparente?action=verDocumentosGestion&id=' + val + '"></a>'
                            }}
                    ]
                });

                var loadControlFinanza = function() {
                    var modelo;
                    if ($("finanzaCmb").get("value") == "2" || $("finanzaCmb").get("value") == "8") {
                        modelo = [
                            {name: "mes", width: "15%", items: [{id: "01", valor: "Enero"},
                                    {id: "02", valor: "Febrero"},
                                    {id: "03", valor: "Marzo"},
                                    {id: "04", valor: "Abril"},
                                    {id: "05", valor: "Mayo"},
                                    {id: "06", valor: "Junio"},
                                    {id: "07", valor: "Julio"},
                                    {id: "08", valor: "Agosto"},
                                    {id: "09", valor: "Setiembre"},
                                    {id: "10", valor: "Octubre"},
                                    {id: "11", valor: "Noviembre"},
                                    {id: "12", valor: "Diciembre"}]
                            },
                            {name: "descripcion", width: "60%", sort: true},
                            {name: "docuId", width: "5%", style: {"text-align": "center"}, clase: 'tips', title: 'Explicación', filtro: 'descripcion', activo: 'activo', type: 'string', renderer: function(val) {
                                    return '<a class="pdf" target="_blank" href="./GestionTransparente?action=verDocumentosGestion&id=' + val + '"></a>'
                                }}
                        ]

                    } else {
                        modelo = [
                            {name: "fecha"},
                            {name: "descripcion"},
                            {name: "docuId", clase: 'tips', style: {"text-align": "center"}, title: 'Explicación', filtro: 'descripcion', activo: 'activo', type: 'string', renderer: function(val) {
                                    return '<a class="pdf" target="_blank" href="./GestionTransparente?action=verDocumentosGestion&id=' + val + '"></a>'
                                }}
                        ]
                    }
                    tblFinanza.loadData([
                        {name: 'anho', value: $("anhosFinanza").get("value")},
                        {name: 'tipo', value: $("finanzaCmb").get("value")},
                        {name: 'query', value: $("txtBuscarFinanza").get("value").replace("&", "$$")}
                    ], modelo);
                }
                $("finanzaCmb").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    loadDataFinanza();
                });
                loadDataFinanza();

                $("btnBuscarFinanza").addEvent("click", function(evt) {
                    evt.stopPropagation();
                    tblFinanza.loadData([
                        {name: 'anho', value: $("anhosFinanza").get("value")},
                        {name: 'tipo', value: $("finanzaCmb").get("value")},
                        {name: 'query', value: $("txtBuscarFinanza").get("value").replace("&", "$$")}
                    ]);
                });

                $("txtBuscarFinanza").addEvent("keypress", function(evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblFinanza.loadData([
                            {name: 'anho', value: $("anhosFinanza").get("value")},
                            {name: 'tipo', value: $("finanzaCmb").get("value")},
                            {name: 'query', value: $("txtBuscarFinanza").get("value").replace("&", "$$")}
                        ]);
                    }
                });

                //info Presupuestal
                var loadDatainfoPresupuesto = function() {

                    var anhoinfoPresupuesto = new Request.HTML({
                        url: './GestionTransparente?action=ListarAnhosFinanza&tipo=' + $("infoPresupuestoCmb").get("value"),
                        onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                            $("anhosinfoPresupuesto").set('html', responseHTML);
                            $("anhosinfoPresupuesto").addEvent("change", function(evt) {
                                evt.stopPropagation();
                                loadControlinfoPresupuesto();
                            });
                            loadControlinfoPresupuesto();
                        }}).send();
                }


                var items = [{id: "01", valor: "Enero"},
                    {id: "02", valor: "Febrero"},
                    {id: "03", valor: "Marzo"},
                    {id: "04", valor: "Abril"},
                    {id: "05", valor: "Mayo"},
                    {id: "06", valor: "Junio"},
                    {id: "07", valor: "Julio"},
                    {id: "08", valor: "Agosto"},
                    {id: "09", valor: "Setiembre"},
                    {id: "10", valor: "Octubre"},
                    {id: "11", valor: "Noviembre"},
                    {id: "12", valor: "Diciembre"}];

                var itemsT = [{id: "01", valor: "Primer trimestre"},
                    {id: "02", valor: "Primer trimestre"},
                    {id: "03", valor: "Primer trimestre"},
                    {id: "04", valor: "Segundo trimestre"},
                    {id: "05", valor: "Segundo trimestre"},
                    {id: "06", valor: "Segundo trimestre"},
                    {id: "07", valor: "Tercer trimestre"},
                    {id: "08", valor: "Tercer trimestre"},
                    {id: "09", valor: "Tercer trimestre"},
                    {id: "10", valor: "Cuarto trimestre"},
                    {id: "11", valor: "Cuarto trimestre"},
                    {id: "12", valor: "Cuarto trimestre"}];

                var tblinfoPresupuesto;
                tblinfoPresupuesto = new JpGrid($("tbl-infoPresupuesto"), {
                    id: "gridinfoPresupuesto",
                    url: './GestionTransparente?action=listarFinanza',
                    altura: '240px',
                    dataQuery: [
                        {name: 'tipo', value: $("infoPresupuestoCmb").get("value")},
                        {name: 'query', value: $("txtBuscarinfoPresupuesto").get("value").replace("&", "$$")}
                    ],
                    model: [
                        {name: "mes", field: 'Periodo', width: "15%",
                            renderer: function(val) {
                                result = "";
                                if ($("infoPresupuestoCmb").get("value") != "3") {
                                    items.each(function(node, index) {
                                        if (node["id"] == val)
                                            result = node["valor"];
                                    });
                                } else {
                                    itemsT.each(function(node, index) {
                                        if (node["id"] == val)
                                            result = node["valor"];
                                    });
                                }
                                return result;
                            }
                        },
                        {name: "descripcion", field: 'Descripci&oacute;n', width: "65%", sort: true},
                        {name: "docuId", field: 'Descargar', style: {"text-align": "center"}, width: "7%", clase: 'tips', title: 'Explicación', filtro: 'descripcion', activo: 'activo', type: 'string', renderer: function(val) {
                                return '<a class="pdf" target="_blank" href="./GestionTransparente?action=verDocumentosGestion&id=' + val + '"></a>'
                            }}
                    ]
                });

                var loadControlinfoPresupuesto = function() {

                    tblinfoPresupuesto.loadData([
                        {name: 'anho', value: $("anhosinfoPresupuesto").get("value")},
                        {name: 'tipo', value: $("infoPresupuestoCmb").get("value")},
                        {name: 'query', value: $("txtBuscarinfoPresupuesto").get("value").replace("&", "$$")}
                    ]);
                }
                $("infoPresupuestoCmb").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    loadDatainfoPresupuesto();
                });
                loadDatainfoPresupuesto();

                $("btnBuscarinfoPresupuesto").addEvent("click", function(evt) {
                    evt.stopPropagation();
                    tblinfoPresupuesto.loadData([
                        {name: 'anho', value: $("anhosinfoPresupuesto").get("value")},
                        {name: 'tipo', value: $("infoPresupuestoCmb").get("value")},
                        {name: 'query', value: $("txtBuscarinfoPresupuesto").get("value").replace("&", "$$")}
                    ]);
                });

                $("txtBuscarinfoPresupuesto").addEvent("keypress", function(evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblinfoPresupuesto.loadData([
                            {name: 'anho', value: $("anhosinfoPresupuesto").get("value")},
                            {name: 'tipo', value: $("infoPresupuestoCmb").get("value")},
                            {name: 'query', value: $("txtBuscarinfoPresupuesto").get("value").replace("&", "$$")}
                        ]);
                    }
                });
            });
        </script>
        <title>Presupuesto y Finanzas</title>
    </head>
    <body>
        <%@include file="../jspf/cabecera.jspf" %>  
        <div class="wrapper2">
            
            <div class="cuerpo">
                <div class="navegacion">
                    <h2>
                        <a href="./Inicio">Inicio</a> / <a href="./GestionTransparente">Gesti&oacute;n Transparente</a> / Presupuesto y Finanzas
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
                        <div class="panel efecto active">
                            <div class="presupuesto"></div>
                            <div class="descripcion" style="font-size:11px">Presupuesto y Finanzas</div>
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
                        <h2 id="st1">Presupuesto Institucional de Apertura (PIA) y Presupuesto Institucional Modificado (PIM)</h2>
                        <div id="sp1">
                            <div class="search">
                                <div class="content-l">
                                    <label style="margin-right:13px; margin-left:5px; font-weight: bold; color: #6A6C71;">Seleccione Categor&iacute;a:</label>
                                    <select id="presupuestoCmb">
                                        <option value='1' selected="selected">PIA</option>
                                        <option value="2">PIM </option>
                                    </select>
                                    <div style="float:right; display: none" id="divMesPresupuesto"><label style="margin-right:8px; margin-left:5px; font-weight: bold; color: #6A6C71;"> Mes: </label><select id="mesPresupuesto"></select></div>
                                    <div style="float:right; display: none" id="divAnhoPresupuesto"><label style="margin-right:8px; margin-left:5px; font-weight: bold; color: #6A6C71;"> A&ntilde;o: </label><select id="anhosPresupuesto"></select></div>
                                </div>
                                <div class="content-i" style="width: 52%">
                                    <label style="margin-right:13px; margin-left:5px; font-weight: bold; color: #6A6C71;"> Buscar por Descripci&oacute;n o Doc. de Aprobaci&oacute;n:</label><input type="text" id="txtBuscarPresupuesto" style="margin-right:3px"/><button id="btnBuscarPresupuesto">Buscar</button>
                                </div>
                            </div>
                            <div id="tbl-presupuesto" class="grid"></div>  
                        </div>                                              
                    </div>
                    <div class="sliderPanel">
                        <h2 id="st2">Informaci&oacute;n Financiera</h2>
                        <div id="sp2">
                            <div class="search">
                                <div class="content-l">
                                    <label style="margin-right:13px; margin-left:5px; font-weight: bold; color: #6A6C71;">Selecione Categor&iacute;a:</label>
                                    <select id="finanzaCmb">
                                        <option value="2">Estados de Situaci&oacute;n Financiera </option>
                                        <option value="8">Estados de Gesti&oacute;n </option>
                                        <option value="6">Estados de Cambio en el Patrimonio Neto </option>
                                        <option value="7">Estados de Flujo de Efectivo </option>
                                        <option value="5">Saldos de Balance </option>
                                    </select>
                                    <div style="float:right; " id="divAnhoFinanza"><label style="margin-right:13px; margin-left:5px; font-weight: bold; color: #6A6C71;"> A&ntilde;o: </label><select id="anhosFinanza"></select></div>
                                </div>
                                <div class="content-i">
                                    <label style="margin-right:13px; margin-left:5px; font-weight: bold; color: #6A6C71;">Buscar por Descripci&oacute;n:</label><input type="text" id="txtBuscarFinanza" style="margin-right:3px"/><button id="btnBuscarFinanza">Buscar</button>
                                </div>
                            </div>
                            <div id="tbl-finanza" class="grid"></div>
                        </div>
                    </div>

                    <div class="sliderPanel">
                        <h2 id="st3">Informaci&oacute;n Presupuestal</h2>
                        <div id="sp3">
                            <div class="search">
                                <div class="content-l">
                                    <label style="margin-right:13px; margin-left:5px; font-weight: bold; color: #6A6C71;">Selecione Categor&iacute;a:</label>
                                    <select id="infoPresupuestoCmb">
                                        <option value='1'>Ejecuci&oacute;n Presupuestal</option>
                                        <option value="3">Evaluaci&oacute;n de Ingresos </option>
                                        <option value="4">Resumen de Gastos por Espec&iacute;fica </option>
                                    </select>
                                    <div style="float:right; " id="divAnhoinfoPresupuesto"><label style="margin-right:13px; margin-left:5px; font-weight: bold; color: #6A6C71;"> A&ntilde;o: </label><select id="anhosinfoPresupuesto"></select></div>
                                </div>
                                <div class="content-i">
                                    <label style="margin-right:13px; margin-left:5px; font-weight: bold; color: #6A6C71;">Buscar por Descripci&oacute;n:</label><input type="text" id="txtBuscarinfoPresupuesto" style="margin-right:3px"/><button id="btnBuscarinfoPresupuesto">Buscar</button>
                                </div>
                            </div>
                            <div id="tbl-infoPresupuesto" class="grid"></div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
        <%@include file="../jspf/pie.jspf" %>
    </body>
</html>
