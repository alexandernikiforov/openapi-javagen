package ch.alni.openapi.javagen.model;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;


public class ApiDefinitionTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void definitions() throws IOException {

        final String apiAsJson = IOUtils.toString(
                getClass().getResourceAsStream("/batch-service-api.json"),
                StandardCharsets.UTF_8
        );

        final ApiDefinition apiDefinition = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .readValue(apiAsJson, ApiDefinition.class);

        assertThat(apiDefinition).isNotNull();
    }
}