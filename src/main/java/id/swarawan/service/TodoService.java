package id.swarawan.service;

import id.swarawan.database.entity.Todo;
import id.swarawan.database.repository.TodoRepository;
import id.swarawan.model.TodoRequestDto;
import id.swarawan.model.TodoResponseDto;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class TodoService {

    @Inject
    TodoRepository todoRepository;

    public List<TodoResponseDto> findAll() {
        return todoRepository.findAll().stream()
                .map(this::convertDto)
                .collect(Collectors.toList());
    }

    public TodoResponseDto findById(Long id) {
        return todoRepository.findByIdOptional(id)
                .map(this::convertDto)
                .orElseThrow(RuntimeException::new);
    }

    @Transactional
    public TodoResponseDto save(TodoRequestDto data) {
        todoRepository.findByTitleOptional(data.title).ifPresent(existingData -> {
            throw new RuntimeException();
        });

        Todo todo = new Todo();
        todo.title = data.title;
        todo.content = data.content;
        todoRepository.persistAndFlush(todo);
        return convertDto(todo);
    }

    @Transactional
    public TodoResponseDto update(long id, TodoRequestDto data) {
        return todoRepository.findByIdOptional(id)
                .map(todo -> {
                    todo.title = data.title;
                    todo.content = data.content;
                    todoRepository.persistAndFlush(todo);
                    return convertDto(todo);
                }).orElseThrow(RuntimeException::new);
    }

    @Transactional
    public TodoResponseDto updatePatch(long id, TodoRequestDto data) {
        return todoRepository.findByIdOptional(id)
                .map(todo -> {
                    todo.title = data.title != null ? data.title : todo.title;
                    todo.content = data.content != null ? data.content : todo.content;
                    todoRepository.persistAndFlush(todo);
                    return convertDto(todo);
                }).orElseThrow(RuntimeException::new);
    }

    @Transactional
    public void delete(long id) {
        todoRepository.deleteById(id);
    }

    private TodoResponseDto convertDto(Todo data) {
        TodoResponseDto dto = new TodoResponseDto();
        dto.id = data.id;
        dto.title = data.title;
        dto.content = data.content;
        dto.createdAt = data.createdAt;
        dto.updatedAt = data.updatedAt;
        return dto;
    }
}
