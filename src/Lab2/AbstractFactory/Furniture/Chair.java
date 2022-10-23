package Lab2.AbstractFactory.Furniture;

import Lab2.AbstractFactory.Furniture.Furniture;

public class Chair implements Furniture {
    @Override
    public void getItem() {
        System.out.println("Purchased Chair.");
    }
}
