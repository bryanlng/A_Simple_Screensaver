/**
 *Bryan Leung
 *Mrs. Gallatin
 *foodComponent
 *the JComponent for the food
**/

import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.File;


/**
   This component draws pictures.
*/
public class foodComponent extends JComponent
{  
  //make 12 threads 
     private MovingSushi sushi;
     private MovingPizza pizza;
     private MovingHotdog hotdog;
     
     private MovingSushi sushi1;
     private MovingPizza pizza1;
     private MovingHotdog hotdog1;
     
     private MovingSushi sushi2;
     private MovingPizza pizza2;
     private MovingHotdog hotdog2;
     
     private MovingSushi sushi3;
     private MovingPizza pizza3;
     private MovingHotdog hotdog3;
	 
	 
  /**
   * Adds MovingSushi, MovingPizza, and MovingHotdog objects to the component
   */
   public foodComponent()
   {
   	//public MovingSushi(int x, int y, int step, int delay, double direction, JComponent component)
    sushi = new MovingSushi(  560, 400, 5, 20, 234, this);
    pizza = new MovingPizza(  232, 45, 5, 20, 30, this);
    hotdog = new MovingHotdog(379, 220, 5, 20, 123, this);
    
    sushi1 = new MovingSushi(  127, 22, 5, 20, 32, this);
    pizza1 = new MovingPizza(  33, 87, 5, 20, 344, this);
    hotdog1 = new MovingHotdog(700, 376, 5, 20, 100, this);
    
    sushi2 = new MovingSushi(  321, 21, 5, 20, 98, this);
    pizza2 = new MovingPizza(  199, 3, 5, 20, 11, this);
    hotdog2 = new MovingHotdog(99, 456, 5, 20, 156, this);
    
    sushi3 = new MovingSushi(  442, 212, 5, 20, 43, this);
    pizza3 = new MovingPizza(  123, 555, 5, 20, 266, this);
    hotdog3 = new MovingHotdog(545, 89, 5, 20, 120, this);
    
   }
   
   /**
    * Called each time. First creates the background image. Then, checks to see if each object has not been eaten yet. If it has not been, it will be drawn.
    */
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;
      
	  try
	  {
	  	BufferedImage img = ImageIO.read(new File("test3.jpg"));
	  	g.drawImage(img, 0 , 0 , null);
	  }
	  
	  catch(Exception e)
	  {
	  	e.printStackTrace();
	  }
	  
	  if(!sushi.isEaten())
	  {
	  	sushi.draw(g2);
	  }	  
	  
	  if(!sushi1.isEaten())
	  {
	  	sushi1.draw(g2);
	  }	
	  	
	  if(!sushi2.isEaten())
	  {
	  	sushi2.draw(g2);
	  }	
	  	
	  if(!sushi3.isEaten())
	  {
	  	sushi3.draw(g2);
	  }	
	  	
	  
	  if(!pizza.isEaten())
	  {
	  	pizza.draw(g2);
	  }
	  
	  if(!pizza1.isEaten())
	  {
	  	pizza1.draw(g2);
	  }
	  
	  if(!pizza2.isEaten())
	  {
	  	pizza2.draw(g2);
	  }
	  
	  if(!pizza3.isEaten())
	  {
	  	pizza3.draw(g2);
	  }
	 
	  if(!hotdog.isEaten())
	  {
	  	hotdog.draw(g2);
	  }
	  
	  if(!hotdog1.isEaten())
	  {
	  	hotdog1.draw(g2);
	  }
	  
	  if(!hotdog2.isEaten())
	  {
	  	hotdog2.draw(g2);
	  }
	  
	  if(!hotdog3.isEaten())
	  {
	  	hotdog3.draw(g2);
	  }
	  
//	  g2.setColor(Color.black);
//	  Rectangle rect 
//           = new Rectangle(297, 385, 183, 203); 
//           	
//      g2.fill(rect);
	  
//	  g2.setColor(Color.black);
//	  Ellipse2D.Double circle 
//           = new Ellipse2D.Double(305, 385, 195, 195); 
//           	
//      g2.fill(circle);
	  
	  
	  
	  
	  
	  
	  
      
   }
      
   /**
      Starts a new animation thread that uses the AnimationRunnable inner class. 
   */
   public void startAnimation()
   {	
      /**
       * Has 3 constructors for each Moving<Food> object. Uses the identify() method in the run() method.
       */     
      class AnimationRunnable implements Runnable
      {
        private MovingSushi sush;
     	private MovingPizza piz;
     	private MovingHotdog hot;
     	private int identity; 
         
         //cannot make MovingSushi extend MovingFood

       /**
       *Creates a new AnimationRunnable that takes a MovingSushi instance
       *@param s The MovingSushi object 
       */ 
       public AnimationRunnable(MovingSushi s)
       {
          sush = s;
          identity = sush.getIdentifier();
          System.out.println ("identity: " + identity);
       }
       
       /**
       *Creates a new AnimationRunnable that takes a MovingPizza instance
       *@param p The MovingPizza object 
       */   
       public AnimationRunnable(MovingPizza p)
       {
            piz = p;
		    identity = piz.getIdentifier();
       }
       
       /**
       *Creates a new AnimationRunnable that takes a MovingHotdog instance
       *@param h The MovingHotdog object 
       */   
       public AnimationRunnable(MovingHotdog h)
       {
            hot = h;
	        identity = hot.getIdentifier();
       }
       
       /**
       *Uses each Moving<Food>'s animate() method. Identifies between Moving<Food> objects using identify()
       */ 
       public void run()
       {
          try
          {
//             sush.animate();
             if(identity == 1)
             {
             		sush.animate();
             }
             
             else if ( identity == 2)
             {
             		hot.animate();
             }
             
             else
             {
             		piz.animate();
             }
           }
          catch (InterruptedException exception)
          {
          	
          }
       }
         
      }
      
      Runnable r1 = new AnimationRunnable(sushi);
	  Thread t1 = new Thread(r1);
	  t1.start();
	  
	  Runnable r2 = new AnimationRunnable(hotdog);
	  Thread t2 = new Thread(r2);
	  t2.start();
	  
	  Runnable r3 = new AnimationRunnable(pizza);
	  Thread t3 = new Thread(r3);
	  t3.start();
	  
	  Runnable r4 = new AnimationRunnable(sushi1);
	  Thread t4 = new Thread(r4);
	  t4.start();
	  
	  Runnable r5 = new AnimationRunnable(hotdog1);
	  Thread t5 = new Thread(r5);
	  t5.start();
	  
	  Runnable r6 = new AnimationRunnable(pizza1);
	  Thread t6 = new Thread(r6);
	  t6.start();
//	  
	  Runnable r7 = new AnimationRunnable(sushi2);
	  Thread t7 = new Thread(r7);
	  t7.start();
	  
	  Runnable r8 = new AnimationRunnable(hotdog2);
	  Thread t8 = new Thread(r8);
	  t8.start();
	  
	  Runnable r9 = new AnimationRunnable(pizza2);
	  Thread t9 = new Thread(r9);
	  t9.start();
	  
	  Runnable r1a = new AnimationRunnable(sushi3);
	  Thread t1a = new Thread(r1a);
	  t1a.start();
	  
	  Runnable r1b = new AnimationRunnable(hotdog3);
	  Thread t1b = new Thread(r1b);
	  t1b.start();
	  
	  Runnable r1c = new AnimationRunnable(pizza3);
	  Thread t1c = new Thread(r1c);
	  t1c.start();
//	  

   }
   
   

}