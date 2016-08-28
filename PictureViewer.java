/**
 *Bryan Leung
 *Mrs. Gallatin
 *PictureViewer
 *makes a JFrame to view the foodComponents objects
**/

import javax.swing.JFrame;

/**
 * Shows an animation of moving food Objects
 */
public class PictureViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FRAME_WIDTH = 800;
      final int FRAME_HEIGHT = 600;

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("Picture Viewer");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      foodComponent component = new foodComponent();
	  	  
      frame.add(component);

      frame.setVisible(true);
      component.startAnimation();
 
   }
}

