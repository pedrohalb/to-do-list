package br.edu.unifalmg.description;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidDeadlineException extends RuntimeException{

    public InvalidDeadlineException(String message){
        super(message);
    }
}