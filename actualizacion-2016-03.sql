ALTER TABLE web.obra
  ADD COLUMN anho_actualizacion character(4) NOT NULL DEFAULT '';
ALTER TABLE web.obra
  ADD COLUMN mes_actualizacion character varying(30) NOT NULL DEFAULT '';
ALTER TABLE web.obra
  ADD COLUMN snip character varying(150) NOT NULL DEFAULT '';
ALTER TABLE web.obra
  ADD COLUMN observacion text NOT NULL DEFAULT '';
ALTER TABLE web.obra
  ADD COLUMN infobras character varying(150) NOT NULL DEFAULT '';
ALTER TABLE web.obra
  ADD COLUMN leyenda character varying(150) NOT NULL DEFAULT '';

