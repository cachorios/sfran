package com.gmail.sanfrancisco.converter;

import com.vaadin.flow.data.binder.Result;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.converter.Converter;

import static com.gmail.sanfrancisco.converter.DataProviderUtil.convertIfNotNull;

public class DoubleConverter implements Converter<String, Double> {
    @Override
    public Result<Double> convertToModel(String s, ValueContext valueContext) {
        try{
            return Result.ok( Double.valueOf(s));
        }catch (NumberFormatException e) {
            return Result.error("Valor inválido");
        }
    }

    @Override
    public String convertToPresentation(Double modelValue, ValueContext valueContext) {
        return convertIfNotNull(modelValue, i -> i.toString(), () -> "");
    }
}
