/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sm.cmr.graficos;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * Clase hereada de Line2D.Float para incluir los métodos setLocation y
 * getLocation
 *
 * @author cesar
 */
public class Line2D_extended extends Line2D.Float {

    /**
     * Constructor hereado de Line2D.Float en el que establecemos los 2 puntos
     * de la linea
     *
     * @param point
     * @param point0
     */
    public Line2D_extended(Point2D point, Point2D point0) {
        super(point, point0);
    }

    /**
     * Establece una nueva ubicacion para la linea creada pasandole el primer
     * punto
     *
     * @param pos es el primer punto
     */
    public void setLocation(Point2D pos) {
        double dx = pos.getX() - this.getX1();
        double dy = pos.getY() - this.getY1();
        Point2D newp2 = new Point2D.Double(this.getX2() + dx, this.getY2() + dy);
        this.setLine(pos, newp2);
    }

    /**
     * Devuelve la ubicación de la linea
     *
     * @return el primer punto
     */
    public Point2D getLocation() {
        Point2D loc = new Point2D.Float((float) this.getX1(), (float) this.getY1());
        return loc;
    }

    /**
     * Comprueba si el punto está cerca de la linea creada
     *
     * @param p punto del cursor
     * @return boolean
     */
    public boolean isNear(Point2D p) {
        // Caso p1=p2 (punto)
        if (this.getP1().equals(this.getP2())) {
            return this.getP1().distance(p) <= 2.0;
        }
        // Caso p1!=p2
        return this.ptLineDist(p) <= 2.0;
    }

    /**
     * Comprueba si el punto está cerca de la linea creada con el método isNear
     *
     * @param p punto del cursor
     * @return boolean
     */
    @Override
    public boolean contains(Point2D p) {
        return isNear(p);
    }
}
