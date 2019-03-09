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
               /* $("cab1").addEvent("click", function() {
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
                var tblBienes, tblServicios, tblPublicidad, tblVehiculo, tblVehiculo, tblProveedor;
                var anhoComprasBienes, anhoComprasServicios, anhoPublicidad, anhoVehiculo, anhoVehiculo, anhoProveedor;
                $("st1").addEvent('click', function(event) {
                    event.stop();
                    sp1.toggle();
                    sp2.hide();
                    sp3.hide();
                    sp4.hide();
                    sp5.hide();
                    sp6.hide();
                    sp7.hide();
                    sp8.hide();
                    sp9.hide();
                    sp10.hide();
                    sp11.hide();
                    sp12.hide();
                });

                $("st2").addEvent('click', function(event) {
                    event.stop();
                    sp1.hide();
                    sp2.toggle();
                    sp3.hide();
                    sp4.hide();
                    sp5.hide();
                    sp6.hide();
                    sp7.hide();
                    sp8.hide();
                    sp9.hide();
                    sp10.hide();
                    sp11.hide();
                    sp12.hide();
                });

                $("st3").addEvent('click', function(event) {
                    event.stop();
                    sp1.hide();
                    sp2.hide();
                    sp3.toggle();
                    sp4.hide();
                    sp5.hide();
                    sp6.hide();
                    sp7.hide();
                    sp8.hide();
                    sp9.hide();
                    sp10.hide();
                    sp11.hide();
                    sp12.hide();
                });

                $("st4").addEvent('click', function(event) {
                    event.stop();
                    sp1.hide();
                    sp2.hide();
                    sp3.hide();
                    sp4.toggle();
                    sp5.hide();
                    sp6.hide();
                    sp7.hide();
                    sp8.hide();
                    sp9.hide();
                    sp10.hide();
                    sp11.hide();
                    sp12.hide();
                });

                $("st5").addEvent('click', function(event) {
                    event.stop();
                    sp1.hide();
                    sp2.hide();
                    sp3.hide();
                    sp4.hide();
                    sp5.toggle();
                    sp6.hide();
                    sp7.hide();
                    sp8.hide();
                    sp9.hide();
                    sp10.hide();
                    sp11.hide();
                    sp12.hide();
                });

                $("st6").addEvent('click', function(event) {
                    event.stop();
                    sp1.hide();
                    sp2.hide();
                    sp3.hide();
                    sp4.hide();
                    sp5.hide();
                    sp6.toggle();
                    sp7.hide();
                    sp8.hide();
                    sp9.hide();
                    sp10.hide();
                    sp11.hide();
                    sp12.hide();
                });

                $("st7").addEvent('click', function(event) {
                    event.stop();
                    sp1.hide();
                    sp2.hide();
                    sp3.hide();
                    sp4.hide();
                    sp5.hide();
                    sp6.hide();
                    sp7.toggle();
                    sp8.hide();
                    sp9.hide();
                    sp10.hide();
                    sp11.hide();
                    sp12.hide();
                });

                $("st8").addEvent('click', function(event) {
                    event.stop();
                    sp1.hide();
                    sp2.hide();
                    sp3.hide();
                    sp4.hide();
                    sp5.hide();
                    sp6.hide();
                    sp7.hide();
                    sp8.toggle();
                    sp9.hide();
                    sp10.hide();
                    sp11.hide();
                    sp12.hide();
                });

                $("st9").addEvent('click', function(event) {
                    event.stop();
                    sp1.hide();
                    sp2.hide();
                    sp3.hide();
                    sp4.hide();
                    sp5.hide();
                    sp6.hide();
                    sp7.hide();
                    sp8.hide();
                    sp9.toggle();
                    sp10.hide();
                    sp11.hide();
                    sp12.hide();
                });

                $("st10").addEvent('click', function(event) {
                    event.stop();
                    sp1.hide();
                    sp2.hide();
                    sp3.hide();
                    sp4.hide();
                    sp5.hide();
                    sp6.hide();
                    sp7.hide();
                    sp8.hide();
                    sp9.hide();
                    sp10.toggle();
                    sp11.hide();
                    sp12.hide();
                });

                $("st11").addEvent('click', function(event) {
                    event.stop();
                    sp1.hide();
                    sp2.hide();
                    sp3.hide();
                    sp4.hide();
                    sp5.hide();
                    sp6.hide();
                    sp7.hide();
                    sp8.hide();
                    sp9.hide();
                    sp10.hide();
                    sp11.toggle();
                    sp12.hide();
                });
                $("st12").addEvent('click', function(event) {
                    event.stop();
                    sp1.hide();
                    sp2.hide();
                    sp3.hide();
                    sp4.hide();
                    sp5.hide();
                    sp6.hide();
                    sp7.hide();
                    sp8.hide();
                    sp9.hide();
                    sp10.hide();
                    sp11.hide();
                    sp12.toggle();
                });

                var sp1 = $("sp1");//new Fx.Slide('sp1', {mode: 'vertical'});
                var sp2 = $("sp2");//new Fx.Slide('sp2', {mode: 'vertical'});
                var sp3 = $("sp3");//new Fx.Slide('sp3', {mode: 'vertical'});
                var sp4 = $("sp4");//new Fx.Slide('sp4', {mode: 'vertical'});                
                var sp5 = $("sp5");//new Fx.Slide('sp5', {mode: 'vertical'});
                var sp6 = $("sp6");//new Fx.Slide('sp6', {mode: 'vertical'});
                var sp7 = $("sp7");
                var sp8 = $("sp8");
                var sp9 = $("sp9");
                var sp10 = $("sp10");
                var sp11 = $("sp11");
                var sp12 = $("sp12");

                sp1.hide();
                sp2.hide();
                sp3.hide();
                sp4.hide();
                sp5.hide();
                sp6.hide();
                sp7.hide();
                sp8.hide();
                sp9.hide();
                sp10.hide();
                sp11.hide();
                sp12.hide();

                var tab = get()["tab"];

                switch (tab) {
                    case "1" :
                        sp1.setFocus();
                        sp1.toggle();
                        
                        break;
                    case "2" :
                        sp2.toggle();
                        sp2.setFocus();
                        break;
                    case "3" :
                        sp3.toggle();
                        sp3.setFocus();
                        break;
                    case "4" :
                        sp4.toggle();
                        sp4.setFocus();
                        break;
                    case "5" :
                        sp5.toggle();
                        sp5.setFocus();
                        break;
                    case "6" :
                        sp6.toggle();
                        sp6.setFocus();
                        break;
                    case "7" :
                        sp7.toggle();
                        sp7.setFocus();
                        break;
                    case "8" :
                        sp8.toggle();
                        sp8.setFocus();
                        break;
                    case "9" :
                        sp9.toggle();
                        sp9.setFocus();
                        break;
                    case "10" :
                        sp10.toggle();
                        sp10.setFocus();
                        break;
                    case "11" :
                        sp11.toggle();
                        sp11.setFocus();
                        break;
                    case "12" :
                        sp12.toggle();
                        sp12.setFocus();
                        break;
                }

                var meses = [
                    {id: "01", valor: "Enero"},
                    {id: "1", valor: "Enero"},
                    {id: "02", valor: "Febrero"},
                    {id: "2", valor: "Febrero"},
                    {id: "03", valor: "Marzo"},
                    {id: "3", valor: "Marzo"},
                    {id: "04", valor: "Abril"},
                    {id: "4", valor: "Abril"},
                    {id: "05", valor: "Mayo"},
                    {id: "5", valor: "Mayo"},
                    {id: "06", valor: "Junio"},
                    {id: "6", valor: "Junio"},
                    {id: "07", valor: "Julio"},
                    {id: "7", valor: "Julio"},
                    {id: "08", valor: "Agosto"},
                    {id: "8", valor: "Agosto"},
                    {id: "09", valor: "Setiembre"},
                    {id: "9", valor: "Setiembre"},
                    {id: "10", valor: "Octubre"},
                    {id: "11", valor: "Noviembre"},
                    {id: "12", valor: "Diciembre"},
                ]

                tblBienes = new JpGrid($("tbl-bienes"), {
                    id: "gridComprasBienes",
                    url: './GestionTransparente?action=ComprasBienes',
                    altura: 'auto',
                    dataQuery: [
                        {name: 'anho', value: $("anhosComprasBienes").get("value")},
                        {name: 'mes', value: $("mesComprasBienes").get("value")},
                        {name: 'query', value: $("txtBuscarComprasBienes").get("value").replace("&", "$$")}
                    ],
                    model: [
                        {name: "nro", field: 'N° Orden', width: "10%", sort: true, type: 'string', style: {"text-align": "center"}},
                        {name: "nroSiaf", field: 'N° SIAF', width: "10%", style: {"text-align": "center"}},
                        {name: "fecha", field: 'Fecha de Emisión', width: "10%", type: 'date', style: {"text-align": "center"}},
                        {name: "fuenteFinanciamiento", field: 'Fuente de Financiamiento', width: "30%"},
                        {name: "proveedor", field: 'Proveedor', width: "30%", sort: true},
                        {name: "monto", field: 'Monto (S/.)', width: "20%", type: 'numeric', style: {"text-align": "right"}}
                    ]
                });



                var cargarMesBienes = function() {
                    var mesComprasBienes = new Request.HTML({
                        url: './GestionTransparente?action=ListarMesOrdenCompra&anho=' + $("anhosComprasBienes").get("value"),
                        onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                            $("mesComprasBienes").set('html', responseHTML);
                            var mesHTML = "";
                            $$(".mesComprasBienes").each(function(e) {

                                var texto = e.get("text").trim();
                                if (texto.lenght <= 1)
                                    texto = "0" + texto;
                                var i = 0;
                                meses.each(function(node, index) {
                                    if (node["id"] == texto && i == 0) {
                                        i = 1;
                                        mesHTML += "<option value=" + node["id"] + ">" + node["valor"] + "</option>";

                                    }
                                });

                            });

                            $("mesComprasBienes").set('html', mesHTML);

                            tblBienes.loadData([
                                {name: 'anho', value: $("anhosComprasBienes").get("value")},
                                {name: 'mes', value: $("mesComprasBienes").get("value")},
                                {name: 'query', value: $("txtBuscarComprasBienes").get("value").replace("&", "$$")}
                            ]);
                        }
                    }).send();
                }
                $("mesComprasBienes").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    tblBienes.loadData([
                        {name: 'anho', value: $("anhosComprasBienes").get("value")},
                        {name: 'mes', value: $("mesComprasBienes").get("value")},
                        {name: 'query', value: $("txtBuscarComprasBienes").get("value").replace("&", "$$")}
                    ]);
                });
                anhoComprasBienes = new Request.HTML({
                    url: './GestionTransparente?action=ListarAnhosComprasBienes',
                    onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                        $("anhosComprasBienes").set('html', responseHTML);
                        cargarMesBienes();
                    }
                });
                anhoComprasBienes.send();

                $("anhosComprasBienes").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    cargarMesBienes();
                });
                $("txtBuscarComprasBienes").addEvent("keypress", function(evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblBienes.loadData([
                            {name: 'anho', value: $("anhosComprasBienes").get("value")},
                            {name: 'mes', value: $("mesComprasBienes").get("value")},
                            {name: 'query', value: $("txtBuscarComprasBienes").get("value").replace("&", "$$")}
                        ]);
                    }
                });

                /*************************/
                tblServicios = new JpGrid($("tbl-servicios"), {
                    id: "gridComprasServicios",
                    url: './GestionTransparente?action=ComprasServicios',
                    altura: 'auto',
                    dataQuery: [
                        {name: 'anho', value: $("anhosComprasServicios").get("value")},
                        {name: 'mes', value: $("mesComprasServicios").get("value")},
                        {name: 'query', value: $("txtBuscarComprasServicios").get("value").replace("&", "$$")}
                    ],
                    model: [
                        {name: "nro", field: 'N° Orden', width: "10%", sort: true, type: 'string', style: {"text-align": "center"}},
                        {name: "nroSiaf", field: 'N° SIAF', width: "10%", style: {"text-align": "center"}},
                        {name: "fecha", field: 'Fecha de Emisión', width: "10%", type: 'date', style: {"text-align": "center"}},
                        {name: "fuenteFinanciamiento", field: 'Fuente de Financiamiento', width: "30%"},
                        {name: "proveedor", field: 'Proveedor', width: "30%", sort: true},
                        {name: "monto", field: 'Monto (S/.)', width: "20%", type: 'numeric', style: {"text-align": "right"}}
                    ]
                });
                var cargarMesServicios = function() {
                    var mesComprasBienes = new Request.HTML({
                        url: './GestionTransparente?action=ListarMesOrdenServicio&anho=' + $("anhosComprasServicios").get("value"),
                        onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                            $("mesComprasServicios").set('html', responseHTML);

                            var mesHTML = "";
                            $$(".mesComprasServicios").each(function(e) {
                                var texto = e.get("text").trim();
                                var i = 0;
                                meses.each(function(node, index) {
                                    if (node["id"] == texto && i == 0) {
                                        i = 1;
                                        mesHTML += "<option value=" + node["id"] + ">" + node["valor"] + "</option>";

                                    }
                                });
                            });

                            $("mesComprasServicios").set('html', mesHTML);
                            tblServicios.loadData([
                                {name: 'anho', value: $("anhosComprasServicios").get("value")},
                                {name: 'mes', value: $("mesComprasServicios").get("value")},
                                {name: 'query', value: $("txtBuscarComprasServicios").get("value").replace("&", "$$")}
                            ]);
                        }
                    }).send();
                }


                anhoComprasServicios = new Request.HTML({
                    url: './GestionTransparente?action=ListarAnhosComprasServicios',
                    onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                        $("anhosComprasServicios").set('html', responseHTML);
                        cargarMesServicios();
                    }
                });
                anhoComprasServicios.send();
                $("anhosComprasServicios").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    cargarMesServicios();
                });
                $("mesComprasServicios").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    tblServicios.loadData([
                        {name: 'anho', value: $("anhosComprasServicios").get("value")},
                        {name: 'mes', value: $("mesComprasServicios").get("value")},
                        {name: 'query', value: $("txtBuscarComprasServicios").get("value").replace("&", "$$")}
                    ]);
                });

                $("txtBuscarComprasServicios").addEvent("keypress", function(evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblServicios.loadData([
                            {name: 'anho', value: $("anhosComprasServicios").get("value")},
                            {name: 'mes', value: $("mesComprasServicios").get("value")},
                            {name: 'query', value: $("txtBuscarComprasServicios").get("value").replace("&", "$$")}
                        ]);
                    }
                });
                anhoPublicidad = new Request.HTML({
                    url: './GestionTransparente?action=ListarAnhosPublicidad',
                    onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                        $("anhosPublicidad").set('html', responseHTML);
                        tblPublicidad = new JpGrid($("tbl-publicidad"), {
                            id: "gridComprasPublicidad",
                            url: './GestionTransparente?action=Publicidad',
                            altura: 'auto',
                            dataQuery: [
                                {name: 'anho', value: $("anhosPublicidad").get("value")},
                                {name: 'query', value: $("txtBuscarPublicidad").get("value").replace("&", "$$")}
                            ],
                            model: [
                                {name: "contrato", field: 'N° de Contrato', width: "22%", sort: true, type: 'string', style: {"text-align": "center"}},
                                {name: "objetoContrato", field: 'Objeto del Contrato', width: "24%", type: 'string'},
                                {name: "proveedor", field: 'Proveedor', width: "39%", sort: true},
                                {name: "ruc", field: 'R.U.C', width: "5%", sort: true, type: 'string', style: {"text-align": "center"}},
                                {name: "penalidad", field: 'Penalidad (S/.)', width: "5%", type: 'numeric'},
                                {name: "costoFinal", field: 'Costo Final (S/.)', width: "10%", type: 'numeric', style: {"text-align": "right"}}
                            ]
                        });
                    }
                });
                anhoPublicidad.send();
                $("anhosPublicidad").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    tblPublicidad.loadData([
                        {name: 'anho', value: $("anhosPublicidad").get("value")},
                        {name: 'query', value: $("txtBuscarPublicidad").get("value").replace("&", "$$")}
                    ]);
                });

                $("txtBuscarPublicidad").addEvent("keypress", function(evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblPublicidad.loadData([
                            {name: 'anho', value: $("anhosPublicidad").get("value")},
                            {name: 'query', value: $("txtBuscarPublicidad").get("value").replace("&", "$$")}
                        ]);
                    }
                });


                tblTelefonia = new JpGrid($("tbl-Telefonia"), {
                    id: "gridTelefonia",
                    url: './GestionTransparente?action=Telefonia',
                    //altura: 'auto',
                    dataQuery: [
                        {name: 'anho', value: $("anhosTelefonia").get("value")},
                        {name: 'mes', value: $("mesTelefonia").get("value")},
                        {name: 'query', value: $("txtBuscarTelefonia").get("value").replace("&", "$$")}
                    ],
                    model: [
                        //{name: "mes", field:"Mes", width: "8%", sort:true, type:'string', items : meses, style:{"text-align":"center"}},
                        {name: "tipo", field: 'Tipo', width: "10%", type: 'string'},
                        {name: "numero", field: 'Numero', width: "10%", type: 'string'},
                        {name: "areaOficina", field: 'Area/Oficina', width: "20%", sort: true, type: 'string'},
                        {name: "asignadoA", field: 'Asignado a', width: "25%", type: 'string'},
                        {name: "cargoActividad", field: 'Cargo', width: "30%", type: 'string'},
                        {name: "importe", field: 'Importe (S/.)', width: "5%", type: 'numeric', style: {"text-align": "right"}}
                    ]
                });

                var cargarMesTelefonia = function() {
                    var mesTelefonia = new Request.HTML({
                        url: './GestionTransparente?action=ListarMesTelefonia&anho=' + $("anhosTelefonia").get("value"),
                        onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                            $("mesTelefonia").set('html', responseHTML);

                            var mesHTML = "";
                            $$(".mesTelefonia").each(function(e) {
                                var texto = e.get("text").trim();
                                var i = 0;
                                meses.each(function(node, index) {
                                    if (node["id"] == texto && i == 0) {
                                        i = 1;
                                        mesHTML += "<option value=" + node["id"] + ">" + node["valor"] + "</option>";

                                    }
                                });
                            });

                            $("mesTelefonia").set('html', mesHTML);
                            tblTelefonia.loadData([
                                {name: 'anho', value: $("anhosTelefonia").get("value")},
                                {name: 'mes', value: $("mesTelefonia").get("value")},
                                {name: 'query', value: $("txtBuscarTelefonia").get("value").replace("&", "$$")}
                            ]);
                        }
                    }).send();
                }

                anhoTelefonia = new Request.HTML({
                    url: './GestionTransparente?action=ListarAnhosTelefonia',
                    onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                        $("anhosTelefonia").set('html', responseHTML);

                        cargarMesTelefonia();
                    }
                });
                anhoTelefonia.send();

                $("anhosTelefonia").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    cargarMesTelefonia();
                });

                $("mesTelefonia").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    tblTelefonia.loadData([
                        {name: 'anho', value: $("anhosTelefonia").get("value")},
                        {name: 'mes', value: $("mesTelefonia").get("value")},
                        {name: 'query', value: $("txtBuscarTelefonia").get("value").replace("&", "$$")}
                    ]);
                });

                $("txtBuscarTelefonia").addEvent("keypress", function(evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblTelefonia.loadData([
                            {name: 'anho', value: $("anhosTelefonia").get("value")},
                            {name: 'mes', value: $("mesTelefonia").get("value")},
                            {name: 'query', value: $("txtBuscarTelefonia").get("value").replace("&", "$$")}
                        ]);
                    }
                });


                tblVehiculo = new JpGrid($("tbl-vehiculo"), {
                    id: "gridVehiculo",
                    url: './GestionTransparente?action=Vehiculo',
                    altura: 'auto',
                    dataQuery: [
                        {name: 'anho', value: $("anhosVehiculo").get("value")},
                        {name: 'mes', value: $("mesVehiculo").get("value")},
                        {name: 'query', value: $("txtBuscarVehiculo").get("value").replace("&", "$$")}
                    ],
                    model: [
                        //{name: "mes", field:"Mes", width: "7%", sort:true, type:'string', items : meses, style:{"text-align":"center"}},

                        {name: "claseVehiculo", field: 'Veh&iacute;culo', width: "8%", type: 'string', style: {"text-align": "center"}},
                        {name: "cargoActividad", field: 'Asignado', width: "15%", sort: true},
                        {name: "asignadoA", field: 'Chofer', width: "20%", sort: true},
                        {name: "recorridoKm", field: 'Recorrido Km', width: "8%", type: 'string', style: {"text-align": "center"}},
                        {name: "soatFechaVencimiento", field: 'Vencimiento de SOAT', width: "8%", type: 'date', style: {"text-align": "center"}},
                        {name: "tipoCombustible", field: 'Tipo Combustible', width: "10%"},
                        {name: "costoCombustible", field: 'Combustible (S/.)', width: "10%", type: 'numeric', style: {"text-align": "right"}},
                        {name: "placa", field: 'Placa', width: "10%", type: 'string', style: {"text-align": "center"}}
                    ]
                });



                anhoVehiculo = new Request.HTML({
                    url: './GestionTransparente?action=ListarAnhosVehiculo',
                    onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                        $("anhosVehiculo").set('html', responseHTML);

                        cargarMesVehiculo();
                    }
                });

                anhoVehiculo.send();

                $("anhosVehiculo").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    cargarMesVehiculo();
                });

                var cargarMesVehiculo = function() {
                    var mesVehiculo = new Request.HTML({
                        url: './GestionTransparente?action=ListarMesVehiculo&anho=' + $("anhosVehiculo").get("value"),
                        onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                            $("mesVehiculo").set('html', responseHTML);

                            var mesHTML = "";
                            $$(".mesVehiculo").each(function(e) {
                                var texto = e.get("text").trim();
                                var i = 0;
                                meses.each(function(node, index) {
                                    if (node["id"] == texto && i == 0) {
                                        i = 1;
                                        mesHTML += "<option value=" + node["id"] + ">" + node["valor"] + "</option>";

                                    }
                                });
                            });

                            $("mesVehiculo").set('html', mesHTML);
                            tblVehiculo.loadData([
                                {name: 'anho', value: $("anhosVehiculo").get("value")},
                                {name: 'mes', value: $("mesVehiculo").get("value")},
                                {name: 'query', value: $("txtBuscarVehiculo").get("value").replace("&", "$$")}
                            ]);
                        }
                    }).send();
                }

                $("mesVehiculo").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    tblVehiculo.loadData([
                        {name: 'anho', value: $("anhosVehiculo").get("value")},
                        {name: 'mes', value: $("mesVehiculo").get("value")},
                        {name: 'query', value: $("txtBuscarVehiculo").get("value").replace("&", "$$")}
                    ]);
                });

                $("txtBuscarVehiculo").addEvent("keypress", function(evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblVehiculo.loadData([
                            {name: 'anho', value: $("anhosVehiculo").get("value")},
                            {name: 'mes', value: $("mesVehiculo").get("value")},
                            {name: 'query', value: $("txtBuscarVehiculo").get("value").replace("&", "$$")}
                        ]);
                    }
                });
                //lista de proveedores
                tblProveedor = new JpGrid($("tbl-proveedor"), {
                    id: "gridProveedor",
                    url: './GestionTransparente?action=Proveedor',
                    altura: 'auto',
                    dataQuery: [
                        {name: 'anho', value: $("anhosProveedor").get("value")},
                        {name: 'query', value: $("txtBuscarProveedor").get("value").replace("&", "$$")}
                    ],
                    model: [
                        {name: "proveedor", field: 'Proveedor', width: "80%", type: 'string', sort: true},
                        {name: "ruc", field: 'N° de R.U.C', width: "10%", type: 'string', sort: true},
                        {name: "importe", field: 'Importe (S/.)', width: "10%", type: 'numeric', style: {"text-align": "right"}}
                    ]
                });
                anhoProveedor = new Request.HTML({
                    url: './GestionTransparente?action=ListarAnhosProveedor',
                    onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                        $("anhosProveedor").set('html', responseHTML);
                        cargarTrimestreProveedor();
                    }
                });
                anhoProveedor.send();
                var cargarTrimestreProveedor = function() {
                    var mesTrimestreProveedor = new Request.HTML({
                        url: './GestionTransparente?action=ListarTrimestreProveedor&anho=' + $("anhosProveedor").get("value"),
                        onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                            $("trimestreProveedor").set('html', responseHTML);
                            tblProveedor.loadData([
                                {name: 'anho', value: $("anhosProveedor").get("value")},
                                {name: 'trimestre', value: $("trimestreProveedor").get("value")},
                                {name: 'query', value: $("txtBuscarProveedor").get("value").replace("&", "$$")}
                            ]);
                        }
                    }).send();
                }

                $("anhosProveedor").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    cargarTrimestreProveedor();
                });
                $("trimestreProveedor").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    tblProveedor.loadData([
                        {name: 'anho', value: $("anhosProveedor").get("value")},
                        {name: 'trimestre', value: $("trimestreProveedor").get("value")},
                        {name: 'query', value: $("txtBuscarProveedor").get("value").replace("&", "$$")}
                    ]);
                });

                $("txtBuscarProveedor").addEvent("keypress", function(evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblProveedor.loadData([
                            {name: 'anho', value: $("anhosProveedor").get("value")},
                            {name: 'trimestre', value: $("trimestreProveedor").get("value")},
                            {name: 'query', value: $("txtBuscarProveedor").get("value").replace("&", "$$")}
                        ]);
                    }
                });


                //Viaticos putno y aparte
                var tblViatico;
                tblViatico = new JpGrid($("tbl-viatico"), {
                    id: "gridViatico",
                    url: './GestionTransparente?action=ListarViaticos',
                    dataQuery: [
                        {name: 'anho', value: $("anhosViatico").get("value")},
                        {name: 'mes', value: $("mesViatico").get("value")},
                        {name: 'query', value: $("txtBuscarViatico").get("value").replace("&", "$$")}
                    ],
                    model: [
                        {name: "areaOficina", field: 'Oficina/Area', width: "25%", type: 'string'},
                        {name: "usuarios", field: 'Usuario', width: "20%", sort: true, type: 'string'},
                        {name: "fechaSalida", field: 'Salida', width: "8%", type: 'string'},
                        {name: "fechaRetorno", field: 'Retorno', width: "8%", type: 'string'},
                        {name: "ruta", field: 'Ruta', width: "30%", type: 'string', sort: true},
                        {name: "costoPasajes", field: 'Pasaje (S/.)', width: "5%", type: 'numeric', style: {"text-align": "right"}},
                        {name: "viaticos", field: 'Vi&aacute;tico (S/.)', width: "5%", type: 'numeric', style: {"text-align": "right"}}
                    ]
                });

                anhoViatico = new Request.HTML({
                    url: './GestionTransparente?action=ListarAnhosViatico',
                    onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                        $("anhosViatico").set('html', responseHTML);
                        cargarMesViatico();
                    }
                });

                anhoViatico.send();

                $("anhosViatico").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    cargarMesViatico();
                });


                var cargarMesViatico = function() {
                    var mesViatico = new Request.HTML({
                        url: './GestionTransparente?action=ListarMesViatico&anho=' + $("anhosViatico").get("value"),
                        onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                            $("mesViatico").set('html', responseHTML);
                            var mesHTML = "";

                            $$(".mesViatico").each(function(e) {
                                var texto = e.get("text").trim();
                                var i = 0;
                                /*if(texto.lenght<=1)
                                 texto = "0"+texto;*/

                                meses.each(function(node, index) {
                                    if (node["id"] == texto && i == 0) {
                                        i = 1;
                                        mesHTML += "<option value=" + node["id"] + ">" + node["valor"] + "</option>";

                                    }
                                });
                            });

                            $("mesViatico").set('html', mesHTML);

                            tblViatico.loadData([
                                {name: 'anho', value: $("anhosViatico").get("value")},
                                {name: 'mes', value: $("mesViatico").get("value")},
                                {name: 'query', value: $("txtBuscarViatico").get("value").replace("&", "$$")}
                            ]);
                        }
                    }).send();
                }


                $("txtBuscarViatico").addEvent("keypress", function(evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblViatico.loadData([
                            {name: 'anho', value: $("anhosViatico").get("value")},
                            {name: 'mes', value: $("mesViatico").get("value")},
                            {name: 'query', value: $("txtBuscarViatico").get("value").replace("&", "$$")}
                        ]);
                    }
                });
                $("mesViatico").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    tblViatico.loadData([
                        {name: 'anho', value: $("anhosViatico").get("value")},
                        {name: 'mes', value: $("mesViatico").get("value")},
                        {name: 'query', value: $("txtBuscarViatico").get("value").replace("&", "$$")}
                    ]);
                });

                //Penalidad
                var tblPenalidad;

                var anhoPenalidad = new Request.HTML({
                    url: './Convocatoria?action=ListarAnhosPenalidad',
                    onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                        $("anhosPenalidad").set('html', responseHTML);
                        tblPenalidad = new JpGrid($("tbl-penalidad"), {
                            id: "gridPenalidad",
                            url: './Convocatoria?action=ListarPenalidadForWeb',
                            dataQuery: [
                                {name: 'anho', value: $("anhosPenalidad").get("value")},
                                {name: 'query', value: $("txtBuscarPenalidad").get("value").replace("&", "$$")}
                            ],
                            model: [
                                {name: "montoContrato", style: {"text-align": "right"}, field: 'Monto de Contrato S/.', width: "10%", type: 'string'},
                                {name: "contratista", field: 'Contratista', width: "15%", type: 'string'},
                                {name: "ruc", field: 'R.U.C', width: "10%", type: 'string'},
                                {name: "objeto", field: 'Objeto de Proceso', width: "20%", type: 'string'},
                                {name: "nroProceso", field: 'Nro. Proceso Convocado', width: "10%", type: 'string'},
                                {name: "nroContrato", field: 'Nro. Contrato', width: "15%", type: 'string'},
                                {name: "tipo", field: 'Tipo Penalidad', width: "10%", type: 'string'},
                                {name: "montoPenalidad", style: {"text-align": "right"}, field: 'Monto Penalidad S/.', width: "10%", type: 'string'}
                            ]
                        });
                    }
                });
                anhoPenalidad.send();

                $("anhosPenalidad").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    tblPenalidad.loadData([
                        {name: 'anho', value: $("anhosPenalidad").get("value")},
                        {name: 'query', value: $("txtBuscarPenalidad").get("value").replace("&", "$$")}
                    ]);
                });
                $("btnBuscarPenalidad").addEvent("click", function(evt) {
                    evt.stopPropagation();
                    tblPenalidad.loadData([
                        {name: 'anho', value: $("anhosPenalidad").get("value")},
                        {name: 'query', value: $("txtBuscarPenalidad").get("value").replace("&", "$$")}
                    ]);
                });
                $("txtBuscarPenalidad").addEvent("keypress", function(evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblPenalidad.loadData([
                            {name: 'anho', value: $("anhosPenalidad").get("value")},
                            {name: 'query', value: $("txtBuscarPenalidad").get("value").replace("&", "$$")}
                        ]);
                    }
                });

                //Monto de liquidacion finalde obra
                var tblFinalObra;

                var anhoFinalObra = new Request.HTML({
                    url: './Convocatoria?action=ListarAnhosDocumentos&cate_id=100',
                    onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                        $("anhosFinalObra").set('html', responseHTML);
                        tblFinalObra = new JpGrid($("tbl-final-obra"), {
                            id: "gridFinalObra",
                            url: './Convocatoria?action=Documentos',
                            dataQuery: [
                                {name: 'anho', value: $("anhosFinalObra").get("value")},
                                {name: 'cate_id', value: 100},
                                {name: 'query', value: $("txtBuscarFinalObra").get("value").replace("&", "$$")}
                            ],
                            success: function(e) {
                                $$(".tips").addEvent('click', function() {
                                    ToolTip.instance(this, {
                                        autohide: false,
                                        position: {position: 'bottom', edge: 'top'}
                                    },
                                    this.get('dir')).show();
                                });
                            },
                            model: [
                                {name: "fecha", field: 'Fecha', width: "5%", type: 'string'},
                                {name: "titulo", field: 'N° Resoluci&oacute;n', width: "11%", sort: true, type: 'string'},
                                {name: "resumen", style: {"text-align": "justify"}, field: 'Resumen', width: "70%", type: 'string'},
                                {name: "id", field: 'Descargar', style: {"text-align": "center"}, width: "7%", clase: 'tips', title: 'Explicación', filtro: 'descripcion', activo: 'activo', type: 'string', renderer: function(val) {
                                        return '<a class="pdf" target="_blank" href="./GestionTransparente?action=verResolucion&id=' + val + '&anho=' + $("anhosFinalObra").get("value") + '"></a>'
                                    }}
                            ]
                        });
                    }
                });
                anhoFinalObra.send();

                $("anhosFinalObra").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    tblFinalObra.loadData([
                        {name: 'anho', value: $("anhosFinalObra").get("value")},
                        {name: 'cate_id', value: 100},
                        {name: 'query', value: $("txtBuscarFinalObra").get("value").replace("&", "$$")}
                    ]);
                });
                $("btnBuscarFinalObra").addEvent("click", function(evt) {
                    evt.stopPropagation();
                    tblFinalObra.loadData([
                        {name: 'anho', value: $("anhosFinalObra").get("value")},
                        {name: 'cate_id', value: 100},
                        {name: 'query', value: $("txtBuscarFinalObra").get("value").replace("&", "$$")}
                    ]);
                });
                $("txtBuscarFinalObra").addEvent("keypress", function(evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblFinalObra.loadData([
                            {name: 'anho', value: $("anhosFinalObra").get("value")},
                            {name: 'cate_id', value: 100},
                            {name: 'query', value: $("txtBuscarFinalObra").get("value").replace("&", "$$")}
                        ]);
                    }
                });

                //Monto de liquidacion adicional de obras
                var tblAdicional;

                var anhoAdicional = new Request.HTML({
                    url: './Convocatoria?action=ListarAnhosDocumentos&cate_id=200',
                    onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                        $("anhosAdicional").set('html', responseHTML);
                        tblAdicional = new JpGrid($("tbl-adicional"), {
                            id: "gridAdicional",
                            url: './Convocatoria?action=Documentos',
                            dataQuery: [
                                {name: 'anho', value: $("anhosAdicional").get("value")},
                                {name: 'cate_id', value: 200},
                                {name: 'query', value: $("txtBuscarAdicional").get("value").replace("&", "$$")}
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
                                {name: "titulo", field: 'N° Resoluci&oacute;n', width: "11%", sort: true, type: 'string'},
                                {name: "resumen", style: {"text-align": "justify"}, field: 'Resumen', width: "70%", type: 'string'},
                                {name: "id", field: 'Descargar', style: {"text-align": "center"}, width: "7%", clase: 'tips', title: 'Explicación', filtro: 'descripcion', activo: 'activo', type: 'string', renderer: function(val) {
                                        return '<a class="pdf" target="_blank" href="./GestionTransparente?action=verResolucion&id=' + val + '&anho=' + $("anhosAdicional").get("value") + '"></a>'
                                    }}
                            ]
                        });
                    }
                });
                anhoAdicional.send();

                $("anhosAdicional").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    tblAdicional.loadData([
                        {name: 'anho', value: $("anhosAdicional").get("value")},
                        {name: 'cate_id', value: 200},
                        {name: 'query', value: $("txtBuscarAdicional").get("value").replace("&", "$$")}
                    ]);
                });
                $("btnBuscarAdicional").addEvent("click", function(evt) {
                    evt.stopPropagation();
                    tblAdicional.loadData([
                        {name: 'anho', value: $("anhosAdicional").get("value")},
                        {name: 'cate_id', value: 200},
                        {name: 'query', value: $("txtBuscarAdicional").get("value").replace("&", "$$")}
                    ]);
                });
                $("txtBuscarAdicional").addEvent("keypress", function(evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblAdicional.loadData([
                            {name: 'anho', value: $("anhosAdicional").get("value")},
                            {name: 'cate_id', value: 200},
                            {name: 'query', value: $("txtBuscarAdicional").get("value").replace("&", "$$")}
                        ]);
                    }
                });

                //Monto de liquidacion Supervicion
                var tblSupervicion;

                var anhoSupervicion = new Request.HTML({
                    url: './Convocatoria?action=ListarAnhosDocumentos&cate_id=300',
                    onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                        $("anhosSupervicion").set('html', responseHTML);
                        tblSupervicion = new JpGrid($("tbl-supervicion"), {
                            id: "gridSupervicion",
                            url: './Convocatoria?action=Documentos',
                            dataQuery: [
                                {name: 'anho', value: $("anhosSupervicion").get("value")},
                                {name: 'cate_id', value: 300},
                                {name: 'query', value: $("txtBuscarSupervicion").get("value").replace("&", "$$")}
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
                                        return '<a class="pdf" target="_blank" href="./GestionTransparente?action=verResolucion&id=' + val + '&anho=' + $("anhosSupervicion").get("value") + '"></a>'
                                    }}
                            ]
                        });
                    }
                });
                anhoSupervicion.send();

                $("anhosSupervicion").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    tblSupervicion.loadData([
                        {name: 'anho', value: $("anhosSupervicion").get("value")},
                        {name: 'cate_id', value: 300},
                        {name: 'query', value: $("txtBuscarSupervicion").get("value").replace("&", "$$")}
                    ]);
                });
                $("btnBuscarSupervicion").addEvent("click", function(evt) {
                    evt.stopPropagation();
                    tblSupervicion.loadData([
                        {name: 'anho', value: $("anhosSupervicion").get("value")},
                        {name: 'cate_id', value: 300},
                        {name: 'query', value: $("txtBuscarSupervicion").get("value").replace("&", "$$")}
                    ]);
                });
                $("txtBuscarSupervicion").addEvent("keypress", function(evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblSupervicion.loadData([
                            {name: 'anho', value: $("anhosSupervicion").get("value")},
                            {name: 'cate_id', value: 300},
                            {name: 'query', value: $("txtBuscarSupervicion").get("value").replace("&", "$$")}
                        ]);
                    }
                });

                //Modificatorias del PAC
                var tblModificado;

                var anhoModificado = new Request.HTML({
                    url: './Convocatoria?action=ListarAnhosDocumentos&cate_id=1100',
                    onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                        $("anhosModificado").set('html', responseHTML);
                        tblModificado = new JpGrid($("tbl-modificado"), {
                            id: "gridModificado",
                            url: './Convocatoria?action=Documentos',
                            dataQuery: [
                                {name: 'anho', value: $("anhosModificado").get("value")},
                                {name: 'cate_id', value: 1100},
                                {name: 'query', value: $("txtBuscarModificado").get("value").replace("&", "$$")}
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
                                {name: "titulo", field: 'N° Resoluci&oacute;n', width: "11%", sort: true, type: 'string'},
                                {name: "resumen", style: {"text-align": "justify"}, field: 'Resumen', width: "70%", type: 'string'},
                                {name: "id", field: 'Descargar', style: {"text-align": "center"}, width: "7%", clase: 'tips', title: 'Explicación', filtro: 'descripcion', activo: 'activo', type: 'string', renderer: function(val) {
                                        return '<a class="pdf" target="_blank" href="./GestionTransparente?action=verResolucion&id=' + val + '&anho=' + $("anhosModificado").get("value") + '"></a>'
                                    }}
                            ]
                        });
                    }
                });
                anhoModificado.send();

                $("anhosModificado").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    tblModificado.loadData([
                        {name: 'anho', value: $("anhosModificado").get("value")},
                        {name: 'cate_id', value: 1100},
                        {name: 'query', value: $("txtBuscarModificado").get("value").replace("&", "$$")}
                    ]);
                });
                $("btnBuscarModificado").addEvent("click", function(evt) {
                    evt.stopPropagation();
                    tblModificado.loadData([
                        {name: 'anho', value: $("anhosModificado").get("value")},
                        {name: 'cate_id', value: 1100},
                        {name: 'query', value: $("txtBuscarModificado").get("value").replace("&", "$$")}
                    ]);
                });
                $("txtBuscarModificado").addEvent("keypress", function(evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblModificado.loadData([
                            {name: 'anho', value: $("anhosModificado").get("value")},
                            {name: 'cate_id', value: 1100},
                            {name: 'query', value: $("txtBuscarModificado").get("value").replace("&", "$$")}
                        ]);
                    }
                });

                $$(".print").addEvent("click", function(evt) {
                    var url = this.get("rev");
                    var anho = this.getParent("label").getParent("div").getNext("div").getChildren(".anho").get("value");
                    var mes = this.getParent("label").getParent("div").getNext("div").getChildren(".mes").get("value");
                    this.set("href", url + "?format=" + this.get("rel") + "&anho=" + anho + "&mes=" + mes);
                });
                
            });


        </script>
        <style>
            .print{
                cursor: pointer;
            }
        </style>
        <title>Adquisiciones y Contrataciones</title>
    </head>
    <body>        
        <%@include file="../jspf/cabecera.jspf" %>  
        <div class="wrapper2">
            
            <div class="cuerpo">
                <div class="navegacion">
                    <h2>
                        <a href="./Inicio">Inicio</a> / <a href="./GestionTransparente">Gesti&oacute;n Transparente</a> / Adquisiciones y contrataciones
                    </h2>
                </div>
                <div class="services text-center">
                    <div class="gadget">
                        <div class="panel efecto">
                            <a href="./GestionTransparente?action=NormasDirectivas">
                                <div class="normas"></div>
                                <div class="descripcion" style="font-size:10.5px">Documentos Normativos y de Gestión</div>
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
                        <div class="panel efecto active">
                            <div class="adquisiciones"></div>
                            <div class="descripcion" style="font-size:11px">Adquisiciones y Contrataciones </div>
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
                        <h2 id="st12">PAC y Modificatorias</h2>
                        <div id="sp12">
                            <div class="search">
                                <div class="content-l">
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Filtrar por a&ntilde;o del P.A.C:</label><select id="anhosModificado"></select>
                                </div>
                                <div class="content-i">
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Buscar: </label><input  id="txtBuscarModificado" style="margin-right:3px"/><button id="btnBuscarModificado">Buscar</button>             
                                </div>
                            </div>
                            <div id="tbl-modificado" class="grid"></div>
                        </div>
                    </div>
                    <div class="sliderPanel"> 
                        <h2 id="st1">Ordenes de Compra de Bienes</h2>
                        <div id="sp1">
                            <div class="search">
                                <div class="content-l" >
                                    <label style="margin: 10px auto auto 10px; float: left; font-weight: bold; color: #6A6C71;">Obtener Reporte completo en: </label>
                                    <label style="margin-left: 15px;">
                                        <a style="margin: auto 20px auto 0px;" target="_blank" rel="pdf" title="Seleccione el A&ntilde;o que desea para reportear" rev="./OrdenCompraPrint" class="print"><img src="./resources/images/16x16/pdf.png" /></a>
                                        <a style="margin: auto 10px auto 10px;" target="_blank" rel="excel" title="Seleccione el A&ntilde;o que desea para reportear" rev="./OrdenCompraPrint" class="print"><img src="./resources/images/16x16/excel.png" /></a>
                                        <a style="margin: auto 10px auto 10px;" target="_blank" rel="odt" title="Seleccione el A&ntilde;o que desea para reportear" rev="./OrdenCompraPrint" class="print"><img src="./resources/images/16x16/word.png" /></a>
                                    </label>
                                </div>
                                <div class="content-i" style="width: 52%">
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">N&ordm; Orden/Proveedor:</label><input type="text" id="txtBuscarComprasBienes" />
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">A&ntilde;o:</label><select class="anho" id="anhosComprasBienes"></select>
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Mes:</label><select class='mes' id="mesComprasBienes"></select>
                                </div>
                            </div>
                            <div id="tbl-bienes" class="grid"></div>  
                        </div>                                              
                    </div>
                    <div class="sliderPanel">
                        <h2 id="st2">Ordenes de Servicios</h2>
                        <div id="sp2">
                            <div class="search">
                                <div class="content-l">
                                    <label style="margin: 10px auto auto 10px; float: left; font-weight: bold; color: #6A6C71;">Obtener Reporte completo en: </label>
                                    <label style="margin-left: 15px;">
                                        <a style="margin: auto 20px auto 0px;" target="_blank" rel="pdf" title="Seleccione el A&ntilde;o que desea para reportear" rev="./OrdenServicioPrint" class=" print"><img src="./resources/images/16x16/pdf.png" /></a>
                                        <a style="margin: auto 10px auto 10px;" target="_blank" rel="excel" title="Seleccione el A&ntilde;o que desea para reportear" rev="./OrdenServicioPrint" class=" print"><img src="./resources/images/16x16/excel.png" /></a>
                                        <a style="margin: auto 10px auto 10px;" target="_blank" rel="odt" title="Seleccione el A&ntilde;o que desea para reportear"  rev="./OrdenServicioPrint" class="print"><img src="./resources/images/16x16/word.png" /></a>
                                    </label>
                                </div>
                                <div class="content-i" style="width: 52%">
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">N&ordm; Orden/Proveedor:</label><input type="text" id="txtBuscarComprasServicios" />
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">A&ntilde;o:</label><select class="anho" id="anhosComprasServicios"></select>
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Mes:</label><select class='mes' id="mesComprasServicios"></select>
                                </div>
                            </div>
                            <div id="tbl-servicios" class="grid"></div> 
                        </div>
                    </div>
                    <div class="sliderPanel">
                        <h2 id="st3">Gastos en Publicidad</h2>
                        <div id="sp3">
                            <div class="search">
                                <div class="content-l">
                                    <label style="margin: 10px auto auto 10px; float: left; font-weight: bold; color: #6A6C71;">Obtener Reporte completo en: </label>
                                    <label style="margin-left: 15px;">
                                        <a style="margin: auto 20px auto 0px;" target="_blank" rel="pdf" title="Seleccione el A&ntilde;o que desea para reportear" rev="./PublicidadPrint" class="print"><img src="./resources/images/16x16/pdf.png" /></a>
                                        <a style="margin: auto 10px auto 10px;" target="_blank" rel="excel" title="Seleccione el A&ntilde;o que desea para reportear" rev="./PublicidadPrint" class="print"><img src="./resources/images/16x16/excel.png" /></a>
                                        <a style="margin: auto 10px auto 10px;" target="_blank" rel="odt" title="Seleccione el A&ntilde;o que desea para reportear"  rev="./PublicidadPrint" class="print"><img src="./resources/images/16x16/word.png" /></a>
                                    </label>

                                </div>
                                <div class="content-i">
                                    <label style="margin-right:15px;margin-left:-50px; font-weight: bold; color: #6A6C71;">Contrato/R.U.C/Proveedor:</label><input type="text" id="txtBuscarPublicidad" />
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">A&ntilde;o:</label><select class="anho" id="anhosPublicidad"></select>
                                </div>
                            </div>
                            <div id="tbl-publicidad" class="grid"></div> 
                        </div>
                    </div>
                    
                    <div class="sliderPanel"  style="height: auto;">
                        <h2 id="st4">Gastos en Telefon&iacute;a</h2>
                        <div id="sp4" style="height:  auto;">
                            <div class="search">
                                <div class="content-l">
                                    <label style="margin: 10px auto auto 10px; float: left; font-weight: bold; color: #6A6C71;">Obtener Reporte completo en:</label>
                                    <label style="margin-left: 15px;">
                                        <a style="margin: auto 20px auto 0px;" target="_blank" rel="pdf" title="Seleccione el A&ntilde;o que desea para reportear" rev="./TelefoniaPrint" class="print"><img src="./resources/images/16x16/pdf.png" /></a>
                                        <a style="margin: auto 10px auto 10px;" target="_blank" rel="excel" title="Seleccione el A&ntilde;o que desea para reportear" rev="./TelefoniaPrint" class="print"><img src="./resources/images/16x16/excel.png" /></a>
                                        <a style="margin: auto 10px auto 10px;" target="_blank" rel="odt" title="Seleccione el A&ntilde;o que desea para reportear"  rev="./TelefoniaPrint" class="print"><img src="./resources/images/16x16/word.png" /></a>
                                    </label>
                                </div>
                                
                                <div class="content-i"  style="width: 52%">
                                    <label style="margin-right:15px;margin-left:-50px; font-weight: bold; color: #6A6C71;">Area/Oficina:</label><input type="text" id="txtBuscarTelefonia" />
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">A&ntilde;o:</label><select class="anho" id="anhosTelefonia"></select>
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Mes:</label><select class='mes' id="mesTelefonia"></select>
                                </div>
                                
                            </div>
                            <div id="tbl-Telefonia" class="grid"></div> 
                        </div>
                    </div>
                    
                    <div class="sliderPanel">
                        <h2 id="st5">Uso de Veh&iacute;culos</h2>
                        <div id="sp5">
                            <div class="search">
                                <div class="content-l">
                                    <label style="margin: 10px auto auto 10px; float: left; font-weight: bold; color: #6A6C71;">Obtener Reporte completo en:</label>
                                    <label style="margin-left: 15px;">
                                        <a style="margin: auto 20px auto 0px;" target="_blank" rel="pdf" title="Seleccione el A&ntilde;o que desea para reportear" rev="./VehiculoPrint" class="print"><img src="./resources/images/16x16/pdf.png" /></a>
                                        <a style="margin: auto 10px auto 10px;" target="_blank" rel="excel" title="Seleccione el A&ntilde;o que desea para reportear" rev="./VehiculoPrint" class="print"><img src="./resources/images/16x16/excel.png" /></a>
                                        <a style="margin: auto 10px auto 10px;" target="_blank" rel="odt" title="Seleccione el A&ntilde;o que desea para reportear"  rev="./VehiculoPrint" class="print"><img src="./resources/images/16x16/word.png" /></a>
                                    </label>
                                </div>
                                <div class="content-i" style="width: 52%" >
                                    <label style="margin-right:15px;margin-left:-50px; font-weight: bold; color: #6A6C71;">Asignado a:</label><input type="text" id="txtBuscarVehiculo" />
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">A&ntilde;o:</label><select class="anho" id="anhosVehiculo"></select>
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Mes:</label><select class="mes" id="mesVehiculo"></select>
                                </div>
                            </div>
                            <div id="tbl-vehiculo" class="grid"></div>
                        </div>
                    </div>
                    
                    <div class="sliderPanel">
                        <h2 id="st6">Principales Proveedores</h2>
                        <div id="sp6">
                            <div class="search">
                                <div class="content-l">
                                    <label style="margin: 10px auto auto 5px; float:left;font-weight: bold; color: #6A6C71;">Obtener Reporte completo en:</label>
                                    <label style="margin-left: 15px;">
                                        <a style="margin: auto 20px auto 0px;" target="_blank" rel="pdf" title="Seleccione el A&ntilde;o que desea para reportear" rev="./ProveedorPrint" class="print"><img src="./resources/images/16x16/pdf.png" /></a>
                                        <a style="margin: auto 10px auto 10px;" target="_blank" rel="excel" title="Seleccione el A&ntilde;o que desea para reportear" rev="./ProveedorPrint" class="print"><img src="./resources/images/16x16/excel.png" /></a>
                                        <a style="margin: auto 10px auto 10px;" target="_blank" rel="odt" title="Seleccione el A&ntilde;o que desea para reportear"  rev="./ProveedorPrint" class="print"><img src="./resources/images/16x16/word.png" /></a>
                                    </label>
                                </div>
                                <div class="content-i" style="width:54%">
                                    <label style="margin-right:15px;margin-left:-50px; font-weight: bold; color: #6A6C71;">R.U.C/Proveedor:</label><input type="text" id="txtBuscarProveedor" />
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">A&ntilde;o:</label><select class="anho" id="anhosProveedor"></select>
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Trimestre:</label><select class="mes" id="trimestreProveedor"></select>
                                </div>
                            </div>
                            <div id="tbl-proveedor" class="grid"></div>
                        </div>
                    </div>  
                    <div class="sliderPanel">
                        <h2 id="st7">Viáticos y Pasajes</h2>
                        <div id="sp7">
                            <div class="search">
                                <div class="content-l">
                                    <label style="margin: 10px auto auto 10px; float: left; font-weight: bold; color: #6A6C71;">Obtener Reporte completo en: </label>
                                    <label style="margin-left: 15px;">
                                        <a style="margin: auto 20px auto 0px;" target="_blank" rel="pdf" title="Seleccione el A&ntilde;o que desea para reportear" rev="./ViaticosPrint" class="print"><img src="./resources/images/16x16/pdf.png" /></a>
                                        <a style="margin: auto 10px auto 10px;" target="_blank" rel="excel" title="Seleccione el A&ntilde;o que desea para reportear" rev="./ViaticosPrint" class=" print"><img src="./resources/images/16x16/excel.png" /></a>
                                        <a style="margin: auto 10px auto 10px;" target="_blank" rel="odt" title="Seleccione el A&ntilde;o que desea para reportear"  rev="./ViaticosPrint" class="print"><img src="./resources/images/16x16/word.png" /></a>
                                    </label>
                                </div>
                                <div class="content-i" style="width: 52%">
                                    <label style="margin-right:15px;margin-left:-50px; font-weight: bold; color: #6A6C71;">Buscar</label><input type="text" id="txtBuscarViatico" />
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">A&ntilde;o:</label><select class="anho" id="anhosViatico"></select>
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Mes:</label><select class="mes" id="mesViatico"></select>
                                </div>
                            </div>
                            <div id="tbl-viatico" class="grid"></div>

                        </div>
                    </div>

                    <div class="sliderPanel">
                        <h2 id="st8" >Penalidades Aplicadas </h2>
                        <div id="sp8" >
                            <div class="search">
                                <div class="content-l">
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Filtrar por A&ntilde;o:</label><select id="anhosPenalidad"></select>
                                </div>
                                <div class="content-i">
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Buscar: </label><input  id="txtBuscarPenalidad" style="margin-right:3px"/><button id="btnBuscarPenalidad">Buscar</button>             
                                </div>
                            </div>
                            <div id="tbl-penalidad" class="grid"></div>  
                        </div>
                    </div>
                    <div class="sliderPanel">
                        <h2 id="st9">Monto de liquidaci&oacute;n final de Obra</h2>
                        <div id="sp9">
                            <div class="search">
                                <div class="content-l">
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Filtrar por A&ntilde;o:</label><select id="anhosFinalObra"></select>
                                </div>
                                <div class="content-i">
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Buscar: </label><input  id="txtBuscarFinalObra" style="margin-right:3px" /><button id="btnBuscarFinalObra">Buscar</button>             
                                </div>
                            </div>
                            <div id="tbl-final-obra" class="grid"></div>
                        </div>
                    </div>
                    <div class="sliderPanel">
                        <h2 id="st10">Monto Adicionales de las Obras</h2>
                        <div id="sp10">
                            <div class="search">
                                <div class="content-l">
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Filtrar por A&ntilde;o:</label><select id="anhosAdicional"></select>
                                </div>
                                <div class="content-i">
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Buscar: </label><input  id="txtBuscarAdicional" style="margin-right:3px" /><button id="btnBuscarAdicional">Buscar</button>             
                                </div>
                            </div>
                            <div id="tbl-adicional" class="grid"></div>
                        </div>
                    </div>
                    <div class="sliderPanel">
                        <h2 id="st11">Informes de Supervisi&oacute;n de Contratos</h2>
                        <div id="sp11">
                            <div class="search">
                                <div class="content-l">
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Filtrar por A&ntilde;o:</label><select id="anhosSupervicion"></select>
                                </div>
                                <div class="content-i">
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Buscar: </label><input  id="txtBuscarSupervicion" style="margin-right:3px"/><button id="btnBuscarSupervicion" style="margin-right:3px">Buscar</button>             
                                </div>
                            </div>
                            <div id="tbl-supervicion" class="grid"></div>
                        </div>
                    </div>


                </div>
            </div>
            
        </div>
        <%@include file="../jspf/pie.jspf" %>
    </body>
</html>