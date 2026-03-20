package ee.msaareva.veebipood.controller;

import ee.msaareva.veebipood.entity.Product;
import ee.msaareva.veebipood.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") // ebaturvaline, päris arendustes ei tehta
@RestController
public class ProductController {
    // localhost:8080/products
    // application.properties  server.port=8090
//    @GetMapping("products")
//    public String helloworld(){
//        return "Hello World";
//    }

    // 1xx -> (harva) informatiivne
    // 2xx -> õnnestuv
    // 3xx -> (harva) redirect
    // 4xx -> päringu tegija (client error / front-end error)
    // 5xx -> päringu vastuvõtja viga (server error)

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("products")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("products/{id}")
    public Product getOneProduct(@PathVariable Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("products/{id}")
    public List<Product> deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id); // kustutan
        return productRepository.findAll(); // uuenenud seis
    }

    @PostMapping("products")
    public List<Product> addProduct(@RequestBody Product product) {
        if (product.getId() != null) {
            throw new RuntimeException("Cannot add with ID");
        }
        productRepository.save(product); // siin salvestab
        return productRepository.findAll(); // siin on uuenenud seis
    }

    @PutMapping("products")
    public List<Product> editProduct(@RequestBody Product product) {
        // File -> Settings -> Plugins -> Lombok -> Install
        if (product.getId() == null) {
            throw new RuntimeException("Cannot edit without ID");
        }
        if (!productRepository.existsById(product.getId())) {
            throw new RuntimeException("Product ID does not exist");
        }
        productRepository.save(product); // siin salvestab
        return productRepository.findAll(); // siin on uuenenud seis
    }


}
