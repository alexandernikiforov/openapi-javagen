package ch.alni.openapi.javagen.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Method {
    GET("get"),
    POST("post"),
    PUT("put"),
    DELETE("delete"),
    PATCH("patch");

    private final static Map<String, Method> VALUE_MAP =
            Stream.of(values()).collect(Collectors.toMap(Method::getValue, Function.identity()));

    private final String value;

    Method(String value) {
        this.value = value;
    }

    @JsonCreator
    public static Method fromValue(String value) {
        return Optional
                .ofNullable(VALUE_MAP.get(value))
                .orElseThrow(() -> new IllegalArgumentException("invalid value " + value));
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
