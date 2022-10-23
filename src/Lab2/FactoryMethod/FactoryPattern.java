package Lab2.FactoryMethod;

public class FactoryPattern {
    public static void main(String[] args) {
        TransportationFactory transportationFactory = new TransportationFactory();

        Transporation transporation1 = transportationFactory.getTransportation("Bike");
        transporation1.useTransportation();

        Transporation transporation2 = transportationFactory.getTransportation("Car");
        transporation2.useTransportation();

        Transporation transporation3 = transportationFactory.getTransportation("Bus");
        transporation3.useTransportation();
    }
}
