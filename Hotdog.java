/**
 *Bryan Leung
 *Mrs. Gallatin
 *Hotdog
 *Makes a Hotdog using java draw methods
**/


import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.*;

/**
   Makes a Hotdog using java draw methods
*/

public class Hotdog implements Animatable
{
   private int xOrig;
   private int yOrig;
   
   /**
      Makes the Hotdog.
      @param x the original x coordinate
      @param y the original y coordinate
   */
   public Hotdog(int x, int y)
   {
   		xOrig = x;
   		yOrig = y;
   }
   
   /**
      Moves the Hotdog.
      @param dx the amount to move in x-direction
      @param dy the amount to move in y-direction
   */
   public void move(int dx, int dy)
   {
      xOrig += dx;
      yOrig += dy;
   }
   
   /**
      Draws the Hotdog.
      @param g2 the graphics context
   */
   public void draw(Graphics2D g2)
   {
    g2.setColor(new Color(225, 204, 0));  
           	
    g2.fillRoundRect(xOrig,yOrig, 60, 20 , 5, 5 ); //x,y,w,h, arcWidth, arcHeight
    
    g2.setColor(new Color(27, 59, 86));
    g2.fillRoundRect(xOrig - 10, yOrig + 6 , 80, 8 , 5, 5 ); //x,y,w,h, arcWidth, arcHeight
	
	g2.setColor(Color.yellow);
	Rectangle grip 
     	   = new Rectangle(xOrig - 4, yOrig + 8 , 70, 2); 
           
      g2.fill(grip);



  
   }
   
   /**
	 *Gets the x coordinate
	 *@return the x coordinate
	**/
   public int getX()
   {
   		return xOrig;
   }
   
   /**
	 *Gets the y coordinate
	 *@return the y coordinate
	**/
   public int getY()
   {
   		return yOrig;
   }
   
   /**
	 *Sets the x coordinate value to the given int value
	 *@param x the value the x coordinate will be set to
	**/
   public void setX(int x)
   {
   		xOrig = x;
   }
   
   /**
	 *Sets the y coordinate value to the given int value
	 *@param y the value the y coordinate will be set to
	**/
   public void setY(int y)
   {
   		yOrig = y;
   }
}