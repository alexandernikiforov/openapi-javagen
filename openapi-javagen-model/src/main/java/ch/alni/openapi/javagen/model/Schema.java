package ch.alni.openapi.javagen.model;

import com.google.auto.value.AutoValue;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@AutoValue
@JsonDeserialize(builder = Schema.Builder.class)
public abstract class Schema {

    public static Builder builder() {
        return new AutoValue_Schema.Builder();
    }

    @JsonGetter("$ref")
    public abstract String reference();

    @AutoValue.Builder
    @JsonPOJOBuilder(withPrefix = "")
    public abstract static class Builder {

        @JsonCreator
        static Builder create() {
            return builder();
        }

        @JsonSetter("$ref")
        public abstract Builder reference(String value);

        public abstract Schema build();
    }
}