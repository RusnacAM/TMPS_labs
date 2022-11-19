package Lab3.SecondProject.Decorator;

import Lab3.SecondProject.Room;

public class Plant extends RoomDecorator {
    public Plant(Room room) {
        super(room);
    }

    public String decorate() {
        return super.decorate() + decorateWithPlant();
    }

    private String decorateWithPlant() {
        return " a nice plant.";
    }
}
