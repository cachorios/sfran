package com.gmail.sanfrancisco.converter;

import com.gmail.cacho.slbase.core.Constantes;
import com.vaadin.flow.data.binder.Result;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.converter.Converter;

import static com.gmail.sanfrancisco.converter.DataProviderUtil.convertIfNotNull;

public class LongConverter implements Converter<String, Long> {
    @Override
    public Result<Long> convertToModel(String s, ValueContext valueContext) {
        try {
            return Result.ok(((s == null || s.isEmpty()) ? null : Long.valueOf(s)));
        } catch (NumberFormatException e) {
            return Result.error(Constantes.MSJ_ERR_DB_ATCONVERTDATA.concat(Constantes.MSJ_ERR_DB_NEEDINTEGER));
        }
    }

    @Override
    public String convertToPresentation(Long aLong, ValueContext valueContext) {
        return convertIfNotNull(aLong, i -> i.toString(), () -> "");
    }
}
