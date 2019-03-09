function fechaUnFormat(fecha){
    var formato
    var $fecha = fecha.split("-");
    formato = $fecha[2].trim(" ") + "/"+ $fecha[1].trim(" ")  +"/" +$fecha[0].trim(" ");
    return  formato;
}
var opcion=0;
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
function saveComentario(){      
    var ik=$(this).parent().parent().attr("id");
    if (validarCampos()){
        //enviamos los datos del registro
        if(opcion==1){
            $.ajax({
                url:'./ParticipacionCiudadana?action=actualizarComentario',
                data:{
                    comentario:$("#contenidoComentario").val(),
                    tema:$("#tema").val(),
                    id:$("#frmRegistroComentario").data("numeroComentario")
                },
                success:function(response){
                    $("#message").removeClass("ui-state-error").addClass("ui-state-hightlight").html(response.msg);
                    //volvemos a mostrar las noticias
                    $("#frmRegistroComentario").css("display","none");
                    $("#noticias").css("display","block");
                    $("#txtBuscador").css("display","block");
                    loadComentario();
                    $("#frmRegistroComentario").removeData("numeroComentario");
                    $("#btnNuevo").show();
                    $("#btnBuscar").show();
                    $("#btnGuardar").hide();
                    $("#btnCancelar").hide();  
                }
            });
        }
    }
    return false;
}

function loadComentario(){
    $.ajax({
        url:'./ParticipacionCiudadana?action=listarComentarioForAdmin',
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
            
            /*$("#fecha").datepicker({ 
                        altFormat:"dd/mm/yy",
                        dateFormat:"dd/mm/yy",
                        currentText: "Now"
                    });  */                  
            $("#contenidoComentario").htmlarea({
                toolbar: [
                "bold", "italic", "underline",
                "|",
                "h1", "h2", "h3", "h4", "h5", "h6",
                "|",
                "link", "unlink","|","p"
                ]
            });
            $("#respuestaComentario").htmlarea({
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
            $(".editar").on("click",editarComentario);    
            $(".eliminar").on("click",mostrarDialogEliminarComentario);
                    
            if((parseInt($("#txtCurrent").val()))<Math.ceil(parseInt($(".Comentario").attr("data"))/parseInt($("#txtLimit").val()))){
                $("#btnSeguir").css("display","block");
            }
            else{
                $("#btnSeguir").css("display","none");                        
            } 
            if((parseInt($("#txtCurrent").val())+1)==Math.ceil(parseInt($(".Comentario").attr("data"))/parseInt($("#txtLimit").val()))){
                $("#btnSeguir").css("display","none");
            }
            $("#noticias").roles(); 
            
              
        }
    });
    return false;
}
function mostrarDialogEliminarComentario(){
    var ik=$(this).parent().parent().attr("data");
    $("#msg-icon").addClass("ui-icon ui-icon-info");
    $(".msg-html").html("¿Estas seguro de eliminar la noticias?");        
    $(".eliminarQuestion").dialog({
        title:'Mensaje de Advertencia',
        modal:true,
        height: 145 ,
        resizable:false 
    });
  
    $(".eliminarQuestion").data("numeroComentario",ik);
}
function editarComentario(){
    var ik=$(this).parent().parent().attr("data");
    //obtener la noticia
    $.ajax({
        url:'./ParticipacionCiudadana?action=getComentarioForAdmin',
        dataType:'json',
        data:{
            id:ik
        },            
        success:function(response){
            if(response.comentario!=null){
                $("#frmRegistroComentario").css("display","block");
                $("#frmRegistroComentario").data("numeroComentario",ik);
                $("#noticias").css("display","none");
                $("#txtBuscador").css("display","none");
                $("#busqueda-more").css("display","none");
                $("#btnNuevo").hide();
                $("#btnBuscar").hide();
                $("#btnGuardar").show();
                $("#btnCancelar").show(); 
                opcion=1;
                //ahora llenamos el form
                
                $("#fechaComentario").val(fechaUnFormat(response.comentario.fecha));
                $("#nombre").val(response.comentario.usuario);
                $("#correo").val(response.comentario.correo);
                $("#tema").val(response.comentario.tema);
                $("#contenidoComentario").htmlarea("html",response.comentario.descripcion);
            }
        }
            
    });
    return false;
}
function cancelar(){        
    opcion=0;
    $("#frmRegistroComentario").css("display","none");
    $("#noticias").css("display","block");
    $("#txtBuscador").css("display","block");
    $("#busqueda-more").css("display","block");
    $("#noticias").empty();
    $("#txtStart").val(0);
    $("#txtCurrent").val(0);
    loadComentario();
    $("#btnNuevo").show();
    $("#btnBuscar").show();
    $("#btnGuardar").hide();
    $("#btnCancelar").hide();
    $("#message").html("Administre los comentarios y sugerencias de una manera fácil, y sencilla con solo unos clicks");
    return false;
}
    
function eliminarComentario(){
    $.ajax({
        url:'./ParticipacionCiudadana?action=EliminarComentario',
        dataType:'json',
        data:{
            id: $(".eliminarQuestion").data("numeroComentario")
        },
        success:function(response){
            if(response.success){
                $(".eliminarQuestion").dialog("close");
                $("#message").removeClass("ui-state-error").addClass("ui-state-hightlight").html(response.msg);                   
                loadComentario();
            }
            else{
                $(".eliminarQuestion").dialog("close");
                $("#message").removeClass("ui-state-hightlight").addClass("ui-state-error").html(response.msg);  
            }
        }
    });
    return false;
}

function seguirComentario(){
    $("#txtCurrent").val(parseInt($("#txtCurrent").val())+1);
    $("#txtStart").val(parseInt($("#txtCurrent").val())*parseInt($("#txtLimit").val()));
    loadComentario();
}
function buscarComentario(){
    $("#txtCurrent").val(0);
    $("#txtStart").val(0);
    $("#noticias").html("");
    loadComentario();
    return false;
}
function init(){
    loadComentario();
    
    $("#btnBuscar").button();
    $("#btnBuscar").on("click",buscarComentario);
    $("#btnNuevo").button();

    $("#btnGuardar").button().on("click",saveComentario);
    $("#btnCancelar").button();
    $("#btnCancelar").on("click",cancelar);
    $("#txtBuscador").keypress(function(e){
        if(e.keyCode==13){                    
            return false;
        }
        return true;
    });           
    $(".siMessage").on("click",eliminarComentario);
    $(".noMessage").click(function(){
        $(".eliminarQuestion").dialog("close");
    });
        
    $("#btnSeguir").on("click",seguirComentario);
    $("body").roles();
    
}

$("document").ready(function(){
    init();
});
