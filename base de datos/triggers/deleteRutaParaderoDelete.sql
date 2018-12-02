delete trigger if exists deleteRutaParadero
create trigger deleteRutaParadero before delete on ruta
for each row
	delete from rutaparaderos where ID_RUTA = old.ID_RUTA;