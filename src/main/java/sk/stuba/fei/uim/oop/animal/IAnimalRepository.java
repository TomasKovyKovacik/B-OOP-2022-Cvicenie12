package sk.stuba.fei.uim.oop.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findAll();

    List<Animal> findAllByName(String name);
}
