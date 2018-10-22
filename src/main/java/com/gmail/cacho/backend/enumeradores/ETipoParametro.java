package com.gmail.cacho.backend.enumeradores;

/**
 * ETipoParametro es una enumeracion que contiene los distintas tipos de parametros que pueden existir
 * y persistir dentro de un sistema hecho par el framework. Esta enumeracion deberia ser utilizada dentro
 * de la clase parametro para establecer su tipo (por ejemplo: RECURSO, MENU, etc.).
 *
 * @author jmfragueiro
 * @version 20161011
 */
public enum ETipoParametro {
    NINGUNO,            //0
    RECURSO,            //1
    MENU,               //2
    CONFIG,             //3
    SEXO,               //4
    GRUPO_SANGUINEO,    //5
    LIBRE,              //6
    TIPO_DOC,           //7
    CATEGORIA_ANIMAL,   //8
    PROVINCIA,          //9
    LOCALIDAD,          //10
    LIBRE2,             //11
    COLOR,              //12
    CONDICION_IVA,      //13
    ESTADO_VEHICULO,    //14
    MARCA_VEHICUO,      //15
    OPERADORA_TEL,      //16
    TIPO_COMBUSTIBLE,   //17
    TIPO_INSUMO,        //18
    TIPO_VEHICULO,      //19
    IMPUESTO,           //20
    ESPECIES,           //21
    TIPO_LICENCIA,      //22
}
