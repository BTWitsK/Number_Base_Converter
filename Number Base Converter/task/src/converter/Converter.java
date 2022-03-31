package converter;

import java.util.*;

//TODO: build converter abstract class
//TODO: build hex template
//TODO: build octal template
//TODO:
//TODO:

interface Converter {
    StringBuilder output = new StringBuilder();
    void convert(int from, int to);
}

class BinaryMethod implements Converter {

    @Override
    public void convert(int from, int to) {
        //TODO: implement binary convert method
        System.out.println(output);
    }

}
