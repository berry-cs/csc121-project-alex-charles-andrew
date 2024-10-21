import java.util.Objects;

import processing.core.PApplet;

public class Snake {
	
	ILoP segments;
	Posn curDir;
	
	public Snake(ILoP segments, Posn curDir) {
		super();
		this.segments = segments;
		this.curDir = curDir;
	}

	public PApplet draw(PApplet c) {
		c.fill(0, 0, 255); // (R, G, B) = "blue"
		//c.circle(this.snake.getX(), this.snake.getY(), 20);
        
		segments.draw(c);
		return c; 
	}
	
	public Snake changeDir(Posn newDir) {
		return new Snake(this.segments, newDir);
	}
	
	public Snake move() {
		return new Snake(new Consp( segments.getFirst().translate(curDir), segments).dropLast()  , curDir);
	}

	public Snake grow() {
		return new Snake(new Consp( segments.getFirst().translate(curDir), segments) , curDir);
	}

	
	public boolean ate(Posn appleLoc) {
		return false;
	}
	
}


/*
 * public class Snake implements ISnake{
 
	Posn head;
	Posn curDir;
	ISnake body;
	
	// Can't remember why we have 2 different constructors here?? Do we need both??

	public Snake(Posn head, ISnake body) {
		this.head = head;
		this.curDir = new Posn(10, 0);
		this.body = body;
	}
	
	public Snake(Posn head, Posn curDir, ISnake body) {
		super();
		this.head = head;
		this.curDir = curDir;
		this.body = body;
	}

	/** produce an image of this snake on given canvas 
	public PApplet draw(PApplet c) {
		c.fill(0, 0, 255); // (R, G, B) = "blue"
		//c.circle(this.snake.getX(), this.snake.getY(), 20);
        c.rectMode(PApplet.CENTER);
		c.rect(this.head.getX(), this.head.getY(), 20, 20);
		return c; 
	}

	public Snake changeDir(Posn newDir) {
		return new Snake(this.head, newDir, this.body);
	}
	
	public ISnake move() {
		return new Snake(this.head.translate(this.curDir),  this.curDir, this.body);
	}
	
	public boolean ate(Posn appleLoc) {
		return this.head.equals(appleLoc);
	}
	
	public ISnake grow(Posn newPos) {
		return new Snake(this.head, this.curDir, this.body.grow(this.head)); ///////////////////////////// HELP HERE??????
	}

	@Override
	public int hashCode() {
		return Objects.hash(curDir, head);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Snake other = (Snake) obj;
		return Objects.equals(curDir, other.curDir) && Objects.equals(head, other.head);
	}

	@Override
	public String toString() {
		return "Snake [head=" + head + ", curDir=" + curDir + "]";
	}
	
	
	
	
}


hitting arrow keys should change the snake's direction, not actually move at that point



Posn curDir;    =   0,10   or 0,-10  or 10,0 or -10,0
current direction
list of segments





*/


