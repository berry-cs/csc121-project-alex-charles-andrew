
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
	private Snake snake;
	private Posn apple;
	private int clock;
	private final int SPEED = 20;
	 int score = 0;
	
	public SnakeWorld(Snake snake, Posn apple, int clock, int score) {
		super();
		this.snake = snake;
		this.apple = apple;
		this.clock = clock;
		this.score = score;
	}
	
	/** produce an image of the state of this animation on given canvas */
	public PApplet draw(PApplet c) {
		c.background(160, 190, 100); // clear the screen each time (color white)
		c.stroke(100,100,100);
		c.strokeWeight(10);
		c.noFill();
		c.rect(200, 200, c.width - 10, c.height - 10);
		
		c.noStroke();
		
		
		c.fill(255, 0, 0); // (R, G, B) = "red"
		c.circle(this.apple.getX(), this.apple.getY(), 20); // put a circle with diameter 10 at the Posn of the apple
		
		c.fill(0, 0, 0);
		c.textSize(15);
		c.textAlign(PApplet.CENTER, PApplet.CENTER);
		c.text("Your Score: " + this.score, c.width / 7, c.height / 20);
        
		this.snake.draw(c);
		
		
		return c;
	}
	
	/** moves the snake in response to arrow keys */
    public IWorld keyPressed(KeyEvent kev) {
    	///    kev.getKey() == 'A'
        if (kev.getKeyCode() == PApplet.UP) {
            return new SnakeWorld(this.snake.changeDir(new Posn(0, -20)), this.apple, this.clock, this.score);
        } else if (kev.getKeyCode() == PApplet.DOWN) {
            return new SnakeWorld(this.snake.changeDir(new Posn(0, 20)), this.apple, this.clock, this.score);
        } else if (kev.getKeyCode() == PApplet.LEFT) {
            return new SnakeWorld(this.snake.changeDir(new Posn(-20, 0)), this.apple, this.clock, this.score);
        } else if (kev.getKeyCode() == PApplet.RIGHT) {
            return new SnakeWorld(this.snake.changeDir(new Posn(20, 0)), this.apple, this.clock, this.score);
        } else {
            return this;
        }
    }
    
    
    /** moves the snake constantly in the direction given */
    public IWorld update() {
    	if (this.snake.outOfBounds()) {
    		return new GameOverWorld(this);
    	} else if (this.snake.ate(apple)) {
        	score = score + 1;
            return new SnakeWorld(this.snake.grow(), this.apple.RandPosn(), this.clock+1, this.score);  // move the apple to a random Posn
        } else if (this.clock % this.SPEED == 0) {
            return new SnakeWorld(this.snake.move(),
                                this.apple, this.clock+1, this.score);
        } else {
        	return new SnakeWorld(this.snake,
        					this.apple, this.clock+1, this.score);
        }
    }

	@Override
	public int hashCode() {
		return Objects.hash(SPEED, apple, clock, snake);
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
		return SPEED == other.SPEED && Objects.equals(apple, other.apple) && clock == other.clock
				&& Objects.equals(snake, other.snake);
	}

	@Override
	public String toString() {
		return "SnakeWorld [snake=" + snake + ", apple=" + apple + ", clock=" + clock + ", SPEED=" + SPEED + "]";
	}

	
	
}












