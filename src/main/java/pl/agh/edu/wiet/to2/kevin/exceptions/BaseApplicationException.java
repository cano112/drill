package pl.agh.edu.wiet.to2.kevin.exceptions;

import javafx.scene.control.Alert;

public abstract class BaseApplicationException extends RuntimeException {
    private final Alert.AlertType alertType;

    public BaseApplicationException(Alert.AlertType alertType) {
        this.alertType = alertType;
    }

    public BaseApplicationException(String message, Alert.AlertType alertType) {
        super(message);
        this.alertType = alertType;
    }

    public BaseApplicationException(String message, Throwable cause, Alert.AlertType alertType) {
        super(message, cause);
        this.alertType = alertType;
    }

    public BaseApplicationException(Throwable cause, Alert.AlertType alertType) {
        super(cause);
        this.alertType = alertType;
    }

    public BaseApplicationException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace, Alert.AlertType alertType) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.alertType = alertType;
    }

    public Alert.AlertType getAlertType() {
        return alertType;
    }
}
