import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Boat extends Racer {
	private int speed;
	private Random rand;

   /** Default Constructor: calls Racer default constructor
   */
   public Boat( )
   {
     super( );

   }

   /** Constructor
   *    @param rID  racer Id, passed to Racer constructor
   *    @param rX    x position, passed to Racer constructor
   *    @param rY    y position, passed to Racer constructor
   */
   public Boat( String rID, int rX, int rY )
   {
     super( rID, rX, rY );
 
   }

   /** move:  Boat moves fast or slow according to the wind. The wind changes every turn.
    * If the random number is odd, the boat moves slow between the speeds of -1 to 1 depending on how strong the waves are
    * If the random number is even, the boat moves fast between the speeds 1 - 4 due to wind blowing in the sail
    *
   */

   public void move( )
   {
	 rand = new Random();
     int move = rand.nextInt(10);
     if (move % 2 == 0) {
    	 setX( getX() + rand.nextInt(4) + 1 );

     }
     else {
    	 setX( getX() - (rand.nextInt(3) - 1));
  
     }
    
 
     
   }

   /** draw: draws the Boat at current (x, y) coordinate. The method draws a boat of specific colors.
   *       @param g   Graphics context
   */
   public void draw( Graphics g )
   {
     int startX = getX( );
     int startY = getY( );
     
     	g.setColor( new Color( 181, 181, 181 ) ); // dark green

     //hull of boat
     g.fillOval( startX - 30, startY, 30, 15 );

     //flatten top of boat
     g.clearRect( startX - 30, startY, 30, 7 );
     //mast
    g.setColor( new Color( 107, 53, 0 ) ); // dark green
    g.fillRect( startX - 15, startY - 10, 3, 15);
    //sail
    g.setColor( new Color( 244, 226, 198));
    g.fillRoundRect(startX - 30, startY - 15, 20, 15, 10, 30);
    
    if (this.isWinner) {
    	morph(g);
    }
 
   }

/**
 * This morph method implemented from the Racer abstract class draws a smiling yellow face if the racer finishes first.
 */
@Override
public void morph(Graphics g) {
	g.clearRect(getX() - 30, getY() - 15, 32, 30);
	g.setColor( new Color(255, 247, 0));
	g.fillOval(getX() - 30, getY() - 15, 32, 30);
	g.setColor(new Color(0, 0, 0));
	g.fillOval( getX() - 10, getY() - 5, 5, 5);
	g.fillOval( getX() - 25, getY() - 5, 5, 5);
	g.fillRoundRect(getX() - 20, getY() + 5, 10, 5, 50, 2);

	
}
   
}
