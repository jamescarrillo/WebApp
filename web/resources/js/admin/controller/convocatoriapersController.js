
var opt=0,optActiNeto=0,optSub=0,optPla=0;
    
var $datafecha = function(data){
    $.datepicker.regional['es'] = {
        closeText: 'Cerrar',
        prevText: '&#x3c;Ant',
        nextText: 'Sig&#x3e;',
        currentText: 'Hoy',
        monthNames: ['Enero','Febrero','Marzo','Abril','Mayo','Junio',
        'Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'],
        monthNamesShort: ['Ene','Feb','Mar','Abr','May','Jun',
        'Jul','Ago','Sep','Oct','Nov','Dic'],
        dayNames: ['Domingo','Lunes','Martes','Mi&eacute;rcoles','Jueves','Viernes','S&aacute;bado'],
        dayNamesShort: ['Dom','Lun','Mar','Mi&eacute;','Juv','Vie','S&aacute;b'],
        dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','S&aacute;'],
        weekHeader: 'Sm',
        dateFormat: 'dd/mm/yy',
        firstDay: 1,
        isRTL: false,
        showMonthAfterYear: false,
        yearSuffix: ''
    }
    $.datepicker.setDefaults($.datepicker.regional['es']);
                
    $("#"+data).datepicker({
        //altField: "#actualDate",
        showOn: 'both',
        buttonImageOnly: true,
        buttonText: "Seleccionar Fecha",
        buttonImage: './resources/images/16x16/calendario.png'
    });
}

function createPagination(render){//creamos el pie
    var pie= $("<div/>",{
        id:'paginate-convocatorias',
        "class":"paginate ui-state-default ui-corner-bottom"
    }).css("margin-top","5px");
    var bInicio=$("<a/>",{
        "id":"binicio",
        "class":"ui-button ui-icon ui-icon-seek-first"
    });
    bInicio.on("click",function(evt){
        evt.preventDefault();
        $("#current").val(0);
        $("#start").val(parseInt($("#current").val())* parseInt($("#limit").val()));
        $(render).html("");
        loadConvocatorias(render);
    });
    var bIzquierdo=$("<a/>",{
        "id":"bizq" ,
        "class":"ui-button ui-icon ui-icon-seek-prev"                        
    });
    bIzquierdo.on("click",function(evt){
        evt.preventDefault();
        if ($("#current").val()>0){
            $("#current").val(parseInt($("#current").val())-1);
            $("#start").val(parseInt($("#current").val())* parseInt($("#limit").val()));
            $(render).html("");
            loadConvocatorias(render);
        }
    });
    var page=$("<a/>",{
        "id":"page",
        "class":"ui-button",
        "html":"0"
    });
    var bderecha=$("<a/>",{
        "id":"bder",
        "class":"ui-button ui-icon ui-icon-seek-next"
    });
    bderecha.on("click",function(evt){
        evt.preventDefault();
        if ((parseInt($("#current").val())+1)< parseInt($("#bfinal").attr("rel"))){
            $("#current").val(parseInt($("#current").val())+1);
            $("#start").val(parseInt($("#current").val())* parseInt($("#limit").val()));
            $(render).html("");
            loadConvocatorias(render);
        }                        
    });
    var bfinal=$("<a/>",{
        "id":"bfinal",
        "class":"ui-button ui-icon ui-icon-seek-end"
    });
    bfinal.on("click",function(evt){
        evt.preventDefault();
        $("#current").val(parseInt($("#bfinal").attr("rel"))-1);
        $("#start").val(parseInt($("#current").val())* parseInt($("#limit").val()));
        $(render).html("");
        loadConvocatorias(render);
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
        "id":"totalItems",
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

function createPaginationActividad(render){//creamos el pie
    var pie= $("<div/>",{
        id:'paginate-subconvocatorias',
        "class":"paginate ui-state-default ui-corner-bottom"
    }).css("margin-top","5px");
    var bInicio=$("<a/>",{
        "id":"binicioActividad",
        "class":"ui-button ui-icon ui-icon-seek-first"
    });
    bInicio.on("click",function(evt){
        evt.preventDefault();
        $("#currentActividad").val(0);
        $("#startActividad").val(parseInt($("#currentActividad").val())* parseInt($("#limitActividad").val()));
        $(render).html("");
        loadActividads(render);
    });
    var bIzquierdo=$("<a/>",{
        "id":"bizqActividad" ,
        "class":"ui-button ui-icon ui-icon-seek-prev"                        
    });
    bIzquierdo.on("click",function(evt){
        evt.preventDefault();
        if ($("#currentActividad").val()>0){
            $("#currentActividad").val(parseInt($("#currentActividad").val())-1);
            $("#startActividad").val(parseInt($("#currentActividad").val())* parseInt($("#limitActividad").val()));
            $(render).html("");
            loadActividads(render);
        }
    });
    var page=$("<a/>",{
        "id":"pageActividad",
        "class":"ui-button",
        "html":"0"
    });
    var bderecha=$("<a/>",{
        "id":"bderActividad",
        "class":"ui-button ui-icon ui-icon-seek-next"
    });
    bderecha.on("click",function(evt){
        evt.preventDefault();
        if ((parseInt($("#currentActividad").val())+1)< parseInt($("#bfinalActividad").attr("rel"))){
            $("#currentActividad").val(parseInt($("#currentActividad").val())+1);
            $("#startActividad").val(parseInt($("#currentActividad").val())* parseInt($("#limitActividad").val()));
            $(render).html("");
            loadActividads(render);
        }                        
    });
    var bfinal=$("<a/>",{
        "id":"bfinalActividad",
        "class":"ui-button ui-icon ui-icon-seek-end"
    });
    bfinal.on("click",function(evt){
        evt.preventDefault();
        $("#currentActividad").val(parseInt($("#bfinalActividad").attr("rel"))-1);
        $("#startActividad").val(parseInt($("#currentActividad").val())* parseInt($("#limitActividad").val()));
        $(render).html("");
        loadActividads(render);
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
        "id":"totalItemsActividad",
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
    
function loadActividads(render){
    $.ajax({
        url:'./ConvocatoriaPers?action=ListarCalendarioConvocatoriaPers',
        dataType:'json',
        data:{
            idConvocatoriaPers:$("#frmRegistroConvocatoriaPers").data("id"),
            query:$("#txtBuscarActividad").val().replace("&","$$"),
            limit:$("#limitActividad").val(),
            start:$("#startActividad").val(),
            current:$("#currentActividad").val()
        },
        success:function(response){
            if (response.calendario.length>0){                
                var ul=$("<ul/>",{
                    id:'listActividads'
                });                    
                $(render).append(ul);  
                $(response.calendario).each(function(index,node){                    
                    var divId=$("<div/>",{
                        id:'idActividad',
                        html:node.Id
                    }).css({
                        "width":"10%", 
                        "display": "none"
                    });
                    var divNombre=$("<div/>",{  
                        id:'nombreActividad',
                        html:node.actividad.descripcion
                    }).css("width","50%");
                    var divFechaIni=$("<div/>",{
                        id:'FechaInicio',
                        html:node.fechaInicio
                    }).css("width","20%");
                    var divFechaFin=$("<div/>",{
                        id:'FechaFin',
                        html:node.fechaFin
                    }).css("width","20%");
                    var divFile=$("<a/>",{
                        "title":"Agregar Archivos",
                        "class":"ui-button ui-icon ui-icon-document",
                        "value":node.Id
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
                    divFile.on("click",function(evt){
                        evt.preventDefault();    
                            
                        asignarFiles($(this).val());
                        $("#dialog-pers").dialog("open");
                    });
                    li.append(divId);
                    li.append(divNombre);
                    li.append(divFechaIni);
                    li.append(divFechaFin);
                    li.append(divFile);
                    ul.append(li);      
                });                
                if(parseInt( response.total)==0){
                    $("#paginate-subconvocatorias").hide();
                }else{                    
                    $("#listActividads").find("li:first").addClass("selected ui-state-highlight");
                    $("#paginate-subconvocatorias").show();
                    $("#totalItemsActividad").html(" "+"Total de Registros: "+response.total);
                }
                if(parseInt(response.pagina)==0) $("#pageActividad").html(" 1 de "+Math.ceil(parseInt(response.total)/(parseInt($("#limitActividad").val()))));
                else $("#pageActividad").html((parseInt(response.pagina)+1) + " de " +(Math.ceil(parseInt(response.total)/(parseInt($("#limitActividad").val())))));                          
                $("#bfinalActividad").attr("rel", Math.ceil(parseInt(response.total)/(parseInt($("#limitActividad").val()))));  
            }else{
                $(render).html("<ul><li><div style='color:red;'>No Hay Registros</div></li></ul>");
            }
        }
    });
}
function loadConvocatorias(render){
    $.ajax({
        url:'./ConvocatoriaPers?action=ListarConvocatoriaPers',
        dataType:'json',
        data:{
            query:$("#txtBuscarConvocatoriaPers").val().replace("&","$$"),
            limit:$("#limit").val(),
            start:$("#start").val(),
            current:$("#current").val()
        },
        success:function(response){
            if (response.items.length>0){
                var ul=$("<ul/>",{
                    id:'listConvocatorias'
                });
                $(render).append(ul);  
                $(response.items).each(function(index,node){                    
                    var divId=$("<div/>",{
                        id:'idConvocatoriaPers',
                        html:node.coperId
                    }).css({
                        "width":"10%", 
                        "display": "none"
                    });
                    var divFecha=$("<div/>",{  
                        id:'fecha',
                        html:node.fecha
                    }).css("width","10%");
                    var divNombre=$("<div/>",{
                        id:'Convocatoria',
                        html:node.convocatoria
                    }).css("width","30%");
                    var divTipo=$("<div/>",{
                        id:'descripcion',
                        html:node.descripcion
                    }).css("width","45%");
                    var divEdit=$("<a/>",{
                        "title":"Editar",
                        "class":"ui-button ui-icon ui-icon-pencil"   
                    }).css("width","11px");
                  
                    var divDel=$("<a/>",{
                        "title":"Eliminar",
                        "class":"ui-button ui-icon ui-icon-trash"                        
                    }).css("width","11px");                    
                    var divEstado=$("<a/>",{
                        "title": node.estado?"Vigente":"Finalizado",
                        "class": node.estado?"ui-button ui-icon ui-icon-circle-arrow-n":"ui-button ui-icon ui-icon-circle-arrow-s",
                        "dir": "publicar",
                        "value": node.estado
                    }).css("width","12px");
                                 
                    var li=$("<li/>").css("cursor","pointer");
                    if (!node.estado){
                        $(li).css("color","#A29494");
                    }
                    li.hover(function(){
                        $(this).addClass("ui-state-hover").css("border","none");
                    }, function(){
                        $(this).removeClass("ui-state-hover").css("border","none");
                    });
                    li.click(function(evt){
                        evt.preventDefault();
                        $("#frmActividadPorConvocatoriaPers").find(".body").html("");                                            
                        $(this).addClass("selected ui-state-highlight").siblings().removeClass("selected ui-state-highlight");
                    });
     
                    divEdit.on("click",function(evt){
                        evt.preventDefault();
                        $(li).trigger("click");
                        $("#btnEditarConvocatoriaPers").trigger("click");
                    });
                    divDel.on("click",function(evt){
                        evt.preventDefault();
                        $(li).trigger("click");
                        $("#btnEliminarConvocatoriaPers").trigger("click");
                    });
                    divEstado.click(function(evt){
                        evt.preventDefault();
                        estadoConvocatoriaPers($(this).val(), $(li));
                    });
                        
                    li.append(divId);
                    li.append(divFecha);
                    li.append(divNombre);
                    li.append(divTipo);
                    li.append(divEdit);
                    li.append(divDel);
                    li.append(divEstado);
                    ul.append(li);      
                });                
                if(parseInt( response.total)==0){
                    $("#paginate-convocatorias").hide();                    
                }else{                    
                    $("#listConvocatorias").find("li:first").addClass("selected ui-state-highlight");
                    $("#paginate-convocatorias").show();
                    $("#totalItems").html(" "+"Total de Registros: "+response.total);
                }
                if(parseInt(response.pagina)==0) $("#page").html(" 1 de "+Math.ceil(parseInt(response.total)/(parseInt($("#limit").val()))));
                else $("#page").html((parseInt(response.pagina)+1) + " de " +(Math.ceil(parseInt(response.total)/(parseInt($("#limit").val())))));                          
                $("#bfinal").attr("rel", Math.ceil(parseInt(response.total)/(parseInt($("#limit").val()))));  
            }else{
                $(render).html("<ul><li><div style='color:red;'>No Hay Registros</div></li></ul>");
            }
        }
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

function sortableColumns(){      
    $(".sortable").on("click",function(){      
        var col=$(this).attr("data");  
        var findOrder= columnType[$(this).attr("type")==undefined?"string":$(this).attr("type")](col);        
        var sortDirect=1;
        if($(this).is(".sort-asc")){
            sortDirect=-1;
        }
        var filas=$("ul#listConvocatorias").find("li").get();           
        $(filas).each(function(index,node){                
            $(node).data("sortKey",findOrder($(node).children("div").eq(col)));                        
        });
        filas.sort(function(a,b){                        
            if($(a).data("sortKey")<$(b).data("sortKey"))return -sortDirect;
            if($(a).data("sortKey")>$(b).data("sortKey"))return sortDirect;                        
            return 0;
        });
        $(filas).each(function(index,nodo){                        
            $("ul#listConvocatorias").append(nodo);
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

function validarCampos(){
    if ($("#txtNombreConvocatoriaPers").val() == "") {
        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Ingresar el Nombre Del M&oacute;dulo");
        return false;
    }else if ($("#txtDescripcionConvocatoriaPers").val()==""){
        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Ingresar la Descripci&oacute;n Del M&oacute;dulo");
        return false;
    }else if ($("#txtUrlConvocatoriaPers").val()==""){
        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Ingresar la Url Del M&oacute;dulo");
        return false;
    }
    return true;
}
    
function newConvocatoriaPers(){
    opt=0;
    $("#frmConvocatoriaPers").hide();
    $("#widget").hide();
    $("#frmConvocatoriaPers").hide();
    $("#widget").hide();
    $("#txtSintesisConvocatoriaPers").val("");
    $("#txtConvocatoriaPers").val("");
    $("#txtCostoParticipacion").val("");
    $("#txtLugarRegParticipantes").val("");
    $("#txtEstadoConvocatoriaPers").attr("checked","checked");
    $(".file").val("");
    $(".tablafile").empty();
    $("#frmRegistroConvocatoriaPers").show();
    return false;
}
    
function editConvocatoriaPers(){
    if($("#listConvocatorias").find("li.selected").length>0){
        var select=$("#listConvocatorias").find("li.selected");
        $.ajax({
            url:'./ConvocatoriaPers?action=BuscarConvocatoriaPers',
            data:{
                id:$(select).find("#idConvocatoriaPers").html()
            },
            dataType:'json',
            success:function(response){
                opt=1;
                $("#frmConvocatoriaPers").hide();
                $("#widget").hide();
                $("#txtSintesisConvocatoriaPers").val(response.convocatoria.descripcion);
                $("#txtConvocatoriaPers").val(response.convocatoria.convocatoria);
                           
                if (response.convocatoria.estado){
                    $("#txtEstadoConvocatoriaPers").attr("checked","checked");
                }
                else{
                    $("#txtEstadoConvocatoriaPers").removeAttr("checked");
                }
                    
                $("#frmRegistroConvocatoriaPers").data("id",response.convocatoria.coperId);
                $("#frmRegistroConvocatoriaPers").show();
                $("#panelActividads").show();
                $("#paginate-subconvocatorias").remove();
                $("#frmActividadPorConvocatoriaPers").find(".body").html("");
                createPaginationActividad($("#frmActividadPorConvocatoriaPers").find(".body"));
                loadActividads($("#frmActividadPorConvocatoriaPers").find(".body"));  
                //Plazas a convocar
                $("#panelPlaza").show();
                $("#paginate-plaza").remove();
                $("#frmPlazaPorConvocatoriaPers").find(".body").html("");
                createPaginationPlaza($("#frmPlazaPorConvocatoriaPers").find(".body"));
                loadPlaza($("#frmPlazaPorConvocatoriaPers").find(".body"));
            }
        });        
    }
    return false;
}
    
function delConvocatoriaPers(){
    if($("#listConvocatorias").find("li.selected").length>0){
        var select=$("#listConvocatorias").find("li.selected"); 
        opt=2;
        $(".msg-html").html("¿ESTAS SEGURO DE ELIMINAR LA CONVOCATORIA: "+select.find("#Convocatoria").html()+"?");
        $(".eliminarQuestionMod").data("idConvocatoriaPers",$(select).find("#idConvocatoriaPers").html());
        $(".eliminarQuestionMod").dialog({
            title:'Mensaje de Confirmaci&oacute;n',
            modal:true,
            resizable:false,
            width:600,
            height:150
        });
    }    
    return false;
}

function delCalendarioConvocatoria(){
    if($("#listActividads").find("li.selected").length>0){
        var select=$("#listActividads").find("li.selected"); 
        opt=4;
        
        $(".msg-html").html("¿ESTAS SEGURO DE ELIMINAR ESTA ACTIVIDAD: "+select.find("#nombreActividad").html()+"?");
        $(".eliminarQuestionMod").data("idActividad",$(select).find("#idActividad").html());
        
        $(".eliminarQuestionMod").dialog({
            title:'Mensaje de Confirmaci&oacute;n',
            modal:true,
            resizable:false,
            width:600,
            height:150
        });
    }    
    return false;
}
function delPlaza(){
    if($("#listPlaza").find("li.selected").length>0){
        var select=$("#listPlaza").find("li.selected"); 
        opt=6;
        
        $(".msg-html").html("¿ESTAS SEGURO DE ELIMINAR ESTA PLAZA: "+select.find("#cargoPlaza").html()+"?");
        $(".eliminarQuestionMod").data("idPlaza",$(select).find("#idPlaza").html());
        $(".eliminarQuestionMod").dialog({
            title:'Mensaje de Confirmaci&oacute;n',
            modal:true,
            resizable:false,
            width:600,
            height:150
        });
    }
    return false;
}

function asignarFiles(id){
    if($("#listActividads").find("li.selected").length>0){
        var select=$("#listActividads").find("li.selected");
        $("#dialog-pers").val(id);
        
        jQuery("#archivos").jgrid({
            id:'docgesgrid',
            data :"action=listarDocumentoConvocatoria&id="+id,
            url:'./ConvocatoriaPers',
            ancho:'655px',
            concat: '|',
            select: 0,
            success: function(result){
            //$funcionalidad(result,'cprint1','cpublic1', 'docgestion', 'CmbCateDocument', 11 );
            },
            getData: function(data){
                $("#archivos").data("nombre", data.split("|")[1]);
                $("#archivos").data("idDocumento", data.split("|")[0]);
            },
            model:[
            {
                name:"nombre",
                field:'nombre',
                width:"70%",
                sort:true,
                type:'string',
                cut : '.PDF',
                maxTamanio: '80'
            },
            {
                name:"urlFile",
                field:'Archivo',
                width:"30%",
                type:'string',
                maxTamanio: '80'
            },
            {
                name:"docoId",
                hidden: true
            },
            {
                name:"nombre",
                hidden: true,
                cut : '.PDF'
            }
            ]
        }).paginate({
            params:{
                start:0,
                limit:10
            }
        });
            
    }
}
function estadoConvocatoriaPers(estado, li){
    var select=li;
    opt=3;
    $(".msg-html").html("¿ESTAS SEGURO DE FINALIZAR/ACTIVAR LA CONVOCATORIA: "+select.find("#Convocatoria").html()+"?");
    $(".eliminarQuestionMod").data("idConvocatoriaPers",$(select).find("#idConvocatoriaPers").html());
    $(".eliminarQuestionMod").val(estado);
    $(".eliminarQuestionMod").dialog({
        title:'Mensaje de Confirmaci&oacute;n',
        modal:true,
        resizable:false,
        width:600,
        height:150
    });
    
    return false;
}
function guardarConvocatoriaPers(){    
    if (validarCampos()){        
        if (opt==0){
            $.ajax({
                url:'./ConvocatoriaPers?action=InsertarConvocatoriaPers',
                dataType:'json',
                data:{
                    txtSintesisConvocatoriaPers:$("#txtSintesisConvocatoriaPers").val(),
                    txtConvocatoriaPers:$("#txtConvocatoriaPers").val(),
                    txtEstadoConvocatoriaPers:$("#txtEstadoConvocatoriaPers").is(":checked")
                },
                success:function(response){
                    if ( response.success==true ){
                        $("#frmConvocatoriaPers").find(".body").html("");
                        loadConvocatorias($("#frmConvocatoriaPers").find(".body"));
                        $("#frmConvocatoriaPers").show();
                        $("#widget").show();
                        $("#frmRegistroConvocatoriaPers").hide();
                        $("#panelActividads").hide();
                            
                        $("#panelPlaza").hide();
                        $(".tablafile").empty();
                        $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg);                     
                    } else {
                        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html( response.msg);                     
                    }
                }
            });
        }else if (opt==1){    
            $.ajax({
                url:'./ConvocatoriaPers?action=ActualizarConvocatoriaPers',
                dataType:'json',
                data:{
                    idConvocatoriaPers:$("#frmRegistroConvocatoriaPers").data("id"),
                    txtSintesisConvocatoriaPers:$("#txtSintesisConvocatoriaPers").val(),
                    txtConvocatoriaPers:$("#txtConvocatoriaPers").val(),
                    txtEstadoConvocatoriaPers:$("#txtEstadoConvocatoriaPers").is(":checked")
                },
                success:function(response){
                    if (response.success==true){
                        $("#frmConvocatoriaPers").find(".body").html("");
                        loadConvocatorias($("#frmConvocatoriaPers").find(".body"));
                        $("#frmConvocatoriaPers").show();
                        $("#widget").show();
                        $("#frmRegistroConvocatoriaPers").hide();
                        $("#panelActividads").hide();
                        $("#panelPlaza").hide();
                            
                        $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg);                     
                    }else{
                        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html( response.msg);                     
                    }
                }
            });
        }
    }
    return false;
}
function cancelarConvocatoriaPers(){
    $("#frmConvocatoriaPers").find(".body").html("");
    loadConvocatorias($("#frmConvocatoriaPers").find(".body"));
    $("#frmConvocatoriaPers").show();
    $("#widget").show();
    $("#frmRegistroConvocatoriaPers").hide();
    $("#panelActividads").hide();
    $("#panelPlaza").hide();
    return false;
}
function notMessage(){
    $(".eliminarQuestionMod").dialog("close");
    return false;
}
function yesMessage(){
    if (opt==2){//es para eliminar el convocatoria
        $.ajax({
            url:'./ConvocatoriaPers?action=eliminarConvocatoriaPers',
            data:{
                id: $(".eliminarQuestionMod").data("idConvocatoriaPers")
            },
            dataType:'json',
            success:function(response){
                if (response.success){
                    $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg); 
                    $("#frmConvocatoriaPers").find(".body").html("");
                    loadConvocatorias($("#frmConvocatoriaPers").find(".body"));
                    $(".eliminarQuestionMod").dialog("close");
                }else{
                    $(".eliminarQuestionMod").dialog("close");
                    $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html( response.msg);                     
                }
            }
        });
    } else if (opt==3){
        $.ajax({
            url:'./ConvocatoriaPers?action=estadoConvocatoriaPers',
            data:{
                idConvocatoriaPers: $(".eliminarQuestionMod").data("idConvocatoriaPers"),
                estado : $(".eliminarQuestionMod").val()
            },
            dataType:'json',
            success:function(response){
                if (response.success){
                    $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg); 
                    $("#frmConvocatoriaPers").find(".body").html("");
                    loadConvocatorias($("#frmConvocatoriaPers").find(".body"));
                    $(".eliminarQuestionMod").dialog("close");
                }else{
                    $(".eliminarQuestionMod").dialog("close");
                    $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html( response.msg);                     
                }
            }
        });        
    } else if (opt==4){
        $.ajax({
            url:'./ConvocatoriaPers?action=EliminarCalendarioConvocatoria',
            data:{
                id: $(".eliminarQuestionMod").data("idActividad"),
                tipo: 2
            },
            dataType:'json',
            success:function(response){
                if (response.success){
                    $("#message2").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg); 
                    $("#frmActividadPorConvocatoriaPers").find(".body").html("");
                    loadActividads($("#frmActividadPorConvocatoriaPers").find(".body"));
                    $(".eliminarQuestionMod").dialog("close");
                } else {
                    $(".eliminarQuestionMod").dialog("close");
                    $("#message2").removeClass("ui-state-highlight").addClass("ui-state-error").html( response.msg);                     
                }
            }
        });
    } else if (opt==5) {
        $.ajax({
            url:'./ConvocatoriaPers?action=EliminarDocumentoConvocatoria',
            data:{
                id: $("#archivos").data("idDocumento")
            },
            dataType:'json',
            success:function(response){
                if (response.success){
                    $("#message6").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg); 
                    $(".eliminarQuestionMod").dialog("close");
                    asignarFiles($("#dialog-pers").val());
                } else {
                    $(".eliminarQuestionMod").dialog("close");
                    $("#message6").removeClass("ui-state-highlight").addClass("ui-state-error").html( response.msg);                     
                }
            }
        });        
    }
    if (opt==6){
        $.ajax({
            url:'./ConvocatoriaPers?action=EliminarPlazaConvocatoria',
            data:{
                id: $(".eliminarQuestionMod").data("idPlaza")
            },
            dataType:'json',
            success:function(response){
                if (response.success){
                    $("#message7").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg); 
                    $("#frmPlazaPorConvocatoriaPers").find(".body").html("");
                    loadPlaza($("#frmPlazaPorConvocatoriaPers").find(".body"));
                    $(".eliminarQuestionMod").dialog("close");
                } else {
                    $(".eliminarQuestionMod").dialog("close");
                    $("#message7").removeClass("ui-state-highlight").addClass("ui-state-error").html( response.msg);                          
                }
            }
        });
    }
    
    if (optActiNeto==2){//es para eliminar el ActiNeto
        $.ajax({
            url:'./ConvocatoriaPers?action=EliminarNombreActividad',
            data:{
                id:$("#cmbnombreActividad").val()
            },
            dataType:'json',
            success: function(response){
                if (response.success){
                    $("#message3").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg); 
                    cargarCombonombreActividad(0);
                    $(".eliminarQuestionMod").dialog("close");
                }else{
                    $(".eliminarQuestionMod").dialog("close");
                    $("#message3").removeClass("ui-state-highlight").addClass("ui-state-error").html( response.msg);                     
                }
            }
        });        
    }
    /*   if (optSub==2){//es para eliminar el subConvocatoria
        $.ajax({
            url:'./ConvocatoriaPers?action=eliminarCalendarioConvocatoria',
            data:{
                idActividad:$(".eliminarQuestionMod").data("idActividad"),
                tipo : 2
            },
            dataType:'json',
            success:function(response){
                if (response.success){
                    $("#message2").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg); 
                    $("#frmActividadPorConvocatoriaPers").find(".body").html("");
                    loadActividads($("#frmActividadPorConvocatoriaPers").find(".body"));    
                    $(".ui-dialog").dialog("close");
                }else{
                    $(".ui-dialog").dialog("close");
                    $("#message2").removeClass("ui-state-highlight").addClass("ui-state-error").html( response.msg);                     
                }
            }
        }); 
    }*/
    return false;
}
function newActividad(){
    optSub=0;
    cargarCombonombreActividad(0);
   
    $("#txtFechaInicio").val("");
    $("#txtFechaFin").val("");
    $("#txtEstadoActividad").attr("checked","checked");
    $("#frmRegistroActividad").dialog({
        title:'Registrar Item',
        resizable:false,
        modal:true,
        width:900
    });
    return false;
}

function newPlaza(){
    optPla=0;
    $("#txtCargo").val("");
    $("#txtCostoMensual").val("");
    $("#txtModalidad").val("");
    $("#frmRegistroPlaza").dialog({
        title:'Registrar Item',
        resizable:false,
        modal:true,
        width:900
    });
    return false;
}
function newActiNeto(){
    optActiNeto=0;
    $("#txtDescripcionActiNeto").val("");
    $("#frmRegistroActiNeto").dialog({
        modal:true,
        title:'Registro de Item',
        width:600,
        height:145,
        resizable:false
    });
    return false;
}
function cargarCombonombreActividad(value){    
    $.ajax({
        url:'./ConvocatoriaPers?action=ListarActividadPers',
        data: {
            idConvocatoriaPers:$("#frmRegistroConvocatoriaPers").data("id"),
            idActividad:value
        },
        success:function(response){
            $("#cmbnombreActividad").html("");
            $("#cmbnombreActividad").append(response);
            $("#cmbnombreActividad").val(value);
        }
    });
}
function cancelActiNeto(){
    $("#frmRegistroActiNeto").dialog("close");
    return false;
}
function saveActiNeto(){
    if ($("#txtDescripcionActiNeto").val()!=""){
        if (optActiNeto==0){
            $.ajax({
                url:'./ConvocatoriaPers?action=InsertarNombreActividad',
                dataType:'json',
                data:{
                    descripcion:$("#txtDescripcionActiNeto").val(),
                    tipo : 2
                },
                success:function(response){
                    if (response.success){
                        $("#message4").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg);                     
                        $("#frmRegistroActiNeto").dialog("close");
                        cargarCombonombreActividad(response.id);
                    }else{
                        $("#message4").removeClass("ui-state-highlight").addClass("ui-state-error").html(response.msg);                     
                    }
                }
            });            
        }else if(optActiNeto==1){
            $.ajax({
                url:'./ConvocatoriaPers?action=ActualizarNombreActividad',
                dataType:'json',
                data:{
                    id:$("#frmRegistroActiNeto").data("id"),
                    descripcion:$("#txtDescripcionActiNeto").val()
                },
                success:function(response){
                    if (response.success){
                        $("#message4").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg);                     
                        $("#frmRegistroActiNeto").dialog("close");
                        cargarCombonombreActividad($("#frmRegistroActiNeto").data("id"));
                        $("#frmRegistroActiNeto").removeData("id");                        
                    }else{
                        $("#message4").removeClass("ui-state-highlight").addClass("ui-state-error").html(response.msg);                     
                    }
                }
            });
        }
    }else{
        $("#message4").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Ingresar un nombre al ActiNeto");
    }
    return false;
}

function editActiNeto(){    
    if ($("#cmbnombreActividad").val()!=0){
        optActiNeto=1;
        $("#frmRegistroActiNeto").data("id",$("#cmbnombreActividad").val());   
        $("#txtDescripcionActiNeto").val($('#cmbnombreActividad option:selected').html());
        $("#frmRegistroActiNeto").dialog({
            modal:true,
            title:'Registro de Edici&oacute;n del Nombre de la Actividad',
            width:600,
            height:145,
            resizable:false
        });
    }    
    return false;
}
function delActiNeto(){
    if ($("#cmbnombreActividad").val()!=0){
        optActiNeto=2;
        $(".msg-html").html("¿ESTAS SEGURO DE ELIMINAR EL ITEM: " + $('#cmbnombreActividad option:selected').html() + " ?");
        $(".eliminarQuestionMod").dialog({
            title:'Mensaje de Confirmaci&oacute;n',   
            modal:true,
            resizable:false,
            width:400,
            height:120
        });
    }
    return false;
}
function delDocumento(){
    opt=5;
    $(".eliminarQuestionMod").data("idDocumento");
    $(".msg-html").html("¿ESTAS SEGURO DE ELIMINAR EL DOCUMENTO: " + $("#archivos").data("nombre") + "?");
    $(".eliminarQuestionMod").dialog({
        title:'Mensaje de Confirmaci&oacute;n',   
        modal:true,
        resizable:false,
        width:400,
        height:145
    });
    
    return false;
}
function cancelActividad(){
    $("#frmRegistroActividad").dialog("close");
    return false;
}
function cancelPlaza(){
    $("#frmRegistroPlaza").dialog("close");
    return false;
}
function validarCamposActividad(){
    if ($("#txtFechaInicio").val() == "") {
        $("#message3").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Ingresar Fecha de Inicio de la actividad");
        return false;
    }else if ($("#txtFechaFin").val() == "") {
        $("#message3").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Ingresar Fecha de Finalizacion de la actividad");
        return false;
    }
    return true;
}
function guardarActividad(){
    if (validarCamposActividad()){
        if (optSub==0){//insertar Actividad
            $.ajax({
                url:'./ConvocatoriaPers?action=insertarCalendarioConvocatoriaPers',
                dataType:'json',
                data:{
                    txtFechaInicio:$("#txtFechaInicio").val(),
                    txtFechaFin:$("#txtFechaFin").val(),
                    txtEstadoActividad:$("#txtEstadoActividad").is(":checked"),
                    cmbnombreActividad:$("#cmbnombreActividad").val(),
                    idConvocatoriaPers:$("#frmRegistroConvocatoriaPers").data("id")
                },
                success:function(response){
                    if (response.success==true){
                        $("#frmActividadPorConvocatoriaPers").find(".body").html("");
                        loadActividads($("#frmActividadPorConvocatoriaPers").find(".body"));                       
                        $("#frmRegistroActividad").dialog("close");                        
                        $("#message3").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg);                     
                    }else{
                        $("#message3").removeClass("ui-state-highlight").addClass("ui-state-error").html( response.msg);                     
                    }
                }
            });
                
        }else if (optSub==1){
            $.ajax({
                url:'./ConvocatoriaPers?action=ActualizarCalendarioConvocatoriaPers',
                dataType:'json',
                data:{
                    txtFechaInicio:$("#txtFechaInicio").val(),
                    txtFechaFin:$("#txtFechaFin").val(),
                    txtEstadoActividad:$("#txtEstadoActividad").is(":checked"),
                    cmbnombreActividad:$("#cmbnombreActividad").val(),
                    idCalendario: $("#frmRegistroActividad").data("id")
                },
                success:function(response){
                    if (response.success==true){
                        $("#frmActividadPorConvocatoriaPers").find(".body").html("");
                        loadActividads($("#frmActividadPorConvocatoriaPers").find(".body"));                       
                        $("#frmRegistroActividad").dialog("close");                        
                        $("#message3").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg);                     
                    }else{
                        $("#message3").removeClass("ui-state-highlight").addClass("ui-state-error").html( response.msg);                     
                    }
                }
            });
        }
    }
    return false;
}
   
function guardarPlaza(){
    //if (validarCamposPlaza()){
    if (optPla==0){//insertar Actividad
        if ($("#opcion").val()=="1") {
            $.ajax({
                url:'./ConvocatoriaPers?action=insertarPlazaConvocatoria',
                dataType:'json',
                data:{
                    txtCargo:$("#txtCargo").val(),
                    txtCostoMensual:$("#txtCostoMensual").val(),
                    txtModalidad:$("#txtModalidad").val(),
                    idConvocatoriaPers:$("#frmRegistroConvocatoriaPers").data("id")
                },
                success:function(response){
                    if (response.success==true){
                        $("#frmPlazaPorConvocatoriaPers").find(".body").html("");
                        loadPlaza($("#frmPlazaPorConvocatoriaPers").find(".body"));                       
                        $("#frmRegistroPlaza").dialog("close");                        
                        $("#message7").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg);                     
                    }else{
                        $("#message7").removeClass("ui-state-highlight").addClass("ui-state-error").html( response.msg);                     
                    }
                }
            });
        } else {
            $.ajax({
                url:'./ConvocatoriaPers?action=ModificarPlazaConvocatoria',
                dataType:'json',
                data:{
                    txtCargo:$("#txtCargo").val(),
                    txtCostoMensual:$("#txtCostoMensual").val(),
                    txtModalidad:$("#txtModalidad").val(),
                    idPlaza: $("#txtIdPlaza").val(),
                    txtNroPlaza : $("#txtPlazas").val()
                },
                success:function(response){
                    if (response.success==true){
                        $("#frmPlazaPorConvocatoriaPers").find(".body").html("");
                        loadPlaza($("#frmPlazaPorConvocatoriaPers").find(".body"));
                        $("#frmRegistroPlaza").dialog("close");                        
                        $("#message7").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg);                     
                    }else{
                        $("#message7").removeClass("ui-state-highlight").addClass("ui-state-error").html( response.msg);                     
                    }
                }
            });
        }
                
    }else if (optSub==1){
        $.ajax({
            url:'./ConvocatoriaPers?action=ActualizarCalendarioConvocatoriaPers',
            dataType:'json',
            data:{
                txtFechaInicio:$("#txtFechaInicio").val(),
                txtFechaFin:$("#txtFechaFin").val(),
                txtEstadoActividad:$("#txtEstadoActividad").is(":checked"),
                cmbnombreActividad:$("#cmbnombreActividad").val(),
                idCalendario: $("#frmRegistroActividad").data("id")
            },
            success:function(response){
                if (response.success==true){
                    $("#frmActividadPorConvocatoriaPers").find(".body").html("");
                    loadActividads($("#frmActividadPorConvocatoriaPers").find(".body"));                       
                    $("#frmRegistroActividad").dialog("close");                        
                    $("#message3").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg);                     
                }else{
                    $("#message3").removeClass("ui-state-highlight").addClass("ui-state-error").html( response.msg);                     
                }
            }
        });
    }
    // }
    return false;
}
        
function editActividad(){
    
    if($("#listActividads").find("li.selected").length>0){
        var select=$("#listActividads").find("li.selected");
        $.ajax({
            url:'./ConvocatoriaPers?action=buscarCalendarioConvocatoriaPers',
            data:{
                id:$(select).find("#idActividad").html()
            },
            dataType: 'json',
            success: function(response){
                
                optSub=1;              
                $("#txtFechaInicio").val(response.calendario.fechaInicio);                
                $("#txtFechaFin").val(response.calendario.fechaFin);
                if (response.calendario.estado){
                    $("#txtEstadoActividad").attr("checked","checked");
                }
                else {
                    $("#txtEstadoActividad").removeAttr("checked");
                }
                $("#frmRegistroActividad").data("id",response.calendario.Id);
                    
                cargarCombonombreActividad(response.calendario.actividad.actiId);       
                
                $("#frmRegistroActividad").dialog({
                    modal:true,
                    title:'Edición de La Actividad',
                    width:900,
                    resizable:false
                });
            }
        });        
    }
    return false;
}





var dialog=function(){
    return $("<div id='dialog-file-m' title='Documentos'>\n\
                <fieldset id='form1' class='ui-widget ui-widget-content ui-corner-top'>\n\
                    <div>\n\
                    <label>Titulo: </label>\n\
                    <input type='text' value='' style='width: 98%; float:left padding:5px' id ='titulo' name='titulo'  />\n\
                    </div>\n\
                    <div>\n\
                    <label>Archivo: </label>\n\
                    <input type='text' value='' style='width: 98%; float:left padding:5px' id ='archivo' name='archivo' />\n\
                    <input value='' id='codigo' name='codigo' type='hidden' />\n\
                    <form id='file_upload' action='./Upload' method='POST' style='float:left' enctype='multipart/form-data' >\n\
                    <div id='drop_zone_1' style='width: 37px;  height: 25px; ' >\n\
                        <input style='width: 35px; float: left;' id='file_1' type='file' name='file_1' >\n\
                        <div style='width: 25px; float: left;'> <img src='./resources/images/16x16/add-hover.png' ></div>\n\
                    </div>\n\
                    </div>\n\
                    </form>\n\
                    <table id='files_1' class='tablafile' style='background:yellow;'></table>\n\
                    </fieldset>\n\
            <fieldset class='ui-widget-content ui-corner-bottom' style='text-align:center; padding: 5px 0px'><button type='button' id='guardar'>Guardar</button><button type='button' id='close'>Cerrar</button></fieldset>\n\
            </div>");
        
}
var submit_docu =function() {
    var name = $( "#titulo" );
    var allFields = $( [] ).add( name );

    function checkLength( o,  min, max ) {
        if ( o.val().length > max || o.val().length < min ) {
            o.addClass( "ui-state-error" );
            return false;
        } else {
            return true;
        }
    }
    function checkRegexp( o, regexp ) {
        var text = o.val();
        if (text.length<=1)text=text+text;
        if ( !( regexp.test( text ) ) ) {
            o.addClass( "ui-state-error" );
            return false;
        } else return true;
    }

    var bValid = true;
    allFields.removeClass( "ui-state-error" );

    if ( bValid ) {
        $.ajax({
            type: 'POST',
            url: './ConvocatoriaPers?action=InsertarDocumentoPers',
            data:$("#form1").serialize(),
            dataType:'json',
            success: function(data){

                asignarFiles($("#dialog-pers").val());
                $("#dialog-file-m").dialog("close");
            }
        });
    }
    return false;
}
function createPaginationPlaza(render){//creamos el pie de plazas
    var pie= $("<div/>",{
        id:'paginate-plaza',
        "class":"paginate ui-state-default ui-corner-bottom"
    }).css("margin-top","5px");
    var bInicio=$("<a/>",{
        "id":"binicioPlaza",
        "class":"ui-button ui-icon ui-icon-seek-first"
    });
    bInicio.on("click",function(evt){
        evt.preventDefault();
        $("#currentPlaza").val(0);
        $("#startPlaza").val(parseInt($("#currentPlaza").val())* parseInt($("#limitPlaza").val()));
        $(render).html("");
        loadPlaza(render);
    });
    var bIzquierdo=$("<a/>",{
        "id":"bizqPlaza" ,
        "class":"ui-button ui-icon ui-icon-seek-prev"                        
    });
    bIzquierdo.on("click",function(evt){
        evt.preventDefault();
        if ($("#currentPlaza").val()>0){
            $("#currentPlaza").val(parseInt($("#currentPlaza").val())-1);
            $("#startPlaza").val(parseInt($("#currentPlaza").val())* parseInt($("#limitPlaza").val()));
            $(render).html("");
            loadPlaza(render);
        }
    });
    var page=$("<a/>",{
        "id":"pagePlaza",
        "class":"ui-button",
        "html":"0"
    });
    var bderecha=$("<a/>",{
        "id":"bderPlaza",
        "class":"ui-button ui-icon ui-icon-seek-next"
    });
    bderecha.on("click",function(evt){
        evt.preventDefault();
        if ((parseInt($("#currentPlaza").val())+1)< parseInt($("#bfinalPlaza").attr("rel"))){
            $("#currentPlaza").val(parseInt($("#currentPlaza").val())+1);
            $("#startPlaza").val(parseInt($("#currentPlaza").val())* parseInt($("#limitPlaza").val()));
            $(render).html("");
            loadConvocatorias(render);
        }                        
    });
    var bfinal=$("<a/>",{
        "id":"bfinalPlaza",
        "class":"ui-button ui-icon ui-icon-seek-end"
    });
    bfinal.on("click",function(evt){
        evt.preventDefault();
        $("#currentPlaza").val(parseInt($("#bfinalPlaza").attr("rel"))-1);
        $("#startPlaza").val(parseInt($("#currentPlaza").val())* parseInt($("#limitPlaza").val()));
        $(render).html("");
        loadPlaza(render);
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
        "id":"totalItemsPlaza",
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
function loadPlaza(render){
    $.ajax({
        url:'./ConvocatoriaPers?action=listarPlazaConvocatoriaForAdmin',
        dataType:'json',
        data:{
            idConvocatoriaPers:$("#frmRegistroConvocatoriaPers").data("id"),
            query:$("#txtBuscarPlaza").val().replace("&","$$"),
            limit:$("#limitPlaza").val(),
            start:$("#startPlaza").val(),
            current:$("#currentPlaza").val()
        },
        success:function(response){
            if (response.plaza.length>0){                
                var ul=$("<ul/>",{
                    id:'listPlaza'
                });                    
                $(render).append(ul);  
                $(response.plaza).each(function(index,node){                    
                    var divId=$("<div/>",{
                        id:'idPlaza',
                        html:node.puesId
                    }).css({
                        "width":"10%", 
                        "display": "none"
                    });
                    var divCargo=$("<div/>",{  
                        id:'cargoPlaza',
                        html:node.cargo
                    }).css("width","45%");
                    var divModalidad=$("<div/>",{
                        id:'modalidad',
                        html:node.modalidad
                    }).css("width","20%");
                    var divIngreso=$("<div/>",{
                        id:'ingresoPlaza',
                        html:node.ingreMensual
                    }).css("width","15%");
                    var divVacantes=$("<div/>",{
                        id:'vacantesPlaza',
                        html:node.nroPlaza
                    }).css("width","10%");        
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

                    li.append(divId);
                    li.append(divCargo);
                    li.append(divIngreso);
                    li.append(divModalidad);
                    li.append(divVacantes);
                    ul.append(li);
                });                
                if(parseInt( response.total)==0){
                    $("#paginate-plaza").hide();                    
                }else{                    
                    $("#listPlaza").find("li:first").addClass("selected ui-state-highlight");
                    $("#paginate-Plaza").show();
                    $("#totalItemsPlaza").html(" "+"Total de Registros: "+response.total);
                }
                if(parseInt(response.pagina)==0) $("#pagePlaza").html(" 1 de "+Math.ceil(parseInt(response.total)/(parseInt($("#limitPlaza").val()))));
                else $("#pagePlaza").html((parseInt(response.pagina)+1) + " de " +(Math.ceil(parseInt(response.total)/(parseInt($("#limitPlaza").val())))));                          
                $("#bfinalPlaza").attr("rel", Math.ceil(parseInt(response.total)/(parseInt($("#limitPlaza").val()))));  
            }else{
                $(render).html("<ul><li><div style='color:red;'>No Hay Registros</div></li></ul>");
            }
        }
    });
}

var $validImportantes  = function(e, a){
    cont = 0;
    $.each($(e),function(i){
        if ($(this).val()==""){
            cont++;
        }
    });
    if (cont!=0)
        $(a).button({
            disabled: true,
            icons: {
                primary:'ui-icon-disk'
            }
        });
    else
        $(a).button({
            disabled: false,
            icons: {
                primary:'ui-icon-disk'
            }
        });
}

function editPlaza(){
    if($("#listPlaza").find("li.selected").length>0){
        var select=$("#listPlaza").find("li.selected");
        $("#txtCargo").val(select.find("#cargoPlaza").html());
        $("#txtCostoMensual").val(select.find("#ingresoPlaza").html());
        $("#txtModalidad").val(select.find("#modalidad").html());
        $("#txtPlazas").val(select.find("#vacantesPlaza").html());
        $("#txtIdPlaza").val(select.find("#idPlaza").html());
        $("#opcion").val("2");
        $("#frmRegistroPlaza").dialog({
            title:'Registrar Item',
            resizable:false,
            modal:true,
            width:900,
            close: function(){
                $("#txtCargo").val("");
                $("#txtCostoMensual").val("");
                $("#txtModalidad").val("");
                $("#txtPlazas").val("");
                $("#opcion").val("1");
                $("#txtIdPlaza").val("");
            }
        });
    }
}

function init(){
    $datafecha("txtFechaInicio");
    $datafecha("txtFechaFin");
        
    $(".import").bind("change",function(){
        $validImportantes(".import", "#btnGuardarConvocatoriaPers");
    });
    $(".import").keyup(function(){
        $validImportantes(".import", "#btnGuardarConvocatoriaPers");
    });

    $(".importPlaza").keyup(function (evt){
        $validImportantes(".importPlaza", "#btnGuardarPlaza");
    });        
        
    var $dialogo = $( "#dialog-pers" ).dialog({
        autoOpen: false,
        modal: true,
        show: "blind",
        hide: "explode",
        resizable: false,
        width: '680px',
        buttons: {
            "Aceptar": function() {
                $( this ).dialog( "close" );
            }
        }
    });
            
    var $dialog = dialog();
            
    $dialog.dialog({
        autoOpen: false,
        modal: true,
        show: "blind",
        hide: "explode",
        resizable: false,
        width: '480px',
        close: function(){
            $("#codigo").val("");
            $("#archivo").val("");
            $("#titulo").val("");
            $("#files_1").html("");
        }
    });
    /****boton guardar documento*/
    $("#guardar").button({
        disabled: true,
        icons: {
            primary:'ui-icon-disk'
        }
    }).click(function(){
        submit_docu();
    })
    /*******cerrar nuevo documento*////
    $("#close").button({
        icons: {
            primary:'ui-icon-cancel'
        }
    }).click(function(){
        $dialog.dialog("close");
    })
    /***********************************************++++++++++************************************/
    /*++++++++++++++++++++++++++++++++++++++++MODIFICAR++++++++++++++++++++++++++++++++++++++++++*/
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    $("#modificar").button({
        icons: {
            primary:'ui-icon-pencil'
        }
    }).click(function(){
        });
    /***********************************************++++++++++************************************/
    /*++++++++++++++++++++++++++++++++++++++++NUEVO+++++++++++++++++++++++++++++++++++++++++++++*/
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/       
    $( "#nuevo" ).button({
        icons: {
            primary:'ui-icon-document'
        }
    }).click(function() {
        $("#codigo").val($("#dialog-pers").val());
        $( "#dialog-file-m" ).dialog("open");
    });
        
    $("#eliminar").button({
        icons: {
            primary:'ui-icon-disk'
        }
    }).click(function(){
        delDocumento();
    });
        
    sortableColumns();        
    createPagination($("#frmConvocatoriaPers").find(".body"));
    loadConvocatorias($("#frmConvocatoriaPers").find(".body"));

    $("#btnNuevoConvocatoriaPers").button({
        icons:{
            primary:'ui-icon-plus'
        }
    });
    $("#btnNuevoConvocatoriaPers").on("click",newConvocatoriaPers);
    $("#btnEditarConvocatoriaPers").button({
        icons:{
            primary:'ui-icon-pencil'
        }
    }); 
    $("#btnEditarConvocatoriaPers").on("click",editConvocatoriaPers);        
    $("#btnEliminarConvocatoriaPers").button({
        icons: {
            primary:'ui-icon-trash'
        }
    });
    $("#btnEliminarConvocatoriaPers").on("click",delConvocatoriaPers);
    $("#btnGuardarConvocatoriaPers").button({
        disabled: true,
        icons:{
            primary:'ui-icon-disk'
        }
    });
    $("#btnGuardarConvocatoriaPers").on("click",guardarConvocatoriaPers);
    $("#btnCancelarConvocatoriaPers").button({
        icons:{
            primary:'ui-icon-cancel'
        }
    });
    $("#btnCancelarConvocatoriaPers").on("click",cancelarConvocatoriaPers);
    $(".siMessage").on("click",yesMessage);
    $("#btnNuevoActividad").button({
        icons:{
            primary:'ui-icon-plus'
        }
    })
            
    $("#btnNuevoPlaza").button({
        icons:{
            primary:'ui-icon-plus'
        }
    }).on("click",newPlaza);
            
    $(".noMessage").on("click",notMessage);
    $("#btnEditarActividad").button({
        icons:{
            primary:'ui-icon-pencil'
        }
    }).on("click",editActividad);
    $("#btnEliminarActividad").button({
        icons: {
            primary:'ui-icon-trash'
        }
    });
    $("#btnEliminarPlaza").button({
        icons: {
            primary:'ui-icon-trash'
        }
    }).on("click",delPlaza)

    $("#btnEditarPlaza").button({
        icons:{
            primary:'ui-icon-pencil'
        }
    }).on("click",editPlaza);
    $("#btnEliminarActividad").on("click",delCalendarioConvocatoria);
    $("#btnNuevoActividad").on("click",newActividad);
    $("#btnNuevonombreActividad").on("click",newActiNeto);
    $("#btnEditarnombreActividad").on("click",editActiNeto);
    $("#btnCancelarActiNeto").button({
        icons: {
            primary:'ui-icon-close'
        }
    });
    $("#btnCancelarActiNeto").on("click",cancelActiNeto);
    $("#btnGuardarActiNeto").button({
        icons: {
            primary:'ui-icon-disk'
        }
    });
    $("#btnGuardarActiNeto").on("click",saveActiNeto);
    $("#btnEliminarnombreActividad").on("click",delActiNeto);
    $("#btnCancelarActividad").button({
        icons:{
            primary:'ui-icon-cancel'
        }
    });
    $("#btnCancelarActividad").on("click",cancelActividad);
    $("#btnGuardarActividad").button({
        icons:{
            primary:'ui-icon-disk'
        }
    });
    $("#btnGuardarActividad").on("click",guardarActividad);
            
    $("#txtBuscarConvocatoriaPers").keypress(function (evt){
        if(evt.keyCode==13){
            $("#current").val(0);
            $("#start").val(parseInt($("#current").val())* parseInt($("#limit").val()));
            $("#frmConvocatoriaPers").find(".body").html("");
            loadConvocatorias($("#frmConvocatoriaPers").find(".body"));
        }                    
    });
            
    $("#btnCancelarPlaza").button({
        icons:{
            primary:'ui-icon-cancel'
        }
    }).on("click",cancelPlaza);
            
    $("#btnGuardarPlaza").button({
        disabled: true,
        icons:{
            primary:'ui-icon-disk'
        }
    });
        
    $("#btnGuardarPlaza").on("click",guardarPlaza);
            
    var initFileUpload = function (suffix) {
        var id = suffix;
        $('#file_upload').fileUploadUI({
            namespace: 'file_upload_' + suffix,
            fileInputFilter: '#file_' + suffix,
            dropZone: $('#drop_zone_' + suffix),
            uploadTable: $('#files_' + suffix),
            downloadTable: $('#files_' + suffix),
            buildUploadRow: function (files, index) {
                return $('<tr><td>' + files[index].name + '<\/td>' +
                    '<td class="file_upload_progress"><div><\/div><\/td>' +
                    '<td class="file_upload_cancel">' +
                    '<button class="ui-state-default ui-corner-all" title="Cancel">' +
                    '<span class="ui-icon ui-icon-cancel">Cancel<\/span>' +
                    '<\/button><\/td><\/tr>');
            },
            buildDownloadRow: function (file)
            {
                $("#guardar").button({
                    disabled: false,
                    icons: {
                        primary:'ui-icon-disk'
                    }
                });
                $("#archivo").val(file.nametrue);
                return $('<tr><td>' + file.name + '<\/td><\/tr>');
            }
        });
    }
    initFileUpload(1);
    $("body").roles();
}

$("document").ready(function(){
    init();
});
