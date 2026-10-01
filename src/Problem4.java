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
        // your code here
        return 0.0;
    }

    static void main() {
        // you can test your code here.
        var solver = new Problem4();
        System.out.println(solver.minDistBrute(new double[][]{{0,0},{3,4},{5,-3}}));
    }
}