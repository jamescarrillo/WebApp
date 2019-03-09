
var opt=0,optGrup=0;
    
function eliminarTemp($row){
    $row.parent().remove();
}
function elimarAllTemp($row){
    $row.parent().remove();
}

function changeArchivo(){
    this.abierto=true;
    $("#frmPersonalPlanillaFile").submit(); 
    return false;
}
function changeArchivoS(){
    this.abierto=true;
    $("#frmLocadors").submit(); 
    return false;
}

function changeArchivoP(){
    this.abierto=true;
    $("#frmCASs").submit(); 
    return false;
}

function changeArchivoT(){
    this.abierto=true;
    $("#frmCategorias").submit();
    return false;
}
function changeArchivoV(){
    this.abierto=true;
    $("#frmVehiculos").submit();
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

function validarCampoS(){
    if ($("#archivoS").val()==""){
        $("#message3").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Seleccionar un Archivo");
        return false;
    }else if($("#archivoS").val().split(".")[$("#archivoS").val().split(".").length-1]!="xls"){
        $("#message3").removeClass("ui-state-highlight").addClass("ui-state-error").html("Solo se Puede Cargar Archivos Excel");
        return false;
    }
    return true;
}

function validarCampoP(){
    if ($("#archivoP").val()==""){
        $("#message4").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Seleccionar un Archivo");
        return false;
    }else if($("#archivoP").val().split(".")[$("#archivoP").val().split(".").length-1]!="xls"){
        $("#message4").removeClass("ui-state-highlight").addClass("ui-state-error").html("Solo se Puede Cargar Archivos Excel");
        return false;
    }
    return true;
}

function validarCampoT(){
    if ($("#archivoT").val()==""){
        $("#message5").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Seleccionar un Archivo");
        return false;
    }else if($("#archivoT").val().split(".")[$("#archivoT").val().split(".").length-1]!="xls"){
        $("#message5").removeClass("ui-state-highlight").addClass("ui-state-error").html("Solo se Puede Cargar Archivos Excel");
        return false;
    }
    return true;
}

function validarCampoV(){
    if ($("#archivoV").val()==""){
        $("#message6").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Seleccionar un Archivo");
        return false;
    }else if($("#archivoV").val().split(".")[$("#archivoV").val().split(".").length-1]!="xls"){
        $("#message6").removeClass("ui-state-highlight").addClass("ui-state-error").html("Solo se Puede Cargar Archivos Excel");
        return false;
    }
    return true;
}

function validarCampoPr(){
    if ($("#archivoPr").val()==""){
        $("#message7").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Seleccionar un Archivo");
        return false;
    }else if($("#archivoPr").val().split(".")[$("#archivoPr").val().split(".").length-1]!="xls"){
        $("#message7").removeClass("ui-state-highlight").addClass("ui-state-error").html("Solo se Puede Cargar Archivos Excel");
        return false;
    }
    return true;
}
function cancelarPersonalPlanilla(){
    var $data = $("#listPersonalPlanillasx").find("li");
    $("#guardarFilasPersonalPlanilla").button({
        disabled:true
    });
    $("#btnSubir").button({
        disabled:true
    });
    eliminarTemp($data);
    $("#frmPersonalPlanilla").show();
    $("#widget").show();
    $("#frmRegistroPersonalPlanilla").hide();
    return false;
}

/*********locador *//////
function cancelarLocador(){
    var $data = $("#listLocadorx").find("li");
    $("#guardarLocador").button({
        disabled:true
    });
    $("#btnSubirS").button({
        disabled:true
    });
    eliminarTemp($data);
    $("#frmLocador").show();
    $("#widgetS").show();
    $("#frmRegistroLocador").hide();
    return false;
}
/*********publicidad *//////
function cancelarCAS(){
    var $data = $("#listCASx").find("li");
    $("#guardarCAS").button({
        disabled:true
    });
    $("#btnSubirP").button({
        disabled:true
    });
    eliminarTemp($data);
    $("#frmCAS").show();
    $("#widgetP").show();
    $("#frmRegistroCAS").hide();
    return false;
}
/*********publicidad *//////
function cancelarCategoria(){
    var $data = $("#listCategoriax").find("li");
    $("#guardarCategoria").button({
        disabled:true
    });
    $("#btnSubirT").button({
        disabled:true
    });
    eliminarTemp($data);
    $("#frmCategoria").show();
    $("#widgetT").show();
    $("#frmRegistroCategoria").hide();
    return false;
}
function cancelarVehiculo(){
    var $data = $("#listVehiculox").find("li");
    $("#guardarVehiculo").button({
        disabled:true
    });
    $("#btnSubirV").button({
        disabled:true
    });
    eliminarTemp($data);
    $("#frmVehiculo").show();
    $("#widgetV").show();
    $("#frmRegistroVehiculo").hide();
    return false;
}

function newPersonalPlanilla(){
    $("#frmPersonalPlanilla").hide();
    $("#widget").hide();
    $("#archivo").val("");
    $("#frmRegistroPersonalPlanilla").show();
    $("#btnGuardarOnlyPersonalPlanilla").hide();
    $("#frmVerPersonalPlanilla").find(".body").find("ul").remove();
    return false;
}

function newLocador(){
    $("#frmLocador").hide();
    $("#widgetS").hide();
    $("#archivoS").val("");
    $("#frmRegistroLocador").show();
    $("#btnGuardarOnlyLocador").hide();
    return false;
}

function newCAS(){
    $("#frmCAS").hide();
    $("#widgetP").hide();
    $("#archivoP").val("");
    $("#frmRegistroCAS").show();
    $("#btnGuardarOnlyCAS").hide();
    return false;
}

function newCategoria(){
    $("#frmCategoria").hide();
    $("#widgetT").hide();
    $("#archivoT").val("");
    $("#frmRegistroCategoria").show();
    $("#btnGuardarOnlyCategoria").hide();
    return false;
}

function newVehiculo(){
    $("#frmVehiculo").hide();
    $("#widgetV").hide();
    $("#archivoV").val("");
    $("#frmRegistroVehiculo").show();
    $("#btnGuardarOnlyVehiculo").hide();
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
                loadPersonalPlanillas($("#"+frm).find(".body"));
                break;
            case 2 :
                loadLocadors($("#"+frm).find(".body"));
                break;
            case 3 :
                loadCAS($("#"+frm).find(".body"));
                break;   
            case 4 :
                loadCategoria($("#"+frm).find(".body"));
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
                    loadPersonalPlanillas($("#"+frm).find(".body"));
                    break;
                case 2 :
                    loadLocadors($("#"+frm).find(".body"));
                    break;
                case 3 :
                    loadCAS($("#"+frm).find(".body"));
                    break; 
                case 4 :
                    loadCategoria($("#"+frm).find(".body"));
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
                    loadPersonalPlanillas($("#"+frm).find(".body"));
                    break;
                case 2 :
                    loadLocadors($("#"+frm).find(".body"));
                    break;
                case 3 :
                    loadCAS($("#"+frm).find(".body"));
                    break; 
                case 4 :
                    loadCategoria($("#"+frm).find(".body"));
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
                loadPersonalPlanillas($("#"+frm).find(".body"));
                break;
            case 2 :
                loadLocadors($("#"+frm).find(".body"));
                break;
            case 3 :
                loadCAS($("#"+frm).find(".body"));
                break; 
            case 4 :
                loadCategoria($("#"+frm).find(".body"));
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

function guardarFilasPlanilla(){
    var tam=$("#listPersonalPlanillasx li").length;
    var index=0;
    var contg1=tam;
    var op = "true";

    var $data = $("#listPersonalPlanillasx").find("li")
    $("#guardarFilasPersonalPlanilla").button({
        disabled:true
    });
    var recursivito = function(index, contg1, $data) {
        if(index>=contg1){
            elimarAllTemp($data);
            $("#guardarFilasPersonalPlanilla").button({
                disabled:false
            });
            $("#frmPersonalPlanilla").find(".body").html("");
            loadPersonalPlanillas($("#frmPersonalPlanilla").find(".body"));
            $("#frmPersonalPlanilla").show();
            $("#widget").show();
            $("#frmRegistroPersonalPlanilla").hide();
            $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").html("Se insertaron nuevos items"); 
            return false;
        }
        
        var $array = $data.eq(index).data("data").split("|");
       
        index++;
        if(index!=1) op = "false";
        $.ajax({
            type: 'POST',
            cache: false,
            url: './GestionTransparente?action=VolcarTemporalPersonal',
            data: {
                id:  $array[0],  
                anho: $array[1], 
                trimestre: $array[2], 
                apellidosNombres: $array[3], 
                cargo: $array[4], 
                codigoFormato: $array[5],
                pension: $array[6],
                financiamiento : $array[7],
                fechaIngreso : $array[8],
                fechaCede : $array[9],
                numeroDni : $array[10],
                codigoCivil : $array[11],
                oficinaArea : $array[12],
                remuneracionMensual : $array[13],
                beneficios : $array[14],
                ingresoTotal : $array[15],
                tipo : $array[16],
                categoria : $array[17],
                observacion : $array[18],
                bonificacionQuinqu : $array[19]
            },
            success: function(){
                $data.eq(parseInt(index-1)).remove();
                recursivito(index, contg1, $data)
            }
        });
                
        return false;
    }
    recursivito( index, contg1, $data); 
    return false;
}

//***************************************/
function guardarFilasLocador(){
    var tam=$("#listLocadorx li").length;
    var index=0;
    var contg1=tam;
    var op = "true";

    var $data = $("#listLocadorx").find("li")
    $("#guardarFilasLocador").button({
        disabled:true
    });
    var recursivito = function(index, contg1, $data) {
        if(index>=contg1){
            elimarAllTemp($data);
            $("#guardarFilasLocador").button({
                disabled:false
            });
            $("#frmLocador").find(".body").html("");
            loadLocadors($("#frmLocador").find(".body"));
            $("#frmLocador").show();
            $("#widgetS").show();
            $("#frmRegistroLocador").hide();
            $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").html("Se insertaron nuevos items"); 
            return false;
        }
        var $array = $data.eq(index).data("data").split("|");
        
        index++;
        if(index!=1) op = "false";
        $.ajax({
            type: 'POST',
            url: './GestionTransparente?action=VolcarTemporalPersonal',
            data: {
                id:  $array[0],  
                anho: $array[1], 
                trimestre: $array[2], 
                apellidosNombres: $array[3], 
                cargo: $array[4], 
                codigoFormato: $array[5],
                pension: $array[6],
                financiamiento : $array[7],
                fechaIngreso : $array[8],
                fechaCede : $array[9],
                numeroDni : $array[10],
                codigoCivil : $array[11],
                oficinaArea : $array[12],
                remuneracionMensual : $array[13],
                beneficios : $array[14],
                ingresoTotal : $array[15],
                tipo : $array[16],
                categoria : $array[17],
                observacion: $array[18]
            },
            success: function(){
                $data.eq(parseInt(index-1)).remove();
                recursivito(index, contg1, $data)
            }
        });
        return false;
    }
    recursivito( index, contg1, $data); 
    return false;
}

//***************************/
function guardarFilasCAS(){
    var tam=$("#listCASx li").length;
    var index=0;
    var contg1=tam;
    var op = "true";

    var $data = $("#listCASx").find("li")
    $("#guardarFilasCAS").button({
        disabled:true
    });
    var recursivito = function(index, contg1, $data) {
        if(index>=contg1){
            elimarAllTemp($data);
            $("#guardarFilasCAS").button({
                disabled:false
            });
            $("#frmCAS").find(".body").html("");
            loadCAS($("#frmCAS").find(".body"));
            $("#frmCAS").show();
            $("#widgetP").show();
            $("#frmRegistroCAS").hide();
            $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").html("Se insertaron nuevos items"); 
            return false;
        }
        var $array = $data.eq(index).data("data").split("|");
       
        index++;
        if(index!=1) op = "false";
        $.ajax({
            type: 'POST',
            url: './GestionTransparente?action=VolcarTemporalPersonal',
            data: {
                id:  $array[0],  
                anho: $array[1], 
                trimestre: $array[2], 
                apellidosNombres: $array[3], 
                cargo: $array[4], 
                codigoFormato: $array[5],
                pension: $array[6],
                financiamiento : $array[7],
                fechaIngreso : $array[8],
                fechaCede : $array[9],
                numeroDni : $array[10],
                codigoCivil : $array[11],
                oficinaArea : $array[12],
                remuneracionMensual : $array[13],
                beneficios : $array[14],
                ingresoTotal : $array[15],
                tipo : $array[16],
                categoria : $array[17],
                observacion : $array[18]
            },
            success: function(){
                $data.eq(parseInt(index-1)).remove();
                recursivito(index, contg1, $data)
            }
        });
        return false;
    }
    recursivito( index, contg1, $data); 
    return false;
}

//***************************/
function guardarFilasCategoria(){
    var tam=$("#listCategoriax li").length;
    var index=0;
    var contg1=tam;
    var op = "true";

    var $data = $("#listCategoriax").find("li")
    $("#guardarFilasCategoria").button({
        disabled:true
    });
    var recursivito = function(index, contg1, $data) {
        if(index>=contg1){
            elimarAllTemp($data);
            $("#guardarFilasCategoria").button({
                disabled:false
            });
            $("#frmCategoria").find(".body").html("");
            loadCategoria($("#frmCategoria").find(".body"));
            $("#frmCategoria").show();
            $("#widgetT").show();
            $("#frmRegistroCategoria").hide();
            $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").html("Se insertaron nuevos items"); 
            return false;
        }
        
        var $array = $data.eq(index).data("data").split("|");
        
        index++;
        if(index!=1) op = "false";
        $.ajax({
            type: 'POST',
            url: './GestionTransparente?action=VolcarTemporalPersonalCategoria',
            data: {
                anho: $array[1], 
                trimestre: $array[2], 
                codigo: $array[3], 
                categoria: $array[4], 
                remuneracionMinimo: $array[5], 
                remuneracionMaximo : $array[6],
                numeroTrabajadores : $array[7]
            },
            success: function(){
                $data.eq(parseInt(index-1)).remove();
                recursivito(index, contg1, $data)
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
            url:'./GestionTransparente?action=ImportarPersonalPlanilla',
            cache: false,
            dataType:'json',
            success:function(response){
                $("#guardarFilasPersonalPlanilla").button({
                    disabled:false
                });
                var cont = 0;
                if (response.errors==1){
                    $("#msnError_1").html("Este Formato no Pertenece al Registo de Personal en Planilla: ver un Ejemplo <a href='./archivos/EJEMPLOS/planilla_ejemplo.xls'>Abrir</a>");
                    return 0;
                }
                
                var a = {};
                $("#frmVerPersonalPlanilla").find(".body").html("");
                if (response.items.length>0){
                    var ul=$("<ul/>",{
                        id:'listPersonalPlanillasx'
                    });
                    eliminarTemp($("#frmVerPersonalPlanilla").find(".body").find("ul").find("li"));
                    $("#frmVerPersonalPlanilla").find(".body").append(ul);
                    
                    $(response.items).each(function(index,node){
                        var divId=$("<div/>",{
                            id:'idPersonalPlanilla',
                            html:node.id
                        }).css({
                            "width":"2%"
                        });
                        var divPersonal=$("<div/>",{
                            id:'nombrePersonalPlanilla',
                            html:node.apellidosNombres
                        }).css("width","19%");
                        var divDni=$("<div/>",{
                            id:'dniPersonalPlanilla',
                            html:node.numeroDni
                        }).css("width","10%");
                        var divTrimestre=$("<div/>",{
                            id:'trimestrePersonalPlanilla',
                            html: node.trimestre
                        }).css("width","8%");
                        var divCategoria=$("<div/>",{
                            id:'categoria',
                            html: node.categoria
                        }).css("width","8%");
                        var divCargo=$("<div/>",{
                            id:'cargo',
                            html: node.cargo
                        }).css("width","20%");

                        var divRegimen=$("<div/>",{
                            id:'cargo',
                            html: node.codigoCivil
                        }).css("width","10%");
                        
                        var divTotal=$("<div/>",{
                            id:'total',
                            html: node.ingresoTotal
                        }).css("width","8%");
                        
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
                        
                        li.data("data",node.id+"|"+node.anho+"|"+node.trimestre+"|"+node.apellidosNombres+"|"+node.cargo+"|"+node.codigoFormato+"|"+node.pension+"|"+node.financiamiento+"|"+node.fechaIngreso+"|"+node.fechaCede+"|"+node.numeroDni+"|"+node.codigoCivil+"|"+node.oficinaArea+"|"+node.remuneracionMensual+"|"+node.beneficios+"|"+node.ingresoTotal+"|"+node.tipo+"|"+node.categoria+"|"+node.observacion+"|"+node.bonificacionQuinqu);
                        divDel.on("click",function(evt){
                            evt.preventDefault();
                            eliminarTemp(li);
                        });
                        
                        li.append(divId);
                        li.append(divPersonal);
                        li.append(divDni);
                        li.append(divTrimestre);
                        li.append(divCategoria);
                        li.append(divCargo);
                        li.append(divRegimen);
                        li.append(divTotal);
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
                    $("#frmVerPersonalPlanilla").find(".body").html("<ul><li><div style='color:red;'>No Hay Registros</div></li></ul>");
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
                $(pie).insertAfter($("#frmVerPersonalPlanilla"));
            }
        });
    }
    return false;
}

/***********locador**************************/
function subirArchivoS(){
    if (validarCampoS()){
        $.ajax({
            url:'./GestionTransparente?action=ImportarPersonalLocador',
            dataType:'json',
            success:function(response){
                $("#guardarFilasLocador").button({
                    disabled:false
                });
                var a={};
                cont=0;
                
                if (response.items.length>0){
                    var ul=$("<ul/>",{
                        id:'listLocadorx'
                    });
                    var cont=0;
                    if (response.errors==1){
                        $("#msnError_2").html("Este Formato no Pertenece al Registo de Locadores de Servicio: ver un Ejemplo <a href='./archivos/EJEMPLOS/locador_ejemplo.xls'>Abrir</a>");
                        return 0;
                    }
                
                    $("#frmVerLocador").find(".body").append(ul);  
                    $(response.items).each(function(index,node){
                        
                        var divId=$("<div/>",{
                            id:'idPersonalPlanilla',
                            html:node.id
                        }).css({
                            "width":"2%"
                        });
                    
                        var divPersonal=$("<div/>",{  
                            id:'nombrePersonalPlanilla',
                            html:node.apellidosNombres
                        }).css("width","19%");
                    
                        var divTrimestre=$("<div/>",{
                            id:'trimestrePersonalPlanilla',
                            html: node.trimestre
                        }).css("width","8%");
                    
                        var divDependencia=$("<div/>",{
                            id:'dependencia',
                            html: node.oficinaArea
                        }).css("width","18%");
                    
                        var divRegimen=$("<div/>",{
                            id:'cargo',
                            html: node.codigoCivil
                        }).css("width","10%");
                        
                        var divDel=$("<a/>",{
                            "title":"Eliminar",
                            "class":"ui-button ui-icon ui-icon-trash"                        
                        }).css("width","11px");
                        var divDni = $("<div/>",{
                            html: node.numeroDni
                        }).css("width","9%");
                        var divTotal=$("<div/>",{
                            html: node.ingresoTotal
                        }).css("width","10%");
                        var divFechaIngreso = $("<div/>",{
                            html: node.fechaIngreso
                        }).css("width","10%");
                    
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
                        
                        li.data("data",node.id+"|"+node.anho+"|"+node.trimestre+"|"+node.apellidosNombres+"|"+node.cargo+"|"+node.codigoFormato+"|"+node.pension+"|"+node.financiamiento+"|"+node.fechaIngreso+"|"+node.fechaCede+"|"+node.numeroDni+"|"+node.codigoCivil+"|"+node.oficinaArea+"|"+node.remuneracionMensual+"|"+node.beneficios+"|"+node.ingresoTotal+"|"+node.tipo+"|"+node.categoria+"|"+node.observacion);
                        divDel.on("click",function(evt){
                            evt.preventDefault();
                            eliminarTemp(li);
                        });
                        
                        li.append(divId);
                        li.append(divPersonal);
                        li.append(divDni);
                        li.append(divFechaIngreso);
                        li.append(divTrimestre);
                        li.append(divDependencia);
                        li.append(divRegimen);
                        li.append(divTotal);
                        li.append(divDel);
                        ul.append(li);
                    });
                    if (cont>0) {
                        $("#msnError_2").html("Cargó Con Algunos Errores De Consistencia, <br /> Revise las lineas de color Rojo. en la(s) fila(s): ");
                        for (var i=1; i<cont; i++){
                            $("#msnError_2").html($("#msnError_2").html()+a[i]+", ");
                        }
                        $("#msnError_2").html($("#msnError_2").html()+a[cont]);
                    } else $("#msnError_2").html("");
                }else{
                    $("#frmVerLocador").find(".body").html("<ul><li><div style='color:red;'>No Hay Registros</div></li></ul>");
                }
                
                $(".totalPieLocador").remove();
                var pie= $("<div/>",{
                    "class":"paginate ui-state-default ui-corner-bottom totalPieLocador"
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
                $(pie).insertAfter($("#frmVerLocador"));
            }
        });
    }
    return false;
}

/***********CAS**************************/
function subirArchivoP(){
    if (validarCampoP()){
        $.ajax({
            url:'./GestionTransparente?action=ImportarPersonalCAS',
            dataType:'json',
            success:function(response){
                $("#guardarFilasCAS").button({
                    disabled:false
                });
                var a={};
                cont=0;
                if (response.errors==1){
                    $("#msnError_3").html("Este Formato no Pertenece al Registo de CAS: ver un Ejemplo <a href='./archivos/EJEMPLOS/locador_ejemplo.xls'>Abrir</a>");
                    return 0;
                }
                if (response.items.length>0){
                    var ul=$("<ul/>",{
                        id:'listCASx'
                    });
                    $("#frmVerCAS").find(".body").append(ul);
                    var cont = 0;
                    $(response.items).each(function(index,node){
                        var divId=$("<div/>",{
                            id:'idPersonalPlanilla',
                            html:node.id
                        }).css({
                            "width":"2%"
                            
                        });
                    
                        var divPersonal=$("<div/>",{  
                            id:'nombrePersonalPlanilla',
                            html:node.apellidosNombres
                        }).css("width","19%");
                    
                        var divTrimestre=$("<div/>",{
                            id:'trimestrePersonalPlanilla',
                            html: node.trimestre
                        }).css("width","8%");
                    
                        var divDependencia=$("<div/>",{
                            id:'dependencia',
                            html: node.oficinaArea
                        }).css("width","18%");
                    
                        var divRegimen=$("<div/>",{
                            id:'cargo',
                            html: node.codigoCivil
                        }).css("width","10%");
                        
                        var divDel=$("<a/>",{
                            "title":"Eliminar",
                            "class":"ui-button ui-icon ui-icon-trash"                        
                        }).css("width","11px");
                        var divDni = $("<div/>",{
                            html: node.numeroDni
                        }).css("width","9%");
                        var divTotal=$("<div/>",{
                            html: node.ingresoTotal
                        }).css("width","10%");
                        var divFechaIngreso = $("<div/>",{
                            html: node.fechaIngreso
                        }).css("width","10%");
                    
                        
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
                        
                        li.data("data",node.id+"|"+node.anho+"|"+node.trimestre+"|"+node.apellidosNombres+"|"+node.cargo+"|"+node.codigoFormato+"|"+node.pension+"|"+node.financiamiento+"|"+node.fechaIngreso+"|"+node.fechaCede+"|"+node.numeroDni+"|"+node.codigoCivil+"|"+node.oficinaArea+"|"+node.remuneracionMensual+"|"+node.beneficios+"|"+node.ingresoTotal+"|"+node.tipo+"|"+node.categoria+"|"+node.observacion);
                        divDel.on("click",function(evt){
                            evt.preventDefault();
                            eliminarTemp(li);
                        });
                        
                        li.append(divId);
                        li.append(divPersonal);
                        li.append(divDni);
                        li.append(divFechaIngreso);
                        li.append(divTrimestre);
                        li.append(divDependencia);
                        li.append(divRegimen);
                        li.append(divTotal);
                        li.append(divDel);
                        ul.append(li);
                    });                
                    if (cont>0) {
                        $("#msnError_3").html("Cargó Con Algunos Errores De Consistencia, <br /> Revise las lineas de color Rojo. en la(s) fila(s): ");
                        for (var i=1; i<cont; i++){
                            $("#msnError_3").html($("#msnError_3").html()+a[i]+", ");
                        }
                        $("#msnError_3").html($("#msnError_3").html()+a[cont]);
                    } else $("#msnError_3").html("");
                }else{
                    $("#frmVerCAS").find(".body").html("<ul><li><div style='color:red;'>No Hay Registros</div></li></ul>");
                }
                
                $(".totalPieCAS").remove();
                var pie= $("<div/>",{
                    "class":"paginate ui-state-default ui-corner-bottom totalPieCAS"
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
                $(pie).insertAfter($("#frmVerCAS"));
            }
        });
    }
    return false;
}


/***********Categoria**************************/
function subirArchivoT(){
    if (validarCampoT()){
        $.ajax({
            url:'./GestionTransparente?action=ImportarPersonalCategoria',
            dataType:'json',
            success:function(response){
                $("#guardarFilasCategoria").button({
                    disabled:false
                });
                var cont=0;
                if (response.errors==1){
                    $("#msnError_4").html("Este Formato no Pertenece al Registo de Categorias: ver un Ejemplo <a href='./archivos/EJEMPLOS/F00009_ejemplo.xls'>Abrir</a>");
                    return 0;
                }
                var a = {};
                if (response.items.length>0){
                    var ul=$("<ul/>",{
                        id:'listCategoriax'
                    });
                    $("#frmVerCategoria").find(".body").append(ul);  
                    $(response.items).each(function(index,node){
                        var divId=$("<div/>",{
                            html:node.id
                        }).css({
                            "width":"2%"
                            
                        });
                        
                        var divCodigo=$("<div/>",{
                            id:'codigoCategoria',
                            html: node.codigo
                        }).css("width","10%");
                        
                        var divTrimestres=$("<div/>",{  
                            html:node.trimestre
                        }).css("width","10%");
                        
                        var divCategoria=$("<div/>",{
                            html:node.categoria
                        }).css("width","17%");
                        
                        var divMinimo=$("<div/>",{
                            html: node.remuneracionMinima
                        }).css("width","15%");
                        
                        var divMaximo=$("<div/>",{
                            html: node.remuneracionMaxima
                        }).css("width","15%");
                        
                        var divNro=$("<div/>",{
                            html: node.numeroTrabajadores
                        }).css("width","15%");

                                 
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
                        var divDel=$("<a/>",{
                            "title":"Eliminar",
                            "class":"ui-button ui-icon ui-icon-trash"                        
                        }).css("width","11px");
                        
                        li.data("data",node.id+"|"+node.anho+"|"+node.trimestre+"|"+node.codigo+"|"+node.categoria+"|"+node.remuneracionMinima+"|"+node.remuneracionMaxima+"|"+node.numeroTrabajadores);
                        
                        divDel.on("click",function(evt){
                            evt.preventDefault();
                            eliminarTemp(li);
                        });
                        li.append(divId);
                        li.append(divCodigo);
                        li.append(divTrimestres);
                        li.append(divCategoria);
                        li.append(divMinimo);
                        li.append(divMaximo);
                        li.append(divNro);

                        li.append(divDel);
                        
                        ul.append(li);
                    });               
                    if (cont>0) {
                        $("#msnError_4").html("Cargó Con Algunos Errores De Consistencia, <br /> Revise las lineas de color Rojo. en la(s) fila(s): ");
                        for (var i=1; i<cont; i++){
                            $("#msnError_4").html($("#msnError_4").html()+a[i]+", ");
                        }
                        $("#msnError_4").html($("#msnError_4").html()+a[cont]);
                    } else $("#msnError_4").html("");
                }else{
                    $("#frmVerCategoria").find(".body").html("<ul><li><div style='color:red;'>No Hay Registros</div></li></ul>");
                }
                
                $(".totalPieCategoria").remove();
                var pie= $("<div/>",{
                    "class":"paginate ui-state-default ui-corner-bottom totalPieCategoria"
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
                $(pie).insertAfter($("#frmVerCategoria"));
            }
        });
    }
    return false;
}



/*******************************************/
/*************Personal**********************/
/******************************************/
var listaPersonalPlanilla = function(anho, render){
    $.ajax({
        url:'./GestionTransparente?action=ListarPersonalForAdmin&anho='+anho,
        dataType:'json',
        cache:false,
        data:{
            query:$("#txtBuscarPersonalPlanilla").val().replace("&","$$"),
            limit:$("#limit1").val(),
            start:$("#start1").val(),
            current:$("#current1").val(),
            tipo: 1
        },
        success:function(response){
            if (response.items.length>0){
                var ul=$("<ul/>",{
                    id:'listPersonalPlanillas'
                });
                
                $(render).html("");
                $(render).append(ul);  
                
                $(response.items).each(function(index,node){
                    
                    var divId=$("<em/>",{
                        id:'idPersonalPlanilla',
                        html:node.id
                    }).css({
                        "width":"0%", 
                        "display":"none"
                    });
                    
                    var divPersonal=$("<div/>",{  
                        id:'nombrePersonalPlanilla',
                        html:node.apellidosNombres
                    }).css("width","20%");
                    var divDni=$("<div/>",{  
                        id:'dniPersonalPlanilla',
                        html:node.numeroDni
                    }).css("width","10%");
                    var divTrimestre=$("<div/>",{
                        id:'trimestrePersonalPlanilla',
                        html: node.trimestre
                    }).css("width","8%");
                    
                    var divCategoria=$("<div/>",{
                        id:'categoria',
                        html: node.categoria
                    }).css("width","8%");
                    
                    var divCargo=$("<div/>",{
                        id:'cargo',
                        html: node.cargo
                    }).css("width","20%");

                    var divRegimen=$("<div/>",{
                        id:'cargo',
                        html: node.codigoCivil
                    }).css("width","10%");
                    
                    var divTotal=$("<div/>",{
                        id:'total',
                        html: node.ingresoTotal
                    }).css("width","10%");
                    
                    var divDel=$("<a/>",{
                        "title":"Eliminar",
                        "class":"ui-button ui-icon ui-icon-trash"                        
                    }).css("width","11px");
                    
            
                    var divEstado=$("<a/>",{
                        "title":node.estado?"Activo":"Desactivado",
                        "class":node.estado?"ui-button ui-icon ui-icon-circle-arrow-n":"ui-button ui-icon ui-icon-circle-arrow-s"
                    }).css("width","12px");
                                 
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
                        $("#btnEliminarPersonalPlanilla").trigger("click");
                    });
                    
                    li.append(divId);
                    li.append(divPersonal);
                    li.append(divDni);
                    li.append(divTrimestre);
                    li.append(divCategoria);
                    li.append(divCargo);
                    li.append(divRegimen);
                    li.append(divTotal);
                    li.append(divDel);
                    //li.append(divEstado);
                    ul.append(li);      
                });                
                if(parseInt( response.total)==0){
                    $("#paginate-personalPLan").hide();                    
                }else{                    
                    $("#listPersonalPlanillas").find("li:first").addClass("selected ui-state-highlight");
                    $("#paginate-personalPLan").show();
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
function loadPersonalPlanillas(render){
    $.ajax({
        url:'./GestionTransparente?action=ListarAnhosPersonalPlanilla&tipo=1',
        success:function(responseHTML){
            $("#anhosPersonalPlanilla").html(responseHTML);
            listaPersonalPlanilla($("#anhosPersonalPlanilla").val(), render);
        }
    });
}

/*******************************************/
/*************Locadors********************/
/******************************************/
var  listaLocadors = function(anho, render){
    $.ajax({
        url:'./GestionTransparente?action=ListarPersonalForAdmin&anho='+anho,
        dataType:'json',
        data:{
            query:$("#txtBuscarLocador").val().replace("&","$$"),
            limit:$("#limit2").val(),
            start:$("#start2").val(),
            current:$("#current2").val(),
            tipo: 2
        },
        success:function(response){
            if (response.items.length>0){
                var ul=$("<ul/>",{
                    id:'listLocador'
                });
                $(render).html("");
                $(render).append(ul);  
                $(response.items).each(function(index,node){
                    var divId=$("<em/>",{
                        id:'idPersonalLocador',
                        html:node.id
                    }).css({
                        "width":"0%", 
                        "display":"none"
                    });
                    
                    var divPersonal=$("<div/>",{  
                        id:'nombrePersonalLocador',
                        html:node.apellidosNombres
                    }).css("width","20%");
                    
                    var divTrimestre=$("<div/>",{
                        id:'trimestrePersonalLocador',
                        html: node.trimestre
                    }).css("width","8%");
                    
                    var divDni = $("<div/>",{
                        html: node.numeroDni
                    }).css("width","9%");
                    var divTotal=$("<div/>",{
                        html: node.ingresoTotal
                    }).css("width","10%");
                    var divFechaIngreso = $("<div/>",{
                        html: node.fechaIngreso
                    }).css("width","10%");
                    
                    var divDependencia=$("<div/>",{
                        id:'dependencia',
                        html: node.oficinaArea
                    }).css("width","19%");
                    
                    var divRegimen=$("<div/>",{
                        id:'cargo',
                        html: node.codigoCivil
                    }).css("width","10%");
                    
                    var divDel=$("<a/>",{
                        "title":"Eliminar",
                        "class":"ui-button ui-icon ui-icon-trash"                        
                    }).css("width","11px");
                    
           
                    
                    var divEstado=$("<a/>",{
                        "title":node.estado?"Activo":"Desactivado",
                        "class":node.estado?"ui-button ui-icon ui-icon-circle-arrow-n":"ui-button ui-icon ui-icon-circle-arrow-s"
                    }).css("width","12px");
                                 
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
                        $("#btnEliminarLocador").trigger("click");
                    });
                    
                    li.append(divId);
                    li.append(divPersonal);
                    li.append(divDni);
                    li.append(divFechaIngreso)
                    li.append(divTrimestre);
                    li.append(divDependencia);
                    li.append(divRegimen);
                    li.append(divTotal);
                    li.append(divDel);
                    //li.append(divEstado);
                    ul.append(li);    
                });                
                if(parseInt( response.total)==0){
                    $("#paginate-locador").hide();             
                }else{
                    $("#listLocador").find("li:first").addClass("selected ui-state-highlight");
                    $("#paginate-locador").show();
                    $("#totalItems2").html(" "+"Total de Registros: "+response.total);
                }
                if(parseInt(response.pagina)==0) $("#page2").html(" 1 de "+Math.ceil(parseInt(response.total)/(parseInt($("#limit2").val()))));
                else $("#page2").html((parseInt(response.pagina)+1) + " de " +(Math.ceil(parseInt(response.total)/(parseInt($("#limit2").val())))));                          
                $("#bfinal2").attr("rel", Math.ceil(parseInt(response.total)/(parseInt($("#limit2").val()))));
            }
            else{
                $(render).html("<ul><li><div style='color:red;'>No Hay Registros</div></li></ul>");
            }
        }
    });
}

function loadLocadors(render){
    $.ajax({
        url:'./GestionTransparente?action=ListarAnhosPersonalPlanilla&tipo=2',
        success:function(responseHTML){
            $("#anhosLocador").html(responseHTML);
            listaLocadors($("#anhosLocador").val(), render);
        }
    });
}


/*******************************************/
/*************PUBLICIDAD********************/
/******************************************/
var  listaCAS = function(anho, render){
    $.ajax({
        url:'./GestionTransparente?action=ListarPersonalForAdmin&anho='+anho,
        dataType:'json',
        data:{
            query:$("#txtBuscarCAS").val().replace("&","$$"),
            limit:$("#limit3").val(),
            start:$("#start3").val(),
            current:$("#current3").val(),
            tipo: 3
        },
        success:function(response){
            if (response.items.length>0){
                var ul=$("<ul/>",{
                    id:'listCAS'
                });
                $(render).html("");
                $(render).append(ul);  
                $(response.items).each(function(index,node){
                    var divId=$("<em/>",{
                        id:'idPersonalLocador',
                        html:node.id
                    }).css({
                        "width":"0%", 
                        "display":"none"
                    });
                    
                    var divPersonal=$("<div/>",{  
                        id:'nombrePersonalLocador',
                        html:node.apellidosNombres
                    }).css("width","20%");
                    
                    var divTrimestre=$("<div/>",{
                        id:'trimestrePersonalLocador',
                        html: node.trimestre
                    }).css("width","8%");
                    
                    var divDni = $("<div/>",{
                        html: node.numeroDni
                    }).css("width","9%");
                    var divTotal=$("<div/>",{
                        html: node.ingresoTotal
                    }).css("width","10%");
                    var divFechaIngreso = $("<div/>",{
                        html: node.fechaIngreso
                    }).css("width","10%");
                    
                    var divDependencia=$("<div/>",{
                        id:'dependencia',
                        html: node.oficinaArea
                    }).css("width","19%");
                    
                    var divRegimen=$("<div/>",{
                        id:'cargo',
                        html: node.codigoCivil
                    }).css("width","10%");
                    
                    var divDel=$("<a/>",{
                        "title":"Eliminar",
                        "class":"ui-button ui-icon ui-icon-trash"                        
                    }).css("width","11px");
                    
                    var divEstado=$("<a/>",{
                        "title":node.estado?"Activo":"Desactivado",
                        "class":node.estado?"ui-button ui-icon ui-icon-circle-arrow-n":"ui-button ui-icon ui-icon-circle-arrow-s"
                    }).css("width","12px");
                                 
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
                        $("#btnEliminarCAS").trigger("click");
                    });
                    
                    li.append(divId);
                    li.append(divPersonal);
                    li.append(divDni);
                    li.append(divFechaIngreso)
                    li.append(divTrimestre);
                    li.append(divDependencia);
                    li.append(divRegimen);
                    li.append(divTotal);
                    li.append(divDel);
                    //li.append(divEstado);
                    ul.append(li);  
                });
                if(parseInt( response.total)==0){
                    $("#paginate-publicidad").hide();                    
                }else{
                    $("#listCAS").find("li:first").addClass("selected ui-state-highlight");
                    $("#paginate-publicidad").show();
                    $("#totalItems3").html(" "+"Total de Registros: "+response.total);
                }
                if(parseInt(response.pagina)==0) $("#page3").html(" 1 de "+Math.ceil(parseInt(response.total)/(parseInt($("#limit3").val()))));
                else $("#page3").html((parseInt(response.pagina)+1) + " de " +(Math.ceil(parseInt(response.total)/(parseInt($("#limit3").val())))));                          
                $("#bfinal3").attr("rel", Math.ceil(parseInt(response.total)/(parseInt($("#limit3").val()))));  
            }else{
                $(render).html("<ul><li><div style='color:red;'>No Hay Registros</div></li></ul>");
            }
        }
    });
}

function loadCAS(render){
    $.ajax({
        url:'./GestionTransparente?action=ListarAnhosPersonalPlanilla&tipo=3',
        success:function(responseHTML){
            $("#anhosCAS").html(responseHTML);
            listaCAS($("#anhosCAS").val(), render);
        }
    });
}


/*******************************************/
/*************CATEGORIA********************/
/******************************************/
var  listaCategoria = function(anho, render){
    $.ajax({
        url:'./GestionTransparente?action=PersonalCategoria&anho='+anho,
        dataType:'json',
        data:{
            query:$("#txtBuscarCategoria").val().replace("&","$$"),
            limit:$("#limit4").val(),
            start:$("#start4").val(),
            current:$("#current4").val()
        },
        success:function(response){
            if (response.items.length>0){
                var ul=$("<ul/>",{
                    id:'listCategoria'
                });
                $(render).html("");
                $(render).append(ul);  
                $(response.items).each(function(index,node){
                    var divId=$("<em/>",{
                        id:'idCategoria',
                        html:node.id
                    }).css({
                        "width":"0%", 
                        "display":"none"
                    });
                    
                    var divCodigo=$("<div/>",{
                        id:'codigoCategoria',
                        html: node.codigo
                    }).css("width","10%");
                        
                    var divTrimestres=$("<div/>",{  
                        id:'trimestreCategoria',
                        html:node.trimestre
                    }).css("width","10%");
                        
                    var divCategoria=$("<div/>",{
                        id:'cateCategoria',
                        html:node.categoria
                    }).css("width","20%");
                        
                    var divMinimo=$("<div/>",{
                        id:'minCategoria',
                        html: node.remuneracionMinima
                    }).css("width","15%");
                        
                    var divMaximo=$("<div/>",{
                        id:'maxCategoria',
                        html: node.remuneracionMaxima
                    }).css("width","15%");
                        
                    var divNro=$("<div/>",{
                        id:'nroCategoria',
                        html: node.numeroTrabajadores
                    }).css("width","15%");
                        
                    var divEstado=$("<a/>",{
                        "title":node.estado?"Activo":"Desactivado",
                        "class":node.estado?"ui-button ui-icon ui-icon-circle-arrow-n":"ui-button ui-icon ui-icon-circle-arrow-s"
                    }).css("width","12px");
                                 
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
                    var divDel=$("<a/>",{
                        "title":"Eliminar",
                        "class":"ui-button ui-icon ui-icon-trash"                        
                    }).css("width","11px");
                    
                    divDel.on("click",function(evt){
                        evt.preventDefault();
                        $(li).trigger("click");
                        $("#btnEliminarCategoria").trigger("click");
                    });
                    var divKey=$("<em/>",{
                        "style" : "display:none",
                        html : node.id
                    });
                    
                    li.append(divId);
                    li.append(divCodigo);
                    li.append(divTrimestres);
                    li.append(divCategoria);
                    li.append(divMinimo);
                    li.append(divMaximo);
                    li.append(divNro);
                    li.append(divDel);
                   
                    //li.append(divEstado);
                    ul.append(li);
                });
                if(parseInt( response.total)==0){
                    $("#paginate-telefonia").hide();
                }else{
                    $("#listCategoria").find("li:first").addClass("selected ui-state-highlight");
                    $("#paginate-telefonia").show();
                    $("#totalItems4").html(" "+"Total de Registros: "+response.total);
                }
                if(parseInt(response.pagina)==0) $("#page4").html(" 1 de "+Math.ceil(parseInt(response.total)/(parseInt($("#limit4").val()))));
                else $("#page4").html((parseInt(response.pagina)+1) + " de " +(Math.ceil(parseInt(response.total)/(parseInt($("#limit4").val())))));                          
                $("#bfinal4").attr("rel", Math.ceil(parseInt(response.total)/(parseInt($("#limit4").val()))));  
            }else{
                $(render).html("<ul><li><div style='color:red;'>No Hay Registros</div></li></ul>");
            }
        }
    });
}

function loadCategoria(render){
    $.ajax({
        url:'./GestionTransparente?action=ListarAnhosPersonalCategoria',
        success:function(responseHTML){ 
            $("#anhosCategoria").html(responseHTML);
            listaCategoria($("#anhosCategoria").val(), render);
        }
    });
}

function validarOnlyPersonalPlanilla(){
    if ($("#txtDni").val() == "") {
        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Ingresar el N&uacute;mero D.N.I");
        return false;
    }else if ($("#txtDni").val().length < 8) {
        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Ingresar correctamente la cantidad de digitos del D.N.I");
        return false;
    }
    else if($("#txtNombre").val()==""){
        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Ingresar el Nombre de la PersonalPlanilla");
        return false;
    }
    else if($("#txtApellidoPaterno").val()==""){
        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Ingresar el Apellido Paterno de la PersonalPlanilla");
        return false;
    }
    else if($("#txtApellidoMaterno").val()==""){
        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Ingresar el Apellido Materno de la PersonalPlanilla");
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
                    $(".eliminarQuestion").removeData("idPersonalPlanilla");
                    $("#"+b.parent().parent().data("frm")).find(".body").html("");
                    switch (b.parent().parent().data("load")){
                        case 1:
                            listaPersonalPlanilla($("#anhosPersonalPlanilla").val(), $("#"+b.parent().parent().data("frm")).find(".body"));
                            break;
                        case 2:
                            loadLocadors($("#anhosLocador").val(), $("#"+b.parent().parent().data("frm")).find(".body"));
                            break;
                        case 3:
                            loadCAS($("#anhosCAS").val(), $("#"+b.parent().parent().data("frm")).find(".body"));
                            break;
                        case 4:
                            loadCategoria($("#anhosCategoria").val(), $("#"+b.parent().parent().data("frm")).find(".body"));
                            break;
                    }
                    $(".eliminarQuestion").dialog("close");
                }
                else{
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
    $("#tabs").tabs();
    /************************************/
    sortableColumns("listPersonalPlanillas");
    createPagination($("#frmPersonalPlanilla").find(".body"),"paginate-personalPLan", "frmPersonalPlanilla", 1);
    loadPersonalPlanillas($("#frmPersonalPlanilla").find(".body"));
    sortableColumns("listLocador");
    createPagination($("#frmLocador").find(".body"),"paginate-locador", "frmLocador", 2);
    loadLocadors($("#frmLocador").find(".body"));
    sortableColumns("listCAS");
    createPagination($("#frmCAS").find(".body"),"paginate-publicidad", "frmCAS", 3);
    loadCAS($("#frmCAS").find(".body"));
    sortableColumns("listCategoria");
    createPagination($("#frmCategoria").find(".body"),"paginate-telefonia", "frmCategoria", 4);
    loadCategoria($("#frmCategoria").find(".body"));
    
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
    $("#guardarFilasPersonalPlanilla").button({
        disabled:true,
        icons:{
            primary:'ui-icon-disk'
        }
    });
    
    $("#guardarFilasPersonalPlanilla").on("click",guardarFilasPlanilla);
    $("#btnCancelarPersonalPlanilla").button({
        icons:{
            primary:'ui-icon-cancel'
        }
    });
    $("#btnCancelarPersonalPlanilla").on("click",cancelarPersonalPlanilla);

    $("#btnNuevoPersonalPlanilla").button({
        icons:{
            primary:'ui-icon-plus'
        }
    });
    
    $("#btnNuevoPersonalPlanilla").on("click",newPersonalPlanilla);
    
    $("#btnEliminarPersonalPlanilla").button({
        icons: {
            primary:'ui-icon-trash'
        }
    }).click(function(){
        delItem($("#frmPersonalPlanilla"),1,"EliminarPersonal", "frmPersonalPlanilla");
    });
        
    $(".siMessage").click(function(){
        yesMessage($(this));
    });
    
    /********************************************************************/
    $("#btnSubirS").button({
        disabled:true,
        icons:{
            primary:'ui-icon-disk'
        }
    });
        
    $("#archivoS").on("change",changeArchivoS);
    $("#btnSubirS").on("click",subirArchivoS);
    $("#guardarFilasLocador").button({
        disabled:true,
        icons:{
            primary:'ui-icon-disk'
        }
    });
    $("#guardarFilasLocador").on("click",guardarFilasLocador);
    $("#btnCancelarLocador").button({
        icons:{
            primary:'ui-icon-cancel'
        }
    });
    $("#btnCancelarLocador").on("click",cancelarLocador);
        
    $("#btnNuevoLocador").button({
        icons:{
            primary:'ui-icon-plus'
        }
    });
    $("#btnNuevoLocador").on("click",newLocador);
    $("#btnEliminarLocador").button({
        icons: {
            primary:'ui-icon-trash'
        }
    }).click(function(){
        delItem($("#frmLocador"),2,"EliminarPersonal", "frmLocador");
    });
    /********************************************/
    $("#btnSubirP").button({
        disabled:true,
        icons:{
            primary:'ui-icon-disk'
        }
    });
        
    $("#archivoP").on("change",changeArchivoP);
    $("#btnSubirP").on("click",subirArchivoP);
    $("#guardarFilasCAS").button({
        disabled:true,
        icons:{
            primary:'ui-icon-disk'
        }
    });
    $("#guardarFilasCAS").on("click",guardarFilasCAS);
    $("#btnCancelarCAS").button({
        icons:{
            primary:'ui-icon-cancel'
        }
    });
    $("#btnCancelarCAS").on("click",cancelarCAS);
        
    $("#btnNuevoCAS").button({
        icons:{
            primary:'ui-icon-plus'
        }
    });
    $("#btnNuevoCAS").on("click",newCAS);
        
    $("#btnEliminarCAS").button({
        icons: {
            primary:'ui-icon-trash'
        }
    }).click(function(){
        delItem($("#frmCAS"),3,"EliminarPersonal", "frmCAS");
    });

    /********************************************/
    $("#btnSubirT").button({
        disabled:true,
        icons:{
            primary:'ui-icon-disk'
        }
    });
        
    $("#archivoT").on("change",changeArchivoT);
    $("#btnSubirT").on("click",subirArchivoT);
    $("#guardarFilasCategoria").button({
        disabled:true,
        icons:{
            primary:'ui-icon-disk'
        }
    });
    $("#guardarFilasCategoria").on("click",guardarFilasCategoria);
    $("#btnCancelarCategoria").button({
        icons:{
            primary:'ui-icon-cancel'
        }
    });
    $("#btnCancelarCategoria").on("click",cancelarCategoria);
        
    $("#btnNuevoCategoria").button({
        icons:{
            primary:'ui-icon-plus'
        }
    });
    $("#btnNuevoCategoria").on("click",newCategoria);
        
    $("#btnEliminarCategoria").button({
        icons: {
            primary:'ui-icon-trash'
        }
    }).click(function(){
        delItem($("#frmCategoria"),4,"EliminarPersonalCategoria", "frmCategoria");
    });
    
    /***********************************************************************/
    /************************************************************************/
    $("#txtBuscarPersonalPlanilla").keypress(function (evt){
        if(evt.keyCode==13){
            $("#current1").val(0);
            $("#start1").val(parseInt($("#current1").val())* parseInt($("#limit1").val()));
            $("#frmPersonalPlanilla").find(".body").html("");
            loadPersonalPlanillas($("#frmPersonalPlanilla").find(".body"));
        }                    
    });
    $("#txtBuscarLocador").keypress(function (evt){
        if(evt.keyCode==13){
            $("#current2").val(0);
            $("#start2").val(parseInt($("#current2").val())* parseInt($("#limit2").val()));
            $("#frmLocador").find(".body").html("");
            loadLocadors($("#frmLocador").find(".body"));
        }                    
    }); 
    $("#txtBuscarCAS").keypress(function (evt){
        if(evt.keyCode==13){
            $("#current3").val(0);
            $("#start3").val(parseInt($("#current3").val())* parseInt($("#limit3").val()));
            $("#frmCAS").find(".body").html("");
            loadCAS($("#frmCAS").find(".body"));
        }                    
    }); 
    $("#txtBuscarCategoria").keypress(function (evt){
        if(evt.keyCode==13){
            $("#current4").val(0);
            $("#start4").val(parseInt($("#current4").val())* parseInt($("#limit4").val()));
            $("#frmCategoria").find(".body").html("");
            loadCategoria($("#frmCategoria").find(".body"));
        }                    
    });
    
    $("#anhosPersonalPlanilla").bind("change",function(){
        listaPersonalPlanilla($("#anhosPersonalPlanilla").val(),$("#frmPersonalPlanilla").find(".body"));
    });  
    $("#anhosLocador").bind("change",function(){
        listaLocadors($("#anhosLocador").val(),$("#frmLocador").find(".body"));
    }); 
    $("#anhosCAS").bind("change",function(){
        listaCAS($("#anhosCAS").val(),$("#frmCAS").find(".body") );
    }); 
    $("#anhosCategoria").bind("change",function(){
        listaCategoria($("#anhosCategoria").val(),$("#frmCategoria").find(".body") );
    });
    
    $(".noMessage").click(function(){
        $(".eliminarQuestion").dialog("close");
    });
    $("body").roles();
}
    
$("document").ready(function(){
    init();
});

