package pl.agh.edu.wiet.to2.kevin.exceptions.parser;

import javafx.scene.control.Alert;

public final class FileNotFoundException extends ParseException {

    private final static Alert.AlertType ALERT_TYPE = Alert.AlertType.WARNING;

    public FileNotFoundException() {
        super(ALERT_TYPE);
    }

    public FileNotFoundException(String message) {
        super(message, ALERT_TYPE);
    }

    public FileNotFoundException(String message, Throwable cause) {
        super(message, cause, ALERT_TYPE);
    }

    public FileNotFoundException(Throwable cause) {
        super(cause, ALERT_TYPE);
    }

    public FileNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace, ALERT_TYPE);
    }
}
