package id.swarawan.model;

import jakarta.json.bind.annotation.JsonbNillable;
import jakarta.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder({"success", "message", "data"})
@JsonbNillable(value = false)
public class BaseResponseDto<T> {
    public boolean success;
    public String message;
    public T data;
}
