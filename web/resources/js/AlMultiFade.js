

Elements.implement({
    multiFade: function(opacity){
        var elems = this;
        if(!opacity) opacity = 0.3;

        this.addEvents({
            'mouseenter':	function(){
                elems.filter(function(item){
                    if(item != this) return item
                }.bind(this)).tween('opacity', opacity)
            },
            'mouseleave':	function(){
                elems.tween('opacity', 1);
            }
        });
    },
    multiSelect: function(opacity, array){
        
        var elems = this;
        if(!opacity) opacity = 0.3;
        content=$("detailSistema");
        content.set("html",array[10]);
        color = this.getStyle('background-color');
        this.addEvents({
            'mouseenter':	function(){
                elems.filter(function(item){
                    if(item != this) {
                        this.setStyles({
                            'background-color': '#ecf8ec',
                            'border': '1px solid #b2e3b2'
                        });
                        content.empty();
                        content.set("html",array[this.get("data-id")]);
                        return item
                    }
                }.bind(this)).tween('opacity', opacity);
            },
            'mouseleave':	function(){
                this.setStyles({
                    "border": "1px solid #eee",
                    "background-color": "#F9F9F9"
                });
                elems.tween('opacity', 1);
            }
        });
    }
});

Element.implement({
    setFocus: function(index) {
        this.setAttribute('tabIndex',index || 0);
        this.focus();
    }
});

Element.implement({
    buscarDato: function(e){
        DOMEvent.defineKey(13, 'enter');
        var input = this;
        var formatValue  = function(value, max){
            var tam = value.length;
            var valor = "";
            
            if(parseInt(tam)>parseInt(max))
                valor = value.substring(0, max)+"...";
            else valor = value;
            return valor;
        }
        input.addEvent('keydown', function(event){
            if (event.key == 'enter') {
                var size=$(document).getSize();
                $$(".layout").hide();
                var capa = new Element("div", {
                    "class":"layout", 
                    'style':'border:1px solid #898C95; z-index:10000; background-color:#fff; position: absolute; width: 1005px; min-height:'+size.y+'px; -moz-border-radius: 6px 6px 6px 6px; -webkit-border-radius: 6px 6px 6px 6px; border-radius: 6px 6px 6px 6px; -moz-box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.2); -webkit-box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.2);	box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.2); margin: 0 0 4px 0;	padding: 8px 10px 8px 10px; ',
                    'html' : ''
                });
                capa.inject(e,"after");
                capa.tween('opacity', 0.97);
                var close = new Element("div",{
                    'style':'margin-top:5px; width:100%; text-align: right;  ', 
                    'html': '<button class="button green" style="cursor:pointer; " id="closeBusqueda">cerrar (x)</span>'
                });
                close.inject(capa);
                $("closeBusqueda").addEvent("click",function(){
                    $$(".layout").hide();
                });
                
                var result= new Element("div",{
                    'style':'width:100%',
                    'html': 'Cargando...',
                    'id': 'result'
                }).empty();
                
                var carga = new Element("div",{
                    "class": "loadResult",
                    "html": "<img src='./resources/images/logo/loading.gif' />",
                    "style": 'width:100%'
                });
                var boton = new Element("button", {
                    "id":"btnSeguir",
                    "html": "Ver Mas Resultados",
                    "style": "display:none; float: right;",
                    "class": "button green"
                });
                var titulo = new Element("p",{
                    "html": "RESULTADOS DE LA BUSQUEDA",
                    "class": "cabezeraResult"
                });
                result.inject(capa);
                titulo.inject(result, "before");
                boton.inject(result, "after");
                
                var cargarResult = function(){
                    carga.inject(result,"after");
                    $$(".loadResult").show();
                    var ajax=new Request.JSON({
                        url:"./Busqueda?filter="+input.get("value"),
                        data:Object.toQueryString({
                            "start":$("txtStart").get("value"),
                            "limit":$("txtLimit").get("value"),
                            "current":$("txtCurrent").get("value")
                        }),
                        onSuccess:function(result){
                            if (result.total>0) {
                                var div = $("result");
                                $$(".loadResult").hide();
                                var varHTML = "";
                                result.items.each(function(node,index){
                                    var val = formatValue(node.descripcion, 300)
                                    varHTML += "<a href='"+ node.ruta +"'><h2 class='tituloResult' >"+node.titulo+"</h2></a><p class='contentResult'>"+node.ruta+" <br/>"+ val.replace(/<[^>]+>/gi,'') + " <br /><a href='"+ node.ruta +"' >Leer Más</a> </p>";
                                });
                                div.set("html",div.get("html")+"" +varHTML );
                            
                                if((parseInt($("txtCurrent").get("value")))<Math.ceil(parseInt(result.total)/parseInt($("txtLimit").get("value")))){
                                    $("btnSeguir").setStyle("display","block");
                                }
                            
                                else{
                                    $("btnSeguir").setStyle("display","none");
                                }
                            
                                if((parseInt($("txtCurrent").get("value"))+1)==Math.ceil(parseInt(result.total)/parseInt($("txtLimit").get("value")))){
                                    $("btnSeguir").setStyle("display","none");
                                }
                                $('btnSeguir').setFocus();
                            } else {
                                $$(".loadResult").hide();
                                $("result").set("html","NO SE ENCUENTRAN RESULTADOS"  );
                            }
                        }
                    }).send();
                }
                cargarResult();
                $("btnSeguir").addEvent("click",function(){
                    $("txtCurrent").set("value",(parseInt($("txtCurrent").get("value"))+1));
                    $("txtStart").set("value",((parseInt($("txtCurrent").get("value")))*parseInt($("txtLimit").get("value"))));
                    cargarResult();
                    return false;
                });
            }
        });
    }
});

Element.implement({
    reclamo: function(e){
        var carga = new Element("div",{
            "class": "loadResult",
            "html": "<img src='./resources/images/logo/loading.gif' />"
        });
        
        var cargarResult = function(e){
            var $div = $(e);
            
            carga.inject($div);
            $$(".loadResult").show();
            var ajax = new Request.JSON({
                url:"./ParticipacionCiudadana?action=Reclamos",
                data:Object.toQueryString({
                    "start":$("start").get("value"),
                    "limit":$("limit").get("value"),
                    "current":$("current").get("value")
                }),
                onSuccess:function(result){
                    if (result.total>0) {
                        //var div = $("result");
                        $$(".loadResult").hide();
                        var varHTML = "";
                        result.items.each(function(node,index){
                            
                            varHTML += "<table class='formulario' > \n\
                                      <tr><td >Fecha: </td><td>"+node.fecha+"</td>\n\
                                      <td >Hoja de Reclamación N°: </td><td>"+node.numero+"-"+node.anio+"</td>\n\
                                      </tr>\n\
                                      <tr><td>Nombre: </td><td>"+node.usuario+"</td></tr></table>\n\
                                      <label class='subtitu' >Descripcion(Reclamo): </label><div class='data'>"+node.descripcionAtencion+"</div>\n\
                                      <label class='subtitu' >Descripcion(Respuesta):  </label><div class='data'>"+node.detalleAcciones+"</div>";
                        });
                        
                        $div.set("html",varHTML);
                        //div.set("html",div.get("html")+"" +varHTML );
                            
                        if((parseInt($("current").get("value")))<Math.ceil(parseInt(result.total)/parseInt($("limit").get("value")))){
                            $("btn2").setStyle("display","block");
                        }
                        else{
                            $("btn2").setStyle("display","none");
                        }
                            
                        if((parseInt($("current").get("value"))+1)==Math.ceil(parseInt(result.total)/parseInt($("limit").get("value")))){
                            $("btn2").setStyle("display","none");
                        }
                        
                        if ((parseInt($("current").get("value"))<=0))
                            $("btn1").setStyle("display","none");
                        else 
                            $("btn1").setStyle("display","block");
                        
                    } else {
                        $$(".loadResult").hide();
                    }
                }
            }).send();
        }
        cargarResult(e);
        $("btn2").addEvent("click",function(){
            $("current").set("value",(parseInt($("current").get("value"))+1));
            $("start").set("value",((parseInt($("current").get("value")))*parseInt($("limit").get("value"))));
            cargarResult(e);
            return false;
        });
        $("btn1").addEvent("click",function(){
            $("current").set("value",(parseInt($("current").get("value"))-1));
            $("start").set("value",((parseInt($("current").get("value")))*parseInt($("limit").get("value"))));
            cargarResult(e);
            return false;
        });
    }
});

/*
---
description: This is yet another ToolTip class for MooTools 1.3. See README.md for details
license: MIT-style
authors:
 - Korney Czukowski
requires:
 - core/1.3: [Class, Options, Events, Element, Element.Event]
 - more/1.3: [Element.Position, Element.Shortcuts, Locale]
provides: [ToolTip, Request.ToolTip]
...
 */
var ToolTip = new Class({
    Implements: [Events, Options],
    Binds: ['hide'],
    timer: null,
    options: {
        autohide: true,
        offset: 12,
        hideDelay: 1000,
        parseURLs: true,
        position: {
            edge: 'bottom',
            position: 'centerTop',
            offset: {
                x: 0, 
                y: 0
            }
        },
        text: null
    },
    initialize: function(element, options) {
        this.element = element;
        this.setOptions(options);
        // Create ToolTip
        var edges = {
            'bottom': {
                'q': -1, 
                'dim': 'y'
            },
            'top': {
                'q': 1, 
                'dim': 'y'
            },
            'left': {
                'q': 1, 
                'dim': 'x'
            },
            'right': {
                'q': -1, 
                'dim': 'x'
            }
        };
        this.options.position.offset[edges[this.options.position.edge].dim] = this.options.offset * edges[this.options.position.edge].q;
        this.toolTip = new Element('div.tooltip', {
            'html': this.options.text
        })
        .hide()
        .inject(document.body);
        // Create arrow
        this.arrow = ToolTip.arrow(ToolTip.arrowPosition(this.options.position), this.toolTip);
        // Attach event listeners
        [this.element, this.toolTip].each(function(el) {
            el.addEvents({
                'mouseenter': function() {
                    if (this.options.autohide) window.clearTimeout(this.timer);
                }.bind(this),
                'mouseleave': function() {
                    if (this.options.autohide) this.timer = this.hide.delay(this.options.hideDelay, this);
                }.bind(this)
            });
        }, this);
    },
    hide: function() {
        this.arrow.hide();
        this.toolTip.hide();
        if (typeof(btn = this.toolTip.getElement('div.close')) == 'element') {
            btn.destroy();
        }
        this.fireEvent('hide');
        this.element.erase('data-tooltip-displayed');
        return this;
    },
    position: function() {
        this.toolTip.position({
            relativeTo: this.element,
            position: this.options.position.position,
            edge: this.options.position.edge,
            offset: this.options.position.offset
        });
        return this;
    },
    set: function(content) {
        if (typeOf(content) == 'element') {
            this.toolTip.empty().grab(content);
        }
        else {
            if (this.options.parseURLs) {
                content = ToolTip.parseLinks(content);
            }
            this.toolTip.set('html', content);
        }
        if ( ! this.options.autohide) {
            new Element('div.close[title="'+(Locale.get('ToolTip.close') || 'Cerrar')+'"]')
            .inject(this.toolTip, 'top')
            .addEvent('click', this.hide.bind(this));
        }
        this.position();
    },
    show: function() {
        if ( ! this.element.get('data-tooltip-displayed')) {
            this.element.set('data-tooltip-displayed', true);
            this.position();
            this.toolTip.show();
            this.arrow.show();
            this.fireEvent('show');
        }
        return this;
    }
}).extend({
    /**
     * Tooltip arrow factory
     */
    arrow: function(options, tooltipElement) {
        options = Object.merge({
            distance: 12,
            edge: 'bottom',
            offset: {
                x: 0, 
                y: 0
            },
            parent: document.body,
            position: 'centerTop'
        }, options);
        if (typeOf(tooltipElement) == 'element') {
            options.relativeTo = tooltipElement;
        }
        var edges = {
            'bottom': {
                'className': 'css-arrow-up', 
                'borderWidth': '0 {y}px {y}px'
            },
            'top': {
                'className': 'css-arrow-down', 
                'borderWidth': '{y}px {y}px 0'
            },
            'left': {
                'className': 'css-arrow-right', 
                'borderWidth': '{x2}px 0 {x2}px {x}px'
            },
            'right': {
                'className': 'css-arrow-left', 
                'borderWidth': '{x2}px {x}px {x2}px 0'
            }
        };
        var borderWidth = edges[options.edge].borderWidth.substitute({
            'x': (options.distance * .8).round(),
            'y': (options.distance * .8).round(),
            'x2': (options.distance * .8).round()
        });
        var element = new Element('div.tooltip-arrow.'+edges[options.edge].className)
        .setStyle('border-width', borderWidth)
        .hide()
        .inject(options.parent)
        .store('ArrowPosition', options);
        element.show = function() {
            this.setStyle('display', 'block')
            .position(this.retrieve('ArrowPosition'));
        };
        return element;
    },
    /**
     * Returns tooptip arrow position options
     */
    arrowPosition: function(options) {
        var edges = {
            'bottom': {
                'dim': 'y', 
                'edge': 'top'
            },
            'top': {
                'dim': 'y', 
                'edge': 'bottom'
            },
            'left': {
                'dim': 'x', 
                'edge': 'right'
            },
            'right': {
                'dim': 'x', 
                'edge': 'left'
            }
        };
        var arrowOptions = Object.merge(Object.clone(options), {
            distance: options.offset[edges[options.edge].dim].abs(),
            edge: edges[options.edge].edge,
            offset: {
                x: 0, 
                y: 0
            }
        });
        arrowOptions.position = ToolTip.getCoordinateFromValue(arrowOptions.position);
        arrowOptions.position[edges[options.edge].dim] = options.edge;
        return arrowOptions;
    },
    /**
     * From Element.Position
     * @see https://mootools.lighthouseapp.com/projects/24057/tickets/556-expose-some-static-methods-of-elementposition
     */
    getCoordinateFromValue: function(option) {
        if (typeOf(option) != 'string') return option;
        option = option.toLowerCase();
        return {
            x: option.test('left') ? 'left'
            : (option.test('right') ? 'right' : 'center'),
            y: option.test(/upper|top/) ? 'top'
            : (option.test('bottom') ? 'bottom' : 'center')
        };
    },
    /**
     * Tooltip instance getter
     * @param  Element           tooltip owner
     * @param  string | Element  tooltip content
     * @param  object            options; 2nd and 3rd parameters order may be reversed
     */
    instance: function() {
        var element = arguments[0],
        param = ['string', 'element'].contains(typeOf(arguments[1])),
        content = param ? arguments[1] : (arguments[2] || null),
        options = param ? (arguments[2] || {}) : arguments[1];
        if (typeOf(current = document.retrieve('ToolTip.current')) == 'object') {
            current.hide();
        }
        if ((toolTip = element.retrieve('ToolTip.instance')) == null) {
            toolTip = new ToolTip(element, options);
        }
        else {
            toolTip.setOptions(options);
        }
        element.store('ToolTip.instance', toolTip);
        document.store('ToolTip.current', toolTip);
        if (content) {
            toolTip.set(content);
        }
        return toolTip;
    },
    /**
     * Parse URLs in text and replace them with anchors (ported from Kohana Framework)
     * @see http://kohanaframework.org/3.1/guide/api/Text#auto_link
     * @param string
     * @return string
     */
    parseLinks: function(text) {
        // Find and replace all http/https/ftp/ftps links that are not part of an existing html anchor
        text = text.replace(/\b(href="|">)?(?:ht|f)tps?:\/\/[^<\s]+(?:\/|\b)/i, function($0, $1) {
            return $1 ? $0 : '<a href="'+$0+'">'+$0+'</a>';
        });
        // Find and replace all naked www.links.com (without http://)
        text = text.replace(/\b\b(:\/\/|">)?www(?:\.[a-z0-9][-a-z0-9]*)+\.[a-z]{2,6}\b/i, function($0, $1) {
            return $1 ? $0 : '<a href="http://'+$0+'">'+$0+'</a>';
        });
        // Find and replace all email addresses that are not part of an existing html mailto anchor
        text = text.replace(/\b(href=["']?mailto:|58;)?(?!\.)[-+_a-z0-9.]+(\.)?@(?![-.])[-a-z0-9.]+(\.)?\.[a-z]{2,6}\b(?!<\/a>)/i, function($0, $1) {
            return $1 ? $0 : '<a href="mailto:'+$0+'">'+$0+'</a>';
        });
        return text;
    }
});
/**
 * Experimental; shows tooltip while executing XHR
 */
Request.ToolTip = new Class({
    Extends: Request,
    options: {
        anchor: null,
        link: 'cancel',
        localePrefix: 'ToolTip',
        method: 'post'
    },
    initialize: function(options) {
        this.parent(options);
        if (typeOf(this.options.anchor) != 'element') {
            throw 'Anchor option must be element';
        }
        this.addEvents({
            'failure': function(xhr) {
                var content = new Element('div').adopt(
                    new Element('span[html="'+(Locale.get(this.options.localePrefix+'.failed') || 'Your request could not complete')+'. "]'),
                    new Element('a[href="javascript:;"][html="'+(Locale.get('ToolTip.retry') || 'Try again')+'"]')
                    .addEvent('click', this.send.bind(this)),
                    new Element('br'),
                    new Element('span[html="'+(Locale.get('ToolTip.status') || 'Server replied: {status} {statusText}').substitute(xhr)+'"]')
                    );
                ToolTip.instance(this.options.anchor, {
                    autohide: false
                }, content).show();
            },
            'request': function() {
                var content = new Element('div.progress[html="'+(Locale.get(this.options.localePrefix+'.updating') || 'Your request is being processed')+'&hellip;"]');
                ToolTip.instance(this.options.anchor, {
                    autohide: false
                }, content).show();
            },
            'success': function(text) {
                if (/application\/json/.test(this.getHeader('Content-type'))) {
                    var json = this.response.json = Function.attempt(function(){
                        return JSON.decode(text);
                    });
                    text = json.message;
                }
                ToolTip.instance(this.options.anchor, {
                    autohide: true
                }, text || (Locale.get(this.options.localePrefix+'.success') || 'Your request has completed')).show();
                this.fireEvent('mouseleave');
            }
        });
    }
});

var ScrollSidebar = new Class({
	
    Implements: [Options],
	
    options: {
        offsets: {
            x:0, 
            y:0
        },
        mode: 'vertical',
        positionVertical: 'top',
        positionHorizontal: 'right',
        speed: 400
    },
	
    initialize: function(menu,options) {
        /* initial options */
        this.setOptions(options);
        this.menu = $(menu);
        this.move = this.options.mode == 'vertical' ? 'y' : 'x';
        this.property = this.move == 'y' ? 'positionVertical' : 'positionHorizontal';
        /* ensure a few things */
        var css = {
            position: 'absolute', 
            display:'block'
        };
        css[this.options.positionVertical] = this.options.offsets.y;
        css[this.options.positionHorizontal] = this.options.offsets.x;
        this.menu.setStyles(css).set('tween',{
            duration: this.options.speed
        });
        /* start listening */
        this.startListeners();
    },
	
    startListeners: function() {
        var action = function() {
            this.setPosition($(document.body).getScroll()[this.move] + this.options.offsets[this.move]);
        }.bind(this);
        window.addEvent('scroll',action);
        window.addEvent('load',action);
    },
	
    setPosition: function(move) {
        this.menu.tween(this.options[this.property],move);
        return this;
    }
});

/* usage */
window.addEvent('domready',function() {
    /*$('sidebar-menu').set('opacity',0.8); //opacity effect for fun
    var sidebar = new ScrollSidebar('sidebar-menu',{
        offsets: {
            x: 0,
            y: 250
        }
    });
    $('sidebar-menu').setStyles({
        "display":"none"
    });*/
    var formatValue=function(value, max){
        var tam=value.length;
        var valor = "";
            
        if (parseInt(tam)>parseInt(max))
            valor = value.substring(0,max)+"...";
        else valor = value;
        return valor;
    }
        
    /*var json = new Request.JSON({
        url: './Publicaciones?action=GetAnuncioForWeb',
        onSuccess: function(data){
            if (data.anuncio!=null){
                if (data.estado=="x"){
                    $('sidebar-menu').setStyles({
                        "display":"block"
                    });
                
                    $("tituAnuncio").set("html", " <a href='./Publicaciones?action=PaginaComunicadoPrint&id="+data.anuncio.anuId+"' style='color:#ccffcc; font-size:13pt; text-decoration:none;' >"+ data.anuncio.titulo+"</a>");
                    $("contentAnuncio").set("html",formatValue(data.anuncio.contenido, 400)+ " <a href='./Publicaciones?action=PaginaComunicadoPrint&id="+data.anuncio.anuId+"' style='color:#000; float:right; font-weight: bold;'>Leer Más</a>" );
                }
            } else
                $('sidebar-menu').setStyles({
                    "display":"none"
                });
        }
    });
    json.send();*/
        
    $$(".closeAnuncio").addEvent("click", function(){
        var json = new Request.JSON({
            url: './Publicaciones?action=CerrarAnuncioForWeb'
        }).send();
        $('sidebar-menu').setStyles({
            "display":"none"
        });
    })
            
    $$(".sliderPanel h2").each(function(e){
        var text = e.get("text");
        var arrow;
        e.set("html","<table style='width:100%'><tr></tr></table>");
        switch(e.getNext().getStyle("display")){
            case "none":
                arrow = "<img src='./resources/images/16x16/arrow-u.png' class='up-img' border='0' style='padding:4px' />";
                break;
            case "block":
                arrow = "<img src='./resources/images/16x16/arrow-d.png'  border='0' style='padding:4px' />";
                break;
        }
        
        e.getChildren().set("html", "<td  style='font-weight:bold; width:95%'>"+text+"</td><td >"+arrow+"</td></tr>");
        
        e.addEvent("click", function(evt){
            switch(e.getNext().getStyle("display")){
                case "none":
                    arrow = "<img src='./resources/images/16x16/arrow-u.png' class='up-img'  border='0' style='padding:4px' />";
                    $$(".up-img").set("src","./resources/images/16x16/arrow-d.png");
                    break;
                case "block":
                    arrow = "<img src='./resources/images/16x16/arrow-d.png' border='0' style='padding:4px' />";
                    $$(".up-img").set("src","./resources/images/16x16/arrow-d.png");
                    break;
            }
            text = this.getChildren()[0].get("text");
            e.getChildren().set("html", "<td  style='font-weight:bold; width:95%'>"+text+"</td><td >"+arrow+"</td></tr>");
        });
    });

});

function get() { 
    var vars = [], hash; 
    var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&'); 
    for(var i = 0; i < hashes.length; i++) { hash = hashes[i].split('='); vars.push(hash[0]); vars[hash[0]] = hash[1]; } return vars; } 
        
        
