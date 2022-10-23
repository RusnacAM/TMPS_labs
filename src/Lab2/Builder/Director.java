package Lab2.Builder;

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
