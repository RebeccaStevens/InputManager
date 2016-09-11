package keymanager;

import java.util.ArrayList;
import java.util.List;

public class Key {

	static final List<Key> keys = new ArrayList<Key>();
	
	private boolean isPressed;
	private int keyCode;
	private Runnable pressedEvent;
	private Runnable releasedEvent;

	/**
	 * Create a key.
	 */
	public Key(){
		this(0);
	}

	/**
	 * Create a key.
	 * 
	 * @param keyCode - The code for the key
	 */
	public Key(int keyCode){
		this(keyCode, null, null);
	}
	
	/**
	 * Create a key.
	 * 
	 * @param keyCode - The code for the key
	 * @param pressedEvent - The action to run when the key is pressed
	 */
	public Key(int keyCode, Runnable pressedEvent){
		this(keyCode, pressedEvent, null);
	}

	/**
	 * Create a key.
	 * 
	 * @param keyCode - The code for the key
	 * @param pressedEvent - The action to run when the key is pressed
	 * @param releasedEvent - The action to run when the key is released
	 */
	public Key(int keyCode, Runnable pressedEvent, Runnable releasedEvent){
		this.isPressed = false;
		this.keyCode = keyCode;
		this.pressedEvent = pressedEvent;
		this.releasedEvent = releasedEvent;
		keys.add(this);
	}

	/**
	 * Returns true if the key is pressed down, otherwise false.
	 * 
	 * @return
	 */
	public boolean isPressed(){
		return this.isPressed;
	}

	/**
	 * Get the key's key code
	 * 
	 * @return
	 */
	public int getKeyCode() {
		return keyCode;
	}

	/**
	 * Set the key's key code
	 * 
	 * @param
	 */
	public void setKeyCode(int keyCode) {
		this.keyCode = keyCode;
	}

	/**
	 * Set the action that will happen when the key is pressed.
	 * 
	 * @param event
	 */
	public void setPressedEvent(Runnable event){
		this.pressedEvent = event;
	}

	/**
	 * Set the action that will happen when the key is released.
	 * 
	 * @param event
	 */
	public void setReleasedEvent(Runnable event){
		this.releasedEvent = event;
	}

	/**
	 * Remove the pressed event.
	 */
	public void removePressedEvent(){
		this.pressedEvent = null;
	}

	/**
	 * remove the released event
	 */
	public void removeReleasedEvent(){
		this.releasedEvent = null;
	}

	/**
	 * Update the key's pressed state.
	 * Call the pressed and released events if need.
	 * 
	 * @param keyCode
	 * @param pressed
	 */
	void update(int keyCode, boolean pressed){
		if (this.keyCode == keyCode) {
			if(this.pressedEvent != null && pressed && !this.isPressed){
				this.pressedEvent.run();
			}
			if(this.releasedEvent != null && !pressed && this.isPressed){
				this.releasedEvent.run();
			}

			this.isPressed = pressed;
		}
	}
}
