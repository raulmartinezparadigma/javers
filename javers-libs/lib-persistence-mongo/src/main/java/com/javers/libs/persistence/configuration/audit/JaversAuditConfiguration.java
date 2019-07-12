package com.javers.libs.persistence.configuration.audit;

import org.javers.spring.auditable.AuthorProvider;
import org.javers.spring.auditable.CommitPropertiesProvider;
import org.javers.spring.auditable.EmptyPropertiesProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class JaversAuditConfiguration {

    private static final String AUTHOR = "paradigma";

    /**
     * Modificar si se necesitara añadir properties fijas a cada commit de auditoría
     *
     * @return
     */
    @Bean
    public CommitPropertiesProvider createAuditCommitPropertiesProvider() {
        return new EmptyPropertiesProvider();
    }

    /**
     * Cuando añadamos con Spring Security habrá que integrarlo para asociar el autor
     *
     * @return
     * @see org.javers.spring.auditable.SpringSecurityAuthorProvider
     */
    @Bean
    @Primary
    public AuthorProvider createAuditAuthorProvider() {
        return new AuthorProvider() {
            @Override
            public String provide() {
                return AUTHOR;
            }
        };
    }

}
