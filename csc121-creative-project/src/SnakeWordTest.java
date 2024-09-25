import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import processing.core.PApplet;
import processing.event.KeyEvent;

class SnakeWordTest {
	

	SnakeWorld w1 =  new SnakeWorld(new Snake (new Posn (180, 210), new Posn (250, 180)), new Posn (-10, 0), 12);
	SnakeWorld w2 = new SnakeWorld(new Snake (new Posn (170, 205), new Posn (190, 220)), new Posn (0, 10), 20);
	//SnakeWorld w3 = new SnakeWorld(new Posn (280, 190), new Posn(300, 200));
	//SnakeWorld w4 = new SnakeWorld(new Posn (300, 190), new Posn(300, 200));

	//SnakeWorld w1 = new SnakeWorld(new Posn (160, 190), new Posn(300, 200));
	//SnakeWorld w2 = new SnakeWorld(new Posn (180, 190), new Posn(300, 200));
	SnakeWorld w3 = new SnakeWorld(new Snake(new Posn (20, 10), new Posn (10, 0)), new Posn(5, 10), 5);
	SnakeWorld w4 = new SnakeWorld(new Snake(new Posn (40, 20), new Posn (0, -10)), new Posn(10, 15), 10);
	SnakeWorld w5 = new SnakeWorld(new Snake(new Posn (50, 30), new Posn (-10, 0)), new Posn(20, 10), 8);
	SnakeWorld w6 = new SnakeWorld(new Snake(new Posn (40, 10), new Posn (0, 10)), new Posn(10, 30), 15);
			//new SnakeWorld(new Posn (280, 190), new Posn(300, 200));
	 
	//new SnakeWorld(new Posn (300, 190), new Posn(300, 200));

	




	
	
	@Test
	void testKeyPressed() {

		assertEquals( new SnakeWorld(new Snake (new Posn (180, 210), new Posn (10, 0)), new Posn (-10, 0), 12), w1.keyPressed(new KeyEvent(null, 0, 0, 0, '\0', PApplet.RIGHT)));
		assertEquals( new SnakeWorld(new Snake (new Posn (170, 205), new Posn (-10, 0)), new Posn (0, 10), 20), w2.keyPressed(new KeyEvent(null, 0, 0, 0, '\0', PApplet.LEFT)));


		assertEquals(  new SnakeWorld(new Snake(new Posn (20, 10), new Posn (10, 0)), new Posn(5, 10), 5), w3.keyPressed(new KeyEvent(null, 0, 0, 0, '\0', PApplet.RIGHT)));
		assertEquals(  new SnakeWorld(new Snake(new Posn (40, 20), new Posn (-10, 0)), new Posn(10, 15), 10), w4.keyPressed(new KeyEvent(null, 0, 0, 0, '\0', PApplet.LEFT)));
		assertEquals(  new SnakeWorld(new Snake(new Posn (50, 30), new Posn (0, 10)), new Posn(20, 10), 8), w5.keyPressed(new KeyEvent(null, 0, 0, 0, '\0', PApplet.DOWN)));
		assertEquals(  new SnakeWorld(new Snake(new Posn (40, 10), new Posn (0, -10)), new Posn(10, 30), 15), w6.keyPressed(new KeyEvent(null, 0, 0, 0, '\0', PApplet.UP)));

	}
	@Test
	void testchangeDir() {
		assertEquals(new Snake(new Posn (20, 10), new Posn (10, 0)), w3.snake.changeDir(new Posn(10, 0)));
		assertEquals(new Snake(new Posn (40, 20), new Posn (0, -10)), w4.snake.changeDir(new Posn(0, -10)));
		assertEquals(new Snake(new Posn (50, 30), new Posn (-10, 0)), w5.snake.changeDir(new Posn(-10, 0)));
		assertEquals(new Snake(new Posn (40, 10), new Posn (0, 10)), w6.snake.changeDir(new Posn(0, 10)));
	}

	@Test
	void testate() {
		assertEquals(false, w1.snake.ate(new Posn (45, 90)));
		assertEquals(true, w2.snake.ate(new Posn (170, 205)));
		assertEquals(true, w3.snake.ate(new Posn (20, 10)));
		assertEquals(false, w4.snake.ate(new Posn (50, 20)));
		assertEquals(true, w5.snake.ate(new Posn (50, 30)));
		assertEquals(false, w6.snake.ate(new Posn (10, 40)));
	}
	
	
}
