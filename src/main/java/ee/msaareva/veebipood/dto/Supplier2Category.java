package ee.msaareva.veebipood.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Supplier2Category {
    private int id;
    private String name;
    private String slug;
    private String image;
    private Date creationAt;
    private Date updatedAt;
}
