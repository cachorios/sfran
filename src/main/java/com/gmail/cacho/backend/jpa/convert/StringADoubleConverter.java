package com.gmail.cacho.backend.jpa.convert;


import com.gmail.cacho.slbase.core.Constantes;
import com.vaadin.flow.data.binder.Result;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.converter.Converter;

public class StringADoubleConverter implements Converter<String, Double> {
    @Override
    public Result<Double> convertToModel(String valor, ValueContext valueContext) {
        try {
            return Result.ok(((valor == null) ? null : Double.valueOf(valor)));
        } catch (NumberFormatException e) {
            return Result.error(Constantes.MSJ_ERR_DB_ATCONVERTDATA.concat(Constantes.MSJ_ERR_DB_NEEDDOUBLE));
        }
    }

    @Override
    public String convertToPresentation(Double valor, ValueContext valueContext) {
        return (valor == null ? "" : String.valueOf(valor));
    }
}
