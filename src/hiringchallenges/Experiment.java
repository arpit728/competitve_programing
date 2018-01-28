package hiringchallenges;

/**
 * Created by bugkiller on 8/5/2017.
 */
public class Experiment {
    public static void main(String[] args) {
        F(8, 0, "");
        int a[] = {1, 2, 3, 4, 5};
    }

    static int M = 41;

    static int K = 7;
    static int L = 8;


    static void F(int D, int T, String str) {
        if (T < 0) return;
        if (D == 0) {
            if (T == 0) {
                K--;
                if (K == 0) {
                    System.out.println(str);
                }
            }
        return;
    }
        F(D - 1, T + 1, str + "(");
        F(D - 1, T - 1, str + ")");
    }
}
