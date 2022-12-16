package Lab4.FirstProject.State;

public class PlacedOrderState implements OrderState{
    @Override
    public void next(Order order) {
        order.setState(new PreparingOrderState());
    }

    @Override
    public void prev(Order order) {
        System.out.println("The order is in its root state.");
    }

    @Override
    public void printStatus() {
        System.out.println("The order was placed, it is being taken to be prepared in the kitchen.");
    }
}
