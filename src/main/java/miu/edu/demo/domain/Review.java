package miu.edu.demo.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    private int id;
    private String comment;
    private int numberOfStates;
}
