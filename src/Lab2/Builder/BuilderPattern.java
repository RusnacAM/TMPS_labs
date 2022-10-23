package Lab2.Builder;

public class BuilderPattern {
    public static void main(String[] args) {
        EmployeeBuilder builder = new EmployeeBuilder();
        Director director = new Director(builder);
        System.out.println(director.buildEmployee());

    }
}
