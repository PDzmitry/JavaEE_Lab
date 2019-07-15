package by.protasovitski.springfirst.service;

import by.protasovitski.springfirst.entities.Person;
import by.protasovitski.springfirst.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public boolean deletePerson(long id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isEmpty() != true) {
            personRepository.delete(person.get());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean editPerson(Person person) {
        if (personRepository.save(person) != null)
            return true;
        else {
            return false;
        }
    }

    @Override
    public boolean addNewPerson(Person person) {
        if (personRepository.save(person) != null)
            return true;
        else {
            return false;
        }
    }

    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @Override
    public Optional<Person> getById(long id) {
        return personRepository.findById(id);
    }
}
