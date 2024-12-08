package org.javaApp.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDTO {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("price")
    private Double price;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
    }
}

/*
The @JsonProperty annotation from the Jackson library is used to specify how a property in a Java class maps to a JSON key during serialization (Java object → JSON) and deserialization (JSON → Java object).

Key Functions of @JsonProperty
Serialization: It ensures that Jackson includes the annotated field when converting a Java object to JSON.
Deserialization: It maps a JSON key to the annotated field when converting JSON back to a Java object.
By default, Jackson uses JavaBean-style getters and setters to detect properties for serialization and deserialization. If for some reason it doesn't detect the fields (due to misconfigurations, Lombok-generated methods, or private visibility), @JsonProperty explicitly tells Jackson to consider the field.

Why Was It Necessary Here?
In your case:

Lombok's @Data generates getters and setters at compile time. Jackson usually detects them, but sometimes issues like conflicts or visibility restrictions may cause Jackson to skip fields.
No Explicit Getters/Setters: If Jackson couldn't automatically infer the fields from your class structure, the fields were ignored during serialization, leading to empty JSON objects ({}).
Fix with @JsonProperty: By adding @JsonProperty, you explicitly instructed Jackson to include these fields during serialization/deserialization, bypassing any detection issues.
*/
