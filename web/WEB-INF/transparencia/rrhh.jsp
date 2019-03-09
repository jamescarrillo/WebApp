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
        <script type="text/javascript" src="resources/js/JpViewCopy.js"></script>
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
                var tblPersonalPlanilla, tblPersonalSNP, tblPersonalCAS, tblPersonalCategoria, tblPersonalDis;
                var anhoPersonalPlanilla, anhoPersonalSNP, anhoPersonalCAS, anhoPersonalCategoria, anhoPersonalDis;

                new JpView($("tbl-funcionario"), {url: './GestionTransparente?action=Funcionario', select: true});
                new JpView($("tbl-directivo"), {url: './GestionTransparente?action=Directivo', select: true, type: "consejo"});

               $("st1").addEvent('click', function(event) {
                    event.preventDefault();
                    sp1.toggle();
                    sp2.hide();
                    sp3.hide();
                    sp4.hide();
                    sp5.hide();
                    sp6.hide();
                    sp7.hide();
                });

                $("st2").addEvent('click', function(event) {
                    event.preventDefault();
                    sp1.hide();
                    sp2.toggle();
                    sp3.hide();
                    sp4.hide();
                    sp5.hide();
                    sp6.hide();
                    sp7.hide();
                });
                $("st3").addEvent('click', function(event) {
                    event.preventDefault();
                    sp1.hide();
                    sp2.hide();
                    sp3.toggle();
                    sp4.hide();
                    sp5.hide();
                    sp6.hide();
                    sp7.hide();
                });
                $("st4").addEvent('click', function(event) {
                    event.preventDefault();
                    sp1.hide();
                    sp2.hide();
                    sp3.hide();
                    sp4.toggle();
                    sp5.hide();
                    sp6.hide();
                    sp7.hide();
                });
                $("st5").addEvent('click', function(event) {
                    event.preventDefault();
                    sp1.hide();
                    sp2.hide();
                    sp3.hide();
                    sp4.hide();
                    sp5.toggle();
                    sp6.hide();
                    sp7.hide();
                });
               $("st6").addEvent('click', function(event) {
                    event.preventDefault();
                    sp1.hide();
                    sp2.hide();
                    sp3.hide();
                    sp4.hide();
                    sp5.hide();
                    sp6.toggle();
                    sp7.hide();
                });
                $("st7").addEvent('click', function(event) {
                    event.preventDefault();
                    sp1.hide();
                    sp2.hide();
                    sp3.hide();
                    sp4.hide();
                    sp5.hide();
                    sp6.hide();
                    sp7.toggle();
                });
                var sp1 = $("sp1");//new Fx.Slide('sp1', {mode: 'vertical'});
                var sp2 = $("sp2");//new Fx.Slide('sp2', {mode: 'vertical'});
                var sp3 = $("sp3");//new Fx.Slide('sp3', {mode: 'vertical'});
                var sp4 = $("sp4");//new Fx.Slide('sp4', {mode: 'vertical'});                
                var sp5 = $("sp5");//new Fx.Slide('sp5', {mode: 'vertical'});
                var sp6 = $("sp6");//new Fx.Slide('sp6', {mode: 'vertical'});
                var sp7 = $("sp7");//new Fx.Slide('sp6', {mode: 'vertical'});

                sp1.hide();
                sp2.hide();
                sp3.hide();
                sp4.hide();
                sp5.hide();
                sp6.hide();
                sp7.hide();
                
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
                    case "7" :
                        sp7.toggle();
                        break;
                }

                tblPersonalPlanilla = new JpGrid($("tbl-personal-planilla"), {
                    id: "gridPersonalPlanilla",
                    url: './GestionTransparente?action=ListarPersonalForAdmin',
                    altura: 'auto',
                    dataQuery: [
                        {name: 'anho', value: $("anhosPersonalPlanilla").get("value")},
                        
                        {name: 'query', value: $("txtBuscarPersonalPlanilla").get("value").replace("&", "$$")},
                        {name: 'tipo', value: '1'}
                    ],
                    model: [
                        {name: "apellidosNombres", field: 'Apellidos y Nombres', width: "15%", sort: true, type: 'string'},
                        {name: "numeroDni", field: 'DNI', width: "5%", sort: true, type: 'string', style: {"text-align": "center"}},
                        {name: "fechaIngreso", field: 'Fecha Ingreso', width: "9%", sort: true, type: 'string', style: {"text-align": "center"}},
                        {name: "oficinaArea", field: 'Area', width: "14%", sort: true, type: 'string'},
                        {name: "cargo", field: 'Cargo', width: "25%", type: 'string'},
                        /*{name: "trimestre", field: 'Trimestre', width: "10%", type: 'string', renderer: function(val) {
                                if (val == 1)
                                    return "Trimestre 1";
                                else if (val == 2)
                                    return "Trimestre 2";
                                else if (val == 3)
                                    return "Trimestre 3";
                                else if (val == 4)
                                    return "Trimestre 4";
                            }, style: {"text-align": "center"}},*/
                       /* {name: "categoria", field: 'Categor&iacute;a', width: "7%", type: 'string', sort: true, style: {"text-align": "center"}},*/
                       // {name: "codigoCivil", field: 'Reg. Laboral', width: "6%", type: 'string', style: {"text-align": "center"}},
                        {name: "pension", field: 'Reg. Pensionario', width: "6%", type: 'string', style: {"text-align": "center"}},
                        
                        {name: "remuneracionMensual", field: 'Remuneración (S/.)', width: "7%", type: 'numeric', style: {"text-align": "right"}},
                        {name: "bonificacionQuinqu", field: 'Gratif. / Escol. (S/.)', width: "7%", type: 'numeric', style: {"text-align": "right"}},
                        {name: "beneficios", field: 'Otros Ingresos (S/.)', width: "7%", type: 'numeric', style: {"text-align": "right"}},
                        
                        {name: "ingresoTotal", field: 'Ingreso Total (S/.)', width: "10%", type: 'numeric', style: {"text-align": "right"}},
                    ]
                });
                

                anhoPersonalPlanilla = new Request.HTML({
                    url: './GestionTransparente?action=ListarAnhosPersonalPlanilla&tipo=1',
                    onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                        $("anhosPersonalPlanilla").set('html', responseHTML);
                        cargarTrimestrePersonalPlanilla();
                        //cargarMesPersonalPlanilla();
                    }
                });
                 anhoPersonalPlanilla.send();
                
                 var cargarTrimestrePersonalPlanilla = function() {
                 //if("anho">='2016'){
                    var mesTrimestreP = new Request.HTML({
                        url: './GestionTransparente?action=ListarTrimestrePersonal2&tipo=1&anho=' + $("anhosPersonalPlanilla").get("value"),
                        onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                            $("trimestrePersonalPlanilla").set('html', responseHTML);
                            tblPersonalPlanilla.loadData([
                                {name: 'anho', value: $("anhosPersonalPlanilla").get("value")},
                                {name: 'trimestre', value: $("trimestrePersonalPlanilla").get("value")},
                                {name: 'query', value: $("txtBuscarPersonalPlanilla").get("value").replace("&", "$$")},
                                {name: 'tipo', value: 1}
                            ]);
                        }
                    }).send();
                } 
               // }
              /*  var cargarTrimestrePersonalPlanilla = function() {
                    var mesTrimestreP = new Request.HTML({
                        url: './GestionTransparente?action=ListarTrimestrePersonal&tipo=1&anho=' + $("anhosPersonalPlanilla").get("value"),
                        onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                            $("trimestrePersonalPlanilla").set('html', responseHTML);
                            tblPersonalPlanilla.loadData([
                                {name: 'anho', value: $("anhosPersonalPlanilla").get("value")},
                                {name: 'trimestre', value: $("trimestrePersonalPlanilla").get("value")},
                                {name: 'query', value: $("txtBuscarPersonalPlanilla").get("value").replace("&", "$$")},
                                {name: 'tipo', value: 1}
                            ]);
                        }
                    }).send();
                }*/
                             

               $("anhosPersonalPlanilla").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    cargarTrimestrePersonalPlanilla();
                    //cargarMesPersonalPlanilla();
                });
                 
                $("trimestrePersonalPlanilla").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    tblPersonalPlanilla.loadData([
                        {name: 'anho', value: $("anhosPersonalPlanilla").get("value")},
                        {name: 'trimestre', value: $("trimestrePersonalPlanilla").get("value")},
                        {name: 'query', value: $("txtBuscarPersonalPlanilla").get("value").replace("&", "$$")},
                        {name: 'tipo', value: 1}
                    ]);
                });

                $("txtBuscarPersonalPlanilla").addEvent("keypress", function(evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblPersonalPlanilla.loadData([
                            {name: 'anho', value: $("anhosPersonalPlanilla").get("value")},
                            {name: 'trimestre', value: $("trimestrePersonalPlanilla").get("value")},
                            {name: 'query', value: $("txtBuscarPersonalPlanilla").get("value").replace("&", "$$")},
                            {name: 'tipo', value: 1}
                        ]);
                    }
                });
                
                
                
           /*  anhoPersonalPlanilla = new Request.HTML({
                    url: './GestionTransparente?action=ListarAnhosPersonalPlanilla&tipo=1',
                    onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                        $("anhosPersonalPlanilla").set('html', responseHTML);
                        cargarMesPersonalPlanilla();
                    }
                });
                anhoPersonalPlanilla.send();
                
                  $("anhosPersonalPlanilla").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    cargarMesPersonalPlanilla();
                });
                
                var cargarMesPersonalPlanilla = function() {
                    var mesPersonal = new Request.HTML({
                        url: './GestionTransparente?action=ListarMesPersonal&tipo=1&anho=' + $("anhosPersonalPlanilla").get("value"),
                        onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                            $("mesPersonal").set('html', responseHTML);
                            var mesHTML = "";

                            $$(".mesPersonal").each(function(e) {
                                var texto = e.get("text").trim();
                                var i = 0;
                                /*if(texto.lenght<=1)
                                 texto = "0"+texto;*/

                            /*--   meses.each(function(node, index) {
                                    if (node["id"] == texto && i == 0) {
                                        i = 1;
                                        mesHTML += "<option value=" + node["id"] + ">" + node["valor"] + "</option>";

                                    }
                                });
                            });

                            $("mesPersonal").set('html', mesHTML);

                            tblPersonalPlanilla.loadData([
                                {name: 'anho', value: $("anhosPersonalPlanilla").get("value")},
                                {name: 'trimestre', value: $("mesPersonal").get("value")},
                                {name: 'query', value: $("txtBuscarPersonalPlanilla").get("value").replace("&", "$$")},
                                {name: 'tipo', value: 1}
                            ]);
                        }
                    }).send();
                }

                $("txtBuscarPersonalPlanilla").addEvent("keypress", function(evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblPersonalPlanilla.loadData([
                            {name: 'anho', value: $("anhosPersonalPlanilla").get("value")},
                            {name: 'trimestre', value: $("mesPersonal").get("value")},
                            {name: 'query', value: $("txtBuscarPersonalPlanilla").get("value").replace("&", "$$")},
                            {name: 'tipo', value: 1}
                        ]);
                    }
                });
                 $("mesPersonal").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    tblPersonalPlanilla.loadData([
                        {name: 'anho', value: $("anhosPersonalPlanilla").get("value")},
                        {name: 'trimestre', value: $("mesPersonal").get("value")},
                        {name: 'query', value: $("txtBuscarPersonalPlanilla").get("value").replace("&", "$$")},
                        {name: 'tipo', value: 1}
                    ]);
                });*/

               /*  anhoPersonalPlanilla = new Request.HTML({
                    url: './GestionTransparente?action=ListarAnhosPersonalPlanilla&tipo=1',
                    onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                        $("anhosPersonalPlanilla").set('html', responseHTML);
                        cargarMesPersonalPlanilla();
                    }
                });
                anhoPersonalPlanilla.send();
                
                var cargarMesPersonalPlanilla = function() {
                    var mesP = new Request.HTML({
                        url: './GestionTransparente?action=ListarMesPersonal&tipo=1&anho>=2016' + $("anhosPersonalPlanilla").get("value"),
                        onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                            $("trimestrePersonalPlanilla").set('html', responseHTML);
                            tblPersonalPlanilla.loadData([
                                {name: 'anho', value: $("anhosPersonalPlanilla").get("value")},
                                {name: 'mes', value: $("trimestrePersonalPlanilla").get("value")},
                                {name: 'query', value: $("txtBuscarPersonalPlanilla").get("value").replace("&", "$$")},
                                {name: 'tipo', value: 1}
                            ]);
                        }
                    }).send();
                }*/

              /*  $("anhosPersonalPlanilla").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    cargarMesPersonalPlanilla();
                });
                $("trimestrePersonalPlanilla").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    tblPersonalPlanilla.loadData([
                        {name: 'anho', value: $("anhosPersonalPlanilla").get("value")},
                        {name: 'mes', value: $("trimestrePersonalPlanilla").get("value")},
                        {name: 'query', value: $("txtBuscarPersonalPlanilla").get("value").replace("&", "$$")},
                        {name: 'tipo', value: 1}
                    ]);
                });

                $("txtBuscarPersonalPlanilla").addEvent("keypress", function(evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblPersonalPlanilla.loadData([
                            {name: 'anho', value: $("anhosPersonalPlanilla").get("value")},
                            {name: 'mes', value: $("trimestrePersonalPlanilla").get("value")},
                            {name: 'query', value: $("txtBuscarPersonalPlanilla").get("value").replace("&", "$$")},
                            {name: 'tipo', value: 1}
                        ]);
                    }
                });*/
                
                /*ERS-Inicio*/
                tblPersonalDis = new JpGrid($("tbl-personal-dis"), {
                    id: "gridPersonalDis",
                    url: './GestionTransparente?action=ListarPersonalForDis',
                    altura: 'auto',
                    dataQuery: [
                        {name: 'anho', value: $("anhosPersonalDis").get("value")},
                        {name: 'query', value: $("txtBuscarPersonalDis").get("value").replace("&", "$$")},
                        {name: 'tipo', value: '2'}
                    ],
                    model: [
                        {name: "apellidosNombres", field: 'Apellidos y Nombres', width: "30%", sort: true, type: 'string'},
                        /*{name: "trimestre", field: 'Trimestre', width: "10%", type: 'string', renderer: function(val) {
                                if (val == 1)
                                    return  "Trimestre 1";
                                else if (val == 2)
                                    return "Trimestre 2";
                                else if (val == 3)
                                    return "Trimestre 3";
                                else if (val == 4)
                                    return "Trimestre 4";
                            }, style: {"text-align": "center"}},*/
                        {name: "oficinaArea", field: 'Oficina/Area', width: "50%", type: 'string', sort: true},
                        {name: "codigoCivil", field: 'C&oacute;digo Civil', width: "10%", type: 'string'},
                        {name: "remuneracionMensual", field: 'Retribución mensual (S/.)', width: "10%", type: 'numeric', style: {"text-align": "right"}}
                        
                    ]
                });

                anhoPersonalDis = new Request.HTML({
                    url: './GestionTransparente?action=ListarAnhosPersonalDis',
                    onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                        $("anhosPersonalDis").set('html', responseHTML);
                        cargarTrimestrePersonalDis();
                    }
                });
                anhoPersonalDis.send();
                var cargarTrimestrePersonalDis = function() {
                    var mesTrimestrePDis = new Request.HTML({
                        url: './GestionTransparente?action=ListarTrimestrePersonalDis&anho=' + $("anhosPersonalDis").get("value"),
                        onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                            $("trimestrePersonalDis").set('html', responseHTML);
                            tblPersonalDis.loadData([
                                {name: 'anho', value: $("anhosPersonalDis").get("value")},
                                {name: 'trimestre', value: $("trimestrePersonalDis").get("value")},
                                {name: 'query', value: $("txtBuscarPersonalDis").get("value").replace("&", "$$")}
                            ]);
                        }
                    }).send();
                }

                $("anhosPersonalDis").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    cargarTrimestrePersonalDis();
                });
                $("trimestrePersonalDis").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    tblPersonalDis.loadData([
                        {name: 'anho', value: $("anhosPersonalDis").get("value")},
                        {name: 'trimestre', value: $("trimestrePersonalDis").get("value")},
                        {name: 'query', value: $("txtBuscarPersonalDis").get("value").replace("&", "$$")}
                    ]);
                });

                $("txtBuscarPersonalDis").addEvent("keypress", function(evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblPersonalDis.loadData([
                            {name: 'anho', value: $("anhosPersonalDis").get("value")},
                            {name: 'trimestre', value: $("trimestrePersonalDis").get("value")},
                            {name: 'query', value: $("txtBuscarPersonalDis").get("value").replace("&", "$$")}
                        ]);
                    }
                });
                /*ERS-Final*/
    
                tblPersonalSNP = new JpGrid($("tbl-personal-snp"), {
                    id: "gridPersonalSNP",
                    url: './GestionTransparente?action=ListarPersonalForAdmin',
                    altura: 'auto',
                    dataQuery: [
                        {name: 'anho', value: $("anhosPersonalSNP").get("value")},
                        {name: 'query', value: $("txtBuscarPersonalSNP").get("value").replace("&", "$$")},
                        {name: 'tipo', value: '2'}
                    ],
                    model: [
                        {name: "apellidosNombres", field: 'Apellidos y Nombres', width: "30%", sort: true, type: 'string'},
                        /*{name: "trimestre", field: 'Trimestre', width: "10%", type: 'string', renderer: function(val) {
                                if (val == 1)
                                    return  "Trimestre 1";
                                else if (val == 2)
                                    return "Trimestre 2";
                                else if (val == 3)
                                    return "Trimestre 3";
                                else if (val == 4)
                                    return "Trimestre 4";
                            }, style: {"text-align": "center"}},*/
                        {name: "oficinaArea", field: 'Oficina/Area', width: "50%", type: 'string', sort: true},
                        {name: "codigoCivil", field: 'C&oacute;digo Civil', width: "10%", type: 'string'},
                        {name: "remuneracionMensual", field: 'Retribución mensual (S/.)', width: "10%", type: 'numeric', style: {"text-align": "right"}}
                        
                    ]
                });

                anhoPersonalSNP = new Request.HTML({
                    url: './GestionTransparente?action=ListarAnhosPersonalPlanilla&tipo=2',
                    onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                        $("anhosPersonalSNP").set('html', responseHTML);
                        cargarTrimestrePersonalSNP();
                    }
                });
                anhoPersonalSNP.send();
                var cargarTrimestrePersonalSNP = function() {
                    var mesTrimestreP = new Request.HTML({
                        url: './GestionTransparente?action=ListarTrimestrePersonal&tipo=2&anho=' + $("anhosPersonalSNP").get("value"),
                        onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                            $("trimestrePersonalSNP").set('html', responseHTML);
                            tblPersonalSNP.loadData([
                                {name: 'anho', value: $("anhosPersonalSNP").get("value")},
                                {name: 'trimestre', value: $("trimestrePersonalSNP").get("value")},
                                {name: 'query', value: $("txtBuscarPersonalSNP").get("value").replace("&", "$$")},
                                {name: 'tipo', value: 2}
                            ]);
                        }
                    }).send();
                }

                $("anhosPersonalSNP").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    cargarTrimestrePersonalSNP();
                });
                $("trimestrePersonalSNP").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    tblPersonalSNP.loadData([
                        {name: 'anho', value: $("anhosPersonalSNP").get("value")},
                        {name: 'trimestre', value: $("trimestrePersonalSNP").get("value")},
                        {name: 'query', value: $("txtBuscarPersonalSNP").get("value").replace("&", "$$")},
                        {name: 'tipo', value: 2}
                    ]);
                });

                $("txtBuscarPersonalSNP").addEvent("keypress", function(evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblPersonalSNP.loadData([
                            {name: 'anho', value: $("anhosPersonalSNP").get("value")},
                            {name: 'trimestre', value: $("trimestrePersonalSNP").get("value")},
                            {name: 'query', value: $("txtBuscarPersonalSNP").get("value").replace("&", "$$")},
                            {name: 'tipo', value: 2}
                        ]);
                    }
                });

                tblPersonalCAS = new JpGrid($("tbl-personal-cas"), {
                    id: "gridPersonalCAS",
                    url: './GestionTransparente?action=ListarPersonalForAdmin',
                    altura: 'auto',
                    dataQuery: [
                        {name: 'anho', value: $("anhosPersonalCAS").get("value")},
                        {name: 'query', value: $("txtBuscarPersonalCAS").get("value").replace("&", "$$")},
                        {name: 'tipo', value: 3}
                    ],
                    model: [
                        {name: "apellidosNombres", field: 'Apellidos y Nombres', width: "40%", sort: true, type: 'string'},
                        /*{name: "trimestre", field: 'Trimestre', width: "10%", type: 'string', renderer: function(val) {
                                if (val == 1)
                                    return "Trimestre 1";
                                else if (val == 2)
                                    return "Trimestre 2";
                                else if (val == 3)
                                    return "Trimestre 3";
                                else if (val == 4)
                                    return "Trimestre 4";
                            }, style: {"text-align": "center"}},*/
                        {name: "oficinaArea", field: 'Oficina/Area', width: "50%", type: 'string', sort: true},
                        {name: "codigoCivil", field: 'C&oacute;digo Civil', width: "10%", type: 'string', style: {"text-align": "center"}},
                        {name: "ingresoTotal", field: 'Remuneraci&oacute;n (S/.)', width: "10%", type: 'numeric', style: {"text-align": "right"}}
                    ]
                });

                anhoPersonalCAS = new Request.HTML({
                    url: './GestionTransparente?action=ListarAnhosPersonalPlanilla&tipo=3',
                    onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                        $("anhosPersonalCAS").set('html', responseHTML);
                        cargarTrimestrePersonalCAS();
                    }
                });
                anhoPersonalCAS.send();
                var cargarTrimestrePersonalCAS = function() {
                    var mesTrimestreP = new Request.HTML({
                        url: './GestionTransparente?action=ListarTrimestrePersonal&tipo=3&anho=' + $("anhosPersonalCAS").get("value"),
                        onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                            $("trimestrePersonalCAS").set('html', responseHTML);
                            tblPersonalCAS.loadData([
                                {name: 'anho', value: $("anhosPersonalCAS").get("value")},
                                {name: 'trimestre', value: $("trimestrePersonalCAS").get("value")},
                                {name: 'query', value: $("txtBuscarPersonalCAS").get("value").replace("&", "$$")},
                                {name: 'tipo', value: 3}
                            ]);
                        }
                    }).send();
                }

                $("anhosPersonalCAS").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    cargarTrimestrePersonalCAS();
                });
                $("trimestrePersonalCAS").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    tblPersonalCAS.loadData([
                        {name: 'anho', value: $("anhosPersonalCAS").get("value")},
                        {name: 'trimestre', value: $("trimestrePersonalCAS").get("value")},
                        {name: 'query', value: $("txtBuscarPersonalCAS").get("value").replace("&", "$$")},
                        {name: 'tipo', value: 3}
                    ]);
                });

                $("txtBuscarPersonalCAS").addEvent("keypress", function(evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblPersonalCAS.loadData([
                            {name: 'anho', value: $("anhosPersonalCAS").get("value")},
                            {name: 'trimestre', value: $("trimestrePersonalCAS").get("value")},
                            {name: 'query', value: $("txtBuscarPersonalCAS").get("value").replace("&", "$$")},
                            {name: 'tipo', value: 3}
                        ]);
                    }
                });

                //gruilla categoria
                tblPersonalCategoria = new JpGrid($("tbl-personal-categoria"), {
                    id: "gridPersonalCategoria",
                    url: './GestionTransparente?action=PersonalCategoria',
                    altura: 'auto',
                    dataQuery: [
                        {name: 'anho', value: $("anhosPersonalCategoria").get("value")},
                        {name: 'query', value: $("txtBuscarPersonalCategoria").get("value").replace("&", "$$")}
                    ],
                    model: [
                        {name: "codigo", field: 'C&oacute;digo', width: "10%", type: 'string', style: {"text-align": "center"}},
                        /*{name: "trimestre", field: 'Trimestre', width: "10%", type: 'string', renderer: function(val) {
                                if (val == 1)
                                    return "Trimestre 1";
                                else if (val == 2)
                                    return "Trimestre 2";
                                else if (val == 3)
                                    return "Trimestre 3";
                                else if (val == 4)
                                    return "Trimestre 4";
                            }, style: {"text-align": "center"}},*/
                        {name: "categoria", field: 'Categor&iacute;a', width: "40%", type: 'string', sort: true, style: {"text-align": "center"}},
                        {name: "remuneracionMinima", field: 'Remuneraci&oacute;n M&iacute;nima', width: "20%", type: 'numeric', style: {"text-align": "right"}},
                        {name: "remuneracionMaxima", field: 'Remuneraci&oacute;n M&aacute;xima', width: "20%", type: 'numeric', style: {"text-align": "right"}},
                        {name: "numeroTrabajadores", field: 'N° de Trabajadores', width: "10%", type: 'integer', style: {"text-align": "center"}}
                    ]
                });


                anhoPersonalCategoria = new Request.HTML({
                    url: './GestionTransparente?action=ListarAnhosPersonalCategoria',
                    onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                        $("anhosPersonalCategoria").set('html', responseHTML);
                        cargarTrimestrePersonalCategoria();
                    }
                });
                anhoPersonalCategoria.send();
                var cargarTrimestrePersonalCategoria = function() {
                    var mesTrimestreP = new Request.HTML({
                        url: './GestionTransparente?action=ListarTrimestreCategoria&anho=' + $("anhosPersonalCategoria").get("value"),
                        onSuccess: function(responseTree, responseElements, responseHTML, responseJavaScript) {
                            $("trimestrePersonalCategoria").set('html', responseHTML);
                            tblPersonalCategoria.loadData([
                                {name: 'anho', value: $("anhosPersonalCategoria").get("value")},
                                {name: 'trimestre', value: $("trimestrePersonalCategoria").get("value")},
                                {name: 'query', value: $("txtBuscarPersonalCategoria").get("value").replace("&", "$$")},
                                {name: 'tipo', value: 3}
                            ]);
                        }
                    }).send();
                }

                $("anhosPersonalCategoria").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    cargarTrimestrePersonalCategoria();
                });
                $("trimestrePersonalCategoria").addEvent("change", function(evt) {
                    evt.stopPropagation();
                    tblPersonalCategoria.loadData([
                        {name: 'anho', value: $("anhosPersonalCategoria").get("value")},
                        {name: 'trimestre', value: $("trimestrePersonalCategoria").get("value")},
                        {name: 'query', value: $("txtBuscarPersonalCategoria").get("value").replace("&", "$$")}
                    ]);
                });

                $("txtBuscarPersonalCategoria").addEvent("keypress", function(evt) {
                    evt.stopPropagation();
                    if (evt.code == 13) {
                        tblPersonalCategoria.loadData([
                            {name: 'anho', value: $("anhosPersonalCategoria").get("value")},
                            {name: 'trimestre', value: $("trimestrePersonalCategoria").get("value")},
                            {name: 'query', value: $("txtBuscarPersonalCategoria").get("value").replace("&", "$$")}
                        ]);
                    }
                });

                $$(".print").addEvent("click", function(evt) {
                    var url = this.get("rev");
                    var anho = this.getParent("label").getParent("div").getNext("div").getChildren(".anho").get("value");
                    var trimestre = this.getParent("label").getParent("div").getNext("div").getChildren(".trimestre").get("value");

                    this.set("href", url + "?format=" + this.get("rel") + "&anho=" + anho + "&trimestre=" + trimestre);
                });
            });
        </script>
        <title>Recursos Humanos</title>
    </head>
    <body>
        <%@include file="../jspf/cabecera.jspf" %>  
        <div class="wrappere">
            
            <div class="cuerpo">
                <div class="navegacion">
                    <h2>
                        <a href="./Inicio">Inicio</a> / <a href="./GestionTransparente">Gesti&oacute;n Transparente</a> / Recursos Humanos
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
                        <div class="panel efecto active">
                            <div class="rrhh"></div>
                            <div class="descripcion" style="font-size:11px">Recursos Humanos</div>
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
                        <h2 id="st4">Plana Gerencial y Directivos</h2>
                        <div id="sp4">                     
                            <div id="tbl-funcionario"></div>  
                        </div>
                    </div>
                    <div class="sliderPanel">
                        <h2 id="st5">Consejo Directivo</h2>
                        <div id="sp5">                     
                            <div id="tbl-directivo"></div>  
                        </div>
                    </div>
                    <div class="sliderPanel">
                        <h2 id="st6">Remuneraci&oacute;n por Categor&iacute;as</h2>
                        <div id="sp6">
                            <div class="search">
                                <div class="content-l">
                                    <label style="margin: 10px auto auto 10px; float: left; font-weight: bold; color: #6A6C71;">Obtener Reporte completo en: </label>
                                    <label style="margin-left: 15px;">
                                        <a style="margin: auto 20px auto 0px;" target="_blank" rel="pdf" rev="./PersonalCategoriaPrint" class="print"><img src="./resources/images/16x16/pdf.png" /></a>
                                        <a style="margin: auto 10px auto 10px;" target="_blank" rel="excel" rev="./PersonalCategoriaPrint" class="print"><img src="./resources/images/16x16/excel.png" /></a>
                                        <a style="margin: auto 10px auto 10px;" target="_blank" rel="odt" rev="./PersonalCategoriaPrint" class="print"><img src="./resources/images/16x16/word.png" /></a>
                                    </label>
                                </div>
                                <div class="content-i" style="width:54%">
                                    <label style="margin-right:13px; margin-left:5px; font-weight: bold; color: #6A6C71;"> Buscar por Categor&iacute;a</label><input type="text" id="txtBuscarPersonalCategoria" />
                                    <label style="margin-right:13px; margin-left:5px; font-weight: bold; color: #6A6C71;">A&ntilde;o:</label><select class="anho" id="anhosPersonalCategoria"></select>
                                    <label style="margin-right:13px; margin-left:5px; font-weight: bold; color: #6A6C71;">Trimestre:</label><select class="trimestre" id="trimestrePersonalCategoria"></select>
                                </div>
                            </div>
                            <div id="tbl-personal-categoria" class="grid"></div>  
                        </div>
                    </div>

                    <div class="sliderPanel">
                        <h2 id="st1">Personal y Remuneraciones - R&eacute;gimen Lab. D.L. 728</h2>
                        <div id="sp1">
                            <div class="search">
                                <div class="content-l">
                                    <label style="margin: 10px auto auto 10px; float: left; font-weight: bold; color: #6A6C71;">Obtener Reporte completo en: </label>
                                    <label style="margin-left: 15px;">
                                        <a style="margin: auto 20px auto 0px;" target="_blank" rel="pdf" rev="./PersonalPlanillaPrint" class="print"><img src="./resources/images/16x16/pdf.png" /></a>
                                        <a style="margin: auto 10px auto 10px;" target="_blank" rel="excel" rev="./PersonalPlanillaPrint" class="print"><img src="./resources/images/16x16/excel.png" /></a>
                                        <a style="margin: auto 10px auto 10px;" target="_blank" rel="odt" rev="./PersonalPlanillaPrint" class="print"><img src="./resources/images/16x16/word.png" /></a>
                                    </label>
                                </div>
                                <div class="content-i" style='width:54%'>
                                    <label style="margin-right:13px; margin-left:5px; font-weight: bold; color: #6A6C71;">Buscar: </label><input type="text" id="txtBuscarPersonalPlanilla" />
                                    <label style="margin-right:13px; margin-left:5px; font-weight: bold; color: #6A6C71;">A&ntilde;o:</label><select class="anho" id="anhosPersonalPlanilla"></select>
                                    <label style="margin-right:13px; margin-left:5px; font-weight: bold; color: #6A6C71;">Periodo:</label>
                                        <select class="trimestre" id="trimestrePersonalPlanilla">
                                        
                                        </select>
                                </div>
                            </div>
                            <div id="tbl-personal-planilla" class="grid"></div>
                        </div>
                    </div>
                    <div class="sliderPanel">
                        <h2 id="st2">Personal y Remuneraciones - Contrato por Locaci&oacute;n de Servicios</h2>
                        <div id="sp2">
                            <div class="search">
                                <div class="content-l">
                                    <label style="margin: 10px auto auto 10px; float: left; font-weight: bold; color: #6A6C71;">Obtener Reporte completo en:</label>
                                    <label style="margin-left: 15px;">
                                        <a style="margin: auto 20px auto 0px;" target="_blank" rel="pdf" rev="./PersonalServicioPrint" class="print"><img src="./resources/images/16x16/pdf.png" /></a>
                                        <a style="margin: auto 10px auto 10px;" target="_blank" rel="excel" rev="./PersonalServicioPrint" class="print"><img src="./resources/images/16x16/excel.png" /></a>
                                        <a style="margin: auto 10px auto 10px;" target="_blank" rel="odt" rev="./PersonalServicioPrint" class="print"><img src="./resources/images/16x16/word.png" /></a>
                                    </label>
                                </div>
                                <div class="content-i" style='width:54%'>
                                    <label style="margin-right:13px; margin-left:5px; font-weight: bold; color: #6A6C71;">Buscar:</label><input type="text" id="txtBuscarPersonalSNP" />
                                    <label style="margin-right:13px; margin-left:5px; font-weight: bold; color: #6A6C71;">A&ntilde;o:</label><select class="anho" id="anhosPersonalSNP"></select>
                                    <label style="margin-right:13px; margin-left:5px; font-weight: bold; color: #6A6C71;">Trimestre:</label><select class="trimestre" id="trimestrePersonalSNP"></select>
                                </div>
                            </div>
                            <div id="tbl-personal-snp" class="grid"></div>  
                        </div>
                    </div>
                    <div class="sliderPanel">
                        <h2 id="st3">Personal y Remuneraciones - Contrato Administrativo de Servicios</h2>
                        <div id="sp3">
                            <div class="search">
                                <div class="content-l">

                                    <label style="margin: 10px auto auto 10px; float: left; font-weight: bold; color: #6A6C71;"">Obtener Reporte completo en:</label>
                                    <label style="margin-left: 15px;">
                                        <a style="margin: auto 20px auto 0px;" target="_blank" rel="pdf" rev="./PersonalCASPrint" class="print"><img src="./resources/images/16x16/pdf.png" /></a>
                                        <a style="margin: auto 10px auto 10px;" target="_blank" rel="excel" rev="./PersonalCASPrint" class="print"><img src="./resources/images/16x16/excel.png" /></a>
                                        <a style="margin: auto 10px auto 10px;" target="_blank" rel="odt" rev="./PersonalCASPrint" class="print"><img src="./resources/images/16x16/word.png" /></a>                                    </label>
                                </div>
                                <div class="content-i" style="width:54%">
                                    <label style="margin-right:13px; margin-left:5px; font-weight: bold; color: #6A6C71;">Buscar:</label><input type="text" id="txtBuscarPersonalCAS" />
                                    <label style="margin-right:13px; margin-left:5px; font-weight: bold; color: #6A6C71;">A&ntilde;o:</label><select class="anho" id="anhosPersonalCAS"></select>
                                    <label style="margin-right:13px; margin-left:5px; font-weight: bold; color: #6A6C71;">Trimestre:</label><select class="trimestre" id="trimestrePersonalCAS"></select>
                                </div>
                            </div>
                            <div id="tbl-personal-cas" class="grid"></div>  
                        </div>
                    </div>
                    <!-- -->
                    <div class="sliderPanel">
                        <h2 id="st7">Personal con Discapacidad</h2>
                        <div id="sp7">
                            <div class="search">
                                <div class="content-l">

                                    <label style="margin: 10px auto auto 10px; float: left; font-weight: bold; color: #6A6C71;">Obtener Reporte completo en:</label>
                                    <label style="margin-left: 15px;">
                                        <a style="margin: auto 20px auto 0px;" target="_blank" rel="pdf" rev="./PersonalDisPrint" class="print"><img src="./resources/images/16x16/pdf.png" /></a>
                                        <a style="margin: auto 10px auto 10px;" target="_blank" rel="excel" rev="./PersonalDisPrint" class="print"><img src="./resources/images/16x16/excel.png" /></a>
                                        <a style="margin: auto 10px auto 10px;" target="_blank" rel="odt" rev="./PersonalDisPrint" class="print"><img src="./resources/images/16x16/word.png" /></a>                                    </label>
                                </div>
                                <div class="content-i" style="width:54%">
                                    <label style="margin-right:13px; margin-left:5px; font-weight: bold; color: #6A6C71;">Buscar:</label><input type="text" id="txtBuscarPersonalDis" />
                                    <label style="margin-right:13px; margin-left:5px; font-weight: bold; color: #6A6C71;">A&ntilde;o:</label><select class="anho" id="anhosPersonalDis"></select>
                                    <label style="margin-right:13px; margin-left:5px; font-weight: bold; color: #6A6C71;">Trimestre:</label><select class="trimestre" id="trimestrePersonalDis"></select>
                                </div>
                            </div>
                            <div id="tbl-personal-dis" class="grid"></div>  
                        </div>
                    </div>
                    <!-- -->
                </div>
            </div>
            
        </div>
        <%@include file="../jspf/pie.jspf" %>
    </body>
</html>
