package converter;
import java.math.*;
import java.util.*;

class Converter{
    int source;
    int target;
    boolean run;
    HashMap<Character, Integer> alphabetMap = new HashMap<>();
    HashMap<Integer, Character> digitMap = new HashMap<>();

    public Converter(String input) {
        int decimal = 10;
        String[] parameters = input.split(" ");
        try {
            this.source = Integer.parseInt(parameters[0]);
            this.target = Integer.parseInt(parameters[1]);
            for (char i = 'a'; i <= 'z'; i++) {
                alphabetMap.put(i, decimal);
                digitMap.put(decimal, i);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            this. run = false;
        }
    }

    public boolean isRunning() {
        return run;
    }

    public void convert(String num) {
        if (num.contains(".")) {
            String[] number = num.split("\\.");
            System.out.printf("\nConversion result: %s.%s", convertWhole(number[0]), convertFraction(number[1]));
        } else {
            System.out.printf("\nConversion result: %s", convertWhole(num));
        }
    }

   public String convertWhole (String number) {
        return new BigInteger(number, this.source).toString(this.target);
   }

    public String convertFraction (String number) {
        BigDecimal decimal = new BigDecimal(number);

        decimal = decimal.multiply(new BigDecimal(base).pow(number.length()));

        StringBuilder output = new StringBuilder(decimal.toBigInteger().toString(base));


        return output.toString();
    }

    public String baseLessThan10(Character digit) {
        return Character.isDigit(digit) ?
                Integer.parseInt(String.valueOf(digit)) < 10 ?
                        String.valueOf(digit) : digitMap.get(Integer.parseInt(String.valueOf(digit))).toString()
                : alphabetMap.get(digit).toString();
    }
}