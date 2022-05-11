package sk.stuba.fei.uim.oop.person;

import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PersonResponse {
    private Long id;
    private String name;
    private List<Long> animalIds;
    public PersonResponse(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.animalIds = person.getPayments().stream().map(payment -> payment.getAnimal().getId()).collect(Collectors.toList());
    }
}
