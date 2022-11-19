package Lab3.SecondProject.Composite;

import Lab3.SecondProject.Room;

public class LivingRoom implements Room {

    @Override
    public void build() {
        System.out.println("Building new Living Room.");
    }

    @Override
    public String decorate() {
        return null;
    }
}
