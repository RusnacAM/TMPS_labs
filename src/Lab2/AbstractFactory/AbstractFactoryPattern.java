package Lab2.AbstractFactory;

import Lab2.AbstractFactory.Factories.AbstractFactory;
import Lab2.AbstractFactory.Factories.FactoryGenerator;
import Lab2.AbstractFactory.Furniture.Furniture;
import Lab2.AbstractFactory.Styles.Style;

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        AbstractFactory itemFactory = FactoryGenerator.getFactory("Item");

        Furniture furniture1 = itemFactory.pickItem("Bed");

        furniture1.getItem();

        Furniture furniture2 = itemFactory.pickItem("Chair");

        furniture2.getItem();

        Furniture furniture3 = itemFactory.pickItem("Sofa");

        furniture3.getItem();

        AbstractFactory styleFactory = FactoryGenerator.getFactory("Style");

        Style style1 = styleFactory.pickStyle("Victorian");

        style1.getStyle();

        Style style2 = styleFactory.pickStyle("Retro");

        style2.getStyle();

        Style style3 = styleFactory.pickStyle("Modern");

        style3.getStyle();

    }
}
