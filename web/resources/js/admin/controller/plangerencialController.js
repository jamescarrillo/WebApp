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
                loadFuncionarios($("#"+frm).find(".body"));
                break;
            case 2 :
                loadDirectivos($("#"+frm).find(".body"));
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
                    loadFuncionarios($("#"+frm).find(".body"));
                    break;
                case 2 :
                    loadDirectivos($("#"+frm).find(".body"));
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
                    loadFuncionarios($("#"+frm).find(".body"));
                    break;
                case 2 :
                    loadDirectivos($("#"+frm).find(".body"));
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
                loadFuncionarios($("#"+frm).find(".body"));
                break;
            case 2 :
                loadDirectivos($("#"+frm).find(".body"));
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

function loadFuncionarios(render){
    $.ajax({
        url:'./GestionTransparente?action=ListarFuncionarioForAdmin',
        dataType:'json',
        cache: false,
        data:{
            idFuncionario:$("#frmRegistroFuncionario").data("id"),
            query:$("#txtBuscarFuncionario").val().replace("&","$$"),
            limit:$("#limit1").val(),
            start:$("#start1").val(),
            current:$("#current1").val()
        },
        success:function(response){
            if (response.items.length>0){
                var ul=$("<ul/>",{
                    id:'listFuncionarios'
                });
                $(render).append(ul);
                $(response.items).each(function(index,node){
                    var divId=$("<div/>",{
                        id:'idFuncionario',
                        html:node.id
                    }).css("display","none");
                    
                    var divNombres=$("<div/>",{
                        id:'nombreFuncionario',
                        html:node.nombresApellidos
                    }).css("width","22%");
                    
                    var divCargo=$("<div/>",{
                        id:'cargoFuncionario',
                        html:node.cargo
                    }).css("width","20%");
                    
                    var divDNI=$("<div/>",{
                        id:'dniFuncionario',
                        html:node.numeroDni
                    }).css("width","8%");
                    
                    var divTelefono=$("<div/>",{
                        id:'telefonoFuncionario',
                        html:node.telefono
                    }).css("width","24%");
                    
                    var divCurriculum=$("<div/>",{
                        id:'curriculumFuncionario',
                        html: "<a href='"+node.hojaVida+"' target='_blank' > Ver </a>"
                    }).css("width","10%");
                    
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
                        msn = "Relevar Trabajador"; 
                        icon = "ui-button ui-icon ui-icon-circle-arrow-s";
                    }
                    else{ 
                        msn = "Reasignar Trabajador"; 
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
                        $("#btnEditarFuncionario").trigger("click");
                    });
                    divDel.on("click",function(evt){
                        evt.preventDefault();
                        $(li).trigger("click");
                        $("#btnEliminarFuncionario").trigger("click");
                    });

                    divEstado.click(function(evt){
                        evt.preventDefault();
                        estadoFuncionario($(this).val(), $(li));
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
                    li.append(divNombres);
                    li.append(divCargo);
                    li.append(divDNI);
                    li.append(divTelefono);
                    li.append(divCurriculum);
                    li.append(divEstado);
                    li.append(divEdit);
                    li.append(divDel);
                    ul.append(li);
                });
                
                if(parseInt( response.total )==0){
                    $("#paginate-funcionarios").hide();
                }else{                    
                    $("#listFuncionarios").find("li:first").addClass("selected ui-state-highlight");
                    $("#paginate-funcionarios").show();
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

function validarCampos(){
    if ($("#txtNombre").val() == "") {
        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Ingresar Nombre del Funcionario");
        return false;
    }else if ($("#txtDNI").val()==""){
        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html("Seleccione Ingrese el DNI del Funcionario");
        return false;
    }else if ($("#txtCargo").val()==""){
        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Ingresar El Cargo del Funcionario");
        return false;
    }
    return true;
}

function newFuncionario(){
    opt=0;
    $("#frmFuncionario").hide();
    $("#widget").hide();
    $("#frmRegistroFuncionario").hide();
    $("#widget").hide();
    $(".casilla").val("");
    $("#txtCurriculum").val("nocurriculum.pdf");
    $("#txtFoto").val("no-photo.gif");
    $("#fotito").html("<img src='./archivos/no_photo.gif' />");
    $("#frmRegistroFuncionario").show();
    $(".tablafile").empty();
    $("#txtDestacado").removeAttr("checked");
    $datafecha("txtFecha");
    return false;
}
    
function editFuncionario(){
    if($("#listFuncionarios").find("li.selected").length>0){
        var select=$("#listFuncionarios").find("li.selected");
        $.ajax({
            url:'./GestionTransparente?action=BuscarFuncionario',
            cache: false,
            data:{
                id:$(select).find("#idFuncionario").html()
            },
            dataType:'json',
            success:function(response){
                opt=1;
                $("#frmFuncionario").hide();
                $("#widget").hide();
                $(".tablafile").empty();
                $datafecha("txtFecha");
                $("#txtNombre").val(response.funcionario.nombresApellidos);
                $("#txtCargo").val(response.funcionario.cargo);
                $("#txtCurriculum").val(response.funcionario.hojaVida);
                $("#txtDNI").val(response.funcionario.numeroDni);
                $("#txtEmail").val(response.funcionario.eMail);
                $("#txtTelefono").val(response.funcionario.telefono);
                $("#txtFax").val(response.funcionario.fax);
                $("#txtFecha").val(response.funcionario.fechaDesignacion.split("-")[2]+"/"+response.funcionario.fechaDesignacion.split("-")[1]+"/"+response.funcionario.fechaDesignacion.split("-")[0]);
                $("#txtNivel").val(response.funcionario.nivelRemunerativo);
                $("#txtRegimen").val(response.funcionario.regimenLaboral);
                $("#txtResolucion").val(response.funcionario.resolucion);
                $("#txtFoto").val(response.funcionario.foto);
                $("#txtProfesion").val(response.funcionario.profesion);
                $("#txtRetribucion").val(response.funcionario.retribucionMensual);
                $("#txtOrganigrama").val(response.funcionario.organigrama);
                $("#codigo").val(response.funcionario.id);
                $("#fotito").html("<img src='./archivos/"+response.funcionario.foto+"' />");
                
                if (response.funcionario.estado){
                    $("#txtEstado").attr("checked","checked");
                }
                else{
                    $("#txtEstado").removeAttr("checked");
                }
                
                if (response.funcionario.destacado){
                    $("#txtDestacado").attr("checked","checked");
                }
                else{
                    $("#txtDestacado").removeAttr("checked");
                }
                    
                $("#frmRegistroFuncionario").data("id",response.funcionario.id);
                $("#frmRegistroFuncionario").show();
                $("#panelFuncionarios").show();
                $("#paginate-subfuncionarios").remove();
                $("#frmRegistroFuncionario").find(".body").html("");
                
                createPagination($("#frmRegistroFuncionario").find(".body"));
                loadFuncionarios($("#frmRegistroFuncionario").find(".body"));  
            }
        });        
    }
    return false;
}

function delFuncionario(){
    if($("#listFuncionarios").find("li.selected").length>0){
        var select=$("#listFuncionarios").find("li.selected"); 
        opt=2;
        $(".msg-html").html("¿ESTAS SEGURO DE ELIMINAR ESTE ITEM: "+select.find("#nombreFuncionario").html()+"?");
        $(".eliminarQuestionMod").data("idFuncionario",$(select).find("#idFuncionario").html());
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

function estadoFuncionario(estado, li){
    var select=li;
    opt=3;
    $(".msg-html").html("¿ESTAS SEGURO DE PUBLICAR/OCULTAR AL FUNCIONARIO: "+select.find("#nombreFuncionario").html()+ " DE SU CARGO?");
    $(".eliminarQuestionMod").data("idFuncionario",$(select).find("#idFuncionario").html());
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

function guardarFuncionario(){    
    if (validarCampos()){        
        if (opt==0){
            $.ajax({
                url:'./GestionTransparente?action=ActualizarFuncionario&opt='+0,
                type: 'POST',
                cache: false,
                dataType:'json',
                data: $("#frmRegistroFuncionarioSend").serialize(),
                success:function(response){
                    if ( response.success==true ){
                        $("#frmFuncionario").find(".body").html("");
                        loadFuncionarios($("#frmFuncionario").find(".body"));
                        $("#frmFuncionario").show();
                        $("#widget").show();
                        $("#frmRegistroFuncionario").hide();
                        $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg);                     
                    } else {
                        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html( response.msg);                     
                    }
                }
            });
        }else if (opt==1){    
            $.ajax({
                url:'./GestionTransparente?action=ActualizarFuncionario&opt=1&codigo='+$("#frmRegistroFuncionario").data("id"),
                dataType:'json',
                cache: false,
                type: 'POST',
                data: $("#frmRegistroFuncionarioSend").serialize(),
                success:function(response){
                    if (response.success==true){
                        $("#frmFuncionario").find(".body").html("");
                        loadFuncionarios($("#frmFuncionario").find(".body"));
                        $("#frmFuncionario").show();
                        $("#widget").show();
                        $("#frmRegistroFuncionario").hide();
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

function cancelarFuncionario(){
    $("#frmFuncionario").find(".body").html("");
    loadFuncionarios($("#frmFuncionario").find(".body"));
    $("#widget").show();
    $("#frmFuncionario").show();
    $("#frmRegistroFuncionario").hide();
    $("#panelFuncionarios").hide();
    return false;
}

function notMessage(){
    $(".eliminarQuestionMod").dialog("close");
    return false;
}

function yesMessage(){
    if (opt==2){//es para eliminar el funcionario
        $.ajax({
            url:'./GestionTransparente?action=EliminarFuncionario',
            cache: false,
            data:{
                id: $(".eliminarQuestionMod").data("idFuncionario")
            },
            dataType:'json',
            success:function(response){
                if (response.success){
                    $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg); 
                    $("#frmFuncionario").find(".body").html("");
                    loadFuncionarios($("#frmFuncionario").find(".body"));
                    $(".eliminarQuestionMod").dialog("close");
                } else {
                    $(".eliminarQuestionMod").dialog("close");
                    $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html( response.msg);                     
                }
            }
        });
    } else if (opt==3){
        $.ajax({
            url:'./GestionTransparente?action=EstadoFuncionario',
            cache: false,
            data:{
                id: $(".eliminarQuestionMod").data("idFuncionario"),
                estado : $(".eliminarQuestionMod").val()
            },
            dataType:'json',
            success:function(response){
                if (response.success){
                    $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg); 
                    $("#frmFuncionario").find(".body").html("");
                    loadFuncionarios($("#frmFuncionario").find(".body"));
                    $(".eliminarQuestionMod").dialog("close");
                }else{
                    $(".eliminarQuestionMod").dialog("close");
                    $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html( response.msg);                     
                }
            }
        });        
    } else if (opt==4){
        $.ajax({
            url:'./GestionTransparente?action=EliminarDirectivo',
            cache: false,
            data:{
                id: $(".eliminarQuestionMod").data("idDirectivo"),
                estado : $(".eliminarQuestionMod").val()
            },
            dataType:'json',
            success:function(response){
                if (response.success){
                    $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg); 
                    $("#frmDirectivo").find(".body").html("");
                    loadDirectivos($("#frmDirectivo").find(".body"));
                    $(".eliminarQuestionMod").dialog("close");
                }else{
                    $(".eliminarQuestionMod").dialog("close");
                    $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html( response.msg);                     
                }
            }
        });        
    } else if (opt==5){
        $.ajax({
            url:'./GestionTransparente?action=EstadoDirectivo',
            cache: false,
            data:{
                id: $(".eliminarQuestionMod").data("idDirectivo"),
                estado : $(".eliminarQuestionMod").val()
            },
            dataType:'json',
            success:function(response){
                if (response.success){
                    $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg); 
                    $("#frmDirectivo").find(".body").html("");
                    loadDirectivos($("#frmDirectivo").find(".body"));
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

function loadDirectivos(render){
    $.ajax({
        url:'./GestionTransparente?action=ListarDirectivoForAdmin',
        dataType:'json',
        cache: false,
        data:{
            idFuncionario:$("#frmRegistroDirectivo").data("id"),
            query:$("#txtBuscarDirectivo").val().replace("&","$$"),
            limit:$("#limit2").val(),
            start:$("#start2").val(),
            current:$("#current2").val()
        },
        success:function(response){
            if (response.items.length>0){
                var ul=$("<ul/>",{
                    id:'listDirectivos'
                });
                $(render).append(ul);
                $(response.items).each(function(index,node){
                    var divId=$("<div/>",{
                        id:'idDirectivo',
                        html:node.id
                    }).css("display","none");
                    
                    var divNombres=$("<div/>",{
                        id:'nombreDirectivo',
                        html:node.nombresApellidos
                    }).css("width","22%");
                    
                    var divCargo=$("<div/>",{
                        id:'cargoDirectivo',
                        html:node.cargo
                    }).css("width","20%");
                    
                    var divDNI=$("<div/>",{
                        id:'dniDirectivo',
                        html:node.numeroDni
                    }).css("width","8%");
                    
                    var divTelefono=$("<div/>",{
                        id:'telefonoDirectivo',
                        html:node.telefono
                    }).css("width","24%");
                    
                    var divCurriculum=$("<div/>",{
                        id:'curriculumDirectivo',
                        html: "<a href='"+node.hojaVida+"' target='_blank' > Ver </a>"
                    }).css("width","10%");
                    
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
                        msn = "Relevar Trabajador"; 
                        icon = "ui-button ui-icon ui-icon-circle-arrow-s";
                    }
                    else{ 
                        msn = "Reasignar Trabajador"; 
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
                        $("#btnEditarDirectivo").trigger("click");
                    });
                    divDel.on("click",function(evt){
                        evt.preventDefault();
                        $(li).trigger("click");
                        $("#btnEliminarDirectivo").trigger("click");
                    });

                    divEstado.click(function(evt){
                        evt.preventDefault();
                        estadoDirectivo($(this).val(), $(li));
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
                    li.append(divNombres);
                    li.append(divCargo);
                    li.append(divDNI);
                    li.append(divTelefono);
                    li.append(divCurriculum);
                    li.append(divEstado);
                    li.append(divEdit);
                    li.append(divDel);
                    ul.append(li);
                });
                
                if(parseInt( response.total )==0){
                    $("#paginate-directivos").hide();
                }else{                    
                    $("#listDirectivos").find("li:first").addClass("selected ui-state-highlight");
                    $("#paginate-directivos").show();
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

function newDirectivo(){
    opt=0;
    $("#frmDirectivo").hide();
    $("#widget_1").hide();
    $("#frmRegistroDirectivo").hide();
    $("#widget_1").hide();
    $(".casilla_1").val("");
    $("#txtCurriculum_1").val("nocurriculum.pdf");
    $("#txtFoto_1").val("no-photo.gif");
    $("#fotito_1").html("<img src='./archivos/no_photo.gif' />");
    $("#frmRegistroDirectivo").show();
    $(".tablafile_1").empty();
    $datafecha("txtFecha_1");
    return false;
}
    
function editDirectivo(){
    if($("#listDirectivos").find("li.selected").length>0){
        var select=$("#listDirectivos").find("li.selected");
        $.ajax({
            url:'./GestionTransparente?action=BuscarDirectivo',
            cache: false,
            data:{
                id:$(select).find("#idDirectivo").html()
            },
            dataType:'json',
            success:function(response){
                opt=1;
                $("#frmDirectivo").hide();
                $("#widget_1").hide();
                $(".tablafile_1").empty();
                $datafecha("txtFecha_1");
                $("#txtNombre_1").val(response.funcionario.nombresApellidos);
                $("#txtCargo_1").val(response.funcionario.cargo);
                $("#txtCurriculum_1").val(response.funcionario.hojaVida);
                $("#txtDNI_1").val(response.funcionario.numeroDni);
                $("#txtEmail_1").val(response.funcionario.eMail);
                $("#txtTelefono_1").val(response.funcionario.telefono);
                $("#txtFax_1").val(response.funcionario.fax);
                $("#txtFecha_1").val(response.funcionario.fechaDesignacion.split("-")[2]+"/"+response.funcionario.fechaDesignacion.split("-")[1]+"/"+response.funcionario.fechaDesignacion.split("-")[0]);
                $("#txtNivel_1").val(response.funcionario.nivelRemunerativo);
                $("#txtRegimen_1").val(response.funcionario.regimenLaboral);
                $("#txtResolucion_1").val(response.funcionario.resolucion);
                $("#txtFoto_1").val(response.funcionario.foto);
                $("#txtProfesion_1").val(response.funcionario.profesion);
                $("#txtRetribucion_1").val(response.funcionario.retribucionMensual);
                $("#txtInstitucion_1").val(response.funcionario.institucion);
                $("#codigo_1").val(response.funcionario.id);
                $("#fotito_1").html("<img src='./archivos/"+response.funcionario.foto+"' />");
                
                if (response.funcionario.estado){
                    $("#txtEstado_1").attr("checked","checked");
                }
                else{
                    $("#txtEstado_1").removeAttr("checked");
                }
                    
                $("#frmRegistroDirectivo").data("id",response.funcionario.id);
                $("#frmRegistroDirectivo").show();
                $("#panelDirectivos").show();
                $("#paginate-directivos").remove();
                $("#frmRegistroDirectivo").find(".body").html("");
                
                createPagination($("#frmRegistroDirectivo").find(".body"));
                loadDirectivos($("#frmRegistroDirectivo").find(".body"));  
            }
        });        
    }
    return false;
}

function delDirectivo(){
    if($("#listDirectivos").find("li.selected").length>0){
        var select=$("#listDirectivos").find("li.selected"); 
        opt=4;
        $(".msg-html").html("¿ESTAS SEGURO DE ELIMINAR ESTE ITEM: "+select.find("#nombreDirectivo").html()+"?");
        $(".eliminarQuestionMod").data("idDirectivo",$(select).find("#idDirectivo").html());
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

function estadoDirectivo(estado, li){
    var select=li;
    opt=5;
    $(".msg-html").html("¿ESTAS SEGURO DE PUBLICAR/OCULTAR AL DIRECTIVO: "+select.find("#nombreDirectivo").html()+ " DE SU CARGO?");
    $(".eliminarQuestionMod").data("idDirectivo",$(select).find("#idDirectivo").html());
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

function validarCamposDirectivo(){
    if ($("#txtNombre_1").val() == "") {
        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Ingresar Nombre del Directivo");
        return false;
    }else if ($("#txtDNI_1").val()==""){
        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html("Seleccione Ingrese el DNI del Directivo");
        return false;
    }else if ($("#txtCargo_1").val()==""){
        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html("Debe Ingresar El Cargo del Directivo");
        return false;
    }
    return true;
}

function guardarDirectivo(){    
    if (validarCamposDirectivo()){        
        if (opt==0){
            $.ajax({
                url:'./GestionTransparente?action=ActualizarDirectivo&opt='+0,
                type: 'POST',
                cache: false,
                dataType:'json',
                data: $("#frmRegistroDirectivoSend").serialize(),
                success:function(response){
                    if ( response.success==true ){
                        $("#frmDirectivo").find(".body").html("");
                        loadDirectivos($("#frmDirectivo").find(".body"));
                        $("#frmDirectivo").show();
                        $("#widget_1").show();
                        $("#frmRegistroDirectivo").hide();
                        $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg);                     
                    } else {
                        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html( response.msg);                     
                    }
                }
            });
        }else if (opt==1){    
            $.ajax({
                url:'./GestionTransparente?action=ActualizarDirectivo&opt=1&codigo='+$("#frmRegistroDirectivo").data("id"),
                dataType:'json',
                cache: false,
                type: 'POST',
                data: $("#frmRegistroDirectivoSend").serialize(),
                success:function(response){
                    if (response.success==true){
                        $("#frmDirectivo").find(".body").html("");
                        loadDirectivos($("#frmDirectivo").find(".body"));
                        $("#frmDirectivo").show();
                        $("#widget_1").show();
                        $("#frmRegistroDirectivo").hide();
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

function cancelarDirectivo(){
    $("#frmDirectivo").find(".body").html("");
    loadDirectivos($("#frmDirectivo").find(".body"));
    $("#widget_1").show();
    $("#frmDirectivo").show();
    $("#frmRegistroDirectivo").hide();
    $("#panelDirectivos").hide();
    return false;
}

function init(){
    $("#tabs").tabs();
    /********************************************************/
    sortableColumns("frmFuncionario");
    createPagination($("#frmFuncionario").find(".body"),"paginate-funcionarios", "frmFuncionario", 1);
    sortableColumns("frmDirectivo");
    createPagination($("#frmDirectivo").find(".body"),"paginate-directivos", "frmDirectivo", 2);
    
    loadFuncionarios(($("#frmFuncionario").find(".body")));
    loadDirectivos(($("#frmDirectivo").find(".body")));
        
    $("#btnNuevoFuncionario").button({
        icons:{
            primary:'ui-icon-plus'
        }
    });
        
    $("#btnNuevoFuncionario").on("click", newFuncionario);
    $("#btnEditarFuncionario").button({
        icons:{
            primary:'ui-icon-pencil'
        }
    }); 
    $("#btnEditarFuncionario").on("click", editFuncionario);        
    $("#btnEliminarFuncionario").button({
        icons: {
            primary:'ui-icon-trash'
        }
    });
    $("#btnEliminarFuncionario").on("click", delFuncionario);
    $("#btnGuardarFuncionario").button({
        icons:{
            primary:'ui-icon-disk'
        }
    });
    /***************************************/
    $("#btnNuevoDirectivo").button({
        icons:{
            primary:'ui-icon-plus'
        }
    });
    $("#btnNuevoDirectivo").on("click", newDirectivo);
    $("#btnEditarDirectivo").button({
        icons:{
            primary:'ui-icon-pencil'
        }
    }); 
    $("#btnEditarDirectivo").on("click", editDirectivo);        
    $("#btnEliminarDirectivo").button({
        icons: {
            primary:'ui-icon-trash'
        }
    });
    $("#btnEliminarDirectivo").on("click", delDirectivo);
    $("#btnGuardarDirectivo").button({
        icons:{
            primary:'ui-icon-disk'
        }
    });
    $("#btnGuardarDirectivo").on("click", guardarDirectivo);
    $("#btnCancelarDirectivo").button({
        icons:{
            primary:'ui-icon-cancel'
        }
    });
        
    $("#btnCancelarDirectivo").on("click", cancelarDirectivo);
    
    /*************************************************/
    $("#btnGuardarFuncionario").on("click", guardarFuncionario);
    $("#btnCancelarFuncionario").button({
        icons:{
            primary:'ui-icon-cancel'
        }
    });
        
    $("#btnCancelarFuncionario").on("click", cancelarFuncionario);
        
    $(".siMessage").on("click",yesMessage);
    $("#btnNuevoFuncionario").button({
        icons:{
            primary:'ui-icon-plus'
        }
    });
    
    $(".noMessage").on("click", notMessage);
    
    $("#txtBuscarFuncionario").keypress(function (evt){
        if(evt.keyCode==13){
            $("#current").val(0);
            $("#start").val(parseInt($("#current").val())* parseInt($("#limit").val()));
            $("#frmFuncionario").find(".body").html("");
            loadFuncionarios($("#frmFuncionario").find(".body"));
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
                $("#txtCurriculum").val(file.nametrue);
                return $('<tr><td>' + file.name + '<\/td><\/tr>');
            }
        });
    }
    initFileUpload(1);
    
    var initFileUpload1 = function (suffix) {
        var id = suffix;
        $('#file_upload_2').fileUploadUI({
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
                $("#fotito").html("<img src='./archivos/"+file.nametrue+"' />");
                $("#txtFoto").val(file.nametrue);
                return $('<tr><td>' + file.name + '<\/td><\/tr>');
            }
        });
    }
    initFileUpload1(2);
    
    var initFileUpload3 = function (suffix) {
        var id = suffix;
        $('#file_upload_3').fileUploadUI({
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
                $("#txtCurriculum_1").val(file.nametrue);
                return $('<tr><td>' + file.name + '<\/td><\/tr>');
            }
        });
    }
    initFileUpload3(3);
    
    var initFileUpload4 = function (suffix) {
        var id = suffix;
        $('#file_upload_4').fileUploadUI({
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
                $("#fotito_1").html("<img src='./archivos/"+file.nametrue+"' />");
                $("#txtFoto_1").val(file.nametrue);
                return $('<tr><td>' + file.name + '<\/td><\/tr>');
            }
        });
    }
    initFileUpload4(4);
    $("body").roles();
}

$("document").ready(function(){
    init();
});
    