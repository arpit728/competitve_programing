package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Long.max;

/**
 * Created by bugkiller on 28/01/18.
 */

public class Triathlon {

    static final int MAX = 200001;
    static TutariaCitizen citizens[]=new TutariaCitizen[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        String s[];
        for (int i = 0; i < MAX; i++) {
            citizens[i] = new TutariaCitizen();
        }
        n = Integer.parseInt(br.readLine());
        for (int i = 1; i <=n; i++) {
            s = br.readLine().split("\\s");
            citizens[i].setCobolTime(Integer.parseInt(s[0]));
            citizens[i].setPoleVaultTime(Integer.parseInt(s[1]));
            citizens[i].setDoughnutsTime(Integer.parseInt(s[2]));
        }
        Arrays.sort(citizens, 1, n + 1);
        System.out.println(solve(citizens, n));

    }

    private static long solve(TutariaCitizen[] citizens, int n) {
        long ans = Long.MIN_VALUE, cobolSum = 0;
        for (int i = 1; i <= n; i++) {
            cobolSum += citizens[i - 1].cobolTime;
            ans = max(ans, cobolSum
                    + citizens[i].cobolTime
                    + citizens[i].poleVaultTime
                    + citizens[i].doughnutsTime);
        }
        return ans;
    }
}
class TutariaCitizen implements Comparable<TutariaCitizen>{
    int cobolTime,poleVaultTime, doughnutsTime;

    public TutariaCitizen(int cobolTime, int poleVaultTime, int doughnutsTime) {
        this.cobolTime = cobolTime;
        this.poleVaultTime = poleVaultTime;
        this.doughnutsTime = doughnutsTime;
    }

    TutariaCitizen() {

    }

    public void setCobolTime(int cobolTime) {
        this.cobolTime = cobolTime;
    }

    public void setPoleVaultTime(int poleVaultTime) {
        this.poleVaultTime = poleVaultTime;
    }

    public void setDoughnutsTime(int doughnutsTime) {
        this.doughnutsTime = doughnutsTime;
    }

    @Override
    public int compareTo(TutariaCitizen citizen) {
        return ((Integer) (citizen.poleVaultTime + citizen.doughnutsTime)).compareTo(this.poleVaultTime + this.doughnutsTime);
    }

    @Override
    public String toString() {
        return "TutariaCitizen{" +
                "cobolTime=" + cobolTime +
                ", poleVaultTime=" + poleVaultTime +
                ", doughnutsTime=" + doughnutsTime +
                '}';
    }
}
