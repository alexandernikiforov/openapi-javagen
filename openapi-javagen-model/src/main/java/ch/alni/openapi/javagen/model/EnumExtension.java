package ch.alni.openapi.javagen.model;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableSet;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.Set;

@AutoValue
@JsonDeserialize(builder = EnumExtension.Builder.class)
public abstract class EnumExtension {
    public static EnumExtension.Builder builder() {
        return new AutoValue_EnumExtension.Builder()
                .modelAsString(false);
    }

    @JsonGetter
    public abstract String name();

    @JsonGetter
    public abstract boolean modelAsString();

    @JsonGetter
    public abstract ImmutableSet<EnumValue> values();

    @AutoValue.Builder
    @JsonPOJOBuilder(withPrefix = "")
    public abstract static class Builder {

        @JsonCreator
        static Builder create() {
            return EnumExtension.builder();
        }

        @JsonSetter
        public abstract Builder name(String value);

        @JsonSetter
        public abstract Builder modelAsString(boolean value);

        @JsonSetter
        public abstract Builder values(Set<EnumValue> values);

        public abstract EnumExtension build();
    }
}
