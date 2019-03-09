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
        <script type="text/javascript" src="resources/js/JpSlider.js"></script>
        <script type="text/javascript">
            window.addEvent("domready",function(){   
                var notice= new JpSlider($("s-content"),{
                    url : './Publicaciones?action=NotaPrensaForNotice',
                    type:'notice'});
                var links= new JpSlider($("enlaces"),{url:'./Enlace',type:'links'});
            });
        </script>
        <title>Nuestra Labor</title>
    </head>
    <body>
        <div class="wrapper">
            <%@include file="../jspf/cabecera.jspf" %>           
            <%@include file="../jspf/pie.jspf" %>
        </div>
    </body>
</html>
