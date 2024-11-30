package org.javaApp.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor(force = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

@Getter
public class ErrorResponse {
    @JsonProperty("message")
    private final String message;

    //can make this big or small depeneing on the needs
    public ErrorResponse(String message) {
        this.message = message;
    }

}
