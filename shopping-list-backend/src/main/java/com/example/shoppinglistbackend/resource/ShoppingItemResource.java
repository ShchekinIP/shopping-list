package com.example.shoppinglistbackend.resource;

import com.example.shoppinglistbackend.persist.ShoppingItem;
import com.example.shoppinglistbackend.persist.ShoppingItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:63342")
@RestController
@RequestMapping("/api/v1/item")
public class ShoppingItemResource {

    private final ShoppingItemRepository repository;

    @Autowired
    public ShoppingItemResource(ShoppingItemRepository repository) {
        this.repository = repository;
    }
    @PostMapping(consumes = "application/json",produces = "application/json")
    public ShoppingItem create(@RequestBody ShoppingItem item){
        return repository.save(item);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") long id){
        repository.deleteById(id);
    }

    @GetMapping(path = "/all", produces = "application/json")
    public List<ShoppingItem> findAll(){
        return repository.findAll();
    }
}
