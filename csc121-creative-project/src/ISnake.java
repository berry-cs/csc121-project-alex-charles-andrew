import processing.core.PApplet;

interface ISnake{
	
	public PApplet draw(PApplet c);
	
	public ISnake changeDir(Posn newDir);
	
	public ISnake move();
	
	public boolean ate(Posn appleLoc);
	
	public ISnake grow(Posn newPos);
	

}