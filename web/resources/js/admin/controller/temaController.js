function loadThema() {
    $.ajax({
        url: './Temas?action=ListarEstilos',
        success: function(response) {
            $("#contenedor").html(response);
            //loadDefecto();
        }
    });
    return false;
}

function init() {
    loadThema();
    $(".estilos").live("click", function(index, val) {
        $.ajax({
            url: './Temas',
            dataType: 'json',
            cache: true,
            type: 'post',
            data: {
                idThema: $(this).attr("id"),
                action: "actualizarEstilo"
            },
            success: function() {
                window.location.href = "./WebContent";
            }
        });
    });
}

$("document").ready(function() {
    $("body").roles();
    init();
});
