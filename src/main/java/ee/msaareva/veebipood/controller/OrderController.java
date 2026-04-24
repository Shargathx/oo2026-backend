package ee.msaareva.veebipood.controller;

import ee.msaareva.veebipood.dto.OrderRowDto;
import ee.msaareva.veebipood.dto.ParcelMachine;
import ee.msaareva.veebipood.dto.PaymentUrl;
import ee.msaareva.veebipood.entity.Order;
import ee.msaareva.veebipood.repository.OrderRepository;
import ee.msaareva.veebipood.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@CrossOrigin(origins = "*")
@AllArgsConstructor
@RequiredArgsConstructor
@RestController
public class OrderController {
    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/parcelMachines")
    public List<ParcelMachine> getParcelMachines(@RequestParam String country) {
        String url = "";
        ParcelMachine[] response = restTemplate.exchange(url, HttpMethod.GET, null, ParcelMachine[].class).getBody();
        return Arrays.stream(response).filter(e -> e.getA0_name().equals(country.toUpperCase())).toList();
    }


    private OrderRepository orderRepository;
    private OrderService orderService;

    @GetMapping("orders")
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @DeleteMapping("orders/{id}")
    public List<Order> deleteOrder(@PathVariable Long id) {
        orderRepository.deleteById(id); // kustutan
        return orderRepository.findAll(); // uuenenud seis
    }

    // localhost:8080/orders?personId=1
    @PostMapping("orders")
    public PaymentUrl addOrder(@RequestParam Long personId,
                          @RequestParam(required = false) String parcelMachine,
                          @RequestBody List<OrderRowDto> orderRows) {
        Order order = orderService.saveOrder(personId, parcelMachine, orderRows);
        return orderService.makePayment(order.getId(), order.getTotal());
        // return orderRepository.findAll(); // siin on uuenenud seis
    }

//    @PostMapping("pay")
//    public PaymentUrl makePayment(@RequestParam Long orderId, double sum) {
//        return orderService.makePayment(orderId, sum);
//    }
}
