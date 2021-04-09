package talkToWeb;

public class TriviaNumber {
    public String text;
    public int number;
    public boolean found;
    public String type;

    @Override
    public String toString() {
        return "TriviaNumber{" +
                "text='" + text + '\'' +
                ", number=" + number +
                ", found=" + found +
                ", type='" + type + '\'' +
                '}';
    }
}
