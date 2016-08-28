/**
 *Bryan Leung
 *Mrs. Gallatin
 *PictureComponent
 *the JComponent for the Camera
**/

/**
 *the sub never stated that this lab was due on friday. In fact, he did not say anything at all during the class period?
 *There was no due date stated in the pdf. So, I assumed that the assignment was due on Monday.
**/


import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
   This component draws pictures.
*/
public class PictureComponent extends JComponent
{  
   private Animatable one;
   private Animatable two;
   
	/**
	 * Adds pictures to the component
	 */
   public PictureComponent()
   {
      one = new Camera(50, 100); // change to instantiate YOUR picture object
      two = new Camera(500, 300);// change to instantiate YOUR picture object
      
   }
   
   /**
    * Draws the pictures, moves them, draws them again.
    */
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;

      //components have methods draw(), move(dx, dy);
      one.draw(g2);
      two.draw(g2);
      one.move(90,90);
      two.move(-70,-110);
      one.draw(g2);
      two.draw(g2);
   }
   
   

}