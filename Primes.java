public class Primes {
    public static boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int multiple = p * p; multiple <= n; multiple += p) {
                    isPrime[multiple] = false;
                }
            }
        }

        return isPrime;
    }
    public static int printPrimes(boolean[] isPrime) {
        int count = 0;
        System.out.println("Prime numbers:");

        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                System.out.println(i);
                count++;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        boolean[] primes = sieve(n);
        int count = printPrimes(primes);

        double percent = 100.0 * count / n;
        System.out.println("There are " + count + " primes between 2 and " + n + " (" + (int)percent + "% are primes)");
    }
}

    
