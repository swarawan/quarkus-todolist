package id.swarawan.model;

import jakarta.json.bind.annotation.JsonbNillable;
import jakarta.json.bind.annotation.JsonbProperty;

@JsonbNillable(value = false)
public class TodoRequestDto {
    @JsonbProperty("title")
    public String title;

    @JsonbProperty("content")
    public String content;
}
