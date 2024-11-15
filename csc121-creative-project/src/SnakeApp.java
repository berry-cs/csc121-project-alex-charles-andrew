import processing.core.*;
import java.util.Scanner;
import java.io.*;
import processing.event.*;

/**
 * Provides the scaffolding to launch a Processing application
 */
public class SnakeApp extends PApplet {	// <----- 1. rename AppTemplate everywhere in this file
    IWorld w;
    
    public static final Posn StartingPosnHead = new Posn(180, 200);
    public static final Posn StartingPosnBody = new Posn(160, 200);
    public static final Posn StartingDir = new Posn(20, 0);
    public static final Posn StartingPosnApple = new Posn(300, 200);
    public static final int StartingClock = 0;
    public static final int StartingScore = 0;
    public static final int Width = 400;
    public static final int Height = 400;
    
    public static final IWorld StartSnakeWorld = new SnakeWorld(new Snake(new Consp(StartingPosnHead, new Consp(StartingPosnBody, new MTp())), StartingDir), StartingPosnApple, StartingClock, StartingScore);
    
    
    public void settings() {
        this.size(Width, Height);
    }
    
    public void setup() {
        //w = new WORLD(..........)   	<----- 2. create your initial world object
    	w = StartSnakeWorld;
    }
    
    public void draw() {
        w = w.update();
        w.draw(this);
    }
    
    @Override
    public void mousePressed(MouseEvent mev) {
        w = w.mousePressed(mev);
    }
    
    @Override
   public void mouseReleased(MouseEvent mev) {
    	w = w.mouseReleased(mev);
    }

    @Override
   public void mouseMoved(MouseEvent mev) {
    	w = w.mouseMoved(mev);
    }
    
    @Override
    public void mouseDragged(MouseEvent mev) {
    	w = w.mouseDragged(mev);
    }
    
    @Override
    public void mouseClicked(MouseEvent mev) {
    	w = w.mouseClicked(mev);
    }

    @Override
    public void mouseEntered(MouseEvent mev) {
    	w = w.mouseEntered(mev);
    }

    @Override
    public void mouseExited(MouseEvent mev) {
    	w = w.mouseExited(mev);
    }
    
    @Override
    public void mouseWheel(MouseEvent mev) {
    	w = w.mouseWheel(mev);
    }

    @Override
    public void keyPressed(KeyEvent kev) {
        w = w.keyPressed(kev);
    }

    @Override
    public void keyReleased(KeyEvent kev) {
        w = w.keyReleased(kev);
    }
    
    @Override
    public void keyTyped(KeyEvent kev) {
        w = w.keyTyped(kev);
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[] { SnakeApp.class.getName() }, new SnakeApp());
        
    }
    
    
    	
}
