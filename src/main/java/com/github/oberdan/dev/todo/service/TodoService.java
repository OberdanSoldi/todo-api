package com.github.oberdan.dev.todo.service;

import com.github.oberdan.dev.todo.entity.Todo;
import com.github.oberdan.dev.todo.exceptions.TodoNotFoundException;
import com.github.oberdan.dev.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> getByUserId(Long userId) {
        List<Todo> todos = todoRepository.findByUserIdOrElseThrow(userId);

        if(!todos.isEmpty()){
            return todos;
        }

        throw new TodoNotFoundException();
    }

    public void deleteById(Long id) {
        todoRepository.findById(id).map(todo -> {
            todoRepository.deleteById(todo.getId());
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
