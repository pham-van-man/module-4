package org.example.test_thuc_hanh_module_4.RestfulController;

import org.example.test_thuc_hanh_module_4.model.Category;
import org.example.test_thuc_hanh_module_4.model.Product;
import org.example.test_thuc_hanh_module_4.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductRestfulController {
    private final ProductService productService;

    public ProductRestfulController(ProductService productService) {
        this.productService = productService;
    }
@ModelAttribute("o")
    @PostMapping("/list")
    public ResponseEntity<List<Product>> list(@RequestBody Category category) {
        List<Product> products = productService.getProductsByCategory(category);
        return ResponseEntity.ok(products);
    }
}
