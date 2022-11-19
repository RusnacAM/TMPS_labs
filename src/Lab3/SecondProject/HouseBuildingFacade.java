package Lab3.SecondProject;

import Lab3.SecondProject.Composite.*;
import Lab3.SecondProject.Decorator.*;

public class HouseBuildingFacade {
    public void buildHouse() {
        System.out.println("Building house.");

        //Sketch the house plan
        Room livingRoom = new LivingRoom();
        Room bedroom = new Bedroom();
        Room kitchen = new Kitchen();
        Room bathRoom = new Bathroom();
        Room guestRoom = new Guestroom();

        HousePlan housePlan = new HousePlan();
        housePlan.add(livingRoom);
        housePlan.add(bedroom);
        housePlan.add(kitchen);
        housePlan.add(bathRoom);
        housePlan.add(guestRoom);

        housePlan.build();

        //Decorate the house
        livingRoom = new Plant(new Painting(new RoomImpl()));
        System.out.println("Living room" + livingRoom.decorate());

        bedroom = new Plant(new Poster(new Painting(new Chair(new RoomImpl()))));
        System.out.println("Bedroom" + bedroom.decorate());

        kitchen = new Table(new Chair(new Painting(new RoomImpl())));
        System.out.println("Kitchen" + kitchen.decorate());

        bathRoom = new Plant(new RoomImpl());
        System.out.println("Bathroom" + bathRoom.decorate());

        guestRoom = new Chair(new Plant(new Poster(new RoomImpl())));
        System.out.println("Guesroom" + guestRoom.decorate());

        housePlan.clear();
    }
}
