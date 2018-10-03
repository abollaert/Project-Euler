import java.util.ArrayList;
import java.util.List;

/**
 * Project Euler #10: Summation of primes.
 *
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 *
 */
public final class solution10 {

    /**
     * A Sieve (https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes).
     */
    private static final class Sieve {

        /** Primes already found. */
        private final List<Long> primes = new ArrayList<>();

        /** The upper bound. */
        private final long bound;

        /**
         * Create a new instance.
         *
         * @param   bound      The upper bound.
         */
        public Sieve(final long bound) {
            this.bound = bound;
        }

        /**
         * Finds all primes up until the upper bound specified.
         */
        public final void findPrimes() {
            for (long i = 2; i < bound; i++) {
                boolean isPrime = true;

                for (final long prime : primes) {
                    if (i % prime == 0) {
                        isPrime = false;
                        break;
                    } else if (prime > Math.sqrt(i)) {
                        break;
                    }
                }

                if (isPrime) {
                    primes.add(i);
                }
            }
        }

        /**
         * Returns the {@link List} of primes found.
         *
         * @return  The List of primes found.
         */
        public final List<Long> getPrimes() {
            return this.primes;
        }
    }

    /**
     * Main method.
     *
     * @param   args        Command line arguments.
     */
    public static final void main(final String[] args) {
        final Sieve sieve = new Sieve(2000000);
        sieve.findPrimes();

        System.out.println(sieve.getPrimes().stream().reduce(Long::sum).get());
    }
}
