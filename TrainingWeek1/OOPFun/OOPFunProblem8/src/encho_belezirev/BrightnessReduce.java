package encho_belezirev;

public class BrightnessReduce implements MatrixOperation {

    @Override
    public Pixel withPixel(int x, int y, Pixel[][] matrix) {
        Pixel originalPixel = matrix[x][y];
        Pixel newPixel = new Pixel(originalPixel.getRed()/2, originalPixel.getGreen()/2, originalPixel.getBlue()/2);
        return newPixel;
    }

}
