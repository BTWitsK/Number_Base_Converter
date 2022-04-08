package converter;
import java.math.*;
import java.util.*;

class Converter{
    private int source;
    private int target;
    private boolean mainMenu = true;
    private boolean subMenu = true;
    private final HashMap<Character, Integer> alphabetMap = new HashMap<>();
    private final HashMap<Integer, String> digitMap = new HashMap<>();

    public Converter(String input) {
        int decimal = 10;
        String[] parameters = input.split(" ");
        try {
            this.source = Integer.parseInt(parameters[0]);
            this.target = Integer.parseInt(parameters[1]);
            for (char i = 'a'; i <= 'z'; i++) {
                alphabetMap.put(i, decimal);
                digitMap.put(decimal, Character.toString(i));
                decimal++;
            }
        } catch (NumberFormatException e) {
            this.mainMenu = false;
        }
    }

    public boolean inMainMenu() {
        return mainMenu;
    }

    public boolean inSubMenu() {
        return subMenu;
    }

    public void getNumber() {
        System.out.printf("\nEnter number in base %d to convert to base %d (To go back type /back)", source, target);
    }

    public void convert(String num) {
        num = num.toLowerCase();
        if ("/back".equals(num)) {
            subMenu = false;
        } else if (num.contains(".")) {
            String[] number = num.split("\\.");
            System.out.printf("\nConversion result: %s.%s", convertWhole(number[0]), convertFraction(number[1]));
        } else {
            System.out.printf("\nConversion result: %s", convertWhole(num));
        }
    }

    private String convertWhole (String number) {
        return new BigInteger(number, this.source).toString(this.target);
   }

    private String convertFraction (String num) {
        BigDecimal number = new BigDecimal(convertToDecimal(num)).setScale(5, RoundingMode.UP);
        StringBuilder output = new StringBuilder();

        do {
            String[] result = number.multiply(BigDecimal.valueOf(target)).toString().split("\\.");
            output.append(digitToBase(Integer.parseInt(result[0])));
            number = new BigDecimal(".".concat(result[1]));
        } while (!number.equals(BigDecimal.ZERO) && output.length() < 5);
        if (output.length() > 5) {
            BigDecimal finalNumber = new BigDecimal(".".concat(output.toString())).setScale(5, RoundingMode.UP);
            String[] finalOutput = finalNumber.toString().split("\\.");
            return finalOutput[1];
        }
        return output.toString();
    }

    private String convertToDecimal(String number) {
        BigDecimal decimal = BigDecimal.ZERO;
        int power = -1;

        for (int i = 0; i < number.length(); i ++) {
            decimal = decimal.add(new BigDecimal(String.valueOf(digitToDecimal(number.charAt(i))))
                    .multiply(BigDecimal.valueOf(Math.pow(source, power--))));
        }
        return decimal.toString();
    }

    private int digitToDecimal(Character digit) {
        return Character.isDigit(digit) ? Integer.parseInt(String.valueOf(digit)) : alphabetMap.get(digit);
    }

    private String digitToBase(int num) {
        return num < 10 ? String.valueOf(num) : digitMap.get(num);
    }
}