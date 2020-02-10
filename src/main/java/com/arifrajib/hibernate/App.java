package com.arifrajib.hibernate;

import java.util.List;

public class App {

    public static void main(String[] args){

        /// New Person
        Person me = new Person("Arif", "Rajib", "arif.rajib@gmail.com", "123456789");

        /// save person
        PersonRepository.save(me);

        /// Get person
        List<Person> people = PersonRepository.getAll();
        people.forEach(person -> System.out.println(person));
    }
}
