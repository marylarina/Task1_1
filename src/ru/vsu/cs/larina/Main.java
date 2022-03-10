package ru.vsu.cs.larina;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //тест для суммирования
        String arr1 = "6 3 . 7 8 8 3 5 8 9 9 8";
        String arr2 = "4 3 4 5 3 . 6 3 7 3 7";
        System.out.println(NewBigDecimal.ArrayToString(NewBigDecimal.Sum(NewBigDecimal.StringToArray(arr1), NewBigDecimal.StringToArray(arr2))));

        //тест для вычитания
        String arr3 = "5 5 4 6 9 . 9 7 8 9";
        String arr4 = "3 3 6 0 6 . 0 7 6 7";
        System.out.println(NewBigDecimal.ArrayToString(NewBigDecimal.Subtraction(NewBigDecimal.StringToArray(arr3), NewBigDecimal.StringToArray(arr4))));

        //тест для умножения
        String arr5 = "5 5 4 7 8 9 . 6 9";
        String arr6 = "3 3 6 9 . 8 7 8 9";
        System.out.println(NewBigDecimal.ArrayToString(NewBigDecimal.Multiplication(NewBigDecimal.StringToArray(arr5), NewBigDecimal.StringToArray(arr6))));

        //тест для целочисленного деления и остатка от деления
        String arr7 = "5 0 5 6 7 8 9 . 9 5 4 5";
        int variable = 20;
        System.out.println(NewBigDecimal.ArrayToString(NewBigDecimal.Division(NewBigDecimal.StringToArray(arr7), variable)));
        System.out.print(NewBigDecimal.ArrayToString(NewBigDecimal.Remainder(NewBigDecimal.StringToArray(arr7), variable)));
    }

}
