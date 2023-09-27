package br.edu.unifalmg.services;

import br.edu.unifalmg.description.DuplicatedChoreException;
import br.edu.unifalmg.description.InvalidDeadlineException;
import br.edu.unifalmg.description.InvalidDescriptionException;
import br.edu.unifalmg.domain.Chore;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ChoreServices {
    private List<Chore> chores;

    public ChoreServices(){
        chores = new ArrayList<>();
    }
    public Chore addChore(String description, LocalDate deadline){
        if(description == null || description.isEmpty()){
            throw new InvalidDescriptionException("the description cannot be null or empty");
        }
        if(deadline == null || deadline.isBefore(LocalDate.now())){
            throw new InvalidDeadlineException("The deadlinecannot be null or before the current");
        }
        for(Chore chore : chores){
            if(chore.getDescription().equals(description) && chore.getDeadline().isEqual(deadline)){
                throw new DuplicatedChoreException("The given chore already exist");
            }
        }
        Chore chore = new Chore();
        chore.setDescription(description);
        chore.setDeadline(deadline);
        chore.setCompleted(Boolean.FALSE);
        chores.add(chore);
        return chore;
    }
}