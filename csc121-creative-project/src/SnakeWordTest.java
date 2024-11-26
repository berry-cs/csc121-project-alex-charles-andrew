import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import processing.core.PApplet;
import processing.event.KeyEvent;

class SnakeWordTest {

	SnakeWorld w1 = new SnakeWorld(new Snake(new Consp(new Posn(180, 200), new Consp(new Posn(175, 195), new MTp())), new Posn(20, 0)), new Posn(300, 200), 0, 0);
	SnakeWorld w2 = new SnakeWorld(new Snake(new Consp(new Posn(160, 180), new Consp(new Posn(155, 175), new MTp())), new Posn(30, 0)), new Posn(290, 190), 0, 0);
	SnakeWorld w3 = new SnakeWorld(new Snake(new Consp(new Posn(140, 160), new Consp(new Posn(135, 155), new MTp())), new Posn(40, 0)), new Posn(280, 180), 0, 0);
	SnakeWorld w4 = new SnakeWorld(new Snake(new Consp(new Posn(120, 140), new Consp(new Posn(115, 135), new MTp())), new Posn(10, 0)), new Posn(270, 170), 0, 0);

	ILoP L1 = new Consp (new Posn(1, 2), new MTp());
	ILoP L2 = new MTp();
	ILoP L3 = new Consp (new Posn(21, 2), L1);
	ILoP L4 = new Consp (new Posn(41, 2), L3);
	
	Snake S1 = new Snake(L1, new Posn(20,0));
	Snake S2 = new Snake(L2, new Posn(-20,0));
	Snake S3 = new Snake(L3, new Posn(0,20));
	Snake S4 = new Snake(L4, new Posn(0,-20));


	@Test
	void testgetFirst() {
		
		assertEquals(new Posn(1, 2), L1.getFirst());
		assertEquals(new Posn(21, 2), L3.getFirst());
		assertEquals(new Posn(41, 2), L4.getFirst());
	}
	
	
	@Test
	void testdropLast() {
		
		assertEquals(new MTp(), L1.dropLast());
		assertEquals(null, L2.dropLast());
		assertEquals(new Consp (new Posn(21, 2), new MTp()), L3.dropLast());
		assertEquals(new Consp(new Posn(41, 2), new Consp( new Posn(21, 2), new MTp())), L4.dropLast());
	}
	
	@Test
	void testisEmpty() {
		
		assertEquals(true, new MTp().isEmpty());	
		assertEquals(false, L1.isEmpty());	
		assertEquals(false, L4.isEmpty());	
	}
	
	@Test
	void testchangeDir() {
		
		assertEquals(new Snake(L1, new Posn(0,20)), S1.changeDir(new Posn(0,20)));
		assertEquals(new Snake(L2, new Posn(0,-20)), S2.changeDir(new Posn(0,-20)));
		assertEquals(new Snake(L3, new Posn(20, 0)), S3.changeDir(new Posn(20, 0)));
		
	}

	@Test
	void testate() {
		
		assertEquals(false , S1.ate(new Posn (20, 15)));
		assertEquals(true , S3.ate(new Posn (21, 2)));
		assertEquals(true , S4.ate(new Posn (41, 2)));

	}
	
	@Test
	void testgrow() {
		
	assertEquals(new Snake(L3, new Posn(20,0)), S1.grow());
	assertEquals(new Snake(new Consp (new Posn(21, 22), L3), new Posn(0,20)), S3.grow());

	}
	
	@Test
	void testmove() {
	
		assertEquals( new Snake(new Consp (new Posn(1, 2), new MTp()), new Posn(20,0)), S1.move());
	
	}
	
	
}
