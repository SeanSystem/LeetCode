package exhaustive;

/**
 * 求二维平面最多有多少点在一条直线上
 *
 * @author by Sean
 * @date 2020/4/27 23:05
 */
public class MaxPointOnAline {

    public static int run(Point[] points) {
        if (points.length < 3) {
            return points.length;
        }
        int max = 0;
        for (int i = 1; i < points.length; i++) {
            int x = points[i].x;
            int y = points[i].y;
            int dx = x - points[i - 1].x;
            int dy = y - points[i - 1].y;
            int count = 0;
            if (dx == 0 && dy == 0) {
                for (int j = 0; j < points.length; j++) {
                    if (points[j].x == x && points[j].y == y) {
                        count++;
                    }
                }
            } else {
                for (int j = 0; j < points.length; j++) {
                    if ((points[j].x - x) * dy == (points[j].y - y) * dx) {
                        count++;
                    }
                }
            }
            max = Math.max(count, max);
        }
        return max;
    }

    public static void main(String[] args) {
        Point point = new Point(1, 1);
        Point point1 = new Point(1, 1);
        Point point2 = new Point(1, 1);
        // Point point3 = new Point(2, 2);
        Point[] points = {point, point1, point2};
        System.out.println(run(points));
    }
}

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
