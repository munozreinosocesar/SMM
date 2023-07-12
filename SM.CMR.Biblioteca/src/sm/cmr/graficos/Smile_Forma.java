/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sm.cmr.graficos;

import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Point2D;

/**
 * Clase heredada de FormasSM que contiene un objeto Smile y atributos propios
 *
 * @author Cesar Muñoz Reinoso
 */
public class Smile_Forma extends FormasSM {

    /**
     * Objeto Smile
     */
    protected Smile smile;

    /**
     * Color de la figura
     */
    protected Color color_figura;

    /**
     * Trazo de la figura
     */
    protected Stroke trazo_figura;

    /**
     * Composite de la figura
     */
    protected Composite comp_figura;

    /**
     * Render de la figura
     */
    protected RenderingHints render_figura;

    /**
     * Tiene relleno o no
     */
    protected boolean relleno_figura;

    /**
     * Tiene alisado o no
     */
    protected boolean alisado_figura;

    /**
     * Tiene trazo discontinuo o no
     */
    protected boolean discontinua_figura;

    /**
     * Constructor que llama al constructor de Smile
     *
     * @param pos
     */
    public Smile_Forma(Point2D pos) {
        super();
        smile = new Smile(pos);
    }

    /**
     * Comprueba si el punto está cerca de la sonrisa creada
     *
     * @param pos
     * @return
     */
    @Override
    public boolean contains(Point2D pos) {
        return smile.contains(pos);
    }

    /**
     * Devuelve la figura Smile
     *
     * @return
     */
    @Override
    public Smile getSmile() {
        return smile;
    }

    /**
     * Establece el color de la figura
     *
     * @param color
     */
    @Override
    public void setColor(Color color) {
        this.color_figura = color;
    }

    /**
     * Devuelve el color de la figura
     *
     * @return
     */
    @Override
    public Color getColor() {
        return color_figura;
    }

    /**
     * Establece el trazo de la figura
     *
     * @param trazo
     */
    @Override
    public void setTrazo(Stroke trazo) {
        this.trazo_figura = trazo;

    }

    /**
     * Devuelve el trazo de la figura
     *
     * @return
     */
    @Override
    public Stroke getTrazo() {
        return trazo_figura;
    }

    /**
     * Establece si la figura tiene relleno
     *
     * @param relleno
     */
    @Override
    public void setRelleno(boolean relleno) {
        this.relleno_figura = relleno;
    }

    /**
     * Devuelve si la figura tiene relleno
     *
     * @return
     */
    @Override
    public boolean getRelleno() {
        return relleno_figura;
    }

    /**
     * Establece la composición de la figura
     *
     * @param comp
     */
    @Override
    public void setComp(Composite comp) {
        this.comp_figura = comp;
    }

    /**
     * Devuelve la composición de la figura
     *
     * @return
     */
    @Override
    public Composite getComp() {
        return comp_figura;
    }

    /**
     * Establece el alisado de la figura
     *
     * @param alisado
     */
    @Override
    public void setAlisado(boolean alisado) {
        this.alisado_figura = alisado;

        if (alisado) {
            render_figura = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        } else {
            render_figura = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        }
    }

    /**
     * Devuelve el alisado de la figura
     *
     * @return
     */
    @Override
    public boolean getAlisado() {
        return alisado_figura;
    }

    /**
     * Establece el render de la figura
     *
     * @param render
     */
    @Override
    public void setRender(RenderingHints render) {
        this.render_figura = render;
    }

    /**
     * Devuelve el render de la figura
     *
     * @return
     */
    @Override
    public RenderingHints getRender() {
        return render_figura;
    }

    /**
     * Establece si la figura tiene discontinuidad
     *
     * @param discontinua
     */
    @Override
    public void setDiscontinua(boolean discontinua) {
        this.discontinua_figura = discontinua;
    }

    /**
     * Devuelve si la figura tiene discontinuidad
     *
     * @return
     */
    @Override
    public boolean getDiscontinua() {
        return discontinua_figura;
    }

    /**
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(this.color_figura);
        g2d.setStroke(this.trazo_figura);
        g2d.setComposite(comp_figura);
        g2d.setRenderingHints(render_figura);
        if (relleno_figura) {
            g2d.fill(smile);
        } else {
            g2d.draw(smile);
        }

    }
}
