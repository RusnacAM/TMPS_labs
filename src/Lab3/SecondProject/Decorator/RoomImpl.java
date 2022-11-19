package Lab3.SecondProject.Decorator;

import Lab3.SecondProject.Room;

public class RoomImpl implements Room {

    @Override
    public String decorate() {
        return " decoration added: ";
    }

    @Override
    public void build() {
        return;
    }
}
