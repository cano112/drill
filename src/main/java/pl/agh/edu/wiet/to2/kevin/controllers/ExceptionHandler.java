package pl.agh.edu.wiet.to2.kevin.controllers;

import javafx.scene.control.Alert;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import pl.agh.edu.wiet.to2.kevin.exceptions.BaseApplicationException;

import java.lang.reflect.InvocationTargetException;

@Controller @Qualifier("exceptionHandler") public class ExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override public void uncaughtException(Thread t, Throwable e) {

        if (e instanceof RuntimeException) {
            InvocationTargetException ex = (InvocationTargetException) e.getCause();
            if (ex.getTargetException() instanceof BaseApplicationException) {
                BaseApplicationException appEx = (BaseApplicationException) ex.getTargetException();
                handleAppException(appEx);
            } else {
                handleRuntimeException((RuntimeException) e);
            }
        } else {
            handleThrowable(e);
        }
    }

    private void handleAppException(BaseApplicationException e) {
        showAlert(e.getAlertType(), e.getMessage());
    }

    private void handleRuntimeException(RuntimeException e) {
        showAlert(Alert.AlertType.ERROR, e.getMessage());
    }

    private void handleThrowable(Throwable e) {
        showAlert(Alert.AlertType.ERROR, e.getMessage());
    }

    private void showAlert(Alert.AlertType type, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(type.toString().toUpperCase());
        alert.setContentText(message);
        alert.showAndWait();
    }
}
