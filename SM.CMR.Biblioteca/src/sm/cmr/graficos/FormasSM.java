/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sm.cmr.graficos;

import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Point2D;

/**
 * Clase de formas que podemos dibujar en el lienzo de la que heredan todas las
 * figuras
 *
 * @author Cesar Muñoz Reinoso
 */
public class FormasSM {

    /**
     * Color de la figura
     */
    protected Color color;

    /**
     * Trazo de la figura
     */
    protected Stroke trazo;

    /**
     * Composite de la figura
     */
    protected Composite comp;

    /**
     * Render de la figura
     */
    protected RenderingHints render;
    /**
     * Tiene relleno o no
     */
    protected boolean relleno;

    /**
     * Tiene alisado o noo
     */
    protected boolean alisado;

    /**
     * Tiene trazo discontinuo o no
     */
    protected boolean discontinua;

    /**
     * Funcion paint implementada en cada Figura
     *
     * @param g
     */
    public void paint(Graphics g) {

    }

    /**
     * Devuelve la elipse
     *
     * @return
     */
    public Ellipse2D_extended getElipse() {
        return null;
    }

    /**
     * Devuelve el rectangulo
     *
     * @return
     */
    public Rectangle2D_extended getRectangulo() {
        return null;
    }

    /**
     * Devuelve la curva
     *
     * @return
     */
    public QuadCurve2D_extended getCurva() {
        return null;
    }

    /**
     * Devuelve el path
     *
     * @return
     */
    public GeneralPath_extended getGeneralPath() {
        return null;
    }

    /**
     * Devuelve la smile
     *
     * @return
     */
    public Smile getSmile() {
        return null;
    }

    /**
     * Devuelve la linea
     *
     * @return
     */
    public Line2D_extended getLine() {
        return null;
    }

    /**
     * Comprueba si el punto está cerca de la figura creada, se implenta en cada
     * figura
     *
     * @param pos
     * @return
     */
    public boolean contains(Point2D pos) {
        return false;
    }

    /**
     * Establece el color de la figura
     *
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Devuelve el color de la figura
     *
     * @return
     */
    public Color getColor() {
        return color;
    }

    /**
     * Establece el trazo de la figura
     *
     * @param trazo
     */
    public void setTrazo(Stroke trazo) {
        this.trazo = trazo;

    }

    /**
     * Devuelve el trazo de la figura
     *
     * @return
     */
    public Stroke getTrazo() {
        return trazo;
    }

    /**
     * Establece si la figura tiene relleno
     *
     * @param relleno
     */
    public void setRelleno(boolean relleno) {
        this.relleno = relleno;
    }

    /**
     * Devuelve si la figura tiene relleno
     *
     * @return
     */
    public boolean getRelleno() {
        return relleno;
    }

    /**
     * Establece la composición de la figura
     *
     * @param comp
     */
    public void setComp(Composite comp) {
        this.comp = comp;
    }

    /**
     * Devuelve la composición de la figura
     *
     * @return
     */
    public Composite getComp() {
        return comp;
    }

    /**
     * Establece el alisado de la figura
     *
     * @param alisado
     */
    public void setAlisado(boolean alisado) {
        this.alisado = alisado;

        if (alisado) {
            render = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        } else {
            render = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        }
    }

    /**
     * Devuelve el alisado de la figura
     *
     * @return
     */
    public boolean getAlisado() {
        return alisado;
    }

    /**
     * Establece el render de la figura
     *
     * @param render
     */
    public void setRender(RenderingHints render) {
        this.render = render;
    }

    /**
     * Devuelve el render de la figura
     *
     * @return
     */
    public RenderingHints getRender() {
        return render;
    }

    /**
     * Establece si la figura tiene discontinuidad
     *
     * @param discontinua
     */
    public void setDiscontinua(boolean discontinua) {
        this.discontinua = discontinua;
    }

    /**
     * Devuelve si la figura tiene discontinuidad
     *
     * @return
     */
    public boolean getDiscontinua() {
        return discontinua;
    }
}
