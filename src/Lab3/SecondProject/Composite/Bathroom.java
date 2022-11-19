package Lab3.SecondProject.Composite;

import Lab3.SecondProject.Room;

public class Bathroom implements Room {
    @Override
    public void build() {
        System.out.println("Building new Bathroom.");
    }

    @Override
    public String decorate() {
        return null;
    }
}
