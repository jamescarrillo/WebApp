var mensaje = "Registre en nuestro formulario Las penalidades de algunos procesos";
var save = false;

function isOnlyNumber(evt)
{
    var charCode = (evt.which) ? evt.which : evt.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57) || charCode==10)
        return false; 
    return true;
}

function nuevo(){
    $("#frm").hide();
    $("#frmRegistro").show();
    $("#frmRegistro").find("input").val("");
    $("#frmRegistro").find("textarea").val("");
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
            url: './Convocatoria?action=GetPenalidad',
            data: {
                "id": $("#frmRegistro").data("id")
            },
            success:function(response){ 
                $("#frmRegistro").find("input").eq(0).val(response.anho);
                $("#frmRegistro").find("input").eq(1).val(response.montoContrato);
                $("#frmRegistro").find("textarea").eq(0).val(response.objeto.toString());
                $("#frmRegistro").find("input").eq(2).val(response.contratista);
                $("#frmRegistro").find("input").eq(3).val(response.ruc);
                $("#frmRegistro").find("input").eq(4).val(response.nroProceso);
                $("#frmRegistro").find("input").eq(5).val(response.nroContrato);
                $("#frmRegistro").find("input").eq(6).val(response.tipo);
                $("#frmRegistro").find("input").eq(7).val(response.montoPenalidad);
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
        
        if($("#frmRegistro").find("input").eq(3).val()==""){
            flag= false;
            $("#frmRegistro").find("label").eq(3).html("<font color='#ff0000'>No se debe dejar en Blanco</font>")
        }
         if($("#frmRegistro").find("textarea").eq(0).val()==""){
            flag= false;
            $("#frmRegistro").find("label").eq(4).html("<font color='#ff0000'>No se debe dejar en Blanco</font>")
        }
        if($("#frmRegistro").find("input").eq(4).val()==""){
            flag= false;
            $("#frmRegistro").find("label").eq(5).html("<font color='#ff0000'>No se debe dejar en Blanco</font>")
        }
        
        if($("#frmRegistro").find("input").eq(5).val()==""){
            flag= false;
            $("#frmRegistro").find("label").eq(6).html("<font color='#ff0000'>No se debe dejar en Blanco</font>")
        }
        
        if($("#frmRegistro").find("input").eq(6).val()==""){
            flag= false;
            $("#frmRegistro").find("label").eq(7).html("<font color='#ff0000'>No se debe dejar en Blanco</font>")
        }
        
        if($("#frmRegistro").find("input").eq(7).val()==""){
            flag= false;
            $("#frmRegistro").find("label").eq(8).html("<font color='#ff0000'>No se debe dejar en Blanco</font>")
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
    
       
        $("#frmRegistro").find("input").eq(0).on("keypress",isOnlyNumber);
        $("#frmRegistro").find("input").eq(3).on("keypress",isOnlyNumber);
        
        $("body").roles({
            atributo:"lang"
        });
    });
}


$(function() {
    $("#formRegistro").submit(function(evt) {
        actualizar($(this), evt);
        return false;
    });
});