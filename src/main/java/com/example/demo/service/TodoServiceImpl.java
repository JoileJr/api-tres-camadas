package com.example.demo.service;

import com.example.demo.dto.TodoDTO;
import com.example.demo.model.Todo;
import com.example.demo.repository.TodoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final ObjectMapper objectMapper;

    @Override
    public TodoDTO create(TodoDTO todoDTO) {
        Todo newTodo = Todo.builder()
                .item(todoDTO != null && todoDTO.getItem() != null ? todoDTO.getItem() : "")
                .build();
        todoRepository.save(newTodo);
        return objectMapper.convertValue(newTodo, TodoDTO.class);
    }

    @Override
    public TodoDTO update(TodoDTO todoDTO) {
        Todo todoToUpdate = todoRepository.findById(todoDTO.getId()).orElse(null);
        if (todoToUpdate != null) {
            todoToUpdate.setItem(todoDTO.getItem());
            todoRepository.save(todoToUpdate);
            return objectMapper.convertValue(todoToUpdate, TodoDTO.class);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        todoRepository.deleteById(id);
    }

    @Override
    public List<TodoDTO> getListTodo() {
        return todoRepository.findAll().stream()
                .map(todo -> objectMapper.convertValue(todo, TodoDTO.class))
                .collect(java.util.stream.Collectors.toList());
    }
}
