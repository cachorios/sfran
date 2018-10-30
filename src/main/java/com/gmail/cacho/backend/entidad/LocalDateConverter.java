//package com.gmail.cacho.backend.entidad;
//
//import javax.persistence.AttributeConverter;
//import javax.persistence.Converter;
//import java.sql.Date;
//import java.time.LocalDate;
//
//@Converter(autoApply = true)
//public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {
//// also ZonedDateTimeConverter and InstantConverter
//
//    @Override
//    public Date convertToDatabaseColumn(LocalDate localDate) {
//        return localDate != null ? Date.valueOf(localDate) : null;
//    }
//
//    @Override
//    public LocalDate convertToEntityAttribute(Date date) {
//        return date != null ? date.toLocalDate() : null;
//    }
//}