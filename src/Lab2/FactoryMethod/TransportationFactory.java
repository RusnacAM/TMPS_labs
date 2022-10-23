package Lab2.FactoryMethod;

public class TransportationFactory {
    public Transporation getTransportation(String transpType){
        if(transpType == null){
            return null;
        }
        if(transpType.equalsIgnoreCase("Bike")){
            return new Bike();

        } else if(transpType.equalsIgnoreCase("Car")){
            return new Car();

        } else if(transpType.equalsIgnoreCase("Bus")){
            return new Bus();
        }

        return null;
    }
}
