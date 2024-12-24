class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

class Employee extends Person {
    private String empID;
    private String jobTitle;

    public Employee(String firstName, String lastName, String empID, String jobTitle) {
        super(firstName, lastName);
        this.empID = empID;
        this.jobTitle = jobTitle;
    }

    public String getEmployeeId() {
        return empID;
    }

    @Override
    public String getLastName() {
        return super.getLastName() + ", " + jobTitle;
    }
}

public class Main {
    public static void main(String[] args) {
        Person person = new Person("John", "Doe");
        System.out.println("Person Name: " + person.getFirstName() + " " + person.getLastName());

        Employee employee = new Employee("Jane", "Smith", "E123", "Software Engineer");
        System.out.println("Employee Name: " + employee.getFirstName() + " " + employee.getLastName());
        System.out.println("Employee ID: " + employee.getEmployeeId());
    }
}
