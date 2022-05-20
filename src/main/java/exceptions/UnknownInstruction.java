package exceptions;

public class UnknownInstruction extends RuntimeException {
	public UnknownInstruction(String bitMap) {
		super("Don't know following instruction: " + bitMap);
	}
}
