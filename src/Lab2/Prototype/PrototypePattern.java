package Lab2.Prototype;

public class PrototypePattern {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Holly", "Wray", 21, "1234567", "holly.wray@email");
        System.out.println("Employee1 info: ");
        System.out.println(employee1);

        Employee employee2 = (Employee) employee1.getClone();
        System.out.println("\nEmployee2 info: ");
        System.out.println(employee2);

        Manager manager1 = new Manager("Terezi", "Pyrope", 21, "1234567", "terezi.pyrope@email");
        System.out.println("\nManager1 info: ");
        System.out.println(manager1);

        Manager manager2 = (Manager) manager1.getClone();
        System.out.println("\nManager2 info: ");
        System.out.println(manager2);
    }
}
