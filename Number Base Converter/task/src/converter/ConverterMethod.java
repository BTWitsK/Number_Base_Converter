package converter;

interface ConverterMethod {
    StringBuilder output = new StringBuilder();
    String convert(int from);
}

class BinaryMethod implements ConverterMethod {

    @Override
    public String convert(int from) {
        //TODO: implement binary convert method
        System.out.println(output);
    }
}

class HexMethod implements ConverterMethod {

    @Override
    public String convert(int from) {
        //TODO: implement hex convert method
        System.out.println(output);
    }
}

class OctalMethod implements ConverterMethod {

    @Override
    public String convert(int from) {
        //TODO: implement octal convert method
        System.out.println(output);
    }
}