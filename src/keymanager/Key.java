package keymanager;

public class Key extends Input {

	/**
	 * Create a key.
	 */
	public Key() {
		this(0);
	}

	/**
	 * Create a key.
	 * 
	 * @param code - The code for the mouse button
	 */
	public Key(int code) {
		super(InputType.KeyBoardKey, code);
	}
}
