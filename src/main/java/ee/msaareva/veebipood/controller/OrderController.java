package ee.msaareva.veebipood.controller;

import ee.msaareva.veebipood.dto.OrderRowDto;
import ee.msaareva.veebipood.entity.Order;
import ee.msaareva.veebipood.entity.OrderRow;
import ee.msaareva.veebipood.repository.OrderRepository;
import ee.msaareva.veebipood.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
public class OrderController {

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
    public Order addOrder(@RequestParam Long personId,
                          @RequestParam(required = false) String parcelMachine,
                          @RequestBody List<OrderRowDto> orderRows) {
        return orderService.saveOrder(personId, parcelMachine, orderRows);
        // return orderRepository.findAll(); // siin on uuenenud seis
    }
}
