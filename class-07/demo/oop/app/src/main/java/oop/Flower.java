package oop;

public class Flower extends Plant implements Creature {
    private String name;
    private boolean isBloomed;
    private int bloomHeight;

//    public Flower(){
//
//    }

    public Flower(String name,int bloomHeight, String color){
        super(color);
        this.name = name;
        this.bloomHeight = bloomHeight;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBloomed() {
        return isBloomed;
    }

    public void setBloomed(boolean bloomed) {
        isBloomed = bloomed;
    }

    @Override
    public void grow(){
        this.setHeight(this.getHeight()+1);
        if(this.getHeight() >= this.bloomHeight)
            this.isBloomed = true;
    }
}
