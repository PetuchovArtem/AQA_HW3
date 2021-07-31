package com.it_academy.practice.junit_basics;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Введите 2 числа, каждое на новой строке");

        Scanner sc = new Scanner(System.in);
        int n1 = Integer.parseInt(sc.next());
        int n2 = Integer.parseInt(sc.next());

        System.out.println("Введите строку чисел");
        Scanner sc2 = new Scanner(System.in);
        String stroka = sc2.nextLine();
        int[] numArr = Arrays.stream(stroka.split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> myArray = new ArrayList<Integer>(numArr.length);
        for (int i : numArr) {
            myArray.add(i);
        }

        Calculator calculator1 = new Calculator(n1, n2);

        Calculator calculator = new Calculator(myArray);

        System.out.println("Для двух чисел");
        System.out.println("Plus result: " + calculator1.calculate('+'));
        System.out.println("Minus result: " + calculator1.calculate('-'));
        System.out.println("Division result: " + calculator1.calculate('/'));
        System.out.println("Multiply result: " + calculator1.calculate('*'));
        System.out.println("Exponentiation result: " + calculator1.calculate('^'));
        System.out.println("Root result: " + calculator1.calculate('#'));
        System.out.println("---------------");
        System.out.println("---------------");
        System.out.println("Для массива");
        System.out.println("Plus result: " + calculator.calculateArray('+', myArray));
        System.out.println("Minus result: " + calculator.calculateArray('-', myArray));
        System.out.println("Division result: " + calculator.calculateArray('/', myArray));
        System.out.println("Multiply result: " + calculator.calculateArray('*', myArray));
        System.out.println("Exponentiation result: " + calculator.calculateArray('^', myArray));
        System.out.println("Root result: " + calculator.calculateArray('#', myArray));

    }
}
