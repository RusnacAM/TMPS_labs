package Lab3.SecondProject.Decorator;

import Lab3.SecondProject.Room;

public class Poster extends RoomDecorator {
    public Poster(Room room) {
        super(room);
    }

    public String decorate() {
        return super.decorate() + decorateWithPoster();
    }

    private String decorateWithPoster() {
        return " an interesting poster.";
    }
}
