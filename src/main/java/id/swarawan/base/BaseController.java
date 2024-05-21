package id.swarawan.base;

import id.swarawan.model.BaseResponseDto;

public class BaseController {

    protected <T> BaseResponseDto<T> generateResponse(T data) {
        return generateResponse(data, "Success");
    }

    protected <T> BaseResponseDto<T> generateResponse(String message) {
        return generateResponse(null, message);
    }

    protected <T> BaseResponseDto<T> generateResponse(T data, String message) {
        BaseResponseDto<T> response = new BaseResponseDto<>();
        response.success = true;
        response.data = data;
        response.message = message;
        return response;
    }
}
