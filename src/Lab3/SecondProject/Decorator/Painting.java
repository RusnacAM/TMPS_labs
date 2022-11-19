package Lab3.SecondProject.Decorator;

import Lab3.SecondProject.Room;

public class Painting extends RoomDecorator {
    public Painting(Room room) {
        super(room);
    }

    public String decorate() {
        return super.decorate() + decorateWithPainting();
    }

    private String decorateWithPainting() {
        return " a new painting.";
    }
}
