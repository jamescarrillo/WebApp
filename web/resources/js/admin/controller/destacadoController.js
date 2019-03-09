
var opcion = 0;
var $datafecha = function (data) {
    $.datepicker.regional['es'] = {
        closeText: 'Cerrar',
        prevText: '&#x3c;Ant',
        nextText: 'Sig&#x3e;',
        currentText: 'Hoy',
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
            'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
            'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi&eacute;rcoles', 'Jueves', 'Viernes', 'S&aacute;bado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mi&eacute;', 'Juv', 'Vie', 'S&aacute;b'],
        dayNamesMin: ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'S&aacute;'],
        weekHeader: 'Sm',
        dateFormat: 'dd/mm/yy',
        firstDay: 1,
        isRTL: false,
        showMonthAfterYear: false,
        yearSuffix: ''
    }
    $.datepicker.setDefaults($.datepicker.regional['es']);

    $("#" + data).datepicker({
        //altField: "#actualDate",
        showOn: 'both',
        buttonImageOnly: true,
        buttonText: "Seleccionar Fecha",
        buttonImage: './resources/images/16x16/calendario.png'
    });
}
function validarCampos() {
    if ($("#tituloDestacado").val() == "") {
        $("#message").removeClass("ui-state-hightlight").addClass("ui-state-error").html("Debe ingresar el titulo del destacado");
        return false;
    } else if ($("#urlDestacado").val() == "") {
        $("#message").removeClass("ui-state-hightlight").addClass("ui-state-error").html("Debe ingresar la url del destacado");
        return false;
    } else if ($("#fotoDestacado").val() == "") {
        $("#message").removeClass("ui-state-hightlight").addClass("ui-state-error").html("Debe ingresar la foto del destacado");
        return false;
    }
    return true;
}

function fechaUnFormat(fecha) {
    var formato
    var $fecha = fecha.split("-");
    formato = $fecha[2].trim(" ") + "/" + $fecha[1].trim(" ") + "/" + $fecha[0].trim(" ");
    return  formato;
}
function saveNotice() {
    if (validarCampos()) {
        //enviamos los datos del registro
        $("#noticias").empty();
        $("#txtStart").val(0);
        $("#txtCurrent").val(0);
        if (opcion == 0) {
            $.ajax({
                url: "./Destacado?action=InsertarDestacado",
                dataType: "json",
                data: {
                    titulo: $("#tituloDestacado").val(),
                    contenido: $("#contenidoDestacado").val(),
                    url: $("#urlDestacado").val(),
                    fecha: $("#fechaPublicacion").val(),
                    foto: $("#fotoDestacado").val(),
                    estado: 'false'
                },
                success: function (response) {
                    if (response.success) {
                        $("#message").removeClass("ui-state-error").addClass("ui-state-hightlight").html(response.msg);
                        //volvemos a mostrar las noticias
                        $("#frmRegistroNoticia").css("display", "none");
                        $("#noticias").css("display", "block");
                        $("#txtBuscador").css("display", "block");
                        $("#busqueda-more").css("display", "block");
                        $(".casilla").val("");
                        loadNotice();
                        $("#btnNuevo").show();
                        $("#btnBuscar").show();
                        $("#btnGuardar").hide();
                        $("#btnCancelar").hide();
                    }
                    else {
                        $("#message").removeClass("ui-state-hightlight").addClass("ui-state-error").html(response.msg);
                    }
                }
            });
        } else if (opcion == 1) {
            $.ajax({
                url: './Destacado?action=ActualizarDestacado',
                data: {
                    id: parseInt($("#frmRegistroNoticia").data("idNotice")),
                    titulo: $("#tituloDestacado").val(),
                    contenido: $("#contenidoDestacado").val(),
                    url: $("#urlDestacado").val(),
                    fecha: $("#fechaPublicacion").val(),
                    foto: $("#fotoDestacado").val()

                },
                success: function (response) {
                    $("#message").removeClass("ui-state-error").addClass("ui-state-hightlight").html(response.msg);
                    //volvemos a mostrar las noticias
                    $("#frmRegistroNoticia").css("display", "none");
                    $("#noticias").css("display", "block");
                    $("#txtBuscador").css("display", "block");
                    $("#busqueda-more").css("display", "block");
                    $(".casilla").attr("value", "");
                    loadNotice();
                    $("#frmRegistroNoticia").removeData("idNotice");
                    $("#btnNuevo").show();
                    $("#btnBuscar").show();
                    $("#btnBuscar").show();
                    $("#btnGuardar").hide();
                    $("#btnCancelar").hide();
                }
            });
        }
    }
    return false;
}

function newNotice() {
    $(".casilla").val("");
    $("#frmRegistroNoticia").css("display", "block");
    $("#noticias").css("display", "none");
    $("#txtBuscador").css("display", "none");
    $("#busqueda-more").css("display", "none");
    $("#fechaPublicacion").datepicker("setDate", new Date());
    $("#tituloDestacado").val("");
    $("#contenidoDestacado").val("");
    $("#btnNuevo").hide();
    $("#btnBuscar").hide();
    $("#btnGuardar").show();
    $("#btnCancelar").show();

    opcion = 0;
    return false;
}

function loadNotice() {
    $.ajax({
        url: './Destacado?action=ListarDestacadoForAdmin',
        method: "get",
        data: {
            start: $("#txtStart").val(),
            filtro: $("#txtBuscador").val(),
            limit: $("#txtLimit").val(),
            current: $("#txtCurrent").val()
        },
        success: function (response) {
            $("#noticias").append(response);

            $datafecha("fechaPublicacion");

            
            
            $(".notice").hover(function () {
                $(this).children(".notice-tools").children(".notice-tbutton").css("display", "block");
            }, function () {
                $(this).children(".notice-tools").children(".notice-tbutton").css("display", "none");
            });

            $(".editar").on("click", editarNotice);
            $(".eliminar").on("click", mostrarDialogEliminarNotice);
            $(".publicar").on("click", mostrarDialogPublicarNotice);
            $(".ver").on("click", mostrarDialogVerNotice);

            if ((parseInt($("#txtCurrent").val())) < Math.ceil(parseInt($(".notice").attr("data")) / parseInt($("#txtLimit").val()))) {
                $("#btnSeguir").css("display", "block");
            }
            else {
                $("#btnSeguir").css("display", "none");
            }
            if ((parseInt($("#txtCurrent").val()) + 1) == Math.ceil(parseInt($(".notice").attr("data")) / parseInt($("#txtLimit").val()))) {
                $("#btnSeguir").css("display", "none");
            }
            $("#noticias").roles();

        }
    });
    return false;
}

function mostrarDialogVerNotice() {
    $(".paper").css({
        opacity: 0.9
    });
    $('.paper').corner("10px");
    $(".paper").css({
        "display": "block"
    });
    var posicion = $(this).position();

    $(".paper").css({
        "margin-top": parseInt(posicion.top - 200) + "px"
    });

    var ik = parseInt($(this).parent().parent().attr("data"));
    $.ajax({
        url: './Destacado?action=GetNotice',
        dataType: 'json',
        data: {
            id: ik
        },
        success: function (response) {
            if (response.destacado != null) {
                //$("#fechaPublicacion").val(fechaUnFormat(response.destacado.fecha));
                $(".titulo").html(response.destacado.titulo);
                $(".contenido").html(" <p >Url:  " + response.destacado.url + "</p><p>" + response.destacado.contenido + "</p>");
                $(".imagen").html("<img src='" + response.destacado.foto + "' /> ");
            }
        }
    });
}
function mostrarDialogEliminarNotice() {
    var ik = parseInt($(this).parent().parent().attr("data"));
    $("#msg-icon").addClass("ui-icon ui-icon-info");
    $(".msg-html").html("¿Estas seguro de eliminar el destacado?");
    $(".eliminarQuestion").dialog({
        title: 'Mensaje de Advertencia',
        modal: true,
        height: 145,
        resizable: false
    });
    $(".eliminarQuestion").data("idNotice", ik);
}

function mostrarDialogPublicarNotice() {
    var ik = parseInt($(this).parent().parent().attr("data"));
    $("#msg-icon-public").addClass("ui-icon ui-icon-info");
    $(".msg-html-public").html("¿Estas seguro de publicar este destacado?");
    $(".eliminarQuestionPublic").dialog({
        title: 'Mensaje de Advertencia',
        modal: true,
        height: 145,
        resizable: false
    });
    $(".eliminarQuestionPublic").data("idNotice", ik);
}

function editarNotice() {
    var ik = parseInt($(this).parent().parent().attr("data"));
    //obtener la noticia
    $.ajax({
        url: './Destacado?action=GetNotice',
        dataType: 'json',
        data: {
            id: ik
        },
        success: function (response) {
            if (response.destacado != null) {
                $("#frmRegistroNoticia").css("display", "block");
                $("#frmRegistroNoticia").data("idNotice", ik);
                $("#noticias").css("display", "none");
                $("#txtBuscador").css("display", "none");
                $("#busqueda-more").css("display", "none");
                $("#btnNuevo").hide();
                $("#btnBuscar").hide();
                $("#btnGuardar").show();
                $("#btnCancelar").show();
                opcion = 1;
                $("#fechaPublicacion").val(fechaUnFormat(response.destacado.fecha));                
                $("#tituloDestacado").val(response.destacado.titulo);
                $("#contenidoDestacado").val(response.destacado.contenido);
                $("#urlDestacado").val(response.destacado.url);
                $("#fotoDestacado").val(response.destacado.foto);
            }
        }

    });
    return false;
}
function cancelar() {
    opcion = 0;
    $("#frmRegistroNoticia").css("display", "none");
    $("#noticias").css("display", "block");
    $("#txtBuscador").css("display", "block");
    $("#busqueda-more").css("display", "block");
    $("#noticias").empty();
    $("#txtStart").val(0);
    $("#txtCurrent").val(0);
    loadNotice();
    $("#btnNuevo").show();
    $("#btnBuscar").show();
    $("#btnGuardar").hide();
    $("#btnCancelar").hide();
    $("#message").html("Administe sus noticias de una manera m&aacute;s f&aacute;cil, con integraci&oacute;n a Flickr");
    return false;
}

function eliminarNotice() {
    $.ajax({
        url: 'Destacado?action=EliminarDestacado',
        dataType: 'json',
        data: {
            id: $(".eliminarQuestion").data("idNotice")
        },
        success: function (response) {
            if (response.success) {
                $(".eliminarQuestion").dialog("close");
                $("#noticias").empty();
                $("#txtStart").val(0);
                $("#txtCurrent").val(0);
                $("#message").removeClass("ui-state-error").addClass("ui-state-hightlight").html(response.msg);
                loadNotice();
            }
            else {
                $(".eliminarQuestion").dialog("close");
                $("#message").removeClass("ui-state-hightlight").addClass("ui-state-error").html(response.msg);
            }
        }
    });
    return false;
}

function publicarNotice() {
    $.ajax({
        url: 'Destacado?action=PublicarDestacado',
        dataType: 'json',
        data: {
            id: $(".eliminarQuestionPublic").data("idNotice")
        },
        success: function (response) {
            if (response.success) {
                $(".eliminarQuestionPublic").dialog("close");
                $("#noticias").empty();
                $("#txtStart").val(0);
                $("#txtCurrent").val(0);

                $("#message").removeClass("ui-state-error").addClass("ui-state-hightlight").html(response.msg);
                loadNotice();
            }
            else {
                $(".eliminarQuestionPublic").dialog("close");
                $("#message").removeClass("ui-state-hightlight").addClass("ui-state-error").html(response.msg);
            }
        }
    });
    return false;
}

function seguirNotice() {
    $("#txtCurrent").val(parseInt($("#txtCurrent").val()) + 1);
    $("#txtStart").val(parseInt($("#txtCurrent").val()) * parseInt($("#txtLimit").val()));
    loadNotice();
}
function buscarNotice() {
    $("#txtCurrent").val(0);
    $("#txtStart").val(0);
    $("#noticias").html("");
    loadNotice();
    return false;
}
function init() {
    loadNotice();

    $("#txtStart").val(0);
    $("#txtCurrent").val(0);
    $("#btnBuscar").button();
    $("#btnBuscar").on("click", buscarNotice);
    $("#btnNuevo").button();
    $("#btnNuevo").on("click", newNotice);
    $("#btnGuardar").button();
    $("#btnGuardar").on("click", saveNotice);
    $("#btnCancelar").button();
    $("#btnCancelar").on("click", cancelar);
    $("#txtBuscador").keypress(function (e) {
        if (e.keyCode == 13) {
            buscarNotice();
            return false;
        }
        return true;
    });
    $(".siMessage").on("click", eliminarNotice);
    $(".noMessage").click(function () {
        $(".eliminarQuestion").dialog("close");
    });

    $(".siMessagePublic").on("click", publicarNotice);
    $(".noMessagePublic").click(function () {
        $(".eliminarQuestionPublic").dialog("close");
    });

    $(".cerrarPaper").on("click", function () {
        $(".paper").css({
            "display": "none"
        });
    });
    $("#btnSeguir").on("click", seguirNotice);
    $("body").roles();
}

$("document").ready(function () {
    init();
});
