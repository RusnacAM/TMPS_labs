package Lab2.FactoryMethod;

public class Car implements Transporation{
    @Override
    public void useTransportation() {
        System.out.println("Driving car to destination.");
    }
}
