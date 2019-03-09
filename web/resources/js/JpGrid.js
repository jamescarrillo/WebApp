var JpGrid = new Class({
    Implements: Options,
    options: {
        url: '',
        sortable: true,
        pagination: true,
        ancho: '100%',
        altura: null,
        hidden: false,
        model: [],
        margin: 0,
        padding: 0,
        select: 0,
        onClick: function(e) {
        },
        success: function(e) {
        },
        cargado: function() {
        },
        defaultColumns: [{
                type: 'string',
                sort: false
            }],
        params: {
            start: 0,
            current: 0,
            limit: 10
        },
        totalCount: 0
    },
    initialize: function(elemento, opciones) {
        this.elemento = elemento;
        this.contenedor = null;
        this.body = null;
        this.setOptions(opciones);
        this._createTable();
        if (this.options.pagination)
            this._pagination();

        if (this.options.sortable)
            this._addSortableColumn();

        this._loadData();
    },
    _createTable: function() {
        this.contenedor = new Element('table', {
            "class": "grid"
        });
        this.header = new Element('thead');
        var trHeader = new Element('tr', {
            'style': 'cursor:pointer'
        });
        for (var i = 0; i < this.options.model.length; i++) {

            if (this.options.model[i].hidden != true) {
                var th = new Element('th', {
                    "html": this.options.model[i].field,
                    'style': 'text-align:center'
                });

                th.setStyles({
                    "width": this.options.model[i].width
                });
                th.inject(trHeader);
            }
        }
        trHeader.inject(this.header);
        this.contenedor.setStyles({
            "width": this.options.ancho,
            "margin": this.options.margin,
            "padding": this.options.padding
        });
        if (this.options.altura != null)
            this.elemento.setStyle("min-height", this.options.altura);
        this.header.inject(this.contenedor);
        this.body = new Element('tbody');
        this.body.inject(this.contenedor);
        this.contenedor.inject(this.elemento);

    },
    _loadData: function(data, model) {
        var query = "", me = this;
        this.dataQuery = "";
        if (data == undefined) {
            this.dataQuery = this.options.dataQuery;
        } else {
            this.dataQuery = data;
        }

        if (model != undefined) {
            me.options.model = model;
        }

        var content = me.body.getParent().getParent()
        this.dataQuery.each(function(node, index) {
            query += node.name + "=" + node.value + "&";
        });

        /*effectos de trasparencia cargando */


        /*var $divTransparent = new Element("div", {
         "style" : "position:absolute; z-index:1; background-color:#fff; width:"+size.x+"px; height:"+size.y+"px",
         "id" : "tra"+content.get("id")
         });*/

        /*$divTransparent.inject(content,"before");
         $divTransparent.tween('opacity', 0.5);*/
        var sizeBody = me.body.getSize();
        me.body.empty();
        var $divLoading = new Element("tr", {
            "id": "load" + content.get("id"),
            "style": 'height:' + sizeBody.y + 'px'
        }).set("html", "<td colspan=" + me.options.model.length + " ><img style='margin:auto  auto auto " + parseInt(parseInt(sizeBody.x / 2) - 24) + "px' src='./resources/images/loading.gif' border='0' >     </td>");

        $divLoading.inject(me.body);


        var ajax = new Request.JSON({
            url: this.options.url,
            data: query,
            onSuccess: function(result) {
                me.body.empty();
                me.options.totalCount = result.total;

                result.items.each(function(node, index) {
                    var elem;
                    var back = "";

                    var tdParent = new Element('tr', {
                        'style': 'cursor:pointer; '
                    });

                    var datos = "";
                    for (var i = 0; i < me.options.model.length; i++) {
                        if (me.options.model[i].hidden == true) {
                            var value = "";
                            if (node[me.options.model[i].name] == undefined)
                                value = " ";
                            else
                                value = node[me.options.model[i].name];
                            
                            if (i < parseInt(me.options.model.length - 1))
                                datos += value + '|';
                            else
                                datos += value;
                        } else {
                            if (me.options.model[i].type == "date") {
                                elem = new Element('td', {
                                    "text": me._convertDate(node[me.options.model[i].name])
                                });
                            } else if (me.options.model[i].type == "numeric") {

                                elem = new Element('td', {
                                    "text": me._convertNumeric(node[me.options.model[i].name])
                                });
                            } else if (me.options.model[i].type == "url") {
                                elem = new Element('td', {
                                    "html": "<a href='" + node[me.options.model[i].name] + "'>enlace</a>"
                                });
                            } else {
                                elem = new Element('td', {
                                    "html": node[me.options.model[i].name]
                                });
                            }
      
                            if (me.options.model[i].style != undefined) {
                                elem.setStyles(me.options.model[i].style);
                            }

                            if (me.options.model[i].items != undefined) {
                                var $object = me.options.model[i].items;
                                var valor = node[me.options.model[i].name];
                                $object.each(function(node, index) {
                                    if (valor == node["id"])
                                        elem.set("html", node["valor"]);
                                });
                            }

                            if (me.options.model[i].renderer != undefined) {
                                if (node[me.options.model[i].activo] || node[me.options.model[i].activo] == undefined)
                                    elem.set("html", me.options.model[i].renderer(elem.get('html')));
                                else {
                                    if (me.options.model[i].clase != undefined) {
                                        elem.setAttribute("class", me.options.model[i].clase);
                                        elem.setAttribute("dir", me.options.model[i].title + " : " + node[me.options.model[i].filtro])
                                    }
                                    elem.set("html", '<em class="arrow" href="#">Restringido</em>');
                                }
                            }
                            if (me.options.model[i].removeTags != undefined) {
                                var cadena = node[me.options.model[i].name];
                                elem.set("html", cadena.replace(/<[^>]+>/g, ''));
                            }

                            if (me.options.model[i].maxLength != undefined) {
                                cadena = node[me.options.model[i].name];
                                if (cadena.length > me.options.model[i].maxLength)
                                    elem.set("html", cadena.substr(0, me.options.model[i].maxLength, cadena) + "...");
                            }

                            if (me.options.model[i].link != undefined) {
                                $object = me.options.model[i].link;
                                cadena = node[me.options.model[i].name];
                                var target = "";
                                if ($object.target != undefined){
                                    target = "target='" + $object['target'] + "'";
                                }
                                elem.set("html", "<a " + target + " href='" + $object['url'] + cadena + "'>" + $object['text'] + "</a>");
                            }
                            
                            if (me.options.model[i].textAlign != undefined) {
                                
                                elem.set("html", "<div style='text-align:" + me.options.model[i].textAlign + "; width:100%'>" + cadena + "</div>");
                            }
                            
                            //alert(elem.get("text"));
                            elem.inject(tdParent);
                        }
                    }

                    tdParent.set("data-store", datos);

                    var color = tdParent.getStyle('backgroundColor');
                    tdParent.inject(me.body);
                    if (parseInt(index % 2) == 0)
                        tdParent.addClass("rendija")

                    tdParent.addEvent('click', function() {
                        this.addClass("active").getSiblings().removeClass("active");
                        me.options.onClick(this);
                    });

                    if (index == me.options.select) {
                        tdParent.addClass("active").getSiblings().removeClass("active");
                        me.options.onClick(tdParent);
                    }
                    me.options.success(node);

                });
                me.options.cargado();
                if (result.total == 0) {
                    $$(".paginate-" + me.options.id).hide();
                    var trParent = new Element('tr');
                    var td = new Element('td', {
                        "colspan": "5",
                        "html": "No se encontraron resultados"
                    });
                    td.setStyles({
                        "border": "none",
                        "font-weight": "bold",
                        "text-align": "center"
                    });
                    trParent.adopt(td);
                    trParent.inject(me.body);
                }
                else {
                    $$(".paginate-" + me.options.id).show();
                }
                $("totalItems-" + me.options.id).set("html", result.total);
                if ((parseInt(result.pagina)) == 0)
                    $("page-" + me.options.id).set("html", 1 + " de " + Math.ceil(parseInt(result.total) / (parseInt(me.options.params.limit))));
                else
                    $("page-" + me.options.id).set("html", (parseInt(result.pagina) + 1) + " de " + (Math.ceil(parseInt(result.total) / (parseInt(me.options.params.limit)))));
                $("bfinal-" + me.options.id).set("rel", Math.ceil(parseInt(result.total) / (parseInt(me.options.params.limit))));
            }
        });
        ajax.send();
    },
    _convertNumeric: function(cell) {
        var val = parseFloat(cell);
        if (isNaN(val)) {
            return "0.00";
        }
        if (val <= 0) {
            return "0.00";
        }
        val += "";
        // Next two lines remove anything beyond 2 decimal places
        var aux = val
        var response = "";
        var cont = 0;
        if (val.indexOf('.') == -1) {

            if (aux.length > 3) {
                for (var i = aux.length - 3; i > 0; i = i - 3) {
                    response = "," + aux.substring(i, i + 3) + response;
                    if (parseInt(i - 3) <= 0)
                        break;
                }
                response = aux.substring(0, i) + response;
            } else
                response = aux;

            //response=aux.substring(0,i)+response;
            key = response + ".00";
            return key;
        }
        else {

            val = val.substring(0, val.indexOf('.') + 3);
        }

        val = (val == Math.floor(val)) ? val + '.00' : ((val * 10 ==
                Math.floor(val * 10)) ? val + '0' : val);

        // poniendo comas de millar
        aux = val.split(".")[0];
        response = "";
        if (aux.length > 3) {
            for (var i = aux.length - 3; i > 0; i = i - 3) {
                response = "," + aux.substring(i, i + 3) + response;
                if (parseInt(i - 3) <= 0)
                    break;
            }
            response = aux.substring(0, i) + response;
        } else
            response = aux;
        var key = response + "." + val.split(".")[1];
        return key;
    },
    _convertDate: function(dato) {
        if (dato == undefined) {
            return null;
        }
        else {
            var date = dato;
            if (dato.indexOf("-") > 0) {
                return dato.split("-")[2] + "/" + dato.split("-")[1] + "/" + dato.split("-")[0];
            }
            return dato;
        }
    },
    _pagination: function() {
        var me = this;
        var pie = new Element('div', {
            "id": "paginate-" + this.options.id,
            "class": "paginate"
        });
        this.options.url += '&start=' + this.options.params.start + "&limit=" + this.options.params.limit;
        pie.setStyle("width", this.options.ancho);
        var lizq = new Element('div', {
            "class": "lizq"
        });
        var binicio = new Element('a', {
            "id": "binicio-" + this.options.id,
            "href": "#",
            "class": "binicio",
            "html": "&nbsp;&nbsp;&nbsp;&nbsp;"
        });
        binicio.addEvent('click', function(evt) {
            evt.preventDefault();
            me._rewriteUrl(1);
        });
        var bizq = new Element('a', {
            "id": "bizq-" + this.options.id,
            "href": "#",
            "class": "bizq",
            "html": "&nbsp;&nbsp;&nbsp;&nbsp;"
        });
        bizq.addEvent("click", function(evt) {
            evt.preventDefault();
            if ((parseInt($("page-" + me.options.id).get('html')) - 1) > 0)
                me._rewriteUrl(parseInt($("page-" + me.options.id).get("html")) - 1);
        });
        var lPropiedades = new Element('label', {
            "id": "page-" + this.options.id,
            "html": "0"
        });

        var bder = new Element('a', {
            "id": "bder-" + this.options.id,
            "href": "#",
            "class": "bder",
            "html": "&nbsp;&nbsp;&nbsp;&nbsp;"
        });

        bder.addEvent('click', function(evt) {
            evt.preventDefault();
            if ((parseInt($("page-" + me.options.id).get("html")) - 1) < (parseInt($("bfinal-" + me.options.id).get("rel")) - 1))
                me._rewriteUrl(parseInt($("page-" + me.options.id).get("html")) + 1);
        });

        var bfinal = new Element('a', {
            "id": "bfinal-" + this.options.id,
            "href": "#",
            "class": "bfinal",
            "html": "&nbsp;&nbsp;&nbsp;&nbsp;"
        });

        bfinal.addEvent("click", function(evt) {
            evt.preventDefault();
            me._rewriteUrl($("bfinal-" + me.options.id).get("rel"));
        });
        lizq.adopt(binicio, bizq, lPropiedades, bder, bfinal);
        var lder = new Element('div', {
            "class": "lder",
            "html": "Total de registro "
        });
        var totalItems = new Element('label', {
            "id": "totalItems-" + this.options.id,
            "html": "0"
        });
        lder.adopt(totalItems);
        pie.adopt(lizq, lder);
        pie.inject(this.elemento.getParent());
    },
    _columnType: {
        "string": function(col) {
            $(col).addClass("string");
            return function(cell) {
                return cell.get('html').toUpperCase();
            };
        },
        "numeric": function(col) {
            $(col).addClass("numeric");
            return function(cell) {
                var key = cell.text().toPrecision(2);
                return isNaN(key) ? 0 : key;
            };
        },
        "integer": function(col) {
            $(col).addClass("integer");
            return function(cell) {
                var key = parseInt(cell.text());
                return isNaN(key) ? 0 : key;
            };
        },
        "boolean": function(col) {
            $(col).addClass("boolean");
            return function(cell) {
                return cell.get('html');
            };
        },
        "date": function(col) {
            $(col).addClass("date");
            return function(cell) {
                var key = cell.text();
                return key;
            };
        },
        "url": function(col) {
            $(col).addClass("string");
            return function(cell) {
                return cell.get('html');
            };
        }
    },
    _addSortableColumn: function() {
        var me = this;
        this.options.model.each(function(component, columna) {
            if (component.hidden != true) {
                var col = me.header.getChildren("tr th")[columna];
                if (component.sort == undefined ? me.options.defaultColumns[0].sort : component.sort)
                    col.removeClass("sortable").addClass("sortable");
                var findOrder = me._columnType[component.type == undefined ? me.options.defaultColumns[0].type : component.type.toLowerCase()](col);
                if (findOrder) {
                    col.addEvent("click", function() {
                        if (col.hasClass('sortable')) {
                            var sortDirect = 1;
                            if (col.match(".sort-asc"))
                                sortDirect = -1;
                            var filas = me.body.getChildren("tr");
                            filas.each(function(nodo, index) {
                                nodo.store("sortKey", findOrder(nodo.getChildren("td")[columna]));
                            });
                            filas.sort(function(a, b) {
                                if (a.retrieve("sortKey") < b.retrieve("sortKey"))
                                    return -sortDirect;
                                if (a.retrieve("sortKey") > b.retrieve("sortKey"))
                                    return sortDirect;
                                return 0;
                            });
                            filas.each(function(nodo, index) {
                                nodo.inject(me.body);
                                nodo.eliminate('sortKey');
                            });
                            me.header.getChildren("tr th").removeClass("sort-asc").removeClass("sort-desc");//aqui eliminamos las clase de ordenacion de la cabecera para asignar de acuerdo a la variable sortDirect
                            if (sortDirect == 1)
                                col.addClass("sort-asc");
                            else
                                col.addClass("sort-desc");
                        }
                    });
                }
            }
        });

    },
    _rewriteUrl: function(page) {
        var urlTemp = this.options.url.split('&');
        var urlHttp = urlTemp[0];
        var newUrl = urlHttp + "&";
        if (this.options.url.split('?')) {
            var queryString = this.options.url.split('&');
            for (var i = 0; i < queryString.length; i++) {
                var row, key, opt = false;
                if (queryString[i].indexOf("start") != -1) {
                    row = queryString[i].split("=");
                    key = row[0];
                    newUrl += key + "=" + (parseInt(page - 1) * parseInt(this.options.params.limit));
                    opt = true;
                }
                if (opt)
                    newUrl += "&";
                if (queryString[i].indexOf("limit") != -1)
                    newUrl += queryString[i];
            }
        }
        this.options.url = newUrl + "&current=" + parseInt(page - 1);
        this._loadData(this.dataQuery);
    },
    loadData: function(data, model) {
        var urlTemp = this.options.url.split('&');
        var urlHttp = urlTemp[0];
        var newUrl = urlHttp + "&";
        if (this.options.url.split('?')) {
            var queryString = this.options.url.split('&');
            for (var i = 0; i < queryString.length; i++) {
                var row, key, opt = false;
                if (queryString[i].indexOf("start") != -1) {
                    row = queryString[i].split("=");
                    key = row[0];
                    newUrl += key + "=0";
                    opt = true;
                }
                if (opt)
                    newUrl += "&";
                if (queryString[i].indexOf("limit") != -1)
                    newUrl += queryString[i];
            }
        }
        this.options.url = newUrl + "&current=" + parseInt(0);
        this._loadData(data, model);
    }
});