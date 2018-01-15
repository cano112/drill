package pl.agh.edu.wiet.to2.kevin.exceptions;

import javafx.scene.control.Alert;

public final class IncoherentStateException extends BaseApplicationException {

    private final static Alert.AlertType ALERT_TYPE = Alert.AlertType.ERROR;

    public IncoherentStateException() {
        super(ALERT_TYPE);
    }

    public IncoherentStateException(String message) {
        super(message, ALERT_TYPE);
    }

    public IncoherentStateException(String message, Throwable cause) {
        super(message, cause, ALERT_TYPE);
    }

    public IncoherentStateException(Throwable cause) {
        super(cause, ALERT_TYPE);
    }

    public IncoherentStateException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace, ALERT_TYPE);
    }
}
