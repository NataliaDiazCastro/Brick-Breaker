
//This "Paddle" class extends the "Structure" class. It is used for the player's paddle in the game.

//Imports
import java.awt.*;
import java.awt.event.*;

//Class definition
public class Paddle extends Structure implements Constants {
	//Variables
	private int xSpeed;
        private int w,h;

	//Constructor
	public Paddle(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
                xSpeed = x;
                w = width;
                h = height;
	}

	//Draws the paddle
	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(xSpeed, y, w, h);
	}

         public void moveRight(){
        //System.out.println("pos x: "+x);
            if(xSpeed < 10 ){
                xSpeed = 10;
            }else{
                xSpeed += 50;
            }
        }
    public void moveLeft(){
        //System.out.println("pos x: "+x);
        if(xSpeed > 400){
            xSpeed = 400;
        }else{
            xSpeed -= 50;
        }
    }
	//Places the paddle back in starting position at center of screen
	public void reset() {
		x = PADDLE_X_START;
		y = PADDLE_Y_START;
	}

	//Checks if the ball hit the paddle
	public boolean hitPaddle(int ballX, int ballY) {
		if (((ballX >= xSpeed)) && (ballX  <= xSpeed + w) && ((ballY >= y) && (ballY <= y + h))) {
			return true;
		}
		return false;
	}

	//Resizes the paddle if it touches an item, then returns true or false
	public boolean caughtItem(Item i) {
		if ((i.getX() < xSpeed + w) && (i.getX() + i.getWidth() > xSpeed) && (y == i.getY() || y == i.getY() - 1)) {
			i.resizePaddle(this);
			return true;
		}
		return false;
	}
        
        public void aumentar(){
        w += 15;
    }
    
    public void disminuir(){
        w -= 15;
    }
}
