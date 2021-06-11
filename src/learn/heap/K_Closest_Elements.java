package learn.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
// Time : O(n log n)
// Space: O(n)
public class K_Closest_Elements {
    public static Point[] kClosestPoints(Point[] points, int k) {
        PriorityQueue<Point> pointsQ = new PriorityQueue<Point>(points.length, Comparator.comparing(Point::distanceToZero));
        Point[] result = new Point[k];
        pointsQ.addAll(Arrays.asList(points));
        for (int i = 0; i < k; i++) {
            result[i] = pointsQ.poll();
        }
        return result;
    }

    public static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        // Distance between two coordinates (x1, y1) and (x2, y2) is sqrt((x1 - x2)^ + (y1 - y2)^2)
        // So if (x2, y2) is (0,0) the equation becomes sqrt(x1^2 + y2^2)
        private int distanceToZero() {
            return (int) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        }
    }
}
