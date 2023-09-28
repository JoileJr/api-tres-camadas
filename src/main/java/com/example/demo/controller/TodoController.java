package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Todo;
import com.example.demo.repository.TodoRepository;

@RestController
@RequestMapping("api/")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping
    public List<Todo> buscarTodos(){
       return todoRepository.findAll();
    }

    @PostMapping
    public Todo inserir(@RequestBody Todo todo){
        return todoRepository.save(todo);
    }

    @PutMapping
    public Todo alterar(@RequestBody Todo todo){
        return todoRepository.save(todo);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> excluir(@PathVariable("id") Long id){
        Optional<Todo> obj = todoRepository.findById(id);
        todoRepository.delete(obj.get());
        return ResponseEntity.ok("Excluido com sucesso");
    }
}
