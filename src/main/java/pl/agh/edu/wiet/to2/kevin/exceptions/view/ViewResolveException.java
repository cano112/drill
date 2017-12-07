package pl.agh.edu.wiet.to2.kevin.exceptions.view;

public class ViewResolveException extends RuntimeException {
    public ViewResolveException() {
    }

    public ViewResolveException(String message) {
        super(message);
    }

    public ViewResolveException(String message, Throwable cause) {
        super(message, cause);
    }

    public ViewResolveException(Throwable cause) {
        super(cause);
    }

    public ViewResolveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
