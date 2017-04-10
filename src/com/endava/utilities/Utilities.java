package com.endava.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utilities {

    public static String readString() {
        BufferedReader box = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        try {
            str = box.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return str;
    }

    public static int readIntFromConsole() {
        return (Integer.valueOf(readString())).intValue();
    }

    public static float readFloatFromConsole() {
        return (Float.valueOf(readString())).floatValue();
    }


}
