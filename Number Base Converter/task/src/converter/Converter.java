package converter;

import java.util.*;

class Converter{
    public ConverterMethod converter;

    public void setConverter(int method) {
        converter = switch(method) {
            case 2 -> converter = new BinaryMethod();
            case 8 -> converter = new OctalMethod();
            case 16 -> converter = new HexMethod();
            default -> null;
        };
    }

    public void convert(int from) {
        System.out.println(converter.convert(from));
    }
}