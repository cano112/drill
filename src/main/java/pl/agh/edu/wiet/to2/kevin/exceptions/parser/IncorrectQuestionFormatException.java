package pl.agh.edu.wiet.to2.kevin.exceptions.parser;

public class IncorrectQuestionFormatException extends ParseException {
    public IncorrectQuestionFormatException() {
    }

    public IncorrectQuestionFormatException(String message) {
        super(message);
    }

    public IncorrectQuestionFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectQuestionFormatException(Throwable cause) {
        super(cause);
    }

    public IncorrectQuestionFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
