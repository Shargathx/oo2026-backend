package ee.msaareva.veebipood.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Supplier1Product {
    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private Supplier1Rating rating;
}
