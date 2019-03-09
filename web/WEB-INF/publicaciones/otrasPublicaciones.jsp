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
                //$('contenedor-notice').setFocus();
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
               /* $$('.panel').multiFade();
                $("cab1").addEvent("click",function(){
                    $("hidenoti").setStyle('display', 'block');
                    $("s-content").setStyle('display', 'block');
                });
                 $("hidenoti").setStyle('display', 'none').addEvent("click",function(){
                    $("hidenoti").setStyle('display', 'none');
                    $("s-content").setStyle('display', 'none');
                });*/
                
                var tblOtraPublicacion;
                tblOtraPublicacion= new JpGrid($("tbl-otrapublicacion"),{
                    id:"gridOtraPublicacion",
                    url:'./Publicaciones?action=ListarPublicacionForWeb',                   
                    dataQuery:[
                        {name:'query',value:$("txtBuscarOtraPublicacion").get("value").replace("&","$$")},
                        {name:'tipo',value:'3'}
                    ],
                    model:[
                        {name:"anho", field:'Fecha', width:"7%", style: {"text-align": "center"},sort:true, type:'string'},
                        {name:"titulo", field:'Titulo', width:"20%", maxLength:100, sort:true, type:'string'},
                        {name:"descripcion", field:'Contenido',  width:"65%", type:'string'},
                        {name:"docuId",field:'Descagar',width:"7%", style: {"text-align": "center"},clase:'tips', title:'Explicación' , filtro:'descripcion', activo:'activo' ,type:'string',renderer:function(val){                                        
                                return '<a class="pdf" target="_blank" href="./GestionTransparente?action=verDocumentosGestion&id='+val+'"></a>'
                            }}
                    ]
                });
                
                $("btnBuscarOtraPublicacion").addEvent("click",function(evt){
                    evt.stopPropagation();
                    tblOtraPublicacion.loadData([
                        {name:'query',value:$("txtBuscarOtraPublicacion").get("value").replace("&","$$")},
                        {name:'tipo',value:'3'}
                    ]);
                });                
                $("txtBuscarOtraPublicacion").addEvent("keypress",function(evt){
                    evt.stopPropagation();
                    if(evt.code==13){
                        tblOtraPublicacion.loadData([
                            {name:'query',value:$("txtBuscarOtraPublicacion").get("value").replace("&","$$")},
                            {name:'tipo',value:'3'}
                        ]);
                    }                        
                });
               /* var notice= new JpSlider( $("s-content"),{
                    url : './Publicaciones?action=NotaPrensaForNotice',
                    type:'notice'});
                var links= new JpSlider($("enlaces"),{url:'./Enlace',type:'links'});*/
            });
        </script>
        <title>Otras Publicaciones</title>
    </head>
    <body>
        <%@include file="../jspf/cabecera.jspf" %> 
        <div class="wrapper2">
            
            <div class="cuerpo">
                <div class="navegacion">
                    <h2><a href="./Inicio">Inicio</a> / <a href="./Publicaciones">Publicaciones</a> / OtraPublicacion </h2>
                </div>
                <div class="services text-center">
                    <div class="gadget">
                        <div class="panel">
                            <a href="./Publicaciones?action=NotaPrensa">
                                <div class="noticia"></div>
                                <div class="descripcion" class="descripcion" style="font-size:11px">
                                    Noticia/Nota Prensa
                                </div>
                            </a>
                        </div>
                        <div class="panel">
                            <a href="./Publicaciones?action=NoticiasMultimedia">
                                <div class="videos"></div>
                                <div class="descripcion" class="descripcion" style="font-size:11px">Noticias Multimedia</div>
                            </a>
                        </div>
                        <div class="panel">
                            <a href="./Publicaciones?action=MemoriasAnuales">
                                <div class="memoria"></div>
                                <div class="descripcion" class="descripcion" style="font-size:11px">Memorias Anuales</div>
                            </a>
                        </div>
                        <div class="panel">
                            <a href="./Publicaciones?action=Comunicados">
                                <div class="comunicado"></div>
                                <div class="descripcion" class="descripcion" style="font-size:11px">Comunicados</div>
                            </a>
                        </div>
                        <!--<div class="panel">
                            <a href="./Publicaciones?action=Articulos">
                                <div class="articulo"></div>
                                <div class="descripcion">Art&iacute;culos</div>
                            </a>
                        </div>   -->
                        <div class="panel active">
                            <div class="otros-publicacion"></div>
                            <div class="descripcion" class="descripcion" style="font-size:11px">Otras Publicaciones</div>
                        </div>  
                    </div>
                </div>
                <div class="cdesk">
                    <div class="sliderPanel">
                        <h2>Otras Publicaciones</h2>
                        <div id="sp1">
                            <div class="search">

                                <div class="content-i">
                                    <label style="margin-right:15px; font-weight: bold; color: #6A6C71;">Buscar Publicaciones:</label><input  id="txtBuscarOtraPublicacion" style="margin-right:3px"/><button id="btnBuscarOtraPublicacion">Buscar</button>             
                                </div>
                            </div>
                            <div id="tbl-otrapublicacion" class="grid"></div>  
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
        <%@include file="../jspf/pie.jspf" %>
    </body>
</html>
