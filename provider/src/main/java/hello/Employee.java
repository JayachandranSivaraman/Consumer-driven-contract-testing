package hello;

public class Employee {

    private final long id;
    private final String name;
    private final String employee_id;
    private final String department;

    public Employee(long id, String name,String employee_id,String department) {
        this.id = id;
        this.name = name;
        this.employee_id=employee_id;
        this.department=department;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmployee_id() {return employee_id;}

    public String getDepartment() {return department;}


}