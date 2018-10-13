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

set ubic="D:\Servidor\htdocs"
rem set ubic="D:\Desarrollo"
rem set ubic="E:\Desarrollo"
rem set ubic="D:\Vaadin"

rem ---------------------------------
rem -- MIGRACION DE LOS DATOS      --
rem ---------------------------------
psql -d sfran -U postgres -f "db-pgsql-common.sql"

psql -d sfran -U postgres -f "db-pgsql-data.sql"
psql -d sfran -U postgres -f "MENU.sql"
psql -d sfran -U postgres -f "PROVINCIAS.sql"
psql -d sfran -U postgres -f "LOCALIDADES.sql"
psql -d sfran -U postgres -f "operadora.sql"
rem ---------------------------------
psql -d sfran -U postgres -f "USUARIOS.sql"
psql -d sfran -U postgres -f "AFIP.sql"


rem ---------------------------------
psql -d sfran -U postgres -c "VACUUM FULL FREEZE ANALYZE"


rem ---------------------------------
rem -- TAREAS DE MANTENIMINENTO    --
rem ---------------------------------
psql -d sfran -U postgres -c "VACUUM FULL FREEZE ANALYZE"
