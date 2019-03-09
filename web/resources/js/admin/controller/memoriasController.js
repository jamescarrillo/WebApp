var opt=0;
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
        
var $funcionalidad = function(result, cprint){
    var nodo = result;
    $("."+cprint).empty();
    $("<a class='addDocu' role='a' dir='imprimir' target='_blank' href='#' style='text-align:center;'>Ver</a>")       
    .appendTo("."+cprint).each(function(index){
        var val= nodo[index];
        $(this).attr("href", "./GestionTransparente?action=verDocumentosGestion&id="+val['docuId']);
    }).parent().css({
        "text-align":"center"
    });
}
var $cargarGrillaPresupuestoFinanza = function(filter, anho, tipo, subfijo){
    jQuery("#arcDig"+subfijo).jgrid({
        id:'presupuestogrid'+subfijo,
        data:{
            query: filter.replace("&","$$"),
            action: "PresupuestoFinanzasArcDig",
            anho: anho,
            tipo: tipo
        },
        url:'./GestionTransparente',
        ancho:'100%',
        concat: '|',
        getData: function(datos){
            $("#array"+subfijo).val(datos);
        },
        select: 0,
        model:[
        {
            name:"titulo",
            field:'N° '+subfijo,
            width:"20%",
            sort:true,
            type:'string',
            cut : '.PDF'
        },
        {
            name:"titulo",
            hidden:true
        },
        {
            name:"resumen",
            field:'Resumen',
            width:"70%",
            type:'string',
            maxTamanio: '70'
        },
        {
            name:"resumen",
            hidden: true
        },
        {
            name:"id",
            hidden: true
        },
        {
            name:"origenArchivo",
            hidden: true
        },
        {
            name:"tidoId",
            hidden: true
        },
        {
            name:"fecha",
            hidden: true
        },
        ]
    }).paginate({
        params:{
            start:0,
            limit:10
        }
    });
}

var $cargarMEMO = function(){
    var filter = $("#buscar-MEMO").val();
    jQuery("#frmMEMO").jgrid({
        id:'effgrid',
        data:{
            query: filter.replace("&","$$"),
            action: "ListarPublicacionForWeb",
            tipo : "1"
        },
        url:'./Publicaciones',
        ancho:'99%',
        concat: '|',
        select: 0,
        success: function(result){
            $funcionalidad(result,'descarga3');
            $("#frmMEMO").roles();
        },
        getData: function(datu) {
            $("#arrayE").val(datu);
        },
        model:[
        {
            name:"anho",
            field:'año',
            width:"5%",
            type:'string'
        },
        {
            name:"titulo",
            field:"Titulo",
            width:"20%",
            type:"string",
            maxTamanio:'20'
        },
        {
            name:"descripcion",
            field:'Descripcion',
            width:"40%",
            type:'string',
            maxTamanio: '50'
        },
        {
            name:"docuId",
            field:'Documento',
            width:"10%",
            type:'string',
            clase: 'descarga3'
        },
        {
            name:"estado",
            field:"Publicado",
            width:"5%",
            type:"boolean",
            format:"checkcolumn",
            showdialog:true, 
            msndel:"Al Aceptar se Cambiara el estado de este Registro",
            event: "click",
            delurl:"./GestionTransparente?action=activarFinanza",
            dir: "publicar"
        },
        {
            name:"Id",
            hidden:true,
            key: true
        },
        {
            name:"anho",
            hidden:true
        },
        {
            name:"titulo",
            hidden:true
        },
        {
            name:"descripcion",
            hidden:true
        },
        {
            name:"estado",
            hidden:true
        },
        {
            name:"docuId",
            hidden:true
        },
        ]
    }).paginate({
        params:{
            start:0,
            limit:10
        }
    });
}   

/*************************EEEEEEEEEMEMOFFFFFFFFFFFFFFFFFF***********************/
function newMEMO(){
    opt = 0;
    $("#divMEMO").hide();
    $("#widgetMEMO").hide();
    $("#frmRegistroMEMO").show();
    $(".casilla").val("");
    $("#guardarMEMO").button({
        disabled:true
    });
    return false;
}
function cancelarMEMO(){
    $("#guardarMEMO").button({
        disabled:true
    });
    $("#divMEMO").show();
    $("#widgetMEMO").show();
    $("#frmRegistroMEMO").hide();
    return false;
}
function eliminarMEMO(){
    $.ajax({
        type: 'POST',
        url: "./GestionTransparente?action=EliminarPublicicaciones",
        data: {
            id:$("#frmMEMO").attr("rel")
        },
        success: function(){
            $cargarMEMO();
        }
    });
}
function editarMEMO(){
    $("#divMEMO").hide();
    $("#widgetMEMO").hide();
    $("#frmRegistroMEMO").show();
    $(".casilla").val("");
    opt = 1;
    $("#guardarMEMO").button({
        disabled:false
    });

    var $array= $("#arrayE").val().split("|");
    $("#txtIdMEMO").val($array[0]);
    $("#txtFechaMEMO").val("28/12/"+$array[1]);
    $("#txtTituloMEMO").val($array[2]);
    $("#txtDescripcionMEMO").val($array[3]);
    $("#txtArcDigId_2").val($array[5]);
    if ($array[4]=="true"){
        $("#txtEstadoMEMO").attr("checked","checked");
    }
    else{
        $("#txtEstadoMEMO").removeAttr("checked");
    }
    
}
function guardarMEMO(){ 
    $("#guardarMEMO").button({
        disabled:true
    });
    $.extend($.gritter.options, {
        class_name: 'gritter-light', 
        position: 'bottom-left', 
        fade_in_speed: 100,
        fade_out_speed: 100, 
        time: 3000 
    });
    $.ajax({
        type: 'POST',
        url: './GestionTransparente?action=insertMEMO',
        data: {
            fecha: $("#txtFechaMEMO").val(),
            descripcion: $("#txtDescripcionMEMO").val(), 
            opt : opt,
            estado:$("#txtEstadoMEMO").is(":checked"),
            id : $("#txtIdMEMO").val(),
            arcDigId: $("#txtArcDigId_2").val(),
            tabla : 1,
            titulo : $("#txtTituloMEMO").val()
        },
        success: function(data){
            $("#guardarMEMO").button({
                disabled:true
            });
            $("#frmRegistroMEMO").find(".body").html("");
            $("#divMEMO").show();
            $("#widgetMEMO").show();
            $("#frmRegistroMEMO").hide();
            $cargarMEMO();
            var unique_id = $.gritter.add({
                title: data.title,
                text: data.msn,
                image: data.image,
                sticky: true, 
                class_name: 'my-sticky-class'
            });
            setTimeout(function(){
                $.gritter.remove(unique_id, {
                    fade: true,
                    speed: 'slow'
                });
            }, 5000);
        }
    });
    return false;
}

function llenarForm(tipo){
    String.prototype.capitalize = function() {
        return this.charAt(0).toUpperCase() + this.slice(1);
    }
    var $array=null;
    switch (tipo) {
        case 20:
            
            $array= $("#arrayMEMO").val().split("|");
            $("#txtTituloMEMO").val($array[0]);
            $("#txtFechaMEMO").val($array[5]);
            $("#txtDescripcionMEMO").val($array[1].toLowerCase().capitalize());
            $("#txtArcDigId_2").val($array[2]);
            $("#guardarMEMO").button({
                disabled:false,
                icons:{
                    primary:'ui-icon-disk'
                }
            });
            $("#dialog-MEMO").dialog("close");
            break;
    }
}

function actualizarArcDig(tipo){
    $.ajax({
        type: 'POST',
        url: "./GestionTransparente?action=ActualizarPublicaciones",
        data: {
            tipo:tipo
        },
        success: function(){
            switch (tipo) {
                case 20 :
                    $cargarMEMO();
                    break;
            }
        }
    });
}

function init(){
    $("#tabs").tabs();
    // fix the classes
    $( ".tabs-bottom .ui-tabs-nav, .tabs-bottom .ui-tabs-nav > *" )
    .removeClass( "ui-corner-all ui-corner-top" )
    .addClass( "ui-corner-bottom" );
    // move the nav to the bottom
    $( ".tabs-bottom .ui-tabs-nav" ).appendTo( ".tabs-bottom" );
    
    /***********EEEEEEEEEMEMOFFFFFFFFFFFFFFFFFFF****************/
    $datafecha("txtFechaMEMO");
    // move the nav to the bottom
    $( ".tabs-bottom .ui-tabs-nav" ).appendTo( ".tabs-bottom" );
        
    $cargarMEMO();
    $("#btnNuevoMEMO").button({
        icons:{
            primary:'ui-icon-plus'
        }
    });
    $("#btnEliminarMEMO").button({
        icons:{
            primary:'ui-icon-circle-close'
        }
    }).on("click",eliminarMEMO);
    $("#btnEditarMEMO").button({
        icons:{
            primary:'ui-icon-pencil'
        }
    }).on("click",editarMEMO);
        
    $("#btnNuevoMEMO").on("click",newMEMO);
    $("#btnCancelarMEMO").button({
        icons:{
            primary:'ui-icon-cancel'
        }
    }).on("click",cancelarMEMO);
    $("#guardarMEMO").button({
        disabled:true,
        icons:{
            primary:'ui-icon-disk'
        }
    }).on("click",guardarMEMO);
    $("#buscar-MEMO").keypress(function (evt){
        if(evt.keyCode==13){
            $cargarMEMO();
        }
    });
    $("#dialog-MEMO").dialog({
        autoOpen: false,
        modal: true,
        show: "blind",
        hide: "explode",
        resizable: false,
        width: '60%'
    });
    $("#seleccionar_2").button({
        icons: {
            primary:'ui-icon-arrow4-diag'
        }
    }).click(function(){
        llenarForm(20)
    });
    $("#close_2").button({
        icons: {
            primary:'ui-icon-close'
        }
    }).click(function(){
        $("#dialog-MEMO").dialog("close");
    });
    $("#asignarArcDig_2").button({
        icons:{
            primary:'ui-icon-signal-diag'
        }
    }).click(function(){
        $cargarGrillaPresupuestoFinanza("","", 20,"MEMO");
        $( "#dialog-MEMO" ).dialog("open");
    });
        
    $("#btnActualizarMEMO").button({
        icons:{
            primary:'ui-icon-signal-diag'
        }
    }).click(function(){
        actualizarArcDig(20);
    });
    
        
    $("body").roles();
    
}
$("document").ready(function(){
    init();

});