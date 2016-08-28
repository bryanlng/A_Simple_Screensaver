/**
 *Bryan Leung
 *Mrs. Gallatin
 *PictureViewer
 *makes a JFrame to view the Camera objects
**/

/**
 *the sub never stated that this lab was due on friday. In fact, he did not say anything at all during the class period?
 *There was no due date stated in the pdf. So, I assumed that the assignment was due on Monday.
**/



import javax.swing.JFrame;

/**
 * Shows an animation of moving cars
 */
public class PictureViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FRAME_WIDTH = 600;
      final int FRAME_HEIGHT = 400;

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("Picture Viewer");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      PictureComponent component = new PictureComponent();
      frame.add(component);

      frame.setVisible(true);
 
   }
}

