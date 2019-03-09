/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var JpView= new Class({
    Implements:Options,
    options:{
        url:'',
        width:'1024px',
        data:null,
        select:false,
        type:'funcionario' //consejoc
    },
    initialize:function(elemento,opciones){
        this.elemento=elemento;
        this.setOptions(opciones);
        if (this.options.type=="funcionario")
            this._loadDataFuncionario();
        if (this.options.type=="consejo")
            this._loadDataConsejo();
    },
    _loadDataFuncionario:function(){
        var me=this;
        this.elem= new Element('div',{
            "id":"view-f"
        });
        this.elem.setStyles(
        {
            "width":this.options.width
        },
        {
            "min-width":this.options.width
        }
        );
        var viewIzq= new Element('div',{
            "id":"view-izquierdo-f"
        });
        viewIzq.setStyle('width',"46%");
        var viewDer= new Element('div',{
            "id":"view-derecha-f"
        });
        viewDer.setStyle('width',"455px");
        viewDer.hide(); 
        var ajax= new Request.JSON({
            url:this.options.url,
            onSuccess:function(result){
                me.elem.adopt(viewIzq,viewDer);
                me.elem.inject(me.elemento);                
                result.items.each(function(node,index){                             
                    me._createViewFuncionario(node,index);
                });
            }
        }); 
        me.options.data=ajax.send();
    },
    _loadDataConsejo:function(){
        var me=this;
        this.elem= new Element('div',{
            "id":"view-c"
        });
        this.elem.setStyles(
        {
            "width":this.options.width
        },
        {
            "min-width":this.options.width
        }
        );
        var viewIzq= new Element('div',{
            "id":"view-izquierdo-c"
        });
        viewIzq.setStyle('width',"46%");
        var viewDer= new Element('div',{
            "id":"view-derecha-c"
        });
        viewDer.setStyle('width',"455px");
        viewDer.hide();                        
        var ajax= new Request.JSON({
            url:this.options.url,
            onSuccess:function(result){
                me.elem.adopt(viewIzq,viewDer);
                me.elem.inject(me.elemento);                
                result.items.each(function(node,index){                             
                    me._createViewConsejo(node,index);
                });
            }
        }); 
        me.options.data=ajax.send();
    },
    _createViewFuncionario:function(node,index){
        var cadena='<a href="#">{cargo}</a></span>';      //</br><span>Nombre:{nombresApellidos}          
        var i=cadena.substitute(node);
        var divParent= new Element('div',{
            "id":"list-view-"+index,
            "class":"view-content",
            "html":i
        });
        divParent.inject($("view-izquierdo-f"));
        var me=this;       
        divParent.addEvent('click',function(){
            this.addClass("active").getSiblings().removeClass("active");
            $("view-derecha-f").show();
            $("view-derecha-f").addClass('active');                            
            me._templateViewFuncionario(node);
            return false;
        }); 
        if (this.options.select){
            if (index==0){                
                divParent.fireEvent("click");
            }
        }
    },
    _createViewConsejo:function(node,index){
        var cadena='<a href="#">{nombresApellidos}</a></span>';
        var i=cadena.substitute(node);
        var divParent= new Element('div',{
            "id":"list-view-"+index,
            "class":"view-content",
            "html":i
        });
        divParent.inject($("view-izquierdo-c"));
        var me=this;       
        divParent.addEvent('click',function(){            
            this.addClass("active").getSiblings().removeClass("active");
            $("view-derecha-c").show();
            $("view-derecha-c").addClass('active');                            
            me._templateViewConsejo(node);
            return false;
        }); 
        if (this.options.select){
            if (index==0){                
                divParent.fireEvent("click");
            }
        }
    },
    _templateViewFuncionario:function(node){
        var a=Object.clone(node);
        //a.fechaDesignacion=new Date().parse(node.fechaDesignacion).format("%d/%m/%Y");                       
        $("view-derecha-f").empty();
        var viewHeader= new Element('div',{
            "id":"view-head-f"
        });
        var viewHTitle=new Element('div',{
            "id":"view-htitle-f",
            "html":"<span>Informaci&oacute;n</span>"
        });
        var temp= '<div id="vc-images-f"><img src="./archivos/{foto}" /><a class="button green" href="./archivos/{hojaVida}" target="_blank">Curriculum</a></div><div id="vc-description-f">';
        temp+='<div><label>Nombres y Apellidos:</label><span>{nombresApellidos}</span></div>';
        temp+='<div><label>D.N.I:</label><span>{numeroDni}</span></div>';
        temp+='<div><label>Cargo:</label><span>{cargo}</span></div>';
        temp+='<div><label>Nivel:</label><span>{nivelRemunerativo}</span></div>';
        temp+='<div><label>Designado Por:</label><span>{resolucion}</span></div>';
        temp+='<div><label>Fecha Designaci&oacute;n:</label><span>{fechaDesignacion}</span></div>';
        temp+='<div><label>Tel&eacute;fono:</label><span>{telefono}</span></div>';
        temp+='<div><label>Fax:</label><span>{fax}</span></div>';
        temp+='<div><label>Correo Electr&oacute;nico:</label><span>{eMail}</span></div>';
        temp+='<div><label>R&eacute;gimen Laboral:</label><span>{regimenLaboral}</span></div>';
        temp+='</div>';
        var template=temp.substitute(a);
        var viewContent= new Element('div',{
            "id":"view-content-f",
            "html":template
        });
        viewHTitle.inject(viewHeader);
        viewHeader.inject($("view-derecha-f"));
        viewContent.inject($("view-derecha-f"));        
    } ,
    _templateViewConsejo:function(node){
        var a=Object.clone(node);
        //a.fechaDesignacion=new Date().parse(node.fechaDesignacion).format("%d/%m/%Y");                       
        $("view-derecha-c").empty();
        var viewHeader= new Element('div',{
            "id":"view-head-c"
        });
        var viewHTitle=new Element('div',{
            "id":"view-htitle-c",
            "html":"<span>Informaci&oacute;n</span>"
        });
        var temp= '<div id="vc-images-c"><img src="./archivos/{foto}" /><a class="button green" href="./archivos/{hojaVida}" target="_blank">Curriculum</a></div><div id="vc-description-c">';
        temp+='<div><label>Nombres y Apellidos:</label><span>{nombresApellidos}</span></div>';
        temp+='<div><label>D.N.I:</label><span>{numeroDni}</span></div>';
        temp+='<div><label>Cargo:</label><span>{cargo}</span></div>';
        temp+='<div><label>Representante de Nivel:</label><span>{institucion}</span></div>';
        temp+='<div><label>Designado Por:</label><span>{resolucion}</span></div>';
        temp+='<div><label>Fecha Designaci&oacute;n:</label><span>{fechaDesignacion}</span></div>';
        temp+='<div><label>Tel&eacute;fono:</label><span>{telefono}</span></div>';
        temp+='<div><label>Fax:</label><span>{fax}</span></div>';
        temp+='<div><label>Correo Electr&oacute;nico:</label><span>{eMail}</span></div>';
        temp+='<div><label>R&eacute;gimen Laboral:</label><span>{regimenLaboral}</span></div>';
        temp+='</div>';
        var template=temp.substitute(a);
        var viewContent= new Element('div',{
            "id":"view-content-c",
            "html":template
        });
        viewHTitle.inject(viewHeader);
        viewHeader.inject($("view-derecha-c"));
        viewContent.inject($("view-derecha-c"));        
    }
});

