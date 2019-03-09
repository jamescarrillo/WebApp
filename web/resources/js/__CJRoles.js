(function ($) {
    $.fn.roles=function(options){
        $.fn.roles.defaults={
            activo: true,
            url:'./Permiso?action=BuscarPermisoPorUsuario',
            registeID: './Permiso?action=RegistroIdSubmodulo',
            data:{},
            nuevo: true,
            editar: true,
            eliminar: true,
            imprimir: true,
            ver: true,
            eti_nuevo: 'nuevo',
            eti_editar: 'editar',
            eti_imprimir: 'imprimir',
            eti_eliminar: 'eliminar',
            eti_publicar: 'publicar',
            eti_ver: 'ver',
            menu: 'menu-lateral',
            atributo: 'dir'
        }
        
        var desactivarControl=function(obj){
            switch (obj.attr("role")){
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
                    obj.attr("disabled","disabled");
                    break;
                default:
                    obj.addClass("ui-state-disable").unbind("click");
                    break;
            }
        }
        var loadpermiso=function(propiedad, control){
            $.ajax({
                url: propiedad.url,
                dataType: 'json',
                success: function(data) {
                    var datos = data;
                    var elem = {
                        1: "button",
                        2: "a",
                        3: "div",
                        4: "td",
                        5: "input"
                    };
                    $.each(elem, function(ind, elem){
                        $.each(control.find(elem), function(index, object){
                            switch ($(object).attr(propiedad.atributo)){
                                case option.eti_nuevo :
                                    if (!datos.permiso.nuevo){
                                        desactivarControl($(object))
                                    }
                                    break;
                                case option.eti_editar :
                                    if (!datos.permiso.editar){
                                        desactivarControl($(object))
                                    }
                                    break;
                                case option.eti_eliminar :
                                    if (!datos.permiso.eliminar){
                                        desactivarControl($(object))
                                    }
                                    break;
                                case option.eti_imprimir :
                                    if (!datos.permiso.imprimir){
                                        desactivarControl($(object))
                                    }
                                    break;
                                case option.eti_publicar :
                                    if (!datos.permiso.publicar){
                                        desactivarControl($(object))
                                    }
                                    break;
                                case option.eti_ver :
                                    if (!datos.permiso.ver){
                                        desactivarControl($(object))
                                    }
                                    break;
                            }
                        });
                    });
                }
            });
        }
        
        var loadroles=function(propiedad){
            $("."+propiedad.menu).each(function(){
                $(this).click(function(){
                    if ($(this).attr("id")!=undefined){
                        var item = $(this);
                        $.ajax({
                            url:propiedad.registeID,
                            data : {
                                id: $(this).attr("id")
                            },
                            success: function(data){
                                item.addClass("ui-state-disabled");
                                item.unbind("click");
                                location.href= item.find("a").attr("rel");
                            }
                        });
                    }
                });
            });
        }
        var option = $.extend({}, $.fn.roles.defaults,options);
        loadroles(option);
        var control = $(this);
        loadpermiso(option,control);
    }
})(jQuery);


