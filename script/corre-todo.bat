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

rem psql -d sfran -U postgres -f "USUARIOS.sql"


rem psql -d sfran -U postgres -f "db-pgsql-data.sql"
rem psql -d sfran -U postgres -f "MENU.sql"
rem psql -d sfran -U postgres -f "PROVINCIASNUEVO.sql"
rem psql -d sfran -U postgres -f "LOCALIDADESNUEVO.sql"
rem psql -d sfran -U postgres -f "ESPECIE.sql"
rem psql -d sfran -U postgres -f "CATEGORIA.sql"
rem psql -d sfran -U postgres -f "COLOR.sql"
rem psql -d sfran -U postgres -f "CONDICION.sql"
rem psql -d sfran -U postgres -f "ESTADOSMOVIL.sql"
rem psql -d sfran -U postgres -f "MARCAMOVIL.sql"
rem psql -d sfran -U postgres -f "OPERADORASTELEFONICAS.sql"
rem psql -d sfran -U postgres -f "TIPOCOMBUSTIBLE.sql"
rem psql -d sfran -U postgres -f "TIPOINSUMO.sql"
rem psql -d sfran -U postgres -f "TIPOMOVIL.sql"
rem psql -d sfran -U postgres -f "IMPUESTO.sql"
rem psql -d sfran -U postgres -f "UNIDAD.sql"

rem psql -d sfran -U postgres -f "CONDUCTOR.sql"
rem psql -d sfran -U postgres -f "COMISIONISTA.sql"
rem psql -d sfran -U postgres -f "CONSIGNATARIO.sql"
rem psql -d sfran -U postgres -f "INSUMO.sql"

rem psql -d sfran -U postgres -f "VEHICULO.sql"

rem psql -d sfran -U postgres -f "PRODUCTOR.sql"
rem psql -d sfran -U postgres -f "RENSPA.sql"

rem psql -d sfran -U postgres -f "DTE.sql"
rem psql -d sfran -U postgres -f "NUMERODTE.sql"
rem psql -d sfran -U postgres -f "DTEDETALLECATEGORIA.sql"
rem psql -d sfran -U postgres -f "DTEDETALLEIMPUESTO.sql"
rem psql -d sfran -U postgres -f "DTEDETALLEINSUMO.sql"
rem psql -d sfran -U postgres -f "TIPOLICENCIA.sql"
rem psql -d sfran -U postgres -f "LICENCIA.sql"
rem psql -d sfran -U postgres -f "DOCUMENTO.sql"
rem psql -d sfran -U postgres -f "DOCUMENTODTE.sql"
rem psql -d sfran -U postgres -f "FACTURACOSTOVEHICULO.sql"
rem psql -d sfran -U postgres -f "INSUMOCOSTOVEHICULO.sql"
rem psql -d sfran -U postgres -f "IMPUESTOCOSTOVEHICULO.sql"
rem psql -d sfran -U postgres -f "GRASERIA.sql"
rem psql -d sfran -U postgres -f "GRASERIADETALLEINSUMO.sql"
rem psql -d sfran -U postgres -f "GRASERIADETALLEIMPUESTO.sql"


rem ---------------------------------

rem psql -d sfran -U postgres -f "AFIP.sql"


rem ---------------------------------
psql -d sfran -U postgres -c "VACUUM FULL FREEZE ANALYZE"


rem ---------------------------------
rem -- TAREAS DE MANTENIMINENTO    --
rem ---------------------------------
psql -d sfran -U postgres -c "VACUUM FULL FREEZE ANALYZE"
