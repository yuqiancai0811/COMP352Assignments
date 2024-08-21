//comp 352 summer 2024
//programming assignment 1

import java.io.*;

/**
 * This class implements an Oddonacci sequence calculator. Oddonacci numbers are inspired
 * by Fibonacci numbers but start with three predetermined values, each value afterwards
 * being the sum of the preceding three values. In this program will calculate the number by Trinary, linear and tail versions
 * Also measure the corresponding run times and redirect the output into the OddoOut.txt file.
 */
public class Oddonacci {
    /**Recursively calculates the nth Oddonacci number (trinary recursion).
     * @param n integer positive number, which calculates the nth position's Oddonacci number
     * @return the result of the nth Oddonacci number
     */
    public static long trinaryOddonacci(int n) {
        if (n == 1 || n == 2 || n == 3) return 1;
        else return trinaryOddonacci(n - 1) + trinaryOddonacci(n - 2) + trinaryOddonacci(n - 3);

    }

    /** Recursively calculates the nth Oddonacci number (linear recursion).
     * @param n  integer positive number, which calculates the nth position's Oddonacci number
     * @return an array which the third element of this array is the result of the nth Oddonacci number
     */
    public static long[] linearOddonacci(int n) {
        if (n == 1) {
            return new long[]{1, 0, 0};
        }
        if (n == 2) {
            return new long[]{1, 1, 0};
        }
        if (n == 3) {
            return new long[]{1, 1, 1};
        } else {
            long[] previous = linearOddonacci(n - 1);
            return new long[]{previous[1], previous[2], previous[0] + previous[1] + previous[2]};
        }
    }

    /**Recursively calculates the nth Oddonacci number (Tail recursion).
     * @param n  integer positive number, which calculates the nth position's Oddonacci number
     * @param a the third previous Oddonacci number  of nth Oddonacci number, initailly as 1
     * @param b the second previous Oddonacci number  of nth Oddonacci number, initailly as 1
     * @param c the first previous Oddonacci number  of nth Oddonacci number, initailly as 1
     * @return c, the sum of preceding 3 values, is the result of the nth Oddonacci number
     */
    public static long tailRecursiveOddonacci(int n, long a, long b, long c) {
        if (n == 1) {
            return a;
        }
        if (n == 2) {
            return b;
        }
        if (n == 3) {
            return c;
        } else {
            return tailRecursiveOddonacci(n - 1, b, c, a + b + c);
        }
    }

    public static void main(String[] args) {

        File oddoOut = new File("OddoOut.txt"); //results output file
        FileWriter oddoOutWriter; //writer to output file

        try {
            oddoOutWriter = new FileWriter(oddoOut);
        } catch (FileNotFoundException e) {
            System.out.println("Output file not found, exiting...");
            return;
        } catch (IOException e) {
            System.out.println("Output file could not be created, exiting...");
            return;
        }

        //calculates until 40th position's Oddonacci numbers in 5-increments
        try {
            for (int n = 5; n <= 40; n += 5) {
                long startTime_Tri = System.nanoTime();
                long result_Tri = trinaryOddonacci(n);
                long endTime_Tri = System.nanoTime();

                long startTime_L = System.nanoTime();
                long result_L = linearOddonacci(n)[2];
                long endTime_L = System.nanoTime();

                long startTime_Tail = System.nanoTime();
                long result_Tail = tailRecursiveOddonacci(n, 1, 1, 1);
                long endTime_Tail = System.nanoTime();
                // Calculate the duration_T in nanoseconds and convert to milliseconds
                long duration_Tri = (endTime_Tri - startTime_Tri); // Convert to milliseconds for easier readability
                long duration_L = (endTime_L - startTime_L);
                long duration_Tail = (endTime_Tail - startTime_Tail);

                // Write the results and durations to the file
                oddoOutWriter.write("trinaryOddonacci(" + n + ") = " + result_Tri + "\n");
                oddoOutWriter.write("Time taken: " + duration_Tri + " ns\n");
                oddoOutWriter.write("linearOddonacci(" + n + ") = " + result_L + "\n");
                oddoOutWriter.write("Time taken: " + duration_L + " ns\n");
                oddoOutWriter.write("tailRecursiveOddonacci(" + n + ") = " + result_Tail + "\n");
                oddoOutWriter.write("Time taken: " + duration_Tail + " ns\n");
                oddoOutWriter.write("----------------------------------------\n");
                oddoOutWriter.flush();
            }
            oddoOutWriter.close();
        } catch (IOException e) {
            System.out.println("Failed to write into the output file, exiting...");
        }

    }

}