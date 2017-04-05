package com.endava.entity;

/**
 * Created by vcerbu on 4/3/2017.
 */
public class MyAssertion {

    public static int recursiveSumOfArray(int[] array, int numberOfElements) {
        for (int i = 0; i < array.length; i++)
            assert (array[i] > 5) : "Elements should be greater than 5";
        if (numberOfElements == 0)
            return array[numberOfElements];
        else
            return array[numberOfElements] + recursiveSumOfArray(array, numberOfElements - 1);
    }

    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50};
        int sum = recursiveSumOfArray(array, array.length - 1);
        System.out.println(sum);
    }
}
