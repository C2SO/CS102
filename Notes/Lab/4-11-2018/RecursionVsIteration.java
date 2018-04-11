public class RecursionVsIteration {

    int powerIteration(int k, int n) {
        int tempPow = 1;
        if (n == 0) {
            return tempPow;
        } else {
            for (int i = 1; i <= n; i++) {
                tempPow *= k;
            }
            return tempPow;
        }
    }

    int powerRecursion(int k, int n) {
        int result;
        if (n == 0) {
            result = 1;
        } else {
            result = k * powerRecursion(k, n - 1);
        }
        return result;
    }
    
}