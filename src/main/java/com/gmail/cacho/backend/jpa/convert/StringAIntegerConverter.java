package com.gmail.cacho.backend.jpa.convert;


import com.gmail.cacho.slbase.core.Constantes;
import com.vaadin.flow.data.binder.Result;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.converter.Converter;


public class StringAIntegerConverter implements Converter<String, Integer> {
    @Override
    public Result<Integer> convertToModel(String s, ValueContext valueContext) {
        try {
            return Result.ok(((s == null || s.isEmpty()) ? null : Integer.valueOf(s)));
        } catch (NumberFormatException e) {
            return Result.error(Constantes.MSJ_ERR_DB_ATCONVERTDATA.concat(Constantes.MSJ_ERR_DB_NEEDINTEGER));
        }

    }

    @Override
    public String convertToPresentation(Integer integer, ValueContext valueContext) {
        return (integer == null ? "" : String.valueOf(integer));
    }
}
