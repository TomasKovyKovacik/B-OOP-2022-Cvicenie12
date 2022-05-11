package sk.stuba.fei.uim.oop.animal;

import sk.stuba.fei.uim.oop.exceptions.NotFoundException;

import java.util.List;

public interface IAnimalService {
    List<Animal> getAll();
    Animal create(AnimalRequest request);
    List<Animal> getAllByName(String name);
    Animal addPersonToAnimal(Long animalId, Long personId) throws NotFoundException;
}
