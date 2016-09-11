package keymanager;

import processing.core.PApplet;
import processing.event.KeyEvent;

public class KeyManager {
	
	private static KeyManager me;

	public KeyManager(PApplet sketch){
		if(me != null){
			throw new RuntimeException("Error: there can only be one KeyManager.");
		}
		me = this;
		sketch.registerMethod("keyEvent", this);
	}

	/**
	 * Called when a key event occurs.
	 * 
	 * @param e
	 */
	public void keyEvent(KeyEvent e){
		switch(e.getAction()){
		case KeyEvent.PRESS:	keyPressed(e);	break;
		case KeyEvent.RELEASE:	keyReleased(e);	break;
		}
	}

	/**
	 * Called when a key is pressed.
	 * 
	 * @param e
	 */
	private void keyPressed(KeyEvent e){
		for(Key key : Key.keys){
			key.update(e.getKeyCode(), true);
		}
	}

	/**
	 * Called when a key is released.
	 * 
	 * @param e
	 */
	private void keyReleased(KeyEvent e){
		for(Key key : Key.keys){
			key.update(e.getKeyCode(), false);
		}
	}
}
