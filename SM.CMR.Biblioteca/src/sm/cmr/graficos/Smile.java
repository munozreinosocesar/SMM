/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sm.cmr.graficos;

import java.awt.geom.Arc2D;
import static java.awt.geom.Arc2D.OPEN;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 * Clase hereada de Area en el que creamos una cara sonriente e incluimos los
 * métodos setSmile setLocation y getLocation
 *
 * @author cesar
 */
public class Smile extends Area {

    Area circ, e1, e2, s;
    Arc2D.Double smile;
    Ellipse2D.Float circle, eye1, eye2;
    Point2D punto_inicial;

    /**
     * Constructor en el que establecemos las componentes de la cara sonriente
     *
     * @param pos es el punto superior izquierdo
     */
    public Smile(Point2D pos) {
        circle = new Ellipse2D.Float();
        eye1 = new Ellipse2D.Float();
        eye2 = new Ellipse2D.Float();
        smile = new Arc2D.Double();
        punto_inicial = pos;

        this.setSmile(punto_inicial);
    }

    /**
     * Establece una nueva ubicacion para la cara sonriente pasandole el punto
     * superior izquierdo
     *
     * @param pos es el punto superior izquierdo
     */
    private void setSmile(Point2D pos) {

        double x = pos.getX();
        double y = pos.getY();

        circle.setFrame(x, y, 75.0, 75.0);
        circ = new Area(circle);

        eye1.setFrame(x + 20, y + 25, 10.0, 10.0);
        e1 = new Area(eye1);
        circ.exclusiveOr​(e1);

        eye2.setFrame(x + 45, y + 25, 10.0, 10.0);
        e2 = new Area(eye2);
        circ.exclusiveOr​(e2);

        smile = new Arc2D.Double(x + 25, y + 35, 25, 25, 0, -180, OPEN);
        s = new Area(smile);
        circ.exclusiveOr​(s);
        this.reset();
        this.add(circ);
    }

    /**
     * Establece una nueva ubicacion para la cara sonriente creada pasandole el
     * punto superior izquierdo
     *
     * @param pos es el punto superior izquierdo
     */
    public void setLocation(Point2D pos) {
        this.setSmile(pos);
    }

    /**
     * Devuelve la ubicación de la cara sonriente
     *
     * @return el punto superior izquierdo
     */
    public Point2D getLocation() {
        return punto_inicial;
    }
}
