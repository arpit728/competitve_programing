package problems.codechef;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Arpit on 12-Dec-15.
 */
public class CalculateDistances {

    private double pointx1;
    private double pointy1;
    private double pointx2;
    private double pointy2;

    private double distance;

    public double getPointx1() {
        return pointx1;
    }

    public void setPointx1(double pointx1) {
        this.pointx1 = pointx1;
    }

    public double getPointy1() {
        return pointy1;
    }

    public void setPointy1(double pointy1) {
        this.pointy1 = pointy1;
    }

    public double getPointx2() {
        return pointx2;
    }

    public void setPointx2(double pointx2) {
        this.pointx2 = pointx2;
    }

    public double getPointy2() {
        return pointy2;
    }

    public void setPointy2(double pointy2) {
        this.pointy2 = pointy2;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double x1, y1, x2, y2, distance, x2minusx1, y2minusy1;
        ArrayList<CalculateDistances> listOfPoints = new ArrayList<CalculateDistances>();
        // we want to find the distance in 10 cases.
        for (int i = 0; i < 5; i++) {
            // "example of input: 2 3 4 3" It means: point1(2,3) & point2(4,3)
            String line = scan.nextLine();/*.trim();*/
            String[] points = line.split("\\s");
            System.out.println(Arrays.toString(points));
            x1 = Double.parseDouble(points[0]);
            y1 = Double.parseDouble(points[1]);
            x2 = Double.parseDouble(points[2]);
            y2 = Double.parseDouble(points[3]);
            CalculateDistances obj = new CalculateDistances();
            obj.setPointx1(x1);
            obj.setPointy1(y1);
            obj.setPointx2(x2);
            obj.setPointy2(y2);
            listOfPoints.add(obj);
        }
        scan.close();

		/*
		 * Distance Formula: Given the two points (x1, y1) and (x2, y2), the
		 * distance between these points is given by the formula:
		 * squareRoot((x2-x1)^2+(y2-y1)^2)
		 */
        for (CalculateDistances cd : listOfPoints) {
            x2minusx1 = cd.getPointx1() - cd.getPointx2();
            y2minusy1 = cd.getPointy1() - cd.getPointy2();
            distance = Math.sqrt(Math.pow(x2minusx1, 2)
                    + Math.pow(y2minusy1, 2));
            System.out.println((int)distance);
        }
    }
}
