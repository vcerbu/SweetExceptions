package com.endava.entity;

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


}
