/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sm.cmr.imagen;

import java.awt.Color;
import static java.awt.Color.HSBtoRGB;
import static java.awt.Color.RGBtoHSB;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageOpAdapter;

/**
 * Clase que implementa un filtro de una imagen en el que mediante un deslizador
 * cambia el tono
 *
 * @author Cesar Muñoz Reinoso
 */
public class CambiarTonoOp extends BufferedImageOpAdapter {

    private final int tono;

    /**
     * Constructor con el tono elegido
     *
     * @param tono
     */
    public CambiarTonoOp(int tono) {
        this.tono = tono;
    }

    /**
     * Sobrecarga de función filter en el que se implementa el cambio de tono
     * pixel a pixel
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
        float hsb[] = new float[3];
        int colorint, r, g, b;
        for (int x = 0; x < src.getWidth(); x++) {
            for (int y = 0; y < src.getHeight(); y++) {
                srcRaster.getPixel(x, y, pixelComp);

                Color color = new Color(src.getRGB(x, y));

                RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), hsb);
                hsb[0] = ((hsb[0] * 360 + tono) % 360) / 360;
                colorint = HSBtoRGB(hsb[0], hsb[1], hsb[2]);
                r = (colorint >> 16) & 0xFF;
                g = (colorint >> 8) & 0xFF;
                b = colorint & 0xFF;
                int rgb[] = {r, g, b};

                System.arraycopy(rgb, 0, pixelCompDest, 0, pixelCompDest.length);
                destRaster.setPixel(x, y, pixelCompDest);
            }
        }
        return dest;
    }
}
