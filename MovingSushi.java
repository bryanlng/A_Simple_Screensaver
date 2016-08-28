/**
 *Bryan Leung
 *Mrs. Gallatin
 *MovingSushi
 *Makes a MovingSushi which extends Sushi and defines its movement patterns
**/


import javax.swing.JComponent;
import java.awt.Graphics2D;
import java.awt.*;

public class MovingSushi extends Sushi implements Identifiable // Identifiable is interface I created
{
   
   private int step;
   private int delay;
   //private int steps;
   private boolean hasBeenEaten;
   private double direction;
   private int identity;
   private JComponent component;
   
   public static final int WIDTH = 25; //60
   public static final int HEIGHT = 60; //77
   
   /**
      Creates a new MovingSushi instance
      @param x the x coordinate of the top left corner
      @param y the y coordinate of the top left corner
      @param step Step in pixels the MovingSushi will move each time
      @param delay The delay to wait between each step
      @param direction In which direction the MovingSushi will move
      @param component The component
    */
   public MovingSushi(int x, int y, int step, int delay, double direction, JComponent component)
   {
      super(x, y);
      this.step = step;
      this.delay = delay;
      //this.steps = steps;
      hasBeenEaten = false;
      this.direction = direction;
      this.identity = 1;
      this.component = component;
   }
   
   /**
    * Adjusts the MovingSushi's x and y locations based on the direction it is going.
    * Checks if the Sushi has 1) steps have passed 100 2) been eaten yet 3) is out of bounds
    * 1) If steps > 100, it generates a new random step value between 2-22 and a new random direction value between 1 - 232. 
    * 2) If the MovingSushi's x coordinate is [between (360 - WIDTH) and 410] and its y coordiante is [between (460 - HEIGHT) and 600],
    *    then it is considered to be eaten.   hasBeenEaten is set to true, and pause() is called one last time to clear up any remaining objects left by the previous paintComponent().
    * 3) If sushi is out of bounds, it changes its direction to be somewhat perpandicular of its original direction and increases velocity ( represented by step)
    * Then, it moves it a fixed number of pixels in both the x and y direction using the formulas 
    * x = vcos(direction in radians) and y = vsin(direction in radians).
    */
   public void animate()
         throws InterruptedException
   {  	  
   	  
   	  while(!hasBeenEaten)
   	  {
//   	    System.out.println ("steps: " + step);
//   	  	System.out.println ("x: " + super.getX());
//  	  	System.out.println ("y: " + super.getY());
//   	  	System.out.println ("direction: " + direction);
//   	  	System.out.println ("hasBeenEaten: " + isEaten());
//   	  	System.out.println ("");

	  	
   	  	 if( step > 100)
		 {
			double rand = (Math.random()*20) + 2;
			step = (int)rand;
				 
			double drand = (Math.random()*232);
			direction = (int)drand;
			System.out.println ("direction: " + direction);
		 }
   	  	
   	  	 if(  (super.getX() > 360 - WIDTH && super.getX() < 410) && (super.getY() > (460 - HEIGHT) && super.getY() < 600) )
   	  	 {
   	  	 	setEaten(true);
   	  	 	pause();
   	  	 	
   	  	 }
   	  	 
   	  	 else if(  (super.getX() < 0 || super.getX() > 720) || (super.getY() < 0 || super.getY() > 480) )
   	  	 {
		
				if(super.getX() < 0) // hitting left wall
				{
					super.setX(5);
					if(direction == 180)
					{
						double rand = (Math.random()*90) + 270;
						direction = (int)rand;
					}
					
					else if ( direction > 180)
					{
						direction += 90;
					}
					
					else // direction < 180
					{
						direction -= 90;
					}
				}
				
				else if(super.getX() > 720) //hitting right wall
				{
					super.setX(super.getX() - (WIDTH / 5));
					if(direction == 0)
					{
						double rand = (Math.random()*180) + 90;
						direction = (int)rand;
					}
					
					else if ( direction >= 270 && direction <= 360)
					{
						direction -= 90;
					}
					
					else // 0 < direction < 90
					{
						direction += 90;
					}
				}
				
				else if(super.getY() < 0 ) //hitting ceiling
				{
					super.setY(5);
					if(direction == 270)
					{
						double rand = (Math.random()*180);
						direction = (int)rand;
					}
					
					else if ( direction > 270)
					{
						direction -= 270;
					}
					
					else // direction < 270
					{
						direction -= 90;
					}
				}
				
				else //hitting floor
				{
					super.setY(super.getY() - (HEIGHT / 5));
					if(direction == 90)
					{
						double rand = (Math.random()*180) + 180;
						direction = (int)rand;
					}
					
					else if ( direction > 90)
					{
						direction += 90;
					}
					
					else // direction < 90
					{
						direction += 270;
					}
				}
				
				   	  	 	
	   	  	 	step += 1;
	   	  	 	
	   	  	 	double x1 = Math.cos(Math.toRadians(direction))*step;
		   	  	int x = (int) x1;
		   	  	 
		   	  	double y1 = Math.sin(Math.toRadians(direction))*step;
		   	  	int y = (int) y1;
		   	  	 
		        move(x, y);
		        pause();
   	  	 	
   	  	 }
   	  	 
   	  	 else
   	  	 {
   	  	 	double x1 = Math.cos(Math.toRadians(direction))*step;
	   	  	int x = (int) x1;
	   	  	 
	   	  	double y1 = Math.sin(Math.toRadians(direction))*step;
	   	  	int y = (int) y1;
	   	  	 
	        move(x, y);
	        pause();
   	  	 }
   	  	 
   	  	 
   	  }
    	System.out.println ("hasBeenEaten: " + isEaten());
   }
   
    /**
      *Draws the MovingSushi in the current position. Overrides Sushi's draw() method.
      *@param g2 the graphics context
   */
   public void draw(Graphics2D g2)
   {
      super.draw(g2);
      
   }
   
   /**
      *Pauses the animation.
   */
   public void pause()
         throws InterruptedException
   {
      component.repaint();
      Thread.sleep(delay);
   }
   
   /**
      *Gets the identity # of the Sushi object
      *@return the identify #
   */
   public int getIdentifier()
   {
      return identity;
   }
   
   /**
      *Gets whether the MovingSushi has been eaten or not.
      *@return whether the MovingSushi has been eaten or not.
   */
   public boolean isEaten()
   {
   	   return hasBeenEaten;
   }
   
   /**
      *Sets hasBeenEaten to true (for eaten) and false (for not)
      *@param b the boolean hasBeenEaten is being set to 
   */
   public void setEaten(boolean b)
   {
   		hasBeenEaten = b;
   }
   

   


}
