create trigger addRutaParadero after insert on ruta
for each row
	insert into rutaparaderos (id_ruta, id_paradero) 
    values (new.id_ruta, new.paradero_inicio), 
    (new.id_ruta, new.paradero_fin);