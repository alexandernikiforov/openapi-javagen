package ch.alni.openapi.javagen.model;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Set;

@AutoValue
@JsonDeserialize(builder = Definition.Builder.class)
public abstract class Definition {

    public static Builder builder() {
        return new AutoValue_Definition.Builder()
                .required(ImmutableSet.of());
    }

    @JsonGetter
    public abstract ImmutableMap<String, Property> properties();

    @Nullable
    @JsonGetter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public abstract String title();

    @JsonGetter
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public abstract ImmutableSet<String> required();

    @AutoValue.Builder
    @JsonPOJOBuilder(withPrefix = "")
    public abstract static class Builder {

        @JsonCreator
        static Builder create() {
            return Definition.builder();
        }

        abstract ImmutableMap.Builder<String, Property> propertiesBuilder();

        public Builder property(String name, Property property) {
            propertiesBuilder().put(name, property);
            return this;
        }

        abstract ImmutableSet.Builder<String> requiredBuilder();

        public Builder required(String value) {
            requiredBuilder().add(value);
            return this;
        }

        @JsonSetter
        public abstract Builder properties(Map<String, Property> value);

        @JsonSetter
        public abstract Builder required(Set<String> value);

        @JsonSetter
        public abstract Builder title(String value);

        public abstract Definition build();
    }

}
