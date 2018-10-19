#Descripcion del sistema

##Productor
Titular de los terrenos donde se encuentran los animales.

## DTE
"Documento de transito electronico" es un comprobante que detalla los movimientos de animales, el origen, destino y la carga.

##### - Numero de DTE
Numero identificador del documento electronico. En el sistema se requiere cargar varios de estos pero solo se especificaran los datos de un DTE.

##### - Numero de tropa
Numero identificador para un conjunto de DTEs, ya que en un transporte se cargan varios conjuntos de animales de distintos origenes. 

##### - Renspa
Codigo que asocia a un productor con el campo donde realiza su actividad.

##### - Insumos
Al DTE se le asignan insumos con sus datos de cantidad y precio.

##### - Impuestos
Al DTE se le asignan impuestos con su saldo. En el caso de DTE solo se asigna el impuesto "Rentas". 

##### - Categoria
Las diferentes categorias de los animales que se cargaran en un DTE. Junto a ellas se cargan los siguientes datos:

###### * Kilogramos vivos, Precio (Por kg vivos), porcentaje de comision y kilogramos de carne.

El rinde/rendimiento se calcula dividiendo los kg de carne por los kg vivos.

La comision se calcula multiplicando kg vivos por precio por el porcentaje de comision.

## Moviles
Transportes usando por los conductores. Datos:

###### - Tara: Masa del vehículo con su equipo fijo autorizado, sin personal y sus recursos/herramientas.
###### - Estado vehiculo: Estado actual del vehiculo
###### - Fecha: La fecha que indica cuando fue el ultimo cambio de estado del vehiculo.

## Consignatario
Persona que figura en los documentos como receptor de los envios de los animales.

## Comisionita
Persona que se encarga de realizar una venta a nombre de otro y cobra su comision.

## Conductores
Choferes de los vehiculos para los transportes.

## Licencias
Las licencias de conducir de los choferes. Datos:

###### - Tipo de licencia
###### - Permisos para realizar cargas.
###### - Vencimientos: Vencimiento normal de carnet normal, vencimiento normal de carnet de habilitacion para cargas pesadas y vencimiento del curso a realizar para obtener el carnet que habilita las cargas pesadas (Son 2 licencias).

## Tipo de insumos
Indicacion de en que modulo podra agregarse el insumo.

## Operadoras
Operadoras de telefonia vehiculo.