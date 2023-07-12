/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package practica_final;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

/**
 * Clase de Ventana Interna Camara que se utilizara para mostrar la webcam
 *
 * @author Cesar Muñoz Reinoso
 */
public class VentanaInternaCamara extends VentanaInternaSM {

    /**
     * Cámara webcam
     */
    private Webcam camara;

    /**
     * Constructor de Ventana interna cámara en el que se inicializa con la
     * mejor resolución posible
     */
    @SuppressWarnings("null")
    private VentanaInternaCamara() {
        super();
        this.camara = null;
        initComponents();
        camara = Webcam.getDefault();
        if (camara != null) {
            Dimension resoluciones[] = camara.getViewSizes();
            Dimension maxRes = resoluciones[resoluciones.length - 1];
            camara.setViewSize(maxRes);
            WebcamPanel areaVisual = new WebcamPanel(camara);
            if (areaVisual != null) {
                getContentPane().add(areaVisual, BorderLayout.CENTER);
                pack();
            }
        }
    }
    
    /**
     * Devuelve la instancia de la webcam
     *
     * @return
     */
    public static VentanaInternaCamara getInstance() {
        VentanaInternaCamara v = new VentanaInternaCamara();
        return (v.camara != null ? v : null);
    }

    /**
     * Devuelve la imagen de la ventana, en ese caso una captura de la webcam
     *
     */
    @Override
    public BufferedImage getImagen() {
        return camara != null ? camara.getImage() : null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(350, 300));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        getContentPane().setLayout(new java.awt.BorderLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Para la webcam y la iguala a null cuando se cierra la Ventana interna
     *
     */
    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        if (camara != null) {
            camara.close();
            camara = null;
        }
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
