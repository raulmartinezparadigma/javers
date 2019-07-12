package com.javers.libs.persistence.configuration;

import com.javers.libs.persistence.configuration.converter.OffsetDateTimeWriteConverter;
import com.javers.libs.persistence.configuration.converter.OffsetDateTimeReadConverter;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.CustomConversions;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Leemos la configración de spring para esta librería
 */
@Configuration
@ComponentScan("com.javers.libs.persistence")
@EnableMongoRepositories(basePackages = {"com.javers.libs.persistence.toy.repository"}) //@on
public class PersistenceMongoConfigurator extends AbstractMongoConfiguration {

    private static final String MONGO_REQUIRED_URI_MSG = "No se han configurado la URL de conexión de la Mongo";

    private final List<Converter<?, ?>> converters = new ArrayList<Converter<?, ?>>(2);

    @Autowired
    private MongoProperties mongoProperties;

    @Override
    @Bean
    public MongoClient mongoClient() {
        return Optional.ofNullable(mongoProperties)
                .filter(mongoConfig -> Objects.nonNull(mongoConfig.getUri()))
                .map(MongoProperties::getUri)
                .map(MongoClientURI::new)
                .map(MongoClient::new)
                .orElseThrow(() -> new IllegalStateException(MONGO_REQUIRED_URI_MSG));
    }

    @Override
    protected String getDatabaseName() {
        return Optional.ofNullable(mongoProperties)
                .filter(mongoConfig -> Objects.nonNull(mongoConfig.getUri()))
                .map(MongoProperties::getUri)
                .map(MongoClientURI::new)
                .map(MongoClientURI::getDatabase)
                .orElseThrow(() -> new IllegalStateException(MONGO_REQUIRED_URI_MSG));
    }

    @Override
    public CustomConversions customConversions() {
        converters.add(new OffsetDateTimeReadConverter());
        converters.add(new OffsetDateTimeWriteConverter());

        return new MongoCustomConversions(converters);
    }
}
