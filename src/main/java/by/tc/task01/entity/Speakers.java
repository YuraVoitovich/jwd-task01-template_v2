package by.tc.task01.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Speakers extends Appliance {
    private Integer POWER_CONSUMPTION;
    private Integer NUMBER_OF_SPEAKERS;
    private Integer FREQUENCY_RANGE;
    private Integer CORD_LENGTH;
}
