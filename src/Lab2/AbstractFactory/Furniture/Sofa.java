package Lab2.AbstractFactory.Furniture;

import Lab2.AbstractFactory.Furniture.Furniture;

public class Sofa implements Furniture {
    @Override
    public void getItem() {
        System.out.println("Purchased Sofa.");
    }
}
