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
    NINGUNO,        //0
    RECURSO,        //1
    MENU,           //2
    CONFIG,         //3
    SEXO,           //4
    GRUPO_SANGUINEO,//5
    OPERADORA_TEL,  //6
    TIPO_DOC,       //7
    COLOR,          //8
    PROVINCIA,      //9
    LOCALIDAD,      //10
    ESPECIES,       //11

}
