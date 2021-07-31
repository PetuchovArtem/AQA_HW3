package com.it_academy.practice.junit_basics;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private int a;
    private int b;
    List<Integer> arrayList = new ArrayList<>();

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Calculator(List<Integer> arrayList) {
        this.arrayList = (ArrayList<Integer>) arrayList;
    }


    public float getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public float calculate(char operation) {
        switch (operation) {
            default: {
                return 0;
            }
            case '-': {
                return a - b;
            }
            case '+': {
                return a + b;
            }
            case '/': {
                return a / b;
            }
            case '*': {
                return a * b;
            }
            case '^': {
                return (float) Math.pow(a, b);
            }
            case '#': {
                return (float) Math.pow(a, (1.0 / b));
            }
        }
    }

    public float calculateArray(char operation, List<Integer> arrayList) {
        switch (operation) {
            default: {
                return 0;
            }
            case '-': {
                int sub = arrayList.get(0);
                for (int count = 1; count < arrayList.size(); count++) {
                    sub = sub - arrayList.get(count);
                }
                return sub;
            }
            case '+': {
                int sum = arrayList.get(0);
                for (int count = 1; count < arrayList.size(); count++) {
                    sum = sum + arrayList.get(count);
                }
                return sum;
            }
            case '/': {
                float div = arrayList.get(0);
                for (int count = 1; count < arrayList.size(); count++) {
                    div = div / arrayList.get(count);
                }
                return div;
            }
            case '*': {
                float mul = arrayList.get(0);
                for (int count = 1; count < arrayList.size(); count++) {
                    mul = mul * arrayList.get(count);
                }
                return mul;
            }

            case '^': {
                float exp = arrayList.get(0);
                for (int count = 1; count < arrayList.size(); count++) {
                    exp = (float) Math.pow(exp, arrayList.get(count));
                }
                return exp;
            }
            case '#': {
                float root = arrayList.get(0);
                for (int count = 1; count < arrayList.size(); count++) {
                    root = (float) Math.pow(root, (1.0 / arrayList.get(count)));
                }
                return root;
            }
        }
    }


}
