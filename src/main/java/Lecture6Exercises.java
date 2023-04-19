import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lecture6Exercises {

    /*
     *   implement a function that takes an array of int and return sum of
     *   elements at even positions
     *   lecture 6 page  16
     */
    public long calculateEvenSum(int[] arr) {
        long res = 0;
        for (int i = 0; i < arr.length; i += 2) {
            res += arr[i];
        }
        return res;
    }

    /*
     *   implement a function that takes an array of int and return that
     *   array in reverse order
     *   lecture 6 page 16
     */
    public int[] reverseArray(int[] arr) {
        int n = arr.length;
        int[] reversed = new int[n];
        for (int i = 0; i < n; i++) {
            reversed[n-i-1] = arr[i];
        }
        return reversed;
    }

    /*
     *   implement a function that calculate product of two 2-dim matrices
     *   lecture 6 page 21
     */
    public double[][] matrixProduct(double[][] m1, double[][] m2) throws RuntimeException {
        if (m2.length != m1[0].length) {
            throw new RuntimeException();
        }
        double[][] prod = new double[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++)
                    prod[i][j] += m1[i][k] * m2[k][j];
            }
        }
        return prod;
    }

    /*
     *   implement a function that return array list of array list of string
     *   from a 2-dim string array
     *   lecture 6 page 30
     */
    public List<List<String>> arrayToList(String[][] names) {
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            list.add(Arrays.asList(names[i]));
        }
        return list;
    }

    /*
     *   implement a function that return a list of prime factor of integer n
     *   in ascending order
     *   lecture 6 page 30
     */
    public List<Integer> primeFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                if (isPrime(i)) {
                    factors.add(i);
                }
            }
        }
        return factors;
    }

    private boolean isPrime(int n){
        for(int i = 2; i < n ;i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    /*
     *   implement a function that return a list of words in a given string
     *   lecture 6 page 30
     */
    public List<String> extractWord(String line) {
        return Arrays.asList(line.split("[^a-zA-Z]+"));
    }
}
