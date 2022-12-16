package Lab4.FirstProject.State;

public class ReceivedOrderState implements OrderState{
    @Override
    public void next(Order order) {
        System.out.println("The order has finished preparing and was sent back to the client.");
    }

    @Override
    public void prev(Order order) {
        order.setState(new PreparingOrderState());
    }

    @Override
    public void printStatus() {
    }
}
