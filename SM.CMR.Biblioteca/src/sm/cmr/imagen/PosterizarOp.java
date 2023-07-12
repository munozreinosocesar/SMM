/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sm.cmr.imagen;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageOpAdapter;

/**
 * Clase que implementa un filtro de una imagen en el que mediante un deslizador
 * realiza un posterizado
 *
 * @author Cesar Muñoz Reinoso
 */
public class PosterizarOp extends BufferedImageOpAdapter {

    private final int niveles;

    /**
     * Constructor con el nivel elegido
     *
     * @param niveles
     */
    public PosterizarOp(int niveles) {
        this.niveles = niveles;
    }

    /**
     * Sobrecarga de función filter en el que se implementa el posterizado
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
        int sample;

        float K = 256.f / niveles;
        for (int x = 0; x < src.getWidth(); x++) {
            for (int y = 0; y < src.getHeight(); y++) {
                for (int band = 0; band < srcRaster.getNumBands(); band++) {
                    sample = srcRaster.getSample(x, y, band);
                    sample = (int) (K * (int) (sample / K));
                    destRaster.setSample(x, y, band, sample);
                }
            }
        }
        return dest;
    }

}
