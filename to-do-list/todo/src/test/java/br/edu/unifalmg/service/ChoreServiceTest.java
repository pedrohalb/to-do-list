package br.edu.unifalmg.service;

import br.edu.unifalmg.description.DuplicatedChoreException;
import br.edu.unifalmg.description.InvalidDescriptionException;
import br.edu.unifalmg.services.ChoreServices;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import br.edu.unifalmg.description.InvalidDeadlineException;

import java.time.LocalDate;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ChoreServiceTest {
    @Test
    public void addChoreWhenTheDescriptionIsIncvalidThrowAnException(){
        ChoreServices service = new ChoreServices();
        assertAll(
                () -> assertThrows(InvalidDescriptionException.class,
                       () -> service.addChore(null, null)),
                () -> assertThrows(InvalidDescriptionException.class,
                       () -> service.addChore("", null)),
                () -> assertThrows(InvalidDescriptionException.class,
                        () -> service.addChore(null, LocalDate.now().plusDays(1))),
                () -> assertThrows(InvalidDescriptionException.class,
                        () -> service.addChore("", LocalDate.now().plusDays(1))),
                () -> assertThrows(InvalidDescriptionException.class,
                        () -> service.addChore(null, LocalDate.now().minusDays(1))),
                () -> assertThrows(InvalidDescriptionException.class,
                        () -> service.addChore("", LocalDate.now().minusDays(1)))

        );

    }
    @Test
    @DisplayName("#addChore > When the deadline is invalid > Throw an exception")
    public void addChoreWhenTheDeadlineIsIncvalidThrowAnException(){
        ChoreServices service = new ChoreServices();
        assertAll(
                () -> assertThrows(InvalidDeadlineException.class,
                       () -> service.addChore("Description", null)),
                () -> assertThrows(InvalidDeadlineException.class,
                       () -> service.addChore("Description", LocalDate.now().minusDays(1)))
        );

    }

    @Test
    @DisplayName("#addChore > When addind a chore > When the core already exists > Throw an exception")
    public void addChoreWhenAddingAChoreWhenTheChoreAlreadyExistsThrowAnException(){
        ChoreServices service = new ChoreServices();
        service.addChore("Description", LocalDate.now());
        assertThrows(DuplicatedChoreException.class,
                () -> service.addChore("Description", LocalDate.now()));
    }

    @Test
    @DisplayName("#addChore > When adding a single chore > Should not throw any exception")
    public void addSingleChoreWithoutExceptions() {
        ChoreServices service = new ChoreServices();
        assertAll(
                () -> assertDoesNotThrow(() -> service.addChore("Description", LocalDate.now())),
                () -> assertDoesNotThrow(() -> service.addChore("Another Description", LocalDate.now().plusDays(1)))
        );
    }

    @Test
    @DisplayName("#addChore > When adding multiple chores (without repetition) > Should not throw any exception")
    public void addMultipleChoresWithoutRepetition() {
        ChoreServices service = new ChoreServices();
        assertAll(
                () -> assertDoesNotThrow(() -> service.addChore("Description 1", LocalDate.now())),
                () -> assertDoesNotThrow(() -> service.addChore("Description 2", LocalDate.now().plusDays(1))),
                () -> assertDoesNotThrow(() -> service.addChore("Description 3", LocalDate.now().plusDays(2)))
        );
    }
}