package sk.stuba.fei.uim.oop.person;

import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.uim.oop.animal.Animal;
import sk.stuba.fei.uim.oop.payment.Payment;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    private List<Payment> payments;

    public Person(String name) {
        this();
        this.name = name;
    }

    public Person() {
        this.payments = new ArrayList<>();
    }
}
