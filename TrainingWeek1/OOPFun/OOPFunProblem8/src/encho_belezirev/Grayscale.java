package encho_belezirev;

public class Grayscale implements MatrixOperation {

    @Override
    public Pixel withPixel(int x, int y, Pixel[][] matrix) {
        Pixel originalPixel = matrix[x][y];
        float averageValue = (originalPixel.getRed() + originalPixel.getGreen() + originalPixel.getBlue()) / 3;
        Pixel newPixel = new Pixel(averageValue * 0.2989f, averageValue * 0.5870f, averageValue * 0.1140f);
        return newPixel;
    }

}
