package oop;

public class Rose extends Flower {
    private int thorns;

    public Rose(String roseName, String roseColor, int height){
        super(roseName,roseColor,4);
    }

    public Rose(String roseName, String roseColor, int height, int thorns){
        super(roseName,roseColor,4);
        this.setThorns(thorns);

    }

    public int getThorns() {
        return thorns;
    }

    public void setThorns(int thorns) {
        this.thorns = thorns;
    }

    // override - 2 classes, inheritance, same function name same arguments
    @Override
    public void grow(){
        this.thorns++;
       // super.grow();
    }

    @Override
    public String toString() {
        return "Rose{" +
                "thorns=" + thorns +
                '}';
    }
}
