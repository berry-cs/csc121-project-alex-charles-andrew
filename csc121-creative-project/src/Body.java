import processing.core.PApplet;

class Body implements ISnake{
	Posn pos;
	Posn curDir;
	ISnake next;
	
	

	public Body(Posn pos, Posn curDir, ISnake next) {
		super();
		this.pos = pos;
		this.curDir = curDir;
		this.next = next;
	}

	/** produce an image of this snake on given canvas */
	public PApplet draw(PApplet c) {
		c.fill(0, 0, 255); // (R, G, B) = "blue"
		//c.circle(this.snake.getX(), this.snake.getY(), 20);
        c.rectMode(PApplet.CENTER);
		c.rect(this.pos.getX(), this.pos.getY(), 20, 20);
		return c; 
	}
	
	public ISnake changeDir(Posn newDir) {
		return new Body(this.pos, this.curDir, this.next.changeDir(newDir));
	}
	
	public ISnake move() {
		return new Body(pos.translate(this.curDir), this.curDir, this.next.move());
	}
	
	public ISnake grow(Posn newPos) {
		return new Body(this.pos, this.curDir, this.next); //////////////// HELP HERE. CANT GET SNAKE TO GROW
	}
	
	public boolean ate(Posn appleLoc) {
		return this.pos.equals(appleLoc);
	}
}