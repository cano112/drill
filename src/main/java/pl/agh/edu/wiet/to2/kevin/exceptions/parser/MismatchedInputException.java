package pl.agh.edu.wiet.to2.kevin.exceptions.parser;

public class MismatchedInputException extends ParseException {
    public MismatchedInputException() {
    }

    public MismatchedInputException(String message) {
        super(message);
    }

    public MismatchedInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public MismatchedInputException(Throwable cause) {
        super(cause);
    }

    public MismatchedInputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
