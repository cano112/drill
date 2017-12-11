package pl.agh.edu.wiet.to2.kevin.exceptions.questions;

public class EmptyQuestionListException extends RuntimeException {
    public EmptyQuestionListException() {
    }

    public EmptyQuestionListException(String message) {
        super(message);
    }

    public EmptyQuestionListException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyQuestionListException(Throwable cause) {
        super(cause);
    }

    public EmptyQuestionListException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
