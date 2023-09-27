package br.edu.unifalmg.description;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidDescriptionException extends RuntimeException{

    public InvalidDescriptionException(String message){
        super(message);
    }
}
