package com.cetera.process.engine.client;

public class LineIntersection {
    
    private double calculateSlope(final Points a , Points b){
        return (b.getY() - a.getY()) / (b.getX() - a .getX());
    }
    
    private int checkOrientation(final Points p , Points q, Points r){
        double orientation = calculateSlope(p, r) - calculateSlope(p, q);
        return orientation == 0 ? 0 : orientation > 0 ? 1 : 2;
    }
    
    private boolean onSegment(final Points p , Points q, Points r){
        return r.getX() >= Math.min(p.getX(), q.getX()) 
                && r.getX() <= Math.max(p.getX(), q.getX())
                && r.getY() >= Math.min(p.getY(), q.getY())
                && r.getY() >= Math.max(p.getY(), q.getY());
    }
    
    private boolean linesIntersect(final Points p1 , Points p2, Points q1, Points q2){
        int orientation1  = checkOrientation(p1, q1, p2);
        int orientation2  = checkOrientation(p1, q1, q2);
        int orientation3  = checkOrientation(p2, q2, p1);
        int orientation4  = checkOrientation(p2, q2, q1);
        
        //General best case for intersection
        if(orientation1 != orientation2 && orientation3 != orientation4){
            return true;
        }
        
        //Special case for intersection considering co-llinear points
        if(orientation1 == 0 && onSegment(p1, q1, p2)) return true;
        if(orientation1 == 0 && onSegment(p1, q1, q2)) return true;
        if(orientation1 == 0 && onSegment(p2, q2, p1)) return true;
        if(orientation1 == 0 && onSegment(p2, q2, q1)) return true;
        return false;
    }
    
    
    public static void main(String[] args) {
        
    }

}
