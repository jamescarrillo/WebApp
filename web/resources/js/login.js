window.addEvent('domready', function() {
	$("btnConectar").addEvent("click", function(evt) {
		var load;
		var ajax = new Request.JSON({
			url : './Usuario?action=connect',
			data : {
				login : $("usua_login").get("value"),
				password : $("usua_password").get("value"),
				captcha : $("usua_captcha").get("value")
			},
			onRequest : function() {
				$$("div.mensaje").setStyle("display", "none");
				load = new Element('div', {
					"id" : "load",
					"class" : "load"					
				});
				load.setStyles({
					"text-align" : "center"					
				});
				load.inject($$(".mensaje")[0], "before");
				$("btnConectar").set("disabled",true);
			},
			onSuccess : function(response) {
				load.getParent().removeChild(load);
				$("btnConectar").set("disabled",false);
				if (response.success) {
					window.location = response.msg;
				} else {
					$$("div.mensaje").setStyle("display", "block").addClass("error").set("html", response.msg);
				}
			}
		});
		ajax.send();
		return false;
	});
});