/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sm.cmr.imagen;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageOpAdapter;

/**
 * Clase que implementa un filtro de una imagen en el que resalta en rojo las
 * partes con ese tono
 *
 * @author Cesar Muñoz Reinoso
 */
public class RojoOp extends BufferedImageOpAdapter {

    private final int umbral;

    /**
     * Constructor con el umbral elegido
     *
     * @param umbral
     */
    public RojoOp(int umbral) {
        this.umbral = umbral;
    }

    /**
     * Sobrecarga de función filter en el que se implementa el resaltado en rojo
     * las partes con ese tono
     *
     * @param src
     * @param dest
     * @return
     */
    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest) {
        if (src == null) {
            throw new NullPointerException("src image is null");
        }
        if (dest == null) {
            dest = createCompatibleDestImage(src, null);
        }
        WritableRaster srcRaster = src.getRaster();
        WritableRaster destRaster = dest.getRaster();
        int[] pixelComp = new int[srcRaster.getNumBands()];
        int[] pixelCompDest = new int[srcRaster.getNumBands()];
        for (int x = 0; x < src.getWidth(); x++) {
            for (int y = 0; y < src.getHeight(); y++) {
                srcRaster.getPixel(x, y, pixelComp);

                Color color = new Color(src.getRGB(x, y));
                int rgb[] = {color.getRed(), color.getGreen(), color.getBlue()};
                if (color.getRed() - color.getGreen() - color.getBlue() < umbral) {
                    int media = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
                    for (int i = 0; i < pixelCompDest.length; i++) {
                        pixelCompDest[i] = media;
                    }
                } else {
                    System.arraycopy(rgb, 0, pixelCompDest, 0, pixelCompDest.length);
                }

                destRaster.setPixel(x, y, pixelCompDest);
            }
        }
        return dest;
    }
}
