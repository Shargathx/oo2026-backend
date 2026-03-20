package ee.msaareva.veebipood.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> handleException(RuntimeException ex) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage(ex.getMessage());
        errorMessage.setStatus(HttpStatus.BAD_REQUEST.value());
        errorMessage.setTimestamp(new Date());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> handleException(MissingServletRequestParameterException ex) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage("Missing parameter(s): " + ex.getMessage());
        errorMessage.setStatus(HttpStatus.BAD_REQUEST.value());
        errorMessage.setTimestamp(new Date());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }
}
