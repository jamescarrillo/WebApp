/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var JpWindow= new Class({
    Implements:[Options,Events],
    options: {          
        baseClass: "ui-window",
        fadeDelay: 400,
        fadeDuration: 400,
        width:"70%",
        height:"auto",
        zIndex: 9001
    },
    initialize: function(elemento,options) {
        this.elemento=elemento;
        this.setOptions(options);
        this.isOpen=false;
        this.draw();
    },
    draw:function(){
        //creamos la mascara para simular una pérdida de foco
        this.modal= new Element('div',{
            "class":this.options.baseClass+'-modal' ,
            styles:{
                "z-index":this.options.zIndex-1
            }
        });    
        this.modal.inject(document.body);        
    },
    close:function(){       			
        this.fireEvent("close");      
        this.elemento.setStyle("display","none");        
        document.body.removeEvent("scroll",this._position.bind(this));
        this.modal.parentNode.removeChild(this.modal);
        this.isOpen=false; 
        document.body.setStyle("overflow","auto");
        var scrollingObj = new Fx.Scroll($(document.body), {
            link:'chain',
            duration:2
        });
        scrollingObj.start(0,this.scrollSize.y);
        return this;
    },
    open: function() {   
        this.fireEvent("open");       
        this.modal.setStyles({
            "display":"block",
            top: window.getScroll().y,         
            "z-index":this.options.zIndex-1
        });
        this.elemento.setStyles({
            "display":"block",
            "z-index":this.options.zIndex*2,
            "width":this.options.width,
            "height":this.options.height,
            "position":"absolute"
        });
        this.isOpen=true;
        document.body.setStyle("overflow","hidden");
        document.body.addEvent("scroll",this._position.bind(this));        
        this._position();        
        return this;
    },
    _position: function() {        
        var windowSize = document.body.getSize(), 
        scrollSize = document.body.getScroll(), 
        boxSize = this.elemento.getSize();
        this.elemento.setStyles({
            left: scrollSize.x + ((windowSize.x - boxSize.x) / 2),
            top: scrollSize.y + ((windowSize.y - boxSize.y) / 2)
        }); 
        if (this.isOpen){
            this.modal.setStyles({           
                top: scrollSize.y
            });
        }    
        this.scrollSize=scrollSize;
        return this;
    }    
});

