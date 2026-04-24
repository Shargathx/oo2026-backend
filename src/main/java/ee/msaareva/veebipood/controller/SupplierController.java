package ee.msaareva.veebipood.controller;

import ee.msaareva.veebipood.dto.Supplier1Product;
import ee.msaareva.veebipood.dto.Supplier2Product;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// https://fakestoreapi.com/products
@CrossOrigin(origins = "*")
@RestController
public class SupplierController {
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/supplier1")
    public List<Supplier1Product> getProductsSupplier1() {
        String url = "https://fakestoreapi.com/products";
        Supplier1Product[] response = restTemplate.exchange(url, HttpMethod.GET, null, Supplier1Product[].class).getBody();
        return Arrays.stream(response).
                filter(e -> e.getRating().getRate() > 4.0)
                .toList();
    }

    @GetMapping("/supplier2")
    public List<Supplier2Product> getProductsSupplier2() {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println(restTemplate);
        String url = "https://api.escuelajs.co/api/v1/products";
        Supplier2Product[] response = restTemplate.exchange(url, HttpMethod.GET, null, Supplier2Product[].class).getBody();
        return Arrays.stream(response).
                sorted(Comparator.comparing(Supplier2Product::getPrice))
                .toList();
    }
}
