import processing.core.*;

public class CarGame extends PApplet {


Car car = new Car (this, "gamecar1.png", 400, 500);

Car obstacle1 = new Car (this, "gamecar2.png");

int roady = 0;

public void settings() {
    this.setSize(800, 600);
  }

  public void draw() {
    // Draw road and obstacle
    background(0);
    fill(255);
    rect(0, roady, width, 600);
    image(obstacle1.getOppImg(), obstacle1.getOppLocation()[0], obstacle1.getOppLocation()[1]);

    // Move road and obstacle
    roady += car.getCarSpeed();

    obstacle1.OppMove();

    image(car.getCarImg(), car.getCarLocation()[0], car.getCarLocation()[1]);

    if (keyPressed) {
        switch (keyCode) {
            case LEFT :
            car.getCarLocation()[0] -= car.getCarSpeed();
            break;
            case RIGHT :
            car.getCarLocation()[0] += car.getCarSpeed();
            break;
        }
    }
    
    if (dist(car.getCarLocation()[0], car.getCarLocation()[1], obstacle1.getOppLocation()[0], obstacle1.getOppLocation()[1]) < 50) {
        // If collision, end game
        textAlign(CENTER);
        textSize(50);
        fill(255, 0, 0);
        text("GAME OVER", width/2, height/2);
        noLoop();
      }

  }
  public static void main(String[] args) {
    PApplet.main("CarGame");
  }

}