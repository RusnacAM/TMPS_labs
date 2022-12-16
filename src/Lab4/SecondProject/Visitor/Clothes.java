package Lab4.SecondProject.Visitor;

public class Clothes implements Item{
    private int price;
    private String clothingItem;

    public Clothes(int price, String name) {
        this.price = price;
        this.clothingItem = name;
    }

    public int getPrice() {
        return price;
    }

    public String getClothingItem() {
        return clothingItem;
    }

    @Override
    public int accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }
}
