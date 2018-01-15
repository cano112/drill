package pl.agh.edu.wiet.to2.kevin.exceptions.parser;

import javafx.scene.control.Alert;
import pl.agh.edu.wiet.to2.kevin.exceptions.BaseApplicationException;

public class ParseException extends BaseApplicationException {
    public ParseException(Alert.AlertType alertType) {
        super(alertType);
    }

    public ParseException(String message, Alert.AlertType alertType) {
        super(message, alertType);
    }

    public ParseException(String message, Throwable cause, Alert.AlertType alertType) {
        super(message, cause, alertType);
    }

    public ParseException(Throwable cause, Alert.AlertType alertType) {
        super(cause, alertType);
    }

    public ParseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace,
            Alert.AlertType alertType) {
        super(message, cause, enableSuppression, writableStackTrace, alertType);
    }
}
