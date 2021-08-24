package core.enums;

public enum Passengers {

    ADULT(0), CHILD(1), BABY(2);

    private final int value;

    Passengers(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}