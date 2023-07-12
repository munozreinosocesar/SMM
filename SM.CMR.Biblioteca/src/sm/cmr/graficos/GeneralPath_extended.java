/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sm.cmr.graficos;

import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

/**
 * Clase hereada de GeneralPath.Float para incluir los métodos setLocation y
 * getLocation así como constructores auxiliares
 *
 * @author cesar
 */
public class GeneralPath_extended extends GeneralPath.Float {

    /**
     * Contructor por defecto
     */
    public GeneralPath_extended() {
        super();
    }

    /**
     * Constructor hereado de GeneralPath.Float
     *
     * @param rule
     * @param initialCapacity capacidad inicial de puntos del trazo
     */
    public GeneralPath_extended(int rule, int initialCapacity) {
        super(rule, initialCapacity);
    }

    /**
     * Establece una nueva ubicacion para el trazo creado pasandole el ultimo
     * punto
     *
     * @param pos es el ultimo punto
     */
    public void setLocation(Point2D pos) {
        AffineTransform at;
        at = AffineTransform.getTranslateInstance(pos.getX() - this.getCurrentPoint().getX(), pos.getY() - this.getCurrentPoint().getY());
        this.transform(at);
    }

    /**
     * Devuelve la ubicación del trazo
     *
     * @return el ultimo punto
     */
    public Point2D getLocation() {
        return this.getCurrentPoint();
    }
}
