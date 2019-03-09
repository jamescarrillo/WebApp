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
function validarCampos(){
    if ($("#tituloAnuncio").val() == "") {
        $("#message").removeClass("ui-state-hightlight").addClass("ui-state-error").html("Debe ingresar el titulo del  anuncio");
        return false;
    }else if($("#contenidoAnuncio").val()==""){
        $("#message").removeClass("ui-state-hightlight").addClass("ui-state-error").html("Debe ingresar el contenido del anuncio");
        return false;
    }
    return true;
}

function saveAnunce(){        
    if (validarCampos()){
        //enviamos los datos del registro
        $("#noticias").empty();
        $("#txtStart").val(0);
        $("#txtCurrent").val(0);
        if(opcion==0){
            $.ajax({
                url:"./Publicaciones?action=InsertarAnuncio",
                dataType:"json",
                data:{
                    titulo:$("#tituloAnuncio").val(),
                    contenido:$("#contenidoAnuncio").val(),
                    fechaInicio:$("#fechaInicioPublicacion").val(),
                    fechaFin:$("#fechaFinPublicacion").val(),
                    tipo:$("#tipoAnuncio").val(),
                    estado: $("#txtEstadoAnuncio").is(":checked")
                },
                success:function(response){
                    if (response.success){
                        $("#message").removeClass("ui-state-error").addClass("ui-state-hightlight").html(response.msg);
                        //volvemos a mostrar las noticias
                        $("#frmRegistroAnuncio").css("display","none");
                        $("#noticias").css("display","block");
                        $("#txtBuscador").css("display","block");
                        $("#busqueda-more").css("display","block");
                        loadAnunce();
                        $("#btnNuevo").show();
                        $("#btnBuscar").show();
                        $("#btnGuardar").hide();
                        $("#btnCancelar").hide();
                    }
                    else{
                        $("#message").removeClass("ui-state-hightlight").addClass("ui-state-error").html(response.msg);  
                    }
                }
            });
        }else if(opcion==1){                
            $.ajax({
                url:'./Publicaciones?action=ActualizarAnuncio',
                data:{
                    id: parseInt($("#frmRegistroAnuncio").data("idAnunce")),
                    titulo:$("#tituloAnuncio").val(),
                    contenido:$("#contenidoAnuncio").val(),
                    fechaInicio:$("#fechaInicioPublicacion").val(),
                    fechaFin:$("#fechaFinPublicacion").val(),
                    tipo:$("#tipoAnuncio").val(),
                    estado: $("#txtEstadoAnuncio").is(":checked")
                },
                success:function(response){
                    $("#message").removeClass("ui-state-error").addClass("ui-state-hightlight").html(response.msg);
                    //volvemos a mostrar las noticias
                    $("#frmRegistroAnuncio").css("display","none");
                    $("#noticias").css("display","block");
                    $("#txtBuscador").css("display","block");
                    loadAnunce();
                    $("#frmRegistroAnuncio").removeData("idAnunce");
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
function newAnunce(){      
    $("#frmRegistroAnuncio").css("display","block");
    $("#noticias").css("display","none");
    $("#txtBuscador").css("display","none");
    $("#busqueda-more").css("display","none");
    $("#fechaInicioPublicacion").datepicker("setDate",new Date());
    $("#fechaFinPublicacion").datepicker("setDate",new Date());
    $("#fuenteAnuncio").val("");
    $("#tituloAnuncio").val("");
    $("#btnNuevo").hide();
    $("#btnBuscar").hide();
    $("#btnGuardar").show();
    $("#btnCancelar").show();
    opcion=0;
    return false;
}
function loadAnunce(){
    $.ajax({
        url:'./Publicaciones?action=ListarAnuncioForAdmin',
        method:"get",
        data:{
            start:$("#txtStart").val(),
            filtro:$("#txtBuscador").val(),
            limit:$("#txtLimit").val(),
            current:$("#txtCurrent").val()
        },
        success:function(response){
            $("#noticias").empty().append(response);
                
            

            $datafecha("fechaInicioPublicacion");
            $datafecha("fechaFinPublicacion");
            $("#contenidoAnuncio").htmlarea({
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
            $(".editar").on("click",editarAnunce);    
            $(".eliminar").on("click",mostrarDialogEliminarAnunce);
            $(".publicar").on("click",mostrarDialogPublicarAnunce);
            $(".ver").on("click",mostrarDialogVerNotice);

            if((parseInt($("#txtCurrent").val()))<Math.ceil(parseInt($(".notice").attr("data"))/parseInt($("#txtLimit").val()))){
                $("#btnSeguir").css("display","block");
            }
            else{
                $("#btnSeguir").css("display","none");
            }
            if((parseInt($("#txtCurrent").val())+1)==Math.ceil(parseInt($(".notice").attr("data"))/parseInt($("#txtLimit").val()))){
                $("#btnSeguir").css("display","none");
            }
            $("#noticias").roles({
                atributo:'class'
            });
            
              
        }
    });
    return false;
}

function mostrarDialogEliminarAnunce(){
    var ik=parseInt($(this).parent().parent().attr("data"));
    $("#msg-icon").addClass("ui-icon ui-icon-info");
    $(".msg-html").html("¿Estas seguro de eliminar la Anuncio?");        
    $(".eliminarQuestion").dialog({
        title:'Mensaje de Advertencia',
        modal:true,
        height: 145 ,
        resizable:false 
    });
    $(".eliminarQuestion").data("idAnunce",ik);
}

function mostrarDialogPublicarAnunce(){
    var ik=parseInt($(this).parent().parent().attr("data"));
    $("#msg-icon-public").addClass("ui-icon ui-icon-info");
    $(".msg-html-public").html("¿Estas seguro de publicar este anuncio?");        
    $(".eliminarQuestionPublic").dialog({
        title: 'Mensaje de Advertencia',
        modal: true,
        height: 145,
        resizable: false 
    });
    $(".eliminarQuestionPublic").data("idAnunce",ik);
}

function mostrarDialogVerNotice(){
    
    $(".paper").css({
        opacity: 0.9
    });
    $('.paper').corner("10px");
    $(".paper").css({
        "display": "block"
    });
    
    var posicion = $(this).position();
    
    $(".paper").css({
        "margin-top": parseInt(posicion.top - 200)+"px"
    })
    var ik=parseInt($(this).parent().parent().attr("data"));
    $.ajax({
        url:'./Publicaciones?action=GetAnuncio',
        dataType:'json',
        data:{
            id:ik
        },
        success:function(response){
            if(response.anuncio!=null){
                $(".titulo").html(response.anuncio.titulo);
                $(".contenido").html(response.anuncio.contenido+" <p style='float:right;'>Fecha:  "+response.anuncio.anuFechaInicio+"/"+response.anuncio.anuFechaFin+"</p>");
            }
        }
    });
}
function editarAnunce(){
    var ik=parseInt($(this).parent().parent().attr("data"));
    //obtener la noticia
    $.ajax({
        url:'./Publicaciones?action=GetAnuncio',
        dataType:'json',
        data:{
            id:ik
        },            
        success:function(response){
            if(response.anuncio!=null){
                $("#frmRegistroAnuncio").css("display","block");
                $("#frmRegistroAnuncio").data("idAnunce",ik);
                $("#noticias").css("display","none");
                $("#txtBuscador").css("display","none");
                $("#busqueda-more").css("display","none");
                $("#btnNuevo").hide();
                $("#btnBuscar").hide();
                $("#btnGuardar").show();
                $("#btnCancelar").show(); 
                opcion=1;
                //ahora llenamos el form
                    
                $("#fechaInicioPublicacion").val(response.anuncio.anuFechaInicio.split("-")[2]+"/"+response.anuncio.anuFechaInicio.split("-")[1]+"/"+response.anuncio.anuFechaInicio.split("-")[0]);
                $("#fechaFinPublicacion").val(response.anuncio.anuFechaFin.split("-")[2]+"/"+response.anuncio.anuFechaFin.split("-")[1]+"/"+response.anuncio.anuFechaFin.split("-")[0]);
                $("#tituloAnuncio").val(response.anuncio.titulo);
                $("#contenidoAnuncio").htmlarea("html",response.anuncio.contenido);
                $("#tipoAnuncio").val(response.anuncio.tipo);
            }
        }
            
    });
    return false;
}
function cancelar(){        
    opcion=0;
    $("#frmRegistroAnuncio").css("display","none");
    $("#noticias").css("display","block");
    $("#txtBuscador").css("display","block");
    $("#busqueda-more").css("display","block");
    $("#noticias").empty();
    $("#txtStart").val(0);
    $("#txtCurrent").val(0);
    loadAnunce();
    $("#btnNuevo").show();
    $("#btnBuscar").show();
    $("#btnGuardar").hide();
    $("#btnCancelar").hide();
    $("#message").html("Administre los  anuncio de una manera m&aacute;s f&aacute;cil");
    return false;
}

function eliminarAnunce(){
    $.ajax({
        url:'Publicaciones?action=EliminarAnuncio',
        dataType:'json',
        data:{
            id: $(".eliminarQuestion").data("idAnunce")
        },
        success:function(response){
            if(response.success){
                $("#noticias").empty();
                $("#txtStart").val(0);
                $("#txtCurrent").val(0);
                $(".eliminarQuestion").dialog("close");
                $("#message").removeClass("ui-state-error").addClass("ui-state-hightlight").html(response.msg);                   
                loadAnunce();
            }
            else{
                $(".eliminarQuestion").dialog("close");
                $("#message").removeClass("ui-state-hightlight").addClass("ui-state-error").html(response.msg);  
            }
        }
    });
    return false;
}
function publicarAnunce(){
    $.ajax({
        url:'Publicaciones?action=PublicarAnuncio',
        dataType:'json',
        data:{
            id: $(".eliminarQuestionPublic").data("idAnunce")
        },
        success:function(response){
            if(response.success){
                $(".eliminarQuestionPublic").dialog("close");
                $("#noticias").empty();
                $("#txtStart").val(0);
                $("#txtCurrent").val(0);
                $("#message").removeClass("ui-state-error").addClass("ui-state-hightlight").html(response.msg);
                loadAnunce();
            }
            else {
                $(".eliminarQuestionPublic").dialog("close");
                $("#message").removeClass("ui-state-hightlight").addClass("ui-state-error").html(response.msg);
            }
        }
    });
    return false;
}
function seguirAnunce(){
    $("#txtCurrent").val(parseInt($("#txtCurrent").val())+1);
    $("#txtStart").val(parseInt($("#txtCurrent").val())*parseInt($("#txtLimit").val()));
    loadAnunce();
}
function buscarAnunce(){
    $("#txtCurrent").val(0);
    $("#txtStart").val(0);
    $("#noticias").html("");
    loadAnunce();
    return false;
}
function init(){
    loadAnunce();
    
    $("#txtStart").val(0);
    $("#txtCurrent").val(0);
    $("#btnBuscar").button();
    $("#btnBuscar").on("click",buscarAnunce);
    $("#btnNuevo").button();
    $("#btnNuevo").on("click",newAnunce);
    $("#btnGuardar").button();
    $("#btnGuardar").on("click",saveAnunce);
    $("#btnCancelar").button();
    $("#btnCancelar").on("click",cancelar);
    $("#txtBuscador").keypress(function(e){
        if(e.keyCode==13){            
            buscarAnunce();
            return false;
        }
        return true;
    });
    $(".siMessage").on("click",eliminarAnunce);
    $(".noMessage").click(function(){
        $(".eliminarQuestion").dialog("close");
    });
    $(".siMessagePublic").on("click",publicarAnunce);
    $(".noMessagePublic").click(function(){
        $(".eliminarQuestionPublic").dialog("close");
    });
    $(".cerrarPaper").on("click", function(){
        $(".paper").css({
            "display": "none"
        });
    });
    $("#btnSeguir").on("click",seguirAnunce);
    $("body").roles();

}

$("document").ready(function(){
    init();
});
