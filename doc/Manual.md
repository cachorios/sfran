#Pantalla principal

Al iniciar sesion encontrara en la esquina superior izquierda tres lineas horizontales que le permitiran ocultar el **Menu principal** y en la esquina superior derecha botones que le permitiran **cambiar su contraseña** (Candado) o **cerrar su sesion**.

![Pantalla pricipal](Manual imagenes/pantalla principal.png)

## Menu principal

El menu principal permite la facil **navegacion** entre los sectores, presentadolos en una lista que a su ves cada una contiene una sub-lista para su mejor ordenamiento.

![Menu principal](Manual imagenes/Menu principal.png)

## Interfaz de sectores

![CRUD](Manual imagenes/CRUD.png)

Cada sector contiene una lista de sus registros (En este caso 'Consignatarios') la cual se puede filtrar con el campo sobre ella. A su derecha un conjunto de botones y debajo de ellos una previsualizacion.

###### Previsualizacion:
Al seleccionar un registro de la lista mostrara datos extra del mismo.
###### Botones:
- VER: Previsualizacion completa del registro seleccionado en la lista.
- NUEVO: Crear un nuevo registro.
- EDITAR: Modificar los datos del registro seleccionado.
- BORRAR: Eliminar el registro seleccionado.
- IMPRIMIR: Despliega una lista de reportes en PDF o EXCEL relacionados con el sector (En este caso 'Consignatarios').

## Ventanas de carga o edicion de datos

Las interfaces de carga/edicion de datos cuentan con un formulario con los campos correspondientes a rellenar/cambiar y 3 botones:

- GUARDAR: Guardar los cambios o el nuevo registro.
- GUARDAR Y AGREGAR: Guarda el nuevo registro y mantiene la ventana abierta para otro registro nuevo.
- CANCELAR: Cancelar la operacion.

![Ventana Alta-Modificacion](Manual imagenes/Ventana AM.png)

## Control 'Custom select'

En algunos formularios se encontrara con el control 'custom select' (En este caso de 'Consignatario')

![Control custom select](Manual imagenes/custom select.png)

En el usted puede:
- Si lo sabe de memoria, puede **ingresar el codigo** del registro que desea y ahorrarse la busqueda manual. En este caso es '2' y el codigo que desee debe ingresarse **en el mismo lugar donde este se encuentra**.
- La lupa: Permite desplegar una **lista de los registros** (Consignatarios en este caso), **filtrarlos** con el campo que se encuentra sobre la lista e incluso agregar un registro en el acto con el boton **AGREGAR**.

![Control custom select listado](Manual imagenes/custom select list.png)

- La goma: Quitar del control el registro seleccionado, o en otras palabras, limpiar el campo.

- El ojo: Previsualizar el registro seleccionado.

## Control grilla

En algunos formularios se encontrara con el control grilla. Que permite agregar varios regitros a uno solo 'superior' (Por llamarlo de alguna manera).
En el ejemplo de la imagen vemos la grilla de categoria que permite cargar varias categorias al mismo DTE. A su ves vemos que en distintas pestañas tenemos las grillas de 'Numero de DTE', 'Insumos' e 'Impuestos'.

![Control grilla](Manual imagenes/grilla.png)

La grilla muestra un **listado de registros** ya cargados y a su ves permite: **Previsualizar** un registro cargado (Boton: lupa), **Agregar** un registro (Boton: mas), **Editar** un registro (Boton: Lapiz y papel) o **borrar** un registro (Boton: Tacho).

## FAENA

![faena](Manual imagenes/faena.png)

El campo **Tropa** no permitira cargar una tropa que no sea del productor seleccionado, es por esto que **debe cargar el campo Productor con anterioridad**.
Una ves seleccionada la tropa se le apareceran las categorias de la misma. Donde:
- El campo **Cantidad**: Indica la cantidad de la categoria dentro de la tropa.
- El campo **Faenado**: Indica la cantidad ya faenada.
- El campo **Dif** (Diferencia): Indica la cantidad que queda por faenar.
- El campo **A Faenar**: En este campo debera indicar que cantidad desea faenar y luego darle al boton **CARGAR**.
