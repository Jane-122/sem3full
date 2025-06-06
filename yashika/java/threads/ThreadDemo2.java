

class NewThread implements Runnable {
Thread t;
NewThread() {

// Create a new, second thread
t = new Thread(this, "Demo Thread");
System.out.println("Child thread: " + t);
t.start(); // Start the thread, this will call run method
}
public void run() { // This is the entry point for the second thread.
try {
for(int i = 5; i> 0; i--) {
System.out.println("Child Thread: " + i);
Thread.sleep(500);
}
}
catch (InterruptedException e) {
System.out.println("Child interrupted.");
}
System.out.println("Exiting child thread.");
}
}
class ThreadDemo2 {
public static void main(String args[]) {
new NewThread(); // create a new thread
try {
for(int i = 5; i> 0; i--) {
System.out.println("Main Thread: " + i);
Thread.sleep(1000);
}
}
catch (InterruptedException e) {
System.out.println("Main thread interrupted.");
}
System.out.println("Main thread exiting.");
}
}