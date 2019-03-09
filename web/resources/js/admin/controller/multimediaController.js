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
    if ($("#tituloMultimedia").val() == "") {
        $("#message").removeClass("ui-state-hightlight").addClass("ui-state-error").html("Debe ingresar el titulo de la noticia multimedia");
        return false;
    }
    else if($("#fuenteMultimedia").val()==""){
        $("#message").removeClass("ui-state-hightlight").addClass("ui-state-error").html("Debe ingresar la URL de la noticia multimedia");
        return false;
    }
    return true;
}
function saveNotice(){        
    if (validarCampos()){
        //enviamos los datos del registro

        if(opcion==0){
            $.ajax({
                url:"./Publicaciones?action=InsertarMultimedia",
                dataType:"json",
                data:{
                    titulo:$("#tituloMultimedia").val(),
                    fuente:$("#fuenteMultimedia").val(),
                    fecha:$("#fechaPublicacion").val(),
                    estado: true
                
                },
                success:function(response){
                    if (response.success){
                        $("#message").removeClass("ui-state-error").addClass("ui-state-hightlight").html(response.msg);
                        //volvemos a mostrar las noticias
                        $("#noticias").empty();
                        $("#txtStart").val(0);
                        $("#txtCurrent").val(0);
                        $("#frmRegistroMultimedia").css("display","none");
                        $("#noticias").css("display","block");
                        $("#txtBuscador").css("display","block");
                        $("#busqueda-more").css("display","block");
                        loadNotice();
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
                url:'./Publicaciones?action=ActualizarMultimedia',
                data:{
                    id: parseInt($("#frmRegistroMultimedia").data("idNotice")),
                    titulo:$("#tituloMultimedia").val(),
                    fuente:$("#fuenteMultimedia").val(),
                    fecha:$("#fechaPublicacion").val()
                },
                success:function(response){
                    $("#message").removeClass("ui-state-error").addClass("ui-state-hightlight").html(response.msg);
                    //volvemos a mostrar las noticias
                    $("#frmRegistroMultimedia").css("display","none");
                    $("#noticias").css("display","block");
                    $("#txtBuscador").css("display","block");
                    loadNotice();
                    $("#frmRegistroMultimedia").removeData("idNotice");
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
function newNotice(){      
    $(".casilla").val("");
    $("#frmRegistroMultimedia").css("display","block");
    $("#noticias").css("display","none");
    $("#txtBuscador").css("display","none");
    $("#busqueda-more").css("display","none");
    $("#fechaPublicacion").datepicker("setDate",new Date());
    
    $("#btnNuevo").hide();
    $("#btnBuscar").hide();
    $("#btnGuardar").show();
    $("#btnCancelar").show();
    opcion=0;
    return false;
}
function loadNotice(){
    var predefinirMultimedia = function( bind){
        var ik=parseInt(bind.parent().parent().attr("data"));
        $.ajax({
            url:'./Publicaciones?action=PredefinirMultimedia',
            method:"get",
            data:{
                value:bind.attr("rel"),
                id: ik
            },
            success:function(){
                if (bind.attr("rel")=="true"){
                    bind.attr("rel","false");
                    bind.removeClass("default-d").addClass("default"); 
                }
                else  {
                    bind.attr("rel","true");
                    bind.removeClass("default").addClass("default-d");
                }
            }
        });
    }
    $.ajax({
        url:'./Publicaciones?action=ListarMultimediaForAdmin',
        method:"get",
        data:{
            start:$("#txtStart").val(),
            filtro:$("#txtBuscador").val(),
            limit:$("#txtLimit").val(),
            current:$("#txtCurrent").val()
        },
        success:function(response){
            $("#noticias").append(response);
            
            $datafecha("fechaPublicacion");
            $("#contenidoMultimedia").htmlarea({
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
            $(".editar").on("click", editarNotice);    
            $(".eliminar").on("click", mostrarDialogEliminarNotice);
            $(".publicar").on("click", mostrarDialogPublicarNotice);
            $(".default-d").click(function(){
                predefinirMultimedia($(this))
            });
            $(".default").click(function(){
                predefinirMultimedia($(this))
            });
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

function mostrarDialogEliminarNotice(){
    var ik=parseInt($(this).parent().parent().attr("data"));
    $("#msg-icon").addClass("ui-icon ui-icon-info");
    $(".msg-html").html("¿Estas seguro de eliminar la Multimedia?");        
    $(".eliminarQuestion").dialog({
        title: 'Mensaje de Advertencia',
        modal: true,
        height: 145,
        resizable: false 
    });
    $(".eliminarQuestion").data("idNotice",ik);
}
function mostrarDialogPublicarNotice(){
    var ik=parseInt($(this).parent().parent().attr("data"));
    $("#msg-icon-public").addClass("ui-icon ui-icon-info");
    $(".msg-html-public").html("¿Estas seguro de publicar esta noticia multimedia?");        
    $(".eliminarQuestionPublic").dialog({
        title: 'Mensaje de Advertencia',
        modal: true,
        height: 145,
        resizable: false 
    });
    $(".eliminarQuestionPublic").data("idNotice",ik);
}
function editarNotice(){
    var ik=parseInt($(this).parent().parent().attr("data"));
    //obtener la noticia
    $.ajax({
        url:'./Publicaciones?action=GetMultimedia',
        dataType:'json',
        data:{
            id:ik
        },            
        success:function(response){
            if(response.multimedia!=null){
                $("#frmRegistroMultimedia").css("display","block");
                $("#frmRegistroMultimedia").data("idNotice",ik);
                $("#noticias").css("display","none");
                $("#txtBuscador").css("display","none");
                $("#busqueda-more").css("display","none");
                var divMa= $("<div></div>");
                divMa.css({
                    "border":"0.1em #ccc solid",                                       
                    "display":"block",
                    "width":"99%",
                    "height":"255px",
                    "position":"relative",
                    "text-align": "center"
                });
                var iFrame= $("<iframe width='auto' height= '255px' frameborder='0' allowfullscreen='' src='"+response.multimedia.fuente+"&showinfo=0&wmode=transparent' />");
                                        
                var titulo= $("<h1> "+response.multimedia.titulo+ "</h1>");
                    
                titulo.css({
                    "z-index":"9002",
                    "position":"absolute",
                    "width":"310px",
                    "height":"10%",
                    "top":"0"
                });
                iFrame.appendTo(divMa);
                $("#ivideo").empty();
                divMa.appendTo($("#ivideo"));
                $("#btnNuevo").hide();
                $("#btnBuscar").hide();
                $("#btnGuardar").show();
                $("#btnCancelar").show(); 
                opcion=1;
                //ahora llenamos el form
                      
                $("#fechaPublicacion").val(fechaUnFormat(response.multimedia.fecha));
                $("#tituloMultimedia").val(response.multimedia.titulo);
                $("#fuenteMultimedia").val(response.multimedia.fuente);
            }
        }
    });
    return false;
}
function cancelar(){        
    opcion=0;
    $("#frmRegistroMultimedia").css("display","none");
    $("#noticias").css("display","block");
    $("#txtBuscador").css("display","block");
    $("#busqueda-more").css("display","block");
    loadNotice();
    $("#btnNuevo").show();
    $("#btnBuscar").show();
    $("#btnGuardar").hide();
    $("#btnCancelar").hide();
    $("#message").html("Administre las noticias  multimedia de una manera m&aacute;s f&aacute;cil, con integraci&oacute;n a Youtube");
    return false;
}
function eliminarNotice(){
    $("#noticias").empty();
    $("#txtStart").val(0);
    $("#txtCurrent").val(0);
    $.ajax({
        url:'Publicaciones?action=EliminarMultimedia',
        dataType:'json',
        data:{
            id: $(".eliminarQuestion").data("idNotice")
        },
        success:function(response){
            if(response.success){
                $(".eliminarQuestion").dialog("close");
                $("#message").removeClass("ui-state-error").addClass("ui-state-hightlight").html(response.msg);                   
                loadNotice();
            }
            else{
                $(".eliminarQuestion").dialog("close");
                $("#message").removeClass("ui-state-hightlight").addClass("ui-state-error").html(response.msg);  
            }
        }
    });
    return false;
}

function publicarNotice(){
    $.ajax({
        url:'Publicaciones?action=PublicarMultimedia',
        dataType:'json',
        data:{
            id: $(".eliminarQuestionPublic").data("idNotice")
        },
        success:function(response){
            if(response.success){
                $(".eliminarQuestionPublic").dialog("close");
                $("#noticias").empty();
                $("#txtStart").val(0);
                $("#txtCurrent").val(0);
                $("#message").removeClass("ui-state-error").addClass("ui-state-hightlight").html(response.msg);
                loadNotice();
            }
            else{
                $(".eliminarQuestionPublic").dialog("close");
                $("#message").removeClass("ui-state-hightlight").addClass("ui-state-error").html(response.msg);  
            }
        }
    });
    return false;
}

function seguirNotice(){
    $("#txtCurrent").val(parseInt($("#txtCurrent").val())+1);
    $("#txtStart").val(parseInt($("#txtCurrent").val())*parseInt($("#txtLimit").val()));
    loadNotice();
}

function buscarNotice(){
    $("#txtCurrent").val(0);
    $("#txtStart").val(0);
    $("#noticias").html("");
    loadNotice();
    return false;
}

function init(){
    loadNotice();
    
    $("#txtStart").val(0);
    $("#txtCurrent").val(0);
    $("#btnBuscar").button();
    $("#btnBuscar").on("click",buscarNotice);
    $("#btnNuevo").button();
    $("#btnNuevo").on("click",newNotice);
    $("#btnGuardar").button();
    $("#btnGuardar").on("click",saveNotice);
    $("#btnCancelar").button();
    $("#btnCancelar").on("click",cancelar);
    $("#txtBuscador").keypress(function(e){
        if(e.keyCode==13){     
            buscarNotice();
            return false;
        }
        return true;
    });           
    $(".siMessage").on("click",eliminarNotice);
    $(".noMessage").click(function(){
        $(".eliminarQuestion").dialog("close");
    });
        
    $(".siMessagePublic").on("click",publicarNotice);
    $(".noMessagePublic").click(function(){
        $(".eliminarQuestionPublic").dialog("close");
    });
        
    $("#btnSeguir").on("click",seguirNotice);
    $("body").roles();
    
}

$("document").ready(function(){
    init();

});