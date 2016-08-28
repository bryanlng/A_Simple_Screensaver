/**
 *Bryan Leung
 *Mrs. Gallatin
 *Pizza
 *Makes a Pizza using java draw methods
**/

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.*;

/**
   Makes a Pizza using java draw methods
*/

public class Pizza implements Animatable
{
   private int xOrig;
   private int yOrig;
   
   
   /**
      Makes the Pizza.
      @param x the original x coordinate
      @param y the original y coordinate
   */
   public Pizza(int x, int y)
   {
   		xOrig = x;
   		yOrig = y;
   }
   
   /**
      Moves the Pizza.
      @param dx the amount to move in x-direction
      @param dy the amount to move in y-direction
   */
   public void move(int dx, int dy)
   {
      xOrig += dx;
      yOrig += dy;
   }
   
   /**
      Draws the pizza
      @param g2 the graphics context
   */
   public void draw(Graphics2D g2)
   {  	
     g2.setColor(Color.yellow);
     int[] xTop = {xOrig, xOrig + 20, xOrig + 40 };
	 int[] yTop = {yOrig, yOrig +50, yOrig };
	 g2.drawPolygon(xTop, yTop, 3); //x,y, total # points
	 g2.fillPolygon(xTop, yTop, 3); //x,y, total # points
	 
	 
   	  Point2D.Double origin 
            = new Point2D.Double(xOrig, yOrig);
      Point2D.Double r1 
            = new Point2D.Double(xOrig + 20, yOrig + 50);
      Point2D.Double r2 
            = new Point2D.Double(xOrig + 40, yOrig); 
      Line2D.Double top 
           = new Line2D.Double(origin, r1);
      Line2D.Double right
           = new Line2D.Double(r1, r2);
      Line2D.Double left 
           = new Line2D.Double(origin, r2);	 
	 
	 g2.setColor(Color.red);  
     Ellipse2D.Double outerCircle 
           = new Ellipse2D.Double(xOrig + 8, yOrig + 5 , 10, 10); 
     Ellipse2D.Double middleCircle 
           = new Ellipse2D.Double(xOrig + 22, yOrig + 5, 10, 10); 
     Ellipse2D.Double innerCircle 
          = new Ellipse2D.Double(xOrig + 15, yOrig + 20 , 10, 10); 
          	
      g2.draw(outerCircle);
      g2.draw(middleCircle);
      g2.draw(innerCircle);
      g2.fill(outerCircle);
      g2.fill(middleCircle);
      g2.fill(innerCircle);
      
      g2.setColor(new Color(210, 180, 140));  
      g2.draw(top);
      g2.draw(right);
      g2.draw(left);
	    


  
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
	 *@param y the value the  coordinate will be set to
	**/
   public void setY(int y)
   {
   		yOrig = y;
   }
}