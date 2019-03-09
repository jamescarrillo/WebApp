var $cargarCategoriaDoc = function(divCont, tipo, select) {
    $("#" + divCont).remove();
    var $select = $("<select  class='ui-widget-content ui-corner-all; ' style='width:64%' name='" + divCont + "' id='" + divCont + "'></select>");

    $.ajax({
        type: 'POST',
        url: "./GestionTransparente?action=listarCategoriaDocumento&tipo=" + tipo,
        dataType: 'json',
        success: function(data) {
            $.each(data.items, function(index, node) {
                $("<option class='opcion1' value=" + node["cateId"] + ">" + node["nombre"] + "</option>").appendTo("#" + divCont);
            });
            if (select != undefined)
                $("#" + divCont + " option").each(function() {
                    if (parseInt($(this).val()) == parseInt(select)) {
                        var text = $(this).text();
                        var $select = $(this).parent();
                        $(this).remove();
                        $select.append("<option value=" + select + " selected=selected>" + text + "</option>");
                    }
                });

        }}
    );
    return $select;
}

var dialog = function() {
    return $("<div id='dialog-public' title='Publicación'>\n\
            <form id='form1' action='./GestionTransparente' >\n\
                <fieldset class='ui-widget ui-widget-content ui-corner-top'>\n\
                    <div>\n\
                    <label>Titulo: </label>\n\
                    <input type='text' value='' style='width: 50%; float:left; padding:5px' id ='titulo' name='titulo'  />\n\
                    </div>\n\
                    <div>\n\
                    <label>Resumen: </label>\n\
                    <textarea id='resumen' name='resumen' cols='90' rows='3' style='width: 63%;height: 80px;resize: none;'></textarea>\n\
                    </div>\n\
                    <div>\n\
                    <label>Detalle de la Publicación: </label>\n\
                    <textarea id='descripcion' style='width: 63%;height: 80px;resize: none;' name='descripcion' ></textarea>\n\
                    </div>\n\
                    <div>\n\
                    <label >Categoría de Documento:</label>\n\
                    <b id='categoriaDoc'></b>\n\
                    </div>\n\
                    <br/>\n\
                    <div>\n\
                        <label>Restringido:</label> <input style='float:left; text-align:right; width:10%' type='checkbox'  name='activo' id='activo'  />\n\
                    </div>\n\
                    <input value='' id='origenArchivo' name='origenArchivo' type='hidden' />\n\
                    <input  name='action' value='insertDocumentosGestionPublico' type='hidden' />\n\
                    <input  name='tidoid' id='tidoid' value='0' type='hidden' />\n\
                    <input id='fechadocx' name='fechadocx' value='' type='hidden' />\n\
                    <input id='id' name='id' value='' type='hidden' />\n\
                    <input id='activocheck' name='activocheck' value='false' type='hidden' />\n\
                    </fieldset>\n\
            <fieldset class='ui-widget-content ui-corner-bottom' style='text-align:center; padding: 5px 0px'><button id='sincro' type='button'>Sincronizar</button><button type='submit' id='guardar'>Guardar</button><button type='button' id='close'>Cerrar</button><button id='delete' type='button'>Eliminar Publicaci&oacute;n</button></fieldset></form>\n\
            </div>").submit(function() {
        var name = $("#descripcion");
        var allFields = $([]).add(name);

        function checkLength(o, min, max) {
            if (o.val().length > max || o.val().length < min) {
                o.addClass("ui-state-error");
                return false;
            } else {
                return true;
            }
        }
        function checkRegexp(o, regexp) {
            var text = o.val();
            if (text.length <= 1)
                text = text + text;
            if (!(regexp.test(text))) {
                o.addClass("ui-state-erro");
                return false;
            } else
                return true;
        }

        var bValid = true;
        allFields.removeClass("ui-state-error");
        //bValid = bValid && checkRegexp( name, /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i );
        //.-------------------------------------------
        $.extend($.gritter.options, {
            class_name: 'gritter-light', // for light notifications (can be added directly to $.gritter.add too)
            position: 'bottom-left', // possibilities: bottom-left, bottom-right, top-left, top-right
            fade_in_speed: 100, // how fast notifications fade in (string or int)
            fade_out_speed: 100, // how fast the notices fade out
            time: 3000 // hang on the screen for...
        });
        if (bValid) {
            $.ajax({
                type: 'GET',
                url: $("#form1").attr('action'),
                data: $("#form1").serialize(),
                dataType: 'json',
                success: function(data) {
                    var unique_id = $.gritter.add({
                        title: data.title,
                        text: data.msn,
                        image: data.image,
                        sticky: true,
                        class_name: 'my-sticky-class'
                    });
                    setTimeout(function() {
                        $.gritter.remove(unique_id, {
                            fade: true,
                            speed: 'slow'
                        });
                    }, 5000);

                    $("#dialog-public").dialog("close");
                }
            });
        }
        return false;
    });
}

var $funcionalidad = function(result, cprint, cpublic, grilla, divContent, tipo) {
    var nodo = result;
    $("." + cprint).empty();
    $("<a class='addDocu' rel='imprimir' target='_blank' href='#' style='float:right'></a>").button({
        icons: {
            primary: 'ui-icon-circle-zoomin'
        }
    }).appendTo("." + cprint).each(function(index) {
        var val = nodo[index];
        $(this).attr("href", "./GestionTransparente?action=verDocumentosGestion&id=" + val['id']);
    });

    $("." + cpublic).empty();

    $("<button class='addDocu' rel='publicar' style='float:right'></button>").button({
        icons: {
            primary: 'ui-icon-circle-check'
        }
    }).appendTo("." + cpublic).each(function(index) {
        var val = nodo[index];
        $(this).click(function() {
            $.ajax({
                type: 'POST',
                url: "./GestionTransparente?action=verDocumentosGestionPublico&id=" + val['id'],
                dataType: 'json',
                success: function(data) {
                    $("#dialog-public").dialog("open").data("id", val['id']);
                    var $array = $("#array").val().split("|");
                    String.prototype.capitalize = function() {
                        return this.charAt(0).toUpperCase() + this.slice(1);
                    }
                    $("#titulo").val($array[0].replace(".PDF", ""));
                    $("#resumen").val($array[1].toLowerCase().capitalize());
                    $("#descripcion").val("");
                    $("#id").val($array[2]);
                    $("#origenArchivo").val($array[3]);
                    $("#tidoid").val($array[4]);
                    $("#fechadocx").val($array[5]);
                    $("#activo").removeAttr("checked");
                    $("#activocheck").val("");
                    if (data != null) {
                        if (divContent != undefined)
                            $cargarCategoriaDoc(divContent, tipo, data.cateId).appendTo("#categoriaDoc");
                        else
                            $("#categoriaDoc").find("select").remove();
                        $("#tidoid").val("0");
                        $("#resumen").val(data.resumen);
                        $("#descripcion").val(data.descripcion);
                        $("#fechadocx").val(data.fechaDocx);
                        $("#activocheck").val(data.activo);
                        $("#activocheck").val("true");
                        var $msn = $("<b> DOCUMENTO YA ESTA REGISTRADA EN EL PORTAL WEB!</b>");
                        $("#delete").button({
                            disabled: false,
                            icons: {
                                primary: 'ui-icon-trash'
                            }
                        });
                        $msn.appendTo($("#dialog-public").prev().find("span").eq(0).empty());
                        if (!data.activo) {
                            $("#activo").attr("checked", "checked");
                        }
                    } else {
                        $("#activocheck").val("true");
                        var $msn = $("<b> DOCUMENTO AUN NO REGISTRADO EN EL PORTAL WEB!</b>");
                        $("#delete").button({
                            disabled: true,
                            icons: {
                                primary: 'ui-icon-trash'
                            }
                        });
                        if (divContent != undefined)
                            $cargarCategoriaDoc(divContent, tipo).appendTo("#categoriaDoc");
                        else
                            $("#categoriaDoc").remove();
                    }
                    $msn.appendTo($("#dialog-public").prev().find("span").eq(0).empty());
                }});
        });
    });
}

var $cargarGrillaDocumentoGestion = function() {
    var filter = $("#buscar-gestion").val();
    jQuery("#docgestion").jgrid({
        id: 'docgesgrid',
        data: {
            query: filter.replace("&", "$$"),
            action: "DocumentoGestionAdmin"
        },
        url: './GestionTransparente',
        ancho: '100%',
        concat: '|',
        success: function(result) {
            $funcionalidad(result, 'cprint1', 'cpublic1', 'docgestion', 'CmbCateDocument', 11);
            $("#tabledocgesgrid").roles({
                atributo: "rel"
            });
        },
        getData: function(datos) {
            $("#array").val(datos);
        },
        model: [
            {
                name: "titulo",
                field: 'N° Resoluci&oacute;n',
                width: "20%",
                sort: true,
                type: 'string',
                cut: '.PDF',
                maxTamanio: '20'
            },
            {
                name: "titulo",
                hidden: true
            },
            {
                name: "resumen",
                field: 'Resumen',
                width: "70%",
                type: 'string',
                maxTamanio: '70'
            },
            {
                name: "resumen",
                hidden: true
            },
            {
                name: "id",
                field: 'Ver',
                width: "5%",
                type: 'string',
                clase: 'cprint1'
            },
            {
                name: "id",
                hidden: true
            },
            {
                name: "id",
                field: 'Publicar',
                width: "5%",
                type: 'string',
                clase: 'cpublic1'
            },
            {
                name: "origenArchivo",
                hidden: true
            },
            {
                name: "tidoId",
                hidden: true
            },
            {
                name: "cateId",
                hidden: true
            }
        ]
    }).paginate({
        params: {
            start: 0,
            limit: 10
        }
    });

}

var $cargarGrillaNormasDirectivas = function() {
    var filter = $("#buscar-normas").val();
    jQuery("#docsnormas").jgrid({
        id: 'docnormasgrid',
        data: {
            query: filter.replace("&", "$$"),
            action: "NormaDirectivaAdmin"
        },
        url: './GestionTransparente',
        ancho: '99%',
        concat: '|',
        success: function(result) {
            $funcionalidad(result, 'cprint', 'cpublic', 'docsnormas');
            $("#docsnormas").roles({
                atributo: "rel"
            });
        },
        getData: function(datos) {
            $("#array").val(datos);
            $("#docsnormas").roles({
                atributo: "rel"
            });
        },
        model: [
            {
                name: "titulo",
                field: 'N° Resoluci&oacute;n',
                width: "20%",
                sort: true,
                type: 'string',
                cut: '.PDF'
            },
            {
                name: "titulo",
                hidden: true
            },
            {
                name: "resumen",
                field: 'Resumen',
                width: "70%",
                type: 'string',
                maxTamanio: '70',
                dir: "publicar"
            },
            {
                name: "resumen",
                hidden: true
            },
            {
                name: "id",
                field: 'Ver',
                width: "5%",
                type: 'string',
                clase: 'cprint'
            },
            {
                name: "id",
                hidden: true
            },
            {
                name: "id",
                field: 'Publicar',
                width: "5%",
                type: 'string',
                clase: 'cpublic'
            },
            {
                name: "origenArchivo",
                hidden: true
            },
            {
                name: "tidoId",
                hidden: true
            },
        ]
    }).paginate({
        params: {
            start: 0,
            limit: 10
        }
    });
}
var $cargarAnhoResolucion = function() {
    $.ajax({
        url: "./GestionTransparente?action=ListarAnhosResolucionGerencial",
        success: function(data) {
            $("#anhosResolucionGerencial").html(data);
            $("#anhosResolucionGerencial").change(function() {
                $cargarGrillaResolucionesGeren($(this).val());
            });
            $cargarGrillaResolucionesGeren($("#anhosResolucionGerencial").val());
        }
    });

}

var $cargarGrillaResolucionesGeren = function(anho) {
    var filter = $("#buscar-resol").val();
    var anio = $("#anhosResolucionGerencial").val();
    jQuery("#docsresol").jgrid({
        id: 'docresolgrid',
        data: {
            query: filter.replace("&", "$$"),
            action: "ResolucionGerencialAdmin",
            anho: anio
        },
        url: './GestionTransparente',
        ancho: '99%',
        concat: '|',
        success: function(result) {
            $funcionalidad(result, 'cprint2', 'cpublic2', 'docsresol');
            $("#docsresol").roles({
                atributo: "rel"
            });
        },
        getData: function(datos) {
            $("#array").val(datos);
        },
        model: [
            {
                name: "titulo",
                field: 'N° Resoluci&oacute;n',
                width: "20%",
                sort: true,
                type: 'string',
                cut: '.PDF'
            },
            {
                name: "titulo",
                hidden: true
            },
            {
                name: "resumen",
                field: 'Resumen',
                width: "70%",
                type: 'string',
                maxTamanio: '70'
            },
            {
                name: "resumen",
                hidden: true
            },
            {
                name: "id",
                field: 'Ver',
                width: "5%",
                type: 'string',
                clase: 'cprint2'
            },
            {
                name: "id",
                hidden: true
            },
            {
                name: "id",
                field: 'Publicar',
                width: "5%",
                type: 'string',
                clase: 'cpublic2'
            },
            {
                name: "origenArchivo",
                hidden: true
            },
            {
                name: "tidoId",
                hidden: true
            },
            {
                name: "fecha",
                hidden: true
            },
        ]
    }).paginate({
        params: {
            start: 0,
            limit: 10
        }
    });

}

botonSincronizar = function() {
    $.ajax({
        type: 'POST',
        url: "./GestionTransparente?action=SincronizarDoc&id=" + $("#dialog-public").data("id"),
        dataType: 'json',
        success: function(data) {
            $("#titulo").val(data.titulo);
            $("#resumen").val(data.resumen);
            $("#fechadocx").val(data.fecha);

        }}
    );
}

botonEliminar = function() {

    $(".msg-html").html("¿ESTAS SEGURO DE ELIMINAR LA PUBLICACION?");
    $(".eliminarQuestionMod").data("id", $("#dialog-public").data("id"));
    $(".eliminarQuestionMod").dialog({
        title: 'Mensaje de Confirmaci&oacute;n',
        modal: true,
        resizable: false,
        width: 600,
        height: 150
    });

}

botonSi = function() {
    $.ajax({
        type: 'POST',
        url: "./GestionTransparente?action=eliminarDocumento&id=" + $("#dialog-public").data("id"),
        dataType: 'json',
        success: function(data) {
            //$dialog.dialog("close");
        }}
    );
}

function init() {

    $("#tabs").tabs();
    // fix the classes
    $(".tabs-bottom .ui-tabs-nav, .tabs-bottom .ui-tabs-nav > *")
            .removeClass("ui-corner-all ui-corner-top")
            .addClass("ui-corner-bottom");

    // move the nav to the bottom
    $(".tabs-bottom .ui-tabs-nav").appendTo(".tabs-bottom");
    var $dialog = dialog();

    $cargarGrillaDocumentoGestion();
    $cargarGrillaNormasDirectivas();
    $cargarAnhoResolucion();
    $dialog.dialog({
        autoOpen: false,
        modal: true,
        show: "blind",
        hide: "explode",
        resizable: false,
        width: '680px',
        close: function() {
        }
    });

    $('#activo').live('change', function() {
        if ($(this).is(':checked')) {
            $("#activocheck").val("false");
        } else
            $("#activocheck").val("true");

    });
    /*************************/
    $("#btnDocGestion").button({
        icons: {
            primary: 'ui-icon ui-icon-arrowrefresh-1-e'
        }
    }).click(function() {
        $cargarGrillaDocumentoGestion();
    });
    /*************************/
    $("#btnNormasDirectivas").button({
        icons: {
            primary: 'ui-icon ui-icon-arrowrefresh-1-e'
        }
    }).click(function() {
        $cargarGrillaNormasDirectivas();
    });
    /*************************/
    $("#btnResoluciones").button({
        icons: {
            primary: 'ui-icon ui-icon-arrowrefresh-1-e'
        }
    }).click(function() {
        $cargarAnhoResolucion();
    });
    /*************************/
    $("#buscar-gestion").keypress(function(evt) {
        if (evt.keyCode == 13) {
            $cargarGrillaDocumentoGestion();
        }
    });
    /*************************/
    $("#buscar-normas").keypress(function(evt) {
        if (evt.keyCode == 13) {
            $cargarGrillaNormasDirectivas();
        }
    });
    /*************************/
    $("#buscar-resol").keypress(function(evt) {
        if (evt.keyCode == 13) {
            $cargarGrillaResolucionesGeren();
        }
    });

    /****************************/
    $("#sincro").button({
        icons: {
            primary: 'ui-icon-signal-diag'
        }
    }).click(function() {
        botonSincronizar();
    });


    $("#guardar").button({
        icons: {
            primary: 'ui-icon-disk'
        }
    });

    $("#delete").button({
        icons: {
            primary: 'ui-icon-trash'
        }
    }).click(function() {
        botonEliminar();
    });

    $("#close").button({
        icons: {
            primary: 'ui-icon-close'
        }
    }).click(function() {
        $dialog.dialog("close");
    });
    //botonSincronizar();
    $("body").roles();

    $(".noMessage").on("click", function() {
        $(".eliminarQuestionMod").dialog("close");
    });
    $(".siMessage").on("click", function() {
        botonSi();
        $(".eliminarQuestionMod").dialog("close");
        $dialog.dialog("close");
        $.extend($.gritter.options, {
            class_name: 'gritter-light', // for light notifications (can be added directly to $.gritter.add too)
            position: 'bottom-left', // possibilities: bottom-left, bottom-right, top-left, top-right
            fade_in_speed: 100, // how fast notifications fade in (string or int)
            fade_out_speed: 100, // how fast the notices fade out
            time: 3000 // hang on the screen for...
        });

        var unique_id = $.gritter.add({
            title: "Se acaba de eliminar una publicación",
            text: "Se ah despublicado un documento del portal web",
            image: "./resources/images/dialog-error.png",
            sticky: true,
            class_name: 'my-sticky-class'
        });

        setTimeout(function() {
            $.gritter.remove(unique_id, {
                fade: true,
                speed: 'slow'
            });
        }, 5000);
    });
}


$("document").ready(function() {
    init();
});
