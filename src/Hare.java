/** Hare class
*   inherits from abstract Racer class
*/

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Hare extends Racer
{
   /** Default Constructor: calls Racer default constructor
   */
   public Hare( )
   {
     super( );
   }

   /** Constructor
   *    @param rID   racer Id, passed to Racer constructor
   *    @param rX    x position, passed to Racer constructor
   *    @param rY    y position, passed to Racer constructor
   */
   public Hare( String rID, int rX, int rY )
   {
     super( rID, rX, rY );
   }

   /** move:  calculates the new x position for the racer
   *   Hare move characteristics:  30% of the time, Hare jumps 5 pixels
   *                               70% of the time, Hare sleeps (no move)
   *   generates random number between 1 & 10
   *          for 1 - 7,  no change to x position
   *          for 8 - 10, x position is incremented by 5
   */
   public void move( )
   {
     Random rand = new Random( );
     int move =  rand.nextInt( 10 ) + 1 ;

     if ( getX( ) < 100 )
     {
      if ( move > 7 )
       setX( getX( ) + 5 );
     }
     else
     {
      if ( move > 7 )
       setX( getX( ) + 5 );
     }
   }

   /** draw: draws the Hare at current (x, y) coordinate
   *   @param g   Graphics context
   */
   public void draw( Graphics g )
   {
     int startY = getY( );
     int startX = getX( );

     // tail
     g.setColor( Color.LIGHT_GRAY );
     g.fillOval( startX - 37, startY + 8,  12, 12 ) ;

     //body
     g.setColor( Color.GRAY );
     g.fillOval( startX - 30, startY,  20,  20 );

     //head
     g.fillOval( startX - 13, startY + 2, 13, 8 );
     g.fillOval( startX - 13, startY - 8, 8, 28 );

     //flatten bottom
     g.clearRect( startX - 37, startY + 15, 32, 5 );
     if (this.isWinner) {
    	 morph(g);
     }
   }

/**
 * This morph method implemented from the Racer abstract class morphs the hare racer into a randomly colored face and randomly colored hat if it finishes first.
 */
@Override
public void morph(Graphics g) {
	// TODO Auto-generated method stub
	Random rand = new Random();
	g.clearRect(getX() - 40, getY() - 10, 42, 40);
	g.setColor( new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
	g.fillOval(getX() - 40, getY() - 15, 32, 30);
	g.setColor(new Color(0, 0, 0));
	g.fillOval( getX() - 15, getY() - 5, 5, 5);
	g.fillOval( getX() - 30, getY() - 5, 5, 5);
	g.fillRoundRect(getX() - 30, getY() + 5, 10, 5, 50, 2);
	g.setColor(new Color(rand.nextInt(256),rand.nextInt(256) , rand.nextInt(256)));
	g.fillOval( getX() - 37, getY() - 20, 30, 10);
	g.setColor(new Color (rand.nextInt(256),rand.nextInt(256) , rand.nextInt(256)));
	g.fillRect( getX() - 30, getY() - 34, 15, 20);
	
}

}