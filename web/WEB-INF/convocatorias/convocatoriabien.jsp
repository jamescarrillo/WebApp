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
                
 
                //convocatorias vigentes
                var tblConvocatoria= new JpGrid($("tbl-convocatoria"),{
                    id: "gridConvocatoria",
                    url: './Convocatoria?action=ListarConvocatoriaBienForWeb',
                    ancho: '100%',
                    select: 0,
                    dataQuery:[
                        {name: 'query', value: $("txtBuscarConvocatoria").get("value").replace("&","$$")},
                        {name: 'flag', value: 'true'}
                    ],
                    onClick : function(a){
                        var $array = a.get("data-store").split("|");
                        $("crono").set("html", "cargando...");
                        ajax= new Request({
                            url:"./Convocatoria?action=listarCalendarioConvocatoriaForWeb&convo_id="+$array[0],
                            onComplete: function(data) {
                                $("crono").set("html",data);
                            }
                        }).send();
                            
                        $("valor_c").set("text",$array[1]);
                        $("costo_c").set("text",$array[2]);
                        $("lugar_c").set("text",$array[3]);
                        $("titulo_c").set("text",$array[18]);
                        $$(".files").set("html","");
                        if($array[4]!="") $("file_1").set("html", "<a href='archivos/"+$array[4]+"' title='Descargar Documento' target='_blank' alt='ver'> <img src='./resources/images/file.png' />   </a>"  );
                        if($array[5]!="") $("file_2").set("html", "<a href='archivos/"+$array[5]+"'  title='Descargar Documento' target='_blank' alt='ver'> <img src='./resources/images/file.png' />   </a>"  );
                        if($array[6]!="") $("file_3").set("html", "<a href='archivos/"+$array[6]+"'  title='Descargar Documento' target='_blank' alt='ver'> <img src='./resources/images/file.png' />   </a>"  );
                        if($array[7]!="") $("file_4").set("html", "<a href='archivos/"+$array[7]+"'  title='Descargar Documento' target='_blank' alt='ver'> <img src='./resources/images/file.png' />   </a>"  );
                        if($array[8]!="") $("file_5").set("html", "<a href='archivos/"+$array[8]+"'  title='Descargar Documento'  title='Descargar Documento' target='_blank' alt='ver'> <img src='./resources/images/file.png' />   </a>"  );
                        if($array[9]!="") $("file_6").set("html", "<a href='archivos/"+$array[9]+"' title='Descargar Documento' target='_blank' alt='ver'> <img src='./resources/images/file.png' />   </a>"  );
                        if($array[10]!="") $("file_7").set("html", "<a href='archivos/"+$array[10]+"' title='Descargar Documento' target='_blank' alt='ver'> <img src='./resources/images/file.png' />   </a>"  );
                        if($array[11]!="") $("file_8").set("html", "<a href='archivos/"+$array[11]+"' title='Descargar Documento' target='_blank' alt='ver'> <img src='./resources/images/file.png' />   </a>"  );
                        if($array[12]!="") $("file_9").set("html", "<a href='archivos/"+$array[12]+"' title='Descargar Documento' target='_blank' alt='ver'> <img src='./resources/images/file.png' />   </a>"  );
                        if($array[13]!="") $("file_10").set("html", "<a href='archivos/"+$array[13]+"' title='Descargar Documento' target='_blank' alt='ver'> <img src='./resources/images/file.png' />   </a>"  );
                        if($array[14]!="") $("file_11").set("html", "<a href='archivos/"+$array[14]+"' title='Descargar Documento' target='_blank' alt='ver'> <img src='./resources/images/file.png' />   </a>"  );
                        if($array[15]!="") $("file_12").set("html", "<a href='archivos/"+$array[15]+"' title='Descargar Documento' target='_blank' alt='ver'> <img src='./resources/images/file.png' />   </a>"  );
                        if($array[16]!="") $("file_13").set("html", "<a href='archivos/"+$array[16]+"' title='Descargar Documento' target='_blank' alt='ver'> <img src='./resources/images/file.png' />   </a>"  );
                        if($array[17]!="") $("file_14").set("html", "<a href='archivos/"+$array[17]+"' title='Descargar Documento' target='_blank' alt='ver'> <img src='./resources/images/file.png' />   </a>"  );
                    },
                    model:[
                        {name:"fecha", field:'Fecha', type:'string', width:"10%"},
                        {name:"referencia", style: {"text-align": "justify"},field:'S&iacute;ntesis',width:"65%",type:'string'},
                        {name:"tipo",field:'Tipo',width:"9%",type:'string', items:[{id : "1", valor: "Bien"}, {id:"2", valor: "Servicio"}, {id:"3", valor:"Obra"}, {id:"4", valor:"Concesión"}] },
                        {name:"proceso",field:'Proceso',width:"10%",type:'string', items:[{id : 1, valor: "Vigente"}, {id: 2, valor:"Anulado"}, {id: 3, valor:"Finalizado"}, {id: 4, valor:"Desierto"}]},
                        {name:"convoId", hidden:true, type:'integer'},
                        {name:"valReferencial", hidden:true, type:'string'},
                        {name:"costParticipacion", hidden:true},
                        {name:"lugRegParticipante", hidden:true},
                        {name:"basesFile", hidden:true},
                        {name:"resEjectFile", hidden:true},
                        {name:"absConObserFile", hidden:true},
                        {name:"absConsultFile", hidden:true},
                        {name:"absObservaFile", hidden:true},
                        {name:"ProEntiFile", hidden:true},
                        {name:"ProOsceFile", hidden:true},
                        {name:"basInteFile", hidden:true},
                        {name:"actEvalTecFile", hidden:true},
                        {name:"cuaCompaFile", hidden:true},
                        {name:"actaBuenaProFile", hidden:true},
                        {name:"notiSusFile", hidden:true},
                        {name:"resRecEntiFile", hidden:true},
                        {name:"resRecTribFile", hidden:true},
                        {name:"titulo", hidden:true}
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
                border: 1px solid #fff;
                text-align: center;
                background-color: #d9edf7;
            }
            
            .tabla1 tbody th {
                text-align: center;
                background-color: #d9edf7;
            }
            
            .tabla tbody tr  th { 
                text-align: center;
                background-color: #FCC49C ;
            }
            
            .tabla tbody tr td, th {
                border: 1px solid #d9edf7;
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

            .files{border: 1px solid #d9edf7; margin-left: 5px}

        </style>
        <title>Convocatorias Bienes, Servicios, Obras y Concesiones</title>
    </head>
    <body>
        <%@include file="../jspf/cabecera.jspf" %>
        <div class="wrapper2" style="">
            
            <div class="cuerpo">
                <div class="navegacion">
                    <h2><a href="./Inicio">Inicio</a> /  <a href="./Convocatorias">Selecci&oacute;n de Personal</a> / Bienes, Servicios, Obras y Concesiones</h2>
                </div>
                <div class="services text-center">
                    <div class="gadget">
                        <div class="panel efecto active">
                            <a href="#">
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
                        <div class="panel efecto ">
                            <a href="./Convocatorias?action=Exonerado">
                                <div class="icon-exonerado"></div>
                                <div class="descripcion" style="font-size: 11px">Procesos Exonerados</div>
                            </a>
                        </div>  
                    </div>
                </div>

                <div class="cdesk">
                    <h3 style="text-align: center; text-shadow: 1px 1px 0px rgba(0, 0, 0, 0.2), 1px 1px 0px rgba(0, 0, 0, 0.2), 1px 1px 0px rgba(0, 0, 0, 0.2)">Organo Encargado de las contrataciones: Oficina de Administraci&oacute;n (Abastecimiento y Servicios Auxiliares) </h3>
                    
                    


                    <div class="sliderPanel">
                        <h2 id="st1">Convocatorias: Selección de Bienes, Servicios, Obras y Concesiones </h2>
                        <div id="sp1" >
                            <div class="search">
                                <div class="mensaje-nota"><strong>Nota:</strong> Para ver más datos sobre la convocatoria, haga click en cada convocatoria de la tabla izquierda</div>
                                <div class="content-i" >
                                    <label style="margin-right:13px; margin-left:5px; font-weight: bold; color: #6A6C71;">Buscar Convocatoria:</label><input type="text" id="txtBuscarConvocatoria" style="margin-right:3px" /><button id="btnBuscarConvocatoria">Buscar</button>
                                </div>
                            </div>
                            <div id="content-convo" style="width: 50%; float: left;">
                                <div id="tbl-convocatoria" class="grid"></div>
                            </div>
                            <div id ="detalle-convo_1" style=" width: 40%; float: right;  " >
                                <h2>Datos Principales</h2>
                                <table class="tabla" width="100%" style="background-color: #fff; font-family: Arial,Verdana,Helvetica,sans-serif;" >
                                    <tr>
                                        <td width="40%" class="bold">T&iacute;tulo: </td>
                                        <td width="60%" id="titulo_c"></td>
                                    </tr>
                                    <tr>
                                        <td width="40%" class="bold">Valor Referencial: </td>
                                        <td  width="60%" id="valor_c"></td>
                                    </tr>
                                    <tr>
                                        <td width="40%" class="bold">Costo de participaci&oacute;n: </td>
                                        <td  width="60%" id="costo_c"></td>
                                    </tr>
                                    <tr>
                                        <td width="40%" class="bold">Lugar de Registro: </td>
                                        <td  width="60%" id="lugar_c"></td>
                                    </tr>
                                </table>
                                <h2>Cronograma del proceso</h2>
                                <table class="tabla" style="background-color: #fff" >
                                    <thead>
                                    <th class="bold" style="width:70%; font-weight: bold; color: #6A6C71">Actividad</th><th class="bold" style="width:20%; font-weight: bold; color: #6A6C71">Fecha Inicio</th><th class="bold" style="width:20%; font-weight: bold; color: #6A6C71">Fecha Final</th>
                                    </thead>
                                    <tbody id="crono" style="font-family: Arial,Verdana,Helvetica,sans-serif;">
                                    </tbody>
                                </table >
                            </div>
                            <table class="tabla1" border="1" cellpadding="3" cellspacing="0" width="100%" style="border-collapse: collapse; border: 1px solid #000; background-color: #fff" >
                                <tbody>
                                    <tr style="height:100px; font-size:11px;">
                                        <th style="font-weight: bold;color: #6A6C71">Bases
                                        </th><th style="font-weight: bold;color: #6A6C71">Resumen Ejecutivo
                                        </th><th style="font-weight: bold;color: #6A6C71">Absolución de Consultas y Observaciones
                                        </th><th style="font-weight: bold;color: #6A6C71">Absolución Consultas
                                        </th><th style="font-weight: bold;color: #6A6C71">Absolución Observaciones
                                        </th><th style="font-weight: bold;color: #6A6C71">Pronuncia. Entidad
                                        </th><th style="font-weight: bold;color: #6A6C71">Pronuncia. OSCE
                                        </th><th style="font-weight: bold;color: #6A6C71">Bases Integradas
                                        </th><th style="font-weight: bold;color: #6A6C71">Acta de Evaluación Técnica</th>
                                        <th style="font-weight: bold;color: #6A6C71">Cuadro Comparativo y/o Actas
                                        </th><th style="font-weight: bold;color: #6A6C71">Acta Buena Pro
                                        </th><th style="font-weight: bold;color: #6A6C71">Notificación Suscripción de Acuerdo
                                        </th><th style="font-weight: bold;color: #6A6C71">Resolución de Recurso de Apelación de la Entidad
                                        </th><th style="font-weight: bold;color: #6A6C71">Resolución de Recurso de Apelación del Tribunal
                                        </th>
                                    </tr>
                                    <tr>
                                        <td valign="top" class="files" id="file_1" align="center">    

                                        </td>
                                        <td valign="top" class="files" id="file_2"   align="center">

                                        </td>
                                        <td valign="top" class="files" id="file_3"  align="center">

                                        </td>
                                        <td valign="top" class="files"  id="file_4"  align="center">

                                        </td>
                                        <td valign="top" class="files" id="file_5"  align="center">

                                        </td>
                                        <td valign="top" class="files" id="file_6"  align="center">

                                        </td>
                                        <td valign="top" class="files" id="file_7"  align="center">

                                        </td>
                                        <td valign="top" class="files" id="file_8"  align="center">

                                        </td>
                                        <td valign="top" class="files" id="file_9"  align="center">

                                        </td>
                                        <td valign="top" class="files" id="file_10"  align="center">

                                        </td>
                                        <td valign="top" class="files" id="file_11"  align="center">

                                        </td>
                                        <td valign="top" class="files" id="file_12"  align="center">

                                        </td>
                                        <td valign="top" class="files" id="file_13"  align="center">

                                        </td>
                                        <td valign="top" class="files" id="file_14"  align="center">

                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
        <%@include file="../jspf/pie.jspf" %>
    </body>
</html>
