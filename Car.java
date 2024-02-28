
import processing.core.PApplet;
import processing.core.PImage;
import java.util.Random;

public class Car {

    private CarGame app; // will hold a reference to the main Game object
    private int carSpeed;
    private PImage img;
    private PImage oppImg;
    private int[] carLocation = new int [2];
    private int [] oppLocation = new int [2];
    Random random = new Random();

    public Car (CarGame app, String imgFilePath, int carX, int carY){
        this.app = app;
        this.img = app.loadImage (imgFilePath);
        this.carLocation[0] = carX;
        this.carLocation[1] = carY;
        this.carSpeed = 5;
    }

    public Car (CarGame app, String imgFilePath) {
        this.app = app;
        this.oppImg = app.loadImage (imgFilePath);
        this.oppLocation[0] = random.nextInt(701) + 50;
        this.oppLocation[1] = -200;
    }


    public void OppMove (){
        this.oppLocation[1] += this.carSpeed;

        if (this.oppLocation[1] > 600){
            this.oppLocation[0] = random.nextInt(701) + 50; //USE SETTER METHOD FOR THIS AND ABOVE
            this.oppLocation[1]= -200;
        }

    }

    public int getCarSpeed () {
        return this.carSpeed;
    }
    
    public int[] getCarLocation () {
        return this.oppLocation;

    }

    public void setCarLocation (int x, int y) {
        this.carLocation[0] = x;
        this.carLocation[1] = y;

    }

    public int[] getOppLocation () {
        return this.oppLocation;

    }

    public void setOppLocation (int x, int y) {
        this.oppLocation[0] = x;
        this.oppLocation[1] = y;
    }

    public PImage getCarImg  () {
        return this.img;
    }

    public PImage getOppImg () {
        return this.oppImg;
    }

}