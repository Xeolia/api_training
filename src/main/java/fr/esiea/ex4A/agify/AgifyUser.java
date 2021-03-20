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

        @JsonProperty("name")
        public void setName(String name) {
            this.name = name;
        }

        @JsonProperty("age")
        public Integer getAge() {
            return age;
        }

        @JsonProperty("age")
        public void setAge(Integer age) {
            this.age = age;
        }

        @JsonProperty("count")
        public Integer getCount() {
            return count;
        }

        @JsonProperty("count")
        public void setCount(Integer count) {
            this.count = count;
        }

        @JsonProperty("country_id")
        public String getCountryId() {
            return countryId;
        }

        @JsonProperty("country_id")
        public void setCountryId(String countryId) {
            this.countryId = countryId;
        }
}
