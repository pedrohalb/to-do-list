package br.edu.unifalmg.description;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DuplicatedChoreException extends RuntimeException{

    public DuplicatedChoreException(String message){
        super(message);
    }
}
