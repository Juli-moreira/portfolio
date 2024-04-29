package com.julianamoreira.desafioanotaai.controllers.products;

import com.julianamoreira.desafioanotaai.domain.category.Category;
import com.julianamoreira.desafioanotaai.domain.products.ProductDTO;
import com.julianamoreira.desafioanotaai.domain.products.Products;
import com.julianamoreira.desafioanotaai.services.products.ProductsServices;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductsControllers
{
    private ProductsServices service;

    public ProductsControllers (ProductsServices service)
    {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<Products> insert(@RequestBody ProductDTO productData)
    {
        Products newProduct =  this.service.insert(productData);
        return ResponseEntity.ok().body(newProduct);
    }

    @GetMapping
    public ResponseEntity<List> getAll()
    {
        List<Products> products = this.service.getAll();
        return ResponseEntity.ok().body(products);
    }

    @PutMapping("{/id}")
    public ResponseEntity<Products> update(@PathParam("id") String id, @RequestBody ProductDTO productData)
    {
        Products updateProduct =  this.service.update(id, productData);
        return ResponseEntity.ok().body(updateProduct);
    }

    @DeleteMapping("{/id}")
    public ResponseEntity<Products> delete(@PathParam("id") String id)
    {
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
