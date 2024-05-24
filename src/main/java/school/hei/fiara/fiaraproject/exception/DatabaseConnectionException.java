package school.hei.fiara.fiaraproject.exception;

public class DatabaseConnectionException extends RuntimeException {
    public DatabaseConnectionException(String message) {
        super((message));
    }
}
