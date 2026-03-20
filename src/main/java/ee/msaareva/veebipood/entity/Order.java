package ee.msaareva.veebipood.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order { // ERROR: syntax error at or near "order"
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date created;
    private double total;
    private String parcelMachine;

    @ManyToOne
    private Person person;

    // @ManyToMany
    // @OneToMany
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderRow> orderRows;
}
