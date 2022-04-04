package converter;

import java.math.*;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Converter converter = new Converter();
    static String number;

    public static void main(String[] args) {
        String[] mainInput;

        System.out.print("Enter two numbers in format: {source base} {target base} (To quit type /exit)");
        mainInput = scanner.nextLine().split(" ");

        while (!"/exit".equals(mainInput[0])) {

            int source = Integer.parseInt(mainInput[0]);
            int target = Integer.parseInt(mainInput[1]);

            System.out.printf("\nEnter number in base %d to convert to base %d (To go back type /back)", source, target);
            number = scanner.nextLine();

            while (!"/back".equals(number)) {

                System.out.print("Conversion result: " + new BigInteger(number, source).toString(target));

                System.out.printf("\nEnter number in base %d to convert to base %d (To go back type /back)", source, target);
                number = scanner.nextLine();
            }

            System.out.print("Enter two numbers in format: {source base} {target base} (To quit type /exit)");
            mainInput = scanner.nextLine().split(" ");
        }
    }
}