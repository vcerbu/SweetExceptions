package com.endava.entity;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by vcerbu on 4/7/2017.
 */
public class Person {

    private String name;
    private String surname;
    private int age;

    public Person() {
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Object getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Object getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setInfoFromListToPerson(List<String> myList) {
        this.setName(myList.get(0));
        this.setSurname(myList.get(1));
        this.setAge(Integer.parseInt(myList.get(2)));
    }


}
