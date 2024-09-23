
/* 
 * Snake game is a game where a snake moves in a direction with the goal of eating apples.
 * The user uses arrow keys to move the snake in a given direction. If a snake eats an apple,
 * it will get a little bit longer and the player will get a point. If the snake runs into 
 * itself or a wall, the game is over.
 */

import java.util.Objects;

import processing.core.PApplet;
import processing.event.KeyEvent;

public class SnakeWorld implements IWorld {
	Posn snake;
	Posn apple;
	int speed = 20;
	
	public SnakeWorld(Posn snake, Posn apple) {
		super();
		this.snake = snake;
		this.apple = apple;
	}
	
	/** produce an image of the state of this animation on given canvas */
	public PApplet draw(PApplet c) {
		c.background(160, 190, 100); // clear the screen each time (color white)
		c.stroke(0);   // color black outline
		c.noStroke();  // no outline
		
		c.fill(255, 0, 0); // (R, G, B) = "red"
		c.circle(this.apple.getX(), this.apple.getY(), 20); // put a circle with diameter 10 at the Posn of the apple
        
		c.fill(0, 0, 255); // (R, G, B) = "blue"
		c.rect(this.snake.getX(), this.snake.getY(), -60, 20, 28); 
        c.rectMode(c.CORNER);
        
        c.fill(255, 255, 255);
        c.circle((this.snake.getX() - 5), (this.snake.getY() + 5), 5);
		
		return c;
	}
	
	/** moves the snake in response to arrow keys */
    public IWorld keyPressed(KeyEvent kev) {
    	///    kev.getKey() == 'A'
        if (kev.getKeyCode() == PApplet.UP) {
            return new SnakeWorld(this.snake.translate(new Posn(0, -20)), this.apple);
        } else if (kev.getKeyCode() == PApplet.DOWN) {
            return new SnakeWorld(this.snake.translate(new Posn(0, 20)), this.apple);
        } else if (kev.getKeyCode() == PApplet.LEFT) {
            return new SnakeWorld(this.snake.translate(new Posn(-20, 0)), this.apple);
        } else if (kev.getKeyCode() == PApplet.RIGHT) {
            return new SnakeWorld(this.snake.translate(new Posn(20, 0)), this.apple);
        } else {
            return this;
        }
    }
    
    
    /** moves the snake constantly in the direction given */
    public IWorld update() {
        if (this.snake.equals(apple)) {
            return new SnakeWorld(this.snake, this.apple.RandPosn());  // move the apple to a random Posn
        } else {
            return new SnakeWorld(this.snake,
                                this.apple);
        }
    }

	@Override
	public int hashCode() {
		return Objects.hash(apple, snake, speed);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SnakeWorld other = (SnakeWorld) obj;
		return Objects.equals(apple, other.apple) && Objects.equals(snake, other.snake) && speed == other.speed;
	}

	@Override
	public String toString() {
		return "SnakeWorld [snake=" + snake + ", apple=" + apple + ", speed=" + speed + "]";
	}
     
	
}












