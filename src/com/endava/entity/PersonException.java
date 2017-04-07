package com.endava.entity;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

import static com.endava.utilities.Utilities.convertStringToInt;

public class PersonException extends Throwable {

    Person person = new Person();

    public List readFromFile(String fileName) throws FileNotFoundException {
        String line;
        BufferedReader br;
        List<String> myList = new ArrayList<>();
        File source = new File(fileName);
        br = new BufferedReader(new FileReader(source));
        try {
            while ((line = br.readLine()) != null)
                myList.add(line);
            person.setName(myList.get(0));
            person.setSurname(myList.get(1));
            person.setAge(Integer.parseInt(myList.get(2)));
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

    public static void ThrowRandomException(Map<Integer, Throwable> myMap) throws Throwable {
        Random rand = new Random();
        int randomNum = rand.nextInt((2));
        throw myMap.get(randomNum);
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.out.println("THIS IS PRINTSTACKTRACE!");
    }
}

