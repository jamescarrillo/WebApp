var opcion=1;
var     capa = null;
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

function saveSolicitude(){        
    if(opcion==1){                
        $.ajax({
            url:'./ParticipacionCiudadana?action=actualizarSolicitud',
            data:{
                id: parseInt($("#frmRegistroSolicitud").data("idSolicitude"))
            },
            success:function(response){
                $("#message").removeClass("ui-state-error").addClass("ui-state-hightlight").html(response.msg);
                $("#frmRegistroSolicitud").css("display","none");
                $("#noticias").css("display","block");
                $("#txtBuscador").css("display","block");
                $("#noticias").empty();
                loadSolicitude();
                $("#frmRegistroSolicitud").removeData("idSolicitude");
                $("#btnBuscar").show();
                $("#btnGuardar").hide();
                $("#btnCancelar").hide();  
                $("#btnImprimir").hide();
            }
        });
    }
        
    return false;
}
function loadSolicitude(){
    $.ajax({
        url:'./ParticipacionCiudadana?action=listarSolicitudForAdmin',
        method:"get",
        data:{
            start:$("#txtStart").val(),
            filtro:$("#txtBuscador").val(),
            limit:$("#txtLimit").val(),
            current:$("#txtCurrent").val()
        },
        success:function(response){
            $("#noticias").append(response);
            
            $datafecha("fechaRegistro");
            $("#contenidoSolicitud").htmlarea({
                toolbar: [
                "html","bold", "italic", "underline",
                "|",
                "h1", "h2", "h3", "h4", "h5", "h6",
                "|",
                "link", "unlink","|","p", "orderedlist", "unorderedlist"
                ]
            });
            $(".notice").hover(function(){  
                $(this).children(".notice-tools").children(".notice-tbutton").css("display","block");
            }, function(){                      
                $(this).children(".notice-tools").children(".notice-tbutton").css("display","none");
            });
            $(".editar").on("click",editarSolicitude);    
            $(".eliminar").on("click",mostrarDialogEliminarSolicitude);
                    
            if((parseInt($("#txtCurrent").val()))<Math.ceil(parseInt($(".notice").attr("data"))/parseInt($("#txtLimit").val()))){
                $("#btnSeguir").css("display","block");
            }
            else{
                $("#btnSeguir").css("display","none");                        
            } 
            if((parseInt($("#txtCurrent").val())+1)==Math.ceil(parseInt($(".notice").attr("data"))/parseInt($("#txtLimit").val()))){
                $("#btnSeguir").css("display","none");
            }
            $("#noticias").roles(); 
            
              
        }
    });
    return false;
}

function mostrarDialogEliminarSolicitude(){
    var ik=parseInt($(this).parent().parent().attr("data"));
    capa = $(this).parent().parent().parent();
    $("#msg-icon").addClass("ui-icon ui-icon-info");
    $(".msg-html").html("¿Estas seguro de eliminar la Solicitud?");        
    $(".eliminarQuestion").dialog({
        title:'Mensaje de Advertencia',
        modal:true,
        height: 145 ,
        resizable:false 
    });
    $(".eliminarQuestion").data("idSolicitude",ik);
}

function editarSolicitude(){
    var ik=parseInt($(this).parent().parent().attr("data"));
    
    //obtener la noticia
    $.ajax({
        url:'./ParticipacionCiudadana?action=getSolicitudForAdmin',
        dataType:'json',
        data:{
            id:ik
        },            
        success:function(response){
            if(response.solicitud!=null){
                $("#frmRegistroSolicitud").css("display","block");
                $("#frmRegistroSolicitud").data("idSolicitude",ik);
                $("#noticias").css("display","none");
                $("#txtBuscador").css("display","none");
                $("#busqueda-more").css("display","none");
                    
                $("#btnBuscar").hide();
                $("#btnGuardar").show();
                $("#btnCancelar").show(); 
                $("#btnImprimir").show(); 
                var opcion=1;
                
                //ahora llenamos el form
                var forma = "";
                switch (response.solicitud.forma){
                    case 1: forma = "Copia Simple"; break;
                    case 2: forma = "Copia Fedateada"; break;
                    case 3: forma = "CD-ROM"; break;
                    case 4: forma = "Correo Electrónico"; break;
                    case 5: forma = "Otro"; break;
                }
                
                $("#nroRegistro").val(ik);
                $("#fechaRegistro").val(fechaUnFormat(response.solicitud.fechaRegistro));
                $("#nombre").val(response.solicitud.usuario);
                $("#correo").val(response.solicitud.correo);
                $("#documento").val(response.solicitud.dni);
                $("#dependencia").val(response.solicitud.dependencia);
                $("#domicilio").val(response.solicitud.domicilio);
                $("#telefono").val(response.solicitud.telefono);
                $("#contenidoSolicitud").htmlarea("html",response.solicitud.descripcion);
                $("#forma").html(forma);
            }
        }
            
    });
    return false;
}

function cancelar(){        
    opcion=0;
    $("#frmRegistroSolicitud").css("display","none");
    $("#noticias").css("display","block");
    $("#txtBuscador").css("display","block");
    $("#busqueda-more").css("display","block");
    $("#noticias").empty();
    $("#txtStart").val(0);
    $("#txtCurrent").val(0);
    loadSolicitude();
    //$("#btnNuevo").show();
    $("#btnBuscar").show();
    $("#btnGuardar").hide();
    $("#btnCancelar").hide();
    $("#btnImprimir").hide();
    $("#message").html("Administre las solicitudes de una manera f&aacute;cil y sencilla");
    return false;
}

function eliminarSolicitude(){
    $.ajax({
        url:'ParticipacionCiudadana?action=EliminarSolicitud',
        dataType:'json',
        data:{
            id: $(".eliminarQuestion").data("idSolicitude")
        },
        success:function(response){
            if(response.success){
                $(".eliminarQuestion").dialog("close");
                $("#message").removeClass("ui-state-error").addClass("ui-state-hightlight").html(response.msg);                   
                capa.remove();
            }
            else{
                $(".eliminarQuestion").dialog("close");
                $("#message").removeClass("ui-state-hightlight").addClass("ui-state-error").html(response.msg);  
            }
        }
    });
    return false;
}

function seguirSolicitude(){
    $("#txtCurrent").val(parseInt($("#txtCurrent").val())+1);
    $("#txtStart").val(parseInt($("#txtCurrent").val())*parseInt($("#txtLimit").val()));
    loadSolicitude();
}

function buscarSolicitude(){
    $("#txtCurrent").val(0);
    $("#txtStart").val(0);
    $("#noticias").html("");
    loadSolicitude();
    return false;
}

function imprimir(){
    var url="./SolicitudPrint";
    var ik=$("#frmRegistroSolicitud").data("idSolicitude");
    $("#btnImprimir").attr("href",url+"?id="+ik+"&format=pdf");
}

function init(){
    $("#txtCurrent").val(0);
    $("#txtStart").val(0);
    $("#txtLimit").val(7);
    loadSolicitude();
    $("#btnImprimir").button().click(function(){
        imprimir();
    });
    $("#btnBuscar").button();
    $("#btnBuscar").on("click",buscarSolicitude);
    $("#btnGuardar").button();
    $("#btnGuardar").on("click",saveSolicitude);
    $("#btnCancelar").button();
    $("#btnCancelar").on("click",cancelar);
    $("#txtBuscador").keypress(function(e){
        if(e.keyCode==13){                    
            return false;
        }
        return true;
    });           
    $(".siMessage").on("click",eliminarSolicitude);
    $(".noMessage").click(function(){
        $(".eliminarQuestion").dialog("close");
    });
    $("#btnSeguir").on("click",seguirSolicitude);
    $("body").roles();
}

$("document").ready(function(){
    init();
});