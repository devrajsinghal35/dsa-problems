class Solution {

    static final long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {

        long evenPositions = (n + 1) / 2;
        long oddPositions = n / 2;

        long evenWays = power(5, evenPositions);
        long oddWays = power(4, oddPositions);

        return (int)((evenWays * oddWays) % MOD);
    }

    private long power(long base, long exponent) {

        if (exponent == 0) {
            return 1;
        }

        long half = power(base, exponent / 2);

        long result = (half * half) % MOD;

        if (exponent % 2 == 1) {
            result = (result * base) % MOD;
        }

        return result;
    }
}