package calculator;

public class InputValidator {
    public static void validateNumbers(String[] numbers) {
        for (String number : numbers) {
            validateNumber(number.trim());
        }
    }

    private static void validateNumber(String number) {
        if (number.isEmpty()) {
            throw new IllegalArgumentException("숫자가 없습니다.");
        }

        try {
            int value = Integer.parseInt(number);
            if (value < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
}
