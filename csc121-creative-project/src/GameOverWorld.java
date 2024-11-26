import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

import processing.core.PApplet;
import processing.event.KeyEvent;

public class GameOverWorld implements IWorld {
	private SnakeWorld sw;
	private int highScore;
	private String highScoreName;

	GameOverWorld(SnakeWorld sw) {
		this.sw = sw;
		
		String name = JOptionPane.showInputDialog("Your name: ");
		
		try {
    		Scanner sc = new Scanner(new File("scores.txt"));
    		if (sc.hasNextInt()) {
    			this.highScore = sc.nextInt();
    			this.highScoreName = sc.nextLine().trim();
    		}
    		sc.close();
		
			if (this.sw.score > this.highScore) {
				this.highScore = this.sw.score;
				this.highScoreName = name;
				PrintWriter pw = new PrintWriter(new File("scores.txt"));
				pw.println(this.highScore + " " + name);
				pw.close();
			}
        } catch (IOException e) {
			//System.out.println("Error, file not found " + e);
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}

		
	}
	
	public PApplet draw(PApplet c) {
		this.sw.draw(c);
		
		c.fill(0, 0, 0);
		c.textSize(50);
		c.textAlign(PApplet.CENTER, PApplet.CENTER);
		c.text("Game Over!", c.width / 2, c.height / 2 - 50);
		
		c.textSize(40);
		c.text("Your Score: " + this.sw.score, c.width / 2, c.height / 2);
		c.text("High Score: " + this.highScore + " (" + this.highScoreName + ")", c.width / 2, c.height / 2 + 50);
		
		return c;
	}
	
	public IWorld keyPressed(KeyEvent kev) {
		if (kev.getKey() == ' ') {
			return SnakeApp.StartSnakeWorld;
		} else {
			return this;
		}
	}
	
}
