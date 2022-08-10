/*
    204. Count Primes

    Given an integer n, return the number of prime numbers that are strictly less than n.

    Example 1:
    Input: n = 10
    Output: 4
    Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

    Example 2:
    Input: n = 0
    Output: 0

    Example 3:
    Input: n = 1
    Output: 0
    
    Constraints:
    0 <= n <= 5 * 106
*/
public class Problem204 {
    public int countPrimes(int n) { // Note: count primes strictly less than n
        // initialize boolean array (default false)
        // flip value to true if not prime
        // indexed by 1, ex. trueIsPrime[i] refers to whether if i is prime , # of true occurences
        
        // aka sieve of eratosthenes
        if (n < 2) {
            return 0;
        }
        
        boolean[] falseIsPrime = new boolean[n];
        
        // check multiples upto sqrt(n) since
        // If `n` is not a prime, it can be factored into two factors `a` and `b`: where `n = a * b`.
        // Now `a` and `b` can't both be greater than sqrt(n) since then the product `a * b` would be greater than sqrt(n) * sqrt(n) = `n`.
        // So in any factorization of `n`, at least one of the factors must be smaller than sqrt(n).
        // And if we can't find any factors <= sqrt(n), n must be a prime.
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (falseIsPrime[i] == false) {
                for (int j = i * i; j < n; j += i) {
                    falseIsPrime[j] = true;
                }
            }
        }
        
        int numOfPrimes = 0;
        
        for (int i = 2; i < n; i++) {
            if (!falseIsPrime[i]) {
                numOfPrimes++;
            }
        }
        
        return numOfPrimes;
    }
}