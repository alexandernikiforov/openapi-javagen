package ch.alni.openapi.javagen.model;

import com.google.auto.value.AutoValue;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import org.jetbrains.annotations.Nullable;

@AutoValue
@JsonDeserialize(builder = EnumValue.Builder.class)
public abstract class EnumValue {
    public static Builder builder() {
        return new AutoValue_EnumValue.Builder();
    }

    @JsonGetter
    public abstract String value();

    @JsonGetter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Nullable
    public abstract String description();

    @AutoValue.Builder
    @JsonPOJOBuilder(withPrefix = "")
    public abstract static class Builder {

        @JsonCreator
        static Builder create() {
            return EnumValue.builder();
        }

        @JsonSetter
        public abstract Builder value(String value);

        @JsonSetter
        public abstract Builder description(String value);

        public abstract EnumValue build();
    }
}
