package com.julianamoreira.desafioanotaai.services.products;

import com.julianamoreira.desafioanotaai.domain.category.Category;
import com.julianamoreira.desafioanotaai.domain.category.CategoryDTO;
import com.julianamoreira.desafioanotaai.domain.category.exceptions.CategoryNotFoundException;
import com.julianamoreira.desafioanotaai.domain.products.ProductDTO;
import com.julianamoreira.desafioanotaai.domain.products.Products;
import com.julianamoreira.desafioanotaai.domain.products.exception.ProductNotFoundException;
import com.julianamoreira.desafioanotaai.repositories.CategoryRepository;
import com.julianamoreira.desafioanotaai.repositories.ProductRepository;
import com.julianamoreira.desafioanotaai.services.category.CategoryServices;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductsServices
{
    private ProductRepository productRepository;
    private CategoryServices categoryServices;

    public ProductsServices(ProductRepository repository, CategoryServices categoryServices)
    {
        this.categoryServices = categoryServices;
        this.productRepository = productRepository;
    }

    public Products insert (ProductDTO productsData)
    {
        Category category = this.categoryServices.getById(productsData.categoryId()).orElseThrow(CategoryNotFoundException::new);
        Products newProduct = new Products(productsData);
        newProduct.setCategory(category);
        this.productRepository.save(newProduct);
        return new Products();
    }

    public Products update (String id, ProductDTO productData)
    {

        Products products = this.productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        this.categoryServices.getById(productData.categoryId()).ifPresent(products::setCategory);
        if(!productData.description().isEmpty()) products.setDescription(productData.description());
        if(!productData.title().isEmpty()) products.setTitle(productData.title());
        if(!(productData.price() == null)) products.setPrice(productData.price());
        this.productRepository.save(products);
        return products;
    }

    public void delete (String id)
    {
        Products products = this.productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        this.productRepository.delete(products);
    }

    public List<Products> getAll()
    {
        return this.productRepository.findAll();
    }

}
