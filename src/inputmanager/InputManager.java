package inputmanager;

import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

public class InputManager {
	
	private static InputManager me;

	public InputManager(PApplet sketch){
		if(me != null){
			throw new RuntimeException("Error: there can only be one " + getClass().getSimpleName() + ".");
		}
		me = this;
		sketch.registerMethod("keyEvent", this);
		sketch.registerMethod("mouseEvent", this);
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
		for(Input key : Input.keyBoardKeys){
			key.update(e.getKeyCode(), true);
		}
	}

	/**
	 * Called when a key is released.
	 * 
	 * @param e
	 */
	private void keyReleased(KeyEvent e){
		for(Input key : Input.keyBoardKeys){
			key.update(e.getKeyCode(), false);
		}
	}

	/**
	 * Called when a mouse event occurs.
	 * 
	 * @param e
	 */
	public void mouseEvent(MouseEvent e){
		switch(e.getAction()){
		case KeyEvent.PRESS:	mouseButtonPressed(e);	break;
		case KeyEvent.RELEASE:	mouseButtonReleased(e);	break;
		}
	}

	/**
	 * Called when a mouse button is pressed.
	 * 
	 * @param e
	 */
	private void mouseButtonPressed(MouseEvent e){
		for(Input button : Input.mouseButtons){
			button.update(e.getButton(), true);
		}
	}

	/**
	 * Called when a mouse button is released.
	 * 
	 * @param e
	 */
	private void mouseButtonReleased(MouseEvent e){
		for(Input button : Input.mouseButtons){
			button.update(e.getButton(), false);
		}
	}
}
