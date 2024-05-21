package id.swarawan.controller;

import id.swarawan.base.BaseController;
import id.swarawan.model.BaseResponseDto;
import id.swarawan.model.TodoRequestDto;
import id.swarawan.model.TodoResponseDto;
import id.swarawan.service.TodoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/todo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoResource extends BaseController {

    @Inject
    TodoService todoService;

    @GET
    public BaseResponseDto<List<TodoResponseDto>> getAllTodo() {
        List<TodoResponseDto> data = todoService.findAll();
        return generateResponse(data, "Data fetched successfully");
    }

    @GET
    @Path("{id}")
    public BaseResponseDto<TodoResponseDto> findById(@PathParam("id") Long id) {
        TodoResponseDto data = todoService.findById(id);
        return generateResponse(data, "Data fetched successfully");
    }

    @POST
    public BaseResponseDto<TodoResponseDto> save(TodoRequestDto request) {
        TodoResponseDto data = todoService.save(request);
        return generateResponse(data, "Data saved successfully");
    }

    @PUT
    @Path("{id}")
    public BaseResponseDto<TodoResponseDto> update(@PathParam("id") Long id,
                                                   TodoRequestDto request) {
        TodoResponseDto data = todoService.update(id, request);
        return generateResponse(data, "Data updated successfully");
    }

    @PATCH
    @Path("{id}")
    public BaseResponseDto<TodoResponseDto> updatePatch(@PathParam("id") Long id,
                                                        TodoRequestDto request) {
        TodoResponseDto data = todoService.updatePatch(id, request);
        return generateResponse(data, "Data updated successfully");
    }

    @DELETE
    @Path("{id}")
    public BaseResponseDto<TodoResponseDto> delete(@PathParam("id") Long id) {
        todoService.delete(id);
        return generateResponse("Data deleted successfully");
    }
}
