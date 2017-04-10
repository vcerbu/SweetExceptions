package com.endava.main;

import com.endava.entity.PersonException;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.*;


import static com.endava.utilities.Utilities.readString;

public class Main {
    public static void main(String[] args) throws Throwable {
        //if (args.length < 1) throw new RuntimeException("Please insert filePath");
        PersonException personException = new PersonException();
        List<Object> personInfo = new ArrayList<>();
        Map<Integer, Throwable> exceptionsMap = new HashMap<>();
        String fileName = "C:\\Users\\vcerbu\\Desktop\\Java June\\f.txt";
        //if (FileSystems.getDefault().getSeparator().equals('/'))
        //fileName = "/home/ipanasenco/file.txt";
        try {
            personInfo = personException.readFromFileInputToList(fileName);
            //myInfo = personException.readFromFile(args[1]);
            personException.displayInformation(personInfo);
            personException.displayElements(personInfo);
        } catch (FileNotFoundException e) {
            System.out.println("This file does not exist");
            // e.printStackTrace();
            // personException.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("The element you want to access is unavailable.");
            System.out.println("Try again? (y/n)");
            String answer = readString();
            if (answer.equals("y"))
                personException.displayInformation(personInfo);
            else if (answer.equals("n"))
                System.exit(0);
        } catch (ClassCastException e) {
            System.out.println("You can not cast your information to Integer");
        } catch (Exception e) {
            e.printStackTrace();
        }

        exceptionsMap.put(0, personException);
        exceptionsMap.put(1, new IllegalArgumentException());
        exceptionsMap.put(2, new SQLException());

        System.out.println("Randomly thrown exception:");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            PersonException.ThrowRandomException(exceptionsMap);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

}



