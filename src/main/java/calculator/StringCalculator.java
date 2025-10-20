package calculator;

import camp.nextstep.edu.missionutils.Console;

public class StringCalculator {
    public void run() {
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();
            int result = calculateSum(input);
            System.out.println("결과: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public int calculateSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers = StringParser.parse(input);
        InputValidator.validateNumbers(numbers);

        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number.trim());
        }
        return sum;
    }
}
