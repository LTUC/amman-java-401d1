package garden;

public class Plant {
    private String name; // default
    private String color; // -> accessible from any package

    public Plant(){

    }

    public Plant(String name, String color){
        this.setColor(color);
        this.setName(name);
    }
    // setters and getters
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

