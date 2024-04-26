package encora.challenger.api.mscustomerproducts.infraestructure.rest.advice;

import encora.challenger.api.mscustomerproducts.infraestructure.adapters.exception.CustomerProductException;
import encora.challenger.api.mscustomerproducts.infraestructure.adapters.exception.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomerProductControllerAdvice {
  @ExceptionHandler(CustomerProductException.class)
  public ResponseEntity<ErrorResponse> handleAccountTransactionException(CustomerProductException ex) {
    ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode().toString(), ex.getErrorMessage());
    return new ResponseEntity<>(errorResponse, ex.getErrorCode());
  }
}
