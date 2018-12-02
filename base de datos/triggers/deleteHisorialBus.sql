delete trigger if exists deleteHistorialBus
create trigger deleteHistorialBus before delete on ruta
for each row
	delete from historialbus where ID_RUTA = old.ID_RUTA;