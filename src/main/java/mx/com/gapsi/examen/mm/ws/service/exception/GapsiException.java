package mx.com.gapsi.examen.mm.ws.service.exception;

public class GapsiException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String errorMessage;

	public GapsiException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
