package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bugkiller on 31/12/17.
 */

public class TotalDiamonds {

    private static final int MAX = 1000000;
    private static final int MAX_ROOM_NO = 2000000;
    private static long diamondsInHouse[] = new long[MAX + 1];
    private static long diamondsInRoom[] = new long[MAX_ROOM_NO + 1];
    private static long prefix[] = new long[MAX_ROOM_NO + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t, n;
        precompute();
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            System.out.println(diamondsInHouse[n]);
        }
    }

    private static void precompute() {
        for (int i = 1; i <=MAX_ROOM_NO ; i++)
        {
            diamondsInRoom[i] = getDiamonds(i);
            prefix[i] = diamondsInRoom[i] + prefix[i - 1];
        }
        for (int i = 1; i < MAX; i++) {
            diamondsInHouse[i] = diamondsInHouse[i - 1] + 2 * (prefix[2 * i] - prefix[i]) - diamondsInRoom[2 * i];
        }
    }

    private static long getDiamonds(int roomNo) {
        int evenSum = 0, oddSum = 0, temp;

        while (roomNo > 0) {
            temp = roomNo % 10;

            if (temp % 2 == 0) evenSum += temp;
            else oddSum += temp;

            roomNo /= 10;
        }

        return Math.abs(oddSum - evenSum);
    }
}
