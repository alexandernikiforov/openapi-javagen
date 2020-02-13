package ch.alni.openapi.javagen.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Type {
    INTEGER("integer"),
    NUMBER("number"),
    STRING("string"),
    BOOLEAN("boolean"),
    FILE("file"),
    ARRAY("array");

    private final static Map<String, Type> VALUE_MAP =
            Stream.of(values()).collect(Collectors.toMap(Type::getValue, Function.identity()));

    private final String value;

    Type(String value) {
        this.value = value;
    }

    @JsonCreator
    public static Type fromValue(String value) {
        return Optional
                .ofNullable(VALUE_MAP.get(value))
                .orElseThrow(() -> new IllegalArgumentException("invalid value " + value));
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
