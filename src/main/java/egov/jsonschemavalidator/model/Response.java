package egov.jsonschemavalidator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Response {
    @JsonProperty("is_valid")
    Boolean is_valid;

    @JsonProperty("message")
    String message;

}
