/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sm.cmr.graficos;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 * Clase hereada de Ellipse2D.Float para incluir los métodos setLocation y
 * getLocation
 *
 * @author Cesar Muñoz Reinoso
 */
public class Ellipse2D_extended extends Ellipse2D.Float {

    /**
     * Constructor hereado de Ellipse2D.Float en el que establecemos el
     * perimetro de la elipse
     *
     * @param x
     * @param y
     * @param w
     * @param h
     */
    public Ellipse2D_extended(float x, float y, float w, float h) {
        super(x, y, w, h);
    }

    /**
     * Establece una nueva ubicacion para la elipse creada pasandole el punto
     * superior izquierdo
     *
     * @param pos es el punto superior izquierdo de la elipse
     */
    public void setLocation(Point2D pos) {
        this.setFrame((float) pos.getX(), (float) pos.getY(), (float) this.getWidth(), (float) this.getHeight());
    }

    /**
     * Devuelve la ubicación de la elipse
     *
     * @return el punto superior izquierdo
     */
    public Point2D getLocation() {
        Point2D loc = new Point2D.Float((float) this.getX(), (float) this.getY());
        return loc;
    }
}
