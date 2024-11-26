import java.util.Objects;


/*
 * A Snake contains a ListOfPosns AND a current direction. CurDir is 
 * a vector that directs the snake to go either left, right, up, or down.
 * A ListOfPosns is either empty OR a Posn first ListOfPosns rest.
 */


import processing.core.PApplet;

public class Snake {
	
	private ILoP segments;
	private Posn curDir;
	
	
	public static final int SnakeOB = 380;
	
	public Snake(ILoP segments, Posn curDir) {
		super();
		this.segments = segments;
		this.curDir = curDir;
	}

	
	// This draw method draws the blue segments of the snake on the screen.
	public PApplet draw(PApplet c) {
		c.fill(0, 0, 255); // (R, G, B) = "blue"
        
		segments.draw(c);
		return c; 
	}
	
	
	// This method changes the direction of the snake to the new given posn. NewDir must be either: (20,0) , (0,20) . (-20,0) , OR (0, -20)
	public Snake changeDir(Posn newDir) {
		return new Snake(this.segments, newDir);
	}
	
	
	// This method controls the movement of a snake. If a snake goes out of bounds, do not move the snake. Otherwise, move the snake in the curDir.
	// To make it move, we can add 1 segment to the beginning of the list of segments and then drop the last segment.
	public Snake move() {
		if (this.outOfBounds()) {
			return this;
		} else {
		return new Snake(new Consp( segments.getFirst().translate(curDir), segments).dropLast()  , curDir);
		}
	}

	
	// This method is triggered when a snake eats an apple. To make it grow, we can add a segment to the beginning of a list of segments. However,
	// we do not drop the last segment. This makes the snake get longer.
	public Snake grow() {
		return new Snake(new Consp( segments.getFirst().translate(curDir), segments) , curDir);
	}

	
	// This method checks to see if a snake eats an apple(Check to see if the first segment is on the apple).
	public boolean ate(Posn appleLoc) {
		return this.segments.getFirst().equals(appleLoc);
	}
	
	
	// This method checks to see if the first segment of a snake goes out of bounds in any direction of the screen. 
	public boolean outOfBounds() {
		return this.segments.getFirst().getX() < 10 || 
				this.segments.getFirst().getY() < 10 ||
				this.segments.getFirst().getX() > SnakeApp.Width - 20 ||
				this.segments.getFirst().getY() > SnakeOB ;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(curDir, segments);
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
		return Objects.equals(curDir, other.curDir) && Objects.equals(segments, other.segments);
	}

	@Override
	public String toString() {
		return "Snake [segments=" + segments + ", curDir=" + curDir + "]";
	}
	
	
	
}



