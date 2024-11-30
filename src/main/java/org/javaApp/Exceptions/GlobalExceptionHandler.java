package org.javaApp.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.javaApp.Model.ErrorResponse;
import org.javaApp.Exceptions.ErrorMessages;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleProductNotFoundException(ProductNotFoundException exception){
        System.out.println(exception.getMessage());
        return new ErrorResponse(exception.getMessage());
        }

    @ExceptionHandler(ProductNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleProductNotValidException(ProductNotValidException exception){
        System.out.println(exception.getMessage());
        return new ErrorResponse(exception.getMessage());
    }
}




//
//
//The @ControllerAdvice annotation was first introduced in Spring 3.2.
//It allows you to handle exceptions across the whole application,
//not just to an individual controller.
//You can think of it as an interceptor of exceptions
//thrown by methods annotated with @RequestMapping or one of the shortcuts.
/*

@RestController
@RequestMapping("/users/{username}/posts")
public class PostController {


    @PostMapping
    public ResponseEntity<Post> create(@PathVariable String username, @RequestBody Post post)
            throws ContentNotAllowedException {
        List<ObjectError> contentNotAllowedErrors = ContentUtils.getContentErrorsFrom(post);

        if (!contentNotAllowedErrors.isEmpty()) {
            throw ContentNotAllowedException.createWith(contentNotAllowedErrors);
        }

        // More logic on Post

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ExceptionHandler(ContentNotAllowedException.class)
    public ResponseEntity<ApiError> handleContentNotAllowedException(ContentNotAllowedException cnae) {
        List<String> errorMessages = cnae.getErrors()
                .stream()
                .map(contentError -> contentError.getObjectName() + " " + contentError.getDefaultMessage())
                .collect(Collectors.toList());

        return new ResponseEntity<>(new ApiError(errorMessages), HttpStatus.BAD_REQUEST);
    }
}

ratner than doing this, we can have a global one and intercept all rest call thrown excetpion is the idea
 */