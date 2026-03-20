package ee.msaareva.veebipood.repository;

import ee.msaareva.veebipood.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// repository --> andmebaasiga suhtlemiseks. tema sees on kõik funktsioonid, mida on võimalik
//              andmebaasiga teha.

public interface ProductRepository extends JpaRepository<Product,Long> {
}
