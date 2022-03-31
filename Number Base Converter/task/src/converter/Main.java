package converter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number in decimal system: ");
        int number = scanner.nextInt();
        System.out.print("\nEnter target base: ");
        int base = scanner.nextInt();

        Converter converter = new Converter();
        converter.setConverter(base);
        System.out.print("\nConversion result: ");
        converter.convert(number);
    }
}