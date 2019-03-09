/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var JpDatePicker = new Class({
    Extends : JpCalendar,
    Implements : [ Options, Events ],
    options : {
        url : null
    },
    initialize : function(element, options) {
        this.parent(element, options);
        this.closerCalendar=true;
        
        this.setOptions(options);        
    },
    selected : function(evt) {
        var seleccionado = evt.target;
        $$(seleccionado.getParent().getSiblings().getChildren("td.number")).removeClass('select');
        seleccionado.addClass('select').getSiblings().removeClass('select');  
        console.info(seleccionado);
        this.closer=true;
        this.render.fireEvent("blur");
        return false;
    },
    drawCalendar : function(calendar) {
        this.parent(calendar);
        // $(this.render).set("readonly",true);
        $(this.render).addEvent("focus",this.openDatePicker.bind(this));
        $$("#tbl-" + this.render.get("id") + " .number").each(function(node, i) {
            node.set("id", "day-" + (i + 1));
            node.addEvent("click", function(evt) {                
                this.selected(evt);                 
                return false;
            }.bind(this));
        }.bind(this));
    },
    openDatePicker:function(e){
        this.calendar.setStyles({
            "position":"absolute",
            "z-index":"1",
            "display":"block",
            "width":"250px",
            "left":$(e.target).offsetLeft+$(e.target).offsetWidth,
            "top":this.render.offsetTop
        });

        this.calendar.addEvent("mouseover",function(){
            this.closerCalendar=false;
            return false;
        }.bind(this));
        
        this.calendar.addEvent("mouseleave",function(){
            this.closerCalendar=true;            
            
            return false;
        }.bind(this));
       
        this.render.addEvent("blur",function(){
            if (this.closer){
                this.calendar.setStyle("display","none");
            }
            return false;
        }.bind(this));    
 
        return false;   
        
    }
    ,
    createCalendar:function(){
        this.parent();
        this.calendar.set("id","cal"+this.render.get("id")); 
        this.calendar.inject(document.body);    
        this.calendar.setStyle("display","none");
    }
})