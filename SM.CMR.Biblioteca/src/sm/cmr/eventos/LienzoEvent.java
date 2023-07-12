/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sm.cmr.eventos;

import java.awt.Color;
import java.util.EventObject;
import sm.cmr.graficos.FormasSM;

/**
 *
 * @author Cesar Muñoz Reinoso
 */
public class LienzoEvent extends EventObject{
    private final FormasSM forma;
    private final Color color;

    /**
     *
     * @param source
     * @param forma
     * @param color
     */
    public LienzoEvent(Object source, FormasSM forma, Color color) {
        super(source);
        this.forma = forma;
        this.color = color;
    }

    /**
     *
     * @return
     */
    public FormasSM getForma() {
        return forma;
    }

    /**
     *
     * @return
     */
    public Color getColor() {
        return color;
    }
}
