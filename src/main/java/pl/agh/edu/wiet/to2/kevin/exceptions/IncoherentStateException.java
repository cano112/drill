package pl.agh.edu.wiet.to2.kevin.exceptions;

public class IncoherentStateException extends RuntimeException {

    public IncoherentStateException() {
    }

    public IncoherentStateException(String message) {
        super(message);
    }

    public IncoherentStateException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncoherentStateException(Throwable cause) {
        super(cause);
    }

    public IncoherentStateException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
