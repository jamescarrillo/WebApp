var mensaje = "Gestione los Documentos desde ArcDig. Informes Técnicos Previos de Evaluación de Software";
var save = false;

function cancelar() {
    $("#frm").show();
    $("#frmRegistro").hide();
    $("#frmRegistro").find("input").val("");
    $("#frmRegistro").find("textarea").val("");
    $("#frmRegistro").find("label").html("");
    $("#id").val(0);
    $("#op").val(0);
    $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").text(mensaje);
}

function editar() {
    $("#frmRegistro").data("id", $("#grid").find(".z-listitem-seld").eq(0).find("td:last").text());
    $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").text(mensaje);
    if ($("#frmRegistro").data("id") != "") {
        $("#frm").hide();
        $("#frmRegistro").show();
        $("#frmRegistro").find("label").html("");
        $("#frmRegistro").find("textarea").val("");
        $("#cate_id").val("1300");
        $("#op").val(1);
        $("#id").val($("#frmRegistro").data("id"));
        $.ajax({
            dataType: 'json',
            type: 'post',
            url: './Convocatoria?action=GetDocumento',
            data: {
                "id": $("#frmRegistro").data("id"),
                "cate_id": "1300"
            },
            success: function(response) {
                $("#frmRegistro").find("input").eq(0).val(response.titulo);
                $("#frmRegistro").find("textarea").eq(0).val(response.resumen.toString());

            }
        });
    } else {
        $("#dialog-msg").html("Seleccione un Item!")
        $("#dialog-confirm").dialog("open");
    }
}


function actualizar(form, evt) {
    if (!save) {
        var flag = true;

        var flag = true;
        $("#frmRegistro").find("label").html("");
        if ($("#frmRegistro").find("input").eq(0).val() == "") {
            flag = false;
            $("#frmRegistro").find("label").eq(0).html("<font color='#ff0000'>No se debe dejar en Blanco</font>")
        }

        if ($("#frmRegistro").find("input").eq(1).val() == "") {
            flag = false;
            $("#frmRegistro").find("label").eq(1).html("<font color='#ff0000'>No se debe dejar en Blanco</font>")
        }

        if ($("#frmRegistro").find("input").eq(2).val() == "") {
            flag = false;
            $("#frmRegistro").find("label").eq(2).html("<font color='#ff0000'>No se debe dejar en Blanco</font>")
        }

        if (flag)
            $.ajax({
                dataType: 'json',
                type: 'post',
                url: form.attr("action"),
                data: form.serialize(),
                success: function(response) {
                    save = false;
                    evt.isPropagationStopped()
                    if (response.success) {
                        $("#frmRegistro").hide();
                        $("#frm").show();
                        $("#message").removeClass("ui-state-error").addClass("ui-state-highlight").html(response.msg);
                        $("#grid").find("button").eq(3).click();
                    } else {
                        $("#message").removeClass("ui-state-highlight").addClass("ui-state-error").html(response.msg);
                    }
                }
            });
        save = true;
    } else
        save = false;
}

function init() {
    $(function() {
        $("#dialog-arcdig").dialog({
            autoOpen: false,
            modal: true,
            show: "blind",
            hide: "explode",
            resizable: false,
            width: '1000px'
        });
        $("#dialog-confirm").dialog({
            autoOpen: false,
            modal: true,
            show: "blind",
            hide: "explode",
            resizable: false,
            height: 140,
            buttons: {
                "Aceptar": function() {
                    $(this).dialog("close");
                }
            }
        });
        $("#grid").find("button").button({
            disabled: true
        });

        $("#grid").find("button").eq(0).button({
            icons: {
                primary: 'ui-icon-note'
            }
        }).attr("lang", "otro").click(function() {
            $("#dialog-arcdig").dialog("open");

        });

        $("#btnEditar").button({
            icons: {
                primary: 'ui-icon-pencil'
            }
        }).on("click", editar);

        $("#grid").find("button").eq(2).button({
            icons: {
                primary: 'ui-icon-trash'
            }
        }).attr("lang", "eliminar")

        $("#grid").find("button").eq(3).button({
            icons: {
                primary: 'ui-icon-plus'
            }
        });

        $("#grid").find("button").eq(3).button({
            icons: {
                primary: 'ui-icon-arrowrefresh-1-e'
            }
        }).attr("lang", "otro");

        $("#btnGuardar").button({
            icons: {
                primary: 'ui-icon-disk'
            }
        });

        $("#btnCancelar").button({
            icons: {
                primary: 'ui-icon-cancel'
            }
        });

        $("#btnCancelar").on("click", cancelar);

               
        /*Boton publicar despublicar */
        var index = 0;
        $.each($("#grid").find(".z-listitem").find("img"), function(node) {
            var item = $(this);
            switch (index) {
                case 0:
                    padre = item.parent();
                    copy = item;

                    var a = $("<a target='_blank' role='a'  lang='imprimir' href='GestionTransparente?action=verResolucion&id=" + item.parent().parent().next().next().text() + "'  />");
                    item.remove();
                    a.appendTo(padre)

                    copy.appendTo(a);
                    index++;
                    break;
                case 1:
                    index = 0;
                    item.click(function() {
                        item.attr("src", "/WebApp/resources/images/16x16/loader.gif").unbind("click");
                        $.ajax({
                            dataType: 'json',
                            type: 'post',
                            url: "./Convocatoria?action=Publicar",
                            chache: true,
                            data: {
                                "id": item.parent().parent().next().text(),
                                "cate_id": '1300'
                            },
                            success: function() {
                                $("#grid").find("button").eq(3).click();
                            }
                        });
                    }).attr("lang", "publicar");
                    break;
            }

        });

        $("body").roles({
            atributo: "lang"

        });
    });
}


function selectDocumento() {
    var id = "";
    id = $("#grid-01").find(".z-listitem-seld").eq(0).find("td:last").text();

    if (id != "") {
        $("#frmRegistro").find("input").eq(0).val($("#grid-01").find(".z-listitem-seld").eq(0).find("td").eq(2).text());

        $.ajax({
            url: "./Convocatoria?action=ActualizarFinalObra",
            dataType: 'json',
            type: 'post',
            data: {
                id: id,
                op: 0,
                cate_id: 1300
            },
            success: function(response) {
                if (!response.success) {
                    //$("#dialog-msg").html("Alguno(s) Periodos No pudieron ser Agregados. La Raz&oacute;n es porque ya Existe o los intervalos son demasiados Peque&ntilde;os")
                    //$( "#dialog-confirm" ).dialog("open");
                    $("#grid").find("button").eq(3).click();
                }

                $("#dialog-arcdig").dialog("close");
                $("#grid").find("button").eq(3).click();
            }
        });

        $("#dialog").dialog("close");
    } else
        return "Seleccione un Item, para poder Agregar";

    return "";
}

function init1() {
    $(function() {
        $("#dialog-arcdig").dialog({
            buttons: {
                "Agregar": function() {
                    msn = selectDocumento();
                    if (msn != "") {
                        $("#dialog-msg").html(msn);
                        $("#dialog-confirm").dialog("open");
                    }
                },
                "Cancelar": function() {
                    $(this).dialog("close");
                }
            }
        });
    });
}


$(function() {
    $("#formRegistro").submit(function(evt) {
        actualizar($(this), evt);
        return false;
    });
});