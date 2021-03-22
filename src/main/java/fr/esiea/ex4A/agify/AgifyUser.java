package fr.esiea.ex4A.agify;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class AgifyUser {
    @JsonPropertyOrder({
        "name",
        "age",
        "count",
        "country_id"
    })
        @JsonProperty("name")
        private String name;
        @JsonProperty("age")
        private Integer age;
        @JsonProperty("count")
        private Integer count;
        @JsonProperty("country_id")
        private String countryId;

    @JsonProperty("name")
        public String getName() {
            return name;
        }


        @JsonProperty("age")
        public Integer getAge() {
            return age;
        }


        @JsonProperty("count")
        public Integer getCount() {
            return count;
        }


        @JsonProperty("country_id")
        public String getCountryId() {
            return countryId;
        }

}
