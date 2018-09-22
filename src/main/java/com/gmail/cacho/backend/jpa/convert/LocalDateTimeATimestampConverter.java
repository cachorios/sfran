package com.gmail.cacho.backend.jpa.convert;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * JPA no conoce como manejar el tipo Java 8 "java.time.LocalDateTime" asi que esta clase "se supone"
 * que convierte LocalDateTime a un formato que JPA pueda manejar, para lo que implementa la interfaz
 * AttributeConverter (NOTA: por ahora no esta funcionando). Se supone que dicha interfaz parmetrica
 * recibe como parametros de clase los dos tipos entre los que debe convertir.
 *
 * @author jmfragueiro
 * @version 20161011
 */
@Converter(autoApply = true)
public class LocalDateTimeATimestampConverter implements AttributeConverter<LocalDateTime, Timestamp> {
    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime attribute) {
        return ((attribute != null) ? Timestamp.valueOf(attribute) : null);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp dbData) {
        return ((dbData != null) ? dbData.toLocalDateTime() : null);
    }
}
