package pl.github.kathelan.bizoncup.exceptions;

public class JsonProcessingRuntimeException extends RuntimeException {
    public JsonProcessingRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}