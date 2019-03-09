
var opcion=0;
function checkRegexp( o, regexp) {
    var text = o.val();
    if (text.length<=1) text=text+text;
    if ( !( regexp.test( text ) ) ) {
        o.addClass( "ui-state-error" );
        return false;
    } else{
        o.removeClass( "ui-state-error" );
        return true;
    }
}

function validarCampos(){
    var bValid = true;
    bValid = bValid && checkRegexp( $("#paraCorreo"), /[\w-\.]{3,}@([\w-]{2,}\.)*([\w-]{2,}\.)[\w-]{2,4}/ );
    if (! bValid) {
        $("#message").removeClass("ui-state-hightlight").addClass("ui-state-error").html("Ingrese Correctamente el correo");
    }
    
    bValid = bValid && checkRegexp( $("#deCorreo"), /[\w-\.]{3,}@([\w-]{2,}\.)*([\w-]{2,}\.)[\w-]{2,4}/ );
    if (! bValid) {
        $("#message").removeClass("ui-state-hightlight").addClass("ui-state-error").html("Ingrese Correctamente el correo");
    }
    
    if( bValid){
        $("#message").removeClass("ui-state-error").addClass("ui-state-hightlight").html("Configure a donde quiere que llegue información solicitada por los usuarios, usando su correo(s)");
    }
    
    return bValid;
}

function saveCorreo(){
    //enviamos los datos del registro
    if(opcion==0){
        $("#frmRegistroCorreo").submit(function(){
            if (validarCampos()){
                $.ajax({
                    type: 'POST',
                    url:"./ParticipacionCiudadana?action=ActualizarCorreo",
                    cache: false,
                    dataType:"json",
                    data: $(this).serialize(),
                    success:function(response){
                        $("#btnGuardar").button({
                            disabled: true
                        });
                        if (response.success){
                            $("#message").removeClass("ui-state-error").addClass("ui-state-hightlight").html(response.msg);
                        }
                        else{
                            $("#message").removeClass("ui-state-hightlight").addClass("ui-state-error").html(response.msg);
                        }
                    }
                });
            }
            return false;
        });
    }
}

function elegirModulo(){
    $.ajax({
        url:'./ParticipacionCiudadana?action=GetCorreo',
        cache: false,
        dataType:"json",
        data: {
            tipo : $("#moduloCorreo").val()
        },
        success:function(datos){
            $("#paraCorreo").val(datos.paraCorreo==null?"":datos.paraCorreo);
            $("#ccCorreo").val(datos.ccCorreo==null?"":datos.ccCorreo);
            $("#deCorreo").val(datos.parteCorreo==null?"":datos.parteCorreo);
            $("#mensajeCorreo").text(datos.mensajeCorreo==null?"":datos.mensajeCorreo);
            if (datos.estado){
                $("#txtEstado").attr("checked","checked");
            }
            else{
                $("#txtEstado").removeAttr("checked");
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

function init(){
    $("#btnGuardar").button({
        disabled:true,
        icons: {
            primary:'ui-icon-disk'
        }
    }).on("click", saveCorreo);
    $("#moduloCorreo").bind("change", elegirModulo);
    elegirModulo();
    $(".import").keyup(function(){
        $validImportantes(".import", "#btnGuardar");
    });
    $(".noimport").keyup(function(){ 
        $validImportantes(".import", "#btnGuardar");
    }).bind("change",(function(){
        $validImportantes(".import", "#btnGuardar");
    }))
    $("body").roles();
}

$("document").ready(function(){
    init();
});
