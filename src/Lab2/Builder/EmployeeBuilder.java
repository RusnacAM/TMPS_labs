package Lab2.Builder;

public class EmployeeBuilder implements Builder{
    private Employee employee;

    public EmployeeBuilder(){
        this.employee = new Employee();
    }

    @Override
    public void setFirstName() {
        employee.setFirstName("Holly");
    }

    @Override
    public void setLastName() {
        employee.setLastName("Wray");
    }

    @Override
    public void setAge() {
        employee.setAge(21);
    }

    @Override
    public void setPhone() {
        employee.setPhone("1234567");
    }

    @Override
    public void setEmail() {
        employee.setEmail("holly.wray@email");
    }

    @Override
    public Employee getEmployee() {
        System.out.println("The requested employee:");
        return employee;
    }
}
