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
    public String convert(int from) {
        //TODO: implement hex convert method

    }
}

