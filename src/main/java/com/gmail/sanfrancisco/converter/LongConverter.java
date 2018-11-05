package com.gmail.sanfrancisco.converter;

import com.vaadin.flow.data.binder.Result;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.converter.Converter;

import static com.gmail.sanfrancisco.converter.DataProviderUtil.convertIfNotNull;

public class LongConverter implements Converter<String, Long> {
    @Override
    public Result<Long> convertToModel(String s, ValueContext valueContext) {
        try{
            return Result.ok(Long.valueOf(s));
        }catch (NumberFormatException e){
            return Result.error("Valor inválido");
        }
    }

    @Override
    public String convertToPresentation(Long aLong, ValueContext valueContext) {
        return convertIfNotNull(aLong, i -> i.toString(), () -> "");
    }
}
