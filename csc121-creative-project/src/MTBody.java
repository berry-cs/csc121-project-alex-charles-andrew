import processing.core.PApplet;

class MTBody implements ISnake{
	
	public PApplet draw(PApplet c) {
		return c; 
	}
	/*
	public ISnake move() {
		return new MTBody();
	}
	
	public ISnake grow(Posn newPosn) {
		return new Body(newPosn, new Posn(10, 0), new MTBody());
	}
	
	public boolean ate(Posn appleLoc) {
		return false;
	}
	*/
	
	public ISnake changeDir(Posn newDir) {
		return this;
	}
	
}





