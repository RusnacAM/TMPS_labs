package Lab3.SecondProject.Composite;

import Lab3.SecondProject.Room;

import java.util.ArrayList;
import java.util.List;

public class HousePlan implements Room {
    private List<Room> rooms = new ArrayList<Room>();

    @Override
    public void build() {
        for(Room r: rooms) {
            r.build();
        }
    }

    public void add(Room r) {
        this.rooms.add(r);
    }

    public void remove(Room r) {
        this.rooms.remove(r);
    }

    public void clear() {
        System.out.println("Clearing all drawings from house plan.");
        this.rooms.clear();
    }

    @Override
    public String decorate() {
        return null;
    }
}
