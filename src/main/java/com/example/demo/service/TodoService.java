package com.example.demo.service;

import com.example.demo.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    TodoDTO create(TodoDTO todoDTO);

    TodoDTO update(TodoDTO todoDTO);

    void delete(Long id);

    List<TodoDTO> getListTodo();
}
