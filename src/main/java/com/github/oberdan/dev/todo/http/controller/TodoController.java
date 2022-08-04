package com.github.oberdan.dev.todo.http.controller;

import com.github.oberdan.dev.todo.entity.Todo;
import com.github.oberdan.dev.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/todo")
public class TodoController {
    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<Todo> save(Todo todo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.save(todo));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Todo>> getByUserId(@PathVariable("userId") Long id) {
        return ResponseEntity.ok(todoService.getByUserId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        todoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
