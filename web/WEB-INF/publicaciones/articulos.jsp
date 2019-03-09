<%-- 
    Document   : institucion
    Created on : 30/05/2012, 02:53:26 PM
    Author     : jprada
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=9" />
        <link type="text/css" rel="stylesheet" href="resources/css/estilo.css" />
        <script type="text/javascript" src="resources/js/mootools-core.js"></script>
        <script type="text/javascript" src="resources/js/mootools-more.js"></script>
        <script type="text/javascript" src="resources/js/JpSlider.js"></script>
        <script type="text/javascript" src="resources/js/JpGrid.js"></script>
        <script type="text/javascript" src="resources/js/AlMultiFade.js"></script>
        <script type="text/javascript">
            window.addEvent("domready",function(){
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
                $$('.panel').multiFade();
                $("cab1").addEvent("click",function(){
                    $("hidenoti").setStyle('display', 'block');
                    $("s-content").setStyle('display', 'block');
                });
                 $("hidenoti").setStyle('display', 'none').addEvent("click",function(){
                    $("hidenoti").setStyle('display', 'none');
                    $("s-content").setStyle('display', 'none');
                });
                
                var tblArticulos;
                tblArticulos= new JpGrid($("tbl-articulos"),{
                    id:"gridArticulos",
                    url:'./Publicaciones?action=ListarPublicacionForWeb',                   
                    dataQuery:[
                        {name:'query',value:$("txtBuscarArticulos").get("value").replace("&","$$")},
                        {name:'tipo',value:'2'}
                    ],
                    model:[
                        {name:"anho", field:'Fecha', width:"10%", sort:true, type:'string'},
                        {name:"titulo", field:'Titulo', width:"20%", maxLength:100, sort:true, type:'string'},
                        {name:"descripcion", field:'Contenido', maxLength:200, width:"60%",type:'string', removeTags:"'/<[^>]+>/g,''"},
                        {name:"direccionArchivo", field:'Archivo', width:"10%", sort:true, type:'string', link:{url: './archivos/', target: '_blank', text:'Descargar'}}
                    ]
                });
                
                $("btnBuscarArticulos").addEvent("click",function(evt){
                    evt.stopPropagation();
                    tblArticulos.loadData([
                        {name:'query',value:$("txtBuscarArticulos").get("value").replace("&","$$")},
                        {name:'tipo',value:'2'}
                    ]);
                });                
                $("txtBuscarArticulos").addEvent("keypress",function(evt){
                    evt.stopPropagation();
                    if(evt.code==13){
                        tblArticulos.loadData([
                            {name:'query',value:$("txtBuscarArticulos").get("value").replace("&","$$")},
                            {name:'tipo',value:'2'}
                        ]);
                    }                        
                });
                
                var notice= new JpSlider(               $("s-content"),{
                    url : './Publicaciones?action=NotaPrensaForNotice',
                    type:'notice'});
                var links= new JpSlider($("enlaces"),{url:'./Enlace',type:'links'});
            });
        </script>
        <title>Articulos</title>
    </head>
    <body>
        <div class="wrapper">
            <%@include file="../jspf/cabecera.jspf" %> 
            <div class="cuerpo">
                <div class="navegacion">
                    <h2><a href="./Inicio">Inicio</a> / <a href="./Publicaciones">Publicaciones</a> / Articulos </h2>
                </div>
                <div class="services">
                    <div class="gadget">
                        <div class="panel">
                            <a href="./Publicaciones?action=NotaPrensa">
                                <div class="noticia"></div>
                                <div class="descripcion">
                                    Noticia/Nota Prensa
                                </div>
                            </a>
                        </div>
                        <div class="panel">
                            <a href="./Publicaciones?action=NoticiasMultimedia">
                                <div class="videos"></div>
                                <div class="descripcion">Noticias Multimedia</div>
                            </a>
                        </div>
                        <div class="panel">
                             <a href="./Publicaciones?action=MemoriasAnuales">
                                <div class="memoria"></div>
                                <div class="descripcion">Articulos Anuales</div>
                             </a>

                        </div>
                        <div class="panel">
                            <a href="./Publicaciones?action=Comunicados">
                                <div class="comunicado"></div>
                                <div class="descripcion">Comunicados</div>
                            </a>
                        </div>
                        <div class="panel active">
                            
                                <div class="articulo"></div>
                                <div class="descripcion">Art&iacute;culos</div>
                            
                        </div>   
                        <div class="panel">
                            <a href="./Publicaciones?action=OtrasPublicaciones">
                                <div class="otros-publicacion"></div>
                                <div class="descripcion">Otras Publicaciones</div>
                            </a>
                        </div>  
                    </div>
                </div>
                <div class="cdesk">
                    <div class="sliderPanel">
                        <h2>Articulos</h2>
                        <div id="sp1">
                            <div class="search">

                                <div class="content-i">
                                    <label>Articulos:</label><input  id="txtBuscarArticulos" /><button id="btnBuscarArticulos">Buscar</button>             
                                </div>
                            </div>
                            <div id="tbl-articulos" class="grid"></div>  
                        </div>
                    </div>
                </div>
            </div>
            <%@include file="../jspf/pie.jspf" %>
        </div>
    </body>
</html>
