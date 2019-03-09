define(function() {
    function cargarScript(owner){ 
        var fin=$(owner).attr("href").indexOf("?action");
        var js;
        if (fin==-1){
            fin=$(owner).attr("href").length;
            js=$(owner).attr("href").substring(2, fin+1).toLowerCase();
        }else{
            js=$(owner).attr("href").substring(2, fin).toLowerCase(); 
        }
        require(["resources/js/admin/controller/"+js+"Controller.js"],function(js){
            js.init();
        });
    }
    function forward(owner, renderTo) {
        if ($(owner).attr('href') != "") {
            $.ajax({               
                url : $(owner).attr('href'),
                beforeSend:function(){
                    $('<div/>',{
                        "id" : "load",
                        "class" : "load",
                        css:{
                        "text-align" : "center",
                        "z-index" : 9001
                    }
                    }).appendTo($(renderTo));
                },
                success:function(response){
                    $("#load").remove();
                    $(renderTo).html(response);
                    require(["resources/js/admin/listener.js"],function(listener){
                        listener.cargarScript(owner);
                    });
                }
            });
        }
    }
    return {
        redirectUrl : forward,
        cargarScript:cargarScript
    };
});

////define(function() {
//    function cargarScript(owner){ 
//         
//      var fin=$(owner).get("href").indexOf("?action");
//         var js;
//        if (fin==-1){
//            fin=$(owner).get("href").length;
//            js=$(owner).get("href").substring(2, fin+1).toLowerCase();
//        }else{
//            js=$(owner).get("href").substring(2, fin).toLowerCase();
//        }  
//        
//        require(["resources/js/admin/controller/"+js+"Controller.js"],function(js){
//            js.init();
//        });
//    }
//    function forward(owner, renderTo) {   
//       if ($(owner).get('href') != "") {
//            var html = new Request.HTML({
//                url : $(owner).get('href'),
//                onRequest : function() {
//                    var load = new Element('div', {
//                        "id" : "load",
//                        "class" : "load"
//                    });
//                    load.setStyles({
//                        "text-align" : "center",
//                        "z-index" : 9001
//                    });
//                    load.inject($(renderTo));
//                },
//                onSuccess : function(responseTree, responseElements, responseHTML, responseJavaScript) {
//                    $(renderTo).set("html", responseHTML);
//                    require(["resources/js/admin/listener.js"],function(listener){
//                        listener.cargarScript(owner);
//                    });              
//                }
//            });
//            html.send();
//        }
//    }
//    return {
//        redirectUrl : forward,
//        cargarScript:cargarScript
//    };
//});