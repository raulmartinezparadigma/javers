package com.javers.ms.poc;

import com.javers.libs.persistence.configuration.PersistenceMongoConfigurator;
import com.javers.libs.persistence.configuration.audit.JaversAuditConfiguration;
import com.javers.ms.poc.configuration.PocConfigurator;
import com.satelite.libs.commons.http.logging.HttpLogbookConfigurator;
import com.satelite.spring.libs.extender.params.configuration.RequestParamExtenderConfigurator;
import org.javers.spring.boot.mongo.JaversMongoAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * Aplicación Spring boot para arrancar.
 * <p>
 * Cargaremos la auto configuración añadiendo los xml por convención que correspondan
 * <p>
 * Notas:<br/>
 * - Si el MS no tiene autenticación JWT, quitar SecurityConfigurator.class del import y excluir SecurityAutoConfiguration.class de la autoconfiguración
 */
@EnableAutoConfiguration
@Import({PocConfigurator.class, HttpLogbookConfigurator.class, RequestParamExtenderConfigurator.class, PersistenceMongoConfigurator.class, JaversMongoAutoConfiguration.class, JaversAuditConfiguration.class})
public class PocApplication {

    public static void main(String[] args) {
        SpringApplication.run(PocApplication.class, args);
    }

}
