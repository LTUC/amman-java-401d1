package oop;

public abstract class Plant {
    // abstract classes cannot be instantiated
    private String color;
    private int height;

    public Plant(){

    }

    public Plant(String color){
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
