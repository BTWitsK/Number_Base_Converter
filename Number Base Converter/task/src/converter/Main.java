package converter;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Converter converter = new Converter();
    static String number;
    static int base;

    public static void main(String[] args) {
        printMenu();
        while (converter.run()) {
            printMenu();
        }
    }

    public static void printMenu() {
        System.out.print("\nDo you want to convert /from decimal or /to decimal? (To quit type /exit)");
        converter.setMode(scanner.nextLine());

        switch (converter.getMode()) {
            case FROM -> {
                System.out.print("\nEnter a number in decimal system: ");
                number = scanner.nextLine();
                System.out.print("\nEnter the target base: ");
                base = Integer.parseInt(scanner.nextLine());
                converter.setConverter(base);
                System.out.print("\nConversion result: ");
                converter.convert(number);
            }
            case TO -> {
                System.out.println("\nEnter source number: ");
                number = scanner.nextLine();
                System.out.println("\nEnter source base: ");
                base = Integer.parseInt(scanner.nextLine());
                converter.setConverter(base);
                System.out.print("\nConversion to decimal result: ");
                converter.convert(number);
            }
        }
    }
}