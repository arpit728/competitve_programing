package misc;

/**
 * Created by arpit on 10/9/16.
 */
public class SimilarNumberPermutations {


    public static void main(String[] args) {
        System.out.println(solution(11122));
    }

    private static int solution(int n) {
        if (n>0 && n<=9)
            return 1;

        byte hash[]=new byte[10];
        byte fact[]=new byte[]{1,1,2,6,24,120};
        char s[]=Integer.toString(n).toCharArray();

        for(int i = 0; i < s.length; i++)
            hash[s[i]-48]++;


        if (s.length-hash[0]==1)
            return 1;

        int f=s.length-hash[0];
        int ans=f*fact[s.length-1];

        for (int i = 0; i < 10; i++)
            if (hash[i]!=0)
                ans/=fact[hash[i]];

        return ans;
    }

}
