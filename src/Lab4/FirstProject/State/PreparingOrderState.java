package Lab4.FirstProject.State;

public class PreparingOrderState implements OrderState{
    @Override
    public void next(Order order) {
        order.setState(new ReceivedOrderState());
    }

    @Override
    public void prev(Order order) {
        order.setState(new PlacedOrderState());
    }

    @Override
    public void printStatus() {
        System.out.println("Order is being prepared, it will soon be ready.");
    }
}
