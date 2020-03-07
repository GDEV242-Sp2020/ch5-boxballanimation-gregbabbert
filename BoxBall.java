import java.awt.*;
import java.awt.geom.*;

/**
 * This class is for determing when the ball should change speed. When the
 * ball gets to the edge of where it's allowed to go, then it's speed is
 * reversed so that it goes the opposite direction.
 *
 * This movement can be initiated by repeated calls to the "move" method.
 * 
 * @author Greg Babbert
 *
 * @version 2020.03.06
 */

public class BoxBall
{
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private int bottomPosition = 446;
    private int topPosition = 50;
    private int leftPosition = 50;
    private int rightPosition = 546;
    private Canvas canvas;
    private int ySpeed;
    private int xSpeed;
    // initial downward speed

    /**
     * Constructor for objects of class BoxBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
                        Canvas drawingCanvas, int xsp, int ysp)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        canvas = drawingCanvas;
        xSpeed = xsp;
        ySpeed = ysp;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * This determines when the speed of teh ball should be reversed
     * and it stops the ball from going over the lines of the square.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        
        yPosition += ySpeed;
        xPosition += xSpeed;
        
        if (xPosition > (rightPosition - diameter)) {
          xSpeed = -xSpeed;
        }
        
        if (yPosition > (bottomPosition - diameter)) {
          ySpeed = -ySpeed;
        }
        
        if (yPosition < (topPosition)) {
          ySpeed = -ySpeed;
        }
        
        if (xPosition < (leftPosition)) {
          xSpeed = -xSpeed;
        }
        
        // draw again at new position
        draw();
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}
