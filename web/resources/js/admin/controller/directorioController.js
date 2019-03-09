var mensaje = "Agrega número de anexo de cada dependencia para el Portal web";
var save = false;
function nuevo(){
    $("#frm").hide();
    
    $("#frmRegistro").show();
    $("#frmRegistro").find("input").val("");
    $("#frmRegistro").find("textarea").text("");
    $("#frmRegistro").find("label").html("");
    $("#id").val(0);
    $("#op").val(0);
    $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").text(mensaje);

}
function cancelar(){
    $("#frm").show();
    
    $("#frmRegistro").hide();
    $("#frmRegistro").find("input").val("");
    $("#frmRegistro").find("label").html("");
    $("#id").val(0);
    $("#op").val(0);
    $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").text(mensaje);
}

function editar(){
    $("#frmRegistro").data("id", $("#grid").find(".z-listitem-seld").eq(0).find("td:last").text());
    $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").text(mensaje);
    if($("#frmRegistro").data("id")!=""){
        $("#frm").hide();
        $("#frmRegistro").show();
        $("#frmRegistro").find("label").html("");
        $("#op").val(1);
        $("#id").val($("#frmRegistro").data("id"));
        $.ajax({
            dataType:'json',
            type:'post',
            url: './LaInstitucion?action=GetDirectorio',
            data: {
                "id": $("#frmRegistro").data("id")
            },
            success:function(response){ 
                $("#frmRegistro").find("input").eq(0).val(response.oficina);
                $("#frmRegistro").find("input").eq(1).val(response.seccion);
                $("#frmRegistro").find("input").eq(2).val(response.anexo);
                
            }
        });
    } else {
        $("#dialog-msg").html("Seleccione un Grupo!")
        $( "#dialog-confirm" ).dialog("open");
    }
}


function actualizar(form, evt){
    if(!save){
        var flag = true;
        $("#frmRegistro").find("label").html("");
        if($("#frmRegistro").find("input").eq(0).val()==""){
            flag= false;
            $("#frmRegistro").find("label").eq(0).html("<font color='#ff0000'>No se debe dejar en Blanco</font>")
        }
        
        if($("#frmRegistro").find("input").eq(1).val()==""){
            flag= false;
            $("#frmRegistro").find("label").eq(1).html("<font color='#ff0000'>No se debe dejar en Blanco</font>")
        }
        
        if($("#frmRegistro").find("input").eq(2).val()==""){
            flag= false;
            $("#frmRegistro").find("label").eq(2).html("<font color='#ff0000'>No se debe dejar en Blanco</font>")
        }
    
        if (flag)
            $.ajax({
                dataType:'json',
                type:'post',
                url: form.attr("action"),
                data: form.serialize(),
                success:function(response){
                    save= false;
                    evt.isPropagationStopped()
                    if(response.success){
                        $("#frmRegistro").hide();
                        $("#frm").show();
                        $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg);
                        $("#grid").find("button").eq(3).click();
                    } else {
                        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html( response.msg);
                    }
                }
            });
        save= true;
    } else save=false;
}

function init(){
    $(function() {
        $( "#dialog" ).dialog({
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
            },
            close: function(){
                $("#grid").find("button").eq(4).click()
            }
        });
        $( "#dialog-confirm" ).dialog({
            autoOpen: false,
            modal: true,
            show: "blind",
            hide: "explode",
            resizable: false,
            height:140,
            buttons: {
                "Aceptar": function() {
                    $( this ).dialog( "close" );
                }
            }
        });
        $("#grid").find("button").button({
            disabled:true
        });
    
        $("#btnNuevo").button({
            icons:{
                primary:'ui-icon-document'
            }
        });
        $("#btnNuevo").on("click", nuevo);
    
        $("#btnEditar").button({
            icons:{
                primary:'ui-icon-pencil'
            }
        }).on("click", editar);
    
        $("#grid").find("button").eq(2).button({
            icons:{
                primary:'ui-icon-trash'
            }
        }).attr("lang","eliminar")

        $("#grid").find("button").eq(3).button({
            icons:{
                primary:'ui-icon-plus'
            }
        });
    
        $("#grid").find("button").eq(3).button({
            icons:{
                primary:'ui-icon-arrowrefresh-1-e'
            }
        }).attr("lang","otro");
    
        $("#btnGuardar").button({
            icons:{
                primary:'ui-icon-disk'
            }
        });
    
        $("#btnCancelar").button({
            icons:{
                primary:'ui-icon-cancel'
            }
        });
    
        $("#btnCancelar").on("click", cancelar);
    
        $("#formRegistro").submit(function(evt){
            actualizar($(this), evt);
            return false;
        });  
    
        
        $("body").roles({
            atributo:"lang"
        });
    });
}


