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

import java.util.Map;
import java.util.Set;

@AutoValue
@JsonDeserialize(builder = ApiDefinition.Builder.class)
public abstract class ApiDefinition {
    public static Builder builder() {
        return new AutoValue_ApiDefinition.Builder()
                .definitions(ImmutableMap.of());
    }

    @JsonGetter
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public abstract ImmutableMap<String, Definition> definitions();

    @JsonGetter
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public abstract ImmutableSet<String> consumes();

    @JsonGetter
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public abstract ImmutableSet<String> produces();

    @AutoValue.Builder
    @JsonPOJOBuilder(withPrefix = "")
    public abstract static class Builder {

        @JsonCreator
        static Builder create() {
            return builder();
        }

        @JsonSetter
        public abstract Builder definitions(Map<String, Definition> values);

        @JsonSetter
        public abstract Builder consumes(Set<String> values);

        @JsonSetter
        public abstract Builder produces(Set<String> values);

        public abstract ApiDefinition build();
    }
}
