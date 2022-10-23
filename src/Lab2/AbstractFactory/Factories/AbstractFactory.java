package Lab2.AbstractFactory.Factories;

import Lab2.AbstractFactory.Furniture.Furniture;
import Lab2.AbstractFactory.Styles.Style;

public interface AbstractFactory {
    Furniture pickItem(String item);
    Style pickStyle(String style);
}
