package Lab2.Prototype;

public class Employee implements Prototype{
    private String firstName;
    private String lastName;
    private int age;
    private String phone;
    private String email;

    public Employee(String firstName, String lastName, int age, String phone, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public Prototype getClone() {
        return new Employee(firstName, lastName, age, phone, email);
    }


    @Override
    public String toString() {
        String res = "First Name: " + firstName + "\nLast Name: " + lastName +
                "\nAge: " + age + "\nPhone: " + phone + "\nEmail: " + email;
        return res;
    }
}
