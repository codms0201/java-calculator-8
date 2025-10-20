package calculator;

public class StringParser {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String DELIMITER_SEPARATOR = "\n";
    private static final String DEFAULT_DELIMITERS = "[,;]";

    public static String[] parse(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            return parseCustomDelimiter(input);
        }
        return parseBasic(input);
    }

    private static String[] parseCustomDelimiter(String input) {
        int separatorIndex = input.indexOf(DELIMITER_SEPARATOR);
        if (separatorIndex == -1) {
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }

        String customDelimiter = input.substring(2, separatorIndex);
        String numbers = input.substring(separatorIndex + 1);

        if (customDelimiter.isEmpty()) {
            throw new IllegalArgumentException("구분자가 비어있습니다.");
        }

        return numbers.split(escapeDelimiter(customDelimiter), -1);
    }

    private static String[] parseBasic(String input) {
        return input.split(DEFAULT_DELIMITERS, -1);
    }

    private static String escapeDelimiter(String delimiter) {
        return delimiter.replaceAll("([\\\\.*+?\\[\\](){}|^$])", "\\\\$1");
    }
}
