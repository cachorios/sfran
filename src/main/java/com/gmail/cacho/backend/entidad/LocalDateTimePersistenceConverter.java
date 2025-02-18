//package com.gmail.cacho.backend.entidad;
//
//import javax.persistence.AttributeConverter;
//import javax.persistence.Converter;
//import java.sql.Timestamp;
//import java.time.LocalDateTime;
//
//@Converter(autoApply = true)
//public class LocalDateTimePersistenceConverter implements AttributeConverter<LocalDateTime, Timestamp> {
//
//    @Override
//    public Timestamp convertToDatabaseColumn(LocalDateTime locDate) {
//        if (locDate != null) {
//
//            return Timestamp.valueOf(locDate);
//        } else {
//            return null;
//        }
//    }
//
//    @Override
//    public LocalDateTime convertToEntityAttribute(Timestamp sqlTimestamp) {
//
//        if (sqlTimestamp != null) {
//            return sqlTimestamp.toLocalDateTime();
//        } else {
//            return null;
//        }
//    }
//}