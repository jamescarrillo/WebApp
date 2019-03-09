
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
    if($("#txtTituloConvocatoria").val() == ""){
        $("#message").removeClass("ui-state-hightlight").addClass("ui-state-error").html("Debe Ingresear Por lo menos Un Titulo de la Convocatoria");
        return false;
    }else if($("#txtSintesisConvocatoria").val()=="" || $("#txtSintesisConvocatoria").val().length>200 ){
        $("#message").removeClass("ui-state-hightlight").addClass("ui-state-error").html("Debe Ingresear Por lo menos Una Sintensis de la Convocatoria, Menor a 200 digitos");
        return false;
    }
    return true;
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
            loadConvocatorias(render);
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
        url:'./Convocatoria?action=ListarCalendarioConvocatoria',
        dataType:'json',
        data:{
            idConvocatoria:$("#frmRegistroConvocatoria").data("id"),
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
                    }).css("width","5%");
                    var divNombre=$("<div/>",{  
                        id:'nombreActividad',
                        html:node.actividad.descripcion
                    }).css("width","40%");
                    var divFechaIni=$("<div/>",{
                        id:'FechaInicio',
                        html:node.fechaInicio
                    }).css("width","20%");
                    var divFechaFin=$("<div/>",{
                        id:'FechaFin',
                        html:node.fechaFin
                    }).css("width","20%");
                    var divEdit=$("<a/>",{
                        "title":"Editar",
                        "class":"ui-button ui-icon ui-icon-pencil"   
                    }).css("width","11px");
                  
                    var divDel=$("<a/>",{
                        "title":"Eliminar",
                        "class":"ui-button ui-icon ui-icon-trash"                        
                    }).css("width","11px");                    
                    /*var divEstado=$("<a/>",{
                        "title":node.estado?"Activo":"Desactivado",
                        "class":node.estado?"ui-button ui-icon ui-icon-circle-arrow-n":"ui-button ui-icon ui-icon-circle-arrow-s"
                    }).css("width","12px");*/
                                 
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
                    li.append(divId);
                    li.append(divNombre);
                    li.append(divFechaIni);
                    li.append(divFechaFin);
                    li.append(divEdit);
                    li.append(divDel);
                    //li.append(divEstado);
                    ul.append(li);      
                });                
                if(parseInt( response.total)==0){
                    alert(parseInt( response.total));
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
        url:'./Convocatoria?action=ListarConvocatoriaBien',
        dataType:'json',
        data:{
            query:$("#txtBuscarConvocatoria").val().replace("&","$$"),
            limit:$("#limit").val(),
            start:$("#start").val(),
            current:$("#current").val(),
            filtro: $("#frmConvocatoria").data("filtro")
        },
        success:function(response){
            if (response.items.length>0){
                var ul=$("<ul/>",{
                    id:'listConvocatorias'
                });
                $(render).append(ul);  
                var tamanio = function(node,max){
                    if (node.length>max)
                        return node.substring(0,max)+"...";
                    else
                        return node;
                }
                $(response.items).each(function(index,node){                    
                    var divId=$("<div/>",{
                        id:'idConvocatoria',
                        html:node.convoId
                    }).css({
                        "width":"10%", 
                        "display": "none"
                    });
                    var divFecha=$("<div/>",{  
                        id:'fecha',
                        html:node.fecha
                    }).css("width","10%");
                    
                    var divNombre=$("<div/>",{
                        id:'referencia',
                        html:tamanio(node.referencia,120)
                    }).css("width","55%");
                    
                    var tipoFunct = function(val){
                        switch (val){
                            case 1:
                                return "Bienes";
                                
                            case 2:
                                return "Servicio";
                                
                            case 3:
                                return "Obra";
                            case 4 :
                                return "Concesión";
                        }
                    };
                    var divTipo=$("<div/>",{
                        id:'tipo',
                        html:tipoFunct(node.tipo)
                    }).css("width","10%");
                    var procesoFunct = function(val){
                        switch (val){
                            case 1:
                                return "Vigente";
                                
                            case 2:
                                return "Anulado";
                                
                            case 3:
                                return "Finalizado";
                                
                            case 4:
                                return "Desierto";
                        }
                    };
                    
                    var divProceso=$("<div/>",{
                        id:'proceso',
                        html:procesoFunct(node.proceso)
                    }).css("width","10%");
                    
                    var divEdit=$("<a/>",{
                        "title":"Editar",
                        "class":"ui-button ui-icon ui-icon-pencil"   
                    }).css("width","11px");
                  
                    var divDel=$("<a/>",{
                        "title":"Eliminar",
                        "class":"ui-button ui-icon ui-icon-trash"                        
                    }).css("width","11px");   
                    
                    var divEstado=$("<a/>",{
                        "title":node.estado?"Desactivar":"Publicar",
                        "class":node.estado?"ui-button ui-icon ui-icon-circle-arrow-n":"ui-button ui-icon ui-icon-circle-arrow-s",
                        "dir": "publicar",
                        "value":node.estado
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
                        $("#frmActividadPorConvocatoria").find(".body").html("");                                            
                        $(this).addClass("selected ui-state-highlight").siblings().removeClass("selected ui-state-highlight");
                    });
     
                    divEdit.on("click",function(evt){
                        evt.preventDefault();
                        $(li).trigger("click");
                        $("#btnEditarConvocatoria").trigger("click");
                    });
                    
                    divDel.on("click",function(evt){
                        evt.preventDefault();
                        $(li).trigger("click");
                        $("#btnEliminarConvocatoria").trigger("click");
                    });
                    
                    divEstado.click(function(evt){
                        evt.preventDefault();
                        estadoConvocatoria($(this).val(), $(li));
                    });
                        
                    li.append(divId);
                    li.append(divFecha);
                    li.append(divNombre);
                    li.append(divTipo);
                    li.append(divProceso);
                    li.append(divEdit);
                    li.append(divDel);
                    li.append(divEstado);
                    
                    ul.append(li);
                    $("#listConvocatorias").roles();
                });                
                if(parseInt( response.total)==0){
                    alert(parseInt( response.total));
                    $("#paginate-convocatorias").hide();                    
                }else{                    
                    $("#listConvocatorias").find("li:first").addClass("selected ui-state-highlight");
                    $("#paginate-convocatorias").show();
                    $("#totalItems").html(" Total de Registros: "+response.total);
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
function newConvocatoria(){
    opt=0;
    $("#frmConvocatoria").hide();
    $("#widget").hide();
    $("#frmConvocatoria").hide();
    $("#widget").hide();
    $("#txtTituloConvocatoria").val("");
    $("#txtSintesisConvocatoria").val("");
    $("#txtValorReferencial").val("");
    $("#txtCostoParticipacion").val("");
    $("#txtLugarRegParticipantes").val("");
    $("#txtEstadoConvocatoria").attr("checked","checked");
    $(".file").val("");
    $(".tablafile").empty();
    $("#frmRegistroConvocatoria").show();
    $datafecha("txtFecha");
    return false;
}
    
function editConvocatoria(){
    if($("#listConvocatorias").find("li.selected").length>0){
        var select=$("#listConvocatorias").find("li.selected");
        $.ajax({
            url:'./Convocatoria?action=BuscarConvocatoriaBien',
            data:{
                id:$(select).find("#idConvocatoria").html()
            },
            dataType:'json',
            success:function(response){
                opt=1;
                $("#frmConvocatoria").hide();
                $("#widget").hide();
                $("#txtTituloConvocatoria").val(response.convocatoria.titulo);
                $("#txtSintesisConvocatoria").val(response.convocatoria.referencia);
                $("#txtValorReferencial").val(response.convocatoria.valReferencial);
                $("#cmbObjeto option").each(function(){
                    if(parseInt($(this).val())==parseInt(response.convocatoria.tipo)){
                        $(this).attr("selected","selected");
                    }
                });
                $("#txtCostoParticipacion").val(response.convocatoria.costParticipacion);
                $datafecha("txtFecha");
                $("#txtFecha").val(response.convocatoria.fecha);
                
                $("#txtLugarRegParticipantes").val(response.convocatoria.lugRegParticipante);
                if (response.convocatoria.basesFile.length>0){
                    $(".icono").eq(0).html("<img src='./resources/images/16x16/trash.png' />");
                }
                if (response.convocatoria.resEjectFile.length>0){
                    $(".icono").eq(1).html("<img src='./resources/images/16x16/trash.png' />");
                }
                if (response.convocatoria.absConObserFile.length>0){
                    $(".icono").eq(1).html("<img src='./resources/images/16x16/trash.png' />");
                }
                if (response.convocatoria.absConsultFile.length>0){
                    $(".icono").eq(2).html("<img src='./resources/images/16x16/trash.png' />");
                }
                if (response.convocatoria.absObservaFile.length>0){
                    $(".icono").eq(3).html("<img src='./resources/images/16x16/trash.png' />");
                }
                if (response.convocatoria.ProEntiFile.length>0){
                    $(".icono").eq(4).html("<img src='./resources/images/16x16/trash.png' />");
                }
                if (response.convocatoria.ProOsceFile.length>0){
                    $(".icono").eq(5).html("<img src='./resources/images/16x16/trash.png' />");
                }
                if (response.convocatoria.basInteFile.length>0){
                    $(".icono").eq(6).html("<img src='./resources/images/16x16/trash.png' />");
                }
                if (response.convocatoria.actEvalTecFile.length>0){
                    $(".icono").eq(7).html("<img src='./resources/images/16x16/trash.png' />");
                }
                if (response.convocatoria.cuaCompaFile.length>0){
                    $(".icono").eq(8).html("<img src='./resources/images/16x16/trash.png' />");
                }
                if (response.convocatoria.actaBuenaProFile.length>0){
                    $(".icono").eq(9).html("<img src='./resources/images/16x16/trash.png' />");
                }
                if (response.convocatoria.notiSusFile.length>0){
                    $(".icono").eq(10).html("<img src='./resources/images/16x16/trash.png' />");
                }
                if (response.convocatoria.resRecEntiFile.length>0){
                    $(".icono").eq(11).html("<img src='./resources/images/16x16/trash.png' />");
                }
                if (response.convocatoria.resRecTribFile.length>0){
                    $(".icono").eq(12).html("<img src='./resources/images/16x16/trash.png' />");
                }
                if (response.convocatoria.proceso.length>0){
                    $(".icono").eq(13).html("<img src='./resources/images/16x16/trash.png' />");
                }                
                $("#file_1").val(response.convocatoria.basesFile);
                $("#file_2").val(response.convocatoria.resEjectFile);
                $("#file_3").val(response.convocatoria.absConObserFile);
                $("#file_4").val(response.convocatoria.absConsultFile);
                $("#file_5").val(response.convocatoria.absObservaFile);
                $("#file_6").val(response.convocatoria.ProEntiFile);
                $("#file_7").val(response.convocatoria.ProOsceFile);
                $("#file_8").val(response.convocatoria.basInteFile);
                $("#file_9").val(response.convocatoria.actEvalTecFile);
                $("#file_10").val(response.convocatoria.cuaCompaFile);
                $("#file_11").val(response.convocatoria.actaBuenaProFile);
                $("#file_12").val(response.convocatoria.notiSusFile);
                $("#file_13").val(response.convocatoria.resRecEntiFile);
                $("#file_14").val(response.convocatoria.resRecTribFile);
                $("#txtProceso").val(response.convocatoria.proceso);
                $(".tablafile").empty();         
                if (response.convocatoria.estado){
                    $("#txtEstado").attr("checked","checked");
                }
                else{
                    $("#txtEstado").removeAttr("checked");
                }
                    
                $("#frmRegistroConvocatoria").data("id",response.convocatoria.convoId);
                $("#frmRegistroConvocatoria").show();
                $("#panelActividads").show();
                $("#paginate-subconvocatorias").remove();
                $("#frmActividadPorConvocatoria").find(".body").html("");
                createPaginationActividad($("#frmActividadPorConvocatoria").find(".body"));
                loadActividads($("#frmActividadPorConvocatoria").find(".body"));  
            }
        });        
    }
    return false;
}

function delConvocatoria(){
    if($("#listConvocatorias").find("li.selected").length>0){
        var select=$("#listConvocatorias").find("li.selected"); 
        opt=2;
        $(".msg-html").html("¿ESTAS SEGURO DE ELIMINAR EL MODULO: "+select.find("#referencia").html()+"?");
        $(".eliminarQuestionMod").data("idConvocatoria",$(select).find("#idConvocatoria").html());
        $(".eliminarQuestionMod").dialog({
            title:'Mensaje de Confirmaci&oacute;n',
            modal:true,
            show: "blind",
            hide: "explode",
            resizable:false,
            width:600,
            height:150
        });
    }    
    return false;
}

function estadoConvocatoria(estado, li){
    var select=li; 
    opt=3;
    $(".msg-html").html("¿ESTAS SEGURO DE FINALIZAR/ACTIVAR LA CONVOCATORIA: "+select.find("#referencia").html()+"?");
    $(".eliminarQuestionMod").data("idConvocatoria",$(select).find("#idConvocatoria").html());
    $(".eliminarQuestionMod").val(estado);
    $(".eliminarQuestionMod").dialog({
        title:'Mensaje de Confirmaci&oacute;n',
        modal:true,
        resizable:false,
        show: "blind",
        hide: "explode",
        width:600,
        height:150
    });
    return false;
}

function guardarConvocatoria(){    
    if (validarCampos()){
        if (opt==0){
            $.ajax({
                url:'./Convocatoria?action=InsertarConvocatoriaBien',
                dataType:'json',
                data:{
                    txtSintesisConvocatoria:$("#txtSintesisConvocatoria").val(),
                    txtValorReferencial:$("#txtValorReferencial").val(),
                    cmbObjeto :$("#cmbObjeto").val(),
                    txtCostoParticipacion:$("#txtCostoParticipacion").val(),
                    txtLugarRegParticipantes:$("#txtLugarRegParticipantes").val(),
                    txtProceso : $("#txtProceso").val(),
                    txtTitulo : $("#txtTituloConvocatoria").val(),
                    estado: $("#txtEstado").is(":checked"),
                    file_1:$("#file_1").val(),
                    file_2:$("#file_2").val(),
                    file_3:$("#file_3").val(),
                    file_4:$("#file_4").val(),
                    file_5:$("#file_5").val(),
                    file_6:$("#file_6").val(),
                    file_7:$("#file_7").val(),
                    file_8:$("#file_8").val(),
                    file_9:$("#file_9").val(),
                    file_10:$("#file_10").val(),
                    file_11:$("#file_11").val(),
                    file_12:$("#file_12").val(),
                    file_13:$("#file_13").val(),
                    file_14:$("#file_14").val(),
                    txtFecha: $("#txtFecha").val()
                },
                success:function(response){
                    if ( response.success==true ){
                        $("#frmConvocatoria").find(".body").html("");
                        loadConvocatorias($("#frmConvocatoria").find(".body"));
                        $("#frmConvocatoria").show();
                        $("#widget").show();
                        $("#frmRegistroConvocatoria").hide();
                        $("#panelActividads").hide();
                        $(".tablafile").empty();
                        $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg);                     
                    } else {
                        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html( response.msg);                     
                    }
                }
            });
        }else if (opt==1){
            $.ajax({
                url:'./Convocatoria?action=ActualizarConvocatoriaBien',
                dataType:'json',
                data:{
                    idConvocatoria:$("#frmRegistroConvocatoria").data("id"),
                    txtSintesisConvocatoria:$("#txtSintesisConvocatoria").val(),
                    txtValorReferencial:$("#txtValorReferencial").val(),
                    cmbObjeto :$("#cmbObjeto").val(),
                    txtCostoParticipacion:$("#txtCostoParticipacion").val(),
                    txtLugarRegParticipantes:$("#txtLugarRegParticipantes").val(),
                    txtProceso : $("#txtProceso").val(),
                    txtTitulo : $("#txtTituloConvocatoria").val(),
                    estado: $("#txtEstado").is(":checked"),
                    file_1:$("#file_1").val(),
                    file_2:$("#file_2").val(),
                    file_3:$("#file_3").val(),
                    file_4:$("#file_4").val(),
                    file_5:$("#file_5").val(),
                    file_6:$("#file_6").val(),
                    file_7:$("#file_7").val(),
                    file_8:$("#file_8").val(),
                    file_9:$("#file_9").val(),
                    file_10:$("#file_10").val(),
                    file_11:$("#file_11").val(),
                    file_12:$("#file_12").val(),
                    file_13:$("#file_13").val(),
                    file_14:$("#file_14").val(),
                    txtFecha: $("#txtFecha").val()
                },
                success:function(response){
                    if (response.success==true){
                        $("#frmConvocatoria").find(".body").html("");
                        loadConvocatorias($("#frmConvocatoria").find(".body"));
                        $("#frmConvocatoria").show();
                        $("#widget").show();
                        $("#frmRegistroConvocatoria").hide();
                        $("#panelActividads").hide();
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
function cancelarConvocatoria(){
    $("#frmConvocatoria").find(".body").html("");
    loadConvocatorias($("#frmConvocatoria").find(".body"));
    $("#frmConvocatoria").show();
    $("#widget").show();
    $("#frmRegistroConvocatoria").hide();
    $("#panelActividads").hide();
    return false;
}

function notMessage(){
    $(".eliminarQuestionMod").dialog("close");
    return false;
}

function yesMessage(){
    if (opt==2){//es para eliminar el convocatoria
        $.ajax({
            url:'./Convocatoria?action=eliminarConvocatoriaBien',
            data:{
                idConvocatoria: $(".eliminarQuestionMod").data("idConvocatoria")
            },
            dataType:'json',
            success:function(response){
                if (response.success){
                    $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg); 
                    $("#frmConvocatoria").find(".body").html("");
                    loadConvocatorias($("#frmConvocatoria").find(".body"));
                    $(".eliminarQuestionMod").dialog("close");
                }else{
                    $(".eliminarQuestionMod").dialog("close");
                    $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html( response.msg);                     
                }
            }
        });
            
    } else if (opt==3){
        $.ajax({
            url:'./Convocatoria?action=estadoConvocatoriaBien',
            data:{
                idConvocatoria: $(".eliminarQuestionMod").data("idConvocatoria"),
                estado : $(".eliminarQuestionMod").val()
            },
            dataType:'json',
            success:function(response){
                if (response.success){
                    $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg); 
                    $("#frmConvocatoria").find(".body").html("");
                    loadConvocatorias($("#frmConvocatoria").find(".body"));
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
                    $("#frmActividadPorConvocatoria").find(".body").html("");
                    loadActividads($("#frmActividadPorConvocatoria").find(".body"));
                    $(".eliminarQuestionMod").dialog("close");
                } else {
                    $(".eliminarQuestionMod").dialog("close");
                    $("#message2").removeClass("ui-state-highlight").addClass("ui-state-error").html( response.msg);                     
                }
            }
        });
    }
    if (optActiNeto==2){//es para eliminar el ActiNeto
        $.ajax({
            url:'./ConvocatoriaPers?action=EliminarNombreActividad',
            data:{
                id:$("#cmbnombreActividad").val(),
                tipo : 1
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
     
    return false;
}

function newActividad(){
    optSub=0;
    cargarCombonombreActividad(0);
    
    $("#txtFechaInicio").val("");
    $("#txtFechaFin").val("");
    $("#txtEstadoActividad").attr("checked","checked");
    $("#frmRegistroActividad").dialog({
        title:'Asignar Actividad',
        resizable:false,
        show: "blind",
        hide: "explode",
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
        title:'Registro del Nombre de la Actividad',
        show: "blind",
        hide: "explode",
        width:600,
        height:145,
        resizable:false
    });
    return false;
}
function cargarCombonombreActividad(value){    
    $.ajax({
        url:'./Convocatoria?action=ListarActividad',
        data: {
            idConvocatoria:$("#frmRegistroConvocatoria").data("id"),
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
                    tipo : 1
                },
                success:function(response){
                    if (response.success){
                        $("#message4").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg);                     
                        $("#frmRegistroActiNeto").dialog("close");
                        cargarCombonombreActividad(response.id);
                    } else {
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
            modal: true,
            show: "blind",
            hide: "explode",
            title: 'Edici&oacute;n del Nombre de la Actividad',
            width: 600,
            height: 145,
            resizable: false
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
            show: "blind",
            hide: "explode",
            modal:true,
            resizable:false,
            width:400,
            height:120
        });
    }
    return false;
}
function cancelActividad(){
    $("#frmRegistroActividad").dialog("close");
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
                url:'./Convocatoria?action=insertarCalendarioConvocatoria',
                dataType:'json',
                data:{
                    txtFechaInicio:$("#txtFechaInicio").val(),
                    txtFechaFin:$("#txtFechaFin").val(),
                    txtEstadoActividad:$("#txtEstadoActividad").is(":checked"),
                    cmbnombreActividad:$("#cmbnombreActividad").val(),
                    idConvocatoria:$("#frmRegistroConvocatoria").data("id")
                },
                success:function(response){
                    if (response.success==true){
                        $("#frmActividadPorConvocatoria").find(".body").html("");
                        loadActividads($("#frmActividadPorConvocatoria").find(".body"));
                        $("#frmRegistroActividad").dialog("close");
                        $("#message2").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg);                     
                    }else{
                        $("#message2").removeClass("ui-state-highlight").addClass("ui-state-error").html( response.msg);                     
                    }
                }
            });
                
        }else if (optSub==1){
            $.ajax({
                url:'./Convocatoria?action=ActualizarCalendarioConvocatoria',
                dataType:'json',
                data:{
                    txtFechaInicio:$("#txtFechaInicio").val(),
                    txtFechaFin:$("#txtFechaFin").val(),
                    txtEstadoActividad:$("#txtEstadoActividad").is(":checked"),
                    cmbnombreActividad:$("#cmbnombreActividad").val(),
                    idCalendario:$("#frmRegistroActividad").data("id")
                },
                success:function(response){
                    if (response.success==true){
                        $("#frmActividadPorConvocatoria").find(".body").html("");
                        loadActividads($("#frmActividadPorConvocatoria").find(".body"));                       
                        $("#frmRegistroActividad").dialog("close");                        
                        $("#message2").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg);                     
                    }else{
                        $("#message3").removeClass("ui-state-highlight").addClass("ui-state-error").html( response.msg);                     
                    }
                }
            });
        }
    }
    return false;
}
function editActividad(){
    if($("#listActividads").find("li.selected").length>0){
        var select=$("#listActividads").find("li.selected");
        $.ajax({
            url:'./Convocatoria?action=buscarCalendarioConvocatoria',
            data:{
                id:$(select).find("#idActividad").html()
            },
            dataType:'json',
            success:function(response){
                optSub=1;              
                    
                $("#txtFechaInicio").val(response.calendario.fechaInicio);                
                $("#txtFechaFin").val(response.calendario.fechaFin);
                if (response.calendario.estado){
                    $("#txtEstadoActividad").attr("checked","checked");
                }
                else{
                    $("#txtEstadoActividad").removeAttr("checked");
                }
                $("#frmRegistroActividad").data("id",response.calendario.Id);
                    
                cargarCombonombreActividad(response.calendario.actividad.actiId);                
                $("#frmRegistroActividad").dialog({
                    title:'Editar Actividad',
                    show: "blind",
                    hide: "explode",
                    resizable:false,
                    modal:true,
                    width:900
                });                           
            }
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
            show: "blind",
            hide: "explode",
            resizable:false,
            width:600,
            height:150
        });
    }    
    return false;
}
function init(){
    sortableColumns();
    
    createPagination($("#frmConvocatoria").find(".body"));
    loadConvocatorias($("#frmConvocatoria").find(".body"));
    
    $("#filtro").bind("change", function(){
        $("#frmConvocatoria").data("filtro",$("#filtro").val());
        $("#frmConvocatoria").find(".body").html("");
        loadConvocatorias($("#frmConvocatoria").find(".body"));
    });
    $datafecha("txtFechaInicio");
    $datafecha("txtFechaFin");
    $("#btnNuevoConvocatoria").button({
        icons:{
            primary:'ui-icon-plus'
        }
    });
    $("#btnNuevoConvocatoria").on("click", newConvocatoria);
    $("#btnEditarConvocatoria").button({
        icons:{
            primary:'ui-icon-pencil'
        }
    }); 

    $("#btnEditarConvocatoria").on("click", editConvocatoria);        
    $("#btnEliminarConvocatoria").button({
        icons: {
            primary:'ui-icon-trash'
        }
    });
    $("#btnEliminarConvocatoria").on("click", delConvocatoria);
    $("#btnGuardarConvocatoria").button({
        icons:{
            primary:'ui-icon-disk'
        }
    });
    $("#btnGuardarConvocatoria").on("click", guardarConvocatoria);
    $("#btnCancelarConvocatoria").button({
        icons:{
            primary:'ui-icon-cancel'
        }
    });
    $("#btnCancelarConvocatoria").on("click", cancelarConvocatoria);
    $(".siMessage").on("click",yesMessage);
    $("#btnNuevoActividad").button({
        icons:{
            primary:'ui-icon-plus'
        }
    });
    $("#btnNuevoActividad").on("click", newActividad);
    $(".noMessage").on("click", notMessage);
    
    $("#btnEditarActividad").button({
        icons:{
            primary:'ui-icon-pencil'
        }
    }).on("click", editActividad);
        
    $("#btnEliminarActividad").button({
        icons: {
            primary:'ui-icon-trash'
        }
    });
        
    $("#btnEliminarActividad").on("click", delCalendarioConvocatoria);
    $("#btnNuevoActividad").on("click", newActividad);
    $("#btnNuevonombreActividad").on("click", newActiNeto);
    $("#btnEditarnombreActividad").on("click", editActiNeto);
    $("#btnCancelarActiNeto").button({
        icons: {
            primary:'ui-icon-close'
        }
    });
    $("#btnCancelarActiNeto").on("click", cancelActiNeto);
    $("#btnGuardarActiNeto").button({
        icons: {
            primary:'ui-icon-disk'
        }
    });
    $("#btnGuardarActiNeto").on("click", saveActiNeto);
    $("#btnEliminarnombreActividad").on("click", delActiNeto);
    $("#btnCancelarActividad").button({
        icons:{
            primary:'ui-icon-cancel'
        }
    });
    $("#btnCancelarActividad").on("click", cancelActividad);
    $("#btnGuardarActividad").button({
        icons:{
            primary:'ui-icon-disk'
        }
    });
    $("#btnGuardarActividad").on("click", guardarActividad);
        
    $("#txtBuscarConvocatoria").keypress(function (evt){
        if(evt.keyCode==13){
            $("#current").val(0);
            $("#start").val(parseInt($("#current").val())* parseInt($("#limit").val()));
            $("#frmConvocatoria").find(".body").html("");
            loadConvocatorias($("#frmConvocatoria").find(".body"));
        }                    
    });
            
    $("#txtBuscarActividad").keypress(function (evt){
        if(evt.keyCode==13){
            $("#current").val(0);
            $("#startActividad").val(parseInt($("#currentActividad").val())* parseInt($("#limitActividad").val()));
            $("#frmActividadPorConvocatoria").find(".body").html("");
            loadActividads($("#frmActividadPorConvocatoria").find(".body"));
        }                    
    });            
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
                $(".file").eq(parseInt(id-1)).val(file.nametrue);
                return $('<tr><td>' + file.name + '<\/td><\/tr>');
                        
            }
        });
    }
    initFileUpload(1);
    initFileUpload(2);
    initFileUpload(3);
    initFileUpload(4);
    initFileUpload(5);
    initFileUpload(6);
    initFileUpload(7);
    initFileUpload(8);
    initFileUpload(9);
    initFileUpload(10);
    initFileUpload(11);
    initFileUpload(12);
    initFileUpload(13);
    initFileUpload(14);
    $("body").roles();
    
    $(".icono").each(function(index, elem) {
        $(this).on("click",function(){
            $(".archivo").eq(index).val("");
            $(this).html("");
        });
    });
    
}


$("document").ready(function(){
    init();
});
    