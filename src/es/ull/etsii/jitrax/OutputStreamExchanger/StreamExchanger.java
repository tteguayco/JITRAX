package es.ull.etsii.jitrax.OutputStreamExchanger;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Redirect messages from System.out to a custom stream.
 * Useful for treat the information as a string, for example.
 */
public class StreamExchanger {

	private PrintStream oldStream;
	private PrintStream newStream;
	private ByteArrayOutputStream byteArrayOutputStream;
	
	public StreamExchanger(PrintStream streamToReplace) {
		byteArrayOutputStream = new ByteArrayOutputStream();
		oldStream = streamToReplace;
		newStream = new PrintStream(byteArrayOutputStream);
	}
	
	/**
	 * Sets the newStream as the new output stream.
	 */
	public void redirectOutputStream() {
		System.setErr(newStream);
	}
	
	/**
	 * Restores System.out as the output stream.
	 */
	public void restoreOutputStream() {
		// Clear the System.out stream
		System.out.flush();
		System.setErr(oldStream);
	}
	
	
	
	/**
	 * Returns the information saved in the newStream as a string.
	 * @return
	 */
	public String getSavedString() {
		return byteArrayOutputStream.toString();
	}
}
