import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import processing.core.PApplet;
import processing.event.KeyEvent;

class SnakeWordTest {
	
	SnakeWorld w1 =  new SnakeWorld(new Snake (new Posn (180, 210), new Posn (250, 180)), new Posn (-10, 0), 12);
	SnakeWorld w2 = new SnakeWorld(new Snake (new Posn (170, 205), new Posn (190, 220)), new Posn (0, 10), 20);
	//SnakeWorld w3 = new SnakeWorld(new Posn (280, 190), new Posn(300, 200));
	//SnakeWorld w4 = new SnakeWorld(new Posn (300, 190), new Posn(300, 200));

	
	
	@Test
	void testKeyPressed() {
		assertEquals( new SnakeWorld(new Snake (new Posn (180, 210), new Posn (10, 0)), new Posn (-10, 0), 12), w1.keyPressed(new KeyEvent(null, 0, 0, 0, '\0', PApplet.RIGHT)));
		assertEquals( new SnakeWorld(new Snake (new Posn (170, 205), new Posn (-10, 0)), new Posn (0, 10), 20), w2.keyPressed(new KeyEvent(null, 0, 0, 0, '\0', PApplet.LEFT)));
		
	}

}
