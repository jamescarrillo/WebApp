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
        success:function(){},
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

var $cargarOTPU = function(){
    var filter = $("#buscar-OTPU").val();
    jQuery("#frmOTPU").jgrid({
        id:'effgrid',
        data:{
            query: filter.replace("&","$$"),
            action: "ListarPublicacionForWeb",
            tipo : "3"
        },
        url:'./Publicaciones',
        ancho:'99%',
        concat: '|',
        select: 0,
        success: function(result){
            $funcionalidad(result,'descarga3');
            $("#frmOTPU").roles();
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

/*************************EEEEEEEEEOTPUFFFFFFFFFFFFFFFFFF***********************/
function newOTPU(){
    opt = 0;
    $("#divOTPU").hide();
    $("#widgetOTPU").hide();
    $("#frmRegistroOTPU").show();
    $(".casilla").val("");
    $("#guardarOTPU").button({
        disabled:true
    });
    return false;
}
function cancelarOTPU(){
    $("#guardarOTPU").button({
        disabled:true
    });
    $("#divOTPU").show();
    $("#widgetOTPU").show();
    $("#frmRegistroOTPU").hide();
    return false;
}
function eliminarOTPU(){
    $.ajax({
        type: 'POST',
        url: "./GestionTransparente?action=EliminarPublicicaciones",
        data: {
            id:$("#frmOTPU").attr("rel")
        },
        success: function(){
            $cargarOTPU();
        }
    });
}
function editarOTPU(){
    $("#divOTPU").hide();
    $("#widgetOTPU").hide();
    $("#frmRegistroOTPU").show();
    $(".casilla").val("");
    opt = 1;
    $("#guardarOTPU").button({
        disabled:false
    });

    var $array= $("#arrayE").val().split("|");
    $("#txtIdOTPU").val($array[0]);
    $("#txtFechaOTPU").val("28/12/"+$array[1]);
    $("#txtTituloOTPU").val($array[2]);
    $("#txtDescripcionOTPU").val($array[3]);
    $("#txtArcDigId_2").val($array[5]);
    if ($array[4]=="true"){
        $("#txtEstadoOTPU").attr("checked","checked");
    }
    else{
        $("#txtEstadoOTPU").removeAttr("checked");
    }
    
}
function guardarOTPU(){ 
    $("#guardarOTPU").button({
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
            fecha: $("#txtFechaOTPU").val(),
            descripcion: $("#txtDescripcionOTPU").val(), 
            opt : opt,
            estado:$("#txtEstadoOTPU").is(":checked"),
            id : $("#txtIdOTPU").val(),
            arcDigId: $("#txtArcDigId_2").val(),
            tabla : 3,
            titulo : $("#txtTituloOTPU").val()
        },
        success: function(data){
            $("#guardarOTPU").button({
                disabled:true
            });
            $("#frmRegistroOTPU").find(".body").html("");
            $("#divOTPU").show();
            $("#widgetOTPU").show();
            $("#frmRegistroOTPU").hide();
            $cargarOTPU();
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
        case 21:
            
            $array= $("#arrayOTPU").val().split("|");
            $("#txtTituloOTPU").val($array[0]);
            $("#txtFechaOTPU").val($array[5]);
            $("#txtDescripcionOTPU").val($array[1].toLowerCase().capitalize());
            $("#txtArcDigId_2").val($array[2]);
            $("#guardarOTPU").button({
                disabled:false,
                icons:{
                    primary:'ui-icon-disk'
                }
            });
            $("#dialog-OTPU").dialog("close");
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
                case 21 :
                    $cargarOTPU();
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
    
    /***********EEEEEEEEEOTPUFFFFFFFFFFFFFFFFFFF****************/
    $datafecha("txtFechaOTPU");
    // move the nav to the bottom
    $( ".tabs-bottom .ui-tabs-nav" ).appendTo( ".tabs-bottom" );
        
    $cargarOTPU();
    $("#btnNuevoOTPU").button({
        icons:{
            primary:'ui-icon-plus'
        }
    });
    $("#btnEliminarOTPU").button({
        icons:{
            primary:'ui-icon-circle-close'
        }
    }).on("click",eliminarOTPU);
    $("#btnEditarOTPU").button({
        icons:{
            primary:'ui-icon-pencil'
        }
    }).on("click",editarOTPU);
        
    $("#btnNuevoOTPU").on("click",newOTPU);
    $("#btnCancelarOTPU").button({
        icons:{
            primary:'ui-icon-cancel'
        }
    }).on("click",cancelarOTPU);
    $("#guardarOTPU").button({
        disabled:true,
        icons:{
            primary:'ui-icon-disk'
        }
    }).on("click",guardarOTPU);
    $("#buscar-OTPU").keypress(function (evt){
        if(evt.keyCode==13){
            $cargarOTPU();
        }
    });
    $("#dialog-OTPU").dialog({
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
        llenarForm(21)
    });
    $("#close_2").button({
        icons: {
            primary:'ui-icon-close'
        }
    }).click(function(){
        $("#dialog-OTPU").dialog("close");
    });
    $("#asignarArcDig_2").button({
        icons:{
            primary:'ui-icon-signal-diag'
        }
    }).click(function(){
        $cargarGrillaPresupuestoFinanza("","", 21,"OTPU");
        $( "#dialog-OTPU" ).dialog("open");
    });
        
    $("#btnActualizarOTPU").button({
        icons:{
            primary:'ui-icon-signal-diag'
        }
    }).click(function(){
        actualizarArcDig(21);
    });
    
        
    $("body").roles();
    
}
$("document").ready(function(){
    init();

});