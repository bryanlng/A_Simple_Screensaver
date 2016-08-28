/**
 *Bryan Leung
 *Mrs. Gallatin
 *Camera
 *makes a Camera using java awt methods
**/

/**
 *the sub never stated that this lab was due on friday. In fact, he did not say anything at all during the class period?
 *There was no due date stated in the pdf. So, I assumed that the assignment was due on Monday.
**/

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
   A camera shape that can be positioned anywhere on the screen.
*/

public class Camera implements Animatable
{
   private int xLeft;
   private int yTop;
   
   public Camera(int x, int y)
   {
   		xLeft = x;
   		yTop = y;
   }
   
   /**
      Moves the camera.
      @param dx the amount to move in x-direction
      @param dy the amount to move in y-direction
   */
   public void move(int dx, int dy)
   {
      xLeft += dx;
      yTop += dy;
   }
   
   /**
      Draws the camera.
      @param g2 the graphics context
   */
   public void draw(Graphics2D g2)
   {
   	  Point2D.Double origin 
            = new Point2D.Double(xLeft, yTop);
      Point2D.Double r1 
            = new Point2D.Double(xLeft, yTop + 60);
      Point2D.Double r2 
            = new Point2D.Double(xLeft + 130, yTop + 60); 
            	     
  	  Point2D.Double shutter1 
            = new Point2D.Double(xLeft + 20, yTop - 20);
      Point2D.Double shutter2
            = new Point2D.Double(xLeft + 43, yTop - 25);
            
      Point2D.Double title1 
            = new Point2D.Double(xLeft + 63, yTop - 45);  
  	  Point2D.Double title2 
            = new Point2D.Double(xLeft + 103, yTop - 45);
           
      Point2D.Double tool1 
            = new Point2D.Double(xLeft + 123, yTop - 25);
      Point2D.Double tool2 
            = new Point2D.Double(xLeft + 125, yTop - 30);  
  	  Point2D.Double tool3 
            = new Point2D.Double(xLeft + 140, yTop - 25);
      Point2D.Double tool4 
            = new Point2D.Double(xLeft + 135, yTop - 15);
            
      Point2D.Double rightU 
            = new Point2D.Double(xLeft + 150, yTop - 10);
      Point2D.Double rightS
            = new Point2D.Double(xLeft + 150, yTop + 45);
//      Point2D.Double r2 
//            = new Point2D.Double(xLeft + 100, yTop + 60);   
  	  
      Line2D.Double leftSide 
           = new Line2D.Double(origin, r1);
      Line2D.Double bottom
           = new Line2D.Double(r1, r2);
      Line2D.Double shutter 
           = new Line2D.Double(shutter1, shutter2);
      Line2D.Double title
           = new Line2D.Double(title1, title2);
      Line2D.Double toolLeft 
           = new Line2D.Double(tool1, tool2);
      Line2D.Double toolMiddle
           = new Line2D.Double(tool2, tool3);
      Line2D.Double toolRight 
           = new Line2D.Double(tool3, tool4);
           
      Line2D.Double rightUpper
           = new Line2D.Double(tool4, rightU);
      Line2D.Double rightSide
           = new Line2D.Double(rightU, rightS);
           
                
     Rectangle grip 
     	   = new Rectangle(xLeft + 5, yTop , 20, 55);       
     Ellipse2D.Double outerCircle 
           = new Ellipse2D.Double(xLeft + 45, yTop - 25, 80, 80); 
     Ellipse2D.Double middleCircle 
           = new Ellipse2D.Double(xLeft + 50, yTop - 20, 70, 70); 
     Ellipse2D.Double innerCircle 
           = new Ellipse2D.Double(xLeft + 70, yTop, 30, 30); 
           
	  g2.draw(leftSide);
      g2.draw(bottom);
      g2.draw(shutter);
      g2.draw(title);
      
      g2.draw(toolLeft);
      g2.draw(toolMiddle);
      g2.draw(toolRight);
      
      g2.draw(rightUpper);
      g2.draw(rightSide);
      
      	//http://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html#drawArc%28int,%20int,%20int,%20int,%20int,%20int%29
      g2.drawArc(xLeft, yTop - 20, 40, 50, 90, 90); //NW arc (X,Y) represent upper - left corner
      g2.drawArc(xLeft + 110, yTop + 20, 40, 40, 360, - 90); //right-bottom arc
      g2.drawArc(xLeft + 23, yTop - 65, 40, 40, 360, - 90); //leftTitle arc  //(xLeft + 43, yTop - 30);
      g2.drawArc(xLeft + 103, yTop - 65, 40, 40, 180, 90); //rightTitle arc  //(xLeft + 103, yTop - 45);
      
      g2.draw(grip);
      g2.draw(outerCircle);
      g2.draw(middleCircle);
      g2.draw(innerCircle);
   		
  
   }
}