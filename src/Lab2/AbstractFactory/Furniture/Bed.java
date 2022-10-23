package Lab2.AbstractFactory.Furniture;

import Lab2.AbstractFactory.Furniture.Furniture;

public class Bed implements Furniture {
    @Override
    public void getItem() {
        System.out.println("Purchased Bed.");
    }
}
