package Lab4.FirstProject.State;

public interface OrderState {
    void next(Order order);
    void prev(Order order);
    void printStatus();
}
