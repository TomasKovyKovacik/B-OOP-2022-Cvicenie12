package sk.stuba.fei.uim.oop.animal;

import lombok.Getter;
import sk.stuba.fei.uim.oop.person.Person;
import sk.stuba.fei.uim.oop.person.PersonResponse;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class AnimalResponse {
    private Long id;

    private String species;

    private String name;

    private List<PersonResponse> person;

    AnimalResponse(Animal a) {
        this.id = a.getId();
        this.species = a.getSpecies();
        this.name = a.getName();
        this.person = a.getPerson().stream().map(PersonResponse::new).collect(Collectors.toList());
    }
}
