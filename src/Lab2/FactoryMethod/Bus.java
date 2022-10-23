package Lab2.FactoryMethod;

public class Bus implements Transporation{
    @Override
    public void useTransportation() {
        System.out.println("Riding bus to destination.");
    }
}
