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
        <script type="text/javascript" src="resources/js/AlMultiFade.js"></script>
        <script type="text/javascript" src="resources/js/JpGrid.js"></script>
        
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
                    onActive: function(toggler, element){
                        toggler.addClass('active');
                    },
                    onBackground: function(toggler, element){
                        toggler.removeClass('active');
                    }
                });
                $$('.efecto').multiFade();
                $('buscarPag').buscarDato("norte");
                
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
                //convocatorias vigentes
                var tblConvocatoria= new JpGrid($("tbl-convocatoria"),{
                    id: "gridConvocatoria",
                    url: './Convocatorias?action=listconvocatoriapers',
                    ancho: '100%',
                    select: 0,
                    dataQuery:[
                        {name: 'query', value: $("txtBuscarConvocatoria").get("value").replace("&","$$")},
                        {name: 'flag', value: 'true'}
                    ],
                    onClick : function(a){
                        var funcDocs = function(e) {
                            ajaxdocs = new Request({
                                url:"./ConvocatoriaPers?action=listarDocumentoConvocatoriaForWeb&id="+e,
                                onComplete: function(data) {
                                    $("docs").set("html",data);
                                }}).send();
                        }
                        var $array = a.get("data-store").split("|");
                        $("crono").set("html", "cargando...");
                        ajax = new Request({
                            url:"./ConvocatoriaPers?action=listarCalendarioConvocatoriaPersForWeb&convo_id="+$array[0],
                            onComplete: function(data) {
                                $("crono").set("html",data);
                                $$(".detal").each(function(e){
                                    e.addEvent("click", function(){
                                        funcDocs(this.get("data"));
                                    });
                                });
                                var codigo =$$(".detal[data-index=0]").get("data");
                                funcDocs(codigo)
                            }
                        }).send();
                        ajax = new Request({
                            url:"./ConvocatoriaPers?action=listarPlazaConvocatoriaForWeb&coper_id="+$array[0],
                            onComplete: function(data) {
                                
                                $("plazaContent").set("html",data);
                            }
                        }).send();
                    },
                    model:[
                        {name:"convocatoria",field:'Convocatoria',width:"30%",type:'string'},
                        {name:"descripcion", style: {"text-align": "justify"},field:'Descripci&oacute;n',width:"40%",type:'string'},
                        {name:"fecha",field:'Fecha',width:"8%",type:'string'},
                        {name:"estado",field:'Estado',width:"8%",type:'boolean', items:[{id : true, valor: "Vigente"}, {id: false, valor:"Finalizada"}]},
                        {name:"coperId", hidden:true}
                    ]
                }); 
                
                $("btnBuscarConvocatoria").addEvent("click",function(evt){
                    evt.preventDefault();
                    tblConvocatoria.loadData([
                        {name:'query',value:$("txtBuscarConvocatoria").get("value").replace("&","$$")},
                        {name: 'flag', value: 'true'}
                    ]);
                });
                
                $("txtBuscarConvocatoria").addEvent("keypress",function(evt){
                    evt.stopPropagation();
                    if(evt.code==13){
                        tblConvocatoria.loadData([
                            {name:'query',value:$("txtBuscarConvocatoria").get("value").replace("&","$$")},
                            {name: 'flag', value: 'true'}
                        ]);
                    }                     
                });
            });
        </script>
        <style>

            .tabla {
                margin-bottom: 10px;

            }
            .tabla thead th{
                border: 1px solid #fff;
                text-align: center;
                background-color: #29abe2;
            }
            .tabla1 head th {
                text-align: center;
                background-color: #29abe2;
            }
            .tabla tbody tr  th { 
                text-align: center;
                background-color: #29abe2 ;
            }
            .tabla tbody tr td, th {
                border: 1px solid #fff;
                height: 20px;
                
            }

            #detalle-convo_1{
                *display: inline;
                display: inline-block;
            }

            #content-convo{
                *display: inline;
                display: inline-block;                
            }
            .gray{
                background-color: #cecece;
            }

        </style>
        <title>Convocatorias de Personal</title>
    </head>
    <body>
        <%@include file="../jspf/cabecera.jspf" %>    
        <div class="wrapper2" style="">
            
            <div class="cuerpo">
                <div class="navegacion">
                    <h2><a href="./Inicio">Inicio</a> / <a href="./Convocatorias">Selecci&oacute;n de Personal</a> / Convocatorias de Personal</h2>
                </div>
                

                <div class="cdesk">
                    <div class="sliderPanel" style="height:auto">
                        <h2 id="st1">Lista de Convocatorias: Selecci&oacute;n Personal </h2>
                        <div id="sp1">
                            <div class="search" style="padding: 10px;">
                                <div class="mensaje-nota"><strong>Nota:</strong> Para ver m&aacute;s datos sobre la convocatoria, haga click en cada convocatoria de la tabla izquierda</div>
                                <div class="content-i">
                                    <label style="margin-right:13px; margin-left:5px; font-weight: bold; color: #6A6C71;">Buscar Convocatoria:</label><input type="text" id="txtBuscarConvocatoria" style="margin-right:3px"/><button id="btnBuscarConvocatoria">Buscar</button>
                                </div>
                            </div>

                            <div id="content-convo"  style="width: 50%; float: left;padding: 10px;">
                                <div id="tbl-convocatoria" class="grid"></div>
                            </div>

                            <div id ="detalle-convo_1" style="width: 50%; float: right;padding: 10px;">
                                <h2>Cronograma del proceso</h2>
                                <table class="tabla" style="width: 100%; " >
                                    <thead style="color: #fff;">
                                    <th class="bold" width="45%" style="font-weight: bold;" >Actividad</th><th class="bold" width="20%" style="font-weight: bold;" >Fecha Inicio</th><th width="20%"  class="bold" style="font-weight: bold;">Fecha Final</th><th width="25%"  class="bold" style="font-weight: bold;">Detalle</th>
                                    </thead>
                                    <tbody id="crono" style="font-family: Arial,Verdana,Helvetica,sans-serif;">
                                    </tbody>
                                </table >
                                <h2>Detalle Documentario</h2>
                                <table class="tabla" style="width: 400px;">
                                    <thead style="color: #fff;">
                                    <th class="bold" width="55%" style="font-weight: bold;">Nombre</th><th class="bold" width="25%" style="font-weight: bold;">Documento</th>
                                    </thead>
                                    <tbody id="docs" style="font-family: Arial,Verdana,Helvetica,sans-serif;">
                                    </tbody>
                                </table>
                            </div>

                            <table class="tabla"  border="1" cellpadding="3" cellspacing="0" width="100%" style="border-collapse: collapse;   border: 1px solid #000;" >
                                <thead>
                                <th class="bold" colspan="2" style="background-color:#29abe2; font-weight: bold;">Plazas de Convocatoria</th>
                                </thead>
                                <table width="100%" class="tabla"  id="plazaContent" style="font-family: Arial,Verdana,Helvetica,sans-serif;">
                                </table>
                            </table>
                        </div>
                    </div>
                </div>

            </div>
            
        </div>
        <%@include file="../jspf/pie.jspf" %>
    </body>
</html>