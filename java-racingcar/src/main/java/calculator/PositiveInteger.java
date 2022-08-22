package calculator;

public class PositiveInteger {

    private int number;

    private PositiveInteger() { }

    private PositiveInteger(String number) {
        this(Integer.parseInt(number));
    }

    private PositiveInteger(int number) {
        validateNumber(number);
        this.number = number;
    }

    public static PositiveInteger from(int number) {
        return new PositiveInteger(number);
    }

    public static PositiveInteger from(String number) {
        return new PositiveInteger(number);
    }

    private void validateNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 올 수 없습니다.");
        }
    }

    public int sum(PositiveInteger positiveInteger) {
        return positiveInteger.number + this.number;
    }
}
