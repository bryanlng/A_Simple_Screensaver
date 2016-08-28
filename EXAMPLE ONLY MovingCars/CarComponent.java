import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
   This component draws two car shapes.
*/
public class CarComponent extends JComponent
{  
   private MovingCar car1;
   private MovingCar car2;
   private MovingCar car3;
	
	/**
	 * Adds cars to the component
	 */
   public CarComponent()
   {
      // https://docs.oracle.com/javase/tutorial/java/javaOO/thiskey.html
      car1 = new MovingCar(50, 100, 10, 250, 500, MovingCar.EAST, this);
      car2 = new MovingCar(500, 300, 10, 250, 500, MovingCar.NORTH, this);
      car3 = new MovingCar(500,100,10,250,500,MovingCar.WEST,this);
      
   }
   
   /**
    * Draws the cars
    */
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;

      car1.draw(g2);
      car2.draw(g2);
      car3.draw(g2);
   }
   
   /**
      Starts a new animation thread.
   */
   public void startAnimation()
   {
      class AnimationRunnable implements Runnable
      {
         private MovingCar car;
         
         public AnimationRunnable(MovingCar car)
         {
            this.car = car;
         }

         public void run()
         {
            try
            {
               car.animate();
            }
            catch (InterruptedException exception)
            {
            }
         }
         
      }

      Runnable r1 = new AnimationRunnable(car1);
      Runnable r2 = new AnimationRunnable(car2);
      Runnable r3 = new AnimationRunnable(car3);
      Thread t1 = new Thread(r1);
      Thread t2 = new Thread(r2);
      Thread t3 = new Thread(r3);
      t1.start();
      t2.start();
      t3.start();
   }
   

}