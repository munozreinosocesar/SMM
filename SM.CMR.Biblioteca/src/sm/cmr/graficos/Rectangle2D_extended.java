/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sm.cmr.graficos;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Clase hereada de Rectangle2D.Float para incluir los métodos setLocation y
 * getLocation
 *
 * @author cesar
 */
public class Rectangle2D_extended extends Rectangle2D.Float {

    /**
     * Constructor hereado de Rectangle2D.Float en el que establecemos el
     * perimetro del rectangulo
     *
     * @param x
     * @param y
     * @param w
     * @param h
     */
    public Rectangle2D_extended(float x, float y, float w, float h) {
        super(x, y, w, h);
    }

    /**
     * Establece una nueva ubicacion para el rectangulo creada pasandole el
     * punto superior izquierdo
     *
     * @param pos es el punto superior izquierdo del rectangulo
     */
    public void setLocation(Point2D pos) {
        Rectangle2D_extended newr2 = new Rectangle2D_extended((float) pos.getX(), (float) pos.getY(), (float) this.getWidth(), (float) this.getHeight());
        this.setRect(newr2);
    }

    /**
     * Devuelve la ubicación del rectangulo
     *
     * @return el punto superior izquierdo
     */
    public Point2D getLocation() {
        Point2D loc = new Point2D.Float((float) this.getX(), (float) this.getY());
        return loc;
    }
}
