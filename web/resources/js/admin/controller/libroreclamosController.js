var opcion=0;
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
function fechaUnFormat(fecha){
    var formato
    var $fecha = fecha.split("-");
    formato = $fecha[2].trim(" ") + "/"+ $fecha[1].trim(" ")  +"/" +$fecha[0].trim(" ");
    return  formato;
}
function validarCampos(){
    if($("#contenidoReclamo").val() == ""){
        $("#message").removeClass("ui-state-hightlight").addClass("ui-state-error").html("No puede borrar todo el cotenido del Reclamo");
        return false;
    }else if($("#respuestaReclamo").val()==""){
        $("#message").removeClass("ui-state-hightlight").addClass("ui-state-error").html("Ingrese una respuesta para poder guardar");
        return false;
    }
    return true;
}
function saveReclamo(){      
    var ik=$(this).parent().parent().attr("id");
    var send;
    $( "#dialog-confirm" ).dialog({
        resizable: false,
        height:200,
        modal: true,
        buttons: {
            "Si": function() {
                send = true;
                $( this ).dialog( "close" );
            },
            No: function() {
                send = false;
                $( this ).dialog( "close" );
            }
        }
    });
    //enviamos los datos del registro
    if(opcion==1){
        $.ajax({
            url:'./ParticipacionCiudadana?action=actualizarReclamo',
            data:{
                reclamo:$("#contenidoReclamo").val(),
                acciones:$("#respuestaReclamo").val(),
                id:$("#frmRegistroReclamo").data("numeroReclamo"),
                estado: $("#txtEstadoReclamo").is(":checked"),
                email: $("#email").val(),
                fecha : $("#fechaReclamo").val(),
                send : send
                    
            },
            success:function(response){
                $("#message").removeClass("ui-state-error").addClass("ui-state-hightlight").html(response.msg);
                //volvemos a mostrar las noticias
                $("#frmRegistroReclamo").css("display","none");
                $("#noticias").css("display","block");
                $("#txtBuscador").css("display","block");
                loadReclamo();
                $("#frmRegistroReclamo").removeData("numeroReclamo");
                $("#btnNuevo").show();
                $("#btnBuscar").show();
                $("#btnGuardar").hide();
                $("#btnCancelar").hide();
            }
        });
    }
    
    
        
    
    return false;
}

function loadReclamo(){
    $.ajax({
        url:'./ParticipacionCiudadana?action=listarReclamosForAdmin',
        method:"get",
        data:{
            start:$("#txtStart").val(),
            filtro:$("#txtBuscador").val(),
            limit:$("#txtLimit").val(),
            current:$("#txtCurrent").val()
        },
        success:function(response){
            $("#noticias").empty();
            $("#noticias").append(response);
            

            $("#contenidoReclamo").htmlarea({
                toolbar: [
                "bold", "italic", "underline",
                "|",
                "h1", "h2", "h3", "h4", "h5", "h6",
                "|",
                "link", "unlink","|","p"
                ]
            });
            $("#respuestaReclamo").htmlarea({
                toolbar: [
                "bold", "italic", "underline",
                "|",
                "h1", "h2", "h3", "h4", "h5", "h6",
                "|",
                "link", "unlink","|","p"
                ]
            });  
            $(".notice").hover(function(){  
                $(this).children(".notice-tools").children(".notice-tbutton").css("display","block");
            }, function(){                      
                $(this).children(".notice-tools").children(".notice-tbutton").css("display","none");
            });
            $(".editar").on("click",editarReclamo);    
            $(".eliminar").on("click",mostrarDialogEliminarReclamo);
                    
            if((parseInt($("#txtCurrent").val()))<Math.ceil(parseInt($(".Reclamo").attr("data"))/parseInt($("#txtLimit").val()))){
                $("#btnSeguir").css("display","block");
            }
            else{
                $("#btnSeguir").css("display","none");                        
            } 
            if((parseInt($("#txtCurrent").val())+1)==Math.ceil(parseInt($(".Reclamo").attr("data"))/parseInt($("#txtLimit").val()))){
                $("#btnSeguir").css("display","none");
                 
            }
            $("#noticias").roles(); 
            
              
        }
    });
    return false;
}

function mostrarDialogEliminarReclamo(){
    var ik=$(this).parent().parent().attr("data");
    $("#msg-icon").addClass("ui-icon ui-icon-info");
    $(".msg-html").html("¿Estas seguro de eliminar El Reclamo?");        
    $(".eliminarQuestion").dialog({
        title:'Mensaje de Advertencia',
        modal:true,
        height: 145 ,
        resizable:false 
    });
  
    $(".eliminarQuestion").data("numeroReclamo",ik);
}

function editarReclamo(){
    var ik=$(this).parent().parent().attr("data");
    //obtener el reclamo
    $.ajax({
        url:'./ParticipacionCiudadana?action=getReclamoForAdmin',
        dataType:'json',
        data:{
            id: ik
        },            
        success:function(response){
            if(response.reclamo!=null){
                $("#frmRegistroReclamo").css("display","block");
                $("#frmRegistroReclamo").data("numeroReclamo",ik);
                $("#noticias").css("display","none");
                $("#txtBuscador").css("display","none");
                $("#busqueda-more").css("display","none");
                $("#btnNuevo").hide();
                $("#btnBuscar").hide();
                $("#btnGuardar").show();
                $("#btnCancelar").show(); 
                opcion=1;
                //ahora llenamos el form
                $("#fechaReclamo").val(fechaUnFormat(response.reclamo.fecha));
                $("#nombre").val(response.reclamo.usuario);
                $("#tipoDocument").html(response.reclamo.documentoIdentidad);
                $("#documento").val(response.reclamo.numeroDocumento);
                $("#domicilio").val(response.reclamo.direccion);
                $("#telefono").val(response.reclamo.telefono);
                $("#contenidoReclamo").htmlarea("html",response.reclamo.descripcionAtencion);
                $("#respuestaReclamo").htmlarea("html",response.reclamo.detalleAcciones);
                $("#email").val(response.reclamo.email);
                if (response.reclamo.estado){
                    $("#txtEstadoReclamo").attr("checked","checked");
                }
                else{
                    $("#txtEstadoReclamo").removeAttr("checked");
                }
            }
        }
    });
    return false;
}
function cancelar(){        
    opcion=0;
    $("#frmRegistroReclamo").css("display","none");
    $("#noticias").css("display","block");
    $("#txtBuscador").css("display","block");
    $("#busqueda-more").css("display","block");
    loadReclamo();
    $("#btnNuevo").show();
    $("#btnBuscar").show();
    $("#btnGuardar").hide();
    $("#btnCancelar").hide();
    $("#message").html("Administre El libro de reclamos de una manera fácil, y sencilla con solo unos clicks");
    return false;
}
    
function eliminarReclamo(){
    
    $.ajax({
        url:'ParticipacionCiudadana?action=EliminarReclamo',
        dataType:'json',
        data:{
            id: $(".eliminarQuestion").data("numeroReclamo")
        },
        success:function(response){
            if(response.success){
                $("#txtCurrent").val(0);
                $("#txtStart").val(0);
                $("#noticias").html("");
                $(".eliminarQuestion").dialog("close");
                $("#message").removeClass("ui-state-error").addClass("ui-state-hightlight").html(response.msg);                   
                loadReclamo();
            }
            else{
                $(".eliminarQuestion").dialog("close");
                $("#message").removeClass("ui-state-hightlight").addClass("ui-state-error").html(response.msg);  
            }
        }
    });
    return false;
}

function seguirReclamo(){
    $("#txtCurrent").val(parseInt($("#txtCurrent").val())+1);
    $("#txtStart").val(parseInt($("#txtCurrent").val())*parseInt($("#txtLimit").val()));
    loadReclamo();
}

function buscarReclamo(){
    $("#txtCurrent").val(0);
    $("#txtStart").val(0);
    $("#noticias").html("");
    loadReclamo();
    return false;
}
function init(){
    loadReclamo();
    
    $("#btnBuscar").button();
    $("#btnBuscar").on("click",buscarReclamo);
    $("#btnNuevo").button();
    $("#btnGuardar").button().on("click",saveReclamo);
    $("#btnCancelar").button();
    $("#btnCancelar").on("click",cancelar);
    $("#txtBuscador").keypress(function(e){
        if(e.keyCode==13){                    
            return false;
        }
        return true;
    });           
    $(".siMessage").on("click",eliminarReclamo);
    $(".noMessage").click(function(){
        $(".eliminarQuestion").dialog("close");
    });

    $("#btnSeguir").on("click",seguirReclamo);
    $("body").roles();
        
    
}

$("document").ready(function(){
    init();
});
