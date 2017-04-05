package com.endava.entity;

/**
 * Created by vcerbu on 4/3/2017.
 */
public class MyAssertion {

    public static int recursiveSumOfArray(int[] array, int numberOfElements) {
        assert numberOfElements < array.length : "Invalid number of Elements";
        if (numberOfElements == 0)
            return array[numberOfElements];
        else
            return array[numberOfElements] + recursiveSumOfArray(array, numberOfElements - 1);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int sum = recursiveSumOfArray(array, array.length - 1);
        //int sum = sumOfArray(array, 10);
        System.out.println(sum);
    }
}
