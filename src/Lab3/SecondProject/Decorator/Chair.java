package Lab3.SecondProject.Decorator;

import Lab3.SecondProject.Room;

public class Chair extends RoomDecorator {
    public Chair(Room room) {
        super(room);
    }

    public String decorate() {
        return super.decorate() + decorateWithChairs();
    }

    private String decorateWithChairs() {
        return " a new chair set.";
    }
}
