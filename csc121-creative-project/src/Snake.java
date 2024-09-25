import processing.core.PApplet;

public class Snake {
	Posn head;
	Posn curDir;

	public Snake(Posn head) {
		this.head = head;
		this.curDir = new Posn(10, 0);
	}
	
	public Snake(Posn head, Posn curDir) {
		super();
		this.head = head;
		this.curDir = curDir;
	}

	/** produce an image of this snake on given canvas */
	public PApplet draw(PApplet c) {
		c.fill(0, 0, 255); // (R, G, B) = "blue"
		//c.circle(this.snake.getX(), this.snake.getY(), 20);
        c.rectMode(PApplet.CENTER);
		c.rect(this.head.getX(), this.head.getY(), 20, 20);
		return c; 
	}

	public Snake changeDir(Posn newDir) {
		return new Snake(this.head, newDir);
	}
	
	public Snake move() {
		return new Snake(this.head.translate(this.curDir),  this.curDir);
	}
	
	public boolean ate(Posn appleLoc) {
		return this.head.equals(appleLoc);
	}
	
	
}

/*
hitting arrow keys should change the snake's direction, not actually move at that point



Posn curDir;    =   0,10   or 0,-10  or 10,0 or -10,0
current direction
list of segments





*/