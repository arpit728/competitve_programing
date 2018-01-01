package hiringchallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by arpit on 17/5/17.
 */
public class TwitterTrends {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n;
        String s;
        HashMap<String,Integer>map=new HashMap<>();
        StringBuilder sbr=new StringBuilder();
        n=Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            s=br.readLine();
            int tweetSize=s.length();
            addHashtags(s,tweetSize,map);
        }
        System.out.print(trendingHashtags(map));
    }

    private static StringBuilder trendingHashtags(HashMap<String, Integer> map) {

        StringBuilder sbr = new StringBuilder();
        Tag[] tags = new Tag[map.size()];
        String[] s = new String[map.size()];
        map.keySet().toArray(s);
        for (int i = 0; i < s.length; i++) {
            tags[i] = new Tag(s[i], map.get(s[i]));
        }
        Arrays.sort(tags);
        for (int i = 0; i < tags.length && i<5; i++) {
            sbr.append("#"+tags[i].s+"\n");
        }
        return sbr;
    }

    private static void addHashtags(String s, int tweetSize, HashMap<String, Integer> map) {
        int j;
        StringBuilder sbr = new StringBuilder();
        for (int i = 0; i < tweetSize; i++) {
            sbr.setLength(0);
            if (s.charAt(i) == '#') {
                for (j = i + 1; j < tweetSize; j++) {
                    if (s.charAt(j) != ' ' && s.charAt(j)!='#') {
                        sbr.append(s.charAt(j));
                    } else {
                        updateKeyValue(map, sbr.toString());
                        break;
                    }
                }
                if (j == tweetSize)
                    updateKeyValue(map, sbr.toString());
            }
        }
    }

    private static void updateKeyValue(HashMap<String, Integer> map, String s) {
        if (map.containsKey(s)) {
            int temp = map.get(s);
            temp++;
            map.put(s,temp);
        }
        else {
            map.put(s, 1);
        }
    }

    static class Tag implements Comparable<Tag>{

        String s;
        int count;

        public Tag(String s, int count) {
            this.s = s;
            this.count = count;
        }

        @Override
        public int compareTo(Tag tag) {
            if (this.count==tag.count){
                return s.compareTo(tag.s);
            }

            return ((Integer)tag.count).compareTo(count);
        }
    }
}
