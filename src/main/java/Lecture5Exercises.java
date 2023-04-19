import java.util.Random;

public class Lecture5Exercises {

    /*
     *   implement a function to create a random password with
     *   given length using lower case letters
     *   lecture 5 page 14
     */
    public String weakPassword(int length) {
        Random rand = new Random();
        String res = "";
        for (int i = 0; i < length; i++) {
            res += (char)(rand.nextInt(26) + 97);
        }
        return res;
    }

    /*
     *   implement a function to create a random password with
     *   given length and at least 1 digit and 1 special character
     *   lecture 5 page 14
     */
    public String strongPassword(int length) throws Exception {
        if (length < 3) {
            throw new Exception("Length must be more than 3");
        }
        Random rand = new Random();
        String res = "";
        res += (char)(rand.nextInt(9)+49);
        res += (char)(rand.nextInt(15)+33);
        res += weakPassword(length-2);
        int newIndex = rand.nextInt(length);
        if (newIndex != 0 && newIndex != 1) {
            res = swap(res, 0, newIndex);
        }
        newIndex = rand.nextInt(length);
        if (newIndex != 0 && newIndex != 1) {
            res = swap(res, 1, newIndex);
        }
        return res;
    }

    public String swap(String str, int i, int j)
    {
        if (j == str.length() - 1) {
            return str.substring(0, i) + str.charAt(j) + str.substring(i + 1, j) + str.charAt(i);
        }
        else {
            return str.substring(0, i) + str.charAt(j) + str.substring(i + 1, j) + str.charAt(i) + str.substring(j + 1);
        }
    }

    /*
     *   implement a function that checks if a integer is a fibobin number
     *   integer n is fibobin is there exist an i where:
     *       n = fib(i) + bin(fib(i))
     *   where fib(i) is the ith fibonacci number and bin(i) is the number
     *   of ones in binary format
     *   lecture 5 page 17
     */
    public boolean isFiboBin(int n) {
        for (int i = 1; i < n; i++) {
            long fib = fibonacci(i);
            if (fib + Long.bitCount(fib) == n) {
                return true;
            }
        }
        return false;
    }

    public long fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
