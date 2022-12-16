package Lab4.FirstProject.Iterator;

public class MenuIterator implements Iterator{
    private MenuItem[] dishes;
    private int pos;

    public MenuIterator(MenuItem[] dishes) {
        this.dishes = dishes;
        pos = 0;
    }

    @Override
    public void reset() {
        pos = 0;
    }

    @Override
    public MenuItem next() {
        return dishes[pos++];
    }

    @Override
    public MenuItem currentItem() {
        return dishes[pos];
    }

    @Override
    public boolean hasNext() {
        if(pos >= dishes.length) {
            return false;
        }
        return true;
    }
}
