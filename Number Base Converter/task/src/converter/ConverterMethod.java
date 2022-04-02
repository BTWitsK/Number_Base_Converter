package converter;

interface ConverterMethod {
    StringBuilder output = new StringBuilder();
    StringBuilder convertToDec(int number);
    int base = 0;

    default StringBuilder convertFromDec(String number) {
        return output.append(fromDecHelper(0, Integer.parseInt(number), 0));
    }

    default double fromDecHelper(double total, int currentNumber, int power) {
        return currentNumber < 10 ? total + currentNumber * Math.pow(base, power) :
                fromDecHelper(total + currentNumber % 10 * Math.pow(base, power),
                        currentNumber / 10, ++power);
    }
}

class BinaryMethod implements ConverterMethod {
    int base = 2;

    @Override
    public StringBuilder convertToDec(int number) {
        return number == 0 ? output :
                number % base == 0 ? convertToDec(number / base).append("0") :
                        convertToDec(number / base).append("1");
    }
}

class OctalMethod implements ConverterMethod {
    int base = 8;

    @Override
    public StringBuilder convertToDec(int number) {
        return number == 0 ? output : convertToDec(number / base).append(number % base);
    }
}

class HexMethod implements ConverterMethod {
    int base = 16;

    @Override
    public StringBuilder convertToDec(int number) {
        String remainder = switch (number % base) {
            case 10 -> "A";
            case 11 -> "B";
            case 12 -> "C";
            case 13 -> "D";
            case 14 -> "E";
            case 15 -> "F";
            default -> String.valueOf(number % base);
        };
        return number == 0 ? output : convertToDec(number / base).append(remainder);
    }

    @Override
    public StringBuilder convertFromDec(String number) {
        int total = 0;

        for (int i = number.length() - 1; i > 0; i--) {
            total += switch(String.valueOf(number.charAt(i)).toUpperCase()) {
                case "A" -> 10;
                case "B" -> 11;
                case "C" -> 12;
                case "D" -> 13;
                case "E" -> 14;
                case "F" -> 15;
                default -> Integer.parseInt(number);
            };
        }
        return output.append(total);
    }
}