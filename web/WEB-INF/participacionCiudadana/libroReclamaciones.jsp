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
        <script type="text/javascript" src="resources/js/JpCalendar.js"></script>
        <script type="text/javascript" src="resources/js/JpAgenda.js"></script>
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
                $('sp2').reclamo("reclamos");
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
                
               /* $("cab1").addEvent("click",function(){
                    $("hidenoti").setStyle('display', 'block');
                    $("s-content").setStyle('display', 'block');
                });
                $("hidenoti").setStyle('display', 'none').addEvent("click",function(){
                    $("hidenoti").setStyle('display', 'none');
                    $("s-content").setStyle('display', 'none');
                });
                new JpSlider($("s-content"), {
                    url : './Publicaciones?action=NotaPrensaForNotice',
                    type : 'notice'
                });
                new JpSlider($("enlaces"), {
                    url : './Enlace',
                    type : 'links'
                });*/
                
                var validatorInteger = function(element){
                    return (/^(-?[1-9]\d*|0)$/).test(element.get('value'));
                }
                
                var validatorEmail = function(element){
                    return (/^(?:[a-z0-9!#$%&'*+\/=?^_`{|}~-]\.?){0,63}[a-z0-9!#$%&'*+\/=?^_`{|}~-]@(?:(?:[a-z0-9](?:[a-z0-9-]{0,61}[a-z0-9])?\.)*[a-z0-9](?:[a-z0-9-]{0,61}[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\])$/i).test(element.get('value'));
                }
                var validateAlpha = function(element){
                    return (/^[a-z A-Z]+$/).test(element.get('value'));
                }
                var tamanio = function(element,max){
                    if (element.get("value").length!=max){
                        element.getNext().setStyle('color', 'red');
                        element.setStyle('border-color', 'red');
                        return true
                    }
                    return false
                }
                $("customForm").addEvent("submit", function(e){
                    e.stop();
                    $('st1').setFocus();
                    var error = false;
                    $$(".field").setStyle('color', '#000');
                    $$(".field").setStyle('border-color', '#000');
                    
                    if ($("nombre").get("value")==""){
                        error = true;
                        $("nombre").getNext().setStyle('color', 'red');
                        $("nombre").setStyle('border-color', 'red');
                    } else 
                        if (!(validateAlpha($("nombre")))) {
                            error = true;
                            $("nombre").getNext().setStyle('color', 'red');
                            $("nombre").setStyle('border-color', 'red');
                        }
            
                    if($("documento").get("value")==""){
                        error = true;
                        $("documento").getNext().setStyle('color', 'red');
                        $("documento").setStyle('border-color', 'red');
                    } 
            
                    if($("reclamo").get("value")==""){
                        error = true;
                        $("reclamo").getNext().setStyle('color', 'red');
                        $("reclamo").setStyle('border-color', 'red');
                    }
                    
                    if($("correo").get("value")==""){
                        error = true;
                        $("correo").getNext().setStyle('color', 'red');
                        $("correo").setStyle('border-color', 'red');
                    } if (!(validatorEmail($("correo")))) {
                        error = true;
                        $("correo").getNext().setStyle('color', 'red');
                        $("correo").setStyle('border-color', 'red');
                    }
                    
                    if($("telefono").get("value")==""){
                        error = true;
                        $("telefono").getNext().setStyle('color', 'red');
                        $("telefono").setStyle('border-color', 'red');
                        
                    }
                    
                    if ($("usua_captcha").get("value")==""){
                        error = true;
                        $("usua_captcha").getNext().setStyle('color', 'red');
                        $("usua_captcha").setStyle('border-color', 'red');
                    }
                    
                    this.set('send', {onComplete: function(response) {
                            $$(".field").set("value","");
                            $("exitcode").set("html", response);
                            $("controlBoton").set("html",'<a href="./Inicio" id="ala" class="green button">Aceptar</a>');
                            $('ala').setFocus();
                            $("nota").set("html", "Nota: Toda respuesta será remitida a su correo electrónico. Se sugiere revisar frecuentemente").setStyle('font-weight', 'bold');;
                        },onFailure: function(data){
                            $("msn").set("html","<p>Se Produjo un problema Al Enviar el Reclamo, Intentelo Mas Tarde</p>");      
                        }
                    });
                    
                    if($("usua_captcha").get("value")!=""){
                        new Request.JSON({
                            url: "./ParticipacionCiudadana?action=VerifyCaptcha",
                            data: Object.toQueryString({
                                "usua_captcha":$("usua_captcha").get("value")
                            }),
                            onSuccess: function(a) {
                                if(a.msn!=0) {
                                    if (!(error)) {
                                        var size=$("cdesk").getSize();
                                        var $divResult = new Element("div",{
                                            'class' : 'result',
                                            'html'  : '<div style="width:50%; margin:170px auto; "><div id="exitcode"></div>\n\
                                                <div style=" width: 100%; display: block; text-align: center; margin: 20px auto;" id="controlBoton"><img style="margin: 0px auto; float:none;" src="./resources/images/loading.gif" /><br /> Enviando... </div>',
                                            'style':'border:1px solid #898C95; z-index:9999; background-color:#fff; position: absolute; width: 950px; min-height:'+parseInt(size.y-200)+'px; -moz-border-radius: 6px 6px 6px 6px; -webkit-border-radius: 6px 6px 6px 6px; border-radius: 6px 6px 6px 6px; -moz-box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.2); -webkit-box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.2);	box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.2); margin: 0 0 4px 0;	padding: 8px 10px 8px 10px; '
                                        });
                                        $divResult.inject("cdesk","before");
                                        $divResult.tween('opacity', 0.97);
                                        $("botonazo").empty();
                                        $('controlBoton').setFocus();
                                        $("customForm").send();
                                        
                                    }
                                } else {
                                    $("usua_captcha").getNext().setStyle('color', 'red');
                                    $("usua_captcha").setStyle('border-color', 'red');
                                }
                            }
                        }).send();
                    }
                });
            });
        </script>
        <style>
            #tableta tr {
                margin-top: 5px;
            }
            #tableta tr td {
                border: 1px solid black;
                padding: 2px;
                line-height: normal;
            }
        </style>
        <title>Libro de Reclamaciones </title>
    </head>
    <body>
        <%@include file="../jspf/cabecera.jspf"%>
        <div class="wrapper2">
            
            <div class="cuerpo">
                <div class="navegacion">
                    <h2>
                        <a href="./Inicio">Inicio</a> / <a href="./ParticipacionCiudadana">Participacion Ciudadana</a> / Libro de Reclamaciones
                    </h2>
                </div>
                <div class="services text-center">
                    <div class="gadget">
                        <div class="panel efecto">
                            <a href="./Servicios">
                                <div class="mis-servicios "></div>
                                <div class="descripcion" style="font-size:11px">Mis Servicios</div>
                            </a>
                        </div>
                        <div class="panel efecto">
                            <a href="./ParticipacionCiudadana?action=AccesoInformacion">
                                <div class="solicitud "></div>
                                <div class="descripcion" style="font-size:11px">Acceso a la Informaci&oacute;n</div>
                            </a>
                        </div>
                        <div class="panel efecto active">
                            <a href="#">
                                <div class="libro "></div>
                                <div class="descripcion" style="font-size:11px">Libro de Reclamaciones</div>
                            </a>
                        </div>
                        <div class="panel efecto">
                            <a href="./ParticipacionCiudadana?action=Consultas">
                                <div class="consultas "></div>
                                <div class="descripcion" style="font-size:11px">Consultas y Sugerencias</div>
                            </a>
                        </div>

                        <div class="panel efecto">
                            <a href="./ParticipacionCiudadana?action=PortalTransparencia">
                                <div class="portal "></div>
                                <div class="descripcion" style="font-size:11px">Portal de Transparencia</div>
                            </a>
                        </div>
                    </div>
                </div>

                <div class="cdesk" id="cdesk">
                    <div class="sliderPanel">
                        <h2 id="st1">Formulario de Reclamaciones</h2>
                        <div id="sp1" style=" width: 800px;  margin: 5px auto;  text-align: left; border:0.1em solid #C3C5CB;">
                            <div style="display:block; width: 100%; text-align: center; margin-top: 7px; margin-bottom: 20px;">
                                Estimado usuario, el Libro de Reclamaciones Virtual es sólo para lo estipulado en el <b style="font-weight: bold">D.S. N° 042-2011-PCM</b>; en caso de realizar una sugerencia o comentario hacer uso del siguiente formulario: <a href="./ParticipacionCiudadana?action=Consultas" >AQUI </a>
                            </div>
                            <h1 style="font-weight: 700; font-size: 18px; margin-left: 5px; line-height: 1.2em; border-bottom: 1px dotted rgb(247, 249, 251); color:black; margin-bottom: 1em;">Formulario de Reclamaciones </h1>
                            <form id="customForm"  method="post" action="./ParticipacionCiudadana?action=insertReclamos" >
                                <div>
                                    <label for="name" style="margin-left: 5px;">Apellidos y Nombres:</label>
                                    <input id="nombre" class="field" name="nombre" type="text" value="" style="margin-left: 5px;" />
                                    <span id="nameInfo" class="field">¿Cuál es su nombre?</span>
                                </div>
                                <div>
                                    <label for="doc" style="margin-left: 5px;">
                                        <select name="nrodocumento">
                                            <option value="D.N.I."> D.N.I. </option>
                                            <option value="R.U.C."> R.U.C. </option>
                                            <option value="C.E."> C.E. </option>
                                        </select>
                                    </label>
                                    <input id="documento" class="field"  name="documento" type="text" value="" style="margin-left: 5px;"/>
                                    <span id="docInfo" class="field">¿Cuál es su Documento de Identidad?</span>
                                </div>
                                <div>
                                    <label for="email" style="margin-left: 5px;">Email:</label>
                                    <input id="correo" class="field"  name="correo" type="text" style="margin-left: 5px;">
                                    <span id="correoInfo" class="field">¿Cuál es su Correo Electrónico?</span>
                                </div>
                                <div>
                                    <label for="telefono" style="margin-left: 5px;">Teléfono</label>
                                    <input id="telefono" class="field"  name="telefono" type="text" style="margin-left: 5px;"/>
                                    <span id="teleInfo" class="field">¿Cuál es su Número telefónico?</span>
                                </div>
                                <div>
                                    <label for="domicilio" style="margin-left: 5px;">Domicilio</label>
                                    <input id="domicilio" class="field"  name="domicilio" type="text" style="margin-left: 5px;">
                                    <span id="domiInfo" class="field">¿Cuál es su Dirección Específica de Domicilio?</span>
                                </div>
                                <div>
                                    <label for="reclamo" style="margin-left: 5px;">Formule su Reclamo:</label>
                                    <textarea id="reclamo" class="field" name="reclamo" style="margin-left: 5px;" ></textarea>
                                    <span id="reclamoInfo" class="field"> ¿Cuál es el reclamo que desea hacer?</span>			
                                </div>
                                <div>
                                    <label for="captcha" style="margin-left: 5px;">C&oacute;digo captcha:</label>
                                    <img id='captcha' src="./captcha.jpg" name="captcha" style="display: block !important; float: none" />
                                </div>
                                <div>
                                    <label for="usua_captcha" style="margin-left: 5px;">Ingrese C&oacute;digo captcha:</label>
                                    <input type="text" id="usua_captcha" name="usua_captcha" class="field" style="margin-left: 5px;"/>    
                                    <span id="codcaptchaInfo" class="field"> Demuestre que es un humano, ¿Cuál es el número captcha?</span>
                                </div>
                                <div id="botonazo">
                                    <button type="submit" id="submit" class="green button" style="margin-top:5px; margin-left: 5px;">
                                        Enviar
                                    </button>
                                </div>
                            </form>
                            <div id="result"></div>
                        </div>
                    </div>
                    <div class="sliderPanel">
                        <h2 id="st2">Publicación de Reclamos</h2>
                        <div id="sp2">
                            <div id="reclamos">
                            </div>
                            <div id="botones">
                                <button id="btn1" class="green button" type="button">Anterior</button><button id="btn2" class="green button"  type="button">Siguiente</button>
                            </div>
                            <input id="current" type=hidden value=0 /> <input id="start" type=hidden value=0 /> <input id="limit" type=hidden value='1' />
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
        <%@include file="../jspf/pie.jspf"%>
    </body>
</html>
