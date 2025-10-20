package calculator;

public class StringParser {
    public static String[] parseBasic(String input) {
        return input.split("[,:]", -1);
    }
}
