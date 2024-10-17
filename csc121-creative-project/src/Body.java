import processing.core.PApplet;

class Body implements ISnake{
	Snake body;

	public Body(Snake body) {
		super();
		this.body = body;
	}
	
	/** produce an image of this snake on given canvas */
	public PApplet draw(PApplet c) {
		c.fill(0, 0, 255); // (R, G, B) = "blue"
		//c.circle(this.snake.getX(), this.snake.getY(), 20);
        c.rectMode(PApplet.CENTER);
		c.rect(this.body.head.getX(), this.body.head.getY(), 20, 20);
		return c; 
	}
	
	public Snake changeDir(Posn newDir) {
		return new Snake(this.body.head, newDir);
	}
	
	public Snake move() {
		return new Snake(this.body.head.translate(this.body.curDir),  this.body.curDir);
	}
	
	public boolean ate(Posn appleLoc) {
		return this.body.head.equals(appleLoc);
	}
}