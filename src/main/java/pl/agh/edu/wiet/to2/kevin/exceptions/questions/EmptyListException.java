package pl.agh.edu.wiet.to2.kevin.exceptions.questions;

import javafx.scene.control.Alert;
import pl.agh.edu.wiet.to2.kevin.exceptions.BaseApplicationException;

public final class EmptyListException extends BaseApplicationException {

    private final static Alert.AlertType ALERT_TYPE = Alert.AlertType.WARNING;

    public EmptyListException() {
        super(ALERT_TYPE);
    }

    public EmptyListException(String message) {
        super(message, ALERT_TYPE);
    }

    public EmptyListException(String message, Throwable cause) {
        super(message, cause, ALERT_TYPE);
    }

    public EmptyListException(Throwable cause) {
        super(cause, ALERT_TYPE);
    }

    public EmptyListException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace, ALERT_TYPE);
    }
}
