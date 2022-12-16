package Lab4.FirstProject;

import Lab4.FirstProject.Iterator.*;
import Lab4.FirstProject.Memento.CareTaker;
import Lab4.FirstProject.Memento.Originator;
import Lab4.FirstProject.State.Order;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();

        MenuCollection<MenuItem> menuCollection = menu.getMenu();
        Iterator<MenuItem> iterator = menuCollection.iterator();

        menu.readMenu(menuCollection, iterator);
        System.out.println();

        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        Order order = new Order();

        originator.setState(menu.getFoodItem(menuCollection, iterator, "Burger"));
        originator.setState(menu.getFoodItem(menuCollection, iterator, "Pizza"));
        careTaker.add(originator.saveStateToMemento());

        originator.setState(menu.getFoodItem(menuCollection, iterator, "Lava cake"));
        careTaker.add(originator.saveStateToMemento());

        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("First saved Order: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("Second saved Order: " + originator.getState());

        originator.setState(menu.getFoodItem(menuCollection, iterator, "Cheesecake"));
        System.out.println("Current Order: " + originator.getState() + "\n");

        order.printStatus();

        order.nextState();
        order.printStatus();

        order.nextState();
        order.printStatus();

        order.nextState();
        order.printStatus();
    }
}
