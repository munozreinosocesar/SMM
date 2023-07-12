/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sm.cmr.eventos;

import java.util.EventListener;

/**
 *
 * @author Cesar Muñoz Reinoso
 */

public interface LienzoListener extends EventListener{

    /**
     *
     * @param evt
     */
    public void shapeAdded(LienzoEvent evt);

    /**
     *
     * @param evt
     */
    public void propertyChange(LienzoEvent evt);
}


