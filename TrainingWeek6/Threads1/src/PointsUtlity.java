import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PointsUtlity {
    public static Map<Point, Point> outMap = new HashMap<>();

    public static Map<Point, Point> generatePoints() {
        List<Point> points = new ArrayList<>();
        // Map<Point, Point> outMap = new HashMap<>();
        Random rand = new Random();
        for (int i = 1; i < 100_000; i++) {
            points.add(new Point(rand.nextInt(10_000), rand.nextInt(10_000)));
        }
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                outMap = doCalculations(points, 0, points.size() / 4, outMap);
            }
        });
        Thread tTest = new Thread(() -> outMap = doCalculations(points, 0, points.size() / 4, outMap));
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                outMap = doCalculations(points, points.size() / 4, points.size() / 2, outMap);
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                outMap = doCalculations(points, points.size() / 2, (points.size() / 4) * 3, outMap);
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                outMap = doCalculations(points, (points.size() / 4) * 3, points.size(), outMap);
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        while (t1.isAlive() && t2.isAlive() && t3.isAlive() && t4.isAlive()) {
            System.out.println("Calculating...");
        }

        return outMap;
    }

    public static Map<Point, Point> getNearestPoints(List<Point> generatedPoints) {
        Map<Point, Point> nearestPoints = new HashMap<>();
        double baseDist = Double.MAX_VALUE;
        for (int i = 0; i < generatedPoints.size(); i++) {
            Point basePoint = generatedPoints.get(i);
            Point secondaryPoint = null;
            for (int j = 0; j < generatedPoints.size(); j++) {
                Point testPoint = generatedPoints.get(j);
                if (testPoint.equals(basePoint)) {
                    continue;
                }

                double xd = basePoint.getX() - testPoint.getX();
                double yd = basePoint.getY() - testPoint.getY();
                double dist = Math.sqrt(Math.pow(xd, 2) + Math.pow(yd, 2));
                if (dist <= baseDist) {
                    baseDist = dist;
                    secondaryPoint = testPoint;
                }
            }
            nearestPoints.put(basePoint, secondaryPoint);
        }
        return nearestPoints;
    }

    public synchronized static Map<Point, Point> doCalculations(List<Point> inPoints, int startIndex, int endIndex,
            Map<Point, Point> outMap) {
        // Map<Point,Point> nearestPoints = new HashMap<>();
        double baseDist = Double.MAX_VALUE;
        for (int i = startIndex; i < endIndex; i++) {
            Point basePoint = inPoints.get(i);
            Point secondaryPoint = null;
            for (int j = startIndex; j < endIndex; j++) {
                Point testPoint = inPoints.get(j);
                if (testPoint.equals(basePoint)) {
                    continue;
                }
                double xd = basePoint.getX() - testPoint.getX();
                double yd = basePoint.getY() - testPoint.getY();
                double dist = Math.sqrt(Math.pow(xd, 2) + Math.pow(yd, 2));
                if (dist <= baseDist) {
                    baseDist = dist;
                    secondaryPoint = testPoint;
                }
            }
            outMap.put(basePoint, secondaryPoint);
        }
        return outMap;
    }
}
