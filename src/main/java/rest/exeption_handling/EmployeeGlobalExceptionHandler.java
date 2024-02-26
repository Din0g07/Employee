package rest.exeption_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeGlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handleException(
            EmployeeNotFoundException exp) {
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exp.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handleException(
            Exception exp) {
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exp.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
}
