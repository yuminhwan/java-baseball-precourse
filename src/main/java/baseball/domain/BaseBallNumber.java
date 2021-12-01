package baseball.domain;

public class BaseBallNumber {
    private static final String INVALID_NUMBER = "1-9 사이의 숫자를 입력해야 합니다.";

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final int baseballNumber;

    public BaseBallNumber(int baseballNumber) {
        validateNumberRange(baseballNumber);
        this.baseballNumber = baseballNumber;
    }

    private void validateNumberRange(int baseballNumber) {
        if (baseballNumber < MIN_NUMBER || baseballNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_NUMBER);
        }
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof BaseBallNumber &&
            ((BaseBallNumber)obj).baseballNumber == this.baseballNumber;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(baseballNumber);
    }
}
