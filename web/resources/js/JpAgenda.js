/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var JpAgenda = new Class({
	Extends : JpCalendar,
	Implements : [ Options, Events ],
	options : {
		url : null
	},
	initialize : function(element, contenedor, options) {
		this.parent(element, options);
		this.setOptions(options);
		this.contenedor = contenedor;
	},
	selected : function(evt) {
		var seleccionado = evt.target;
		$$(seleccionado.getParent().getSiblings().getChildren("td.number")).removeClass('select');
		seleccionado.addClass('select').getSiblings().removeClass('select');
		return false;
	},
	drawCalendar : function(calendar) {
        this.parent(calendar);
		$$("#tbl-" + this.render.get("id") + " .number").each(function(node, i) {
			node.set("id", "day-" + (i + 1));
			node.addEvent("click", function(evt) {
				this.selected(evt);
				this.loadData({
					anho : this.options.calendar.year,
					mes : this.options.months.indexOf(this.options.calendar.month) + 1,
					dia : $("day-" + (i + 1)).get("html")
				});
				return false;
			}.bind(this));
		}.bind(this));
                var today = new Date();
		this.loadData({
			anho : this.options.calendar.year,
			mes : this.options.months.indexOf(this.options.calendar.month) + 1,
                        dia : today.getDate()
		});
	},
	loadData : function(query) {
		var me = this;
		/*if (Browser.version < 9) {
			query.anho = query.anho - 1900;
		}*/
		var ajax = new Request.JSON({
			url : this.options.url,
			data : Object.toQueryString(query),
			onSuccess : function(responseJson) {
				me.contenedor.getChildren("div").each(function(node, index) {
					$$(node)[0].getParent().removeChild(node);
				});			
				
				if (responseJson.items.length > 0) {
					responseJson.items.each(function(node) {
						var actividad = new Element('div', {
							"html" : node.actividad
						});
						actividad.setStyles({
							"padding" : "5px",
							"font-weight" : "bold",
							"font-size" : "90%"
						});
						var tiempo = new Element('div', {
							"html" : "FECHA : " + node.fechaInicio + " &nbsp; &nbsp; &nbsp;HORA : " + node.horaInicio + " - "+ node.horaFinal
                                                        
						});
						tiempo.setStyles({
							"padding-left" : "5px",
							"color" : "#444444",
							"font-size" : "85%"
                                                        
						});
						var lugar = new Element('div', {
							"html" : "LUGAR : " + node.ciudad + ", " + node.lugar
						});
						lugar.setStyles({
							"padding" : "1px 5px",
							"color" : "#444444",
							"font-size" : "85%"
						});
						var direccion = new Element('div', {
							"html" : "DIRECCI&Oacute;N : " + node.direccion
						});
						direccion.setStyles({
							"padding" : "1px 5px",
							"color" : "#444444",
							"font-size" : "85%"
						});
						var elem = new Element('div', {
							"class" : "gadgets"
						});
						elem.adopt(actividad, tiempo, lugar);
						elem.inject(me.contenedor);
					});
				} else {
					var elem = new Element('div', {
						"class" : "gadgets"
					});
					var actividad = new Element('div', {
						"html" : "NO EXISTE ACTIVIDAD"
					});
					actividad.setStyles({
						"padding" : "5px",
						"font-weight" : "bold",
						"font-size" : "80%"
					});
					elem.adopt(actividad);
					elem.inject(me.contenedor);
				}
			}
		});
		ajax.send();
	}
});
