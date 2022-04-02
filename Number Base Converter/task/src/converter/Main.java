package converter;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Converter converter = new Converter();
    static String number;
    static int base;

    public static void main(String[] args) {
        do {
            printMenu();
            converter.setConverter(base);
            System.out.print("\nConversion result: ");
            converter.convert(number);
        } while (converter.run());
    }

    public static void printMenu() {
        System.out.print("Do you want to convert /from decimal or /to decimal? (To quit type /exit)");
        converter.setMode(scanner.nextLine());

        switch (converter.getMode()) {
            case FROM -> {
                System.out.println("\nEnter a number in decimal system: ");
                number = scanner.nextLine();
                System.out.print("\nEnter the target base: ");
                base = scanner.nextInt();
            }
            case TO -> {
                System.out.println("\nEnter source number: ");
                number = scanner.nextLine();
                System.out.println("\nEnter source base: ");
                base = scanner.nextInt();
            }
        }
    }
}