package ch.alni.openapi.javagen.model;

import com.google.auto.value.AutoValue;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

/**
 * TODO: javadoc
 */
@AutoValue
@JsonDeserialize(builder = BodyParameter.Builder.class)
public abstract class BodyParameter {

    public static Builder builder() {
        return new AutoValue_BodyParameter.Builder();
    }

    @AutoValue.Builder
    @JsonPOJOBuilder(withPrefix = "")
    public abstract static class Builder {

        @JsonCreator
        static Builder create() {
            return builder();
        }

        public abstract BodyParameter build();
    }
}