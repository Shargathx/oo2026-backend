package ee.msaareva.veebipood.repository;

import ee.msaareva.veebipood.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
