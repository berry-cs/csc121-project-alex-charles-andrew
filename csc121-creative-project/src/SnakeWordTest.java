import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import processing.core.PApplet;
import processing.event.KeyEvent;

class SnakeWordTest {
	
	SnakeWorld w1 = new SnakeWorld(new Posn (160, 190), new Posn(300, 200));
	SnakeWorld w2 = new SnakeWorld(new Posn (180, 190), new Posn(300, 200));
	SnakeWorld w3 = new SnakeWorld(new Posn (280, 190), new Posn(300, 200));
	SnakeWorld w4 = new SnakeWorld(new Posn (300, 190), new Posn(300, 200));

	
	
	@Test
	void testKeyPressed() {
		assertEquals( w2, w1.keyPressed(new KeyEvent(null, 0, 0, 0, '\0', PApplet.RIGHT)));
	}

}
