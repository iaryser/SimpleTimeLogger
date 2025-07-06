package ch.timor.projects.simpletimelogger.view;

public enum CardName {
    LOGIN("Login"), REGISTER("Register"), TIMETRACKER("TimeTracker");
    private final String cardName;

    CardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardName() {
        return this.cardName;
    }
}
