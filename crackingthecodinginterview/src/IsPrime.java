/**
 * 如果在 該數的平方根之前找不到可以除盡的，後面也就不用找了
 */
public class IsPrime {
    public static void main(String[] args) {
        IsPrime p = new IsPrime();
        p.isPrime(21);
    }

    boolean isPrime(int n) {
        for (int x = 2; x * x <= n; x++) {
            if (n % x == 0) {
                return false;
            }
        }
        return true;
    }

}
