package encho_belezirev;

public class Matrix {
    private Pixel[][] matrix;
    
    
    public Matrix(int width, int height){
        this.matrix = new Pixel[height][width];
    }
    
    public Matrix(Pixel[][] matrix){
        this.setMatrix(matrix);
    }
    
    
    public Pixel[][] getMatrix(){
        return this.matrix;
    }
    
    public void setMatrix(Pixel[][] matrix){

        this.matrix = matrix;
    }
    
    public int getMatrixHeight(){
        return this.matrix.length;
    }
    
    public int getMatrixWidth(){
        return this.matrix[0].length;
    }
    
    public Pixel getPixel(int x, int y){
        return this.matrix[x][y];
    }
    
    public void setPixel(int x, int y, Pixel pixel){
        this.matrix[x][y] = pixel;
    }
    
    public void operate(MatrixOperation op){
        int originalMatrixHeight = this.getMatrixHeight();
        int originalMatrixWidth = this.getMatrixWidth();
        Pixel[][] newMatrix = new Pixel[originalMatrixHeight][originalMatrixWidth];
        
        for (int i = 0; i < originalMatrixHeight; i++) {
            for (int j = 0; j < originalMatrixWidth; j++) {
                Pixel generatedPixel = op.withPixel(i, j, this.matrix);
                newMatrix[i][j] = generatedPixel;
            }
        }
        this.setMatrix(newMatrix);
    }
}
