package ee.msaareva.veebipood.dto;

import ee.msaareva.veebipood.entity.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
public class Supplier2Product {
    private int id;
    private String title;
    private String slug;
    private int price;
    private String description;
    private Category category;
    private ArrayList<String> images;
    private Date creationAt;
    private Date updatedAt;
}
