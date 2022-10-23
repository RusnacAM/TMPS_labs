package Lab2.AbstractFactory.Factories;

import Lab2.AbstractFactory.Furniture.Furniture;
import Lab2.AbstractFactory.Styles.Modern;
import Lab2.AbstractFactory.Styles.Retro;
import Lab2.AbstractFactory.Styles.Style;
import Lab2.AbstractFactory.Styles.Victorian;

public class StyleFactory implements AbstractFactory {

    @Override
    public Style pickStyle(String style) {
        if(style == null){
            return null;
        }
        if(style.equalsIgnoreCase("Victorian")){
            return new Victorian();
        } else if(style.equalsIgnoreCase("Retro")){
            return new Retro();
        } else if(style.equalsIgnoreCase("Modern")){
            return new Modern();
        }
        return null;
    }

    @Override
    public Furniture pickItem(String item) {
        return null;
    }
}
