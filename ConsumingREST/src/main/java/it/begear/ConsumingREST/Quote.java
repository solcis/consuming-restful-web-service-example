package it.begear.ConsumingREST;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// domain class
// to bind your data to your custom types -> variable name same as key in JSON returned from API
// if  variable name and key in JSON  don't match -> @JsonProperty annotation to specify exact key of JSON doc
// @JsonIgnoreProperties -> indicates that any properties not bound in this type should be ignored
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
	
	private String type;
    private Value value;

    public Quote() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }

}
