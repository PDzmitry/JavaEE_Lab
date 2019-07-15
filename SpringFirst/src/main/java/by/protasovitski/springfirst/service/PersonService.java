package by.protasovitski.springfirst.service;

import by.protasovitski.springfirst.entities.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    boolean deletePerson(long id);

    boolean editPerson(Person person);

    boolean addNewPerson(Person person);

    List<Person> getAllPerson();

    Optional<Person> getById(long id);

}
