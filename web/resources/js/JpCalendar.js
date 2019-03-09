var JpCalendar = new Class(
    {
        Implements : Options,
        options : {
            navigation : false,
            minYear : 1900,
            maxYear : 2099,
            ruteable: false,
            days : [ "Lu", "Ma", "Mi", "Ju", "Vi", "Sa", "Do" ],
            months : [ "Enero", "Febrero", "Marzo", "Abril", "Mayo",
            "Junio", "Julio", "Agosto", "Setiembre", "Octubre",
            "Noviembre", "Diciembre" ],
            monthDays : null,
            calendar : {
                year : null,
                fecha : null,
                month : null
            }
        },
        initialize : function(render, options) {
            this.setOptions(options);
            this.render = render;
            this.createCalendar();            
        },
        rendererTitle : function(calendar) {
            var msgHeadCal = "{month} {year}";
            var replaceDes = msgHeadCal.substitute(calendar);
            var format = replaceDes.split(" ");
            if (parseInt(format[1])>3000)
                format[1] = format[1] - 1900;
            $("span-" + this.render.get("id")).set("html", format[0]+ " " + format[1]);
            this.drawCalendar(calendar);
        },
        drawCalendar : function(calendar) {
            if (parseInt(calendar.year)>3000)
                calendar.year = calendar.year - 1900;
            if ((calendar.year % 4 == 0)
                && (calendar % 100 != 0 || calendar % 400 == 0)) {
                this.options.monthDay = {
                    "Enero" : 31,
                    "Febrero" : 29,
                    "Marzo" : 31,
                    "Abril" : 30,
                    "Mayo" : 31,
                    "Junio" : 30,
                    "Julio" : 31,
                    "Agosto" : 31,
                    "Setiembre" : 30,
                    "Octubre" : 31,
                    "Noviembre" : 30,
                    "Diciembre" : 31
                };
            } else {
                this.options.monthDay = {
                    "Enero" : 31,
                    "Febrero" : 28,
                    "Marzo" : 31,
                    "Abril" : 30,
                    "Mayo" : 31,
                    "Junio" : 30,
                    "Julio" : 31,
                    "Agosto" : 31,
                    "Setiembre" : 30,
                    "Octubre" : 31,
                    "Noviembre" : 30,
                    "Diciembre" : 31
                };
            }
            
            var fecha_actual = new Date();
            var now = false;
            now = (fecha_actual.getMonth() == this.options.calendar.fecha
                .getMonth());
            var dia_mes = this.options.calendar.fecha.getDate();
            var dia_semana = this.options.calendar.fecha.getDay();
            var dia_semana_act;
            var mes = this.options.calendar.month;
            for (x = dia_mes; x > 0; x--) {
                if (dia_semana == 0) {
                    dia_semana = 7;
                }
                dia_semana--;
                dia_semana_act = dia_semana;
            }
            if (dia_semana_act == -1) {
                dia_semana_act = 6;
            }
            if (this.calendar.getChildren("table").length > 0)
                this.calendar.removeChild($("tbl-" + this.render.get("id")));
            var table = new Element("table", {
                "id" : "tbl-" + this.render.get("id"),
                "class" : "tbl-calendar"
            });
            var thead = new Element("thead");
            var trh = new Element("tr");
            for (m = 0; m < 7; m++) {
                var th = new Element("th", {
                    "html" : this.options.days[m]
                });
                th.inject(trh);
            }
            trh.inject(thead);
            thead.inject(table);
            var tbody = new Element("tbody");
            var k = 0;
            var trb = new Element("tr");
            for (i = 0; i < dia_semana_act; i++) {
                var td = new Element('td', {
                    "html" : "&nbsp;"
                });
                td.inject(trb);
                k++;
            }
            var j = k;
            var Td;
            if (!this.options.ruteable){
                for (i = 0; i < this.options.monthDay[mes]; i++) {
                    if (j == 7) {
                        trb.inject(tbody);
                        Td = new Element("td", {
                            "html" : i + 1
                            
                        });
                        if (now && (i + 1) == fecha_actual.getDate()) {
                            Td.addClass("now");
                        } else {
                            Td.addClass("number");
                        }
                        trb = new Element("tr");
                        Td.inject(trb);
                        j = 0;
                    } else {
                        Td = new Element("td", {
                            "html" : i + 1
                            
                        });
                        if (now && (i + 1) == fecha_actual.getDate()) {
                            Td.addClass("number now");
                        } else {
                            Td.addClass("number");
                        }
                        Td.inject(trb);
                    }
                    j++;
                }
            } else{
                for (i = 0; i < this.options.monthDay[mes]; i++) {
                    if (j == 7) {
                        trb.inject(tbody);
                        Td = new Element("td", {
                            "html" : i + 1,
                            "title": "Click Para Ir A La Agenda Del Gerente"
                        }).addEvent("click", function(e){
                            document.location.href="./GestionTransparente?action=AgendaInstitucional";
                        });
                        if (now && (i + 1) == fecha_actual.getDate()) {
                            Td.addClass("now");
                        } else {
                            Td.addClass("number");
                        }
                        trb = new Element("tr");
                        Td.inject(trb);
                        j = 0;
                    } else {
                        Td = new Element("td", {
                            "html" : i + 1,
                            "title": "Click Para Ir A La Agenda Del Gerente"
                        }).addEvent("click", function(e){
                            document.location.href="./GestionTransparente?action=AgendaInstitucional";
                        });
                        if (now && (i + 1) == fecha_actual.getDate()) {
                            Td.addClass("number now");
                        } else {
                            Td.addClass("number");
                        }
                        Td.inject(trb);
                    }
                    j++;
                }
            }
            for (i = 0; i < 7 - j; i++) {
                Td = new Element('td', {
                    "html" : "&nbsp;"
                });
                Td.inject(trb);
            }
            if (trb.getChildren("td").length > 0) {
                trb.inject(tbody);
            }
            tbody.inject(table);
            table.inject(this.calendar);
        },
        
        createCalendar : function() {
            var calendarTitle = new Element('div', {
                "class" : "calendar-title"
            });
            var aPrevius, aNext;
            var spanCalendarDescription = new Element('span', {
                "id" : "span-" + this.render.get("id"),
                "class" : "span-description"
            });
            if (this.options.navigation) {
                aPrevius = new Element('a', {
                    "href" : "#",
                    "title" : "Anterior",
                    "html" : "&lt;",
                    "class" : "aPrev"
                });
                aNext = new Element('a', {
                    "href" : "#",
                    "title" : "Siguiente",
                    "html" : "&gt;",
                    "class" : "aNext"
                });
                aPrevius.addEvent("click", this.previous.bind(this));
                aNext.addEvent("click", this.next.bind(this));
                calendarTitle.adopt(aPrevius, spanCalendarDescription,
                    aNext);
            } else {
                spanCalendarDescription.setStyle("width", "100%");
                calendarTitle.adopt(spanCalendarDescription);
            }
            var fecha_actual = new Date();
            var mes = fecha_actual.getMonth();
            var anho = parseInt(fecha_actual.getYear())
            + this.options.minYear;
            this.options.calendar.month = this.options.months[mes];
            if (parseInt(anho)>3000)
                anho= anho - 1900;
            
            this.options.calendar.year = anho;
            this.options.calendar.fecha = fecha_actual;
            this.calendar = new Element("div", {
                "class" : "calendar"
            });
            calendarTitle.inject(this.calendar);
            this.calendar.inject(this.render);
            this.rendererTitle(this.options.calendar);
        },
        previous : function() {
            if (this.options.months.indexOf(this.options.calendar.month) - 1 == -1) {
                this.options.calendar.month = this.options.months[11];
                this.options.calendar.fecha = new Date(
                    this.options.calendar.year - 1, 11, 1);
                this.options.calendar.year = this.options.calendar.year - 1;
            } else {
                this.options.calendar.month = this.options.months[this.options.months
                .indexOf(this.options.calendar.month) - 1];
                this.options.calendar.fecha = new Date(
                    this.options.calendar.year, this.options.months
                    .indexOf(this.options.calendar.month), 1);
            }
            this.rendererTitle(this.options.calendar);
            return false;
        },
        next : function() {
            if (this.options.months.indexOf(this.options.calendar.month) + 1 == 12) {
                this.options.calendar.month = this.options.months[0];
                this.options.calendar.fecha = new Date(
                    this.options.calendar.year + 1, 0, 1);
                this.options.calendar.year = this.options.calendar.year + 1;
            } else {
                this.options.calendar.month = this.options.months[this.options.months
                .indexOf(this.options.calendar.month) + 1];
                this.options.calendar.fecha = new Date(
                    this.options.calendar.year, this.options.months
                    .indexOf(this.options.calendar.month), 1);
            }
            this.rendererTitle(this.options.calendar);
            return false;
        }
    });