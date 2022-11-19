package Lab3.SecondProject.Composite;

import Lab3.SecondProject.Room;

public class Bedroom implements Room {

    @Override
    public void build() {
        System.out.println("Building new Bedroom.");
    }

    @Override
    public String decorate() {
        return null;
    }
}
