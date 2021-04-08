package oop;

public class Rose extends Flower {
    private int thorns;

    public Rose(String name, int bloomHeight,String color){
        super(name,bloomHeight,color);
    }

    public int getThorns() {
        return thorns;
    }

    public void setThorns(int thorns) {
        this.thorns = thorns;
    }

    @Override
    public void grow(){
        this.thorns++;
        super.grow();
    }

//    @Override
//    public String toString() {
//        return "Rose{" +
//                "name=" + this.getName() +
//                ", color=" + this.getColor() +
//                ", thorns=" + thorns +
//                ", is Bloomed?" + this.isBloomed()+
//                '}';
//    }
}
