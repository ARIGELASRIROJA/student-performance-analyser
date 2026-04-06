import java.util.*;

class StudentAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        if (n < 2) {
            System.out.println("Need at least 2 students");
            return;
        }

        int[] arr = new int[n];

        System.out.println("Enter marks:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE, secMax = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE, secMin = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int val = arr[i];
            sum += val;

            // Max & Second Max
            if (val > max) {
                secMax = max;
                max = val;
            } else if (val > secMax && val != max) {
                secMax = val;
            }

            // Min & Second Min
            if (val < min) {
                secMin = min;
                min = val;
            } else if (val < secMin && val != min) {
                secMin = val;
            }
        }

        double avg = (double) sum / n;

        int countAboveAvg = 0;
        for (int val : arr) {
            if (val > avg) {
                countAboveAvg++;
            }
        }

        System.out.println("\n--- Analysis ---");
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);

        if (secMax == Integer.MIN_VALUE)
            System.out.println("Second Max: Not available");
        else
            System.out.println("Second Max: " + secMax);

        if (secMin == Integer.MAX_VALUE)
            System.out.println("Second Min: Not available");
        else
            System.out.println("Second Min: " + secMin);

        System.out.println("Average: " + avg);
        System.out.println("Students above average: " + countAboveAvg);
    }
}
