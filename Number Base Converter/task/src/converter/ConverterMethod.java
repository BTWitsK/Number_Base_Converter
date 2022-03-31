package converter;

interface ConverterMethod {
    StringBuilder output = new StringBuilder();
    StringBuilder convert(int from);
}

class BinaryMethod implements ConverterMethod {
    int base = 2;

    @Override
    public StringBuilder convert(int from) {
        if (from == 0) {
            return output;
        }

        return from % base == 0 ? output.append("0").append(convert(from / base)) :
                output.append("1").append(convert(from / base));

    }

}

class OctalMethod implements ConverterMethod {
    double base = 8;

    @Override
    public StringBuilder convert(int from) {
        //TODO: implement octal convert method
        System.out.print(output);
    }
}

class HexMethod implements ConverterMethod {
    double base = 16;

    @Override
    public String convert(int from) {
        //TODO: implement hex convert method
        System.out.println(output);
    }
}

