package Lab4.FirstProject.Iterator;

public interface Iterator<E> {
    void reset();
    E next();
    E currentItem();
    boolean hasNext();
}
