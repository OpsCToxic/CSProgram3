import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Car extends Racer {

   /** Default Constructor: calls Racer default constructor
   */
	private int move;
	
   public Car( )
   {
     super( );
     move = 0;
   }

   /** Constructor
   *    @param rID  racer Id, passed to Racer constructor
   *    @param rX    x position, passed to Racer constructor
   *    @param rY    y position, passed to Racer constructor
   */
   public Car( String rID, int rX, int rY )
   {
     super( rID, rX, rY );
     
   }

   /** move:  calculates the new x position for the racer
   *   Car move characteristics: "Car starts slow but accelerates quickly Speed exponentially increases.
   *   The car's acceleration depends on how fast the move field adds the random integers from 0 to 10 every move.. Each 
   *   value has a specific speed that the car is set at, rapidly increasing its pace at a constant acceleration
   *   Car's top speed is 20 spaces per move
   */
   public void move( )
   {
	 Random rand = new Random();
     move += rand.nextInt(10);
     if (move > 0) {
    	if (move <= 5) {
      		setX( getX( ) + 1 );
      	}
      	else if (move <= 100 )  {
      		setX( getX( ) + 2 );
      	}
      	else if (move <= 1000)  {
      		setX( getX( ) + 4 );
      	}
      	else if (move <= 1500)  {
      		setX( getX( ) + 8 );
      	}
      	else if (move <= 2000)  {
      		setX( getX( ) + 16 );
      	}
      	else {
          	setX( getX( ) + 20 );
        
      	}
 
     }
    
     
     
   }

   /** draw: draws the Car at current (x, y) coordinate. This method draws a car.
   *       @param g   Graphics context
   */
   public void draw( Graphics g )
   {
	
     int startX = getX( );
     int startY = getY( );
     
     g.setColor( new Color( 38, 53, 235 ) ); // blue

     //chasis
     g.fillRect( startX - 30, startY, 50, 15 );

     //wheels
     g.setColor( new Color( 0, 0, 0 ) ); //black
     g.fillOval( startX - 30, startY + 5, 20, 20 );
     g.fillOval( startX + 8, startY + 5, 20, 20 );
     g.setColor( new Color( 181, 181, 193 ) ); //grey
     g.fillOval( startX - 26, startY + 10, 10, 10 );
     g.fillOval( startX + 13, startY + 10, 10, 10 );

     //top
     g.setColor( new Color( 255, 0, 0 ) );
     g.fillRoundRect(startX - 15, startY - 15, 40, 15, 20, 30);

     if (this.isWinner) {
    	 morph(g);
     }
     
   }

/**
 * This morph method implemented from the Racer abstract class draws a hat on top of the car if the car finishes in first place in the race.
 */
@Override
public void morph(Graphics g) {
	// TODO Auto-generated method stub
	Random rand = new Random();
	g.setColor(new Color(rand.nextInt(256),rand.nextInt(256) , rand.nextInt(256)));
	g.fillOval( getX() - 10, getY() - 20, 30, 10);
	g.setColor(new Color (rand.nextInt(256),rand.nextInt(256) , rand.nextInt(256)));
	g.fillRect( getX(), getY() - 34, 15, 20);
	
}
   
}

