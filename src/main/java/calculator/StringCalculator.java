package calculator;

public class StringCalculator {
    public int calculateSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] numbers = StringParser.parse(input);
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number.trim());
        }
        return sum;
    }
}
