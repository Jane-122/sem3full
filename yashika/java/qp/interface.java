// Interface P
interface P {
    int p = 10; // Data member (constant in interfaces)

    void disp(); // Abstract method
}

// Interface P1 inherits P
interface P1 extends P {
    int p1 = 20; // Data member (constant in interfaces)

    void dispP1(); // Abstract method
}

// Interface P2 inherits P
interface P2 extends P {
    int p2 = 30; // Data member (constant in interfaces)

    void dispP2(); // Abstract method
}

// Class Q implements both P1 and P2
class Q implements P1, P2 {

    // Implementing method from P
    @Override
    public void disp() {
        System.out.println("Value of p from interface P: " + p);
    }

    // Implementing method from P1
    @Override
    public void dispP1() {
        System.out.println("Value of p1 from interface P1: " + p1);
    }

    // Implementing method from P2
    @Override
    public void dispP2() {
        System.out.println("Value of p2 from interface P2: " + p2);
    }
}

// Main class to test the program
public class Main {
    public static void main(String[] args) {
        // Instantiate class Q
        Q q = new Q();

        // Invoke each method
        q.disp();   // Method from P
        q.dispP1(); // Method from P1
        q.dispP2(); // Method from P2
    }
}