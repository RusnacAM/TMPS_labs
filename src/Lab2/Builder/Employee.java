package Lab2.Builder;

public class Employee {
    private String firstName;
    private String lastName;
    private int age;
    private String phone;
    private String email;

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public String toString() {
        String res = "First Name: " + firstName + "\nLast Name: " + lastName +
                "\nAge: " + age + "\nPhone: " + phone + "\nEmail: " + email;
        return res;
    }
}
