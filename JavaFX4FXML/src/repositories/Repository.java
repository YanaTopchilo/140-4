/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.List;
import models.User;
import models.Person;
import models.Domain;
/**
 *
 * @author Topchilo
 */
public interface Repository {
    
    List<User> getUsers();
    List<Person> getPersons();
    Person getPersonById(int id);
    List<Domain> getDomain();
    List<Domain> getDomainByPerson(Person person);
}
