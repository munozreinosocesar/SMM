/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sm.cmr.graficos;

import java.awt.geom.Point2D;
import java.awt.geom.QuadCurve2D;

/**
 * Clase hereada de QuadCurve2D.Float para incluir los métodos setLocation y
 * getLocation
 *
 * @author cesar
 */
public class QuadCurve2D_extended extends QuadCurve2D.Float {

    /**
     * Constructor hereado de QuadCurve2D.Float en el que establecemos los 3
     * puntos de la curva
     *
     * @param x1
     * @param y1
     * @param ctrlx
     * @param ctrly
     * @param x2
     * @param y2
     */
    public QuadCurve2D_extended(float x1, float y1, float ctrlx, float ctrly, float x2, float y2) {
        super(x1, y1, ctrlx, ctrly, x2, y2);
    }

    /**
     * Establece una nueva ubicacion para la curva creada pasandole el primer
     * punto
     *
     * @param pos es el primer punto
     */
    public void setLocation(Point2D pos) {
        double dx = this.getX1() - this.getX2();
        double dy = this.getY1() - this.getY2();
        double dctrlx = this.getX1() - this.getCtrlX();
        double dctrly = this.getY1() - this.getCtrlY();
        QuadCurve2D_extended newqc2 = new QuadCurve2D_extended((float) pos.getX(), (float) pos.getY(), (float) (pos.getX() + Math.abs(dctrlx)), (float) (pos.getY() + Math.abs(dctrly)), (float) (pos.getX() + Math.abs(dx)), (float) (pos.getY() + Math.abs(dy)));
        this.setCurve(newqc2);
    }

    /**
     * Devuelve la ubicación de la curva
     *
     * @return el primer punto
     */
    public Point2D getLocation() {
        Point2D loc = new Point2D.Float((float) this.getX1(), (float) this.getY1());
        return loc;
    }
}
