package sk.stuba.fei.uim.oop.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.payment.IPaymentService;
import sk.stuba.fei.uim.oop.payment.Payment;
import sk.stuba.fei.uim.oop.person.IPersonService;
import sk.stuba.fei.uim.oop.person.Person;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService implements IAnimalService {

    private IAnimalRepository repository;
    @Autowired
    private IPersonService personService;
    @Autowired
    private IPaymentService paymentService;

    @Autowired
    public AnimalService(IAnimalRepository repository) {
        this.repository = repository;
        Animal a1 = new Animal();
        a1.setSpecies("Pes");
        a1.setName("Luna");
        Animal a2 = new Animal();
        a2.setSpecies("Macka");
        a2.setName("Murko");
        this.repository.save(a1);
        this.repository.save(a2);
    }

    @Override
    public List<Animal> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Animal create(AnimalRequest request) {
        Animal a = new Animal();
        a.setSpecies(request.getSpecies());
        a.setName(request.getName());
        return this.repository.save(a);
    }

    @Override
    public List<Animal> getAllByName(String name) {
        return this.repository.findAllByName(name);
    }

    @Override
    public Animal addPersonToAnimal(Long animalId, Long personId) {
        Optional<Animal> animalOpt = this.repository.findById(animalId);
        Animal animal = animalOpt.get();
        Person person = this.personService.getById(personId);

        Payment payment = new Payment(animal, person, 20);
        payment = this.paymentService.save(payment);
        animal.getPayments().add(payment);
        person.getPayments().add(payment);
        this.personService.save(person);

        return this.repository.save(animal);
    }
}
