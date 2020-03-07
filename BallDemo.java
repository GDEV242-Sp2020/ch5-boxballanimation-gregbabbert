import java.awt.Color;
import java.util.Random;

/**
 * This class is used to make a box with 5-30 balls inside it. All of the
 * balls have a random position, size, xspeed, yspeed, color. At the moment
 * this class only creates one ball with the random variables.
 *
 * @author Greg Babbert
 * @version 2020.03.06
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo3 object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    public void boxBounce(int numberOfBalls) {
    
    //This is used to create the box    
        
    int bottom = 450;
    int top = 48;
    int left = 47;
    int right = 550;
    
    myCanvas.drawLine(left, bottom, right, bottom);
    myCanvas.drawLine(left, top, right, top);
    myCanvas.drawLine(left, top, left, bottom);
    myCanvas.drawLine(right, top, right, bottom);
        
    int []balls = new int[numberOfBalls];
        
    myCanvas.setVisible(true);
    
    //This is the array I tried to make to make a ball for every ball
    //that the user wanted to be made.
    
    for (int i = 0; i <= balls.length; ++ i) {
    
    Random ran = new Random();
    
    int []xspeed = new int[numberOfBalls];
    int []yspeed = new int[numberOfBalls];
    int []xdirection = new int[numberOfBalls];
    int []ydirection = new int[numberOfBalls];
    int []xposition = new int[numberOfBalls];
    int []yposition = new int[numberOfBalls];
    int []diameter = new int[numberOfBalls];
    int []r = new int[numberOfBalls];
    int []g = new int[numberOfBalls];
    int []b = new int[numberOfBalls];
    xspeed[i] = ran.nextInt(7);
    if (xspeed[i] == 0) {
      xspeed[i] = 1;
    }
    yspeed[i] = ran.nextInt(7);
    if (yspeed[i] == 0) {
      yspeed[i] = 1;
    }
    xdirection[i] = ran.nextInt(1000000);
    if (xdirection[i] % 2 == 0) {
      xspeed[i] = xspeed[i];
    } else {
      xspeed[i] = -xspeed[i];
    }
    ydirection[i] = ran.nextInt(1000000);
    if (ydirection[i] % 2 == 0) {
      yspeed[i] = yspeed[i];
    } else {
      xspeed[i] = -xspeed[i];
    }
    xposition[i] = ran.nextInt(575);
    if (xposition[i] < 50) {
      xposition[i] = 50;
    }
    yposition[i] = ran.nextInt(475);
    if (yposition[i] < 50) {
      yposition[i] = 50;
    }
    diameter[i] = ran.nextInt(26);
    if (diameter[i] < 10) {
      diameter[i] = diameter[i] + 15;
    }
    
    r[i] = ran.nextInt(256);
    g[i] = ran.nextInt(256);
    b[i] = ran.nextInt(256);
    Color randomColor = new Color(r[i], g[i], b[i]);
    
    BoxBall []myBoxBall = new BoxBall[numberOfBalls];
    
    //This is where I think I had trouble. I was able to make random
    //variable for each of the parameters for balls, but I couldn't
    //firgure out how to get the program to make all the balls at once.
    //The code below is supposed to be called each time the loop ran
    //so taht for howerever many balls the user wanted it would make that 
    // number of balls.
    
    myBoxBall[i] = new BoxBall(xposition[i],
    yposition[i], diameter[i], randomColor, myCanvas, 
    xspeed[i], yspeed[i]);
    
    boolean finished =  false;
    for (int j = 0; j < numberOfBalls; ++j){
    while(!finished) {
            myCanvas.wait(50);
            myBoxBall[i].move();
        
            ++j;
        }
    }
    ++i;        
    }    
    
    }
    
    
}
