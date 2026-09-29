package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Alan.Ryan
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Medals {
    private int rank;
    private String team;
    private int goldTotal;
    private int silverTotal;
    private int bronzeTotal;
    private int overallTotal;
    private int rankByTotal;

   
}
