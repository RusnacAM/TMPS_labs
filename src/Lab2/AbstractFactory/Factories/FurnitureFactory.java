package Lab2.AbstractFactory.Factories;

import Lab2.AbstractFactory.Furniture.Bed;
import Lab2.AbstractFactory.Furniture.Chair;
import Lab2.AbstractFactory.Furniture.Furniture;
import Lab2.AbstractFactory.Furniture.Sofa;
import Lab2.AbstractFactory.Styles.Style;

public class FurnitureFactory implements AbstractFactory {
    @Override
    public Furniture pickItem(String item) {
        if(item == null){
            return null;
        }
        if(item.equalsIgnoreCase("Chair")){
            return new Chair();
        } else if(item.equalsIgnoreCase("Bed")){
            return new Bed();
        } else if(item.equalsIgnoreCase("Sofa")){
            return new Sofa();
        }
        return null;
    }

    @Override
    public Style pickStyle(String style) {
        return null;
    }
}
