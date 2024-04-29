package com.julianamoreira.desafioanotaai.controllers.category;

import com.julianamoreira.desafioanotaai.domain.category.Category;
import com.julianamoreira.desafioanotaai.domain.category.CategoryDTO;
import com.julianamoreira.desafioanotaai.services.category.CategoryServices;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryControllers
{
    private CategoryServices service;

    public CategoryControllers (CategoryServices service)
    {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody CategoryDTO categoryData)
    {
      Category newCategory =  this.service.insert(categoryData);
      return ResponseEntity.ok().body(newCategory);
    }

    @GetMapping
    public ResponseEntity<List> getAll()
    {
        List<Category> categories = this.service.getAll();
        return ResponseEntity.ok().body(categories);
    }

    @PutMapping("{/id}")
    public ResponseEntity<Category> update(@PathParam("id") String id, @RequestBody CategoryDTO categoryData)
    {
        Category updateCategory =  this.service.update(id, categoryData);
        return ResponseEntity.ok().body(updateCategory);
    }

    @DeleteMapping
    public ResponseEntity<Category> delete(@PathParam("id") String id)
    {
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

