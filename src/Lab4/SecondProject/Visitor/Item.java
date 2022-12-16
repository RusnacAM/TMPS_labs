package Lab4.SecondProject.Visitor;

public interface Item {
    int accept(ShoppingCartVisitor visitor);
}
