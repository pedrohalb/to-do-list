package br.edu.unifalmg.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Chore {
    private boolean isCompleted;
    private String description;
    private LocalDate deadline;

    
}
