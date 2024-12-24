package employee;

public class Emp {
    // Declaring employee details and pay components
    String name;
    int empid;
    String category;
    double bpay;    // Basic pay
    double hra;     // House Rent Allowance
    double da;      // Dearness Allowance
    double npay;    // Net Pay
    double pf;      // Provident Fund
    double grosspay; // Gross Pay
    double incomeTax; // Income tax
    double allowance; // Additional allowance
    
    // Constructor to initialize employee details
    public Emp(String name, int empid, String category, double bpay) {
        this.name = name;
        this.empid = empid;
        this.category = category;
        this.bpay = bpay;
    }

    // Method to calculate HRA, DA, Gross Pay, Allowances, and Tax
    public void calculatePay() {
        hra = 0.2 * bpay;  // HRA is 20% of Basic Pay
        da = 0.1 * bpay;   // DA is 10% of Basic Pay
        allowance = 0.05 * bpay; // Allowance is 5% of Basic Pay
        grosspay = bpay + hra + da + allowance; // Gross Pay = Basic Pay + HRA + DA + Allowance
        pf = 0.12 * bpay;  // Provident Fund is 12% of Basic Pay
        incomeTax = 0.1 * grosspay; // Income Tax is 10% of Gross Pay
        npay = grosspay - pf - incomeTax; // Net Pay = Gross Pay - PF - Income Tax
    }

    // Method to display employee payroll details
    public void displayPayroll() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + empid);
        System.out.println("Category: " + category);
        System.out.println("Basic Pay: " + bpay);
        System.out.println("House Rent Allowance (HRA): " + hra);
        System.out.println("Dearness Allowance (DA): " + da);
        System.out.println("Allowances: " + allowance);
        System.out.println("Gross Pay: " + grosspay);
        System.out.println("Provident Fund (PF): " + pf);
        System.out.println("Income Tax: " + incomeTax);
        System.out.println("Net Pay: " + npay);
    }
}





import employee.Emp; // Import the Emp class from the employee package

public class Emppay {
    public static void main(String[] args) {
        // Create an employee object with necessary details
        Emp e = new Emp("John Doe", 101, "Manager", 50000);
        
        // Calculate the pay details using the method from Emp class
        e.calculatePay();
        
        // Display the payroll information
        e.displayPayroll();
    }
}
