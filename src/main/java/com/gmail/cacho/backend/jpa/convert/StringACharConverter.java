package com.gmail.cacho.backend.jpa.convert;



import com.gmail.cacho.slbase.core.Constantes;
import com.vaadin.flow.data.binder.Result;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.converter.Converter;


public class StringACharConverter implements Converter<String, Character> {
    @Override
    public Result<Character> convertToModel(String s, ValueContext valueContext) {
        try{
            return Result.ok(((s == null || s.isEmpty()) ? null : s.charAt(0)));
        }catch (NumberFormatException e){
            return Result.error(Constantes.MSJ_ERR_DB_ATCONVERTDATA.concat(Constantes.MSJ_ERR_DB_NEEDINTEGER));
        }

    }

    @Override
    public String convertToPresentation(Character caracter, ValueContext valueContext) {
        return (caracter == null ? "" :  String.valueOf(caracter));
    }
}
