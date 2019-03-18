package enums;

public enum Backgrounds {
    BLUE("blue"),
    ORANGE("orange"),
    GREEN("green"),
    RED("red"),
    PURPLE("purple"),
    PINK("pink"),
    LIME("lime"),
    SKY("sky"),
    GREY("grey");

    public final String color;

    Backgrounds(String color) {
        this.color = color;
    }
}
