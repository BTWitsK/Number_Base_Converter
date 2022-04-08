package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Converter converter;

        do {
            System.out.print("Enter two numbers in format: {source base} {target base} (To quit type /exit)");
            converter = new Converter(scanner.nextLine());

            if (converter.inMainMenu()) {
                do {
                    converter.getNumber();
                    converter.convert(scanner.nextLine());

                } while (converter.inSubMenu());
            }

        } while (converter.inMainMenu());
    }
}