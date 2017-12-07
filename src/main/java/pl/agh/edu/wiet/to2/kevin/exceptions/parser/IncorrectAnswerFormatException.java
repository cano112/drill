package pl.agh.edu.wiet.to2.kevin.exceptions.parser;

public class IncorrectAnswerFormatException extends ParseException {
    public IncorrectAnswerFormatException() {
    }

    public IncorrectAnswerFormatException(String message) {
        super(message);
    }

    public IncorrectAnswerFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectAnswerFormatException(Throwable cause) {
        super(cause);
    }

    public IncorrectAnswerFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
