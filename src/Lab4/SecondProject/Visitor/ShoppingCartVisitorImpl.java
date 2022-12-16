package Lab4.SecondProject.Visitor;

public class ShoppingCartVisitorImpl implements ShoppingCartVisitor{

    @Override
    public int visit(Clothes clothes) {
        int price = 0;
        price = clothes.getPrice();
        System.out.println(clothes.getClothingItem() + ", price = " + price);
        return price;
    }

    @Override
    public int visit(DecorativeItem decorativeItem) {
        int price = 0;
        price = decorativeItem.getPrice();
        System.out.println(decorativeItem.getName() + ", price = " + price);
        return price;
    }
}
