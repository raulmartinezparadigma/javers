package com.javers.libs.persistence.configuration.converter;

import java.time.OffsetDateTime;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * @author Arnaldo Trujillo
 */
public class OffsetDateTimeWriteConverter implements Converter<OffsetDateTime, Date> {

    @Override
    public Date convert(OffsetDateTime offsetDateTime) {
        return Date.from(offsetDateTime.toInstant());
    }
}
