/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sm.cmr.imagen;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageOpAdapter;

/**
 * Clase propia de filtro pixel a pixel, en el que dividimos cada banda a la
 * mitad y la multiplicamos por el valor del deslizador
 *
 * @author Cesar Muñoz Reinoso
 */
public class OperadorOpPropia extends BufferedImageOpAdapter {

    private final int param;

    /**
     * Constructor con el parámetro elegido
     *
     * @param param
     */
    public OperadorOpPropia(int param) {
        this.param = param;
    }

    /**
     * Sobrecarga de función filter en el que se implementa el cambio de color
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

        for (int x = 0; x < src.getWidth(); x++) {
            for (int y = 0; y < src.getHeight(); y++) {
                srcRaster.getPixel(x, y, pixelComp);

                pixelCompDest[0] = param * (pixelComp[0]) / 2;
                pixelCompDest[1] = param * (pixelComp[1]) / 2;
                pixelCompDest[2] = param * (pixelComp[2]) / 2;

                destRaster.setPixel(x, y, pixelCompDest);
            }
        }
        return dest;
    }

}
