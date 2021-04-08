package oop;

public class Tulip extends Flower {
    private int bulbSize = 1;

    public Tulip(String name, int bloomHeight, String color) {
        super(name, bloomHeight, color);
    }

//    @Override
//    public void grow() {
//        super.grow();s
//        this.bulbSize++;
//    }

    @Override
    public String toString() {
        return "Tulip{" +
                "name=" + this.getName() +
                ", color=" + this.getColor() +
                ", bulbSize=" + bulbSize +
                ", is Bloomed?" + this.isBloomed()+
                '}';
    }
}
