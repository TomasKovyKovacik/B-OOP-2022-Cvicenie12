package sk.stuba.fei.uim.oop.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService{

    private IPersonRepository repository;

    @Autowired
    public PersonService(IPersonRepository repository) {
        this.repository = repository;

        this.repository.save(new Person("Jakub"));
        this.repository.save(new Person("Tomas"));
        this.repository.save(new Person("Martin"));
    }

    @Override
    public List<Person> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Person getById(Long id) {
        return this.repository.findById(id).get();
    }

    @Override
    public Person save(Person p) {
        return this.repository.save(p);
    }
}
