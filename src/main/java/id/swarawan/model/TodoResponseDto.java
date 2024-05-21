package id.swarawan.model;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;

import java.time.LocalDateTime;

@JsonbPropertyOrder({"id", "title", "content", "created_at", "updated_at"})
public class TodoResponseDto {

    @JsonbProperty("id")
    public Long id;

    @JsonbProperty("title")
    public String title;

    @JsonbProperty("content")
    public String content;

    @JsonbProperty("created_at")
    public LocalDateTime createdAt;

    @JsonbProperty("updated_at")
    public LocalDateTime updatedAt;
}
