package com.endava.entity;

import java.io.*;
import java.util.*;

import static com.endava.utilities.Utilities.convertStringToInt;

public class PersonException extends Throwable {

    private String name;
    private String surname;
    private int age;
    private String line = null;

    public PersonException() {
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

    public List readFromFile(String fileName) throws FileNotFoundException {
        BufferedReader br;
        List<String> myList = new ArrayList<>();
        File source = new File(fileName);
        if (!source.exists())
            throw new FileNotFoundException("Could not find file: " + fileName);
        br = new BufferedReader(new FileReader(source));
        try {
            while ((line = br.readLine()) != null)
                myList.add(line);
            this.setName((String) myList.get(0));
            this.setSurname((String) myList.get(1));
            this.setAge(Integer.parseInt(myList.get(2)));
        } catch (IOException | ClassCastException e) {
            e.printStackTrace();
        }
        return myList;
    }

    public void displayInformation(List<Object> myList) throws IndexOutOfBoundsException {
        int position;
        System.out.println("What information to display? (0 - name, 1 - surname, 2 - age)");
        position = convertStringToInt();
        if (position > myList.size())
            throw new IndexOutOfBoundsException();
        else
            System.out.println(myList.get(position));
    }

    public void displayElements(List<Object> myList) throws ClassCastException {
        Iterator it = myList.iterator();
        while (it.hasNext()) {
            Integer i = (Integer) it.next();
            System.out.println(i);
        }
    }

    public void printStackTrace() {
        super.printStackTrace();
        System.out.println("This is printStackTrace method");
    }

    public static void ThrowRandomException(Map<Integer, Throwable> myMap) {
        Random rand = new Random();
        int randomNum = rand.nextInt((3) + 1);
        try {
            throw myMap.get(randomNum);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}

