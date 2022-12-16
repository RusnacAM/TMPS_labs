package Lab4.FirstProject.Iterator;

public class Menu {
    public MenuCollection<MenuItem> getMenu() {
        MenuItem[] menuItems = new MenuItem[10];

        menuItems[0] = new MenuItem("Lasagna");
        menuItems[1] = new MenuItem("Burger");
        menuItems[2] = new MenuItem("Chicken Pesto");
        menuItems[3] = new MenuItem("Caesar Salad");
        menuItems[4] = new MenuItem("Pizza");
        menuItems[5] = new MenuItem("Tomato Soup");
        menuItems[6] = new MenuItem("Crumble Apple pie");
        menuItems[7] = new MenuItem("Banana split");
        menuItems[8] = new MenuItem("Lava cake");
        menuItems[9] = new MenuItem("Cheesecake");

        MenuCollection<MenuItem> list = new MenuItemCollection(menuItems);
        return list;
    }

    public void readMenu(MenuCollection<MenuItem> menuCollection, Iterator<MenuItem> iterator) {
        iterator.reset();
        int count = 1;
        while (iterator.hasNext()) {
            MenuItem currentItem = iterator.next();
            System.out.println(count + ". " + currentItem.getName());
            count++;
        }
    }

    public String getFoodItem(MenuCollection<MenuItem> menuCollection, Iterator<MenuItem> iterator, String name) {
        iterator.reset();
        while (iterator.hasNext()) {
            MenuItem currentItem = iterator.next();
            if(currentItem.getName().equals(name)) {
                return currentItem.getName();
            }
        }
        return "There is no such item on the menu.";
    }
}
