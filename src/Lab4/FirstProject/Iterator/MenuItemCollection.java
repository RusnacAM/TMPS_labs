package Lab4.FirstProject.Iterator;

public class MenuItemCollection implements MenuCollection {
    private MenuItem[] dishes;

    public MenuItemCollection(MenuItem[] dishes) {
        this.dishes = dishes;
    }

    @Override
    public Iterator iterator() {
        return new MenuIterator(dishes);
    }
}
