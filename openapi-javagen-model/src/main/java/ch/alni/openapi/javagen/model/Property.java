package ch.alni.openapi.javagen.model;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableSet;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import org.jetbrains.annotations.Nullable;

import java.util.Set;

@AutoValue
@JsonDeserialize(builder = Property.Builder.class)
public abstract class Property {
    public static Builder builder() {
        return new AutoValue_Property.Builder()
                .enumeration(ImmutableSet.of());
    }

    @JsonGetter
    @Nullable
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public abstract String title();

    @JsonGetter
    @Nullable
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public abstract String description();

    @JsonGetter
    @Nullable
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public abstract Type type();

    @JsonGetter("$ref")
    @Nullable
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public abstract String reference();

    @JsonGetter
    @Nullable
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public abstract String format();

    @JsonGetter("enum")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public abstract ImmutableSet<String> enumeration();

    @JsonGetter("x-ms-enum")
    @Nullable
    public abstract EnumExtension enumerationExtension();

    @AutoValue.Builder
    @JsonPOJOBuilder(withPrefix = "")
    public abstract static class Builder {
        @JsonCreator
        static Builder create() {
            return Property.builder();
        }

        @JsonSetter
        public abstract Builder title(String value);

        @JsonSetter
        public abstract Builder description(String value);

        @JsonSetter
        public abstract Builder type(Type value);

        @JsonSetter("$ref")
        public abstract Builder reference(String value);

        @JsonSetter
        public abstract Builder format(String value);

        @JsonSetter("enum")
        public abstract Builder enumeration(Set<String> values);

        @JsonSetter("x-ms-enum")
        public abstract Builder enumerationExtension(EnumExtension value);

        public abstract Property build();
    }

}
