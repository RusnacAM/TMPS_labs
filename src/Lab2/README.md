# Lab2. Creational Patterns

## Overview:

- Factory Method
- Abstract Factory
- Builder
- Prototype
- Singleton

### Factory Method
&nbsp;&nbsp;&nbsp;&nbsp;Factory Method is a creational design pattern that provides 
an interface for creating objects in a superclass, but allows 
subclasses to alter the type of objects that will be created.

&nbsp;&nbsp;&nbsp;&nbsp;For the Factory Method, the supercllas is represented by the 
interface ***Transportation*** in which is a single function to be 
implemented:

    public interface Transporation {
        void useTransportation();
    }

&nbsp;&nbsp;&nbsp;&nbsp;As for the subclasses, there are 3 which implement the interace 
Transpotation: 

- Bike
- Car
- Bus

as such:

    public class Bike implements Transporation{
    @Override
    public void useTransportation() {
        System.out.println("Riding bike to destination.");
        }
    }

&nbsp;&nbsp;&nbsp;&nbsp;For the actual factory method, according to the requested subclass,
it creates a new instance of this class:

     public Transporation getTransportation(String transpType){
        if(transpType == null){
            return null;
        }
        if(transpType.equalsIgnoreCase("Bike")){
            return new Bike();

        } else if(transpType.equalsIgnoreCase("Car")){
            return new Car();

        } else if(transpType.equalsIgnoreCase("Bus")){
            return new Bus();
        }
        return null;
     }

### Abstract Factory
&nbsp;&nbsp;&nbsp;&nbsp;Abstract Factory is a creational design pattern that lets you produce families of related objects without specifying their concrete classes.

&nbsp;&nbsp;&nbsp;&nbsp;The first step is to declare interfaces for a set of distinct but related
products which make up the product family. These interfaces are stored in
the ***furniture*** and ***styles*** packages. The first interface is ***Furniture***, the other
is ***Style*** with *getItem()* and *getStyle()* methods respectively:

    public interface Furniture {
        void getItem();
    }
These interfaces represent the Abstract Products.

&nbsp;&nbsp;&nbsp;&nbsp;For the Furniture interface, the classes *Bed*, *Chair*, and *Sofa* implement it.
For the Styles, the classes *Modern*, *Retro*, and *Victorian* implement it.
All of these represent the Concrete Products, the implementations of the 
abstract products.

All factory methods are stored in the Factories package:

- Abstract Factory
- Furniture Factory
- Style Factory

&nbsp;&nbsp;&nbsp;&nbsp;Abstract Factory is the abstract factory itself, which contains the set of
methods for creating each of the abstract products.

    public interface AbstractFactory {
        Furniture pickItem(String item);
        Style pickStyle(String style);
    }

&nbsp;&nbsp;&nbsp;&nbsp;***FurnitureFactory*** and ***StyleFactory*** are the concrete factories, which implement
the creation methods of the abstract factory, much like in the factory method
pattern.

    @Override
    public Furniture pickItem(String item) {
        if(item == null){
            return null;
        }
        if(item.equalsIgnoreCase("Chair")){
            return new Chair();
        } else if(item.equalsIgnoreCase("Bed")){
            return new Bed();
        } else if(item.equalsIgnoreCase("Sofa")){
            return new Sofa();
        }
        return null;
    }

&nbsp;&nbsp;&nbsp;&nbsp;The ***FactoryGenerator*** has the function any factory or product subclass
to the client code:

    public class FactoryGenerator {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("Item")){
            return new FurnitureFactory();
        } else if(choice.equalsIgnoreCase("Style")){
            return new StyleFactory();
        }
        return null;
        }
    }

### Builder
&nbsp;&nbsp;&nbsp;&nbsp;Builder is a creational design pattern that lets you construct 
complex objects step by step. The pattern allows you to produce 
different types and representations of an object using the same 
construction code.

&nbsp;&nbsp;&nbsp;&nbsp;In order to achieve this, first there will be a builder interface, in 
which all product construction common steps for every type of
builder are declared:

    public interface Builder {
        void setFirstName();
        void setLastName();
        void setAge();
        void setPhone();
        void setEmail();
        Employee getEmployee();
    }

&nbsp;&nbsp;&nbsp;&nbsp;The concrete builders - ***EmployeeBuilder***, provides an implementation method
of the construction steps. There can be multiple different builders that
implement the same steps to produce different results. In this case, EmployeeBuilder:

     private Employee employee;

    public EmployeeBuilder(){
        this.employee = new Employee();
    }

    @Override
    public void setFirstName() {
        employee.setFirstName("Holly");
    }

&nbsp;&nbsp;&nbsp;&nbsp;This employee builder, implements the steps of building the employee
according to the ***Employee*** class:

    public class Employee {
        private String firstName;
        private String lastName;
        private int age;
        private String phone;
        private String email;
        ...
    }

&nbsp;&nbsp;&nbsp;&nbsp;The ***Director*** class defines the order in which to call construction steps,
so you can create and reuse specific configurations of the product:

    public class Director {
        private EmployeeBuilder employeeBuilder;
    
        public Director(EmployeeBuilder employeeBuilder){
            this.employeeBuilder = employeeBuilder;
        }
    
        public Employee buildEmployee(){
            this.employeeBuilder.setFirstName();
            this.employeeBuilder.setLastName();
            this.employeeBuilder.setAge();
            this.employeeBuilder.setPhone();
            this.employeeBuilder.setEmail();
            return this.employeeBuilder.getEmployee();
        }
    }

&nbsp;&nbsp;&nbsp;&nbsp;Lastly, the client, represented by the ***BuilderPattern Class***, must associate one
of the builder objects with the director:

    EmployeeBuilder builder = new EmployeeBuilder();
    Director director = new Director(builder);
    System.out.println(director.buildEmployee());

### Prototype
&nbsp;&nbsp;&nbsp;&nbsp;Prototype is a creational design pattern that lets you copy 
existing objects without making your code dependent on their classes.

&nbsp;&nbsp;&nbsp;&nbsp;The Prototype Registry provides an easy way to access 
frequently-used prototypes. It stores a set of pre-built objects 
that are ready to be copied. Here ***Prototype*** is a simple interface
with one method: *getClone()*.

The two classes, employee and manager both implement this interface,
and as for the clone method, the same in both:

    @Override
    public Prototype getClone() {
        return new Employee(firstName, lastName, age, phone, email);
    }

Makes a simple clone of the exact object, as seen in ***PrototypePattern*** main class

### Singleton
&nbsp;&nbsp;&nbsp;&nbsp;Singleton is a creational design pattern that lets you ensure that a 
class has only one instance, while providing a global access point to 
this instance.

&nbsp;&nbsp;&nbsp;&nbsp;For this to be possible, there is one requirement, for the constructor
to be hidden from the client code, and be set to private:

     private Database(){}

&nbsp;&nbsp;&nbsp;&nbsp;The ***Database*** class declares the static method *getInstance()*, which returns
the same instance of its own class, if there is no instance, it creates and
returns a new one:

    public static Database getInstance(int id){
        if(Database.instance == null){
            Database.instance = new Database();
        }
        return Database.instance;
    }