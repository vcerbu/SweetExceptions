package com.endava.main;

import com.endava.entity.PersonException;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.*;

import static com.endava.entity.PersonException.ThrowRandomException;
import static com.endava.utilities.Utilities.readString;

public class Main {
    public static void main(String[] args) {
        PersonException personException = new PersonException();
        List<Object> myInfo = new ArrayList<>();
        Map<Integer, Throwable> myMap = new HashMap<>();
        String fileName = "C:\\Users\\vcerbu\\Desktop\\Java June\\f.txt";

        try {
            myInfo = personException.readFromFile(fileName);
            personException.displayInformation(myInfo);
            personException.displayElements(myInfo);


        } catch (FileNotFoundException e) {
            System.out.println("This file does not exist");
            // e.printStackTrace();
            // personException.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("The element you want to access is unavailable.");
            //e.printStackTrace();
            System.out.println("Try again? (y/n)");
            String answer = readString();
            if (answer.equals("y"))
                personException.displayInformation(myInfo);
            else if (answer.equals("n"))
                System.exit(0);
        } catch (ClassCastException e) {
            System.out.println("You can not cast your information to Integer");
            //e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        myMap.put(0, personException);
        myMap.put(1, new IllegalArgumentException());
        myMap.put(2, new SQLException());

        System.out.println("Randomly thrown exception:");
        ThrowRandomException(myMap);
    }

}



