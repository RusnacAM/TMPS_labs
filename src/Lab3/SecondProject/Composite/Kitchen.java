package Lab3.SecondProject.Composite;

import Lab3.SecondProject.Room;

public class Kitchen implements Room {
    @Override
    public void build() {
        System.out.println("Building new Kitchen.");
    }

    @Override
    public String decorate() {
        return null;
    }
}
