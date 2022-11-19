package Lab3.SecondProject.Composite;

import Lab3.SecondProject.Room;

public class Guestroom implements Room {
    @Override
    public void build() {
        System.out.println("Building new Guestroom.");
    }

    @Override
    public String decorate() {
        return null;
    }
}
