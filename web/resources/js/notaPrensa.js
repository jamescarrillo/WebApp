/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
window.addEvent("domready",function(){ 
    //esto es para la cabecera
    /*var notice= new JpSlider($("s-content"),{
        url : './Publicaciones?action=NotaPrensaForNotice',
        type:'notice'
    });
    //find e la cabecera
                
    //esto es para el pie
    var links= new JpSlider($("enlaces"),{
        url:'./Enlace',
        type:'links'
    });    */            
    //fin del pie de pagina
                
    var busqueda=false;//esto es para poder ir navegando por los años de las noticias
    //Obtenemos los años
    var ajaxAnhos= new Request.JSON({
        url:'./Publicaciones?action=ListarAnhosNotaPrensa',
        onRequest: function(){       
            var divMensaje= new Element("div",{
                "id":"mensaje"
            });
            divMensaje.inject($("notice-context"));
            $("mensaje").set("html","Cargando...");
        },
        onSuccess:function(response){
            if (response.anhos.length>0){
                //si hay años creamos la lista
                var ulAnhos= new Element('ul');
                response.anhos.each(function(node,index){                                
                    var anhosLink= new Element('a',{
                        "html":node
                    });
                    anhosLink.addEvent("click",function(){
                        busqueda=false;
                        this.addClass("active");
                        this.getParent("li").getSiblings().each(function(node,index){
                            node.getChildren("a").removeClass("active");
                        });                                    
                        $("txtCurrent").set("value","0");
                        $("txtStart").set("value","0");
                        cargarNotaPrensa(this.get("html"));
                        return false;
                    });
                    var liAnhos= new Element('li');
                    anhosLink.inject(liAnhos);
                    liAnhos.inject(ulAnhos);
                });
                ulAnhos .inject($("anhos-history"));
                var primero=$("anhos-history").getFirst("ul li");
                if(primero!=null){
                    $("btnSeguir").hidden=false;                               
                    $$(primero)[0].getChildren("a")[0].addClass("active");
                    cargarNotaPrensa($$(primero)[0].getChildren("a")[0].get("html"));
                }else{
                    $("btnSeguir").hidden=true;
                }
            }
        }
    });
    ajaxAnhos.send();                
    function cargarNotaPrensa(anho){                    
        var ajax= new Request.JSON({
            url:'./Publicaciones?action=ListarNotaPrensaForWeb',
            data:Object.toQueryString({
                "start":$("txtStart").get("value"),
                "limit":$("txtLimit").get("value"),
                "current":$("txtCurrent").get("value"),
                "anho":String.from(anho)
            }),
            onSuccess:function(response){
                if(response.total>0){      
                    if(!busqueda){
                        //eliminamos todas las noticias
                        $("notice-context").getChildren("div").each(function(node, index) {
                            $$(node)[0].getParent().removeChild(node);
                        });
                        $("txtCurrent").set("value","0");
                        $("txtStart").set("value","0");
                    }
                    response.items.each(function(node,index){ 
                        //aqui inicia los links para las noticias
                        var enlaceNoticia= new Element('a',{ 
                            "id":"ui-window-enlace-"+node.id,
                            "href":"./Publicaciones?action=PaginaNotaPrensaPrint&id="+node.id,
                            "target": "_blank",
                            "html":node.titulo,
                            styles:{
                                "cursor":"pointer"
                            }
                        });
                        var titulo= new Element('h1'); 
                        enlaceNoticia.inject(titulo);
                        var divMa= new Element('div');
                        divMa.setStyles({
                            "border":"0.1em #ccc solid",                                       
                            "display":"block",
                            "width":"280px",
                            "height":"160px",
                            "position":"relative"
                        });
                        var img=new Element('img',{
                            "src":node.foto
                        });
                        img.setStyles({
                            "width":"280px",
                            "height":"160px"
                        });
                        divMa.adopt(img,titulo);
                        divMa.inject($("notice-context"));
                        
                    });                                                              
                    if((parseInt($("txtCurrent").get("value")))<Math.ceil(parseInt(response.total)/parseInt($("txtLimit").get("value")))){
                        $("btnSeguir").setStyle("display","block");
                    }
                    else{
                        $("btnSeguir").setStyle("display","none");
                    } 
                    if((parseInt($("txtCurrent").get("value"))+1)==Math.ceil(parseInt(response.total)/parseInt($("txtLimit").get("value")))){
                        $("btnSeguir").setStyle("display","none");
                    }
                }
                else{
                    $("notice-context").set("html","No Hay Registros");
                }
            }
        });
        ajax.send();                             
    }
    $("btnSeguir").addEvent("click",function(){
        busqueda=true;
        $("txtCurrent").set("value",(parseInt($("txtCurrent").get("value"))+1));
        $("txtStart").set("value",((parseInt($("txtCurrent").get("value")))*parseInt($("txtLimit").get("value"))));
        cargarNotaPrensa($$("#anhos-history a.active")[0].get("html"));
        return false;
    });
});

