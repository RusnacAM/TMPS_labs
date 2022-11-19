package Lab3.SecondProject.Decorator;

import Lab3.SecondProject.Room;

public class Table extends RoomDecorator {
    public Table(Room room) {
        super(room);
    }

    public String decorate() {
        return super.decorate() + decorateWithTable();
    }

    private String decorateWithTable() {
        return " a long dining table.";
    }
}
