var opt=0,optActiNeto=0,optSub=0;
    
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
    var obtenerfecha   = function(){
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth()+1; //January is 0!

        var yyyy = today.getFullYear();
        if(dd<10){
            dd='0'+dd
        }
        if(mm<10){
            mm='0'+mm
        }
        today = dd+'/'+mm+'/'+yyyy;
        return today;
    }
    
    $("#"+data).datepicker({
        beforeShowDay: $.datepicker.noWeekends,
        showOn: 'both',
        buttonImageOnly: true,
        buttonText: "Seleccionar Fecha",
        buttonImage: './resources/images/16x16/calendario24.png'
    }).val(obtenerfecha());
}

function fechaUnFormat(fecha){
    var formato
    var $fecha = fecha.split("-");
    formato = $fecha[2].trim(" ") + "/"+ $fecha[1].trim(" ")  +"/" +$fecha[0].trim(" ");
    return  formato;
}

function validarCampos(){
    if($("#contenidoComentario").val() == ""){
        $("#message").removeClass("ui-state-hightlight").addClass("ui-state-error").html("No puede borrar todo el cotenido del Comentario");
        return false;
    }else if($("#tema").val()==""){
        $("#message").removeClass("ui-state-hightlight").addClass("ui-state-error").html("No puede borrar todo el Tema del Comentario");
        return false;
    }
    return true;
}

function createPagination(render){//creamos el pie
    var pie= $("<div/>",{
        id:'paginate-actividads',
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
        loadActividads(render);
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
            loadActividads(render);
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
            loadActividads(render);
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

function loadActividads(render){
    $.ajax({
        url:'./GestionTransparente?action=ListarAgendaForAdmin',
        dataType:'json',
        cache: false,
        data:{
            idActividad:$("#frmRegistroActividad").data("id"),
            query:$("#txtBuscarActividad").val().replace("&","$$"),
            limit:$("#limit").val(),
            start:$("#start").val(),
            current:$("#current").val(),
            tipo:$("#txtTipo").val(),
            fechaFiltro: $("#txtFechaFiltro").val(),
            filtro:$("#frmActividad").data("filtro")
        },
        success:function(response){
            if (response.items.length>0){
                var ul=$("<ul/>",{
                    id:'listActividads'
                });
                $(render).append(ul);
                $(response.items).each(function(index,node){
                    var divId=$("<div/>",{
                        id:'idActividad',
                        html:node.id
                    }).css("display","none");
                    
                    var divHora=$("<div/>",{
                        id:'horaActividad',
                        html:node.horaInicio
                    }).css("width","10%");
                    
                    var divFechaIni=$("<div/>",{
                        id:'Fecha',
                        html:node.fechaInicio
                    }).css("width","10%");
                    
                    var tamanio = function(node,max){
                        if (node.length>max)
                            return node.substring(0,max)+"...";
                        else
                            return node;
                    }
                    var divActividad=$("<div/>",{
                        id:'actiAgenda',
                        html:tamanio(node.actividad,120)
                    }).css("width","26%");
                    
                    var divCiudad=$("<div/>",{
                        id:'ciudadAgenda',
                        html:node.ciudad
                    }).css("width","14%");
                    
                    var divLugar=$("<div/>",{
                        id:'lugarAgenda',
                        html:tamanio(node.lugar,120)
                    }).css("width","25%");
                    
                    var divEdit=$("<a/>",{
                        "title":"Editar",
                        "class":"ui-button ui-icon ui-icon-pencil"   
                    }).css("width","11px");
                    
                    var divDel=$("<a/>",{
                        "title":"Eliminar",
                        "class":"ui-button ui-icon ui-icon-trash"                        
                    }).css("width","11px");
                    var msn = "";
                    var icon = "";
                    if (node.estado) { 
                        msn = "Publico"; 
                        icon = "ui-button ui-icon ui-icon-circle-arrow-s";
                    }
                    else{ 
                        msn = "No Publico"; 
                        icon = "ui-button ui-icon ui-icon-circle-arrow-n";
                    }
                    
                    var divEstado=$("<a/>",{
                        "title":msn,
                        "class":icon,
                        "rel": "publicar",
                        "value": node.estado
                    }).css("width","12px");
                                 
                    divEdit.on("click",function(evt){
                        evt.preventDefault();
                        $(li).trigger("click");
                        $("#btnEditarActividad").trigger("click");
                    });
                    divDel.on("click",function(evt){
                        evt.preventDefault();
                        $(li).trigger("click");
                        $("#btnEliminarActividad").trigger("click");
                    });

                    divEstado.click(function(evt){
                        evt.preventDefault();
                        estadoActividadAgenda($(this).val(), $(li));
                    });
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
                    li.append(divHora);
                    li.append(divFechaIni);
                    li.append(divActividad);
                    li.append(divCiudad);
                    li.append(divLugar);
                    li.append(divEstado);
                    li.append(divEdit);
                    li.append(divDel);
                    ul.append(li);
                });
                
                if(parseInt( response.total )==0){
                    $("#paginate-actividads").hide();
                }else{                    
                    $("#listActividads").find("li:first").addClass("selected ui-state-highlight");
                    $("#paginate-actividads").show();
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
        var filas=$("ul#listActividads").find("li").get();           
        $(filas).each(function(index,node){                
            $(node).data("sortKey",findOrder($(node).children("div").eq(col)));                        
        });
        filas.sort(function(a,b){                        
            if($(a).data("sortKey")<$(b).data("sortKey"))return -sortDirect;
            if($(a).data("sortKey")>$(b).data("sortKey"))return sortDirect;                        
            return 0;
        });
        $(filas).each(function(index,nodo){                        
            $("ul#listActividads").append(nodo);
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
    if ($("#txtActividad").val() == "" || $("#txtActividad").val().length > 300) {
        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Ingresar una Descripci&oacute;n De la Actividad Menor a 300 Digitos, No dejar en Blanco");
        return false;
    }else if ($("#txtFecha").val()==""){
        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html("Seleccione Una Fecha, Para Su Actividad");
        return false;
    }else if ($("#txtHora").val()==""){
        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Ingresar Por Lo menos la hora de Inicio");
        return false;
    } else if ($("#txtLugar").val() == "" || $("#txtLugar").val().length > 200) {
        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Ingresar una Descripci&oacute;n Del Lugar Menor a 200 Digitos, No dejar en Blanco");
        return false;
    }
    return true;
}
function newActividad(){
    opt=0;
    $("#frmActividad").hide();
    $("#widget").hide();
    $("#frmRegistroActividad").hide();
    $("#widget").hide();
    $("#txtActividad").val("");
    $("#txtFecha").val("");
    $("#txtHora").val("");
    $("#txtHoraFinal").val("");
    $("#txtCiudad").val("");
    $("#txtLugar").val("");
    $("#frmRegistroActividad").show();
    return false;
}
    
function editActividad(){
    if($("#listActividads").find("li.selected").length>0){
        var select=$("#listActividads").find("li.selected");
        $.ajax({
            url:'./GestionTransparente?action=BuscarActividadAgenda',
            cache: false,
            data:{
                id:$(select).find("#idActividad").html()
            },
            dataType:'json',
            success:function(response){
                opt=1;
                $("#frmActividad").hide();
                $("#widget").hide();
                $("#txtActividad").val(response.actividad.actividad);
                $("#txtFecha").val(response.actividad.fechaInicio);
                $("#txtHora").val(response.actividad.horaInicio);
                $("#txtHoraFinal").val(response.actividad.horaFinal);
                $("#txtCiudad").val(response.actividad.ciudad);
                $("#txtLugar").val(response.actividad.lugar);
                $("#txtTipo").val(response.actividad.tipo);
                if (response.actividad.estado){
                    $("#txtEstado").attr("checked","checked");
                }
                else{
                    $("#txtEstado").removeAttr("checked");
                }
                $("#frmRegistroActividad").data("id",response.actividad.id);
                $("#frmRegistroActividad").show();
                $("#panelActividads").show();
                $("#paginate-subactividads").remove();
                $("#frmRegistroActividad").find(".body").html("");
                createPagination($("#frmRegistroActividad").find(".body"));
                loadActividads($("#frmRegistroActividad").find(".body"));  
            }
        });        
    }
    return false;
}
function delActividad(){
    if($("#listActividads").find("li.selected").length>0){
        var select=$("#listActividads").find("li.selected"); 
        opt=2;
        $(".msg-html").html("¿ESTAS SEGURO DE ELIMINAR ESTE ITEM: "+select.find("#actiAgenda").html()+"?");
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
function estadoActividadAgenda(estado, li){
    var select=li;
    opt=3;
    $(".msg-html").html("¿ESTAS SEGURO DE PUBLICAR/OCULTAR LA ACTIVIDAD DE SU AGENDA: "+select.find("#actiAgenda").html()+"?");
    $(".eliminarQuestionMod").data("idActividad",$(select).find("#idActividad").html());
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

function guardarActividad(){    
    if (validarCampos()){        
        if (opt==0){
            $.ajax({
                url:'./GestionTransparente?action=ActualizarActividadAgenda&opt='+0,
                type: 'POST',
                cache: false,
                dataType:'json',
                data: $("#frmRegistroActividadSend").serialize(),
                success:function(response){
                    if ( response.success==true ){
                        $("#frmActividad").find(".body").html("");
                        loadActividads($("#frmActividad").find(".body"));
                        $("#frmActividad").show();
                        $("#widget").show();
                        $("#frmRegistroActividad").hide();
                        $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg);                     
                    } else {
                        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html( response.msg);                     
                    }
                }
            });
        }else if (opt==1){    
            $.ajax({
                url:'./GestionTransparente?action=ActualizarActividadAgenda&opt=1&codigo='+$("#frmRegistroActividad").data("id"),
                dataType:'json',
                cache: false,
                type: 'POST',
                data: $("#frmRegistroActividadSend").serialize(),
                success:function(response){
                    if (response.success==true){
                        $("#frmActividad").find(".body").html("");
                        loadActividads($("#frmActividad").find(".body"));
                        $("#frmActividad").show();
                        $("#widget").show();
                        $("#frmRegistroActividad").hide();
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
function cancelarActividad(){
    $("#frmActividad").find(".body").html("");
    loadActividads($("#frmActividad").find(".body"));
    $("#frmActividad").show();
    $("#widget").show();
    $("#frmRegistroActividad").hide();
    $("#panelActividads").hide();
    return false;
}

function notMessage(){
    $(".eliminarQuestionMod").dialog("close");
    return false;
}

function yesMessage(){
    if (opt==2){//es para eliminar el actividad
        $.ajax({
            url:'./GestionTransparente?action=EliminarActividadAgenda',
            cache: false,
            data:{
                id: $(".eliminarQuestionMod").data("idActividad")
            },
            dataType:'json',
            success:function(response){
                if (response.success){
                    $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg); 
                    $("#frmActividad").find(".body").html("");
                    loadActividads($("#frmActividad").find(".body"));
                    $(".eliminarQuestionMod").dialog("close");
                } else {
                    $(".eliminarQuestionMod").dialog("close");
                    $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html( response.msg);                     
                }
            }
        });
    } else if (opt==3){
        $.ajax({
            url:'./GestionTransparente?action=EstadoActividadAgenda',
            cache: false,
            data:{
                id: $(".eliminarQuestionMod").data("idActividad"),
                estado : $(".eliminarQuestionMod").val()
            },
            dataType:'json',
            success:function(response){
                if (response.success){
                    $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg); 
                    $("#frmActividad").find(".body").html("");
                    loadActividads($("#frmActividad").find(".body"));
                    $(".eliminarQuestionMod").dialog("close");
                }else{
                    $(".eliminarQuestionMod").dialog("close");
                    $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html( response.msg);                     
                }
            }
        });        
    }
    return false;
}

function init(){
    sortableColumns();
    $datafecha("txtFecha");
    $datafecha("txtFechaFiltro");
    
    createPagination($("#frmActividad").find(".body"));
    
    loadActividads($("#frmActividad").find(".body"));
    $("#txtFechaFiltro").bind("change", function(){
        $("#frmActividad").find(".body").html("");
        $("#frmActividad").data("filtro",$("#filtro").val());
        loadActividads($("#frmActividad").find(".body"));
    });
    
    $("#filtro").bind("change", function(){
        $("#frmActividad").find(".body").html("");
        $("#frmActividad").data("filtro",$("#filtro").val());
        loadActividads($("#frmActividad").find(".body"));
    });
    
    
    $("#btnNuevoActividad").button({
        icons:{
            primary:'ui-icon-plus'
        }
    });
        
    $("#btnNuevoActividad").on("click", newActividad);
    $("#btnEditarActividad").button({
        icons:{
            primary:'ui-icon-pencil'
        }
    }); 
    $("#btnEditarActividad").on("click", editActividad);        
    $("#btnEliminarActividad").button({
        icons: {
            primary:'ui-icon-trash'
        }
    });
    $("#btnEliminarActividad").on("click", delActividad);
    $("#btnGuardarActividad").button({
        icons:{
            primary:'ui-icon-disk'
        }
    });
    $("#btnGuardarActividad").on("click", guardarActividad);
    $("#btnCancelarActividad").button({
        icons:{
            primary:'ui-icon-cancel'
        }
    });
        
    $("#btnCancelarActividad").on("click", cancelarActividad);
        
    $(".siMessage").on("click",yesMessage);
    $("#btnNuevoActividad").button({
        icons:{
            primary:'ui-icon-plus'
        }
    });
    
    $(".noMessage").on("click", notMessage);
    
    $("#txtBuscarActividad").keypress(function (evt){
        if(evt.keyCode==13){
            $("#current").val(0);
            $("#start").val(parseInt($("#current").val())* parseInt($("#limit").val()));
            $("#frmActividad").find(".body").html("");
            $("#frmActividad").data("filtro",$("#filtro").val());
            loadActividads($("#frmActividad").find(".body"));
        }                    
    });
    $("body").roles();
}


$("document").ready(function(){
    init();
});
    