package com.gmail.cacho.backend.jpa.convert;


import com.gmail.cacho.slbase.core.Constantes;
import com.gmail.cacho.slbase.core.Fecha;
import com.vaadin.flow.data.binder.Result;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.converter.Converter;

import java.time.LocalDate;
import java.util.Date;

public class LocalDateADateConverter implements Converter<LocalDate, Date> {
    @Override
    public Result<Date> convertToModel(LocalDate localDate, ValueContext valueContext) {
        try {
            return Result.ok(Fecha.toDate(localDate));
        } catch (NumberFormatException e) {
            return Result.error(Constantes.MSJ_ERR_DB_ATCONVERTDATA.concat(Constantes.MSJ_ERR_DB_NEEDDATE));
        }
    }

    @Override
    public LocalDate convertToPresentation(Date date, ValueContext valueContext) {
        return Fecha.toLocalDate(date);
    }
}
