import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem4 {
    public double minDistBrute(double [][] p){
        double min =  Double.MAX_VALUE;

        for (int i = 0; i < p.length ; i++) {
            for(int j = i + 1;j < p.length;j++ ){
                double distX = p[i][0] -  p[j][0];
                double distY = p[i][1] -  p[j][1];
                double dist = Math.sqrt((distX*distX) + (distY*distY));
                if(dist<min){
                    min = dist;
                }
            }
        }


        return min;
    }

    public double minDistSmart(double [][] p){
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < p.length; i++) {
            points.add(new Point(p[i][0], p[i][1]));
        }
        points.sort(Comparator.comparingDouble(point -> point.x));

        return closest(points);
    }

    private static class Point {
        double x;
        double y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
    private double closest(List<Point> points){
        int n = points.size();
        if(n <= 3){
            return innerBruteForce(points);
        }

        int mid = n/2;
        List<Point> leftHalf = points.subList(0, mid);
        List<Point> rightHalf = points.subList(mid, n);

        double leftDist = closest(leftHalf);
        double rightDist = closest(rightHalf);

        double dist = Math.min(leftDist, rightDist);

        Point middlePoint = points.get(mid);

        List<Point> strip = new ArrayList<>();

        for (Point point : points) {
            if(Math.abs(point.x - middlePoint.x) < dist){
                strip.add(point);
            }
        }
        double stripDist = stripClosest(strip,dist);
        return Math.min(dist, stripDist);
    }

    private double stripClosest(List<Point> strip, double dist){
        double min = dist;
        strip.sort(Comparator.comparingDouble(point -> point.x));

        for(int i = 0 ; i < strip.size() ; i++){
            for(int j = i + 1; j < strip.size() && (strip.get(j).y -strip.get(i).y <min); j++){
                double distance = distance(strip.get(i), strip.get(j));
            }
            if(dist<min){
                min = dist;
            }
        }
        return min;
    }
    private double distance(Point a, Point b) {

        double dx = a.x - b.x;
        double dy = a.y - b.y;

        return Math.sqrt(dx * dx + dy * dy);
    }
    private double innerBruteForce(List<Point> points) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                double distance = distance(points.get(i), points.get(j));
                if (distance < min) {
                    min = distance;
                }
            }
        }
        return min;
    }

    static void main() {
//        var solver = new Problem4();
//        System.out.println(solver.minDistSmart(new double[][]{{0,0},{3,4},{5,-3}}));
//        System.out.println(solver.minDistBrute(new double[][]{{0,0},{3,4},{5,-3}}));

        var solver = new Problem4();
        long startBrute = System.nanoTime();
        double resultBrute = solver.minDistBrute(new double[][]{{0,0},{3,4},{5,-3}});
        long endBrute = System.nanoTime();

        long startSmart = System.nanoTime();
        double resultSmart = solver.minDistSmart(new double[][]{{0,0},{3,4},{5,-3}});
        long endSmart = System.nanoTime();

        long bruteTime = endBrute - startBrute;
        long smartTime = endSmart - startSmart;

        System.out.println("Brute result: " + resultBrute);
        System.out.println("Smart result: " + resultSmart);

        System.out.println("Brute-force time: " + bruteTime + " ns");
        System.out.println("Smart time: " + smartTime + " ns");
    }
}