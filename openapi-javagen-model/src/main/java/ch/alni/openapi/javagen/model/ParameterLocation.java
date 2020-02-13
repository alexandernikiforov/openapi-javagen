package ch.alni.openapi.javagen.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ParameterLocation {
    QUERY("query"),
    BODY("body"),
    HEADER("header"),
    FORM_DATA("formData"),
    PATH("path");

    private final static Map<String, ParameterLocation> VALUE_MAP =
            Stream.of(values()).collect(Collectors.toMap(ParameterLocation::getValue, Function.identity()));

    private final String value;

    ParameterLocation(String value) {
        this.value = value;
    }

    @JsonCreator
    public static ParameterLocation fromValue(String value) {
        return Optional
                .ofNullable(VALUE_MAP.get(value))
                .orElseThrow(() -> new IllegalArgumentException("invalid value " + value));
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
