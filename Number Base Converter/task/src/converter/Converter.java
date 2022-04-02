package converter;

class Converter{
    enum Mode {
        TO("/to"),
        FROM("/from"),
        EXIT("/exit");

        String choice;

        Mode (String input) {
            this.choice = input;
        }
    }

    private ConverterMethod converter;
    private Mode mode;

    public void setConverter(int method) {
        converter = switch(method) {
            case 2 -> new BinaryMethod();
            case 8 -> new OctalMethod();
            case 16 -> new HexMethod();
            default -> null;
        };
    }

    public void setMode(String input) {
        for (Mode mode : Mode.values()) {
            if (input.equals(mode.choice)) {
                this.mode = mode;
            }
        }
    }

    public Mode getMode() {
        return this.mode;
    }

    public boolean run() {
        return this.mode != Mode.EXIT;
    }

    public void convert(String num) {
        if (mode == Mode.FROM) {
            System.out.println(converter.convertToDec(Integer.parseInt(num)));
        } else {
            System.out.println(converter.convertFromDec(num));
        }
    }
}