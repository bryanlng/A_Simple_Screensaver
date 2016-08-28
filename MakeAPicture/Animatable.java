/**
 *Bryan Leung
 *Mrs. Gallatin
 *Animatable
 *interface to animate the Cameras
**/

/**
 *the sub never stated that this lab was due on friday. In fact, he did not say anything at all during the class period?
 *There was no due date stated in the pdf. So, I assumed that the assignment was due on Monday.
**/


import java.awt.*;

/**
 * Shows an animation of moving cars
 */
public interface Animatable
{
	/**
      Moves the picture. Specified parameters can be negative.
      @param dx the amount to move in x-direction
      @param dy the amount to move in y-direction
   */
   public void move(int dx, int dy);
   
   /**
      Draws the picture.
      @param g2 the graphics context
   */
   public void draw(Graphics2D g2);
}

