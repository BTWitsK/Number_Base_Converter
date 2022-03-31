package converter;

interface ConverterMethod {
    StringBuilder output = new StringBuilder();
    StringBuilder convert(int from);
}

class BinaryMethod implements ConverterMethod {
    int base = 2;

    @Override
    public StringBuilder convert(int from) {
        return from == 0 ? output :
                from % base == 0 ? convert(from / base).append("0") :
                        convert(from / base).append("1");
    }
}

class OctalMethod implements ConverterMethod {
    int base = 8;

    @Override
    public StringBuilder convert(int from) {
        return from == 0 ? output : convert(from / base).append(from % base);
    }
}

class HexMethod implements ConverterMethod {
    int base = 16;

    @Override
    public StringBuilder convert(int from) {
        String remainder = switch (from % base) {
            case 10 -> "A";
            case 11 -> "B";
            case 12 -> "C";
            case 13 -> "D";
            case 14 -> "E";
            case 15 -> "F";
            default -> String.valueOf(from % base);
        };
        return from == 0 ? output : convert(from / base).append(remainder);
    }
}