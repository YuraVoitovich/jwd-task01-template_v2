package by.tc.task01.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Laptop extends Appliance {
    private Integer BATTERY_CAPACITY;
    private String OS;
    private Integer MEMORY_ROM;
    private Integer SYSTEM_MEMORY;
    private String CPU;
    private Double DISPLAY_INCHS;
}
