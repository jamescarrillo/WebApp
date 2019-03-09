(function(b){
    b.gritter={};
    
    b.gritter.options={
        position:"",
        class_name:"",
        fade_in_speed:"medium",
        fade_out_speed:1000,
        time:6000
    };
    
    b.gritter.add=function(f){
        try{
            return a.add(f||{})
            }catch(d){
            var c="Gritter Error: "+d;
            (typeof(console)!="undefined"&&console.error)?console.error(c,f):""
            }
        };
    
b.gritter.remove=function(d,c){
    a.removeSpecific(d,c||{})
    };
    
b.gritter.removeAll=function(c){
    a.stop(c||{})
    };
    
var a={
    position:"",
    fade_in_speed:"",
    fade_out_speed:"",
    time:"",
    _custom_timer:0,
    _item_count:0,
    _is_setup:0,
    _tpl_close:'<div class="gritter-close"></div>',
    _tpl_title:'<span class="gritter-title">[[title]]</span>',
    _tpl_item:'<div id="gritter-item-[[number]]" class="gritter-item-wrapper [[item_class]]" style="display:none"><div class="gritter-top"></div><div class="gritter-item">[[close]][[image]]<div class="[[class_name]]">[[title]]<p>[[text]]</p></div><div style="clear:both"></div></div><div class="gritter-bottom"></div></div>',
    _tpl_wrap:'<div id="gritter-notice-wrapper"></div>',
    add:function(g){
        if(typeof(g)=="string"){
            g={
                text:g
            }
        }
        if(!g.text){
        throw'You must supply "text" parameter.'
        }
        if(!this._is_setup){
        this._runSetup()
        }
        var k=g.title,n=g.text,e=g.image||"",l=g.sticky||false,m=g.class_name||b.gritter.options.class_name,j=b.gritter.options.position,d=g.time||"";
    this._verifyWrapper();
    this._item_count++;
    var f=this._item_count,i=this._tpl_item;
    b(["before_open","after_open","before_close","after_close"]).each(function(p,q){
        a["_"+q+"_"+f]=(b.isFunction(g[q]))?g[q]:function(){}
    });
this._custom_timer=0;
if(d){
    this._custom_timer=d
    }
    var c=(e!="")?'<img src="'+e+'" class="gritter-image" />':"",h=(e!="")?"gritter-with-image":"gritter-without-image";
    if(k){
    k=this._str_replace("[[title]]",k,this._tpl_title)
    }else{
    k=""
    }
    i=this._str_replace(["[[title]]","[[text]]","[[close]]","[[image]]","[[number]]","[[class_name]]","[[item_class]]"],[k,n,this._tpl_close,c,this._item_count,h,m],i);
    if(this["_before_open_"+f]()===false){
    return false
    }
    b("#gritter-notice-wrapper").addClass(j).append(i);
    var o=b("#gritter-item-"+this._item_count);
    o.fadeIn(this.fade_in_speed,function(){
    a["_after_open_"+f](b(this))
    });
if(!l){
    this._setFadeTimer(o,f)
    }
    b(o).bind("mouseenter mouseleave",function(p){
    if(p.type=="mouseenter"){
        if(!l){
            a._restoreItemIfFading(b(this),f)
            }
        }else{
    if(!l){
        a._setFadeTimer(b(this),f)
        }
    }
a._hoverState(b(this),p.type)
    });
b(o).find(".gritter-close").click(function(){
    a.removeSpecific(f,{},null,true)
    });
return f
},
_countRemoveWrapper:function(c,d,f){
    d.remove();
    this["_after_close_"+c](d,f);
    if(b(".gritter-item-wrapper").length==0){
        b("#gritter-notice-wrapper").remove()
        }
    },
_fade:function(g,d,j,f){
    var j=j||{},i=(typeof(j.fade)!="undefined")?j.fade:true,c=j.speed||this.fade_out_speed,h=f;
    this["_before_close_"+d](g,h);
    if(f){
        g.unbind("mouseenter mouseleave")
        }
        if(i){
        g.animate({
            opacity:0
        },c,function(){
            g.animate({
                height:0
            },300,function(){
                a._countRemoveWrapper(d,g,h)
                })
            })
        }else{
        this._countRemoveWrapper(d,g)
        }
    },
_hoverState:function(d,c){
    if(c=="mouseenter"){
        d.addClass("hover");
        d.find(".gritter-close").show()
        }else{
        d.removeClass("hover");
        d.find(".gritter-close").hide()
        }
    },
removeSpecific:function(c,g,f,d){
    if(!f){
        var f=b("#gritter-item-"+c)
        }
        this._fade(f,c,g||{},d)
    },
_restoreItemIfFading:function(d,c){
    clearTimeout(this["_int_id_"+c]);
    d.stop().css({
        opacity:"",
        height:""
    })
    },
_runSetup:function(){
    for(opt in b.gritter.options){
        this[opt]=b.gritter.options[opt]
        }
        this._is_setup=1
    },
_setFadeTimer:function(f,d){
    var c=(this._custom_timer)?this._custom_timer:this.time;
    this["_int_id_"+d]=setTimeout(function(){
        a._fade(f,d)
        },c)
    },
stop:function(e){
    var c=(b.isFunction(e.before_close))?e.before_close:function(){};
    
    var f=(b.isFunction(e.after_close))?e.after_close:function(){};
    
    var d=b("#gritter-notice-wrapper");
    c(d);
    d.fadeOut(function(){
        b(this).remove();
        f()
        })
    },
_str_replace:function(v,e,o,n){
    var k=0,h=0,t="",m="",g=0,q=0,l=[].concat(v),c=[].concat(e),u=o,d=c instanceof Array,p=u instanceof Array;
    u=[].concat(u);
    if(n){
        this.window[n]=0
        }
        for(k=0,g=u.length;k<g;k++){
        if(u[k]===""){
            continue
        }
        for(h=0,q=l.length;h<q;h++){
            t=u[k]+"";
            m=d?(c[h]!==undefined?c[h]:""):c[0];
            u[k]=(t).split(l[h]).join(m);
            if(n&&u[k]!==t){
                this.window[n]+=(t.length-u[k].length)/l[h].length
                }
            }
        }
    return p?u:u[0]
},
_verifyWrapper:function(){
    if(b("#gritter-notice-wrapper").length==0){
        b("body").append(this._tpl_wrap)
        }
    }
}
})(jQuery);
(function($) {
    $.fn.editable = function(target, options) {
        if ('disable' == target) {
            $(this).data('disabled.editable', true);
            return;
        }
        if ('enable' == target) {
            $(this).data('disabled.editable', false);
            return;
        }
        if ('destroy' == target) {
            $(this)
            .unbind($(this).data('event.editable'))
            .removeData('disabled.editable')
            .removeData('event.editable');
            return;
        }

        var settings = $.extend({}, $.fn.editable.defaults, {
            target:target
        }, options);
        
        /* setup some functions */
        var plugin   = $.editable.types[settings.type].plugin || function() { };
        var submit   = $.editable.types[settings.type].submit || function() { };
        var buttons  = $.editable.types[settings.type].buttons 
        || $.editable.types['defaults'].buttons;
        var content  = $.editable.types[settings.type].content 
        || $.editable.types['defaults'].content;
        var element  = $.editable.types[settings.type].element 
        || $.editable.types['defaults'].element;
        var reset    = $.editable.types[settings.type].reset 
        || $.editable.types['defaults'].reset;
        var callback = settings.callback || function() { };
        var onedit   = settings.onedit   || function() { }; 
        var onsubmit = settings.onsubmit || function() { };
        var onreset  = settings.onreset  || function() { };
        var onerror  = settings.onerror  || reset;
          
        /* show tooltip */
        if (settings.tooltip) {
            $(this).attr('title', settings.tooltip);
        }
        
        settings.autowidth  = 'auto' == settings.width;
        settings.autoheight = 'auto' == settings.height;
        
        return this.each(function() {
                        
            /* save this to self because this changes when scope changes */
            var self = this;  
                   
            /* inlined block elements lose their width and height after first edit */
            /* save them for later use as workaround */
            var savedwidth  = $(self).width();
            var savedheight = $(self).height();
            
            /* save so it can be later used by $.editable('destroy') */
            $(this).data('event.editable', settings.event);
            
            /* if element is empty add something clickable (if requested) */
            if (!$.trim($(this).html())) {
                $(this).html(settings.placeholder);
            }
            
            $(this).bind(settings.event, function(e) {
                
                /* abort if disabled for this element */
                if (true === $(this).data('disabled.editable')) {
                    return;
                }
                
                /* prevent throwing an exeption if edit field is clicked again */
                if (self.editing) {
                    return;
                }
                
                /* abort if onedit hook returns false */
                if (false === onedit.apply(this, [settings, self])) {
                    return;
                }
                
                /* prevent default action and bubbling */
                e.preventDefault();
                e.stopPropagation();
                
                /* remove tooltip */
                if (settings.tooltip) {
                    $(self).removeAttr('title');
                }
                
                /* figure out how wide and tall we are, saved width and height */
                /* are workaround for http://dev.jquery.com/ticket/2190 */
                if (0 == $(self).width()) {
                    //$(self).css('visibility', 'hidden');
                    settings.width  = savedwidth;
                    settings.height = savedheight;
                } else {
                    if (settings.width != 'none') {
                        settings.width = 
                        settings.autowidth ? $(self).width()  : settings.width;
                    }
                    if (settings.height != 'none') {
                        settings.height = 
                        settings.autoheight ? $(self).height() : settings.height;
                    }
                }
                //$(this).css('visibility', '');
                
                /* remove placeholder text, replace is here because of IE */
                if ($(this).html().toLowerCase().replace(/(;|")/g, '') == 
                    settings.placeholder.toLowerCase().replace(/(;|")/g, '')) {
                    $(this).html('');
                }
                                
                self.editing    = true;
                self.revert     = $(self).html();
                $(self).html('');

                /* create the form object */
                var form = $('<form />');
                
                /* apply css or style or both */
                if (settings.cssclass) {
                    if ('inherit' == settings.cssclass) {
                        form.attr('class', $(self).attr('class'));
                    } else {
                        form.attr('class', settings.cssclass);
                    }
                }

                if (settings.style) {
                    if ('inherit' == settings.style) {
                        form.attr('style', $(self).attr('style'));
                        /* IE needs the second line or display wont be inherited */
                        form.css('display', $(self).css('display'));                
                    } else {
                        form.attr('style', settings.style);
                    }
                }

                /* add main input element to form and store it in input */
                var input = element.apply(form, [settings, self]);

                /* set input content via POST, GET, given data or existing value */
                var input_content;
                
                if (settings.loadurl) {
                    var t = setTimeout(function() {
                        input.disabled = true;
                        content.apply(form, [settings.loadtext, settings, self]);
                    }, 100);

                    var loaddata = {};
                    loaddata[settings.id] = self.id;
                    if ($.isFunction(settings.loaddata)) {
                        $.extend(loaddata, settings.loaddata.apply(self, [self.revert, settings]));
                    } else {
                        $.extend(loaddata, settings.loaddata);
                    }
                    $.ajax({
                        type : settings.loadtype,
                        url  : settings.loadurl,
                        data : loaddata,
                        async : false,
                        success: function(result) {
                            window.clearTimeout(t);
                            input_content = result;
                            input.disabled = false;
                        }
                    });
                } else if (settings.data) {
                    input_content = settings.data;
                    if ($.isFunction(settings.data)) {
                        input_content = settings.data.apply(self, [self.revert, settings]);
                    }
                } else {
                    input_content = self.revert; 
                }
                content.apply(form, [input_content, settings, self]);

                input.attr('name', settings.name);
                input.addClass("ui-widget-content ui-corner-all").css({
                    height:"18px"
                });
                /* add buttons to the form */
                buttons.apply(form, [settings, self]);
         
                /* add created form to self */
                $(self).append(form);
         
                /* attach 3rd party plugin if requested */
                plugin.apply(form, [settings, self]);

                /* focus to first visible form element */
                $(':input:visible:enabled:first', form).focus();

                /* highlight input contents when requested */
                if (settings.select) {
                    input.select();
                }
        
                /* discard changes if pressing esc */
                input.keydown(function(e) {
                    if (e.keyCode == 27) {
                        e.preventDefault();
                        //self.reset();
                        reset.apply(form, [settings, self]);
                    }
                });

                /* discard, submit or nothing with changes when clicking outside */
                /* do nothing is usable when navigating with tab */
                var t;
                if ('cancel' == settings.onblur) {
                    input.blur(function(e) {
                        /* prevent canceling if submit was clicked */
                        t = setTimeout(function() {
                            reset.apply(form, [settings, self]);
                        }, 500);
                    });
                } else if ('submit' == settings.onblur) {
                    input.blur(function(e) {
                        /* prevent double submit if submit was clicked */
                        t = setTimeout(function() {
                            form.submit();
                        }, 200);
                    });
                } else if ($.isFunction(settings.onblur)) {
                    input.blur(function(e) {
                        settings.onblur.apply(self, [input.val(), settings]);
                    });
                } else {
                    input.blur(function(e) {
                        /* TODO: maybe something here */
                        });
                }

                form.submit(function(e) {

                    if (t) { 
                        clearTimeout(t);
                    }

                    /* do no submit */
                    e.preventDefault(); 
            
                    /* call before submit hook. */
                    /* if it returns false abort submitting */                    
                    if (false !== onsubmit.apply(form, [settings, self])) { 
                        /* custom inputs call before submit hook. */
                        /* if it returns false abort submitting */
                        if (false !== submit.apply(form, [settings, self])) { 

                            /* check if given target is function */
                            if ($.isFunction(settings.target)) {
                                var str = settings.target.apply(self, [input.val(), settings]);
                                $(self).html(str);
                                self.editing = false;
                                callback.apply(self, [self.innerHTML, settings]);
                                /* TODO: this is not dry */                              
                                if (!$.trim($(self).html())) {
                                    $(self).html(settings.placeholder);
                                }
                            } else {
                                /* add edited content and id of edited element to POST */
                                var submitdata = {};
                                submitdata[settings.name] = input.val();
                                submitdata[settings.id] = self.id;
                                /* add extra data to be POST:ed */
                                if ($.isFunction(settings.submitdata)) {
                                    $.extend(submitdata, settings.submitdata.apply(self, [self.revert, settings]));
                                } else {
                                    $.extend(submitdata, settings.submitdata);
                                }

                                /* quick and dirty PUT support */
                                if ('PUT' == settings.method) {
                                    submitdata['_method'] = 'put';
                                }

                                /* show the saving indicator */
                                $(self).html(settings.indicator);
                              
                                /* defaults for ajaxoptions */
                                var ajaxoptions = {
                                    type    : 'POST',
                                    data    : submitdata,
                                    dataType: 'html',
                                    url     : settings.target,
                                    success : function(result, status) {
                                        if (ajaxoptions.dataType == 'html') {
                                            $(self).html(result);
                                        }
                                        self.editing = false;
                                        callback.apply(self, [result, settings]);
                                        if (!$.trim($(self).html())) {
                                            $(self).html(settings.placeholder);
                                        }
                                    },
                                    error   : function(xhr, status, error) {
                                        onerror.apply(form, [settings, self, xhr]);
                                    }
                                };
                              
                                /* override with what is given in settings.ajaxoptions */
                                $.extend(ajaxoptions, settings.ajaxoptions);   
                                $.ajax(ajaxoptions);          
                              
                            }
                        }
                    }
                    
                    /* show tooltip again */
                    $(self).attr('title', settings.tooltip);
                    
                    return false;
                });
            });
            
            /* privileged methods */
            this.reset = function(form) {
                /* prevent calling reset twice when blurring */
                if (this.editing) {
                    /* before reset hook, if it returns false abort reseting */
                    if (false !== onreset.apply(form, [settings, self])) { 
                        $(self).html(self.revert);
                        self.editing   = false;
                        if (!$.trim($(self).html())) {
                            $(self).html(settings.placeholder);
                        }
                        /* show tooltip again */
                        if (settings.tooltip) {
                            $(self).attr('title', settings.tooltip);                
                        }
                    }                    
                }
            };            
        });

    };


    $.editable = {
        types: {
            defaults: {
                element : function(settings, original) {
                    var input = $('<input type="hidden"></input>');                
                    $(this).append(input);
                    return(input);
                },
                content : function(string, settings, original) {
                    $(':input:first', this).val(string);
                },
                reset : function(settings, original) {
                    original.reset(this);
                },
                buttons : function(settings, original) {
                    var form = this;
                    if (settings.submit) {
                        /* if given html string use that */
                        if (settings.submit.match(/>$/)) {
                            var submit = $(settings.submit).click(function() {
                                if (submit.attr("type") != "submit") {
                                    form.submit();
                                }
                            });
                        /* otherwise use button with given string as text */
                        } else {
                            var submit = $('<button type="submit" />');
                            submit.html(settings.submit);                            
                        }
                        $(this).append(submit);
                    }
                    if (settings.cancel) {
                        /* if given html string use that */
                        if (settings.cancel.match(/>$/)) {
                            var cancel = $(settings.cancel);
                        /* otherwise use button with given string as text */
                        } else {
                            var cancel = $('<button type="cancel" />');
                            cancel.html(settings.cancel);
                        }
                        $(this).append(cancel);

                        $(cancel).click(function(event) {
                            //original.reset();
                            if ($.isFunction($.editable.types[settings.type].reset)) {
                                var reset = $.editable.types[settings.type].reset;                                                                
                            } else {
                                var reset = $.editable.types['defaults'].reset;                                
                            }
                            reset.apply(form, [settings, original]);
                            return false;
                        });
                    }
                }
            },
            text: {
                element : function(settings, original) {
                    var input = $('<input />');
                    if (settings.width  != 'none') {
                        input.width(settings.width);
                    }
                    if (settings.height != 'none') {
                        input.height(settings.height);
                    }
                    /* https://bugzilla.mozilla.org/show_bug.cgi?id=236791 */
                    //input[0].setAttribute('autocomplete','off');
                    input.attr('autocomplete','off');
                    $(this).append(input);
                    return(input);
                }
            },
            textarea: {
                element : function(settings, original) {
                    var textarea = $('<textarea />');
                    if (settings.rows) {
                        textarea.attr('rows', settings.rows);
                    } else if (settings.height != "none") {
                        textarea.height(settings.height);
                    }
                    if (settings.cols) {
                        textarea.attr('cols', settings.cols);
                    } else if (settings.width != "none") {
                        textarea.width(settings.width);
                    }
                    $(this).append(textarea);
                    return(textarea);
                }
            },
            select: {
                element : function(settings, original) {
                    var select = $('<select />');
                    $(this).append(select);
                    return(select);
                },
                content : function(data, settings, original) {
                    /* If it is string assume it is json. */
                    if (String == data.constructor) {      
                        eval ('var json = ' + data);
                    } else {
                        /* Otherwise assume it is a hash already. */
                        var json = data;
                    }
                    for (var key in json) {
                        if (!json.hasOwnProperty(key)) {
                            continue;
                        }
                        if ('selected' == key) {
                            continue;
                        } 
                        var option = $('<option />').val(key).append(json[key]);
                        $('select', this).append(option);    
                    }                    
                    /* Loop option again to set selected. IE needed this... */ 
                    $('select', this).children().each(function() {
                        if ($(this).val() == json['selected'] || 
                            $(this).text() == $.trim(original.revert)) {
                            $(this).attr('selected', 'selected');
                        }
                    });
                }
            }
        },

        /* Add new input type */
        addInputType: function(name, input) {
            $.editable.types[name] = input;
        }
    };

    // publicly accessible defaults
    $.fn.editable.defaults = {
        name       : 'value',
        id         : 'id',
        type       : 'text',
        width      : 'auto',
        height     : 'auto',
        event      : 'click.editable',
        onblur     : 'cancel',
        loadtype   : 'GET',
        loadtext   : 'Cargando...',
        placeholder: 'Click para editar',
        loaddata   : {},
        submitdata : {},
        ajaxoptions: {}
    };

})(jQuery);

//GRID//
(function ($) {
    var $tabla;
    
    $.fn.jgrid=function(options){
        initComponent=function(owner){
            var propiedades=$.extend($.fn.jgrid.defaults,$.fn.paginate.defaults, options);
            $("#"+owner).attr("rel","").css("width", options.ancho);
            createTable(propiedades,owner);
        }
        selectAll = function(clase, body) {
            var $id=body.parent().parent().parent();
            var dato ="";
            var flag = "";
            $("."+clase).each(function(){
                $(this).click(function(){ 
                    var indice = $(this).attr("rel");
                    $("tr",body).each(function(index){
                        dato= $(this).find("td").eq(indice).find("img").attr("rel");
                        if ($(this).find("td").eq(indice).find("img").attr("val")=="false"){
                            flag= "true";
                            $(this).find("td").eq(indice).attr("val", $(this).find("td").eq(indice).text()).empty().append('<img val="true" rel='+dato+' src="./resources/images/checked.png" />').css("text-align", "center");
                        }else{
                            flag= "false";
                            $(this).find("td").eq(indice).attr("val", $(this).find("td").eq(indice).text()).empty().append('<img val="false" rel='+dato+'  src="./resources/images/unchecked.png" />').css("text-align", "center");
                        }
                    });
                    
                    var $achecks = $id.attr(dato).split(",");
                    $id.attr(dato,"");
                    var tamanio = $achecks.length;
                    $.each($achecks, function(index,node){
                        var nodo ="";
                        var $adatos = node.split(".");
                        nodo = $adatos[0]+"."+flag+"."+$adatos[2];

                        if (index<parseInt(tamanio-1))
                            $id.attr(dato,$id.attr(dato)+nodo+",");
                        else
                            $id.attr(dato,$id.attr(dato)+nodo);

                    });
                });
                
            });
        }
        createTable=function(propiedades,renderTo){
            
            if($("#"+renderTo).html()==""){
                if (propiedades.titulo!="")
                    var titulo = $("<div class='ui-widget-header ui-corner-top' style='height:15px; text-align:center; padding-top:5px;'> "+propiedades.titulo+" </div>").css({
                        width: (propiedades.ancho)
                    
                    });
                
            
                var divContenedor = $("<div id='div"+propiedades.id+"'/>").css({
                    width: propiedades.ancho
                }).addClass("ui-widget-content");
                var contenedor=$('<table class="ui-widget-content" id="table'+propiedades.id+'" cellspacing="0" ></table>').css({
                    width: propiedades.ancho
                });
                var header=$('<thead></thead>');
                var columnas=[];
                for(var i=0;i<propiedades.model.length;i++){
                    var check = "";
                    if (propiedades.model[i].virtual)
                        check = "<input type='checkbox' rel="+i+" class='check"+renderTo+"' value='false' >";
                    if(!(propiedades.model[i].hidden))
                        columnas.push('<th class="ui-state-default ui-th-colum ui-th-ltr" style="width:'+propiedades.model[i].width +'; padding:6px;" name="'+propiedades.model[i].name+'">'+check+propiedades.model[i].field+'</th>');
                }
                $("<tr class='ui-widget-header'></tr>").append(columnas.join('')).appendTo(header);
                addSortableColumn(header,propiedades, propiedades.id);
                columnas=[];
                header.appendTo(contenedor);
                divContenedor.appendTo("#" +renderTo );
                contenedor.appendTo("#div" +propiedades.id);
                if (propiedades.titulo!="")
                    titulo.insertBefore("#div"+ propiedades.id);
            
                
                //var rowsLoad=loadGrid(propiedades, renderTo);
                //rowsLoad.appendTo(contenedor);
                $tabla=contenedor;
                
            }
        }
        addSortableColumn=function($header,$propiedades, renderTo){
            $.each($propiedades.model,function(columna,component){
                var col=$("th",$header).get(columna);
                if(component.sort==undefined?$propiedades.defaultColumns[0].sort:component.sort){                    
                    $(col).removeClass("sortable").addClass("sortable");
                }                
                var findOrder= $.fn.jgrid.columnType[component.type==undefined?$propiedades.defaultColumns[0].type:component.type.toLowerCase()](col); 
                if(findOrder){
                    $(col).click(function(){
                        if($(col).hasClass("sortable")){
                            var sortDirect=1;
                            if($(col).is('.sort-asc')) {
                                sortDirect=-1
                            }
                            var filas=$("#table"+renderTo).find("tbody > tr").get();
                            $(filas).each(function(index,node){
                                $(node).data("sortKey",findOrder( $(node).children("td").eq(columna)));
                            });
                            filas.sort(function(a,b){
                                if($(a).data("sortKey")<$(b).data("sortKey"))return -sortDirect;
                                if($(a).data("sortKey")>$(b).data("sortKey"))return sortDirect;
                                return 0;
                            });
                            $(filas).each(function(index,nodo){
                                $("#table"+renderTo).children("tbody").append(nodo);
                                $(nodo).removeData('sortKey')
                            });                               
                            $("#table"+renderTo).find("th").removeClass("sort-asc").removeClass("sort-desc");
                            if(sortDirect==1){
                                $(col).addClass("sort-asc");                                
                            }else{
                                $(col).addClass("sort-desc");
                            }                                                   
                        }                               
                    });                           
                }
            });
        }
        checktamanio= function ( o, min, max ) {
            if ( o.val().length > max || o.val().length < min )  {
                o.addClass( "ui-state-error" );
                return false;
            } else {
                return true;
            }
        }
        checkcaracter= function ( o, regexp, n ) {
            var text = o.val();
            if (text.length<=1)
                text=text+text;
            if ( !( regexp.test( text ) ) ) {
                o.addClass( "ui-state-error" );
                
                return false;
            } else 
                return true;
            
        }
        controlDel=function($objeto,option){
            var flag=true;
            if ($objeto.find("img").attr("val")=="true"){
                flag = false;
                $objeto.empty().append('<img val="false" src="./resources/images/unchecked.png" />');
                $objeto.parent().attr("lang","false");
            } else {
                flag = true;
                $objeto.empty().append('<img val="true" src="./resources/images/checked.png" />');
                $objeto.parent().attr("lang","true");
            }
            //alert($objeto.parent().attr("rel"));
            if(!(option.virtual)){
                $.ajax({
                    type: 'POST',
                    url: $objeto.attr("rel"),
                    data: "codigo="+$objeto.parent().attr("rel")+"&op=eliminar&act="+flag
                });
            } else {
                var $id=$objeto.parent().parent().parent().parent().parent();
                var iddato=$objeto.parent().attr("rel");
                var $achecks = $id.attr($objeto.attr("lang")).split(",");
                $id.attr($objeto.attr("lang"),"");
                var tamanio = $achecks.length;
                $.each($achecks, function(index,node){
                    var nodo ="";
                    var $adatos = node.split(".");
                    if($adatos[0]==iddato){
                        $adatos[1] = flag;
                        nodo = $adatos[0]+"."+$adatos[1]+"."+$adatos[2];
                    }
                    else 
                        nodo = node;
                    if (index<parseInt(tamanio-1))
                        $id.attr($objeto.attr("lang"),$id.attr($objeto.attr("lang"))+nodo+",");
                    else
                        $id.attr($objeto.attr("lang"),$id.attr($objeto.attr("lang"))+nodo);

                });
                
            }

        }
        eventCheck=function($objeto,node){
            if(node.showdialog) {
                $("<div id='dialog-confirm' title='Desea cambiar estado a este item?'><p><span class='ui-icon ui-icon-alert' style='float:left; margin:0 7px 20px 0;'></span>"+node.msndel+"</p></div>").dialog({
                    resizable: false,
                    height:160,
                    modal: true,
                    buttons: {
                        "Aceptar": function() {
                            controlDel($objeto, node);
                            $( this ).dialog( "close" );
                        },
                        "Cancelar": function() {
                            $( this ).dialog( "close" );
                        }
                    }
                });
                                    
            } else controlDel($objeto, node);
        }
        formatCell=function(body,propiedades){
            $.each(propiedades.model,function(index,node){
                var $objeto="";
                var tipo ="text";
                var sumito = "";
                var valido = "";
                var max = node.max;
                var min = node.min;
                if (node.items){
                    tipo="select";
                    $objeto=node.items;
                    sumito="Ok"
                };

                if(!(node.valid=="undefined")) valido=node.valid;
                if(node.editable){
                    var clase = $("tr", body).find("td").eq(index).attr("class");
                    var url = $("tr", body).find("td").eq(index).attr("rev");
                    
                    $("."+$("tr",body).find("td").eq(index).attr("class")).editable(url+'?op=mod'+clase,{
                        onsubmit: function(settings, td) {
                            var input = $(td).find('input');
                            var bValid = true;
                            input.removeClass( "ui-state-error" );
                            if (max=="undefined" || min=="undefined")
                                bValid = checktamanio( input, min, max );
                            if (valido)
                                bValid = checkcaracter( input, valido );
                            
                            if (node.keypress!=undefined) bValid=node.keypress(input); 
                            return bValid;
                        },
                        indicator : 'Guardando...',
                        type    :   tipo,
                        tooltip   : 'Doble Click Para Editar',
                        event     : "dblclick",
                        submit :    sumito,
                        style   : 'display: inline; position:absolute; margin-top:-10px',
                        data : $objeto
                    });
                }
                var columna=0;
                //booleandos true O false
                if(node.type=="boolean"){
                    if(node.format=="checkcolumn"){
                        var tamanio = $("tr",body).length;
                        var cont=0;
                        $("tr",body).each(function(){
                            var linea = $(this).attr("rel");
                            if ($(this).find("td").eq(index).text()=="true"){
                                if (node.virtual) {  
                                    var $id=$($(this).parent().parent().parent().parent().attr("id"));
                                    if (cont<parseInt(tamanio-1))
                                        $id.attr(node.datastore,$id.attr(node.datastore)+linea+".true."+columna+",");
                                    else
                                        $id.attr(node.datastore,$id.attr(node.datastore)+linea+".true."+columna);
                                    $(this).find("td").eq(index).attr("lang",node.datastore);
                                }
                                if (node.event==undefined || node.event=='dobleclik')
                                    $(this).find("td").eq(index).attr("val", $(this).find("td").eq(index).text()).empty().append('<img val="true"  src="./resources/images/checked.png" />').css("text-align", "center").dblclick(function(){
                                        eventCheck($(this),node); 
                                    });
                                else
                                    $(this).find("td").eq(index).attr("val", $(this).find("td").eq(index).text()).empty().append('<img val="true"  src="./resources/images/checked.png" />').css("text-align", "center").click(function(){
                                        eventCheck($(this),node); 
                                    });
                            }else{
                                if (node.virtual) {
                                    var $id=$(this).parent().parent().parent().parent();
                                    
                                    if (cont<parseInt(tamanio-1))
                                        $id.attr(node.datastore,$id.attr(node.datastore)+linea+".false."+columna+",");
                                    else
                                        $id.attr(node.datastore,$id.attr(node.datastore)+linea+".false."+columna);
                                    
                                    $(this).find("td").eq(index).attr("lang",node.datastore);
                                }
                               
                                if (node.event==undefined || node.event=='dobleclik')
                                    $(this).find("td").eq(index).attr("val", $(this).find("td").eq(index).text()).empty().append('<img rel='+node.datastore+' val="false" src="./resources/images/unchecked.png" />').css("text-align", "center").dblclick(function(){
                                        eventCheck($(this),node); 
                                    });
                                else 
                                    $(this).find("td").eq(index).attr("val", $(this).find("td").eq(index).text()).empty().append('<img rel='+node.datastore+' val="false" src="./resources/images/unchecked.png" />').css("text-align", "center").click(function(){
                                        eventCheck($(this),node); 
                                    });
                            }
                            cont++;
                        });
                    }
                    columna++;
                }                
            });
        }
        convertdate = function(dato){
            var date = "";
            var $fecha = dato.split("-");
            date = $fecha[2]+"/"+$fecha[1]+"/"+$fecha[0];
            return date
        }
        loadData = function(renderTo, tr, propiedades,concat){
            var $this = tr;
            var $grilla=$this.parent().parent().parent().parent();
            $grilla.attr("rel",$this.attr("rel"));
            
            $grilla.attr("value",$this.attr("value"));
            $this.addClass("ui-state-highlight").siblings().removeClass("ui-state-highlight");
                           
            if($this.attr("value")!="undefined"){
                var $obj=[];
                $obj=$this.attr("value").split(concat);
                var j=0;
                var valores="";
                $.each($obj,function(index,node){
                    for(var i=j;i<propiedades.model.length;i++){
                        if ((propiedades.model[i].hidden)){
                            $("#"+propiedades.model[i].content).attr("value",node);
                            if (i<parseInt(propiedades.model.length-1))
                                valores += propiedades.model[i].content+concat;
                            else valores += propiedades.model[i].content;
                            j=parseInt(i+1);
                            break;
                        }
                    }
                });
            }
        }
        function recur($nodo, $nombres, $beans, indice, concatText, flag){
            var tam = $beans.length;
            var $value = ["",""];
            var valor = "";
            $.each($nodo[$beans[indice]], function(index, node){
                if (indice<parseInt(tam-1)){
                    if (index==$beans[parseInt(indice+1)]) {
                        indice++;
                        
                        for(var k=0; k<$nombres.length; k++){
                            if(node[$nombres[k]]!="undefined"){
                                $value[0] += node[$nombres[k]];
                                if ($nombres.length>1 && k<parseInt($nombres.length-1))  $value[0] += concatText;
                            }
                        }
                        
                        if($value[0]=="undefined"){
                            indice++;
                            $value=recur(node,$nombres, $beans, indice, concatText, flag);
                            
                        }
                        
                    }
                }
                
                for(var k=0; k<$nombres.length; k++)
                    if (index==$nombres[k]) {
                        $value[0] += node;
                        if($value[0]!="undefined"){
                            if ($nombres.length>1 && k<parseInt($nombres.length-1)) $value[0] += concatText;
                        }
                        if (flag)
                            $value[1] = node;
                    }
                     
            });
           
            return $value;    
        }
        formatValue=function(value, max){
            var tam=value.length;
            var valor = "";
            
            if (parseInt(tam)>parseInt(max))
                valor = value.substring(0,max)+"...";
            else valor = value;
            return valor;
        }
        loadGrid=function(propiedades, renderTo){
            var body=$('<tbody ></tbody>').addClass("ui-jqgrid ui-jqgrid-btable");
            var $divGrid=$("#div"+ propiedades.id);
            var position = "";
            
            if ($divGrid.attr("value")==undefined){
                position=20;
            } else 
                position = parseInt(($divGrid.attr("value")/2)-10);
            $(".transparent").remove();
            var $divTransparent = $("<div id='tra"+propiedades.id+"' style=' position:absolute; background-color:#fff' class='transparent' >").css({
                width:propiedades.ancho,
                height:$divGrid.attr("value")+"px"
            }).fadeTo("fast", 0.5);
            
            $divTransparent.insertBefore("#div"+propiedades.id);
            var $divLoading = $("<div id=load"+propiedades.id+" class='ui-widget-content ui-corner-all ' style='margin:"+position+"px auto auto auto; position:static'>").css({
                width:'150px',
                height:'60px'
            }).html("<h2 style='margin-left:40px; float:left; '>Cargando...</<h2>");
            $divLoading.addClass("cargando").appendTo("#tra"+propiedades.id);
            $.ajax({
                url:propiedades.url,
                type : 'GET',
                dataType:'json',
                data: propiedades.data,
                success:function(result){
                    if (result.items.length)
                        $("#tra"+propiedades.id).fadeOut("fast", function(){
                            $(this).remove(); 
                        });
                    else{
                        $("#load"+propiedades.id).removeClass("cargando").html("<h3 style='text-align:center'>No hay resultados</<h3>");   
                    }
                    var cuerpo=[];
                    var key = 0;
                    var date = 0;
                    var value = "";
                    var $valor = [];
                    var codigo ="";
                    var select = 0;
                    var concat=",";
                    var size = result.items;
                    if (propiedades.select != "undefined")
                        select = propiedades.select;
                    if (propiedades.concat!="undefined")
                        concat = propiedades.concat;
                    $.each(result.items, function(index,node){
                        var datos = "";
                        
                        for(var i=0;i<propiedades.model.length;i++){
                            var flag = false;
                            value = "";
                            
                            var concatText=" ";
                            if (propiedades.model[i].concatText!=undefined)
                                concatText = propiedades.model[i].concatText;
                            
                            $("#"+renderTo).attr(propiedades.model[i].datastore,"");
                            if (propiedades.model[i].key) flag = true;
                            var nombreaux = propiedades.model[i].name;
                            var $nombreaux = nombreaux.split(",");
                            for(var k=0; k<$nombreaux.length; k++) {
                                value += node[$nombreaux[k]];
                                if ($nombreaux.length>1 && k<parseInt($nombreaux.length-1)) value += concatText;
                            }
                            
                            if (propiedades.model[i].nodo){
                                value="";
                                var nodo1 = propiedades.model[i].nodo1;
                                var nodo = propiedades.model[i].name;
                                var $nombres=nodo1.split(",");
                                var $beans = nodo.split(",");
                                var indice = 0;
                                
                                $valor=recur(node,$nombres, $beans, indice, concatText, flag);
                               
                                value= $valor[0];
                                if ($valor[1]!="")
                                    codigo=$valor[1];
                            }else{
                                if (flag) codigo = node[propiedades.model[i].name];
                            }
                            
                            if(!flag) if (propiedades.model[i].key) {
                                key = i;
                                var codigo= node[propiedades.model[key].name];
                            } 
                            
                            if (propiedades.model[i].type == "date"){
                                date=convertdate(value);
                                value = date;
                            }
                            var clase = "";
                            if (propiedades.model[i].editable){
                                clase = "class='"+propiedades.model[i].name+"'";
                            } else clase="class='"+propiedades.model[i].clase+"'";
                            if(propiedades.model[i].items) 
                                $.each(propiedades.model[i].items,function(index,node){
                                    if (value==index) value=node;
                                });
                            var delurl
                            if (propiedades.model[i].delurl!=undefined)
                             delurl   = "rel="+propiedades.model[i].delurl;
                            else delurl = "";
                            var dir = ""
                            if (propiedades.model[i].dir!=undefined){
                                dir = "dir="+propiedades.model[i].dir;
                            } else dir = "";
                            /*tipo Hidden */
                            if (!(propiedades.model[i].hidden)){
                                if (propiedades.model[i].cut!=undefined)
                                    value = value.replace(propiedades.model[i].cut,"");
                                value=formatValue(value,propiedades.model[i].maxTamanio);
                                cuerpo.push('<td '+clase+' id="'+codigo+'" '+dir+'  '+delurl+' rev="'+propiedades.model[i].modurl+'"  style="border-left: 1px solid #EDEDED; border-right: 1px solid #EDEDED;  padding-top:5px; padding-bottom:5px; " >'+value+'</td>');
                            }else {
                                if (i<parseInt(propiedades.model.length-1))
                                    datos += value+concat;
                                else datos += value;
                            }
                        //evento doble click a todas las tipos de datos boolean;
                        }
                        if (key!=0){
                            codigo= node[propiedades.model[key].name];
                        }
                        
                        var $trFila=$("<tr value=''  rel='"+codigo+"'></tr>").attr("lang","false").addClass("jqgrow ui-widget-content")                        
                        .click(function(){
                            if (propiedades.getData!=undefined)
                                propiedades.getData(datos);
                            loadData(renderTo, $(this), propiedades,  concat);
                        }).append(cuerpo.join('')).appendTo(body).hover(function () {
                            $(this).addClass("ui-state-hover").css({
                                cursor: "pointer"

                            });
                        },
                        function () {
                            $(this).removeClass("ui-state-hover");
                        }
                        );
                        if (index==select){
                            $trFila.addClass("ui-state-highlight");
                            propiedades.getData(datos);
                            loadData(renderTo, $trFila, propiedades, concat);
                        }
                        cuerpo=[];
                    });
                    
                    propiedades.success(result.items);
                    var alto = $("#table"+ propiedades.id).height();
                    $("#div"+propiedades.id).css({
                        'min-height': alto
                    }).attr("value",alto);
                    
                    if (result.items.length)
                        formatCell(body,propiedades);
                    
                    if((parseInt(result.pagina))==0)
                        $("#page"+ propiedades.id).attr("rel",0).val(1);
                    else
                        $("#page"+ propiedades.id).attr("rel", result.pagina).val(parseInt(result.pagina)+1);    
                    
                    $("#bfinal"+ propiedades.id).attr("rel", Math.ceil(parseInt(result.total)/(parseInt(propiedades.params.limit))))
                    if ((parseInt(propiedades.params.limit)*parseInt($("#page"+ propiedades.id).attr("value")))>result.total) {
                        var vista0=parseInt(((parseInt(propiedades.params.limit)*parseInt($("#page"+ propiedades.id).attr("value")))-parseInt(propiedades.params.limit))+1);
                        var vista = result.total;
                    }else {
                        var vista = (parseInt(propiedades.params.limit)*parseInt($("#page"+ propiedades.id).attr("value")));
                        var vista0= (vista-parseInt(propiedades.params.limit)+1);
                    }
                    
                    $("#total"+ propiedades.id).html(Math.ceil(parseInt(result.total)/(parseInt(propiedades.params.limit))));
                    $("#vista"+ propiedades.id).html(" | Vista "+vista0+" - "+ vista + " de "+ result.total);
                    
                    selectAll("check"+renderTo,body);
                }
            });
            return body;
        }
        initComponent(this.attr("id"));        
        
        return $tabla;
        
    }
    $.fn.jgrid.defaults={    
        url:'./defecto',
        id:'jgrid',
        ancho:'400px',
        data: "",
        success: function(){},
        titulo: "",
        concat : ",",
        defaultColumns:[{
            type:'string',
            sort:false
        }],
        model:[]
    }
    $.fn.jgrid.columnType={
        "string":function(col){
            $(col).addClass("string");
            return function(cell){
                return cell.text().toUpperCase();
            } 
        },
        "numeric":function(col){
            $(col).addClass("numeric");
            return function(cell){
                var key=parseFloat(cell.text());
                return isNaN(key)?0:key;
            }
        },
        "integer":function(col){
            $(col).addClass("integer");
            return function(cell){
                var key=parseInt(cell.text());
                return isNaN(key)?0:key;
            } 
        },
        "boolean":function(col){
            $(col).addClass("boolean")
            return function(cell){              
                return cell.text();
            } 
        },
        "date":function(col){
            $(col).addClass("date");
            return function(cell){              
                var key = cell.text();
                return key;
            } 
        }
    } 
})(jQuery);

(function ($) {
    
    $.fn.paginate=function(options){
        var padre=$(this).parent().parent().attr("id");
        
        var option=$.extend({}, $.fn.jgrid.defaults,$.fn.paginate.defaults,options);
        $("#pies"+option.id).remove();
        var vista ="";
        
            
        if (option.params.view!=false)
            vista = '<td align="right" ><div dir="ltr" style="text-align:right" class="ui-paging-info" id="vista'+option.id+'"></div></td>';
        var $pies = $('<div id=pies'+option.id+' class="ui-jqgrid-pager ui-state-default ui-corner-bottom" style="height:30px;"><div class="ui-pager-control" role="group" ><table cellspacing="0" cellpadding="0" border="0" class="ui-pg-table" style="width:'+option.id+'; table-layout:fixed; height:30px; float:right; " role="row"><tbody><tr><td align="left"></td><td  align="center" style="white-space: pre; width: 150px; "><table cellspacing="0" cellpadding="0" border="0" style="table-layout:auto;" class="ui-pg-table"><tbody><tr><td id="binicio'+option.id+'" class="ui-pg-button ui-corner-all ui-state-enabled" style="cursor: default; "><span id="binicio'+option.id+'" class="ui-icon ui-icon-seek-first"></span></td><td id="bizq'+option.id+'" class="ui-pg-button ui-corner-all ui-state-enabled"><span id="bizq" class="ui-icon ui-icon-seek-prev"></span></td><td class="ui-pg-button ui-state-enabled" style="width:4px;"><span class="ui-separator"></span></td><td dir="ltr"> Pagina <input class="" type="text" size="2" readonly=readonly id="page'+option.id+'" maxlength="7" value="0" role="textbox"> de <span id="total'+option.id+'"></span></td><td class="ui-pg-button ui-state-enabled" style="width:4px;"><span class="ui-separator"></span></td><td id="bder'+option.id+'"  class="ui-pg-button ui-corner-all ui-state-enabled"><span id="bder'+option.id+'" class="ui-icon ui-icon-seek-next"></span></td><td id="bfinal'+option.id+'" class="ui-pg-button ui-corner-all ui-state-enabled"><span id="bfinal'+option.id+'" class="ui-icon ui-icon-seek-end"></span></td><td dir="ltr"></td></tr></tbody></table></td>'+vista+'</tr></tbody></table></div></div>').css("width", option.ancho);
        option.url+='?start='+option.params.start+"&limit="+option.params.limit;
        var alto = Math.ceil((option.params.limit*21)+21+(option.params.limit-1));
        $("#div"+options.id).css({
            'min-height': alto
        }).attr("value",alto);

        
        
        $pies.insertAfter('#div'+option.id);
        if (options.params.paginate==undefined) {
            options.params.paginate = true;
        
        
        } else
            $("#pies"+option.id).hide();
        loadPaginate(option,padre);
        $(".ui-icon-seek-first").each(function(){
            $(this).click(function(evt){
                evt.preventDefault();
                urlParse(option,0, padre);
            });
        });
        
        $("#bizq"+option.id).click(function(evt){
            evt.preventDefault();
            
            if(parseInt($("#page"+option.id).attr("rel"))>0) urlParse(option,parseInt($("#page"+option.id).attr("rel"))-1,padre);
        });
    
        $("#bder"+option.id).click(function(evt){
            
            evt.preventDefault();
            if(parseInt($("#page"+option.id).attr("rel"))<(parseInt($("#bfinal"+option.id).attr("rel"))-1)) urlParse(option,parseInt($("#page"+option.id).attr("rel"))+1,padre);
        });
        
        $("#bfinal"+option.id).click(function(evt){
            evt.preventDefault();
            urlParse(option,$("#bfinal"+option.id).attr("rel")-1, padre);        
        });
    }
    var urlParse=function(option,page,padre){
        var urlTemp=option.url.split('?');
        var urlHttp=urlTemp[0];
        var urlQuerys=urlTemp[1];
        var temp="&";
        var newUrl=urlHttp+"?";
        if(urlQuerys){
            var queryString=urlQuerys.split('&');
            for(var i=0 in queryString){
                var row,key,opt=false;
                if(queryString[i].indexOf("start")!=-1){
                    row=queryString[i].split("=");
                    key=row[0]; 
                    newUrl+=key+"="+(parseInt(page)* parseInt(option.params.limit));
                    opt=true;
                }
                if(opt) newUrl+=temp;                    
                if(queryString[i].indexOf("limit")!=-1) newUrl+=queryString[i];              
            }
        }
        option.url=newUrl+"&current="+parseInt(page);
        loadPaginate(option,padre);
    }
    
    var loadPaginate=function(propiedades, renderTo){
        $("#table"+propiedades.id).find("tbody").remove();
        var body=loadGrid(propiedades, renderTo);
        body.appendTo("#table"+propiedades.id);
    }
     
    $.fn.paginate.defaults={
        params:{
            start:0,
            current:0,
            limit:10,
            view:true,
            paginate: true
        }
    }
})(jQuery);