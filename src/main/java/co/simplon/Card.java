package co.simplon;

public class Card {
    private String pin;
    private String userId;

    public Card(String pin, String userId) {
        this.pin = pin;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public String getPin() {
        return pin;
    }
}
