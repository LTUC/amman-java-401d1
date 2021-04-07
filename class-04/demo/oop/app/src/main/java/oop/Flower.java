package oop;

import garden.Plant;

public class Flower extends Plant {

    // Encapsulation -> private variables + public setters and getters


    // method overloading -> 2 functions with the same name and different arguments in the same class

    // access modifiers -> public, protected, private
    private boolean isBloomed;
    private int height = 0;
    public static final int chopHeight = 2;

    public Flower(){
    }

    public Flower(String flowerName, String color){
        super(flowerName, color);
    }

    public Flower(String flowerName, String color, int height){
        this(flowerName, color);
        this.setHeight(height);
    }

    public boolean isBloomed() {
        return isBloomed;
    }

    public void setBloomed(boolean bloomed) {
        isBloomed = bloomed;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void grow(){
        this.height++;
    }

    public static void chop(Flower flower){
        flower.setHeight(0);
        flower.setBloomed(false);
    }
}
