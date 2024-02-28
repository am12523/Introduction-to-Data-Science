import processing.core.*;

public class RacingGame extends PApplet {

  // Variables for car position and speed
  int carX, carY;
  int carSpeed;

  // Variables for road and obstacle positions
  int roadY;
  int obstacleX, obstacleY;

  // Load images for car and obstacle
  PImage carImg, obstacleImg;

  public void settings() {
    size(800, 600);
  }

  public void setup() {
    // Set initial values for variables
    carX = width/2;
    carY = height - 100;
    carSpeed = 5;
    roadY = 0;
    obstacleX = width/2 - 50;
    obstacleY = -200;

    // Load images for car and obstacle
    carImg = loadImage("gamecar1.png");
    obstacleImg = loadImage("gamecar2.png");
  }

  public void draw() {
    // Draw road and obstacle
    background(0);
    fill(255);
    rect(0, roadY, width, 600);
    image(obstacleImg, obstacleX, obstacleY);

    // Move road and obstacle
    roadY += carSpeed;
    obstacleY += carSpeed;

    // If obstacle goes off screen, reset position
    if (obstacleY > height) {
      obstacleX = (int) random(50, width - 100);
      obstacleY = -200;
    }

    // Draw car and move based on key presses
    image(carImg, carX, carY);
    if (keyPressed) {
      if (keyCode == LEFT) {
        carX -= carSpeed;
      } else if (keyCode == RIGHT) {
        carX += carSpeed;
      }
    }

    // Check for collision with obstacle
    if (dist(carX, carY, obstacleX, obstacleY) < 50) {
      // If collision, end game
      textAlign(CENTER);
      textSize(50);
      fill(255, 0, 0);
      text("GAME OVER", width/2, height/2);
      noLoop();
    }
  }

  public static void main(String[] args) {
    PApplet.main("RacingGame");
  }

}
