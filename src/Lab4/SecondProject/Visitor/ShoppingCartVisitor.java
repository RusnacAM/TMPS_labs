package Lab4.SecondProject.Visitor;

public interface ShoppingCartVisitor {
    int visit(Clothes clothes);
    int visit(DecorativeItem decorativeItem);
}
