package com.example.demo.controller;

import java.util.List;

import com.example.demo.dto.TodoDTO;
import com.example.demo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/todo")
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public List<TodoDTO> getListTodo(){
        return todoService.getListTodo();
    }

    @PostMapping
    public TodoDTO create(@RequestBody TodoDTO todo){
        return todoService.create(todo);
    }

    @PutMapping
    public TodoDTO update(@RequestBody TodoDTO todo){
        return todoService.update(todo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        todoService.delete(id);
        return ResponseEntity.ok("Excluido com sucesso");
    }
}
