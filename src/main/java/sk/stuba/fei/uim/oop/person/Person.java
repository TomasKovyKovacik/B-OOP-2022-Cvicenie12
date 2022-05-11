package sk.stuba.fei.uim.oop.person;

import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.uim.oop.animal.Animal;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Animal animal;

    public Person(String name) {
        this.name = name;
    }
}
