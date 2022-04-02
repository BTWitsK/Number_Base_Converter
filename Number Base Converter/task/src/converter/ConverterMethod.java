package converter;

interface ConverterMethod {
    StringBuilder output = new StringBuilder();
    StringBuilder convertToDec(int number);
    StringBuilder convertFromDec(String number);
}

class BinaryMethod implements ConverterMethod {
    int base = 2;

    @Override
    public StringBuilder convertToDec(int number) {
        return number == 0 ? output :
                number % base == 0 ? convertToDec(number / base).append("0") :
                        convertToDec(number / base).append("1");
    }
    //TODO: implement convert to decimal
}

class OctalMethod implements ConverterMethod {
    int base = 8;

    @Override
    public StringBuilder convertToDec(int number) {
        return number == 0 ? output : convertToDec(number / base).append(number % base);
    }
    //TODO: implement convert to decimal
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
    //TODO: implement convert to decimal
}