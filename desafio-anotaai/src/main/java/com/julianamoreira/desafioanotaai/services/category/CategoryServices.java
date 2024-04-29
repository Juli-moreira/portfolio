package com.julianamoreira.desafioanotaai.services.category;

import com.julianamoreira.desafioanotaai.domain.category.Category;
import com.julianamoreira.desafioanotaai.domain.category.CategoryDTO;
import com.julianamoreira.desafioanotaai.domain.category.exceptions.CategoryNotFoundException;
import com.julianamoreira.desafioanotaai.domain.products.Products;
import com.julianamoreira.desafioanotaai.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServices {
    private CategoryRepository repository;

    public CategoryServices(CategoryRepository repository)
    {
        this.repository = repository;
    }

    public Category insert (CategoryDTO categoryData)
    {
       Category newCategory = new Category(categoryData);
       this.repository.save(newCategory);
       return newCategory;
    }

    public Category update (String id, CategoryDTO categoryData)
    {
        Category category = this.repository.findById(id).orElseThrow(CategoryNotFoundException::new);
        if(!categoryData.description().isEmpty()) category.setDescription(categoryData.description());
        if(!categoryData.title().isEmpty()) category.setTitle(categoryData.title());
        //f(!categoryData.ownerId().isEmpty()) category.setOwnerId(categoryData.ownerId());
        this.repository.save(category);
        return category;
    }

    public void delete (String id)
    {
        Category category = this.repository.findById(id).orElseThrow(CategoryNotFoundException::new);
        this.repository.delete(category);
    }

    public List<Category> getAll()
    {
        return this.repository.findAll();
    }
    public Optional<Category> getById(String id)
    {
        return this.repository.findById(id);
    }
}
