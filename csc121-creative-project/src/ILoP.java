import java.util.Objects;

import processing.core.PApplet;

public interface ILoP {

	PApplet draw(PApplet c);

	Posn getFirst();
	
	// produce a copy of *this* list with the
	//  last posn removed
	ILoP dropLast();
	
	boolean isEmpty();

}


class MTp implements ILoP {
	


	@Override
	public PApplet draw(PApplet c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Posn getFirst() {
		throw new RuntimeException("can't get first of empty list");
	}

	@Override
	public ILoP dropLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		return true;
	}
	
	
	
}


class Consp implements ILoP {
	Posn first;
	ILoP rest;
	
	public Consp(Posn first, ILoP rest) {
		super();
		this.first = first;
		this.rest = rest;
	}

	@Override
	public PApplet draw(PApplet c) {
		c.rectMode(PApplet.CENTER);
		c.rect(this.first.getX(), this.first.getY(), 20, 20);
		rest.draw(c);
		return c;
	}

	@Override
	public Posn getFirst() {
		return this.first;
	}

	public ILoP dropLast() {
		if (rest.isEmpty()) {
			return rest;
		} else {
			return new Consp(first, rest.dropLast());
		}
	}

	public boolean isEmpty() {
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(first, rest);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consp other = (Consp) obj;
		return Objects.equals(first, other.first) && Objects.equals(rest, other.rest);
	}

	@Override
	public String toString() {
		return "Consp [first=" + first + ", rest=" + rest + "]";
	}
	
	
	
}