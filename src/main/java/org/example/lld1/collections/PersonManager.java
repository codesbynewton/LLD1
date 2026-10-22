package org.example.lld1.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

 class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}



public class PersonManager {
    public static List<Person> removeDuplicatePersons(List<Person> persons) {
        List<Person> uniquePersons = new ArrayList<>();
        //code here
        Set<String> hs = new HashSet<>();

        for(Person person : persons){
            if(hs.add(person.getName())) uniquePersons.add(person);
        }
        return uniquePersons;
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Alice", 20));
        persons.add(new Person("Bob", 25));
        persons.add(new Person("Alice", 22));
        persons.add(new Person("Charlie", 22));
        persons.add(new Person("Bob", 30));

        List<Person> result = removeDuplicatePersons(persons);
        for(Person p:result){
            System.out.println(p.getName()+" "+p.getAge());
        }
    }
}

// Problem Statement
 /*


 You are given a class Person which stores the data of each person.
 The Person class has two variables, name and age.
 Now you are given a list of Person and you need to remove the duplicates from the given list
 and return the filtered list.

 You need to remove the duplicates based on name only, irrespective of the age.
 If two or more persons have the same name but different ages,
 then include the person who came first in the list and discard others.


  */