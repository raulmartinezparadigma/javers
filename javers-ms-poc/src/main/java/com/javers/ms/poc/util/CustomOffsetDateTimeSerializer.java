package com.javers.ms.poc.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class CustomOffsetDateTimeSerializer extends StdSerializer<OffsetDateTime> {
    private static final long serialVersionUID = -3227369507240888859L;

    public CustomOffsetDateTimeSerializer() {
        this((Class) null);
    }

    public CustomOffsetDateTimeSerializer(Class<OffsetDateTime> t) {
        super(t);
    }

    public void serialize(OffsetDateTime value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(value.format(DateTimeFormatter.ISO_DATE_TIME));
    }
}
