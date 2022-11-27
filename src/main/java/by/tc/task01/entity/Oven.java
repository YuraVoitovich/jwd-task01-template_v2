package by.tc.task01.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlRootElement
public class Oven extends Appliance {
    private Integer POWER_CONSUMPTION;
    private Integer WEIGHT;
    private Integer CAPACITY;
    private Integer DEPTH;
    private Integer HEIGHT;
    private Integer WIDTH;
}
