package by.tc.task01.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Refrigerator extends Appliance{
    private Integer POWER_CONSUMPTION;
    private Integer WEIGHT;
    private Integer FREEZER_CAPACITY;
    private Integer OVERALL_CAPACITY;
    private Integer HEIGHT;
    private Integer WIDTH;
}
