package hiringchallenges;

/**
 * Created by arpit on 26/5/17.
 */
public class RunLengthEncoding {

    public static void main(String[] args) {

        System.out.println(collapseString("zabb"));
    }

    static String collapseString(String input) {


        char ch=input.charAt(0);
        int cnt = 0, n = input.length();
        StringBuilder sbr = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (input.charAt(i) == ch) {
                cnt++;
            } else {
                sbr.append(cnt);
                sbr.append(ch);
                ch = input.charAt(i);
                cnt = 1;
            }
        }
        sbr.append(cnt);
        sbr.append(ch);
        return sbr.toString();
    }
}
