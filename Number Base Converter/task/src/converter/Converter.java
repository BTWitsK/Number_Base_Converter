package converter;

class Converter{
    public ConverterMethod converter;

    public void setConverter(int method) {
        converter = switch(method) {
            case 2 -> new BinaryMethod();
            case 8 -> new OctalMethod();
            case 16 -> new HexMethod();
            default -> null;
        };
    }
    public void convert(int from) {
        System.out.println(converter.convert(from));
    }
}