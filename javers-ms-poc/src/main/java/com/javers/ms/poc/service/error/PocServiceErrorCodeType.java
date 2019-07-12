package com.javers.ms.poc.service.error;

import com.satelite.libs.commonstestbase.coverage.GenerateCoverage;

/**
 * Códigos de error semánticos para el manejo dentro de las aplicaciones. <br/>
 * Cada elemento del enumerado tendrá su mapeo en el fichero custom_errors_ms_poc.yml, donde se definirá mensaje y código http que devuelve el servicio para
 * dicho error.
 */
@GenerateCoverage
public enum PocServiceErrorCodeType {

    MS_SAMPLE_ERROR_SPECIAL_VALUE_SAMPLE;

}
