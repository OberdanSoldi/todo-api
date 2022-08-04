package com.github.oberdan.dev.todo.repository;

import com.github.oberdan.dev.todo.entity.Todo;
import com.github.oberdan.dev.todo.exceptions.TodoNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    Optional<List<Todo>> findByUserId(Long userId);

    default List<Todo> findByUserIdOrElseThrow(Long userId) {
        return findByUserId(userId).orElseThrow(TodoNotFoundException::new);
    }
}
