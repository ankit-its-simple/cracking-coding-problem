package com.cetera.process.engine.client;

public class Orientation {

    
    private int checkOrientation(final Points p, final Points q, final Points r){
        final int x1 = p.getX();
        final int x2 = q.getX();
        final int x3 = r.getX();
        final int y1 = p.getY();
        final int y2 = q.getY();
        final int y3 = r.getY();
        final int orientation = ((y2 - y1) * (x3 - x2)) - ((y3 - y2) * (x2 - x1));
        
        
        return orientation == 0 ? 0 : orientation > 0 ? 1 : 2;
    }

    public static void main(String[] args) {
        final Points p = new Points(2, 3);
        final Points q = new Points(0, 1);
        final Points r = new Points(0, 2);
        int orientation = new Orientation().checkOrientation(p, q, r);
        
        switch(orientation){
            case 0:
                System.out.println("Coolinear points");
                break;
            case 1:
                System.out.println("clockwise");
                break;
            case 2:
                System.out.println("counter-clockwise");
                break;
        }
    }

}
