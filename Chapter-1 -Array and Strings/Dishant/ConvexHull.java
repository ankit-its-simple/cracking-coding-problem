package com.cetera.process.engine.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvexHull {

    private int calculateOrientation(Points p, Points q, Points r) {
        int orientation = (q.getY() - p.getY()) * (r.getX() - q.getX()) - ((r.getY() - q.getY()) * (q.getX() - p.getX()));
        return orientation == 0 ? 0 : orientation > 0 ? 1 : 2;
    }

    private List<Points> calculateConvexHull(List<Points> points) {
        List<Points> convexHull = new ArrayList<>();
        // Fetch the leftmost point
        int start = 0;
        for (int i = 1; i < points.size(); i++) {
            if (points.get(i).getX() < points.get(start).getX()) {
                start = i;
            }
        }

        int currentpointer = start, nextPointer;
        do {
            // Add the current pointer to the convexHull
            convexHull.add(points.get(currentpointer));

            nextPointer = (currentpointer + 1) % (points.size());
            for (int i = 0; i < points.size(); i++) {
                int orientation = calculateOrientation(points.get(currentpointer), points.get(i), points.get(nextPointer));
                if (orientation == 2) {
                    nextPointer = i;
                }
            }
            currentpointer = nextPointer;
        } while (currentpointer != start);
        return convexHull;
    }

    public static void main(String[] args) {
        Points points[] = new Points[7];
        points[0] = new Points(0, 3);
        points[1] = new Points(2, 3);
        points[6] = new Points(3, 2);
        final List<Points> convexPoints = new ConvexHull().calculateConvexHull(Arrays.asList(points));
        for(Points point : convexPoints){
            System.out.println("(" + point.getX() + "," + point.getY() + ")");
        }
    }

}
