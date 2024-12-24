import java.util.Scanner;

class Random {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char choice;
        int num;
        int[] numbers = new int[100];
        int count;

        do {
            count = 0;
            System.out.println("Enter numbers (type -1 when you want to terminate):");
            
            while (true) {
                num = sc.nextInt();
                if (num == -1) {
                    break;
                }
                numbers[count] = num;
                count++;
            }

            if (count > 0) {
                int largest = numbers[0];
                int smallest = numbers[0];
                int sum = 0;

                for (int i = 0; i < count; i++) {
                    sum += numbers[i];

                    if (numbers[i] > largest) {
                        largest = numbers[i];
                    }
                    if (numbers[i] < smallest) {
                        smallest = numbers[i];
                    }
                }

                double average = (double) sum / count;

                System.out.println("Largest: " + largest);
                System.out.println("Smallest: " + smallest);
                System.out.println("Sum: " + sum);
                System.out.println("Average: " + average);
            } else {
                System.out.println("No numbers were entered.");
            }

            System.out.println("Do you want to continue? (y/n):");
            sc.nextLine();
            choice = sc.nextLine().charAt(0);

        } while (choice == 'y' || choice == 'Y');

        System.out.println("Thank you for using the program!");
        sc.close();
    }
}
