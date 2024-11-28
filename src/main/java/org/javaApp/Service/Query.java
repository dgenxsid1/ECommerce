package org.javaApp.Service;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;

public interface Query <I,O>{
    ResponseEntity<O> execute(I input);
}
