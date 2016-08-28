import javax.swing.JComponent;
import java.awt.Graphics2D;

public class MovingCar extends Car
{
   
   public static final int NORTH = 1;
   public static final int SOUTH = 2;
   public static final int EAST = 3;
   public static final int WEST = 4;
   
   private int step;
   private int delay;
   private int steps;
   private int direction;
   private JComponent component;
   
   /**
      Creates a new MovingCarInstance
      @param x the x coordinate of the top left corner
      @param y the y coordinate of the top left corner
      @param step Step in pixels the car will move each time
      @param delay The delay to wait between each step
      @param steps How many times the car will move
      @param direction In which direction the car will move
      @param component The component
    */
   public MovingCar(int x, int y, int step, int delay, int steps,
         int direction, JComponent component)
   {
      super(x, y);
      this.step = step;
      this.delay = delay;
      this.steps = steps;
      this.direction = direction;
      this.component = component;
   }
   
   /**
    * Adjusts the car's x and y locations based on the direction it is going.  Moves it a fixed
    * number of steps.
    */
   public void animate()
         throws InterruptedException
   {
      for (int i = 0; i < steps; i++)
      {
         int x = 0;
         int y = 0;
         switch(direction)
         {
            case NORTH: y = -1 * step;
               break;
            case SOUTH: y = step;
               break;
            case EAST: x = step;
               break;
            case WEST: x = -1 * step;
         }
         
         move(x, y);
         pause();
      }
   }
   
    /**
      Draws the car in the current position.
      @param g2 the graphics context
   */
   public void draw(Graphics2D g2)
   {
      super.draw(g2);
   }
   
   /**
      Pauses the animation.
   */
   public void pause()
         throws InterruptedException
   {
      component.repaint();
      Thread.sleep(delay);
   }
   
}
