package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class LAZYPROG {

    private static Project projects[] = new Project[100000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t, n, a, b, d;
        String s[];
        t = parseInt(br.readLine());
        initProjects();
        while (t-- > 0) {
            n = parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                s = br.readLine().split("\\s");
                a = parseInt(s[0]);
                b = parseInt(s[1]);
                d = parseInt(s[2]);
                projects[i].init(a, b, d);
            }
            Arrays.sort(projects, 0, n, (p1, p2) -> {
                if (p1.d == p2.d) {
                    return Integer.compare(p1.a, p2.a);
                }
                return Integer.compare(p1.d, p2.d);
            });
            System.out.printf("%.2f", solve(n));
        }
    }

    private static double solve(int n) {

        return totalProgrammerAmount(n);
    }

    private static double totalProgrammerAmount(int n) {
        int timeToComplete, totalRunTime = 0;
        double cost = 0;
        for (int i = 0; i < n; i++) {
            timeToComplete = projects[i].d - totalRunTime;
            if (projects[i].b > timeToComplete) {
                cost += ((double) (projects[i].b - timeToComplete) / (double) projects[i].a);
                totalRunTime = projects[i].d;
            } else {
                totalRunTime += projects[i].b;
            }
        }
        return cost;
    }

    private static void initProjects() {
        for (int i = 0; i < 100000; i++) {
            projects[i] = new Project();
        }
    }


    static class Project{
        int a,b, d;
        public void init(int a, int b, int d) {
            this.a = a;
            this.b = b;
            this.d = d;
        }
    }
}
/*
2
2
1 10 10
10 1000 10
2
20 50 100
10 100 50
*/
