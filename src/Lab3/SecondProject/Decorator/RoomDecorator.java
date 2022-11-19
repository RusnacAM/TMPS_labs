package Lab3.SecondProject.Decorator;

import Lab3.SecondProject.Room;

public abstract class RoomDecorator implements Room {
    private Room room;

    public RoomDecorator(Room room) {
        this.room = room;
    }

    @Override
    public String decorate() {
        return room.decorate();
    }

    @Override
    public void build() {
    }
}
