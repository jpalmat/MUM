package lesson10.labsolns.prob5;

@SuppressWarnings("serial")
public class InputTooLongRuntimeException extends RuntimeException {
	public InputTooLongRuntimeException() {
		super();
	}
	public InputTooLongRuntimeException(String msg) {
		super(msg);
	}
	public InputTooLongRuntimeException(Throwable t) {
		super(t);
	}
}
