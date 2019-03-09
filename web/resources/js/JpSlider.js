/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var JpSlider=new Class({
    Implements:Options,
    options:{
        step : 1,
        url : '',
        type:'notice' ,//links
        auto : true,
        pause : 5000,
        clickstop : true,
        current : 'current',
        hide : false
    },
    initialize:function(elemento,opciones){
        this.elemento=elemento;
        this.setOptions(opciones);
        if (this.options.type=="notice"){
            this.count=0;
            this.cargarDataNotice();
            this.page=0;
            this.timer=0;
        }
        else if(this.options.type=="links"){
            this.cargarDataLinks();
        }
    },
    
    cargarDataNotice:function(){
        var me =this;
        var ajaxN=new Request.JSON({
            url : this.options.url,
            onSuccess : function(response) {
                Array.each(response.items, function(node, index) {
                    me.templateNotice(node,index);
                    me.count=me.elemento.getChildren().length;
                });                                
                me.cargarControles();
            }
        }); 
        ajaxN.send();
    },
    cargarControles:function(){
        if (this.count>this.options.step){                            
            var ol =new Element('ol',{
                "id":'pagination'
            });
            var parent=this.elemento.getParent();
            var me =this;
            ol.inject(parent,'after');
            for(i=this.count-1; i>=0; i--){
                var navegation=new Element('li',{
                    "data-index":i,
                    "html":i
                });
                navegation.inject(ol);
                $(navegation).addEvent('click',function(){
                    me.page=this.get('html');
                    me.show();
                    return false;
                });
                if(i==0)
                    $$('ol li[data-index="'+i+'"]').addClass('current'); 
            }
            
            $("cab1").addEvent("click",function(){
                $("hidenoti").setStyle('display', 'block');
                $("s-content").setStyle('display', 'block');
                $("pagination").setStyle('display', 'block');
                $$(".linknoti[data=1]").set("html","");
            });
            if(this.options.hide==true){
                $("hidenoti").setStyle('display', 'block');
                $("pagination").setStyle('display', 'block');
            }
            else {
                $("hidenoti").setStyle('display', 'none');
                $("pagination").setStyle('display', 'none');
            }
            $("hidenoti").addEvent("click",function(){
                $("hidenoti").setStyle('display', 'none');
                $("s-content").setStyle('display', 'none');
                $("pagination").setStyle('display', 'none');
                $$(".linknoti[data=1]").set("html","Ver Noticias");
            });
            this.show();
        }                        
    },
    show:function(){  
        clearTimeout(this.timer);
        var formatoDate=function(fecha){
            return "<em style='color:#ccc;'>("+fecha.toString().split("-")[2]+"/"+fecha.toString().split("-")[1]+"/"+fecha.toString().split("-")[0]+")</em>"
        }
        var tmv=310*this.page;                        
        var fx=new Fx.Tween($(this.elemento),{
            duration:'long'
        });
        fx.start('top',-tmv);
        var titulo=$$(".tituloNoti[data-index='"+this.page+"']").get("text")+" "+formatoDate($$(".tituloNoti[data-index='"+this.page+"']").get("rel"))+"";
        $("tituloNoticia").set("html","Titulares: "+titulo);
        $$("ol#pagination li").removeClass('current');
        $$('ol li[data-index="'+this.page+'"]').addClass('current');
        this.page = this.page < this.count - 1 ? (Number.from(this.page)+1) : 0; 
        this.timer=this.show.delay(8000,this);
    },         
    templateNotice:function(node,index){       
        var divParent=new Element('div');
        var divIzq=new Element('div',{
            "class":"c-izq"
        });
        var pIzq=new Element('p');
        var aIzq=new Element('a',{
            "href":"#"
        });
        
        var imgIzq=new Element('img',{
            'src':node.foto
        });
        
        imgIzq.setStyles({
            "width":'470px',
            "height":'275px',
            "border":"3px #666666 solid",
            "position": "relative"
        });
        
        var divDer=new Element('div',{
            "class":"c-dere"
        });
        
        var h3Der=new Element('h3',{
            "html":node.titulo,
            "class": "tituloNoti",
            "rel": node.fecha,
            "data-index": index
        });
        
        h3Der.setStyles({
            "font": "1.6em/100% arial",
            "margin-top": "10px"
        });
        
        var pDer=new Element('p',{
            "class":"info",
            "html":node.contenido.trim().substr(0, 420)+" ..."
        });
        
        var divMas=new Element('div',{
            "class":"mas"
        });
        
        var aMas=new Element('a',{
            "id":"ui-jwindow-enlace-"+node.id,
            "href":"./Publicaciones?action=PaginaNotaPrensaPrint&id="+node.id,
            "html":"Leer más",
            "target": "_blank",
            "class" : "green button",
            "style" : "color: #fff",
            styles:{
                "cursor":"pointer",
                "text-decoration":"none"
            }
        });
        
        divMas.adopt(aMas);
        divDer.adopt(h3Der,pDer,divMas);
        aIzq.adopt(imgIzq);
        pIzq.adopt(aIzq);
        divIzq.adopt(pIzq);
        divParent.adopt(divIzq,divDer);
        divParent.inject(this.elemento);
    
    },
    cargarDataLinks:function(){       
        var me=this;

        var ajaxL=new Request.JSON({
            url : me.options.url,
            onSuccess : function(responseJSON, responseText) { 
                responseJSON.items.each(function(node, index) {                   
                    me.templateLinks(node,index);
                });                                
            }
        });        
        ajaxL.send();
    },
    templateLinks:function(node,index){       
        var divParent=new Element('div',{
            "class":"links"
        });
        var aLinks=new Element('a');
        aLinks.set("href",node.url);
        aLinks.set("target","_blank");
        var imgLinks=new Element('img',{
            "src":"resources/images/logo/"+node.logo
        });
        imgLinks.inject(aLinks);
        divParent.adopt(aLinks);
        divParent.inject(this.elemento);
    }
    
});

