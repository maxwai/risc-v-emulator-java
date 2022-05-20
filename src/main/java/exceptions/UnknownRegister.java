package exceptions;

public class UnknownRegister extends RuntimeException {
	public UnknownRegister(int index) {
		super("Don't know following register index: " + index);
	}
}
