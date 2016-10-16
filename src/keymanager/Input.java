package keymanager;

import java.util.ArrayList;
import java.util.List;

public class Input {

	static final List<Input> keyBoardKeys = new ArrayList<Input>();
	static final List<Input> mouseButtons = new ArrayList<Input>();

	private InputType type;
	private boolean isPressed;
	private int inputCode;
	private Runnable pressedEvent;
	private Runnable releasedEvent;
	
	/**
	 * Create an input.
	 */
	public Input() {
		this(null);
	}
	
	/**
	 * Create an input.
	 */
	public Input(InputType type) {
		this(type, 0);
	}

	/**
	 * Create an input.
	 * 
	 * @param buttonCode - The code for the input
	 */
	public Input(InputType type, int buttonCode) {
		this.isPressed = false;
		this.inputCode = buttonCode;
		this.setType(type);
	}

	/**
	 * Returns true if the input is pressed down, otherwise false.
	 * 
	 * @return
	 */
	public boolean isPressed() {
		return this.isPressed;
	}

	/**
	 * @return the type
	 */
	public InputType getType() {
		return type;
	}

	/**
	 * Get the input code
	 * 
	 * @return
	 */
	public int getInputCode() {
		return inputCode;
	}

	/**
	 * @param type
	 */
	public void setType(InputType type) {
		if (this.type != null) {
			remove();
		}
		
		this.type = type;
		
		if (this.type == null) {
			return;
		}
		
		switch (type) {
		case KeyBoardKey:
			keyBoardKeys.add(this);
			break;
		case MouseButton:
			mouseButtons.add(this);
			break;
		default:
			break;
		
		}
	}

	/**
	 * Set the input code
	 * 
	 * @param
	 */
	public void setInputCode(int inputCode) {
		this.inputCode = inputCode;
	}

	/**
	 * Set the type and input code for this input.
	 * 
	 * @param type
	 * @param inputCode
	 */
	public void setInput(InputType type, int inputCode) {
		setType(type);
		setInputCode(inputCode);
	}

	/**
	 * Set the action that will happen when the input is pressed.
	 * 
	 * @param event
	 */
	public void setPressedEvent(Runnable event) {
		this.pressedEvent = event;
	}

	/**
	 * Set the action that will happen when the input is released.
	 * 
	 * @param event
	 */
	public void setReleasedEvent(Runnable event) {
		this.releasedEvent = event;
	}

	/**
	 * Remove this input.
	 */
	public void remove() {
		switch (type) {
		case KeyBoardKey:
			keyBoardKeys.remove(this);
			break;
		case MouseButton:
			mouseButtons.remove(this);
			break;
		default:
			break;
		
		}
	}

	/**
	 * Remove the pressed event.
	 */
	public void removePressedEvent() {
		this.pressedEvent = null;
	}

	/**
	 * remove the released event
	 */
	public void removeReleasedEvent() {
		this.releasedEvent = null;
	}

	/**
	 * Update the input's pressed state.
	 * Call the pressed and released events if need.
	 * 
	 * @param inputCode
	 * @param pressed
	 */
	void update(int inputCode, boolean pressed) {
		if (this.inputCode == inputCode) {
			if (this.pressedEvent != null && pressed && !this.isPressed) {
				this.pressedEvent.run();
			}
			if (this.releasedEvent != null && !pressed && this.isPressed) {
				this.releasedEvent.run();
			}

			this.isPressed = pressed;
		}
	}
}
