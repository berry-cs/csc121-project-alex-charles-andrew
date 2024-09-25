import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import processing.core.PApplet;
import processing.event.KeyEvent;

class SnakeWordTest {
	
	//SnakeWorld w1 = new SnakeWorld(new Posn (160, 190), new Posn(300, 200));
	//SnakeWorld w2 = new SnakeWorld(new Posn (180, 190), new Posn(300, 200));
	SnakeWorld w3 = new SnakeWorld(new Snake(new Posn (20, 10), new Posn (10, 0)), new Posn(5, 10), 5);
	SnakeWorld w4 = new SnakeWorld(new Snake(new Posn (40, 20), new Posn (0, -10)), new Posn(10, 15), 10);
	SnakeWorld w5 = new SnakeWorld(new Snake(new Posn (50, 30), new Posn (-10, 0)), new Posn(20, 10), 8);
	SnakeWorld w6 = new SnakeWorld(new Snake(new Posn (40, 10), new Posn (10, 0)), new Posn(10, 30), 15);
			//new SnakeWorld(new Posn (280, 190), new Posn(300, 200));
	 
	//new SnakeWorld(new Posn (300, 190), new Posn(300, 200));

	
	
	@Test
	void testKeyPressed() {
		assertEquals(  new SnakeWorld(new Snake(new Posn (20, 10), new Posn (10, 0)), new Posn(5, 10), 5), w3.keyPressed(new KeyEvent(null, 0, 0, 0, '\0', PApplet.RIGHT)));
		assertEquals(  new SnakeWorld(new Snake(new Posn (40, 20), new Posn (-10, 0)), new Posn(10, 15), 10), w4.keyPressed(new KeyEvent(null, 0, 0, 0, '\0', PApplet.LEFT)));
		assertEquals(  new SnakeWorld(new Snake(new Posn (50, 30), new Posn (0, 10)), new Posn(20, 10), 8), w5.keyPressed(new KeyEvent(null, 0, 0, 0, '\0', PApplet.DOWN)));
		assertEquals(  new SnakeWorld(new Snake(new Posn (40, 10), new Posn (0, -10)), new Posn(10, 30), 15), w6.keyPressed(new KeyEvent(null, 0, 0, 0, '\0', PApplet.UP)));
	}

}
