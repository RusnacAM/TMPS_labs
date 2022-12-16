package Lab4.SecondProject;

import Lab4.SecondProject.Strategy.BigDiscountStrategy;
import Lab4.SecondProject.Strategy.Context;
import Lab4.SecondProject.Strategy.SmallDiscountStrategy;
import Lab4.SecondProject.Visitor.*;

public class Main {
    public static void main(String[] args) {
        Item[] items = new Item[]{new Clothes(50, "Pants"), new Clothes(25, "Shirt"),
                new Clothes(125, "Coat"), new DecorativeItem(30, "lamp"),
                new DecorativeItem(10, "Vase")};
        int total = getPrice(items);
        System.out.println("Total = " + total);

        Context context = new Context(new BigDiscountStrategy());
        Context context1 = new Context(new SmallDiscountStrategy());

        System.out.println(total + " after big discount: " + context.executeStrategy(total));
        System.out.println(total + " after small discount: " + context1.executeStrategy(total) + "\n");

        Item[] items1 = new Item[]{new Clothes(700, "Bag"), new Clothes(250, "Shoes"),
                new Clothes(300, "Coat"), new DecorativeItem(150, "Pillow")};
        int newTotal = getPrice(items1);
        System.out.println("Total = " + newTotal);

        System.out.println(newTotal + " after big discount: " + context.executeStrategy(newTotal));
        System.out.println(newTotal + " after small discount: " + context1.executeStrategy(newTotal));
    }

    private static int getPrice(Item[] items) {
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        int sum = 0;
        for(Item item: items) {
            sum = sum + item.accept(visitor);
        }
        return sum;
    }


}
