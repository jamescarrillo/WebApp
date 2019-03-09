require(["resources/js/jquery.js"],function(){
    $("document").ready(function(){
        $("div.menu-lateral a").on("click", function() {
            require([ 'resources/js/admin/listener.js' ], function(evento) {
                evento.redirectUrl(this,$("#c-izquierdo"));
            }.bind(this));
            return false;
        });
    });
});
