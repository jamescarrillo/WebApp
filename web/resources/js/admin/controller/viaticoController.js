
var opt=0,optGrup=0;
    
function eliminarTemp($row){
    $row.remove();
}
function elimarAllTemp($row){
    $row.parent().remove();
}

function changeArchivo(){
    this.abierto=true;
    $("#frmComprasBienes").submit(); 
    return false;
}
function validarCampo(){
    if ($("#archivo").val()==""){
        $("#message2").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Seleccionar un Archivo");
        return false;
    }else if($("#archivo").val().split(".")[$("#archivo").val().split(".").length-1]!="xls"){
        $("#message2").removeClass("ui-state-highlight").addClass("ui-state-error").html("Solo se Puede Cargar Archivos Excel");
        return false;
    }
    return true;
}
function cancelarViatico(){
    var $data = $("#listViaticosx").find("li");
    $("#guardarFilasViatico").button({
        disabled:true
    });
    $("#btnSubir").button({
        disabled:true
    });
    eliminarTemp($data);
    $("#frmViatico").show();
    $("#widget").show();
    $("#frmRegistroViatico").hide();
    return false;
}

function newViatico(){
    $("#frmViatico").hide();
    $("#widget").hide();
    $("#archivo").val("");
    $("#frmRegistroViatico").show();
    $("#btnGuardarOnlyViatico").hide();
    return false;
}

function sortableColumns(list){      
    $(".sortable").on("click",function(){      
        var col=$(this).attr("data");  
        var findOrder= columnType[$(this).attr("type")==undefined?"string":$(this).attr("type")](col);        
        var sortDirect=1;
        if($(this).is(".sort-asc")){
            sortDirect=-1;
        }
        var filas=$("ul#"+list).find("li").get();           
        $(filas).each(function(index,node){                
            $(node).data("sortKey",findOrder($(node).children("div").eq(col)));                        
        });
        filas.sort(function(a,b){                        
            if($(a).data("sortKey")<$(b).data("sortKey"))return -sortDirect;
            if($(a).data("sortKey")>$(b).data("sortKey"))return sortDirect;                        
            return 0;
        });
        $(filas).each(function(index,nodo){                        
            $("ul#"+list).append(nodo);
            $(nodo).removeData('sortKey');
        });                               
        $(this).removeClass("sort-asc").removeClass("sort-desc");
        if(sortDirect==1){
            $(this).addClass("sort-asc");                                
        }else{
            $(this).addClass("sort-desc");
        } 
        return false;
    });
}
columnType={
    "string":function(col){
        $(col).addClass("string");
        return function(cell){
            return cell.text().toUpperCase();
        };
    },
    "numeric":function(col){
        $(col).addClass("numeric");
        return function(cell){
            var key=parseFloat(cell.text());
            return isNaN(key)?0:key;
        };
    },
    "integer":function(col){
        $(col).addClass("integer");
        return function(cell){
            var key=parseInt(cell.text());
            return isNaN(key)?0:key;
        } ;
    },
    "boolean":function(col){
        $(col).addClass("boolean");
        return function(cell){              
            return cell.text();
        }; 
    },
    "date":function(col){
        $(col).addClass("date");
        return function(cell){              
            var key = cell.text();
            return key;
        } 
    }
} 
function createPagination(render, id, frm, index){//creamos el pie
    var pie= $("<div/>",{
        id:id,
        "class":"paginate ui-state-default ui-corner-bottom"
    }).css("margin-top","5px");
    var bInicio=$("<a/>",{
        "id":"binicio"+index,
        "class":"ui-button ui-icon ui-icon-seek-first"
    });
    bInicio.on("click",function(evt){
        evt.preventDefault();
        $("#current"+index).val(0);
        $("#start"+index).val(parseInt($("#current"+index).val())* parseInt($("#limit"+index).val()));
        $("#"+frm).find(".body").html("");
        switch (index){
            case 1:
                loadViaticos($("#"+frm).find(".body"));
                break;
        }
    });
    var bIzquierdo=$("<a/>",{
        "id":"bizq"+index ,
        "class":"ui-button ui-icon ui-icon-seek-prev"                        
    });
    bIzquierdo.on("click",function(evt){
        evt.preventDefault();
        if ($("#current"+index).val()>0){
            $("#current"+index).val(parseInt($("#current"+index).val())-1);
            $("#start"+index).val(parseInt($("#current"+index).val())* parseInt($("#limit"+index).val()));
            $("#"+frm).find(".body").html("");
            switch (index){
                case 1:
                    loadViaticos($("#"+frm).find(".body"));
                    break;
            }
        }
    });
    var page=$("<a/>",{
        "id":"page"+index,
        "class":"ui-button",
        "html":"0"
    });
    var bderecha=$("<a/>",{
        "id":"bder"+index,
        "class":"ui-button ui-icon ui-icon-seek-next"
    });
    bderecha.on("click",function(evt){
        evt.preventDefault();
        if ((parseInt($("#current"+index).val())+1)< parseInt($("#bfinal"+index).attr("rel"))){
            $("#current"+index).val(parseInt($("#current"+index).val())+1);
            $("#start"+index).val(parseInt($("#current"+index).val())* parseInt($("#limit"+index).val()));
            $("#"+frm).find(".body").html("");
            switch (index){
                case 1:
                    loadViaticos($("#"+frm).find(".body"));
                    break;

            }
        }                        
    });
    var bfinal=$("<a/>",{
        "id":"bfinal"+index,
        "class":"ui-button ui-icon ui-icon-seek-end"
    });
    bfinal.on("click",function(evt){
        evt.preventDefault();
        $("#current"+index).val(parseInt($("#bfinal"+index).attr("rel"))-1);
        $("#start"+index).val(parseInt($("#current"+index).val())* parseInt($("#limit"+index).val()));
        $("#"+frm).find(".body").html("");
        switch (index){
            case 1:
                loadViaticos($("#"+frm).find(".body"));
                break;
        }
    });
    var lizq= $('<div/>',{
        "class":"lizq"
    });
    lizq.append(bInicio);
    lizq.append(bIzquierdo);
    lizq.append(page);
    lizq.append(bderecha);
    lizq.append(bfinal);
    var totalItems=$('<label/>',{
        "id":"totalItems"+index,
        "class":"ui-button",
        "html":"Total de Registros : 0"
    });
    var lder=$("<div>",{
        "class":"lder"
    });
    lder.append(totalItems);
    pie.append(lizq);
    pie.append(lder);
    $(pie).insertAfter($(render));
}

function guardarFilasOrden(){
    var tam=$("#listViaticosx li").length;
    var index=0;
    var contg1=tam;
    var op = "true";

    var $data = $("#listViaticosx").find("li")
    $("#guardarFilasViatico").button({
        disabled:true
    });
    var recursivito = function(index, contg1, $data) {
        if(index>=contg1){
            elimarAllTemp($data);
            $("#guardarFilasViatico").button({
                disabled:false
            });
            $("#frmViatico").find(".body").html("");
            loadViaticos($("#frmViatico").find(".body"));
            $("#frmViatico").show();
            $("#widget").show();
            $("#frmRegistroViatico").hide();
            $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").html("Se insertaron nuevos items"); 
            return false;
        }
        var $array,id,mes, anho,  tipoViatico,modalidad,areaOficina,usuarios,fuenteFinanciamiento, fechaSalida, fechaRetorno, ruta, autorizacionViaje, costoPasajes, viaticos;
        $array = $data.eq(index).data("data").split("|");
        id=$array[0];
        anho=$array[1];
        mes=$array[2];
        tipoViatico=$array[3];
        modalidad=$array[4];
        areaOficina=$array[5];
        usuarios=$array[6];
        fuenteFinanciamiento=$array[7];
        fechaSalida=$array[8];
        fechaRetorno = $array[9];
        ruta = $array[10];
        autorizacionViaje = $array[11];
        costoPasajes = $array[12];
        viaticos = $array[13];
        
        index++;
        if(index!=1) op = "false";
        $.ajax({
            type: 'POST',
            url: './GestionTransparente?action=VolcarTemporalViatico',
            data: {
                id:  id,
                mes:  mes,
                anho: anho,
                tipoViatico: tipoViatico,
                modalidad: modalidad,
                areaOficina: areaOficina,
                usuarios: usuarios,
                fuenteFinanciamiento: fuenteFinanciamiento,
                fechaSalida : fechaSalida,
                fechaRetorno : fechaRetorno,
                ruta : ruta,
                autorizacionViaje : autorizacionViaje,
                costoPasajes : costoPasajes,
                viaticos : viaticos
            },
            success: function(){
                $data.eq(parseInt(index-1)).remove();
                recursivito(index, contg1, $data);
            }
        });
                
        return false;
    }
    recursivito( index, contg1, $data); 
    return false;
}

function subirArchivo(){
    if (validarCampo()){
        $.ajax({
            url:'./GestionTransparente?action=ImportarViatico',
            dataType:'json',
            success:function(response){
                $("#guardarFilasViatico").button({
                    disabled:false
                });
                var cont = 0;
                if (response.errors==1){
                    $("#msnError_1").html("Este Formato no Pertenece al Registo de Viaticos: ver un Ejemplo <a href='./archivos/EJEMPLOS/F00018_ejemplo.xls'>Abrir</a>");
                    return 0;
                }
                var a = {};
                $("#frmVerViatico").find(".body").html("");  
                if (response.items.length>0){
                    var ul=$("<ul/>",{
                        id:'listViaticosx'
                    });
                   
                    $("#frmVerViatico").find(".body").append(ul);  
                    $(response.items).each(function(index,node){
                        var divId=$("<div/>",{  
                            id:'idViatico',
                            html:node.id
                        }).css("width","2%");
                        
                        var divArea=$("<div/>",{  
                            id:'areaViatico',
                            html:node.areaOficina
                        }).css("width","14%");
                        var divUsuario=$("<div/>",{
                            id:'usuarioViatico',
                            html: node.usuarios
                        }).css("width","18%");
                        var divSalida=$("<div/>",{
                            id:'financiamientoViatico',
                            html: node.fechaSalida
                        }).css("width","7%");
                        var divRetorno=$("<div/>",{
                            id:'montoViatico',
                            html: node.fechaRetorno
                        }).css("width","7%");
                        var divRuta=$("<div/>",{
                            id:'rutaViatico',
                            html: node.ruta
                        }).css("width","21%");
                    
                        var divPasaje=$("<div/>",{
                            id:'pasajeViatico',
                            html: node.costoPasajes
                        }).css("width","7%");    
                    
                        var divViatico=$("<div/>",{
                            id:'Viatico',
                            html: node.viaticos
                        }).css("width","7%");
                    
                        var divKey=$("<em/>",{
                            "style" : "display:none",
                            html : node.id
                        });
                        
                        var divDel=$("<a/>",{
                            "title":"Eliminar",
                            "class":"ui-button ui-icon ui-icon-trash"                        
                        }).css("width","11px");

                                 
                        var li=$("<li/>").css("cursor","pointer");
                        if (!node.estado){
                            cont++;
                            a[cont]= node.id;
                            $(li).css("color","red");
                        }
                        li.hover(function(){
                            $(this).addClass("ui-state-hover").css("border","none");
                        }, function(){
                            $(this).removeClass("ui-state-hover").css("border","none");
                        });
                        li.click(function(evt){
                            evt.preventDefault();
                            $(this).addClass("selected ui-state-highlight").siblings().removeClass("selected ui-state-highlight");
                        });
                        li.dblclick(function(evt){
                            evt.preventDefault();
                        });
                        li.data("data",node.id+"|"+node.anho+"|"+node.mes+"|"+node.tipoViatico+"|"+node.modalidad+"|"+node.areaOficina+"|"+node.usuarios+"|"+node.fuenteFinanciamiento+"|"+node.fechaSalida+"|"+node.fechaRetorno+"|"+node.ruta+"|"+node.autorizacionViaje+"|"+node.costoPasajes+"|"+node.viaticos);
                        divDel.on("click",function(evt){
                            evt.preventDefault();
                            eliminarTemp(li);
                        });
                        li.append(divId);
                        li.append(divArea);
                        li.append(divUsuario);
                        li.append(divSalida);
                        li.append(divRetorno);
                        li.append(divRuta);
                        li.append(divPasaje);
                        li.append(divViatico);
                        li.append(divDel);
                        ul.append(li);
                    });        
                    if (cont>0) {
                        $("#msnError_1").html("Cargó Con Algunos Errores De Consistencia, <br /> Revise las lineas de color Rojo. en la(s) fila(s): ");
                        for (var i=1; i<cont; i++){
                            $("#msnError_1").html($("#msnError_1").html()+a[i]+", ");
                        }
                        $("#msnError_1").html($("#msnError_1").html()+a[cont]);
                    } else $("#msnError_1").html("");
                }else{
                    $("#frmVerViatico").find(".body").html("<ul><li><div style='color:red;'>No Hay Registros</div></li></ul>");
                }
                $(".totalPiePlanilla").remove();
                var pie= $("<div/>",{
                    "class":"paginate ui-state-default ui-corner-bottom totalPiePlanilla"
                }).css("margin-top","5px");
                
                var totalItems=$('<label/>',{
                    "class":"ui-button",
                    "html":"Total de Registros : " + parseInt(response.items.length - cont) + " Correctos; Mas: " + cont + " Errores"
                });
                
                var lder=$("<div>",{
                    "class":"lder"
                });
                
                lder.append(totalItems);
                pie.append(lder);
                $(pie).insertAfter($("#frmVerViatico"));
            }
        });
    }
    return false;
}

/*******************************************/
/*************Bienes **********************/
/******************************************/
var listaComprasBienes = function(anho, render){
    $.ajax({
        url:'./GestionTransparente?action=ListarViaticosForAdmin&anho='+anho,
        dataType:'json',
        data:{
            query:$("#txtBuscarViatico").val().replace("&","$$"),
            limit:$("#limit1").val(),
            start:$("#start1").val(),
            current:$("#current1").val()
        },
        success:function(response){
            
            $("#frmVerViatico").find(".body").html("");
            
            if (response.items.length>0){
                var ul=$("<ul/>",{
                    id:'listViaticos'
                });
                $(render).html("");
                $(render).append(ul);  
                $(response.items).each(function(index,node){
                    var divArea=$("<div/>",{  
                        id:'areaViatico',
                        html:node.areaOficina
                    }).css("width","15%");
                    var divUsuario=$("<div/>",{
                        id:'usuarioViatico',
                        html: node.usuarios
                    }).css("width","18%");
                    var divSalida=$("<div/>",{
                        id:'financiamientoViatico',
                        html: node.fechaSalida
                    }).css("width","7%");
                    var divRetorno=$("<div/>",{
                        id:'montoViatico',
                        html: node.fechaRetorno
                    }).css("width","7%");
                    var divRuta=$("<div/>",{
                        id:'rutaViatico',
                        html: node.ruta
                    }).css("width","25%");
                    var divPasaje=$("<div/>",{
                        id:'pasajeViatico',
                        html: node.costoPasajes
                    }).css("width","7%");    
                    var divViatico=$("<div/>",{
                        id:'Viatico',
                        html: node.viaticos
                    }).css("width","7%");
                    var divKey=$("<em/>",{
                        "style" : "display:none",
                        html : node.id
                    });
                    var divDel=$("<a/>",{
                        "title":"Eliminar",
                        "class":"ui-button ui-icon ui-icon-trash"                        
                    }).css("width","11px");
                    
                                 
                    var li=$("<li/>").css("cursor","pointer");
                    
                    if (!node.estado){
                        $(li).css("color","red");
                        
                    }
                    
                    li.hover(function(){
                        $(this).addClass("ui-state-hover").css("border","none");
                    }, function(){
                        $(this).removeClass("ui-state-hover").css("border","none");
                    });
                    li.click(function(evt){
                        evt.preventDefault();
                        $(this).addClass("selected ui-state-highlight").siblings().removeClass("selected ui-state-highlight");
                    });
                    li.dblclick(function(evt){
                        evt.preventDefault();
                    });

                    divDel.on("click",function(evt){
                        evt.preventDefault();
                        $(li).trigger("click");
                        $("#btnEliminarViatico").trigger("click");
                    });
                    
                    li.append(divKey);
                    li.append(divArea);
                    li.append(divUsuario);
                    li.append(divSalida);
                    li.append(divRetorno);
                    li.append(divRuta);
                    li.append(divPasaje);
                    li.append(divViatico);
                    li.append(divDel);

                    ul.append(li);      
                }); 
                
                
                if(parseInt( response.total)==0){
                    $("#paginate-ordenCompra").hide();                    
                }else{                    
                    $("#listViaticos").find("li:first").addClass("selected ui-state-highlight");
                    $("#paginate-ordenCompra").show();
                    $("#totalItems1").html(" "+"Total de Registros: "+response.total);
                }
                if(parseInt(response.pagina)==0) $("#page1").html(" 1 de "+Math.ceil(parseInt(response.total)/(parseInt($("#limit1").val()))));
                else $("#page1").html((parseInt(response.pagina)+1) + " de " +(Math.ceil(parseInt(response.total)/(parseInt($("#limit1").val())))));                          
                $("#bfinal1").attr("rel", Math.ceil(parseInt(response.total)/(parseInt($("#limit1").val()))));  
            }else{
                $(render).html("<ul><li><div style='color:red;'>No Hay Registros</div></li></ul>");
            }
        }
    });
}

function loadViaticos(render){
    $.ajax({
        url:'./GestionTransparente?action=ListarAnhosViatico',
        success:function(responseHTML){
            $("#anhosComprasBienes").html(responseHTML);
            listaComprasBienes($("#anhosComprasBienes").val(), render);
        }
    });
}

function validarOnlyViatico(){
    if ($("#txtDni").val() == "") {
        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Ingresar el N&uacute;mero D.N.I");
        return false;
    }else if ($("#txtDni").val().length < 8) {
        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Ingresar correctamente la cantidad de digitos del D.N.I");
        return false;
    }
    else if($("#txtNombre").val()==""){
        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Ingresar el Nombre de la Viatico");
        return false;
    }
    else if($("#txtApellidoPaterno").val()==""){
        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Ingresar el Apellido Paterno de la Viatico");
        return false;
    }
    else if($("#txtApellidoMaterno").val()==""){
        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Ingresar el Apellido Materno de la Viatico");
        return false;
    }
    return true;
}
    
function yesMessage(b){
    if (opt==2){
        $.ajax({
            url:'./GestionTransparente?action='+b.parent().parent().data("action"),
            type : 'GET',
            dataType:'json',
            data:{
                id:b.parent().parent().data("id")
            },
            success:function(response){
                if (response.success){
                    $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg); 
                    $(".eliminarQuestion").removeData("idViatico");
                    $("#"+b.parent().parent().data("frm")).find(".body").html("");
                    switch (b.parent().parent().data("load")){
                        case 1:
                            loadViaticos($("#"+b.parent().parent().data("frm")).find(".body"));
                            break;
                    }
                    $(".eliminarQuestion").dialog("close");
                }
                else {
                    $(".eliminarQuestion").dialog("close");
                    $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html( response.msg);  
                }
            }
        });
    }
}

function delItem($grid, carga, action, frm){
    if($grid.find("li.selected").length>0){
        var select=$grid.find("li.selected"); 
        opt=2;
        $(".msg-html").html("¿ESTAS SEGURO DE ELIMINAR ESTE ITEM?");
        $(".eliminarQuestion").data("id",$(select).find("em").html());
        $(".eliminarQuestion").data("load",carga);
        $(".eliminarQuestion").data("action",action);
        $(".eliminarQuestion").data("frm",frm);
        $(".eliminarQuestion").dialog({
            title:'Mensaje de Confirmaci&oacute;n',
            modal: true,
            show: "blind",
            hide: "explode",
            resizable: false,
            width: 600,
            height: 145
        });
    }
    return false;
}

function init(){
    

    sortableColumns("listViaticos");
    createPagination($("#frmViatico").find(".body"),"paginate-ordenCompra", "frmViatico", 1);
    loadViaticos($("#frmViatico").find(".body"));
        
    /**************************************************************************/
    $("a[href$='"+$("#uri").val()+"']").parent().addClass("ui-state-default");
    $("a[href$='"+$("#uri").val()+"']").removeAttr("href");    
        
    $("#btnSubir").button({
        disabled:true,
        icons:{
            primary:'ui-icon-disk'
        }
    });
    $("#archivo").on("change",changeArchivo);
    $("#btnSubir").on("click",subirArchivo);
    $("#guardarFilasViatico").button({
        disabled:true,
        icons:{
            primary:'ui-icon-disk'
        }
    });
    $("#guardarFilasViatico").on("click",guardarFilasOrden);
    $("#btnCancelarViatico").button({
        icons:{
            primary:'ui-icon-cancel'
        }
    });
    $("#btnCancelarViatico").on("click",cancelarViatico);

    $("#btnNuevoViatico").button({
        icons:{
            primary:'ui-icon-plus'
        }
    });
    $("#btnNuevoViatico").on("click",newViatico);
    $("#btnEliminarViatico").button({
        icons: {
            primary:'ui-icon-trash'
        }
    }).click(function(){
        delItem($("#frmViatico"),1,"EliminarViatico", "frmViatico");
    });
        
    $("#txtBuscarViatico").keypress(function (evt){
        if(evt.keyCode==13){
            $("#current1").val(0);
            $("#start1").val(parseInt($("#current1").val())* parseInt($("#limit1").val()));
            $("#frmViatico").find(".body").html("");
            loadViaticos($("#frmViatico").find(".body"));
        }                    
    });
        
    $("#anhosComprasBienes").bind("change",function(){
        listaComprasBienes($("#anhosComprasBienes").val(),$("#frmViatico").find(".body"));
    });  
        
    $(".siMessage").click(function(){
        yesMessage($(this));
    });
    $(".noMessage").click(function(){
        $(".eliminarQuestion").dialog("close");
    });
    $("body").roles();
    
    
}
    

$("document").ready(function(){
    
    init();
    $("body").roles();
});

