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
                var notice= new JpSlider(               $("s-content"),{
                    url : './Publicaciones?action=NotaPrensaForNotice',
                    type:'notice'});
                var links= new JpSlider($("enlaces"),{url:'./Enlace',type:'links'});
                */
                
                
                 //Exonerado
                var tblExonerado;
                
                var  anhoExonerado =new Request.HTML({
                    url:'./Convocatoria?action=ListarAnhosExonerado' ,
                    onSuccess:function(responseTree, responseElements, responseHTML, responseJavaScript){
                        $("anhosExonerado").set('html',responseHTML);
                        tblExonerado= new JpGrid($("tbl-exonerado"),{
                            id:"gridExonerado",
                            url:'./Convocatoria?action=ListarExoneradoForWeb',                   
                            dataQuery:[
                                {name:'anho',value:$("anhosExonerado").get("value")},
                                {name:'query',value:$("txtBuscarExonerado").get("value").replace("&","$$")}
                            ],
                            success: function(e){
                                $$(".tips").addEvent('click', function() {
                                    ToolTip.instance(this, {
                                        autohide: false,
                                        position: {position: 'bottom', edge: 'top'}
                                    },
                                    this.get('dir')
                                ).show();
                                
                                });
                            },
                            model:[
                                {name:"fecha",field:'Fecha',sort:true,width:"5%",type:'string'},
                                {name:"causa",field:'Causal',width:"8%",type:'string'},
                                {name:"objeto",field:'Objeto del Proceso',width:"15%",type:'string'},
                                {name:"descripcion",field:'Descripción del proceso',width:"35%",type:'string'},
                                {name:"monto",field:'Monto de Contrato',width:"8%",type:'string'},
                                {name:"contratista",field:'Contratista',width:"12%",type:'string'},
                                {name:"ruc",field:'R.U.C.',width:"5%",type:'string'},
                                {name:"url",field:'Link SEACE', style: {"text-align": "center"},width:"5%",clase:'tips', title:'Explicación' , filtro:'descripcion', activo:'activo' ,type:'string',renderer:function(val){
                                        return '<a class="url" target="_blank" href="'+val+'"></a>'
                                    }}
                            ]
                        });
                    }
                });
                anhoExonerado.send();
                
                $("anhosExonerado").addEvent("change",function(evt){
                    evt.stopPropagation();
                    tblExonerado.loadData([
                        {name:'anho',value:$("anhosExonerado").get("value")},
                        
                        {name:'query',value:$("txtBuscarExonerado").get("value").replace("&","$$")}
                    ]);
                });
                $("btnBuscarExonerado").addEvent("click",function(evt){
                    evt.stopPropagation();
                    tblExonerado.loadData([
                        {name:'anho',value:$("anhosExonerado").get("value")},
                        
                        {name:'query',value:$("txtBuscarExonerado").get("value").replace("&","$$")}
                    ]);
                });                
                $("txtBuscarExonerado").addEvent("keypress",function(evt){
                    evt.stopPropagation();
                    if(evt.code==13){
                        tblExonerado.loadData([
                            {name:'anho',value:$("anhosExonerado").get("value")},
                            {name:'query',value:$("txtBuscarExonerado").get("value").replace("&","$$")}
                        ]);
                    }                        
                });
                
                
            });
        </script>
        <style type="text/css">
            .tablet{
                border:1px solid green;
                font-size: 100%;
                width: 100%
            }
            .tablet tr {
                padding: 3px;
            }

            .tabla {
                margin-bottom: 10px;

            }
            .tabla thead th{
                border: 1px solid #B4D3A4;
                text-align: center;
                background-color: #eaf7e6;
            }
            .tabla1 tbody th {
                text-align: center;
                background-color: #eaf7e6;
            }
            .tabla tbody tr  th { 
                text-align: center;
                background-color: #eaf7e6 ;
            }
            .tabla tbody tr td, th {
                border: 1px solid #B4D3A4;
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

            .files{border: 1px solid #B4D3A4; margin-left: 5px}


        </style>
        <title>Procesos Exonerados </title>
    </head>
    <body>
        <%@include file="../jspf/cabecera.jspf" %>
        <div class="wrapper2" style="">
            
            <div class="cuerpo">
                <div class="navegacion">
                    <h2><a href="./Inicio">Inicio</a> / <a href="./Convocatorias">Selecci&oacute;n de Personal</a> / Procesos Exonerados </h2>
                </div>
                <div class="services text-center">
                    <div class="gadget">
                        <div class="panel efecto ">
                            <a href="./Convocatorias?action=convocatoria">
                                <div class="icon-bien"></div>
                                <div class="descripcion" style="font-size: 11px">Bienes, Servicios, Obras y Concesiones</div>
                            </a>
                        </div>                      
                       <div class="panel efecto ">
                            <a href="./Convocatorias?action=Comites">
                                <div class="icon-comite"></div>
                                <div class="descripcion" style="font-size: 11px">Comit&eacute;s de Contrataciones</div>
                            </a>
                        </div>  
                        <div class="panel efecto active">
                            
                                <div class="icon-exonerado"></div>
                                <div class="descripcion" style="font-size: 11px">Procesos Exonerados</div>
                            
                        </div> 
                    </div>
                </div>

                <div class="cdesk">
                    <h3 style="text-align: center; text-shadow: 1px 1px 0px rgba(0, 0, 0, 0.2), 1px 1px 0px rgba(0, 0, 0, 0.2), 1px 1px 0px rgba(0, 0, 0, 0.2)">Organo Encargado de las contrataciones: Oficina de Administraci&oacute;n (Abastecimiento y Servicios Auxiliares) </h3>
                    <div class="sliderPanel">
                        <h2 id="st2" >Procesos Exonerados </h2>
                        <div id="sp2" >
                            <div class="search">
                                <div class="content-l">
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Filtrar por A&ntilde;o:</label><select id="anhosExonerado"></select>
                                </div>
                                <div class="content-i">
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Buscar: </label><input  id="txtBuscarExonerado" style="margin-right:3px" /><button id="btnBuscarExonerado">Buscar</button>             
                                </div>
                            </div>
                            <div id="tbl-exonerado" class="grid"></div>  
                        </div>
                    </div>
                    
                </div>
            </div>
            
        </div>
        <%@include file="../jspf/pie.jspf" %>
    </body>
</html>
