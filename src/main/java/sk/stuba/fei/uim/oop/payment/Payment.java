package sk.stuba.fei.uim.oop.payment;

import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.uim.oop.animal.Animal;
import sk.stuba.fei.uim.oop.person.Person;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Animal animal;

    @ManyToOne
    private Person person;

    private int payment;

    public Payment(Animal animal, Person person, int payment) {
        this.animal = animal;
        this.person = person;
        this.payment = payment;
    }
}
