# Lab3. Structural Patterns

&nbsp;&nbsp;&nbsp;&nbsp;This laboratory work is structured into 2 different projects,
exploring 5 of the structural patterns:

- Adapter
- Bridge
- Composite
- Decorator
- Facade

&nbsp;&nbsp;&nbsp;&nbsp;The First project includes the adapter and Bridge pattern, while the second
focuses on composite, decorator, and facade.

### First Project.
&nbsp;&nbsp;&nbsp;&nbsp;The first project combines the adapter and bridge pattern for a simple
application to read books on kindle in different formats.

#### Adapter
&nbsp;&nbsp;&nbsp;&nbsp;Adapter is a structural design pattern that allows objects 
with incompatible interfaces to collaborate. In this example, the
incompatible interfaces are the unsupported file formats for kindle,
pdf and azw4.

&nbsp;&nbsp;&nbsp;&nbsp;The original interface is the FileFormat class, which holds the file formats
for pdf and azw4 files. The implementations of this interface simply reads
their respective file format:

    public void readAzw4(String bookName) {
        System.out.println("Reading azw4 file. Book Name: " + bookName);
    }

&nbsp;&nbsp;&nbsp;&nbsp;As for the adapter interface, the adapter interface is the SupportedFormat interface.
Its implementation is in the FormatAdapter Class, the adapter class, which
for the unsupported formats creates new instances, and allows the files to 
be read:

    if(fileType.equalsIgnoreCase("pdf")) {
           unsupportedFormat = new PdfFormat();

    if(fileType.equalsIgnoreCase("pdf")) {
            unsupportedFormat.readPdf(bookName);

&nbsp;&nbsp;&nbsp;&nbsp;The concrete class that implements the SupportedFormat interface 
is the Kindle class, which first checks through its supported file types,
and reads them, else it goes through the adapter for the unsupported format
types, or prints a message if the format type is not supported and can't 
be adapted either.

     else if (fileType.equalsIgnoreCase("pdf") || fileType.equalsIgnoreCase("azw4")) {
            formatAdapter = new FormatAdapter(fileType);
            formatAdapter.read(fileType, bookName);

#### Bridge

&nbsp;&nbsp;&nbsp;&nbsp;Bridge is a structural design pattern that lets 
you split a large class or a set of closely related 
classes into two separate hierarchies—abstraction and 
implementation—which can be developed independently of 
each other.

&nbsp;&nbsp;&nbsp;&nbsp;This project, for the bridge pattern, contains two layers of abstraction:
the genre of the ebook, and its format type.

&nbsp;&nbsp;&nbsp;&nbsp;The abstraction of the file type is represented by the FileType interface,
and the AZW3 and EPUB classes, are the classes that implement it. The interface
simply contains a method to read these files.

The abstract class Ebook, consists of a reference (a bridge) to the 
FileType object:

    protected FileType fileType;

    public Ebook(FileType fileType) {
        this.fileType = fileType;
    }

    abstract public String getFile();

&nbsp;&nbsp;&nbsp;&nbsp;The concrete implementations of Ebook, are the classes Fantasy and Romance,
which utilize the method from the FileType interface as well. Thus, it is 
possible to create an Ebook object and pass the desired format type to it
through a "bridge".

&nbsp;&nbsp;&nbsp;&nbsp;The way in which these two patterns are combined, can be seen in the main
class, where through the bridge pattern an ebook objects is created,
a format type is passed to it, and using the format type from the object,
it is passed to the kindle, which is able to read this file, with 
supported on unsupported format types.

### Second Project.

&nbsp;&nbsp;&nbsp;&nbsp;The Second project more or less simulated the process of building a 
a simple house by elaborating a house plan, building the rooms, and
decorating them. This is accomplished with the composite, decorator, and 
facade patterns.

#### Composite

&nbsp;&nbsp;&nbsp;&nbsp;Composite is a structural design pattern that lets you compose 
objects into tree structures and then work with these structures 
as if they were individual objects. The pattern can be broken down
into:

- component - the base interface for all the objects in the composition.
- leaf - implements the default behavior of the base component.
- composite - has leaf elements.

&nbsp;&nbsp;&nbsp;&nbsp;The base component  is represented by the interface Room, which is 
actually the same interface used for the decorator pattern as well (more 
will be elaborated in the decorator pattern segment of the report.)
Form the 2 methods in the Room interface, the void method build() is the
relevant one for the composite pattern.

    public interface Room {
        public String decorate();
        public void build();
    }

&nbsp;&nbsp;&nbsp;&nbsp;For the leaf components, those are the rooms a typical house might have,
in this case, the classes: bathroom, bedroom, guestroom, kitchen, and 
living room. The leaf component are all implementations of the Room
interface (the decorate method is ignored here).

&nbsp;&nbsp;&nbsp;&nbsp;As for the composite element, the one that unites all of the leaf components
together, that is represented by the HousePlan class. This class
is nothing else but another implementation of the Room interface, and it holds a
collection of Room components.
However, for a composite element, the build method instead iterates over
the list of all the leaf components and calls the respective method.

    private List<Room> rooms = new ArrayList<Room>();

    @Override
    public void build() {
        for(Room r: rooms) {
            r.build();
        }
    }

&nbsp;&nbsp;&nbsp;&nbsp;Besides this method, it also contains methods for adding, and removing
elements from this list, as well as clearing the list completely.

    public void add(Room r) {
        this.rooms.add(r);
    }

    public void remove(Room r) {
        this.rooms.remove(r);
    }

    public void clear() {
        System.out.println("Clearing all drawings from house plan.");
        this.rooms.clear();
    }

#### Decorator

&nbsp;&nbsp;&nbsp;&nbsp;Decorator is a structural design pattern that lets you 
attach new behaviors to objects by placing these objects inside 
special wrapper objects that contain the behaviors.

&nbsp;&nbsp;&nbsp;&nbsp;For the decorator pattern, the Room interface is the one used, shared 
by the composite pattern, and the respective method for the decorator pattern
is decorate(). The implementation is held in the RoomImpl class, in which
it just adds a new decoration to the house.

&nbsp;&nbsp;&nbsp;&nbsp;The decorator itself is represented by the RoomDecorator class, which
is an abstract class, which also implements Room. This class holds a 
standard constructor, the object itself, and the method it implemented method
will simply call the decorate() from the interface.

     public RoomDecorator(Room room) {
        this.room = room;
    }

&nbsp;&nbsp;&nbsp;&nbsp;The decorating elements are represented by the classes: chair, painting,
plant, poster, and table. These decorators extend the abstract class RoomDecorator
and modify its decorate() method accordingly. For the painting decorator, for
example:

    public String decorate() {
        return super.decorate() + decorateWithPainting();
    }

    private String decorateWithPainting() {
        return " a new painting.";
    }

And thus, this pattern permits as many decorator as needed to be added at 
runtime.

&nbsp;&nbsp;&nbsp;&nbsp;The composite and decorator patterns are often used together. When
decorator and composite are used together, they will usually have a 
common parent calls, or in this case, the Room class. Combining the
two allows to add features and responsibilities to composites and 
leafs with decorators, thus using composition over inheritance.
The way they are combined in this project is best represented by the
following diagram:

![Decorator composite diagram](https://i.stack.imgur.com/4Xxj4.png)

#### Facade

&nbsp;&nbsp;&nbsp;&nbsp;Facade is a structural design pattern that provides a simplified 
interface to a library, a framework, or any other complex set 
of classes. In this project, the facade class is the one that nicely
ties everything together and create a "house builder" that easily
accessed to build and decorate rooms of a house in just one single line.

&nbsp;&nbsp;&nbsp;&nbsp;The facade class, here name HouseBuildingFacade, contains the method
buildHouse(), which in itself contains all the necessary steps, and
combines all the work done from the composite and decorator class.
This method for creates objects for every room a house might need,
after which, it builds them, then decorated them, and it ends with 
clearing the room list.

&nbsp;&nbsp;&nbsp;&nbsp;All of these steps, while not complicated, are tedious to write
over and over again each time a new house might be needed to be built.
That is exactly the point of this facade class, in the main class, it
is observed how this process is simplified from around 30-40 lines for building a
house, to just one:

    house1.buildHouse();

