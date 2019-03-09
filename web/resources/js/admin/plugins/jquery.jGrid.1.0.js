/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
(function($){
    var jGrid;
    $.fn.jGrid=function(options){
        $.extend($.fn.jGrid.defaults,{
            id:$(this).attr("id")
        });
        var opt=$.extend({}, $.fn.jGrid.defaults, options);
        $.fn.jGrid.createGrid(opt);
    }
    $.fn.jGrid.defaults={
        name:'jGrid',
        id:'example',
        defaultColumns:{
            type:'string',
            sort:false
        }
    }
    $.fn.jGrid.loadData=function(options){
        var ul=$("<ul/>",{            
            id:'ul-'+options.name + "-" +options.id,
            "class":"tbody"
        });
        $.ajax({
            url:options.url,
            dataType:'json',
            data:{
                depe_id:1
            },
            success:function(response){
                if (response.items.length>0){
                    var li=$("<li/>");
                    $(response.items).each(function(index,node){
                        for(var i=0;i<options.columns.length;i++){
                            $("<div/>",{
                                html:eval("node."+options.columns[i].name)
                            }).css("display","inline-block").appendTo(li);
                           
                        }                        
                    });
                    li.appendTo(ul);
                }
            }
        })
        $("#"+options.id).append(ul);
    }
    $.fn.jGrid.sortable=function(){        
        var col=$(this).attr("data");
        var sortDirect=1;
        if($(this).is(".sort-asc")){
            sortDirect=-1;
        }
        var filas=$("ul").find("li").get();   
        $(filas).each(function(index,node){
            $(node).data("sortKey",$(node).children("div").eq(col).text().toUpperCase());
                        
        });
        filas.sort(function(a,b){                        
            if($(a).data("sortKey")<$(b).data("sortKey"))return -sortDirect;
            if($(a).data("sortKey")>$(b).data("sortKey"))return sortDirect;                        
            return 0;
        });
        $(filas).each(function(index,nodo){                        
            $("ul").append(nodo);
            $(nodo).removeData('sortKey');
        });                               
        $(this).removeClass("sort-asc").removeClass("sort-desc");
        if(sortDirect==1){
            $(this).addClass("sort-asc");                                
        }else{
            $(this).addClass("sort-desc");
        } 
        return false;
    }
    $.fn.jGrid.createGrid=function(config){
        //aqui creamos el contenedor de la tabla
        jGrid=$("<div/>",{
            id:config.name + "-" +config.id,
            "class":"jGrid ui-widget"
        });
        var columnas=[]
        //aqui creamos la cabecera
        for(var i=0;i<config.columns.length;i++){
            var colSpan=$("<span/>",{
                html:config.columns[i].field,
                "class":"column"
            });
            colSpan.attr("data",i);            
            if (config.columns[i].sort==undefined?config.defaultColumns.sort:config.columns[i].sort){
                colSpan.removeClass("sortable").addClass("sortable");               
                if (colSpan.is(".sortable")){
                    colSpan.on("click",$.fn.jGrid.sortable);
                }
            }           
            columnas.push(colSpan);            
        }   
        $("<div/>",{
            "Class":"theader ui-widget ui-widget-header ui-corner-top"
        }).append(columnas).appendTo(jGrid);        
        //fin de la cabecera  
       
        //aqui insertamos el grid en el html
        $("#"+config.id).append(jGrid);    
        //cargamos la data
        $.fn.jGrid.loadData(config);        
    }
})(jQuery);