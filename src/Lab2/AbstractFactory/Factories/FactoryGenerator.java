package Lab2.AbstractFactory.Factories;

public class FactoryGenerator {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("Item")){
            return new FurnitureFactory();
        } else if(choice.equalsIgnoreCase("Style")){
            return new StyleFactory();
        }
        return null;
    }
}
