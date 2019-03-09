(function($) {
    $.get = function(key) {
        key = key.replace(/[\[]/, '\\[');
        key = key.replace(/[\]]/, '\\]');
        var pattern = "[\\?&]" + key + "=([^&#]*)";
        var regex = new RegExp(pattern);
        var url = unescape(window.location.href);
        var results = regex.exec(url);
        if (results === null) {
            return null;
        } else {
            return results[1];
        }
    }
})(jQuery);
(function($) {
    $.fn.roles = function(options) {
        var subId = $.get("id");
        
        $.fn.roles.defaults = {
            activo: true,
            url: './Permiso?action=BuscarPermisoPorUsuario',
            data: {subId: subId},
            success: function() {
            },
            nuevo: true,
            editar: true,
            eliminar: true,
            imprimir: true,
            ver: true,
            otro: true,
            eti_nuevo: 'nuevo',
            eti_editar: 'editar',
            eti_imprimir: 'imprimir',
            eti_eliminar: 'eliminar',
            eti_publicar: 'publicar',
            eti_ver: 'ver',
            eti_otro: 'otro',
            menu: 'menu-lateral',
            atributo: 'dir'
        }

        var desactivarControl = function(obj) {
            switch (obj.attr("role")) {
                case "button" :
                    obj.button({
                        disabled: true
                    });
                    break;
                case "a":
                    obj.removeAttr("href");
                    obj.addClass("ui-state-disable").unbind("click");
                    break;
                case "div":
                    obj.hide();
                    break;
                case "input":
                    obj.addClass("ui-state-disable").unbind("click");
                    obj.attr("disabled", "disabled");
                    break;
                default:
                    obj.addClass("ui-state-disable").unbind("click");
                    break;
            }
        }
        
        var activarControl = function(obj) {
            switch (obj.attr("role")) {
                case "button" :
                    obj.button({
                        disabled: false
                    });
                    break;
                case "a":
                    obj.removeAttr("href");
                    obj.addClass("ui-state-enabled").bind("click");
                    break;
                case "div":
                    obj.hide();
                    break;
                case "input":
                    obj.addClass("ui-state-enabled").bind("click");
                    obj.removeAttr("disabled");
                    break;
                default:
                    obj.addClass("ui-state-enabled").bind("click");
                    break;
            }
        }
        var loadpermiso = function(propiedad, control) {
            $.ajax({
                url: propiedad.url,
                dataType: 'json',
                data : propiedad.data,
                cache: false,
                success: function(data) {

                    var datos = data;
                    var elem = {
                        1: "button",
                        2: "a",
                        3: "div",
                        4: "td",
                        5: "input",
                        6: "img"
                    };
                    $.each(elem, function(ind, elem) {
                        $.each(control.find(elem), function(index, object) {

                            switch ($(object).attr(propiedad.atributo)) {
                                case option.eti_nuevo :
                                    if (!datos.permiso.nuevo) {
                                        desactivarControl($(object))
                                    } else
                                        activarControl($(object))
                                    break;
                                case option.eti_editar :
                                    if (!datos.permiso.editar) {
                                        desactivarControl($(object))
                                    } else
                                        activarControl($(object))
                                    break;
                                case option.eti_eliminar :
                                    if (!datos.permiso.eliminar) {
                                        desactivarControl($(object))
                                    } else
                                        activarControl($(object))
                                    break;
                                case option.eti_imprimir :
                                    if (!datos.permiso.imprimir) {
                                        desactivarControl($(object))
                                    }
                                    break;
                                case option.eti_publicar :
                                    if (!datos.permiso.publicar) {
                                        desactivarControl($(object))
                                    } else
                                        activarControl($(object))
                                    break;
                                case option.eti_ver :
                                    if (!datos.permiso.ver) {
                                        desactivarControl($(object))
                                    } else
                                        activarControl($(object))
                                    break;
                                case option.eti_otro :
                                    activarControl($(object))
                                    break;
                                default :
                                    activarControl($(object))
                                    break;
                            }
                        });
                    });
                    propiedad.success();
                }
            });
        }

        var option = $.extend({}, $.fn.roles.defaults, options);
        var control = $(this);
        loadpermiso(option, control);
        
        $("#"+$.get("id")).addClass("ui-state-active");
    }
})(jQuery);


