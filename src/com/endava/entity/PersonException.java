package com.endava.entity;


import java.io.*;
import java.util.*;


import static com.endava.utilities.Utilities.readIntFromConsole;

public class PersonException extends Throwable {

    public List readFromFileInputToList(String fileName) throws FileNotFoundException {

        String line;
        List<String> personInfo = new ArrayList<>();
        File source = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(source));
        try {
            while ((line = br.readLine()) != null)
                personInfo.add(line);
            new Person().setInfoFromListToPerson(personInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personInfo;
    }

    public void displayInformation(List<Object> personInfo) throws IndexOutOfBoundsException {
        int position;
        System.out.println("What information to display? (0 - name, 1 - surname, 2 - age)");
        position = readIntFromConsole();
        if (position > personInfo.size())
            throw new IndexOutOfBoundsException();
        else
            System.out.println(personInfo.get(position));
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

