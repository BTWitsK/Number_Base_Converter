package converter;

interface ConverterMethod {
    StringBuilder convertFromDec(int number);
    StringBuilder convertToDec(String number);
}

class BinaryMethod implements ConverterMethod {
    StringBuilder output = new StringBuilder();
    int base = 2;

    @Override
    public StringBuilder convertFromDec(int number) {
        return number == 0 ? output :
                number % base == 0 ? convertFromDec(number / base).append("0") :
                        convertFromDec(number / base).append("1");
    }

    @Override
    public StringBuilder convertToDec(String number) {
        return output.append((int) toDecHelper(0, Integer.parseInt(number), 0));
    }

    public double toDecHelper(double total, int currentNumber, int power) {
        return currentNumber < 10 ? total + (currentNumber * Math.pow(base, power)) :
                toDecHelper(total + ((currentNumber % 10) * Math.pow(base, power)),
                        currentNumber / 10, ++power);
    }

}

class OctalMethod implements ConverterMethod {
    StringBuilder output = new StringBuilder();
    int base = 8;

    @Override
    public StringBuilder convertFromDec(int number) {
        return number == 0 ? output : convertFromDec(number / base).append(number % base);
    }

    @Override
    public StringBuilder convertToDec(String number) {
        return output.append((int) toDecHelper(0, Integer.parseInt(number), 0));
    }

    public double toDecHelper(double total, int currentNumber, int power) {
        return currentNumber < 10 ? total + (currentNumber * Math.pow(base, power)) :
                toDecHelper(total + ((currentNumber % 10) * Math.pow(base, power)),
                        currentNumber / 10, ++power);
    }
}

class HexMethod implements ConverterMethod {
    StringBuilder output = new StringBuilder();
    int base = 16;

    @Override
    public StringBuilder convertFromDec(int number) {
        String remainder = switch (number % base) {
            case 10 -> "A";
            case 11 -> "B";
            case 12 -> "C";
            case 13 -> "D";
            case 14 -> "E";
            case 15 -> "F";
            default -> String.valueOf(number % base);
        };
        return number == 0 ? output : convertFromDec(number / base).append(remainder);
    }

    @Override
    public StringBuilder convertToDec(String number) {
        number = number.toUpperCase();
        int power = 0;
        int total = 0;

        for (int i = number.length() - 1; i >= 0; i--) {
            total += toDecHelper(number.charAt(i)) * Math.pow(base, power++);
        }
        return output.append(total);
    }

    public int toDecHelper(Character digit) {
        return switch(digit) {
            case 'A' -> 10;
            case 'B' -> 11;
            case 'C' -> 12;
            case 'D' -> 13;
            case 'E' -> 14;
            case 'F' -> 15;
            default -> Integer.parseInt(digit.toString());
        };
    }
}