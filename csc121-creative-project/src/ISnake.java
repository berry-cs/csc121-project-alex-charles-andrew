import processing.core.PApplet;

interface ISnake{
	
	public PApplet draw(PApplet c);
	
	public Snake changeDir(Posn newDir);
	
	public Snake move();
	
	public boolean ate(Posn appleLoc);
	

}