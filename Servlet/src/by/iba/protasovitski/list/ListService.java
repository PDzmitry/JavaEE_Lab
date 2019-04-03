package by.iba.protasovitski.list;

import by.iba.protasovitski.model.Person;

import java.util.ArrayList;
import java.util.List;

public class ListService {
    private static List<Person> groupList = new ArrayList<>();

    static {
        groupList.add(new Person("anna5", "+37581118181", "anna5@gmail.com"));
        groupList.add(new Person("anna1", "+375823421", "anna1@gmail.com"));
        groupList.add(new Person("anna2", "+3324234118181", "anna2@gmail.com"));
        groupList.add(new Person("anna3", "+342342381118181", "anna2@gmail.com"));
        groupList.add(new Person("anna4", "+324342381118181", "anna3@gmail.com"));

    }

    static public List<Person> retrieveList() {
        return groupList;
    }

    static public void addPerson(Person person) {
        groupList.add(new Person(person));
    }
}
