
/* 
 * Snake game is a game where a snake moves in a direction with the goal of eating apples.
 * The user uses arrow keys to move the snake in a given direction. If a snake eats an apple,
 * it will get a little bit longer and the player will get a point. If the snake runs into 
 * itself or a wall, the game is over.
 */

import processing.core.PApplet;

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
		c.background(255); // clear the screen each time (color white)
		c.stroke(0);   // color black outline
		c.noStroke();  // no outline
		c.fill(255, 0, 0); // (R, G, B) = "red"
		
		c.circle(this.apple.getX(), this.apple.getY(), 10); // put a circle with diameter 10 at the Posn of the apple
        c.rect(this.snake.getX(), this.snake.getY(), 30, 10); 
        c.imageMode(c.CENTER);
		
		return c;
	}
}










