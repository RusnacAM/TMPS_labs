package Lab4.SecondProject.Visitor;

public class DecorativeItem implements Item{
    private int price;
    private String name;

    public DecorativeItem(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public int accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }
}
