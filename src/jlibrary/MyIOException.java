package jlibrary;

import java.io.IOException;


public class MyIOException extends IOException {

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = -4485933467358737598L;

	@Override
	public String toString() {
		return "This went totally wrong... " + super.toString();
	}
}
