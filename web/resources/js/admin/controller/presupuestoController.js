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
var $cargarPIA = function(){
    var filter = $("#buscar-PIA").val();
    jQuery("#frmPIA").jgrid({
        id:'piagrid',
        data:{
            query: filter.replace("&","$$"),
            action: "listarPresupuesto",
            tipo : "1"
        },
        url:'./GestionTransparente',
        ancho:'99%',
        concat: '|',
        success: function(result){
            $funcionalidad(result,'descarga1');
            $("#frmPIA").roles();
        },
        select: 0,
        getData: function(datos) {
            $("#arrayO").val(datos);
        },
        model:[
        {
            name:"anho",
            field:'año',
            width:"5%",
            type:'string'
        },
        {
            name:"fechaAprobacion",
            field:'Fecha',
            width:"10%"
        },
        {
            name:"descripcion",
            field:'Descripcion',
            width:"40%",
            type:'string',
            maxTamanio: '50'
        },
        {
            name:"resolucionAprobacion",
            field:'Aprobado Por',
            width:"25%",
            type:'string'
        },
        {
            name:"ubicacion",
            field:'Documento',
            width:"10%",
            type:'string',
            clase: 'descarga1'
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
            delurl:"./GestionTransparente?action=activarPresupuesto",
            dir: "publicar"
        },
        {
            name:"id",
            hidden:true,
            key: true
        },
        {
            name:"fechaAprobacion",
            hidden:true
        },
        {
            name:"descripcion",
            hidden:true
        },
        {
            name:"resolucionAprobacion",
            hidden:true
        },
        {
            name:"ubicacion",
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

var $cargarPIM = function(){
    var filter = $("#buscar-PIM").val();
    jQuery("#frmPIM").jgrid({
        id:'pimgrid',
        data:{
            query: filter.replace("&","$$"),
            action: "listarPresupuesto",
            tipo : "2"
        },
        url:'./GestionTransparente',
        ancho:'99%',
        concat: '|',
        select: 0,
        success: function(result){
            $funcionalidad(result,'descarga2');
            $("#frmPIM").roles();
        },
        getData: function(date) {
            
            $("#arrayM").val(date);
        },
        model:[
        {
            name:"anho",
            field:'año',
            width:"5%",
            type:'string'
        },
        {
            name:"fechaAprobacion",
            field:'Fecha',
            width:"10%"
        },
        {
            name:"descripcion",
            field:'Descripcion',
            width:"40%",
            type:'string',
            maxTamanio: '50'
        },
        {
            name:"resolucionAprobacion",
            field:'Aprobado Por',
            width:"25%",
            type:'string'
        },
        {
            name:"ubicacion",
            field:'Documento',
            width:"10%",
            type:'string',
            clase: 'descarga2'
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
            delurl:"./GestionTransparente?action=activarPresupuesto",
            dir: "publicar"
        },
        {
            name:"id",
            hidden:true,
            key: true
        },
        {
            name:"fechaAprobacion",
            hidden:true
        },
        {
            name:"descripcion",
            hidden:true
        },
        {
            name:"resolucionAprobacion",
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

var $cargarEFF = function(){
    var filter = $("#buscar-EFF").val();
    jQuery("#frmEFF").jgrid({
        id:'effgrid',
        data:{
            query: filter.replace("&","$$"),
            action: "listarFinanza",
            tipo : "1"
        },
        url:'./GestionTransparente',
        ancho:'99%',
        concat: '|',
        select: 0,
        success: function(result){
            $funcionalidad(result,'descarga3');
            $("#frmEFF").roles();
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
            name:"mes",
            field:'Mes',
            width:"10%"
        },
        {
            name:"descripcion",
            field:'Descripcion',
            width:"40%",
            type:'string',
            maxTamanio: '50'
        },
        {
            name:"ubicacion",
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
            name:"id",
            hidden:true,
            key: true
        },
        {
            name:"anho",
            hidden:true
        },
        {
            name:"mes",
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

var $cargarBG = function(){
    var filter = $("#buscar-BG").val();
    jQuery("#frmBG").jgrid({
        id:'bggrid',
        data:{
            query: filter.replace("&","$$"),
            action: "listarFinanza",
            tipo : "2"
        },
        url:'./GestionTransparente',
        ancho:'99%',
        concat: '|',
        select: 0,
        success: function(result){
            $funcionalidad(result,'descarga4');
            $("#frmBG").roles();
        },
        getData: function(dati) {
            $("#arrayB").val(dati);
        },
        model:[
        {
            name:"anho",
            field:'año',
            width:"5%",
            type:'string'
        },
        {
            name:"mes",
            field:'Mes',
            width:"10%"
        },
        {
            name:"descripcion",
            field:'Descripcion',
            width:"40%",
            type:'string',
            maxTamanio: '50'
        },
        {
            name:"ubicacion",
            field:'Documento',
            width:"10%",
            type:'string',
            clase: 'descarga4'
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
            name:"id",
            hidden:true,
            key: true
        },
        {
            name:"anho",
            hidden:true
        },
        {
            name:"mes",
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

var $cargarEI = function(){
    var filter = $("#buscar-EI").val();
    jQuery("#frmEI").jgrid({
        id:'eigrid',
        data:{
            query: filter.replace("&","$$"),
            action: "listarFinanza",
            tipo : "3"
        },
        url:'./GestionTransparente',
        ancho:'99%',
        concat: '|',
        select: 0,
        success: function(result){
            $funcionalidad(result,'descarga5');
            $("#frmEI").roles();
        },
        getData: function(datw) {
            $("#arrayI").val(datw);
        },
        model:[
        {
            name:"anho",
            field:'año',
            width:"5%",
            type:'string'
        },
        {
            name:"mes",
            field:'Mes',
            width:"10%"
        },
        {
            name:"descripcion",
            field:'Descripcion',
            width:"40%",
            type:'string',
            maxTamanio: '50'
        },
        {
            name:"ubicacion",
            field:'Documento',
            width:"10%",
            type:'string',
            clase: 'descarga5'
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
            name:"id",
            hidden:true,
            key: true
        },
        {
            name:"anho",
            hidden:true
        },
        {
            name:"mes",
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

var $cargarRGE = function(){
    var filter = $("#buscar-RGE").val();
    jQuery("#frmRGE").jgrid({
        id:'rgegrid',
        data:{
            query: filter.replace("&","$$"),
            action: "listarFinanza",
            tipo : "4"
        },
        url:'./GestionTransparente',
        ancho:'99%',
        concat: '|',
        select: 0,
        success: function(result){
            $funcionalidad(result,'descarga6');
            $("#frmRGE").roles();
        },
        getData: function(datw) {
            $("#arrayR").val(datw);
        },
        model:[
        {
            name:"anho",
            field:'año',
            width:"5%",
            type:'string'
        },
        {
            name:"mes",
            field:'Mes',
            width:"10%"
        },
        {
            name:"descripcion",
            field:'Descripcion',
            width:"40%",
            type:'string',
            maxTamanio: '50'
        },
        {
            name:"ubicacion",
            field:'Documento',
            width:"10%",
            type:'string',
            clase: 'descarga6'
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
            name:"id",
            hidden:true,
            key: true
        },
        {
            name:"anho",
            hidden:true
        },
        {
            name:"mes",
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
function newPIA(){
    opt = 0;
    $("#divPIA").hide();
    $("#widget").hide();
    $("#frmRegistroPIA").show();
    $(".casilla").val("");
    $("#guardarPIA").button({
        disabled:true
    });
    $(".tablafile").html("");
    return false;
}
function cancelarPIA(){
    $("#guardarPIA").button({
        disabled:true
    });
    $("#divPIA").show();
    $("#widget").show();
    $("#frmRegistroPIA").hide();
    return false;
}
function eliminarPIA(){
    $.ajax({
        type: 'POST',
        url: "./GestionTransparente?action=eliminarPresupuesto",
        data: {
            id:$("#frmPIA").attr("rel")
        },
        success: function(){
            $cargarPIA();
        }
    });
}
function editarPIA(){
    $("#divPIA").hide();
    $("#widget").hide();
    $("#frmRegistroPIA").show();
    $(".casilla").val("");
    opt = 1;
    $("#guardarPIA").button({
        disabled:false
    });
    
    var $array= $("#arrayO").val().split("|");
    $("#txtIdPIA").val($array[0]);
    $("#txtFechaPIA").val($array[1].split("-")[2]+"/"+$array[1].split("-")[1]+"/"+$array[1].split("-")[0]);
    $("#txtDescripcionPIA").val($array[2]);
    $("#txtAprobadoPor").val($array[3]);
    $("#txtArcDigId").val($array[6]);
    if ($array[5]=="true"){
        $("#txtEstadoPIA").attr("checked","checked");
    }
    else{
        $("#txtEstadoPIA").removeAttr("checked");
    }
}
function guardarPIA(){ 
    $("#guardarPIA").button({
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
        url: './GestionTransparente?action=insertPIA',
        data: {
            fecha: $("#txtFechaPIA").val(),
            descripcion: $("#txtDescripcionPIA").val(), 
            aprobado: $("#txtAprobadoPor").val(), 
            archivo: $("#archivo_1").val(),
            opt : opt,
            estado: $("#txtEstadoPIA").is(":checked"),
            id : $("#txtIdPIA").val(),
            arcDigId: $("#txtArcDigId").val(),
            tabla : 1
        },
        success: function(data){
            $("#guardarPIA").button({
                disabled:true
            });
            $("#frmRegistroPIA").find(".body").html("");
            $("#divPIA").show();
            $("#widget").show();
            $("#frmRegistroPIA").hide();
            $cargarPIA();
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

/*************************PIMMMMMMMMMMMMMMMMMMMMM***********************/
    
function newPIM(){
    opt = 0;
    $("#divPIM").hide();
    $("#widgetPIM").hide();
    $("#frmRegistroPIM").show();
    $(".casilla").val("");
    $("#guardarPIM").button({
        disabled:true
    });
    $(".tablafile").html("");
    return false;
}
function cancelarPIM(){
    $("#guardarPIM").button({
        disabled:true
    });
    $("#divPIM").show();
    $("#widgetPIM").show();
    $("#frmRegistroPIM").hide();
    return false;
}
function eliminarPIM(){
    $.ajax({
        type: 'POST',
        url: "./GestionTransparente?action=eliminarPresupuesto",
        data: {
            id:$("#frmPIM").attr("rel")
        },
        success: function(){
            $cargarPIM();
        }
    });
}
function editarPIM(){
    $("#divPIM").hide();
    $("#widgetPIM").hide();
    $("#frmRegistroPIM").show();
    $(".casilla").val("");
    opt = 1;
    $("#guardarPIM").button({
        disabled:false
    });

    var $array= $("#arrayM").val().split("|");
    $("#txtIdPIM").val($array[0]);
    $("#txtFechaPIM").val($array[1].split("-")[2]+"/"+$array[1].split("-")[1]+"/"+$array[1].split("-")[0]);
    $("#txtDescripcionPIM").val($array[2]);
    $("#txtAprobadoPorPIM").val($array[3]);
    $("#txtArcDigId_1").val($array[5]);
    if ($array[4]=="true"){
        $("#txtEstadoPIM").attr("checked","checked");
    }
    else{
        $("#txtEstadoPIM").removeAttr("checked");
    }
    
}
function guardarPIM(){ 
    $("#guardarPIM").button({
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
        url: './GestionTransparente?action=insertPIA',
        data: {
            fecha: $("#txtFechaPIM").val(),
            descripcion: $("#txtDescripcionPIM").val(), 
            aprobado: $("#txtAprobadoPorPIM").val(), 
            opt : opt,
            estado:$("#txtEstadoPIM").is(":checked"),
            id : $("#txtIdPIM").val(),
            arcDigId: $("#txtArcDigId_1").val(),
            tabla : 2
        },
        success: function(data){
            $("#guardarPIM").button({
                disabled:true
            });
            $("#frmRegistroPIM").find(".body").html("");
            $("#divPIM").show();
            $("#widgetPIM").show();
            $("#frmRegistroPIM").hide();
            $cargarPIM();
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

/*************************EEEEEEEEEEFFFFFFFFFFFFFFFFFFFF***********************/
function newEFF(){
    opt = 0;
    $("#divEFF").hide();
    $("#widgetEFF").hide();
    $("#frmRegistroEFF").show();
    $(".casilla").val("");
    $("#guardarEFF").button({
        disabled:true
    });
    return false;
}
function cancelarEFF(){
    $("#guardarEFF").button({
        disabled:true
    });
    $("#divEFF").show();
    $("#widgetEFF").show();
    $("#frmRegistroEFF").hide();
    return false;
}
function eliminarEFF(){
    $.ajax({
        type: 'POST',
        url: "./GestionTransparente?action=eliminarFinanza",
        data: {
            id:$("#frmEFF").attr("rel")
        },
        success: function(){
            $cargarEFF();
        }
    });
}
function editarEFF(){
    $("#divEFF").hide();
    $("#widgetEFF").hide();
    $("#frmRegistroEFF").show();
    $(".casilla").val("");
    opt = 1;
    $("#guardarEFF").button({
        disabled:false
    });

    var $array= $("#arrayE").val().split("|");
    $("#txtIdEFF").val($array[0]);
    $("#txtFechaEFF").val("28/"+$array[2]+"/"+$array[1]);
    $("#txtDescripcionEFF").val($array[3]);
    $("#txtArcDigId_2").val($array[5]);
    if ($array[4]=="true"){
        $("#txtEstadoEFF").attr("checked","checked");
    }
    else{
        $("#txtEstadoEFF").removeAttr("checked");
    }
    
}
function guardarEFF(){ 
    $("#guardarEFF").button({
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
        url: './GestionTransparente?action=insertEFF',
        data: {
            fecha: $("#txtFechaEFF").val(),
            descripcion: $("#txtDescripcionEFF").val(), 
            opt : opt,
            estado:$("#txtEstadoEFF").is(":checked"),
            id : $("#txtIdEFF").val(),
            arcDigId: $("#txtArcDigId_2").val(),
            tabla : 1
        },
        success: function(data){
            $("#guardarEFF").button({
                disabled:true
            });
            $("#frmRegistroEFF").find(".body").html("");
            $("#divEFF").show();
            $("#widgetEFF").show();
            $("#frmRegistroEFF").hide();
            $cargarEFF();
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

/*************************BBBBBBBBBGGGGGGG***********************/
function newBG(){
    opt = 0;
    $("#divBG").hide();
    $("#widgetBG").hide();
    $("#frmRegistroBG").show();
    $(".casilla").val("");
    $("#guardarBG").button({
        disabled:true
    });
    return false;
}
function cancelarBG(){
    $("#guardarBG").button({
        disabled:true
    });
    $("#divBG").show();
    $("#widgetBG").show();
    $("#frmRegistroBG").hide();
    return false;
}
function eliminarBG(){
    $.ajax({
        type: 'POST',
        url: "./GestionTransparente?action=eliminarFinanza",
        data: {
            id:$("#frmBG").attr("rel")
        },
        success: function(){
            $cargarBG();
        }
    });
}
function editarBG(){
    $("#divBG").hide();
    $("#widgetBG").hide();
    $("#frmRegistroBG").show();
    $(".casilla").val("");
    opt = 1;
    $("#guardarBG").button({
        disabled:false
    });

    var $array= $("#arrayB").val().split("|");
    $("#txtIdBG").val($array[0]);
    $("#txtFechaBG").val("28/"+$array[2]+"/"+$array[1]);
    $("#txtDescripcionBG").val($array[3]);
    $("#txtArcDigId_3").val($array[5]);
    if ($array[4]=="true"){
        $("#txtEstadoBG").attr("checked","checked");
    }
    else{
        $("#txtEstadoBG").removeAttr("checked");
    }
    
}
function guardarBG(){ 
    $("#guardarBG").button({
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
        url: './GestionTransparente?action=insertEFF',
        data: {
            fecha: $("#txtFechaBG").val(),
            descripcion: $("#txtDescripcionBG").val(), 
            opt : opt,
            estado:$("#txtEstadoBG").is(":checked"),
            id : $("#txtIdBG").val(),
            arcDigId: $("#txtArcDigId_3").val(),
            tabla : 2
        },
        success: function(data){
            $("#guardarBG").button({
                disabled:true
            });
            $("#frmRegistroBG").find(".body").html("");
            $("#divBG").show();
            $("#widgetBG").show();
            $("#frmRegistroBG").hide();
            $cargarBG();
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


/*************************EEEEEEEEEIIIIIIIIIII***********************/
function newEI(){
    opt = 0;
    $("#divEI").hide();
    $("#widgetEI").hide();
    $("#frmRegistroEI").show();
    $(".casilla").val("");
    $("#guardarEI").button({
        disabled:true
    });
    return false;
}
function cancelarEI(){
    $("#guardarEI").button({
        disabled:true
    });
    $("#divEI").show();
    $("#widgetEI").show();
    $("#frmRegistroEI").hide();
    return false;
}
function eliminarEI(){
    $.ajax({
        type: 'POST',
        url: "./GestionTransparente?action=eliminarFinanza",
        data: {
            id:$("#frmEI").attr("rel")
        },
        success: function(){
            $cargarEI();
        }
    });
}
function editarEI(){
    $("#divEI").hide();
    $("#widgetEI").hide();
    $("#frmRegistroEI").show();
    $(".casilla").val("");
    opt = 1;
    $("#guardarEI").button({
        disabled:false
    });

    var $array= $("#arrayI").val().split("|");
    $("#txtIdEI").val($array[0]);
    $("#txtFechaEI").val("28/"+$array[2]+"/"+$array[1]);
    $("#txtDescripcionEI").val($array[3]);
    $("#txtArcDigId_4").val($array[5]);
    if ($array[4]=="true"){
        $("#txtEstadoEI").attr("checked","checked");
    }
    else{
        $("#txtEstadoEI").removeAttr("checked");
    }
    
}
function guardarEI(){ 
    $("#guardarEI").button({
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
        url: './GestionTransparente?action=insertEFF',
        data: {
            fecha: $("#txtFechaEI").val(),
            descripcion: $("#txtDescripcionEI").val(), 
            opt : opt,
            estado:$("#txtEstadoEI").is(":checked"),
            id : $("#txtIdEI").val(),
            arcDigId: $("#txtArcDigId_4").val(),
            tabla : 3
        },
        success: function(data){
            $("#guardarEI").button({
                disabled:true
            });
            $("#frmRegistroEI").find(".body").html("");
            $("#divEI").show();
            $("#widgetEI").show();
            $("#frmRegistroEI").hide();
            $cargarEI();
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



/*************************RRRRRRRRRRRRRGGGGGGGGGGGGGGEEEEEEEEEEEE***********************/
function newRGE(){
    opt = 0;
    $("#divRGE").hide();
    $("#widgetRGE").hide();
    $("#frmRegistroRGE").show();
    $(".casilla").val("");
    $("#guardarRGE").button({
        disabled:true
    });
    return false;
}
function cancelarRGE(){
    $("#guardarRGE").button({
        disabled:true
    });
    $("#divRGE").show();
    $("#widgetRGE").show();
    $("#frmRegistroRGE").hide();
    return false;
}
function eliminarRGE(){
    $.ajax({
        type: 'POST',
        url: "./GestionTransparente?action=eliminarFinanza",
        data: {
            id:$("#frmRGE").attr("rel")
        },
        success: function(){
            $cargarRGE();
        }
    });
}
function editarRGE(){
    $("#divRGE").hide();
    $("#widgetRGE").hide();
    $("#frmRegistroRGE").show();
    $(".casilla").val("");
    opt = 1;
    $("#guardarRGE").button({
        disabled:false
    });

    var $array= $("#arrayR").val().split("|");
    $("#txtIdRGE").val($array[0]);
    $("#txtFechaRGE").val("28/"+$array[2]+"/"+$array[1]);
    $("#txtDescripcionRGE").val($array[3]);
    $("#txtArcDigId_5").val($array[5]);
    if ($array[4]=="true"){
        $("#txtEstadoRGE").attr("checked","checked");
    }
    else{
        $("#txtEstadoRGE").removeAttr("checked");
    }
}
function guardarRGE(){ 
    $("#guardarRGE").button({
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
        url: './GestionTransparente?action=insertEFF',
        data: {
            fecha: $("#txtFechaRGE").val(),
            descripcion: $("#txtDescripcionRGE").val(), 
            opt : opt,
            estado:$("#txtEstadoRGE").is(":checked"),
            id : $("#txtIdRGE").val(),
            arcDigId: $("#txtArcDigId_5").val(),
            tabla : 4
        },
        success: function(data){
            $("#guardarRGE").button({
                disabled:true
            });
            $("#frmRegistroRGE").find(".body").html("");
            $("#divRGE").show();
            $("#widgetRGE").show();
            $("#frmRegistroRGE").hide();
            $cargarRGE();
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
        case 13:
            $array= $("#arrayPIA").val().split("|");
            $("#txtFechaPIA").val($array[5]);
            $("#txtDescripcionPIA").val($array[1].toLowerCase().capitalize());
            $("#txtArcDigId").val($array[2]);
            $("#guardarPIA").button({
                disabled:false,
                icons:{
                    primary:'ui-icon-disk'
                }
            });
            $("#dialog-PIA").dialog("close");
            break;
        case 14:
            $array= $("#arrayPIM").val().split("|");
            $("#txtFechaPIM").val($array[5]);
            $("#txtDescripcionPIM").val($array[1].toLowerCase().capitalize());
            $("#txtArcDigId_1").val($array[2]);
            $("#guardarPIM").button({
                disabled:false,
                icons:{
                    primary:'ui-icon-disk'
                }
            });
            $("#dialog-PIM").dialog("close");
            break;
        case 19:
            $array= $("#arrayEFF").val().split("|");
            $("#txtFechaEFF").val($array[5]);
            $("#txtDescripcionEFF").val($array[1].toLowerCase().capitalize());
            $("#txtArcDigId_2").val($array[2]);
            $("#guardarEFF").button({
                disabled:false,
                icons:{
                    primary:'ui-icon-disk'
                }
            });
            $("#dialog-EFF").dialog("close");
            break;
        case 15:
            $array= $("#arrayBG").val().split("|");
            $("#txtFechaBG").val($array[5]);
            $("#txtDescripcionBG").val($array[1].toLowerCase().capitalize());
            $("#txtArcDigId_3").val($array[2]);
            $("#guardarBG").button({
                disabled:false,
                icons:{
                    primary:'ui-icon-disk'
                }
            });
            $("#dialog-BG").dialog("close");
            break;      
        case 16:
            $array= $("#arrayEI").val().split("|");
            $("#txtFechaEI").val($array[5]);
            $("#txtDescripcionEI").val($array[1].toLowerCase().capitalize());
            $("#txtArcDigId_4").val($array[2]);
            $("#guardarEI").button({
                disabled:false,
                icons:{
                    primary:'ui-icon-disk'
                }
            });
            $("#dialog-EI").dialog("close");
            break;       
        case 17:
            $array= $("#arrayRGE").val().split("|");
            $("#txtFechaRGE").val($array[5]);
            $("#txtDescripcionRGE").val($array[1].toLowerCase().capitalize());
            $("#txtArcDigId_5").val($array[2]);
            $("#guardarRGE").button({
                disabled:false,
                icons:{
                    primary:'ui-icon-disk'
                }
            });
            $("#dialog-RGE").dialog("close");
            break; 
    }
}

function actualizarArcDig(tipo){
    $.ajax({
        type: 'POST',
        url: "./GestionTransparente?action=ActualizarFinanzas",
        data: {
            tipo:tipo
        },
        success: function(){
            switch (tipo) {
                case 19 :
                    $cargarEFF();
                    break;
                case 15 :
                    $cargarBG();
                    break;
                case 16 :
                    $cargarEI();
                    break;
                case 17 :
                    $cargarRGE();
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
    $datafecha("txtFechaPIA");
    // move the nav to the bottom
    $( ".tabs-bottom .ui-tabs-nav" ).appendTo( ".tabs-bottom" );
        
    $cargarPIA();
    $("#btnNuevoPIA").button({
        icons:{
            primary:'ui-icon-plus'
        }
    });
    $("#btnEliminarPIA").button({
        icons:{
            primary:'ui-icon-circle-close'
        }
    }).on("click",eliminarPIA);
    $("#btnEditarPIA").button({
        icons:{
            primary:'ui-icon-pencil'
        }
    }).on("click",editarPIA);
        
    $("#btnNuevoPIA").on("click",newPIA);
    $("#btnCancelarPIA").button({
        icons:{
            primary:'ui-icon-cancel'
        }
    }).on("click",cancelarPIA);
    $("#guardarPIA").button({
        disabled:true,
        icons:{
            primary:'ui-icon-disk'
        }
    }).on("click",guardarPIA);
    $("#buscar-PIA").keypress(function (evt){
        if(evt.keyCode==13){
            $cargarPIA();
        }
    });
    $("#dialog-PIA").dialog({
        autoOpen: false,
        modal: true,
        show: "blind",
        hide: "explode",
        resizable: false,
        width: '60%'
    });
    $("#seleccionar").button({
        icons: {
            primary:'ui-icon-arrow4-diag'
        }
    }).click(function(){
        llenarForm(13)
    });
    $("#close").button({
        icons: {
            primary:'ui-icon-close'
        }
    }).click(function(){
        $("#dialog-PIA").dialog("close");
    });        
    $("#asignarArcDig").button({
        icons:{
            primary:'ui-icon-signal-diag'
        }
    }).click(function(){
        $cargarGrillaPresupuestoFinanza("","", 13, "PIA");
        $( "#dialog-PIA" ).dialog("open");
    });
        
        
    /***********PIMMMMMMMMMMMMMMMMMMMMMMMMMM****************/
    $datafecha("txtFechaPIM");
    // move the nav to the bottom
    $( ".tabs-bottom .ui-tabs-nav" ).appendTo( ".tabs-bottom" );
        
    $cargarPIM();
    $("#btnNuevoPIM").button({
        icons:{
            primary:'ui-icon-plus'
        }
    });
    $("#btnEliminarPIM").button({
        icons:{
            primary:'ui-icon-circle-close'
        }
    }).on("click",eliminarPIM);
    $("#btnEditarPIM").button({
        icons:{
            primary:'ui-icon-pencil'
        }
    }).on("click",editarPIM);
        
    $("#btnNuevoPIM").on("click",newPIM);
    $("#btnCancelarPIM").button({
        icons:{
            primary:'ui-icon-cancel'
        }
    }).on("click",cancelarPIM);
    $("#guardarPIM").button({
        disabled:true,
        icons:{
            primary:'ui-icon-disk'
        }
    }).on("click",guardarPIM);
    $("#buscar-PIM").keypress(function (evt){
        if(evt.keyCode==13){
            $cargarPIM();
        }
    });
    $("#dialog-PIM").dialog({
        autoOpen: false,
        modal: true,
        show: "blind",
        hide: "explode",
        resizable: false,
        width: '60%'
    });
    $("#seleccionar_1").button({
        icons: {
            primary:'ui-icon-arrow4-diag'
        }
    }).click(function(){
        llenarForm(14)
    });
    $("#close_1").button({
        icons: {
            primary:'ui-icon-close'
        }
    }).click(function(){
        $("#dialog-PIM").dialog("close");
    });
    $("#asignarArcDig_1").button({
        icons:{
            primary:'ui-icon-signal-diag'
        }
    }).click(function(){
        $cargarGrillaPresupuestoFinanza("","", 14,"PIM");
        $( "#dialog-PIM" ).dialog("open");
    });
    /***********EEEEEEEEEEFFFFFFFFFFFFFFFFFFFFF****************/
    $datafecha("txtFechaEFF");
    // move the nav to the bottom
    $( ".tabs-bottom .ui-tabs-nav" ).appendTo( ".tabs-bottom" );
        
    $cargarEFF();
    $("#btnNuevoEFF").button({
        icons:{
            primary:'ui-icon-plus'
        }
    });
    $("#btnEliminarEFF").button({
        icons:{
            primary:'ui-icon-circle-close'
        }
    }).on("click",eliminarEFF);
    $("#btnEditarEFF").button({
        icons:{
            primary:'ui-icon-pencil'
        }
    }).on("click",editarEFF);
        
    $("#btnNuevoEFF").on("click",newEFF);
    $("#btnCancelarEFF").button({
        icons:{
            primary:'ui-icon-cancel'
        }
    }).on("click",cancelarEFF);
    $("#guardarEFF").button({
        disabled:true,
        icons:{
            primary:'ui-icon-disk'
        }
    }).on("click",guardarEFF);
    $("#buscar-EFF").keypress(function (evt){
        if(evt.keyCode==13){
            $cargarEFF();
        }
    });
    $("#dialog-EFF").dialog({
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
        llenarForm(19)
    });
    $("#close_2").button({
        icons: {
            primary:'ui-icon-close'
        }
    }).click(function(){
        $("#dialog-EFF").dialog("close");
    });
    $("#asignarArcDig_2").button({
        icons:{
            primary:'ui-icon-signal-diag'
        }
    }).click(function(){
        $cargarGrillaPresupuestoFinanza("","", 19,"EFF");
        $( "#dialog-EFF" ).dialog("open");
    });
        
    $("#btnActualizarEFF").button({
        icons:{
            primary:'ui-icon-signal-diag'
        }
    }).click(function(){
        actualizarArcDig(19);
    });
    
    /***********BBBBBBBBBBBBBBBBBBBBBBBBBGGGGGGGGGGGGGGGGGGGGG****************/
    $datafecha("txtFechaBG");
    // move the nav to the bottom
    $( ".tabs-bottom .ui-tabs-nav" ).appendTo( ".tabs-bottom" );
        
    $cargarBG();
    $("#btnNuevoBG").button({
        icons:{
            primary:'ui-icon-plus'
        }
    });
    $("#btnEliminarBG").button({
        icons:{
            primary:'ui-icon-circle-close'
        }
    }).on("click",eliminarBG);
    $("#btnEditarBG").button({
        icons:{
            primary:'ui-icon-pencil'
        }
    }).on("click",editarBG);
        
    $("#btnNuevoBG").on("click",newBG);
    $("#btnCancelarBG").button({
        icons:{
            primary:'ui-icon-cancel'
        }
    }).on("click",cancelarBG);
    $("#guardarBG").button({
        disabled:true,
        icons:{
            primary:'ui-icon-disk'
        }
    }).on("click",guardarBG);
    $("#buscar-BG").keypress(function (evt){
        if(evt.keyCode==13){
            $cargarBG();
        }
    });
    $("#dialog-BG").dialog({
        autoOpen: false,
        modal: true,
        show: "blind",
        hide: "explode",
        resizable: false,
        width: '60%'
    });
    $("#seleccionar_3").button({
        icons: {
            primary:'ui-icon-arrow4-diag'
        }
    }).click(function(){
        llenarForm(15)
    });
    $("#close_3").button({
        icons: {
            primary:'ui-icon-close'
        }
    }).click(function(){
        $("#dialog-BG").dialog("close");
    });
    $("#asignarArcDig_3").button({
        icons:{
            primary:'ui-icon-signal-diag'
        }
    }).click(function(){
        $cargarGrillaPresupuestoFinanza("","", 15,"BG");
        $( "#dialog-BG" ).dialog("open");
    });
        
    $("#btnActualizarBG").button({
        icons:{
            primary:'ui-icon-signal-diag'
        }
    }).click(function(){
        actualizarArcDig(15);
    });
        
    /***********EEEEEEEIIIIIIIIIII****************/
    $datafecha("txtFechaEI");
    // move the nav to the bottom
    $( ".tabs-bottom .ui-tabs-nav" ).appendTo( ".tabs-bottom" );
        
    $cargarEI();
    $("#btnNuevoEI").button({
        icons:{
            primary:'ui-icon-plus'
        }
    });
    $("#btnEliminarEI").button({
        icons:{
            primary:'ui-icon-circle-close'
        }
    }).on("click",eliminarEI);
    $("#btnEditarEI").button({
        icons:{
            primary:'ui-icon-pencil'
        }
    }).on("click",editarEI);
        
    $("#btnNuevoEI").on("click",newEI);
    $("#btnCancelarEI").button({
        icons:{
            primary:'ui-icon-cancel'
        }
    }).on("click",cancelarEI);
    $("#guardarEI").button({
        disabled:true,
        icons:{
            primary:'ui-icon-disk'
        }
    }).on("click",guardarEI);
    $("#buscar-EI").keypress(function (evt){
        if(evt.keyCode==13){
            $cargarEI();
        }
    });
    $("#dialog-EI").dialog({
        autoOpen: false,
        modal: true,
        show: "blind",
        hide: "explode",
        resizable: false,
        width: '60%'
    });
    $("#seleccionar_4").button({
        icons: {
            primary:'ui-icon-arrow4-diag'
        }
    }).click(function(){
        llenarForm(16)
    });
    $("#close_4").button({
        icons: {
            primary:'ui-icon-close'
        }
    }).click(function(){
        $("#dialog-EI").dialog("close");
    });
    $("#asignarArcDig_4").button({
        icons:{
            primary:'ui-icon-signal-diag'
        }
    }).click(function(){
        $cargarGrillaPresupuestoFinanza("","", 16,"EI");
        $( "#dialog-EI" ).dialog("open");
    });
        
    $("#btnActualizarEI").button({
        icons:{
            primary:'ui-icon-signal-diag'
        }
    }).click(function(){
        actualizarArcDig(16);
    });
        
    /*************RGE**************/
    $datafecha("txtFechaRGE");
    // move the nav to the bottom
    $( ".tabs-bottom .ui-tabs-nav" ).appendTo( ".tabs-bottom" );
        
    $cargarRGE();
    $("#btnNuevoRGE").button({
        icons:{
            primary:'ui-icon-plus'
        }
    });
    $("#btnEliminarRGE").button({
        icons:{
            primary:'ui-icon-circle-close'
        }
    }).on("click",eliminarRGE);
    $("#btnEditarRGE").button({
        icons:{
            primary:'ui-icon-pencil'
        }
    }).on("click",editarRGE);
        
    $("#btnNuevoRGE").on("click",newRGE);
    $("#btnCancelarRGE").button({
        icons:{
            primary:'ui-icon-cancel'
        }
    }).on("click",cancelarRGE);
    $("#guardarRGE").button({
        disabled:true,
        icons:{
            primary:'ui-icon-disk'
        }
    }).on("click",guardarRGE);
    $("#buscar-RGE").keypress(function (evt){
        if(evt.keyCode==13){
            $cargarRGE();
        }
    });
    $("#dialog-RGE").dialog({
        autoOpen: false,
        modal: true,
        show: "blind",
        hide: "explode",
        resizable: false,
        width: '60%'
    });
    $("#seleccionar_5").button({
        icons: {
            primary:'ui-icon-arrow4-diag'
        }
    }).click(function(){
        llenarForm(17)
    });
    $("#close_5").button({
        icons: {
            primary:'ui-icon-close'
        }
    }).click(function(){
        $("#dialog-RGE").dialog("close");
    });
    $("#asignarArcDig_5").button({
        icons:{
            primary:'ui-icon-signal-diag'
        }
    }).click(function(){
        $cargarGrillaPresupuestoFinanza("","", 17,"RGE");
        $( "#dialog-RGE" ).dialog("open");
    });
        
    $("#btnActualizarRGE").button({
        icons:{
            primary:'ui-icon-signal-diag'
        }
    }).click(function(){
        actualizarArcDig(17);
    });
    $("body").roles();
    
}


$("document").ready(function(){
    init();

});