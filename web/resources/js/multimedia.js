/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
window.addEvent("domready",function(){
   /* var notice= new JpSlider($("s-content"),{
        url : './Publicaciones?action=NotaPrensaForNotice',
        type:'notice'
    });*/
    //find e la cabecera
                
    //esto es para el pie
   /* var links= new JpSlider($("enlaces"),{
        url:'./Enlace',
        type:'links'
    }); */               
    //fin del pie de pagina
    var busqueda=true;
    //cargamos las noticias multimedia
    function cargarMultimedia(){
        var ajaxMultimedia= new Request.JSON({
            url:'./Publicaciones?action=ListarMultimediaForWeb',
            data:Object.toQueryString({
                "start":$("txtStart").get("value"),
                "limit":$("txtLimit").get("value"),
                "current":$("txtCurrent").get("value")
            }),                       
            onSuccess:function(response){
                if(response.total>0){
                    if(busqueda){
                        //eliminamos todas las noticias
                        $("notice-context-m").getChildren("div").each(function(node, index) {
                            $$(node)[0].getParent().removeChild(node);
                        });
                        $("txtCurrent").set("value","0");
                        $("txtStart").set("value","0");
                    }
                    
                    response.items.each(function(node,index){
                        var divMa= new Element('div');
                        divMa.setStyles({
                            "border":"0.1em #ccc solid",                                       
                            "display":"block",
                            "width":"310px",
                            "height":"190px",
                            "position":"relative"
                        });
                        var iFrame= new Element('iframe',{
                            "width":"310px",
                            "height":"190px",             
                            "frameborder":"0",                        
                            "allowfullscreen":"",
                            "src":node.fuente+"&showinfo=0&wmode=transparent"
                        });
                        var titulo= new Element('h1',{
                            "html":node.titulo
                        });
                        titulo.setStyles({
                            "z-index":"9002",
                            "position":"absolute",
                            "width":"300px",
                            "height":"10%",
                            "top":"0"
                        });
                        divMa.adopt(iFrame,titulo);
                        divMa.inject($("notice-context-m"));
                        if((parseInt($("txtCurrent").get("value")))<Math.ceil(parseInt(response.total)/parseInt($("txtLimit").get("value")))){
                            $("btnSeguir").setStyle("display","block");
                        }
                        else{
                            $("btnSeguir").setStyle("display","none");
                        } 
                        if((parseInt($("txtCurrent").get("value"))+1)==Math.ceil(parseInt(response.total)/parseInt($("txtLimit").get("value")))){
                            $("btnSeguir").setStyle("display","none");
                        }
                    });
                }else{
                    $("notice-context-m").set("html","No Hay Registros");
                }
            }
        });
        ajaxMultimedia.send();
    }
    cargarMultimedia();
    $("btnSeguir").addEvent("click",function(){ 
        busqueda=false;
        $("txtCurrent").set("value",(parseInt($("txtCurrent").get("value"))+1));
        $("txtStart").set("value",((parseInt($("txtCurrent").get("value")))*parseInt($("txtLimit").get("value"))));
        cargarMultimedia();
        return false;
    });
});

