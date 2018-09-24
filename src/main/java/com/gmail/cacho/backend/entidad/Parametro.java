package com.gmail.cacho.backend.entidad;

import com.gmail.cacho.backend.enumeradores.ETipoParametro;
import com.gmail.cacho.slapi.comunes.C;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Esta clase representa a un Parametro del sistema y contiene, ademas de un conjunto de campos para guardar
 * valores de distinto tipo: double, long, booelan, Timestamp, etc. Los parámetros tiene un Tipo basado en la
 * enumeracion ETipoParametro.
 *
 * @author jmfragueiro
 * @version 20161011
 * @see ETipoParametro
 */
@Entity
public class Parametro extends AbstractEntidad {
    public static final String F_PAR_TIPO = "Tipo";
    public static final String F_PAR_CLASE = "Clase";
    public static final String F_PAR_ORDEN = "Orden";
    public static final String F_PAR_NOMBRE = "Nombre";
    public static final String F_PAR_VALORINT = "Valor Entero";
    public static final String F_PAR_VALORDOB = "Valor Decimal";
    public static final String F_PAR_VALORSTR = "Valor Cadena";
    public static final String F_PAR_VALORBOL = "Valor Booleano";
    public static final String F_PAR_VALORDAT = "Valor Fecha";
    public static final String F_PAR_VALORCHR = "Valor Caracter";

    @Enumerated
    @Column(columnDefinition = "smallint default 0")
    @NotNull(message = C.MSJ_ERR_DB_FIELD_EMPTY + F_PAR_TIPO)
    private ETipoParametro tipo;

    @NotNull(message = C.MSJ_ERR_DB_FIELD_EMPTY + F_PAR_CLASE)
    @Size(min = 4, max = 32, message = C.MSJ_ERR_DB_FIELD_LONGNOK + F_PAR_CLASE)
    private String clase;

    @NotNull(message = C.MSJ_ERR_DB_FIELD_EMPTY + F_PAR_ORDEN)
    private Integer orden;

    @NotNull(message = C.MSJ_ERR_DB_FIELD_EMPTY + F_PAR_NOMBRE)
    @Size(min = 4, max = 32, message = C.MSJ_ERR_DB_FIELD_LONGNOK + F_PAR_NOMBRE)
    private String nombre;

    private Long valorint;

    private Double valordob;

    @Size(max = 255, message = C.MSJ_ERR_DB_FIELD_LONGNOK + F_PAR_VALORSTR)
    private String valorstr;

    @Column(columnDefinition = "boolean default false")
    @NotNull(message = C.MSJ_ERR_DB_FIELD_EMPTY + F_PAR_VALORBOL)
    private Boolean valorbol;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date valordat;

    private String  valorchr;

    public Parametro() {
        super();
    }

    public Parametro(ETipoParametro tipo, String clase, Integer orden, String nombre, Long valorint, Double valordob,
                     String valorstr, Boolean valorbol, Date valordat, String valorchr) {
        this();
        this.tipo = tipo;
        this.clase = clase;
        this.orden = orden;
        this.nombre = nombre;
        this.valorint = valorint;
        this.valordob = valordob;
        this.valorstr = valorstr;
        this.valorbol = valorbol;
        this.valordat = valordat;
        this.valorchr = valorchr;
    }

    public ETipoParametro getTipo() {
        return tipo;
    }

    public void setTipo(ETipoParametro tipo) {
        this.tipo = tipo;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getValorint() {
        return valorint;
    }

    public void setValorint(Long valorint) {
        this.valorint = valorint;
    }

    public Double getValordob() {
        return valordob;
    }

    public void setValordob(Double valordob) {
        this.valordob = valordob;
    }

    public String getValorstr() {
        return valorstr;
    }

    public void setValorstr(String valorstr) {
        this.valorstr = valorstr;
    }

    public Boolean getValorbol() {
        return valorbol;
    }

    public void setValorbol(Boolean valorbol) {
        this.valorbol = valorbol;
    }

    public Date getValordat() {
        return valordat;
    }

    public void setValordat(Date valordat) {
        this.valordat = valordat;
    }

    public String getValorchr() {
        return valorchr;
    }

    public void setValorchr(String valorchr) {
        this.valorchr = valorchr;
    }

    @Override
    public String toString() {
        return this.nombre;
       // return (tipo.name().concat(C.SYS_CAD_LOGSEP).concat(clase));
    }
}
