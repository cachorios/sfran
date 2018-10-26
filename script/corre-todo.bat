@echo off
cls
set PGPASSWORD=postgres
set PGDATA="C:\\Program Files (x86)\\PostgreSQL\\10\\data"

rem ---------------------------------
rem -- COMANDOS UTILES             --
rem ---------------------------------
rem INICIAR EL SERVER (EN MODO IMMEDIATE): pg_ctl restart -D "C:\Program Files\PostgreSQL\10\data" -m i
rem REINICIAR EL SERVER (EN MODO IMMEDIATE): pg_ctl restart -D "C:\Program Files\PostgreSQL\10\data" -m i
rem DETENER EL SERVER (EN MODO IMMEDIATE): pg_ctl stop -D "C:\Program Files\PostgreSQL\10\data" -m i
rem RECARGAR CONFIG DEL SERVER (EN MODO IMMEDIATE): pg_ctl reload -D "C:\Program Files\PostgreSQL\10\data" -m i
rem ...El archivo de configuraciones es el "postgresql.conf" dentro del "datadir" (por defaul lo que tiene la variable PGDATA)...

rem ---------------------------------
rem -- REINICIO DEL SERVIDOR       --
rem ---------------------------------
rem pg_ctl restart -D %PGDATA% -m i

rem ---------------------------------
rem -- PATH A LOS SCRIPTS DE DATOS --
rem ---------------------------------

rem set ubic="D:\Servidor\htdocs"
rem set ubic="D:\Desarrollo"
rem set ubic="E:\Desarrollo"
set ubic="D:\Vaadin"

rem ---------------------------------
rem -- MIGRACION DE LOS DATOS      --
rem ---------------------------------
rem psql -d sfran -U postgres -f "db-pgsql-common.sql"

psql -d sfran -U postgres -f "db-pgsql-data.sql"
psql -d sfran -U postgres -f "MENU.sql"
psql -d sfran -U postgres -f "PROVINCIASNUEVO.sql"
psql -d sfran -U postgres -f "LOCALIDADESNUEVO.sql"
psql -d sfran -U postgres -f "ESPECIE.sql"
psql -d sfran -U postgres -f "CATEGORIA.sql"
psql -d sfran -U postgres -f "COLOR.sql"
psql -d sfran -U postgres -f "CONDICION.sql"
psql -d sfran -U postgres -f "ESTADOSMOVIL.sql"
psql -d sfran -U postgres -f "MARCAMOVIL.sql"
psql -d sfran -U postgres -f "OPERADORASTELEFONICAS.sql"
psql -d sfran -U postgres -f "TIPOCOMBUSTIBLE.sql"
psql -d sfran -U postgres -f "TIPOINSUMO.sql"
psql -d sfran -U postgres -f "TIPOMOVIL.sql"
psql -d sfran -U postgres -f "IMPUESTO.sql"
psql -d sfran -U postgres -f "UNIDAD.sql"

psql -d sfran -U postgres -f "COMISIONISTA.sql"
psql -d sfran -U postgres -f "CONDUCTOR.sql"
psql -d sfran -U postgres -f "CONSIGNATARIO.sql"
psql -d sfran -U postgres -f "INSUMO.sql"

psql -d sfran -U postgres -f "VEHICULO.sql"

psql -d sfran -U postgres -f "PRODUCTOR.sql"
psql -d sfran -U postgres -f "RENSPA.sql"

psql -d sfran -U postgres -f "DTE.sql"
psql -d sfran -U postgres -f "NUMERODTE.sql"
psql -d sfran -U postgres -f "DTEDETALLECATEGORIA.sql"
psql -d sfran -U postgres -f "DTEDETALLEIMPUESTO.sql"
psql -d sfran -U postgres -f "DTEDETALLEINSUMO.sql"
psql -d sfran -U postgres -f "TIPOLICENCIA.sql"
psql -d sfran -U postgres -f "LICENCIA.sql"
psql -d sfran -U postgres -f "DOCUMENTO.sql"
psql -d sfran -U postgres -f "DOCUMENTODTE.sql"
psql -d sfran -U postgres -f "FACTURACOSTOVEHICULO.sql"
psql -d sfran -U postgres -f "INSUMOCOSTOVEHICULO.sql"
psql -d sfran -U postgres -f "IMPUESTOCOSTOVEHICULO.sql"


rem ---------------------------------
psql -d sfran -U postgres -f "USUARIOS.sql"
psql -d sfran -U postgres -f "AFIP.sql"


rem ---------------------------------
psql -d sfran -U postgres -c "VACUUM FULL FREEZE ANALYZE"


rem ---------------------------------
rem -- TAREAS DE MANTENIMINENTO    --
rem ---------------------------------
psql -d sfran -U postgres -c "VACUUM FULL FREEZE ANALYZE"
