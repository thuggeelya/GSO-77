package org.example;

import org.example.task_1.MyStringClass;
import org.example.task_2.CensoredText;
import org.example.task_3.Fraction;

import java.util.Arrays;

import static org.example.task_4.CalculateTemperatureByInput.analiseInput;

public class Application {

    public static void main(String[] args) {
        /*-------------------------------------------------------------------------*/
        System.out.println("Task 1");

        System.out.println(MyStringClass.capitalize("somebody"));
        System.out.println(MyStringClass.isPalindrome("someemos"));
        System.out.println(MyStringClass.alphabetize("Papa Roach"));
        /*-------------------------------------------------------------------------*/

        /*-------------------------------------------------------------------------*/
        System.out.println(System.lineSeparator() + "Task 2");

        String text = """
                Help! I need somebody
                Help! Not just anybody
                Help! You know I need someone
                Help!""";
        String wordToCensor = "help";
        CensoredText censored = new CensoredText(wordToCensor);
        System.out.println(text + System.lineSeparator() + System.lineSeparator() + censored.censor(text));
        /*-------------------------------------------------------------------------*/

        /*-------------------------------------------------------------------------*/
        System.out.println(System.lineSeparator() + "Task 3");

        Fraction f1 = new Fraction(5, 6);
        Fraction f2 = new Fraction(7, 12);
        System.out.println("f1 = " + f1 + ", f2 = " + f2);
        System.out.println("f1 + f2 = " + f1.add(f2));
        System.out.println("f1 * f2 = " + f1.multiply(f2));
        System.out.println("f1 / f2 = " + f1.divide(f2));
        System.out.println("f1 - f2 = " + f1.subtract(f2));
        System.out.println("f1 == f2 ? " + ((f1.compareTo(f2) == 0) ? "yes" : "no"));
        /*-------------------------------------------------------------------------*/

        /*-------------------------------------------------------------------------*/
        System.out.println(System.lineSeparator() + "Task 4");

        String[] inputs = {"40C => F", "290 K => C", "11F=>C", "29C=>K", "-123F=>K"};
        Arrays.stream(inputs).forEach(in -> System.out.println(analiseInput(in)));
        /*-------------------------------------------------------------------------*/

    }
}
