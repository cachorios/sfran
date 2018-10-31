-- Control de dte ---
select * from dte
where not comisionista_id in(select id from comisionista);

select * from dte
where not conductor_id in(select id from conductor);

select * from dte
where not consignatario_id in(select id from consignatario);

--especie
select * from dte
where not especie_id in(select id from parametro where tipo=21);
--localidad
select * from dte
where not localidaddestino_id in(select id from parametro where tipo=10);
--localidad
select * from dte
where not localidadorigen_id in(select id from parametro where tipo=10);

--pica
select * from dte
where not provinciadestino_id in(select id from parametro where tipo=9);
--pcia
select * from dte
where not provinciaorigen_id in(select id from parametro where tipo=9);

select * from dte
where not vehiculo_id in(select id from vehiculo)

-- Control de DteDetalleCategoria --
select * from dtedetallecategoria
where not categoria_id in(select id from parametro where tipo=8);

select * from dtedetallecategoria
where not productor_id in(select id from productor);

select * from dtedetallecategoria
where not renspa_id in(select id from renspa);

select * from dtedetallecategoria
where not dte_id in(select id from dte);


