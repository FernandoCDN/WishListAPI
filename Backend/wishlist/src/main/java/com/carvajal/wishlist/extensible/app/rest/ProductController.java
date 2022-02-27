package com.carvajal.wishlist.extensible.app.rest;

import com.carvajal.wishlist.extensible.domain.model.Product;
import com.carvajal.wishlist.extensible.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/services/product")
public class ProductController
{
    @Autowired
    ProductService productService;

    @GetMapping("/getAll")
    @ApiOperation("Get All products")
    private ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(productService.getAll());
    }
}
