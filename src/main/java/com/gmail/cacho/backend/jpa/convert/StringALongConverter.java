package com.gmail.cacho.backend.jpa.convert;



import com.gmail.cacho.slbase.core.Constantes;
import com.vaadin.flow.data.binder.Result;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.converter.Converter;

public class StringALongConverter implements Converter<String, Long> {
    @Override
    public Result<Long> convertToModel(String s, ValueContext valueContext) {
        try {
            return Result.ok(((s == null || s.isEmpty()) ? null : Long.valueOf(s)));
        } catch (NumberFormatException e) {
            return Result.error(Constantes.MSJ_ERR_DB_ATCONVERTDATA.concat(Constantes.MSJ_ERR_DB_NEEDINTEGER));
        }

    }

    @Override
    public String convertToPresentation(Long largo, ValueContext valueContext) {
        return (largo == null ? "" : String.valueOf(largo));
    }
}
