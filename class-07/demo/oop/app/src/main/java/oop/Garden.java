package oop;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Garden {
    ArrayList<Flower> flowers = new ArrayList<>();



    public void plant(){
        Flower roseFlower = new Rose("rose flower",5,"black");
        Flower tulipFlower = new Tulip("tulip flower", 2,"white");

        flowers.add(roseFlower);
        flowers.add(tulipFlower);

        System.out.println(flowers);
    }

    public void water(){
        for(Flower flower:flowers){
            flower.grow();
        }
    }

}
