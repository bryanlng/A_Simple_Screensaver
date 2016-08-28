/**
 *Bryan Leung
 *Mrs. Gallatin
 *Sushi
 *Makes a Sushi using java draw methods
**/

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.*;
/**
   Makes a Sushi using java draw methods
*/

public class Sushi implements Animatable
{
   private int xOrig;
   private int yOrig;
   
   /**
      Makes the Sushi.
      @param x the original x coordinate
      @param y the original y coordinate
   */
   public Sushi(int x, int y)
   {
   		xOrig = x;
   		yOrig = y;
   }
   
   /**
      Moves the Sushi.
      @param dx the amount to move in x-direction
      @param dy the amount to move in y-direction
   */
   public void move(int dx, int dy)
   {
      xOrig += dx;
      yOrig += dy;
   }
   
   /**
      Draws the Sushi.
      @param g2 the graphics context
   */
   public void draw(Graphics2D g2)
   {
   	 g2.setColor(Color.black);
     int[] xTop = {xOrig, xOrig + 60, xOrig + 60 , xOrig  };
	 int[] yTop = {yOrig + 15, yOrig + 15, yOrig + 60, yOrig + 60 };
	 g2.fillPolygon(xTop, yTop, 4); //x,y, total # points
    
    
     Ellipse2D.Double outerCircle 
           = new Ellipse2D.Double(xOrig, yOrig, 60, 40); 
     Ellipse2D.Double innerCircle 
          = new Ellipse2D.Double(xOrig + 10, yOrig + 5, 37, 25); 
          	
      g2.setColor(Color.black);
      g2.draw(outerCircle);
     
      
      g2.setColor(Color.white);    	
      g2.fill(outerCircle);
      
      g2.setColor(Color.green);
      g2.fill(innerCircle);

	  g2.setColor(Color.black);
	  
	   Ellipse2D.Double bottom 
          = new Ellipse2D.Double(xOrig , yOrig + 50, 60, 25); 	  
          	
      g2.fill(bottom);

  
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