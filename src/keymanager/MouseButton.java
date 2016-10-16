package keymanager;

public class MouseButton extends Input {

	/**
	 * Create a mouse button.
	 */
	public MouseButton() {
		this(0);
	}

	/**
	 * Create a mouse button.
	 * 
	 * @param button - The code for the mouse button
	 */
	public MouseButton(int button) {
		super(InputType.MouseButton, button);
	}
}
