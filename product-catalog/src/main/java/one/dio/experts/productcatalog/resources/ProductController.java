package one.dio.experts.productcatalog.resources;

import one.dio.experts.productcatalog.model.Product;
import one.dio.experts.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    Product create(@RequestBody Product product) {
        return productRepository.save(product);
    }
    @GetMapping("/{id}")
    Optional<Product> findById(@PathVariable Integer id) {
        return productRepository.findById(id);
    }
}
