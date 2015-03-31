package encho_belezirev;

public class Pixel {
    private float red;
    private float green;
    private float blue;

    public Pixel(float red, float green, float blue) {
        this.setRed(red);
        this.setGreen(green);
        this.setBlue(blue);
    }

    public float getRed() {
        return this.red;
    }

    public void setRed(float valueRed) {
        if (valueRed < 0 || valueRed > 256) {
            System.out.println("Value must be between 0-255");
            return;
        }
        this.red = valueRed;
    }
    
    public float getBlue() {
        return this.blue;
    }

    public void setBlue(float valueBlue)  {
        if (valueBlue < 0 || valueBlue > 256) {
            System.out.println("Value must be between 0-255");
            return;
        }
        this.blue = valueBlue;
    }
    
    public float getGreen() {
        return this.green;
    }

    public void setGreen(float valueGreen) {
        if (valueGreen < 0 || valueGreen > 256) {
            System.out.println("Value must be between 0-255");
            return;
        }
        this.green = valueGreen;
    }
}
