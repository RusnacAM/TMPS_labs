# Lab4. Behavioural Patterns

&nbsp;&nbsp;&nbsp;&nbsp;This laboratory work is structured into 2 different projects,
exploring 5 of the behavioural patterns:

- Iterator
- Memento
- State
- Strategy
- Visitor

&nbsp;&nbsp;&nbsp;&nbsp;The First project includes the first 3 patterns mentioned -
iterator, memento, and state, and the second project contains strategy and visitor.

### First Project.
<div style="text-align: justify">&nbsp;&nbsp;&nbsp;&nbsp;The first project simulates the process of placing an order at a restaurant.
It goes through the steps: getting and reading the menu, picking a dish
from the menu to order, and waiting for the order. This is done through the
iterator, memento and state patterns.</div>

### Iterator
<div style="text-align: justify">&nbsp;&nbsp;&nbsp;&nbsp;Iterator is a behavioral design pattern that lets you traverse 
elements of a collection without exposing its underlying representation 
(list, stack, tree, etc.).</div>

<div style="text-align: justify">&nbsp;&nbsp;&nbsp;&nbsp;The iterator pattern implements the logic for the menu and simulates
reading through the menu as well as getting specific items from add to 
place an order.</div>

<div style="text-align: justify">&nbsp;&nbsp;&nbsp;&nbsp;First the Iterator interface declares the operations required for 
traversing a collection, such as : fetching the next element, getting the 
current element, and restarting the iteration if necessary.</div>

    void reset();
    E next();
    E currentItem();
    boolean hasNext();

<div style="text-align: justify">&nbsp;&nbsp;&nbsp;&nbsp;The concrete iterator is the class MenuIterator, which implements the interface.
In it is contained all the logic of actually iterating through the collection/
menu items, which here are just represented by a List of the type MenuItem[],
where Menu Item is simply a class with getters and setters to specify the name of
the dish whhich will be on the menu:</div>

    public MenuItem(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

Back to the concrete iterator, it takes this list of dishes, and implements
the logic:

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

The Collection interface, here MenuCollection, declares the iterator 
function which returns the iteration:

    Iterator<E> iterator();

<div style="text-align: justify">&nbsp;&nbsp;&nbsp;&nbsp;he concrete collection is MenuItemCollection, implements the interface
and returns a new instance of a particular concrete iterator class each time
the client requests one:</div>

     @Override
    public Iterator iterator() {
        return new MenuIterator(dishes);
    }

<div style="text-align: justify">&nbsp;&nbsp;&nbsp;&nbsp;The Menu Class is not actually part of the Iterator pattern, but it
contains all the logic of showcasing how this pattern work, and 
primarily has 3 important methods for the client. First, it creates the 
actual menu</div>

    MenuCollection<MenuItem> list = new MenuItemCollection(menuItems);

And then it gives the client 2 choices, they can display the whole menu to 
read it:

     public void readMenu(MenuCollection<MenuItem> menuCollection, Iterator<MenuItem> iterator) {
        iterator.reset();
        int count = 1;
        while (iterator.hasNext()) {
            MenuItem currentItem = iterator.next();
            System.out.println(count + ". " + currentItem.getName());
            count++;
        }
    }

or the client can just pick one item from the menu to then pass to
the memento pattern, and place a specific order:

    iterator.reset();
        while (iterator.hasNext()) {
            MenuItem currentItem = iterator.next();
            if(currentItem.getName().equals(name)) {
                return currentItem.getName();
            }
        }
        return "There is no such item on the menu.";

### Memento
<div style="text-align: justify">&nbsp;&nbsp;&nbsp;&nbsp;Memento picks up where iterator left off. Memento is a behavioral design pattern that lets you save and restore the previous state of an object without revealing the details of its implementation,
and this is used to simulate picking/changing and placing a final order.</div>

<div style="text-align: justify">&nbsp;&nbsp;&nbsp;&nbsp;The Originator class can produce snapshots of its own state, as well as
restore its state when needed.</div>

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }

The Memento itself is a value object that acts as a snapshot of the 
originator's state.

    private String state;
    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

<div style="text-align: justify">&nbsp;&nbsp;&nbsp;&nbsp;And finally CareTaker can keep track of the originator’s 
history by storing a stack of mementos. When the originator has to 
travel back in history, the caretaker fetches the topmost memento 
from the stack and passes it to the originator’s restoration method.</div>

    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return  mementoList.get(index);
    }

<div style="text-align: justify">&nbsp;&nbsp;&nbsp;&nbsp;In the driver code, we can see how through the use of iterator, we can
set a menu item as the state of memento, we can change or restore it
any time we want, and finally place an order:</div>

    originator.setState(menu.getFoodItem(menuCollection, iterator, "Burger"));
        originator.setState(menu.getFoodItem(menuCollection, iterator, "Pizza"));
        careTaker.add(originator.saveStateToMemento());

        originator.setState(menu.getFoodItem(menuCollection, iterator, "Lava cake"));
        careTaker.add(originator.saveStateToMemento());

        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("First saved Order: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("Second saved Order: " + originator.getState());

        originator.setState(menu.getFoodItem(menuCollection, iterator, "Cheesecake"));
        System.out.println("Current Order: " + originator.getState() + "\n");

This is the output you get, when you execute this code up until this point:

    1. Lasagna
    2. Burger
    3. Chicken Pesto
    4. Caesar Salad
    5. Pizza
    6. Tomato Soup
    7. Crumble Apple pie
    8. Banana split
    9. Lava cake
    10. Cheesecake

    First saved Order: Pizza
    Second saved Order: Lava cake
    Current Order: Cheesecake

You can see how the client changes the order multiple times through memento,
and then decides on the final order.

### State
<div style="text-align: justify">&nbsp;&nbsp;&nbsp;&nbsp;State is a behavioral design pattern that lets an object alter its 
behavior when its internal state changes. It appears as if the object changed its class.
State is the last step in this project, and it simulates the order being 
places in 3 different states: placed order, preparing the order, and receiving 
the order.</div>

<div style="text-align: justify">&nbsp;&nbsp;&nbsp;&nbsp;The Order class is the actual order, with its states, and it has some
basic getters and setters to get the current state of the order, 
this is also called the Context:</div>

    public OrderState getState() {
        return state;
    }

    public void previousState() {
        state.prev(this);
    }

    public void nextState() {
        state.next(this);
    }

    public void printStatus() {
        state.printStatus();
    }

The State interface declares the state specific methods:

    void next(Order order);
    void prev(Order order);
    void printStatus();

<div style="text-align: justify">&nbsp;&nbsp;&nbsp;&nbsp;And the remaining 3 classes are the concrete states: PlacedOrderState, 
PreparingOrderState, and ReceivedOrderState.These provide their own implementations
for the state specific methods. For example, the PreparingOrderState:</div>
    
    @Override
    public void next(Order order) {
        order.setState(new ReceivedOrderState());
    }

    @Override
    public void prev(Order order) {
        order.setState(new PlacedOrderState());
    }

    @Override
    public void printStatus() {
        System.out.println("Order is being prepared, it will soon be ready.");
    }

The other 2 classes have similar implementations. In the driver code:

    order.printStatus();

    order.nextState();
    order.printStatus();

    order.nextState();
    order.printStatus();

    order.nextState();
    order.printStatus();

And the result of the simulation looks like this:

    1. Lasagna
    2. Burger
    3. Chicken Pesto
    4. Caesar Salad
    5. Pizza
    6. Tomato Soup
    7. Crumble Apple pie
    8. Banana split
    9. Lava cake
    10. Cheesecake

    First saved Order: Pizza
    Second saved Order: Lava cake
    Current Order: Cheesecake
    
    The order was placed, it is being taken to be prepared in the kitchen.
    Order is being prepared, it will soon be ready.
    The order has finished preparing and was sent back to the client.

### Second Project.
<div style="text-align: justify">&nbsp;&nbsp;&nbsp;&nbsp;The second project simulates the shopping experience of placing items
in a cart, getting a total sum for your products, and applying
a discount to your purchase if the sum you bought meets the requirements.
The strategy and visitor patterns were applied here.</div>

### Visitor
<div style="text-align: justify">&nbsp;&nbsp;&nbsp;&nbsp;Visitor is a behavioral design pattern that lets you separate 
algorithms from the objects on which they operate. Through this pattern,
the process of a shopping cart, adding items, and checking out with a total
sum for all the products is done.</div>

<div style="text-align: justify">&nbsp;&nbsp;&nbsp;&nbsp;The Visitor interface declares a set of visiting methods that can
take concrete elements of an object structure as arguments. This is
of course the ShoppingCartVisitor class:</div>

    int visit(Clothes clothes);
    int visit(DecorativeItem decorativeItem);

<div style="text-align: justify">&nbsp;&nbsp;&nbsp;&nbsp;Where ShoppingCartVisitorImpl is the concrete visitor which implements
several versions of the same behaviours, tailored for different concrete
element classes.</div>

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

The Element interface, here named Item, declares a method for "accepting"
visitors:

    int accept(ShoppingCartVisitor visitor);

and Clothes and DecorativeItem are both the concrete element, which implement
the acceptance method:
    
        @Override
    public int accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }

In the Main class, first the items are added to the shopping cart:

     Item[] items = new Item[]{new Clothes(50, "Pants"), new Clothes(25, "Shirt"),
                new Clothes(125, "Coat"), new DecorativeItem(30, "lamp"),
                new DecorativeItem(10, "Vase")};
        int total = getPrice(items);
        System.out.println("Total = " + total);

and the getPrice method, invokes the visitor to get the total sum of items:

    ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        int sum = 0;
        for(Item item: items) {
            sum = sum + item.accept(visitor);
        }
        return sum;


### Strategy
<div style="text-align: justify">&nbsp;&nbsp;&nbsp;&nbsp;Strategy is a behavioral design pattern that lets you define a 
family of algorithms, put each of them into a separate class, and 
make their objects interchangeable. The family of algorithms here are
some algorithms that apply a discount according to the sum of your purchase
done with the visitor pattern.</div>

<div style="text-align: justify">&nbsp;&nbsp;&nbsp;&nbsp;The Context maintains a reference to one of the concrete strategies and
communicates with this object via the strategy interface:</div>

    public double executeStrategy(int amount) {
        return strategy.discount(amount);
    }

The strategy interface declares a method the context uses to execute a strategy.

    double discount(int amount);

<div style="text-align: justify">&nbsp;&nbsp;&nbsp;&nbsp;BigDiscountStrategy and SmallDiscountStrategy are the concrete strategy, and 
depending on the amount give, it will apply different discounts. Here is
an example from the small discount strategy:</div>

    @Override
    public double discount(int amount) {
        if(amount <= 100) {
            return amount - (amount * smallDiscount);
        } else if(amount <=500) {
            return amount - (amount * averageDiscount);
        } else if(amount > 500) {
            return amount - (amount * averageDiscount);
        }
        return amount;
    }

The context calls the execution method on the linked strategy object each time it needs
to run the algorithm.

    Context context = new Context(new BigDiscountStrategy());
    Context context1 = new Context(new SmallDiscountStrategy());

    System.out.println(total + " after big discount: " + context.executeStrategy(total));
    System.out.println(total + " after small discount: " + context1.executeStrategy(total) + "\n");

Here is an example of the whole output, using visitor and strategy together:

    Pants, price = 50
    Shirt, price = 25
    Coat, price = 125
    lamp, price = 30
    Vase, price = 10
    Total = 240
    240 after big discount: 240.0
    240 after small discount: 168.0
    
    Bag, price = 700
    Shoes, price = 250
    Coat, price = 300
    Pillow, price = 150
    Total = 1400
    1400 after big discount: 350.0
    1400 after small discount: 980.0