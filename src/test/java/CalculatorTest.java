import com.it_academy.practice.junit_basics.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.CsvSource;

import java.util.Scanner;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource({"1, 1, 0", "10, 20, -10", "0, 0, 0", "2147483647, 1, 2147483646"})
    @DisplayName("Вычитание")
    public void testCalculateSubtraction(int arg0, int arg1, int arg2) {
        float calculator = new Calculator(arg0, arg1).calculate('-');
        Assertions.assertEquals(calculator, arg2);
    }

    @ParameterizedTest
    @CsvSource({"5, 5, 10", "10, 0, 10", "0, 0, 0", "2147483647, 1, -2147483647"})
    @DisplayName("Сложение")
    public void testCalculateAddition(int arg0, int arg1, int arg2) {
        float calculator = new Calculator(arg0, arg1).calculate('+');
        Assertions.assertEquals(calculator, arg2);
    }

    @ParameterizedTest
    @CsvSource({"5, 5, 25", "0, 0, 0", "10, 0, 0", "0, 10, 0", "2147483647, 1, 2147483647", "-2147483647, 1, -2147483647"})
    @DisplayName("Умножение")
    public void testCalculateMultiplication(int arg0, int arg1, int arg2) {
        float calculator = new Calculator(arg0, arg1).calculate('*');
        Assertions.assertEquals(calculator, arg2);
    }

    @ParameterizedTest
    @CsvSource({"5, 5, 1", "0, 0, 0", "10, 0, 0", "0, 10, 0", "2147483647, 1, 2147483647", "-2147483647, 1, -2147483647"})
    @DisplayName("Деление")
    public void testCalculateDivision(int arg0, int arg1, int arg2) {
        try {
            float calculator = new Calculator(arg0, arg1).calculate('/');
            Assertions.assertEquals(calculator, arg2);
        } catch (ArithmeticException e) {
            System.out.println("НА НОЛЬ ДЕЛИТЬ НЕЛЬЗЯ!, но можно в высшей матиматике");
        }
    }

    @ParameterizedTest
    @CsvSource({"1, 1, 1", "2, 3, 8", "0, 3, 0", "3, 0, 1"})
    @DisplayName("Возведение в степень")
    public void testCalculateExponentiation(int arg0, int arg1, int arg2) {
        float calculator = new Calculator(arg0, arg1).calculate('^');
        Assertions.assertEquals(calculator, arg2);
    }

    @ParameterizedTest
    @CsvSource({"1, 1, 1", "4, 2, 2",  "0, 10, 0", "2147483647, 1, 2147483647", "-2147483647, 1, -2147483647"})
    @DisplayName("Корень")
    public void testCalculateRoot(int arg0, int arg1, int arg2) {
        float calculator = new Calculator(arg0, arg1).calculate('#');
        Assertions.assertEquals(calculator, arg2);
    }

    @Test
    @DisplayName("Невалидные значения")
    public void testCalculateInvalid() {
        Scanner sc = new Scanner("values.txt");
        Assertions.assertThrows(NumberFormatException.class, () -> new Calculator(Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine())));
    }

}
