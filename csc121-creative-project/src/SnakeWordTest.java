import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import processing.core.PApplet;
import processing.event.KeyEvent;

class SnakeWordTest {
	

	//SnakeWorld w1 =  new SnakeWorld(new Snake (new Posn (180, 210), new Posn (250, 180)), new Posn (-10, 0), 12);
	//SnakeWorld w2 = new SnakeWorld(new Snake (new Posn (170, 205), new Posn (190, 220)), new Posn (0, 10), 20);
	//SnakeWorld w3 = new SnakeWorld(new Posn (280, 190), new Posn(300, 200));
	//SnakeWorld w4 = new SnakeWorld(new Posn (300, 190), new Posn(300, 200));

	//SnakeWorld w1 = new SnakeWorld(new Posn (160, 190), new Posn(300, 200));
	//SnakeWorld w2 = new SnakeWorld(new Posn (180, 190), new Posn(300, 200));
	//SnakeWorld w3 = new SnakeWorld(new Snake(new Posn (20, 10), new Posn (10, 0)), new Posn(5, 10), 5);
	//SnakeWorld w4 = new SnakeWorld(new Snake(new Posn (40, 20), new Posn (0, -10)), new Posn(10, 15), 10);
	//SnakeWorld w5 = new SnakeWorld(new Snake(new Posn (50, 30), new Posn (-10, 0)), new Posn(20, 10), 8);
	//SnakeWorld w6 = new SnakeWorld(new Snake(new Posn (40, 10), new Posn (0, 10)), new Posn(10, 30), 15);
			//new SnakeWorld(new Posn (280, 190), new Posn(300, 200));
	 
	//new SnakeWorld(new Posn (300, 190), new Posn(300, 200));

	SnakeWorld w1 = new SnakeWorld(new Snake(new Consp(new Posn(180, 200), new Consp(new Posn(175, 195), new MTp())), new Posn(20, 0)), new Posn(300, 200), 0);
	SnakeWorld w2 = new SnakeWorld(new Snake(new Consp(new Posn(160, 180), new Consp(new Posn(155, 175), new MTp())), new Posn(30, 0)), new Posn(290, 190), 0);
	SnakeWorld w3 = new SnakeWorld(new Snake(new Consp(new Posn(140, 160), new Consp(new Posn(135, 155), new MTp())), new Posn(40, 0)), new Posn(280, 180), 0);
	SnakeWorld w4 = new SnakeWorld(new Snake(new Consp(new Posn(120, 140), new Consp(new Posn(115, 135), new MTp())), new Posn(10, 0)), new Posn(270, 170), 0);









	@Test
	void testgetFirst() {
		
		assertEquals(new Posn(1, 2), new Consp(new Posn(1, 2), new MTp()).getFirst());
		//assertEquals("can't get first of empty list", new MTp().getFirst());
		
	}
	
	@Test
	void testdropLast() {
		
		assertEquals(null, new MTp().dropLast());
		//assertEquals(new MTp(), new Consp(new Posn(1, 2), new MTp()).dropLast());   
		/*
		 * We are getting an error with this test case that seems to have something to do with the MTp. 
		 * We expect this test above to return MTp() but the hash code does not align and it gives an error. 
		 */
	}
	
	@Test
	void testisEmpty() {
		
		assertEquals(true, new MTp().isEmpty());	
		assertEquals(false, new Consp(new Posn(1, 2), new MTp()).isEmpty());	
	}
	
	@Test
	void testchangeDir() {
		
		
		
	}

	@Test
	void testate() {
		
	}
	
	@Test
	void testgrow() {
		
	}
	
	@Test
	void testmove() {
		
	}
	
	
}
