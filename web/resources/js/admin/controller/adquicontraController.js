
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
function changeArchivoS(){
    this.abierto=true;
    $("#frmServicios").submit(); 
    return false;
}

function changeArchivoP(){
    this.abierto=true;
    $("#frmPublicidads").submit(); 
    return false;
}

function changeArchivoT(){
    this.abierto=true;
    $("#frmTelefonias").submit();
    return false;
}
function changeArchivoV(){
    this.abierto=true;
    $("#frmVehiculos").submit();
    return false;
}
function changeArchivoPr(){
    this.abierto=true;
    $("#frmProveedors").submit();
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
function cancelarCompraBien(){
    var $data = $("#listCompraBiensx").find("li");
    $("#guardarFilasCompraBien").button({
        disabled:true
    });
    $("#btnSubir").button({
        disabled:true
    });
    eliminarTemp($data);
    $("#frmCompraBien").show();
    $("#widget").show();
    $("#frmRegistroCompraBien").hide();
    return false;
}

/*********servicio *//////
function cancelarServicio(){
    var $data = $("#listServiciox").find("li");
    $("#guardarServicio").button({
        disabled:true
    });
    $("#btnSubirS").button({
        disabled:true
    });
    eliminarTemp($data);
    $("#frmServicio").show();
    $("#widgetS").show();
    $("#frmRegistroServicio").hide();
    return false;
}
/*********publicidad *//////
function cancelarPublicidad(){
    var $data = $("#listPublicidadx").find("li");
    $("#guardarPublicidad").button({
        disabled:true
    });
    $("#btnSubirP").button({
        disabled:true
    });
    eliminarTemp($data);
    $("#frmPublicidad").show();
    $("#widgetP").show();
    $("#frmRegistroPublicidad").hide();
    return false;
}
/*********publicidad *//////
function cancelarTelefonia(){
    var $data = $("#listTelefoniax").find("li");
    $("#guardarTelefonia").button({
        disabled:true
    });
    $("#btnSubirT").button({
        disabled:true
    });
    eliminarTemp($data);
    $("#frmTelefonia").show();
    $("#widgetT").show();
    $("#frmRegistroTelefonia").hide();
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
function cancelarProveedor(){
    var $data = $("#listProveedorx").find("li");
    $("#guardarProveedor").button({
        disabled:true
    });
    $("#btnSubirPr").button({
        disabled:true
    });
    eliminarTemp($data);
    $("#frmProveedor").show();
    $("#widgetPr").show();
    $("#frmRegistroProveedor").hide();
    return false;
}
function newCompraBien(){
    $("#frmCompraBien").hide();
    $("#widget").hide();
    $("#archivo").val("");
    $("#frmRegistroCompraBien").show();
    $("#btnGuardarOnlyCompraBien").hide();
    $("#frmVerCompraBien").find(".body").html("");
    $("#msnError_1").html("");
    return false;
}

function newServicio(){
    $("#frmServicio").hide();
    $("#widgetS").hide();
    $("#archivoS").val("");
    $("#frmRegistroServicio").show();
    $("#btnGuardarOnlyServicio").hide();
    $("#frmVerServicio").find(".body").html("");
    $("#msnError_2").html("");
    return false;
}

function newPublicidad(){
    $("#frmPublicidad").hide();
    $("#widgetP").hide();
    $("#archivoP").val("");
    $("#frmRegistroPublicidad").show();
    $("#btnGuardarOnlyPublicidad").hide();
    $("#frmVerPublicidad").find(".body").html("");
    $("#msnError_3").html("");    
    return false;
}

function newTelefonia(){
    $("#frmTelefonia").hide();
    $("#widgetT").hide();
    $("#archivoT").val("");
    $("#frmRegistroTelefonia").show();
    $("#btnGuardarOnlyTelefonia").hide();
    $("#frmVerTelefonia").find(".body").html("");
    $("#msnError_4").html("");
    return false;
}

function newVehiculo(){
    $("#frmVehiculo").hide();
    $("#widgetV").hide();
    $("#archivoV").val("");
    $("#frmRegistroVehiculo").show();
    $("#btnGuardarOnlyVehiculo").hide();
    $("#frmVerVehiculo").find(".body").html("");
    $("#msnError_5").html("");
    return false;
}

function newProveedor(){
    $("#frmProveedor").hide();
    $("#widgetPr").hide();
    $("#archivoPr").val("");
    $("#frmRegistroProveedor").show();
    $("#btnGuardarOnlyProveedor").hide();
    $("#frmVerProveedor").find(".body").html("");
    $("#msnError_6").html("");
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
                loadCompraBiens($("#"+frm).find(".body"));
                break;
            case 2 :
                loadServicios($("#"+frm).find(".body"));
                break;
            case 3 :
                loadPublicidad($("#"+frm).find(".body"));
                break;   
            case 4 :
                loadTelefonia($("#"+frm).find(".body"));
                break; 
            case 5 :
                loadVehiculo($("#"+frm).find(".body"));
                break; 
            case 6 :
                loadProveedor($("#"+frm).find(".body"));
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
                    loadCompraBiens($("#"+frm).find(".body"));
                    break;
                case 2 :
                    loadServicios($("#"+frm).find(".body"));
                    break;
                case 3 :
                    loadPublicidad($("#"+frm).find(".body"));
                    break; 
                case 4 :
                    loadTelefonia($("#"+frm).find(".body"));
                    break; 
                case 5 :
                    loadVehiculo($("#"+frm).find(".body"));
                    break; 
                case 6 :
                    loadProveedor($("#"+frm).find(".body"));
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
                    loadCompraBiens($("#"+frm).find(".body"));
                    break;
                case 2 :
                    loadServicios($("#"+frm).find(".body"));
                    break;
                case 3 :
                    loadPublicidad($("#"+frm).find(".body"));
                    break; 
                case 4 :
                    loadTelefonia($("#"+frm).find(".body"));
                    break; 
                case 5 :
                    loadVehiculo($("#"+frm).find(".body"));
                    break; 
                case 6 :
                    loadProveedor($("#"+frm).find(".body"));
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
                loadCompraBiens($("#"+frm).find(".body"));
                break;
            case 2 :
                loadServicios($("#"+frm).find(".body"));
                break;
            case 3 :
                loadPublicidad($("#"+frm).find(".body"));
                break; 
            case 4 :
                loadTelefonia($("#"+frm).find(".body"));
                break; 
            case 5 :
                loadVehiculo($("#"+frm).find(".body"));
                break; 
            case 6 :
                loadProveedor($("#"+frm).find(".body"));
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
    var tam=$("#listCompraBiensx li").length;
    var index=0;
    var contg1=tam;
    var op = "true";

    var $data = $("#listCompraBiensx").find("li")
    $("#guardarFilasCompraBien").button({
        disabled:true
    });
    var recursivito = function(index, contg1, $data) {
        if(index>=contg1){
            elimarAllTemp($data);
            $("#guardarFilasCompraBien").button({
                disabled:false
            });
            $("#frmCompraBien").find(".body").html("");
            loadCompraBiens($("#frmCompraBien").find(".body"));
            $("#frmCompraBien").show();
            $("#widget").show();
            $("#frmRegistroCompraBien").hide();
            $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").html("Se insertaron nuevos items"); 
            return false;
        }
        var $array,id,mes,anho,fecha,nro,proveedor,monto,financiamiento,fuente, nroSiaf;
        $array = $data.eq(index).attr("data").split("|");
        id=$array[0];
        anho=$array[1];
        mes=$array[2];
        fecha=$array[3];
        nro=$array[4];
        proveedor=$array[5];
        monto=$array[6];
        financiamiento=$array[7];
        fuente=$array[8];
        nroSiaf = $array[9];
        index++;
        if(index!=1) op = "false";
        $.ajax({
            type: 'POST',
            url: './GestionTransparente?action=VolcarTemporalOrden',
            data: {
                id:  id,  
                mes:  mes,  
                anho: anho, 
                fecha: fecha, 
                nro: nro, 
                proveedor: proveedor, 
                monto: monto,
                financiamiento: financiamiento,
                fuente : fuente,
                nroSiaf : nroSiaf
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
function guardarFilasServicio(){
    var tam=$("#listServiciox li").length;
    var index=0;
    var contg1=tam;
    var op = "true";

    var $data = $("#listServiciox").find("li")
    $("#guardarFilasServicio").button({
        disabled:true
    });
    var recursivito = function(index, contg1, $data) {
        if(index>=contg1){
            elimarAllTemp($data);
            $("#guardarFilasServicio").button({
                disabled:false
            });
            $("#frmServicio").find(".body").html("");
            loadServicios($("#frmServicio").find(".body"));
            $("#frmServicio").show();
            $("#widgetS").show();
            $("#frmRegistroServicio").hide();
            $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").html("Se insertaron nuevos items"); 
            return false;
        }
        var $array,id,mes,anho,fecha,nro,proveedor,monto,financiamiento,fuente, nroSiaf;
        $array = $data.eq(index).attr("data").split("|");
        id=$array[0];
        anho=$array[1];
        mes=$array[2];
        fecha=$array[3];
        nro=$array[4];
        proveedor=$array[5];
        monto=$array[6];
        financiamiento=$array[7];
        fuente=$array[8];
        nroSiaf = $array[9];
        
        index++;
        if(index!=1) op = "false";
        $.ajax({
            type: 'POST',
            url: './GestionTransparente?action=VolcarTemporalServicio',
            data: {
                id:  id,  
                mes:  mes,  
                anho: anho, 
                fecha: fecha, 
                nro: nro, 
                proveedor: proveedor, 
                monto: monto,
                financiamiento: financiamiento,
                fuente : fuente,
                nroSiaf : nroSiaf
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
function guardarFilasPublicidad(){
    var tam=$("#listPublicidadx li").length;
    var index=0;
    var contg1=tam;
    var op = "true";

    var $data = $("#listPublicidadx").find("li")
    $("#guardarFilasPublicidad").button({
        disabled:true
    });
    var recursivito = function(index, contg1, $data) {
        if(index>=contg1){
            elimarAllTemp($data);
            $("#guardarFilasPublicidad").button({
                disabled:false
            });
            $("#frmPublicidad").find(".body").html("");
            loadPublicidad($("#frmPublicidad").find(".body"));
            $("#frmPublicidad").show();
            $("#widgetP").show();
            $("#frmRegistroPublicidad").hide();
            $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").html("Se insertaron nuevos items"); 
            return false;
        }
        var $array,id,anho,bienes,ruc,proveedor,objeto,penalidad,fuente,costofinal,contrato,observaciones;
        $array = $data.eq(index).attr("data").split("|");
        id=$array[0];
        anho=$array[1];
        fuente=$array[2];
        contrato=$array[3];
        objeto=$array[4];
        ruc=$array[5];
        proveedor=$array[6];
        penalidad=$array[7];
        costofinal=$array[8];
        bienes = $array[9];
        var montoRef = $array[10];
        var montoContr = $array[11];
        var proceso = $array[12];
        observaciones = $array[13];
        index++;
        if(index!=1) op = "false";
        $.ajax({
            type: 'POST',
            url: './GestionTransparente?action=VolcarTemporalPublicidad',
            data: {
                id:  id,  
                anho: anho, 
                fuente: fuente, 
                contrato: contrato, 
                objeto: objeto, 
                ruc: ruc,
                proveedor : proveedor,
                penalidad: penalidad,
                costofinal : costofinal,
                bienes : bienes,
                valorReferencial: montoRef,
                montoContrato : montoContr,
                proceso : proceso,
                observaciones: observaciones
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
function guardarFilasTelefonia(){
    var tam=$("#listTelefoniax li").length;
    var index=0;
    var contg1=tam;
    var op = "true";

    var $data = $("#listTelefoniax").find("li")
    $("#guardarFilasTelefonia").button({
        disabled:true
    });
    var recursivito = function(index, contg1, $data) {
        if(index>=contg1){
            elimarAllTemp($data);
            $("#guardarFilasTelefonia").button({
                disabled:false
            });
            $("#frmTelefonia").find(".body").html("");
            loadTelefonia($("#frmTelefonia").find(".body"));
            $("#frmTelefonia").show();
            $("#widgetT").show();
            $("#frmRegistroTelefonia").hide();
            $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").html("Se insertaron nuevos items"); 
            return false;
        }
        var $array,anho,mes,area,asignacion,cargo,importe;
        $array = $data.eq(index).attr("data").split("|");
        area = $array[0];
        anho=$array[1];
        mes=$array[2];
        asignacion=$array[3];
        cargo=$array[4];
        importe=$array[5];
        var tipo = $array[6];
        var numero = $array[7];
        index++;
        if(index!=1) op = "false";
        $.ajax({
            type: 'POST',
            url: './GestionTransparente?action=VolcarTemporalTelefonia',
            data: {
                anho: anho, 
                mes: mes, 
                area: area, 
                asignacion: asignacion, 
                cargo: cargo,
                importe : importe,
                tipo : tipo,
                numero : numero
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
function guardarFilasVehiculo(){
    var tam=$("#listVehiculox li").length;
    var index=0;
    var contg1=tam;
    var op = "true";

    var $data = $("#listVehiculox").find("li")
    $("#guardarFilasVehiculo").button({
        disabled:true
    });
    var recursivito = function(index, contg1, $data) {
        if(index>=contg1){
            elimarAllTemp($data);
            $("#guardarFilasVehiculo").button({
                disabled:false
            });
            $("#frmVehiculo").find(".body").html("");
            loadVehiculo($("#frmVehiculo").find(".body"));
            $("#frmVehiculo").show();
            $("#widgetV").show();
            $("#frmRegistroVehiculo").hide();
            $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").html("Se insertaron nuevos items"); 
            return false;
        }
        var $array, anho, mes, tipoClase, claseVehiculo, asignadoA, cargoActividad, 
        tipoCombustible, recorridoKm, costoCombustible, soatFechaVencimiento, 
        placa, observaciones;
        $array = $data.eq(index).attr("data").split("|");
        anho=$array[0];
        mes=$array[1];
        tipoClase=$array[2];
        claseVehiculo=$array[3];
        asignadoA=$array[4];
        cargoActividad=$array[5];
        tipoCombustible=$array[6];
        recorridoKm=$array[7];
        costoCombustible=$array[8];
        soatFechaVencimiento=$array[9];
        placa=$array[10];
        observaciones=$array[11];
        
        
        index++;
        if(index!=1) op = "false";
        $.ajax({
            type: 'POST',
            url: './GestionTransparente?action=VolcarTemporalVehiculo',
            data: {
                anho: anho, 
                mes: mes, 
                tipoClase: tipoClase, 
                claseVehiculo: claseVehiculo, 
                asignadoA: asignadoA,
                cargoActividad : cargoActividad,
                tipoCombustible : tipoCombustible,
                recorridoKm : recorridoKm,
                costoCombustible : costoCombustible,
                fecha : soatFechaVencimiento,
                placa : placa,
                observaciones : observaciones
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
function guardarFilasProveedor(){
    var tam=$("#listProveedorx li").length;
    var index=0;
    var contg1=tam;
    var op = "true";

    var $data = $("#listProveedorx").find("li")
    $("#guardarFilasProveedor").button({
        disabled:true
    });
    var recursivito = function(index, contg1, $data) {
        if(index>=contg1){
            elimarAllTemp($data);
            $("#guardarFilasProveedor").button({
                disabled:false
            });
            $("#frmProveedor").find(".body").html("");
            loadProveedor($("#frmProveedor").find(".body"));
            $("#frmProveedor").show();
            $("#widgetPr").show();
            $("#frmRegistroProveedor").hide();
            $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").html("Se insertaron nuevos items"); 
            return false;
        }
        var $array, anho, trimestre, ruc, proveedor, importe;
        $array = $data.eq(index).attr("data").split("|");
        anho=$array[0];
        trimestre=$array[1];
        ruc=$array[2];
        proveedor=$array[3];
        importe=$array[4];
        
        index++;
        if(index!=1) op = "false";
        $.ajax({
            type: 'POST',
            url: './GestionTransparente?action=VolcarTemporalProveedor',
            data: {
                anho: anho, 
                trimestre: trimestre, 
                ruc: ruc, 
                proveedor: proveedor, 
                importe: importe
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
        $("#frmVerCompraBien").find(".body").html("");
        var a={};
        $.ajax({
            url:'./GestionTransparente?action=ImportarComprasBienes',
            dataType:'json',
            success:function(response){
                $("#guardarFilasCompraBien").button({
                    disabled:false
                });
                var cont=0;
                if (response.errors==1){
                    $("#msnError_1").html("Este Formato no Pertenece al Registo de Orden de Compra: ver un Ejemplo <a href='./archivos/EJEMPLOS/F00007_ejemplo.xls'>Abrir</a>");
                    return 0;
                }
                if (response.items.length>0){
                    var ul=$("<ul/>",{
                        id:'listCompraBiensx'
                    });
                    $("#frmVerCompraBien").find(".body").append(ul);  
                    $(response.items).each(function(index,node){
                        var divItem=$("<div/>",{
                            id:'itemBienx',
                            html:node.id
                        }).css("width","2%");
                        
                        var divId=$("<div/>",{
                            id:'idCompraBienx',
                            html:node.nro
                        }).css("width","7%");
                        var divFecha=$("<div/>",{  
                            id:'fechaCompraBienx',
                            html:node.fecha
                        }).css("width","9%");
                        var divFuente=$("<div/>",{
                            id:'fuenteCompraBien',
                            html: node.fuenteFinanciamiento
                        }).css("width","20%");
                        var divProveedor=$("<div/>",{
                            id:'proveedorCompraBienx',
                            html: node.proveedor
                        }).css("width","20%");
                        var divFinanciamiento=$("<div/>",{
                            id:'financiamientoCompraBienx',
                            html: node.financiamiento
                        }).css("width","10%");
                        var divMonto=$("<div/>",{
                            id:'montoCompraBienx',
                            html: node.monto
                        }).css("width","7%");
                        
                        var divSiaf=$("<div/>",{
                            id:'nroSiafx',
                            html: node.nroSiaf
                        }).css("width","10%");
                        
                        var divDel=$("<a/>",{
                            "title":"Eliminar",
                            "class":"ui-button ui-icon ui-icon-trash"                        
                        }).css("width","11px");

                                 
                        var li=$("<li/>").css("cursor","pointer");
                        if (!node.estado){
                            $(li).css("color","red");
                            cont++;
                            a[cont]= node.id;
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
                        li.attr("data",node.id+"|"+node.anho+"|"+node.mes+"|"+node.fecha+"|"+node.nro+"|"+node.proveedor+"|"+node.monto+"|"+node.financiamiento+"|"+node.fuenteFinanciamiento+"|"+node.nroSiaf);
                        divDel.on("click",function(evt){
                            evt.preventDefault();
                            eliminarTemp(li);
                        });
                        
                        li.append(divItem);
                        li.append(divId);
                        li.append(divFecha);
                        li.append(divFuente);
                        li.append(divProveedor);
                        li.append(divFinanciamiento);
                        li.append(divMonto);
                        li.append(divSiaf);
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
                    $("#frmVerCompraBien").find(".body").html("<ul><li><div style='color:red;'>No Hay Registros</div></li></ul>");
                }
                
                $(".totalPieBien").remove();
                var pie= $("<div/>",{
                    "class":"paginate ui-state-default ui-corner-bottom totalPieBien"
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
                $(pie).insertAfter($("#frmVerCompraBien"));
            }
        });
    }
    return false;
}

/***********servicio**************************/
function subirArchivoS(){
    if (validarCampoS()){
        $("#frmVerServicio").find(".body").html("");
        var a={};
        
        $.ajax({
            url:'./GestionTransparente?action=ImportarServicios',
            dataType:'json',
            success:function(response){
                $("#guardarFilasServicio").button({
                    disabled:false
                });
                var cont=0;
                if (response.errors==1){
                    $("#msnError_2").html("Este Formato no Pertenece al Registo de Orden de Servicio: ver un Ejemplo <a href='./archivos/EJEMPLOS/F00008_ejemplo.xls'>Abrir</a>");
                    return 0;
                }
                if (response.items.length>0){
                    var ul=$("<ul/>",{
                        id:'listServiciox'
                    });
                    $("#frmVerServicio").find(".body").append(ul);  
                    $(response.items).each(function(index,node){
                        
                        var divItem=$("<div/>",{
                            id:'itemServiciox',
                            html:node.id
                        }).css("width","2%");
                        
                        var divId=$("<div/>",{
                            id:'idServiciox',
                            html:node.nro
                        }).css("width","7%");
                        var divFecha=$("<div/>",{  
                            id:'fechaServiciox',
                            html:node.fecha
                        }).css("width","9%");
                        var divProveedor=$("<div/>",{
                            id:'proveedorServiciox',
                            html: node.proveedor
                        }).css("width","20%");
                        var divFuente=$("<div/>",{
                            id:'fuenteCompraBien',
                            html: node.fuenteFinanciamiento
                        }).css("width","20%");
                        var divFinanciamiento=$("<div/>",{
                            id:'financiamientoServiciox',
                            html: node.financiamiento
                        }).css("width","10%");
                        
                        var divMonto=$("<div/>",{
                            id:'montoServiciox',
                            html: node.monto
                        }).css("width","7%");
                        var divDel=$("<a/>",{
                            "title":"Eliminar",
                            "class":"ui-button ui-icon ui-icon-trash"                        
                        }).css("width","11px");
                        var divSiaf=$("<div/>",{
                            id:'nroSiaf',
                            html: node.nroSiaf
                        }).css("width","10%");
                        var li=$("<li/>").css("cursor","pointer");
                        if (!node.estado){
                            $(li).css("color","red");
                            cont++;
                            a[cont]= node.id;
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
                        li.attr("data",node.id+"|"+node.anho+"|"+node.mes+"|"+node.fecha+"|"+node.nro+"|"+node.proveedor+"|"+node.monto+"|"+node.financiamiento+"|"+node.fuenteFinanciamiento+"|"+node.nroSiaf);
                        divDel.on("click",function(evt){
                            evt.preventDefault();
                            eliminarTemp(li);
                        });
                        
                        li.append(divItem);
                        li.append(divId);
                        li.append(divFecha);
                        li.append(divFuente);
                        li.append(divProveedor);
                        li.append(divFinanciamiento);
                        li.append(divMonto);
                        li.append(divSiaf);
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
                    $("#frmVerServicio").find(".body").html("<ul><li><div style='color:red;'>No Hay Registros</div></li></ul>");
                }
                
                $(".totalPieServicio").remove();
                
                var pie= $("<div/>",{
                    "class":"paginate ui-state-default ui-corner-bottom totalPieServicio"
                }).css("margin-top","5px");
                
                var totalItems=$('<label/>',{
                    "class":"ui-button",
                    "html":"Total de Registros : " + parseInt(response.items.length - cont) + " Correctos; Mas: "+cont+" Errores"
                });
                var lder=$("<div>",{
                    "class":"lder"
                });
                lder.append(totalItems);
                pie.append(lder);
                $(pie).insertAfter($("#frmVerServicio"));
            }
        });
    }
    return false;
}

/***********publicididad**************************/
function subirArchivoP(){
    if (validarCampoP()){
        $("#frmVerPublicidad").find(".body").html("");
        var a = {};
        $.ajax({
            url:'./GestionTransparente?action=ImportarPublicidad',
            dataType:'json',
            success:function(response){
                $("#guardarFilasPublicidad").button({
                    disabled:false
                });
                var cont=0;
                if (response.errors==1){
                    $("#msnError_3").html("Este Formato no Pertenece al Registo de Publicidad: ver un Ejemplo <a href='./archivos/EJEMPLOS/F00026_ejemplo.xls'>Abrir</a>");
                    return 0;
                }
                if (response.items.length>0){
                    var ul=$("<ul/>",{
                        id:'listPublicidadx'
                    });
                    $("#frmVerPublicidad").find(".body").append(ul);
                    
                    $(response.items).each(function(index,node){
                        
                        var divItem=$("<div/>",{
                            id:'itemublicidadx',
                            html:node.id
                        }).css("width","2%");
                        
                        var divFuente=$("<div/>",{
                            id:'fuenteFinPublicidad',
                            html:node.fuenteFinanciamiento
                        }).css("width","12%");
                        var divContrato=$("<div/>",{
                            id:'contratoPublicidad',
                            html:node.contrato
                        }).css("width","12%");
                        var divObjeto=$("<div/>",{  
                            id:'objetoPublicidad',
                            html:node.objetoContrato
                        }).css("width","15%");
                        var divRuc=$("<div/>",{  
                            id:'objetoRuc',
                            html:node.ruc
                        }).css("width","10%");
                        var divProveedor=$("<div/>",{
                            id:'proveedorPublicidad',
                            html: node.proveedor
                        }).css("width","23%");
                        var divPenalidad=$("<div/>",{
                            id:'penalidadPublicidad',
                            html: node.penalidad
                        }).css("width","5%");
                        var divMonto=$("<div/>",{
                            id:'montoPublicidad',
                            html: node.costoFinal
                        }).css("width","5%");
                        
                        var divDel=$("<a/>",{
                            "title":"Eliminar",
                            "class":"ui-button ui-icon ui-icon-trash"                        
                        }).css("width","11px");
                                 
                        var li=$("<li/>").css("cursor","pointer");
                        if (!node.estado){
                            $(li).css("color","red");
                            cont++;
                            a[cont]= node.id;
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
                        li.attr("data",node.id+"|"+node.anho+"|"+node.fuenteFinanciamiento+"|"+node.contrato+"|"+node.objetoContrato+"|"+node.ruc+"|"+node.proveedor+"|"+node.penalidad+"|"+node.costoFinal+"|"+node.bienesServicios+"|"+node.valorReferencial+"|"+node.montoContrato+"|"+node.proceso+"|"+node.observaciones);
                        divDel.on("click",function(evt){
                            evt.preventDefault();
                            eliminarTemp(li);
                        });
                        
                        li.append(divItem);
                        li.append(divFuente);
                        li.append(divContrato);
                        li.append(divObjeto);
                        li.append(divRuc);
                        li.append(divProveedor);
                        li.append(divPenalidad);
                        li.append(divMonto);
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
                    $("#frmVerPublicidad").find(".body").html("<ul><li><div style='color:red;'>No Hay Registros</div></li></ul>");
                }
                $(".totalPiePublicidad").remove();
                
                var pie= $("<div/>",{
                    "class":"paginate ui-state-default ui-corner-bottom totalPiePublicidad"
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
                $(pie).insertAfter($("#frmVerPublicidad"));
            }
        });
    }
    return false;
}


/***********telefonia**************************/
function subirArchivoT(){
    if (validarCampoT()){
        $("#frmVerTelefonia").find(".body").html("");
        var a = {};
        $.ajax({
            url:'./GestionTransparente?action=ImportarTelefonia',
            dataType:'json',
            success:function(response){
                $("#guardarFilasTelefonia").button({
                    disabled:false
                });
                var cont=0;
                if (response.errors==1){
                    $("#msnError_4").html("Este Formato no Pertenece al Registo de Telefonia: ver un Ejemplo <a href='./archivos/EJEMPLOS/F00020_ejemplo.xls'>Abrir</a>");
                    return 0;
                }
                if (response.items.length>0){
                    var ul=$("<ul/>",{
                        id:'listTelefoniax'
                    });
                    $("#frmVerTelefonia").find(".body").append(ul);
                    $(response.items).each(function(index,node){
                        var divItem=$("<div/>",{
                            html:node.id
                        }).css("width","2%");
                        var divArea=$("<div/>",{
                            html:node.areaOficina
                        }).css("width","18%");
                        var divAsigancion=$("<div/>",{  
                            html:node.asignadoA
                        }).css("width","17%");
                        var divCargo=$("<div/>",{  
                            html:node.cargoActividad
                        }).css("width","17%");
                        var divTipo=$("<div/>",{  
                            html:node.tipo
                        }).css("width","10%");
                        var divNumero=$("<div/>",{  
                            html:node.numero
                        }).css("width","10%");
                        var divImporte=$("<div/>",{
                            html: node.importe
                        }).css("width","10%");
                                 
                        var li=$("<li/>").css("cursor","pointer");
                        if (!node.estado){
                            $(li).css("color","red");
                            a[cont]= node.id;
                            cont++;
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
                        li.attr("data",node.areaOficina+"|"+node.anho+"|"+node.mes+"|"+node.asignadoA+"|"+node.cargoActividad+"|"+node.importe+"|"+node.tipo+"|"+node.numero);
                        divDel.on("click",function(evt){
                            evt.preventDefault();
                            eliminarTemp(li);
                        });
                        
                        li.append(divItem);
                        li.append(divTipo);
                        li.append(divNumero);
                        li.append(divArea);
                        li.append(divAsigancion);
                        li.append(divCargo);
                        li.append(divImporte);

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
                    $("#frmVerTelefonia").find(".body").html("<ul><li><div style='color:red;'>No Hay Registros</div></li></ul>");
                }
                
                $(".totalPieTelefonia").remove();
                var pie= $("<div/>",{
                    "class":"paginate ui-state-default ui-corner-bottom totalPieTelefonia"
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
                $(pie).insertAfter($("#frmVerTelefonia"));
            }
        });
    }
    return false;
}

/***********Vehiculo**************************/
function subirArchivoV(){
    if (validarCampoV()){
        $("#frmVerVehiculo").find(".body").html("");
        var a = {};
        $.ajax({
            url:'./GestionTransparente?action=ImportarVehiculo',
            dataType:'json',
            success:function(response){
                $("#guardarFilasVehiculo").button({
                    disabled:false
                });
                var cont=0;
                if (response.errors==1){
                    $("#msnError_5").html("Este Formato no Pertenece al Registo de Vehiculos: ver un Ejemplo <a href='./archivos/EJEMPLOS/F00014_ejemplo.xls'>Abrir</a>");
                    return 0;
                }
                if (response.items.length>0){
                    var ul=$("<ul/>",{
                        id:'listVehiculox'
                    });
                    
                    $("#frmVerVehiculo").find(".body").append(ul);  
                    
                    $(response.items).each(function(index,node){
                        var divItem=$("<div/>",{
                            html:node.id
                        }).css("width","2%");
                        var divClase=$("<div/>",{
                            id: 'claseVehiculo',
                            html: node.tipoClase
                        }).css("width","7%");
                        var divVehiculo=$("<div/>",{  
                            id:'vehiculo',
                            html:node.claseVehiculo
                        }).css("width","10%");
                        var divPlaca=$("<div/>",{  
                            id:'placaVehiculo',
                            html:node.placa
                        }).css("width","7%");
                        var divSOAT=$("<div/>",{
                            id:'SOATVehiculo',
                            html: node.soatFechaVencimiento
                        }).css("width","10%");
                        var divAsignado=$("<div/>",{
                            id:'asignadoVehiculo',
                            html: node.asignadoA
                        }).css("width","19%");
                        var divRecorrido=$("<div/>",{
                            id:'recorridoVehiculo',
                            html: node.recorridoKm
                        }).css("width","8%");  
                        var divTipo=$("<div/>",{
                            id:'tipoVehiculo',
                            html: node.tipoCombustible
                        }).css("width","10%");
                        
                        var divCosto=$("<div/>",{
                            id:'costoVehiculo',
                            html: node.costoCombustible
                        }).css("width","10%");
                        
                        var li=$("<li/>").css("cursor","pointer");
                        
                        if (!node.estado){
                            $(li).css("color","red");
                            a[cont]= node.id;
                            cont++;
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
                        
                        li.attr("data",node.anho+"|"+node.mes+"|"+node.tipoClase+"|"+node.claseVehiculo+"|"+node.asignadoA+"|"+node.cargoActividad+"|"+node.tipoCombustible+"|"+node.recorridoKm+"|"+node.costoCombustible+"|"+node.soatFechaVencimiento+"|"+node.placa+"|"+node.observaciones);
                        divDel.on("click",function(evt){
                            evt.preventDefault();
                            eliminarTemp(li);
                        });
                        
                        li.append(divItem);
                        li.append(divClase);
                        li.append(divVehiculo);
                        li.append(divPlaca);
                        li.append(divSOAT);
                        li.append(divAsignado);
                        li.append(divRecorrido);
                        li.append(divTipo);
                        li.append(divCosto);
                        li.append(divDel);
                        ul.append(li);
                    });    
                    
                    if (cont>0) {
                        $("#msnError_5").html("Cargó Con Algunos Errores De Consistencia, <br /> Revise las lineas de color Rojo. en la(s) fila(s): ");
                        for (var i=1; i<cont; i++){
                            $("#msnError_5").html($("#msnError_5").html()+a[i]+", ");
                        }
                        $("#msnError_5").html($("#msnError_5").html()+a[cont]);
                    } else $("#msnError_5").html("");
                }else{
                    $("#frmVerVehiculo").find(".body").html("<ul><li><div style='color:red;'>No Hay Registros</div></li></ul>");
                }
                
                $(".totalPieVehiculo").remove();
                var pie= $("<div/>",{
                    "class":"paginate ui-state-default ui-corner-bottom totalPieVehiculo"
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
                $(pie).insertAfter($("#frmVerVehiculo"));
            }
        });
    }
    return false;
}


/***********Proveedor**************************/
function subirArchivoPr(){
    if (validarCampoPr()){
        
        $("#frmVerProveedor").find(".body").html("");
        var a = {};
        
        $.ajax({
            url:'./GestionTransparente?action=ImportarProveedor',
            dataType:'json',
            success:function(response){
                $("#guardarFilasProveedor").button({
                    disabled:false
                });
                var cont=0;
                if (response.errors==1){
                    $("#msnError_6").html("Este Formato no Pertenece al Registo de Proveedor: ver un Ejemplo <a href='./archivos/EJEMPLOS/F00006_ejemplo.xls'>Abrir</a>");
                    return 0;
                }
                if (response.items.length>0){
                    var ul=$("<ul/>",{
                        id:'listProveedorx'
                    });
                    $("#frmVerProveedor").find(".body").append(ul);  
                    $(response.items).each(function(index,node){
                        var divItem=$("<div/>",{
                            html:node.id
                        }).css("width","2%");
                        
                        var divRuc=$("<div/>",{
                            id: 'rucProveedor',
                            html: node.ruc
                        }).css("width","25%");
                        var divProveedor=$("<div/>",{
                            id: 'proveedor',
                            html: node.proveedor
                        }).css("width","45%");
                        var divImporte=$("<div/>",{
                            id: 'importe',
                            html: node.importe
                        }).css("width","15%");
                        
                        var li=$("<li/>").css("cursor","pointer");
                        if (!node.estado){
                            $(li).css("color","red");
                            a[cont]= node.id;
                            cont++;
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
                        li.attr("data",node.anho+"|"+node.trimestre+"|"+node.ruc+"|"+node.proveedor+"|"+node.importe);
                        divDel.on("click",function(evt){
                            evt.preventDefault();
                            eliminarTemp(li);
                        });
                        
                        li.append(divItem);
                        li.append(divRuc);
                        li.append(divProveedor);
                        li.append(divImporte);

                        li.append(divDel);
                        
                        ul.append(li);
                    });       
                    if (cont>0) {
                        $("#msnError_6").html("Cargó Con Algunos Errores De Consistencia, <br /> Revise las lineas de color Rojo. en la(s) fila(s): ");
                        for (var i=1; i<cont; i++){
                            $("#msnError_6").html($("#msnError_6").html()+a[i]+", ");
                        }
                        $("#msnError_6").html($("#msnError_6").html()+a[cont]);
                    } else $("#msnError_6").html("");
                }else{
                    $("#frmVerProveedor").find(".body").html("<ul><li><div style='color:red;'>No Hay Registros</div></li></ul>");
                }
                
                $(".totalPieProveedor").remove();
                var pie= $("<div/>",{
                    "class":"paginate ui-state-default ui-corner-bottom totalPieProveedor"
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
                $(pie).insertAfter($("#frmVerProveedor"));
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
        url:'./GestionTransparente?action=ComprasBienesForAdmin&anho='+anho,
        dataType:'json',
        data:{
            query:$("#txtBuscarCompraBien").val().replace("&","$$"),
            limit:$("#limit1").val(),
            start:$("#start1").val(),
            current:$("#current1").val()
        },
        success:function(response){
            if (response.ordenCompra.length>0){
                var ul=$("<ul/>",{
                    id:'listCompraBiens'
                });
                
                $(render).html("");
                $(render).append(ul);  
                $(response.ordenCompra).each(function(index,node){
                    var divId=$("<div/>",{
                        id:'idCompraBien',
                        html:node.nro
                    }).css("width","7%");
                    var divFecha=$("<div/>",{  
                        id:'fechaCompraBien',
                        html:node.fecha
                    }).css("width","9%");
                    var divProveedor=$("<div/>",{
                        id:'proveedorCompraBien',
                        html: node.proveedor
                    }).css("width","23%");
                    var divFuente=$("<div/>",{
                        id:'fuenteCompraBien',
                        html: node.fuenteFinanciamiento
                    }).css("width","20%");
                    var divFinanciamiento=$("<div/>",{
                        id:'financiamientoCompraBien',
                        html: node.financiamiento
                    }).css("width","10%");
                    var divMonto=$("<div/>",{
                        id:'montoCompraBien',
                        html: node.monto
                    }).css("width","7%");
                    
                    var divKey=$("<em/>",{
                        "style" : "display:none",
                        html : node.id
                    });
                    var divDel=$("<a/>",{
                        "title":"Eliminar",
                        "class":"ui-button ui-icon ui-icon-trash"                        
                    }).css("width","11px");
                    
                    var divSiaf=$("<div/>",{
                        id:'nroSiafx',
                        html: node.nroSiaf
                    }).css("width","10%");
                    
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
                        $("#btnEliminarCompraBien").trigger("click");
                    });
                    li.append(divKey);
                    li.append(divId);
                    li.append(divFecha);
                    li.append(divFuente);
                    li.append(divProveedor);
                    li.append(divFinanciamiento);
                    li.append(divMonto);
                    li.append(divSiaf);
                    li.append(divDel);
                    //li.append(divEstado);
                    ul.append(li);      
                });                
                if(parseInt( response.total)==0){
                        
                    $("#paginate-ordenCompra").hide();                    
                }else{                    
                    $("#listCompraBiens").find("li:first").addClass("selected ui-state-highlight");
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
function loadCompraBiens(render){
    $.ajax({
        url:'./GestionTransparente?action=ListarAnhosComprasBienes',
        success:function(responseHTML){ 
            $("#anhosComprasBienes").html(responseHTML);
            listaComprasBienes($("#anhosComprasBienes").val(), render);
        }
    });
}

/*******************************************/
/*************Servicios********************/
/******************************************/
var  listaServicios = function(anho, render){
    $.ajax({
        url:'./GestionTransparente?action=ComprasServiciosForAdmin&anho='+anho,
        dataType:'json',
        data:{
            query:$("#txtBuscarServicio").val().replace("&","$$"),
            limit:$("#limit2").val(),
            start:$("#start2").val(),
            current:$("#current2").val()
        },
        success:function(response){
            if (response.servicio.length>0){
                var ul=$("<ul/>",{
                    id:'listServicio'
                });
                $(render).html("");
                $(render).append(ul);  
                $(response.servicio).each(function(index,node){
                    var divId=$("<div/>",{
                        id:'idServicio',
                        html:node.nro
                    }).css("width","7%");
                    var divFecha=$("<div/>",{  
                        id:'fechaServicio',
                        html:node.fecha
                    }).css("width","9%");
                    var divProveedor=$("<div/>",{
                        id:'proveedorServicio',
                        html: node.proveedor
                    }).css("width","23%");
                    var divFuente=$("<div/>",{
                        id:'fuenteCompraBien',
                        html: node.fuenteFinanciamiento
                    }).css("width","20%");
                    var divFinanciamiento=$("<div/>",{
                        id:'financiamientoServicio',
                        html: node.financiamiento
                    }).css("width","10%");
                    var divMonto=$("<div/>",{
                        id:'montoServicio',
                        html: node.monto
                    }).css("width","7%");
                    var divDel=$("<a/>",{
                        "title":"Eliminar",
                        "class":"ui-button ui-icon ui-icon-trash"                        
                    }).css("width","11px");
                    
                    var divSiaf=$("<div/>",{
                        id:'nroSiaf',
                        html: node.nroSiaf
                    }).css("width","10%");
                    
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
                        $("#btnEliminarServicio").trigger("click");
                    });
                    var divKey=$("<em/>",{
                        "style" : "display:none",
                        html : node.id
                    });
                    li.append(divKey);
                    li.append(divId);
                    li.append(divFecha);
                    li.append(divFuente);
                    li.append(divProveedor);
                    li.append(divFinanciamiento);
                    li.append(divMonto);
                    li.append(divSiaf);
                    li.append(divDel);
                    //li.append(divEstado);
                    ul.append(li);      
                });                
                if(parseInt( response.total)==0){
                        
                    $("#paginate-servicio").hide();                    
                }else{                    
                    $("#listServicio").find("li:first").addClass("selected ui-state-highlight");
                    $("#paginate-servicio").show();
                    $("#totalItems2").html(" "+"Total de Registros: "+response.total);
                }
                if(parseInt(response.pagina)==0) $("#page2").html(" 1 de "+Math.ceil(parseInt(response.total)/(parseInt($("#limit2").val()))));
                else $("#page2").html((parseInt(response.pagina)+1) + " de " +(Math.ceil(parseInt(response.total)/(parseInt($("#limit2").val())))));                          
                $("#bfinal2").attr("rel", Math.ceil(parseInt(response.total)/(parseInt($("#limit2").val()))));  
            }else{
                $(render).html("<ul><li><div style='color:red;'>No Hay Registros</div></li></ul>");
            }
        }
    });
}
function loadServicios(render){
    $.ajax({
        url:'./GestionTransparente?action=ListarAnhosComprasServicios',
        success:function(responseHTML){
            $("#anhosServicio").html(responseHTML);
            listaServicios($("#anhosServicio").val(), render);
        }
    });
}

/*******************************************/
/*************PUBLICIDAD********************/
/******************************************/
var  listaPublicidad = function(anho, render){
    $.ajax({
        url:'./GestionTransparente?action=PublicidadForAdmin&anho='+anho,
        dataType:'json',
        data:{
            query:$("#txtBuscarPublicidad").val().replace("&","$$"),
            limit:$("#limit3").val(),
            start:$("#start3").val(),
            current:$("#current3").val()
        },
        success:function(response){
            if (response.items.length>0){
                var ul=$("<ul/>",{
                    id:'listPublicidad'
                });
                $(render).html("");
                $(render).append(ul);  
                $(response.items).each(function(index,node){
                    
                    divFuente=$("<div/>",{
                        id:'fuenteFinPublicidad',
                        html:node.fuenteFinanciamiento
                    }).css("width","12%");
                    
                    var divContrato=$("<div/>",{
                        id:'contratoPublicidad',
                        html:node.contrato
                    }).css("width","12%");
                    
                    var divObjeto=$("<div/>",{  
                        id:'objetoPublicidad',
                        html:node.objetoContrato
                    }).css("width","15%");
                    var divRuc=$("<div/>",{  
                        id:'objetoRuc',
                        html:node.ruc
                    }).css("width","10%");
                    var divProveedor=$("<div/>",{
                        id:'proveedorPublicidad',
                        html: node.proveedor
                    }).css("width","25%");
                    var divPenalidad=$("<div/>",{
                        id:'penalidadPublicidad',
                        html: node.penalidad
                    }).css("width","5%");
                    var divMonto=$("<div/>",{
                        id:'montoPublicidad',
                        html: node.costoFinal
                    }).css("width","5%");
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
                        $("#btnEliminarPublicidad").trigger("click");
                    });
                    var divKey=$("<em/>",{
                        "style" : "display:none",
                        html : node.id
                    });
                    li.append(divKey);
                    li.append(divFuente);
                    li.append(divContrato);
                    li.append(divObjeto);
                    li.append(divRuc);
                    li.append(divProveedor);
                    li.append(divPenalidad);
                    li.append(divMonto);
                    li.append(divDel);
                    //li.append(divEstado);
                    ul.append(li);
                });
                if(parseInt( response.total)==0){
                    $("#paginate-publicidad").hide();                    
                }else{
                    $("#listPublicidad").find("li:first").addClass("selected ui-state-highlight");
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
function loadPublicidad(render){
    $.ajax({
        url:'./GestionTransparente?action=ListarAnhosPublicidad',
        success:function(responseHTML){ 
            $("#anhosPublicidad").html(responseHTML);
            listaPublicidad($("#anhosPublicidad").val(), render);
        }
    });
}


/*******************************************/
/*************TELEFONIA********************/
/******************************************/
var  listaTelefonia = function(anho, render){
    $.ajax({
        url:'./GestionTransparente?action=TelefoniaForAdmin&anho='+anho,
        dataType:'json',
        data:{
            query:$("#txtBuscarTelefonia").val().replace("&","$$"),
            limit:$("#limit4").val(),
            start:$("#start4").val(),
            current:$("#current4").val()
        },
        success:function(response){
            if (response.items.length>0){
                var ul=$("<ul/>",{
                    id:'listTelefonia'
                });
                $(render).html("");
                $(render).append(ul);  
                $(response.items).each(function(index,node){
                    var divPublicidad=$("<div/>",{
                        id:'areaTelefonia',
                        html:node.areaOficina
                    }).css("width","17%");
                    var divAsigancion=$("<div/>",{  
                        id:'asignacionTelefonia',
                        html:node.asignadoA
                    }).css("width","17%");
                    var divCargo=$("<div/>",{  
                        id:'cargoTelefonia',
                        html:node.cargoActividad
                    }).css("width","18%");
                    var divImporte=$("<div/>",{
                        id:'importeTelefonia',
                        html: node.importe
                    }).css("width","10%");
                    var divTipo=$("<div/>",{  
                        html:node.tipo
                    }).css("width","10%");
                    var divNumero=$("<div/>",{  
                        html:node.numero
                    }).css("width","10%");
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
                    var divEstado=$("<a/>",{
                        "title":node.estado?"Activo":"Desactivado",
                        "class":node.estado?"ui-button ui-icon ui-icon-circle-arrow-n":"ui-button ui-icon ui-icon-circle-arrow-s"
                    }).css("width","12px");
                    divDel.on("click",function(evt){
                        evt.preventDefault();
                        $(li).trigger("click");
                        $("#btnEliminarTelefonia").trigger("click");
                    });
                    var divKey=$("<em/>",{
                        "style" : "display:none",
                        html : node.id
                    });
                    li.append(divKey);
                    li.append(divTipo);
                    li.append(divNumero);
                    li.append(divPublicidad);
                    li.append(divAsigancion);
                    li.append(divCargo);
                    li.append(divImporte);
                    li.append(divDel);
                    //li.append(divEstado);
                    ul.append(li);
                });
                if(parseInt( response.total)==0){
                    $("#paginate-telefonia").hide();
                }else{
                    $("#listTelefonia").find("li:first").addClass("selected ui-state-highlight");
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
function loadTelefonia(render){
    $.ajax({
        url:'./GestionTransparente?action=ListarAnhosTelefonia',
        success:function(responseHTML){ 
            $("#anhosTelefonia").html(responseHTML);
            listaTelefonia($("#anhosTelefonia").val(), render);
        }
    });
}

/*******************************************/
/*************VEHICULO*********************/
/******************************************/
var  listaVehiculo = function(anho, render){
    $.ajax({
        url:'./GestionTransparente?action=VehiculoForAdmin&anho='+anho,
        dataType:'json',
        data:{
            query:$("#txtBuscarVehiculo").val().replace("&","$$"),
            limit:$("#limit5").val(),
            start:$("#start5").val(),
            current:$("#current5").val()
        },
        success:function(response){
            
            if (response.items.length>0){
                var ul=$("<ul/>",{
                    id:'listVehiculo'
                });
                $(render).html("");
                $(render).append(ul);  
                $(response.items).each(function(index,node){
                    var divClase=$("<div/>",{
                        id: 'claseVehiculo',
                        html: node.tipoClase
                    }).css("width","7%");
                    var divVehiculo=$("<div/>",{  
                        id:'vehiculo',
                        html:node.claseVehiculo
                    }).css("width","10%");
                    var divPlaca=$("<div/>",{  
                        id:'placaVehiculo',
                        html:node.placa
                    }).css("width","7%");
                    var divSOAT=$("<div/>",{
                        id:'SOATVehiculo',
                        html: node.soatFechaVencimiento
                    }).css("width","10%");
                    var divAsignado=$("<div/>",{
                        id:'asignadoVehiculo',
                        html: node.asignadoA
                    }).css("width","20%");                    
                    var divRecorrido=$("<div/>",{
                        id:'recorridoVehiculo',
                        html: node.recorridoKm
                    }).css("width","8%");                    
                    var divTipo=$("<div/>",{
                        id:'tipoVehiculo',
                        html: node.tipoCombustible
                    }).css("width","12%");
                    var divCosto=$("<div/>",{
                        id:'costoVehiculo',
                        html: node.costoCombustible
                    }).css("width","10%");         
                    
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
                    var divEstado=$("<a/>",{
                        "title":node.estado?"Activo":"Desactivado",
                        "class":node.estado?"ui-button ui-icon ui-icon-circle-arrow-n":"ui-button ui-icon ui-icon-circle-arrow-s"
                    }).css("width","12px");
                    var divKey=$("<em/>",{
                        "style" : "display:none",
                        html : node.id
                    });
                    
                    divDel.on("click",function(evt){
                        evt.preventDefault();
                        $(li).trigger("click");
                        $("#btnEliminarVehiculo").trigger("click");
                    });
                    li.append(divKey);
                    li.append(divClase);
                    li.append(divVehiculo);
                    li.append(divPlaca);
                    li.append(divSOAT);
                    li.append(divAsignado);
                    li.append(divRecorrido);
                    li.append(divTipo);
                    li.append(divCosto);
                    li.append(divDel);
                    //                    li.append(divEstado);
                    ul.append(li);
                });
                if(parseInt( response.total)==0){
                    $("#paginate-vehiculo").hide();
                }else{
                    $("#listVehiculo").find("li:first").addClass("selected ui-state-highlight");
                    $("#paginate-vehiculo").show();
                    $("#totalItems5").html(" "+"Total de Registros: "+response.total);
                }
                if(parseInt(response.pagina)==0) $("#page5").html(" 1 de "+Math.ceil(parseInt(response.total)/(parseInt($("#limit5").val()))));
                else $("#page5").html((parseInt(response.pagina)+1) + " de " +(Math.ceil(parseInt(response.total)/(parseInt($("#limit5").val())))));                          
                $("#bfinal5").attr("rel", Math.ceil(parseInt(response.total)/(parseInt($("#limit5").val()))));  
            }else{
                $(render).html("<ul><li><div style='color:red;'>No Hay Registros</div></li></ul>");
            }
        }
    });
}
function loadVehiculo(render){
    $.ajax({
        url:'./GestionTransparente?action=ListarAnhosVehiculo',
        success:function(responseHTML){ 
            $("#anhosVehiculo").html(responseHTML);
            listaVehiculo($("#anhosVehiculo").val(), render);
        }
    });
}

/*******************************************/
/*************PROVEEDOR*********************/
/******************************************/
var  listaProveedor = function(anho, render){
    $.ajax({
        url:'./GestionTransparente?action=Proveedor&anho='+anho,
        dataType:'json',
        data:{
            query:$("#txtBuscarProveedor").val().replace("&","$$"),
            limit:$("#limit6").val(),
            start:$("#start6").val(),
            current:$("#current6").val()
        },
        success:function(response){
            if (response.items.length>0){
                var ul=$("<ul/>",{
                    id:'listProveedor'
                });
                $(render).html("");
                $(render).append(ul);  
                $(response.items).each(function(index,node){
                    var divRuc=$("<div/>",{
                        id: 'rucProveedor',
                        html: node.ruc
                    }).css("width","25%");
                    var divProveedor=$("<div/>",{
                        id: 'proveedor',
                        html: node.proveedor
                    }).css("width","50%");
                    var divImporte=$("<div/>",{
                        id: 'importe',
                        html: node.importe
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
                    var divEstado=$("<a/>",{
                        "title":node.estado?"Activo":"Desactivado",
                        "class":node.estado?"ui-button ui-icon ui-icon-circle-arrow-n":"ui-button ui-icon ui-icon-circle-arrow-s"
                    }).css("width","12px");
                    var divKey=$("<em/>",{
                        "style" : "display:none",
                        html : node.id
                    });
                    divDel.on("click",function(evt){
                        evt.preventDefault();
                        $(li).trigger("click");
                        $("#btnEliminarProveedor").trigger("click");
                    });
                    li.append(divKey);
                    li.append(divRuc);
                    li.append(divProveedor);
                    li.append(divImporte);
                    li.append(divDel);
                    //li.append(divEstado);
                    ul.append(li);
                });
                if(parseInt( response.total)==0){
                    $("#paginate-proveedor").hide();
                }else{
                    $("#listProveedor").find("li:first").addClass("selected ui-state-highlight");
                    $("#paginate-vehiculo").show();
                    $("#totalItems6").html(" "+"Total de Registros: "+response.total);
                }
                if(parseInt(response.pagina)==0) $("#page6").html(" 1 de "+Math.ceil(parseInt(response.total)/(parseInt($("#limit6").val()))));
                else $("#page6").html((parseInt(response.pagina)+1) + " de " +(Math.ceil(parseInt(response.total)/(parseInt($("#limit6").val())))));                          
                $("#bfinal6").attr("rel", Math.ceil(parseInt(response.total)/(parseInt($("#limit6").val()))));  
            }else{
                $(render).html("<ul><li><div style='color:red;'>No Hay Registros</div></li></ul>");
            }
        }
    });
}
function loadProveedor(render){
    $.ajax({
        url:'./GestionTransparente?action=ListarAnhosProveedor',
        success:function(responseHTML){ 
            $("#anhosProveedor").html(responseHTML);
            listaProveedor($("#anhosProveedor").val(), render);
        }
    });
}



function validarOnlyCompraBien(){
    if ($("#txtDni").val() == "") {
        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Ingresar el N&uacute;mero D.N.I");
        return false;
    }else if ($("#txtDni").val().length < 8) {
        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Ingresar correctamente la cantidad de digitos del D.N.I");
        return false;
    }
    else if($("#txtNombre").val()==""){
        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Ingresar el Nombre de la CompraBien");
        return false;
    }
    else if($("#txtApellidoPaterno").val()==""){
        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Ingresar el Apellido Paterno de la CompraBien");
        return false;
    }
    else if($("#txtApellidoMaterno").val()==""){
        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Ingresar el Apellido Materno de la CompraBien");
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
                    $(".eliminarQuestion").removeData("idCompraBien");
                    $("#"+b.parent().parent().data("frm")).find(".body").html("");
                    switch (b.parent().parent().data("load")){
                        case 1:
                            loadCompraBiens($("#"+b.parent().parent().data("frm")).find(".body"));
                            break;
                        case 2:
                            loadServicios($("#"+b.parent().parent().data("frm")).find(".body"));
                            break;
                        case 3:
                            loadPublicidad($("#"+b.parent().parent().data("frm")).find(".body"));
                            break;
                        case 4:
                            loadTelefonia($("#"+b.parent().parent().data("frm")).find(".body"));
                            break;
                        case 5:
                            loadVehiculo($("#"+b.parent().parent().data("frm")).find(".body"));
                            break;
                        case 6:
                            loadProveedor($("#"+b.parent().parent().data("frm")).find(".body"));
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
    sortableColumns("listCompraBiens");
    createPagination($("#frmCompraBien").find(".body"),"paginate-ordenCompra", "frmCompraBien", 1);
    loadCompraBiens($("#frmCompraBien").find(".body"));
    sortableColumns("listServicio");
    createPagination($("#frmServicio").find(".body"),"paginate-servicio", "frmServicio", 2);
    loadServicios($("#frmServicio").find(".body"));
    sortableColumns("listPublicidad");
    createPagination($("#frmPublicidad").find(".body"),"paginate-publicidad", "frmPublicidad", 3);
    loadPublicidad($("#frmPublicidad").find(".body"));
    sortableColumns("listTelefonia");
    createPagination($("#frmTelefonia").find(".body"),"paginate-telefonia", "frmTelefonia", 4);
    loadTelefonia($("#frmTelefonia").find(".body"));
    sortableColumns("listVehiculo");
    createPagination($("#frmVehiculo").find(".body"),"paginate-vehiculo", "frmVehiculo", 5);
    loadVehiculo($("#frmVehiculo").find(".body"));        
    sortableColumns("listProveedor");
    createPagination($("#frmProveedor").find(".body"),"paginate-proveedor", "frmProveedor", 6);
    loadProveedor($("#frmProveedor").find(".body"));             
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
    $("#guardarFilasCompraBien").button({
        disabled:true,
        icons:{
            primary:'ui-icon-disk'
        }
    });
    $("#guardarFilasCompraBien").on("click",guardarFilasOrden);
    $("#btnCancelarCompraBien").button({
        icons:{
            primary:'ui-icon-cancel'
        }
    });
    $("#btnCancelarCompraBien").on("click",cancelarCompraBien);

    $("#btnNuevoCompraBien").button({
        icons:{
            primary:'ui-icon-plus'
        }
    });
    $("#btnNuevoCompraBien").on("click",newCompraBien);
    $("#btnEliminarCompraBien").button({
        icons: {
            primary:'ui-icon-trash'
        }
    }).click(function(){
        delItem($("#frmCompraBien"),1,"EliminarOrdenCompra", "frmCompraBien");
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
    $("#guardarFilasServicio").button({
        disabled:true,
        icons:{
            primary:'ui-icon-disk'
        }
    });
    $("#guardarFilasServicio").on("click",guardarFilasServicio);
    $("#btnCancelarServicio").button({
        icons:{
            primary:'ui-icon-cancel'
        }
    });
    $("#btnCancelarServicio").on("click",cancelarServicio);
        
    $("#btnNuevoServicio").button({
        icons:{
            primary:'ui-icon-plus'
        }
    });
    $("#btnNuevoServicio").on("click",newServicio);
    $("#btnEliminarServicio").button({
        icons: {
            primary:'ui-icon-trash'
        }
    }).click(function(){
        delItem($("#frmServicio"),2,"EliminarOrdenServicio", "frmServicio");
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
    $("#guardarFilasPublicidad").button({
        disabled:true,
        icons:{
            primary:'ui-icon-disk'
        }
    });
    $("#guardarFilasPublicidad").on("click",guardarFilasPublicidad);
    $("#btnCancelarPublicidad").button({
        icons:{
            primary:'ui-icon-cancel'
        }
    });
    $("#btnCancelarPublicidad").on("click",cancelarPublicidad);
        
    $("#btnNuevoPublicidad").button({
        icons:{
            primary:'ui-icon-plus'
        }
    });
    $("#btnNuevoPublicidad").on("click",newPublicidad);
        
    $("#btnEliminarPublicidad").button({
        icons: {
            primary:'ui-icon-trash'
        }
    }).click(function(){
        delItem($("#frmPublicidad"),3,"EliminarPublicidad", "frmPublicidad");
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
    $("#guardarFilasTelefonia").button({
        disabled:true,
        icons:{
            primary:'ui-icon-disk'
        }
    });
    $("#guardarFilasTelefonia").on("click",guardarFilasTelefonia);
    $("#btnCancelarTelefonia").button({
        icons:{
            primary:'ui-icon-cancel'
        }
    });
    $("#btnCancelarTelefonia").on("click",cancelarTelefonia);
        
    $("#btnNuevoTelefonia").button({
        icons:{
            primary:'ui-icon-plus'
        }
    });
    $("#btnNuevoTelefonia").on("click",newTelefonia);
    $("#btnEliminarTelefonia").button({
        icons: {
            primary:'ui-icon-trash'
        }
    }).click(function(){
        delItem($("#frmTelefonia"),4,"EliminarTelefonia", "frmTelefonia");
    });
    /********************************************/
    $("#btnSubirV").button({
        disabled:true,
        icons:{
            primary:'ui-icon-disk'
        }
    });
        
    $("#archivoV").on("change",changeArchivoV);
    $("#btnSubirV").on("click",subirArchivoV);
    $("#guardarFilasVehiculo").button({
        disabled:true,
        icons:{
            primary:'ui-icon-disk'
        }
    });
    $("#guardarFilasVehiculo").on("click",guardarFilasVehiculo);
    $("#btnCancelarVehiculo").button({
        icons:{
            primary:'ui-icon-cancel'
        }
    });
    $("#btnCancelarVehiculo").on("click",cancelarVehiculo);
        
    $("#btnNuevoVehiculo").button({
        icons:{
            primary:'ui-icon-plus'
        }
    });
    $("#btnNuevoVehiculo").on("click",newVehiculo);
        
    $("#btnEliminarVehiculo").button({
        icons: {
            primary:'ui-icon-trash'
        }
    }).click(function(){
        delItem($("#frmVehiculo"),5,"EliminarVehiculo", "frmVehiculo");
    });
    /********************************************/
    $("#btnSubirPr").button({
        disabled:true,
        icons:{
            primary:'ui-icon-disk'
        }
    });
        
    $("#archivoPr").on("change",changeArchivoPr);
    $("#btnSubirPr").on("click",subirArchivoPr);
    $("#guardarFilasProveedor").button({
        disabled:true,
        icons:{
            primary:'ui-icon-disk'
        }
    });
    $("#guardarFilasProveedor").on("click",guardarFilasProveedor);
    $("#btnCancelarProveedor").button({
        icons:{
            primary:'ui-icon-cancel'
        }
    });
    $("#btnCancelarProveedor").on("click",cancelarProveedor);
        
    $("#btnNuevoProveedor").button({
        icons:{
            primary:'ui-icon-plus'
        }
    });
    $("#btnNuevoProveedor").on("click",newProveedor);
    $("#btnEliminarProveedor").button({
        icons: {
            primary:'ui-icon-trash'
        }
    }).click(function(){
        delItem($("#frmProveedor"),6,"EliminarProveedor", "frmProveedor");
    });
    /***********************************************************************/
    /************************************************************************/
    $("#txtBuscarCompraBien").keypress(function (evt){
        if(evt.keyCode==13){
            $("#current1").val(0);
            $("#start1").val(parseInt($("#current1").val())* parseInt($("#limit1").val()));
            $("#frmCompraBien").find(".body").html("");
            loadCompraBiens($("#frmCompraBien").find(".body"));
        }                    
    });
    $("#txtBuscarServicio").keypress(function (evt){
        if(evt.keyCode==13){
            $("#current2").val(0);
            $("#start2").val(parseInt($("#current2").val())* parseInt($("#limit2").val()));
            $("#frmServicio").find(".body").html("");
            loadServicios($("#frmServicio").find(".body"));
        }                    
    }); 
    $("#txtBuscarPublicidad").keypress(function (evt){
        if(evt.keyCode==13){
            $("#current3").val(0);
            $("#start3").val(parseInt($("#current3").val())* parseInt($("#limit3").val()));
            $("#frmPublicidad").find(".body").html("");
            loadPublicidad($("#frmPublicidad").find(".body"));
        }                    
    }); 
    $("#txtBuscarTelefonia").keypress(function (evt){
        if(evt.keyCode==13){
            $("#current4").val(0);
            $("#start4").val(parseInt($("#current4").val())* parseInt($("#limit4").val()));
            $("#frmTelefonia").find(".body").html("");
            loadTelefonia($("#frmTelefonia").find(".body"));
        }                    
    });
    $("#txtBuscarVehiculo").keypress(function (evt){
        if(evt.keyCode==13){
            $("#current5").val(0);
            $("#start5").val(parseInt($("#current5").val())* parseInt($("#limit5").val()));
            $("#frmVehiculo").find(".body").html("");
            loadVehiculo($("#frmVehiculo").find(".body"));
        }                    
    });
    $("#txtBuscarProveedor").keypress(function (evt){
        if(evt.keyCode==13){
            $("#current6").val(0);
            $("#start6").val(parseInt($("#current6").val())* parseInt($("#limit6").val()));
            $("#frmProveedor").find(".body").html("");
            loadProveedor($("#frmProveedor").find(".body"));
        }                    
    });
    $("#anhosComprasBienes").bind("change",function(){
        listaComprasBienes($("#anhosComprasBienes").val(),$("#frmCompraBien").find(".body"));
    });  
    $("#anhosServicio").bind("change",function(){
        listaServicios($("#anhosServicio").val(),$("#frmServicio").find(".body"));
    }); 
    $("#anhosPublicidad").bind("change",function(){
        listaPublicidad($("#anhosPublicidad").val(),$("#frmPublicidad").find(".body") );
    }); 
    $("#anhosTelefonia").bind("change",function(){
        listaTelefonia($("#anhosTelefonia").val(),$("#frmTelefonia").find(".body") );
    });
    $("#anhosVehiculo").bind("change",function(){
        listaVehiculo($("#anhosVehiculo").val(),$("#frmVehiculo").find(".body") );
    });
    $("#anhosProveedor").bind("change",function(){
        listaProveedor($("#anhosProveedor").val(),$("#frmProveedor").find(".body") );
    });
        
    $(".noMessage").click(function(){
        $(".eliminarQuestion").dialog("close");
    });
    $("body").roles();

}
    

$("document").ready(function(){
    init();
});

