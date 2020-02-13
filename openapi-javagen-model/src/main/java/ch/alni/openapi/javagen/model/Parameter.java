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
@JsonDeserialize(builder = Parameter.Builder.class)
public abstract class Parameter {

    public static Builder builder() {
        return new AutoValue_Parameter.Builder()
                .required(false)
                .allowEmptyValue(false)
                ;
    }

    @JsonGetter
    public abstract String name();

    @JsonGetter
    public abstract ParameterLocation in();

    @JsonGetter
    public abstract boolean required();

    @JsonGetter
    @Nullable
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public abstract Schema schema();

    @JsonGetter
    public abstract boolean allowEmptyValue();

    @JsonGetter
    @Nullable
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public abstract Type type();

    @JsonGetter
    public abstract String format();

    @JsonGetter("default")
    @Nullable
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public abstract Object defaultValue();

    @JsonGetter
    @Nullable
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public abstract String description();

    @AutoValue.Builder
    @JsonPOJOBuilder(withPrefix = "")
    public abstract static class Builder {

        @JsonCreator
        static Builder create() {
            return builder();
        }

        @JsonSetter
        public abstract Builder name(String value);

        @JsonSetter
        public abstract Builder in(ParameterLocation value);

        @JsonSetter
        public abstract Builder schema(Schema value);

        @JsonSetter
        public abstract Builder required(boolean value);

        @JsonSetter
        public abstract Builder allowEmptyValue(boolean value);

        @JsonSetter("default")
        public abstract Builder defaultValue(Object value);

        @JsonSetter
        public abstract Builder type(Type value);

        @JsonSetter
        public abstract Builder format(String value);

        @JsonSetter
        public abstract Builder description(String value);

        public abstract Parameter build();
    }
}