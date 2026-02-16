package auca.ac.rw.question4_ecommerce_api.controller;

import auca.ac.rw.question4_ecommerce_api.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private List<Product> products = new ArrayList<>();

    public ProductController() {

        products.add(new Product(1L, "iPhone 14", "Apple smartphone",
                1200.0, "Electronics", 15, "Apple"));

        products.add(new Product(2L, "Samsung Galaxy S23", "Android smartphone",
                1100.0, "Electronics", 20, "Samsung"));

        products.add(new Product(3L, "Nike Air Max", "Running shoes",
                150.0, "Footwear", 50, "Nike"));

        products.add(new Product(4L, "Adidas Sneakers", "Casual shoes",
                130.0, "Footwear", 40, "Adidas"));

        products.add(new Product(5L, "HP Laptop", "14 inch laptop",
                900.0, "Electronics", 10, "HP"));

        products.add(new Product(6L, "Dell Monitor", "24 inch monitor",
                250.0, "Electronics", 30, "Dell"));

        products.add(new Product(7L, "Wooden Table", "Office table",
                300.0, "Furniture", 5, "IKEA"));

        products.add(new Product(8L, "Office Chair", "Comfortable chair",
                200.0, "Furniture", 12, "IKEA"));

        products.add(new Product(9L, "Puma T-Shirt", "Sports T-shirt",
                45.0, "Clothing", 60, "Puma"));

        products.add(new Product(10L, "Sony Headphones", "Wireless headphones",
                180.0, "Electronics", 25, "Sony"));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer limit) {

        if (page != null && limit != null) {
            int start = page * limit;
            int end = Math.min(start + limit, products.size());

            if (start > products.size()) {
                return ResponseEntity.ok(new ArrayList<>());
            }

            return ResponseEntity.ok(products.subList(start, end));
        }

        return ResponseEntity.ok(products);
    }

  
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {

        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                return ResponseEntity.ok(product);
            }
        }

        return ResponseEntity.notFound().build();
    }

  
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable String category) {

        List<Product> result = new ArrayList<>();

        for (Product product : products) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                result.add(product);
            }
        }

        return ResponseEntity.ok(result);
    }

  
    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<Product>> getByBrand(@PathVariable String brand) {

        List<Product> result = new ArrayList<>();

        for (Product product : products) {
            if (product.getBrand().equalsIgnoreCase(brand)) {
                result.add(product);
            }
        }

        return ResponseEntity.ok(result);
    }

  
    @GetMapping("/search")
    public ResponseEntity<List<Product>> search(@RequestParam String keyword) {

        List<Product> result = new ArrayList<>();

        for (Product product : products) {
            if (product.getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(product);
            }
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/price-range")
    public ResponseEntity<List<Product>> priceRange(@RequestParam Double min,
                                                    @RequestParam Double max) {

        List<Product> result = new ArrayList<>();

        for (Product product : products) {
            if (product.getPrice() >= min && product.getPrice() <= max) {
                result.add(product);
            }
        }

        return ResponseEntity.ok(result);
    }

   
    @GetMapping("/in-stock")
    public ResponseEntity<List<Product>> inStock() {

        List<Product> result = new ArrayList<>();

        for (Product product : products) {
            if (product.getStockQuantity() > 0) {
                result.add(product);
            }
        }

        return ResponseEntity.ok(result);
    }


    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        products.add(product);
        return ResponseEntity.status(201).body(product);
    }

   
    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long productId,
                                                 @RequestBody Product updatedProduct) {

        for (Product product : products) {
            if (product.getProductId().equals(productId)) {

                product.setName(updatedProduct.getName());
                product.setDescription(updatedProduct.getDescription());
                product.setPrice(updatedProduct.getPrice());
                product.setCategory(updatedProduct.getCategory());
                product.setStockQuantity(updatedProduct.getStockQuantity());
                product.setBrand(updatedProduct.getBrand());

                return ResponseEntity.ok(product);
            }
        }

        return ResponseEntity.notFound().build();
    }

    
    @PatchMapping("/{productId}/stock")
    public ResponseEntity<Product> updateStock(@PathVariable Long productId,
                                               @RequestParam int quantity) {

        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                product.setStockQuantity(quantity);
                return ResponseEntity.ok(product);
            }
        }

        return ResponseEntity.notFound().build();
    }

   
    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {

        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                products.remove(product);
                return ResponseEntity.noContent().build();
            }
        }

        return ResponseEntity.notFound().build();
    }
}
