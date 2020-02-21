package pe.financieraoh.apiseguro.exception;

public class PolizaCancelException extends RuntimeException {

	private static final long serialVersionUID = 6888330187916006720L;

	public PolizaCancelException() {
		super();
		
	}

	public PolizaCancelException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public PolizaCancelException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public PolizaCancelException(String message) {
		super(message);
		
	}

	public PolizaCancelException(Throwable cause) {
		super(cause);
		
	}
	
	

}
